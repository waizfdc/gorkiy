package com.google.android.gms.internal.firebase_ml;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
final class zzyo {
    static String zzh(zzuq zzuq) {
        zzyr zzyr = new zzyr(zzuq);
        StringBuilder sb = new StringBuilder(zzyr.size());
        for (int i = 0; i < zzyr.size(); i++) {
            byte zzcs = zzyr.zzcs(i);
            if (zzcs == 34) {
                sb.append("\\\"");
            } else if (zzcs == 39) {
                sb.append("\\'");
            } else if (zzcs != 92) {
                switch (zzcs) {
                    case 7:
                        sb.append("\\a");
                        continue;
                    case 8:
                        sb.append("\\b");
                        continue;
                    case 9:
                        sb.append("\\t");
                        continue;
                    case 10:
                        sb.append("\\n");
                        continue;
                    case 11:
                        sb.append("\\v");
                        continue;
                    case 12:
                        sb.append("\\f");
                        continue;
                    case 13:
                        sb.append("\\r");
                        continue;
                    default:
                        if (zzcs < 32 || zzcs > 126) {
                            sb.append('\\');
                            sb.append((char) (((zzcs >>> 6) & 3) + 48));
                            sb.append((char) (((zzcs >>> 3) & 7) + 48));
                            sb.append((char) ((zzcs & 7) + 48));
                            break;
                        } else {
                            sb.append((char) zzcs);
                            continue;
                        }
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }
}
