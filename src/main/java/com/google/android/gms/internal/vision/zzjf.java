package com.google.android.gms.internal.vision;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
final class zzjf {
    static String zzd(zzfh zzfh) {
        zzji zzji = new zzji(zzfh);
        StringBuilder sb = new StringBuilder(zzji.size());
        for (int i = 0; i < zzji.size(); i++) {
            byte zzan = zzji.zzan(i);
            if (zzan == 34) {
                sb.append("\\\"");
            } else if (zzan == 39) {
                sb.append("\\'");
            } else if (zzan != 92) {
                switch (zzan) {
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
                        if (zzan < 32 || zzan > 126) {
                            sb.append('\\');
                            sb.append((char) (((zzan >>> 6) & 3) + 48));
                            sb.append((char) (((zzan >>> 3) & 7) + 48));
                            sb.append((char) ((zzan & 7) + 48));
                            break;
                        } else {
                            sb.append((char) zzan);
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
