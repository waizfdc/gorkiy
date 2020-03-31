package com.askgps.personaltrackercore.repository;

import android.location.Location;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0014\u0010\u0002\u001a\u0010\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u00040\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "Lcom/google/android/gms/tasks/Task;", "Landroid/location/Location;", "kotlin.jvm.PlatformType", "onComplete"}, k = 3, mv = {1, 1, 16})
/* compiled from: Repository.kt */
final class Repository$startIdentificationAsync$1<TResult> implements OnCompleteListener<Location> {
    final /* synthetic */ String $id;
    final /* synthetic */ Repository this$0;

    Repository$startIdentificationAsync$1(Repository repository, String str) {
        this.this$0 = repository;
        this.$id = str;
    }

    public final void onComplete(Task<Location> task) {
        Intrinsics.checkParameterIsNotNull(task, "it");
        Repository repository = this.this$0;
        String value = repository.getImei().getValue();
        if (value == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(value, "imei.value!!");
        boolean startWork = repository.startWork(value, this.$id, task.getResult());
        this.this$0.identificationSuccess(startWork);
        if (startWork) {
            this.this$0.getDatabaseHelper().settingsDao().setWorkIsStart(startWork);
        }
        Repository repository2 = this.this$0;
        String value2 = repository2.getImei().getValue();
        if (value2 == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(value2, "imei.value!!");
        Repository.sendWorkIsStart$default(repository2, value2, startWork, null, 4, null);
    }
}
