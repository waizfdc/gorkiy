package com.google.android.gms.internal.vision;

import android.os.Binder;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
public final /* synthetic */ class zzat {
    public static <V> V zza(zzaw<V> zzaw) {
        long clearCallingIdentity;
        try {
            return zzaw.zzt();
        } catch (SecurityException unused) {
            clearCallingIdentity = Binder.clearCallingIdentity();
            V zzt = zzaw.zzt();
            Binder.restoreCallingIdentity(clearCallingIdentity);
            return zzt;
        } catch (Throwable th) {
            Binder.restoreCallingIdentity(clearCallingIdentity);
            throw th;
        }
    }
}
