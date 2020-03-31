package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import androidx.work.WorkRequest;
import com.google.android.gms.common.api.internal.GoogleServices;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.measurement.internal.zzhn;
import com.google.android.gms.measurement.internal.zzho;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.2.3 */
public class zzx {
    private static volatile zzx zzb = null;
    private static Boolean zzh = null;
    /* access modifiers changed from: private */
    public static Boolean zzi = null;
    private static boolean zzj = false;
    private static Boolean zzk = null;
    private static String zzl = "use_dynamite_api";
    private static String zzm = "allow_remote_dynamite";
    private static boolean zzn = false;
    private static boolean zzo = false;
    protected final Clock zza;
    /* access modifiers changed from: private */
    public final String zzc;
    private final ExecutorService zzd;
    private final AppMeasurementSdk zze;
    /* access modifiers changed from: private */
    public List<Pair<zzhn, zzb>> zzf;
    private int zzg;
    /* access modifiers changed from: private */
    public boolean zzp;
    private String zzq;
    /* access modifiers changed from: private */
    public zzm zzr;

    /* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.2.3 */
    class zzd implements Application.ActivityLifecycleCallbacks {
        zzd() {
        }

        public final void onActivityCreated(Activity activity, Bundle bundle) {
            zzx.this.zza(new zzbc(this, activity, bundle));
        }

        public final void onActivityStarted(Activity activity) {
            zzx.this.zza(new zzbe(this, activity));
        }

        public final void onActivityResumed(Activity activity) {
            zzx.this.zza(new zzbd(this, activity));
        }

        public final void onActivityPaused(Activity activity) {
            zzx.this.zza(new zzbg(this, activity));
        }

        public final void onActivityStopped(Activity activity) {
            zzx.this.zza(new zzbf(this, activity));
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            zzk zzk = new zzk();
            zzx.this.zza(new zzbi(this, activity, zzk));
            Bundle zzb = zzk.zzb(50);
            if (zzb != null) {
                bundle.putAll(zzb);
            }
        }

        public final void onActivityDestroyed(Activity activity) {
            zzx.this.zza(new zzbh(this, activity));
        }
    }

    public static zzx zza(Context context) {
        return zza(context, (String) null, (String) null, (String) null, (Bundle) null);
    }

    /* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.2.3 */
    abstract class zza implements Runnable {
        final long zza;
        final long zzb;
        private final boolean zzc;

        zza(zzx zzx) {
            this(true);
        }

        /* access modifiers changed from: package-private */
        public abstract void zza() throws RemoteException;

        /* access modifiers changed from: protected */
        public void zzb() {
        }

        zza(boolean z) {
            this.zza = zzx.this.zza.currentTimeMillis();
            this.zzb = zzx.this.zza.elapsedRealtime();
            this.zzc = z;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.android.gms.internal.measurement.zzx.zza(com.google.android.gms.internal.measurement.zzx, java.lang.Exception, boolean, boolean):void
         arg types: [com.google.android.gms.internal.measurement.zzx, java.lang.Exception, int, boolean]
         candidates:
          com.google.android.gms.internal.measurement.zzx.zza(java.lang.String, java.lang.String, java.lang.Object, boolean):void
          com.google.android.gms.internal.measurement.zzx.zza(java.lang.String, java.lang.String, android.os.Bundle, long):void
          com.google.android.gms.internal.measurement.zzx.zza(com.google.android.gms.internal.measurement.zzx, java.lang.Exception, boolean, boolean):void */
        public void run() {
            if (zzx.this.zzp) {
                zzb();
                return;
            }
            try {
                zza();
            } catch (Exception e) {
                zzx.this.zza(e, false, this.zzc);
                zzb();
            }
        }
    }

    public static zzx zza(Context context, String str, String str2, String str3, Bundle bundle) {
        Preconditions.checkNotNull(context);
        if (zzb == null) {
            synchronized (zzx.class) {
                if (zzb == null) {
                    zzb = new zzx(context, str, str2, str3, bundle);
                }
            }
        }
        return zzb;
    }

    /* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.2.3 */
    static class zzb extends zzr {
        private final zzhn zza;

        zzb(zzhn zzhn) {
            this.zza = zzhn;
        }

        public final void zza(String str, String str2, Bundle bundle, long j) {
            this.zza.onEvent(str, str2, bundle, j);
        }

        public final int zza() {
            return System.identityHashCode(this.zza);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.2.3 */
    static class zzc extends zzr {
        private final zzho zza;

        zzc(zzho zzho) {
            this.zza = zzho;
        }

        public final void zza(String str, String str2, Bundle bundle, long j) {
            this.zza.interceptEvent(str, str2, bundle, j);
        }

        public final int zza() {
            return System.identityHashCode(this.zza);
        }
    }

    public final AppMeasurementSdk zza() {
        return this.zze;
    }

    private zzx(Context context, String str, String str2, String str3, Bundle bundle) {
        if (str == null || !zzc(str2, str3)) {
            this.zzc = "FA";
        } else {
            this.zzc = str;
        }
        this.zza = DefaultClock.getInstance();
        this.zzd = new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.zze = new AppMeasurementSdk(this);
        boolean z = false;
        if (!(!zzf(context) || zzk())) {
            this.zzq = null;
            this.zzp = true;
            Log.w(this.zzc, "Disabling data collection. Found google_app_id in strings.xml but Google Analytics for Firebase is missing. Remove this value or add Google Analytics for Firebase to resume data collection.");
            return;
        }
        if (!zzc(str2, str3)) {
            this.zzq = "fa";
            if (str2 == null || str3 == null) {
                if ((str2 == null) ^ (str3 == null ? true : z)) {
                    Log.w(this.zzc, "Specified origin or custom app id is null. Both parameters will be ignored.");
                }
            } else {
                Log.v(this.zzc, "Deferring to Google Analytics for Firebase for event data collection. https://goo.gl/J1sWQy");
            }
        } else {
            this.zzq = str2;
        }
        zza(new zzaa(this, str2, str3, context, bundle));
        Application application = (Application) context.getApplicationContext();
        if (application == null) {
            Log.w(this.zzc, "Unable to register lifecycle notifications. Application null.");
        } else {
            application.registerActivityLifecycleCallbacks(new zzd());
        }
    }

    private static boolean zzf(Context context) {
        try {
            GoogleServices.initialize(context);
            if (GoogleServices.getGoogleAppId() != null) {
                return true;
            }
            return false;
        } catch (IllegalStateException unused) {
        }
    }

    /* access modifiers changed from: private */
    public static boolean zzc(String str, String str2) {
        return (str2 == null || str == null || zzk()) ? false : true;
    }

    /* access modifiers changed from: private */
    public final void zza(zza zza2) {
        this.zzd.execute(zza2);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.measurement.zzx.zza(java.lang.Exception, boolean, boolean):void
     arg types: [com.google.android.gms.dynamite.DynamiteModule$LoadingException, int, int]
     candidates:
      com.google.android.gms.internal.measurement.zzx.zza(com.google.android.gms.internal.measurement.zzx, java.lang.String, java.lang.String):boolean
      com.google.android.gms.internal.measurement.zzx.zza(java.lang.String, java.lang.String, boolean):java.util.Map<java.lang.String, java.lang.Object>
      com.google.android.gms.internal.measurement.zzx.zza(android.app.Activity, java.lang.String, java.lang.String):void
      com.google.android.gms.internal.measurement.zzx.zza(java.lang.String, java.lang.String, android.os.Bundle):void
      com.google.android.gms.internal.measurement.zzx.zza(java.lang.String, java.lang.String, java.lang.Object):void
      com.google.android.gms.internal.measurement.zzx.zza(java.lang.Exception, boolean, boolean):void */
    /* access modifiers changed from: protected */
    public final zzm zza(Context context, boolean z) {
        DynamiteModule.VersionPolicy versionPolicy;
        if (z) {
            try {
                versionPolicy = DynamiteModule.PREFER_HIGHEST_OR_REMOTE_VERSION;
            } catch (DynamiteModule.LoadingException e) {
                zza((Exception) e, true, false);
                return null;
            }
        } else {
            versionPolicy = DynamiteModule.PREFER_LOCAL;
        }
        return zzl.asInterface(DynamiteModule.load(context, versionPolicy, ModuleDescriptor.MODULE_ID).instantiate("com.google.android.gms.measurement.internal.AppMeasurementDynamiteService"));
    }

    /* access modifiers changed from: private */
    public static int zzg(Context context) {
        return DynamiteModule.getRemoteVersion(context, ModuleDescriptor.MODULE_ID);
    }

    /* access modifiers changed from: private */
    public static int zzh(Context context) {
        return DynamiteModule.getLocalVersion(context, ModuleDescriptor.MODULE_ID);
    }

    /* access modifiers changed from: private */
    public final void zza(Exception exc, boolean z, boolean z2) {
        this.zzp |= z;
        if (z) {
            Log.w(this.zzc, "Data collection startup failed. No data will be collected.", exc);
            return;
        }
        if (z2) {
            zza(5, "Error with data collection. Data lost.", exc, (Object) null, (Object) null);
        }
        Log.w(this.zzc, "Error with data collection. Data lost.", exc);
    }

    private static boolean zzk() {
        try {
            Class.forName("com.google.firebase.analytics.FirebaseAnalytics");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public final void zza(zzho zzho) {
        zza(new zzaj(this, zzho));
    }

    public final void zza(zzhn zzhn) {
        Preconditions.checkNotNull(zzhn);
        zza(new zzaw(this, zzhn));
    }

    public final void zzb(zzhn zzhn) {
        Preconditions.checkNotNull(zzhn);
        zza(new zzax(this, zzhn));
    }

    public final void zza(String str, Bundle bundle) {
        zza(null, str, bundle, false, true, null);
    }

    public final void zza(String str, String str2, Bundle bundle) {
        zza(str, str2, bundle, true, true, null);
    }

    public final void zza(String str, String str2, Bundle bundle, long j) {
        zza(str, str2, bundle, true, false, Long.valueOf(j));
    }

    private final void zza(String str, String str2, Bundle bundle, boolean z, boolean z2, Long l) {
        zza(new zzba(this, l, str, str2, bundle, z, z2));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.measurement.zzx.zza(java.lang.String, java.lang.String, java.lang.Object, boolean):void
     arg types: [?[OBJECT, ARRAY], java.lang.String, java.lang.String, int]
     candidates:
      com.google.android.gms.internal.measurement.zzx.zza(com.google.android.gms.internal.measurement.zzx, java.lang.Exception, boolean, boolean):void
      com.google.android.gms.internal.measurement.zzx.zza(java.lang.String, java.lang.String, android.os.Bundle, long):void
      com.google.android.gms.internal.measurement.zzx.zza(java.lang.String, java.lang.String, java.lang.Object, boolean):void */
    public final void zza(String str, String str2) {
        zza((String) null, str, (Object) str2, false);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.measurement.zzx.zza(java.lang.String, java.lang.String, java.lang.Object, boolean):void
     arg types: [java.lang.String, java.lang.String, java.lang.Object, int]
     candidates:
      com.google.android.gms.internal.measurement.zzx.zza(com.google.android.gms.internal.measurement.zzx, java.lang.Exception, boolean, boolean):void
      com.google.android.gms.internal.measurement.zzx.zza(java.lang.String, java.lang.String, android.os.Bundle, long):void
      com.google.android.gms.internal.measurement.zzx.zza(java.lang.String, java.lang.String, java.lang.Object, boolean):void */
    public final void zza(String str, String str2, Object obj) {
        zza(str, str2, obj, true);
    }

    private final void zza(String str, String str2, Object obj, boolean z) {
        zza(new zzaz(this, str, str2, obj, z));
    }

    public final void zza(Bundle bundle) {
        zza(new zzbb(this, bundle));
    }

    public final void zzb(String str, String str2, Bundle bundle) {
        zza(new zzz(this, str, str2, bundle));
    }

    public final List<Bundle> zzb(String str, String str2) {
        zzk zzk2 = new zzk();
        zza(new zzac(this, str, str2, zzk2));
        List<Bundle> list = (List) zzk.zza(zzk2.zzb(5000), List.class);
        return list == null ? Collections.emptyList() : list;
    }

    public final void zza(String str) {
        zza(new zzab(this, str));
    }

    public final void zza(Activity activity, String str, String str2) {
        zza(new zzae(this, activity, str, str2));
    }

    public final void zza(boolean z) {
        zza(new zzad(this, z));
    }

    public final void zzb() {
        zza(new zzag(this));
    }

    public final void zza(long j) {
        zza(new zzaf(this, j));
    }

    public final void zzb(long j) {
        zza(new zzai(this, j));
    }

    public final void zzb(String str) {
        zza(new zzah(this, str));
    }

    public final void zzc(String str) {
        zza(new zzak(this, str));
    }

    public final String zzc() {
        zzk zzk2 = new zzk();
        zza(new zzam(this, zzk2));
        return zzk2.zza(500);
    }

    public final String zzd() {
        zzk zzk2 = new zzk();
        zza(new zzal(this, zzk2));
        return zzk2.zza(50);
    }

    public final long zze() {
        zzk zzk2 = new zzk();
        zza(new zzao(this, zzk2));
        Long l = (Long) zzk.zza(zzk2.zzb(500), Long.class);
        if (l != null) {
            return l.longValue();
        }
        long nextLong = new Random(System.nanoTime() ^ this.zza.currentTimeMillis()).nextLong();
        int i = this.zzg + 1;
        this.zzg = i;
        return nextLong + ((long) i);
    }

    public final String zzf() {
        zzk zzk2 = new zzk();
        zza(new zzan(this, zzk2));
        return zzk2.zza(500);
    }

    public final String zzg() {
        zzk zzk2 = new zzk();
        zza(new zzaq(this, zzk2));
        return zzk2.zza(500);
    }

    public final Map<String, Object> zza(String str, String str2, boolean z) {
        zzk zzk2 = new zzk();
        zza(new zzap(this, str, str2, z, zzk2));
        Bundle zzb2 = zzk2.zzb(5000);
        if (zzb2 == null || zzb2.size() == 0) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap(zzb2.size());
        for (String next : zzb2.keySet()) {
            Object obj = zzb2.get(next);
            if ((obj instanceof Double) || (obj instanceof Long) || (obj instanceof String)) {
                hashMap.put(next, obj);
            }
        }
        return hashMap;
    }

    public final void zza(int i, String str, Object obj, Object obj2, Object obj3) {
        zza(new zzas(this, false, 5, str, obj, null, null));
    }

    public final Bundle zza(Bundle bundle, boolean z) {
        zzk zzk2 = new zzk();
        zza(new zzar(this, bundle, zzk2));
        if (z) {
            return zzk2.zzb(5000);
        }
        return null;
    }

    public final int zzd(String str) {
        zzk zzk2 = new zzk();
        zza(new zzau(this, str, zzk2));
        Integer num = (Integer) zzk.zza(zzk2.zzb(WorkRequest.MIN_BACKOFF_MILLIS), Integer.class);
        if (num == null) {
            return 25;
        }
        return num.intValue();
    }

    public final String zzh() {
        zzk zzk2 = new zzk();
        zza(new zzat(this, zzk2));
        return zzk2.zza(120000);
    }

    public final String zzi() {
        return this.zzq;
    }

    public final Object zza(int i) {
        zzk zzk2 = new zzk();
        zza(new zzav(this, zzk2, i));
        return zzk.zza(zzk2.zzb(15000), Object.class);
    }

    public final void zzb(boolean z) {
        zza(new zzay(this, z));
    }

    /* access modifiers changed from: private */
    public static void zzi(Context context) {
        synchronized (zzx.class) {
            try {
                if (zzh != null && zzi != null) {
                    return;
                }
                if (zza(context, "app_measurement_internal_disable_startup_flags")) {
                    zzh = false;
                    zzi = false;
                    return;
                }
                SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
                zzh = Boolean.valueOf(sharedPreferences.getBoolean(zzl, false));
                zzi = Boolean.valueOf(sharedPreferences.getBoolean(zzm, false));
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.remove(zzl);
                edit.remove(zzm);
                edit.apply();
            } catch (Exception e) {
                Log.e("FA", "Exception reading flag from SharedPreferences.", e);
                zzh = false;
                zzi = false;
            }
        }
    }

    public static boolean zzb(Context context) {
        zzi(context);
        synchronized (zzx.class) {
            if (!zzj) {
                try {
                    String str = (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, "measurement.dynamite.enabled", "");
                    if ("true".equals(str)) {
                        zzk = true;
                    } else if ("false".equals(str)) {
                        zzk = false;
                    } else {
                        zzk = null;
                    }
                    zzj = true;
                } catch (Exception e) {
                    try {
                        Log.e("FA", "Unable to call SystemProperties.get()", e);
                        zzk = null;
                    } finally {
                        zzj = true;
                    }
                }
            }
        }
        Boolean bool = zzk;
        if (bool == null) {
            bool = zzh;
        }
        return bool.booleanValue();
    }

    private static boolean zza(Context context, String str) {
        Preconditions.checkNotEmpty(str);
        try {
            ApplicationInfo applicationInfo = Wrappers.packageManager(context).getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null) {
                if (applicationInfo.metaData != null) {
                    return applicationInfo.metaData.getBoolean(str);
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }
}
