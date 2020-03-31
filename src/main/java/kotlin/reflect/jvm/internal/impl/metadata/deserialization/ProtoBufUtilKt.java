package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;

/* compiled from: ProtoBufUtil.kt */
public final class ProtoBufUtilKt {
    public static final <M extends GeneratedMessageLite.ExtendableMessage<M>, T> T getExtensionOrNull(GeneratedMessageLite.ExtendableMessage<M> extendableMessage, GeneratedMessageLite.GeneratedExtension<M, T> generatedExtension) {
        Intrinsics.checkParameterIsNotNull(extendableMessage, "$this$getExtensionOrNull");
        Intrinsics.checkParameterIsNotNull(generatedExtension, "extension");
        if (extendableMessage.hasExtension(generatedExtension)) {
            return extendableMessage.getExtension(generatedExtension);
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$GeneratedExtension<M, java.util.List<T>>, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$GeneratedExtension] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <M extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableMessage<M>, T> T getExtensionOrNull(kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableMessage<M> r1, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<M, java.util.List<T>> r2, int r3) {
        /*
            java.lang.String r0 = "$this$getExtensionOrNull"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r1, r0)
            java.lang.String r0 = "extension"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r2, r0)
            int r0 = r1.getExtensionCount(r2)
            if (r3 >= r0) goto L_0x0015
            java.lang.Object r1 = r1.getExtension(r2, r3)
            goto L_0x0016
        L_0x0015:
            r1 = 0
        L_0x0016:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt.getExtensionOrNull(kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$ExtendableMessage, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$GeneratedExtension, int):java.lang.Object");
    }
}
