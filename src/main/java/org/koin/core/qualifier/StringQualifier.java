package org.koin.core.qualifier;

import com.google.android.gms.fitness.FitnessActivities;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0002\u0010\u0005J\r\u0010\b\u001a\u00060\u0003j\u0002`\u0004HÆ\u0003J\u0017\u0010\t\u001a\u00020\u00002\f\b\u0002\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\b\u0010\u0010\u001a\u00020\u0003H\u0016R\u0018\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lorg/koin/core/qualifier/StringQualifier;", "Lorg/koin/core/qualifier/Qualifier;", "value", "", "Lorg/koin/core/qualifier/QualifierValue;", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "component1", "copy", "equals", "", FitnessActivities.OTHER, "", "hashCode", "", "toString", "koin-core"}, k = 1, mv = {1, 1, 16})
/* compiled from: StringQualifier.kt */
public final class StringQualifier implements Qualifier {
    private final String value;

    public static /* synthetic */ StringQualifier copy$default(StringQualifier stringQualifier, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = stringQualifier.getValue();
        }
        return stringQualifier.copy(str);
    }

    public final String component1() {
        return getValue();
    }

    public final StringQualifier copy(String str) {
        Intrinsics.checkParameterIsNotNull(str, "value");
        return new StringQualifier(str);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof StringQualifier) && Intrinsics.areEqual(getValue(), ((StringQualifier) obj).getValue());
        }
        return true;
    }

    public int hashCode() {
        String value2 = getValue();
        if (value2 != null) {
            return value2.hashCode();
        }
        return 0;
    }

    public StringQualifier(String str) {
        Intrinsics.checkParameterIsNotNull(str, "value");
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }

    public String toString() {
        return getValue();
    }
}
