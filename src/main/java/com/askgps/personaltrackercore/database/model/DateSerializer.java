package com.askgps.personaltrackercore.database.model;

import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\f"}, d2 = {"Lcom/askgps/personaltrackercore/database/model/DateSerializer;", "Lcom/google/gson/JsonSerializer;", "", "()V", "serialize", "Lcom/google/gson/JsonElement;", "src", "typeOfSrc", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonSerializationContext;", "Companion", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: model.kt */
public final class DateSerializer implements JsonSerializer<Long> {
    public static final Companion Companion = new Companion(null);
    /* access modifiers changed from: private */
    public static final SimpleDateFormat sdf;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/askgps/personaltrackercore/database/model/DateSerializer$Companion;", "", "()V", "sdf", "Ljava/text/SimpleDateFormat;", "getSdf", "()Ljava/text/SimpleDateFormat;", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: model.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SimpleDateFormat getSdf() {
            return DateSerializer.sdf;
        }
    }

    public /* bridge */ /* synthetic */ JsonElement serialize(Object obj, Type type, JsonSerializationContext jsonSerializationContext) {
        return serialize(((Number) obj).longValue(), type, jsonSerializationContext);
    }

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        sdf = simpleDateFormat;
    }

    public JsonElement serialize(long j, Type type, JsonSerializationContext jsonSerializationContext) {
        Intrinsics.checkParameterIsNotNull(jsonSerializationContext, "context");
        Date date = new Date();
        date.setTime(j);
        JsonElement serialize = jsonSerializationContext.serialize(sdf.format(date));
        Intrinsics.checkExpressionValueIsNotNull(serialize, "context.serialize(sdf.format(date))");
        return serialize;
    }
}
