package androidx.camera.core;

import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.os.OperationCanceledException;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

abstract class ImageAnalysisAbstractAnalyzer implements ImageReaderProxy.OnImageAvailableListener {
    private final Object mAnalyzerLock = new Object();
    private AtomicBoolean mIsClosed = new AtomicBoolean(false);
    private volatile int mRelativeRotation;
    private ImageAnalysis.Analyzer mSubscribedAnalyzer;
    private Executor mUserExecutor;

    ImageAnalysisAbstractAnalyzer() {
    }

    /* access modifiers changed from: package-private */
    public ListenableFuture<Void> analyzeImage(ImageProxy imageProxy) {
        Executor executor;
        ImageAnalysis.Analyzer analyzer;
        synchronized (this.mAnalyzerLock) {
            executor = this.mUserExecutor;
            analyzer = this.mSubscribedAnalyzer;
        }
        if (analyzer == null || executor == null) {
            return Futures.immediateFailedFuture(new OperationCanceledException("No analyzer or executor currently set."));
        }
        return CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver(executor, imageProxy, analyzer) {
            /* class androidx.camera.core.$$Lambda$ImageAnalysisAbstractAnalyzer$mR2LN44DwXC209Sm8KLIHvFCIo */
            private final /* synthetic */ Executor f$1;
            private final /* synthetic */ ImageProxy f$2;
            private final /* synthetic */ ImageAnalysis.Analyzer f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return ImageAnalysisAbstractAnalyzer.this.lambda$analyzeImage$1$ImageAnalysisAbstractAnalyzer(this.f$1, this.f$2, this.f$3, completer);
            }
        });
    }

    public /* synthetic */ Object lambda$analyzeImage$1$ImageAnalysisAbstractAnalyzer(Executor executor, ImageProxy imageProxy, ImageAnalysis.Analyzer analyzer, CallbackToFutureAdapter.Completer completer) throws Exception {
        executor.execute(new Runnable(imageProxy, analyzer, completer) {
            /* class androidx.camera.core.$$Lambda$ImageAnalysisAbstractAnalyzer$yUtT5xV4Z6dsue9ch8ol540lxjw */
            private final /* synthetic */ ImageProxy f$1;
            private final /* synthetic */ ImageAnalysis.Analyzer f$2;
            private final /* synthetic */ CallbackToFutureAdapter.Completer f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void run() {
                ImageAnalysisAbstractAnalyzer.this.lambda$null$0$ImageAnalysisAbstractAnalyzer(this.f$1, this.f$2, this.f$3);
            }
        });
        return "analyzeImage";
    }

    public /* synthetic */ void lambda$null$0$ImageAnalysisAbstractAnalyzer(ImageProxy imageProxy, ImageAnalysis.Analyzer analyzer, CallbackToFutureAdapter.Completer completer) {
        if (!isClosed()) {
            analyzer.analyze(new SettableImageProxy(imageProxy, ImmutableImageInfo.create(imageProxy.getImageInfo().getTag(), imageProxy.getImageInfo().getTimestamp(), this.mRelativeRotation)));
            completer.set(null);
            return;
        }
        completer.setException(new OperationCanceledException("Closed before analysis"));
    }

    /* access modifiers changed from: package-private */
    public void setRelativeRotation(int i) {
        this.mRelativeRotation = i;
    }

    /* access modifiers changed from: package-private */
    public void setAnalyzer(Executor executor, ImageAnalysis.Analyzer analyzer) {
        synchronized (this.mAnalyzerLock) {
            this.mSubscribedAnalyzer = analyzer;
            this.mUserExecutor = executor;
        }
    }

    /* access modifiers changed from: package-private */
    public void open() {
        this.mIsClosed.set(false);
    }

    /* access modifiers changed from: package-private */
    public void close() {
        this.mIsClosed.set(true);
    }

    /* access modifiers changed from: package-private */
    public boolean isClosed() {
        return this.mIsClosed.get();
    }
}
