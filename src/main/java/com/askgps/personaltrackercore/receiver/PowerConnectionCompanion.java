package com.askgps.personaltrackercore.receiver;

import com.askgps.personaltrackercore.LogKt;
import com.askgps.personaltrackercore.repository.Repository;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.koin.core.Koin;
import org.koin.core.KoinComponent;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0010R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/askgps/personaltrackercore/receiver/PowerConnectionCompanion;", "Lorg/koin/core/KoinComponent;", "()V", "alarmJob", "Lkotlinx/coroutines/Job;", "job", "Lkotlinx/coroutines/CompletableJob;", "repo", "Lcom/askgps/personaltrackercore/repository/Repository;", "getRepo", "()Lcom/askgps/personaltrackercore/repository/Repository;", "repo$delegate", "Lkotlin/Lazy;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "startJob", "", "stopJob", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: PowerConnectionReceiver.kt */
public final class PowerConnectionCompanion implements KoinComponent {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(PowerConnectionCompanion.class), "repo", "getRepo()Lcom/askgps/personaltrackercore/repository/Repository;"))};
    /* access modifiers changed from: private */
    public Job alarmJob;
    private final CompletableJob job = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null);
    private final Lazy repo$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new PowerConnectionCompanion$$special$$inlined$inject$1(this, null, null));
    private final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault().plus(this.job));

    /* access modifiers changed from: private */
    public final Repository getRepo() {
        Lazy lazy = this.repo$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (Repository) lazy.getValue();
    }

    public Koin getKoin() {
        return KoinComponent.DefaultImpls.getKoin(this);
    }

    public final void startJob() {
        Job job2 = this.alarmJob;
        if (job2 == null || !job2.isActive()) {
            this.alarmJob = BuildersKt__Builders_commonKt.launch$default(this.scope, Dispatchers.getDefault(), null, new PowerConnectionCompanion$startJob$1(this, null), 2, null);
        } else {
            LogKt.toFile$default(this, "Alarm job already started", null, null, 6, null);
        }
    }

    public final void stopJob() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new PowerConnectionCompanion$stopJob$1(this, null), 3, null);
    }
}
