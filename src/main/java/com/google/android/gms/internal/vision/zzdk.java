package com.google.android.gms.internal.vision;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
final class zzdk<K, V> extends zzdj<Map.Entry<K, V>> {
    /* access modifiers changed from: private */
    public final transient int size;
    private final transient zzdg<K, V> zzlw;
    /* access modifiers changed from: private */
    public final transient Object[] zzlx;
    private final transient int zzly = 0;

    zzdk(zzdg<K, V> zzdg, Object[] objArr, int i, int i2) {
        this.zzlw = zzdg;
        this.zzlx = objArr;
        this.size = i2;
    }

    public final zzdr<Map.Entry<K, V>> zzby() {
        return (zzdr) zzcc().iterator();
    }

    /* access modifiers changed from: package-private */
    public final int zza(Object[] objArr, int i) {
        return zzcc().zza(objArr, i);
    }

    /* access modifiers changed from: package-private */
    public final zzdf<Map.Entry<K, V>> zzch() {
        return new zzdn(this);
    }

    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value == null || !value.equals(this.zzlw.get(key))) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int size() {
        return this.size;
    }

    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }
}
