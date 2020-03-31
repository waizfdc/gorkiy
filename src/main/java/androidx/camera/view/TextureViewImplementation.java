package androidx.camera.view;

import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.util.Log;
import android.util.Pair;
import android.util.Size;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import androidx.camera.core.Preview;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.view.PreviewView;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.content.ContextCompat;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

public class TextureViewImplementation implements PreviewView.Implementation {
    private static final String TAG = "TextureViewImpl";
    private FrameLayout mParent;
    private Size mResolution;
    ListenableFuture<SurfaceRequest.Result> mSurfaceReleaseFuture;
    SurfaceRequest mSurfaceRequest;
    SurfaceTexture mSurfaceTexture;
    TextureView mTextureView;

    public void init(FrameLayout frameLayout) {
        this.mParent = frameLayout;
    }

    public Preview.SurfaceProvider getSurfaceProvider() {
        return new Preview.SurfaceProvider() {
            /* class androidx.camera.view.$$Lambda$TextureViewImplementation$XgqhEkmrW85l6BejpQN4wcoi9P0 */

            public final void onSurfaceRequested(SurfaceRequest surfaceRequest) {
                TextureViewImplementation.this.lambda$getSurfaceProvider$1$TextureViewImplementation(surfaceRequest);
            }
        };
    }

    public /* synthetic */ void lambda$getSurfaceProvider$1$TextureViewImplementation(SurfaceRequest surfaceRequest) {
        this.mResolution = surfaceRequest.getResolution();
        initInternal();
        SurfaceRequest surfaceRequest2 = this.mSurfaceRequest;
        if (surfaceRequest2 != null) {
            surfaceRequest2.willNotProvideSurface();
        }
        this.mSurfaceRequest = surfaceRequest;
        surfaceRequest.addRequestCancellationListener(ContextCompat.getMainExecutor(this.mTextureView.getContext()), new Runnable(surfaceRequest) {
            /* class androidx.camera.view.$$Lambda$TextureViewImplementation$PBYfztFT0mGvMWp_MntuQg5vGSE */
            private final /* synthetic */ SurfaceRequest f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                TextureViewImplementation.this.lambda$null$0$TextureViewImplementation(this.f$1);
            }
        });
        tryToProvidePreviewSurface();
    }

    public /* synthetic */ void lambda$null$0$TextureViewImplementation(SurfaceRequest surfaceRequest) {
        SurfaceRequest surfaceRequest2 = this.mSurfaceRequest;
        if (surfaceRequest2 != null && surfaceRequest2 == surfaceRequest) {
            this.mSurfaceRequest = null;
            this.mSurfaceReleaseFuture = null;
        }
    }

    public void onDisplayChanged() {
        TextureView textureView;
        Size size;
        FrameLayout frameLayout = this.mParent;
        if (frameLayout != null && (textureView = this.mTextureView) != null && (size = this.mResolution) != null) {
            correctPreviewForCenterCrop(frameLayout, textureView, size);
        }
    }

    private void initInternal() {
        TextureView textureView = new TextureView(this.mParent.getContext());
        this.mTextureView = textureView;
        textureView.setLayoutParams(new FrameLayout.LayoutParams(this.mResolution.getWidth(), this.mResolution.getHeight()));
        this.mTextureView.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() {
            /* class androidx.camera.view.TextureViewImplementation.AnonymousClass1 */

            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                TextureViewImplementation.this.mSurfaceTexture = surfaceTexture;
                TextureViewImplementation.this.tryToProvidePreviewSurface();
            }

            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
                Log.d(TextureViewImplementation.TAG, "onSurfaceTextureSizeChanged(width:" + i + ", height: " + i2 + " )");
            }

            public boolean onSurfaceTextureDestroyed(final SurfaceTexture surfaceTexture) {
                TextureViewImplementation.this.mSurfaceTexture = null;
                if (TextureViewImplementation.this.mSurfaceRequest != null || TextureViewImplementation.this.mSurfaceReleaseFuture == null) {
                    return true;
                }
                Futures.addCallback(TextureViewImplementation.this.mSurfaceReleaseFuture, new FutureCallback<SurfaceRequest.Result>() {
                    /* class androidx.camera.view.TextureViewImplementation.AnonymousClass1.AnonymousClass1 */

                    public void onSuccess(SurfaceRequest.Result result) {
                        Preconditions.checkState(result.getResultCode() != 3, "Unexpected result from SurfaceRequest. Surface was provided twice.");
                        surfaceTexture.release();
                    }

                    public void onFailure(Throwable th) {
                        throw new IllegalStateException("SurfaceReleaseFuture did not complete nicely.", th);
                    }
                }, ContextCompat.getMainExecutor(TextureViewImplementation.this.mTextureView.getContext()));
                return false;
            }
        });
        this.mParent.removeAllViews();
        this.mParent.addView(this.mTextureView);
    }

    /* access modifiers changed from: package-private */
    public void tryToProvidePreviewSurface() {
        SurfaceTexture surfaceTexture;
        Size size = this.mResolution;
        if (size != null && (surfaceTexture = this.mSurfaceTexture) != null && this.mSurfaceRequest != null) {
            surfaceTexture.setDefaultBufferSize(size.getWidth(), this.mResolution.getHeight());
            Surface surface = new Surface(this.mSurfaceTexture);
            ListenableFuture<SurfaceRequest.Result> future = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver(surface) {
                /* class androidx.camera.view.$$Lambda$TextureViewImplementation$gXACiFKHKklRXpWl9D1anoNeic */
                private final /* synthetic */ Surface f$1;

                {
                    this.f$1 = r2;
                }

                public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                    return TextureViewImplementation.this.lambda$tryToProvidePreviewSurface$2$TextureViewImplementation(this.f$1, completer);
                }
            });
            this.mSurfaceReleaseFuture = future;
            future.addListener(new Runnable(surface, future) {
                /* class androidx.camera.view.$$Lambda$TextureViewImplementation$DcccDK6Uc6TT8LKCNr9D4Ob6X30 */
                private final /* synthetic */ Surface f$1;
                private final /* synthetic */ ListenableFuture f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    TextureViewImplementation.this.lambda$tryToProvidePreviewSurface$3$TextureViewImplementation(this.f$1, this.f$2);
                }
            }, ContextCompat.getMainExecutor(this.mTextureView.getContext()));
            this.mSurfaceRequest = null;
            correctPreviewForCenterCrop(this.mParent, this.mTextureView, this.mResolution);
        }
    }

    public /* synthetic */ Object lambda$tryToProvidePreviewSurface$2$TextureViewImplementation(Surface surface, CallbackToFutureAdapter.Completer completer) throws Exception {
        SurfaceRequest surfaceRequest = this.mSurfaceRequest;
        Executor directExecutor = CameraXExecutors.directExecutor();
        completer.getClass();
        surfaceRequest.provideSurface(surface, directExecutor, new Consumer() {
            /* class androidx.camera.view.$$Lambda$K8R1nxorC_fhJS80SsYrGI5qJg */

            public final void accept(Object obj) {
                CallbackToFutureAdapter.Completer.this.set((SurfaceRequest.Result) obj);
            }
        });
        return "provideSurface[request=" + this.mSurfaceRequest + " surface=" + surface + "]";
    }

    public /* synthetic */ void lambda$tryToProvidePreviewSurface$3$TextureViewImplementation(Surface surface, ListenableFuture listenableFuture) {
        surface.release();
        if (this.mSurfaceReleaseFuture == listenableFuture) {
            this.mSurfaceReleaseFuture = null;
        }
    }

    private void correctPreviewForCenterCrop(View view, TextureView textureView, Size size) {
        Pair<Float, Float> fillScaleWithBufferAspectRatio = ScaleTypeTransform.getFillScaleWithBufferAspectRatio(view, textureView, size);
        textureView.setScaleX(((Float) fillScaleWithBufferAspectRatio.first).floatValue());
        textureView.setScaleY(((Float) fillScaleWithBufferAspectRatio.second).floatValue());
        Point originOfCenteredView = ScaleTypeTransform.getOriginOfCenteredView(view, textureView);
        textureView.setX((float) originOfCenteredView.x);
        textureView.setY((float) originOfCenteredView.y);
        textureView.setRotation((float) (-ScaleTypeTransform.getRotationDegrees(textureView)));
    }
}
