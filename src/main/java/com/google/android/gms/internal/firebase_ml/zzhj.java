package com.google.android.gms.internal.firebase_ml;

import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public final class zzhj implements zzji {
    public static final String MEDIA_TYPE = new zzgv(HttpRequest.CONTENT_TYPE_FORM).zza(zzio.UTF_8).zzfq();

    public static void zze(String str, Object obj) {
        String str2 = str;
        Object obj2 = obj;
        if (str2 != null) {
            try {
                StringReader stringReader = new StringReader(str2);
                Class<?> cls = obj.getClass();
                zzir zzc = zzir.zzc(cls);
                List asList = Arrays.asList(cls);
                zziy zziy = zziy.class.isAssignableFrom(cls) ? (zziy) obj2 : null;
                Map map = Map.class.isAssignableFrom(cls) ? (Map) obj2 : null;
                zzin zzin = new zzin(obj2);
                StringWriter stringWriter = new StringWriter();
                StringWriter stringWriter2 = new StringWriter();
                boolean z = true;
                while (true) {
                    int read = stringReader.read();
                    if (read == -1 || read == 38) {
                        String zzar = zzjs.zzar(stringWriter.toString());
                        if (zzar.length() != 0) {
                            String zzar2 = zzjs.zzar(stringWriter2.toString());
                            zziz zzan = zzc.zzan(zzar);
                            if (zzan != null) {
                                Type zza = zzit.zza((List<Type>) asList, zzan.getGenericType());
                                if (zzjo.zzc(zza)) {
                                    Class<?> zzb = zzjo.zzb(asList, zzjo.zzd(zza));
                                    zzin.zza(zzan.zzhz(), zzb, zza(zzb, asList, zzar2));
                                } else if (zzjo.zza(zzjo.zzb(asList, zza), (Class<?>) Iterable.class)) {
                                    Collection<Object> collection = (Collection) zzan.zzh(obj2);
                                    if (collection == null) {
                                        collection = zzit.zzb(zza);
                                        zzan.zzb(obj2, collection);
                                    }
                                    collection.add(zza(zza == Object.class ? null : zzjo.zze(zza), asList, zzar2));
                                } else {
                                    zzan.zzb(obj2, zza(zza, asList, zzar2));
                                }
                            } else if (map != null) {
                                ArrayList arrayList = (ArrayList) map.get(zzar);
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                    if (zziy != null) {
                                        zziy.zzb(zzar, arrayList);
                                    } else {
                                        map.put(zzar, arrayList);
                                    }
                                }
                                arrayList.add(zzar2);
                            }
                        }
                        StringWriter stringWriter3 = new StringWriter();
                        StringWriter stringWriter4 = new StringWriter();
                        if (read == -1) {
                            zzin.zzhu();
                            return;
                        }
                        stringWriter2 = stringWriter4;
                        z = true;
                        stringWriter = stringWriter3;
                    } else if (read != 61) {
                        if (z) {
                            stringWriter.write(read);
                        } else {
                            stringWriter2.write(read);
                        }
                    } else if (z) {
                        z = false;
                    } else {
                        stringWriter2.write(read);
                    }
                }
            } catch (IOException e) {
                throw zzmm.zza(e);
            }
        }
    }

    private static Object zza(Type type, List<Type> list, String str) {
        return zzit.zza(zzit.zza(list, type), str);
    }

    public final <T> T zza(InputStream inputStream, Charset charset, Class<T> cls) throws IOException {
        throw new NoSuchMethodError();
    }
}
