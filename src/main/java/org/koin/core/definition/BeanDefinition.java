package org.koin.core.definition;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.fitness.FitnessActivities;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.koin.core.parameter.DefinitionParameters;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;
import org.koin.core.scope.ScopeDefinition;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012'\u0010\t\u001a#\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00028\u00000\nj\b\u0012\u0004\u0012\u00028\u0000`\r¢\u0006\u0002\b\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0012\b\u0002\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u0012\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018¢\u0006\u0002\u0010\u0019J\u001e\u0010,\u001a\u00020-2\n\u0010.\u001a\u0006\u0012\u0002\b\u00030\u00062\n\u0010/\u001a\u0006\u0012\u0002\b\u00030\u0006J\t\u00100\u001a\u00020\u0004HÆ\u0003J\r\u00101\u001a\u0006\u0012\u0002\b\u00030\u0006HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\bHÆ\u0003J*\u00103\u001a#\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00028\u00000\nj\b\u0012\u0004\u0012\u00028\u0000`\r¢\u0006\u0002\b\u000eHÆ\u0003J\t\u00104\u001a\u00020\u0010HÆ\u0003J\u0013\u00105\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0012HÆ\u0003J\t\u00106\u001a\u00020\u0014HÆ\u0003J\t\u00107\u001a\u00020\u0016HÆ\u0003J\u000f\u00108\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018HÆ\u0003J \u0001\u00109\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\f\b\u0002\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2)\b\u0002\u0010\t\u001a#\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00028\u00000\nj\b\u0012\u0004\u0012\u00028\u0000`\r¢\u0006\u0002\b\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0012\b\u0002\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018HÆ\u0001J\u0013\u0010:\u001a\u00020-2\b\u0010;\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010<\u001a\u00020-2\n\u0010=\u001a\u0006\u0012\u0002\b\u00030\u0006J\b\u0010>\u001a\u00020?H\u0016J$\u0010@\u001a\u00020-2\n\u0010=\u001a\u0006\u0012\u0002\b\u00030\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u0004J\b\u0010A\u001a\u00020BH\u0016R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR2\u0010\t\u001a#\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00028\u00000\nj\b\u0012\u0004\u0012\u00028\u0000`\r¢\u0006\u0002\b\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0015\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001b\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0012¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+¨\u0006C"}, d2 = {"Lorg/koin/core/definition/BeanDefinition;", ExifInterface.GPS_DIRECTION_TRUE, "", "scopeDefinition", "Lorg/koin/core/scope/ScopeDefinition;", "primaryType", "Lkotlin/reflect/KClass;", "qualifier", "Lorg/koin/core/qualifier/Qualifier;", "definition", "Lkotlin/Function2;", "Lorg/koin/core/scope/Scope;", "Lorg/koin/core/parameter/DefinitionParameters;", "Lorg/koin/core/definition/Definition;", "Lkotlin/ExtensionFunctionType;", "kind", "Lorg/koin/core/definition/Kind;", "secondaryTypes", "", "options", "Lorg/koin/core/definition/Options;", "properties", "Lorg/koin/core/definition/Properties;", "callbacks", "Lorg/koin/core/definition/Callbacks;", "(Lorg/koin/core/scope/ScopeDefinition;Lkotlin/reflect/KClass;Lorg/koin/core/qualifier/Qualifier;Lkotlin/jvm/functions/Function2;Lorg/koin/core/definition/Kind;Ljava/util/List;Lorg/koin/core/definition/Options;Lorg/koin/core/definition/Properties;Lorg/koin/core/definition/Callbacks;)V", "getCallbacks", "()Lorg/koin/core/definition/Callbacks;", "getDefinition", "()Lkotlin/jvm/functions/Function2;", "getKind", "()Lorg/koin/core/definition/Kind;", "getOptions", "()Lorg/koin/core/definition/Options;", "getPrimaryType", "()Lkotlin/reflect/KClass;", "getProperties", "()Lorg/koin/core/definition/Properties;", "getQualifier", "()Lorg/koin/core/qualifier/Qualifier;", "getScopeDefinition", "()Lorg/koin/core/scope/ScopeDefinition;", "getSecondaryTypes", "()Ljava/util/List;", "canBind", "", "primary", "secondary", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", FitnessActivities.OTHER, "hasType", "clazz", "hashCode", "", "is", "toString", "", "koin-core"}, k = 1, mv = {1, 1, 16})
/* compiled from: BeanDefinition.kt */
public final class BeanDefinition<T> {
    private final Callbacks<T> callbacks;
    private final Function2<Scope, DefinitionParameters, T> definition;
    private final Kind kind;
    private final Options options;
    private final KClass<?> primaryType;
    private final Properties properties;
    private final Qualifier qualifier;
    private final ScopeDefinition scopeDefinition;
    private final List<KClass<?>> secondaryTypes;

    public static /* synthetic */ BeanDefinition copy$default(BeanDefinition beanDefinition, ScopeDefinition scopeDefinition2, KClass kClass, Qualifier qualifier2, Function2 function2, Kind kind2, List list, Options options2, Properties properties2, Callbacks callbacks2, int i, Object obj) {
        BeanDefinition beanDefinition2 = beanDefinition;
        int i2 = i;
        return beanDefinition.copy((i2 & 1) != 0 ? beanDefinition2.scopeDefinition : scopeDefinition2, (i2 & 2) != 0 ? beanDefinition2.primaryType : kClass, (i2 & 4) != 0 ? beanDefinition2.qualifier : qualifier2, (i2 & 8) != 0 ? beanDefinition2.definition : function2, (i2 & 16) != 0 ? beanDefinition2.kind : kind2, (i2 & 32) != 0 ? beanDefinition2.secondaryTypes : list, (i2 & 64) != 0 ? beanDefinition2.options : options2, (i2 & 128) != 0 ? beanDefinition2.properties : properties2, (i2 & 256) != 0 ? beanDefinition2.callbacks : callbacks2);
    }

    public final ScopeDefinition component1() {
        return this.scopeDefinition;
    }

    public final KClass<?> component2() {
        return this.primaryType;
    }

    public final Qualifier component3() {
        return this.qualifier;
    }

    public final Function2<Scope, DefinitionParameters, T> component4() {
        return this.definition;
    }

    public final Kind component5() {
        return this.kind;
    }

    public final List<KClass<?>> component6() {
        return this.secondaryTypes;
    }

    public final Options component7() {
        return this.options;
    }

    public final Properties component8() {
        return this.properties;
    }

    public final Callbacks<T> component9() {
        return this.callbacks;
    }

    public final BeanDefinition<T> copy(ScopeDefinition scopeDefinition2, KClass<?> kClass, Qualifier qualifier2, Function2<? super Scope, ? super DefinitionParameters, ? extends T> function2, Kind kind2, List<? extends KClass<?>> list, Options options2, Properties properties2, Callbacks<T> callbacks2) {
        Intrinsics.checkParameterIsNotNull(scopeDefinition2, "scopeDefinition");
        Intrinsics.checkParameterIsNotNull(kClass, "primaryType");
        Intrinsics.checkParameterIsNotNull(function2, "definition");
        Kind kind3 = kind2;
        Intrinsics.checkParameterIsNotNull(kind3, "kind");
        List<? extends KClass<?>> list2 = list;
        Intrinsics.checkParameterIsNotNull(list2, "secondaryTypes");
        Options options3 = options2;
        Intrinsics.checkParameterIsNotNull(options3, "options");
        Properties properties3 = properties2;
        Intrinsics.checkParameterIsNotNull(properties3, "properties");
        Callbacks<T> callbacks3 = callbacks2;
        Intrinsics.checkParameterIsNotNull(callbacks3, "callbacks");
        return new BeanDefinition(scopeDefinition2, kClass, qualifier2, function2, kind3, list2, options3, properties3, callbacks3);
    }

    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.Object, kotlin.jvm.functions.Function2<? super org.koin.core.scope.Scope, ? super org.koin.core.parameter.DefinitionParameters, ? extends T>, kotlin.jvm.functions.Function2<org.koin.core.scope.Scope, org.koin.core.parameter.DefinitionParameters, T>] */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.util.List<kotlin.reflect.KClass<?>>, java.lang.Object, java.util.List<? extends kotlin.reflect.KClass<?>>] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public BeanDefinition(org.koin.core.scope.ScopeDefinition r2, kotlin.reflect.KClass<?> r3, org.koin.core.qualifier.Qualifier r4, kotlin.jvm.functions.Function2<? super org.koin.core.scope.Scope, ? super org.koin.core.parameter.DefinitionParameters, ? extends T> r5, org.koin.core.definition.Kind r6, java.util.List<? extends kotlin.reflect.KClass<?>> r7, org.koin.core.definition.Options r8, org.koin.core.definition.Properties r9, org.koin.core.definition.Callbacks<T> r10) {
        /*
            r1 = this;
            java.lang.String r0 = "scopeDefinition"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r2, r0)
            java.lang.String r0 = "primaryType"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r0)
            java.lang.String r0 = "definition"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r5, r0)
            java.lang.String r0 = "kind"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r6, r0)
            java.lang.String r0 = "secondaryTypes"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r7, r0)
            java.lang.String r0 = "options"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r8, r0)
            java.lang.String r0 = "properties"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r9, r0)
            java.lang.String r0 = "callbacks"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r10, r0)
            r1.<init>()
            r1.scopeDefinition = r2
            r1.primaryType = r3
            r1.qualifier = r4
            r1.definition = r5
            r1.kind = r6
            r1.secondaryTypes = r7
            r1.options = r8
            r1.properties = r9
            r1.callbacks = r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.koin.core.definition.BeanDefinition.<init>(org.koin.core.scope.ScopeDefinition, kotlin.reflect.KClass, org.koin.core.qualifier.Qualifier, kotlin.jvm.functions.Function2, org.koin.core.definition.Kind, java.util.List, org.koin.core.definition.Options, org.koin.core.definition.Properties, org.koin.core.definition.Callbacks):void");
    }

    public final ScopeDefinition getScopeDefinition() {
        return this.scopeDefinition;
    }

    public final KClass<?> getPrimaryType() {
        return this.primaryType;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ BeanDefinition(org.koin.core.scope.ScopeDefinition r14, kotlin.reflect.KClass r15, org.koin.core.qualifier.Qualifier r16, kotlin.jvm.functions.Function2 r17, org.koin.core.definition.Kind r18, java.util.List r19, org.koin.core.definition.Options r20, org.koin.core.definition.Properties r21, org.koin.core.definition.Callbacks r22, int r23, kotlin.jvm.internal.DefaultConstructorMarker r24) {
        /*
            r13 = this;
            r0 = r23
            r1 = r0 & 4
            r2 = 0
            if (r1 == 0) goto L_0x000c
            r1 = r2
            org.koin.core.qualifier.Qualifier r1 = (org.koin.core.qualifier.Qualifier) r1
            r6 = r1
            goto L_0x000e
        L_0x000c:
            r6 = r16
        L_0x000e:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0018
            java.util.List r1 = kotlin.collections.CollectionsKt.emptyList()
            r9 = r1
            goto L_0x001a
        L_0x0018:
            r9 = r19
        L_0x001a:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0027
            org.koin.core.definition.Options r1 = new org.koin.core.definition.Options
            r3 = 3
            r4 = 0
            r1.<init>(r4, r4, r3, r2)
            r10 = r1
            goto L_0x0029
        L_0x0027:
            r10 = r20
        L_0x0029:
            r1 = r0 & 128(0x80, float:1.794E-43)
            r3 = 1
            if (r1 == 0) goto L_0x0035
            org.koin.core.definition.Properties r1 = new org.koin.core.definition.Properties
            r1.<init>(r2, r3, r2)
            r11 = r1
            goto L_0x0037
        L_0x0035:
            r11 = r21
        L_0x0037:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0042
            org.koin.core.definition.Callbacks r0 = new org.koin.core.definition.Callbacks
            r0.<init>(r2, r3, r2)
            r12 = r0
            goto L_0x0044
        L_0x0042:
            r12 = r22
        L_0x0044:
            r3 = r13
            r4 = r14
            r5 = r15
            r7 = r17
            r8 = r18
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.koin.core.definition.BeanDefinition.<init>(org.koin.core.scope.ScopeDefinition, kotlin.reflect.KClass, org.koin.core.qualifier.Qualifier, kotlin.jvm.functions.Function2, org.koin.core.definition.Kind, java.util.List, org.koin.core.definition.Options, org.koin.core.definition.Properties, org.koin.core.definition.Callbacks, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Qualifier getQualifier() {
        return this.qualifier;
    }

    public final Function2<Scope, DefinitionParameters, T> getDefinition() {
        return this.definition;
    }

    public final Kind getKind() {
        return this.kind;
    }

    public final List<KClass<?>> getSecondaryTypes() {
        return this.secondaryTypes;
    }

    public final Options getOptions() {
        return this.options;
    }

    public final Properties getProperties() {
        return this.properties;
    }

    public final Callbacks<T> getCallbacks() {
        return this.callbacks;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0039, code lost:
        if (r2 != null) goto L_0x003d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toString() {
        /*
            r14 = this;
            org.koin.core.definition.Kind r0 = r14.kind
            java.lang.String r0 = r0.toString()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r2 = 39
            r1.append(r2)
            kotlin.reflect.KClass<?> r3 = r14.primaryType
            java.lang.String r3 = org.koin.ext.KClassExtKt.getFullName(r3)
            r1.append(r3)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            org.koin.core.qualifier.Qualifier r2 = r14.qualifier
            java.lang.String r3 = ""
            if (r2 == 0) goto L_0x003c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = ",qualifier:"
            r2.append(r4)
            org.koin.core.qualifier.Qualifier r4 = r14.qualifier
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            if (r2 == 0) goto L_0x003c
            goto L_0x003d
        L_0x003c:
            r2 = r3
        L_0x003d:
            org.koin.core.scope.ScopeDefinition r4 = r14.scopeDefinition
            boolean r4 = r4.isRoot()
            if (r4 == 0) goto L_0x0047
            r4 = r3
            goto L_0x005e
        L_0x0047:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = ",scope:"
            r4.append(r5)
            org.koin.core.scope.ScopeDefinition r5 = r14.scopeDefinition
            org.koin.core.qualifier.Qualifier r5 = r5.getQualifier()
            r4.append(r5)
            java.lang.String r4 = r4.toString()
        L_0x005e:
            java.util.List<kotlin.reflect.KClass<?>> r5 = r14.secondaryTypes
            java.util.Collection r5 = (java.util.Collection) r5
            boolean r5 = r5.isEmpty()
            r5 = r5 ^ 1
            if (r5 == 0) goto L_0x0095
            java.util.List<kotlin.reflect.KClass<?>> r3 = r14.secondaryTypes
            r5 = r3
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.lang.String r3 = ","
            r6 = r3
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            org.koin.core.definition.BeanDefinition$toString$defOtherTypes$typesAsString$1 r3 = org.koin.core.definition.BeanDefinition$toString$defOtherTypes$typesAsString$1.INSTANCE
            r11 = r3
            kotlin.jvm.functions.Function1 r11 = (kotlin.jvm.functions.Function1) r11
            r12 = 30
            r13 = 0
            java.lang.String r3 = kotlin.collections.CollectionsKt.joinToString$default(r5, r6, r7, r8, r9, r10, r11, r12, r13)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = ",binds:"
            r5.append(r6)
            r5.append(r3)
            java.lang.String r3 = r5.toString()
        L_0x0095:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r6 = 91
            r5.append(r6)
            r5.append(r0)
            r0 = 58
            r5.append(r0)
            r5.append(r1)
            r5.append(r2)
            r5.append(r4)
            r5.append(r3)
            r0 = 93
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.koin.core.definition.BeanDefinition.toString():java.lang.String");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            BeanDefinition beanDefinition = (BeanDefinition) obj;
            if (!(!Intrinsics.areEqual(this.primaryType, beanDefinition.primaryType)) && !(!Intrinsics.areEqual(this.qualifier, beanDefinition.qualifier)) && !(!Intrinsics.areEqual(this.scopeDefinition, beanDefinition.scopeDefinition))) {
                return true;
            }
            return false;
        }
        throw new TypeCastException("null cannot be cast to non-null type org.koin.core.definition.BeanDefinition<*>");
    }

    public final boolean hasType(KClass<?> kClass) {
        Intrinsics.checkParameterIsNotNull(kClass, "clazz");
        return Intrinsics.areEqual(this.primaryType, kClass) || this.secondaryTypes.contains(kClass);
    }

    public final boolean is(KClass<?> kClass, Qualifier qualifier2, ScopeDefinition scopeDefinition2) {
        Intrinsics.checkParameterIsNotNull(kClass, "clazz");
        Intrinsics.checkParameterIsNotNull(scopeDefinition2, "scopeDefinition");
        return hasType(kClass) && Intrinsics.areEqual(this.qualifier, qualifier2) && Intrinsics.areEqual(this.scopeDefinition, scopeDefinition2);
    }

    public final boolean canBind(KClass<?> kClass, KClass<?> kClass2) {
        Intrinsics.checkParameterIsNotNull(kClass, "primary");
        Intrinsics.checkParameterIsNotNull(kClass2, "secondary");
        return Intrinsics.areEqual(this.primaryType, kClass) && this.secondaryTypes.contains(kClass2);
    }

    public int hashCode() {
        Qualifier qualifier2 = this.qualifier;
        return ((((qualifier2 != null ? qualifier2.hashCode() : 0) * 31) + this.primaryType.hashCode()) * 31) + this.scopeDefinition.hashCode();
    }
}
