package org.koin.core.qualifier;

import com.google.android.gms.fitness.FitnessActivities;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.koin.ext.KClassExtKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004J\r\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u0003HÆ\u0003J\u0017\u0010\r\u001a\u00020\u00002\f\b\u0002\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\b\u0010\u0014\u001a\u00020\bH\u0016R\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u00060\bj\u0002`\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lorg/koin/core/qualifier/TypeQualifier;", "Lorg/koin/core/qualifier/Qualifier;", "type", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)V", "getType", "()Lkotlin/reflect/KClass;", "value", "", "Lorg/koin/core/qualifier/QualifierValue;", "getValue", "()Ljava/lang/String;", "component1", "copy", "equals", "", FitnessActivities.OTHER, "", "hashCode", "", "toString", "koin-core"}, k = 1, mv = {1, 1, 16})
/* compiled from: TypeQualifier.kt */
public final class TypeQualifier implements Qualifier {
    private final KClass<?> type;
    private final String value;

    public static /* synthetic */ TypeQualifier copy$default(TypeQualifier typeQualifier, KClass kClass, int i, Object obj) {
        if ((i & 1) != 0) {
            kClass = typeQualifier.type;
        }
        return typeQualifier.copy(kClass);
    }

    public final KClass<?> component1() {
        return this.type;
    }

    public final TypeQualifier copy(KClass<?> kClass) {
        Intrinsics.checkParameterIsNotNull(kClass, "type");
        return new TypeQualifier(kClass);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof TypeQualifier) && Intrinsics.areEqual(this.type, ((TypeQualifier) obj).type);
        }
        return true;
    }

    public int hashCode() {
        KClass<?> kClass = this.type;
        if (kClass != null) {
            return kClass.hashCode();
        }
        return 0;
    }

    public TypeQualifier(KClass<?> kClass) {
        Intrinsics.checkParameterIsNotNull(kClass, "type");
        this.type = kClass;
        this.value = KClassExtKt.getFullName(kClass);
    }

    public final KClass<?> getType() {
        return this.type;
    }

    public String getValue() {
        return this.value;
    }

    public String toString() {
        return "q:'" + getValue() + '\'';
    }
}
