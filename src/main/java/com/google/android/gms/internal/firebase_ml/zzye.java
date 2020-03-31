package com.google.android.gms.internal.firebase_ml;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
final class zzye extends zzyf<FieldDescriptorType, Object> {
    zzye(int i) {
        super(i, null);
    }

    public final void zzsp() {
        if (!isImmutable()) {
            for (int i = 0; i < zzvt(); i++) {
                Map.Entry zzdx = zzdx(i);
                if (((zzvs) zzdx.getKey()).zztp()) {
                    zzdx.setValue(Collections.unmodifiableList((List) zzdx.getValue()));
                }
            }
            for (Map.Entry entry : zzvu()) {
                if (((zzvs) entry.getKey()).zztp()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zzsp();
    }
}
