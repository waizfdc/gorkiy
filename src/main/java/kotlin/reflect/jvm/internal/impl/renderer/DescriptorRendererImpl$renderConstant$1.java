package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;

/* compiled from: DescriptorRendererImpl.kt */
final class DescriptorRendererImpl$renderConstant$1 extends Lambda implements Function1<ConstantValue<?>, String> {
    final /* synthetic */ DescriptorRendererImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DescriptorRendererImpl$renderConstant$1(DescriptorRendererImpl descriptorRendererImpl) {
        super(1);
        this.this$0 = descriptorRendererImpl;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke((ConstantValue<?>) ((ConstantValue) obj));
    }

    public final String invoke(ConstantValue<?> constantValue) {
        Intrinsics.checkParameterIsNotNull(constantValue, "it");
        return this.this$0.renderConstant(constantValue);
    }
}
