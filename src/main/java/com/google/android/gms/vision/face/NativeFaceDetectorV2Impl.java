package com.google.android.gms.vision.face;

import android.content.Context;
import android.graphics.PointF;
import android.os.RemoteException;
import android.os.SystemClock;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.vision.zzbl;
import com.google.android.gms.internal.vision.zzbq;
import com.google.android.gms.internal.vision.zzbr;
import com.google.android.gms.internal.vision.zzbx;
import com.google.android.gms.internal.vision.zzbz;
import com.google.android.gms.internal.vision.zzce;
import com.google.android.gms.internal.vision.zzci;
import com.google.android.gms.internal.vision.zzea;
import com.google.android.gms.internal.vision.zzgs;
import com.google.android.gms.internal.vision.zzkf;
import com.google.android.gms.internal.vision.zzkn;
import com.google.android.gms.internal.vision.zzp;
import com.google.android.gms.vision.clearcut.DynamiteClearcutLogger;
import com.google.android.gms.vision.face.internal.client.FaceParcel;
import com.google.android.gms.vision.face.internal.client.LandmarkParcel;
import com.google.android.gms.vision.face.internal.client.zza;
import com.google.android.gms.vision.face.internal.client.zzf;
import com.google.android.gms.vision.face.internal.client.zzg;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.firebase:firebase-ml-vision-face-model@@19.0.0 */
final class NativeFaceDetectorV2Impl extends zzg {
    private static final GmsLogger zzcq = new GmsLogger("NativeFaceDetectorV2Imp", "");
    private final long zzcr;
    private final DynamiteClearcutLogger zzcs;
    private final zzbx.zzd zzct;
    private final FaceDetectorV2Jni zzcu;

    /* renamed from: com.google.android.gms.vision.face.NativeFaceDetectorV2Impl$1  reason: invalid class name */
    /* compiled from: com.google.firebase:firebase-ml-vision-face-model@@19.0.0 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] zzcv;
        static final /* synthetic */ int[] zzcw;

        /* JADX WARNING: Can't wrap try/catch for region: R(59:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|21|22|23|(2:25|26)|27|(2:29|30)|31|(2:33|34)|35|(2:37|38)|39|41|42|43|45|46|47|48|49|50|51|52|53|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|80) */
        /* JADX WARNING: Can't wrap try/catch for region: R(61:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|21|22|23|(2:25|26)|27|(2:29|30)|31|(2:33|34)|35|37|38|39|41|42|43|45|46|47|48|49|50|51|52|53|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|80) */
        /* JADX WARNING: Can't wrap try/catch for region: R(62:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|17|18|19|21|22|23|(2:25|26)|27|(2:29|30)|31|(2:33|34)|35|37|38|39|41|42|43|45|46|47|48|49|50|51|52|53|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|80) */
        /* JADX WARNING: Can't wrap try/catch for region: R(63:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|17|18|19|21|22|23|(2:25|26)|27|(2:29|30)|31|33|34|35|37|38|39|41|42|43|45|46|47|48|49|50|51|52|53|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|80) */
        /* JADX WARNING: Can't wrap try/catch for region: R(64:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|21|22|23|(2:25|26)|27|(2:29|30)|31|33|34|35|37|38|39|41|42|43|45|46|47|48|49|50|51|52|53|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|80) */
        /* JADX WARNING: Can't wrap try/catch for region: R(65:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|21|22|23|(2:25|26)|27|29|30|31|33|34|35|37|38|39|41|42|43|45|46|47|48|49|50|51|52|53|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|80) */
        /* JADX WARNING: Can't wrap try/catch for region: R(66:0|(2:1|2)|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|(2:25|26)|27|29|30|31|33|34|35|37|38|39|41|42|43|45|46|47|48|49|50|51|52|53|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|80) */
        /* JADX WARNING: Can't wrap try/catch for region: R(68:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|25|26|27|29|30|31|33|34|35|37|38|39|41|42|43|45|46|47|48|49|50|51|52|53|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|80) */
        /* JADX WARNING: Code restructure failed: missing block: B:81:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x00c5 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x00cf */
        /* JADX WARNING: Missing exception handler attribute for start block: B:61:0x00d9 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:63:0x00e3 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:65:0x00ed */
        /* JADX WARNING: Missing exception handler attribute for start block: B:67:0x00f7 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:69:0x0101 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:71:0x010b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:73:0x0115 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:75:0x011f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:77:0x0129 */
        static {
            /*
                com.google.android.gms.internal.vision.zzbx$zzb$zzc[] r0 = com.google.android.gms.internal.vision.zzbx.zzb.zzc.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.google.android.gms.vision.face.NativeFaceDetectorV2Impl.AnonymousClass1.zzcw = r0
                r1 = 1
                com.google.android.gms.internal.vision.zzbx$zzb$zzc r2 = com.google.android.gms.internal.vision.zzbx.zzb.zzc.FACE_OVAL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = com.google.android.gms.vision.face.NativeFaceDetectorV2Impl.AnonymousClass1.zzcw     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.android.gms.internal.vision.zzbx$zzb$zzc r3 = com.google.android.gms.internal.vision.zzbx.zzb.zzc.LEFT_EYEBROW_TOP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = com.google.android.gms.vision.face.NativeFaceDetectorV2Impl.AnonymousClass1.zzcw     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.android.gms.internal.vision.zzbx$zzb$zzc r4 = com.google.android.gms.internal.vision.zzbx.zzb.zzc.LEFT_EYEBROW_BOTTOM     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = com.google.android.gms.vision.face.NativeFaceDetectorV2Impl.AnonymousClass1.zzcw     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.android.gms.internal.vision.zzbx$zzb$zzc r5 = com.google.android.gms.internal.vision.zzbx.zzb.zzc.RIGHT_EYEBROW_TOP     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                r4 = 5
                int[] r5 = com.google.android.gms.vision.face.NativeFaceDetectorV2Impl.AnonymousClass1.zzcw     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.android.gms.internal.vision.zzbx$zzb$zzc r6 = com.google.android.gms.internal.vision.zzbx.zzb.zzc.RIGHT_EYEBROW_BOTTOM     // Catch:{ NoSuchFieldError -> 0x003e }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                r5 = 6
                int[] r6 = com.google.android.gms.vision.face.NativeFaceDetectorV2Impl.AnonymousClass1.zzcw     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.android.gms.internal.vision.zzbx$zzb$zzc r7 = com.google.android.gms.internal.vision.zzbx.zzb.zzc.LEFT_EYE     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r6[r7] = r5     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                r6 = 7
                int[] r7 = com.google.android.gms.vision.face.NativeFaceDetectorV2Impl.AnonymousClass1.zzcw     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.google.android.gms.internal.vision.zzbx$zzb$zzc r8 = com.google.android.gms.internal.vision.zzbx.zzb.zzc.RIGHT_EYE     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r7[r8] = r6     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                r7 = 8
                int[] r8 = com.google.android.gms.vision.face.NativeFaceDetectorV2Impl.AnonymousClass1.zzcw     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.google.android.gms.internal.vision.zzbx$zzb$zzc r9 = com.google.android.gms.internal.vision.zzbx.zzb.zzc.UPPER_LIP_TOP     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r9 = r9.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r8[r9] = r7     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                r8 = 9
                int[] r9 = com.google.android.gms.vision.face.NativeFaceDetectorV2Impl.AnonymousClass1.zzcw     // Catch:{ NoSuchFieldError -> 0x006c }
                com.google.android.gms.internal.vision.zzbx$zzb$zzc r10 = com.google.android.gms.internal.vision.zzbx.zzb.zzc.UPPER_LIP_BOTTOM     // Catch:{ NoSuchFieldError -> 0x006c }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r9[r10] = r8     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                r9 = 10
                int[] r10 = com.google.android.gms.vision.face.NativeFaceDetectorV2Impl.AnonymousClass1.zzcw     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.google.android.gms.internal.vision.zzbx$zzb$zzc r11 = com.google.android.gms.internal.vision.zzbx.zzb.zzc.LOWER_LIP_TOP     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r11 = r11.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r10[r11] = r9     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                r10 = 11
                int[] r11 = com.google.android.gms.vision.face.NativeFaceDetectorV2Impl.AnonymousClass1.zzcw     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.google.android.gms.internal.vision.zzbx$zzb$zzc r12 = com.google.android.gms.internal.vision.zzbx.zzb.zzc.LOWER_LIP_BOTTOM     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r12 = r12.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r11[r12] = r10     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                r11 = 12
                int[] r12 = com.google.android.gms.vision.face.NativeFaceDetectorV2Impl.AnonymousClass1.zzcw     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.google.android.gms.internal.vision.zzbx$zzb$zzc r13 = com.google.android.gms.internal.vision.zzbx.zzb.zzc.NOSE_BRIDGE     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r13 = r13.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r12[r13] = r11     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r12 = com.google.android.gms.vision.face.NativeFaceDetectorV2Impl.AnonymousClass1.zzcw     // Catch:{ NoSuchFieldError -> 0x009c }
                com.google.android.gms.internal.vision.zzbx$zzb$zzc r13 = com.google.android.gms.internal.vision.zzbx.zzb.zzc.NOSE_BOTTOM     // Catch:{ NoSuchFieldError -> 0x009c }
                int r13 = r13.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r14 = 13
                r12[r13] = r14     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r12 = com.google.android.gms.vision.face.NativeFaceDetectorV2Impl.AnonymousClass1.zzcw     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.google.android.gms.internal.vision.zzbx$zzb$zzc r13 = com.google.android.gms.internal.vision.zzbx.zzb.zzc.LEFT_CHEEK_CENTER     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r13 = r13.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r14 = 14
                r12[r13] = r14     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r12 = com.google.android.gms.vision.face.NativeFaceDetectorV2Impl.AnonymousClass1.zzcw     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.google.android.gms.internal.vision.zzbx$zzb$zzc r13 = com.google.android.gms.internal.vision.zzbx.zzb.zzc.RIGHT_CHEEK_CENTER     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r13 = r13.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r14 = 15
                r12[r13] = r14     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                com.google.android.gms.internal.vision.zzkf$zze$zza[] r12 = com.google.android.gms.internal.vision.zzkf.zze.zza.values()
                int r12 = r12.length
                int[] r12 = new int[r12]
                com.google.android.gms.vision.face.NativeFaceDetectorV2Impl.AnonymousClass1.zzcv = r12
                com.google.android.gms.internal.vision.zzkf$zze$zza r13 = com.google.android.gms.internal.vision.zzkf.zze.zza.LEFT_EYE     // Catch:{ NoSuchFieldError -> 0x00c5 }
                int r13 = r13.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c5 }
                r12[r13] = r1     // Catch:{ NoSuchFieldError -> 0x00c5 }
            L_0x00c5:
                int[] r1 = com.google.android.gms.vision.face.NativeFaceDetectorV2Impl.AnonymousClass1.zzcv     // Catch:{ NoSuchFieldError -> 0x00cf }
                com.google.android.gms.internal.vision.zzkf$zze$zza r12 = com.google.android.gms.internal.vision.zzkf.zze.zza.RIGHT_EYE     // Catch:{ NoSuchFieldError -> 0x00cf }
                int r12 = r12.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cf }
                r1[r12] = r0     // Catch:{ NoSuchFieldError -> 0x00cf }
            L_0x00cf:
                int[] r0 = com.google.android.gms.vision.face.NativeFaceDetectorV2Impl.AnonymousClass1.zzcv     // Catch:{ NoSuchFieldError -> 0x00d9 }
                com.google.android.gms.internal.vision.zzkf$zze$zza r1 = com.google.android.gms.internal.vision.zzkf.zze.zza.NOSE_TIP     // Catch:{ NoSuchFieldError -> 0x00d9 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d9 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d9 }
            L_0x00d9:
                int[] r0 = com.google.android.gms.vision.face.NativeFaceDetectorV2Impl.AnonymousClass1.zzcv     // Catch:{ NoSuchFieldError -> 0x00e3 }
                com.google.android.gms.internal.vision.zzkf$zze$zza r1 = com.google.android.gms.internal.vision.zzkf.zze.zza.LOWER_LIP     // Catch:{ NoSuchFieldError -> 0x00e3 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e3 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x00e3 }
            L_0x00e3:
                int[] r0 = com.google.android.gms.vision.face.NativeFaceDetectorV2Impl.AnonymousClass1.zzcv     // Catch:{ NoSuchFieldError -> 0x00ed }
                com.google.android.gms.internal.vision.zzkf$zze$zza r1 = com.google.android.gms.internal.vision.zzkf.zze.zza.MOUTH_LEFT     // Catch:{ NoSuchFieldError -> 0x00ed }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ed }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x00ed }
            L_0x00ed:
                int[] r0 = com.google.android.gms.vision.face.NativeFaceDetectorV2Impl.AnonymousClass1.zzcv     // Catch:{ NoSuchFieldError -> 0x00f7 }
                com.google.android.gms.internal.vision.zzkf$zze$zza r1 = com.google.android.gms.internal.vision.zzkf.zze.zza.MOUTH_RIGHT     // Catch:{ NoSuchFieldError -> 0x00f7 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f7 }
                r0[r1] = r5     // Catch:{ NoSuchFieldError -> 0x00f7 }
            L_0x00f7:
                int[] r0 = com.google.android.gms.vision.face.NativeFaceDetectorV2Impl.AnonymousClass1.zzcv     // Catch:{ NoSuchFieldError -> 0x0101 }
                com.google.android.gms.internal.vision.zzkf$zze$zza r1 = com.google.android.gms.internal.vision.zzkf.zze.zza.LEFT_EAR_TRAGION     // Catch:{ NoSuchFieldError -> 0x0101 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0101 }
                r0[r1] = r6     // Catch:{ NoSuchFieldError -> 0x0101 }
            L_0x0101:
                int[] r0 = com.google.android.gms.vision.face.NativeFaceDetectorV2Impl.AnonymousClass1.zzcv     // Catch:{ NoSuchFieldError -> 0x010b }
                com.google.android.gms.internal.vision.zzkf$zze$zza r1 = com.google.android.gms.internal.vision.zzkf.zze.zza.RIGHT_EAR_TRAGION     // Catch:{ NoSuchFieldError -> 0x010b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x010b }
                r0[r1] = r7     // Catch:{ NoSuchFieldError -> 0x010b }
            L_0x010b:
                int[] r0 = com.google.android.gms.vision.face.NativeFaceDetectorV2Impl.AnonymousClass1.zzcv     // Catch:{ NoSuchFieldError -> 0x0115 }
                com.google.android.gms.internal.vision.zzkf$zze$zza r1 = com.google.android.gms.internal.vision.zzkf.zze.zza.LEFT_CHEEK_CENTER     // Catch:{ NoSuchFieldError -> 0x0115 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0115 }
                r0[r1] = r8     // Catch:{ NoSuchFieldError -> 0x0115 }
            L_0x0115:
                int[] r0 = com.google.android.gms.vision.face.NativeFaceDetectorV2Impl.AnonymousClass1.zzcv     // Catch:{ NoSuchFieldError -> 0x011f }
                com.google.android.gms.internal.vision.zzkf$zze$zza r1 = com.google.android.gms.internal.vision.zzkf.zze.zza.RIGHT_CHEEK_CENTER     // Catch:{ NoSuchFieldError -> 0x011f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x011f }
                r0[r1] = r9     // Catch:{ NoSuchFieldError -> 0x011f }
            L_0x011f:
                int[] r0 = com.google.android.gms.vision.face.NativeFaceDetectorV2Impl.AnonymousClass1.zzcv     // Catch:{ NoSuchFieldError -> 0x0129 }
                com.google.android.gms.internal.vision.zzkf$zze$zza r1 = com.google.android.gms.internal.vision.zzkf.zze.zza.LEFT_EAR_TOP     // Catch:{ NoSuchFieldError -> 0x0129 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0129 }
                r0[r1] = r10     // Catch:{ NoSuchFieldError -> 0x0129 }
            L_0x0129:
                int[] r0 = com.google.android.gms.vision.face.NativeFaceDetectorV2Impl.AnonymousClass1.zzcv     // Catch:{ NoSuchFieldError -> 0x0133 }
                com.google.android.gms.internal.vision.zzkf$zze$zza r1 = com.google.android.gms.internal.vision.zzkf.zze.zza.RIGHT_EAR_TOP     // Catch:{ NoSuchFieldError -> 0x0133 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0133 }
                r0[r1] = r11     // Catch:{ NoSuchFieldError -> 0x0133 }
            L_0x0133:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.vision.face.NativeFaceDetectorV2Impl.AnonymousClass1.<clinit>():void");
        }
    }

    NativeFaceDetectorV2Impl(Context context, Context context2, DynamiteClearcutLogger dynamiteClearcutLogger, zzf zzf, FaceDetectorV2Jni faceDetectorV2Jni) {
        zzbx.zzg zzg = (zzbx.zzg) ((zzgs) zzbx.zzg.zzbv().zzj("models").zzgc());
        zzbx.zzd.zza zzf2 = zzbx.zzd.zzbp().zza(zzbx.zze.zzbr().zzh(zzg).zzi(zzg).zzj(zzg)).zza(zzbx.zza.zzbd().zzc(zzg).zzd(zzg)).zza(zzbx.zzf.zzbt().zzk(zzg).zzl(zzg).zzm(zzg).zzn(zzg)).zzd(zzf.zzcn).zze(zzf.trackingEnabled).zze(zzf.proportionalMinFaceSize).zzf(true);
        int i = zzf.mode;
        if (i == 0) {
            zzf2.zzb(zzci.FAST);
        } else if (i == 1) {
            zzf2.zzb(zzci.ACCURATE);
        } else if (i == 2) {
            zzf2.zzb(zzci.SELFIE);
        }
        int i2 = zzf.landmarkType;
        if (i2 == 0) {
            zzf2.zzb(zzce.NO_LANDMARK);
        } else if (i2 == 1) {
            zzf2.zzb(zzce.ALL_LANDMARKS);
        } else if (i2 == 2) {
            zzf2.zzb(zzce.CONTOUR_LANDMARKS);
        }
        int i3 = zzf.zzco;
        if (i3 == 0) {
            zzf2.zzb(zzbz.NO_CLASSIFICATION);
        } else if (i3 == 1) {
            zzf2.zzb(zzbz.ALL_CLASSIFICATIONS);
        }
        zzbx.zzd zzd = (zzbx.zzd) ((zzgs) zzf2.zzgc());
        this.zzct = zzd;
        this.zzcr = faceDetectorV2Jni.zza(zzd, context2.getAssets());
        this.zzcs = dynamiteClearcutLogger;
        this.zzcu = faceDetectorV2Jni;
    }

    public final boolean zzd(int i) throws RemoteException {
        return true;
    }

    public final void zzm() throws RemoteException {
        this.zzcu.zza(this.zzcr);
    }

    public final FaceParcel[] zzc(IObjectWrapper iObjectWrapper, zzp zzp) throws RemoteException {
        String str;
        zzbr zzbr;
        zzbx.zzc zzc;
        float f;
        float f2;
        float f3;
        int i;
        zzbz zzbz;
        zzkn zzkn;
        LandmarkParcel[] landmarkParcelArr;
        zzce zzce;
        zza[] zzaArr;
        int i2;
        int i3;
        zzbz zzbz2;
        zzkn zzkn2;
        List<zzkf.zze> list;
        int i4;
        zzp zzp2 = zzp;
        String str2 = "NativeFaceDetectorV2Imp";
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            ByteBuffer byteBuffer = (ByteBuffer) ObjectWrapper.unwrap(iObjectWrapper);
            zzbq.zza zzj = zzbq.zzai().zzi(zzp2.width).zzj(zzp2.height);
            int i5 = zzp2.rotation;
            if (i5 == 0) {
                zzbr = zzbr.ROTATION_0;
            } else if (i5 == 1) {
                zzbr = zzbr.ROTATION_270;
            } else if (i5 == 2) {
                zzbr = zzbr.ROTATION_180;
            } else if (i5 == 3) {
                zzbr = zzbr.ROTATION_90;
            } else {
                throw new IllegalArgumentException("Unsupported rotation degree.");
            }
            zzbq.zza zzb = zzj.zzb(zzbr).zzb(zzbl.NV21);
            if (zzp2.zzar > 0) {
                zzb.zzc(zzp2.zzar * 1000);
            }
            zzbq zzbq = (zzbq) ((zzgs) zzb.zzgc());
            if (byteBuffer.isDirect()) {
                zzc = this.zzcu.zza(this.zzcr, byteBuffer, zzbq);
            } else if (!byteBuffer.hasArray() || byteBuffer.arrayOffset() != 0) {
                byte[] bArr = new byte[byteBuffer.remaining()];
                byteBuffer.get(bArr);
                zzc = this.zzcu.zza(this.zzcr, bArr, zzbq);
            } else {
                zzc = this.zzcu.zza(this.zzcr, byteBuffer.array(), zzbq);
            }
            zzbz zzbo = this.zzct.zzbo();
            zzce zzbn = this.zzct.zzbn();
            zzkn zzbl = zzc.zzbl();
            int zzjl = zzbl.zzjl();
            FaceParcel[] faceParcelArr = new FaceParcel[zzjl];
            int i6 = 0;
            while (i6 < zzbl.zzjl()) {
                zzkf zzcb = zzbl.zzcb(i6);
                zzkf.zzb zzir = zzcb.zzir();
                float zzjc = zzir.zzjc() + ((zzir.zzje() - zzir.zzjc()) / 2.0f);
                float zzjd = zzir.zzjd() + ((zzir.zzjf() - zzir.zzjd()) / 2.0f);
                float zzje = zzir.zzje() - zzir.zzjc();
                float zzjf = zzir.zzjf() - zzir.zzjd();
                if (zzbo == zzbz.ALL_CLASSIFICATIONS) {
                    float f4 = -1.0f;
                    float f5 = -1.0f;
                    float f6 = -1.0f;
                    for (zzkf.zza next : zzcb.zzix()) {
                        if (next.getName().equals("joy")) {
                            f6 = next.getConfidence();
                        } else if (next.getName().equals("left_eye_closed")) {
                            f4 = 1.0f - next.getConfidence();
                        } else if (next.getName().equals("right_eye_closed")) {
                            f5 = 1.0f - next.getConfidence();
                        }
                    }
                    f3 = f4;
                    f2 = f5;
                    f = f6;
                } else {
                    f3 = -1.0f;
                    f2 = -1.0f;
                    f = -1.0f;
                }
                float confidence = zzcb.zzit() ? zzcb.getConfidence() : -1.0f;
                if (zzbn == zzce.ALL_LANDMARKS) {
                    List<zzkf.zze> zzis = zzcb.zzis();
                    ArrayList arrayList = new ArrayList();
                    int i7 = 0;
                    while (i7 < zzis.size()) {
                        zzkf.zze zze = zzis.get(i7);
                        zzkf.zze.zza zzjj = zze.zzjj();
                        switch (AnonymousClass1.zzcv[zzjj.ordinal()]) {
                            case 1:
                                list = zzis;
                                zzkn2 = zzbl;
                                zzbz2 = zzbo;
                                i3 = zzjl;
                                i4 = 4;
                                break;
                            case 2:
                                list = zzis;
                                zzkn2 = zzbl;
                                zzbz2 = zzbo;
                                i3 = zzjl;
                                i4 = 10;
                                break;
                            case 3:
                                list = zzis;
                                zzkn2 = zzbl;
                                zzbz2 = zzbo;
                                i3 = zzjl;
                                i4 = 6;
                                break;
                            case 4:
                                list = zzis;
                                zzkn2 = zzbl;
                                zzbz2 = zzbo;
                                i3 = zzjl;
                                i4 = 0;
                                break;
                            case 5:
                                list = zzis;
                                zzkn2 = zzbl;
                                zzbz2 = zzbo;
                                i3 = zzjl;
                                i4 = 5;
                                break;
                            case 6:
                                list = zzis;
                                zzkn2 = zzbl;
                                zzbz2 = zzbo;
                                i3 = zzjl;
                                i4 = 11;
                                break;
                            case 7:
                                list = zzis;
                                zzkn2 = zzbl;
                                zzbz2 = zzbo;
                                i3 = zzjl;
                                i4 = 3;
                                break;
                            case 8:
                                list = zzis;
                                zzkn2 = zzbl;
                                zzbz2 = zzbo;
                                i3 = zzjl;
                                i4 = 9;
                                break;
                            case 9:
                                list = zzis;
                                zzkn2 = zzbl;
                                zzbz2 = zzbo;
                                i3 = zzjl;
                                i4 = 1;
                                break;
                            case 10:
                                list = zzis;
                                zzkn2 = zzbl;
                                zzbz2 = zzbo;
                                i3 = zzjl;
                                i4 = 7;
                                break;
                            case 11:
                                list = zzis;
                                zzkn2 = zzbl;
                                zzbz2 = zzbo;
                                i3 = zzjl;
                                i4 = 2;
                                break;
                            case 12:
                                list = zzis;
                                zzkn2 = zzbl;
                                zzbz2 = zzbo;
                                i3 = zzjl;
                                i4 = 8;
                                break;
                            default:
                                list = zzis;
                                GmsLogger gmsLogger = zzcq;
                                zzkn2 = zzbl;
                                String valueOf = String.valueOf(zzjj);
                                zzbz2 = zzbo;
                                i3 = zzjl;
                                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 23);
                                sb.append("Unknown landmark type: ");
                                sb.append(valueOf);
                                gmsLogger.d(str2, sb.toString());
                                i4 = -1;
                                break;
                        }
                        if (i4 >= 0) {
                            arrayList.add(new LandmarkParcel(-1, zze.getX(), zze.getY(), i4));
                        }
                        i7++;
                        zzis = list;
                        zzbl = zzkn2;
                        zzbo = zzbz2;
                        zzjl = i3;
                    }
                    zzkn = zzbl;
                    zzbz = zzbo;
                    i = zzjl;
                    landmarkParcelArr = (LandmarkParcel[]) arrayList.toArray(new LandmarkParcel[0]);
                } else {
                    zzkn = zzbl;
                    zzbz = zzbo;
                    i = zzjl;
                    landmarkParcelArr = new LandmarkParcel[0];
                }
                if (zzbn == zzce.CONTOUR_LANDMARKS) {
                    List list2 = (List) zzcb.zzc(zzbx.zzin);
                    zzaArr = new zza[list2.size()];
                    int i8 = 0;
                    while (i8 < list2.size()) {
                        zzbx.zzb zzb2 = (zzbx.zzb) list2.get(i8);
                        PointF[] pointFArr = new PointF[zzb2.zzbh()];
                        int i9 = 0;
                        while (i9 < zzb2.zzbh()) {
                            zzbx.zzb.C0025zzb zzb3 = zzb2.zzbg().get(i9);
                            pointFArr[i9] = new PointF(zzb3.getX(), zzb3.getY());
                            i9++;
                            list2 = list2;
                            zzbn = zzbn;
                        }
                        List list3 = list2;
                        zzce zzce2 = zzbn;
                        zzbx.zzb.zzc zzbf = zzb2.zzbf();
                        switch (AnonymousClass1.zzcw[zzbf.ordinal()]) {
                            case 1:
                                i2 = 1;
                                break;
                            case 2:
                                i2 = 2;
                                break;
                            case 3:
                                i2 = 3;
                                break;
                            case 4:
                                i2 = 4;
                                break;
                            case 5:
                                i2 = 5;
                                break;
                            case 6:
                                i2 = 6;
                                break;
                            case 7:
                                i2 = 7;
                                break;
                            case 8:
                                i2 = 8;
                                break;
                            case 9:
                                i2 = 9;
                                break;
                            case 10:
                                i2 = 10;
                                break;
                            case 11:
                                i2 = 11;
                                break;
                            case 12:
                                i2 = 12;
                                break;
                            case 13:
                                i2 = 13;
                                break;
                            case 14:
                            case 15:
                                GmsLogger gmsLogger2 = zzcq;
                                String valueOf2 = String.valueOf(zzbf);
                                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 35);
                                sb2.append("Intentionally ignore contour type: ");
                                sb2.append(valueOf2);
                                gmsLogger2.d(str2, sb2.toString());
                                i2 = -1;
                                break;
                            default:
                                GmsLogger gmsLogger3 = zzcq;
                                String valueOf3 = String.valueOf(zzbf);
                                StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf3).length() + 22);
                                sb3.append("Unknown contour type: ");
                                sb3.append(valueOf3);
                                gmsLogger3.e(str2, sb3.toString());
                                i2 = -1;
                                break;
                        }
                        zzaArr[i8] = new zza(pointFArr, i2);
                        i8++;
                        list2 = list3;
                        zzbn = zzce2;
                    }
                    zzce = zzbn;
                } else {
                    zzce = zzbn;
                    zzaArr = new zza[0];
                }
                faceParcelArr[i6] = new FaceParcel(3, (int) zzcb.zziy(), zzjc, zzjd, zzje, zzjf, zzcb.zziv(), -zzcb.zziu(), zzcb.zziw(), landmarkParcelArr, f3, f2, f, zzaArr, confidence);
                i6++;
                zzbl = zzkn;
                zzbo = zzbz;
                zzjl = i;
                zzbn = zzce;
            }
            int i10 = zzjl;
            DynamiteClearcutLogger dynamiteClearcutLogger = this.zzcs;
            long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
            if (zzp2.id <= 2 || i10 != 0) {
                ArrayList arrayList2 = new ArrayList();
                int i11 = i10;
                int i12 = 0;
                while (i12 < i11) {
                    FaceParcel faceParcel = faceParcelArr[i12];
                    zzea.zzm zzm = (zzea.zzm) ((zzgs) zzea.zzm.zzde().zzy((int) (faceParcel.centerX - (faceParcel.width / 2.0f))).zzz((int) (faceParcel.centerY - (faceParcel.height / 2.0f))).zzgc());
                    zzea.zzm zzm2 = (zzea.zzm) ((zzgs) zzea.zzm.zzde().zzy((int) (faceParcel.centerX + (faceParcel.width / 2.0f))).zzz((int) (faceParcel.centerY - (faceParcel.height / 2.0f))).zzgc());
                    str = str2;
                    try {
                        arrayList2.add((zzea.zzn) ((zzgs) zzea.zzn.zzdg().zza(zzea.zzd.zzcn().zzb(zzm).zzb(zzm2).zzb((zzea.zzm) ((zzgs) zzea.zzm.zzde().zzy((int) (faceParcel.centerX + (faceParcel.width / 2.0f))).zzz((int) (faceParcel.centerY + (faceParcel.height / 2.0f))).zzgc())).zzb((zzea.zzm) ((zzgs) zzea.zzm.zzde().zzy((int) (faceParcel.centerX - (faceParcel.width / 2.0f))).zzz((int) (faceParcel.centerY + (faceParcel.height / 2.0f))).zzgc()))).zzaa(faceParcel.id).zzb((zzea.zzh) ((zzgs) zzea.zzh.zzcu().zzj(faceParcel.zzcz).zzk(faceParcel.zzda).zzl(faceParcel.zzdb).zzg(faceParcel.zzce).zzh(faceParcel.zzcf).zzi(faceParcel.zzcg).zzgc())).zzgc()));
                        i12++;
                        str2 = str;
                    } catch (Exception e) {
                        e = e;
                        zzcq.e(str, "Native face detection v2 failed", e);
                        return new FaceParcel[0];
                    }
                }
                String str3 = str2;
                zzea.zzi.zza zzcx = zzea.zzi.zzcx();
                zzea.zzf.zza zze2 = zzea.zzf.zzcq().zzp("face").zzd(elapsedRealtime2).zze((long) i11);
                zze2.zzc(arrayList2);
                ArrayList arrayList3 = new ArrayList();
                arrayList3.add((zzea.zzf) ((zzgs) zze2.zzgc()));
                dynamiteClearcutLogger.zza(3, (zzea.zzo) ((zzgs) zzea.zzo.zzdi().zzb((zzea.zzi) ((zzgs) zzcx.zze(arrayList3).zza((zzea.zzj) ((zzgs) zzea.zzj.zzcz().zzi((long) zzp2.height).zzh((long) zzp2.width).zzj((long) zzp2.id).zzk(zzp2.zzar).zzgc())).zzgc())).zzgc()));
            }
            return faceParcelArr;
        } catch (Exception e2) {
            e = e2;
            str = str2;
            zzcq.e(str, "Native face detection v2 failed", e);
            return new FaceParcel[0];
        }
    }
}
