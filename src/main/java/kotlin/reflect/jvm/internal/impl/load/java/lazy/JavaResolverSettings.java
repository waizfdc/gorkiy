package kotlin.reflect.jvm.internal.impl.load.java.lazy;

/* compiled from: context.kt */
public interface JavaResolverSettings {
    public static final Companion Companion = Companion.$$INSTANCE;

    boolean isReleaseCoroutines();

    /* compiled from: context.kt */
    public static final class Default implements JavaResolverSettings {
        public static final Default INSTANCE = new Default();

        public boolean isReleaseCoroutines() {
            return false;
        }

        private Default() {
        }
    }

    /* compiled from: context.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }
}
