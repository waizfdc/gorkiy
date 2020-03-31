package com.google.android.gms.internal.vision;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
final class zziv extends zziw<FieldDescriptorType, Object> {
    zziv(int i) {
        super(i, null);
    }

    public final void zzdp() {
        if (!isImmutable()) {
            for (int i = 0; i < zzhx(); i++) {
                Map.Entry zzbu = zzbu(i);
                if (((zzgk) zzbu.getKey()).zzfu()) {
                    zzbu.setValue(Collections.unmodifiableList((List) zzbu.getValue()));
                }
            }
            for (Map.Entry entry : zzhy()) {
                if (((zzgk) entry.getKey()).zzfu()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zzdp();
    }
}
