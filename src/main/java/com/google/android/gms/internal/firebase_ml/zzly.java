package com.google.android.gms.internal.firebase_ml;

import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public final class zzly {
    private final String className;
    private final zzlx zzagu;
    private zzlx zzagv;
    private boolean zzagw;

    private zzly(String str) {
        zzlx zzlx = new zzlx();
        this.zzagu = zzlx;
        this.zzagv = zzlx;
        this.zzagw = false;
        this.className = (String) zzmf.checkNotNull(str);
    }

    public final zzly zzh(String str, @NullableDecl Object obj) {
        return zzi(str, obj);
    }

    public final zzly zza(String str, boolean z) {
        return zzi(str, String.valueOf(z));
    }

    public final zzly zza(String str, float f) {
        return zzi(str, String.valueOf(f));
    }

    public final zzly zzb(String str, int i) {
        return zzi(str, String.valueOf(i));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.StringBuilder.append(java.lang.CharSequence, int, int):java.lang.StringBuilder}
     arg types: [java.lang.String, int, int]
     candidates:
      ClspMth{java.lang.StringBuilder.append(java.lang.CharSequence, int, int):java.lang.Appendable throws java.io.IOException}
      ClspMth{java.lang.StringBuilder.append(char[], int, int):java.lang.StringBuilder}
      ClspMth{java.lang.Appendable.append(java.lang.CharSequence, int, int):java.lang.Appendable throws java.io.IOException}
      ClspMth{java.lang.StringBuilder.append(java.lang.CharSequence, int, int):java.lang.StringBuilder} */
    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.className);
        sb.append('{');
        zzlx zzlx = this.zzagu.zzagt;
        String str = "";
        while (zzlx != null) {
            Object obj = zzlx.value;
            sb.append(str);
            if (zzlx.name != null) {
                sb.append(zzlx.name);
                sb.append('=');
            }
            if (obj == null || !obj.getClass().isArray()) {
                sb.append(obj);
            } else {
                String deepToString = Arrays.deepToString(new Object[]{obj});
                sb.append((CharSequence) deepToString, 1, deepToString.length() - 1);
            }
            zzlx = zzlx.zzagt;
            str = ", ";
        }
        sb.append('}');
        return sb.toString();
    }

    private final zzly zzi(String str, @NullableDecl Object obj) {
        zzlx zzlx = new zzlx();
        this.zzagv.zzagt = zzlx;
        this.zzagv = zzlx;
        zzlx.value = obj;
        zzlx.name = (String) zzmf.checkNotNull(str);
        return this;
    }
}
