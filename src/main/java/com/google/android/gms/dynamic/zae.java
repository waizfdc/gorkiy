package com.google.android.gms.dynamic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.DeferredLifecycleHelper;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
final class zae implements DeferredLifecycleHelper.zaa {
    private final /* synthetic */ ViewGroup val$container;
    private final /* synthetic */ DeferredLifecycleHelper zart;
    private final /* synthetic */ Bundle zary;
    private final /* synthetic */ FrameLayout zasb;
    private final /* synthetic */ LayoutInflater zasc;

    zae(DeferredLifecycleHelper deferredLifecycleHelper, FrameLayout frameLayout, LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.zart = deferredLifecycleHelper;
        this.zasb = frameLayout;
        this.zasc = layoutInflater;
        this.val$container = viewGroup;
        this.zary = bundle;
    }

    public final int getState() {
        return 2;
    }

    public final void zaa(LifecycleDelegate lifecycleDelegate) {
        this.zasb.removeAllViews();
        this.zasb.addView(this.zart.zaru.onCreateView(this.zasc, this.val$container, this.zary));
    }
}
