package androidx.camera.camera2.internal;

import android.graphics.PointF;
import android.graphics.Rect;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import android.os.Build;
import android.util.Rational;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.Camera2CameraControl;
import androidx.camera.core.CameraControl;
import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.FocusMeteringResult;
import androidx.camera.core.MeteringPoint;
import androidx.camera.core.impl.CaptureConfig;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class FocusMeteringControl {
    private static final String TAG = "FocusMeteringControl";
    private MeteringRectangle[] mAeRects = new MeteringRectangle[0];
    private MeteringRectangle[] mAfRects = new MeteringRectangle[0];
    private ScheduledFuture<?> mAutoCancelHandle;
    private MeteringRectangle[] mAwbRects = new MeteringRectangle[0];
    private final Camera2CameraControl mCameraControl;
    Integer mCurrentAfState = 0;
    private FocusMeteringAction mCurrentFocusMeteringAction;
    MeteringRectangle[] mDefaultAeRects = new MeteringRectangle[0];
    MeteringRectangle[] mDefaultAfRects = new MeteringRectangle[0];
    MeteringRectangle[] mDefaultAwbRects = new MeteringRectangle[0];
    final Executor mExecutor;
    long mFocusTimeoutCounter = 0;
    private volatile boolean mIsActive = false;
    boolean mIsAutoFocusCompleted = false;
    boolean mIsFocusSuccessful = false;
    private boolean mIsInAfAutoMode = false;
    CallbackToFutureAdapter.Completer<FocusMeteringResult> mRunningActionCompleter = null;
    CallbackToFutureAdapter.Completer<Void> mRunningCancelCompleter = null;
    private final ScheduledExecutorService mScheduler;
    private Camera2CameraControl.CaptureResultListener mSessionListenerForCancel = null;
    private Camera2CameraControl.CaptureResultListener mSessionListenerForFocus = null;

    private int getDefaultTemplate() {
        return 1;
    }

    FocusMeteringControl(Camera2CameraControl camera2CameraControl, ScheduledExecutorService scheduledExecutorService, Executor executor) {
        this.mCameraControl = camera2CameraControl;
        this.mExecutor = executor;
        this.mScheduler = scheduledExecutorService;
    }

    /* access modifiers changed from: package-private */
    public void setDefaultRequestBuilder(CaptureRequest.Builder builder) {
        this.mDefaultAfRects = (MeteringRectangle[]) builder.get(CaptureRequest.CONTROL_AF_REGIONS);
        this.mDefaultAeRects = (MeteringRectangle[]) builder.get(CaptureRequest.CONTROL_AE_REGIONS);
        this.mDefaultAwbRects = (MeteringRectangle[]) builder.get(CaptureRequest.CONTROL_AWB_REGIONS);
    }

    /* access modifiers changed from: package-private */
    public void setActive(boolean z) {
        if (z != this.mIsActive) {
            this.mIsActive = z;
            if (!this.mIsActive) {
                this.mExecutor.execute(new Runnable() {
                    /* class androidx.camera.camera2.internal.$$Lambda$FocusMeteringControl$Fo24HuX4QgnBob7n82jQvBqN3XU */

                    public final void run() {
                        FocusMeteringControl.this.lambda$setActive$0$FocusMeteringControl();
                    }
                });
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void addFocusMeteringOptions(Camera2ImplConfig.Builder builder) {
        builder.setCaptureRequestOption(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(this.mCameraControl.getSupportedAfMode(this.mIsInAfAutoMode ? 1 : 4)));
        if (this.mAfRects.length != 0) {
            builder.setCaptureRequestOption(CaptureRequest.CONTROL_AF_REGIONS, this.mAfRects);
        }
        if (this.mAeRects.length != 0) {
            builder.setCaptureRequestOption(CaptureRequest.CONTROL_AE_REGIONS, this.mAeRects);
        }
        if (this.mAwbRects.length != 0) {
            builder.setCaptureRequestOption(CaptureRequest.CONTROL_AWB_REGIONS, this.mAwbRects);
        }
    }

    private PointF getFovAdjustedPoint(MeteringPoint meteringPoint, Rational rational, Rational rational2) {
        if (meteringPoint.getSurfaceAspectRatio() != null) {
            rational2 = meteringPoint.getSurfaceAspectRatio();
        }
        PointF pointF = new PointF(meteringPoint.getX(), meteringPoint.getY());
        if (!rational2.equals(rational)) {
            if (rational2.compareTo(rational) > 0) {
                float doubleValue = (float) (rational2.doubleValue() / rational.doubleValue());
                pointF.y = (((float) ((((double) doubleValue) - 1.0d) / 2.0d)) + pointF.y) * (1.0f / doubleValue);
            } else {
                float doubleValue2 = (float) (rational.doubleValue() / rational2.doubleValue());
                pointF.x = (((float) ((((double) doubleValue2) - 1.0d) / 2.0d)) + pointF.x) * (1.0f / doubleValue2);
            }
        }
        return pointF;
    }

    private MeteringRectangle getMeteringRect(MeteringPoint meteringPoint, PointF pointF, Rect rect) {
        int width = (int) (((float) rect.left) + (pointF.x * ((float) rect.width())));
        int height = (int) (((float) rect.top) + (pointF.y * ((float) rect.height())));
        int size = ((int) (meteringPoint.getSize() * ((float) rect.width()))) / 2;
        int size2 = ((int) (meteringPoint.getSize() * ((float) rect.height()))) / 2;
        Rect rect2 = new Rect(width - size, height - size2, width + size, height + size2);
        rect2.left = rangeLimit(rect2.left, rect.right, rect.left);
        rect2.right = rangeLimit(rect2.right, rect.right, rect.left);
        rect2.top = rangeLimit(rect2.top, rect.bottom, rect.top);
        rect2.bottom = rangeLimit(rect2.bottom, rect.bottom, rect.top);
        return new MeteringRectangle(rect2, 1000);
    }

    private int rangeLimit(int i, int i2, int i3) {
        return Math.min(Math.max(i, i3), i2);
    }

    /* access modifiers changed from: package-private */
    public ListenableFuture<FocusMeteringResult> startFocusAndMetering(FocusMeteringAction focusMeteringAction, Rational rational) {
        return CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver(focusMeteringAction, rational) {
            /* class androidx.camera.camera2.internal.$$Lambda$FocusMeteringControl$Gz_st8wNW3AE79rbLhzPR3lH1sM */
            private final /* synthetic */ FocusMeteringAction f$1;
            private final /* synthetic */ Rational f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return FocusMeteringControl.this.lambda$startFocusAndMetering$2$FocusMeteringControl(this.f$1, this.f$2, completer);
            }
        });
    }

    public /* synthetic */ Object lambda$startFocusAndMetering$2$FocusMeteringControl(FocusMeteringAction focusMeteringAction, Rational rational, CallbackToFutureAdapter.Completer completer) throws Exception {
        this.mExecutor.execute(new Runnable(completer, focusMeteringAction, rational) {
            /* class androidx.camera.camera2.internal.$$Lambda$FocusMeteringControl$RMIiUu3u7oefEgGTKdbx7jBb96I */
            private final /* synthetic */ CallbackToFutureAdapter.Completer f$1;
            private final /* synthetic */ FocusMeteringAction f$2;
            private final /* synthetic */ Rational f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void run() {
                FocusMeteringControl.this.lambda$null$1$FocusMeteringControl(this.f$1, this.f$2, this.f$3);
            }
        });
        return "startFocusAndMetering";
    }

    /* access modifiers changed from: package-private */
    /* renamed from: startFocusAndMeteringInternal */
    public void lambda$null$1$FocusMeteringControl(CallbackToFutureAdapter.Completer<FocusMeteringResult> completer, FocusMeteringAction focusMeteringAction, Rational rational) {
        if (!this.mIsActive) {
            completer.setException(new CameraControl.OperationCanceledException("Camera is not active."));
        } else if (!focusMeteringAction.getMeteringPointsAf().isEmpty() || !focusMeteringAction.getMeteringPointsAe().isEmpty() || !focusMeteringAction.getMeteringPointsAwb().isEmpty()) {
            int min = Math.min(focusMeteringAction.getMeteringPointsAf().size(), this.mCameraControl.getMaxAfRegionCount());
            int min2 = Math.min(focusMeteringAction.getMeteringPointsAe().size(), this.mCameraControl.getMaxAeRegionCount());
            int min3 = Math.min(focusMeteringAction.getMeteringPointsAwb().size(), this.mCameraControl.getMaxAwbRegionCount());
            if (min + min2 + min3 <= 0) {
                completer.setException(new IllegalArgumentException("None of the specified AF/AE/AWB MeteringPoints is supported on this camera."));
                return;
            }
            ArrayList<MeteringPoint> arrayList = new ArrayList<>();
            ArrayList<MeteringPoint> arrayList2 = new ArrayList<>();
            ArrayList<MeteringPoint> arrayList3 = new ArrayList<>();
            if (min > 0) {
                arrayList.addAll(focusMeteringAction.getMeteringPointsAf().subList(0, min));
            }
            if (min2 > 0) {
                arrayList2.addAll(focusMeteringAction.getMeteringPointsAe().subList(0, min2));
            }
            if (min3 > 0) {
                arrayList3.addAll(focusMeteringAction.getMeteringPointsAwb().subList(0, min3));
            }
            failActionFuture("Cancelled by another startFocusAndMetering()");
            failCancelFuture("Cancelled by another startFocusAndMetering()");
            if (this.mCurrentFocusMeteringAction != null) {
                lambda$setActive$0$FocusMeteringControl();
            }
            disableAutoCancel();
            this.mCurrentFocusMeteringAction = focusMeteringAction;
            this.mRunningActionCompleter = completer;
            Rect cropSensorRegion = this.mCameraControl.getCropSensorRegion();
            Rational rational2 = new Rational(cropSensorRegion.width(), cropSensorRegion.height());
            if (rational == null) {
                rational = rational2;
            }
            ArrayList arrayList4 = new ArrayList();
            ArrayList arrayList5 = new ArrayList();
            ArrayList arrayList6 = new ArrayList();
            for (MeteringPoint meteringPoint : arrayList) {
                arrayList4.add(getMeteringRect(meteringPoint, getFovAdjustedPoint(meteringPoint, rational2, rational), cropSensorRegion));
            }
            for (MeteringPoint meteringPoint2 : arrayList2) {
                arrayList5.add(getMeteringRect(meteringPoint2, getFovAdjustedPoint(meteringPoint2, rational2, rational), cropSensorRegion));
            }
            for (MeteringPoint meteringPoint3 : arrayList3) {
                arrayList6.add(getMeteringRect(meteringPoint3, getFovAdjustedPoint(meteringPoint3, rational2, rational), cropSensorRegion));
            }
            executeMeteringAction((MeteringRectangle[]) arrayList4.toArray(new MeteringRectangle[0]), (MeteringRectangle[]) arrayList5.toArray(new MeteringRectangle[0]), (MeteringRectangle[]) arrayList6.toArray(new MeteringRectangle[0]), focusMeteringAction);
        } else {
            completer.setException(new IllegalArgumentException("No AF/AE/AWB MeteringPoints are added."));
        }
    }

    /* access modifiers changed from: package-private */
    public void triggerAf() {
        if (this.mIsActive) {
            CaptureConfig.Builder builder = new CaptureConfig.Builder();
            builder.setTemplateType(getDefaultTemplate());
            builder.setUseRepeatingSurface(true);
            Camera2ImplConfig.Builder builder2 = new Camera2ImplConfig.Builder();
            builder2.setCaptureRequestOption(CaptureRequest.CONTROL_AF_TRIGGER, 1);
            builder.addImplementationOptions(builder2.build());
            this.mCameraControl.lambda$submitCaptureRequests$2$Camera2CameraControl(Collections.singletonList(builder.build()));
        }
    }

    /* access modifiers changed from: package-private */
    public void triggerAePrecapture() {
        if (this.mIsActive) {
            CaptureConfig.Builder builder = new CaptureConfig.Builder();
            builder.setTemplateType(getDefaultTemplate());
            builder.setUseRepeatingSurface(true);
            Camera2ImplConfig.Builder builder2 = new Camera2ImplConfig.Builder();
            builder2.setCaptureRequestOption(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 1);
            builder.addImplementationOptions(builder2.build());
            this.mCameraControl.lambda$submitCaptureRequests$2$Camera2CameraControl(Collections.singletonList(builder.build()));
        }
    }

    /* access modifiers changed from: package-private */
    public void cancelAfAeTrigger(boolean z, boolean z2) {
        if (this.mIsActive) {
            CaptureConfig.Builder builder = new CaptureConfig.Builder();
            builder.setUseRepeatingSurface(true);
            builder.setTemplateType(getDefaultTemplate());
            Camera2ImplConfig.Builder builder2 = new Camera2ImplConfig.Builder();
            if (z) {
                builder2.setCaptureRequestOption(CaptureRequest.CONTROL_AF_TRIGGER, 2);
            }
            if (Build.VERSION.SDK_INT >= 23 && z2) {
                builder2.setCaptureRequestOption(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 2);
            }
            builder.addImplementationOptions(builder2.build());
            this.mCameraControl.lambda$submitCaptureRequests$2$Camera2CameraControl(Collections.singletonList(builder.build()));
        }
    }

    private void disableAutoCancel() {
        ScheduledFuture<?> scheduledFuture = this.mAutoCancelHandle;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            this.mAutoCancelHandle = null;
        }
    }

    private static int getRegionCount(MeteringRectangle[] meteringRectangleArr) {
        if (meteringRectangleArr == null) {
            return 0;
        }
        return meteringRectangleArr.length;
    }

    private static boolean hasEqualRegions(MeteringRectangle[] meteringRectangleArr, MeteringRectangle[] meteringRectangleArr2) {
        if (getRegionCount(meteringRectangleArr) == 0 && getRegionCount(meteringRectangleArr2) == 0) {
            return true;
        }
        if (getRegionCount(meteringRectangleArr) != getRegionCount(meteringRectangleArr2)) {
            return false;
        }
        if (!(meteringRectangleArr == null || meteringRectangleArr2 == null)) {
            for (int i = 0; i < meteringRectangleArr.length; i++) {
                if (!meteringRectangleArr[i].equals(meteringRectangleArr2[i])) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isAfModeSupported() {
        return this.mCameraControl.getSupportedAfMode(1) == 1;
    }

    private void completeActionFuture(boolean z) {
        CallbackToFutureAdapter.Completer<FocusMeteringResult> completer = this.mRunningActionCompleter;
        if (completer != null) {
            completer.set(FocusMeteringResult.create(z));
            this.mRunningActionCompleter = null;
        }
    }

    private void failActionFuture(String str) {
        this.mCameraControl.removeCaptureResultListener(this.mSessionListenerForFocus);
        CallbackToFutureAdapter.Completer<FocusMeteringResult> completer = this.mRunningActionCompleter;
        if (completer != null) {
            completer.setException(new CameraControl.OperationCanceledException(str));
            this.mRunningActionCompleter = null;
        }
    }

    private void failCancelFuture(String str) {
        this.mCameraControl.removeCaptureResultListener(this.mSessionListenerForCancel);
        CallbackToFutureAdapter.Completer<Void> completer = this.mRunningCancelCompleter;
        if (completer != null) {
            completer.setException(new CameraControl.OperationCanceledException(str));
            this.mRunningCancelCompleter = null;
        }
    }

    private void completeCancelFuture() {
        CallbackToFutureAdapter.Completer<Void> completer = this.mRunningCancelCompleter;
        if (completer != null) {
            completer.set(null);
            this.mRunningCancelCompleter = null;
        }
    }

    private void executeMeteringAction(MeteringRectangle[] meteringRectangleArr, MeteringRectangle[] meteringRectangleArr2, MeteringRectangle[] meteringRectangleArr3, FocusMeteringAction focusMeteringAction) {
        this.mCameraControl.removeCaptureResultListener(this.mSessionListenerForFocus);
        disableAutoCancel();
        this.mAfRects = meteringRectangleArr;
        this.mAeRects = meteringRectangleArr2;
        this.mAwbRects = meteringRectangleArr3;
        if (shouldTriggerAF()) {
            this.mIsInAfAutoMode = true;
            this.mIsAutoFocusCompleted = false;
            this.mIsFocusSuccessful = false;
            this.mCameraControl.updateSessionConfig();
            triggerAf();
        } else {
            this.mIsInAfAutoMode = false;
            this.mIsAutoFocusCompleted = true;
            this.mIsFocusSuccessful = false;
            this.mCameraControl.updateSessionConfig();
        }
        this.mCurrentAfState = 0;
        $$Lambda$FocusMeteringControl$myFOvxwuOccCZDqwHBp6yswlIg r1 = new Camera2CameraControl.CaptureResultListener(isAfModeSupported(), meteringRectangleArr, meteringRectangleArr2, meteringRectangleArr3) {
            /* class androidx.camera.camera2.internal.$$Lambda$FocusMeteringControl$myFOvxwuOccCZDqwHBp6yswlIg */
            private final /* synthetic */ boolean f$1;
            private final /* synthetic */ MeteringRectangle[] f$2;
            private final /* synthetic */ MeteringRectangle[] f$3;
            private final /* synthetic */ MeteringRectangle[] f$4;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
                this.f$4 = r5;
            }

            public final boolean onCaptureResult(TotalCaptureResult totalCaptureResult) {
                return FocusMeteringControl.this.lambda$executeMeteringAction$3$FocusMeteringControl(this.f$1, this.f$2, this.f$3, this.f$4, totalCaptureResult);
            }
        };
        this.mSessionListenerForFocus = r1;
        this.mCameraControl.addCaptureResultListener(r1);
        if (focusMeteringAction.isAutoCancelEnabled()) {
            long j = this.mFocusTimeoutCounter + 1;
            this.mFocusTimeoutCounter = j;
            this.mAutoCancelHandle = this.mScheduler.schedule(new Runnable(j) {
                /* class androidx.camera.camera2.internal.$$Lambda$FocusMeteringControl$d6WwVXBeWXIsWhvPS3v3isXXpE */
                private final /* synthetic */ long f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    FocusMeteringControl.this.lambda$executeMeteringAction$5$FocusMeteringControl(this.f$1);
                }
            }, focusMeteringAction.getAutoCancelDurationInMillis(), TimeUnit.MILLISECONDS);
        }
    }

    public /* synthetic */ boolean lambda$executeMeteringAction$3$FocusMeteringControl(boolean z, MeteringRectangle[] meteringRectangleArr, MeteringRectangle[] meteringRectangleArr2, MeteringRectangle[] meteringRectangleArr3, TotalCaptureResult totalCaptureResult) {
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
        if (shouldTriggerAF()) {
            if (this.mCurrentAfState.intValue() == 3) {
                if (num.intValue() == 4) {
                    this.mIsFocusSuccessful = true;
                    this.mIsAutoFocusCompleted = true;
                } else if (num.intValue() == 5) {
                    this.mIsFocusSuccessful = false;
                    this.mIsAutoFocusCompleted = true;
                }
            } else if (!z) {
                this.mIsFocusSuccessful = true;
                this.mIsAutoFocusCompleted = true;
            }
        }
        if (this.mIsAutoFocusCompleted && totalCaptureResult.getRequest() != null) {
            if (meteringRectangleArr.length == 0) {
                meteringRectangleArr = this.mDefaultAfRects;
            }
            if (meteringRectangleArr2.length == 0) {
                meteringRectangleArr2 = this.mDefaultAeRects;
            }
            if (meteringRectangleArr3.length == 0) {
                meteringRectangleArr3 = this.mDefaultAwbRects;
            }
            CaptureRequest request = totalCaptureResult.getRequest();
            if (hasEqualRegions((MeteringRectangle[]) request.get(CaptureRequest.CONTROL_AF_REGIONS), meteringRectangleArr) && hasEqualRegions((MeteringRectangle[]) request.get(CaptureRequest.CONTROL_AE_REGIONS), meteringRectangleArr2) && hasEqualRegions((MeteringRectangle[]) request.get(CaptureRequest.CONTROL_AWB_REGIONS), meteringRectangleArr3)) {
                completeActionFuture(this.mIsFocusSuccessful);
                return true;
            }
        }
        if (!this.mCurrentAfState.equals(num)) {
            this.mCurrentAfState = num;
        }
        return false;
    }

    public /* synthetic */ void lambda$executeMeteringAction$5$FocusMeteringControl(long j) {
        this.mExecutor.execute(new Runnable(j) {
            /* class androidx.camera.camera2.internal.$$Lambda$FocusMeteringControl$_twzPKhKVhYXrMWzDj4zT4PYeo */
            private final /* synthetic */ long f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                FocusMeteringControl.this.lambda$null$4$FocusMeteringControl(this.f$1);
            }
        });
    }

    public /* synthetic */ void lambda$null$4$FocusMeteringControl(long j) {
        if (j == this.mFocusTimeoutCounter) {
            lambda$setActive$0$FocusMeteringControl();
        }
    }

    private boolean shouldTriggerAF() {
        return this.mAfRects.length > 0;
    }

    /* access modifiers changed from: package-private */
    public ListenableFuture<Void> cancelFocusAndMetering() {
        return CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() {
            /* class androidx.camera.camera2.internal.$$Lambda$FocusMeteringControl$FJquylGHqkA7eofMN5jopP8hJg */

            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return FocusMeteringControl.this.lambda$cancelFocusAndMetering$7$FocusMeteringControl(completer);
            }
        });
    }

    public /* synthetic */ Object lambda$cancelFocusAndMetering$7$FocusMeteringControl(CallbackToFutureAdapter.Completer completer) throws Exception {
        this.mExecutor.execute(new Runnable(completer) {
            /* class androidx.camera.camera2.internal.$$Lambda$FocusMeteringControl$gbSNUUaxV2iGcoucE8t1rJ5bf8 */
            private final /* synthetic */ CallbackToFutureAdapter.Completer f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                FocusMeteringControl.this.lambda$null$6$FocusMeteringControl(this.f$1);
            }
        });
        return "cancelFocusAndMetering";
    }

    /* access modifiers changed from: package-private */
    /* renamed from: cancelFocusAndMeteringWithoutAsyncResult */
    public void lambda$setActive$0$FocusMeteringControl() {
        lambda$null$6$FocusMeteringControl(null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: cancelFocusAndMeteringInternal */
    public void lambda$null$6$FocusMeteringControl(CallbackToFutureAdapter.Completer<Void> completer) {
        failCancelFuture("Cancelled by another cancelFocusAndMetering()");
        failActionFuture("Cancelled by cancelFocusAndMetering()");
        this.mRunningCancelCompleter = completer;
        disableAutoCancel();
        if (this.mRunningCancelCompleter != null) {
            $$Lambda$FocusMeteringControl$vgaNwg87Tv3HiROj1CRAp20PAQ r0 = new Camera2CameraControl.CaptureResultListener(this.mCameraControl.getSupportedAfMode(4)) {
                /* class androidx.camera.camera2.internal.$$Lambda$FocusMeteringControl$vgaNwg87Tv3HiROj1CRAp20PAQ */
                private final /* synthetic */ int f$1;

                {
                    this.f$1 = r2;
                }

                public final boolean onCaptureResult(TotalCaptureResult totalCaptureResult) {
                    return FocusMeteringControl.this.lambda$cancelFocusAndMeteringInternal$8$FocusMeteringControl(this.f$1, totalCaptureResult);
                }
            };
            this.mSessionListenerForCancel = r0;
            this.mCameraControl.addCaptureResultListener(r0);
        }
        if (shouldTriggerAF()) {
            cancelAfAeTrigger(true, false);
        }
        this.mAfRects = new MeteringRectangle[0];
        this.mAeRects = new MeteringRectangle[0];
        this.mAwbRects = new MeteringRectangle[0];
        this.mIsInAfAutoMode = false;
        this.mCameraControl.updateSessionConfig();
        this.mCurrentFocusMeteringAction = null;
    }

    public /* synthetic */ boolean lambda$cancelFocusAndMeteringInternal$8$FocusMeteringControl(int i, TotalCaptureResult totalCaptureResult) {
        CaptureRequest request = totalCaptureResult.getRequest();
        MeteringRectangle[] meteringRectangleArr = (MeteringRectangle[]) request.get(CaptureRequest.CONTROL_AF_REGIONS);
        MeteringRectangle[] meteringRectangleArr2 = (MeteringRectangle[]) request.get(CaptureRequest.CONTROL_AE_REGIONS);
        MeteringRectangle[] meteringRectangleArr3 = (MeteringRectangle[]) request.get(CaptureRequest.CONTROL_AWB_REGIONS);
        if (((Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_MODE)).intValue() != i || !hasEqualRegions(meteringRectangleArr, this.mDefaultAfRects) || !hasEqualRegions(meteringRectangleArr2, this.mDefaultAeRects) || !hasEqualRegions(meteringRectangleArr3, this.mDefaultAwbRects)) {
            return false;
        }
        completeCancelFuture();
        return true;
    }
}
