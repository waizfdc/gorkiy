package com.google.android.gms.internal.firebase_ml;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.text.Typography;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public final class zzgm extends zziy {
    private static final zzjr zzzd = new zzju("=&-_.!~*'()@:$,;/?:", false);
    private String fragment;
    private int port;
    private String zzze;
    private String zzzf;
    private String zzzg;
    private List<String> zzzh;

    public zzgm() {
        this.port = -1;
    }

    public zzgm(String str) {
        this(zzw(str));
    }

    public zzgm(URL url) {
        this(url.getProtocol(), url.getHost(), url.getPort(), url.getPath(), url.getRef(), url.getQuery(), url.getUserInfo());
    }

    private zzgm(String str, String str2, int i, String str3, String str4, String str5, String str6) {
        this.port = -1;
        this.zzze = str.toLowerCase(Locale.US);
        this.zzzf = str2;
        this.port = i;
        this.zzzh = zzv(str3);
        String str7 = null;
        this.fragment = str4 != null ? zzjs.zzar(str4) : null;
        if (str5 != null) {
            zzhj.zze(str5, this);
        }
        this.zzzg = str6 != null ? zzjs.zzar(str6) : str7;
    }

    public final int hashCode() {
        return zzfq().hashCode();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj) || !(obj instanceof zzgm)) {
            return false;
        }
        return zzfq().equals(((zzgm) obj).zzfq());
    }

    public final String toString() {
        return zzfq();
    }

    public final String zzfq() {
        StringBuilder sb = new StringBuilder();
        sb.append((String) zzmf.checkNotNull(this.zzze));
        sb.append("://");
        String str = this.zzzg;
        if (str != null) {
            sb.append(zzjs.zzau(str));
            sb.append('@');
        }
        sb.append((String) zzmf.checkNotNull(this.zzzf));
        int i = this.port;
        if (i != -1) {
            sb.append(':');
            sb.append(i);
        }
        String valueOf = String.valueOf(sb.toString());
        StringBuilder sb2 = new StringBuilder();
        List<String> list = this.zzzh;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                String str2 = this.zzzh.get(i2);
                if (i2 != 0) {
                    sb2.append('/');
                }
                if (str2.length() != 0) {
                    sb2.append(zzjs.zzas(str2));
                }
            }
        }
        zza(entrySet(), sb2);
        String str3 = this.fragment;
        if (str3 != null) {
            sb2.append('#');
            sb2.append(zzzd.zzap(str3));
        }
        String valueOf2 = String.valueOf(sb2.toString());
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    public final URL zzt(String str) {
        try {
            return new URL(zzw(zzfq()), str);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public final void zzu(String str) {
        this.zzzh = zzv(null);
    }

    private static List<String> zzv(String str) {
        String str2;
        if (str == null || str.length() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        boolean z = true;
        while (z) {
            int indexOf = str.indexOf(47, i);
            boolean z2 = indexOf != -1;
            if (z2) {
                str2 = str.substring(i, indexOf);
            } else {
                str2 = str.substring(i);
            }
            arrayList.add(zzjs.zzar(str2));
            i = indexOf + 1;
            z = z2;
        }
        return arrayList;
    }

    static void zza(Set<Map.Entry<String, Object>> set, StringBuilder sb) {
        boolean z = true;
        for (Map.Entry next : set) {
            Object value = next.getValue();
            if (value != null) {
                String zzav = zzjs.zzav((String) next.getKey());
                if (value instanceof Collection) {
                    for (Object zza : (Collection) value) {
                        z = zza(z, sb, zzav, zza);
                    }
                } else {
                    z = zza(z, sb, zzav, value);
                }
            }
        }
    }

    private static boolean zza(boolean z, StringBuilder sb, String str, Object obj) {
        if (z) {
            z = false;
            sb.append('?');
        } else {
            sb.append((char) Typography.amp);
        }
        sb.append(str);
        String zzav = zzjs.zzav(obj.toString());
        if (zzav.length() != 0) {
            sb.append('=');
            sb.append(zzav);
        }
        return z;
    }

    private static URL zzw(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public final /* synthetic */ zziy zzfb() {
        return (zzgm) clone();
    }

    public final /* synthetic */ zziy zzb(String str, Object obj) {
        return (zzgm) super.zzb(str, obj);
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzgm zzgm = (zzgm) super.clone();
        if (this.zzzh != null) {
            zzgm.zzzh = new ArrayList(this.zzzh);
        }
        return zzgm;
    }
}
