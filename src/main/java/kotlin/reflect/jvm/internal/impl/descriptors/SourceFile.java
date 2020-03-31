package kotlin.reflect.jvm.internal.impl.descriptors;

public interface SourceFile {
    public static final SourceFile NO_SOURCE_FILE = new SourceFile() {
        /* class kotlin.reflect.jvm.internal.impl.descriptors.SourceFile.AnonymousClass1 */

        public String getName() {
            return null;
        }
    };

    String getName();
}
