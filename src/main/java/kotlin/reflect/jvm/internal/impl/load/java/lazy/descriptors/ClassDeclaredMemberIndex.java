package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* compiled from: DeclaredMemberIndex.kt */
public class ClassDeclaredMemberIndex implements DeclaredMemberIndex {
    private final Map<Name, JavaField> fields;
    private final JavaClass jClass;
    /* access modifiers changed from: private */
    public final Function1<JavaMember, Boolean> memberFilter;
    private final Function1<JavaMethod, Boolean> methodFilter = new ClassDeclaredMemberIndex$methodFilter$1(this);
    private final Map<Name, List<JavaMethod>> methods;

    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.Object, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember, java.lang.Boolean>, kotlin.jvm.functions.Function1<kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember, java.lang.Boolean>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ClassDeclaredMemberIndex(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass r4, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember, java.lang.Boolean> r5) {
        /*
            r3 = this;
            java.lang.String r0 = "jClass"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r4, r0)
            java.lang.String r0 = "memberFilter"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r5, r0)
            r3.<init>()
            r3.jClass = r4
            r3.memberFilter = r5
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.ClassDeclaredMemberIndex$methodFilter$1 r4 = new kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.ClassDeclaredMemberIndex$methodFilter$1
            r4.<init>(r3)
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            r3.methodFilter = r4
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass r4 = r3.jClass
            java.util.Collection r4 = r4.getMethods()
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            kotlin.sequences.Sequence r4 = kotlin.collections.CollectionsKt.asSequence(r4)
            kotlin.jvm.functions.Function1<kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod, java.lang.Boolean> r5 = r3.methodFilter
            kotlin.sequences.Sequence r4 = kotlin.sequences.SequencesKt.filter(r4, r5)
            java.util.LinkedHashMap r5 = new java.util.LinkedHashMap
            r5.<init>()
            java.util.Map r5 = (java.util.Map) r5
            java.util.Iterator r4 = r4.iterator()
        L_0x0037:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x005c
            java.lang.Object r0 = r4.next()
            r1 = r0
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod r1 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod) r1
            kotlin.reflect.jvm.internal.impl.name.Name r1 = r1.getName()
            java.lang.Object r2 = r5.get(r1)
            if (r2 != 0) goto L_0x0056
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r5.put(r1, r2)
        L_0x0056:
            java.util.List r2 = (java.util.List) r2
            r2.add(r0)
            goto L_0x0037
        L_0x005c:
            r3.methods = r5
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass r4 = r3.jClass
            java.util.Collection r4 = r4.getFields()
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            kotlin.sequences.Sequence r4 = kotlin.collections.CollectionsKt.asSequence(r4)
            kotlin.jvm.functions.Function1<kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember, java.lang.Boolean> r5 = r3.memberFilter
            kotlin.sequences.Sequence r4 = kotlin.sequences.SequencesKt.filter(r4, r5)
            java.util.LinkedHashMap r5 = new java.util.LinkedHashMap
            r5.<init>()
            java.util.Map r5 = (java.util.Map) r5
            java.util.Iterator r4 = r4.iterator()
        L_0x007b:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x0090
            java.lang.Object r0 = r4.next()
            r1 = r0
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField r1 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField) r1
            kotlin.reflect.jvm.internal.impl.name.Name r1 = r1.getName()
            r5.put(r1, r0)
            goto L_0x007b
        L_0x0090:
            r3.fields = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.ClassDeclaredMemberIndex.<init>(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass, kotlin.jvm.functions.Function1):void");
    }

    public Collection<JavaMethod> findMethodsByName(Name name) {
        Intrinsics.checkParameterIsNotNull(name, AppMeasurementSdk.ConditionalUserProperty.NAME);
        List list = this.methods.get(name);
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        return list;
    }

    public Set<Name> getMethodNames() {
        Sequence<JavaMethod> filter = SequencesKt.filter(CollectionsKt.asSequence(this.jClass.getMethods()), this.methodFilter);
        Collection linkedHashSet = new LinkedHashSet();
        for (JavaMethod name : filter) {
            linkedHashSet.add(name.getName());
        }
        return (Set) linkedHashSet;
    }

    public JavaField findFieldByName(Name name) {
        Intrinsics.checkParameterIsNotNull(name, AppMeasurementSdk.ConditionalUserProperty.NAME);
        return this.fields.get(name);
    }

    public Set<Name> getFieldNames() {
        Sequence<JavaField> filter = SequencesKt.filter(CollectionsKt.asSequence(this.jClass.getFields()), this.memberFilter);
        Collection linkedHashSet = new LinkedHashSet();
        for (JavaField name : filter) {
            linkedHashSet.add(name.getName());
        }
        return (Set) linkedHashSet;
    }
}
