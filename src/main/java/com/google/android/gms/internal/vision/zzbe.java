package com.google.android.gms.internal.vision;

import android.content.ContentResolver;
import android.content.Context;
import android.util.Log;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
public abstract class zzbe<T> {
    private static Context zze = null;
    private static final Object zzfy = new Object();
    private static boolean zzfz = false;
    private static zzcu<zzcn<zzba>> zzga;
    private static final AtomicInteger zzgd = new AtomicInteger();
    private final String name;
    private final zzbk zzgb;
    private final T zzgc;
    private volatile int zzge;
    private volatile T zzgf;

    public static void init(Context context) {
        synchronized (zzfy) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            if (zze != context) {
                zzaq.zzx();
                zzbj.zzx();
                zzav.zzaa();
                zzgd.incrementAndGet();
                zze = context;
                zzga = zzcx.zza(zzbd.zzfx);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public abstract T zza(Object obj);

    public static void maybeInit(Context context) {
        synchronized (zzfy) {
            if (zze == null) {
                init(context);
            }
        }
    }

    static void zzab() {
        zzgd.incrementAndGet();
    }

    private zzbe(zzbk zzbk, String str, T t) {
        this.zzge = -1;
        if (zzbk.zzgk == null && zzbk.zzgl == null) {
            throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
        } else if (zzbk.zzgk == null || zzbk.zzgl == null) {
            this.zzgb = zzbk;
            this.name = str;
            this.zzgc = t;
        } else {
            throw new IllegalArgumentException("Must pass one of SharedPreferences file name or ContentProvider URI");
        }
    }

    private final String zze(String str) {
        if (str != null && str.isEmpty()) {
            return this.name;
        }
        String valueOf = String.valueOf(str);
        String valueOf2 = String.valueOf(this.name);
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    public final String zzac() {
        return zze(this.zzgb.zzgn);
    }

    public final T get() {
        T t;
        int i = zzgd.get();
        if (this.zzge < i) {
            synchronized (this) {
                if (this.zzge < i) {
                    if (zze != null) {
                        zzcn zzcn = zzga.get();
                        if (zzcn.isPresent()) {
                            String zza = ((zzba) zzcn.get()).zza(this.zzgb.zzgl, this.zzgb.zzgk, this.zzgb.zzgn, this.name);
                            if (zza != null) {
                                t = zza(zza);
                                this.zzgf = t;
                                this.zzge = i;
                            }
                        } else if (this.zzgb.zzgp) {
                            t = zzae();
                            if (t == null) {
                                t = zzad();
                                if (t != null) {
                                }
                            }
                            this.zzgf = t;
                            this.zzge = i;
                        } else {
                            t = zzad();
                            if (t == null) {
                                t = zzae();
                                if (t != null) {
                                }
                            }
                            this.zzgf = t;
                            this.zzge = i;
                        }
                        t = this.zzgc;
                        this.zzgf = t;
                        this.zzge = i;
                    } else {
                        throw new IllegalStateException("Must call PhenotypeFlag.init() first");
                    }
                }
            }
        }
        return this.zzgf;
    }

    @Nullable
    private final T zzad() {
        zzau zzau;
        Object zzb;
        boolean z = false;
        if (!this.zzgb.zzgq) {
            String str = (String) zzav.zze(zze).zzb("gms:phenotype:phenotype_flag:debug_bypass_phenotype");
            if (str != null && zzal.zzeu.matcher(str).matches()) {
                z = true;
            }
        }
        if (!z) {
            if (this.zzgb.zzgl == null) {
                zzau = zzbj.zzb(zze, this.zzgb.zzgk);
            } else if (!zzbc.zza(zze, this.zzgb.zzgl)) {
                zzau = null;
            } else if (this.zzgb.zzgr) {
                ContentResolver contentResolver = zze.getContentResolver();
                String lastPathSegment = this.zzgb.zzgl.getLastPathSegment();
                String packageName = zze.getPackageName();
                StringBuilder sb = new StringBuilder(String.valueOf(lastPathSegment).length() + 1 + String.valueOf(packageName).length());
                sb.append(lastPathSegment);
                sb.append("#");
                sb.append(packageName);
                zzau = zzaq.zza(contentResolver, zzbb.getContentProviderUri(sb.toString()));
            } else {
                zzau = zzaq.zza(zze.getContentResolver(), this.zzgb.zzgl);
            }
            if (!(zzau == null || (zzb = zzau.zzb(zzac())) == null)) {
                return zza(zzb);
            }
        } else if (Log.isLoggable("PhenotypeFlag", 3)) {
            String valueOf = String.valueOf(zzac());
            Log.d("PhenotypeFlag", valueOf.length() != 0 ? "Bypass reading Phenotype values for flag: ".concat(valueOf) : new String("Bypass reading Phenotype values for flag: "));
        }
        return null;
    }

    @Nullable
    private final T zzae() {
        if (!this.zzgb.zzgo && (this.zzgb.zzgs == null || this.zzgb.zzgs.apply(zze).booleanValue())) {
            Object zzb = zzav.zze(zze).zzb(this.zzgb.zzgo ? null : zze(this.zzgb.zzgm));
            if (zzb != null) {
                return zza(zzb);
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static zzbe<Boolean> zza(zzbk zzbk, String str, boolean z) {
        return new zzbf(zzbk, str, Boolean.valueOf(z));
    }

    /* access modifiers changed from: private */
    public static <T> zzbe<T> zza(zzbk zzbk, String str, T t, zzbh<T> zzbh) {
        return new zzbi(zzbk, str, t, zzbh);
    }

    static final /* synthetic */ zzcn zzaf() {
        new zzaz();
        return zzaz.zzf(zze);
    }

    /* synthetic */ zzbe(zzbk zzbk, String str, Object obj, zzbg zzbg) {
        this(zzbk, str, obj);
    }
}
