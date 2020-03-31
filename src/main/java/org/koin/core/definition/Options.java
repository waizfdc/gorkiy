package org.koin.core.definition;

import com.google.android.gms.fitness.FitnessActivities;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0006\"\u0004\b\n\u0010\b¨\u0006\u0014"}, d2 = {"Lorg/koin/core/definition/Options;", "", "isCreatedAtStart", "", "override", "(ZZ)V", "()Z", "setCreatedAtStart", "(Z)V", "getOverride", "setOverride", "component1", "component2", "copy", "equals", FitnessActivities.OTHER, "hashCode", "", "toString", "", "koin-core"}, k = 1, mv = {1, 1, 16})
/* compiled from: Options.kt */
public final class Options {
    private boolean isCreatedAtStart;
    private boolean override;

    public Options() {
        this(false, false, 3, null);
    }

    public static /* synthetic */ Options copy$default(Options options, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = options.isCreatedAtStart;
        }
        if ((i & 2) != 0) {
            z2 = options.override;
        }
        return options.copy(z, z2);
    }

    public final boolean component1() {
        return this.isCreatedAtStart;
    }

    public final boolean component2() {
        return this.override;
    }

    public final Options copy(boolean z, boolean z2) {
        return new Options(z, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Options)) {
            return false;
        }
        Options options = (Options) obj;
        return this.isCreatedAtStart == options.isCreatedAtStart && this.override == options.override;
    }

    public int hashCode() {
        boolean z = this.isCreatedAtStart;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i = (z ? 1 : 0) * true;
        boolean z3 = this.override;
        if (!z3) {
            z2 = z3;
        }
        return i + (z2 ? 1 : 0);
    }

    public String toString() {
        return "Options(isCreatedAtStart=" + this.isCreatedAtStart + ", override=" + this.override + ")";
    }

    public Options(boolean z, boolean z2) {
        this.isCreatedAtStart = z;
        this.override = z2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Options(boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2);
    }

    public final boolean getOverride() {
        return this.override;
    }

    public final boolean isCreatedAtStart() {
        return this.isCreatedAtStart;
    }

    public final void setCreatedAtStart(boolean z) {
        this.isCreatedAtStart = z;
    }

    public final void setOverride(boolean z) {
        this.override = z;
    }
}
