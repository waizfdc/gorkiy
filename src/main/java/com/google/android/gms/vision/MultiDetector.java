package com.google.android.gms.vision;

import android.util.SparseArray;
import com.google.android.gms.vision.Detector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
public class MultiDetector extends Detector<Object> {
    /* access modifiers changed from: private */
    public List<Detector<? extends Object>> zzaw;

    public void release() {
        for (Detector<? extends Object> superR : this.zzaw) {
            superR.release();
        }
        this.zzaw.clear();
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
    public static class Builder {
        private MultiDetector zzaz = new MultiDetector();

        public Builder add(Detector<? extends Object> detector) {
            this.zzaz.zzaw.add(detector);
            return this;
        }

        public MultiDetector build() {
            if (this.zzaz.zzaw.size() != 0) {
                return this.zzaz;
            }
            throw new RuntimeException("No underlying detectors added to MultiDetector.");
        }
    }

    public SparseArray<Object> detect(Frame frame) {
        SparseArray<Object> sparseArray = new SparseArray<>();
        for (Detector<? extends Object> superR : this.zzaw) {
            SparseArray detect = superR.detect(frame);
            int i = 0;
            while (true) {
                if (i < detect.size()) {
                    int keyAt = detect.keyAt(i);
                    if (sparseArray.get(keyAt) == null) {
                        sparseArray.append(keyAt, detect.valueAt(i));
                        i++;
                    } else {
                        StringBuilder sb = new StringBuilder(104);
                        sb.append("Detection ID overlap for id = ");
                        sb.append(keyAt);
                        sb.append("  This means that one of the detectors is not using global IDs.");
                        throw new IllegalStateException(sb.toString());
                    }
                }
            }
        }
        return sparseArray;
    }

    public void receiveFrame(Frame frame) {
        for (Detector<? extends Object> superR : this.zzaw) {
            superR.receiveFrame(frame);
        }
    }

    public void setProcessor(Detector.Processor<Object> processor) {
        throw new UnsupportedOperationException("MultiDetector.setProcessor is not supported.  You should set a processor instance on each underlying detector instead.");
    }

    public boolean isOperational() {
        for (Detector<? extends Object> superR : this.zzaw) {
            if (!superR.isOperational()) {
                return false;
            }
        }
        return true;
    }

    private MultiDetector() {
        this.zzaw = new ArrayList();
    }
}
