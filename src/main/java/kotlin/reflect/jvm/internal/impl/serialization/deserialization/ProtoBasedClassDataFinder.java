package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.Collection;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.name.ClassId;

/* compiled from: ProtoBasedClassDataFinder.kt */
public final class ProtoBasedClassDataFinder implements ClassDataFinder {
    private final Map<ClassId, ProtoBuf.Class> classIdToProto;
    private final Function1<ClassId, SourceElement> classSource;
    private final BinaryVersion metadataVersion;
    private final NameResolver nameResolver;

    /* JADX WARN: Type inference failed for: r6v0, types: [kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.ClassId, ? extends kotlin.reflect.jvm.internal.impl.descriptors.SourceElement>, kotlin.jvm.functions.Function1<kotlin.reflect.jvm.internal.impl.name.ClassId, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement>, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ProtoBasedClassDataFinder(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.PackageFragment r3, kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver r4, kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion r5, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.ClassId, ? extends kotlin.reflect.jvm.internal.impl.descriptors.SourceElement> r6) {
        /*
            r2 = this;
            java.lang.String r0 = "proto"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r0)
            java.lang.String r0 = "nameResolver"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r4, r0)
            java.lang.String r0 = "metadataVersion"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r5, r0)
            java.lang.String r0 = "classSource"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r6, r0)
            r2.<init>()
            r2.nameResolver = r4
            r2.metadataVersion = r5
            r2.classSource = r6
            java.util.List r3 = r3.getClass_List()
            java.lang.String r4 = "proto.class_List"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r4)
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            r4 = 10
            int r4 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r3, r4)
            int r4 = kotlin.collections.MapsKt.mapCapacity(r4)
            r5 = 16
            int r4 = kotlin.ranges.RangesKt.coerceAtLeast(r4, r5)
            java.util.LinkedHashMap r5 = new java.util.LinkedHashMap
            r5.<init>(r4)
            java.util.Map r5 = (java.util.Map) r5
            java.util.Iterator r3 = r3.iterator()
        L_0x0043:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0063
            java.lang.Object r4 = r3.next()
            r6 = r4
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r6 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class) r6
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver r0 = r2.nameResolver
            java.lang.String r1 = "klass"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r1)
            int r6 = r6.getFqName()
            kotlin.reflect.jvm.internal.impl.name.ClassId r6 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt.getClassId(r0, r6)
            r5.put(r6, r4)
            goto L_0x0043
        L_0x0063:
            r2.classIdToProto = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoBasedClassDataFinder.<init>(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PackageFragment, kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver, kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion, kotlin.jvm.functions.Function1):void");
    }

    public final Collection<ClassId> getAllClassIds() {
        return this.classIdToProto.keySet();
    }

    public ClassData findClassData(ClassId classId) {
        Intrinsics.checkParameterIsNotNull(classId, "classId");
        ProtoBuf.Class classR = this.classIdToProto.get(classId);
        if (classR != null) {
            return new ClassData(this.nameResolver, classR, this.metadataVersion, this.classSource.invoke(classId));
        }
        return null;
    }
}
