package kotlinx.coroutines.flow.internal;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.Job;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "count", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: SafeCollector.kt */
final class SafeCollector$checkContext$result$1 extends Lambda implements Function2<Integer, CoroutineContext.Element, Integer> {
    final /* synthetic */ SafeCollector this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SafeCollector$checkContext$result$1(SafeCollector safeCollector) {
        super(2);
        this.this$0 = safeCollector;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return Integer.valueOf(invoke(((Number) obj).intValue(), (CoroutineContext.Element) obj2));
    }

    public final int invoke(int i, CoroutineContext.Element element) {
        Intrinsics.checkParameterIsNotNull(element, "element");
        CoroutineContext.Key<?> key = element.getKey();
        CoroutineContext.Element element2 = this.this$0.collectContext.get(key);
        if (key == Job.Key) {
            Job job = (Job) element2;
            Job access$transitiveCoroutineParent = this.this$0.transitiveCoroutineParent((Job) element, job);
            if (access$transitiveCoroutineParent == job) {
                return job == null ? i : i + 1;
            }
            throw new IllegalStateException(("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n" + "\t\tChild of " + access$transitiveCoroutineParent + ", expected child of " + job + ".\n" + "\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n" + "\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
        } else if (element != element2) {
            return Integer.MIN_VALUE;
        } else {
            return i + 1;
        }
    }
}
