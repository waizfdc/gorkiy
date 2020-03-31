package com.google.android.gms.internal.fitness;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
final class zziq {
    static String zzc(zzff zzff) {
        zzip zzip = new zzip(zzff);
        StringBuilder sb = new StringBuilder(zzip.size());
        for (int i = 0; i < zzip.size(); i++) {
            byte zzh = zzip.zzh(i);
            if (zzh == 34) {
                sb.append("\\\"");
            } else if (zzh == 39) {
                sb.append("\\'");
            } else if (zzh != 92) {
                switch (zzh) {
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
                        if (zzh < 32 || zzh > 126) {
                            sb.append('\\');
                            sb.append((char) (((zzh >>> 6) & 3) + 48));
                            sb.append((char) (((zzh >>> 3) & 7) + 48));
                            sb.append((char) ((zzh & 7) + 48));
                            break;
                        } else {
                            sb.append((char) zzh);
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
