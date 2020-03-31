package com.askgps.personaltrackercore.ui.infoscreen;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlinx.coroutines.Job;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u000bR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/askgps/personaltrackercore/ui/infoscreen/InfoViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "vibrate", "Landroidx/lifecycle/MutableLiveData;", "", "getVibrate", "()Landroidx/lifecycle/MutableLiveData;", "vibrationJob", "Lkotlinx/coroutines/Job;", "startVibration", "", "stopVibrate", "Companion", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: InfoViewModel.kt */
public final class InfoViewModel extends ViewModel {
    public static final Companion Companion = new Companion(null);
    public static final long VIBRATION_DELAY = 1000;
    private final MutableLiveData<Boolean> vibrate = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public Job vibrationJob;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/askgps/personaltrackercore/ui/infoscreen/InfoViewModel$Companion;", "", "()V", "VIBRATION_DELAY", "", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: InfoViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final MutableLiveData<Boolean> getVibrate() {
        return this.vibrate;
    }

    public final void startVibration() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(super), null, null, new InfoViewModel$startVibration$1(this, null), 3, null);
    }

    public final void stopVibrate() {
        Job job = this.vibrationJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
    }
}
