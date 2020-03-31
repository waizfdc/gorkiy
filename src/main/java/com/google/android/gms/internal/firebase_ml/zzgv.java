package com.google.android.gms.internal.firebase_ml;

import io.fabric.sdk.android.services.network.HttpRequest;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public final class zzgv {
    private static final Pattern zzaae = Pattern.compile("[\\w!#$&.+\\-\\^_]+|[*]");
    private static final Pattern zzaaf = Pattern.compile("[\\p{ASCII}&&[^\\p{Cntrl} ;/=\\[\\]\\(\\)\\<\\>\\@\\,\\:\\\"\\?\\=]]+");
    private static final Pattern zzaag;
    private static final Pattern zzaah;
    private String type = "application";
    private String zzaai = "octet-stream";
    private final SortedMap<String, String> zzaaj = new TreeMap();
    private String zzaak;

    public zzgv(String str) {
        Matcher matcher = zzaag.matcher(str);
        zzmf.checkArgument(matcher.matches(), "Type must be in the 'maintype/subtype; parameter=value' format");
        String group = matcher.group(1);
        zzmf.checkArgument(zzaae.matcher(group).matches(), "Type contains reserved characters");
        this.type = group;
        this.zzaak = null;
        String group2 = matcher.group(2);
        zzmf.checkArgument(zzaae.matcher(group2).matches(), "Subtype contains reserved characters");
        this.zzaai = group2;
        this.zzaak = null;
        String group3 = matcher.group(3);
        if (group3 != null) {
            Matcher matcher2 = zzaah.matcher(group3);
            while (matcher2.find()) {
                String group4 = matcher2.group(1);
                String group5 = matcher2.group(3);
                if (group5 == null) {
                    group5 = matcher2.group(2);
                }
                zza(group4, group5);
            }
        }
    }

    private final zzgv zza(String str, String str2) {
        if (str2 == null) {
            this.zzaak = null;
            this.zzaaj.remove(str.toLowerCase(Locale.US));
            return this;
        }
        zzmf.checkArgument(zzaaf.matcher(str).matches(), "Name contains reserved characters");
        this.zzaak = null;
        this.zzaaj.put(str.toLowerCase(Locale.US), str2);
        return this;
    }

    static boolean zzaf(String str) {
        return zzaaf.matcher(str).matches();
    }

    public final String zzfq() {
        String str = this.zzaak;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.type);
        sb.append('/');
        sb.append(this.zzaai);
        SortedMap<String, String> sortedMap = this.zzaaj;
        if (sortedMap != null) {
            for (Map.Entry next : sortedMap.entrySet()) {
                String str2 = (String) next.getValue();
                sb.append("; ");
                sb.append((String) next.getKey());
                sb.append("=");
                if (!zzaf(str2)) {
                    String replace = str2.replace("\\", "\\\\").replace("\"", "\\\"");
                    StringBuilder sb2 = new StringBuilder(String.valueOf(replace).length() + 2);
                    sb2.append("\"");
                    sb2.append(replace);
                    sb2.append("\"");
                    str2 = sb2.toString();
                }
                sb.append(str2);
            }
        }
        String sb3 = sb.toString();
        this.zzaak = sb3;
        return sb3;
    }

    public final String toString() {
        return zzfq();
    }

    private final boolean zza(zzgv zzgv) {
        return zzgv != null && this.type.equalsIgnoreCase(zzgv.type) && this.zzaai.equalsIgnoreCase(zzgv.zzaai);
    }

    public static boolean zzb(String str, String str2) {
        return str2 != null && new zzgv(str).zza(new zzgv(str2));
    }

    public final zzgv zza(Charset charset) {
        zza(HttpRequest.PARAM_CHARSET, charset == null ? null : charset.name());
        return this;
    }

    public final Charset zzgc() {
        String str = this.zzaaj.get(HttpRequest.PARAM_CHARSET.toLowerCase(Locale.US));
        if (str == null) {
            return null;
        }
        return Charset.forName(str);
    }

    public final int hashCode() {
        return zzfq().hashCode();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgv)) {
            return false;
        }
        zzgv zzgv = (zzgv) obj;
        if (!zza(zzgv) || !this.zzaaj.equals(zzgv.zzaaj)) {
            return false;
        }
        return true;
    }

    static {
        StringBuilder sb = new StringBuilder("[^\\s/=;\"]+".length() + 14 + "[^\\s/=;\"]+".length() + ";.*".length());
        sb.append("\\s*(");
        sb.append("[^\\s/=;\"]+");
        sb.append(")/(");
        sb.append("[^\\s/=;\"]+");
        sb.append(")\\s*(");
        sb.append(";.*");
        sb.append(")?");
        zzaag = Pattern.compile(sb.toString(), 32);
        StringBuilder sb2 = new StringBuilder("\"([^\"]*)\"".length() + 1 + "[^\\s;\"]*".length());
        sb2.append("\"([^\"]*)\"");
        sb2.append("|");
        sb2.append("[^\\s;\"]*");
        String sb3 = sb2.toString();
        StringBuilder sb4 = new StringBuilder("[^\\s/=;\"]+".length() + 12 + String.valueOf(sb3).length());
        sb4.append("\\s*;\\s*(");
        sb4.append("[^\\s/=;\"]+");
        sb4.append(")=(");
        sb4.append(sb3);
        sb4.append(")");
        zzaah = Pattern.compile(sb4.toString());
    }
}
