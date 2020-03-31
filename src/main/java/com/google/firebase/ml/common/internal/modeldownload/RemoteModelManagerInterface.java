package com.google.firebase.ml.common.internal.modeldownload;

import com.google.android.gms.tasks.Task;
import com.google.firebase.ml.common.modeldownload.FirebaseModelDownloadConditions;
import com.google.firebase.ml.common.modeldownload.FirebaseRemoteModel;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public interface RemoteModelManagerInterface<TRemote extends FirebaseRemoteModel> {
    Task<Void> deleteDownloadedModel(TRemote tremote);

    Task<Void> download(TRemote tremote, FirebaseModelDownloadConditions firebaseModelDownloadConditions);

    Task<Set<TRemote>> getDownloadedModels();

    Task<Boolean> isModelDownloaded(TRemote tremote);
}
