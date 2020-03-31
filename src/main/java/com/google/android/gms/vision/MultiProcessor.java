package com.google.android.gms.vision;

import android.util.SparseArray;
import com.google.android.gms.vision.Detector;
import java.util.HashSet;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
public class MultiProcessor<T> implements Detector.Processor<T> {
    /* access modifiers changed from: private */
    public int zzak;
    /* access modifiers changed from: private */
    public Factory<T> zzax;
    private SparseArray<zza> zzay;

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
    public interface Factory<T> {
        Tracker<T> create(T t);
    }

    public void release() {
        for (int i = 0; i < this.zzay.size(); i++) {
            this.zzay.valueAt(i).zzaj.onDone();
        }
        this.zzay.clear();
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
    class zza {
        /* access modifiers changed from: private */
        public Tracker<T> zzaj;
        /* access modifiers changed from: private */
        public int zzan;

        private zza(MultiProcessor multiProcessor) {
            this.zzan = 0;
        }

        static /* synthetic */ int zzb(zza zza) {
            int i = zza.zzan;
            zza.zzan = i + 1;
            return i;
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
    public static class Builder<T> {
        private MultiProcessor<T> zzba;

        public Builder(Factory<T> factory) {
            MultiProcessor<T> multiProcessor = new MultiProcessor<>();
            this.zzba = multiProcessor;
            if (factory != null) {
                Factory unused = multiProcessor.zzax = factory;
                return;
            }
            throw new IllegalArgumentException("No factory supplied.");
        }

        public Builder<T> setMaxGapFrames(int i) {
            if (i >= 0) {
                int unused = this.zzba.zzak = i;
                return this;
            }
            StringBuilder sb = new StringBuilder(28);
            sb.append("Invalid max gap: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        }

        public MultiProcessor<T> build() {
            return this.zzba;
        }
    }

    public void receiveDetections(Detector.Detections<T> detections) {
        SparseArray<T> detectedItems = detections.getDetectedItems();
        for (int i = 0; i < detectedItems.size(); i++) {
            int keyAt = detectedItems.keyAt(i);
            T valueAt = detectedItems.valueAt(i);
            if (this.zzay.get(keyAt) == null) {
                zza zza2 = new zza();
                Tracker unused = zza2.zzaj = this.zzax.create(valueAt);
                zza2.zzaj.onNewItem(keyAt, valueAt);
                this.zzay.append(keyAt, zza2);
            }
        }
        SparseArray<T> detectedItems2 = detections.getDetectedItems();
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i2 = 0; i2 < this.zzay.size(); i2++) {
            int keyAt2 = this.zzay.keyAt(i2);
            if (detectedItems2.get(keyAt2) == null) {
                zza valueAt2 = this.zzay.valueAt(i2);
                zza.zzb(valueAt2);
                if (valueAt2.zzan >= this.zzak) {
                    valueAt2.zzaj.onDone();
                    hashSet.add(Integer.valueOf(keyAt2));
                } else {
                    valueAt2.zzaj.onMissing(detections);
                }
            }
        }
        for (Integer intValue : hashSet) {
            this.zzay.delete(intValue.intValue());
        }
        SparseArray<T> detectedItems3 = detections.getDetectedItems();
        for (int i3 = 0; i3 < detectedItems3.size(); i3++) {
            int keyAt3 = detectedItems3.keyAt(i3);
            T valueAt3 = detectedItems3.valueAt(i3);
            zza zza3 = this.zzay.get(keyAt3);
            int unused2 = zza3.zzan = 0;
            zza3.zzaj.onUpdate(detections, valueAt3);
        }
    }

    private MultiProcessor() {
        this.zzay = new SparseArray<>();
        this.zzak = 3;
    }
}
