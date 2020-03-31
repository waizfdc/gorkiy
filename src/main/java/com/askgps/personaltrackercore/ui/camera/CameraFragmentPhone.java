package com.askgps.personaltrackercore.ui.camera;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Environment;
import android.util.Size;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Preview;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.PreviewView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import com.askgps.personaltrackercore.BaseMainActivity;
import com.askgps.personaltrackercore.R;
import com.askgps.personaltrackercore.config.CustomerCategory;
import com.askgps.personaltrackercore.utils.FaceDetector;
import com.google.common.util.concurrent.ListenableFuture;
import com.hadilq.liveevent.LiveEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0007\u0018\u0000 62\u00020\u0001:\u00016B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\bH\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\bH\u0002J\b\u0010\u0015\u001a\u00020\bH\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\nH\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u0012\u0010\u001d\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0012\u0010 \u001a\u00020!2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J&\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010(\u001a\u00020\bH\u0016J+\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020+2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-2\u0006\u0010/\u001a\u000200H\u0016¢\u0006\u0002\u00101J\b\u00102\u001a\u00020\bH\u0016J\b\u00103\u001a\u00020\bH\u0002J\b\u00104\u001a\u00020\bH\u0002J\b\u00105\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/askgps/personaltrackercore/ui/camera/CameraFragmentPhone;", "Landroidx/fragment/app/DialogFragment;", "()V", "avd", "Landroidx/vectordrawable/graphics/drawable/AnimatedVectorDrawableCompat;", "viewModel", "Lcom/askgps/personaltrackercore/ui/camera/CameraViewModel;", "FaceDetectorAnalyzerCalbback", "", "imageCapture", "Landroidx/camera/core/ImageCapture;", "image", "Landroidx/camera/core/ImageProxy;", "allPermissionsGranted", "", "createImageFile", "Ljava/io/File;", "disableAvd", "getFrameSize", "Landroid/util/Size;", "hideSystemUI", "initAvd", "initCameraSelector", "Landroidx/camera/core/CameraSelector;", "initCapture", "initImageAnalysis", "Landroidx/camera/core/ImageAnalysis;", "initPreview", "Landroidx/camera/core/Preview;", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onPause", "onRequestPermissionsResult", "requestCode", "", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "requestCameraPermission", "startCamera", "updateTransform", "Companion", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: CameraFragmentPhone.kt */
public final class CameraFragmentPhone extends DialogFragment {
    public static final Companion Companion = new Companion(null);
    public static final int REQUEST_CAMERA_PERMISSION = 10;
    /* access modifiers changed from: private */
    public static final String[] REQUIRED_PERMISSIONS = {"android.permission.CAMERA"};
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public AnimatedVectorDrawableCompat avd;
    /* access modifiers changed from: private */
    public CameraViewModel viewModel;

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public static final /* synthetic */ AnimatedVectorDrawableCompat access$getAvd$p(CameraFragmentPhone cameraFragmentPhone) {
        AnimatedVectorDrawableCompat animatedVectorDrawableCompat = cameraFragmentPhone.avd;
        if (animatedVectorDrawableCompat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avd");
        }
        return animatedVectorDrawableCompat;
    }

    public static final /* synthetic */ CameraViewModel access$getViewModel$p(CameraFragmentPhone cameraFragmentPhone) {
        CameraViewModel cameraViewModel = cameraFragmentPhone.viewModel;
        if (cameraViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return cameraViewModel;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0019\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/askgps/personaltrackercore/ui/camera/CameraFragmentPhone$Companion;", "", "()V", "REQUEST_CAMERA_PERMISSION", "", "REQUIRED_PERMISSIONS", "", "", "getREQUIRED_PERMISSIONS", "()[Ljava/lang/String;", "[Ljava/lang/String;", "newInstance", "Lcom/askgps/personaltrackercore/ui/camera/CameraFragmentPhone;", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: CameraFragmentPhone.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CameraFragmentPhone newInstance() {
            return new CameraFragmentPhone();
        }

        public final String[] getREQUIRED_PERMISSIONS() {
            return CameraFragmentPhone.REQUIRED_PERMISSIONS;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [int, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.camera_fragment, viewGroup, false);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Context context = getContext();
        if (context == null) {
            Intrinsics.throwNpe();
        }
        return new Dialog(context, R.style.FullScreenDialog);
    }

    public void onResume() {
        super.onResume();
        hideSystemUI();
        initAvd();
    }

    public void onPause() {
        super.onPause();
        disableAvd();
    }

    private final void initAvd() {
        Context context = getContext();
        if (context == null) {
            Intrinsics.throwNpe();
        }
        AnimatedVectorDrawableCompat create = AnimatedVectorDrawableCompat.create(context, R.drawable.face_detect);
        if (create == null) {
            Intrinsics.throwNpe();
        }
        this.avd = create;
        AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id.camera_face_detector_animation);
        AnimatedVectorDrawableCompat animatedVectorDrawableCompat = this.avd;
        if (animatedVectorDrawableCompat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avd");
        }
        appCompatImageView.setImageDrawable(animatedVectorDrawableCompat);
        AnimatedVectorDrawableCompat animatedVectorDrawableCompat2 = this.avd;
        if (animatedVectorDrawableCompat2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avd");
        }
        animatedVectorDrawableCompat2.registerAnimationCallback(new CameraFragmentPhone$initAvd$1(this));
        AnimatedVectorDrawableCompat animatedVectorDrawableCompat3 = this.avd;
        if (animatedVectorDrawableCompat3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avd");
        }
        animatedVectorDrawableCompat3.start();
    }

    private final void disableAvd() {
        AnimatedVectorDrawableCompat animatedVectorDrawableCompat = this.avd;
        if (animatedVectorDrawableCompat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avd");
        }
        animatedVectorDrawableCompat.clearAnimationCallbacks();
        AnimatedVectorDrawableCompat animatedVectorDrawableCompat2 = this.avd;
        if (animatedVectorDrawableCompat2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avd");
        }
        animatedVectorDrawableCompat2.stop();
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        ViewModel viewModel2 = ViewModelProviders.of(this).get(CameraViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel2, "ViewModelProviders.of(th…eraViewModel::class.java)");
        this.viewModel = (CameraViewModel) viewModel2;
        if (BaseMainActivity.Companion.getCustomer() == CustomerCategory.BUILDER_WATCH) {
            CameraViewModel cameraViewModel = this.viewModel;
            if (cameraViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            LiveEvent<String> idxId = cameraViewModel.getIdxId();
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            Intrinsics.checkExpressionValueIsNotNull(viewLifecycleOwner, "viewLifecycleOwner");
            idxId.observe(viewLifecycleOwner, new CameraFragmentPhone$onActivityCreated$1(this));
        }
        if (allPermissionsGranted()) {
            ((PreviewView) _$_findCachedViewById(R.id.camera_preview)).post(new CameraFragmentPhone$onActivityCreated$2(this));
        } else {
            requestCameraPermission();
        }
    }

    private final void requestCameraPermission() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            Intrinsics.throwNpe();
        }
        ActivityCompat.requestPermissions(activity, REQUIRED_PERMISSIONS, 10);
    }

    private final void hideSystemUI() {
        Window window;
        View decorView;
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null && (decorView = window.getDecorView()) != null) {
            decorView.setSystemUiVisibility(3846);
        }
    }

    /* access modifiers changed from: private */
    public final void startCamera() {
        Context context = getContext();
        if (context == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(context, "context!!");
        ListenableFuture<ProcessCameraProvider> instance = ProcessCameraProvider.getInstance(context.getApplicationContext());
        Intrinsics.checkExpressionValueIsNotNull(instance, "ProcessCameraProvider.ge…ext!!.applicationContext)");
        Runnable cameraFragmentPhone$startCamera$1 = new CameraFragmentPhone$startCamera$1(this, instance);
        Context context2 = getContext();
        if (context2 == null) {
            Intrinsics.throwNpe();
        }
        instance.addListener(cameraFragmentPhone$startCamera$1, ContextCompat.getMainExecutor(context2));
    }

    private final File createImageFile() throws IOException {
        String format = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        Intrinsics.checkExpressionValueIsNotNull(format, "SimpleDateFormat(\"yyyyMMdd_HHmmss\").format(Date())");
        Context context = getContext();
        if (context == null) {
            Intrinsics.throwNpe();
        }
        File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        Intrinsics.checkExpressionValueIsNotNull(externalFilesDir, "context!!.getExternalFil…nment.DIRECTORY_PICTURES)");
        File createTempFile = File.createTempFile("photo_" + format + '_', ".jpg", externalFilesDir);
        Intrinsics.checkExpressionValueIsNotNull(createTempFile, "File.createTempFile(\n   …/* directory */\n        )");
        return createTempFile;
    }

    /* access modifiers changed from: private */
    public final Preview initPreview() {
        Preview.Builder targetResolution = new Preview.Builder().setTargetName("Preview").setTargetResolution(getFrameSize());
        FragmentActivity activity = getActivity();
        if (activity == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity!!");
        WindowManager windowManager = activity.getWindowManager();
        Intrinsics.checkExpressionValueIsNotNull(windowManager, "activity!!.windowManager");
        Display defaultDisplay = windowManager.getDefaultDisplay();
        Intrinsics.checkExpressionValueIsNotNull(defaultDisplay, "activity!!.windowManager.defaultDisplay");
        Preview build = targetResolution.setTargetRotation(defaultDisplay.getRotation()).build();
        Intrinsics.checkExpressionValueIsNotNull(build, "Preview.Builder()\n      …ion)\n            .build()");
        PreviewView previewView = (PreviewView) _$_findCachedViewById(R.id.camera_preview);
        Intrinsics.checkExpressionValueIsNotNull(previewView, "camera_preview");
        build.setSurfaceProvider(previewView.getPreviewSurfaceProvider());
        return build;
    }

    /* access modifiers changed from: private */
    public final ImageAnalysis initImageAnalysis(ImageCapture imageCapture) {
        ImageAnalysis build = new ImageAnalysis.Builder().setTargetResolution(getFrameSize()).setBackpressureStrategy(0).build();
        Intrinsics.checkExpressionValueIsNotNull(build, "ImageAnalysis.Builder()\n…EST)\n            .build()");
        build.setAnalyzer(Executors.newSingleThreadExecutor(), new FaceDetector.FaceDetectorAnalyzer(new CameraFragmentPhone$initImageAnalysis$1(this, imageCapture)));
        return build;
    }

    /* access modifiers changed from: private */
    public final void FaceDetectorAnalyzerCalbback(ImageCapture imageCapture, ImageProxy imageProxy) {
        File createImageFile = createImageFile();
        imageCapture.lambda$takePicture$4$ImageCapture(new ImageCapture.OutputFileOptions.Builder(createImageFile).build(), Executors.newSingleThreadExecutor(), new CameraFragmentPhone$FaceDetectorAnalyzerCalbback$1(this, createImageFile, imageProxy));
    }

    private final Size getFrameSize() {
        PreviewView previewView = (PreviewView) _$_findCachedViewById(R.id.camera_preview);
        Intrinsics.checkExpressionValueIsNotNull(previewView, "camera_preview");
        int min = Math.min(previewView.getWidth(), 480);
        PreviewView previewView2 = (PreviewView) _$_findCachedViewById(R.id.camera_preview);
        Intrinsics.checkExpressionValueIsNotNull(previewView2, "camera_preview");
        return new Size(min, Math.min(previewView2.getHeight(), 360));
    }

    /* access modifiers changed from: private */
    public final ImageCapture initCapture() {
        ImageCapture build = new ImageCapture.Builder().setTargetResolution(getFrameSize()).setCaptureMode(1).build();
        Intrinsics.checkExpressionValueIsNotNull(build, "ImageCapture.Builder()\n …NCY)\n            .build()");
        ((AppCompatButton) _$_findCachedViewById(R.id.camera_btn_send)).setOnClickListener(new CameraFragmentPhone$initCapture$1(this, build));
        return build;
    }

    /* access modifiers changed from: private */
    public final CameraSelector initCameraSelector() {
        CameraSelector build = new CameraSelector.Builder().requireLensFacing(BaseMainActivity.Companion.getCustomer() == CustomerCategory.PATIENT_PHONE ? 0 : 1).build();
        Intrinsics.checkExpressionValueIsNotNull(build, "CameraSelector.Builder()…CK))\n            .build()");
        return build;
    }

    private final void updateTransform() {
        int i;
        Matrix matrix = new Matrix();
        PreviewView previewView = (PreviewView) _$_findCachedViewById(R.id.camera_preview);
        Intrinsics.checkExpressionValueIsNotNull(previewView, "camera_preview");
        float width = ((float) previewView.getWidth()) / 2.0f;
        PreviewView previewView2 = (PreviewView) _$_findCachedViewById(R.id.camera_preview);
        Intrinsics.checkExpressionValueIsNotNull(previewView2, "camera_preview");
        float height = ((float) previewView2.getHeight()) / 2.0f;
        PreviewView previewView3 = (PreviewView) _$_findCachedViewById(R.id.camera_preview);
        Intrinsics.checkExpressionValueIsNotNull(previewView3, "camera_preview");
        Display display = previewView3.getDisplay();
        Intrinsics.checkExpressionValueIsNotNull(display, "camera_preview.display");
        int rotation = display.getRotation();
        if (rotation == 0) {
            i = 0;
        } else if (rotation == 1) {
            i = 90;
        } else if (rotation == 2) {
            i = 180;
        } else if (rotation == 3) {
            i = 270;
        } else {
            return;
        }
        matrix.postRotate(-((float) i), width, height);
        PreviewView previewView4 = (PreviewView) _$_findCachedViewById(R.id.camera_preview);
        Intrinsics.checkExpressionValueIsNotNull(previewView4, "camera_preview");
        PreviewView previewView5 = (PreviewView) _$_findCachedViewById(R.id.camera_preview);
        Intrinsics.checkExpressionValueIsNotNull(previewView5, "camera_preview");
        float height2 = ((float) previewView4.getHeight()) / ((float) previewView5.getWidth());
        PreviewView previewView6 = (PreviewView) _$_findCachedViewById(R.id.camera_preview);
        Intrinsics.checkExpressionValueIsNotNull(previewView6, "camera_preview");
        PreviewView previewView7 = (PreviewView) _$_findCachedViewById(R.id.camera_preview);
        Intrinsics.checkExpressionValueIsNotNull(previewView7, "camera_preview");
        matrix.postScale(height2, ((float) previewView6.getWidth()) / ((float) previewView7.getWidth()), width, height);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Intrinsics.checkParameterIsNotNull(strArr, "permissions");
        Intrinsics.checkParameterIsNotNull(iArr, "grantResults");
        if (i != 10) {
            return;
        }
        if (allPermissionsGranted()) {
            ((PreviewView) _$_findCachedViewById(R.id.camera_preview)).post(new CameraFragmentPhone$onRequestPermissionsResult$1(this));
            return;
        }
        Toast.makeText(getContext(), "Permissions not granted by the user.", 0).show();
        dismiss();
    }

    private final boolean allPermissionsGranted() {
        String[] strArr = REQUIRED_PERMISSIONS;
        int length = strArr.length;
        int i = 0;
        while (true) {
            boolean z = true;
            if (i >= length) {
                return true;
            }
            String str = strArr[i];
            Context context = getContext();
            if (context == null) {
                Intrinsics.throwNpe();
            }
            if (ContextCompat.checkSelfPermission(context, str) != 0) {
                z = false;
            }
            if (!z) {
                return false;
            }
            i++;
        }
    }
}
