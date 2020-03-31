package com.redmadrobot.inputmask;

import com.google.android.gms.fitness.FitnessActivities;
import com.redmadrobot.inputmask.helper.Mask;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000'\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\"\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"com/redmadrobot/inputmask/MaskedTextChangedListener$pickMask$MaskAffinity", "", "mask", "Lcom/redmadrobot/inputmask/helper/Mask;", "affinity", "", "(Lcom/redmadrobot/inputmask/helper/Mask;I)V", "getAffinity", "()I", "getMask", "()Lcom/redmadrobot/inputmask/helper/Mask;", "component1", "component2", "copy", "(Lcom/redmadrobot/inputmask/helper/Mask;I)Lcom/redmadrobot/inputmask/MaskedTextChangedListener$pickMask$MaskAffinity;", "equals", "", FitnessActivities.OTHER, "hashCode", "toString", "", "input-mask-android_release"}, k = 1, mv = {1, 1, 13})
/* compiled from: MaskedTextChangedListener.kt */
public final class MaskedTextChangedListener$pickMask$MaskAffinity {
    private final int affinity;
    private final Mask mask;

    public static /* synthetic */ MaskedTextChangedListener$pickMask$MaskAffinity copy$default(MaskedTextChangedListener$pickMask$MaskAffinity maskedTextChangedListener$pickMask$MaskAffinity, Mask mask2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            mask2 = maskedTextChangedListener$pickMask$MaskAffinity.mask;
        }
        if ((i2 & 2) != 0) {
            i = maskedTextChangedListener$pickMask$MaskAffinity.affinity;
        }
        return maskedTextChangedListener$pickMask$MaskAffinity.copy(mask2, i);
    }

    public final Mask component1() {
        return this.mask;
    }

    public final int component2() {
        return this.affinity;
    }

    public final MaskedTextChangedListener$pickMask$MaskAffinity copy(Mask mask2, int i) {
        Intrinsics.checkParameterIsNotNull(mask2, "mask");
        return new MaskedTextChangedListener$pickMask$MaskAffinity(mask2, i);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof MaskedTextChangedListener$pickMask$MaskAffinity) {
                MaskedTextChangedListener$pickMask$MaskAffinity maskedTextChangedListener$pickMask$MaskAffinity = (MaskedTextChangedListener$pickMask$MaskAffinity) obj;
                if (Intrinsics.areEqual(this.mask, maskedTextChangedListener$pickMask$MaskAffinity.mask)) {
                    if (this.affinity == maskedTextChangedListener$pickMask$MaskAffinity.affinity) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        Mask mask2 = this.mask;
        return ((mask2 != null ? mask2.hashCode() : 0) * 31) + this.affinity;
    }

    public String toString() {
        return "MaskAffinity(mask=" + this.mask + ", affinity=" + this.affinity + ")";
    }

    public MaskedTextChangedListener$pickMask$MaskAffinity(Mask mask2, int i) {
        Intrinsics.checkParameterIsNotNull(mask2, "mask");
        this.mask = mask2;
        this.affinity = i;
    }

    public final int getAffinity() {
        return this.affinity;
    }

    public final Mask getMask() {
        return this.mask;
    }
}
