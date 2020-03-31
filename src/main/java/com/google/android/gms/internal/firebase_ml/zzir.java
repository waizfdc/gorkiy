package com.google.android.gms.internal.firebase_ml;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public final class zzir {
    private static final ConcurrentMap<Class<?>, zzir> zzadz = new ConcurrentHashMap();
    private static final ConcurrentMap<Class<?>, zzir> zzaea = new ConcurrentHashMap();
    private final Class<?> zzaeb;
    private final boolean zzaec;
    private final IdentityHashMap<String, zziz> zzaed = new IdentityHashMap<>();
    final List<String> zzaee;

    public static zzir zzc(Class<?> cls) {
        return zza(cls, false);
    }

    public static zzir zza(Class<?> cls, boolean z) {
        if (cls == null) {
            return null;
        }
        ConcurrentMap<Class<?>, zzir> concurrentMap = z ? zzaea : zzadz;
        zzir zzir = (zzir) concurrentMap.get(cls);
        if (zzir != null) {
            return zzir;
        }
        zzir zzir2 = new zzir(cls, z);
        zzir zzir3 = (zzir) concurrentMap.putIfAbsent(cls, zzir2);
        return zzir3 == null ? zzir2 : zzir3;
    }

    public final boolean zzhv() {
        return this.zzaec;
    }

    public final zziz zzan(String str) {
        if (str != null) {
            if (this.zzaec) {
                str = str.toLowerCase(Locale.US);
            }
            str = str.intern();
        }
        return this.zzaed.get(str);
    }

    public final boolean isEnum() {
        return this.zzaeb.isEnum();
    }

    private zzir(Class<?> cls, boolean z) {
        Field field;
        this.zzaeb = cls;
        this.zzaec = z;
        boolean z2 = !z || !cls.isEnum();
        String valueOf = String.valueOf(cls);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 31);
        sb.append("cannot ignore case on an enum: ");
        sb.append(valueOf);
        zzmf.checkArgument(z2, sb.toString());
        TreeSet treeSet = new TreeSet(new zziq(this));
        for (Field field2 : cls.getDeclaredFields()) {
            zziz zza = zziz.zza(field2);
            if (zza != null) {
                String name = zza.getName();
                name = z ? name.toLowerCase(Locale.US).intern() : name;
                zziz zziz = this.zzaed.get(name);
                boolean z3 = zziz == null;
                Object[] objArr = new Object[4];
                objArr[0] = z ? "case-insensitive " : "";
                objArr[1] = name;
                objArr[2] = field2;
                if (zziz == null) {
                    field = null;
                } else {
                    field = zziz.zzhz();
                }
                objArr[3] = field;
                if (z3) {
                    this.zzaed.put(name, zza);
                    treeSet.add(name);
                } else {
                    throw new IllegalArgumentException(zzmn.zzb("two fields have the same %sname <%s>: %s and %s", objArr));
                }
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass != null) {
            zzir zza2 = zza(superclass, z);
            treeSet.addAll(zza2.zzaee);
            for (Map.Entry next : zza2.zzaed.entrySet()) {
                String str = (String) next.getKey();
                if (!this.zzaed.containsKey(str)) {
                    this.zzaed.put(str, (zziz) next.getValue());
                }
            }
        }
        this.zzaee = treeSet.isEmpty() ? Collections.emptyList() : Collections.unmodifiableList(new ArrayList(treeSet));
    }

    public final Collection<zziz> zzhw() {
        return Collections.unmodifiableCollection(this.zzaed.values());
    }
}
