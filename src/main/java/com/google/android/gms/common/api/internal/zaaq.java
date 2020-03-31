package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
final class zaaq extends zaau {
    private final /* synthetic */ zaak zafz;
    private final ArrayList<Api.Client> zags;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zaaq(zaak zaak, ArrayList<Api.Client> arrayList) {
        super(zaak, null);
        this.zafz = zaak;
        this.zags = arrayList;
    }

    public final void zaal() {
        this.zafz.zafv.zaeh.zahe = this.zafz.zaar();
        ArrayList arrayList = this.zags;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((Api.Client) obj).getRemoteService(this.zafz.zagj, this.zafz.zafv.zaeh.zahe);
        }
    }
}
