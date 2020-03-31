package com.google.android.gms.vision.label;

import android.content.Context;
import android.util.SparseArray;
import com.google.android.gms.internal.vision.zzp;
import com.google.android.gms.internal.vision.zzq;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.label.internal.client.ImageLabelerOptions;
import com.google.android.gms.vision.label.internal.client.LabelOptions;
import com.google.android.gms.vision.label.internal.client.zzi;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-vision-image-label@@18.0.1 */
public class ImageLabeler extends Detector<ImageLabel> {
    private static final LabelOptions zzdm = new LabelOptions(-1);
    private final zzi zzdl;

    private ImageLabeler(zzi zzi) {
        this.zzdl = zzi;
    }

    public SparseArray<ImageLabel> detect(Frame frame) {
        return detect(frame, zzdm);
    }

    /* compiled from: com.google.android.gms:play-services-vision-image-label@@18.0.1 */
    public static class Builder {
        private ImageLabelerOptions zzdp = new ImageLabelerOptions(ImageLabelerOptions.zza(Locale.getDefault().getLanguage()), -1, 0.5f, 1);
        private Context zze;

        public Builder(Context context) {
            this.zze = context;
        }

        public Builder setScoreThreshold(float f) {
            if (f < 0.0f || f > 1.0f) {
                throw new IllegalArgumentException("scoreThreshold should be between [0, 1]");
            }
            this.zzdp.zzdu = f;
            return this;
        }

        public ImageLabeler build() {
            return new ImageLabeler(new zzi(this.zze, this.zzdp));
        }
    }

    public SparseArray<ImageLabel> detect(Frame frame, LabelOptions labelOptions) {
        if (frame != null) {
            ImageLabel[] zza = this.zzdl.zza(zzq.zzb(frame.getBitmap(), zzp.zzc(frame)), labelOptions);
            SparseArray<ImageLabel> sparseArray = new SparseArray<>(zza.length);
            for (int i = 0; i < zza.length; i++) {
                sparseArray.append(i, zza[i]);
            }
            return sparseArray;
        }
        throw new IllegalArgumentException("No frame supplied.");
    }

    public boolean isOperational() {
        return this.zzdl.isOperational();
    }

    public void release() {
        super.release();
        this.zzdl.zzo();
    }
}
