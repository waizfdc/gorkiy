package com.google.firebase.ml.vision.automl.internal;

import com.google.android.gms.internal.firebase_ml.zzng;
import com.google.android.gms.internal.firebase_ml.zznu;
import com.google.android.gms.internal.firebase_ml.zzpf;
import com.google.android.gms.internal.firebase_ml.zzpn;
import com.google.android.gms.internal.firebase_ml.zzpo;
import com.google.android.gms.internal.firebase_ml.zzvx;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.ml.common.FirebaseMLException;
import com.google.firebase.ml.common.internal.modeldownload.RemoteModelManagerInterface;
import com.google.firebase.ml.common.internal.modeldownload.zzg;
import com.google.firebase.ml.common.internal.modeldownload.zzi;
import com.google.firebase.ml.common.internal.modeldownload.zzn;
import com.google.firebase.ml.common.internal.modeldownload.zzv;
import com.google.firebase.ml.common.internal.modeldownload.zzw;
import com.google.firebase.ml.common.modeldownload.FirebaseModelDownloadConditions;
import com.google.firebase.ml.common.modeldownload.FirebaseRemoteModel;
import com.google.firebase.ml.vision.automl.FirebaseAutoMLRemoteModel;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public class zza implements RemoteModelManagerInterface<FirebaseAutoMLRemoteModel> {
    private final zzpn zzbdc;
    private final zzpo zzbfe;

    public zza(zzpn zzpn, zzpo zzpo) {
        this.zzbdc = zzpn;
        this.zzbfe = zzpo;
    }

    public Task<Set<FirebaseAutoMLRemoteModel>> getDownloadedModels() {
        return Tasks.forException(new FirebaseMLException("AutoML Remote model does not support listing downloaded models", 12));
    }

    public /* synthetic */ Task isModelDownloaded(FirebaseRemoteModel firebaseRemoteModel) {
        return zzpf.zzno().zza(new zze(this, (FirebaseAutoMLRemoteModel) firebaseRemoteModel)).addOnCompleteListener(new zzd(this));
    }

    public /* synthetic */ Task deleteDownloadedModel(FirebaseRemoteModel firebaseRemoteModel) {
        return Tasks.call(zzpf.zznn(), new zzc(this, (FirebaseAutoMLRemoteModel) firebaseRemoteModel)).addOnCompleteListener(new zzb(this));
    }

    public /* synthetic */ Task download(FirebaseRemoteModel firebaseRemoteModel, FirebaseModelDownloadConditions firebaseModelDownloadConditions) {
        FirebaseAutoMLRemoteModel firebaseAutoMLRemoteModel = (FirebaseAutoMLRemoteModel) firebaseRemoteModel;
        zzpn zzpn = this.zzbdc;
        zzv zza = zzv.zza(zzpn, firebaseAutoMLRemoteModel, new zzg(zzpn), new zzw(this.zzbdc, firebaseAutoMLRemoteModel));
        zza.zza(firebaseModelDownloadConditions);
        return Tasks.forResult(null).onSuccessTask(zzpf.zznn(), new zzf(zza));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(Task task) {
        this.zzbfe.zza(zzng.zzab.zzln().zzb((zzng.zzae) ((zzvx) zzng.zzae.zzlt().zzc(zzng.zzah.zza.AUTOML_IMAGE_LABELING).zzak(((Boolean) task.getResult()).booleanValue()).zztx())), zznu.REMOTE_MODEL_IS_DOWNLOADED);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Boolean zza(FirebaseAutoMLRemoteModel firebaseAutoMLRemoteModel) throws Exception {
        zzpn zzpn = this.zzbdc;
        return Boolean.valueOf(zzv.zza(zzpn, firebaseAutoMLRemoteModel, new zzg(zzpn), new zzw(this.zzbdc, firebaseAutoMLRemoteModel)).zzoo());
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(Task task) {
        this.zzbfe.zza(zzng.zzab.zzln().zzb((zzng.zzy) ((zzvx) zzng.zzy.zzlh().zzb(zzng.zzah.zza.AUTOML_IMAGE_LABELING).zzz(task.isSuccessful()).zztx())), zznu.REMOTE_MODEL_DELETE_ON_DEVICE);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Void zzb(FirebaseAutoMLRemoteModel firebaseAutoMLRemoteModel) throws Exception {
        new zzi(this.zzbdc).zza(zzn.AUTOML, firebaseAutoMLRemoteModel.getModelName());
        return null;
    }
}
