package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* compiled from: JvmBuiltIns.kt */
final class JvmBuiltIns$settings$2 extends Lambda implements Function0<JvmBuiltInsSettings> {
    final /* synthetic */ StorageManager $storageManager;
    final /* synthetic */ JvmBuiltIns this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    JvmBuiltIns$settings$2(JvmBuiltIns jvmBuiltIns, StorageManager storageManager) {
        super(0);
        this.this$0 = jvmBuiltIns;
        this.$storageManager = storageManager;
    }

    public final JvmBuiltInsSettings invoke() {
        ModuleDescriptorImpl builtInsModule = this.this$0.getBuiltInsModule();
        Intrinsics.checkExpressionValueIsNotNull(builtInsModule, "builtInsModule");
        return new JvmBuiltInsSettings(builtInsModule, this.$storageManager, new Function0<ModuleDescriptor>(this) {
            /* class kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns$settings$2.AnonymousClass1 */
            final /* synthetic */ JvmBuiltIns$settings$2 this$0;

            {
                this.this$0 = r1;
            }

            public final ModuleDescriptor invoke() {
                ModuleDescriptor access$getOwnerModuleDescriptor$p = this.this$0.this$0.ownerModuleDescriptor;
                if (access$getOwnerModuleDescriptor$p != null) {
                    return access$getOwnerModuleDescriptor$p;
                }
                throw new AssertionError("JvmBuiltins has not been initialized properly");
            }
        }, new Function0<Boolean>(this) {
            /* class kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns$settings$2.AnonymousClass2 */
            final /* synthetic */ JvmBuiltIns$settings$2 this$0;

            {
                this.this$0 = r1;
            }

            public final boolean invoke() {
                if (this.this$0.this$0.ownerModuleDescriptor != null) {
                    return this.this$0.this$0.isAdditionalBuiltInsFeatureSupported;
                }
                throw new AssertionError("JvmBuiltins has not been initialized properly");
            }
        });
    }
}
