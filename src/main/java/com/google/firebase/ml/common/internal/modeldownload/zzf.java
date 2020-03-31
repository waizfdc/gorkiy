package com.google.firebase.ml.common.internal.modeldownload;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_ml.zzmz;
import com.google.firebase.ml.common.FirebaseMLException;
import com.google.firebase.ml.common.modeldownload.FirebaseLocalModel;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public class zzf {
    private MappedByteBuffer zzbdt;
    private final Context zzbdu;
    private final FirebaseLocalModel zzbdv;

    public zzf(Context context, FirebaseLocalModel firebaseLocalModel) {
        this.zzbdu = context;
        this.zzbdv = firebaseLocalModel;
    }

    public MappedByteBuffer load() throws FirebaseMLException {
        AssetFileDescriptor openFd;
        RandomAccessFile randomAccessFile;
        Preconditions.checkNotNull(this.zzbdu, "Context can not be null");
        Preconditions.checkNotNull(this.zzbdv, "Model source can not be null");
        MappedByteBuffer mappedByteBuffer = this.zzbdt;
        if (mappedByteBuffer != null) {
            return mappedByteBuffer;
        }
        if (this.zzbdv.getFilePath() != null) {
            try {
                randomAccessFile = new RandomAccessFile(this.zzbdv.getFilePath(), "r");
                FileChannel channel = randomAccessFile.getChannel();
                this.zzbdt = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
                randomAccessFile.close();
                return this.zzbdt;
            } catch (IOException e) {
                String valueOf = String.valueOf(this.zzbdv.getFilePath());
                throw new FirebaseMLException(valueOf.length() != 0 ? "Can not open the local file: ".concat(valueOf) : new String("Can not open the local file: "), 14, e);
            } catch (Throwable th) {
                zzmz.zza(th, th);
            }
        } else if (this.zzbdv.getAssetFilePath() != null) {
            String assetFilePath = this.zzbdv.getAssetFilePath();
            try {
                openFd = this.zzbdu.getAssets().openFd(assetFilePath);
                this.zzbdt = new FileInputStream(openFd.getFileDescriptor()).getChannel().map(FileChannel.MapMode.READ_ONLY, openFd.getStartOffset(), openFd.getDeclaredLength());
                if (openFd != null) {
                    openFd.close();
                }
                return this.zzbdt;
            } catch (IOException e2) {
                StringBuilder sb = new StringBuilder(String.valueOf(assetFilePath).length() + 186);
                sb.append("Can not load the file from asset: ");
                sb.append(assetFilePath);
                sb.append(". Please double check your asset file name and ensure it's not compressed. See documentation for details how to use aaptOptions to skip file compression");
                throw new FirebaseMLException(sb.toString(), 14, e2);
            } catch (Throwable th2) {
                zzmz.zza(th, th2);
            }
        } else {
            throw new FirebaseMLException("Can not load the model. Either filePath or assetFilePath must be set for the model.", 14);
        }
        throw th;
        throw th;
    }

    public final FirebaseLocalModel zzoc() {
        return this.zzbdv;
    }
}
