package androidx.camera.extensions;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.CameraX;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.Preview;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.extensions.ExtensionsErrorListener;
import androidx.camera.extensions.impl.InitializerImpl;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;

public final class ExtensionsManager {
    private static final Handler DEFAULT_HANDLER = new Handler(Looper.getMainLooper());
    private static final Object ERROR_LOCK = new Object();
    private static final String TAG = "ExtensionsManager";
    private static volatile ExtensionsErrorListener sExtensionsErrorListener = null;

    public enum EffectMode {
        NORMAL,
        BOKEH,
        HDR,
        NIGHT,
        BEAUTY,
        AUTO
    }

    public enum ExtensionsAvailability {
        LIBRARY_AVAILABLE,
        LIBRARY_UNAVAILABLE_ERROR_LOADING,
        LIBRARY_UNAVAILABLE_MISSING_IMPLEMENTATION,
        NONE
    }

    public static ListenableFuture<ExtensionsAvailability> init() {
        if (ExtensionVersion.getRuntimeVersion() == null) {
            return Futures.immediateFuture(ExtensionsAvailability.NONE);
        }
        if (ExtensionVersion.getRuntimeVersion().compareTo(Version.VERSION_1_1) < 0) {
            return Futures.immediateFuture(ExtensionsAvailability.LIBRARY_AVAILABLE);
        }
        return CallbackToFutureAdapter.getFuture($$Lambda$ExtensionsManager$E6KSBVGYYaKzIhB6gmgQw0PfD6o.INSTANCE);
    }

    static /* synthetic */ Object lambda$init$0(final CallbackToFutureAdapter.Completer completer) throws Exception {
        try {
            InitializerImpl.init(VersionName.getCurrentVersion().toVersionString(), CameraX.getContext(), new InitializerImpl.OnExtensionsInitializedCallback() {
                /* class androidx.camera.extensions.ExtensionsManager.AnonymousClass1 */

                public void onSuccess() {
                    Log.d(ExtensionsManager.TAG, "Successfully initialized extensions");
                    completer.set(ExtensionsAvailability.LIBRARY_AVAILABLE);
                }

                public void onFailure(int i) {
                    Log.d(ExtensionsManager.TAG, "Failed to initialize extensions");
                    completer.set(ExtensionsAvailability.LIBRARY_UNAVAILABLE_ERROR_LOADING);
                }
            }, CameraXExecutors.mainThreadExecutor());
            return "Initialize extensions";
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
            completer.set(ExtensionsAvailability.LIBRARY_UNAVAILABLE_MISSING_IMPLEMENTATION);
            return "Initialize extensions";
        }
    }

    public static boolean isExtensionAvailable(EffectMode effectMode, int i) {
        boolean checkImageCaptureExtensionCapability = checkImageCaptureExtensionCapability(effectMode, i);
        boolean checkPreviewExtensionCapability = checkPreviewExtensionCapability(effectMode, i);
        if (checkImageCaptureExtensionCapability != checkPreviewExtensionCapability) {
            Log.e(TAG, "ImageCapture and Preview are not available simultaneously for " + effectMode.name());
        }
        return checkImageCaptureExtensionCapability && checkPreviewExtensionCapability;
    }

    public static boolean isExtensionAvailable(Class<?> cls, EffectMode effectMode, int i) {
        if (cls == ImageCapture.class) {
            return checkImageCaptureExtensionCapability(effectMode, i);
        }
        if (cls.equals(Preview.class)) {
            return checkPreviewExtensionCapability(effectMode, i);
        }
        return false;
    }

    private static boolean checkImageCaptureExtensionCapability(EffectMode effectMode, int i) {
        ImageCaptureExtender imageCaptureExtender;
        ImageCapture.Builder builder = new ImageCapture.Builder();
        CameraSelector build = new CameraSelector.Builder().requireLensFacing(i).build();
        switch (AnonymousClass3.$SwitchMap$androidx$camera$extensions$ExtensionsManager$EffectMode[effectMode.ordinal()]) {
            case 1:
                imageCaptureExtender = BokehImageCaptureExtender.create(builder);
                break;
            case 2:
                imageCaptureExtender = HdrImageCaptureExtender.create(builder);
                break;
            case 3:
                imageCaptureExtender = NightImageCaptureExtender.create(builder);
                break;
            case 4:
                imageCaptureExtender = BeautyImageCaptureExtender.create(builder);
                break;
            case 5:
                imageCaptureExtender = AutoImageCaptureExtender.create(builder);
                break;
            case 6:
                return true;
            default:
                return false;
        }
        return imageCaptureExtender.isExtensionAvailable(build);
    }

    /* renamed from: androidx.camera.extensions.ExtensionsManager$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$androidx$camera$extensions$ExtensionsManager$EffectMode;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.camera.extensions.ExtensionsManager$EffectMode[] r0 = androidx.camera.extensions.ExtensionsManager.EffectMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.camera.extensions.ExtensionsManager.AnonymousClass3.$SwitchMap$androidx$camera$extensions$ExtensionsManager$EffectMode = r0
                androidx.camera.extensions.ExtensionsManager$EffectMode r1 = androidx.camera.extensions.ExtensionsManager.EffectMode.BOKEH     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = androidx.camera.extensions.ExtensionsManager.AnonymousClass3.$SwitchMap$androidx$camera$extensions$ExtensionsManager$EffectMode     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.camera.extensions.ExtensionsManager$EffectMode r1 = androidx.camera.extensions.ExtensionsManager.EffectMode.HDR     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = androidx.camera.extensions.ExtensionsManager.AnonymousClass3.$SwitchMap$androidx$camera$extensions$ExtensionsManager$EffectMode     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.camera.extensions.ExtensionsManager$EffectMode r1 = androidx.camera.extensions.ExtensionsManager.EffectMode.NIGHT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = androidx.camera.extensions.ExtensionsManager.AnonymousClass3.$SwitchMap$androidx$camera$extensions$ExtensionsManager$EffectMode     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.camera.extensions.ExtensionsManager$EffectMode r1 = androidx.camera.extensions.ExtensionsManager.EffectMode.BEAUTY     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = androidx.camera.extensions.ExtensionsManager.AnonymousClass3.$SwitchMap$androidx$camera$extensions$ExtensionsManager$EffectMode     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.camera.extensions.ExtensionsManager$EffectMode r1 = androidx.camera.extensions.ExtensionsManager.EffectMode.AUTO     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = androidx.camera.extensions.ExtensionsManager.AnonymousClass3.$SwitchMap$androidx$camera$extensions$ExtensionsManager$EffectMode     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.camera.extensions.ExtensionsManager$EffectMode r1 = androidx.camera.extensions.ExtensionsManager.EffectMode.NORMAL     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.extensions.ExtensionsManager.AnonymousClass3.<clinit>():void");
        }
    }

    public static void setExtensionsErrorListener(ExtensionsErrorListener extensionsErrorListener) {
        synchronized (ERROR_LOCK) {
            sExtensionsErrorListener = extensionsErrorListener;
        }
    }

    static void postExtensionsError(final ExtensionsErrorListener.ExtensionsErrorCode extensionsErrorCode) {
        synchronized (ERROR_LOCK) {
            final ExtensionsErrorListener extensionsErrorListener = sExtensionsErrorListener;
            if (extensionsErrorListener != null) {
                DEFAULT_HANDLER.post(new Runnable() {
                    /* class androidx.camera.extensions.ExtensionsManager.AnonymousClass2 */

                    public void run() {
                        extensionsErrorListener.onError(extensionsErrorCode);
                    }
                });
            }
        }
    }

    private static boolean checkPreviewExtensionCapability(EffectMode effectMode, int i) {
        PreviewExtender previewExtender;
        Preview.Builder builder = new Preview.Builder();
        CameraSelector build = new CameraSelector.Builder().requireLensFacing(i).build();
        switch (AnonymousClass3.$SwitchMap$androidx$camera$extensions$ExtensionsManager$EffectMode[effectMode.ordinal()]) {
            case 1:
                previewExtender = BokehPreviewExtender.create(builder);
                break;
            case 2:
                previewExtender = HdrPreviewExtender.create(builder);
                break;
            case 3:
                previewExtender = NightPreviewExtender.create(builder);
                break;
            case 4:
                previewExtender = BeautyPreviewExtender.create(builder);
                break;
            case 5:
                previewExtender = AutoPreviewExtender.create(builder);
                break;
            case 6:
                return true;
            default:
                return false;
        }
        return previewExtender.isExtensionAvailable(build);
    }

    private ExtensionsManager() {
    }
}
