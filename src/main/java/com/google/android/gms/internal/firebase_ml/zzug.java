package com.google.android.gms.internal.firebase_ml;

import com.google.android.gms.internal.firebase_ml.zzug;
import com.google.android.gms.internal.firebase_ml.zzuj;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public abstract class zzug<MessageType extends zzug<MessageType, BuilderType>, BuilderType extends zzuj<MessageType, BuilderType>> implements zzxg {
    protected int zzbyw = 0;

    public final zzuq zzsk() {
        try {
            zzuy zzcu = zzuq.zzcu(zzua());
            zzb(zzcu.zztb());
            return zzcu.zzta();
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 62 + "ByteString".length());
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ");
            sb.append("ByteString");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e);
        }
    }

    public final byte[] toByteArray() {
        try {
            byte[] bArr = new byte[zzua()];
            zzvh zzg = zzvh.zzg(bArr);
            zzb(zzg);
            zzg.zzte();
            return bArr;
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 62 + "byte array".length());
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ");
            sb.append("byte array");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e);
        }
    }

    /* access modifiers changed from: package-private */
    public int zzsl() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public void zzco(int i) {
        throw new UnsupportedOperationException();
    }

    protected static <T> void zza(Iterable iterable, List list) {
        zzvy.checkNotNull(iterable);
        if (iterable instanceof zzwr) {
            List<?> zzur = ((zzwr) iterable).zzur();
            zzwr zzwr = (zzwr) list;
            int size = list.size();
            for (Object next : zzur) {
                if (next == null) {
                    StringBuilder sb = new StringBuilder(37);
                    sb.append("Element at index ");
                    sb.append(zzwr.size() - size);
                    sb.append(" is null.");
                    String sb2 = sb.toString();
                    for (int size2 = zzwr.size() - 1; size2 >= size; size2--) {
                        zzwr.remove(size2);
                    }
                    throw new NullPointerException(sb2);
                } else if (next instanceof zzuq) {
                    zzwr.zze((zzuq) next);
                } else {
                    zzwr.add((String) next);
                }
            }
        } else if (iterable instanceof zzxs) {
            list.addAll((Collection) iterable);
        } else {
            if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
                ((ArrayList) list).ensureCapacity(list.size() + ((Collection) iterable).size());
            }
            int size3 = list.size();
            for (Object next2 : iterable) {
                if (next2 == null) {
                    StringBuilder sb3 = new StringBuilder(37);
                    sb3.append("Element at index ");
                    sb3.append(list.size() - size3);
                    sb3.append(" is null.");
                    String sb4 = sb3.toString();
                    for (int size4 = list.size() - 1; size4 >= size3; size4--) {
                        list.remove(size4);
                    }
                    throw new NullPointerException(sb4);
                }
                list.add(next2);
            }
        }
    }
}
