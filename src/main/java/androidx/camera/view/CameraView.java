package androidx.camera.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.hardware.display.DisplayManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.DisplayOrientedMeteringPointFactory;
import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.FocusMeteringResult;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.MeteringPoint;
import androidx.camera.core.VideoCapture;
import androidx.camera.core.impl.LensFacingConverter;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.lifecycle.LifecycleOwner;
import java.io.File;
import java.util.concurrent.Executor;

public final class CameraView extends FrameLayout {
    static final boolean DEBUG = false;
    private static final String EXTRA_CAMERA_DIRECTION = "camera_direction";
    private static final String EXTRA_CAPTURE_MODE = "captureMode";
    private static final String EXTRA_FLASH = "flash";
    private static final String EXTRA_MAX_VIDEO_DURATION = "max_video_duration";
    private static final String EXTRA_MAX_VIDEO_SIZE = "max_video_size";
    private static final String EXTRA_PINCH_TO_ZOOM_ENABLED = "pinch_to_zoom_enabled";
    private static final String EXTRA_SCALE_TYPE = "scale_type";
    private static final String EXTRA_SUPER = "super";
    private static final String EXTRA_ZOOM_RATIO = "zoom_ratio";
    private static final int FLASH_MODE_AUTO = 1;
    private static final int FLASH_MODE_OFF = 4;
    private static final int FLASH_MODE_ON = 2;
    static final int INDEFINITE_VIDEO_DURATION = -1;
    static final int INDEFINITE_VIDEO_SIZE = -1;
    private static final int LENS_FACING_BACK = 2;
    private static final int LENS_FACING_FRONT = 1;
    private static final int LENS_FACING_NONE = 0;
    static final String TAG = CameraView.class.getSimpleName();
    CameraXModule mCameraModule;
    private final DisplayManager.DisplayListener mDisplayListener;
    private long mDownEventTimestamp;
    private boolean mIsPinchToZoomEnabled;
    private PinchToZoomGestureDetector mPinchToZoomGestureDetector;
    private PreviewView mPreviewView;
    private ScaleType mScaleType;
    private MotionEvent mUpEvent;

    public CameraView(Context context) {
        this(context, null);
    }

    public CameraView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CameraView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIsPinchToZoomEnabled = true;
        this.mDisplayListener = new DisplayManager.DisplayListener() {
            /* class androidx.camera.view.CameraView.AnonymousClass1 */

            public void onDisplayAdded(int i) {
            }

            public void onDisplayRemoved(int i) {
            }

            public void onDisplayChanged(int i) {
                CameraView.this.mCameraModule.invalidateView();
            }
        };
        this.mScaleType = ScaleType.CENTER_CROP;
        init(context, attributeSet);
    }

    public CameraView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mIsPinchToZoomEnabled = true;
        this.mDisplayListener = new DisplayManager.DisplayListener() {
            /* class androidx.camera.view.CameraView.AnonymousClass1 */

            public void onDisplayAdded(int i) {
            }

            public void onDisplayRemoved(int i) {
            }

            public void onDisplayChanged(int i) {
                CameraView.this.mCameraModule.invalidateView();
            }
        };
        this.mScaleType = ScaleType.CENTER_CROP;
        init(context, attributeSet);
    }

    public void bindToLifecycle(LifecycleOwner lifecycleOwner) {
        this.mCameraModule.bindToLifecycle(lifecycleOwner);
    }

    private void init(Context context, AttributeSet attributeSet) {
        PreviewView previewView = new PreviewView(getContext());
        this.mPreviewView = previewView;
        addView(previewView, 0);
        this.mCameraModule = new CameraXModule(this);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CameraView);
            setScaleType(ScaleType.fromId(obtainStyledAttributes.getInteger(R.styleable.CameraView_scaleType, getScaleType().getId())));
            setPinchToZoomEnabled(obtainStyledAttributes.getBoolean(R.styleable.CameraView_pinchToZoomEnabled, isPinchToZoomEnabled()));
            setCaptureMode(CaptureMode.fromId(obtainStyledAttributes.getInteger(R.styleable.CameraView_captureMode, getCaptureMode().getId())));
            int i = obtainStyledAttributes.getInt(R.styleable.CameraView_lensFacing, 2);
            if (i == 0) {
                setCameraLensFacing(null);
            } else if (i == 1) {
                setCameraLensFacing(0);
            } else if (i == 2) {
                setCameraLensFacing(1);
            }
            int i2 = obtainStyledAttributes.getInt(R.styleable.CameraView_flash, 0);
            if (i2 == 1) {
                setFlash(0);
            } else if (i2 == 2) {
                setFlash(1);
            } else if (i2 == 4) {
                setFlash(2);
            }
            obtainStyledAttributes.recycle();
        }
        if (getBackground() == null) {
            setBackgroundColor(-15658735);
        }
        this.mPinchToZoomGestureDetector = new PinchToZoomGestureDetector(this, context);
    }

    /* access modifiers changed from: protected */
    public FrameLayout.LayoutParams generateDefaultLayoutParams() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(EXTRA_SUPER, super.onSaveInstanceState());
        bundle.putInt(EXTRA_SCALE_TYPE, getScaleType().getId());
        bundle.putFloat(EXTRA_ZOOM_RATIO, getZoomRatio());
        bundle.putBoolean(EXTRA_PINCH_TO_ZOOM_ENABLED, isPinchToZoomEnabled());
        bundle.putString(EXTRA_FLASH, FlashModeConverter.nameOf(getFlash()));
        bundle.putLong(EXTRA_MAX_VIDEO_DURATION, getMaxVideoDuration());
        bundle.putLong(EXTRA_MAX_VIDEO_SIZE, getMaxVideoSize());
        if (getCameraLensFacing() != null) {
            bundle.putString(EXTRA_CAMERA_DIRECTION, LensFacingConverter.nameOf(getCameraLensFacing().intValue()));
        }
        bundle.putInt(EXTRA_CAPTURE_MODE, getCaptureMode().getId());
        return bundle;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        Integer num;
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            super.onRestoreInstanceState(bundle.getParcelable(EXTRA_SUPER));
            setScaleType(ScaleType.fromId(bundle.getInt(EXTRA_SCALE_TYPE)));
            setZoomRatio(bundle.getFloat(EXTRA_ZOOM_RATIO));
            setPinchToZoomEnabled(bundle.getBoolean(EXTRA_PINCH_TO_ZOOM_ENABLED));
            setFlash(FlashModeConverter.valueOf(bundle.getString(EXTRA_FLASH)));
            setMaxVideoDuration(bundle.getLong(EXTRA_MAX_VIDEO_DURATION));
            setMaxVideoSize(bundle.getLong(EXTRA_MAX_VIDEO_SIZE));
            String string = bundle.getString(EXTRA_CAMERA_DIRECTION);
            if (TextUtils.isEmpty(string)) {
                num = null;
            } else {
                num = Integer.valueOf(LensFacingConverter.valueOf(string));
            }
            setCameraLensFacing(num);
            setCaptureMode(CaptureMode.fromId(bundle.getInt(EXTRA_CAPTURE_MODE)));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ((DisplayManager) getContext().getSystemService("display")).registerDisplayListener(this.mDisplayListener, new Handler(Looper.getMainLooper()));
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ((DisplayManager) getContext().getSystemService("display")).unregisterDisplayListener(this.mDisplayListener);
    }

    /* access modifiers changed from: package-private */
    public PreviewView getPreviewView() {
        return this.mPreviewView;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (getMeasuredWidth() > 0 && getMeasuredHeight() > 0) {
            this.mCameraModule.bindToLifecycleAfterViewMeasured();
        }
        super.onMeasure(i, i2);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.mCameraModule.bindToLifecycleAfterViewMeasured();
        this.mCameraModule.invalidateView();
        super.onLayout(z, i, i2, i3, i4);
    }

    /* access modifiers changed from: package-private */
    public int getDisplaySurfaceRotation() {
        Display display = getDisplay();
        if (display == null) {
            return 0;
        }
        return display.getRotation();
    }

    public ScaleType getScaleType() {
        return this.mScaleType;
    }

    public void setScaleType(ScaleType scaleType) {
        if (scaleType != this.mScaleType) {
            this.mScaleType = scaleType;
            requestLayout();
        }
    }

    public CaptureMode getCaptureMode() {
        return this.mCameraModule.getCaptureMode();
    }

    public void setCaptureMode(CaptureMode captureMode) {
        this.mCameraModule.setCaptureMode(captureMode);
    }

    public long getMaxVideoDuration() {
        return this.mCameraModule.getMaxVideoDuration();
    }

    private void setMaxVideoDuration(long j) {
        this.mCameraModule.setMaxVideoDuration(j);
    }

    private long getMaxVideoSize() {
        return this.mCameraModule.getMaxVideoSize();
    }

    private void setMaxVideoSize(long j) {
        this.mCameraModule.setMaxVideoSize(j);
    }

    public void takePicture(Executor executor, ImageCapture.OnImageCapturedCallback onImageCapturedCallback) {
        this.mCameraModule.takePicture(executor, onImageCapturedCallback);
    }

    public void takePicture(File file, Executor executor, ImageCapture.OnImageSavedCallback onImageSavedCallback) {
        this.mCameraModule.takePicture(file, executor, onImageSavedCallback);
    }

    public void startRecording(File file, Executor executor, VideoCapture.OnVideoSavedCallback onVideoSavedCallback) {
        this.mCameraModule.startRecording(file, executor, onVideoSavedCallback);
    }

    public void stopRecording() {
        this.mCameraModule.stopRecording();
    }

    public boolean isRecording() {
        return this.mCameraModule.isRecording();
    }

    public boolean hasCameraWithLensFacing(int i) {
        return this.mCameraModule.hasCameraWithLensFacing(i);
    }

    public void toggleCamera() {
        this.mCameraModule.toggleCamera();
    }

    public void setCameraLensFacing(Integer num) {
        this.mCameraModule.setCameraLensFacing(num);
    }

    public Integer getCameraLensFacing() {
        return this.mCameraModule.getLensFacing();
    }

    public int getFlash() {
        return this.mCameraModule.getFlash();
    }

    public void setFlash(int i) {
        this.mCameraModule.setFlash(i);
    }

    private long delta() {
        return System.currentTimeMillis() - this.mDownEventTimestamp;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mCameraModule.isPaused()) {
            return false;
        }
        if (isPinchToZoomEnabled()) {
            this.mPinchToZoomGestureDetector.onTouchEvent(motionEvent);
        }
        if (motionEvent.getPointerCount() == 2 && isPinchToZoomEnabled() && isZoomSupported()) {
            return true;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mDownEventTimestamp = System.currentTimeMillis();
        } else if (action != 1) {
            return false;
        } else {
            if (delta() < ((long) ViewConfiguration.getLongPressTimeout())) {
                this.mUpEvent = motionEvent;
                performClick();
            }
        }
        return true;
    }

    public boolean performClick() {
        super.performClick();
        MotionEvent motionEvent = this.mUpEvent;
        float x = motionEvent != null ? motionEvent.getX() : getX() + (((float) getWidth()) / 2.0f);
        MotionEvent motionEvent2 = this.mUpEvent;
        float y = motionEvent2 != null ? motionEvent2.getY() : getY() + (((float) getHeight()) / 2.0f);
        this.mUpEvent = null;
        DisplayOrientedMeteringPointFactory displayOrientedMeteringPointFactory = new DisplayOrientedMeteringPointFactory(getDisplay(), new CameraSelector.Builder().requireLensFacing(this.mCameraModule.getLensFacing().intValue()).build(), (float) this.mPreviewView.getWidth(), (float) this.mPreviewView.getHeight());
        MeteringPoint createPoint = displayOrientedMeteringPointFactory.createPoint(x, y, 0.16666667f);
        MeteringPoint createPoint2 = displayOrientedMeteringPointFactory.createPoint(x, y, 0.25f);
        Camera camera = this.mCameraModule.getCamera();
        if (camera != null) {
            Futures.addCallback(camera.getCameraControl().startFocusAndMetering(new FocusMeteringAction.Builder(createPoint, 1).addPoint(createPoint2, 2).build()), new FutureCallback<FocusMeteringResult>() {
                /* class androidx.camera.view.CameraView.AnonymousClass2 */

                public void onSuccess(FocusMeteringResult focusMeteringResult) {
                }

                public void onFailure(Throwable th) {
                    throw new RuntimeException(th);
                }
            }, CameraXExecutors.directExecutor());
        } else {
            Log.d(TAG, "cannot access camera");
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public float rangeLimit(float f, float f2, float f3) {
        return Math.min(Math.max(f, f3), f2);
    }

    public boolean isPinchToZoomEnabled() {
        return this.mIsPinchToZoomEnabled;
    }

    public void setPinchToZoomEnabled(boolean z) {
        this.mIsPinchToZoomEnabled = z;
    }

    public float getZoomRatio() {
        return this.mCameraModule.getZoomRatio();
    }

    public void setZoomRatio(float f) {
        this.mCameraModule.setZoomRatio(f);
    }

    public float getMinZoomRatio() {
        return this.mCameraModule.getMinZoomRatio();
    }

    public float getMaxZoomRatio() {
        return this.mCameraModule.getMaxZoomRatio();
    }

    public boolean isZoomSupported() {
        return this.mCameraModule.isZoomSupported();
    }

    public void enableTorch(boolean z) {
        this.mCameraModule.enableTorch(z);
    }

    public boolean isTorchOn() {
        return this.mCameraModule.isTorchOn();
    }

    public enum ScaleType {
        CENTER_CROP(0),
        CENTER_INSIDE(1);
        
        private final int mId;

        /* access modifiers changed from: package-private */
        public int getId() {
            return this.mId;
        }

        private ScaleType(int i) {
            this.mId = i;
        }

        static ScaleType fromId(int i) {
            for (ScaleType scaleType : values()) {
                if (scaleType.mId == i) {
                    return scaleType;
                }
            }
            throw new IllegalArgumentException();
        }
    }

    public enum CaptureMode {
        IMAGE(0),
        VIDEO(1),
        MIXED(2);
        
        private final int mId;

        /* access modifiers changed from: package-private */
        public int getId() {
            return this.mId;
        }

        private CaptureMode(int i) {
            this.mId = i;
        }

        static CaptureMode fromId(int i) {
            for (CaptureMode captureMode : values()) {
                if (captureMode.mId == i) {
                    return captureMode;
                }
            }
            throw new IllegalArgumentException();
        }
    }

    static class S extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private ScaleGestureDetector.OnScaleGestureListener mListener;

        S() {
        }

        /* access modifiers changed from: package-private */
        public void setRealGestureDetector(ScaleGestureDetector.OnScaleGestureListener onScaleGestureListener) {
            this.mListener = onScaleGestureListener;
        }

        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            return this.mListener.onScale(scaleGestureDetector);
        }
    }

    private class PinchToZoomGestureDetector extends ScaleGestureDetector implements ScaleGestureDetector.OnScaleGestureListener {
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            return true;
        }

        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        }

        PinchToZoomGestureDetector(CameraView cameraView, Context context) {
            this(context, new S());
        }

        PinchToZoomGestureDetector(Context context, S s) {
            super(context, s);
            s.setRealGestureDetector(this);
        }

        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            float scaleFactor = super.getScaleFactor();
            float zoomRatio = CameraView.this.getZoomRatio() * (scaleFactor > 1.0f ? ((scaleFactor - 1.0f) * 2.0f) + 1.0f : 1.0f - ((1.0f - scaleFactor) * 2.0f));
            CameraView cameraView = CameraView.this;
            CameraView.this.setZoomRatio(cameraView.rangeLimit(zoomRatio, cameraView.getMaxZoomRatio(), CameraView.this.getMinZoomRatio()));
            return true;
        }
    }
}
