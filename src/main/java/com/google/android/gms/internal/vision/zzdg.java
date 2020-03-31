package com.google.android.gms.internal.vision;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
public abstract class zzdg<K, V> implements Serializable, Map<K, V> {
    private static final Map.Entry<?, ?>[] zzlo = new Map.Entry[0];
    private transient zzdj<Map.Entry<K, V>> zzlp;
    private transient zzdj<K> zzlq;
    private transient zzdc<V> zzlr;

    public static <K, V> zzdg<K, V> zza(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        zzda.zza(k, v);
        zzda.zza(k2, v2);
        zzda.zza(k3, v3);
        zzda.zza(k4, v4);
        return zzdl.zza(4, new Object[]{k, v, k2, v2, k3, v3, k4, v4});
    }

    public abstract V get(@NullableDecl Object obj);

    /* access modifiers changed from: package-private */
    public abstract zzdj<Map.Entry<K, V>> zzce();

    /* access modifiers changed from: package-private */
    public abstract zzdj<K> zzcf();

    /* access modifiers changed from: package-private */
    public abstract zzdc<V> zzcg();

    zzdg() {
    }

    @Deprecated
    public final V put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean containsKey(@NullableDecl Object obj) {
        return get(obj) != null;
    }

    public boolean containsValue(@NullableDecl Object obj) {
        return ((zzdc) values()).contains(obj);
    }

    public final V getOrDefault(@NullableDecl Object obj, @NullableDecl V v) {
        V v2 = get(obj);
        return v2 != null ? v2 : v;
    }

    public boolean equals(@NullableDecl Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    public int hashCode() {
        return zzdo.zza((zzdj) entrySet());
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.min(long, long):long}
     arg types: [long, int]
     candidates:
      ClspMth{java.lang.Math.min(double, double):double}
      ClspMth{java.lang.Math.min(float, float):float}
      ClspMth{java.lang.Math.min(int, int):int}
      ClspMth{java.lang.Math.min(long, long):long} */
    public String toString() {
        int size = size();
        if (size >= 0) {
            StringBuilder sb = new StringBuilder((int) Math.min(((long) size) << 3, 1073741824L));
            sb.append('{');
            boolean z = true;
            for (Map.Entry entry : entrySet()) {
                if (!z) {
                    sb.append(", ");
                }
                z = false;
                sb.append(entry.getKey());
                sb.append('=');
                sb.append(entry.getValue());
            }
            sb.append('}');
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder("size".length() + 40);
        sb2.append("size");
        sb2.append(" cannot be negative but was: ");
        sb2.append(size);
        throw new IllegalArgumentException(sb2.toString());
    }

    public /* synthetic */ Set entrySet() {
        zzdj<Map.Entry<K, V>> zzdj = this.zzlp;
        if (zzdj != null) {
            return zzdj;
        }
        zzdj<Map.Entry<K, V>> zzce = zzce();
        this.zzlp = zzce;
        return zzce;
    }

    public /* synthetic */ Collection values() {
        zzdc<V> zzdc = this.zzlr;
        if (zzdc != null) {
            return zzdc;
        }
        zzdc<V> zzcg = zzcg();
        this.zzlr = zzcg;
        return zzcg;
    }

    public /* synthetic */ Set keySet() {
        zzdj<K> zzdj = this.zzlq;
        if (zzdj != null) {
            return zzdj;
        }
        zzdj<K> zzcf = zzcf();
        this.zzlq = zzcf;
        return zzcf;
    }
}
