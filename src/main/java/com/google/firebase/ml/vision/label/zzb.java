package com.google.firebase.ml.vision.label;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.util.LinkedList;
import java.util.List;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
final class zzb implements Continuation<List<FirebaseVisionImageLabel>, List<FirebaseVisionImageLabel>> {
    private final /* synthetic */ FirebaseVisionImageLabeler zzbmv;

    zzb(FirebaseVisionImageLabeler firebaseVisionImageLabeler) {
        this.zzbmv = firebaseVisionImageLabeler;
    }

    public final /* synthetic */ Object then(Task task) throws Exception {
        LinkedList linkedList = new LinkedList();
        for (FirebaseVisionImageLabel firebaseVisionImageLabel : (List) task.getResult()) {
            if (Float.compare(firebaseVisionImageLabel.getConfidence(), this.zzbmv.zzbmq.getConfidenceThreshold()) >= 0) {
                linkedList.add(firebaseVisionImageLabel);
            }
        }
        return linkedList;
    }
}
