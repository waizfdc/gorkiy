package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzn;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
public final class zzix extends zze {
    /* access modifiers changed from: private */
    public final zzjp zza;
    /* access modifiers changed from: private */
    public zzfc zzb;
    private volatile Boolean zzc;
    private final zzaf zzd;
    private final zzkl zze;
    private final List<Runnable> zzf = new ArrayList();
    private final zzaf zzg;

    protected zzix(zzgo zzgo) {
        super(zzgo);
        this.zze = new zzkl(zzgo.zzm());
        this.zza = new zzjp(this);
        this.zzd = new zzja(this, zzgo);
        this.zzg = new zzjh(this, zzgo);
    }

    /* access modifiers changed from: protected */
    public final boolean zzz() {
        return false;
    }

    public final boolean zzab() {
        zzd();
        zzw();
        return this.zzb != null;
    }

    /* access modifiers changed from: protected */
    public final void zzac() {
        zzd();
        zzw();
        zza(new zzjk(this, zza(true)));
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzfc zzfc, AbstractSafeParcelable abstractSafeParcelable, zzm zzm) {
        int i;
        List<AbstractSafeParcelable> zza2;
        zzd();
        zzb();
        zzw();
        boolean zzai = zzai();
        int i2 = 0;
        int i3 = 100;
        while (i2 < 1001 && i3 == 100) {
            ArrayList arrayList = new ArrayList();
            if (!zzai || (zza2 = zzj().zza(100)) == null) {
                i = 0;
            } else {
                arrayList.addAll(zza2);
                i = zza2.size();
            }
            if (abstractSafeParcelable != null && i < 100) {
                arrayList.add(abstractSafeParcelable);
            }
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            int i4 = 0;
            while (i4 < size) {
                Object obj = arrayList2.get(i4);
                i4++;
                AbstractSafeParcelable abstractSafeParcelable2 = (AbstractSafeParcelable) obj;
                if (abstractSafeParcelable2 instanceof zzan) {
                    try {
                        zzfc.zza((zzan) abstractSafeParcelable2, zzm);
                    } catch (RemoteException e) {
                        zzr().zzf().zza("Failed to send event to the service", e);
                    }
                } else if (abstractSafeParcelable2 instanceof zzkz) {
                    try {
                        zzfc.zza((zzkz) abstractSafeParcelable2, zzm);
                    } catch (RemoteException e2) {
                        zzr().zzf().zza("Failed to send user property to the service", e2);
                    }
                } else if (abstractSafeParcelable2 instanceof zzv) {
                    try {
                        zzfc.zza((zzv) abstractSafeParcelable2, zzm);
                    } catch (RemoteException e3) {
                        zzr().zzf().zza("Failed to send conditional user property to the service", e3);
                    }
                } else {
                    zzr().zzf().zza("Discarding data. Unrecognized parcel type.");
                }
            }
            i2++;
            i3 = i;
        }
    }

    /* access modifiers changed from: protected */
    public final void zza(zzan zzan, String str) {
        Preconditions.checkNotNull(zzan);
        zzd();
        zzw();
        boolean zzai = zzai();
        zza(new zzjj(this, zzai, zzai && zzj().zza(zzan), zzan, zza(true), str));
    }

    /* access modifiers changed from: protected */
    public final void zza(zzv zzv) {
        Preconditions.checkNotNull(zzv);
        zzd();
        zzw();
        zzu();
        zza(new zzjm(this, true, zzj().zza(zzv), new zzv(zzv), zza(true), zzv));
    }

    /* access modifiers changed from: protected */
    public final void zza(AtomicReference<List<zzv>> atomicReference, String str, String str2, String str3) {
        zzd();
        zzw();
        zza(new zzjl(this, atomicReference, str, str2, str3, zza(false)));
    }

    /* access modifiers changed from: protected */
    public final void zza(zzn zzn, String str, String str2) {
        zzd();
        zzw();
        zza(new zzjo(this, str, str2, zza(false), zzn));
    }

    /* access modifiers changed from: protected */
    public final void zza(AtomicReference<List<zzkz>> atomicReference, String str, String str2, String str3, boolean z) {
        zzd();
        zzw();
        zza(new zzjn(this, atomicReference, str, str2, str3, z, zza(false)));
    }

    /* access modifiers changed from: protected */
    public final void zza(zzn zzn, String str, String str2, boolean z) {
        zzd();
        zzw();
        zza(new zzjq(this, str, str2, z, zza(false), zzn));
    }

    /* access modifiers changed from: protected */
    public final void zza(zzkz zzkz) {
        zzd();
        zzw();
        zza(new zziz(this, zzai() && zzj().zza(zzkz), zzkz, zza(true)));
    }

    /* access modifiers changed from: protected */
    public final void zza(AtomicReference<List<zzkz>> atomicReference, boolean z) {
        zzd();
        zzw();
        zza(new zzjc(this, atomicReference, zza(false), z));
    }

    /* access modifiers changed from: protected */
    public final void zzad() {
        zzd();
        zzb();
        zzw();
        zzm zza2 = zza(false);
        if (zzai()) {
            zzj().zzab();
        }
        zza(new zzjb(this, zza2));
    }

    private final boolean zzai() {
        zzu();
        return true;
    }

    public final void zza(AtomicReference<String> atomicReference) {
        zzd();
        zzw();
        zza(new zzje(this, atomicReference, zza(false)));
    }

    public final void zza(zzn zzn) {
        zzd();
        zzw();
        zza(new zzjd(this, zza(false), zzn));
    }

    /* access modifiers changed from: protected */
    public final void zzae() {
        zzd();
        zzw();
        zzm zza2 = zza(true);
        boolean zza3 = zzt().zza(zzap.zzbz);
        if (zza3) {
            zzj().zzac();
        }
        zza(new zzjg(this, zza2, zza3));
    }

    /* access modifiers changed from: protected */
    public final void zza(zzit zzit) {
        zzd();
        zzw();
        zza(new zzjf(this, zzit));
    }

    /* access modifiers changed from: private */
    public final void zzaj() {
        zzd();
        this.zze.zza();
        this.zzd.zza(zzap.zzah.zza(null).longValue());
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x010f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzaf() {
        /*
            r6 = this;
            r6.zzd()
            r6.zzw()
            boolean r0 = r6.zzab()
            if (r0 == 0) goto L_0x000d
            return
        L_0x000d:
            java.lang.Boolean r0 = r6.zzc
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x011c
            r6.zzd()
            r6.zzw()
            com.google.android.gms.measurement.internal.zzft r0 = r6.zzs()
            java.lang.Boolean r0 = r0.zzj()
            if (r0 == 0) goto L_0x002c
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x002c
            r0 = r2
            goto L_0x0116
        L_0x002c:
            r6.zzu()
            com.google.android.gms.measurement.internal.zzfd r0 = r6.zzg()
            int r0 = r0.zzag()
            if (r0 != r2) goto L_0x003d
        L_0x0039:
            r0 = r2
        L_0x003a:
            r3 = r0
            goto L_0x00f3
        L_0x003d:
            com.google.android.gms.measurement.internal.zzfk r0 = r6.zzr()
            com.google.android.gms.measurement.internal.zzfm r0 = r0.zzx()
            java.lang.String r3 = "Checking service availability"
            r0.zza(r3)
            com.google.android.gms.measurement.internal.zzla r0 = r6.zzp()
            r3 = 12451000(0xbdfcb8, float:1.7447567E-38)
            int r0 = r0.zza(r3)
            if (r0 == 0) goto L_0x00e4
            if (r0 == r2) goto L_0x00d4
            r3 = 2
            if (r0 == r3) goto L_0x00a4
            r3 = 3
            if (r0 == r3) goto L_0x0095
            r3 = 9
            if (r0 == r3) goto L_0x0087
            r3 = 18
            if (r0 == r3) goto L_0x0079
            com.google.android.gms.measurement.internal.zzfk r3 = r6.zzr()
            com.google.android.gms.measurement.internal.zzfm r3 = r3.zzi()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r4 = "Unexpected service status"
            r3.zza(r4, r0)
            goto L_0x00a2
        L_0x0079:
            com.google.android.gms.measurement.internal.zzfk r0 = r6.zzr()
            com.google.android.gms.measurement.internal.zzfm r0 = r0.zzi()
            java.lang.String r3 = "Service updating"
            r0.zza(r3)
            goto L_0x0039
        L_0x0087:
            com.google.android.gms.measurement.internal.zzfk r0 = r6.zzr()
            com.google.android.gms.measurement.internal.zzfm r0 = r0.zzi()
            java.lang.String r3 = "Service invalid"
            r0.zza(r3)
            goto L_0x00a2
        L_0x0095:
            com.google.android.gms.measurement.internal.zzfk r0 = r6.zzr()
            com.google.android.gms.measurement.internal.zzfm r0 = r0.zzi()
            java.lang.String r3 = "Service disabled"
            r0.zza(r3)
        L_0x00a2:
            r0 = r1
            goto L_0x003a
        L_0x00a4:
            com.google.android.gms.measurement.internal.zzfk r0 = r6.zzr()
            com.google.android.gms.measurement.internal.zzfm r0 = r0.zzw()
            java.lang.String r3 = "Service container out of date"
            r0.zza(r3)
            com.google.android.gms.measurement.internal.zzla r0 = r6.zzp()
            int r0 = r0.zzj()
            r3 = 17443(0x4423, float:2.4443E-41)
            if (r0 >= r3) goto L_0x00be
            goto L_0x00e1
        L_0x00be:
            com.google.android.gms.measurement.internal.zzft r0 = r6.zzs()
            java.lang.Boolean r0 = r0.zzj()
            if (r0 == 0) goto L_0x00d1
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x00cf
            goto L_0x00d1
        L_0x00cf:
            r0 = r1
            goto L_0x00d2
        L_0x00d1:
            r0 = r2
        L_0x00d2:
            r3 = r1
            goto L_0x00f3
        L_0x00d4:
            com.google.android.gms.measurement.internal.zzfk r0 = r6.zzr()
            com.google.android.gms.measurement.internal.zzfm r0 = r0.zzx()
            java.lang.String r3 = "Service missing"
            r0.zza(r3)
        L_0x00e1:
            r0 = r1
            r3 = r2
            goto L_0x00f3
        L_0x00e4:
            com.google.android.gms.measurement.internal.zzfk r0 = r6.zzr()
            com.google.android.gms.measurement.internal.zzfm r0 = r0.zzx()
            java.lang.String r3 = "Service available"
            r0.zza(r3)
            goto L_0x0039
        L_0x00f3:
            if (r0 != 0) goto L_0x010d
            com.google.android.gms.measurement.internal.zzx r4 = r6.zzt()
            boolean r4 = r4.zzx()
            if (r4 == 0) goto L_0x010d
            com.google.android.gms.measurement.internal.zzfk r3 = r6.zzr()
            com.google.android.gms.measurement.internal.zzfm r3 = r3.zzf()
            java.lang.String r4 = "No way to upload. Consider using the full version of Analytics"
            r3.zza(r4)
            r3 = r1
        L_0x010d:
            if (r3 == 0) goto L_0x0116
            com.google.android.gms.measurement.internal.zzft r3 = r6.zzs()
            r3.zza(r0)
        L_0x0116:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r6.zzc = r0
        L_0x011c:
            java.lang.Boolean r0 = r6.zzc
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x012a
            com.google.android.gms.measurement.internal.zzjp r0 = r6.zza
            r0.zzb()
            return
        L_0x012a:
            com.google.android.gms.measurement.internal.zzx r0 = r6.zzt()
            boolean r0 = r0.zzx()
            if (r0 != 0) goto L_0x0188
            r6.zzu()
            android.content.Context r0 = r6.zzn()
            android.content.pm.PackageManager r0 = r0.getPackageManager()
            android.content.Intent r3 = new android.content.Intent
            r3.<init>()
            android.content.Context r4 = r6.zzn()
            java.lang.String r5 = "com.google.android.gms.measurement.AppMeasurementService"
            android.content.Intent r3 = r3.setClassName(r4, r5)
            r4 = 65536(0x10000, float:9.18355E-41)
            java.util.List r0 = r0.queryIntentServices(r3, r4)
            if (r0 == 0) goto L_0x015d
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x015d
            r1 = r2
        L_0x015d:
            if (r1 == 0) goto L_0x017b
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r1 = "com.google.android.gms.measurement.START"
            r0.<init>(r1)
            android.content.ComponentName r1 = new android.content.ComponentName
            android.content.Context r2 = r6.zzn()
            r6.zzu()
            r1.<init>(r2, r5)
            r0.setComponent(r1)
            com.google.android.gms.measurement.internal.zzjp r1 = r6.zza
            r1.zza(r0)
            return
        L_0x017b:
            com.google.android.gms.measurement.internal.zzfk r0 = r6.zzr()
            com.google.android.gms.measurement.internal.zzfm r0 = r0.zzf()
            java.lang.String r1 = "Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest"
            r0.zza(r1)
        L_0x0188:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzix.zzaf():void");
    }

    /* access modifiers changed from: package-private */
    public final Boolean zzag() {
        return this.zzc;
    }

    /* access modifiers changed from: protected */
    public final void zza(zzfc zzfc) {
        zzd();
        Preconditions.checkNotNull(zzfc);
        this.zzb = zzfc;
        zzaj();
        zzal();
    }

    public final void zzah() {
        zzd();
        zzw();
        this.zza.zza();
        try {
            ConnectionTracker.getInstance().unbindService(zzn(), this.zza);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.zzb = null;
    }

    /* access modifiers changed from: private */
    public final void zza(ComponentName componentName) {
        zzd();
        if (this.zzb != null) {
            this.zzb = null;
            zzr().zzx().zza("Disconnected from device MeasurementService", componentName);
            zzd();
            zzaf();
        }
    }

    /* access modifiers changed from: private */
    public final void zzak() {
        zzd();
        if (zzab()) {
            zzr().zzx().zza("Inactivity, disconnecting from the service");
            zzah();
        }
    }

    private final void zza(Runnable runnable) throws IllegalStateException {
        zzd();
        if (zzab()) {
            runnable.run();
        } else if (((long) this.zzf.size()) >= 1000) {
            zzr().zzf().zza("Discarding data. Max runnable queue size reached");
        } else {
            this.zzf.add(runnable);
            this.zzg.zza(60000);
            zzaf();
        }
    }

    /* access modifiers changed from: private */
    public final void zzal() {
        zzd();
        zzr().zzx().zza("Processing queued up service tasks", Integer.valueOf(this.zzf.size()));
        for (Runnable run : this.zzf) {
            try {
                run.run();
            } catch (Exception e) {
                zzr().zzf().zza("Task exception while flushing queue", e);
            }
        }
        this.zzf.clear();
        this.zzg.zzc();
    }

    private final zzm zza(boolean z) {
        zzu();
        return zzg().zza(z ? zzr().zzy() : null);
    }

    public final void zza(zzn zzn, zzan zzan, String str) {
        zzd();
        zzw();
        if (zzp().zza((int) GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE) != 0) {
            zzr().zzi().zza("Not bundling data. Service unavailable or out of date");
            zzp().zza(zzn, new byte[0]);
            return;
        }
        zza(new zzji(this, zzan, str, zzn));
    }

    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }

    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    public final /* bridge */ /* synthetic */ void zzd() {
        super.zzd();
    }

    public final /* bridge */ /* synthetic */ zzb zze() {
        return super.zze();
    }

    public final /* bridge */ /* synthetic */ zzhp zzf() {
        return super.zzf();
    }

    public final /* bridge */ /* synthetic */ zzfd zzg() {
        return super.zzg();
    }

    public final /* bridge */ /* synthetic */ zzix zzh() {
        return super.zzh();
    }

    public final /* bridge */ /* synthetic */ zziw zzi() {
        return super.zzi();
    }

    public final /* bridge */ /* synthetic */ zzfg zzj() {
        return super.zzj();
    }

    public final /* bridge */ /* synthetic */ zzkc zzk() {
        return super.zzk();
    }

    public final /* bridge */ /* synthetic */ zzah zzl() {
        return super.zzl();
    }

    public final /* bridge */ /* synthetic */ Clock zzm() {
        return super.zzm();
    }

    public final /* bridge */ /* synthetic */ Context zzn() {
        return super.zzn();
    }

    public final /* bridge */ /* synthetic */ zzfi zzo() {
        return super.zzo();
    }

    public final /* bridge */ /* synthetic */ zzla zzp() {
        return super.zzp();
    }

    public final /* bridge */ /* synthetic */ zzgh zzq() {
        return super.zzq();
    }

    public final /* bridge */ /* synthetic */ zzfk zzr() {
        return super.zzr();
    }

    public final /* bridge */ /* synthetic */ zzft zzs() {
        return super.zzs();
    }

    public final /* bridge */ /* synthetic */ zzx zzt() {
        return super.zzt();
    }

    public final /* bridge */ /* synthetic */ zzw zzu() {
        return super.zzu();
    }
}
