package com.google.android.gms.internal.fitness;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
final class zzig extends zzid<FieldDescriptorType, Object> {
    zzig(int i) {
        super(i, null);
    }

    public final void zzal() {
        if (!isImmutable()) {
            for (int i = 0; i < zzcq(); i++) {
                Map.Entry zzaj = zzaj(i);
                if (((zzgd) zzaj.getKey()).zzbi()) {
                    zzaj.setValue(Collections.unmodifiableList((List) zzaj.getValue()));
                }
            }
            for (Map.Entry entry : zzcr()) {
                if (((zzgd) entry.getKey()).zzbi()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zzal();
    }
}
