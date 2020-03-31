package com.google.android.gms.internal.firebase_ml;

import com.google.android.gms.internal.firebase_ml.zziy;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public final class zzgt extends zziy {
    @zzjc("Accept")
    private List<String> accept;
    @zzjc(HttpRequest.HEADER_ACCEPT_ENCODING)
    private List<String> acceptEncoding = new ArrayList(Collections.singleton(HttpRequest.ENCODING_GZIP));
    @zzjc("Age")
    private List<Long> age;
    @zzjc("WWW-Authenticate")
    private List<String> authenticate;
    @zzjc(HttpRequest.HEADER_AUTHORIZATION)
    private List<String> authorization;
    @zzjc(HttpRequest.HEADER_CACHE_CONTROL)
    private List<String> cacheControl;
    @zzjc(HttpRequest.HEADER_CONTENT_ENCODING)
    private List<String> contentEncoding;
    @zzjc(HttpRequest.HEADER_CONTENT_LENGTH)
    private List<Long> contentLength;
    @zzjc("Content-MD5")
    private List<String> contentMD5;
    @zzjc("Content-Range")
    private List<String> contentRange;
    @zzjc(HttpRequest.HEADER_CONTENT_TYPE)
    private List<String> contentType;
    @zzjc("Cookie")
    private List<String> cookie;
    @zzjc(HttpRequest.HEADER_DATE)
    private List<String> date;
    @zzjc(HttpRequest.HEADER_ETAG)
    private List<String> etag;
    @zzjc(HttpRequest.HEADER_EXPIRES)
    private List<String> expires;
    @zzjc("If-Match")
    private List<String> ifMatch;
    @zzjc("If-Modified-Since")
    private List<String> ifModifiedSince;
    @zzjc(HttpRequest.HEADER_IF_NONE_MATCH)
    private List<String> ifNoneMatch;
    @zzjc("If-Range")
    private List<String> ifRange;
    @zzjc("If-Unmodified-Since")
    private List<String> ifUnmodifiedSince;
    @zzjc(HttpRequest.HEADER_LAST_MODIFIED)
    private List<String> lastModified;
    @zzjc(HttpRequest.HEADER_LOCATION)
    private List<String> location;
    @zzjc("MIME-Version")
    private List<String> mimeVersion;
    @zzjc("Range")
    private List<String> range;
    @zzjc("Retry-After")
    private List<String> retryAfter;
    @zzjc("User-Agent")
    private List<String> userAgent;

    public zzgt() {
        super(EnumSet.of(zziy.zzc.IGNORE_CASE));
    }

    public final zzgt zzx(String str) {
        this.authorization = zza((Object) null);
        return this;
    }

    public final String getContentType() {
        return (String) zza((List) this.contentType);
    }

    public final zzgt zzy(String str) {
        this.ifModifiedSince = zza((Object) null);
        return this;
    }

    public final zzgt zzz(String str) {
        this.ifMatch = zza((Object) null);
        return this;
    }

    public final zzgt zzaa(String str) {
        this.ifNoneMatch = zza((Object) null);
        return this;
    }

    public final zzgt zzab(String str) {
        this.ifUnmodifiedSince = zza((Object) null);
        return this;
    }

    public final zzgt zzac(String str) {
        this.ifRange = zza((Object) null);
        return this;
    }

    public final String getLocation() {
        return (String) zza((List) this.location);
    }

    public final String getUserAgent() {
        return (String) zza((List) this.userAgent);
    }

    public final zzgt zzad(String str) {
        this.userAgent = zza(str);
        return this;
    }

    private static void zza(Logger logger, StringBuilder sb, StringBuilder sb2, zzhc zzhc, String str, Object obj, Writer writer) throws IOException {
        if (obj != null && !zzit.isNull(obj)) {
            String name = obj instanceof Enum ? zziz.zza((Enum) obj).getName() : obj.toString();
            String str2 = ((HttpRequest.HEADER_AUTHORIZATION.equalsIgnoreCase(str) || "Cookie".equalsIgnoreCase(str)) && (logger == null || !logger.isLoggable(Level.ALL))) ? "<Not Logged>" : name;
            if (sb != null) {
                sb.append(str);
                sb.append(": ");
                sb.append(str2);
                sb.append(zzjl.zzafu);
            }
            if (sb2 != null) {
                sb2.append(" -H '");
                sb2.append(str);
                sb2.append(": ");
                sb2.append(str2);
                sb2.append("'");
            }
            if (zzhc != null) {
                zzhc.addHeader(str, name);
            }
            if (writer != null) {
                writer.write(str);
                writer.write(": ");
                writer.write(name);
                writer.write("\r\n");
            }
        }
    }

    static void zza(zzgt zzgt, StringBuilder sb, StringBuilder sb2, Logger logger, zzhc zzhc) throws IOException {
        HashSet hashSet = new HashSet();
        for (Map.Entry next : super.entrySet()) {
            String str = (String) next.getKey();
            Object[] objArr = {str};
            if (hashSet.add(str)) {
                Object value = next.getValue();
                if (value != null) {
                    zziz zzan = super.zzhy().zzan(str);
                    if (zzan != null) {
                        str = zzan.getName();
                    }
                    String str2 = str;
                    Class<?> cls = value.getClass();
                    if ((value instanceof Iterable) || cls.isArray()) {
                        for (Object zza : zzjo.zzi(value)) {
                            zza(logger, sb, sb2, zzhc, str2, zza, null);
                        }
                    } else {
                        zza(logger, sb, sb2, zzhc, str2, value, null);
                    }
                }
            } else {
                throw new IllegalArgumentException(zzmn.zzb("multiple headers of the same name (headers are case insensitive): %s", objArr));
            }
        }
    }

    public final void zza(zzhf zzhf, StringBuilder sb) throws IOException {
        clear();
        zzgs zzgs = new zzgs(this, sb);
        int zzgj = zzhf.zzgj();
        for (int i = 0; i < zzgj; i++) {
            String zzaf = zzhf.zzaf(i);
            String zzag = zzhf.zzag(i);
            List<Type> list = zzgs.zzzn;
            zzir zzir = zzgs.zzzm;
            zzin zzin = zzgs.zzzk;
            StringBuilder sb2 = zzgs.zzzl;
            if (sb2 != null) {
                StringBuilder sb3 = new StringBuilder(String.valueOf(zzaf).length() + 2 + String.valueOf(zzag).length());
                sb3.append(zzaf);
                sb3.append(": ");
                sb3.append(zzag);
                sb2.append(sb3.toString());
                sb2.append(zzjl.zzafu);
            }
            zziz zzan = zzir.zzan(zzaf);
            if (zzan != null) {
                Type zza = zzit.zza(list, zzan.getGenericType());
                if (zzjo.zzc(zza)) {
                    Class<?> zzb = zzjo.zzb(list, zzjo.zzd(zza));
                    zzin.zza(zzan.zzhz(), zzb, zza(zzb, list, zzag));
                } else if (zzjo.zza(zzjo.zzb(list, zza), (Class<?>) Iterable.class)) {
                    Collection<Object> collection = (Collection) zzan.zzh(this);
                    if (collection == null) {
                        collection = zzit.zzb(zza);
                        zzan.zzb(this, collection);
                    }
                    collection.add(zza(zza == Object.class ? null : zzjo.zze(zza), list, zzag));
                } else {
                    zzan.zzb(this, zza(zza, list, zzag));
                }
            } else {
                ArrayList arrayList = (ArrayList) get(zzaf);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    zzgt zzgt = (zzgt) zzb(zzaf, arrayList);
                }
                arrayList.add(zzag);
            }
        }
        zzgs.zzzk.zzhu();
    }

    private static <T> T zza(List<T> list) {
        if (list == null) {
            return null;
        }
        return list.get(0);
    }

    private static <T> List<T> zza(T t) {
        if (t == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(t);
        return arrayList;
    }

    private static Object zza(Type type, List<Type> list, String str) {
        return zzit.zza(zzit.zza(list, type), str);
    }

    public final /* synthetic */ zziy zzfb() {
        return (zzgt) clone();
    }

    public final /* synthetic */ zziy zzb(String str, Object obj) {
        return (zzgt) super.zzb(str, obj);
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return (zzgt) super.clone();
    }
}
