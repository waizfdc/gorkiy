package kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil;

import kotlin.collections.CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.utils.DFS;

/* compiled from: DescriptorUtils.kt */
final class DescriptorUtilsKt$firstOverridden$1<N> implements DFS.Neighbors<N> {
    final /* synthetic */ boolean $useOriginal;

    DescriptorUtilsKt$firstOverridden$1(boolean z) {
        this.$useOriginal = z;
    }

    public final Iterable<CallableMemberDescriptor> getNeighbors(CallableMemberDescriptor callableMemberDescriptor) {
        Iterable<CallableMemberDescriptor> iterable;
        if (this.$useOriginal) {
            callableMemberDescriptor = callableMemberDescriptor != null ? callableMemberDescriptor.getOriginal() : null;
        }
        if (callableMemberDescriptor == null || (iterable = callableMemberDescriptor.getOverriddenDescriptors()) == null) {
            iterable = CollectionsKt.emptyList();
        }
        return iterable;
    }
}
