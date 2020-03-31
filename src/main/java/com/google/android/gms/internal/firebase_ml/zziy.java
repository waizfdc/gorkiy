package com.google.android.gms.internal.firebase_ml;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public class zziy extends AbstractMap<String, Object> implements Cloneable {
    Map<String, Object> zzafe;
    final zzir zzzm;

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    public enum zzc {
        IGNORE_CASE
    }

    public zziy() {
        this(EnumSet.noneOf(zzc.class));
    }

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    final class zza extends AbstractSet<Map.Entry<String, Object>> {
        private final zzix zzafi;

        zza() {
            this.zzafi = (zzix) new zzis(zziy.this, zziy.this.zzzm.zzhv()).entrySet();
        }

        public final Iterator<Map.Entry<String, Object>> iterator() {
            return new zzb(zziy.this, this.zzafi);
        }

        public final int size() {
            return zziy.this.zzafe.size() + this.zzafi.size();
        }

        public final void clear() {
            zziy.this.zzafe.clear();
            this.zzafi.clear();
        }
    }

    public zziy(EnumSet<zzc> enumSet) {
        this.zzafe = new zzil();
        this.zzzm = zzir.zza(getClass(), enumSet.contains(zzc.IGNORE_CASE));
    }

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    final class zzb implements Iterator<Map.Entry<String, Object>> {
        private boolean zzafk;
        private final Iterator<Map.Entry<String, Object>> zzafl;
        private final Iterator<Map.Entry<String, Object>> zzafm;

        zzb(zziy zziy, zzix zzix) {
            this.zzafl = (zziu) zzix.iterator();
            this.zzafm = zziy.zzafe.entrySet().iterator();
        }

        public final boolean hasNext() {
            return this.zzafl.hasNext() || this.zzafm.hasNext();
        }

        public final void remove() {
            if (this.zzafk) {
                this.zzafm.remove();
            }
            this.zzafl.remove();
        }

        public final /* synthetic */ Object next() {
            if (!this.zzafk) {
                if (this.zzafl.hasNext()) {
                    return this.zzafl.next();
                }
                this.zzafk = true;
            }
            return this.zzafm.next();
        }
    }

    public final Object get(Object obj) {
        if (!(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        zziz zzan = this.zzzm.zzan(str);
        if (zzan != null) {
            return zzan.zzh(this);
        }
        if (this.zzzm.zzhv()) {
            str = str.toLowerCase(Locale.US);
        }
        return this.zzafe.get(str);
    }

    /* renamed from: zzf */
    public final Object put(String str, Object obj) {
        zziz zzan = this.zzzm.zzan(str);
        if (zzan != null) {
            Object zzh = zzan.zzh(this);
            zzan.zzb(this, obj);
            return zzh;
        }
        if (this.zzzm.zzhv()) {
            str = str.toLowerCase(Locale.US);
        }
        return this.zzafe.put(str, obj);
    }

    public zziy zzb(String str, Object obj) {
        zziz zzan = this.zzzm.zzan(str);
        if (zzan != null) {
            zzan.zzb(this, obj);
        } else {
            if (this.zzzm.zzhv()) {
                str = str.toLowerCase(Locale.US);
            }
            this.zzafe.put(str, obj);
        }
        return this;
    }

    public final void putAll(Map<? extends String, ?> map) {
        for (Map.Entry next : map.entrySet()) {
            zzb((String) next.getKey(), next.getValue());
        }
    }

    public final Object remove(Object obj) {
        if (!(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        if (this.zzzm.zzan(str) == null) {
            if (this.zzzm.zzhv()) {
                str = str.toLowerCase(Locale.US);
            }
            return this.zzafe.remove(str);
        }
        throw new UnsupportedOperationException();
    }

    public Set<Map.Entry<String, Object>> entrySet() {
        return new zza();
    }

    /* renamed from: zzfb */
    public zziy clone() {
        try {
            zziy zziy = (zziy) super.clone();
            zzit.zza(this, zziy);
            zziy.zzafe = (Map) zzit.clone(this.zzafe);
            return zziy;
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException(e);
        }
    }

    public final zzir zzhy() {
        return this.zzzm;
    }
}
