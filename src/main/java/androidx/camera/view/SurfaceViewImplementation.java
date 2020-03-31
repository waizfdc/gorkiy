package androidx.camera.view;

import android.util.Log;
import android.util.Size;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.widget.FrameLayout;
import androidx.camera.core.Preview;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.view.PreviewView;
import androidx.camera.view.SurfaceViewImplementation;
import androidx.core.content.ContextCompat;

final class SurfaceViewImplementation implements PreviewView.Implementation {
    private static final String TAG = "SurfaceViewPreviewView";
    private Preview.SurfaceProvider mSurfaceProvider = new Preview.SurfaceProvider() {
        /* class androidx.camera.view.SurfaceViewImplementation.AnonymousClass1 */

        public void onSurfaceRequested(SurfaceRequest surfaceRequest) {
            SurfaceViewImplementation.this.mSurfaceView.post(new Runnable(surfaceRequest) {
                /* class androidx.camera.view.$$Lambda$SurfaceViewImplementation$1$cfCQQ8H8Jw_4K9II0AfvdFRGiok */
                private final /* synthetic */ SurfaceRequest f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    SurfaceViewImplementation.AnonymousClass1.this.lambda$onSurfaceRequested$0$SurfaceViewImplementation$1(this.f$1);
                }
            });
        }

        public /* synthetic */ void lambda$onSurfaceRequested$0$SurfaceViewImplementation$1(SurfaceRequest surfaceRequest) {
            SurfaceViewImplementation.this.mSurfaceRequestCallback.setSurfaceRequest(surfaceRequest);
        }
    };
    final SurfaceRequestCallback mSurfaceRequestCallback = new SurfaceRequestCallback();
    TransformableSurfaceView mSurfaceView;

    public void onDisplayChanged() {
    }

    SurfaceViewImplementation() {
    }

    public void init(FrameLayout frameLayout) {
        TransformableSurfaceView transformableSurfaceView = new TransformableSurfaceView(frameLayout.getContext());
        this.mSurfaceView = transformableSurfaceView;
        transformableSurfaceView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(this.mSurfaceView);
        this.mSurfaceView.getHolder().addCallback(this.mSurfaceRequestCallback);
    }

    public Preview.SurfaceProvider getSurfaceProvider() {
        return this.mSurfaceProvider;
    }

    class SurfaceRequestCallback implements SurfaceHolder.Callback {
        private Size mCurrentSurfaceSize;
        private SurfaceRequest mSurfaceRequest;
        private Size mTargetSize;

        SurfaceRequestCallback() {
        }

        /* access modifiers changed from: package-private */
        public void setSurfaceRequest(SurfaceRequest surfaceRequest) {
            cancelPreviousRequest();
            this.mSurfaceRequest = surfaceRequest;
            Size resolution = surfaceRequest.getResolution();
            this.mTargetSize = resolution;
            if (!tryToComplete()) {
                Log.d(SurfaceViewImplementation.TAG, "Wait for new Surface creation.");
                SurfaceViewImplementation.this.mSurfaceView.getHolder().setFixedSize(resolution.getWidth(), resolution.getHeight());
            }
        }

        private boolean tryToComplete() {
            Size size;
            Surface surface = SurfaceViewImplementation.this.mSurfaceView.getHolder().getSurface();
            if (this.mSurfaceRequest == null || (size = this.mTargetSize) == null || !size.equals(this.mCurrentSurfaceSize)) {
                return false;
            }
            Log.d(SurfaceViewImplementation.TAG, "Surface set on Preview.");
            this.mSurfaceRequest.provideSurface(surface, ContextCompat.getMainExecutor(SurfaceViewImplementation.this.mSurfaceView.getContext()), $$Lambda$SurfaceViewImplementation$SurfaceRequestCallback$ylR0NKdu9BLnNlHrGPzfpYLWdGI.INSTANCE);
            this.mSurfaceRequest = null;
            this.mTargetSize = null;
            return true;
        }

        private void cancelPreviousRequest() {
            if (this.mSurfaceRequest != null) {
                Log.d(SurfaceViewImplementation.TAG, "Request canceled: " + this.mSurfaceRequest);
                this.mSurfaceRequest.willNotProvideSurface();
                this.mSurfaceRequest = null;
            }
            this.mTargetSize = null;
        }

        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            Log.d(SurfaceViewImplementation.TAG, "Surface created.");
        }

        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            Log.d(SurfaceViewImplementation.TAG, "Surface changed. Size: " + i2 + "x" + i3);
            this.mCurrentSurfaceSize = new Size(i2, i3);
            tryToComplete();
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            Log.d(SurfaceViewImplementation.TAG, "Surface destroyed.");
            this.mCurrentSurfaceSize = null;
            cancelPreviousRequest();
        }
    }
}
