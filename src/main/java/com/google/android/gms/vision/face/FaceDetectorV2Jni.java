package com.google.android.gms.vision.face;

import android.content.res.AssetManager;
import android.os.RemoteException;
import com.google.android.gms.internal.vision.zzbq;
import com.google.android.gms.internal.vision.zzbx;
import com.google.android.gms.internal.vision.zzgd;
import com.google.android.gms.internal.vision.zzhc;
import com.google.android.gms.vision.L;
import java.nio.ByteBuffer;

/* compiled from: com.google.firebase:firebase-ml-vision-face-model@@19.0.0 */
public class FaceDetectorV2Jni {
    private final zzgd zzcm;

    public FaceDetectorV2Jni() {
        zzgd zzfk = zzgd.zzfk();
        this.zzcm = zzfk;
        zzfk.zza(zzbx.zzin);
    }

    private native void closeDetectorJni(long j);

    private native byte[] detectFacesImageByteArrayJni(long j, byte[] bArr, byte[] bArr2);

    private native byte[] detectFacesImageByteBufferJni(long j, ByteBuffer byteBuffer, byte[] bArr);

    private native long initDetectorJni(byte[] bArr, AssetManager assetManager);

    /* access modifiers changed from: package-private */
    public final long zza(zzbx.zzd zzd, AssetManager assetManager) {
        L.v("%s initialize.start()", "FaceDetectorV2Jni");
        long initDetectorJni = initDetectorJni(zzd.toByteArray(), assetManager);
        L.v("%s initialize.end()", "FaceDetectorV2Jni");
        return initDetectorJni;
    }

    /* access modifiers changed from: package-private */
    public final zzbx.zzc zza(long j, ByteBuffer byteBuffer, zzbq zzbq) throws RemoteException {
        L.v("%s detectFacesImageByteBuffer.start()", "FaceDetectorV2Jni");
        zzbx.zzc zzc = null;
        try {
            byte[] detectFacesImageByteBufferJni = detectFacesImageByteBufferJni(j, byteBuffer, zzbq.toByteArray());
            if (detectFacesImageByteBufferJni != null && detectFacesImageByteBufferJni.length > 0) {
                zzc = zzbx.zzc.zza(detectFacesImageByteBufferJni, this.zzcm);
            }
        } catch (zzhc e) {
            L.e("%s detectFacesImageByteBuffer failed to parse result: %s", "FaceDetectorV2Jni", e.getMessage());
        }
        L.v("%s detectFacesImageByteBuffer.end()", "FaceDetectorV2Jni");
        return zzc;
    }

    /* access modifiers changed from: package-private */
    public final zzbx.zzc zza(long j, byte[] bArr, zzbq zzbq) throws RemoteException {
        L.v("%s detectFacesImageByteArray.start()", "FaceDetectorV2Jni");
        zzbx.zzc zzc = null;
        try {
            byte[] detectFacesImageByteArrayJni = detectFacesImageByteArrayJni(j, bArr, zzbq.toByteArray());
            if (detectFacesImageByteArrayJni != null && detectFacesImageByteArrayJni.length > 0) {
                zzc = zzbx.zzc.zza(detectFacesImageByteArrayJni, this.zzcm);
            }
        } catch (zzhc e) {
            L.e("%s detectFacesImageByteArray failed to parse result: %s", "FaceDetectorV2Jni", e.getMessage());
        }
        L.v("%s detectFacesImageByteArray.end()", "FaceDetectorV2Jni");
        return zzc;
    }

    /* access modifiers changed from: package-private */
    public final void zza(long j) throws RemoteException {
        L.v("%s closeDetector.start()", "FaceDetectorV2Jni");
        closeDetectorJni(j);
        L.v("%s closeDetector.end()", "FaceDetectorV2Jni");
    }
}
