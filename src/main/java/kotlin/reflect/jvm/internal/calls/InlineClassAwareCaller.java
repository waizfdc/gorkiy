package kotlin.reflect.jvm.internal.calls;

import androidx.core.app.NotificationCompat;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0000\u0018\u0000*\f\b\u0000\u0010\u0001 \u0001*\u0004\u0018\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u001cB#\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u001aH\u0016¢\u0006\u0002\u0010\u001bR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00028\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001d"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller;", "M", "Ljava/lang/reflect/Member;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "caller", "isDefault", "", "(Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;Lkotlin/reflect/jvm/internal/calls/Caller;Z)V", "data", "Lkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller$BoxUnboxData;", "member", "getMember", "()Ljava/lang/reflect/Member;", "parameterTypes", "", "Ljava/lang/reflect/Type;", "getParameterTypes", "()Ljava/util/List;", "returnType", "getReturnType", "()Ljava/lang/reflect/Type;", NotificationCompat.CATEGORY_CALL, "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "BoxUnboxData", "kotlin-reflection"}, k = 1, mv = {1, 1, 15})
/* compiled from: InlineClassAwareCaller.kt */
public final class InlineClassAwareCaller<M extends Member> implements Caller<M> {
    private final Caller<M> caller;
    private final BoxUnboxData data;
    private final boolean isDefault;

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0058, code lost:
        if ((r1 instanceof kotlin.reflect.jvm.internal.calls.BoundCaller) != false) goto L_0x0078;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public InlineClassAwareCaller(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r9, kotlin.reflect.jvm.internal.calls.Caller<? extends M> r10, boolean r11) {
        /*
            r8 = this;
            java.lang.String r0 = "descriptor"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r9, r0)
            java.lang.String r0 = "caller"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r10, r0)
            r8.<init>()
            r8.caller = r10
            r8.isDefault = r11
            r10 = r8
            kotlin.reflect.jvm.internal.calls.InlineClassAwareCaller r10 = (kotlin.reflect.jvm.internal.calls.InlineClassAwareCaller) r10
            kotlin.reflect.jvm.internal.impl.types.KotlinType r11 = r9.getReturnType()
            if (r11 != 0) goto L_0x001d
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x001d:
            java.lang.String r0 = "descriptor.returnType!!"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r11, r0)
            java.lang.Class r11 = kotlin.reflect.jvm.internal.calls.InlineClassAwareCallerKt.toInlineClass(r11)
            r0 = 0
            if (r11 == 0) goto L_0x002e
            java.lang.reflect.Method r11 = kotlin.reflect.jvm.internal.calls.InlineClassAwareCallerKt.getBoxMethod(r11, r9)
            goto L_0x002f
        L_0x002e:
            r11 = r0
        L_0x002f:
            r1 = r9
            kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor r1 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor) r1
            boolean r1 = kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.isGetterOfUnderlyingPropertyOfInlineClass(r1)
            r2 = 0
            if (r1 == 0) goto L_0x0048
            kotlin.ranges.IntRange$Companion r9 = kotlin.ranges.IntRange.Companion
            kotlin.ranges.IntRange r9 = r9.getEMPTY()
            java.lang.reflect.Method[] r10 = new java.lang.reflect.Method[r2]
            kotlin.reflect.jvm.internal.calls.InlineClassAwareCaller$BoxUnboxData r0 = new kotlin.reflect.jvm.internal.calls.InlineClassAwareCaller$BoxUnboxData
            r0.<init>(r9, r10, r11)
            goto L_0x014d
        L_0x0048:
            kotlin.reflect.jvm.internal.calls.Caller<M> r1 = r10.caller
            boolean r3 = r1 instanceof kotlin.reflect.jvm.internal.calls.CallerImpl.Method.BoundStatic
            java.lang.String r4 = "descriptor.containingDeclaration"
            r5 = -1
            if (r3 == 0) goto L_0x0052
            goto L_0x0078
        L_0x0052:
            boolean r3 = r9 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor
            if (r3 == 0) goto L_0x005b
            boolean r1 = r1 instanceof kotlin.reflect.jvm.internal.calls.BoundCaller
            if (r1 == 0) goto L_0x0077
            goto L_0x0078
        L_0x005b:
            kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor r1 = r9.getDispatchReceiverParameter()
            if (r1 == 0) goto L_0x0077
            kotlin.reflect.jvm.internal.calls.Caller<M> r1 = r10.caller
            boolean r1 = r1 instanceof kotlin.reflect.jvm.internal.calls.BoundCaller
            if (r1 != 0) goto L_0x0077
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r1 = r9.getContainingDeclaration()
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r4)
            boolean r1 = kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.isInlineClass(r1)
            if (r1 == 0) goto L_0x0075
            goto L_0x0077
        L_0x0075:
            r5 = 1
            goto L_0x0078
        L_0x0077:
            r5 = r2
        L_0x0078:
            boolean r1 = r10.isDefault
            if (r1 == 0) goto L_0x007e
            r1 = 2
            goto L_0x007f
        L_0x007e:
            r1 = r2
        L_0x007f:
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor r6 = r9.getExtensionReceiverParameter()
            if (r6 == 0) goto L_0x008f
            kotlin.reflect.jvm.internal.impl.types.KotlinType r6 = r6.getType()
            goto L_0x0090
        L_0x008f:
            r6 = r0
        L_0x0090:
            if (r6 == 0) goto L_0x0096
            r3.add(r6)
            goto L_0x00de
        L_0x0096:
            boolean r6 = r9 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor
            if (r6 == 0) goto L_0x00c4
            r4 = r9
            kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor) r4
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r4 = r4.getConstructedClass()
            java.lang.String r6 = "descriptor.constructedClass"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r6)
            boolean r6 = r4.isInner()
            if (r6 == 0) goto L_0x00de
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r4 = r4.getContainingDeclaration()
            if (r4 == 0) goto L_0x00bc
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r4
            kotlin.reflect.jvm.internal.impl.types.SimpleType r4 = r4.getDefaultType()
            r3.add(r4)
            goto L_0x00de
        L_0x00bc:
            kotlin.TypeCastException r9 = new kotlin.TypeCastException
            java.lang.String r10 = "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor"
            r9.<init>(r10)
            throw r9
        L_0x00c4:
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r6 = r9.getContainingDeclaration()
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r4)
            boolean r4 = r6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
            if (r4 == 0) goto L_0x00de
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r6 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r6
            boolean r4 = r6.isInline()
            if (r4 == 0) goto L_0x00de
            kotlin.reflect.jvm.internal.impl.types.SimpleType r4 = r6.getDefaultType()
            r3.add(r4)
        L_0x00de:
            java.util.List r4 = r9.getValueParameters()
            java.lang.String r6 = "descriptor.valueParameters"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r6)
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.Iterator r4 = r4.iterator()
        L_0x00ed:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x0104
            java.lang.Object r6 = r4.next()
            r7 = r3
            java.util.Collection r7 = (java.util.Collection) r7
            kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r6 = (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) r6
            kotlin.reflect.jvm.internal.impl.types.KotlinType r6 = r6.getType()
            r7.add(r6)
            goto L_0x00ed
        L_0x0104:
            r4 = r3
            java.util.Collection r4 = (java.util.Collection) r4
            java.util.List r3 = (java.util.List) r3
            int r4 = r3.size()
            int r4 = r4 + r5
            int r4 = r4 + r1
            r1 = r10
            kotlin.reflect.jvm.internal.calls.Caller r1 = (kotlin.reflect.jvm.internal.calls.Caller) r1
            int r6 = kotlin.reflect.jvm.internal.calls.CallerKt.getArity(r1)
            if (r6 != r4) goto L_0x0150
            int r10 = java.lang.Math.max(r5, r2)
            int r1 = r3.size()
            int r1 = r1 + r5
            kotlin.ranges.IntRange r10 = kotlin.ranges.RangesKt.until(r10, r1)
            java.lang.reflect.Method[] r1 = new java.lang.reflect.Method[r4]
        L_0x0127:
            if (r2 >= r4) goto L_0x0148
            boolean r6 = r10.contains(r2)
            if (r6 == 0) goto L_0x0142
            int r6 = r2 - r5
            java.lang.Object r6 = r3.get(r6)
            kotlin.reflect.jvm.internal.impl.types.KotlinType r6 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r6
            java.lang.Class r6 = kotlin.reflect.jvm.internal.calls.InlineClassAwareCallerKt.toInlineClass(r6)
            if (r6 == 0) goto L_0x0142
            java.lang.reflect.Method r6 = kotlin.reflect.jvm.internal.calls.InlineClassAwareCallerKt.getUnboxMethod(r6, r9)
            goto L_0x0143
        L_0x0142:
            r6 = r0
        L_0x0143:
            r1[r2] = r6
            int r2 = r2 + 1
            goto L_0x0127
        L_0x0148:
            kotlin.reflect.jvm.internal.calls.InlineClassAwareCaller$BoxUnboxData r0 = new kotlin.reflect.jvm.internal.calls.InlineClassAwareCaller$BoxUnboxData
            r0.<init>(r10, r1, r11)
        L_0x014d:
            r8.data = r0
            return
        L_0x0150:
            kotlin.reflect.jvm.internal.KotlinReflectionInternalError r11 = new kotlin.reflect.jvm.internal.KotlinReflectionInternalError
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "Inconsistent number of parameters in the descriptor and Java reflection object: "
            r0.append(r2)
            int r1 = kotlin.reflect.jvm.internal.calls.CallerKt.getArity(r1)
            r0.append(r1)
            java.lang.String r1 = " != "
            r0.append(r1)
            r0.append(r4)
            r1 = 10
            r0.append(r1)
            java.lang.String r2 = "Calling: "
            r0.append(r2)
            r0.append(r9)
            r0.append(r1)
            java.lang.String r9 = "Parameter types: "
            r0.append(r9)
            java.util.List r9 = r10.getParameterTypes()
            r0.append(r9)
            java.lang.String r9 = ")\n"
            r0.append(r9)
            java.lang.String r9 = "Default: "
            r0.append(r9)
            boolean r9 = r10.isDefault
            r0.append(r9)
            java.lang.String r9 = r0.toString()
            r11.<init>(r9)
            java.lang.Throwable r11 = (java.lang.Throwable) r11
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.calls.InlineClassAwareCaller.<init>(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.calls.Caller, boolean):void");
    }

    public M getMember() {
        return this.caller.getMember();
    }

    public Type getReturnType() {
        return this.caller.getReturnType();
    }

    public List<Type> getParameterTypes() {
        return this.caller.getParameterTypes();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\r\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003H\u0002J\u0016\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005H\u0002¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller$BoxUnboxData;", "", "argumentRange", "Lkotlin/ranges/IntRange;", "unbox", "", "Ljava/lang/reflect/Method;", "box", "(Lkotlin/ranges/IntRange;[Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "getArgumentRange", "()Lkotlin/ranges/IntRange;", "getBox", "()Ljava/lang/reflect/Method;", "getUnbox", "()[Ljava/lang/reflect/Method;", "[Ljava/lang/reflect/Method;", "component1", "component2", "component3", "kotlin-reflection"}, k = 1, mv = {1, 1, 15})
    /* compiled from: InlineClassAwareCaller.kt */
    private static final class BoxUnboxData {
        private final IntRange argumentRange;
        private final Method box;
        private final Method[] unbox;

        public BoxUnboxData(IntRange intRange, Method[] methodArr, Method method) {
            Intrinsics.checkParameterIsNotNull(intRange, "argumentRange");
            Intrinsics.checkParameterIsNotNull(methodArr, "unbox");
            this.argumentRange = intRange;
            this.unbox = methodArr;
            this.box = method;
        }

        public final IntRange component1() {
            return this.argumentRange;
        }

        public final Method[] component2() {
            return this.unbox;
        }

        public final Method component3() {
            return this.box;
        }
    }

    public Object call(Object[] objArr) {
        Object invoke;
        Intrinsics.checkParameterIsNotNull(objArr, "args");
        BoxUnboxData boxUnboxData = this.data;
        IntRange component1 = boxUnboxData.component1();
        Method[] component2 = boxUnboxData.component2();
        Method component3 = boxUnboxData.component3();
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, size)");
        if (copyOf != null) {
            int first = component1.getFirst();
            int last = component1.getLast();
            if (first <= last) {
                while (true) {
                    Method method = component2[first];
                    Object obj = objArr[first];
                    if (!(method == null || obj == null)) {
                        obj = method.invoke(obj, new Object[0]);
                    }
                    copyOf[first] = obj;
                    if (first == last) {
                        break;
                    }
                    first++;
                }
            }
            Object call = this.caller.call(copyOf);
            return (component3 == null || (invoke = component3.invoke(null, new Object[]{call})) == null) ? call : invoke;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
    }
}
