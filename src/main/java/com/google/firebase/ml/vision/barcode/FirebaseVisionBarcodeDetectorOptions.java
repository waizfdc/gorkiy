package com.google.firebase.ml.vision.barcode;

import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.internal.firebase_ml.zzsl;
import com.google.android.gms.internal.firebase_ml.zzuf;
import com.google.android.gms.internal.firebase_ml.zzvx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public class FirebaseVisionBarcodeDetectorOptions {
    private static final Map<Integer, zzuf> zzbjo;
    private final int zzbjn;

    private FirebaseVisionBarcodeDetectorOptions(int i) {
        this.zzbjn = i;
    }

    /* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
    public static class Builder {
        private int zzbjq = 0;

        public Builder setBarcodeFormats(int i, int... iArr) {
            this.zzbjq = i;
            if (iArr != null) {
                for (int i2 : iArr) {
                    this.zzbjq = i2 | this.zzbjq;
                }
            }
            return this;
        }

        public FirebaseVisionBarcodeDetectorOptions build() {
            return new FirebaseVisionBarcodeDetectorOptions(this.zzbjq);
        }
    }

    public final int zzpq() {
        return this.zzbjn;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof FirebaseVisionBarcodeDetectorOptions) && this.zzbjn == ((FirebaseVisionBarcodeDetectorOptions) obj).zzbjn;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zzbjn));
    }

    public final zzsl.zza zzpr() {
        ArrayList arrayList = new ArrayList();
        if (this.zzbjn == 0) {
            arrayList.addAll(zzbjo.values());
        } else {
            for (Map.Entry next : zzbjo.entrySet()) {
                if ((this.zzbjn & ((Integer) next.getKey()).intValue()) != 0) {
                    arrayList.add((zzuf) next.getValue());
                }
            }
        }
        return (zzsl.zza) ((zzvx) zzsl.zza.zzqz().zzz(arrayList).zztx());
    }

    static {
        HashMap hashMap = new HashMap();
        zzbjo = hashMap;
        hashMap.put(1, zzuf.CODE_128);
        zzbjo.put(2, zzuf.CODE_39);
        zzbjo.put(4, zzuf.CODE_93);
        zzbjo.put(8, zzuf.CODABAR);
        zzbjo.put(16, zzuf.DATA_MATRIX);
        zzbjo.put(32, zzuf.EAN_13);
        zzbjo.put(64, zzuf.EAN_8);
        zzbjo.put(128, zzuf.ITF);
        zzbjo.put(256, zzuf.QR_CODE);
        zzbjo.put(512, zzuf.UPC_A);
        zzbjo.put(1024, zzuf.UPC_E);
        zzbjo.put(2048, zzuf.PDF417);
        zzbjo.put(4096, zzuf.AZTEC);
    }
}
