package com.google.android.gms.internal.firebase_ml;

import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.IOException;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public class zzgb<T> extends zziy {
    private final zzfz zzyo;
    private final String zzyp;
    private final String zzyq;
    private final zzgp zzyr;
    private zzgt zzys = new zzgt();
    private zzgt zzyt;
    private int zzyu = -1;
    private String zzyv;
    private Class<T> zzyw;

    protected zzgb(zzfz zzfz, String str, String str2, zzgp zzgp, Class<T> cls) {
        this.zzyw = (Class) zzmf.checkNotNull(cls);
        this.zzyo = (zzfz) zzmf.checkNotNull(zzfz);
        this.zzyp = (String) zzmf.checkNotNull(str);
        this.zzyq = (String) zzmf.checkNotNull(str2);
        this.zzyr = zzgp;
        String zzfe = zzfz.zzfe();
        if (zzfe != null) {
            zzgt zzgt = this.zzys;
            StringBuilder sb = new StringBuilder(String.valueOf(zzfe).length() + 23);
            sb.append(zzfe);
            sb.append(" Google-API-Java-Client");
            zzgt.zzad(sb.toString());
        } else {
            this.zzys.zzad("Google-API-Java-Client");
        }
        zzgt zzgt2 = (zzgt) this.zzys.zzb("X-Goog-Api-Client", zzgd.zzfk().zzn(zzfz.getClass().getSimpleName()));
    }

    public zzfz zzfh() {
        return this.zzyo;
    }

    public final zzgt zzfi() {
        return this.zzys;
    }

    /* access modifiers changed from: protected */
    public IOException zzb(zzgz zzgz) {
        return new zzgy(zzgz);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.firebase_ml.zzhe.zza(java.lang.String, java.lang.String, java.lang.Object, boolean):java.lang.String
     arg types: [java.lang.String, java.lang.String, com.google.android.gms.internal.firebase_ml.zzgb, int]
     candidates:
      com.google.android.gms.internal.firebase_ml.zzhe.zza(java.lang.String, java.util.Iterator<?>, boolean, com.google.android.gms.internal.firebase_ml.zzhh):java.lang.String
      com.google.android.gms.internal.firebase_ml.zzhe.zza(java.lang.String, java.lang.String, java.lang.Object, boolean):java.lang.String */
    public final T zzfj() throws IOException {
        zzmf.checkArgument(true);
        zzmf.checkArgument(true);
        zzgu zza = zzfh().zzff().zza(this.zzyp, new zzgm(zzhe.zza(this.zzyo.zzfd(), this.zzyq, (Object) this, true)), this.zzyr);
        new zzfx().zzb(zza);
        zza.zza(zzfh().zzfg());
        if (this.zzyr == null && (this.zzyp.equals(HttpRequest.METHOD_POST) || this.zzyp.equals(HttpRequest.METHOD_PUT) || this.zzyp.equals("PATCH"))) {
            zza.zza(new zzgl());
        }
        zza.zzfw().putAll(this.zzys);
        zza.zza(new zzgk());
        zza.zza(new zzga(this, zza.zzfy(), zza));
        zzgz zzgb = zza.zzgb();
        this.zzyt = zzgb.zzfw();
        this.zzyu = zzgb.getStatusCode();
        this.zzyv = zzgb.getStatusMessage();
        return zzgb.zza(this.zzyw);
    }

    /* renamed from: zzc */
    public zzgb<T> zzb(String str, Object obj) {
        return (zzgb) super.zzb(str, obj);
    }
}
