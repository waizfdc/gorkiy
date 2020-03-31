package com.askgps.personaltrackercore.utils;

import android.content.Context;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u000eH&J\b\u0010\u0010\u001a\u00020\u000eH&J\b\u0010\u0011\u001a\u00020\u000eH&J\b\u0010\u0012\u001a\u00020\u000eH\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/askgps/personaltrackercore/utils/Utils;", "", "()V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "listenerIsStart", "", "getListenerIsStart", "()Z", "setListenerIsStart", "(Z)V", "onCreate", "", "onDestroy", "onPause", "onResume", "registerSensorListener", "unregisterSensorListener", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: Utils.kt */
public abstract class Utils {
    private volatile boolean listenerIsStart;

    public abstract Context getContext();

    public abstract void onCreate();

    public abstract void onDestroy();

    public abstract void onPause();

    public abstract void onResume();

    public void registerSensorListener() {
    }

    public void unregisterSensorListener() {
    }

    /* access modifiers changed from: protected */
    public final boolean getListenerIsStart() {
        return this.listenerIsStart;
    }

    /* access modifiers changed from: protected */
    public final void setListenerIsStart(boolean z) {
        this.listenerIsStart = z;
    }
}
