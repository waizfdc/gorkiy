package com.askgps.personaltrackercore.ui.sos;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.askgps.personaltrackercore.LogKt;
import com.askgps.personaltrackercore.repository.Repository;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.Job;
import org.koin.core.Koin;
import org.koin.core.KoinComponent;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00172\u00020\u00012\u00020\u0002:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\u0006\u0010\u0016\u001a\u00020\u0014R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001f\u0010\n\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/askgps/personaltrackercore/ui/sos/SosViewModel;", "Landroidx/lifecycle/ViewModel;", "Lorg/koin/core/KoinComponent;", "()V", "repo", "Lcom/askgps/personaltrackercore/repository/Repository;", "getRepo", "()Lcom/askgps/personaltrackercore/repository/Repository;", "repo$delegate", "Lkotlin/Lazy;", "timer", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "getTimer", "()Landroidx/lifecycle/MutableLiveData;", "timerCounter", "timerJob", "Lkotlinx/coroutines/Job;", "cancel", "", "sendSos", "startTimer", "Companion", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: SosViewModel.kt */
public final class SosViewModel extends ViewModel implements KoinComponent {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(SosViewModel.class), "repo", "getRepo()Lcom/askgps/personaltrackercore/repository/Repository;"))};
    public static final Companion Companion = new Companion(null);
    public static final long DELAY_SEC = 1000;
    public static final int START_TIMER = 5;
    private final Lazy repo$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new SosViewModel$$special$$inlined$inject$1(this, null, null));
    private final MutableLiveData<Integer> timer = new MutableLiveData<>(5);
    /* access modifiers changed from: private */
    public int timerCounter = 5;
    private Job timerJob;

    private final Repository getRepo() {
        Lazy lazy = this.repo$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (Repository) lazy.getValue();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/askgps/personaltrackercore/ui/sos/SosViewModel$Companion;", "", "()V", "DELAY_SEC", "", "START_TIMER", "", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: SosViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public Koin getKoin() {
        return KoinComponent.DefaultImpls.getKoin(this);
    }

    public final MutableLiveData<Integer> getTimer() {
        return this.timer;
    }

    public final void startTimer() {
        Job job = this.timerJob;
        if (job == null || !job.isActive()) {
            try {
                this.timerJob = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(super), null, null, new SosViewModel$startTimer$1(this, null), 3, null);
            } catch (CancellationException unused) {
                LogKt.toLog$default("cancel timer", (String) null, (String) null, (String) null, 7, (Object) null);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void sendSos() {
        getRepo().processingSosMessage();
    }

    public final void cancel() {
        Job job = this.timerJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
    }
}
