package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collection;
import kotlin._Assertions;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;

/* compiled from: VisibilityUtil.kt */
public final class VisibilityUtilKt {
    public static final CallableMemberDescriptor findMemberWithMaxVisibility(Collection<? extends CallableMemberDescriptor> collection) {
        Integer compare;
        Intrinsics.checkParameterIsNotNull(collection, "descriptors");
        boolean z = !collection.isEmpty();
        if (!_Assertions.ENABLED || z) {
            CallableMemberDescriptor callableMemberDescriptor = null;
            for (CallableMemberDescriptor callableMemberDescriptor2 : collection) {
                if (callableMemberDescriptor == null || ((compare = Visibilities.compare(callableMemberDescriptor.getVisibility(), callableMemberDescriptor2.getVisibility())) != null && compare.intValue() < 0)) {
                    callableMemberDescriptor = callableMemberDescriptor2;
                }
            }
            if (callableMemberDescriptor == null) {
                Intrinsics.throwNpe();
            }
            return callableMemberDescriptor;
        }
        throw new AssertionError("Assertion failed");
    }
}
