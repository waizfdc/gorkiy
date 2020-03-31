package com.google.firebase.ml.common.modeldownload;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.inject.Provider;
import com.google.firebase.ml.common.FirebaseMLException;
import com.google.firebase.ml.common.internal.modeldownload.RemoteModelManagerInterface;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public class FirebaseModelManager {
    private final Map<Class<? extends FirebaseRemoteModel>, Provider<? extends RemoteModelManagerInterface<? extends FirebaseRemoteModel>>> zzbgb = new HashMap();

    public static synchronized FirebaseModelManager getInstance() {
        FirebaseModelManager instance;
        synchronized (FirebaseModelManager.class) {
            instance = getInstance(FirebaseApp.getInstance());
        }
        return instance;
    }

    public static synchronized FirebaseModelManager getInstance(FirebaseApp firebaseApp) {
        FirebaseModelManager firebaseModelManager;
        Class<FirebaseModelManager> cls = FirebaseModelManager.class;
        synchronized (cls) {
            Preconditions.checkNotNull(firebaseApp, "Please provide a valid FirebaseApp");
            firebaseModelManager = (FirebaseModelManager) firebaseApp.get(cls);
        }
        return firebaseModelManager;
    }

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    public static class RemoteModelManagerRegistration {
        private final Class<? extends FirebaseRemoteModel> zzbgf;
        private final Provider<? extends RemoteModelManagerInterface<? extends FirebaseRemoteModel>> zzbgg;

        public <TRemote extends FirebaseRemoteModel> RemoteModelManagerRegistration(Class<TRemote> cls, Provider<? extends RemoteModelManagerInterface<TRemote>> provider) {
            this.zzbgf = cls;
            this.zzbgg = provider;
        }

        /* access modifiers changed from: package-private */
        public final Class<? extends FirebaseRemoteModel> zzoy() {
            return this.zzbgf;
        }

        /* access modifiers changed from: package-private */
        public final Provider<? extends RemoteModelManagerInterface<? extends FirebaseRemoteModel>> zzoz() {
            return this.zzbgg;
        }
    }

    public FirebaseModelManager(Set<RemoteModelManagerRegistration> set) {
        for (RemoteModelManagerRegistration next : set) {
            this.zzbgb.put(next.zzoy(), next.zzoz());
        }
    }

    public Task<Void> download(FirebaseRemoteModel firebaseRemoteModel, FirebaseModelDownloadConditions firebaseModelDownloadConditions) {
        Preconditions.checkNotNull(firebaseRemoteModel, "FirebaseRemoteModel cannot be null");
        Preconditions.checkNotNull(firebaseModelDownloadConditions, "FirebaseModelDownloadConditions cannot be null");
        if (this.zzbgb.containsKey(firebaseRemoteModel.getClass())) {
            return zzg(firebaseRemoteModel.getClass()).download(firebaseRemoteModel, firebaseModelDownloadConditions);
        }
        return Tasks.forException(new FirebaseMLException("Feature model doesn't have a corresponding modelmanager registered.", 13));
    }

    public Task<Void> deleteDownloadedModel(FirebaseRemoteModel firebaseRemoteModel) {
        Preconditions.checkNotNull(firebaseRemoteModel, "FirebaseRemoteModel cannot be null");
        return zzg(firebaseRemoteModel.getClass()).deleteDownloadedModel(firebaseRemoteModel);
    }

    public Task<Boolean> isModelDownloaded(FirebaseRemoteModel firebaseRemoteModel) {
        Preconditions.checkNotNull(firebaseRemoteModel, "FirebaseRemoteModel cannot be null");
        return zzg(firebaseRemoteModel.getClass()).isModelDownloaded(firebaseRemoteModel);
    }

    public <T extends FirebaseRemoteModel> Task<Set<T>> getDownloadedModels(Class<T> cls) {
        return ((RemoteModelManagerInterface) this.zzbgb.get(cls).get()).getDownloadedModels();
    }

    private final RemoteModelManagerInterface<FirebaseRemoteModel> zzg(Class<? extends FirebaseRemoteModel> cls) {
        return (RemoteModelManagerInterface) this.zzbgb.get(cls).get();
    }
}
