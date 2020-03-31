package com.google.android.gms.common.api.internal;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
final class zaco implements zacq {
    private final /* synthetic */ zacp zala;

    zaco(zacp zacp) {
        this.zala = zacp;
    }

    public final void zab(BasePendingResult<?> basePendingResult) {
        this.zala.zald.remove(basePendingResult);
        basePendingResult.zal();
    }
}
