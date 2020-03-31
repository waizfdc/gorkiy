package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.fitness.FitnessActivities;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\b\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0002¢\u0006\u0002\b\u0002\u001a»\u0001\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u0006\"\u0004\b\u0001\u0010\u0007\"\u0004\b\u0002\u0010\b\"\u0004\b\u0003\u0010\t\"\u0004\b\u0004\u0010\n\"\u0004\b\u0005\u0010\u0005*\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\b0\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\t0\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\n0\u00042<\b\u0004\u0010\u000f\u001a6\b\u0001\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\n\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0010H\bø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001a¡\u0001\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u0006\"\u0004\b\u0001\u0010\u0007\"\u0004\b\u0002\u0010\b\"\u0004\b\u0003\u0010\t\"\u0004\b\u0004\u0010\u0005*\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\b0\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\t0\u000426\b\u0004\u0010\u000f\u001a0\b\u0001\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\t\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0014H\bø\u0001\u0000¢\u0006\u0002\u0010\u0015\u001a\u0001\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u0006\"\u0004\b\u0001\u0010\u0007\"\u0004\b\u0002\u0010\b\"\u0004\b\u0003\u0010\u0005*\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\b0\u000420\b\u0004\u0010\u000f\u001a*\b\u0001\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0016H\bø\u0001\u0000¢\u0006\u0002\u0010\u0017\u001aj\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u0006\"\u0004\b\u0001\u0010\u0007\"\u0004\b\u0002\u0010\u0005*\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042(\u0010\u000f\u001a$\b\u0001\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0018H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0019\u001aI\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u001b\"\u0004\b\u0001\u0010\u0005*\b\u0012\u0004\u0012\u0002H\u001b0\u00042#\u0010\u001c\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001b0\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u00040\u001d¢\u0006\u0002\b\u001eH\u0007\u001a>\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u001b\"\u0004\b\u0001\u0010\u0005*\b\u0012\u0004\u0012\u0002H\u001b0\u00042\u0018\u0010 \u001a\u0014\u0012\u0004\u0012\u0002H\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u00040\u001dH\u0007\u001a+\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u0004\"\u0004\b\u0000\u0010\u001b*\b\u0012\u0004\u0012\u0002H\u001b0\u00042\u0006\u0010\"\u001a\u0002H\u001bH\u0007¢\u0006\u0002\u0010#\u001a,\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u0004\"\u0004\b\u0000\u0010\u001b*\b\u0012\u0004\u0012\u0002H\u001b0\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u0004H\u0007\u001a&\u0010$\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u0004\"\u0004\b\u0000\u0010\u001b*\b\u0012\u0004\u0012\u0002H\u001b0\u00042\u0006\u0010%\u001a\u00020&H\u0007\u001a&\u0010'\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u0004\"\u0004\b\u0000\u0010\u001b*\b\u0012\u0004\u0012\u0002H\u001b0\u00042\u0006\u0010%\u001a\u00020&H\u0007\u001aV\u0010(\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u001b\"\u0004\b\u0001\u0010\u0005*\b\u0012\u0004\u0012\u0002H\u001b0\u00042(\u0010 \u001a$\b\u0001\u0012\u0004\u0012\u0002H\u001b\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u00040\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00120)H\u0007ø\u0001\u0000¢\u0006\u0002\u0010*\u001a$\u0010+\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u0004\"\u0004\b\u0000\u0010\u001b*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001b0\u00040\u0004H\u0007\u001aS\u0010,\u001a\u00020-\"\u0004\b\u0000\u0010\u001b*\b\u0012\u0004\u0012\u0002H\u001b0\u000421\u0010.\u001a-\b\u0001\u0012\u0013\u0012\u0011H\u001b¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00120)H\u0007ø\u0001\u0000¢\u0006\u0002\u00101\u001a$\u00102\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u0004\"\u0004\b\u0000\u0010\u001b*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001b0\u00040\u0004H\u0007\u001a&\u00103\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u0004\"\u0004\b\u0000\u0010\u001b*\b\u0012\u0004\u0012\u0002H\u001b0\u00042\u0006\u00104\u001a\u000205H\u0007\u001a,\u00106\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u0004\"\u0004\b\u0000\u0010\u001b*\b\u0012\u0004\u0012\u0002H\u001b0\u00042\f\u00107\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u0004H\u0007\u001a,\u00108\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u0004\"\u0004\b\u0000\u0010\u001b*\b\u0012\u0004\u0012\u0002H\u001b0\u00042\f\u00107\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u0004H\u0007\u001a+\u00109\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u0004\"\u0004\b\u0000\u0010\u001b*\b\u0012\u0004\u0012\u0002H\u001b0\u00042\u0006\u00107\u001a\u0002H\u001bH\u0007¢\u0006\u0002\u0010#\u001aA\u00109\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u0004\"\u0004\b\u0000\u0010\u001b*\b\u0012\u0004\u0012\u0002H\u001b0\u00042\u0006\u00107\u001a\u0002H\u001b2\u0014\b\u0002\u0010:\u001a\u000e\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020<0\u001dH\u0007¢\u0006\u0002\u0010=\u001a&\u0010>\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u0004\"\u0004\b\u0000\u0010\u001b*\b\u0012\u0004\u0012\u0002H\u001b0\u00042\u0006\u00104\u001a\u000205H\u0007\u001a~\u0010?\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u001b\"\u0004\b\u0001\u0010\u0005*\b\u0012\u0004\u0012\u0002H\u001b0\u00042\u0006\u0010@\u001a\u0002H\u00052H\b\u0001\u0010A\u001aB\b\u0001\u0012\u0013\u0012\u0011H\u0005¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(B\u0012\u0013\u0012\u0011H\u001b¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(\"\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0018H\u0007ø\u0001\u0000¢\u0006\u0002\u0010C\u001a&\u0010D\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u0004\"\u0004\b\u0000\u0010\u001b*\b\u0012\u0004\u0012\u0002H\u001b0\u00042\u0006\u0010E\u001a\u00020FH\u0007\u001a+\u0010G\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u0004\"\u0004\b\u0000\u0010\u001b*\b\u0012\u0004\u0012\u0002H\u001b0\u00042\u0006\u0010\"\u001a\u0002H\u001bH\u0007¢\u0006\u0002\u0010#\u001a,\u0010G\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u0004\"\u0004\b\u0000\u0010\u001b*\b\u0012\u0004\u0012\u0002H\u001b0\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u0004H\u0007\u001a\u0018\u0010H\u001a\u00020-\"\u0004\b\u0000\u0010\u001b*\b\u0012\u0004\u0012\u0002H\u001b0\u0004H\u0007\u001aD\u0010H\u001a\u00020-\"\u0004\b\u0000\u0010\u001b*\b\u0012\u0004\u0012\u0002H\u001b0\u00042\"\u0010I\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00120)H\u0007ø\u0001\u0000¢\u0006\u0002\u00101\u001ah\u0010H\u001a\u00020-\"\u0004\b\u0000\u0010\u001b*\b\u0012\u0004\u0012\u0002H\u001b0\u00042\"\u0010I\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00120)2\"\u0010J\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020;\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00120)H\u0007ø\u0001\u0000¢\u0006\u0002\u0010K\u001a&\u0010L\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u0004\"\u0004\b\u0000\u0010\u001b*\b\u0012\u0004\u0012\u0002H\u001b0\u00042\u0006\u00104\u001a\u000205H\u0007\u001ae\u0010M\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u001b\"\u0004\b\u0001\u0010\u0005*\b\u0012\u0004\u0012\u0002H\u001b0\u000427\u0010\u000f\u001a3\b\u0001\u0012\u0013\u0012\u0011H\u001b¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(\"\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u00040\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00120)H\u0007ø\u0001\u0000¢\u0006\u0002\u0010*\u0002\u0004\n\u0002\b\u0019¨\u0006N"}, d2 = {"noImpl", "", "noImpl$FlowKt__MigrationKt", "combineLatest", "Lkotlinx/coroutines/flow/Flow;", "R", "T1", "T2", "T3", "T4", "T5", FitnessActivities.OTHER, "other2", "other3", "other4", "transform", "Lkotlin/Function6;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function6;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function5;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function5;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function4;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function4;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function3;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "compose", ExifInterface.GPS_DIRECTION_TRUE, "transformer", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "concatMap", "mapper", "concatWith", "value", "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/Object;)Lkotlinx/coroutines/flow/Flow;", "delayEach", "timeMillis", "", "delayFlow", "flatMap", "Lkotlin/Function2;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "flatten", "forEach", "", "action", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;)V", "merge", "observeOn", "context", "Lkotlin/coroutines/CoroutineContext;", "onErrorResume", "fallback", "onErrorResumeNext", "onErrorReturn", "predicate", "", "", "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/flow/Flow;", "publishOn", "scanFold", "initial", "operation", "accumulator", "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "skip", "count", "", "startWith", "subscribe", "onEach", "onError", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "subscribeOn", "switchMap", "kotlinx-coroutines-core"}, k = 5, mv = {1, 1, 16}, xs = "kotlinx/coroutines/flow/FlowKt")
/* compiled from: Migration.kt */
final /* synthetic */ class FlowKt__MigrationKt {
    private static final Void noImpl$FlowKt__MigrationKt() {
        throw new UnsupportedOperationException("Not implemented, should not be called");
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Collect flow in the desired context instead")
    public static final <T> Flow<T> observeOn(Flow<? extends T> flow, CoroutineContext coroutineContext) {
        Intrinsics.checkParameterIsNotNull(flow, "$this$observeOn");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        noImpl$FlowKt__MigrationKt();
        throw null;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Collect flow in the desired context instead")
    public static final <T> Flow<T> publishOn(Flow<? extends T> flow, CoroutineContext coroutineContext) {
        Intrinsics.checkParameterIsNotNull(flow, "$this$publishOn");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        noImpl$FlowKt__MigrationKt();
        throw null;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use flowOn instead")
    public static final <T> Flow<T> subscribeOn(Flow<? extends T> flow, CoroutineContext coroutineContext) {
        Intrinsics.checkParameterIsNotNull(flow, "$this$subscribeOn");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        noImpl$FlowKt__MigrationKt();
        throw null;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emitAll(fallback) }'", replaceWith = @ReplaceWith(expression = "catch { emitAll(fallback) }", imports = {}))
    public static final <T> Flow<T> onErrorResume(Flow<? extends T> flow, Flow<? extends T> flow2) {
        Intrinsics.checkParameterIsNotNull(flow, "$this$onErrorResume");
        Intrinsics.checkParameterIsNotNull(flow2, "fallback");
        noImpl$FlowKt__MigrationKt();
        throw null;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emitAll(fallback) }'", replaceWith = @ReplaceWith(expression = "catch { emitAll(fallback) }", imports = {}))
    public static final <T> Flow<T> onErrorResumeNext(Flow<? extends T> flow, Flow<? extends T> flow2) {
        Intrinsics.checkParameterIsNotNull(flow, "$this$onErrorResumeNext");
        Intrinsics.checkParameterIsNotNull(flow2, "fallback");
        noImpl$FlowKt__MigrationKt();
        throw null;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use launchIn with onEach, onCompletion and catch operators instead")
    public static final <T> void subscribe(Flow<? extends T> flow) {
        Intrinsics.checkParameterIsNotNull(flow, "$this$subscribe");
        noImpl$FlowKt__MigrationKt();
        throw null;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use launchIn with onEach, onCompletion and catch operators instead")
    public static final <T> void subscribe(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.checkParameterIsNotNull(flow, "$this$subscribe");
        Intrinsics.checkParameterIsNotNull(function2, "onEach");
        noImpl$FlowKt__MigrationKt();
        throw null;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use launchIn with onEach, onCompletion and catch operators instead")
    public static final <T> void subscribe(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2, Function2<? super Throwable, ? super Continuation<? super Unit>, ? extends Object> function22) {
        Intrinsics.checkParameterIsNotNull(flow, "$this$subscribe");
        Intrinsics.checkParameterIsNotNull(function2, "onEach");
        Intrinsics.checkParameterIsNotNull(function22, "onError");
        noImpl$FlowKt__MigrationKt();
        throw null;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue is named flatMapConcat", replaceWith = @ReplaceWith(expression = "flatMapConcat(mapper)", imports = {}))
    public static final <T, R> Flow<R> flatMap(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> function2) {
        Intrinsics.checkParameterIsNotNull(flow, "$this$flatMap");
        Intrinsics.checkParameterIsNotNull(function2, "mapper");
        noImpl$FlowKt__MigrationKt();
        throw null;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'concatMap' is 'flatMapConcat'", replaceWith = @ReplaceWith(expression = "flatMapConcat(mapper)", imports = {}))
    public static final <T, R> Flow<R> concatMap(Flow<? extends T> flow, Function1<? super T, ? extends Flow<? extends R>> function1) {
        Intrinsics.checkParameterIsNotNull(flow, "$this$concatMap");
        Intrinsics.checkParameterIsNotNull(function1, "mapper");
        noImpl$FlowKt__MigrationKt();
        throw null;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'merge' is 'flattenConcat'", replaceWith = @ReplaceWith(expression = "flattenConcat()", imports = {}))
    public static final <T> Flow<T> merge(Flow<? extends Flow<? extends T>> flow) {
        Intrinsics.checkParameterIsNotNull(flow, "$this$merge");
        noImpl$FlowKt__MigrationKt();
        throw null;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'flatten' is 'flattenConcat'", replaceWith = @ReplaceWith(expression = "flattenConcat()", imports = {}))
    public static final <T> Flow<T> flatten(Flow<? extends Flow<? extends T>> flow) {
        Intrinsics.checkParameterIsNotNull(flow, "$this$flatten");
        noImpl$FlowKt__MigrationKt();
        throw null;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'compose' is 'let'", replaceWith = @ReplaceWith(expression = "let(transformer)", imports = {}))
    public static final <T, R> Flow<R> compose(Flow<? extends T> flow, Function1<? super Flow<? extends T>, ? extends Flow<? extends R>> function1) {
        Intrinsics.checkParameterIsNotNull(flow, "$this$compose");
        Intrinsics.checkParameterIsNotNull(function1, "transformer");
        noImpl$FlowKt__MigrationKt();
        throw null;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'skip' is 'drop'", replaceWith = @ReplaceWith(expression = "drop(count)", imports = {}))
    public static final <T> Flow<T> skip(Flow<? extends T> flow, int i) {
        Intrinsics.checkParameterIsNotNull(flow, "$this$skip");
        noImpl$FlowKt__MigrationKt();
        throw null;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'forEach' is 'collect'", replaceWith = @ReplaceWith(expression = "collect(block)", imports = {}))
    public static final <T> void forEach(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.checkParameterIsNotNull(flow, "$this$forEach");
        Intrinsics.checkParameterIsNotNull(function2, "action");
        noImpl$FlowKt__MigrationKt();
        throw null;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow has less verbose 'scan' shortcut", replaceWith = @ReplaceWith(expression = "scan(initial, operation)", imports = {}))
    public static final <T, R> Flow<R> scanFold(Flow<? extends T> flow, R r, Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> function3) {
        Intrinsics.checkParameterIsNotNull(flow, "$this$scanFold");
        Intrinsics.checkParameterIsNotNull(function3, "operation");
        noImpl$FlowKt__MigrationKt();
        throw null;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emit(fallback) }'", replaceWith = @ReplaceWith(expression = "catch { emit(fallback) }", imports = {}))
    public static final <T> Flow<T> onErrorReturn(Flow<? extends T> flow, T t) {
        Intrinsics.checkParameterIsNotNull(flow, "$this$onErrorReturn");
        noImpl$FlowKt__MigrationKt();
        throw null;
    }

    public static /* synthetic */ Flow onErrorReturn$default(Flow flow, Object obj, Function1 function1, int i, Object obj2) {
        if ((i & 2) != 0) {
            function1 = FlowKt__MigrationKt$onErrorReturn$1.INSTANCE;
        }
        return FlowKt.onErrorReturn(flow, obj, function1);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { e -> if (predicate(e)) emit(fallback) else throw e }'", replaceWith = @ReplaceWith(expression = "catch { e -> if (predicate(e)) emit(fallback) else throw e }", imports = {}))
    public static final <T> Flow<T> onErrorReturn(Flow<? extends T> flow, T t, Function1<? super Throwable, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(flow, "$this$onErrorReturn");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        return FlowKt.m1024catch(flow, new FlowKt__MigrationKt$onErrorReturn$2(function1, t, null));
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'startWith' is 'onStart'. Use 'onStart { emit(value) }'", replaceWith = @ReplaceWith(expression = "onStart { emit(value) }", imports = {}))
    public static final <T> Flow<T> startWith(Flow flow, Object obj) {
        Intrinsics.checkParameterIsNotNull(flow, "$this$startWith");
        noImpl$FlowKt__MigrationKt();
        throw null;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'startWith' is 'onStart'. Use 'onStart { emitAll(other) }'", replaceWith = @ReplaceWith(expression = "onStart { emitAll(other) }", imports = {}))
    public static final <T> Flow<T> startWith(Flow flow, Flow flow2) {
        Intrinsics.checkParameterIsNotNull(flow, "$this$startWith");
        Intrinsics.checkParameterIsNotNull(flow2, FitnessActivities.OTHER);
        noImpl$FlowKt__MigrationKt();
        throw null;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'concatWith' is 'onCompletion'. Use 'onCompletion { emit(value) }'", replaceWith = @ReplaceWith(expression = "onCompletion { emit(value) }", imports = {}))
    public static final <T> Flow<T> concatWith(Flow flow, Object obj) {
        Intrinsics.checkParameterIsNotNull(flow, "$this$concatWith");
        noImpl$FlowKt__MigrationKt();
        throw null;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'concatWith' is 'onCompletion'. Use 'onCompletion { emitAll(other) }'", replaceWith = @ReplaceWith(expression = "onCompletion { emitAll(other) }", imports = {}))
    public static final <T> Flow<T> concatWith(Flow flow, Flow flow2) {
        Intrinsics.checkParameterIsNotNull(flow, "$this$concatWith");
        Intrinsics.checkParameterIsNotNull(flow2, FitnessActivities.OTHER);
        noImpl$FlowKt__MigrationKt();
        throw null;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [kotlin.jvm.functions.Function3<? super T1, ? super T2, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object>, kotlin.jvm.functions.Function3, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @kotlin.ReplaceWith(expression = "this.combine(other, transform)", imports = {}))
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T1, T2, R> kotlinx.coroutines.flow.Flow<R> combineLatest(kotlinx.coroutines.flow.Flow<? extends T1> r1, kotlinx.coroutines.flow.Flow<? extends T2> r2, kotlin.jvm.functions.Function3<? super T1, ? super T2, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> r3) {
        /*
            java.lang.String r0 = "$this$combineLatest"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r1, r0)
            java.lang.String r0 = "other"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r2, r0)
            java.lang.String r0 = "transform"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r0)
            kotlinx.coroutines.flow.Flow r1 = kotlinx.coroutines.flow.FlowKt.combine(r1, r2, r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__MigrationKt.combineLatest(kotlinx.coroutines.flow.Flow, kotlinx.coroutines.flow.Flow, kotlin.jvm.functions.Function3):kotlinx.coroutines.flow.Flow");
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use 'onStart { delay(timeMillis) }'", replaceWith = @ReplaceWith(expression = "onStart { delay(timeMillis) }", imports = {}))
    public static final <T> Flow<T> delayFlow(Flow<? extends T> flow, long j) {
        Intrinsics.checkParameterIsNotNull(flow, "$this$delayFlow");
        return FlowKt.onStart(flow, new FlowKt__MigrationKt$delayFlow$1(j, null));
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use 'onEach { delay(timeMillis) }'", replaceWith = @ReplaceWith(expression = "onEach { delay(timeMillis) }", imports = {}))
    public static final <T> Flow<T> delayEach(Flow<? extends T> flow, long j) {
        Intrinsics.checkParameterIsNotNull(flow, "$this$delayEach");
        return FlowKt.onEach(flow, new FlowKt__MigrationKt$delayEach$1(j, null));
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @ReplaceWith(expression = "combine(this, other, other2, transform)", imports = {}))
    public static final <T1, T2, T3, R> Flow<R> combineLatest(Flow<? extends T1> flow, Flow<? extends T2> flow2, Flow<? extends T3> flow3, Function4<? super T1, ? super T2, ? super T3, ? super Continuation<? super R>, ? extends Object> function4) {
        Intrinsics.checkParameterIsNotNull(flow, "$this$combineLatest");
        Intrinsics.checkParameterIsNotNull(flow2, FitnessActivities.OTHER);
        Intrinsics.checkParameterIsNotNull(flow3, "other2");
        Intrinsics.checkParameterIsNotNull(function4, "transform");
        return new FlowKt__MigrationKt$combineLatest$$inlined$combine$1(new Flow[]{flow, flow2, flow3}, function4);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @ReplaceWith(expression = "combine(this, other, other2, other3, transform)", imports = {}))
    public static final <T1, T2, T3, T4, R> Flow<R> combineLatest(Flow<? extends T1> flow, Flow<? extends T2> flow2, Flow<? extends T3> flow3, Flow<? extends T4> flow4, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super Continuation<? super R>, ? extends Object> function5) {
        Intrinsics.checkParameterIsNotNull(flow, "$this$combineLatest");
        Intrinsics.checkParameterIsNotNull(flow2, FitnessActivities.OTHER);
        Intrinsics.checkParameterIsNotNull(flow3, "other2");
        Intrinsics.checkParameterIsNotNull(flow4, "other3");
        Intrinsics.checkParameterIsNotNull(function5, "transform");
        return new FlowKt__MigrationKt$combineLatest$$inlined$combine$2(new Flow[]{flow, flow2, flow3, flow4}, function5);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @ReplaceWith(expression = "combine(this, other, other2, other3, transform)", imports = {}))
    public static final <T1, T2, T3, T4, T5, R> Flow<R> combineLatest(Flow<? extends T1> flow, Flow<? extends T2> flow2, Flow<? extends T3> flow3, Flow<? extends T4> flow4, Flow<? extends T5> flow5, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super Continuation<? super R>, ? extends Object> function6) {
        Intrinsics.checkParameterIsNotNull(flow, "$this$combineLatest");
        Intrinsics.checkParameterIsNotNull(flow2, FitnessActivities.OTHER);
        Intrinsics.checkParameterIsNotNull(flow3, "other2");
        Intrinsics.checkParameterIsNotNull(flow4, "other3");
        Intrinsics.checkParameterIsNotNull(flow5, "other4");
        Intrinsics.checkParameterIsNotNull(function6, "transform");
        return new FlowKt__MigrationKt$combineLatest$$inlined$combine$3(new Flow[]{flow, flow2, flow3, flow4, flow5}, function6);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogues of 'switchMap' are 'transformLatest', 'flatMapLatest' and 'mapLatest'", replaceWith = @ReplaceWith(expression = "this.flatMapLatest(transform)", imports = {}))
    public static final <T, R> Flow<R> switchMap(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> function2) {
        Intrinsics.checkParameterIsNotNull(flow, "$this$switchMap");
        Intrinsics.checkParameterIsNotNull(function2, "transform");
        return FlowKt.transformLatest(flow, new FlowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1(function2, null));
    }
}
