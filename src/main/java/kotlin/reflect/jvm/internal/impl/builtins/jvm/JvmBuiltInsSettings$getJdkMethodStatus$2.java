package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsSettings;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.utils.DFS;

/* compiled from: JvmBuiltInsSettings.kt */
public final class JvmBuiltInsSettings$getJdkMethodStatus$2 extends DFS.AbstractNodeHandler<ClassDescriptor, JvmBuiltInsSettings.JDKMemberStatus> {
    final /* synthetic */ String $jvmDescriptor;
    final /* synthetic */ Ref.ObjectRef $result;

    JvmBuiltInsSettings$getJdkMethodStatus$2(String str, Ref.ObjectRef objectRef) {
        this.$jvmDescriptor = str;
        this.$result = objectRef;
    }

    public boolean beforeChildren(ClassDescriptor classDescriptor) {
        Intrinsics.checkParameterIsNotNull(classDescriptor, "javaClassDescriptor");
        String signature = SignatureBuildingComponents.INSTANCE.signature(classDescriptor, this.$jvmDescriptor);
        if (JvmBuiltInsSettings.Companion.getBLACK_LIST_METHOD_SIGNATURES().contains(signature)) {
            this.$result.element = JvmBuiltInsSettings.JDKMemberStatus.BLACK_LIST;
        } else if (JvmBuiltInsSettings.Companion.getWHITE_LIST_METHOD_SIGNATURES().contains(signature)) {
            this.$result.element = JvmBuiltInsSettings.JDKMemberStatus.WHITE_LIST;
        } else if (JvmBuiltInsSettings.Companion.getDROP_LIST_METHOD_SIGNATURES().contains(signature)) {
            this.$result.element = JvmBuiltInsSettings.JDKMemberStatus.DROP;
        }
        return ((JvmBuiltInsSettings.JDKMemberStatus) this.$result.element) == null;
    }

    public JvmBuiltInsSettings.JDKMemberStatus result() {
        JvmBuiltInsSettings.JDKMemberStatus jDKMemberStatus = (JvmBuiltInsSettings.JDKMemberStatus) this.$result.element;
        return jDKMemberStatus != null ? jDKMemberStatus : JvmBuiltInsSettings.JDKMemberStatus.NOT_CONSIDERED;
    }
}
