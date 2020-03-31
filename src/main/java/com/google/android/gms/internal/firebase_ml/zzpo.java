package com.google.android.gms.internal.firebase_ml;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import androidx.core.os.ConfigurationCompat;
import androidx.core.os.LocaleListCompat;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_ml.zzng;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.Dependency;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public final class zzpo {
    private static final GmsLogger zzbbo = new GmsLogger("MlStatsLogger", "");
    private static List<String> zzbcf;
    private static boolean zzbcr = false;
    private static boolean zzbcs = false;
    public static final Component<?> zzbcu = Component.builder(zza.class).add(Dependency.required(zzpn.class)).add(Dependency.required(Context.class)).add(Dependency.required(zzqc.class)).add(Dependency.required(zzb.class)).factory(zzps.zzbbm).build();
    private final String zzbcg;
    private final String zzbch;
    private final String zzbci;
    private final String zzbcj;
    private final String zzbck;
    private final zzb zzbcl;
    private final zzqc zzbcm;
    private final Task<String> zzbcn;
    private final Task<String> zzbco;
    private final Map<zznu, Long> zzbcp;
    private final Map<zznu, Object> zzbcq;
    private final int zzbct;

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    public interface zzb {
        void zza(zzng.zzab zzab);
    }

    private zzpo(zzpn zzpn, Context context, zzqc zzqc, zzb zzb2, int i) {
        String apiKey;
        String gcmSenderId;
        String projectId;
        this.zzbcp = new HashMap();
        this.zzbcq = new HashMap();
        this.zzbct = i;
        FirebaseApp zznq = zzpn.zznq();
        String str = "";
        this.zzbci = (zznq == null || (projectId = zznq.getOptions().getProjectId()) == null) ? str : projectId;
        FirebaseApp zznq2 = zzpn.zznq();
        this.zzbcj = (zznq2 == null || (gcmSenderId = zznq2.getOptions().getGcmSenderId()) == null) ? str : gcmSenderId;
        FirebaseApp zznq3 = zzpn.zznq();
        if (!(zznq3 == null || (apiKey = zznq3.getOptions().getApiKey()) == null)) {
            str = apiKey;
        }
        this.zzbck = str;
        this.zzbcg = context.getPackageName();
        this.zzbch = zzpb.zza(context);
        this.zzbcm = zzqc;
        this.zzbcl = zzb2;
        this.zzbcn = zzpf.zzno().zza(zzpr.zzbcy);
        zzpf zzno = zzpf.zzno();
        zzqc.getClass();
        this.zzbco = zzno.zza(zzpq.zza(zzqc));
    }

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    public static class zza extends zzpa<Integer, zzpo> {
        private final zzb zzbcl;
        private final zzqc zzbcm;
        private final zzpn zzbdc;
        private final Context zzbdd;

        private zza(zzpn zzpn, Context context, zzqc zzqc, zzb zzb) {
            this.zzbdc = zzpn;
            this.zzbdd = context;
            this.zzbcm = zzqc;
            this.zzbcl = zzb;
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object create(Object obj) {
            return new zzpo(this.zzbdc, this.zzbdd, this.zzbcm, this.zzbcl, ((Integer) obj).intValue());
        }
    }

    public static zzpo zza(zzpn zzpn, int i) {
        Preconditions.checkNotNull(zzpn);
        return (zzpo) ((zza) zzpn.get(zza.class)).get(Integer.valueOf(i));
    }

    public final void zza(zzng.zzab.zza zza2, zznu zznu) {
        zzpf.zznn().execute(new zzpt(this, zza2, zznu));
    }

    public final void zza(zzpw zzpw, zznu zznu) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean z = true;
        if (!zzfv() || (this.zzbcp.get(zznu) != null && elapsedRealtime - this.zzbcp.get(zznu).longValue() <= TimeUnit.SECONDS.toMillis(30))) {
            z = false;
        }
        if (z) {
            this.zzbcp.put(zznu, Long.valueOf(elapsedRealtime));
            zza(zzpw.zznt(), zznu);
        }
    }

    public final <K> void zza(K k, long j, zznu zznu, zzpu<K> zzpu) {
        zzfv();
    }

    private final boolean zzfv() {
        int i = this.zzbct;
        if (i == 1) {
            return this.zzbcm.zzny();
        }
        if (i != 2) {
            return i == 3 || i == 4 || i == 5;
        }
        return this.zzbcm.zznz();
    }

    private static synchronized List<String> zznr() {
        synchronized (zzpo.class) {
            if (zzbcf != null) {
                List<String> list = zzbcf;
                return list;
            }
            LocaleListCompat locales = ConfigurationCompat.getLocales(Resources.getSystem().getConfiguration());
            zzbcf = new ArrayList(locales.size());
            for (int i = 0; i < locales.size(); i++) {
                zzbcf.add(zzpb.zza(locales.get(i)));
            }
            List<String> list2 = zzbcf;
            return list2;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(zzng.zzab.zza zza2, zznu zznu) {
        String str;
        if (!zzfv()) {
            zzbbo.d("MlStatsLogger", "Logging is disabled.");
            return;
        }
        String zzng = zza2.zzlm().zzng();
        if ("NA".equals(zzng) || "".equals(zzng)) {
            zzng = "NA";
        }
        zzng.zzaw.zza zzx = zzng.zzaw.zznh().zzbo(this.zzbcg).zzbp(this.zzbch).zzbq(this.zzbci).zzbt(this.zzbcj).zzbu(this.zzbck).zzbs(zzng).zzx(zznr());
        if (this.zzbcn.isSuccessful()) {
            str = this.zzbcn.getResult();
        } else {
            str = zzpd.zznm().getVersion("firebase-ml-common");
        }
        zza2.zzb(zznu).zza(zzx.zzbr(str));
        try {
            this.zzbcl.zza((zzng.zzab) ((zzvx) zza2.zztx()));
        } catch (RuntimeException e) {
            zzbbo.e("MlStatsLogger", "Exception thrown from the logging side", e);
        }
    }

    static final /* synthetic */ zza zzc(ComponentContainer componentContainer) {
        return new zza((zzpn) componentContainer.get(zzpn.class), (Context) componentContainer.get(Context.class), (zzqc) componentContainer.get(zzqc.class), (zzb) componentContainer.get(zzb.class));
    }
}
