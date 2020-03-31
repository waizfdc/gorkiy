package kotlin.reflect.jvm.internal;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KClassImpl;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\f0\u0001R\b\u0012\u0004\u0012\u0002H\u00030\u0002\"\b\b\u0000\u0010\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/KClassImpl$Data;", "Lkotlin/reflect/jvm/internal/KClassImpl;", ExifInterface.GPS_DIRECTION_TRUE, "", "invoke"}, k = 3, mv = {1, 1, 15})
/* compiled from: KClassImpl.kt */
final class KClassImpl$data$1 extends Lambda implements Function0<KClassImpl<T>.Data> {
    final /* synthetic */ KClassImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KClassImpl$data$1(KClassImpl kClassImpl) {
        super(0);
        this.this$0 = kClassImpl;
    }

    public final KClassImpl<T>.Data invoke() {
        return new KClassImpl.Data();
    }
}
