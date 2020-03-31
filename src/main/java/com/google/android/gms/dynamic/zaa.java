package com.google.android.gms.dynamic;

import android.os.Bundle;
import com.google.android.gms.dynamic.DeferredLifecycleHelper;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
final class zaa implements OnDelegateCreatedListener<T> {
    private final /* synthetic */ DeferredLifecycleHelper zart;

    zaa(DeferredLifecycleHelper deferredLifecycleHelper) {
        this.zart = deferredLifecycleHelper;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.dynamic.DeferredLifecycleHelper.zaa(com.google.android.gms.dynamic.DeferredLifecycleHelper, com.google.android.gms.dynamic.LifecycleDelegate):com.google.android.gms.dynamic.LifecycleDelegate
     arg types: [com.google.android.gms.dynamic.DeferredLifecycleHelper, T]
     candidates:
      com.google.android.gms.dynamic.DeferredLifecycleHelper.zaa(com.google.android.gms.dynamic.DeferredLifecycleHelper, android.os.Bundle):android.os.Bundle
      com.google.android.gms.dynamic.DeferredLifecycleHelper.zaa(android.os.Bundle, com.google.android.gms.dynamic.DeferredLifecycleHelper$zaa):void
      com.google.android.gms.dynamic.DeferredLifecycleHelper.zaa(com.google.android.gms.dynamic.DeferredLifecycleHelper, com.google.android.gms.dynamic.LifecycleDelegate):com.google.android.gms.dynamic.LifecycleDelegate */
    public final void onDelegateCreated(T t) {
        LifecycleDelegate unused = this.zart.zaru = (LifecycleDelegate) t;
        Iterator it = this.zart.zarw.iterator();
        while (it.hasNext()) {
            ((DeferredLifecycleHelper.zaa) it.next()).zaa(this.zart.zaru);
        }
        this.zart.zarw.clear();
        Bundle unused2 = this.zart.zarv = null;
    }
}
