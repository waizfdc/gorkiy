package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import androidx.work.WorkRequest;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzbo;
import com.google.android.gms.internal.measurement.zzbr;
import com.google.android.gms.internal.measurement.zzfd;
import com.google.android.gms.internal.measurement.zzkn;
import com.google.android.gms.internal.measurement.zzky;
import com.google.android.gms.internal.measurement.zzll;
import com.google.android.gms.internal.measurement.zzv;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.jvm.internal.LongCompanionObject;
import kotlinx.coroutines.DebugKt;

/* compiled from: com.google.android.gms:play-services-measurement@@17.2.3 */
public class zzks implements zzhh {
    private static volatile zzks zza;
    private zzgi zzb;
    private zzfo zzc;
    private zzac zzd;
    private zzfr zze;
    private zzko zzf;
    private zzn zzg;
    private final zzkw zzh;
    private zzir zzi;
    private final zzgo zzj;
    private boolean zzk;
    private boolean zzl;
    private long zzm;
    private List<Runnable> zzn;
    private int zzo;
    private int zzp;
    private boolean zzq;
    private boolean zzr;
    private boolean zzs;
    private FileLock zzt;
    private FileChannel zzu;
    private List<Long> zzv;
    private List<Long> zzw;
    private long zzx;

    /* compiled from: com.google.android.gms:play-services-measurement@@17.2.3 */
    class zza implements zzae {
        zzbr.zzg zza;
        List<Long> zzb;
        List<zzbr.zzc> zzc;
        private long zzd;

        private zza() {
        }

        public final void zza(zzbr.zzg zzg) {
            Preconditions.checkNotNull(zzg);
            this.zza = zzg;
        }

        public final boolean zza(long j, zzbr.zzc zzc2) {
            Preconditions.checkNotNull(zzc2);
            if (this.zzc == null) {
                this.zzc = new ArrayList();
            }
            if (this.zzb == null) {
                this.zzb = new ArrayList();
            }
            if (this.zzc.size() > 0 && zza(this.zzc.get(0)) != zza(zzc2)) {
                return false;
            }
            long zzbn = this.zzd + ((long) zzc2.zzbn());
            if (zzbn >= ((long) Math.max(0, zzap.zzh.zza(null).intValue()))) {
                return false;
            }
            this.zzd = zzbn;
            this.zzc.add(zzc2);
            this.zzb.add(Long.valueOf(j));
            if (this.zzc.size() >= Math.max(1, zzap.zzi.zza(null).intValue())) {
                return false;
            }
            return true;
        }

        private static long zza(zzbr.zzc zzc2) {
            return ((zzc2.zze() / 1000) / 60) / 60;
        }

        /* synthetic */ zza(zzks zzks, zzkr zzkr) {
            this();
        }
    }

    public static zzks zza(Context context) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zza == null) {
            synchronized (zzks.class) {
                if (zza == null) {
                    zza = new zzks(new zzkx(context));
                }
            }
        }
        return zza;
    }

    private zzks(zzkx zzkx) {
        this(zzkx, null);
    }

    private zzks(zzkx zzkx, zzgo zzgo) {
        this.zzk = false;
        Preconditions.checkNotNull(zzkx);
        this.zzj = zzgo.zza(zzkx.zza, (zzv) null);
        this.zzx = -1;
        zzkw zzkw = new zzkw(this);
        zzkw.zzal();
        this.zzh = zzkw;
        zzfo zzfo = new zzfo(this);
        zzfo.zzal();
        this.zzc = zzfo;
        zzgi zzgi = new zzgi(this);
        zzgi.zzal();
        this.zzb = zzgi;
        this.zzj.zzq().zza(new zzkr(this, zzkx));
    }

    /* access modifiers changed from: private */
    public final void zza(zzkx zzkx) {
        this.zzj.zzq().zzd();
        zzac zzac = new zzac(this);
        zzac.zzal();
        this.zzd = zzac;
        this.zzj.zzb().zza(this.zzb);
        zzn zzn2 = new zzn(this);
        zzn2.zzal();
        this.zzg = zzn2;
        zzir zzir = new zzir(this);
        zzir.zzal();
        this.zzi = zzir;
        zzko zzko = new zzko(this);
        zzko.zzal();
        this.zzf = zzko;
        this.zze = new zzfr(this);
        if (this.zzo != this.zzp) {
            this.zzj.zzr().zzf().zza("Not all upload components initialized", Integer.valueOf(this.zzo), Integer.valueOf(this.zzp));
        }
        this.zzk = true;
    }

    /* access modifiers changed from: protected */
    public final void zza() {
        this.zzj.zzq().zzd();
        zze().zzv();
        if (this.zzj.zzc().zzc.zza() == 0) {
            this.zzj.zzc().zzc.zza(this.zzj.zzm().currentTimeMillis());
        }
        zzz();
    }

    public final zzw zzu() {
        return this.zzj.zzu();
    }

    public final zzx zzb() {
        return this.zzj.zzb();
    }

    public final zzfk zzr() {
        return this.zzj.zzr();
    }

    public final zzgh zzq() {
        return this.zzj.zzq();
    }

    public final zzgi zzc() {
        zzb(this.zzb);
        return this.zzb;
    }

    public final zzfo zzd() {
        zzb(this.zzc);
        return this.zzc;
    }

    public final zzac zze() {
        zzb(this.zzd);
        return this.zzd;
    }

    private final zzfr zzt() {
        zzfr zzfr = this.zze;
        if (zzfr != null) {
            return zzfr;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    private final zzko zzv() {
        zzb(this.zzf);
        return this.zzf;
    }

    public final zzn zzf() {
        zzb(this.zzg);
        return this.zzg;
    }

    public final zzir zzg() {
        zzb(this.zzi);
        return this.zzi;
    }

    public final zzkw zzh() {
        zzb(this.zzh);
        return this.zzh;
    }

    public final zzfi zzi() {
        return this.zzj.zzj();
    }

    public final Context zzn() {
        return this.zzj.zzn();
    }

    public final Clock zzm() {
        return this.zzj.zzm();
    }

    public final zzla zzj() {
        return this.zzj.zzi();
    }

    private final void zzw() {
        this.zzj.zzq().zzd();
    }

    /* access modifiers changed from: package-private */
    public final void zzk() {
        if (!this.zzk) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    private static void zzb(zzkp zzkp) {
        if (zzkp == null) {
            throw new IllegalStateException("Upload Component not created");
        } else if (!zzkp.zzaj()) {
            String valueOf = String.valueOf(zzkp.getClass());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
            sb.append("Component not initialized: ");
            sb.append(valueOf);
            throw new IllegalStateException(sb.toString());
        }
    }

    private final long zzx() {
        long currentTimeMillis = this.zzj.zzm().currentTimeMillis();
        zzft zzc2 = this.zzj.zzc();
        zzc2.zzaa();
        zzc2.zzd();
        long zza2 = zzc2.zzg.zza();
        if (zza2 == 0) {
            zza2 = 1 + ((long) zzc2.zzp().zzh().nextInt(86400000));
            zzc2.zzg.zza(zza2);
        }
        return ((((currentTimeMillis + zza2) / 1000) / 60) / 60) / 24;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.measurement.internal.zzm.<init>(java.lang.String, java.lang.String, java.lang.String, long, java.lang.String, long, long, java.lang.String, boolean, boolean, java.lang.String, long, long, int, boolean, boolean, boolean, java.lang.String, java.lang.Boolean, long, java.util.List<java.lang.String>, java.lang.String):void
     arg types: [java.lang.String, java.lang.String, java.lang.String, long, java.lang.String, long, long, ?[OBJECT, ARRAY], boolean, int, java.lang.String, long, int, int, boolean, boolean, int, java.lang.String, java.lang.Boolean, long, java.util.List<java.lang.String>, java.lang.String]
     candidates:
      com.google.android.gms.measurement.internal.zzm.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, long, long, java.lang.String, boolean, boolean, long, java.lang.String, long, long, int, boolean, boolean, boolean, java.lang.String, java.lang.Boolean, long, java.util.List<java.lang.String>, java.lang.String):void
      com.google.android.gms.measurement.internal.zzm.<init>(java.lang.String, java.lang.String, java.lang.String, long, java.lang.String, long, long, java.lang.String, boolean, boolean, java.lang.String, long, long, int, boolean, boolean, boolean, java.lang.String, java.lang.Boolean, long, java.util.List<java.lang.String>, java.lang.String):void */
    /* access modifiers changed from: package-private */
    public final void zza(zzan zzan, String str) {
        zzan zzan2 = zzan;
        zzg zzb2 = zze().zzb(str);
        if (zzb2 == null || TextUtils.isEmpty(zzb2.zzl())) {
            this.zzj.zzr().zzw().zza("No app data available; dropping event", str);
            return;
        }
        Boolean zzb3 = zzb(zzb2);
        if (zzb3 == null) {
            if (!"_ui".equals(zzan2.zza)) {
                this.zzj.zzr().zzi().zza("Could not find package. appId", zzfk.zza(str));
            }
        } else if (!zzb3.booleanValue()) {
            this.zzj.zzr().zzf().zza("App version does not match; dropping event. appId", zzfk.zza(str));
            return;
        }
        zzm zzm2 = r2;
        zzm zzm3 = new zzm(str, zzb2.zze(), zzb2.zzl(), zzb2.zzm(), zzb2.zzn(), zzb2.zzo(), zzb2.zzp(), (String) null, zzb2.zzr(), false, zzb2.zzi(), zzb2.zzae(), 0L, 0, zzb2.zzaf(), zzb2.zzag(), false, zzb2.zzf(), zzb2.zzah(), zzb2.zzq(), zzb2.zzai(), (!zzll.zzb() || !this.zzj.zzb().zze(zzb2.zzc(), zzap.zzch)) ? null : zzb2.zzg());
        zza(zzan2, zzm2);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x013b A[Catch:{ all -> 0x038a }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0216 A[Catch:{ all -> 0x038a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.measurement.internal.zzan r20, com.google.android.gms.measurement.internal.zzm r21) {
        /*
            r19 = this;
            r1 = r19
            r0 = r20
            r2 = r21
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r21)
            java.lang.String r3 = r2.zza
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)
            r19.zzw()
            r19.zzk()
            java.lang.String r3 = r2.zza
            long r11 = r0.zzd
            com.google.android.gms.measurement.internal.zzkw r4 = r19.zzh()
            boolean r4 = r4.zza(r0, r2)
            if (r4 != 0) goto L_0x0023
            return
        L_0x0023:
            boolean r4 = r2.zzh
            if (r4 != 0) goto L_0x002b
            r1.zzc(r2)
            return
        L_0x002b:
            com.google.android.gms.measurement.internal.zzgo r4 = r1.zzj
            com.google.android.gms.measurement.internal.zzx r4 = r4.zzb()
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r5 = com.google.android.gms.measurement.internal.zzap.zzbl
            boolean r4 = r4.zze(r3, r5)
            if (r4 == 0) goto L_0x007f
            java.util.List<java.lang.String> r4 = r2.zzu
            if (r4 == 0) goto L_0x007f
            java.util.List<java.lang.String> r4 = r2.zzu
            java.lang.String r5 = r0.zza
            boolean r4 = r4.contains(r5)
            if (r4 == 0) goto L_0x006b
            com.google.android.gms.measurement.internal.zzam r4 = r0.zzb
            android.os.Bundle r4 = r4.zzb()
            r5 = 1
            java.lang.String r7 = "ga_safelisted"
            r4.putLong(r7, r5)
            com.google.android.gms.measurement.internal.zzan r5 = new com.google.android.gms.measurement.internal.zzan
            java.lang.String r14 = r0.zza
            com.google.android.gms.measurement.internal.zzam r15 = new com.google.android.gms.measurement.internal.zzam
            r15.<init>(r4)
            java.lang.String r4 = r0.zzc
            long r6 = r0.zzd
            r13 = r5
            r16 = r4
            r17 = r6
            r13.<init>(r14, r15, r16, r17)
            r0 = r5
            goto L_0x007f
        L_0x006b:
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj
            com.google.android.gms.measurement.internal.zzfk r2 = r2.zzr()
            com.google.android.gms.measurement.internal.zzfm r2 = r2.zzw()
            java.lang.String r4 = r0.zza
            java.lang.String r0 = r0.zzc
            java.lang.String r5 = "Dropping non-safelisted event. appId, event name, origin"
            r2.zza(r5, r3, r4, r0)
            return
        L_0x007f:
            com.google.android.gms.measurement.internal.zzac r4 = r19.zze()
            r4.zzf()
            com.google.android.gms.measurement.internal.zzac r4 = r19.zze()     // Catch:{ all -> 0x038a }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)     // Catch:{ all -> 0x038a }
            r4.zzd()     // Catch:{ all -> 0x038a }
            r4.zzak()     // Catch:{ all -> 0x038a }
            r5 = 0
            int r5 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
            r6 = 2
            r13 = 0
            r14 = 1
            if (r5 >= 0) goto L_0x00b6
            com.google.android.gms.measurement.internal.zzfk r4 = r4.zzr()     // Catch:{ all -> 0x038a }
            com.google.android.gms.measurement.internal.zzfm r4 = r4.zzi()     // Catch:{ all -> 0x038a }
            java.lang.String r7 = "Invalid time querying timed out conditional properties"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzfk.zza(r3)     // Catch:{ all -> 0x038a }
            java.lang.Long r9 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x038a }
            r4.zza(r7, r8, r9)     // Catch:{ all -> 0x038a }
            java.util.List r4 = java.util.Collections.emptyList()     // Catch:{ all -> 0x038a }
            goto L_0x00c6
        L_0x00b6:
            java.lang.String r7 = "active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout"
            java.lang.String[] r8 = new java.lang.String[r6]     // Catch:{ all -> 0x038a }
            r8[r13] = r3     // Catch:{ all -> 0x038a }
            java.lang.String r9 = java.lang.String.valueOf(r11)     // Catch:{ all -> 0x038a }
            r8[r14] = r9     // Catch:{ all -> 0x038a }
            java.util.List r4 = r4.zza(r7, r8)     // Catch:{ all -> 0x038a }
        L_0x00c6:
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x038a }
        L_0x00ca:
            boolean r7 = r4.hasNext()     // Catch:{ all -> 0x038a }
            if (r7 == 0) goto L_0x0153
            java.lang.Object r7 = r4.next()     // Catch:{ all -> 0x038a }
            com.google.android.gms.measurement.internal.zzv r7 = (com.google.android.gms.measurement.internal.zzv) r7     // Catch:{ all -> 0x038a }
            if (r7 == 0) goto L_0x00ca
            boolean r8 = com.google.android.gms.internal.measurement.zzky.zzb()     // Catch:{ all -> 0x038a }
            java.lang.String r9 = "User property timed out"
            if (r8 == 0) goto L_0x0114
            com.google.android.gms.measurement.internal.zzgo r8 = r1.zzj     // Catch:{ all -> 0x038a }
            com.google.android.gms.measurement.internal.zzx r8 = r8.zzb()     // Catch:{ all -> 0x038a }
            java.lang.String r10 = r2.zza     // Catch:{ all -> 0x038a }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r15 = com.google.android.gms.measurement.internal.zzap.zzcz     // Catch:{ all -> 0x038a }
            boolean r8 = r8.zze(r10, r15)     // Catch:{ all -> 0x038a }
            if (r8 == 0) goto L_0x0114
            com.google.android.gms.measurement.internal.zzgo r8 = r1.zzj     // Catch:{ all -> 0x038a }
            com.google.android.gms.measurement.internal.zzfk r8 = r8.zzr()     // Catch:{ all -> 0x038a }
            com.google.android.gms.measurement.internal.zzfm r8 = r8.zzx()     // Catch:{ all -> 0x038a }
            java.lang.String r10 = r7.zza     // Catch:{ all -> 0x038a }
            com.google.android.gms.measurement.internal.zzgo r15 = r1.zzj     // Catch:{ all -> 0x038a }
            com.google.android.gms.measurement.internal.zzfi r15 = r15.zzj()     // Catch:{ all -> 0x038a }
            com.google.android.gms.measurement.internal.zzkz r14 = r7.zzc     // Catch:{ all -> 0x038a }
            java.lang.String r14 = r14.zza     // Catch:{ all -> 0x038a }
            java.lang.String r14 = r15.zzc(r14)     // Catch:{ all -> 0x038a }
            com.google.android.gms.measurement.internal.zzkz r15 = r7.zzc     // Catch:{ all -> 0x038a }
            java.lang.Object r15 = r15.zza()     // Catch:{ all -> 0x038a }
            r8.zza(r9, r10, r14, r15)     // Catch:{ all -> 0x038a }
            goto L_0x0137
        L_0x0114:
            com.google.android.gms.measurement.internal.zzgo r8 = r1.zzj     // Catch:{ all -> 0x038a }
            com.google.android.gms.measurement.internal.zzfk r8 = r8.zzr()     // Catch:{ all -> 0x038a }
            com.google.android.gms.measurement.internal.zzfm r8 = r8.zzw()     // Catch:{ all -> 0x038a }
            java.lang.String r10 = r7.zza     // Catch:{ all -> 0x038a }
            com.google.android.gms.measurement.internal.zzgo r14 = r1.zzj     // Catch:{ all -> 0x038a }
            com.google.android.gms.measurement.internal.zzfi r14 = r14.zzj()     // Catch:{ all -> 0x038a }
            com.google.android.gms.measurement.internal.zzkz r15 = r7.zzc     // Catch:{ all -> 0x038a }
            java.lang.String r15 = r15.zza     // Catch:{ all -> 0x038a }
            java.lang.String r14 = r14.zzc(r15)     // Catch:{ all -> 0x038a }
            com.google.android.gms.measurement.internal.zzkz r15 = r7.zzc     // Catch:{ all -> 0x038a }
            java.lang.Object r15 = r15.zza()     // Catch:{ all -> 0x038a }
            r8.zza(r9, r10, r14, r15)     // Catch:{ all -> 0x038a }
        L_0x0137:
            com.google.android.gms.measurement.internal.zzan r8 = r7.zzg     // Catch:{ all -> 0x038a }
            if (r8 == 0) goto L_0x0145
            com.google.android.gms.measurement.internal.zzan r8 = new com.google.android.gms.measurement.internal.zzan     // Catch:{ all -> 0x038a }
            com.google.android.gms.measurement.internal.zzan r9 = r7.zzg     // Catch:{ all -> 0x038a }
            r8.<init>(r9, r11)     // Catch:{ all -> 0x038a }
            r1.zzb(r8, r2)     // Catch:{ all -> 0x038a }
        L_0x0145:
            com.google.android.gms.measurement.internal.zzac r8 = r19.zze()     // Catch:{ all -> 0x038a }
            com.google.android.gms.measurement.internal.zzkz r7 = r7.zzc     // Catch:{ all -> 0x038a }
            java.lang.String r7 = r7.zza     // Catch:{ all -> 0x038a }
            r8.zze(r3, r7)     // Catch:{ all -> 0x038a }
            r14 = 1
            goto L_0x00ca
        L_0x0153:
            com.google.android.gms.measurement.internal.zzac r4 = r19.zze()     // Catch:{ all -> 0x038a }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)     // Catch:{ all -> 0x038a }
            r4.zzd()     // Catch:{ all -> 0x038a }
            r4.zzak()     // Catch:{ all -> 0x038a }
            if (r5 >= 0) goto L_0x017c
            com.google.android.gms.measurement.internal.zzfk r4 = r4.zzr()     // Catch:{ all -> 0x038a }
            com.google.android.gms.measurement.internal.zzfm r4 = r4.zzi()     // Catch:{ all -> 0x038a }
            java.lang.String r7 = "Invalid time querying expired conditional properties"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzfk.zza(r3)     // Catch:{ all -> 0x038a }
            java.lang.Long r9 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x038a }
            r4.zza(r7, r8, r9)     // Catch:{ all -> 0x038a }
            java.util.List r4 = java.util.Collections.emptyList()     // Catch:{ all -> 0x038a }
            goto L_0x018d
        L_0x017c:
            java.lang.String r7 = "active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live"
            java.lang.String[] r8 = new java.lang.String[r6]     // Catch:{ all -> 0x038a }
            r8[r13] = r3     // Catch:{ all -> 0x038a }
            java.lang.String r9 = java.lang.String.valueOf(r11)     // Catch:{ all -> 0x038a }
            r10 = 1
            r8[r10] = r9     // Catch:{ all -> 0x038a }
            java.util.List r4 = r4.zza(r7, r8)     // Catch:{ all -> 0x038a }
        L_0x018d:
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ all -> 0x038a }
            int r8 = r4.size()     // Catch:{ all -> 0x038a }
            r7.<init>(r8)     // Catch:{ all -> 0x038a }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x038a }
        L_0x019a:
            boolean r8 = r4.hasNext()     // Catch:{ all -> 0x038a }
            if (r8 == 0) goto L_0x0229
            java.lang.Object r8 = r4.next()     // Catch:{ all -> 0x038a }
            com.google.android.gms.measurement.internal.zzv r8 = (com.google.android.gms.measurement.internal.zzv) r8     // Catch:{ all -> 0x038a }
            if (r8 == 0) goto L_0x019a
            boolean r9 = com.google.android.gms.internal.measurement.zzky.zzb()     // Catch:{ all -> 0x038a }
            java.lang.String r10 = "User property expired"
            if (r9 == 0) goto L_0x01e4
            com.google.android.gms.measurement.internal.zzgo r9 = r1.zzj     // Catch:{ all -> 0x038a }
            com.google.android.gms.measurement.internal.zzx r9 = r9.zzb()     // Catch:{ all -> 0x038a }
            java.lang.String r14 = r2.zza     // Catch:{ all -> 0x038a }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r15 = com.google.android.gms.measurement.internal.zzap.zzcz     // Catch:{ all -> 0x038a }
            boolean r9 = r9.zze(r14, r15)     // Catch:{ all -> 0x038a }
            if (r9 == 0) goto L_0x01e4
            com.google.android.gms.measurement.internal.zzgo r9 = r1.zzj     // Catch:{ all -> 0x038a }
            com.google.android.gms.measurement.internal.zzfk r9 = r9.zzr()     // Catch:{ all -> 0x038a }
            com.google.android.gms.measurement.internal.zzfm r9 = r9.zzx()     // Catch:{ all -> 0x038a }
            java.lang.String r14 = r8.zza     // Catch:{ all -> 0x038a }
            com.google.android.gms.measurement.internal.zzgo r15 = r1.zzj     // Catch:{ all -> 0x038a }
            com.google.android.gms.measurement.internal.zzfi r15 = r15.zzj()     // Catch:{ all -> 0x038a }
            com.google.android.gms.measurement.internal.zzkz r6 = r8.zzc     // Catch:{ all -> 0x038a }
            java.lang.String r6 = r6.zza     // Catch:{ all -> 0x038a }
            java.lang.String r6 = r15.zzc(r6)     // Catch:{ all -> 0x038a }
            com.google.android.gms.measurement.internal.zzkz r15 = r8.zzc     // Catch:{ all -> 0x038a }
            java.lang.Object r15 = r15.zza()     // Catch:{ all -> 0x038a }
            r9.zza(r10, r14, r6, r15)     // Catch:{ all -> 0x038a }
            goto L_0x0207
        L_0x01e4:
            com.google.android.gms.measurement.internal.zzgo r6 = r1.zzj     // Catch:{ all -> 0x038a }
            com.google.android.gms.measurement.internal.zzfk r6 = r6.zzr()     // Catch:{ all -> 0x038a }
            com.google.android.gms.measurement.internal.zzfm r6 = r6.zzw()     // Catch:{ all -> 0x038a }
            java.lang.String r9 = r8.zza     // Catch:{ all -> 0x038a }
            com.google.android.gms.measurement.internal.zzgo r14 = r1.zzj     // Catch:{ all -> 0x038a }
            com.google.android.gms.measurement.internal.zzfi r14 = r14.zzj()     // Catch:{ all -> 0x038a }
            com.google.android.gms.measurement.internal.zzkz r15 = r8.zzc     // Catch:{ all -> 0x038a }
            java.lang.String r15 = r15.zza     // Catch:{ all -> 0x038a }
            java.lang.String r14 = r14.zzc(r15)     // Catch:{ all -> 0x038a }
            com.google.android.gms.measurement.internal.zzkz r15 = r8.zzc     // Catch:{ all -> 0x038a }
            java.lang.Object r15 = r15.zza()     // Catch:{ all -> 0x038a }
            r6.zza(r10, r9, r14, r15)     // Catch:{ all -> 0x038a }
        L_0x0207:
            com.google.android.gms.measurement.internal.zzac r6 = r19.zze()     // Catch:{ all -> 0x038a }
            com.google.android.gms.measurement.internal.zzkz r9 = r8.zzc     // Catch:{ all -> 0x038a }
            java.lang.String r9 = r9.zza     // Catch:{ all -> 0x038a }
            r6.zzb(r3, r9)     // Catch:{ all -> 0x038a }
            com.google.android.gms.measurement.internal.zzan r6 = r8.zzk     // Catch:{ all -> 0x038a }
            if (r6 == 0) goto L_0x021b
            com.google.android.gms.measurement.internal.zzan r6 = r8.zzk     // Catch:{ all -> 0x038a }
            r7.add(r6)     // Catch:{ all -> 0x038a }
        L_0x021b:
            com.google.android.gms.measurement.internal.zzac r6 = r19.zze()     // Catch:{ all -> 0x038a }
            com.google.android.gms.measurement.internal.zzkz r8 = r8.zzc     // Catch:{ all -> 0x038a }
            java.lang.String r8 = r8.zza     // Catch:{ all -> 0x038a }
            r6.zze(r3, r8)     // Catch:{ all -> 0x038a }
            r6 = 2
            goto L_0x019a
        L_0x0229:
            java.util.ArrayList r7 = (java.util.ArrayList) r7     // Catch:{ all -> 0x038a }
            int r4 = r7.size()     // Catch:{ all -> 0x038a }
            r6 = r13
        L_0x0230:
            if (r6 >= r4) goto L_0x0243
            java.lang.Object r8 = r7.get(r6)     // Catch:{ all -> 0x038a }
            int r6 = r6 + 1
            com.google.android.gms.measurement.internal.zzan r8 = (com.google.android.gms.measurement.internal.zzan) r8     // Catch:{ all -> 0x038a }
            com.google.android.gms.measurement.internal.zzan r9 = new com.google.android.gms.measurement.internal.zzan     // Catch:{ all -> 0x038a }
            r9.<init>(r8, r11)     // Catch:{ all -> 0x038a }
            r1.zzb(r9, r2)     // Catch:{ all -> 0x038a }
            goto L_0x0230
        L_0x0243:
            com.google.android.gms.measurement.internal.zzac r4 = r19.zze()     // Catch:{ all -> 0x038a }
            java.lang.String r6 = r0.zza     // Catch:{ all -> 0x038a }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)     // Catch:{ all -> 0x038a }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r6)     // Catch:{ all -> 0x038a }
            r4.zzd()     // Catch:{ all -> 0x038a }
            r4.zzak()     // Catch:{ all -> 0x038a }
            if (r5 >= 0) goto L_0x0279
            com.google.android.gms.measurement.internal.zzfk r5 = r4.zzr()     // Catch:{ all -> 0x038a }
            com.google.android.gms.measurement.internal.zzfm r5 = r5.zzi()     // Catch:{ all -> 0x038a }
            java.lang.String r7 = "Invalid time querying triggered conditional properties"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzfk.zza(r3)     // Catch:{ all -> 0x038a }
            com.google.android.gms.measurement.internal.zzfi r4 = r4.zzo()     // Catch:{ all -> 0x038a }
            java.lang.String r4 = r4.zza(r6)     // Catch:{ all -> 0x038a }
            java.lang.Long r6 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x038a }
            r5.zza(r7, r3, r4, r6)     // Catch:{ all -> 0x038a }
            java.util.List r3 = java.util.Collections.emptyList()     // Catch:{ all -> 0x038a }
            goto L_0x028e
        L_0x0279:
            java.lang.String r5 = "active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout"
            r7 = 3
            java.lang.String[] r7 = new java.lang.String[r7]     // Catch:{ all -> 0x038a }
            r7[r13] = r3     // Catch:{ all -> 0x038a }
            r3 = 1
            r7[r3] = r6     // Catch:{ all -> 0x038a }
            java.lang.String r3 = java.lang.String.valueOf(r11)     // Catch:{ all -> 0x038a }
            r6 = 2
            r7[r6] = r3     // Catch:{ all -> 0x038a }
            java.util.List r3 = r4.zza(r5, r7)     // Catch:{ all -> 0x038a }
        L_0x028e:
            java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ all -> 0x038a }
            int r4 = r3.size()     // Catch:{ all -> 0x038a }
            r14.<init>(r4)     // Catch:{ all -> 0x038a }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x038a }
        L_0x029b:
            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x038a }
            if (r4 == 0) goto L_0x035e
            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x038a }
            r15 = r4
            com.google.android.gms.measurement.internal.zzv r15 = (com.google.android.gms.measurement.internal.zzv) r15     // Catch:{ all -> 0x038a }
            if (r15 == 0) goto L_0x029b
            com.google.android.gms.measurement.internal.zzkz r4 = r15.zzc     // Catch:{ all -> 0x038a }
            com.google.android.gms.measurement.internal.zzlb r10 = new com.google.android.gms.measurement.internal.zzlb     // Catch:{ all -> 0x038a }
            java.lang.String r5 = r15.zza     // Catch:{ all -> 0x038a }
            java.lang.String r6 = r15.zzb     // Catch:{ all -> 0x038a }
            java.lang.String r7 = r4.zza     // Catch:{ all -> 0x038a }
            java.lang.Object r16 = r4.zza()     // Catch:{ all -> 0x038a }
            r4 = r10
            r8 = r11
            r13 = r10
            r10 = r16
            r4.<init>(r5, r6, r7, r8, r10)     // Catch:{ all -> 0x038a }
            com.google.android.gms.measurement.internal.zzac r4 = r19.zze()     // Catch:{ all -> 0x038a }
            boolean r4 = r4.zza(r13)     // Catch:{ all -> 0x038a }
            if (r4 == 0) goto L_0x031e
            boolean r4 = com.google.android.gms.internal.measurement.zzky.zzb()     // Catch:{ all -> 0x038a }
            java.lang.String r5 = "User property triggered"
            if (r4 == 0) goto L_0x0300
            com.google.android.gms.measurement.internal.zzgo r4 = r1.zzj     // Catch:{ all -> 0x038a }
            com.google.android.gms.measurement.internal.zzx r4 = r4.zzb()     // Catch:{ all -> 0x038a }
            java.lang.String r6 = r2.zza     // Catch:{ all -> 0x038a }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r7 = com.google.android.gms.measurement.internal.zzap.zzcz     // Catch:{ all -> 0x038a }
            boolean r4 = r4.zze(r6, r7)     // Catch:{ all -> 0x038a }
            if (r4 == 0) goto L_0x0300
            com.google.android.gms.measurement.internal.zzgo r4 = r1.zzj     // Catch:{ all -> 0x038a }
            com.google.android.gms.measurement.internal.zzfk r4 = r4.zzr()     // Catch:{ all -> 0x038a }
            com.google.android.gms.measurement.internal.zzfm r4 = r4.zzx()     // Catch:{ all -> 0x038a }
            java.lang.String r6 = r15.zza     // Catch:{ all -> 0x038a }
            com.google.android.gms.measurement.internal.zzgo r7 = r1.zzj     // Catch:{ all -> 0x038a }
            com.google.android.gms.measurement.internal.zzfi r7 = r7.zzj()     // Catch:{ all -> 0x038a }
            java.lang.String r8 = r13.zzc     // Catch:{ all -> 0x038a }
            java.lang.String r7 = r7.zzc(r8)     // Catch:{ all -> 0x038a }
            java.lang.Object r8 = r13.zze     // Catch:{ all -> 0x038a }
            r4.zza(r5, r6, r7, r8)     // Catch:{ all -> 0x038a }
            goto L_0x0341
        L_0x0300:
            com.google.android.gms.measurement.internal.zzgo r4 = r1.zzj     // Catch:{ all -> 0x038a }
            com.google.android.gms.measurement.internal.zzfk r4 = r4.zzr()     // Catch:{ all -> 0x038a }
            com.google.android.gms.measurement.internal.zzfm r4 = r4.zzw()     // Catch:{ all -> 0x038a }
            java.lang.String r6 = r15.zza     // Catch:{ all -> 0x038a }
            com.google.android.gms.measurement.internal.zzgo r7 = r1.zzj     // Catch:{ all -> 0x038a }
            com.google.android.gms.measurement.internal.zzfi r7 = r7.zzj()     // Catch:{ all -> 0x038a }
            java.lang.String r8 = r13.zzc     // Catch:{ all -> 0x038a }
            java.lang.String r7 = r7.zzc(r8)     // Catch:{ all -> 0x038a }
            java.lang.Object r8 = r13.zze     // Catch:{ all -> 0x038a }
            r4.zza(r5, r6, r7, r8)     // Catch:{ all -> 0x038a }
            goto L_0x0341
        L_0x031e:
            com.google.android.gms.measurement.internal.zzgo r4 = r1.zzj     // Catch:{ all -> 0x038a }
            com.google.android.gms.measurement.internal.zzfk r4 = r4.zzr()     // Catch:{ all -> 0x038a }
            com.google.android.gms.measurement.internal.zzfm r4 = r4.zzf()     // Catch:{ all -> 0x038a }
            java.lang.String r5 = "Too many active user properties, ignoring"
            java.lang.String r6 = r15.zza     // Catch:{ all -> 0x038a }
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzfk.zza(r6)     // Catch:{ all -> 0x038a }
            com.google.android.gms.measurement.internal.zzgo r7 = r1.zzj     // Catch:{ all -> 0x038a }
            com.google.android.gms.measurement.internal.zzfi r7 = r7.zzj()     // Catch:{ all -> 0x038a }
            java.lang.String r8 = r13.zzc     // Catch:{ all -> 0x038a }
            java.lang.String r7 = r7.zzc(r8)     // Catch:{ all -> 0x038a }
            java.lang.Object r8 = r13.zze     // Catch:{ all -> 0x038a }
            r4.zza(r5, r6, r7, r8)     // Catch:{ all -> 0x038a }
        L_0x0341:
            com.google.android.gms.measurement.internal.zzan r4 = r15.zzi     // Catch:{ all -> 0x038a }
            if (r4 == 0) goto L_0x034a
            com.google.android.gms.measurement.internal.zzan r4 = r15.zzi     // Catch:{ all -> 0x038a }
            r14.add(r4)     // Catch:{ all -> 0x038a }
        L_0x034a:
            com.google.android.gms.measurement.internal.zzkz r4 = new com.google.android.gms.measurement.internal.zzkz     // Catch:{ all -> 0x038a }
            r4.<init>(r13)     // Catch:{ all -> 0x038a }
            r15.zzc = r4     // Catch:{ all -> 0x038a }
            r4 = 1
            r15.zze = r4     // Catch:{ all -> 0x038a }
            com.google.android.gms.measurement.internal.zzac r5 = r19.zze()     // Catch:{ all -> 0x038a }
            r5.zza(r15)     // Catch:{ all -> 0x038a }
            r13 = 0
            goto L_0x029b
        L_0x035e:
            r1.zzb(r0, r2)     // Catch:{ all -> 0x038a }
            java.util.ArrayList r14 = (java.util.ArrayList) r14     // Catch:{ all -> 0x038a }
            int r0 = r14.size()     // Catch:{ all -> 0x038a }
            r13 = 0
        L_0x0368:
            if (r13 >= r0) goto L_0x037b
            java.lang.Object r3 = r14.get(r13)     // Catch:{ all -> 0x038a }
            int r13 = r13 + 1
            com.google.android.gms.measurement.internal.zzan r3 = (com.google.android.gms.measurement.internal.zzan) r3     // Catch:{ all -> 0x038a }
            com.google.android.gms.measurement.internal.zzan r4 = new com.google.android.gms.measurement.internal.zzan     // Catch:{ all -> 0x038a }
            r4.<init>(r3, r11)     // Catch:{ all -> 0x038a }
            r1.zzb(r4, r2)     // Catch:{ all -> 0x038a }
            goto L_0x0368
        L_0x037b:
            com.google.android.gms.measurement.internal.zzac r0 = r19.zze()     // Catch:{ all -> 0x038a }
            r0.b_()     // Catch:{ all -> 0x038a }
            com.google.android.gms.measurement.internal.zzac r0 = r19.zze()
            r0.zzh()
            return
        L_0x038a:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzac r2 = r19.zze()
            r2.zzh()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzks.zza(com.google.android.gms.measurement.internal.zzan, com.google.android.gms.measurement.internal.zzm):void");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.measurement.internal.zzla.zza(android.os.Bundle, java.lang.String, java.lang.Object):void
     arg types: [android.os.Bundle, java.lang.String, long]
     candidates:
      com.google.android.gms.measurement.internal.zzla.zza(java.lang.String, int, boolean):java.lang.String
      com.google.android.gms.measurement.internal.zzla.zza(java.lang.String, int, java.lang.String):boolean
      com.google.android.gms.measurement.internal.zzla.zza(java.lang.String, java.lang.String, java.lang.String):boolean
      com.google.android.gms.measurement.internal.zzla.zza(java.lang.String, java.lang.String[], java.lang.String):boolean
      com.google.android.gms.measurement.internal.zzla.zza(android.os.Bundle, java.lang.String, java.lang.Object):void */
    /* JADX WARNING: Code restructure failed: missing block: B:280:0x08ca, code lost:
        r11 = true;
     */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x02b6 A[Catch:{ SQLiteException -> 0x027d, all -> 0x0997 }] */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x02ed A[Catch:{ SQLiteException -> 0x027d, all -> 0x0997 }] */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x02fc  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0313 A[Catch:{ SQLiteException -> 0x027d, all -> 0x0997 }] */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0366 A[Catch:{ SQLiteException -> 0x027d, all -> 0x0997 }] */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0393  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x014f A[Catch:{ SQLiteException -> 0x027d, all -> 0x0997 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0157 A[Catch:{ SQLiteException -> 0x027d, all -> 0x0997 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzb(com.google.android.gms.measurement.internal.zzan r27, com.google.android.gms.measurement.internal.zzm r28) {
        /*
            r26 = this;
            r1 = r26
            r2 = r27
            r3 = r28
            java.lang.String r4 = "_s"
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r28)
            java.lang.String r5 = r3.zza
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r5)
            long r5 = java.lang.System.nanoTime()
            r26.zzw()
            r26.zzk()
            java.lang.String r15 = r3.zza
            com.google.android.gms.measurement.internal.zzkw r7 = r26.zzh()
            boolean r7 = r7.zza(r2, r3)
            if (r7 != 0) goto L_0x0027
            return
        L_0x0027:
            boolean r7 = r3.zzh
            if (r7 != 0) goto L_0x002f
            r1.zzc(r3)
            return
        L_0x002f:
            com.google.android.gms.measurement.internal.zzgi r7 = r26.zzc()
            java.lang.String r8 = r2.zza
            boolean r7 = r7.zzb(r15, r8)
            java.lang.String r14 = "_err"
            r13 = 0
            if (r7 == 0) goto L_0x00da
            com.google.android.gms.measurement.internal.zzgo r3 = r1.zzj
            com.google.android.gms.measurement.internal.zzfk r3 = r3.zzr()
            com.google.android.gms.measurement.internal.zzfm r3 = r3.zzi()
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzfk.zza(r15)
            com.google.android.gms.measurement.internal.zzgo r5 = r1.zzj
            com.google.android.gms.measurement.internal.zzfi r5 = r5.zzj()
            java.lang.String r6 = r2.zza
            java.lang.String r5 = r5.zza(r6)
            java.lang.String r6 = "Dropping blacklisted event. appId"
            r3.zza(r6, r4, r5)
            com.google.android.gms.measurement.internal.zzgi r3 = r26.zzc()
            boolean r3 = r3.zzg(r15)
            if (r3 != 0) goto L_0x0074
            com.google.android.gms.measurement.internal.zzgi r3 = r26.zzc()
            boolean r3 = r3.zzh(r15)
            if (r3 == 0) goto L_0x0072
            goto L_0x0074
        L_0x0072:
            r3 = 0
            goto L_0x0075
        L_0x0074:
            r3 = 1
        L_0x0075:
            if (r3 != 0) goto L_0x0090
            java.lang.String r4 = r2.zza
            boolean r4 = r14.equals(r4)
            if (r4 != 0) goto L_0x0090
            com.google.android.gms.measurement.internal.zzgo r4 = r1.zzj
            com.google.android.gms.measurement.internal.zzla r7 = r4.zzi()
            r9 = 11
            java.lang.String r11 = r2.zza
            r12 = 0
            java.lang.String r10 = "_ev"
            r8 = r15
            r7.zza(r8, r9, r10, r11, r12)
        L_0x0090:
            if (r3 == 0) goto L_0x00d9
            com.google.android.gms.measurement.internal.zzac r2 = r26.zze()
            com.google.android.gms.measurement.internal.zzg r2 = r2.zzb(r15)
            if (r2 == 0) goto L_0x00d9
            long r3 = r2.zzu()
            long r5 = r2.zzt()
            long r3 = java.lang.Math.max(r3, r5)
            com.google.android.gms.measurement.internal.zzgo r5 = r1.zzj
            com.google.android.gms.common.util.Clock r5 = r5.zzm()
            long r5 = r5.currentTimeMillis()
            long r5 = r5 - r3
            long r3 = java.lang.Math.abs(r5)
            com.google.android.gms.measurement.internal.zzez<java.lang.Long> r5 = com.google.android.gms.measurement.internal.zzap.zzy
            java.lang.Object r5 = r5.zza(r13)
            java.lang.Long r5 = (java.lang.Long) r5
            long r5 = r5.longValue()
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 <= 0) goto L_0x00d9
            com.google.android.gms.measurement.internal.zzgo r3 = r1.zzj
            com.google.android.gms.measurement.internal.zzfk r3 = r3.zzr()
            com.google.android.gms.measurement.internal.zzfm r3 = r3.zzw()
            java.lang.String r4 = "Fetching config for blacklisted app"
            r3.zza(r4)
            r1.zza(r2)
        L_0x00d9:
            return
        L_0x00da:
            com.google.android.gms.measurement.internal.zzgo r7 = r1.zzj
            com.google.android.gms.measurement.internal.zzfk r7 = r7.zzr()
            r10 = 2
            boolean r7 = r7.zza(r10)
            if (r7 == 0) goto L_0x0100
            com.google.android.gms.measurement.internal.zzgo r7 = r1.zzj
            com.google.android.gms.measurement.internal.zzfk r7 = r7.zzr()
            com.google.android.gms.measurement.internal.zzfm r7 = r7.zzx()
            com.google.android.gms.measurement.internal.zzgo r8 = r1.zzj
            com.google.android.gms.measurement.internal.zzfi r8 = r8.zzj()
            java.lang.String r8 = r8.zza(r2)
            java.lang.String r9 = "Logging event"
            r7.zza(r9, r8)
        L_0x0100:
            com.google.android.gms.measurement.internal.zzac r7 = r26.zze()
            r7.zzf()
            r1.zzc(r3)     // Catch:{ all -> 0x0997 }
            boolean r7 = com.google.android.gms.internal.measurement.zzjp.zzb()     // Catch:{ all -> 0x0997 }
            if (r7 == 0) goto L_0x0120
            com.google.android.gms.measurement.internal.zzgo r7 = r1.zzj     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzx r7 = r7.zzb()     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r8 = com.google.android.gms.measurement.internal.zzap.zzdf     // Catch:{ all -> 0x0997 }
            boolean r7 = r7.zza(r8)     // Catch:{ all -> 0x0997 }
            if (r7 == 0) goto L_0x0120
            r7 = 1
            goto L_0x0121
        L_0x0120:
            r7 = 0
        L_0x0121:
            java.lang.String r8 = "ecommerce_purchase"
            java.lang.String r9 = r2.zza     // Catch:{ all -> 0x0997 }
            boolean r8 = r8.equals(r9)     // Catch:{ all -> 0x0997 }
            java.lang.String r9 = "refund"
            if (r8 != 0) goto L_0x0144
            if (r7 == 0) goto L_0x0142
            java.lang.String r7 = "purchase"
            java.lang.String r8 = r2.zza     // Catch:{ all -> 0x0997 }
            boolean r7 = r7.equals(r8)     // Catch:{ all -> 0x0997 }
            if (r7 != 0) goto L_0x0144
            java.lang.String r7 = r2.zza     // Catch:{ all -> 0x0997 }
            boolean r7 = r9.equals(r7)     // Catch:{ all -> 0x0997 }
            if (r7 == 0) goto L_0x0142
            goto L_0x0144
        L_0x0142:
            r7 = 0
            goto L_0x0145
        L_0x0144:
            r7 = 1
        L_0x0145:
            java.lang.String r8 = "_iap"
            java.lang.String r10 = r2.zza     // Catch:{ all -> 0x0997 }
            boolean r8 = r8.equals(r10)     // Catch:{ all -> 0x0997 }
            if (r8 != 0) goto L_0x0154
            if (r7 == 0) goto L_0x0152
            goto L_0x0154
        L_0x0152:
            r8 = 0
            goto L_0x0155
        L_0x0154:
            r8 = 1
        L_0x0155:
            if (r8 == 0) goto L_0x02fc
            com.google.android.gms.measurement.internal.zzam r8 = r2.zzb     // Catch:{ all -> 0x0997 }
            java.lang.String r10 = "currency"
            java.lang.String r8 = r8.zzd(r10)     // Catch:{ all -> 0x0997 }
            java.lang.String r10 = "value"
            if (r7 == 0) goto L_0x01d2
            com.google.android.gms.measurement.internal.zzam r7 = r2.zzb     // Catch:{ all -> 0x0997 }
            java.lang.Double r7 = r7.zzc(r10)     // Catch:{ all -> 0x0997 }
            double r17 = r7.doubleValue()     // Catch:{ all -> 0x0997 }
            r19 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r17 = r17 * r19
            r21 = 0
            int r7 = (r17 > r21 ? 1 : (r17 == r21 ? 0 : -1))
            if (r7 != 0) goto L_0x0187
            com.google.android.gms.measurement.internal.zzam r7 = r2.zzb     // Catch:{ all -> 0x0997 }
            java.lang.Long r7 = r7.zzb(r10)     // Catch:{ all -> 0x0997 }
            long r11 = r7.longValue()     // Catch:{ all -> 0x0997 }
            double r10 = (double) r11     // Catch:{ all -> 0x0997 }
            double r17 = r10 * r19
        L_0x0187:
            r10 = 4890909195324358656(0x43e0000000000000, double:9.223372036854776E18)
            int r7 = (r17 > r10 ? 1 : (r17 == r10 ? 0 : -1))
            if (r7 > 0) goto L_0x01b5
            r10 = -4332462841530417152(0xc3e0000000000000, double:-9.223372036854776E18)
            int r7 = (r17 > r10 ? 1 : (r17 == r10 ? 0 : -1))
            if (r7 < 0) goto L_0x01b5
            long r10 = java.lang.Math.round(r17)     // Catch:{ all -> 0x0997 }
            boolean r7 = com.google.android.gms.internal.measurement.zzjp.zzb()     // Catch:{ all -> 0x0997 }
            if (r7 == 0) goto L_0x01dc
            com.google.android.gms.measurement.internal.zzgo r7 = r1.zzj     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzx r7 = r7.zzb()     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r12 = com.google.android.gms.measurement.internal.zzap.zzdf     // Catch:{ all -> 0x0997 }
            boolean r7 = r7.zza(r12)     // Catch:{ all -> 0x0997 }
            if (r7 == 0) goto L_0x01dc
            java.lang.String r7 = r2.zza     // Catch:{ all -> 0x0997 }
            boolean r7 = r9.equals(r7)     // Catch:{ all -> 0x0997 }
            if (r7 == 0) goto L_0x01dc
            long r10 = -r10
            goto L_0x01dc
        L_0x01b5:
            com.google.android.gms.measurement.internal.zzgo r7 = r1.zzj     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzfk r7 = r7.zzr()     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzfm r7 = r7.zzi()     // Catch:{ all -> 0x0997 }
            java.lang.String r8 = "Data lost. Currency value is too big. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzfk.zza(r15)     // Catch:{ all -> 0x0997 }
            java.lang.Double r10 = java.lang.Double.valueOf(r17)     // Catch:{ all -> 0x0997 }
            r7.zza(r8, r9, r10)     // Catch:{ all -> 0x0997 }
            r23 = r5
            r5 = 0
            r11 = 0
            goto L_0x02eb
        L_0x01d2:
            com.google.android.gms.measurement.internal.zzam r7 = r2.zzb     // Catch:{ all -> 0x0997 }
            java.lang.Long r7 = r7.zzb(r10)     // Catch:{ all -> 0x0997 }
            long r10 = r7.longValue()     // Catch:{ all -> 0x0997 }
        L_0x01dc:
            boolean r7 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0997 }
            if (r7 != 0) goto L_0x02e7
            java.util.Locale r7 = java.util.Locale.US     // Catch:{ all -> 0x0997 }
            java.lang.String r7 = r8.toUpperCase(r7)     // Catch:{ all -> 0x0997 }
            java.lang.String r8 = "[A-Z]{3}"
            boolean r8 = r7.matches(r8)     // Catch:{ all -> 0x0997 }
            if (r8 == 0) goto L_0x02e7
            java.lang.String r8 = "_ltv_"
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ all -> 0x0997 }
            int r9 = r7.length()     // Catch:{ all -> 0x0997 }
            if (r9 == 0) goto L_0x0201
            java.lang.String r7 = r8.concat(r7)     // Catch:{ all -> 0x0997 }
            goto L_0x0206
        L_0x0201:
            java.lang.String r7 = new java.lang.String     // Catch:{ all -> 0x0997 }
            r7.<init>(r8)     // Catch:{ all -> 0x0997 }
        L_0x0206:
            r12 = r7
            com.google.android.gms.measurement.internal.zzac r7 = r26.zze()     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzlb r7 = r7.zzc(r15, r12)     // Catch:{ all -> 0x0997 }
            if (r7 == 0) goto L_0x0244
            java.lang.Object r8 = r7.zze     // Catch:{ all -> 0x0997 }
            boolean r8 = r8 instanceof java.lang.Long     // Catch:{ all -> 0x0997 }
            if (r8 != 0) goto L_0x0218
            goto L_0x0244
        L_0x0218:
            java.lang.Object r7 = r7.zze     // Catch:{ all -> 0x0997 }
            java.lang.Long r7 = (java.lang.Long) r7     // Catch:{ all -> 0x0997 }
            long r7 = r7.longValue()     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzlb r17 = new com.google.android.gms.measurement.internal.zzlb     // Catch:{ all -> 0x0997 }
            java.lang.String r9 = r2.zzc     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzgo r13 = r1.zzj     // Catch:{ all -> 0x0997 }
            com.google.android.gms.common.util.Clock r13 = r13.zzm()     // Catch:{ all -> 0x0997 }
            long r19 = r13.currentTimeMillis()     // Catch:{ all -> 0x0997 }
            long r7 = r7 + r10
            java.lang.Long r13 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x0997 }
            r7 = r17
            r8 = r15
            r11 = 2
            r10 = r12
            r23 = r5
            r5 = 0
            r6 = 1
            r11 = r19
            r7.<init>(r8, r9, r10, r11, r13)     // Catch:{ all -> 0x0997 }
        L_0x0241:
            r6 = r17
            goto L_0x02ac
        L_0x0244:
            r23 = r5
            r5 = 0
            r6 = 1
            com.google.android.gms.measurement.internal.zzac r7 = r26.zze()     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzgo r8 = r1.zzj     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzx r8 = r8.zzb()     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Integer> r9 = com.google.android.gms.measurement.internal.zzap.zzad     // Catch:{ all -> 0x0997 }
            int r8 = r8.zzb(r15, r9)     // Catch:{ all -> 0x0997 }
            int r8 = r8 - r6
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r15)     // Catch:{ all -> 0x0997 }
            r7.zzd()     // Catch:{ all -> 0x0997 }
            r7.zzak()     // Catch:{ all -> 0x0997 }
            android.database.sqlite.SQLiteDatabase r9 = r7.c_()     // Catch:{ SQLiteException -> 0x027d }
            java.lang.String r13 = "delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);"
            r6 = 3
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x027d }
            r6[r5] = r15     // Catch:{ SQLiteException -> 0x027d }
            r16 = 1
            r6[r16] = r15     // Catch:{ SQLiteException -> 0x027d }
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ SQLiteException -> 0x027d }
            r16 = 2
            r6[r16] = r8     // Catch:{ SQLiteException -> 0x027d }
            r9.execSQL(r13, r6)     // Catch:{ SQLiteException -> 0x027d }
            goto L_0x0290
        L_0x027d:
            r0 = move-exception
            r6 = r0
            com.google.android.gms.measurement.internal.zzfk r7 = r7.zzr()     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzfm r7 = r7.zzf()     // Catch:{ all -> 0x0997 }
            java.lang.String r8 = "Error pruning currencies. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzfk.zza(r15)     // Catch:{ all -> 0x0997 }
            r7.zza(r8, r9, r6)     // Catch:{ all -> 0x0997 }
        L_0x0290:
            com.google.android.gms.measurement.internal.zzlb r17 = new com.google.android.gms.measurement.internal.zzlb     // Catch:{ all -> 0x0997 }
            java.lang.String r9 = r2.zzc     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzgo r6 = r1.zzj     // Catch:{ all -> 0x0997 }
            com.google.android.gms.common.util.Clock r6 = r6.zzm()     // Catch:{ all -> 0x0997 }
            long r18 = r6.currentTimeMillis()     // Catch:{ all -> 0x0997 }
            java.lang.Long r13 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x0997 }
            r7 = r17
            r8 = r15
            r10 = r12
            r11 = r18
            r7.<init>(r8, r9, r10, r11, r13)     // Catch:{ all -> 0x0997 }
            goto L_0x0241
        L_0x02ac:
            com.google.android.gms.measurement.internal.zzac r7 = r26.zze()     // Catch:{ all -> 0x0997 }
            boolean r7 = r7.zza(r6)     // Catch:{ all -> 0x0997 }
            if (r7 != 0) goto L_0x02ea
            com.google.android.gms.measurement.internal.zzgo r7 = r1.zzj     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzfk r7 = r7.zzr()     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzfm r7 = r7.zzf()     // Catch:{ all -> 0x0997 }
            java.lang.String r8 = "Too many unique user properties are set. Ignoring user property. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzfk.zza(r15)     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzgo r10 = r1.zzj     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzfi r10 = r10.zzj()     // Catch:{ all -> 0x0997 }
            java.lang.String r11 = r6.zzc     // Catch:{ all -> 0x0997 }
            java.lang.String r10 = r10.zzc(r11)     // Catch:{ all -> 0x0997 }
            java.lang.Object r6 = r6.zze     // Catch:{ all -> 0x0997 }
            r7.zza(r8, r9, r10, r6)     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzgo r6 = r1.zzj     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzla r7 = r6.zzi()     // Catch:{ all -> 0x0997 }
            r9 = 9
            r10 = 0
            r11 = 0
            r12 = 0
            r8 = r15
            r7.zza(r8, r9, r10, r11, r12)     // Catch:{ all -> 0x0997 }
            goto L_0x02ea
        L_0x02e7:
            r23 = r5
            r5 = 0
        L_0x02ea:
            r11 = 1
        L_0x02eb:
            if (r11 != 0) goto L_0x02ff
            com.google.android.gms.measurement.internal.zzac r2 = r26.zze()     // Catch:{ all -> 0x0997 }
            r2.b_()     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzac r2 = r26.zze()
            r2.zzh()
            return
        L_0x02fc:
            r23 = r5
            r5 = 0
        L_0x02ff:
            java.lang.String r6 = r2.zza     // Catch:{ all -> 0x0997 }
            boolean r6 = com.google.android.gms.measurement.internal.zzla.zza(r6)     // Catch:{ all -> 0x0997 }
            java.lang.String r7 = r2.zza     // Catch:{ all -> 0x0997 }
            boolean r18 = r14.equals(r7)     // Catch:{ all -> 0x0997 }
            boolean r7 = com.google.android.gms.internal.measurement.zzjp.zzb()     // Catch:{ all -> 0x0997 }
            r19 = 1
            if (r7 == 0) goto L_0x0332
            com.google.android.gms.measurement.internal.zzgo r7 = r1.zzj     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzx r7 = r7.zzb()     // Catch:{ all -> 0x0997 }
            java.lang.String r8 = r3.zza     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r9 = com.google.android.gms.measurement.internal.zzap.zzdb     // Catch:{ all -> 0x0997 }
            boolean r7 = r7.zze(r8, r9)     // Catch:{ all -> 0x0997 }
            if (r7 == 0) goto L_0x0332
            com.google.android.gms.measurement.internal.zzgo r7 = r1.zzj     // Catch:{ all -> 0x0997 }
            r7.zzi()     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzam r7 = r2.zzb     // Catch:{ all -> 0x0997 }
            long r7 = com.google.android.gms.measurement.internal.zzla.zza(r7)     // Catch:{ all -> 0x0997 }
            long r7 = r7 + r19
            r11 = r7
            goto L_0x0334
        L_0x0332:
            r11 = r19
        L_0x0334:
            com.google.android.gms.measurement.internal.zzac r7 = r26.zze()     // Catch:{ all -> 0x0997 }
            long r8 = r26.zzx()     // Catch:{ all -> 0x0997 }
            r13 = 1
            r16 = 0
            r17 = 0
            r10 = r15
            r14 = r6
            r21 = r15
            r15 = r16
            r16 = r18
            com.google.android.gms.measurement.internal.zzab r7 = r7.zza(r8, r10, r11, r13, r14, r15, r16, r17)     // Catch:{ all -> 0x0997 }
            long r8 = r7.zzb     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Integer> r10 = com.google.android.gms.measurement.internal.zzap.zzj     // Catch:{ all -> 0x0997 }
            r14 = 0
            java.lang.Object r10 = r10.zza(r14)     // Catch:{ all -> 0x0997 }
            java.lang.Integer r10 = (java.lang.Integer) r10     // Catch:{ all -> 0x0997 }
            int r10 = r10.intValue()     // Catch:{ all -> 0x0997 }
            long r10 = (long) r10     // Catch:{ all -> 0x0997 }
            long r8 = r8 - r10
            r12 = 0
            int r10 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            r15 = 1000(0x3e8, double:4.94E-321)
            if (r10 <= 0) goto L_0x0393
            long r8 = r8 % r15
            int r2 = (r8 > r19 ? 1 : (r8 == r19 ? 0 : -1))
            if (r2 != 0) goto L_0x0384
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzfk r2 = r2.zzr()     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzfm r2 = r2.zzf()     // Catch:{ all -> 0x0997 }
            java.lang.String r3 = "Data loss. Too many events logged. appId, count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzfk.zza(r21)     // Catch:{ all -> 0x0997 }
            long r5 = r7.zzb     // Catch:{ all -> 0x0997 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0997 }
            r2.zza(r3, r4, r5)     // Catch:{ all -> 0x0997 }
        L_0x0384:
            com.google.android.gms.measurement.internal.zzac r2 = r26.zze()     // Catch:{ all -> 0x0997 }
            r2.b_()     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzac r2 = r26.zze()
            r2.zzh()
            return
        L_0x0393:
            if (r6 == 0) goto L_0x03e8
            long r8 = r7.zza     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Integer> r10 = com.google.android.gms.measurement.internal.zzap.zzl     // Catch:{ all -> 0x0997 }
            java.lang.Object r10 = r10.zza(r14)     // Catch:{ all -> 0x0997 }
            java.lang.Integer r10 = (java.lang.Integer) r10     // Catch:{ all -> 0x0997 }
            int r10 = r10.intValue()     // Catch:{ all -> 0x0997 }
            long r10 = (long) r10     // Catch:{ all -> 0x0997 }
            long r8 = r8 - r10
            int r10 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r10 <= 0) goto L_0x03e8
            long r8 = r8 % r15
            int r3 = (r8 > r19 ? 1 : (r8 == r19 ? 0 : -1))
            if (r3 != 0) goto L_0x03c7
            com.google.android.gms.measurement.internal.zzgo r3 = r1.zzj     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzfk r3 = r3.zzr()     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzfm r3 = r3.zzf()     // Catch:{ all -> 0x0997 }
            java.lang.String r4 = "Data loss. Too many public events logged. appId, count"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzfk.zza(r21)     // Catch:{ all -> 0x0997 }
            long r6 = r7.zza     // Catch:{ all -> 0x0997 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0997 }
            r3.zza(r4, r5, r6)     // Catch:{ all -> 0x0997 }
        L_0x03c7:
            com.google.android.gms.measurement.internal.zzgo r3 = r1.zzj     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzla r7 = r3.zzi()     // Catch:{ all -> 0x0997 }
            r9 = 16
            java.lang.String r10 = "_ev"
            java.lang.String r11 = r2.zza     // Catch:{ all -> 0x0997 }
            r12 = 0
            r8 = r21
            r7.zza(r8, r9, r10, r11, r12)     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzac r2 = r26.zze()     // Catch:{ all -> 0x0997 }
            r2.b_()     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzac r2 = r26.zze()
            r2.zzh()
            return
        L_0x03e8:
            if (r18 == 0) goto L_0x0437
            long r8 = r7.zzd     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzgo r10 = r1.zzj     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzx r10 = r10.zzb()     // Catch:{ all -> 0x0997 }
            java.lang.String r11 = r3.zza     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Integer> r15 = com.google.android.gms.measurement.internal.zzap.zzk     // Catch:{ all -> 0x0997 }
            int r10 = r10.zzb(r11, r15)     // Catch:{ all -> 0x0997 }
            r11 = 1000000(0xf4240, float:1.401298E-39)
            int r10 = java.lang.Math.min(r11, r10)     // Catch:{ all -> 0x0997 }
            int r10 = java.lang.Math.max(r5, r10)     // Catch:{ all -> 0x0997 }
            long r10 = (long) r10     // Catch:{ all -> 0x0997 }
            long r8 = r8 - r10
            int r10 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r10 <= 0) goto L_0x0437
            int r2 = (r8 > r19 ? 1 : (r8 == r19 ? 0 : -1))
            if (r2 != 0) goto L_0x0428
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzfk r2 = r2.zzr()     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzfm r2 = r2.zzf()     // Catch:{ all -> 0x0997 }
            java.lang.String r3 = "Too many error events logged. appId, count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzfk.zza(r21)     // Catch:{ all -> 0x0997 }
            long r5 = r7.zzd     // Catch:{ all -> 0x0997 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0997 }
            r2.zza(r3, r4, r5)     // Catch:{ all -> 0x0997 }
        L_0x0428:
            com.google.android.gms.measurement.internal.zzac r2 = r26.zze()     // Catch:{ all -> 0x0997 }
            r2.b_()     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzac r2 = r26.zze()
            r2.zzh()
            return
        L_0x0437:
            com.google.android.gms.measurement.internal.zzam r7 = r2.zzb     // Catch:{ all -> 0x0997 }
            android.os.Bundle r15 = r7.zzb()     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzgo r7 = r1.zzj     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzla r7 = r7.zzi()     // Catch:{ all -> 0x0997 }
            java.lang.String r8 = "_o"
            java.lang.String r9 = r2.zzc     // Catch:{ all -> 0x0997 }
            r7.zza(r15, r8, r9)     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzgo r7 = r1.zzj     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzla r7 = r7.zzi()     // Catch:{ all -> 0x0997 }
            r11 = r21
            boolean r7 = r7.zzf(r11)     // Catch:{ all -> 0x0997 }
            java.lang.String r10 = "_r"
            if (r7 == 0) goto L_0x0476
            com.google.android.gms.measurement.internal.zzgo r7 = r1.zzj     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzla r7 = r7.zzi()     // Catch:{ all -> 0x0997 }
            java.lang.String r8 = "_dbg"
            java.lang.Long r9 = java.lang.Long.valueOf(r19)     // Catch:{ all -> 0x0997 }
            r7.zza(r15, r8, r9)     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzgo r7 = r1.zzj     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzla r7 = r7.zzi()     // Catch:{ all -> 0x0997 }
            java.lang.Long r8 = java.lang.Long.valueOf(r19)     // Catch:{ all -> 0x0997 }
            r7.zza(r15, r10, r8)     // Catch:{ all -> 0x0997 }
        L_0x0476:
            java.lang.String r7 = r2.zza     // Catch:{ all -> 0x0997 }
            boolean r7 = r4.equals(r7)     // Catch:{ all -> 0x0997 }
            java.lang.String r8 = "_sno"
            if (r7 == 0) goto L_0x04ad
            com.google.android.gms.measurement.internal.zzgo r7 = r1.zzj     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzx r7 = r7.zzb()     // Catch:{ all -> 0x0997 }
            java.lang.String r9 = r3.zza     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r5 = com.google.android.gms.measurement.internal.zzap.zzas     // Catch:{ all -> 0x0997 }
            boolean r5 = r7.zze(r9, r5)     // Catch:{ all -> 0x0997 }
            if (r5 == 0) goto L_0x04ad
            com.google.android.gms.measurement.internal.zzac r5 = r26.zze()     // Catch:{ all -> 0x0997 }
            java.lang.String r7 = r3.zza     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzlb r5 = r5.zzc(r7, r8)     // Catch:{ all -> 0x0997 }
            if (r5 == 0) goto L_0x04ad
            java.lang.Object r7 = r5.zze     // Catch:{ all -> 0x0997 }
            boolean r7 = r7 instanceof java.lang.Long     // Catch:{ all -> 0x0997 }
            if (r7 == 0) goto L_0x04ad
            com.google.android.gms.measurement.internal.zzgo r7 = r1.zzj     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzla r7 = r7.zzi()     // Catch:{ all -> 0x0997 }
            java.lang.Object r5 = r5.zze     // Catch:{ all -> 0x0997 }
            r7.zza(r15, r8, r5)     // Catch:{ all -> 0x0997 }
        L_0x04ad:
            java.lang.String r5 = r2.zza     // Catch:{ all -> 0x0997 }
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x0997 }
            if (r4 == 0) goto L_0x04dd
            com.google.android.gms.measurement.internal.zzgo r4 = r1.zzj     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzx r4 = r4.zzb()     // Catch:{ all -> 0x0997 }
            java.lang.String r5 = r3.zza     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r7 = com.google.android.gms.measurement.internal.zzap.zzaw     // Catch:{ all -> 0x0997 }
            boolean r4 = r4.zze(r5, r7)     // Catch:{ all -> 0x0997 }
            if (r4 == 0) goto L_0x04dd
            com.google.android.gms.measurement.internal.zzgo r4 = r1.zzj     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzx r4 = r4.zzb()     // Catch:{ all -> 0x0997 }
            java.lang.String r5 = r3.zza     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r7 = com.google.android.gms.measurement.internal.zzap.zzas     // Catch:{ all -> 0x0997 }
            boolean r4 = r4.zze(r5, r7)     // Catch:{ all -> 0x0997 }
            if (r4 != 0) goto L_0x04dd
            com.google.android.gms.measurement.internal.zzkz r4 = new com.google.android.gms.measurement.internal.zzkz     // Catch:{ all -> 0x0997 }
            r4.<init>(r8, r12, r14)     // Catch:{ all -> 0x0997 }
            r1.zzb(r4, r3)     // Catch:{ all -> 0x0997 }
        L_0x04dd:
            com.google.android.gms.measurement.internal.zzac r4 = r26.zze()     // Catch:{ all -> 0x0997 }
            long r4 = r4.zzc(r11)     // Catch:{ all -> 0x0997 }
            int r7 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r7 <= 0) goto L_0x0500
            com.google.android.gms.measurement.internal.zzgo r7 = r1.zzj     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzfk r7 = r7.zzr()     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzfm r7 = r7.zzi()     // Catch:{ all -> 0x0997 }
            java.lang.String r8 = "Data lost. Too many events stored on disk, deleted. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzfk.zza(r11)     // Catch:{ all -> 0x0997 }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x0997 }
            r7.zza(r8, r9, r4)     // Catch:{ all -> 0x0997 }
        L_0x0500:
            com.google.android.gms.measurement.internal.zzak r4 = new com.google.android.gms.measurement.internal.zzak     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzgo r8 = r1.zzj     // Catch:{ all -> 0x0997 }
            java.lang.String r9 = r2.zzc     // Catch:{ all -> 0x0997 }
            java.lang.String r5 = r2.zza     // Catch:{ all -> 0x0997 }
            long r12 = r2.zzd     // Catch:{ all -> 0x0997 }
            r18 = 0
            r7 = r4
            r2 = r10
            r10 = r11
            r25 = r11
            r11 = r5
            r27 = r14
            r5 = r15
            r14 = r18
            r16 = r5
            r7.<init>(r8, r9, r10, r11, r12, r14, r16)     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzac r5 = r26.zze()     // Catch:{ all -> 0x0997 }
            java.lang.String r7 = r4.zzb     // Catch:{ all -> 0x0997 }
            r8 = r25
            com.google.android.gms.measurement.internal.zzaj r5 = r5.zza(r8, r7)     // Catch:{ all -> 0x0997 }
            if (r5 != 0) goto L_0x059f
            com.google.android.gms.measurement.internal.zzac r5 = r26.zze()     // Catch:{ all -> 0x0997 }
            long r9 = r5.zzh(r8)     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzgo r5 = r1.zzj     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzx r5 = r5.zzb()     // Catch:{ all -> 0x0997 }
            int r5 = r5.zza(r8)     // Catch:{ all -> 0x0997 }
            long r11 = (long) r5     // Catch:{ all -> 0x0997 }
            int r5 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r5 < 0) goto L_0x0586
            if (r6 == 0) goto L_0x0586
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzfk r2 = r2.zzr()     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzfm r2 = r2.zzf()     // Catch:{ all -> 0x0997 }
            java.lang.String r3 = "Too many event names used, ignoring event. appId, name, supported count"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzfk.zza(r8)     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzgo r6 = r1.zzj     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzfi r6 = r6.zzj()     // Catch:{ all -> 0x0997 }
            java.lang.String r4 = r4.zzb     // Catch:{ all -> 0x0997 }
            java.lang.String r4 = r6.zza(r4)     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzgo r6 = r1.zzj     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzx r6 = r6.zzb()     // Catch:{ all -> 0x0997 }
            int r6 = r6.zza(r8)     // Catch:{ all -> 0x0997 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0997 }
            r2.zza(r3, r5, r4, r6)     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzla r7 = r2.zzi()     // Catch:{ all -> 0x0997 }
            r9 = 8
            r10 = 0
            r11 = 0
            r12 = 0
            r7.zza(r8, r9, r10, r11, r12)     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzac r2 = r26.zze()
            r2.zzh()
            return
        L_0x0586:
            com.google.android.gms.measurement.internal.zzaj r5 = new com.google.android.gms.measurement.internal.zzaj     // Catch:{ all -> 0x0997 }
            java.lang.String r9 = r4.zzb     // Catch:{ all -> 0x0997 }
            r10 = 0
            r12 = 0
            long r14 = r4.zzc     // Catch:{ all -> 0x0997 }
            r16 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r7 = r5
            r7.<init>(r8, r9, r10, r12, r14, r16, r18, r19, r20, r21)     // Catch:{ all -> 0x0997 }
            goto L_0x05ad
        L_0x059f:
            com.google.android.gms.measurement.internal.zzgo r6 = r1.zzj     // Catch:{ all -> 0x0997 }
            long r7 = r5.zzf     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzak r4 = r4.zza(r6, r7)     // Catch:{ all -> 0x0997 }
            long r6 = r4.zzc     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzaj r5 = r5.zza(r6)     // Catch:{ all -> 0x0997 }
        L_0x05ad:
            com.google.android.gms.measurement.internal.zzac r6 = r26.zze()     // Catch:{ all -> 0x0997 }
            r6.zza(r5)     // Catch:{ all -> 0x0997 }
            r26.zzw()     // Catch:{ all -> 0x0997 }
            r26.zzk()     // Catch:{ all -> 0x0997 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r4)     // Catch:{ all -> 0x0997 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r28)     // Catch:{ all -> 0x0997 }
            java.lang.String r5 = r4.zza     // Catch:{ all -> 0x0997 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r5)     // Catch:{ all -> 0x0997 }
            java.lang.String r5 = r4.zza     // Catch:{ all -> 0x0997 }
            java.lang.String r6 = r3.zza     // Catch:{ all -> 0x0997 }
            boolean r5 = r5.equals(r6)     // Catch:{ all -> 0x0997 }
            com.google.android.gms.common.internal.Preconditions.checkArgument(r5)     // Catch:{ all -> 0x0997 }
            com.google.android.gms.internal.measurement.zzbr$zzg$zza r5 = com.google.android.gms.internal.measurement.zzbr.zzg.zzbf()     // Catch:{ all -> 0x0997 }
            r6 = 1
            com.google.android.gms.internal.measurement.zzbr$zzg$zza r5 = r5.zza(r6)     // Catch:{ all -> 0x0997 }
            java.lang.String r7 = "android"
            com.google.android.gms.internal.measurement.zzbr$zzg$zza r5 = r5.zza(r7)     // Catch:{ all -> 0x0997 }
            java.lang.String r7 = r3.zza     // Catch:{ all -> 0x0997 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0997 }
            if (r7 != 0) goto L_0x05ec
            java.lang.String r7 = r3.zza     // Catch:{ all -> 0x0997 }
            r5.zzf(r7)     // Catch:{ all -> 0x0997 }
        L_0x05ec:
            java.lang.String r7 = r3.zzd     // Catch:{ all -> 0x0997 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0997 }
            if (r7 != 0) goto L_0x05f9
            java.lang.String r7 = r3.zzd     // Catch:{ all -> 0x0997 }
            r5.zze(r7)     // Catch:{ all -> 0x0997 }
        L_0x05f9:
            java.lang.String r7 = r3.zzc     // Catch:{ all -> 0x0997 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0997 }
            if (r7 != 0) goto L_0x0606
            java.lang.String r7 = r3.zzc     // Catch:{ all -> 0x0997 }
            r5.zzg(r7)     // Catch:{ all -> 0x0997 }
        L_0x0606:
            long r7 = r3.zzj     // Catch:{ all -> 0x0997 }
            r9 = -2147483648(0xffffffff80000000, double:NaN)
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 == 0) goto L_0x0615
            long r7 = r3.zzj     // Catch:{ all -> 0x0997 }
            int r7 = (int) r7     // Catch:{ all -> 0x0997 }
            r5.zzh(r7)     // Catch:{ all -> 0x0997 }
        L_0x0615:
            long r7 = r3.zze     // Catch:{ all -> 0x0997 }
            r5.zzf(r7)     // Catch:{ all -> 0x0997 }
            java.lang.String r7 = r3.zzb     // Catch:{ all -> 0x0997 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0997 }
            if (r7 != 0) goto L_0x0627
            java.lang.String r7 = r3.zzb     // Catch:{ all -> 0x0997 }
            r5.zzk(r7)     // Catch:{ all -> 0x0997 }
        L_0x0627:
            boolean r7 = com.google.android.gms.internal.measurement.zzll.zzb()     // Catch:{ all -> 0x0997 }
            if (r7 == 0) goto L_0x0676
            com.google.android.gms.measurement.internal.zzgo r7 = r1.zzj     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzx r7 = r7.zzb()     // Catch:{ all -> 0x0997 }
            java.lang.String r8 = r3.zza     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r9 = com.google.android.gms.measurement.internal.zzap.zzch     // Catch:{ all -> 0x0997 }
            boolean r7 = r7.zze(r8, r9)     // Catch:{ all -> 0x0997 }
            if (r7 == 0) goto L_0x0676
            java.lang.String r7 = r5.zzl()     // Catch:{ all -> 0x0997 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0997 }
            if (r7 == 0) goto L_0x0654
            java.lang.String r7 = r3.zzv     // Catch:{ all -> 0x0997 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0997 }
            if (r7 != 0) goto L_0x0654
            java.lang.String r7 = r3.zzv     // Catch:{ all -> 0x0997 }
            r5.zzp(r7)     // Catch:{ all -> 0x0997 }
        L_0x0654:
            java.lang.String r7 = r5.zzl()     // Catch:{ all -> 0x0997 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0997 }
            if (r7 == 0) goto L_0x06a9
            java.lang.String r7 = r5.zzo()     // Catch:{ all -> 0x0997 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0997 }
            if (r7 == 0) goto L_0x06a9
            java.lang.String r7 = r3.zzr     // Catch:{ all -> 0x0997 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0997 }
            if (r7 != 0) goto L_0x06a9
            java.lang.String r7 = r3.zzr     // Catch:{ all -> 0x0997 }
            r5.zzo(r7)     // Catch:{ all -> 0x0997 }
            goto L_0x06a9
        L_0x0676:
            com.google.android.gms.measurement.internal.zzgo r7 = r1.zzj     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzx r7 = r7.zzb()     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r8 = com.google.android.gms.measurement.internal.zzap.zzbh     // Catch:{ all -> 0x0997 }
            boolean r7 = r7.zza(r8)     // Catch:{ all -> 0x0997 }
            if (r7 == 0) goto L_0x069c
            java.lang.String r7 = r5.zzl()     // Catch:{ all -> 0x0997 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0997 }
            if (r7 == 0) goto L_0x06a9
            java.lang.String r7 = r3.zzr     // Catch:{ all -> 0x0997 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0997 }
            if (r7 != 0) goto L_0x06a9
            java.lang.String r7 = r3.zzr     // Catch:{ all -> 0x0997 }
            r5.zzo(r7)     // Catch:{ all -> 0x0997 }
            goto L_0x06a9
        L_0x069c:
            java.lang.String r7 = r3.zzr     // Catch:{ all -> 0x0997 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0997 }
            if (r7 != 0) goto L_0x06a9
            java.lang.String r7 = r3.zzr     // Catch:{ all -> 0x0997 }
            r5.zzo(r7)     // Catch:{ all -> 0x0997 }
        L_0x06a9:
            long r7 = r3.zzf     // Catch:{ all -> 0x0997 }
            r9 = 0
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 == 0) goto L_0x06b6
            long r7 = r3.zzf     // Catch:{ all -> 0x0997 }
            r5.zzh(r7)     // Catch:{ all -> 0x0997 }
        L_0x06b6:
            long r7 = r3.zzt     // Catch:{ all -> 0x0997 }
            r5.zzk(r7)     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzgo r7 = r1.zzj     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzx r7 = r7.zzb()     // Catch:{ all -> 0x0997 }
            java.lang.String r8 = r3.zza     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r11 = com.google.android.gms.measurement.internal.zzap.zzbe     // Catch:{ all -> 0x0997 }
            boolean r7 = r7.zze(r8, r11)     // Catch:{ all -> 0x0997 }
            if (r7 == 0) goto L_0x06d8
            com.google.android.gms.measurement.internal.zzkw r7 = r26.zzh()     // Catch:{ all -> 0x0997 }
            java.util.List r7 = r7.zzf()     // Catch:{ all -> 0x0997 }
            if (r7 == 0) goto L_0x06d8
            r5.zzd(r7)     // Catch:{ all -> 0x0997 }
        L_0x06d8:
            com.google.android.gms.measurement.internal.zzgo r7 = r1.zzj     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzft r7 = r7.zzc()     // Catch:{ all -> 0x0997 }
            java.lang.String r8 = r3.zza     // Catch:{ all -> 0x0997 }
            android.util.Pair r7 = r7.zza(r8)     // Catch:{ all -> 0x0997 }
            if (r7 == 0) goto L_0x070b
            java.lang.Object r8 = r7.first     // Catch:{ all -> 0x0997 }
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8     // Catch:{ all -> 0x0997 }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0997 }
            if (r8 != 0) goto L_0x070b
            boolean r8 = r3.zzo     // Catch:{ all -> 0x0997 }
            if (r8 == 0) goto L_0x076d
            java.lang.Object r8 = r7.first     // Catch:{ all -> 0x0997 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x0997 }
            r5.zzh(r8)     // Catch:{ all -> 0x0997 }
            java.lang.Object r8 = r7.second     // Catch:{ all -> 0x0997 }
            if (r8 == 0) goto L_0x076d
            java.lang.Object r7 = r7.second     // Catch:{ all -> 0x0997 }
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch:{ all -> 0x0997 }
            boolean r7 = r7.booleanValue()     // Catch:{ all -> 0x0997 }
            r5.zza(r7)     // Catch:{ all -> 0x0997 }
            goto L_0x076d
        L_0x070b:
            com.google.android.gms.measurement.internal.zzgo r7 = r1.zzj     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzah r7 = r7.zzx()     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzgo r8 = r1.zzj     // Catch:{ all -> 0x0997 }
            android.content.Context r8 = r8.zzn()     // Catch:{ all -> 0x0997 }
            boolean r7 = r7.zza(r8)     // Catch:{ all -> 0x0997 }
            if (r7 != 0) goto L_0x076d
            boolean r7 = r3.zzp     // Catch:{ all -> 0x0997 }
            if (r7 == 0) goto L_0x076d
            com.google.android.gms.measurement.internal.zzgo r7 = r1.zzj     // Catch:{ all -> 0x0997 }
            android.content.Context r7 = r7.zzn()     // Catch:{ all -> 0x0997 }
            android.content.ContentResolver r7 = r7.getContentResolver()     // Catch:{ all -> 0x0997 }
            java.lang.String r8 = "android_id"
            java.lang.String r7 = android.provider.Settings.Secure.getString(r7, r8)     // Catch:{ all -> 0x0997 }
            if (r7 != 0) goto L_0x074d
            com.google.android.gms.measurement.internal.zzgo r7 = r1.zzj     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzfk r7 = r7.zzr()     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzfm r7 = r7.zzi()     // Catch:{ all -> 0x0997 }
            java.lang.String r8 = "null secure ID. appId"
            java.lang.String r11 = r5.zzj()     // Catch:{ all -> 0x0997 }
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzfk.zza(r11)     // Catch:{ all -> 0x0997 }
            r7.zza(r8, r11)     // Catch:{ all -> 0x0997 }
            java.lang.String r7 = "null"
            goto L_0x076a
        L_0x074d:
            boolean r8 = r7.isEmpty()     // Catch:{ all -> 0x0997 }
            if (r8 == 0) goto L_0x076a
            com.google.android.gms.measurement.internal.zzgo r8 = r1.zzj     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzfk r8 = r8.zzr()     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzfm r8 = r8.zzi()     // Catch:{ all -> 0x0997 }
            java.lang.String r11 = "empty secure ID. appId"
            java.lang.String r12 = r5.zzj()     // Catch:{ all -> 0x0997 }
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzfk.zza(r12)     // Catch:{ all -> 0x0997 }
            r8.zza(r11, r12)     // Catch:{ all -> 0x0997 }
        L_0x076a:
            r5.zzm(r7)     // Catch:{ all -> 0x0997 }
        L_0x076d:
            com.google.android.gms.measurement.internal.zzgo r7 = r1.zzj     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzah r7 = r7.zzx()     // Catch:{ all -> 0x0997 }
            r7.zzaa()     // Catch:{ all -> 0x0997 }
            java.lang.String r7 = android.os.Build.MODEL     // Catch:{ all -> 0x0997 }
            com.google.android.gms.internal.measurement.zzbr$zzg$zza r7 = r5.zzc(r7)     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzgo r8 = r1.zzj     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzah r8 = r8.zzx()     // Catch:{ all -> 0x0997 }
            r8.zzaa()     // Catch:{ all -> 0x0997 }
            java.lang.String r8 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x0997 }
            com.google.android.gms.internal.measurement.zzbr$zzg$zza r7 = r7.zzb(r8)     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzgo r8 = r1.zzj     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzah r8 = r8.zzx()     // Catch:{ all -> 0x0997 }
            long r11 = r8.zzf()     // Catch:{ all -> 0x0997 }
            int r8 = (int) r11     // Catch:{ all -> 0x0997 }
            com.google.android.gms.internal.measurement.zzbr$zzg$zza r7 = r7.zzf(r8)     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzgo r8 = r1.zzj     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzah r8 = r8.zzx()     // Catch:{ all -> 0x0997 }
            java.lang.String r8 = r8.zzg()     // Catch:{ all -> 0x0997 }
            com.google.android.gms.internal.measurement.zzbr$zzg$zza r7 = r7.zzd(r8)     // Catch:{ all -> 0x0997 }
            long r11 = r3.zzl     // Catch:{ all -> 0x0997 }
            r7.zzj(r11)     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzgo r7 = r1.zzj     // Catch:{ all -> 0x0997 }
            boolean r7 = r7.zzab()     // Catch:{ all -> 0x0997 }
            if (r7 == 0) goto L_0x07c3
            r5.zzj()     // Catch:{ all -> 0x0997 }
            boolean r7 = android.text.TextUtils.isEmpty(r27)     // Catch:{ all -> 0x0997 }
            if (r7 != 0) goto L_0x07c3
            r7 = r27
            r5.zzn(r7)     // Catch:{ all -> 0x0997 }
        L_0x07c3:
            com.google.android.gms.measurement.internal.zzac r7 = r26.zze()     // Catch:{ all -> 0x0997 }
            java.lang.String r8 = r3.zza     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzg r7 = r7.zzb(r8)     // Catch:{ all -> 0x0997 }
            if (r7 != 0) goto L_0x0836
            com.google.android.gms.measurement.internal.zzg r7 = new com.google.android.gms.measurement.internal.zzg     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzgo r8 = r1.zzj     // Catch:{ all -> 0x0997 }
            java.lang.String r11 = r3.zza     // Catch:{ all -> 0x0997 }
            r7.<init>(r8, r11)     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzgo r8 = r1.zzj     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzla r8 = r8.zzi()     // Catch:{ all -> 0x0997 }
            java.lang.String r8 = r8.zzk()     // Catch:{ all -> 0x0997 }
            r7.zza(r8)     // Catch:{ all -> 0x0997 }
            java.lang.String r8 = r3.zzk     // Catch:{ all -> 0x0997 }
            r7.zzf(r8)     // Catch:{ all -> 0x0997 }
            java.lang.String r8 = r3.zzb     // Catch:{ all -> 0x0997 }
            r7.zzb(r8)     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzgo r8 = r1.zzj     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzft r8 = r8.zzc()     // Catch:{ all -> 0x0997 }
            java.lang.String r11 = r3.zza     // Catch:{ all -> 0x0997 }
            java.lang.String r8 = r8.zzb(r11)     // Catch:{ all -> 0x0997 }
            r7.zze(r8)     // Catch:{ all -> 0x0997 }
            r7.zzg(r9)     // Catch:{ all -> 0x0997 }
            r7.zza(r9)     // Catch:{ all -> 0x0997 }
            r7.zzb(r9)     // Catch:{ all -> 0x0997 }
            java.lang.String r8 = r3.zzc     // Catch:{ all -> 0x0997 }
            r7.zzg(r8)     // Catch:{ all -> 0x0997 }
            long r11 = r3.zzj     // Catch:{ all -> 0x0997 }
            r7.zzc(r11)     // Catch:{ all -> 0x0997 }
            java.lang.String r8 = r3.zzd     // Catch:{ all -> 0x0997 }
            r7.zzh(r8)     // Catch:{ all -> 0x0997 }
            long r11 = r3.zze     // Catch:{ all -> 0x0997 }
            r7.zzd(r11)     // Catch:{ all -> 0x0997 }
            long r11 = r3.zzf     // Catch:{ all -> 0x0997 }
            r7.zze(r11)     // Catch:{ all -> 0x0997 }
            boolean r8 = r3.zzh     // Catch:{ all -> 0x0997 }
            r7.zza(r8)     // Catch:{ all -> 0x0997 }
            long r11 = r3.zzl     // Catch:{ all -> 0x0997 }
            r7.zzp(r11)     // Catch:{ all -> 0x0997 }
            long r11 = r3.zzt     // Catch:{ all -> 0x0997 }
            r7.zzf(r11)     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzac r8 = r26.zze()     // Catch:{ all -> 0x0997 }
            r8.zza(r7)     // Catch:{ all -> 0x0997 }
        L_0x0836:
            java.lang.String r8 = r7.zzd()     // Catch:{ all -> 0x0997 }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0997 }
            if (r8 != 0) goto L_0x0847
            java.lang.String r8 = r7.zzd()     // Catch:{ all -> 0x0997 }
            r5.zzi(r8)     // Catch:{ all -> 0x0997 }
        L_0x0847:
            java.lang.String r8 = r7.zzi()     // Catch:{ all -> 0x0997 }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0997 }
            if (r8 != 0) goto L_0x0858
            java.lang.String r7 = r7.zzi()     // Catch:{ all -> 0x0997 }
            r5.zzl(r7)     // Catch:{ all -> 0x0997 }
        L_0x0858:
            com.google.android.gms.measurement.internal.zzac r7 = r26.zze()     // Catch:{ all -> 0x0997 }
            java.lang.String r8 = r3.zza     // Catch:{ all -> 0x0997 }
            java.util.List r7 = r7.zza(r8)     // Catch:{ all -> 0x0997 }
            r11 = 0
        L_0x0863:
            int r8 = r7.size()     // Catch:{ all -> 0x0997 }
            if (r11 >= r8) goto L_0x089a
            com.google.android.gms.internal.measurement.zzbr$zzk$zza r8 = com.google.android.gms.internal.measurement.zzbr.zzk.zzj()     // Catch:{ all -> 0x0997 }
            java.lang.Object r12 = r7.get(r11)     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzlb r12 = (com.google.android.gms.measurement.internal.zzlb) r12     // Catch:{ all -> 0x0997 }
            java.lang.String r12 = r12.zzc     // Catch:{ all -> 0x0997 }
            com.google.android.gms.internal.measurement.zzbr$zzk$zza r8 = r8.zza(r12)     // Catch:{ all -> 0x0997 }
            java.lang.Object r12 = r7.get(r11)     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzlb r12 = (com.google.android.gms.measurement.internal.zzlb) r12     // Catch:{ all -> 0x0997 }
            long r12 = r12.zzd     // Catch:{ all -> 0x0997 }
            com.google.android.gms.internal.measurement.zzbr$zzk$zza r8 = r8.zza(r12)     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzkw r12 = r26.zzh()     // Catch:{ all -> 0x0997 }
            java.lang.Object r13 = r7.get(r11)     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzlb r13 = (com.google.android.gms.measurement.internal.zzlb) r13     // Catch:{ all -> 0x0997 }
            java.lang.Object r13 = r13.zze     // Catch:{ all -> 0x0997 }
            r12.zza(r8, r13)     // Catch:{ all -> 0x0997 }
            r5.zza(r8)     // Catch:{ all -> 0x0997 }
            int r11 = r11 + 1
            goto L_0x0863
        L_0x089a:
            com.google.android.gms.measurement.internal.zzac r7 = r26.zze()     // Catch:{ IOException -> 0x090f }
            com.google.android.gms.internal.measurement.zzgo r8 = r5.zzu()     // Catch:{ IOException -> 0x090f }
            com.google.android.gms.internal.measurement.zzfd r8 = (com.google.android.gms.internal.measurement.zzfd) r8     // Catch:{ IOException -> 0x090f }
            com.google.android.gms.internal.measurement.zzbr$zzg r8 = (com.google.android.gms.internal.measurement.zzbr.zzg) r8     // Catch:{ IOException -> 0x090f }
            long r7 = r7.zza(r8)     // Catch:{ IOException -> 0x090f }
            com.google.android.gms.measurement.internal.zzac r5 = r26.zze()     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzam r11 = r4.zze     // Catch:{ all -> 0x0997 }
            if (r11 == 0) goto L_0x0905
            com.google.android.gms.measurement.internal.zzam r11 = r4.zze     // Catch:{ all -> 0x0997 }
            java.util.Iterator r11 = r11.iterator()     // Catch:{ all -> 0x0997 }
        L_0x08b8:
            boolean r12 = r11.hasNext()     // Catch:{ all -> 0x0997 }
            if (r12 == 0) goto L_0x08cc
            java.lang.Object r12 = r11.next()     // Catch:{ all -> 0x0997 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ all -> 0x0997 }
            boolean r12 = r2.equals(r12)     // Catch:{ all -> 0x0997 }
            if (r12 == 0) goto L_0x08b8
        L_0x08ca:
            r11 = r6
            goto L_0x0906
        L_0x08cc:
            com.google.android.gms.measurement.internal.zzgi r2 = r26.zzc()     // Catch:{ all -> 0x0997 }
            java.lang.String r11 = r4.zza     // Catch:{ all -> 0x0997 }
            java.lang.String r12 = r4.zzb     // Catch:{ all -> 0x0997 }
            boolean r2 = r2.zzc(r11, r12)     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzac r11 = r26.zze()     // Catch:{ all -> 0x0997 }
            long r12 = r26.zzx()     // Catch:{ all -> 0x0997 }
            java.lang.String r14 = r4.zza     // Catch:{ all -> 0x0997 }
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            com.google.android.gms.measurement.internal.zzab r11 = r11.zza(r12, r14, r15, r16, r17, r18, r19)     // Catch:{ all -> 0x0997 }
            if (r2 == 0) goto L_0x0905
            long r11 = r11.zze     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzx r2 = r2.zzb()     // Catch:{ all -> 0x0997 }
            java.lang.String r13 = r4.zza     // Catch:{ all -> 0x0997 }
            int r2 = r2.zzb(r13)     // Catch:{ all -> 0x0997 }
            long r13 = (long) r2     // Catch:{ all -> 0x0997 }
            int r2 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r2 >= 0) goto L_0x0905
            goto L_0x08ca
        L_0x0905:
            r11 = 0
        L_0x0906:
            boolean r2 = r5.zza(r4, r7, r11)     // Catch:{ all -> 0x0997 }
            if (r2 == 0) goto L_0x0928
            r1.zzm = r9     // Catch:{ all -> 0x0997 }
            goto L_0x0928
        L_0x090f:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.measurement.internal.zzgo r6 = r1.zzj     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzfk r6 = r6.zzr()     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzfm r6 = r6.zzf()     // Catch:{ all -> 0x0997 }
            java.lang.String r7 = "Data loss. Failed to insert raw event metadata. appId"
            java.lang.String r5 = r5.zzj()     // Catch:{ all -> 0x0997 }
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzfk.zza(r5)     // Catch:{ all -> 0x0997 }
            r6.zza(r7, r5, r2)     // Catch:{ all -> 0x0997 }
        L_0x0928:
            com.google.android.gms.measurement.internal.zzac r2 = r26.zze()     // Catch:{ all -> 0x0997 }
            r2.b_()     // Catch:{ all -> 0x0997 }
            boolean r2 = com.google.android.gms.internal.measurement.zzky.zzb()     // Catch:{ all -> 0x0997 }
            if (r2 == 0) goto L_0x0945
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzx r2 = r2.zzb()     // Catch:{ all -> 0x0997 }
            java.lang.String r3 = r3.zza     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r5 = com.google.android.gms.measurement.internal.zzap.zzcz     // Catch:{ all -> 0x0997 }
            boolean r2 = r2.zze(r3, r5)     // Catch:{ all -> 0x0997 }
            if (r2 != 0) goto L_0x096b
        L_0x0945:
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzfk r2 = r2.zzr()     // Catch:{ all -> 0x0997 }
            r3 = 2
            boolean r2 = r2.zza(r3)     // Catch:{ all -> 0x0997 }
            if (r2 == 0) goto L_0x096b
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzfk r2 = r2.zzr()     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzfm r2 = r2.zzx()     // Catch:{ all -> 0x0997 }
            java.lang.String r3 = "Event recorded"
            com.google.android.gms.measurement.internal.zzgo r5 = r1.zzj     // Catch:{ all -> 0x0997 }
            com.google.android.gms.measurement.internal.zzfi r5 = r5.zzj()     // Catch:{ all -> 0x0997 }
            java.lang.String r4 = r5.zza(r4)     // Catch:{ all -> 0x0997 }
            r2.zza(r3, r4)     // Catch:{ all -> 0x0997 }
        L_0x096b:
            com.google.android.gms.measurement.internal.zzac r2 = r26.zze()
            r2.zzh()
            r26.zzz()
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj
            com.google.android.gms.measurement.internal.zzfk r2 = r2.zzr()
            com.google.android.gms.measurement.internal.zzfm r2 = r2.zzx()
            long r3 = java.lang.System.nanoTime()
            long r3 = r3 - r23
            r5 = 500000(0x7a120, double:2.47033E-318)
            long r3 = r3 + r5
            r5 = 1000000(0xf4240, double:4.940656E-318)
            long r3 = r3 / r5
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            java.lang.String r4 = "Background event processing time, ms"
            r2.zza(r4, r3)
            return
        L_0x0997:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.measurement.internal.zzac r3 = r26.zze()
            r3.zzh()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzks.zzb(com.google.android.gms.measurement.internal.zzan, com.google.android.gms.measurement.internal.zzm):void");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:100|101) */
    /* JADX WARNING: Code restructure failed: missing block: B:101:?, code lost:
        r15.zzj.zzr().zzf().zza("Failed to parse upload URL. Not uploading. appId", com.google.android.gms.measurement.internal.zzfk.zza(r4), r7);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:100:0x02df */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzl() {
        /*
            r15 = this;
            r15.zzw()
            r15.zzk()
            r0 = 1
            r15.zzs = r0
            r1 = 0
            com.google.android.gms.measurement.internal.zzgo r2 = r15.zzj     // Catch:{ all -> 0x031b }
            r2.zzu()     // Catch:{ all -> 0x031b }
            com.google.android.gms.measurement.internal.zzgo r2 = r15.zzj     // Catch:{ all -> 0x031b }
            com.google.android.gms.measurement.internal.zzix r2 = r2.zzw()     // Catch:{ all -> 0x031b }
            java.lang.Boolean r2 = r2.zzag()     // Catch:{ all -> 0x031b }
            if (r2 != 0) goto L_0x0030
            com.google.android.gms.measurement.internal.zzgo r0 = r15.zzj     // Catch:{ all -> 0x031b }
            com.google.android.gms.measurement.internal.zzfk r0 = r0.zzr()     // Catch:{ all -> 0x031b }
            com.google.android.gms.measurement.internal.zzfm r0 = r0.zzi()     // Catch:{ all -> 0x031b }
            java.lang.String r2 = "Upload data called on the client side before use of service was decided"
            r0.zza(r2)     // Catch:{ all -> 0x031b }
            r15.zzs = r1
            r15.zzaa()
            return
        L_0x0030:
            boolean r2 = r2.booleanValue()     // Catch:{ all -> 0x031b }
            if (r2 == 0) goto L_0x004b
            com.google.android.gms.measurement.internal.zzgo r0 = r15.zzj     // Catch:{ all -> 0x031b }
            com.google.android.gms.measurement.internal.zzfk r0 = r0.zzr()     // Catch:{ all -> 0x031b }
            com.google.android.gms.measurement.internal.zzfm r0 = r0.zzf()     // Catch:{ all -> 0x031b }
            java.lang.String r2 = "Upload called in the client side when service should be used"
            r0.zza(r2)     // Catch:{ all -> 0x031b }
            r15.zzs = r1
            r15.zzaa()
            return
        L_0x004b:
            long r2 = r15.zzm     // Catch:{ all -> 0x031b }
            r4 = 0
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 <= 0) goto L_0x005c
            r15.zzz()     // Catch:{ all -> 0x031b }
            r15.zzs = r1
            r15.zzaa()
            return
        L_0x005c:
            r15.zzw()     // Catch:{ all -> 0x031b }
            java.util.List<java.lang.Long> r2 = r15.zzv     // Catch:{ all -> 0x031b }
            if (r2 == 0) goto L_0x0065
            r2 = r0
            goto L_0x0066
        L_0x0065:
            r2 = r1
        L_0x0066:
            if (r2 == 0) goto L_0x007d
            com.google.android.gms.measurement.internal.zzgo r0 = r15.zzj     // Catch:{ all -> 0x031b }
            com.google.android.gms.measurement.internal.zzfk r0 = r0.zzr()     // Catch:{ all -> 0x031b }
            com.google.android.gms.measurement.internal.zzfm r0 = r0.zzx()     // Catch:{ all -> 0x031b }
            java.lang.String r2 = "Uploading requested multiple times"
            r0.zza(r2)     // Catch:{ all -> 0x031b }
            r15.zzs = r1
            r15.zzaa()
            return
        L_0x007d:
            com.google.android.gms.measurement.internal.zzfo r2 = r15.zzd()     // Catch:{ all -> 0x031b }
            boolean r2 = r2.zzf()     // Catch:{ all -> 0x031b }
            if (r2 != 0) goto L_0x009f
            com.google.android.gms.measurement.internal.zzgo r0 = r15.zzj     // Catch:{ all -> 0x031b }
            com.google.android.gms.measurement.internal.zzfk r0 = r0.zzr()     // Catch:{ all -> 0x031b }
            com.google.android.gms.measurement.internal.zzfm r0 = r0.zzx()     // Catch:{ all -> 0x031b }
            java.lang.String r2 = "Network not connected, ignoring upload request"
            r0.zza(r2)     // Catch:{ all -> 0x031b }
            r15.zzz()     // Catch:{ all -> 0x031b }
            r15.zzs = r1
            r15.zzaa()
            return
        L_0x009f:
            com.google.android.gms.measurement.internal.zzgo r2 = r15.zzj     // Catch:{ all -> 0x031b }
            com.google.android.gms.common.util.Clock r2 = r2.zzm()     // Catch:{ all -> 0x031b }
            long r2 = r2.currentTimeMillis()     // Catch:{ all -> 0x031b }
            boolean r6 = com.google.android.gms.internal.measurement.zzlx.zzb()     // Catch:{ all -> 0x031b }
            r7 = 0
            if (r6 == 0) goto L_0x00bd
            com.google.android.gms.measurement.internal.zzgo r6 = r15.zzj     // Catch:{ all -> 0x031b }
            com.google.android.gms.measurement.internal.zzx r6 = r6.zzb()     // Catch:{ all -> 0x031b }
            com.google.android.gms.measurement.internal.zzez<java.lang.Integer> r8 = com.google.android.gms.measurement.internal.zzap.zzao     // Catch:{ all -> 0x031b }
            int r6 = r6.zzb(r7, r8)     // Catch:{ all -> 0x031b }
            goto L_0x00be
        L_0x00bd:
            r6 = r0
        L_0x00be:
            if (r6 <= r0) goto L_0x00d2
            long r8 = com.google.android.gms.measurement.internal.zzx.zzk()     // Catch:{ all -> 0x031b }
            long r8 = r2 - r8
            r10 = r1
        L_0x00c7:
            if (r10 >= r6) goto L_0x00db
            boolean r11 = r15.zza(r7, r8)     // Catch:{ all -> 0x031b }
            if (r11 == 0) goto L_0x00db
            int r10 = r10 + 1
            goto L_0x00c7
        L_0x00d2:
            long r8 = com.google.android.gms.measurement.internal.zzx.zzk()     // Catch:{ all -> 0x031b }
            long r8 = r2 - r8
            r15.zza(r7, r8)     // Catch:{ all -> 0x031b }
        L_0x00db:
            com.google.android.gms.measurement.internal.zzgo r6 = r15.zzj     // Catch:{ all -> 0x031b }
            com.google.android.gms.measurement.internal.zzft r6 = r6.zzc()     // Catch:{ all -> 0x031b }
            com.google.android.gms.measurement.internal.zzfy r6 = r6.zzc     // Catch:{ all -> 0x031b }
            long r8 = r6.zza()     // Catch:{ all -> 0x031b }
            int r4 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r4 == 0) goto L_0x0104
            com.google.android.gms.measurement.internal.zzgo r4 = r15.zzj     // Catch:{ all -> 0x031b }
            com.google.android.gms.measurement.internal.zzfk r4 = r4.zzr()     // Catch:{ all -> 0x031b }
            com.google.android.gms.measurement.internal.zzfm r4 = r4.zzw()     // Catch:{ all -> 0x031b }
            java.lang.String r5 = "Uploading events. Elapsed time since last upload attempt (ms)"
            long r8 = r2 - r8
            long r8 = java.lang.Math.abs(r8)     // Catch:{ all -> 0x031b }
            java.lang.Long r6 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x031b }
            r4.zza(r5, r6)     // Catch:{ all -> 0x031b }
        L_0x0104:
            com.google.android.gms.measurement.internal.zzac r4 = r15.zze()     // Catch:{ all -> 0x031b }
            java.lang.String r4 = r4.d_()     // Catch:{ all -> 0x031b }
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x031b }
            r8 = -1
            if (r5 != 0) goto L_0x02f3
            long r5 = r15.zzx     // Catch:{ all -> 0x031b }
            int r5 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r5 != 0) goto L_0x0124
            com.google.android.gms.measurement.internal.zzac r5 = r15.zze()     // Catch:{ all -> 0x031b }
            long r5 = r5.zzaa()     // Catch:{ all -> 0x031b }
            r15.zzx = r5     // Catch:{ all -> 0x031b }
        L_0x0124:
            com.google.android.gms.measurement.internal.zzgo r5 = r15.zzj     // Catch:{ all -> 0x031b }
            com.google.android.gms.measurement.internal.zzx r5 = r5.zzb()     // Catch:{ all -> 0x031b }
            com.google.android.gms.measurement.internal.zzez<java.lang.Integer> r6 = com.google.android.gms.measurement.internal.zzap.zzf     // Catch:{ all -> 0x031b }
            int r5 = r5.zzb(r4, r6)     // Catch:{ all -> 0x031b }
            com.google.android.gms.measurement.internal.zzgo r6 = r15.zzj     // Catch:{ all -> 0x031b }
            com.google.android.gms.measurement.internal.zzx r6 = r6.zzb()     // Catch:{ all -> 0x031b }
            com.google.android.gms.measurement.internal.zzez<java.lang.Integer> r8 = com.google.android.gms.measurement.internal.zzap.zzg     // Catch:{ all -> 0x031b }
            int r6 = r6.zzb(r4, r8)     // Catch:{ all -> 0x031b }
            int r6 = java.lang.Math.max(r1, r6)     // Catch:{ all -> 0x031b }
            com.google.android.gms.measurement.internal.zzac r8 = r15.zze()     // Catch:{ all -> 0x031b }
            java.util.List r5 = r8.zza(r4, r5, r6)     // Catch:{ all -> 0x031b }
            boolean r6 = r5.isEmpty()     // Catch:{ all -> 0x031b }
            if (r6 != 0) goto L_0x0315
            java.util.Iterator r6 = r5.iterator()     // Catch:{ all -> 0x031b }
        L_0x0152:
            boolean r8 = r6.hasNext()     // Catch:{ all -> 0x031b }
            if (r8 == 0) goto L_0x0171
            java.lang.Object r8 = r6.next()     // Catch:{ all -> 0x031b }
            android.util.Pair r8 = (android.util.Pair) r8     // Catch:{ all -> 0x031b }
            java.lang.Object r8 = r8.first     // Catch:{ all -> 0x031b }
            com.google.android.gms.internal.measurement.zzbr$zzg r8 = (com.google.android.gms.internal.measurement.zzbr.zzg) r8     // Catch:{ all -> 0x031b }
            java.lang.String r9 = r8.zzad()     // Catch:{ all -> 0x031b }
            boolean r9 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x031b }
            if (r9 != 0) goto L_0x0152
            java.lang.String r6 = r8.zzad()     // Catch:{ all -> 0x031b }
            goto L_0x0172
        L_0x0171:
            r6 = r7
        L_0x0172:
            if (r6 == 0) goto L_0x01a1
            r8 = r1
        L_0x0175:
            int r9 = r5.size()     // Catch:{ all -> 0x031b }
            if (r8 >= r9) goto L_0x01a1
            java.lang.Object r9 = r5.get(r8)     // Catch:{ all -> 0x031b }
            android.util.Pair r9 = (android.util.Pair) r9     // Catch:{ all -> 0x031b }
            java.lang.Object r9 = r9.first     // Catch:{ all -> 0x031b }
            com.google.android.gms.internal.measurement.zzbr$zzg r9 = (com.google.android.gms.internal.measurement.zzbr.zzg) r9     // Catch:{ all -> 0x031b }
            java.lang.String r10 = r9.zzad()     // Catch:{ all -> 0x031b }
            boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x031b }
            if (r10 != 0) goto L_0x019e
            java.lang.String r9 = r9.zzad()     // Catch:{ all -> 0x031b }
            boolean r9 = r9.equals(r6)     // Catch:{ all -> 0x031b }
            if (r9 != 0) goto L_0x019e
            java.util.List r5 = r5.subList(r1, r8)     // Catch:{ all -> 0x031b }
            goto L_0x01a1
        L_0x019e:
            int r8 = r8 + 1
            goto L_0x0175
        L_0x01a1:
            com.google.android.gms.internal.measurement.zzbr$zzf$zza r6 = com.google.android.gms.internal.measurement.zzbr.zzf.zzb()     // Catch:{ all -> 0x031b }
            int r8 = r5.size()     // Catch:{ all -> 0x031b }
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ all -> 0x031b }
            int r10 = r5.size()     // Catch:{ all -> 0x031b }
            r9.<init>(r10)     // Catch:{ all -> 0x031b }
            com.google.android.gms.measurement.internal.zzgo r10 = r15.zzj     // Catch:{ all -> 0x031b }
            com.google.android.gms.measurement.internal.zzx r10 = r10.zzb()     // Catch:{ all -> 0x031b }
            boolean r10 = r10.zzf(r4)     // Catch:{ all -> 0x031b }
            r11 = r1
        L_0x01bd:
            if (r11 >= r8) goto L_0x0228
            java.lang.Object r12 = r5.get(r11)     // Catch:{ all -> 0x031b }
            android.util.Pair r12 = (android.util.Pair) r12     // Catch:{ all -> 0x031b }
            java.lang.Object r12 = r12.first     // Catch:{ all -> 0x031b }
            com.google.android.gms.internal.measurement.zzbr$zzg r12 = (com.google.android.gms.internal.measurement.zzbr.zzg) r12     // Catch:{ all -> 0x031b }
            com.google.android.gms.internal.measurement.zzfd$zzb r12 = r12.zzbm()     // Catch:{ all -> 0x031b }
            com.google.android.gms.internal.measurement.zzfd$zzb r12 = (com.google.android.gms.internal.measurement.zzfd.zzb) r12     // Catch:{ all -> 0x031b }
            com.google.android.gms.internal.measurement.zzbr$zzg$zza r12 = (com.google.android.gms.internal.measurement.zzbr.zzg.zza) r12     // Catch:{ all -> 0x031b }
            java.lang.Object r13 = r5.get(r11)     // Catch:{ all -> 0x031b }
            android.util.Pair r13 = (android.util.Pair) r13     // Catch:{ all -> 0x031b }
            java.lang.Object r13 = r13.second     // Catch:{ all -> 0x031b }
            java.lang.Long r13 = (java.lang.Long) r13     // Catch:{ all -> 0x031b }
            r9.add(r13)     // Catch:{ all -> 0x031b }
            com.google.android.gms.measurement.internal.zzgo r13 = r15.zzj     // Catch:{ all -> 0x031b }
            com.google.android.gms.measurement.internal.zzx r13 = r13.zzb()     // Catch:{ all -> 0x031b }
            long r13 = r13.zze()     // Catch:{ all -> 0x031b }
            com.google.android.gms.internal.measurement.zzbr$zzg$zza r13 = r12.zzg(r13)     // Catch:{ all -> 0x031b }
            com.google.android.gms.internal.measurement.zzbr$zzg$zza r13 = r13.zza(r2)     // Catch:{ all -> 0x031b }
            com.google.android.gms.measurement.internal.zzgo r14 = r15.zzj     // Catch:{ all -> 0x031b }
            r14.zzu()     // Catch:{ all -> 0x031b }
            r13.zzb(r1)     // Catch:{ all -> 0x031b }
            if (r10 != 0) goto L_0x01fd
            r12.zzn()     // Catch:{ all -> 0x031b }
        L_0x01fd:
            com.google.android.gms.measurement.internal.zzgo r13 = r15.zzj     // Catch:{ all -> 0x031b }
            com.google.android.gms.measurement.internal.zzx r13 = r13.zzb()     // Catch:{ all -> 0x031b }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r14 = com.google.android.gms.measurement.internal.zzap.zzbg     // Catch:{ all -> 0x031b }
            boolean r13 = r13.zze(r4, r14)     // Catch:{ all -> 0x031b }
            if (r13 == 0) goto L_0x0222
            com.google.android.gms.internal.measurement.zzgo r13 = r12.zzu()     // Catch:{ all -> 0x031b }
            com.google.android.gms.internal.measurement.zzfd r13 = (com.google.android.gms.internal.measurement.zzfd) r13     // Catch:{ all -> 0x031b }
            com.google.android.gms.internal.measurement.zzbr$zzg r13 = (com.google.android.gms.internal.measurement.zzbr.zzg) r13     // Catch:{ all -> 0x031b }
            byte[] r13 = r13.zzbi()     // Catch:{ all -> 0x031b }
            com.google.android.gms.measurement.internal.zzkw r14 = r15.zzh()     // Catch:{ all -> 0x031b }
            long r13 = r14.zza(r13)     // Catch:{ all -> 0x031b }
            r12.zzl(r13)     // Catch:{ all -> 0x031b }
        L_0x0222:
            r6.zza(r12)     // Catch:{ all -> 0x031b }
            int r11 = r11 + 1
            goto L_0x01bd
        L_0x0228:
            com.google.android.gms.measurement.internal.zzgo r5 = r15.zzj     // Catch:{ all -> 0x031b }
            com.google.android.gms.measurement.internal.zzfk r5 = r5.zzr()     // Catch:{ all -> 0x031b }
            r10 = 2
            boolean r5 = r5.zza(r10)     // Catch:{ all -> 0x031b }
            if (r5 == 0) goto L_0x0246
            com.google.android.gms.measurement.internal.zzkw r5 = r15.zzh()     // Catch:{ all -> 0x031b }
            com.google.android.gms.internal.measurement.zzgo r10 = r6.zzu()     // Catch:{ all -> 0x031b }
            com.google.android.gms.internal.measurement.zzfd r10 = (com.google.android.gms.internal.measurement.zzfd) r10     // Catch:{ all -> 0x031b }
            com.google.android.gms.internal.measurement.zzbr$zzf r10 = (com.google.android.gms.internal.measurement.zzbr.zzf) r10     // Catch:{ all -> 0x031b }
            java.lang.String r5 = r5.zza(r10)     // Catch:{ all -> 0x031b }
            goto L_0x0247
        L_0x0246:
            r5 = r7
        L_0x0247:
            r15.zzh()     // Catch:{ all -> 0x031b }
            com.google.android.gms.internal.measurement.zzgo r10 = r6.zzu()     // Catch:{ all -> 0x031b }
            com.google.android.gms.internal.measurement.zzfd r10 = (com.google.android.gms.internal.measurement.zzfd) r10     // Catch:{ all -> 0x031b }
            com.google.android.gms.internal.measurement.zzbr$zzf r10 = (com.google.android.gms.internal.measurement.zzbr.zzf) r10     // Catch:{ all -> 0x031b }
            byte[] r12 = r10.zzbi()     // Catch:{ all -> 0x031b }
            com.google.android.gms.measurement.internal.zzez<java.lang.String> r10 = com.google.android.gms.measurement.internal.zzap.zzp     // Catch:{ all -> 0x031b }
            java.lang.Object r7 = r10.zza(r7)     // Catch:{ all -> 0x031b }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x031b }
            java.net.URL r11 = new java.net.URL     // Catch:{ MalformedURLException -> 0x02df }
            r11.<init>(r7)     // Catch:{ MalformedURLException -> 0x02df }
            boolean r10 = r9.isEmpty()     // Catch:{ MalformedURLException -> 0x02df }
            if (r10 != 0) goto L_0x026b
            r10 = r0
            goto L_0x026c
        L_0x026b:
            r10 = r1
        L_0x026c:
            com.google.android.gms.common.internal.Preconditions.checkArgument(r10)     // Catch:{ MalformedURLException -> 0x02df }
            java.util.List<java.lang.Long> r10 = r15.zzv     // Catch:{ MalformedURLException -> 0x02df }
            if (r10 == 0) goto L_0x0283
            com.google.android.gms.measurement.internal.zzgo r9 = r15.zzj     // Catch:{ MalformedURLException -> 0x02df }
            com.google.android.gms.measurement.internal.zzfk r9 = r9.zzr()     // Catch:{ MalformedURLException -> 0x02df }
            com.google.android.gms.measurement.internal.zzfm r9 = r9.zzf()     // Catch:{ MalformedURLException -> 0x02df }
            java.lang.String r10 = "Set uploading progress before finishing the previous upload"
            r9.zza(r10)     // Catch:{ MalformedURLException -> 0x02df }
            goto L_0x028a
        L_0x0283:
            java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ MalformedURLException -> 0x02df }
            r10.<init>(r9)     // Catch:{ MalformedURLException -> 0x02df }
            r15.zzv = r10     // Catch:{ MalformedURLException -> 0x02df }
        L_0x028a:
            com.google.android.gms.measurement.internal.zzgo r9 = r15.zzj     // Catch:{ MalformedURLException -> 0x02df }
            com.google.android.gms.measurement.internal.zzft r9 = r9.zzc()     // Catch:{ MalformedURLException -> 0x02df }
            com.google.android.gms.measurement.internal.zzfy r9 = r9.zzd     // Catch:{ MalformedURLException -> 0x02df }
            r9.zza(r2)     // Catch:{ MalformedURLException -> 0x02df }
            java.lang.String r2 = "?"
            if (r8 <= 0) goto L_0x02a1
            com.google.android.gms.internal.measurement.zzbr$zzg r2 = r6.zza(r1)     // Catch:{ MalformedURLException -> 0x02df }
            java.lang.String r2 = r2.zzx()     // Catch:{ MalformedURLException -> 0x02df }
        L_0x02a1:
            com.google.android.gms.measurement.internal.zzgo r3 = r15.zzj     // Catch:{ MalformedURLException -> 0x02df }
            com.google.android.gms.measurement.internal.zzfk r3 = r3.zzr()     // Catch:{ MalformedURLException -> 0x02df }
            com.google.android.gms.measurement.internal.zzfm r3 = r3.zzx()     // Catch:{ MalformedURLException -> 0x02df }
            java.lang.String r6 = "Uploading data. app, uncompressed size, data"
            int r8 = r12.length     // Catch:{ MalformedURLException -> 0x02df }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ MalformedURLException -> 0x02df }
            r3.zza(r6, r2, r8, r5)     // Catch:{ MalformedURLException -> 0x02df }
            r15.zzr = r0     // Catch:{ MalformedURLException -> 0x02df }
            com.google.android.gms.measurement.internal.zzfo r9 = r15.zzd()     // Catch:{ MalformedURLException -> 0x02df }
            com.google.android.gms.measurement.internal.zzku r14 = new com.google.android.gms.measurement.internal.zzku     // Catch:{ MalformedURLException -> 0x02df }
            r14.<init>(r15, r4)     // Catch:{ MalformedURLException -> 0x02df }
            r9.zzd()     // Catch:{ MalformedURLException -> 0x02df }
            r9.zzak()     // Catch:{ MalformedURLException -> 0x02df }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r11)     // Catch:{ MalformedURLException -> 0x02df }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r12)     // Catch:{ MalformedURLException -> 0x02df }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r14)     // Catch:{ MalformedURLException -> 0x02df }
            com.google.android.gms.measurement.internal.zzgh r0 = r9.zzq()     // Catch:{ MalformedURLException -> 0x02df }
            com.google.android.gms.measurement.internal.zzfs r2 = new com.google.android.gms.measurement.internal.zzfs     // Catch:{ MalformedURLException -> 0x02df }
            r13 = 0
            r8 = r2
            r10 = r4
            r8.<init>(r9, r10, r11, r12, r13, r14)     // Catch:{ MalformedURLException -> 0x02df }
            r0.zzb(r2)     // Catch:{ MalformedURLException -> 0x02df }
            goto L_0x0315
        L_0x02df:
            com.google.android.gms.measurement.internal.zzgo r0 = r15.zzj     // Catch:{ all -> 0x031b }
            com.google.android.gms.measurement.internal.zzfk r0 = r0.zzr()     // Catch:{ all -> 0x031b }
            com.google.android.gms.measurement.internal.zzfm r0 = r0.zzf()     // Catch:{ all -> 0x031b }
            java.lang.String r2 = "Failed to parse upload URL. Not uploading. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzfk.zza(r4)     // Catch:{ all -> 0x031b }
            r0.zza(r2, r3, r7)     // Catch:{ all -> 0x031b }
            goto L_0x0315
        L_0x02f3:
            r15.zzx = r8     // Catch:{ all -> 0x031b }
            com.google.android.gms.measurement.internal.zzac r0 = r15.zze()     // Catch:{ all -> 0x031b }
            long r4 = com.google.android.gms.measurement.internal.zzx.zzk()     // Catch:{ all -> 0x031b }
            long r2 = r2 - r4
            java.lang.String r0 = r0.zza(r2)     // Catch:{ all -> 0x031b }
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x031b }
            if (r2 != 0) goto L_0x0315
            com.google.android.gms.measurement.internal.zzac r2 = r15.zze()     // Catch:{ all -> 0x031b }
            com.google.android.gms.measurement.internal.zzg r0 = r2.zzb(r0)     // Catch:{ all -> 0x031b }
            if (r0 == 0) goto L_0x0315
            r15.zza(r0)     // Catch:{ all -> 0x031b }
        L_0x0315:
            r15.zzs = r1
            r15.zzaa()
            return
        L_0x031b:
            r0 = move-exception
            r15.zzs = r1
            r15.zzaa()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzks.zzl():void");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.measurement.internal.zzks.zza(com.google.android.gms.internal.measurement.zzbr$zzg$zza, long, boolean):void
     arg types: [com.google.android.gms.internal.measurement.zzbr$zzg$zza, long, int]
     candidates:
      com.google.android.gms.measurement.internal.zzks.zza(com.google.android.gms.measurement.internal.zzm, com.google.android.gms.measurement.internal.zzg, java.lang.String):com.google.android.gms.measurement.internal.zzg
      com.google.android.gms.measurement.internal.zzks.zza(com.google.android.gms.internal.measurement.zzbr$zzc$zza, int, java.lang.String):void
      com.google.android.gms.measurement.internal.zzks.zza(com.google.android.gms.internal.measurement.zzbr$zzg$zza, long, boolean):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.measurement.internal.zzkw.zza(com.google.android.gms.internal.measurement.zzbr$zzc$zza, java.lang.String, java.lang.Object):void
     arg types: [com.google.android.gms.internal.measurement.zzbr$zzc$zza, java.lang.String, long]
     candidates:
      com.google.android.gms.measurement.internal.zzkw.zza(boolean, boolean, boolean):java.lang.String
      com.google.android.gms.measurement.internal.zzkw.zza(java.lang.StringBuilder, int, com.google.android.gms.internal.measurement.zzbj$zzc):void
      com.google.android.gms.measurement.internal.zzkw.zza(java.lang.StringBuilder, int, java.util.List<com.google.android.gms.internal.measurement.zzbr$zze>):void
      com.google.android.gms.measurement.internal.zzkw.zza(com.google.android.gms.internal.measurement.zzbr$zzc$zza, java.lang.String, java.lang.Object):void */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x024e A[SYNTHETIC, Splitter:B:114:0x024e] */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0255 A[Catch:{ IOException -> 0x0213, all -> 0x0f85 }] */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0263 A[Catch:{ IOException -> 0x0213, all -> 0x0f85 }] */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x03a4 A[Catch:{ IOException -> 0x0213, all -> 0x0f85 }] */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x03af A[Catch:{ IOException -> 0x0213, all -> 0x0f85 }] */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x03b0 A[Catch:{ IOException -> 0x0213, all -> 0x0f85 }] */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x03cd A[SYNTHETIC, Splitter:B:182:0x03cd] */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x0472 A[Catch:{ IOException -> 0x0213, all -> 0x0f85 }] */
    /* JADX WARNING: Removed duplicated region for block: B:199:0x04d3 A[Catch:{ IOException -> 0x0213, all -> 0x0f85 }] */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x04d7 A[Catch:{ IOException -> 0x0213, all -> 0x0f85 }] */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x053d A[Catch:{ IOException -> 0x0213, all -> 0x0f85 }] */
    /* JADX WARNING: Removed duplicated region for block: B:221:0x0577 A[Catch:{ IOException -> 0x0213, all -> 0x0f85 }] */
    /* JADX WARNING: Removed duplicated region for block: B:222:0x0596 A[Catch:{ IOException -> 0x0213, all -> 0x0f85 }] */
    /* JADX WARNING: Removed duplicated region for block: B:263:0x068a A[Catch:{ IOException -> 0x0213, all -> 0x0f85 }] */
    /* JADX WARNING: Removed duplicated region for block: B:300:0x0796 A[Catch:{ IOException -> 0x0213, all -> 0x0f85 }] */
    /* JADX WARNING: Removed duplicated region for block: B:306:0x07b0 A[Catch:{ IOException -> 0x0213, all -> 0x0f85 }] */
    /* JADX WARNING: Removed duplicated region for block: B:307:0x07ca A[Catch:{ IOException -> 0x0213, all -> 0x0f85 }] */
    /* JADX WARNING: Removed duplicated region for block: B:446:0x0b90 A[Catch:{ IOException -> 0x0213, all -> 0x0f85 }] */
    /* JADX WARNING: Removed duplicated region for block: B:447:0x0ba3 A[Catch:{ IOException -> 0x0213, all -> 0x0f85 }] */
    /* JADX WARNING: Removed duplicated region for block: B:449:0x0ba6 A[Catch:{ IOException -> 0x0213, all -> 0x0f85 }] */
    /* JADX WARNING: Removed duplicated region for block: B:450:0x0bcd A[SYNTHETIC, Splitter:B:450:0x0bcd] */
    /* JADX WARNING: Removed duplicated region for block: B:464:0x0c7e A[Catch:{ all -> 0x0dc5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:465:0x0c80 A[Catch:{ all -> 0x0dc5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:469:0x0c88 A[SYNTHETIC, Splitter:B:469:0x0c88] */
    /* JADX WARNING: Removed duplicated region for block: B:480:0x0cb6 A[SYNTHETIC, Splitter:B:480:0x0cb6] */
    /* JADX WARNING: Removed duplicated region for block: B:579:0x0f6d A[SYNTHETIC, Splitter:B:579:0x0f6d] */
    /* JADX WARNING: Removed duplicated region for block: B:586:0x0f81 A[SYNTHETIC, Splitter:B:586:0x0f81] */
    /* JADX WARNING: Removed duplicated region for block: B:597:0x043a A[EDGE_INSN: B:597:0x043a->B:191:0x043a ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zza(java.lang.String r58, long r59) {
        /*
            r57 = this;
            r1 = r57
            java.lang.String r2 = "_npa"
            com.google.android.gms.measurement.internal.zzac r3 = r57.zze()
            r3.zzf()
            com.google.android.gms.measurement.internal.zzks$zza r3 = new com.google.android.gms.measurement.internal.zzks$zza     // Catch:{ all -> 0x0f85 }
            r4 = 0
            r3.<init>(r1, r4)     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzac r5 = r57.zze()     // Catch:{ all -> 0x0f85 }
            long r6 = r1.zzx     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r3)     // Catch:{ all -> 0x0f85 }
            r5.zzd()     // Catch:{ all -> 0x0f85 }
            r5.zzak()     // Catch:{ all -> 0x0f85 }
            r9 = -1
            r11 = 2
            r12 = 0
            r13 = 1
            android.database.sqlite.SQLiteDatabase r15 = r5.c_()     // Catch:{ SQLiteException -> 0x0237, all -> 0x0232 }
            boolean r14 = android.text.TextUtils.isEmpty(r4)     // Catch:{ SQLiteException -> 0x0237, all -> 0x0232 }
            java.lang.String r16 = ""
            if (r14 == 0) goto L_0x0090
            int r14 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r14 == 0) goto L_0x0049
            java.lang.String[] r8 = new java.lang.String[r11]     // Catch:{ SQLiteException -> 0x0044 }
            java.lang.String r17 = java.lang.String.valueOf(r6)     // Catch:{ SQLiteException -> 0x0044 }
            r8[r12] = r17     // Catch:{ SQLiteException -> 0x0044 }
            java.lang.String r17 = java.lang.String.valueOf(r59)     // Catch:{ SQLiteException -> 0x0044 }
            r8[r13] = r17     // Catch:{ SQLiteException -> 0x0044 }
            goto L_0x0051
        L_0x0044:
            r0 = move-exception
            r6 = r0
            r8 = r4
            goto L_0x023b
        L_0x0049:
            java.lang.String[] r8 = new java.lang.String[r13]     // Catch:{ SQLiteException -> 0x0237, all -> 0x0232 }
            java.lang.String r17 = java.lang.String.valueOf(r59)     // Catch:{ SQLiteException -> 0x0237, all -> 0x0232 }
            r8[r12] = r17     // Catch:{ SQLiteException -> 0x0237, all -> 0x0232 }
        L_0x0051:
            if (r14 == 0) goto L_0x0055
            java.lang.String r16 = "rowid <= ? and "
        L_0x0055:
            r14 = r16
            int r4 = r14.length()     // Catch:{ SQLiteException -> 0x0237, all -> 0x0232 }
            int r4 = r4 + 148
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0237, all -> 0x0232 }
            r11.<init>(r4)     // Catch:{ SQLiteException -> 0x0237, all -> 0x0232 }
            java.lang.String r4 = "select app_id, metadata_fingerprint from raw_events where "
            r11.append(r4)     // Catch:{ SQLiteException -> 0x0237, all -> 0x0232 }
            r11.append(r14)     // Catch:{ SQLiteException -> 0x0237, all -> 0x0232 }
            java.lang.String r4 = "app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;"
            r11.append(r4)     // Catch:{ SQLiteException -> 0x0237, all -> 0x0232 }
            java.lang.String r4 = r11.toString()     // Catch:{ SQLiteException -> 0x0237, all -> 0x0232 }
            android.database.Cursor r4 = r15.rawQuery(r4, r8)     // Catch:{ SQLiteException -> 0x0237, all -> 0x0232 }
            boolean r8 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x022f }
            if (r8 != 0) goto L_0x0084
            if (r4 == 0) goto L_0x0251
            r4.close()     // Catch:{ all -> 0x0f85 }
            goto L_0x0251
        L_0x0084:
            java.lang.String r8 = r4.getString(r12)     // Catch:{ SQLiteException -> 0x022f }
            java.lang.String r11 = r4.getString(r13)     // Catch:{ SQLiteException -> 0x022c }
            r4.close()     // Catch:{ SQLiteException -> 0x022c }
            goto L_0x00e1
        L_0x0090:
            int r4 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r4 == 0) goto L_0x00a1
            r8 = 2
            java.lang.String[] r11 = new java.lang.String[r8]     // Catch:{ SQLiteException -> 0x0237, all -> 0x0232 }
            r8 = 0
            r11[r12] = r8     // Catch:{ SQLiteException -> 0x0237, all -> 0x0232 }
            java.lang.String r8 = java.lang.String.valueOf(r6)     // Catch:{ SQLiteException -> 0x0237, all -> 0x0232 }
            r11[r13] = r8     // Catch:{ SQLiteException -> 0x0237, all -> 0x0232 }
            goto L_0x00a6
        L_0x00a1:
            r8 = 0
            java.lang.String[] r11 = new java.lang.String[]{r8}     // Catch:{ SQLiteException -> 0x0237, all -> 0x0232 }
        L_0x00a6:
            if (r4 == 0) goto L_0x00aa
            java.lang.String r16 = " and rowid <= ?"
        L_0x00aa:
            r4 = r16
            int r8 = r4.length()     // Catch:{ SQLiteException -> 0x0237, all -> 0x0232 }
            int r8 = r8 + 84
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0237, all -> 0x0232 }
            r14.<init>(r8)     // Catch:{ SQLiteException -> 0x0237, all -> 0x0232 }
            java.lang.String r8 = "select metadata_fingerprint from raw_events where app_id = ?"
            r14.append(r8)     // Catch:{ SQLiteException -> 0x0237, all -> 0x0232 }
            r14.append(r4)     // Catch:{ SQLiteException -> 0x0237, all -> 0x0232 }
            java.lang.String r4 = " order by rowid limit 1;"
            r14.append(r4)     // Catch:{ SQLiteException -> 0x0237, all -> 0x0232 }
            java.lang.String r4 = r14.toString()     // Catch:{ SQLiteException -> 0x0237, all -> 0x0232 }
            android.database.Cursor r4 = r15.rawQuery(r4, r11)     // Catch:{ SQLiteException -> 0x0237, all -> 0x0232 }
            boolean r8 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x022f }
            if (r8 != 0) goto L_0x00d9
            if (r4 == 0) goto L_0x0251
            r4.close()     // Catch:{ all -> 0x0f85 }
            goto L_0x0251
        L_0x00d9:
            java.lang.String r11 = r4.getString(r12)     // Catch:{ SQLiteException -> 0x022f }
            r4.close()     // Catch:{ SQLiteException -> 0x022f }
            r8 = 0
        L_0x00e1:
            java.lang.String r16 = "raw_events_metadata"
            java.lang.String r14 = "metadata"
            java.lang.String[] r17 = new java.lang.String[]{r14}     // Catch:{ SQLiteException -> 0x022c }
            java.lang.String r18 = "app_id = ? and metadata_fingerprint = ?"
            r14 = 2
            java.lang.String[] r9 = new java.lang.String[r14]     // Catch:{ SQLiteException -> 0x022c }
            r9[r12] = r8     // Catch:{ SQLiteException -> 0x022c }
            r9[r13] = r11     // Catch:{ SQLiteException -> 0x022c }
            r19 = 0
            r20 = 0
            java.lang.String r21 = "rowid"
            java.lang.String r22 = "2"
            r14 = r15
            r10 = r15
            r15 = r16
            r16 = r17
            r17 = r18
            r18 = r9
            android.database.Cursor r4 = r14.query(r15, r16, r17, r18, r19, r20, r21, r22)     // Catch:{ SQLiteException -> 0x022c }
            boolean r9 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x022c }
            if (r9 != 0) goto L_0x0126
            com.google.android.gms.measurement.internal.zzfk r6 = r5.zzr()     // Catch:{ SQLiteException -> 0x022c }
            com.google.android.gms.measurement.internal.zzfm r6 = r6.zzf()     // Catch:{ SQLiteException -> 0x022c }
            java.lang.String r7 = "Raw event metadata record is missing. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzfk.zza(r8)     // Catch:{ SQLiteException -> 0x022c }
            r6.zza(r7, r9)     // Catch:{ SQLiteException -> 0x022c }
            if (r4 == 0) goto L_0x0251
            r4.close()     // Catch:{ all -> 0x0f85 }
            goto L_0x0251
        L_0x0126:
            byte[] r9 = r4.getBlob(r12)     // Catch:{ SQLiteException -> 0x022c }
            com.google.android.gms.internal.measurement.zzbr$zzg$zza r14 = com.google.android.gms.internal.measurement.zzbr.zzg.zzbf()     // Catch:{ IOException -> 0x0213 }
            com.google.android.gms.internal.measurement.zzgn r9 = com.google.android.gms.measurement.internal.zzkw.zza(r14, r9)     // Catch:{ IOException -> 0x0213 }
            com.google.android.gms.internal.measurement.zzbr$zzg$zza r9 = (com.google.android.gms.internal.measurement.zzbr.zzg.zza) r9     // Catch:{ IOException -> 0x0213 }
            com.google.android.gms.internal.measurement.zzgo r9 = r9.zzu()     // Catch:{ IOException -> 0x0213 }
            com.google.android.gms.internal.measurement.zzfd r9 = (com.google.android.gms.internal.measurement.zzfd) r9     // Catch:{ IOException -> 0x0213 }
            com.google.android.gms.internal.measurement.zzbr$zzg r9 = (com.google.android.gms.internal.measurement.zzbr.zzg) r9     // Catch:{ IOException -> 0x0213 }
            boolean r14 = r4.moveToNext()     // Catch:{ SQLiteException -> 0x022c }
            if (r14 == 0) goto L_0x0153
            com.google.android.gms.measurement.internal.zzfk r14 = r5.zzr()     // Catch:{ SQLiteException -> 0x022c }
            com.google.android.gms.measurement.internal.zzfm r14 = r14.zzi()     // Catch:{ SQLiteException -> 0x022c }
            java.lang.String r15 = "Get multiple raw event metadata records, expected one. appId"
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzfk.zza(r8)     // Catch:{ SQLiteException -> 0x022c }
            r14.zza(r15, r13)     // Catch:{ SQLiteException -> 0x022c }
        L_0x0153:
            r4.close()     // Catch:{ SQLiteException -> 0x022c }
            r3.zza(r9)     // Catch:{ SQLiteException -> 0x022c }
            r13 = -1
            int r9 = (r6 > r13 ? 1 : (r6 == r13 ? 0 : -1))
            if (r9 == 0) goto L_0x0175
            java.lang.String r9 = "app_id = ? and metadata_fingerprint = ? and rowid <= ?"
            r13 = 3
            java.lang.String[] r14 = new java.lang.String[r13]     // Catch:{ SQLiteException -> 0x022c }
            r14[r12] = r8     // Catch:{ SQLiteException -> 0x022c }
            r13 = 1
            r14[r13] = r11     // Catch:{ SQLiteException -> 0x022c }
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ SQLiteException -> 0x022c }
            r7 = 2
            r14[r7] = r6     // Catch:{ SQLiteException -> 0x022c }
            r17 = r9
            r18 = r14
            goto L_0x0183
        L_0x0175:
            java.lang.String r6 = "app_id = ? and metadata_fingerprint = ?"
            r7 = 2
            java.lang.String[] r9 = new java.lang.String[r7]     // Catch:{ SQLiteException -> 0x022c }
            r9[r12] = r8     // Catch:{ SQLiteException -> 0x022c }
            r7 = 1
            r9[r7] = r11     // Catch:{ SQLiteException -> 0x022c }
            r17 = r6
            r18 = r9
        L_0x0183:
            java.lang.String r15 = "raw_events"
            java.lang.String r6 = "rowid"
            java.lang.String r7 = "name"
            java.lang.String r9 = "timestamp"
            java.lang.String r11 = "data"
            java.lang.String[] r16 = new java.lang.String[]{r6, r7, r9, r11}     // Catch:{ SQLiteException -> 0x022c }
            r19 = 0
            r20 = 0
            java.lang.String r21 = "rowid"
            r22 = 0
            r14 = r10
            android.database.Cursor r4 = r14.query(r15, r16, r17, r18, r19, r20, r21, r22)     // Catch:{ SQLiteException -> 0x022c }
            boolean r6 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x022c }
            if (r6 != 0) goto L_0x01bc
            com.google.android.gms.measurement.internal.zzfk r6 = r5.zzr()     // Catch:{ SQLiteException -> 0x022c }
            com.google.android.gms.measurement.internal.zzfm r6 = r6.zzi()     // Catch:{ SQLiteException -> 0x022c }
            java.lang.String r7 = "Raw event data disappeared while in transaction. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzfk.zza(r8)     // Catch:{ SQLiteException -> 0x022c }
            r6.zza(r7, r9)     // Catch:{ SQLiteException -> 0x022c }
            if (r4 == 0) goto L_0x0251
            r4.close()     // Catch:{ all -> 0x0f85 }
            goto L_0x0251
        L_0x01bc:
            long r6 = r4.getLong(r12)     // Catch:{ SQLiteException -> 0x022c }
            r9 = 3
            byte[] r10 = r4.getBlob(r9)     // Catch:{ SQLiteException -> 0x022c }
            com.google.android.gms.internal.measurement.zzbr$zzc$zza r9 = com.google.android.gms.internal.measurement.zzbr.zzc.zzj()     // Catch:{ IOException -> 0x01f4 }
            com.google.android.gms.internal.measurement.zzgn r9 = com.google.android.gms.measurement.internal.zzkw.zza(r9, r10)     // Catch:{ IOException -> 0x01f4 }
            com.google.android.gms.internal.measurement.zzbr$zzc$zza r9 = (com.google.android.gms.internal.measurement.zzbr.zzc.zza) r9     // Catch:{ IOException -> 0x01f4 }
            r10 = 1
            java.lang.String r11 = r4.getString(r10)     // Catch:{ SQLiteException -> 0x022c }
            com.google.android.gms.internal.measurement.zzbr$zzc$zza r10 = r9.zza(r11)     // Catch:{ SQLiteException -> 0x022c }
            r11 = 2
            long r13 = r4.getLong(r11)     // Catch:{ SQLiteException -> 0x022c }
            r10.zza(r13)     // Catch:{ SQLiteException -> 0x022c }
            com.google.android.gms.internal.measurement.zzgo r9 = r9.zzu()     // Catch:{ SQLiteException -> 0x022c }
            com.google.android.gms.internal.measurement.zzfd r9 = (com.google.android.gms.internal.measurement.zzfd) r9     // Catch:{ SQLiteException -> 0x022c }
            com.google.android.gms.internal.measurement.zzbr$zzc r9 = (com.google.android.gms.internal.measurement.zzbr.zzc) r9     // Catch:{ SQLiteException -> 0x022c }
            boolean r6 = r3.zza(r6, r9)     // Catch:{ SQLiteException -> 0x022c }
            if (r6 != 0) goto L_0x0207
            if (r4 == 0) goto L_0x0251
            r4.close()     // Catch:{ all -> 0x0f85 }
            goto L_0x0251
        L_0x01f4:
            r0 = move-exception
            r6 = r0
            com.google.android.gms.measurement.internal.zzfk r7 = r5.zzr()     // Catch:{ SQLiteException -> 0x022c }
            com.google.android.gms.measurement.internal.zzfm r7 = r7.zzf()     // Catch:{ SQLiteException -> 0x022c }
            java.lang.String r9 = "Data loss. Failed to merge raw event. appId"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzfk.zza(r8)     // Catch:{ SQLiteException -> 0x022c }
            r7.zza(r9, r10, r6)     // Catch:{ SQLiteException -> 0x022c }
        L_0x0207:
            boolean r6 = r4.moveToNext()     // Catch:{ SQLiteException -> 0x022c }
            if (r6 != 0) goto L_0x01bc
            if (r4 == 0) goto L_0x0251
            r4.close()     // Catch:{ all -> 0x0f85 }
            goto L_0x0251
        L_0x0213:
            r0 = move-exception
            r6 = r0
            com.google.android.gms.measurement.internal.zzfk r7 = r5.zzr()     // Catch:{ SQLiteException -> 0x022c }
            com.google.android.gms.measurement.internal.zzfm r7 = r7.zzf()     // Catch:{ SQLiteException -> 0x022c }
            java.lang.String r9 = "Data loss. Failed to merge raw event metadata. appId"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzfk.zza(r8)     // Catch:{ SQLiteException -> 0x022c }
            r7.zza(r9, r10, r6)     // Catch:{ SQLiteException -> 0x022c }
            if (r4 == 0) goto L_0x0251
            r4.close()     // Catch:{ all -> 0x0f85 }
            goto L_0x0251
        L_0x022c:
            r0 = move-exception
            r6 = r0
            goto L_0x023b
        L_0x022f:
            r0 = move-exception
            r6 = r0
            goto L_0x023a
        L_0x0232:
            r0 = move-exception
            r2 = r0
            r4 = 0
            goto L_0x0f7f
        L_0x0237:
            r0 = move-exception
            r6 = r0
            r4 = 0
        L_0x023a:
            r8 = 0
        L_0x023b:
            com.google.android.gms.measurement.internal.zzfk r5 = r5.zzr()     // Catch:{ all -> 0x0f7d }
            com.google.android.gms.measurement.internal.zzfm r5 = r5.zzf()     // Catch:{ all -> 0x0f7d }
            java.lang.String r7 = "Data loss. Error selecting raw event. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzfk.zza(r8)     // Catch:{ all -> 0x0f7d }
            r5.zza(r7, r8, r6)     // Catch:{ all -> 0x0f7d }
            if (r4 == 0) goto L_0x0251
            r4.close()     // Catch:{ all -> 0x0f85 }
        L_0x0251:
            java.util.List<com.google.android.gms.internal.measurement.zzbr$zzc> r4 = r3.zzc     // Catch:{ all -> 0x0f85 }
            if (r4 == 0) goto L_0x0260
            java.util.List<com.google.android.gms.internal.measurement.zzbr$zzc> r4 = r3.zzc     // Catch:{ all -> 0x0f85 }
            boolean r4 = r4.isEmpty()     // Catch:{ all -> 0x0f85 }
            if (r4 == 0) goto L_0x025e
            goto L_0x0260
        L_0x025e:
            r4 = r12
            goto L_0x0261
        L_0x0260:
            r4 = 1
        L_0x0261:
            if (r4 != 0) goto L_0x0f6d
            com.google.android.gms.internal.measurement.zzbr$zzg r4 = r3.zza     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzfd$zzb r4 = r4.zzbm()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzfd$zzb r4 = (com.google.android.gms.internal.measurement.zzfd.zzb) r4     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzbr$zzg$zza r4 = (com.google.android.gms.internal.measurement.zzbr.zzg.zza) r4     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzbr$zzg$zza r4 = r4.zzc()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzgo r5 = r1.zzj     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzx r5 = r5.zzb()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzbr$zzg r6 = r3.zza     // Catch:{ all -> 0x0f85 }
            java.lang.String r6 = r6.zzx()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r7 = com.google.android.gms.measurement.internal.zzap.zzbb     // Catch:{ all -> 0x0f85 }
            boolean r5 = r5.zze(r6, r7)     // Catch:{ all -> 0x0f85 }
            r11 = r12
            r13 = r11
            r16 = r13
            r6 = -1
            r9 = 0
            r10 = 0
            r12 = -1
            r14 = 0
        L_0x028d:
            java.util.List<com.google.android.gms.internal.measurement.zzbr$zzc> r7 = r3.zzc     // Catch:{ all -> 0x0f85 }
            int r7 = r7.size()     // Catch:{ all -> 0x0f85 }
            java.lang.String r8 = "_fr"
            r19 = r13
            java.lang.String r13 = "_e"
            r20 = r2
            java.lang.String r2 = "_et"
            r21 = r14
            if (r11 >= r7) goto L_0x0821
            java.util.List<com.google.android.gms.internal.measurement.zzbr$zzc> r7 = r3.zzc     // Catch:{ all -> 0x0f85 }
            java.lang.Object r7 = r7.get(r11)     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzbr$zzc r7 = (com.google.android.gms.internal.measurement.zzbr.zzc) r7     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzfd$zzb r7 = r7.zzbm()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzfd$zzb r7 = (com.google.android.gms.internal.measurement.zzfd.zzb) r7     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzbr$zzc$zza r7 = (com.google.android.gms.internal.measurement.zzbr.zzc.zza) r7     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzgi r14 = r57.zzc()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzbr$zzg r15 = r3.zza     // Catch:{ all -> 0x0f85 }
            java.lang.String r15 = r15.zzx()     // Catch:{ all -> 0x0f85 }
            r23 = r11
            java.lang.String r11 = r7.zzd()     // Catch:{ all -> 0x0f85 }
            boolean r11 = r14.zzb(r15, r11)     // Catch:{ all -> 0x0f85 }
            java.lang.String r14 = "_err"
            if (r11 == 0) goto L_0x0349
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzfk r2 = r2.zzr()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzfm r2 = r2.zzi()     // Catch:{ all -> 0x0f85 }
            java.lang.String r8 = "Dropping blacklisted raw event. appId"
            com.google.android.gms.internal.measurement.zzbr$zzg r11 = r3.zza     // Catch:{ all -> 0x0f85 }
            java.lang.String r11 = r11.zzx()     // Catch:{ all -> 0x0f85 }
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzfk.zza(r11)     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzgo r13 = r1.zzj     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzfi r13 = r13.zzj()     // Catch:{ all -> 0x0f85 }
            java.lang.String r15 = r7.zzd()     // Catch:{ all -> 0x0f85 }
            java.lang.String r13 = r13.zza(r15)     // Catch:{ all -> 0x0f85 }
            r2.zza(r8, r11, r13)     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzgi r2 = r57.zzc()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzbr$zzg r8 = r3.zza     // Catch:{ all -> 0x0f85 }
            java.lang.String r8 = r8.zzx()     // Catch:{ all -> 0x0f85 }
            boolean r2 = r2.zzg(r8)     // Catch:{ all -> 0x0f85 }
            if (r2 != 0) goto L_0x0313
            com.google.android.gms.measurement.internal.zzgi r2 = r57.zzc()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzbr$zzg r8 = r3.zza     // Catch:{ all -> 0x0f85 }
            java.lang.String r8 = r8.zzx()     // Catch:{ all -> 0x0f85 }
            boolean r2 = r2.zzh(r8)     // Catch:{ all -> 0x0f85 }
            if (r2 == 0) goto L_0x0311
            goto L_0x0313
        L_0x0311:
            r2 = 0
            goto L_0x0314
        L_0x0313:
            r2 = 1
        L_0x0314:
            if (r2 != 0) goto L_0x0339
            java.lang.String r2 = r7.zzd()     // Catch:{ all -> 0x0f85 }
            boolean r2 = r14.equals(r2)     // Catch:{ all -> 0x0f85 }
            if (r2 != 0) goto L_0x0339
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzla r24 = r2.zzi()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzbr$zzg r2 = r3.zza     // Catch:{ all -> 0x0f85 }
            java.lang.String r25 = r2.zzx()     // Catch:{ all -> 0x0f85 }
            r26 = 11
            java.lang.String r27 = "_ev"
            java.lang.String r28 = r7.zzd()     // Catch:{ all -> 0x0f85 }
            r29 = 0
            r24.zza(r25, r26, r27, r28, r29)     // Catch:{ all -> 0x0f85 }
        L_0x0339:
            r24 = r5
            r26 = r9
            r8 = r12
            r13 = r19
            r14 = r21
            r11 = r23
            r12 = 3
            r9 = r4
            r4 = -1
            goto L_0x0815
        L_0x0349:
            com.google.android.gms.measurement.internal.zzgi r11 = r57.zzc()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzbr$zzg r15 = r3.zza     // Catch:{ all -> 0x0f85 }
            java.lang.String r15 = r15.zzx()     // Catch:{ all -> 0x0f85 }
            r24 = r5
            java.lang.String r5 = r7.zzd()     // Catch:{ all -> 0x0f85 }
            boolean r5 = r11.zzc(r15, r5)     // Catch:{ all -> 0x0f85 }
            java.lang.String r11 = "_c"
            if (r5 != 0) goto L_0x03ba
            r57.zzh()     // Catch:{ all -> 0x0f85 }
            java.lang.String r15 = r7.zzd()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r15)     // Catch:{ all -> 0x0f85 }
            r25 = r12
            int r12 = r15.hashCode()     // Catch:{ all -> 0x0f85 }
            r26 = r9
            r9 = 94660(0x171c4, float:1.32647E-40)
            if (r12 == r9) goto L_0x0397
            r9 = 95025(0x17331, float:1.33158E-40)
            if (r12 == r9) goto L_0x038d
            r9 = 95027(0x17333, float:1.33161E-40)
            if (r12 == r9) goto L_0x0383
            goto L_0x03a1
        L_0x0383:
            java.lang.String r9 = "_ui"
            boolean r9 = r15.equals(r9)     // Catch:{ all -> 0x0f85 }
            if (r9 == 0) goto L_0x03a1
            r9 = 1
            goto L_0x03a2
        L_0x038d:
            java.lang.String r9 = "_ug"
            boolean r9 = r15.equals(r9)     // Catch:{ all -> 0x0f85 }
            if (r9 == 0) goto L_0x03a1
            r9 = 2
            goto L_0x03a2
        L_0x0397:
            java.lang.String r9 = "_in"
            boolean r9 = r15.equals(r9)     // Catch:{ all -> 0x0f85 }
            if (r9 == 0) goto L_0x03a1
            r9 = 0
            goto L_0x03a2
        L_0x03a1:
            r9 = -1
        L_0x03a2:
            if (r9 == 0) goto L_0x03ac
            r12 = 1
            if (r9 == r12) goto L_0x03ac
            r12 = 2
            if (r9 == r12) goto L_0x03ac
            r9 = 0
            goto L_0x03ad
        L_0x03ac:
            r9 = 1
        L_0x03ad:
            if (r9 == 0) goto L_0x03b0
            goto L_0x03be
        L_0x03b0:
            r27 = r2
            r28 = r4
            r29 = r13
        L_0x03b6:
            r13 = r19
            goto L_0x05b1
        L_0x03ba:
            r26 = r9
            r25 = r12
        L_0x03be:
            r27 = r2
            r9 = 0
            r12 = 0
            r15 = 0
        L_0x03c3:
            int r2 = r7.zzb()     // Catch:{ all -> 0x0f85 }
            r28 = r4
            java.lang.String r4 = "_r"
            if (r9 >= r2) goto L_0x043a
            com.google.android.gms.internal.measurement.zzbr$zze r2 = r7.zza(r9)     // Catch:{ all -> 0x0f85 }
            java.lang.String r2 = r2.zzb()     // Catch:{ all -> 0x0f85 }
            boolean r2 = r11.equals(r2)     // Catch:{ all -> 0x0f85 }
            if (r2 == 0) goto L_0x03fe
            com.google.android.gms.internal.measurement.zzbr$zze r2 = r7.zza(r9)     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzfd$zzb r2 = r2.zzbm()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzfd$zzb r2 = (com.google.android.gms.internal.measurement.zzfd.zzb) r2     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzbr$zze$zza r2 = (com.google.android.gms.internal.measurement.zzbr.zze.zza) r2     // Catch:{ all -> 0x0f85 }
            r29 = r13
            r12 = 1
            com.google.android.gms.internal.measurement.zzbr$zze$zza r2 = r2.zza(r12)     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzgo r2 = r2.zzu()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzfd r2 = (com.google.android.gms.internal.measurement.zzfd) r2     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzbr$zze r2 = (com.google.android.gms.internal.measurement.zzbr.zze) r2     // Catch:{ all -> 0x0f85 }
            r7.zza(r9, r2)     // Catch:{ all -> 0x0f85 }
            r30 = r14
            r12 = 1
            goto L_0x0431
        L_0x03fe:
            r29 = r13
            com.google.android.gms.internal.measurement.zzbr$zze r2 = r7.zza(r9)     // Catch:{ all -> 0x0f85 }
            java.lang.String r2 = r2.zzb()     // Catch:{ all -> 0x0f85 }
            boolean r2 = r4.equals(r2)     // Catch:{ all -> 0x0f85 }
            if (r2 == 0) goto L_0x042f
            com.google.android.gms.internal.measurement.zzbr$zze r2 = r7.zza(r9)     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzfd$zzb r2 = r2.zzbm()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzfd$zzb r2 = (com.google.android.gms.internal.measurement.zzfd.zzb) r2     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzbr$zze$zza r2 = (com.google.android.gms.internal.measurement.zzbr.zze.zza) r2     // Catch:{ all -> 0x0f85 }
            r30 = r14
            r13 = 1
            com.google.android.gms.internal.measurement.zzbr$zze$zza r2 = r2.zza(r13)     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzgo r2 = r2.zzu()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzfd r2 = (com.google.android.gms.internal.measurement.zzfd) r2     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzbr$zze r2 = (com.google.android.gms.internal.measurement.zzbr.zze) r2     // Catch:{ all -> 0x0f85 }
            r7.zza(r9, r2)     // Catch:{ all -> 0x0f85 }
            r15 = 1
            goto L_0x0431
        L_0x042f:
            r30 = r14
        L_0x0431:
            int r9 = r9 + 1
            r4 = r28
            r13 = r29
            r14 = r30
            goto L_0x03c3
        L_0x043a:
            r29 = r13
            r30 = r14
            if (r12 != 0) goto L_0x0470
            if (r5 == 0) goto L_0x0470
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzfk r2 = r2.zzr()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzfm r2 = r2.zzx()     // Catch:{ all -> 0x0f85 }
            java.lang.String r9 = "Marking event as conversion"
            com.google.android.gms.measurement.internal.zzgo r12 = r1.zzj     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzfi r12 = r12.zzj()     // Catch:{ all -> 0x0f85 }
            java.lang.String r13 = r7.zzd()     // Catch:{ all -> 0x0f85 }
            java.lang.String r12 = r12.zza(r13)     // Catch:{ all -> 0x0f85 }
            r2.zza(r9, r12)     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzbr$zze$zza r2 = com.google.android.gms.internal.measurement.zzbr.zze.zzk()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzbr$zze$zza r2 = r2.zza(r11)     // Catch:{ all -> 0x0f85 }
            r12 = 1
            com.google.android.gms.internal.measurement.zzbr$zze$zza r2 = r2.zza(r12)     // Catch:{ all -> 0x0f85 }
            r7.zza(r2)     // Catch:{ all -> 0x0f85 }
        L_0x0470:
            if (r15 != 0) goto L_0x04a0
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzfk r2 = r2.zzr()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzfm r2 = r2.zzx()     // Catch:{ all -> 0x0f85 }
            java.lang.String r9 = "Marking event as real-time"
            com.google.android.gms.measurement.internal.zzgo r12 = r1.zzj     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzfi r12 = r12.zzj()     // Catch:{ all -> 0x0f85 }
            java.lang.String r13 = r7.zzd()     // Catch:{ all -> 0x0f85 }
            java.lang.String r12 = r12.zza(r13)     // Catch:{ all -> 0x0f85 }
            r2.zza(r9, r12)     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzbr$zze$zza r2 = com.google.android.gms.internal.measurement.zzbr.zze.zzk()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzbr$zze$zza r2 = r2.zza(r4)     // Catch:{ all -> 0x0f85 }
            r12 = 1
            com.google.android.gms.internal.measurement.zzbr$zze$zza r2 = r2.zza(r12)     // Catch:{ all -> 0x0f85 }
            r7.zza(r2)     // Catch:{ all -> 0x0f85 }
        L_0x04a0:
            com.google.android.gms.measurement.internal.zzac r31 = r57.zze()     // Catch:{ all -> 0x0f85 }
            long r32 = r57.zzx()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzbr$zzg r2 = r3.zza     // Catch:{ all -> 0x0f85 }
            java.lang.String r34 = r2.zzx()     // Catch:{ all -> 0x0f85 }
            r35 = 0
            r36 = 0
            r37 = 0
            r38 = 0
            r39 = 1
            com.google.android.gms.measurement.internal.zzab r2 = r31.zza(r32, r34, r35, r36, r37, r38, r39)     // Catch:{ all -> 0x0f85 }
            long r12 = r2.zze     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzx r2 = r2.zzb()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzbr$zzg r9 = r3.zza     // Catch:{ all -> 0x0f85 }
            java.lang.String r9 = r9.zzx()     // Catch:{ all -> 0x0f85 }
            int r2 = r2.zzb(r9)     // Catch:{ all -> 0x0f85 }
            long r14 = (long) r2     // Catch:{ all -> 0x0f85 }
            int r2 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r2 <= 0) goto L_0x04d7
            zza(r7, r4)     // Catch:{ all -> 0x0f85 }
            goto L_0x04d9
        L_0x04d7:
            r19 = 1
        L_0x04d9:
            java.lang.String r2 = r7.zzd()     // Catch:{ all -> 0x0f85 }
            boolean r2 = com.google.android.gms.measurement.internal.zzla.zza(r2)     // Catch:{ all -> 0x0f85 }
            if (r2 == 0) goto L_0x03b6
            if (r5 == 0) goto L_0x03b6
            com.google.android.gms.measurement.internal.zzac r31 = r57.zze()     // Catch:{ all -> 0x0f85 }
            long r32 = r57.zzx()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzbr$zzg r2 = r3.zza     // Catch:{ all -> 0x0f85 }
            java.lang.String r34 = r2.zzx()     // Catch:{ all -> 0x0f85 }
            r35 = 0
            r36 = 0
            r37 = 1
            r38 = 0
            r39 = 0
            com.google.android.gms.measurement.internal.zzab r2 = r31.zza(r32, r34, r35, r36, r37, r38, r39)     // Catch:{ all -> 0x0f85 }
            long r12 = r2.zzc     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzx r2 = r2.zzb()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzbr$zzg r4 = r3.zza     // Catch:{ all -> 0x0f85 }
            java.lang.String r4 = r4.zzx()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Integer> r9 = com.google.android.gms.measurement.internal.zzap.zzm     // Catch:{ all -> 0x0f85 }
            int r2 = r2.zzb(r4, r9)     // Catch:{ all -> 0x0f85 }
            long r14 = (long) r2     // Catch:{ all -> 0x0f85 }
            int r2 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r2 <= 0) goto L_0x03b6
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzfk r2 = r2.zzr()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzfm r2 = r2.zzi()     // Catch:{ all -> 0x0f85 }
            java.lang.String r4 = "Too many conversions. Not logging as conversion. appId"
            com.google.android.gms.internal.measurement.zzbr$zzg r9 = r3.zza     // Catch:{ all -> 0x0f85 }
            java.lang.String r9 = r9.zzx()     // Catch:{ all -> 0x0f85 }
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzfk.zza(r9)     // Catch:{ all -> 0x0f85 }
            r2.zza(r4, r9)     // Catch:{ all -> 0x0f85 }
            r2 = 0
            r4 = -1
            r9 = 0
            r12 = 0
        L_0x0537:
            int r13 = r7.zzb()     // Catch:{ all -> 0x0f85 }
            if (r2 >= r13) goto L_0x056a
            com.google.android.gms.internal.measurement.zzbr$zze r13 = r7.zza(r2)     // Catch:{ all -> 0x0f85 }
            java.lang.String r14 = r13.zzb()     // Catch:{ all -> 0x0f85 }
            boolean r14 = r11.equals(r14)     // Catch:{ all -> 0x0f85 }
            if (r14 == 0) goto L_0x0558
            com.google.android.gms.internal.measurement.zzfd$zzb r4 = r13.zzbm()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzfd$zzb r4 = (com.google.android.gms.internal.measurement.zzfd.zzb) r4     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzbr$zze$zza r4 = (com.google.android.gms.internal.measurement.zzbr.zze.zza) r4     // Catch:{ all -> 0x0f85 }
            r9 = r4
            r14 = r30
            r4 = r2
            goto L_0x0565
        L_0x0558:
            java.lang.String r13 = r13.zzb()     // Catch:{ all -> 0x0f85 }
            r14 = r30
            boolean r13 = r14.equals(r13)     // Catch:{ all -> 0x0f85 }
            if (r13 == 0) goto L_0x0565
            r12 = 1
        L_0x0565:
            int r2 = r2 + 1
            r30 = r14
            goto L_0x0537
        L_0x056a:
            r14 = r30
            if (r12 == 0) goto L_0x0575
            if (r9 == 0) goto L_0x0575
            r7.zzb(r4)     // Catch:{ all -> 0x0f85 }
            goto L_0x03b6
        L_0x0575:
            if (r9 == 0) goto L_0x0596
            java.lang.Object r2 = r9.clone()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzfd$zzb r2 = (com.google.android.gms.internal.measurement.zzfd.zzb) r2     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzbr$zze$zza r2 = (com.google.android.gms.internal.measurement.zzbr.zze.zza) r2     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzbr$zze$zza r2 = r2.zza(r14)     // Catch:{ all -> 0x0f85 }
            r12 = 10
            com.google.android.gms.internal.measurement.zzbr$zze$zza r2 = r2.zza(r12)     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzgo r2 = r2.zzu()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzfd r2 = (com.google.android.gms.internal.measurement.zzfd) r2     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzbr$zze r2 = (com.google.android.gms.internal.measurement.zzbr.zze) r2     // Catch:{ all -> 0x0f85 }
            r7.zza(r4, r2)     // Catch:{ all -> 0x0f85 }
            goto L_0x03b6
        L_0x0596:
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzfk r2 = r2.zzr()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzfm r2 = r2.zzf()     // Catch:{ all -> 0x0f85 }
            java.lang.String r4 = "Did not find conversion parameter. appId"
            com.google.android.gms.internal.measurement.zzbr$zzg r9 = r3.zza     // Catch:{ all -> 0x0f85 }
            java.lang.String r9 = r9.zzx()     // Catch:{ all -> 0x0f85 }
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzfk.zza(r9)     // Catch:{ all -> 0x0f85 }
            r2.zza(r4, r9)     // Catch:{ all -> 0x0f85 }
            goto L_0x03b6
        L_0x05b1:
            if (r5 == 0) goto L_0x0674
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x0f85 }
            java.util.List r4 = r7.zza()     // Catch:{ all -> 0x0f85 }
            r2.<init>(r4)     // Catch:{ all -> 0x0f85 }
            r4 = 0
            r5 = -1
            r9 = -1
        L_0x05bf:
            int r12 = r2.size()     // Catch:{ all -> 0x0f85 }
            java.lang.String r14 = "currency"
            java.lang.String r15 = "value"
            if (r4 >= r12) goto L_0x05ef
            java.lang.Object r12 = r2.get(r4)     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzbr$zze r12 = (com.google.android.gms.internal.measurement.zzbr.zze) r12     // Catch:{ all -> 0x0f85 }
            java.lang.String r12 = r12.zzb()     // Catch:{ all -> 0x0f85 }
            boolean r12 = r15.equals(r12)     // Catch:{ all -> 0x0f85 }
            if (r12 == 0) goto L_0x05db
            r5 = r4
            goto L_0x05ec
        L_0x05db:
            java.lang.Object r12 = r2.get(r4)     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzbr$zze r12 = (com.google.android.gms.internal.measurement.zzbr.zze) r12     // Catch:{ all -> 0x0f85 }
            java.lang.String r12 = r12.zzb()     // Catch:{ all -> 0x0f85 }
            boolean r12 = r14.equals(r12)     // Catch:{ all -> 0x0f85 }
            if (r12 == 0) goto L_0x05ec
            r9 = r4
        L_0x05ec:
            int r4 = r4 + 1
            goto L_0x05bf
        L_0x05ef:
            r4 = -1
            if (r5 == r4) goto L_0x0675
            java.lang.Object r4 = r2.get(r5)     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzbr$zze r4 = (com.google.android.gms.internal.measurement.zzbr.zze) r4     // Catch:{ all -> 0x0f85 }
            boolean r4 = r4.zze()     // Catch:{ all -> 0x0f85 }
            if (r4 != 0) goto L_0x0625
            java.lang.Object r4 = r2.get(r5)     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzbr$zze r4 = (com.google.android.gms.internal.measurement.zzbr.zze) r4     // Catch:{ all -> 0x0f85 }
            boolean r4 = r4.zzg()     // Catch:{ all -> 0x0f85 }
            if (r4 != 0) goto L_0x0625
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzfk r2 = r2.zzr()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzfm r2 = r2.zzk()     // Catch:{ all -> 0x0f85 }
            java.lang.String r4 = "Value must be specified with a numeric type."
            r2.zza(r4)     // Catch:{ all -> 0x0f85 }
            r7.zzb(r5)     // Catch:{ all -> 0x0f85 }
            zza(r7, r11)     // Catch:{ all -> 0x0f85 }
            r2 = 18
            zza(r7, r2, r15)     // Catch:{ all -> 0x0f85 }
            goto L_0x0674
        L_0x0625:
            r4 = -1
            if (r9 != r4) goto L_0x062b
            r2 = 1
            r12 = 3
            goto L_0x0657
        L_0x062b:
            java.lang.Object r2 = r2.get(r9)     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzbr$zze r2 = (com.google.android.gms.internal.measurement.zzbr.zze) r2     // Catch:{ all -> 0x0f85 }
            java.lang.String r2 = r2.zzd()     // Catch:{ all -> 0x0f85 }
            int r9 = r2.length()     // Catch:{ all -> 0x0f85 }
            r12 = 3
            if (r9 == r12) goto L_0x063e
        L_0x063c:
            r2 = 1
            goto L_0x0657
        L_0x063e:
            r9 = 0
        L_0x063f:
            int r15 = r2.length()     // Catch:{ all -> 0x0f85 }
            if (r9 >= r15) goto L_0x0656
            int r15 = r2.codePointAt(r9)     // Catch:{ all -> 0x0f85 }
            boolean r18 = java.lang.Character.isLetter(r15)     // Catch:{ all -> 0x0f85 }
            if (r18 != 0) goto L_0x0650
            goto L_0x063c
        L_0x0650:
            int r15 = java.lang.Character.charCount(r15)     // Catch:{ all -> 0x0f85 }
            int r9 = r9 + r15
            goto L_0x063f
        L_0x0656:
            r2 = 0
        L_0x0657:
            if (r2 == 0) goto L_0x0676
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzfk r2 = r2.zzr()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzfm r2 = r2.zzk()     // Catch:{ all -> 0x0f85 }
            java.lang.String r9 = "Value parameter discarded. You must also supply a 3-letter ISO_4217 currency code in the currency parameter."
            r2.zza(r9)     // Catch:{ all -> 0x0f85 }
            r7.zzb(r5)     // Catch:{ all -> 0x0f85 }
            zza(r7, r11)     // Catch:{ all -> 0x0f85 }
            r2 = 19
            zza(r7, r2, r14)     // Catch:{ all -> 0x0f85 }
            goto L_0x0676
        L_0x0674:
            r4 = -1
        L_0x0675:
            r12 = 3
        L_0x0676:
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzx r2 = r2.zzb()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzbr$zzg r5 = r3.zza     // Catch:{ all -> 0x0f85 }
            java.lang.String r5 = r5.zzx()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r9 = com.google.android.gms.measurement.internal.zzap.zzba     // Catch:{ all -> 0x0f85 }
            boolean r2 = r2.zze(r5, r9)     // Catch:{ all -> 0x0f85 }
            if (r2 == 0) goto L_0x0796
            java.lang.String r2 = r7.zzd()     // Catch:{ all -> 0x0f85 }
            r5 = r29
            boolean r2 = r5.equals(r2)     // Catch:{ all -> 0x0f85 }
            if (r2 == 0) goto L_0x06e7
            r57.zzh()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzgo r2 = r7.zzu()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzfd r2 = (com.google.android.gms.internal.measurement.zzfd) r2     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzbr$zzc r2 = (com.google.android.gms.internal.measurement.zzbr.zzc) r2     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzbr$zze r2 = com.google.android.gms.measurement.internal.zzkw.zza(r2, r8)     // Catch:{ all -> 0x0f85 }
            if (r2 != 0) goto L_0x06e2
            if (r10 == 0) goto L_0x06d8
            long r8 = r10.zzf()     // Catch:{ all -> 0x0f85 }
            long r14 = r7.zzf()     // Catch:{ all -> 0x0f85 }
            long r8 = r8 - r14
            long r8 = java.lang.Math.abs(r8)     // Catch:{ all -> 0x0f85 }
            r14 = 1000(0x3e8, double:4.94E-321)
            int r2 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r2 > 0) goto L_0x06d8
            java.lang.Object r2 = r10.clone()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzfd$zzb r2 = (com.google.android.gms.internal.measurement.zzfd.zzb) r2     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzbr$zzc$zza r2 = (com.google.android.gms.internal.measurement.zzbr.zzc.zza) r2     // Catch:{ all -> 0x0f85 }
            boolean r8 = r1.zza(r7, r2)     // Catch:{ all -> 0x0f85 }
            if (r8 == 0) goto L_0x06d8
            r9 = r28
            r9.zza(r6, r2)     // Catch:{ all -> 0x0f85 }
            r8 = r25
            r11 = r27
        L_0x06d3:
            r10 = 0
        L_0x06d4:
            r26 = 0
            goto L_0x079e
        L_0x06d8:
            r9 = r28
            r26 = r7
            r8 = r16
        L_0x06de:
            r11 = r27
            goto L_0x079e
        L_0x06e2:
            r9 = r28
            r8 = r25
            goto L_0x06de
        L_0x06e7:
            r9 = r28
            java.lang.String r2 = "_vs"
            java.lang.String r8 = r7.zzd()     // Catch:{ all -> 0x0f85 }
            boolean r2 = r2.equals(r8)     // Catch:{ all -> 0x0f85 }
            if (r2 == 0) goto L_0x073b
            r57.zzh()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzgo r2 = r7.zzu()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzfd r2 = (com.google.android.gms.internal.measurement.zzfd) r2     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzbr$zzc r2 = (com.google.android.gms.internal.measurement.zzbr.zzc) r2     // Catch:{ all -> 0x0f85 }
            r11 = r27
            com.google.android.gms.internal.measurement.zzbr$zze r2 = com.google.android.gms.measurement.internal.zzkw.zza(r2, r11)     // Catch:{ all -> 0x0f85 }
            if (r2 != 0) goto L_0x0738
            if (r26 == 0) goto L_0x0732
            long r14 = r26.zzf()     // Catch:{ all -> 0x0f85 }
            long r18 = r7.zzf()     // Catch:{ all -> 0x0f85 }
            long r14 = r14 - r18
            long r14 = java.lang.Math.abs(r14)     // Catch:{ all -> 0x0f85 }
            r18 = 1000(0x3e8, double:4.94E-321)
            int r2 = (r14 > r18 ? 1 : (r14 == r18 ? 0 : -1))
            if (r2 > 0) goto L_0x0732
            java.lang.Object r2 = r26.clone()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzfd$zzb r2 = (com.google.android.gms.internal.measurement.zzfd.zzb) r2     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzbr$zzc$zza r2 = (com.google.android.gms.internal.measurement.zzbr.zzc.zza) r2     // Catch:{ all -> 0x0f85 }
            boolean r8 = r1.zza(r2, r7)     // Catch:{ all -> 0x0f85 }
            if (r8 == 0) goto L_0x0732
            r8 = r25
            r9.zza(r8, r2)     // Catch:{ all -> 0x0f85 }
            goto L_0x06d3
        L_0x0732:
            r8 = r25
            r10 = r7
            r6 = r16
            goto L_0x079e
        L_0x0738:
            r8 = r25
            goto L_0x079e
        L_0x073b:
            r8 = r25
            r11 = r27
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzx r2 = r2.zzb()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzbr$zzg r14 = r3.zza     // Catch:{ all -> 0x0f85 }
            java.lang.String r14 = r14.zzx()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r15 = com.google.android.gms.measurement.internal.zzap.zzcl     // Catch:{ all -> 0x0f85 }
            boolean r2 = r2.zze(r14, r15)     // Catch:{ all -> 0x0f85 }
            if (r2 == 0) goto L_0x079e
            java.lang.String r2 = "_ab"
            java.lang.String r14 = r7.zzd()     // Catch:{ all -> 0x0f85 }
            boolean r2 = r2.equals(r14)     // Catch:{ all -> 0x0f85 }
            if (r2 == 0) goto L_0x079e
            r57.zzh()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzgo r2 = r7.zzu()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzfd r2 = (com.google.android.gms.internal.measurement.zzfd) r2     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzbr$zzc r2 = (com.google.android.gms.internal.measurement.zzbr.zzc) r2     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzbr$zze r2 = com.google.android.gms.measurement.internal.zzkw.zza(r2, r11)     // Catch:{ all -> 0x0f85 }
            if (r2 != 0) goto L_0x079e
            if (r26 == 0) goto L_0x079e
            long r14 = r26.zzf()     // Catch:{ all -> 0x0f85 }
            long r18 = r7.zzf()     // Catch:{ all -> 0x0f85 }
            long r14 = r14 - r18
            long r14 = java.lang.Math.abs(r14)     // Catch:{ all -> 0x0f85 }
            r18 = 4000(0xfa0, double:1.9763E-320)
            int r2 = (r14 > r18 ? 1 : (r14 == r18 ? 0 : -1))
            if (r2 > 0) goto L_0x079e
            java.lang.Object r2 = r26.clone()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzfd$zzb r2 = (com.google.android.gms.internal.measurement.zzfd.zzb) r2     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzbr$zzc$zza r2 = (com.google.android.gms.internal.measurement.zzbr.zzc.zza) r2     // Catch:{ all -> 0x0f85 }
            r1.zzb(r2, r7)     // Catch:{ all -> 0x0f85 }
            r9.zza(r8, r2)     // Catch:{ all -> 0x0f85 }
            goto L_0x06d4
        L_0x0796:
            r8 = r25
            r11 = r27
            r9 = r28
            r5 = r29
        L_0x079e:
            if (r24 != 0) goto L_0x07ff
            java.lang.String r2 = r7.zzd()     // Catch:{ all -> 0x0f85 }
            boolean r2 = r5.equals(r2)     // Catch:{ all -> 0x0f85 }
            if (r2 == 0) goto L_0x07ff
            int r2 = r7.zzb()     // Catch:{ all -> 0x0f85 }
            if (r2 != 0) goto L_0x07ca
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzfk r2 = r2.zzr()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzfm r2 = r2.zzi()     // Catch:{ all -> 0x0f85 }
            java.lang.String r5 = "Engagement event does not contain any parameters. appId"
            com.google.android.gms.internal.measurement.zzbr$zzg r11 = r3.zza     // Catch:{ all -> 0x0f85 }
            java.lang.String r11 = r11.zzx()     // Catch:{ all -> 0x0f85 }
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzfk.zza(r11)     // Catch:{ all -> 0x0f85 }
            r2.zza(r5, r11)     // Catch:{ all -> 0x0f85 }
            goto L_0x07ff
        L_0x07ca:
            com.google.android.gms.measurement.internal.zzkw r2 = r57.zzh()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzgo r5 = r7.zzu()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzfd r5 = (com.google.android.gms.internal.measurement.zzfd) r5     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzbr$zzc r5 = (com.google.android.gms.internal.measurement.zzbr.zzc) r5     // Catch:{ all -> 0x0f85 }
            java.lang.Object r2 = r2.zzb(r5, r11)     // Catch:{ all -> 0x0f85 }
            java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ all -> 0x0f85 }
            if (r2 != 0) goto L_0x07f8
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzfk r2 = r2.zzr()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzfm r2 = r2.zzi()     // Catch:{ all -> 0x0f85 }
            java.lang.String r5 = "Engagement event does not include duration. appId"
            com.google.android.gms.internal.measurement.zzbr$zzg r11 = r3.zza     // Catch:{ all -> 0x0f85 }
            java.lang.String r11 = r11.zzx()     // Catch:{ all -> 0x0f85 }
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzfk.zza(r11)     // Catch:{ all -> 0x0f85 }
            r2.zza(r5, r11)     // Catch:{ all -> 0x0f85 }
            goto L_0x07ff
        L_0x07f8:
            long r14 = r2.longValue()     // Catch:{ all -> 0x0f85 }
            long r14 = r21 + r14
            goto L_0x0801
        L_0x07ff:
            r14 = r21
        L_0x0801:
            java.util.List<com.google.android.gms.internal.measurement.zzbr$zzc> r2 = r3.zzc     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzgo r5 = r7.zzu()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzfd r5 = (com.google.android.gms.internal.measurement.zzfd) r5     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzbr$zzc r5 = (com.google.android.gms.internal.measurement.zzbr.zzc) r5     // Catch:{ all -> 0x0f85 }
            r11 = r23
            r2.set(r11, r5)     // Catch:{ all -> 0x0f85 }
            int r16 = r16 + 1
            r9.zza(r7)     // Catch:{ all -> 0x0f85 }
        L_0x0815:
            int r11 = r11 + 1
            r12 = r8
            r4 = r9
            r2 = r20
            r5 = r24
            r9 = r26
            goto L_0x028d
        L_0x0821:
            r11 = r2
            r9 = r4
            r24 = r5
            r5 = r13
            if (r24 == 0) goto L_0x087b
            r2 = r16
            r14 = r21
            r4 = 0
        L_0x082d:
            if (r4 >= r2) goto L_0x087d
            com.google.android.gms.internal.measurement.zzbr$zzc r6 = r9.zzb(r4)     // Catch:{ all -> 0x0f85 }
            java.lang.String r7 = r6.zzc()     // Catch:{ all -> 0x0f85 }
            boolean r7 = r5.equals(r7)     // Catch:{ all -> 0x0f85 }
            if (r7 == 0) goto L_0x084e
            r57.zzh()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzbr$zze r7 = com.google.android.gms.measurement.internal.zzkw.zza(r6, r8)     // Catch:{ all -> 0x0f85 }
            if (r7 == 0) goto L_0x084e
            r9.zzc(r4)     // Catch:{ all -> 0x0f85 }
            int r2 = r2 + -1
            int r4 = r4 + -1
            goto L_0x0878
        L_0x084e:
            r57.zzh()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzbr$zze r6 = com.google.android.gms.measurement.internal.zzkw.zza(r6, r11)     // Catch:{ all -> 0x0f85 }
            if (r6 == 0) goto L_0x0878
            boolean r7 = r6.zze()     // Catch:{ all -> 0x0f85 }
            if (r7 == 0) goto L_0x0866
            long r6 = r6.zzf()     // Catch:{ all -> 0x0f85 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0f85 }
            goto L_0x0867
        L_0x0866:
            r6 = 0
        L_0x0867:
            if (r6 == 0) goto L_0x0878
            long r12 = r6.longValue()     // Catch:{ all -> 0x0f85 }
            r21 = 0
            int r7 = (r12 > r21 ? 1 : (r12 == r21 ? 0 : -1))
            if (r7 <= 0) goto L_0x0878
            long r6 = r6.longValue()     // Catch:{ all -> 0x0f85 }
            long r14 = r14 + r6
        L_0x0878:
            r6 = 1
            int r4 = r4 + r6
            goto L_0x082d
        L_0x087b:
            r14 = r21
        L_0x087d:
            r2 = 0
            r1.zza(r9, r14, r2)     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzx r2 = r2.zzb()     // Catch:{ all -> 0x0f85 }
            java.lang.String r4 = r9.zzj()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r5 = com.google.android.gms.measurement.internal.zzap.zzbo     // Catch:{ all -> 0x0f85 }
            boolean r2 = r2.zze(r4, r5)     // Catch:{ all -> 0x0f85 }
            java.lang.String r4 = "_se"
            if (r2 == 0) goto L_0x0944
            java.util.List r2 = r9.zza()     // Catch:{ all -> 0x0f85 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0f85 }
        L_0x089d:
            boolean r5 = r2.hasNext()     // Catch:{ all -> 0x0f85 }
            if (r5 == 0) goto L_0x08b7
            java.lang.Object r5 = r2.next()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzbr$zzc r5 = (com.google.android.gms.internal.measurement.zzbr.zzc) r5     // Catch:{ all -> 0x0f85 }
            java.lang.String r6 = "_s"
            java.lang.String r5 = r5.zzc()     // Catch:{ all -> 0x0f85 }
            boolean r5 = r6.equals(r5)     // Catch:{ all -> 0x0f85 }
            if (r5 == 0) goto L_0x089d
            r2 = 1
            goto L_0x08b8
        L_0x08b7:
            r2 = 0
        L_0x08b8:
            if (r2 == 0) goto L_0x08c5
            com.google.android.gms.measurement.internal.zzac r2 = r57.zze()     // Catch:{ all -> 0x0f85 }
            java.lang.String r5 = r9.zzj()     // Catch:{ all -> 0x0f85 }
            r2.zzb(r5, r4)     // Catch:{ all -> 0x0f85 }
        L_0x08c5:
            boolean r2 = com.google.android.gms.internal.measurement.zzmv.zzb()     // Catch:{ all -> 0x0f85 }
            if (r2 == 0) goto L_0x093f
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzx r2 = r2.zzb()     // Catch:{ all -> 0x0f85 }
            java.lang.String r5 = r9.zzj()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r6 = com.google.android.gms.measurement.internal.zzap.zzbp     // Catch:{ all -> 0x0f85 }
            boolean r2 = r2.zze(r5, r6)     // Catch:{ all -> 0x0f85 }
            if (r2 == 0) goto L_0x093f
            java.lang.String r2 = "_sid"
            int r2 = com.google.android.gms.measurement.internal.zzkw.zza(r9, r2)     // Catch:{ all -> 0x0f85 }
            if (r2 < 0) goto L_0x08e7
            r2 = 1
            goto L_0x08e8
        L_0x08e7:
            r2 = 0
        L_0x08e8:
            if (r2 != 0) goto L_0x093f
            int r2 = com.google.android.gms.measurement.internal.zzkw.zza(r9, r4)     // Catch:{ all -> 0x0f85 }
            if (r2 < 0) goto L_0x0961
            r9.zze(r2)     // Catch:{ all -> 0x0f85 }
            boolean r2 = com.google.android.gms.internal.measurement.zzky.zzb()     // Catch:{ all -> 0x0f85 }
            java.lang.String r4 = "Session engagement user property is in the bundle without session ID. appId"
            if (r2 == 0) goto L_0x0927
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzx r2 = r2.zzb()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzbr$zzg r5 = r3.zza     // Catch:{ all -> 0x0f85 }
            java.lang.String r5 = r5.zzx()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r6 = com.google.android.gms.measurement.internal.zzap.zzcz     // Catch:{ all -> 0x0f85 }
            boolean r2 = r2.zze(r5, r6)     // Catch:{ all -> 0x0f85 }
            if (r2 == 0) goto L_0x0927
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzfk r2 = r2.zzr()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzfm r2 = r2.zzf()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzbr$zzg r5 = r3.zza     // Catch:{ all -> 0x0f85 }
            java.lang.String r5 = r5.zzx()     // Catch:{ all -> 0x0f85 }
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzfk.zza(r5)     // Catch:{ all -> 0x0f85 }
            r2.zza(r4, r5)     // Catch:{ all -> 0x0f85 }
            goto L_0x0961
        L_0x0927:
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzfk r2 = r2.zzr()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzfm r2 = r2.zzi()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzbr$zzg r5 = r3.zza     // Catch:{ all -> 0x0f85 }
            java.lang.String r5 = r5.zzx()     // Catch:{ all -> 0x0f85 }
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzfk.zza(r5)     // Catch:{ all -> 0x0f85 }
            r2.zza(r4, r5)     // Catch:{ all -> 0x0f85 }
            goto L_0x0961
        L_0x093f:
            r2 = 1
            r1.zza(r9, r14, r2)     // Catch:{ all -> 0x0f85 }
            goto L_0x0961
        L_0x0944:
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzx r2 = r2.zzb()     // Catch:{ all -> 0x0f85 }
            java.lang.String r5 = r9.zzj()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r6 = com.google.android.gms.measurement.internal.zzap.zzbr     // Catch:{ all -> 0x0f85 }
            boolean r2 = r2.zze(r5, r6)     // Catch:{ all -> 0x0f85 }
            if (r2 == 0) goto L_0x0961
            com.google.android.gms.measurement.internal.zzac r2 = r57.zze()     // Catch:{ all -> 0x0f85 }
            java.lang.String r5 = r9.zzj()     // Catch:{ all -> 0x0f85 }
            r2.zzb(r5, r4)     // Catch:{ all -> 0x0f85 }
        L_0x0961:
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzx r2 = r2.zzb()     // Catch:{ all -> 0x0f85 }
            java.lang.String r4 = r9.zzj()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r5 = com.google.android.gms.measurement.internal.zzap.zzbc     // Catch:{ all -> 0x0f85 }
            boolean r2 = r2.zze(r4, r5)     // Catch:{ all -> 0x0f85 }
            if (r2 == 0) goto L_0x0a04
            com.google.android.gms.measurement.internal.zzkw r2 = r57.zzh()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzfk r4 = r2.zzr()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzfm r4 = r4.zzx()     // Catch:{ all -> 0x0f85 }
            java.lang.String r5 = "Checking account type status for ad personalization signals"
            r4.zza(r5)     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzgi r4 = r2.zzj()     // Catch:{ all -> 0x0f85 }
            java.lang.String r5 = r9.zzj()     // Catch:{ all -> 0x0f85 }
            boolean r4 = r4.zze(r5)     // Catch:{ all -> 0x0f85 }
            if (r4 == 0) goto L_0x0a04
            com.google.android.gms.measurement.internal.zzac r4 = r2.zzi()     // Catch:{ all -> 0x0f85 }
            java.lang.String r5 = r9.zzj()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzg r4 = r4.zzb(r5)     // Catch:{ all -> 0x0f85 }
            if (r4 == 0) goto L_0x0a04
            boolean r4 = r4.zzaf()     // Catch:{ all -> 0x0f85 }
            if (r4 == 0) goto L_0x0a04
            com.google.android.gms.measurement.internal.zzah r4 = r2.zzl()     // Catch:{ all -> 0x0f85 }
            boolean r4 = r4.zzj()     // Catch:{ all -> 0x0f85 }
            if (r4 == 0) goto L_0x0a04
            com.google.android.gms.measurement.internal.zzfk r4 = r2.zzr()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzfm r4 = r4.zzw()     // Catch:{ all -> 0x0f85 }
            java.lang.String r5 = "Turning off ad personalization due to account type"
            r4.zza(r5)     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzbr$zzk$zza r4 = com.google.android.gms.internal.measurement.zzbr.zzk.zzj()     // Catch:{ all -> 0x0f85 }
            r5 = r20
            com.google.android.gms.internal.measurement.zzbr$zzk$zza r4 = r4.zza(r5)     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzah r2 = r2.zzl()     // Catch:{ all -> 0x0f85 }
            long r6 = r2.zzh()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzbr$zzk$zza r2 = r4.zza(r6)     // Catch:{ all -> 0x0f85 }
            r6 = 1
            com.google.android.gms.internal.measurement.zzbr$zzk$zza r2 = r2.zzb(r6)     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzgo r2 = r2.zzu()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzfd r2 = (com.google.android.gms.internal.measurement.zzfd) r2     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzbr$zzk r2 = (com.google.android.gms.internal.measurement.zzbr.zzk) r2     // Catch:{ all -> 0x0f85 }
            r4 = 0
        L_0x09e2:
            int r6 = r9.zze()     // Catch:{ all -> 0x0f85 }
            if (r4 >= r6) goto L_0x09fe
            com.google.android.gms.internal.measurement.zzbr$zzk r6 = r9.zzd(r4)     // Catch:{ all -> 0x0f85 }
            java.lang.String r6 = r6.zzc()     // Catch:{ all -> 0x0f85 }
            boolean r6 = r5.equals(r6)     // Catch:{ all -> 0x0f85 }
            if (r6 == 0) goto L_0x09fb
            r9.zza(r4, r2)     // Catch:{ all -> 0x0f85 }
            r4 = 1
            goto L_0x09ff
        L_0x09fb:
            int r4 = r4 + 1
            goto L_0x09e2
        L_0x09fe:
            r4 = 0
        L_0x09ff:
            if (r4 != 0) goto L_0x0a04
            r9.zza(r2)     // Catch:{ all -> 0x0f85 }
        L_0x0a04:
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzx r2 = r2.zzb()     // Catch:{ all -> 0x0f85 }
            java.lang.String r4 = r9.zzj()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r5 = com.google.android.gms.measurement.internal.zzap.zzcg     // Catch:{ all -> 0x0f85 }
            boolean r2 = r2.zze(r4, r5)     // Catch:{ all -> 0x0f85 }
            if (r2 == 0) goto L_0x0a19
            zza(r9)     // Catch:{ all -> 0x0f85 }
        L_0x0a19:
            com.google.android.gms.internal.measurement.zzbr$zzg$zza r2 = r9.zzm()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzn r10 = r57.zzf()     // Catch:{ all -> 0x0f85 }
            java.lang.String r11 = r9.zzj()     // Catch:{ all -> 0x0f85 }
            java.util.List r12 = r9.zza()     // Catch:{ all -> 0x0f85 }
            java.util.List r13 = r9.zzd()     // Catch:{ all -> 0x0f85 }
            long r4 = r9.zzf()     // Catch:{ all -> 0x0f85 }
            java.lang.Long r14 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x0f85 }
            long r4 = r9.zzg()     // Catch:{ all -> 0x0f85 }
            java.lang.Long r15 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x0f85 }
            java.util.List r4 = r10.zza(r11, r12, r13, r14, r15)     // Catch:{ all -> 0x0f85 }
            r2.zzc(r4)     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzx r2 = r2.zzb()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzbr$zzg r4 = r3.zza     // Catch:{ all -> 0x0f85 }
            java.lang.String r4 = r4.zzx()     // Catch:{ all -> 0x0f85 }
            boolean r2 = r2.zzg(r4)     // Catch:{ all -> 0x0f85 }
            if (r2 == 0) goto L_0x0dca
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ all -> 0x0dc5 }
            r2.<init>()     // Catch:{ all -> 0x0dc5 }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x0dc5 }
            r4.<init>()     // Catch:{ all -> 0x0dc5 }
            com.google.android.gms.measurement.internal.zzgo r5 = r1.zzj     // Catch:{ all -> 0x0dc5 }
            com.google.android.gms.measurement.internal.zzla r5 = r5.zzi()     // Catch:{ all -> 0x0dc5 }
            java.security.SecureRandom r5 = r5.zzh()     // Catch:{ all -> 0x0dc5 }
            r6 = 0
        L_0x0a6b:
            int r7 = r9.zzb()     // Catch:{ all -> 0x0dc5 }
            if (r6 >= r7) goto L_0x0d91
            com.google.android.gms.internal.measurement.zzbr$zzc r7 = r9.zzb(r6)     // Catch:{ all -> 0x0dc5 }
            com.google.android.gms.internal.measurement.zzfd$zzb r7 = r7.zzbm()     // Catch:{ all -> 0x0dc5 }
            com.google.android.gms.internal.measurement.zzfd$zzb r7 = (com.google.android.gms.internal.measurement.zzfd.zzb) r7     // Catch:{ all -> 0x0dc5 }
            com.google.android.gms.internal.measurement.zzbr$zzc$zza r7 = (com.google.android.gms.internal.measurement.zzbr.zzc.zza) r7     // Catch:{ all -> 0x0dc5 }
            java.lang.String r8 = r7.zzd()     // Catch:{ all -> 0x0dc5 }
            java.lang.String r10 = "_ep"
            boolean r8 = r8.equals(r10)     // Catch:{ all -> 0x0dc5 }
            java.lang.String r10 = "_sr"
            if (r8 == 0) goto L_0x0b00
            com.google.android.gms.measurement.internal.zzkw r8 = r57.zzh()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzgo r11 = r7.zzu()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzfd r11 = (com.google.android.gms.internal.measurement.zzfd) r11     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzbr$zzc r11 = (com.google.android.gms.internal.measurement.zzbr.zzc) r11     // Catch:{ all -> 0x0f85 }
            java.lang.String r12 = "_en"
            java.lang.Object r8 = r8.zzb(r11, r12)     // Catch:{ all -> 0x0f85 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x0f85 }
            java.lang.Object r11 = r2.get(r8)     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzaj r11 = (com.google.android.gms.measurement.internal.zzaj) r11     // Catch:{ all -> 0x0f85 }
            if (r11 != 0) goto L_0x0ab8
            com.google.android.gms.measurement.internal.zzac r11 = r57.zze()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzbr$zzg r12 = r3.zza     // Catch:{ all -> 0x0f85 }
            java.lang.String r12 = r12.zzx()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzaj r11 = r11.zza(r12, r8)     // Catch:{ all -> 0x0f85 }
            r2.put(r8, r11)     // Catch:{ all -> 0x0f85 }
        L_0x0ab8:
            java.lang.Long r8 = r11.zzi     // Catch:{ all -> 0x0f85 }
            if (r8 != 0) goto L_0x0af7
            java.lang.Long r8 = r11.zzj     // Catch:{ all -> 0x0f85 }
            long r12 = r8.longValue()     // Catch:{ all -> 0x0f85 }
            r14 = 1
            int r8 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r8 <= 0) goto L_0x0ad1
            com.google.android.gms.measurement.internal.zzkw r8 = r57.zzh()     // Catch:{ all -> 0x0f85 }
            java.lang.Long r12 = r11.zzj     // Catch:{ all -> 0x0f85 }
            r8.zza(r7, r10, r12)     // Catch:{ all -> 0x0f85 }
        L_0x0ad1:
            java.lang.Boolean r8 = r11.zzk     // Catch:{ all -> 0x0f85 }
            if (r8 == 0) goto L_0x0aec
            java.lang.Boolean r8 = r11.zzk     // Catch:{ all -> 0x0f85 }
            boolean r8 = r8.booleanValue()     // Catch:{ all -> 0x0f85 }
            if (r8 == 0) goto L_0x0aec
            com.google.android.gms.measurement.internal.zzkw r8 = r57.zzh()     // Catch:{ all -> 0x0f85 }
            java.lang.String r10 = "_efs"
            r11 = 1
            java.lang.Long r13 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x0f85 }
            r8.zza(r7, r10, r13)     // Catch:{ all -> 0x0f85 }
        L_0x0aec:
            com.google.android.gms.internal.measurement.zzgo r8 = r7.zzu()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzfd r8 = (com.google.android.gms.internal.measurement.zzfd) r8     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzbr$zzc r8 = (com.google.android.gms.internal.measurement.zzbr.zzc) r8     // Catch:{ all -> 0x0f85 }
            r4.add(r8)     // Catch:{ all -> 0x0f85 }
        L_0x0af7:
            r9.zza(r6, r7)     // Catch:{ all -> 0x0f85 }
        L_0x0afa:
            r58 = r5
            r1 = r6
            r5 = r2
            goto L_0x0d88
        L_0x0b00:
            com.google.android.gms.measurement.internal.zzgi r8 = r57.zzc()     // Catch:{ all -> 0x0dc5 }
            com.google.android.gms.internal.measurement.zzbr$zzg r11 = r3.zza     // Catch:{ all -> 0x0dc5 }
            java.lang.String r11 = r11.zzx()     // Catch:{ all -> 0x0dc5 }
            long r11 = r8.zzf(r11)     // Catch:{ all -> 0x0dc5 }
            com.google.android.gms.measurement.internal.zzgo r8 = r1.zzj     // Catch:{ all -> 0x0dc5 }
            r8.zzi()     // Catch:{ all -> 0x0dc5 }
            long r13 = r7.zzf()     // Catch:{ all -> 0x0dc5 }
            long r13 = com.google.android.gms.measurement.internal.zzla.zza(r13, r11)     // Catch:{ all -> 0x0dc5 }
            com.google.android.gms.internal.measurement.zzgo r8 = r7.zzu()     // Catch:{ all -> 0x0dc5 }
            com.google.android.gms.internal.measurement.zzfd r8 = (com.google.android.gms.internal.measurement.zzfd) r8     // Catch:{ all -> 0x0dc5 }
            com.google.android.gms.internal.measurement.zzbr$zzc r8 = (com.google.android.gms.internal.measurement.zzbr.zzc) r8     // Catch:{ all -> 0x0dc5 }
            java.lang.String r15 = "_dbg"
            r23 = r11
            r20 = 1
            java.lang.Long r11 = java.lang.Long.valueOf(r20)     // Catch:{ all -> 0x0dc5 }
            boolean r12 = android.text.TextUtils.isEmpty(r15)     // Catch:{ all -> 0x0dc5 }
            if (r12 != 0) goto L_0x0b8d
            if (r11 != 0) goto L_0x0b36
            goto L_0x0b8d
        L_0x0b36:
            java.util.List r8 = r8.zza()     // Catch:{ all -> 0x0f85 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ all -> 0x0f85 }
        L_0x0b3e:
            boolean r12 = r8.hasNext()     // Catch:{ all -> 0x0f85 }
            if (r12 == 0) goto L_0x0b8d
            java.lang.Object r12 = r8.next()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzbr$zze r12 = (com.google.android.gms.internal.measurement.zzbr.zze) r12     // Catch:{ all -> 0x0f85 }
            r58 = r8
            java.lang.String r8 = r12.zzb()     // Catch:{ all -> 0x0f85 }
            boolean r8 = r15.equals(r8)     // Catch:{ all -> 0x0f85 }
            if (r8 == 0) goto L_0x0b8a
            boolean r8 = r11 instanceof java.lang.Long     // Catch:{ all -> 0x0f85 }
            if (r8 == 0) goto L_0x0b68
            long r15 = r12.zzf()     // Catch:{ all -> 0x0f85 }
            java.lang.Long r8 = java.lang.Long.valueOf(r15)     // Catch:{ all -> 0x0f85 }
            boolean r8 = r11.equals(r8)     // Catch:{ all -> 0x0f85 }
            if (r8 != 0) goto L_0x0b88
        L_0x0b68:
            boolean r8 = r11 instanceof java.lang.String     // Catch:{ all -> 0x0f85 }
            if (r8 == 0) goto L_0x0b76
            java.lang.String r8 = r12.zzd()     // Catch:{ all -> 0x0f85 }
            boolean r8 = r11.equals(r8)     // Catch:{ all -> 0x0f85 }
            if (r8 != 0) goto L_0x0b88
        L_0x0b76:
            boolean r8 = r11 instanceof java.lang.Double     // Catch:{ all -> 0x0f85 }
            if (r8 == 0) goto L_0x0b8d
            double r15 = r12.zzh()     // Catch:{ all -> 0x0f85 }
            java.lang.Double r8 = java.lang.Double.valueOf(r15)     // Catch:{ all -> 0x0f85 }
            boolean r8 = r11.equals(r8)     // Catch:{ all -> 0x0f85 }
            if (r8 == 0) goto L_0x0b8d
        L_0x0b88:
            r8 = 1
            goto L_0x0b8e
        L_0x0b8a:
            r8 = r58
            goto L_0x0b3e
        L_0x0b8d:
            r8 = 0
        L_0x0b8e:
            if (r8 != 0) goto L_0x0ba3
            com.google.android.gms.measurement.internal.zzgi r8 = r57.zzc()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzbr$zzg r11 = r3.zza     // Catch:{ all -> 0x0f85 }
            java.lang.String r11 = r11.zzx()     // Catch:{ all -> 0x0f85 }
            java.lang.String r12 = r7.zzd()     // Catch:{ all -> 0x0f85 }
            int r8 = r8.zzd(r11, r12)     // Catch:{ all -> 0x0f85 }
            goto L_0x0ba4
        L_0x0ba3:
            r8 = 1
        L_0x0ba4:
            if (r8 > 0) goto L_0x0bcd
            com.google.android.gms.measurement.internal.zzgo r10 = r1.zzj     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzfk r10 = r10.zzr()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzfm r10 = r10.zzi()     // Catch:{ all -> 0x0f85 }
            java.lang.String r11 = "Sample rate must be positive. event, rate"
            java.lang.String r12 = r7.zzd()     // Catch:{ all -> 0x0f85 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0f85 }
            r10.zza(r11, r12, r8)     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzgo r8 = r7.zzu()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzfd r8 = (com.google.android.gms.internal.measurement.zzfd) r8     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzbr$zzc r8 = (com.google.android.gms.internal.measurement.zzbr.zzc) r8     // Catch:{ all -> 0x0f85 }
            r4.add(r8)     // Catch:{ all -> 0x0f85 }
            r9.zza(r6, r7)     // Catch:{ all -> 0x0f85 }
            goto L_0x0afa
        L_0x0bcd:
            java.lang.String r11 = r7.zzd()     // Catch:{ all -> 0x0dc5 }
            java.lang.Object r11 = r2.get(r11)     // Catch:{ all -> 0x0dc5 }
            com.google.android.gms.measurement.internal.zzaj r11 = (com.google.android.gms.measurement.internal.zzaj) r11     // Catch:{ all -> 0x0dc5 }
            if (r11 != 0) goto L_0x0c66
            com.google.android.gms.measurement.internal.zzac r11 = r57.zze()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzbr$zzg r12 = r3.zza     // Catch:{ all -> 0x0f85 }
            java.lang.String r12 = r12.zzx()     // Catch:{ all -> 0x0f85 }
            java.lang.String r15 = r7.zzd()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzaj r11 = r11.zza(r12, r15)     // Catch:{ all -> 0x0f85 }
            if (r11 != 0) goto L_0x0c66
            com.google.android.gms.measurement.internal.zzgo r11 = r1.zzj     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzfk r11 = r11.zzr()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzfm r11 = r11.zzi()     // Catch:{ all -> 0x0f85 }
            java.lang.String r12 = "Event being bundled has no eventAggregate. appId, eventName"
            com.google.android.gms.internal.measurement.zzbr$zzg r15 = r3.zza     // Catch:{ all -> 0x0f85 }
            java.lang.String r15 = r15.zzx()     // Catch:{ all -> 0x0f85 }
            r20 = r13
            java.lang.String r13 = r7.zzd()     // Catch:{ all -> 0x0f85 }
            r11.zza(r12, r15, r13)     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzgo r11 = r1.zzj     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzx r11 = r11.zzb()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzbr$zzg r12 = r3.zza     // Catch:{ all -> 0x0f85 }
            java.lang.String r12 = r12.zzx()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r13 = com.google.android.gms.measurement.internal.zzap.zzbn     // Catch:{ all -> 0x0f85 }
            boolean r11 = r11.zze(r12, r13)     // Catch:{ all -> 0x0f85 }
            if (r11 == 0) goto L_0x0c42
            com.google.android.gms.measurement.internal.zzaj r11 = new com.google.android.gms.measurement.internal.zzaj     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzbr$zzg r12 = r3.zza     // Catch:{ all -> 0x0f85 }
            java.lang.String r26 = r12.zzx()     // Catch:{ all -> 0x0f85 }
            java.lang.String r27 = r7.zzd()     // Catch:{ all -> 0x0f85 }
            r28 = 1
            r30 = 1
            r32 = 1
            long r34 = r7.zzf()     // Catch:{ all -> 0x0f85 }
            r36 = 0
            r38 = 0
            r39 = 0
            r40 = 0
            r41 = 0
            r25 = r11
            r25.<init>(r26, r27, r28, r30, r32, r34, r36, r38, r39, r40, r41)     // Catch:{ all -> 0x0f85 }
            goto L_0x0c68
        L_0x0c42:
            com.google.android.gms.measurement.internal.zzaj r11 = new com.google.android.gms.measurement.internal.zzaj     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzbr$zzg r12 = r3.zza     // Catch:{ all -> 0x0f85 }
            java.lang.String r43 = r12.zzx()     // Catch:{ all -> 0x0f85 }
            java.lang.String r44 = r7.zzd()     // Catch:{ all -> 0x0f85 }
            r45 = 1
            r47 = 1
            long r49 = r7.zzf()     // Catch:{ all -> 0x0f85 }
            r51 = 0
            r53 = 0
            r54 = 0
            r55 = 0
            r56 = 0
            r42 = r11
            r42.<init>(r43, r44, r45, r47, r49, r51, r53, r54, r55, r56)     // Catch:{ all -> 0x0f85 }
            goto L_0x0c68
        L_0x0c66:
            r20 = r13
        L_0x0c68:
            com.google.android.gms.measurement.internal.zzkw r12 = r57.zzh()     // Catch:{ all -> 0x0dc5 }
            com.google.android.gms.internal.measurement.zzgo r13 = r7.zzu()     // Catch:{ all -> 0x0dc5 }
            com.google.android.gms.internal.measurement.zzfd r13 = (com.google.android.gms.internal.measurement.zzfd) r13     // Catch:{ all -> 0x0dc5 }
            com.google.android.gms.internal.measurement.zzbr$zzc r13 = (com.google.android.gms.internal.measurement.zzbr.zzc) r13     // Catch:{ all -> 0x0dc5 }
            java.lang.String r14 = "_eid"
            java.lang.Object r12 = r12.zzb(r13, r14)     // Catch:{ all -> 0x0dc5 }
            java.lang.Long r12 = (java.lang.Long) r12     // Catch:{ all -> 0x0dc5 }
            if (r12 == 0) goto L_0x0c80
            r13 = 1
            goto L_0x0c81
        L_0x0c80:
            r13 = 0
        L_0x0c81:
            java.lang.Boolean r13 = java.lang.Boolean.valueOf(r13)     // Catch:{ all -> 0x0dc5 }
            r14 = 1
            if (r8 != r14) goto L_0x0cb6
            com.google.android.gms.internal.measurement.zzgo r8 = r7.zzu()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzfd r8 = (com.google.android.gms.internal.measurement.zzfd) r8     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzbr$zzc r8 = (com.google.android.gms.internal.measurement.zzbr.zzc) r8     // Catch:{ all -> 0x0f85 }
            r4.add(r8)     // Catch:{ all -> 0x0f85 }
            boolean r8 = r13.booleanValue()     // Catch:{ all -> 0x0f85 }
            if (r8 == 0) goto L_0x0cb1
            java.lang.Long r8 = r11.zzi     // Catch:{ all -> 0x0f85 }
            if (r8 != 0) goto L_0x0ca5
            java.lang.Long r8 = r11.zzj     // Catch:{ all -> 0x0f85 }
            if (r8 != 0) goto L_0x0ca5
            java.lang.Boolean r8 = r11.zzk     // Catch:{ all -> 0x0f85 }
            if (r8 == 0) goto L_0x0cb1
        L_0x0ca5:
            r8 = 0
            com.google.android.gms.measurement.internal.zzaj r10 = r11.zza(r8, r8, r8)     // Catch:{ all -> 0x0f85 }
            java.lang.String r8 = r7.zzd()     // Catch:{ all -> 0x0f85 }
            r2.put(r8, r10)     // Catch:{ all -> 0x0f85 }
        L_0x0cb1:
            r9.zza(r6, r7)     // Catch:{ all -> 0x0f85 }
            goto L_0x0afa
        L_0x0cb6:
            int r14 = r5.nextInt(r8)     // Catch:{ all -> 0x0dc5 }
            if (r14 != 0) goto L_0x0cf9
            com.google.android.gms.measurement.internal.zzkw r12 = r57.zzh()     // Catch:{ all -> 0x0f85 }
            long r14 = (long) r8     // Catch:{ all -> 0x0f85 }
            java.lang.Long r8 = java.lang.Long.valueOf(r14)     // Catch:{ all -> 0x0f85 }
            r12.zza(r7, r10, r8)     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzgo r8 = r7.zzu()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzfd r8 = (com.google.android.gms.internal.measurement.zzfd) r8     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzbr$zzc r8 = (com.google.android.gms.internal.measurement.zzbr.zzc) r8     // Catch:{ all -> 0x0f85 }
            r4.add(r8)     // Catch:{ all -> 0x0f85 }
            boolean r8 = r13.booleanValue()     // Catch:{ all -> 0x0f85 }
            if (r8 == 0) goto L_0x0ce2
            java.lang.Long r8 = java.lang.Long.valueOf(r14)     // Catch:{ all -> 0x0f85 }
            r10 = 0
            com.google.android.gms.measurement.internal.zzaj r11 = r11.zza(r10, r8, r10)     // Catch:{ all -> 0x0f85 }
        L_0x0ce2:
            java.lang.String r8 = r7.zzd()     // Catch:{ all -> 0x0f85 }
            long r12 = r7.zzf()     // Catch:{ all -> 0x0f85 }
            r14 = r20
            com.google.android.gms.measurement.internal.zzaj r10 = r11.zza(r12, r14)     // Catch:{ all -> 0x0f85 }
            r2.put(r8, r10)     // Catch:{ all -> 0x0f85 }
            r58 = r5
            r1 = r6
            r5 = r2
            goto L_0x0d85
        L_0x0cf9:
            r58 = r5
            r14 = r20
            java.lang.Long r5 = r11.zzh     // Catch:{ all -> 0x0dc5 }
            if (r5 == 0) goto L_0x0d0c
            java.lang.Long r5 = r11.zzh     // Catch:{ all -> 0x0f85 }
            long r20 = r5.longValue()     // Catch:{ all -> 0x0f85 }
            r18 = r2
            r16 = r6
            goto L_0x0d1f
        L_0x0d0c:
            com.google.android.gms.measurement.internal.zzgo r5 = r1.zzj     // Catch:{ all -> 0x0dc5 }
            r5.zzi()     // Catch:{ all -> 0x0dc5 }
            r16 = r6
            long r5 = r7.zzg()     // Catch:{ all -> 0x0dc5 }
            r18 = r2
            r1 = r23
            long r20 = com.google.android.gms.measurement.internal.zzla.zza(r5, r1)     // Catch:{ all -> 0x0dc5 }
        L_0x0d1f:
            int r1 = (r20 > r14 ? 1 : (r20 == r14 ? 0 : -1))
            if (r1 == 0) goto L_0x0d6f
            com.google.android.gms.measurement.internal.zzkw r1 = r57.zzh()     // Catch:{ all -> 0x0dc5 }
            java.lang.String r2 = "_efs"
            r5 = 1
            java.lang.Long r12 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0dc5 }
            r1.zza(r7, r2, r12)     // Catch:{ all -> 0x0dc5 }
            com.google.android.gms.measurement.internal.zzkw r1 = r57.zzh()     // Catch:{ all -> 0x0dc5 }
            long r5 = (long) r8     // Catch:{ all -> 0x0dc5 }
            java.lang.Long r2 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0dc5 }
            r1.zza(r7, r10, r2)     // Catch:{ all -> 0x0dc5 }
            com.google.android.gms.internal.measurement.zzgo r1 = r7.zzu()     // Catch:{ all -> 0x0dc5 }
            com.google.android.gms.internal.measurement.zzfd r1 = (com.google.android.gms.internal.measurement.zzfd) r1     // Catch:{ all -> 0x0dc5 }
            com.google.android.gms.internal.measurement.zzbr$zzc r1 = (com.google.android.gms.internal.measurement.zzbr.zzc) r1     // Catch:{ all -> 0x0dc5 }
            r4.add(r1)     // Catch:{ all -> 0x0dc5 }
            boolean r1 = r13.booleanValue()     // Catch:{ all -> 0x0dc5 }
            if (r1 == 0) goto L_0x0d5d
            java.lang.Long r1 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0dc5 }
            r2 = 1
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r2)     // Catch:{ all -> 0x0dc5 }
            r2 = 0
            com.google.android.gms.measurement.internal.zzaj r11 = r11.zza(r2, r1, r5)     // Catch:{ all -> 0x0dc5 }
        L_0x0d5d:
            java.lang.String r1 = r7.zzd()     // Catch:{ all -> 0x0dc5 }
            long r5 = r7.zzf()     // Catch:{ all -> 0x0dc5 }
            com.google.android.gms.measurement.internal.zzaj r2 = r11.zza(r5, r14)     // Catch:{ all -> 0x0dc5 }
            r5 = r18
            r5.put(r1, r2)     // Catch:{ all -> 0x0dc5 }
            goto L_0x0d83
        L_0x0d6f:
            r5 = r18
            boolean r1 = r13.booleanValue()     // Catch:{ all -> 0x0dc5 }
            if (r1 == 0) goto L_0x0d83
            java.lang.String r1 = r7.zzd()     // Catch:{ all -> 0x0dc5 }
            r2 = 0
            com.google.android.gms.measurement.internal.zzaj r6 = r11.zza(r12, r2, r2)     // Catch:{ all -> 0x0dc5 }
            r5.put(r1, r6)     // Catch:{ all -> 0x0dc5 }
        L_0x0d83:
            r1 = r16
        L_0x0d85:
            r9.zza(r1, r7)     // Catch:{ all -> 0x0dc5 }
        L_0x0d88:
            int r6 = r1 + 1
            r1 = r57
            r2 = r5
            r5 = r58
            goto L_0x0a6b
        L_0x0d91:
            r5 = r2
            int r1 = r4.size()     // Catch:{ all -> 0x0dc5 }
            int r2 = r9.zzb()     // Catch:{ all -> 0x0dc5 }
            if (r1 >= r2) goto L_0x0da3
            com.google.android.gms.internal.measurement.zzbr$zzg$zza r1 = r9.zzc()     // Catch:{ all -> 0x0dc5 }
            r1.zza(r4)     // Catch:{ all -> 0x0dc5 }
        L_0x0da3:
            java.util.Set r1 = r5.entrySet()     // Catch:{ all -> 0x0dc5 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0dc5 }
        L_0x0dab:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x0dc5 }
            if (r2 == 0) goto L_0x0dca
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x0dc5 }
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch:{ all -> 0x0dc5 }
            com.google.android.gms.measurement.internal.zzac r4 = r57.zze()     // Catch:{ all -> 0x0dc5 }
            java.lang.Object r2 = r2.getValue()     // Catch:{ all -> 0x0dc5 }
            com.google.android.gms.measurement.internal.zzaj r2 = (com.google.android.gms.measurement.internal.zzaj) r2     // Catch:{ all -> 0x0dc5 }
            r4.zza(r2)     // Catch:{ all -> 0x0dc5 }
            goto L_0x0dab
        L_0x0dc5:
            r0 = move-exception
            r1 = r57
            goto L_0x0f86
        L_0x0dca:
            r1 = r57
            com.google.android.gms.measurement.internal.zzgo r2 = r1.zzj     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzx r2 = r2.zzb()     // Catch:{ all -> 0x0f85 }
            java.lang.String r4 = r9.zzj()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r5 = com.google.android.gms.measurement.internal.zzap.zzcg     // Catch:{ all -> 0x0f85 }
            boolean r2 = r2.zze(r4, r5)     // Catch:{ all -> 0x0f85 }
            if (r2 != 0) goto L_0x0de1
            zza(r9)     // Catch:{ all -> 0x0f85 }
        L_0x0de1:
            com.google.android.gms.internal.measurement.zzbr$zzg r2 = r3.zza     // Catch:{ all -> 0x0f85 }
            java.lang.String r2 = r2.zzx()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzac r4 = r57.zze()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzg r4 = r4.zzb(r2)     // Catch:{ all -> 0x0f85 }
            if (r4 != 0) goto L_0x0e0b
            com.google.android.gms.measurement.internal.zzgo r4 = r1.zzj     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzfk r4 = r4.zzr()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzfm r4 = r4.zzf()     // Catch:{ all -> 0x0f85 }
            java.lang.String r5 = "Bundling raw events w/o app info. appId"
            com.google.android.gms.internal.measurement.zzbr$zzg r6 = r3.zza     // Catch:{ all -> 0x0f85 }
            java.lang.String r6 = r6.zzx()     // Catch:{ all -> 0x0f85 }
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzfk.zza(r6)     // Catch:{ all -> 0x0f85 }
            r4.zza(r5, r6)     // Catch:{ all -> 0x0f85 }
            goto L_0x0e66
        L_0x0e0b:
            int r5 = r9.zzb()     // Catch:{ all -> 0x0f85 }
            if (r5 <= 0) goto L_0x0e66
            long r5 = r4.zzk()     // Catch:{ all -> 0x0f85 }
            r7 = 0
            int r10 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r10 == 0) goto L_0x0e1f
            r9.zze(r5)     // Catch:{ all -> 0x0f85 }
            goto L_0x0e22
        L_0x0e1f:
            r9.zzi()     // Catch:{ all -> 0x0f85 }
        L_0x0e22:
            long r7 = r4.zzj()     // Catch:{ all -> 0x0f85 }
            r10 = 0
            int r12 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r12 != 0) goto L_0x0e2d
            goto L_0x0e2e
        L_0x0e2d:
            r5 = r7
        L_0x0e2e:
            int r7 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r7 == 0) goto L_0x0e36
            r9.zzd(r5)     // Catch:{ all -> 0x0f85 }
            goto L_0x0e39
        L_0x0e36:
            r9.zzh()     // Catch:{ all -> 0x0f85 }
        L_0x0e39:
            r4.zzv()     // Catch:{ all -> 0x0f85 }
            long r5 = r4.zzs()     // Catch:{ all -> 0x0f85 }
            int r5 = (int) r5     // Catch:{ all -> 0x0f85 }
            r9.zzg(r5)     // Catch:{ all -> 0x0f85 }
            long r5 = r9.zzf()     // Catch:{ all -> 0x0f85 }
            r4.zza(r5)     // Catch:{ all -> 0x0f85 }
            long r5 = r9.zzg()     // Catch:{ all -> 0x0f85 }
            r4.zzb(r5)     // Catch:{ all -> 0x0f85 }
            java.lang.String r5 = r4.zzad()     // Catch:{ all -> 0x0f85 }
            if (r5 == 0) goto L_0x0e5c
            r9.zzj(r5)     // Catch:{ all -> 0x0f85 }
            goto L_0x0e5f
        L_0x0e5c:
            r9.zzk()     // Catch:{ all -> 0x0f85 }
        L_0x0e5f:
            com.google.android.gms.measurement.internal.zzac r5 = r57.zze()     // Catch:{ all -> 0x0f85 }
            r5.zza(r4)     // Catch:{ all -> 0x0f85 }
        L_0x0e66:
            int r4 = r9.zzb()     // Catch:{ all -> 0x0f85 }
            if (r4 <= 0) goto L_0x0ecc
            com.google.android.gms.measurement.internal.zzgo r4 = r1.zzj     // Catch:{ all -> 0x0f85 }
            r4.zzu()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzgi r4 = r57.zzc()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzbr$zzg r5 = r3.zza     // Catch:{ all -> 0x0f85 }
            java.lang.String r5 = r5.zzx()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzbo$zzb r4 = r4.zza(r5)     // Catch:{ all -> 0x0f85 }
            if (r4 == 0) goto L_0x0e90
            boolean r5 = r4.zza()     // Catch:{ all -> 0x0f85 }
            if (r5 != 0) goto L_0x0e88
            goto L_0x0e90
        L_0x0e88:
            long r4 = r4.zzb()     // Catch:{ all -> 0x0f85 }
            r9.zzi(r4)     // Catch:{ all -> 0x0f85 }
            goto L_0x0ebb
        L_0x0e90:
            com.google.android.gms.internal.measurement.zzbr$zzg r4 = r3.zza     // Catch:{ all -> 0x0f85 }
            java.lang.String r4 = r4.zzam()     // Catch:{ all -> 0x0f85 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0f85 }
            if (r4 == 0) goto L_0x0ea2
            r4 = -1
            r9.zzi(r4)     // Catch:{ all -> 0x0f85 }
            goto L_0x0ebb
        L_0x0ea2:
            com.google.android.gms.measurement.internal.zzgo r4 = r1.zzj     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzfk r4 = r4.zzr()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzfm r4 = r4.zzi()     // Catch:{ all -> 0x0f85 }
            java.lang.String r5 = "Did not find measurement config or missing version info. appId"
            com.google.android.gms.internal.measurement.zzbr$zzg r6 = r3.zza     // Catch:{ all -> 0x0f85 }
            java.lang.String r6 = r6.zzx()     // Catch:{ all -> 0x0f85 }
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzfk.zza(r6)     // Catch:{ all -> 0x0f85 }
            r4.zza(r5, r6)     // Catch:{ all -> 0x0f85 }
        L_0x0ebb:
            com.google.android.gms.measurement.internal.zzac r4 = r57.zze()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzgo r5 = r9.zzu()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzfd r5 = (com.google.android.gms.internal.measurement.zzfd) r5     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.internal.measurement.zzbr$zzg r5 = (com.google.android.gms.internal.measurement.zzbr.zzg) r5     // Catch:{ all -> 0x0f85 }
            r12 = r19
            r4.zza(r5, r12)     // Catch:{ all -> 0x0f85 }
        L_0x0ecc:
            com.google.android.gms.measurement.internal.zzac r4 = r57.zze()     // Catch:{ all -> 0x0f85 }
            java.util.List<java.lang.Long> r3 = r3.zzb     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r3)     // Catch:{ all -> 0x0f85 }
            r4.zzd()     // Catch:{ all -> 0x0f85 }
            r4.zzak()     // Catch:{ all -> 0x0f85 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0f85 }
            java.lang.String r6 = "rowid in ("
            r5.<init>(r6)     // Catch:{ all -> 0x0f85 }
            r6 = 0
        L_0x0ee3:
            int r7 = r3.size()     // Catch:{ all -> 0x0f85 }
            if (r6 >= r7) goto L_0x0f00
            if (r6 == 0) goto L_0x0ef0
            java.lang.String r7 = ","
            r5.append(r7)     // Catch:{ all -> 0x0f85 }
        L_0x0ef0:
            java.lang.Object r7 = r3.get(r6)     // Catch:{ all -> 0x0f85 }
            java.lang.Long r7 = (java.lang.Long) r7     // Catch:{ all -> 0x0f85 }
            long r7 = r7.longValue()     // Catch:{ all -> 0x0f85 }
            r5.append(r7)     // Catch:{ all -> 0x0f85 }
            int r6 = r6 + 1
            goto L_0x0ee3
        L_0x0f00:
            java.lang.String r6 = ")"
            r5.append(r6)     // Catch:{ all -> 0x0f85 }
            android.database.sqlite.SQLiteDatabase r6 = r4.c_()     // Catch:{ all -> 0x0f85 }
            java.lang.String r7 = "raw_events"
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0f85 }
            r8 = 0
            int r5 = r6.delete(r7, r5, r8)     // Catch:{ all -> 0x0f85 }
            int r6 = r3.size()     // Catch:{ all -> 0x0f85 }
            if (r5 == r6) goto L_0x0f33
            com.google.android.gms.measurement.internal.zzfk r4 = r4.zzr()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzfm r4 = r4.zzf()     // Catch:{ all -> 0x0f85 }
            java.lang.String r6 = "Deleted fewer rows from raw events table than expected"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0f85 }
            int r3 = r3.size()     // Catch:{ all -> 0x0f85 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0f85 }
            r4.zza(r6, r5, r3)     // Catch:{ all -> 0x0f85 }
        L_0x0f33:
            com.google.android.gms.measurement.internal.zzac r3 = r57.zze()     // Catch:{ all -> 0x0f85 }
            android.database.sqlite.SQLiteDatabase r4 = r3.c_()     // Catch:{ all -> 0x0f85 }
            java.lang.String r5 = "delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)"
            r6 = 2
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x0f4a }
            r7 = 0
            r6[r7] = r2     // Catch:{ SQLiteException -> 0x0f4a }
            r7 = 1
            r6[r7] = r2     // Catch:{ SQLiteException -> 0x0f4a }
            r4.execSQL(r5, r6)     // Catch:{ SQLiteException -> 0x0f4a }
            goto L_0x0f5d
        L_0x0f4a:
            r0 = move-exception
            r4 = r0
            com.google.android.gms.measurement.internal.zzfk r3 = r3.zzr()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzfm r3 = r3.zzf()     // Catch:{ all -> 0x0f85 }
            java.lang.String r5 = "Failed to remove unused event metadata. appId"
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzfk.zza(r2)     // Catch:{ all -> 0x0f85 }
            r3.zza(r5, r2, r4)     // Catch:{ all -> 0x0f85 }
        L_0x0f5d:
            com.google.android.gms.measurement.internal.zzac r2 = r57.zze()     // Catch:{ all -> 0x0f85 }
            r2.b_()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzac r2 = r57.zze()
            r2.zzh()
            r2 = 1
            return r2
        L_0x0f6d:
            com.google.android.gms.measurement.internal.zzac r2 = r57.zze()     // Catch:{ all -> 0x0f85 }
            r2.b_()     // Catch:{ all -> 0x0f85 }
            com.google.android.gms.measurement.internal.zzac r2 = r57.zze()
            r2.zzh()
            r2 = 0
            return r2
        L_0x0f7d:
            r0 = move-exception
            r2 = r0
        L_0x0f7f:
            if (r4 == 0) goto L_0x0f84
            r4.close()     // Catch:{ all -> 0x0f85 }
        L_0x0f84:
            throw r2     // Catch:{ all -> 0x0f85 }
        L_0x0f85:
            r0 = move-exception
        L_0x0f86:
            r2 = r0
            com.google.android.gms.measurement.internal.zzac r3 = r57.zze()
            r3.zzh()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzks.zza(java.lang.String, long):boolean");
    }

    private static void zza(zzbr.zzg.zza zza2) {
        zza2.zzb((long) LongCompanionObject.MAX_VALUE).zzc(Long.MIN_VALUE);
        for (int i = 0; i < zza2.zzb(); i++) {
            zzbr.zzc zzb2 = zza2.zzb(i);
            if (zzb2.zze() < zza2.zzf()) {
                zza2.zzb(zzb2.zze());
            }
            if (zzb2.zze() > zza2.zzg()) {
                zza2.zzc(zzb2.zze());
            }
        }
    }

    private final void zza(zzbr.zzg.zza zza2, long j, boolean z) {
        zzlb zzlb;
        String str = z ? "_se" : "_lte";
        zzlb zzc2 = zze().zzc(zza2.zzj(), str);
        if (zzc2 == null || zzc2.zze == null) {
            zzlb = new zzlb(zza2.zzj(), DebugKt.DEBUG_PROPERTY_VALUE_AUTO, str, this.zzj.zzm().currentTimeMillis(), Long.valueOf(j));
        } else {
            zzlb = new zzlb(zza2.zzj(), DebugKt.DEBUG_PROPERTY_VALUE_AUTO, str, this.zzj.zzm().currentTimeMillis(), Long.valueOf(((Long) zzc2.zze).longValue() + j));
        }
        zzbr.zzk zzk2 = (zzbr.zzk) ((zzfd) zzbr.zzk.zzj().zza(str).zza(this.zzj.zzm().currentTimeMillis()).zzb(((Long) zzlb.zze).longValue()).zzu());
        boolean z2 = false;
        int zza3 = zzkw.zza(zza2, str);
        if (zza3 >= 0) {
            zza2.zza(zza3, zzk2);
            z2 = true;
        }
        if (!z2) {
            zza2.zza(zzk2);
        }
        if (j > 0) {
            zze().zza(zzlb);
            String str2 = z ? "session-scoped" : "lifetime";
            if (!zzky.zzb() || !this.zzj.zzb().zze(zza2.zzj(), zzap.zzcz)) {
                this.zzj.zzr().zzw().zza("Updated engagement user property. scope, value", str2, zzlb.zze);
            } else {
                this.zzj.zzr().zzx().zza("Updated engagement user property. scope, value", str2, zzlb.zze);
            }
        }
    }

    private final boolean zza(zzbr.zzc.zza zza2, zzbr.zzc.zza zza3) {
        String str;
        Preconditions.checkArgument("_e".equals(zza2.zzd()));
        zzh();
        zzbr.zze zza4 = zzkw.zza((zzbr.zzc) ((zzfd) zza2.zzu()), "_sc");
        String str2 = null;
        if (zza4 == null) {
            str = null;
        } else {
            str = zza4.zzd();
        }
        zzh();
        zzbr.zze zza5 = zzkw.zza((zzbr.zzc) ((zzfd) zza3.zzu()), "_pc");
        if (zza5 != null) {
            str2 = zza5.zzd();
        }
        if (str2 == null || !str2.equals(str)) {
            return false;
        }
        zzb(zza2, zza3);
        return true;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.measurement.internal.zzkw.zza(com.google.android.gms.internal.measurement.zzbr$zzc$zza, java.lang.String, java.lang.Object):void
     arg types: [com.google.android.gms.internal.measurement.zzbr$zzc$zza, java.lang.String, long]
     candidates:
      com.google.android.gms.measurement.internal.zzkw.zza(boolean, boolean, boolean):java.lang.String
      com.google.android.gms.measurement.internal.zzkw.zza(java.lang.StringBuilder, int, com.google.android.gms.internal.measurement.zzbj$zzc):void
      com.google.android.gms.measurement.internal.zzkw.zza(java.lang.StringBuilder, int, java.util.List<com.google.android.gms.internal.measurement.zzbr$zze>):void
      com.google.android.gms.measurement.internal.zzkw.zza(com.google.android.gms.internal.measurement.zzbr$zzc$zza, java.lang.String, java.lang.Object):void */
    private final void zzb(zzbr.zzc.zza zza2, zzbr.zzc.zza zza3) {
        Preconditions.checkArgument("_e".equals(zza2.zzd()));
        zzh();
        zzbr.zze zza4 = zzkw.zza((zzbr.zzc) ((zzfd) zza2.zzu()), "_et");
        if (zza4.zze() && zza4.zzf() > 0) {
            long zzf2 = zza4.zzf();
            zzh();
            zzbr.zze zza5 = zzkw.zza((zzbr.zzc) ((zzfd) zza3.zzu()), "_et");
            if (zza5 != null && zza5.zzf() > 0) {
                zzf2 += zza5.zzf();
            }
            zzh().zza(zza3, "_et", Long.valueOf(zzf2));
            zzh().zza(zza2, "_fr", (Object) 1L);
        }
    }

    private static void zza(zzbr.zzc.zza zza2, String str) {
        List<zzbr.zze> zza3 = zza2.zza();
        for (int i = 0; i < zza3.size(); i++) {
            if (str.equals(zza3.get(i).zzb())) {
                zza2.zzb(i);
                return;
            }
        }
    }

    private static void zza(zzbr.zzc.zza zza2, int i, String str) {
        List<zzbr.zze> zza3 = zza2.zza();
        int i2 = 0;
        while (i2 < zza3.size()) {
            if (!"_err".equals(zza3.get(i2).zzb())) {
                i2++;
            } else {
                return;
            }
        }
        zza2.zza((zzbr.zze) ((zzfd) zzbr.zze.zzk().zza("_err").zza(Long.valueOf((long) i).longValue()).zzu())).zza((zzbr.zze) ((zzfd) zzbr.zze.zzk().zza("_ev").zzb(str).zzu()));
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public final void zza(int i, Throwable th, byte[] bArr, String str) {
        zzac zze2;
        zzw();
        zzk();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.zzr = false;
                zzaa();
                throw th2;
            }
        }
        List<Long> list = this.zzv;
        this.zzv = null;
        boolean z = true;
        if ((i == 200 || i == 204) && th == null) {
            try {
                this.zzj.zzc().zzc.zza(this.zzj.zzm().currentTimeMillis());
                this.zzj.zzc().zzd.zza(0);
                zzz();
                this.zzj.zzr().zzx().zza("Successful upload. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                zze().zzf();
                try {
                    for (Long next : list) {
                        try {
                            zze2 = zze();
                            long longValue = next.longValue();
                            zze2.zzd();
                            zze2.zzak();
                            if (zze2.c_().delete("queue", "rowid=?", new String[]{String.valueOf(longValue)}) != 1) {
                                throw new SQLiteException("Deleted fewer rows from queue than expected");
                            }
                        } catch (SQLiteException e) {
                            zze2.zzr().zzf().zza("Failed to delete a bundle in a queue table", e);
                            throw e;
                        } catch (SQLiteException e2) {
                            if (this.zzw == null || !this.zzw.contains(next)) {
                                throw e2;
                            }
                        }
                    }
                    zze().b_();
                    zze().zzh();
                    this.zzw = null;
                    if (!zzd().zzf() || !zzy()) {
                        this.zzx = -1;
                        zzz();
                    } else {
                        zzl();
                    }
                    this.zzm = 0;
                } catch (Throwable th3) {
                    zze().zzh();
                    throw th3;
                }
            } catch (SQLiteException e3) {
                this.zzj.zzr().zzf().zza("Database error while trying to delete uploaded bundles", e3);
                this.zzm = this.zzj.zzm().elapsedRealtime();
                this.zzj.zzr().zzx().zza("Disable upload, time", Long.valueOf(this.zzm));
            }
        } else {
            this.zzj.zzr().zzx().zza("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
            this.zzj.zzc().zzd.zza(this.zzj.zzm().currentTimeMillis());
            if (i != 503) {
                if (i != 429) {
                    z = false;
                }
            }
            if (z) {
                this.zzj.zzc().zze.zza(this.zzj.zzm().currentTimeMillis());
            }
            zze().zza(list);
            zzz();
        }
        this.zzr = false;
        zzaa();
    }

    private final boolean zzy() {
        zzw();
        zzk();
        return zze().zzy() || !TextUtils.isEmpty(zze().d_());
    }

    private final void zza(zzg zzg2) {
        ArrayMap arrayMap;
        zzw();
        if (!zzll.zzb() || !this.zzj.zzb().zze(zzg2.zzc(), zzap.zzch)) {
            if (TextUtils.isEmpty(zzg2.zze()) && TextUtils.isEmpty(zzg2.zzf())) {
                zza(zzg2.zzc(), 204, null, null, null);
                return;
            }
        } else if (TextUtils.isEmpty(zzg2.zze()) && TextUtils.isEmpty(zzg2.zzg()) && TextUtils.isEmpty(zzg2.zzf())) {
            zza(zzg2.zzc(), 204, null, null, null);
            return;
        }
        String zza2 = this.zzj.zzb().zza(zzg2);
        try {
            URL url = new URL(zza2);
            this.zzj.zzr().zzx().zza("Fetching remote configuration", zzg2.zzc());
            zzbo.zzb zza3 = zzc().zza(zzg2.zzc());
            String zzb2 = zzc().zzb(zzg2.zzc());
            if (zza3 == null || TextUtils.isEmpty(zzb2)) {
                arrayMap = null;
            } else {
                ArrayMap arrayMap2 = new ArrayMap();
                arrayMap2.put("If-Modified-Since", zzb2);
                arrayMap = arrayMap2;
            }
            this.zzq = true;
            zzfo zzd2 = zzd();
            String zzc2 = zzg2.zzc();
            zzkt zzkt = new zzkt(this);
            zzd2.zzd();
            zzd2.zzak();
            Preconditions.checkNotNull(url);
            Preconditions.checkNotNull(zzkt);
            zzd2.zzq().zzb(new zzfs(zzd2, zzc2, url, null, arrayMap, zzkt));
        } catch (MalformedURLException unused) {
            this.zzj.zzr().zzf().zza("Failed to parse config URL. Not fetching. appId", zzfk.zza(zzg2.zzc()), zza2);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x013a A[Catch:{ all -> 0x018d, all -> 0x0196 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x014a A[Catch:{ all -> 0x018d, all -> 0x0196 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.lang.String r7, int r8, java.lang.Throwable r9, byte[] r10, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r11) {
        /*
            r6 = this;
            r6.zzw()
            r6.zzk()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r7)
            r0 = 0
            if (r10 != 0) goto L_0x000e
            byte[] r10 = new byte[r0]     // Catch:{ all -> 0x0196 }
        L_0x000e:
            com.google.android.gms.measurement.internal.zzgo r1 = r6.zzj     // Catch:{ all -> 0x0196 }
            com.google.android.gms.measurement.internal.zzfk r1 = r1.zzr()     // Catch:{ all -> 0x0196 }
            com.google.android.gms.measurement.internal.zzfm r1 = r1.zzx()     // Catch:{ all -> 0x0196 }
            java.lang.String r2 = "onConfigFetched. Response size"
            int r3 = r10.length     // Catch:{ all -> 0x0196 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0196 }
            r1.zza(r2, r3)     // Catch:{ all -> 0x0196 }
            com.google.android.gms.measurement.internal.zzac r1 = r6.zze()     // Catch:{ all -> 0x0196 }
            r1.zzf()     // Catch:{ all -> 0x0196 }
            com.google.android.gms.measurement.internal.zzac r1 = r6.zze()     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzg r1 = r1.zzb(r7)     // Catch:{ all -> 0x018d }
            r2 = 200(0xc8, float:2.8E-43)
            r3 = 304(0x130, float:4.26E-43)
            r4 = 1
            if (r8 == r2) goto L_0x003e
            r2 = 204(0xcc, float:2.86E-43)
            if (r8 == r2) goto L_0x003e
            if (r8 != r3) goto L_0x0042
        L_0x003e:
            if (r9 != 0) goto L_0x0042
            r2 = r4
            goto L_0x0043
        L_0x0042:
            r2 = r0
        L_0x0043:
            if (r1 != 0) goto L_0x005a
            com.google.android.gms.measurement.internal.zzgo r8 = r6.zzj     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzfk r8 = r8.zzr()     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzfm r8 = r8.zzi()     // Catch:{ all -> 0x018d }
            java.lang.String r9 = "App does not exist in onConfigFetched. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzfk.zza(r7)     // Catch:{ all -> 0x018d }
            r8.zza(r9, r7)     // Catch:{ all -> 0x018d }
            goto L_0x0179
        L_0x005a:
            r5 = 404(0x194, float:5.66E-43)
            if (r2 != 0) goto L_0x00ca
            if (r8 != r5) goto L_0x0061
            goto L_0x00ca
        L_0x0061:
            com.google.android.gms.measurement.internal.zzgo r10 = r6.zzj     // Catch:{ all -> 0x018d }
            com.google.android.gms.common.util.Clock r10 = r10.zzm()     // Catch:{ all -> 0x018d }
            long r10 = r10.currentTimeMillis()     // Catch:{ all -> 0x018d }
            r1.zzi(r10)     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzac r10 = r6.zze()     // Catch:{ all -> 0x018d }
            r10.zza(r1)     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzgo r10 = r6.zzj     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzfk r10 = r10.zzr()     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzfm r10 = r10.zzx()     // Catch:{ all -> 0x018d }
            java.lang.String r11 = "Fetching config failed. code, error"
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x018d }
            r10.zza(r11, r1, r9)     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzgi r9 = r6.zzc()     // Catch:{ all -> 0x018d }
            r9.zzc(r7)     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzgo r7 = r6.zzj     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzft r7 = r7.zzc()     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzfy r7 = r7.zzd     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzgo r9 = r6.zzj     // Catch:{ all -> 0x018d }
            com.google.android.gms.common.util.Clock r9 = r9.zzm()     // Catch:{ all -> 0x018d }
            long r9 = r9.currentTimeMillis()     // Catch:{ all -> 0x018d }
            r7.zza(r9)     // Catch:{ all -> 0x018d }
            r7 = 503(0x1f7, float:7.05E-43)
            if (r8 == r7) goto L_0x00ae
            r7 = 429(0x1ad, float:6.01E-43)
            if (r8 != r7) goto L_0x00ad
            goto L_0x00ae
        L_0x00ad:
            r4 = r0
        L_0x00ae:
            if (r4 == 0) goto L_0x00c5
            com.google.android.gms.measurement.internal.zzgo r7 = r6.zzj     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzft r7 = r7.zzc()     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzfy r7 = r7.zze     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzgo r8 = r6.zzj     // Catch:{ all -> 0x018d }
            com.google.android.gms.common.util.Clock r8 = r8.zzm()     // Catch:{ all -> 0x018d }
            long r8 = r8.currentTimeMillis()     // Catch:{ all -> 0x018d }
            r7.zza(r8)     // Catch:{ all -> 0x018d }
        L_0x00c5:
            r6.zzz()     // Catch:{ all -> 0x018d }
            goto L_0x0179
        L_0x00ca:
            r9 = 0
            if (r11 == 0) goto L_0x00d6
            java.lang.String r2 = "Last-Modified"
            java.lang.Object r11 = r11.get(r2)     // Catch:{ all -> 0x018d }
            java.util.List r11 = (java.util.List) r11     // Catch:{ all -> 0x018d }
            goto L_0x00d7
        L_0x00d6:
            r11 = r9
        L_0x00d7:
            if (r11 == 0) goto L_0x00e6
            int r2 = r11.size()     // Catch:{ all -> 0x018d }
            if (r2 <= 0) goto L_0x00e6
            java.lang.Object r11 = r11.get(r0)     // Catch:{ all -> 0x018d }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x018d }
            goto L_0x00e7
        L_0x00e6:
            r11 = r9
        L_0x00e7:
            if (r8 == r5) goto L_0x0103
            if (r8 != r3) goto L_0x00ec
            goto L_0x0103
        L_0x00ec:
            com.google.android.gms.measurement.internal.zzgi r9 = r6.zzc()     // Catch:{ all -> 0x018d }
            boolean r9 = r9.zza(r7, r10, r11)     // Catch:{ all -> 0x018d }
            if (r9 != 0) goto L_0x0124
            com.google.android.gms.measurement.internal.zzac r7 = r6.zze()     // Catch:{ all -> 0x0196 }
            r7.zzh()     // Catch:{ all -> 0x0196 }
            r6.zzq = r0
            r6.zzaa()
            return
        L_0x0103:
            com.google.android.gms.measurement.internal.zzgi r11 = r6.zzc()     // Catch:{ all -> 0x018d }
            com.google.android.gms.internal.measurement.zzbo$zzb r11 = r11.zza(r7)     // Catch:{ all -> 0x018d }
            if (r11 != 0) goto L_0x0124
            com.google.android.gms.measurement.internal.zzgi r11 = r6.zzc()     // Catch:{ all -> 0x018d }
            boolean r9 = r11.zza(r7, r9, r9)     // Catch:{ all -> 0x018d }
            if (r9 != 0) goto L_0x0124
            com.google.android.gms.measurement.internal.zzac r7 = r6.zze()     // Catch:{ all -> 0x0196 }
            r7.zzh()     // Catch:{ all -> 0x0196 }
            r6.zzq = r0
            r6.zzaa()
            return
        L_0x0124:
            com.google.android.gms.measurement.internal.zzgo r9 = r6.zzj     // Catch:{ all -> 0x018d }
            com.google.android.gms.common.util.Clock r9 = r9.zzm()     // Catch:{ all -> 0x018d }
            long r2 = r9.currentTimeMillis()     // Catch:{ all -> 0x018d }
            r1.zzh(r2)     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzac r9 = r6.zze()     // Catch:{ all -> 0x018d }
            r9.zza(r1)     // Catch:{ all -> 0x018d }
            if (r8 != r5) goto L_0x014a
            com.google.android.gms.measurement.internal.zzgo r8 = r6.zzj     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzfk r8 = r8.zzr()     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzfm r8 = r8.zzk()     // Catch:{ all -> 0x018d }
            java.lang.String r9 = "Config not found. Using empty config. appId"
            r8.zza(r9, r7)     // Catch:{ all -> 0x018d }
            goto L_0x0162
        L_0x014a:
            com.google.android.gms.measurement.internal.zzgo r7 = r6.zzj     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzfk r7 = r7.zzr()     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzfm r7 = r7.zzx()     // Catch:{ all -> 0x018d }
            java.lang.String r9 = "Successfully fetched config. Got network response. code, size"
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x018d }
            int r10 = r10.length     // Catch:{ all -> 0x018d }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x018d }
            r7.zza(r9, r8, r10)     // Catch:{ all -> 0x018d }
        L_0x0162:
            com.google.android.gms.measurement.internal.zzfo r7 = r6.zzd()     // Catch:{ all -> 0x018d }
            boolean r7 = r7.zzf()     // Catch:{ all -> 0x018d }
            if (r7 == 0) goto L_0x0176
            boolean r7 = r6.zzy()     // Catch:{ all -> 0x018d }
            if (r7 == 0) goto L_0x0176
            r6.zzl()     // Catch:{ all -> 0x018d }
            goto L_0x0179
        L_0x0176:
            r6.zzz()     // Catch:{ all -> 0x018d }
        L_0x0179:
            com.google.android.gms.measurement.internal.zzac r7 = r6.zze()     // Catch:{ all -> 0x018d }
            r7.b_()     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzac r7 = r6.zze()     // Catch:{ all -> 0x0196 }
            r7.zzh()     // Catch:{ all -> 0x0196 }
            r6.zzq = r0
            r6.zzaa()
            return
        L_0x018d:
            r7 = move-exception
            com.google.android.gms.measurement.internal.zzac r8 = r6.zze()     // Catch:{ all -> 0x0196 }
            r8.zzh()     // Catch:{ all -> 0x0196 }
            throw r7     // Catch:{ all -> 0x0196 }
        L_0x0196:
            r7 = move-exception
            r6.zzq = r0
            r6.zzaa()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzks.zza(java.lang.String, int, java.lang.Throwable, byte[], java.util.Map):void");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(long, long):long}
     arg types: [int, long]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(float, float):float}
      ClspMth{java.lang.Math.max(long, long):long} */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x018b  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x01a9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzz() {
        /*
            r21 = this;
            r0 = r21
            r21.zzw()
            r21.zzk()
            long r1 = r0.zzm
            r3 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 <= 0) goto L_0x004d
            com.google.android.gms.measurement.internal.zzgo r1 = r0.zzj
            com.google.android.gms.common.util.Clock r1 = r1.zzm()
            long r1 = r1.elapsedRealtime()
            r5 = 3600000(0x36ee80, double:1.7786363E-317)
            long r7 = r0.zzm
            long r1 = r1 - r7
            long r1 = java.lang.Math.abs(r1)
            long r5 = r5 - r1
            int r1 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r1 <= 0) goto L_0x004b
            com.google.android.gms.measurement.internal.zzgo r1 = r0.zzj
            com.google.android.gms.measurement.internal.zzfk r1 = r1.zzr()
            com.google.android.gms.measurement.internal.zzfm r1 = r1.zzx()
            java.lang.Long r2 = java.lang.Long.valueOf(r5)
            java.lang.String r3 = "Upload has been suspended. Will update scheduling later in approximately ms"
            r1.zza(r3, r2)
            com.google.android.gms.measurement.internal.zzfr r1 = r21.zzt()
            r1.zzb()
            com.google.android.gms.measurement.internal.zzko r1 = r21.zzv()
            r1.zzf()
            return
        L_0x004b:
            r0.zzm = r3
        L_0x004d:
            com.google.android.gms.measurement.internal.zzgo r1 = r0.zzj
            boolean r1 = r1.zzah()
            if (r1 == 0) goto L_0x0254
            boolean r1 = r21.zzy()
            if (r1 != 0) goto L_0x005d
            goto L_0x0254
        L_0x005d:
            com.google.android.gms.measurement.internal.zzgo r1 = r0.zzj
            com.google.android.gms.common.util.Clock r1 = r1.zzm()
            long r1 = r1.currentTimeMillis()
            com.google.android.gms.measurement.internal.zzez<java.lang.Long> r5 = com.google.android.gms.measurement.internal.zzap.zzz
            r6 = 0
            java.lang.Object r5 = r5.zza(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r7 = r5.longValue()
            long r7 = java.lang.Math.max(r3, r7)
            com.google.android.gms.measurement.internal.zzac r5 = r21.zze()
            boolean r5 = r5.zzz()
            if (r5 != 0) goto L_0x008f
            com.google.android.gms.measurement.internal.zzac r5 = r21.zze()
            boolean r5 = r5.zzk()
            if (r5 == 0) goto L_0x008d
            goto L_0x008f
        L_0x008d:
            r5 = 0
            goto L_0x0090
        L_0x008f:
            r5 = 1
        L_0x0090:
            if (r5 == 0) goto L_0x00cc
            com.google.android.gms.measurement.internal.zzgo r10 = r0.zzj
            com.google.android.gms.measurement.internal.zzx r10 = r10.zzb()
            java.lang.String r10 = r10.zzv()
            boolean r11 = android.text.TextUtils.isEmpty(r10)
            if (r11 != 0) goto L_0x00bb
            java.lang.String r11 = ".none."
            boolean r10 = r11.equals(r10)
            if (r10 != 0) goto L_0x00bb
            com.google.android.gms.measurement.internal.zzez<java.lang.Long> r10 = com.google.android.gms.measurement.internal.zzap.zzu
            java.lang.Object r10 = r10.zza(r6)
            java.lang.Long r10 = (java.lang.Long) r10
            long r10 = r10.longValue()
            long r10 = java.lang.Math.max(r3, r10)
            goto L_0x00dc
        L_0x00bb:
            com.google.android.gms.measurement.internal.zzez<java.lang.Long> r10 = com.google.android.gms.measurement.internal.zzap.zzt
            java.lang.Object r10 = r10.zza(r6)
            java.lang.Long r10 = (java.lang.Long) r10
            long r10 = r10.longValue()
            long r10 = java.lang.Math.max(r3, r10)
            goto L_0x00dc
        L_0x00cc:
            com.google.android.gms.measurement.internal.zzez<java.lang.Long> r10 = com.google.android.gms.measurement.internal.zzap.zzs
            java.lang.Object r10 = r10.zza(r6)
            java.lang.Long r10 = (java.lang.Long) r10
            long r10 = r10.longValue()
            long r10 = java.lang.Math.max(r3, r10)
        L_0x00dc:
            com.google.android.gms.measurement.internal.zzgo r12 = r0.zzj
            com.google.android.gms.measurement.internal.zzft r12 = r12.zzc()
            com.google.android.gms.measurement.internal.zzfy r12 = r12.zzc
            long r12 = r12.zza()
            com.google.android.gms.measurement.internal.zzgo r14 = r0.zzj
            com.google.android.gms.measurement.internal.zzft r14 = r14.zzc()
            com.google.android.gms.measurement.internal.zzfy r14 = r14.zzd
            long r14 = r14.zza()
            com.google.android.gms.measurement.internal.zzac r16 = r21.zze()
            r17 = r10
            long r9 = r16.zzw()
            com.google.android.gms.measurement.internal.zzac r11 = r21.zze()
            r19 = r7
            long r6 = r11.zzx()
            long r6 = java.lang.Math.max(r9, r6)
            int r8 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r8 != 0) goto L_0x0113
        L_0x0110:
            r10 = r3
            goto L_0x0187
        L_0x0113:
            long r6 = r6 - r1
            long r6 = java.lang.Math.abs(r6)
            long r6 = r1 - r6
            long r12 = r12 - r1
            long r8 = java.lang.Math.abs(r12)
            long r8 = r1 - r8
            long r14 = r14 - r1
            long r10 = java.lang.Math.abs(r14)
            long r1 = r1 - r10
            long r8 = java.lang.Math.max(r8, r1)
            long r10 = r6 + r19
            if (r5 == 0) goto L_0x0139
            int r5 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x0139
            long r10 = java.lang.Math.min(r6, r8)
            long r10 = r10 + r17
        L_0x0139:
            com.google.android.gms.measurement.internal.zzkw r5 = r21.zzh()
            r12 = r17
            boolean r5 = r5.zza(r8, r12)
            if (r5 != 0) goto L_0x0147
            long r10 = r8 + r12
        L_0x0147:
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x0187
            int r5 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r5 < 0) goto L_0x0187
            r5 = 0
        L_0x0150:
            r6 = 20
            com.google.android.gms.measurement.internal.zzez<java.lang.Integer> r7 = com.google.android.gms.measurement.internal.zzap.zzab
            r8 = 0
            java.lang.Object r7 = r7.zza(r8)
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            r9 = 0
            int r7 = java.lang.Math.max(r9, r7)
            int r6 = java.lang.Math.min(r6, r7)
            if (r5 >= r6) goto L_0x0110
            r6 = 1
            long r6 = r6 << r5
            com.google.android.gms.measurement.internal.zzez<java.lang.Long> r12 = com.google.android.gms.measurement.internal.zzap.zzaa
            java.lang.Object r12 = r12.zza(r8)
            java.lang.Long r12 = (java.lang.Long) r12
            long r12 = r12.longValue()
            long r12 = java.lang.Math.max(r3, r12)
            long r12 = r12 * r6
            long r10 = r10 + r12
            int r6 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r6 <= 0) goto L_0x0184
            goto L_0x0187
        L_0x0184:
            int r5 = r5 + 1
            goto L_0x0150
        L_0x0187:
            int r1 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r1 != 0) goto L_0x01a9
            com.google.android.gms.measurement.internal.zzgo r1 = r0.zzj
            com.google.android.gms.measurement.internal.zzfk r1 = r1.zzr()
            com.google.android.gms.measurement.internal.zzfm r1 = r1.zzx()
            java.lang.String r2 = "Next upload time is 0"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.zzfr r1 = r21.zzt()
            r1.zzb()
            com.google.android.gms.measurement.internal.zzko r1 = r21.zzv()
            r1.zzf()
            return
        L_0x01a9:
            com.google.android.gms.measurement.internal.zzfo r1 = r21.zzd()
            boolean r1 = r1.zzf()
            if (r1 != 0) goto L_0x01d1
            com.google.android.gms.measurement.internal.zzgo r1 = r0.zzj
            com.google.android.gms.measurement.internal.zzfk r1 = r1.zzr()
            com.google.android.gms.measurement.internal.zzfm r1 = r1.zzx()
            java.lang.String r2 = "No network"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.zzfr r1 = r21.zzt()
            r1.zza()
            com.google.android.gms.measurement.internal.zzko r1 = r21.zzv()
            r1.zzf()
            return
        L_0x01d1:
            com.google.android.gms.measurement.internal.zzgo r1 = r0.zzj
            com.google.android.gms.measurement.internal.zzft r1 = r1.zzc()
            com.google.android.gms.measurement.internal.zzfy r1 = r1.zze
            long r1 = r1.zza()
            com.google.android.gms.measurement.internal.zzez<java.lang.Long> r5 = com.google.android.gms.measurement.internal.zzap.zzq
            r6 = 0
            java.lang.Object r5 = r5.zza(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r5 = r5.longValue()
            long r5 = java.lang.Math.max(r3, r5)
            com.google.android.gms.measurement.internal.zzkw r7 = r21.zzh()
            boolean r7 = r7.zza(r1, r5)
            if (r7 != 0) goto L_0x01fd
            long r1 = r1 + r5
            long r10 = java.lang.Math.max(r10, r1)
        L_0x01fd:
            com.google.android.gms.measurement.internal.zzfr r1 = r21.zzt()
            r1.zzb()
            com.google.android.gms.measurement.internal.zzgo r1 = r0.zzj
            com.google.android.gms.common.util.Clock r1 = r1.zzm()
            long r1 = r1.currentTimeMillis()
            long r10 = r10 - r1
            int r1 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r1 > 0) goto L_0x0239
            com.google.android.gms.measurement.internal.zzez<java.lang.Long> r1 = com.google.android.gms.measurement.internal.zzap.zzv
            r2 = 0
            java.lang.Object r1 = r1.zza(r2)
            java.lang.Long r1 = (java.lang.Long) r1
            long r1 = r1.longValue()
            long r10 = java.lang.Math.max(r3, r1)
            com.google.android.gms.measurement.internal.zzgo r1 = r0.zzj
            com.google.android.gms.measurement.internal.zzft r1 = r1.zzc()
            com.google.android.gms.measurement.internal.zzfy r1 = r1.zzc
            com.google.android.gms.measurement.internal.zzgo r2 = r0.zzj
            com.google.android.gms.common.util.Clock r2 = r2.zzm()
            long r2 = r2.currentTimeMillis()
            r1.zza(r2)
        L_0x0239:
            com.google.android.gms.measurement.internal.zzgo r1 = r0.zzj
            com.google.android.gms.measurement.internal.zzfk r1 = r1.zzr()
            com.google.android.gms.measurement.internal.zzfm r1 = r1.zzx()
            java.lang.Long r2 = java.lang.Long.valueOf(r10)
            java.lang.String r3 = "Upload scheduled in approximately ms"
            r1.zza(r3, r2)
            com.google.android.gms.measurement.internal.zzko r1 = r21.zzv()
            r1.zza(r10)
            return
        L_0x0254:
            com.google.android.gms.measurement.internal.zzgo r1 = r0.zzj
            com.google.android.gms.measurement.internal.zzfk r1 = r1.zzr()
            com.google.android.gms.measurement.internal.zzfm r1 = r1.zzx()
            java.lang.String r2 = "Nothing to upload or uploading impossible"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.zzfr r1 = r21.zzt()
            r1.zzb()
            com.google.android.gms.measurement.internal.zzko r1 = r21.zzv()
            r1.zzf()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzks.zzz():void");
    }

    /* access modifiers changed from: package-private */
    public final void zza(Runnable runnable) {
        zzw();
        if (this.zzn == null) {
            this.zzn = new ArrayList();
        }
        this.zzn.add(runnable);
    }

    private final void zzaa() {
        zzw();
        if (this.zzq || this.zzr || this.zzs) {
            this.zzj.zzr().zzx().zza("Not stopping services. fetch, network, upload", Boolean.valueOf(this.zzq), Boolean.valueOf(this.zzr), Boolean.valueOf(this.zzs));
            return;
        }
        this.zzj.zzr().zzx().zza("Stopping uploading service(s)");
        List<Runnable> list = this.zzn;
        if (list != null) {
            for (Runnable run : list) {
                run.run();
            }
            this.zzn.clear();
        }
    }

    private final Boolean zzb(zzg zzg2) {
        try {
            if (zzg2.zzm() != -2147483648L) {
                if (zzg2.zzm() == ((long) Wrappers.packageManager(this.zzj.zzn()).getPackageInfo(zzg2.zzc(), 0).versionCode)) {
                    return true;
                }
            } else {
                String str = Wrappers.packageManager(this.zzj.zzn()).getPackageInfo(zzg2.zzc(), 0).versionName;
                if (zzg2.zzl() != null && zzg2.zzl().equals(str)) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzo() {
        zzw();
        zzk();
        if (!this.zzl) {
            this.zzl = true;
            if (zzab()) {
                int zza2 = zza(this.zzu);
                int zzaf = this.zzj.zzy().zzaf();
                zzw();
                if (zza2 > zzaf) {
                    this.zzj.zzr().zzf().zza("Panic: can't downgrade version. Previous, current version", Integer.valueOf(zza2), Integer.valueOf(zzaf));
                } else if (zza2 >= zzaf) {
                } else {
                    if (zza(zzaf, this.zzu)) {
                        this.zzj.zzr().zzx().zza("Storage version upgraded. Previous, current version", Integer.valueOf(zza2), Integer.valueOf(zzaf));
                    } else {
                        this.zzj.zzr().zzf().zza("Storage version upgrade failed. Previous, current version", Integer.valueOf(zza2), Integer.valueOf(zzaf));
                    }
                }
            }
        }
    }

    private final boolean zzab() {
        FileLock fileLock;
        zzw();
        if (!this.zzj.zzb().zza(zzap.zzcf) || (fileLock = this.zzt) == null || !fileLock.isValid()) {
            try {
                FileChannel channel = new RandomAccessFile(new File(this.zzj.zzn().getFilesDir(), "google_app_measurement.db"), "rw").getChannel();
                this.zzu = channel;
                FileLock tryLock = channel.tryLock();
                this.zzt = tryLock;
                if (tryLock != null) {
                    this.zzj.zzr().zzx().zza("Storage concurrent access okay");
                    return true;
                }
                this.zzj.zzr().zzf().zza("Storage concurrent data access panic");
                return false;
            } catch (FileNotFoundException e) {
                this.zzj.zzr().zzf().zza("Failed to acquire storage lock", e);
                return false;
            } catch (IOException e2) {
                this.zzj.zzr().zzf().zza("Failed to access storage lock file", e2);
                return false;
            } catch (OverlappingFileLockException e3) {
                this.zzj.zzr().zzi().zza("Storage lock already acquired", e3);
                return false;
            }
        } else {
            this.zzj.zzr().zzx().zza("Storage concurrent access okay");
            return true;
        }
    }

    private final int zza(FileChannel fileChannel) {
        zzw();
        if (fileChannel == null || !fileChannel.isOpen()) {
            this.zzj.zzr().zzf().zza("Bad channel to read from");
            return 0;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        try {
            fileChannel.position(0L);
            int read = fileChannel.read(allocate);
            if (read != 4) {
                if (read != -1) {
                    this.zzj.zzr().zzi().zza("Unexpected data length. Bytes read", Integer.valueOf(read));
                }
                return 0;
            }
            allocate.flip();
            return allocate.getInt();
        } catch (IOException e) {
            this.zzj.zzr().zzf().zza("Failed to read from channel", e);
            return 0;
        }
    }

    private final boolean zza(int i, FileChannel fileChannel) {
        zzw();
        if (fileChannel == null || !fileChannel.isOpen()) {
            this.zzj.zzr().zzf().zza("Bad channel to read from");
            return false;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(i);
        allocate.flip();
        try {
            fileChannel.truncate(0L);
            if (this.zzj.zzb().zza(zzap.zzcu) && Build.VERSION.SDK_INT <= 19) {
                fileChannel.position(0L);
            }
            fileChannel.write(allocate);
            fileChannel.force(true);
            if (fileChannel.size() != 4) {
                this.zzj.zzr().zzf().zza("Error writing to channel. Bytes written", Long.valueOf(fileChannel.size()));
            }
            return true;
        } catch (IOException e) {
            this.zzj.zzr().zzf().zza("Failed to write to channel", e);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzm zzm2) {
        if (this.zzv != null) {
            ArrayList arrayList = new ArrayList();
            this.zzw = arrayList;
            arrayList.addAll(this.zzv);
        }
        zzac zze2 = zze();
        String str = zzm2.zza;
        Preconditions.checkNotEmpty(str);
        zze2.zzd();
        zze2.zzak();
        try {
            SQLiteDatabase c_ = zze2.c_();
            String[] strArr = {str};
            int delete = c_.delete("apps", "app_id=?", strArr) + 0 + c_.delete("events", "app_id=?", strArr) + c_.delete("user_attributes", "app_id=?", strArr) + c_.delete("conditional_properties", "app_id=?", strArr) + c_.delete("raw_events", "app_id=?", strArr) + c_.delete("raw_events_metadata", "app_id=?", strArr) + c_.delete("queue", "app_id=?", strArr) + c_.delete("audience_filter_values", "app_id=?", strArr) + c_.delete("main_event_params", "app_id=?", strArr);
            if (delete > 0) {
                zze2.zzr().zzx().zza("Reset analytics data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zze2.zzr().zzf().zza("Error resetting analytics data. appId, error", zzfk.zza(str), e);
        }
        if (!zzkn.zzb() || !this.zzj.zzb().zza(zzap.zzcm)) {
            zzm zza2 = zza(this.zzj.zzn(), zzm2.zza, zzm2.zzb, zzm2.zzh, zzm2.zzo, zzm2.zzp, zzm2.zzm, zzm2.zzr, zzm2.zzv);
            if (zzm2.zzh) {
                zzb(zza2);
            }
        } else if (zzm2.zzh) {
            zzb(zzm2);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.measurement.internal.zzm.<init>(java.lang.String, java.lang.String, java.lang.String, long, java.lang.String, long, long, java.lang.String, boolean, boolean, java.lang.String, long, long, int, boolean, boolean, boolean, java.lang.String, java.lang.Boolean, long, java.util.List<java.lang.String>, java.lang.String):void
     arg types: [java.lang.String, java.lang.String, java.lang.String, long, java.lang.String, long, long, ?[OBJECT, ARRAY], boolean, int, java.lang.String, int, long, int, boolean, boolean, int, java.lang.String, ?[OBJECT, ARRAY], int, ?[OBJECT, ARRAY], java.lang.String]
     candidates:
      com.google.android.gms.measurement.internal.zzm.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, long, long, java.lang.String, boolean, boolean, long, java.lang.String, long, long, int, boolean, boolean, boolean, java.lang.String, java.lang.Boolean, long, java.util.List<java.lang.String>, java.lang.String):void
      com.google.android.gms.measurement.internal.zzm.<init>(java.lang.String, java.lang.String, java.lang.String, long, java.lang.String, long, long, java.lang.String, boolean, boolean, java.lang.String, long, long, int, boolean, boolean, boolean, java.lang.String, java.lang.Boolean, long, java.util.List<java.lang.String>, java.lang.String):void */
    private final zzm zza(Context context, String str, String str2, boolean z, boolean z2, boolean z3, long j, String str3, String str4) {
        String str5;
        String str6;
        int i;
        String str7 = str;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            this.zzj.zzr().zzf().zza("PackageManager is null, can not log app install information");
            return null;
        }
        try {
            str5 = packageManager.getInstallerPackageName(str7);
        } catch (IllegalArgumentException unused) {
            this.zzj.zzr().zzf().zza("Error retrieving installer package name. appId", zzfk.zza(str));
            str5 = "Unknown";
        }
        if (str5 == null) {
            str5 = "manual_install";
        } else if ("com.android.vending".equals(str5)) {
            str5 = "";
        }
        String str8 = str5;
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(str7, 0);
            if (packageInfo != null) {
                CharSequence applicationLabel = Wrappers.packageManager(context).getApplicationLabel(str7);
                if (!TextUtils.isEmpty(applicationLabel)) {
                    String charSequence = applicationLabel.toString();
                }
                str6 = packageInfo.versionName;
                i = packageInfo.versionCode;
            } else {
                str6 = "Unknown";
                i = Integer.MIN_VALUE;
            }
            return new zzm(str, str2, str6, (long) i, str8, this.zzj.zzb().zze(), this.zzj.zzi().zza(context, str7), (String) null, z, false, "", 0L, j, 0, z2, z3, false, str3, (Boolean) null, 0L, (List<String>) null, (!zzll.zzb() || !this.zzj.zzb().zze(str7, zzap.zzch)) ? null : str4);
        } catch (PackageManager.NameNotFoundException unused2) {
            this.zzj.zzr().zzf().zza("Error retrieving newly installed package info. appId, appName", zzfk.zza(str), "Unknown");
            return null;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.measurement.internal.zzla.zza(java.lang.String, int, boolean):java.lang.String
     arg types: [java.lang.String, int, int]
     candidates:
      com.google.android.gms.measurement.internal.zzla.zza(android.os.Bundle, java.lang.String, java.lang.Object):void
      com.google.android.gms.measurement.internal.zzla.zza(java.lang.String, int, java.lang.String):boolean
      com.google.android.gms.measurement.internal.zzla.zza(java.lang.String, java.lang.String, java.lang.String):boolean
      com.google.android.gms.measurement.internal.zzla.zza(java.lang.String, java.lang.String[], java.lang.String):boolean
      com.google.android.gms.measurement.internal.zzla.zza(java.lang.String, int, boolean):java.lang.String */
    /* access modifiers changed from: package-private */
    public final void zza(zzkz zzkz, zzm zzm2) {
        zzaj zza2;
        zzw();
        zzk();
        if (zze(zzm2)) {
            if (!zzm2.zzh) {
                zzc(zzm2);
                return;
            }
            int zzc2 = this.zzj.zzi().zzc(zzkz.zza);
            int i = 0;
            if (zzc2 != 0) {
                this.zzj.zzi();
                this.zzj.zzi().zza(zzm2.zza, zzc2, "_ev", zzla.zza(zzkz.zza, 24, true), zzkz.zza != null ? zzkz.zza.length() : 0);
                return;
            }
            int zzb2 = this.zzj.zzi().zzb(zzkz.zza, zzkz.zza());
            if (zzb2 != 0) {
                this.zzj.zzi();
                String zza3 = zzla.zza(zzkz.zza, 24, true);
                Object zza4 = zzkz.zza();
                if (zza4 != null && ((zza4 instanceof String) || (zza4 instanceof CharSequence))) {
                    i = String.valueOf(zza4).length();
                }
                this.zzj.zzi().zza(zzm2.zza, zzb2, "_ev", zza3, i);
                return;
            }
            Object zzc3 = this.zzj.zzi().zzc(zzkz.zza, zzkz.zza());
            if (zzc3 != null) {
                if ("_sid".equals(zzkz.zza) && this.zzj.zzb().zze(zzm2.zza, zzap.zzas)) {
                    long j = zzkz.zzb;
                    String str = zzkz.zze;
                    long j2 = 0;
                    zzlb zzc4 = zze().zzc(zzm2.zza, "_sno");
                    if (zzc4 == null || !(zzc4.zze instanceof Long)) {
                        if (zzc4 != null) {
                            this.zzj.zzr().zzi().zza("Retrieved last session number from database does not contain a valid (long) value", zzc4.zze);
                        }
                        if (this.zzj.zzb().zze(zzm2.zza, zzap.zzav) && (zza2 = zze().zza(zzm2.zza, "_s")) != null) {
                            j2 = zza2.zzc;
                            this.zzj.zzr().zzx().zza("Backfill the session number. Last used session number", Long.valueOf(j2));
                        }
                    } else {
                        j2 = ((Long) zzc4.zze).longValue();
                    }
                    zza(new zzkz("_sno", j, Long.valueOf(j2 + 1), str), zzm2);
                }
                zzlb zzlb = new zzlb(zzm2.zza, zzkz.zze, zzkz.zza, zzkz.zzb, zzc3);
                if (!zzky.zzb() || !this.zzj.zzb().zze(zzm2.zza, zzap.zzcz)) {
                    this.zzj.zzr().zzw().zza("Setting user property", this.zzj.zzj().zzc(zzlb.zzc), zzc3);
                } else {
                    this.zzj.zzr().zzx().zza("Setting user property", this.zzj.zzj().zzc(zzlb.zzc), zzc3);
                }
                zze().zzf();
                try {
                    zzc(zzm2);
                    boolean zza5 = zze().zza(zzlb);
                    zze().b_();
                    if (!zza5) {
                        this.zzj.zzr().zzf().zza("Too many unique user properties are set. Ignoring user property", this.zzj.zzj().zzc(zzlb.zzc), zzlb.zze);
                        this.zzj.zzi().zza(zzm2.zza, 9, (String) null, (String) null, 0);
                    } else if (!zzky.zzb() || !this.zzj.zzb().zze(zzm2.zza, zzap.zzcz)) {
                        this.zzj.zzr().zzw().zza("User property set", this.zzj.zzj().zzc(zzlb.zzc), zzlb.zze);
                    }
                } finally {
                    zze().zzh();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzkz zzkz, zzm zzm2) {
        zzw();
        zzk();
        if (zze(zzm2)) {
            if (!zzm2.zzh) {
                zzc(zzm2);
            } else if (!this.zzj.zzb().zze(zzm2.zza, zzap.zzbc)) {
                this.zzj.zzr().zzw().zza("Removing user property", this.zzj.zzj().zzc(zzkz.zza));
                zze().zzf();
                try {
                    zzc(zzm2);
                    zze().zzb(zzm2.zza, zzkz.zza);
                    zze().b_();
                    this.zzj.zzr().zzw().zza("User property removed", this.zzj.zzj().zzc(zzkz.zza));
                } finally {
                    zze().zzh();
                }
            } else if (!"_npa".equals(zzkz.zza) || zzm2.zzs == null) {
                this.zzj.zzr().zzw().zza("Removing user property", this.zzj.zzj().zzc(zzkz.zza));
                zze().zzf();
                try {
                    zzc(zzm2);
                    zze().zzb(zzm2.zza, zzkz.zza);
                    zze().b_();
                    this.zzj.zzr().zzw().zza("User property removed", this.zzj.zzj().zzc(zzkz.zza));
                } finally {
                    zze().zzh();
                }
            } else {
                this.zzj.zzr().zzw().zza("Falling back to manifest metadata value for ad personalization");
                zza(new zzkz("_npa", this.zzj.zzm().currentTimeMillis(), Long.valueOf(zzm2.zzs.booleanValue() ? 1 : 0), DebugKt.DEBUG_PROPERTY_VALUE_AUTO), zzm2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzkp zzkp) {
        this.zzo++;
    }

    /* access modifiers changed from: package-private */
    public final void zzp() {
        this.zzp++;
    }

    /* access modifiers changed from: package-private */
    public final zzgo zzs() {
        return this.zzj;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0222 A[Catch:{ SQLiteException -> 0x01d3, all -> 0x04d4 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzb(com.google.android.gms.measurement.internal.zzm r22) {
        /*
            r21 = this;
            r1 = r21
            r2 = r22
            java.lang.String r3 = "_sysu"
            java.lang.String r4 = "_sys"
            java.lang.String r5 = "_pfo"
            java.lang.String r6 = "_uwa"
            java.lang.String r0 = "app_id=?"
            r21.zzw()
            r21.zzk()
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r22)
            java.lang.String r7 = r2.zza
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r7)
            boolean r7 = r21.zze(r22)
            if (r7 != 0) goto L_0x0023
            return
        L_0x0023:
            com.google.android.gms.measurement.internal.zzac r7 = r21.zze()
            java.lang.String r8 = r2.zza
            com.google.android.gms.measurement.internal.zzg r7 = r7.zzb(r8)
            r8 = 0
            if (r7 == 0) goto L_0x0056
            java.lang.String r10 = r7.zze()
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 == 0) goto L_0x0056
            java.lang.String r10 = r2.zzb
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 != 0) goto L_0x0056
            r7.zzh(r8)
            com.google.android.gms.measurement.internal.zzac r10 = r21.zze()
            r10.zza(r7)
            com.google.android.gms.measurement.internal.zzgi r7 = r21.zzc()
            java.lang.String r10 = r2.zza
            r7.zzd(r10)
        L_0x0056:
            boolean r7 = r2.zzh
            if (r7 != 0) goto L_0x005e
            r21.zzc(r22)
            return
        L_0x005e:
            long r10 = r2.zzm
            int r7 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r7 != 0) goto L_0x006e
            com.google.android.gms.measurement.internal.zzgo r7 = r1.zzj
            com.google.android.gms.common.util.Clock r7 = r7.zzm()
            long r10 = r7.currentTimeMillis()
        L_0x006e:
            com.google.android.gms.measurement.internal.zzgo r7 = r1.zzj
            com.google.android.gms.measurement.internal.zzx r7 = r7.zzb()
            java.lang.String r12 = r2.zza
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r13 = com.google.android.gms.measurement.internal.zzap.zzbc
            boolean r7 = r7.zze(r12, r13)
            if (r7 == 0) goto L_0x0087
            com.google.android.gms.measurement.internal.zzgo r7 = r1.zzj
            com.google.android.gms.measurement.internal.zzah r7 = r7.zzx()
            r7.zzi()
        L_0x0087:
            int r7 = r2.zzn
            r15 = 1
            if (r7 == 0) goto L_0x00a8
            if (r7 == r15) goto L_0x00a8
            com.google.android.gms.measurement.internal.zzgo r12 = r1.zzj
            com.google.android.gms.measurement.internal.zzfk r12 = r12.zzr()
            com.google.android.gms.measurement.internal.zzfm r12 = r12.zzi()
            java.lang.String r13 = r2.zza
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzfk.zza(r13)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            java.lang.String r14 = "Incorrect app type, assuming installed app. appId, appType"
            r12.zza(r14, r13, r7)
            r7 = 0
        L_0x00a8:
            com.google.android.gms.measurement.internal.zzac r12 = r21.zze()
            r12.zzf()
            com.google.android.gms.measurement.internal.zzgo r12 = r1.zzj     // Catch:{ all -> 0x04d4 }
            com.google.android.gms.measurement.internal.zzx r12 = r12.zzb()     // Catch:{ all -> 0x04d4 }
            java.lang.String r13 = r2.zza     // Catch:{ all -> 0x04d4 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r14 = com.google.android.gms.measurement.internal.zzap.zzbc     // Catch:{ all -> 0x04d4 }
            boolean r12 = r12.zze(r13, r14)     // Catch:{ all -> 0x04d4 }
            if (r12 == 0) goto L_0x0129
            com.google.android.gms.measurement.internal.zzac r12 = r21.zze()     // Catch:{ all -> 0x04d4 }
            java.lang.String r13 = r2.zza     // Catch:{ all -> 0x04d4 }
            java.lang.String r14 = "_npa"
            com.google.android.gms.measurement.internal.zzlb r14 = r12.zzc(r13, r14)     // Catch:{ all -> 0x04d4 }
            if (r14 == 0) goto L_0x00d7
            java.lang.String r12 = "auto"
            java.lang.String r13 = r14.zzb     // Catch:{ all -> 0x04d4 }
            boolean r12 = r12.equals(r13)     // Catch:{ all -> 0x04d4 }
            if (r12 == 0) goto L_0x0129
        L_0x00d7:
            java.lang.Boolean r12 = r2.zzs     // Catch:{ all -> 0x04d4 }
            if (r12 == 0) goto L_0x0112
            com.google.android.gms.measurement.internal.zzkz r13 = new com.google.android.gms.measurement.internal.zzkz     // Catch:{ all -> 0x04d4 }
            java.lang.String r18 = "_npa"
            java.lang.Boolean r12 = r2.zzs     // Catch:{ all -> 0x04d4 }
            boolean r12 = r12.booleanValue()     // Catch:{ all -> 0x04d4 }
            if (r12 == 0) goto L_0x00ea
            r19 = 1
            goto L_0x00ec
        L_0x00ea:
            r19 = r8
        L_0x00ec:
            java.lang.Long r19 = java.lang.Long.valueOf(r19)     // Catch:{ all -> 0x04d4 }
            java.lang.String r20 = "auto"
            r12 = r13
            r8 = r13
            r13 = r18
            r18 = r3
            r9 = r14
            r3 = r15
            r14 = r10
            r16 = r19
            r17 = r20
            r12.<init>(r13, r14, r16, r17)     // Catch:{ all -> 0x04d4 }
            if (r9 == 0) goto L_0x010e
            java.lang.Object r9 = r9.zze     // Catch:{ all -> 0x04d4 }
            java.lang.Long r12 = r8.zzc     // Catch:{ all -> 0x04d4 }
            boolean r9 = r9.equals(r12)     // Catch:{ all -> 0x04d4 }
            if (r9 != 0) goto L_0x012c
        L_0x010e:
            r1.zza(r8, r2)     // Catch:{ all -> 0x04d4 }
            goto L_0x012c
        L_0x0112:
            r18 = r3
            r9 = r14
            r3 = r15
            if (r9 == 0) goto L_0x012c
            com.google.android.gms.measurement.internal.zzkz r8 = new com.google.android.gms.measurement.internal.zzkz     // Catch:{ all -> 0x04d4 }
            java.lang.String r13 = "_npa"
            r16 = 0
            java.lang.String r17 = "auto"
            r12 = r8
            r14 = r10
            r12.<init>(r13, r14, r16, r17)     // Catch:{ all -> 0x04d4 }
            r1.zzb(r8, r2)     // Catch:{ all -> 0x04d4 }
            goto L_0x012c
        L_0x0129:
            r18 = r3
            r3 = r15
        L_0x012c:
            com.google.android.gms.measurement.internal.zzac r8 = r21.zze()     // Catch:{ all -> 0x04d4 }
            java.lang.String r9 = r2.zza     // Catch:{ all -> 0x04d4 }
            com.google.android.gms.measurement.internal.zzg r8 = r8.zzb(r9)     // Catch:{ all -> 0x04d4 }
            if (r8 == 0) goto L_0x01e6
            com.google.android.gms.measurement.internal.zzgo r12 = r1.zzj     // Catch:{ all -> 0x04d4 }
            r12.zzi()     // Catch:{ all -> 0x04d4 }
            java.lang.String r12 = r2.zzb     // Catch:{ all -> 0x04d4 }
            java.lang.String r13 = r8.zze()     // Catch:{ all -> 0x04d4 }
            java.lang.String r14 = r2.zzr     // Catch:{ all -> 0x04d4 }
            java.lang.String r15 = r8.zzf()     // Catch:{ all -> 0x04d4 }
            boolean r12 = com.google.android.gms.measurement.internal.zzla.zza(r12, r13, r14, r15)     // Catch:{ all -> 0x04d4 }
            if (r12 == 0) goto L_0x01e6
            com.google.android.gms.measurement.internal.zzgo r12 = r1.zzj     // Catch:{ all -> 0x04d4 }
            com.google.android.gms.measurement.internal.zzfk r12 = r12.zzr()     // Catch:{ all -> 0x04d4 }
            com.google.android.gms.measurement.internal.zzfm r12 = r12.zzi()     // Catch:{ all -> 0x04d4 }
            java.lang.String r13 = "New GMP App Id passed in. Removing cached database data. appId"
            java.lang.String r14 = r8.zzc()     // Catch:{ all -> 0x04d4 }
            java.lang.Object r14 = com.google.android.gms.measurement.internal.zzfk.zza(r14)     // Catch:{ all -> 0x04d4 }
            r12.zza(r13, r14)     // Catch:{ all -> 0x04d4 }
            com.google.android.gms.measurement.internal.zzac r12 = r21.zze()     // Catch:{ all -> 0x04d4 }
            java.lang.String r8 = r8.zzc()     // Catch:{ all -> 0x04d4 }
            r12.zzak()     // Catch:{ all -> 0x04d4 }
            r12.zzd()     // Catch:{ all -> 0x04d4 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r8)     // Catch:{ all -> 0x04d4 }
            android.database.sqlite.SQLiteDatabase r13 = r12.c_()     // Catch:{ SQLiteException -> 0x01d3 }
            java.lang.String[] r14 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x01d3 }
            r15 = 0
            r14[r15] = r8     // Catch:{ SQLiteException -> 0x01d3 }
            java.lang.String r9 = "events"
            int r9 = r13.delete(r9, r0, r14)     // Catch:{ SQLiteException -> 0x01d3 }
            int r9 = r9 + r15
            java.lang.String r15 = "user_attributes"
            int r15 = r13.delete(r15, r0, r14)     // Catch:{ SQLiteException -> 0x01d3 }
            int r9 = r9 + r15
            java.lang.String r15 = "conditional_properties"
            int r15 = r13.delete(r15, r0, r14)     // Catch:{ SQLiteException -> 0x01d3 }
            int r9 = r9 + r15
            java.lang.String r15 = "apps"
            int r15 = r13.delete(r15, r0, r14)     // Catch:{ SQLiteException -> 0x01d3 }
            int r9 = r9 + r15
            java.lang.String r15 = "raw_events"
            int r15 = r13.delete(r15, r0, r14)     // Catch:{ SQLiteException -> 0x01d3 }
            int r9 = r9 + r15
            java.lang.String r15 = "raw_events_metadata"
            int r15 = r13.delete(r15, r0, r14)     // Catch:{ SQLiteException -> 0x01d3 }
            int r9 = r9 + r15
            java.lang.String r15 = "event_filters"
            int r15 = r13.delete(r15, r0, r14)     // Catch:{ SQLiteException -> 0x01d3 }
            int r9 = r9 + r15
            java.lang.String r15 = "property_filters"
            int r15 = r13.delete(r15, r0, r14)     // Catch:{ SQLiteException -> 0x01d3 }
            int r9 = r9 + r15
            java.lang.String r15 = "audience_filter_values"
            int r0 = r13.delete(r15, r0, r14)     // Catch:{ SQLiteException -> 0x01d3 }
            int r9 = r9 + r0
            if (r9 <= 0) goto L_0x01e5
            com.google.android.gms.measurement.internal.zzfk r0 = r12.zzr()     // Catch:{ SQLiteException -> 0x01d3 }
            com.google.android.gms.measurement.internal.zzfm r0 = r0.zzx()     // Catch:{ SQLiteException -> 0x01d3 }
            java.lang.String r13 = "Deleted application data. app, records"
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ SQLiteException -> 0x01d3 }
            r0.zza(r13, r8, r9)     // Catch:{ SQLiteException -> 0x01d3 }
            goto L_0x01e5
        L_0x01d3:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfk r9 = r12.zzr()     // Catch:{ all -> 0x04d4 }
            com.google.android.gms.measurement.internal.zzfm r9 = r9.zzf()     // Catch:{ all -> 0x04d4 }
            java.lang.String r12 = "Error deleting application data. appId, error"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzfk.zza(r8)     // Catch:{ all -> 0x04d4 }
            r9.zza(r12, r8, r0)     // Catch:{ all -> 0x04d4 }
        L_0x01e5:
            r8 = 0
        L_0x01e6:
            if (r8 == 0) goto L_0x0245
            long r12 = r8.zzm()     // Catch:{ all -> 0x04d4 }
            r14 = -2147483648(0xffffffff80000000, double:NaN)
            int r0 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r0 == 0) goto L_0x0200
            long r12 = r8.zzm()     // Catch:{ all -> 0x04d4 }
            r9 = r4
            long r3 = r2.zzj     // Catch:{ all -> 0x04d4 }
            int r0 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r0 == 0) goto L_0x0201
            r0 = 1
            goto L_0x0202
        L_0x0200:
            r9 = r4
        L_0x0201:
            r0 = 0
        L_0x0202:
            long r3 = r8.zzm()     // Catch:{ all -> 0x04d4 }
            int r3 = (r3 > r14 ? 1 : (r3 == r14 ? 0 : -1))
            if (r3 != 0) goto L_0x021e
            java.lang.String r3 = r8.zzl()     // Catch:{ all -> 0x04d4 }
            if (r3 == 0) goto L_0x021e
            java.lang.String r3 = r8.zzl()     // Catch:{ all -> 0x04d4 }
            java.lang.String r4 = r2.zzc     // Catch:{ all -> 0x04d4 }
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x04d4 }
            if (r3 != 0) goto L_0x021e
            r14 = 1
            goto L_0x021f
        L_0x021e:
            r14 = 0
        L_0x021f:
            r0 = r0 | r14
            if (r0 == 0) goto L_0x0246
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x04d4 }
            r0.<init>()     // Catch:{ all -> 0x04d4 }
            java.lang.String r3 = "_pv"
            java.lang.String r4 = r8.zzl()     // Catch:{ all -> 0x04d4 }
            r0.putString(r3, r4)     // Catch:{ all -> 0x04d4 }
            com.google.android.gms.measurement.internal.zzan r3 = new com.google.android.gms.measurement.internal.zzan     // Catch:{ all -> 0x04d4 }
            java.lang.String r13 = "_au"
            com.google.android.gms.measurement.internal.zzam r14 = new com.google.android.gms.measurement.internal.zzam     // Catch:{ all -> 0x04d4 }
            r14.<init>(r0)     // Catch:{ all -> 0x04d4 }
            java.lang.String r15 = "auto"
            r12 = r3
            r16 = r10
            r12.<init>(r13, r14, r15, r16)     // Catch:{ all -> 0x04d4 }
            r1.zza(r3, r2)     // Catch:{ all -> 0x04d4 }
            goto L_0x0246
        L_0x0245:
            r9 = r4
        L_0x0246:
            r21.zzc(r22)     // Catch:{ all -> 0x04d4 }
            if (r7 != 0) goto L_0x0258
            com.google.android.gms.measurement.internal.zzac r0 = r21.zze()     // Catch:{ all -> 0x04d4 }
            java.lang.String r3 = r2.zza     // Catch:{ all -> 0x04d4 }
            java.lang.String r4 = "_f"
            com.google.android.gms.measurement.internal.zzaj r0 = r0.zza(r3, r4)     // Catch:{ all -> 0x04d4 }
            goto L_0x0269
        L_0x0258:
            r3 = 1
            if (r7 != r3) goto L_0x0268
            com.google.android.gms.measurement.internal.zzac r0 = r21.zze()     // Catch:{ all -> 0x04d4 }
            java.lang.String r3 = r2.zza     // Catch:{ all -> 0x04d4 }
            java.lang.String r4 = "_v"
            com.google.android.gms.measurement.internal.zzaj r0 = r0.zza(r3, r4)     // Catch:{ all -> 0x04d4 }
            goto L_0x0269
        L_0x0268:
            r0 = 0
        L_0x0269:
            if (r0 != 0) goto L_0x04a8
            r3 = 3600000(0x36ee80, double:1.7786363E-317)
            long r12 = r10 / r3
            r14 = 1
            long r12 = r12 + r14
            long r12 = r12 * r3
            java.lang.String r0 = "_dac"
            java.lang.String r3 = "_r"
            java.lang.String r4 = "_c"
            java.lang.String r8 = "_et"
            if (r7 != 0) goto L_0x0406
            com.google.android.gms.measurement.internal.zzkz r7 = new com.google.android.gms.measurement.internal.zzkz     // Catch:{ all -> 0x04d4 }
            java.lang.String r14 = "_fot"
            java.lang.Long r16 = java.lang.Long.valueOf(r12)     // Catch:{ all -> 0x04d4 }
            java.lang.String r17 = "auto"
            r12 = r7
            r13 = r14
            r14 = r10
            r12.<init>(r13, r14, r16, r17)     // Catch:{ all -> 0x04d4 }
            r1.zza(r7, r2)     // Catch:{ all -> 0x04d4 }
            com.google.android.gms.measurement.internal.zzgo r7 = r1.zzj     // Catch:{ all -> 0x04d4 }
            com.google.android.gms.measurement.internal.zzx r7 = r7.zzb()     // Catch:{ all -> 0x04d4 }
            java.lang.String r12 = r2.zzb     // Catch:{ all -> 0x04d4 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r13 = com.google.android.gms.measurement.internal.zzap.zzaq     // Catch:{ all -> 0x04d4 }
            boolean r7 = r7.zze(r12, r13)     // Catch:{ all -> 0x04d4 }
            if (r7 == 0) goto L_0x02af
            r21.zzw()     // Catch:{ all -> 0x04d4 }
            com.google.android.gms.measurement.internal.zzgo r7 = r1.zzj     // Catch:{ all -> 0x04d4 }
            com.google.android.gms.measurement.internal.zzfz r7 = r7.zzf()     // Catch:{ all -> 0x04d4 }
            java.lang.String r12 = r2.zza     // Catch:{ all -> 0x04d4 }
            r7.zza(r12)     // Catch:{ all -> 0x04d4 }
        L_0x02af:
            r21.zzw()     // Catch:{ all -> 0x04d4 }
            r21.zzk()     // Catch:{ all -> 0x04d4 }
            android.os.Bundle r7 = new android.os.Bundle     // Catch:{ all -> 0x04d4 }
            r7.<init>()     // Catch:{ all -> 0x04d4 }
            r12 = 1
            r7.putLong(r4, r12)     // Catch:{ all -> 0x04d4 }
            r7.putLong(r3, r12)     // Catch:{ all -> 0x04d4 }
            r3 = 0
            r7.putLong(r6, r3)     // Catch:{ all -> 0x04d4 }
            r7.putLong(r5, r3)     // Catch:{ all -> 0x04d4 }
            r7.putLong(r9, r3)     // Catch:{ all -> 0x04d4 }
            r14 = r18
            r7.putLong(r14, r3)     // Catch:{ all -> 0x04d4 }
            com.google.android.gms.measurement.internal.zzgo r3 = r1.zzj     // Catch:{ all -> 0x04d4 }
            com.google.android.gms.measurement.internal.zzx r3 = r3.zzb()     // Catch:{ all -> 0x04d4 }
            java.lang.String r4 = r2.zza     // Catch:{ all -> 0x04d4 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r12 = com.google.android.gms.measurement.internal.zzap.zzba     // Catch:{ all -> 0x04d4 }
            boolean r3 = r3.zze(r4, r12)     // Catch:{ all -> 0x04d4 }
            if (r3 == 0) goto L_0x02e8
            r3 = 1
            r7.putLong(r8, r3)     // Catch:{ all -> 0x04d4 }
            goto L_0x02ea
        L_0x02e8:
            r3 = 1
        L_0x02ea:
            boolean r12 = r2.zzq     // Catch:{ all -> 0x04d4 }
            if (r12 == 0) goto L_0x02f1
            r7.putLong(r0, r3)     // Catch:{ all -> 0x04d4 }
        L_0x02f1:
            com.google.android.gms.measurement.internal.zzac r0 = r21.zze()     // Catch:{ all -> 0x04d4 }
            java.lang.String r3 = r2.zza     // Catch:{ all -> 0x04d4 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)     // Catch:{ all -> 0x04d4 }
            r0.zzd()     // Catch:{ all -> 0x04d4 }
            r0.zzak()     // Catch:{ all -> 0x04d4 }
            java.lang.String r4 = "first_open_count"
            long r3 = r0.zzh(r3, r4)     // Catch:{ all -> 0x04d4 }
            com.google.android.gms.measurement.internal.zzgo r0 = r1.zzj     // Catch:{ all -> 0x04d4 }
            android.content.Context r0 = r0.zzn()     // Catch:{ all -> 0x04d4 }
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch:{ all -> 0x04d4 }
            if (r0 != 0) goto L_0x032b
            com.google.android.gms.measurement.internal.zzgo r0 = r1.zzj     // Catch:{ all -> 0x04d4 }
            com.google.android.gms.measurement.internal.zzfk r0 = r0.zzr()     // Catch:{ all -> 0x04d4 }
            com.google.android.gms.measurement.internal.zzfm r0 = r0.zzf()     // Catch:{ all -> 0x04d4 }
            java.lang.String r6 = "PackageManager is null, first open report might be inaccurate. appId"
            java.lang.String r9 = r2.zza     // Catch:{ all -> 0x04d4 }
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzfk.zza(r9)     // Catch:{ all -> 0x04d4 }
            r0.zza(r6, r9)     // Catch:{ all -> 0x04d4 }
        L_0x0327:
            r12 = 0
            goto L_0x03ea
        L_0x032b:
            com.google.android.gms.measurement.internal.zzgo r0 = r1.zzj     // Catch:{ NameNotFoundException -> 0x033d }
            android.content.Context r0 = r0.zzn()     // Catch:{ NameNotFoundException -> 0x033d }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r0 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r0)     // Catch:{ NameNotFoundException -> 0x033d }
            java.lang.String r12 = r2.zza     // Catch:{ NameNotFoundException -> 0x033d }
            r13 = 0
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r12, r13)     // Catch:{ NameNotFoundException -> 0x033d }
            goto L_0x0354
        L_0x033d:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzgo r12 = r1.zzj     // Catch:{ all -> 0x04d4 }
            com.google.android.gms.measurement.internal.zzfk r12 = r12.zzr()     // Catch:{ all -> 0x04d4 }
            com.google.android.gms.measurement.internal.zzfm r12 = r12.zzf()     // Catch:{ all -> 0x04d4 }
            java.lang.String r13 = "Package info is null, first open report might be inaccurate. appId"
            java.lang.String r15 = r2.zza     // Catch:{ all -> 0x04d4 }
            java.lang.Object r15 = com.google.android.gms.measurement.internal.zzfk.zza(r15)     // Catch:{ all -> 0x04d4 }
            r12.zza(r13, r15, r0)     // Catch:{ all -> 0x04d4 }
            r0 = 0
        L_0x0354:
            if (r0 == 0) goto L_0x03a6
            long r12 = r0.firstInstallTime     // Catch:{ all -> 0x04d4 }
            r15 = 0
            int r12 = (r12 > r15 ? 1 : (r12 == r15 ? 0 : -1))
            if (r12 == 0) goto L_0x03a6
            long r12 = r0.firstInstallTime     // Catch:{ all -> 0x04d4 }
            r18 = r14
            long r14 = r0.lastUpdateTime     // Catch:{ all -> 0x04d4 }
            int r0 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r0 == 0) goto L_0x0389
            com.google.android.gms.measurement.internal.zzgo r0 = r1.zzj     // Catch:{ all -> 0x04d4 }
            com.google.android.gms.measurement.internal.zzx r0 = r0.zzb()     // Catch:{ all -> 0x04d4 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r12 = com.google.android.gms.measurement.internal.zzap.zzcn     // Catch:{ all -> 0x04d4 }
            boolean r0 = r0.zza(r12)     // Catch:{ all -> 0x04d4 }
            if (r0 == 0) goto L_0x0382
            r12 = 0
            int r0 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r0 != 0) goto L_0x0387
            r12 = 1
            r7.putLong(r6, r12)     // Catch:{ all -> 0x04d4 }
            goto L_0x0387
        L_0x0382:
            r12 = 1
            r7.putLong(r6, r12)     // Catch:{ all -> 0x04d4 }
        L_0x0387:
            r14 = 0
            goto L_0x038a
        L_0x0389:
            r14 = 1
        L_0x038a:
            com.google.android.gms.measurement.internal.zzkz r0 = new com.google.android.gms.measurement.internal.zzkz     // Catch:{ all -> 0x04d4 }
            java.lang.String r13 = "_fi"
            if (r14 == 0) goto L_0x0393
            r14 = 1
            goto L_0x0395
        L_0x0393:
            r14 = 0
        L_0x0395:
            java.lang.Long r16 = java.lang.Long.valueOf(r14)     // Catch:{ all -> 0x04d4 }
            java.lang.String r17 = "auto"
            r12 = r0
            r6 = r18
            r14 = r10
            r12.<init>(r13, r14, r16, r17)     // Catch:{ all -> 0x04d4 }
            r1.zza(r0, r2)     // Catch:{ all -> 0x04d4 }
            goto L_0x03a7
        L_0x03a6:
            r6 = r14
        L_0x03a7:
            com.google.android.gms.measurement.internal.zzgo r0 = r1.zzj     // Catch:{ NameNotFoundException -> 0x03b9 }
            android.content.Context r0 = r0.zzn()     // Catch:{ NameNotFoundException -> 0x03b9 }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r0 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r0)     // Catch:{ NameNotFoundException -> 0x03b9 }
            java.lang.String r12 = r2.zza     // Catch:{ NameNotFoundException -> 0x03b9 }
            r13 = 0
            android.content.pm.ApplicationInfo r0 = r0.getApplicationInfo(r12, r13)     // Catch:{ NameNotFoundException -> 0x03b9 }
            goto L_0x03d0
        L_0x03b9:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzgo r12 = r1.zzj     // Catch:{ all -> 0x04d4 }
            com.google.android.gms.measurement.internal.zzfk r12 = r12.zzr()     // Catch:{ all -> 0x04d4 }
            com.google.android.gms.measurement.internal.zzfm r12 = r12.zzf()     // Catch:{ all -> 0x04d4 }
            java.lang.String r13 = "Application info is null, first open report might be inaccurate. appId"
            java.lang.String r14 = r2.zza     // Catch:{ all -> 0x04d4 }
            java.lang.Object r14 = com.google.android.gms.measurement.internal.zzfk.zza(r14)     // Catch:{ all -> 0x04d4 }
            r12.zza(r13, r14, r0)     // Catch:{ all -> 0x04d4 }
            r0 = 0
        L_0x03d0:
            if (r0 == 0) goto L_0x0327
            int r12 = r0.flags     // Catch:{ all -> 0x04d4 }
            r13 = 1
            r12 = r12 & r13
            if (r12 == 0) goto L_0x03dd
            r12 = 1
            r7.putLong(r9, r12)     // Catch:{ all -> 0x04d4 }
        L_0x03dd:
            int r0 = r0.flags     // Catch:{ all -> 0x04d4 }
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0327
            r12 = 1
            r7.putLong(r6, r12)     // Catch:{ all -> 0x04d4 }
            goto L_0x0327
        L_0x03ea:
            int r0 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r0 < 0) goto L_0x03f1
            r7.putLong(r5, r3)     // Catch:{ all -> 0x04d4 }
        L_0x03f1:
            com.google.android.gms.measurement.internal.zzan r0 = new com.google.android.gms.measurement.internal.zzan     // Catch:{ all -> 0x04d4 }
            java.lang.String r13 = "_f"
            com.google.android.gms.measurement.internal.zzam r14 = new com.google.android.gms.measurement.internal.zzam     // Catch:{ all -> 0x04d4 }
            r14.<init>(r7)     // Catch:{ all -> 0x04d4 }
            java.lang.String r15 = "auto"
            r12 = r0
            r16 = r10
            r12.<init>(r13, r14, r15, r16)     // Catch:{ all -> 0x04d4 }
            r1.zza(r0, r2)     // Catch:{ all -> 0x04d4 }
            goto L_0x0462
        L_0x0406:
            r5 = 1
            if (r7 != r5) goto L_0x0462
            com.google.android.gms.measurement.internal.zzkz r5 = new com.google.android.gms.measurement.internal.zzkz     // Catch:{ all -> 0x04d4 }
            java.lang.String r6 = "_fvt"
            java.lang.Long r16 = java.lang.Long.valueOf(r12)     // Catch:{ all -> 0x04d4 }
            java.lang.String r17 = "auto"
            r12 = r5
            r13 = r6
            r14 = r10
            r12.<init>(r13, r14, r16, r17)     // Catch:{ all -> 0x04d4 }
            r1.zza(r5, r2)     // Catch:{ all -> 0x04d4 }
            r21.zzw()     // Catch:{ all -> 0x04d4 }
            r21.zzk()     // Catch:{ all -> 0x04d4 }
            android.os.Bundle r5 = new android.os.Bundle     // Catch:{ all -> 0x04d4 }
            r5.<init>()     // Catch:{ all -> 0x04d4 }
            r6 = 1
            r5.putLong(r4, r6)     // Catch:{ all -> 0x04d4 }
            r5.putLong(r3, r6)     // Catch:{ all -> 0x04d4 }
            com.google.android.gms.measurement.internal.zzgo r3 = r1.zzj     // Catch:{ all -> 0x04d4 }
            com.google.android.gms.measurement.internal.zzx r3 = r3.zzb()     // Catch:{ all -> 0x04d4 }
            java.lang.String r4 = r2.zza     // Catch:{ all -> 0x04d4 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r6 = com.google.android.gms.measurement.internal.zzap.zzba     // Catch:{ all -> 0x04d4 }
            boolean r3 = r3.zze(r4, r6)     // Catch:{ all -> 0x04d4 }
            if (r3 == 0) goto L_0x0445
            r3 = 1
            r5.putLong(r8, r3)     // Catch:{ all -> 0x04d4 }
            goto L_0x0447
        L_0x0445:
            r3 = 1
        L_0x0447:
            boolean r6 = r2.zzq     // Catch:{ all -> 0x04d4 }
            if (r6 == 0) goto L_0x044e
            r5.putLong(r0, r3)     // Catch:{ all -> 0x04d4 }
        L_0x044e:
            com.google.android.gms.measurement.internal.zzan r0 = new com.google.android.gms.measurement.internal.zzan     // Catch:{ all -> 0x04d4 }
            java.lang.String r13 = "_v"
            com.google.android.gms.measurement.internal.zzam r14 = new com.google.android.gms.measurement.internal.zzam     // Catch:{ all -> 0x04d4 }
            r14.<init>(r5)     // Catch:{ all -> 0x04d4 }
            java.lang.String r15 = "auto"
            r12 = r0
            r16 = r10
            r12.<init>(r13, r14, r15, r16)     // Catch:{ all -> 0x04d4 }
            r1.zza(r0, r2)     // Catch:{ all -> 0x04d4 }
        L_0x0462:
            com.google.android.gms.measurement.internal.zzgo r0 = r1.zzj     // Catch:{ all -> 0x04d4 }
            com.google.android.gms.measurement.internal.zzx r0 = r0.zzb()     // Catch:{ all -> 0x04d4 }
            java.lang.String r3 = r2.zza     // Catch:{ all -> 0x04d4 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r4 = com.google.android.gms.measurement.internal.zzap.zzbb     // Catch:{ all -> 0x04d4 }
            boolean r0 = r0.zze(r3, r4)     // Catch:{ all -> 0x04d4 }
            if (r0 != 0) goto L_0x04c5
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x04d4 }
            r0.<init>()     // Catch:{ all -> 0x04d4 }
            r3 = 1
            r0.putLong(r8, r3)     // Catch:{ all -> 0x04d4 }
            com.google.android.gms.measurement.internal.zzgo r3 = r1.zzj     // Catch:{ all -> 0x04d4 }
            com.google.android.gms.measurement.internal.zzx r3 = r3.zzb()     // Catch:{ all -> 0x04d4 }
            java.lang.String r4 = r2.zza     // Catch:{ all -> 0x04d4 }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r5 = com.google.android.gms.measurement.internal.zzap.zzba     // Catch:{ all -> 0x04d4 }
            boolean r3 = r3.zze(r4, r5)     // Catch:{ all -> 0x04d4 }
            if (r3 == 0) goto L_0x0493
            java.lang.String r3 = "_fr"
            r4 = 1
            r0.putLong(r3, r4)     // Catch:{ all -> 0x04d4 }
        L_0x0493:
            com.google.android.gms.measurement.internal.zzan r3 = new com.google.android.gms.measurement.internal.zzan     // Catch:{ all -> 0x04d4 }
            java.lang.String r13 = "_e"
            com.google.android.gms.measurement.internal.zzam r14 = new com.google.android.gms.measurement.internal.zzam     // Catch:{ all -> 0x04d4 }
            r14.<init>(r0)     // Catch:{ all -> 0x04d4 }
            java.lang.String r15 = "auto"
            r12 = r3
            r16 = r10
            r12.<init>(r13, r14, r15, r16)     // Catch:{ all -> 0x04d4 }
            r1.zza(r3, r2)     // Catch:{ all -> 0x04d4 }
            goto L_0x04c5
        L_0x04a8:
            boolean r0 = r2.zzi     // Catch:{ all -> 0x04d4 }
            if (r0 == 0) goto L_0x04c5
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x04d4 }
            r0.<init>()     // Catch:{ all -> 0x04d4 }
            com.google.android.gms.measurement.internal.zzan r3 = new com.google.android.gms.measurement.internal.zzan     // Catch:{ all -> 0x04d4 }
            java.lang.String r13 = "_cd"
            com.google.android.gms.measurement.internal.zzam r14 = new com.google.android.gms.measurement.internal.zzam     // Catch:{ all -> 0x04d4 }
            r14.<init>(r0)     // Catch:{ all -> 0x04d4 }
            java.lang.String r15 = "auto"
            r12 = r3
            r16 = r10
            r12.<init>(r13, r14, r15, r16)     // Catch:{ all -> 0x04d4 }
            r1.zza(r3, r2)     // Catch:{ all -> 0x04d4 }
        L_0x04c5:
            com.google.android.gms.measurement.internal.zzac r0 = r21.zze()     // Catch:{ all -> 0x04d4 }
            r0.b_()     // Catch:{ all -> 0x04d4 }
            com.google.android.gms.measurement.internal.zzac r0 = r21.zze()
            r0.zzh()
            return
        L_0x04d4:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzac r2 = r21.zze()
            r2.zzh()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzks.zzb(com.google.android.gms.measurement.internal.zzm):void");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.measurement.internal.zzm.<init>(java.lang.String, java.lang.String, java.lang.String, long, java.lang.String, long, long, java.lang.String, boolean, boolean, java.lang.String, long, long, int, boolean, boolean, boolean, java.lang.String, java.lang.Boolean, long, java.util.List<java.lang.String>, java.lang.String):void
     arg types: [java.lang.String, java.lang.String, java.lang.String, long, java.lang.String, long, long, ?[OBJECT, ARRAY], boolean, int, java.lang.String, long, int, int, boolean, boolean, int, java.lang.String, java.lang.Boolean, long, java.util.List<java.lang.String>, java.lang.String]
     candidates:
      com.google.android.gms.measurement.internal.zzm.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, long, long, java.lang.String, boolean, boolean, long, java.lang.String, long, long, int, boolean, boolean, boolean, java.lang.String, java.lang.Boolean, long, java.util.List<java.lang.String>, java.lang.String):void
      com.google.android.gms.measurement.internal.zzm.<init>(java.lang.String, java.lang.String, java.lang.String, long, java.lang.String, long, long, java.lang.String, boolean, boolean, java.lang.String, long, long, int, boolean, boolean, boolean, java.lang.String, java.lang.Boolean, long, java.util.List<java.lang.String>, java.lang.String):void */
    private final zzm zza(String str) {
        String str2 = str;
        zzg zzb2 = zze().zzb(str2);
        if (zzb2 == null || TextUtils.isEmpty(zzb2.zzl())) {
            this.zzj.zzr().zzw().zza("No app data available; dropping", str2);
            return null;
        }
        Boolean zzb3 = zzb(zzb2);
        if (zzb3 == null || zzb3.booleanValue()) {
            return new zzm(str, zzb2.zze(), zzb2.zzl(), zzb2.zzm(), zzb2.zzn(), zzb2.zzo(), zzb2.zzp(), (String) null, zzb2.zzr(), false, zzb2.zzi(), zzb2.zzae(), 0L, 0, zzb2.zzaf(), zzb2.zzag(), false, zzb2.zzf(), zzb2.zzah(), zzb2.zzq(), zzb2.zzai(), (!zzll.zzb() || !this.zzj.zzb().zze(str2, zzap.zzch)) ? null : zzb2.zzg());
        }
        this.zzj.zzr().zzf().zza("App version does not match; dropping. appId", zzfk.zza(str));
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzv zzv2) {
        zzm zza2 = zza(zzv2.zza);
        if (zza2 != null) {
            zza(zzv2, zza2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzv zzv2, zzm zzm2) {
        Preconditions.checkNotNull(zzv2);
        Preconditions.checkNotEmpty(zzv2.zza);
        Preconditions.checkNotNull(zzv2.zzb);
        Preconditions.checkNotNull(zzv2.zzc);
        Preconditions.checkNotEmpty(zzv2.zzc.zza);
        zzw();
        zzk();
        if (zze(zzm2)) {
            if (!zzm2.zzh) {
                zzc(zzm2);
                return;
            }
            zzv zzv3 = new zzv(zzv2);
            boolean z = false;
            zzv3.zze = false;
            zze().zzf();
            try {
                zzv zzd2 = zze().zzd(zzv3.zza, zzv3.zzc.zza);
                if (zzd2 != null && !zzd2.zzb.equals(zzv3.zzb)) {
                    this.zzj.zzr().zzi().zza("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.zzj.zzj().zzc(zzv3.zzc.zza), zzv3.zzb, zzd2.zzb);
                }
                if (zzd2 != null && zzd2.zze) {
                    zzv3.zzb = zzd2.zzb;
                    zzv3.zzd = zzd2.zzd;
                    zzv3.zzh = zzd2.zzh;
                    zzv3.zzf = zzd2.zzf;
                    zzv3.zzi = zzd2.zzi;
                    zzv3.zze = zzd2.zze;
                    zzv3.zzc = new zzkz(zzv3.zzc.zza, zzd2.zzc.zzb, zzv3.zzc.zza(), zzd2.zzc.zze);
                } else if (TextUtils.isEmpty(zzv3.zzf)) {
                    zzv3.zzc = new zzkz(zzv3.zzc.zza, zzv3.zzd, zzv3.zzc.zza(), zzv3.zzc.zze);
                    zzv3.zze = true;
                    z = true;
                }
                if (zzv3.zze) {
                    zzkz zzkz = zzv3.zzc;
                    zzlb zzlb = new zzlb(zzv3.zza, zzv3.zzb, zzkz.zza, zzkz.zzb, zzkz.zza());
                    if (zze().zza(zzlb)) {
                        this.zzj.zzr().zzw().zza("User property updated immediately", zzv3.zza, this.zzj.zzj().zzc(zzlb.zzc), zzlb.zze);
                    } else {
                        this.zzj.zzr().zzf().zza("(2)Too many active user properties, ignoring", zzfk.zza(zzv3.zza), this.zzj.zzj().zzc(zzlb.zzc), zzlb.zze);
                    }
                    if (z && zzv3.zzi != null) {
                        zzb(new zzan(zzv3.zzi, zzv3.zzd), zzm2);
                    }
                }
                if (zze().zza(zzv3)) {
                    this.zzj.zzr().zzw().zza("Conditional property added", zzv3.zza, this.zzj.zzj().zzc(zzv3.zzc.zza), zzv3.zzc.zza());
                } else {
                    this.zzj.zzr().zzf().zza("Too many conditional properties, ignoring", zzfk.zza(zzv3.zza), this.zzj.zzj().zzc(zzv3.zzc.zza), zzv3.zzc.zza());
                }
                zze().b_();
            } finally {
                zze().zzh();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzv zzv2) {
        zzm zza2 = zza(zzv2.zza);
        if (zza2 != null) {
            zzb(zzv2, zza2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzv zzv2, zzm zzm2) {
        Preconditions.checkNotNull(zzv2);
        Preconditions.checkNotEmpty(zzv2.zza);
        Preconditions.checkNotNull(zzv2.zzc);
        Preconditions.checkNotEmpty(zzv2.zzc.zza);
        zzw();
        zzk();
        if (zze(zzm2)) {
            if (!zzm2.zzh) {
                zzc(zzm2);
                return;
            }
            zze().zzf();
            try {
                zzc(zzm2);
                zzv zzd2 = zze().zzd(zzv2.zza, zzv2.zzc.zza);
                if (zzd2 != null) {
                    this.zzj.zzr().zzw().zza("Removing conditional user property", zzv2.zza, this.zzj.zzj().zzc(zzv2.zzc.zza));
                    zze().zze(zzv2.zza, zzv2.zzc.zza);
                    if (zzd2.zze) {
                        zze().zzb(zzv2.zza, zzv2.zzc.zza);
                    }
                    if (zzv2.zzk != null) {
                        Bundle bundle = null;
                        if (zzv2.zzk.zzb != null) {
                            bundle = zzv2.zzk.zzb.zzb();
                        }
                        Bundle bundle2 = bundle;
                        zzb(this.zzj.zzi().zza(zzv2.zza, zzv2.zzk.zza, bundle2, zzd2.zzb, zzv2.zzk.zzd, true, false), zzm2);
                    }
                } else {
                    this.zzj.zzr().zzi().zza("Conditional user property doesn't exist", zzfk.zza(zzv2.zza), this.zzj.zzj().zzc(zzv2.zzc.zza));
                }
                zze().b_();
            } finally {
                zze().zzh();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x014a  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0158  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0195  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.measurement.internal.zzg zza(com.google.android.gms.measurement.internal.zzm r8, com.google.android.gms.measurement.internal.zzg r9, java.lang.String r10) {
        /*
            r7 = this;
            r0 = 1
            if (r9 != 0) goto L_0x001e
            com.google.android.gms.measurement.internal.zzg r9 = new com.google.android.gms.measurement.internal.zzg
            com.google.android.gms.measurement.internal.zzgo r1 = r7.zzj
            java.lang.String r2 = r8.zza
            r9.<init>(r1, r2)
            com.google.android.gms.measurement.internal.zzgo r1 = r7.zzj
            com.google.android.gms.measurement.internal.zzla r1 = r1.zzi()
            java.lang.String r1 = r1.zzk()
            r9.zza(r1)
            r9.zze(r10)
        L_0x001c:
            r10 = r0
            goto L_0x003a
        L_0x001e:
            java.lang.String r1 = r9.zzh()
            boolean r1 = r10.equals(r1)
            if (r1 != 0) goto L_0x0039
            r9.zze(r10)
            com.google.android.gms.measurement.internal.zzgo r10 = r7.zzj
            com.google.android.gms.measurement.internal.zzla r10 = r10.zzi()
            java.lang.String r10 = r10.zzk()
            r9.zza(r10)
            goto L_0x001c
        L_0x0039:
            r10 = 0
        L_0x003a:
            java.lang.String r1 = r8.zzb
            java.lang.String r2 = r9.zze()
            boolean r1 = android.text.TextUtils.equals(r1, r2)
            if (r1 != 0) goto L_0x004c
            java.lang.String r10 = r8.zzb
            r9.zzb(r10)
            r10 = r0
        L_0x004c:
            java.lang.String r1 = r8.zzr
            java.lang.String r2 = r9.zzf()
            boolean r1 = android.text.TextUtils.equals(r1, r2)
            if (r1 != 0) goto L_0x005e
            java.lang.String r10 = r8.zzr
            r9.zzc(r10)
            r10 = r0
        L_0x005e:
            boolean r1 = com.google.android.gms.internal.measurement.zzll.zzb()
            if (r1 == 0) goto L_0x0088
            com.google.android.gms.measurement.internal.zzgo r1 = r7.zzj
            com.google.android.gms.measurement.internal.zzx r1 = r1.zzb()
            java.lang.String r2 = r9.zzc()
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzap.zzch
            boolean r1 = r1.zze(r2, r3)
            if (r1 == 0) goto L_0x0088
            java.lang.String r1 = r8.zzv
            java.lang.String r2 = r9.zzg()
            boolean r1 = android.text.TextUtils.equals(r1, r2)
            if (r1 != 0) goto L_0x0088
            java.lang.String r10 = r8.zzv
            r9.zzd(r10)
            r10 = r0
        L_0x0088:
            java.lang.String r1 = r8.zzk
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x00a2
            java.lang.String r1 = r8.zzk
            java.lang.String r2 = r9.zzi()
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x00a2
            java.lang.String r10 = r8.zzk
            r9.zzf(r10)
            r10 = r0
        L_0x00a2:
            long r1 = r8.zze
            r3 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x00ba
            long r1 = r8.zze
            long r5 = r9.zzo()
            int r1 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r1 == 0) goto L_0x00ba
            long r1 = r8.zze
            r9.zzd(r1)
            r10 = r0
        L_0x00ba:
            java.lang.String r1 = r8.zzc
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x00d4
            java.lang.String r1 = r8.zzc
            java.lang.String r2 = r9.zzl()
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x00d4
            java.lang.String r10 = r8.zzc
            r9.zzg(r10)
            r10 = r0
        L_0x00d4:
            long r1 = r8.zzj
            long r5 = r9.zzm()
            int r1 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r1 == 0) goto L_0x00e4
            long r1 = r8.zzj
            r9.zzc(r1)
            r10 = r0
        L_0x00e4:
            java.lang.String r1 = r8.zzd
            if (r1 == 0) goto L_0x00fa
            java.lang.String r1 = r8.zzd
            java.lang.String r2 = r9.zzn()
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x00fa
            java.lang.String r10 = r8.zzd
            r9.zzh(r10)
            r10 = r0
        L_0x00fa:
            long r1 = r8.zzf
            long r5 = r9.zzp()
            int r1 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r1 == 0) goto L_0x010a
            long r1 = r8.zzf
            r9.zze(r1)
            r10 = r0
        L_0x010a:
            boolean r1 = r8.zzh
            boolean r2 = r9.zzr()
            if (r1 == r2) goto L_0x0118
            boolean r10 = r8.zzh
            r9.zza(r10)
            r10 = r0
        L_0x0118:
            java.lang.String r1 = r8.zzg
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0132
            java.lang.String r1 = r8.zzg
            java.lang.String r2 = r9.zzac()
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0132
            java.lang.String r10 = r8.zzg
            r9.zzi(r10)
            r10 = r0
        L_0x0132:
            long r1 = r8.zzl
            long r5 = r9.zzae()
            int r1 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r1 == 0) goto L_0x0142
            long r1 = r8.zzl
            r9.zzp(r1)
            r10 = r0
        L_0x0142:
            boolean r1 = r8.zzo
            boolean r2 = r9.zzaf()
            if (r1 == r2) goto L_0x0150
            boolean r10 = r8.zzo
            r9.zzb(r10)
            r10 = r0
        L_0x0150:
            boolean r1 = r8.zzp
            boolean r2 = r9.zzag()
            if (r1 == r2) goto L_0x015e
            boolean r10 = r8.zzp
            r9.zzc(r10)
            r10 = r0
        L_0x015e:
            com.google.android.gms.measurement.internal.zzgo r1 = r7.zzj
            com.google.android.gms.measurement.internal.zzx r1 = r1.zzb()
            java.lang.String r2 = r8.zza
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r5 = com.google.android.gms.measurement.internal.zzap.zzbc
            boolean r1 = r1.zze(r2, r5)
            if (r1 == 0) goto L_0x017c
            java.lang.Boolean r1 = r8.zzs
            java.lang.Boolean r2 = r9.zzah()
            if (r1 == r2) goto L_0x017c
            java.lang.Boolean r10 = r8.zzs
            r9.zza(r10)
            r10 = r0
        L_0x017c:
            long r1 = r8.zzt
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x0192
            long r1 = r8.zzt
            long r3 = r9.zzq()
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x0192
            long r1 = r8.zzt
            r9.zzf(r1)
            goto L_0x0193
        L_0x0192:
            r0 = r10
        L_0x0193:
            if (r0 == 0) goto L_0x019c
            com.google.android.gms.measurement.internal.zzac r8 = r7.zze()
            r8.zza(r9)
        L_0x019c:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzks.zza(com.google.android.gms.measurement.internal.zzm, com.google.android.gms.measurement.internal.zzg, java.lang.String):com.google.android.gms.measurement.internal.zzg");
    }

    /* access modifiers changed from: package-private */
    public final zzg zzc(zzm zzm2) {
        zzw();
        zzk();
        Preconditions.checkNotNull(zzm2);
        Preconditions.checkNotEmpty(zzm2.zza);
        zzg zzb2 = zze().zzb(zzm2.zza);
        String zzb3 = this.zzj.zzc().zzb(zzm2.zza);
        if (!com.google.android.gms.internal.measurement.zzks.zzb() || !this.zzj.zzb().zza(zzap.zzcp)) {
            return zza(zzm2, zzb2, zzb3);
        }
        if (zzb2 == null) {
            zzb2 = new zzg(this.zzj, zzm2.zza);
            zzb2.zza(this.zzj.zzi().zzk());
            zzb2.zze(zzb3);
        } else if (!zzb3.equals(zzb2.zzh())) {
            zzb2.zze(zzb3);
            zzb2.zza(this.zzj.zzi().zzk());
        }
        zzb2.zzb(zzm2.zzb);
        zzb2.zzc(zzm2.zzr);
        if (zzll.zzb() && this.zzj.zzb().zze(zzb2.zzc(), zzap.zzch)) {
            zzb2.zzd(zzm2.zzv);
        }
        if (!TextUtils.isEmpty(zzm2.zzk)) {
            zzb2.zzf(zzm2.zzk);
        }
        if (zzm2.zze != 0) {
            zzb2.zzd(zzm2.zze);
        }
        if (!TextUtils.isEmpty(zzm2.zzc)) {
            zzb2.zzg(zzm2.zzc);
        }
        zzb2.zzc(zzm2.zzj);
        if (zzm2.zzd != null) {
            zzb2.zzh(zzm2.zzd);
        }
        zzb2.zze(zzm2.zzf);
        zzb2.zza(zzm2.zzh);
        if (!TextUtils.isEmpty(zzm2.zzg)) {
            zzb2.zzi(zzm2.zzg);
        }
        zzb2.zzp(zzm2.zzl);
        zzb2.zzb(zzm2.zzo);
        zzb2.zzc(zzm2.zzp);
        if (this.zzj.zzb().zze(zzm2.zza, zzap.zzbc)) {
            zzb2.zza(zzm2.zzs);
        }
        zzb2.zzf(zzm2.zzt);
        if (zzb2.zza()) {
            zze().zza(zzb2);
        }
        return zzb2;
    }

    /* access modifiers changed from: package-private */
    public final String zzd(zzm zzm2) {
        try {
            return (String) this.zzj.zzq().zza(new zzkv(this, zzm2)).get(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            this.zzj.zzr().zzf().zza("Failed to get app instance id. appId", zzfk.zza(zzm2.zza), e);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(boolean z) {
        zzz();
    }

    private final boolean zze(zzm zzm2) {
        return (!zzll.zzb() || !this.zzj.zzb().zze(zzm2.zza, zzap.zzch)) ? !TextUtils.isEmpty(zzm2.zzb) || !TextUtils.isEmpty(zzm2.zzr) : !TextUtils.isEmpty(zzm2.zzb) || !TextUtils.isEmpty(zzm2.zzv) || !TextUtils.isEmpty(zzm2.zzr);
    }
}
