package androidx.camera.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.camera.core.Preview;

public class PreviewView extends FrameLayout {
    private final DisplayManager.DisplayListener mDisplayListener;
    Implementation mImplementation;
    private ImplementationMode mImplementationMode;

    interface Implementation {
        Preview.SurfaceProvider getSurfaceProvider();

        void init(FrameLayout frameLayout);

        void onDisplayChanged();
    }

    public enum ScaleType {
        FILL_START,
        FILL_CENTER,
        FILL_END,
        FIT_START,
        FIT_CENTER,
        FIT_END
    }

    public PreviewView(Context context) {
        this(context, null);
    }

    public PreviewView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PreviewView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    /* JADX INFO: finally extract failed */
    public PreviewView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mDisplayListener = new DisplayManager.DisplayListener() {
            /* class androidx.camera.view.PreviewView.AnonymousClass1 */

            public void onDisplayAdded(int i) {
            }

            public void onDisplayRemoved(int i) {
            }

            public void onDisplayChanged(int i) {
                PreviewView.this.mImplementation.onDisplayChanged();
            }
        };
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.PreviewView, i, i2);
        if (Build.VERSION.SDK_INT >= 29) {
            saveAttributeDataForStyleable(context, R.styleable.PreviewView, attributeSet, obtainStyledAttributes, i, i2);
        }
        try {
            this.mImplementationMode = ImplementationMode.fromId(obtainStyledAttributes.getInteger(R.styleable.PreviewView_implementationMode, ImplementationMode.TEXTURE_VIEW.getId()));
            obtainStyledAttributes.recycle();
            setUp();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        DisplayManager displayManager = (DisplayManager) getContext().getSystemService("display");
        if (displayManager != null) {
            displayManager.registerDisplayListener(this.mDisplayListener, getHandler());
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        DisplayManager displayManager = (DisplayManager) getContext().getSystemService("display");
        if (displayManager != null) {
            displayManager.unregisterDisplayListener(this.mDisplayListener);
        }
    }

    /* renamed from: androidx.camera.view.PreviewView$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$androidx$camera$view$PreviewView$ImplementationMode;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                androidx.camera.view.PreviewView$ImplementationMode[] r0 = androidx.camera.view.PreviewView.ImplementationMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.camera.view.PreviewView.AnonymousClass2.$SwitchMap$androidx$camera$view$PreviewView$ImplementationMode = r0
                androidx.camera.view.PreviewView$ImplementationMode r1 = androidx.camera.view.PreviewView.ImplementationMode.SURFACE_VIEW     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = androidx.camera.view.PreviewView.AnonymousClass2.$SwitchMap$androidx$camera$view$PreviewView$ImplementationMode     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.camera.view.PreviewView$ImplementationMode r1 = androidx.camera.view.PreviewView.ImplementationMode.TEXTURE_VIEW     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.view.PreviewView.AnonymousClass2.<clinit>():void");
        }
    }

    private void setUp() {
        removeAllViews();
        int i = AnonymousClass2.$SwitchMap$androidx$camera$view$PreviewView$ImplementationMode[this.mImplementationMode.ordinal()];
        if (i == 1) {
            this.mImplementation = new SurfaceViewImplementation();
        } else if (i == 2) {
            this.mImplementation = new TextureViewImplementation();
        } else {
            throw new IllegalStateException("Unsupported implementation mode " + this.mImplementationMode);
        }
        this.mImplementation.init(super);
    }

    public void setImplementationMode(ImplementationMode implementationMode) {
        this.mImplementationMode = implementationMode;
        setUp();
    }

    public ImplementationMode getImplementationMode() {
        return this.mImplementationMode;
    }

    public Preview.SurfaceProvider getPreviewSurfaceProvider() {
        return this.mImplementation.getSurfaceProvider();
    }

    public enum ImplementationMode {
        SURFACE_VIEW(0),
        TEXTURE_VIEW(1);
        
        private final int mId;

        private ImplementationMode(int i) {
            this.mId = i;
        }

        public int getId() {
            return this.mId;
        }

        static ImplementationMode fromId(int i) {
            for (ImplementationMode implementationMode : values()) {
                if (implementationMode.mId == i) {
                    return implementationMode;
                }
            }
            throw new IllegalArgumentException("Unsupported implementation mode " + i);
        }
    }
}
