package com.google.android.gms.internal.vision;

import android.content.Context;
import android.database.ContentObserver;
import android.util.Log;
import androidx.core.content.PermissionChecker;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
final class zzav implements zzau {
    private static zzav zzfr;
    @Nullable
    private final Context zze;
    @Nullable
    private final ContentObserver zzfl;

    static zzav zze(Context context) {
        zzav zzav;
        synchronized (zzav.class) {
            if (zzfr == null) {
                zzfr = PermissionChecker.checkSelfPermission(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0 ? new zzav(context) : new zzav();
            }
            zzav = zzfr;
        }
        return zzav;
    }

    private zzav(Context context) {
        this.zze = context;
        this.zzfl = new zzax(this, null);
        context.getContentResolver().registerContentObserver(zzal.CONTENT_URI, true, this.zzfl);
    }

    private zzav() {
        this.zze = null;
        this.zzfl = null;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzc */
    public final String zzb(String str) {
        if (this.zze == null) {
            return null;
        }
        try {
            return (String) zzat.zza(new zzay(this, str));
        } catch (IllegalStateException | SecurityException e) {
            String valueOf = String.valueOf(str);
            Log.e("GservicesLoader", valueOf.length() != 0 ? "Unable to read GServices for: ".concat(valueOf) : new String("Unable to read GServices for: "), e);
            return null;
        }
    }

    static synchronized void zzaa() {
        synchronized (zzav.class) {
            if (!(zzfr == null || zzfr.zze == null || zzfr.zzfl == null)) {
                zzfr.zze.getContentResolver().unregisterContentObserver(zzfr.zzfl);
            }
            zzfr = null;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ String zzd(String str) {
        return zzal.zza(this.zze.getContentResolver(), str, (String) null);
    }
}
