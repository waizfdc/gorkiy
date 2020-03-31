package com.askgps.personaltrackercore;

import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u001c\n\u0002\b\u0002\u001a,\u0010\u0002\u001a\u00020\u0003*\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0007\u001a\u00020\u0001\u001a,\u0010\b\u001a\u00020\u0003*\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0007\u001a\u00020\u0001\u001a*\u0010\b\u001a\u00020\u0003*\u00020\t2\b\b\u0002\u0010\u0005\u001a\u00020\u00012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0007\u001a\u00020\u0001\u001a6\u0010\b\u001a\u00020\u0003\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000b2\b\b\u0002\u0010\u0005\u001a\u00020\u00012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0007\u001a\u00020\u0001\u001a6\u0010\f\u001a\u00020\u0003\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000b2\b\b\u0002\u0010\u0005\u001a\u00020\u00012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0007\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"TAG", "", "toFile", "", "", "prefix", "methodName", "tag", "toLog", "", ExifInterface.GPS_DIRECTION_TRUE, "", "toLogLn", "personaltrackercore_release"}, k = 2, mv = {1, 1, 16})
/* compiled from: Log.kt */
public final class LogKt {
    private static final String TAG = "pTracker";

    public static /* synthetic */ void toLog$default(Object obj, String str, String str2, String str3, int i, Object obj2) {
        if ((i & 1) != 0) {
            str = "";
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            str3 = TAG;
        }
        toLog(obj, str, str2, str3);
    }

    public static final void toLog(Object obj, String str, String str2, String str3) {
        Intrinsics.checkParameterIsNotNull(str, "prefix");
        Intrinsics.checkParameterIsNotNull(str3, "tag");
        if (str2 == null) {
            try {
                Thread currentThread = Thread.currentThread();
                Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
                StackTraceElement stackTraceElement = currentThread.getStackTrace()[4];
                Intrinsics.checkExpressionValueIsNotNull(stackTraceElement, "Thread.currentThread().stackTrace[4]");
                str2 = stackTraceElement.getMethodName();
            } catch (Exception unused) {
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Thread currentThread2 = Thread.currentThread();
        Intrinsics.checkExpressionValueIsNotNull(currentThread2, "Thread.currentThread()");
        String format = String.format("%5d", Arrays.copyOf(new Object[]{Long.valueOf(currentThread2.getId())}, 1));
        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
        sb.append(format);
        sb.append("] [");
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String format2 = String.format("%-15s", Arrays.copyOf(new Object[]{str2}, 1));
        Intrinsics.checkExpressionValueIsNotNull(format2, "java.lang.String.format(format, *args)");
        sb.append(format2);
        sb.append("] ");
        sb.append(str);
        sb.append(": ");
        sb.append(obj);
        Log.d(str3, sb.toString());
    }

    public static /* synthetic */ void toFile$default(Object obj, String str, String str2, String str3, int i, Object obj2) {
        if ((i & 1) != 0) {
            str = "";
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            str3 = TAG;
        }
        toFile(obj, str, str2, str3);
    }

    public static final void toFile(Object obj, String str, String str2, String str3) {
        Intrinsics.checkParameterIsNotNull(str, "prefix");
        Intrinsics.checkParameterIsNotNull(str3, "tag");
        if (str2 == null) {
            try {
                Thread currentThread = Thread.currentThread();
                Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
                StackTraceElement stackTraceElement = currentThread.getStackTrace()[4];
                Intrinsics.checkExpressionValueIsNotNull(stackTraceElement, "Thread.currentThread().stackTrace[4]");
                str2 = stackTraceElement.getMethodName();
            } catch (Exception unused) {
            }
        }
        if (obj instanceof Object[]) {
            obj = ArraysKt.joinToString$default((Object[]) obj, "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        } else if (obj instanceof Iterable) {
            obj = CollectionsKt.joinToString$default((Iterable) obj, "\n", null, null, 0, null, null, 62, null);
        } else if (obj instanceof Throwable) {
            StackTraceElement[] stackTrace = ((Throwable) obj).getStackTrace();
            Intrinsics.checkExpressionValueIsNotNull(stackTrace, "this.stackTrace");
            obj = ArraysKt.joinToString$default(stackTrace, "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        }
        toLog(obj, str, str2, str3);
        Logger logger = Logger.INSTANCE;
        Thread currentThread2 = Thread.currentThread();
        Intrinsics.checkExpressionValueIsNotNull(currentThread2, "Thread.currentThread()");
        logger.writeToFile(obj, str, str2, Long.valueOf(currentThread2.getId()));
    }

    public static /* synthetic */ void toLog$default(Throwable th, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            str3 = TAG;
        }
        toLog(th, str, str2, str3);
    }

    public static final void toLog(Throwable th, String str, String str2, String str3) {
        Intrinsics.checkParameterIsNotNull(th, "$this$toLog");
        Intrinsics.checkParameterIsNotNull(str, "prefix");
        Intrinsics.checkParameterIsNotNull(str3, "tag");
        if (str2 == null) {
            try {
                Thread currentThread = Thread.currentThread();
                Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
                StackTraceElement stackTraceElement = currentThread.getStackTrace()[4];
                Intrinsics.checkExpressionValueIsNotNull(stackTraceElement, "Thread.currentThread().stackTrace[4]");
                str2 = stackTraceElement.getMethodName();
            } catch (Exception unused) {
            }
        }
        toLog(th.getMessage(), str, str2, str3);
        th.printStackTrace();
    }

    public static /* synthetic */ void toLog$default(Iterable iterable, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            str3 = TAG;
        }
        toLog(iterable, str, str2, str3);
    }

    public static final <T> void toLog(Iterable<? extends T> iterable, String str, String str2, String str3) {
        Intrinsics.checkParameterIsNotNull(iterable, "$this$toLog");
        Intrinsics.checkParameterIsNotNull(str, "prefix");
        Intrinsics.checkParameterIsNotNull(str3, "tag");
        if (str2 == null) {
            try {
                Thread currentThread = Thread.currentThread();
                Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
                StackTraceElement stackTraceElement = currentThread.getStackTrace()[4];
                Intrinsics.checkExpressionValueIsNotNull(stackTraceElement, "Thread.currentThread().stackTrace[4]");
                str2 = stackTraceElement.getMethodName();
            } catch (Exception unused) {
            }
        }
        toLog(CollectionsKt.joinToString$default(iterable, null, null, null, 0, null, null, 63, null), str, str2, str3);
    }

    public static /* synthetic */ void toLogLn$default(Iterable iterable, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            str3 = TAG;
        }
        toLogLn(iterable, str, str2, str3);
    }

    public static final <T> void toLogLn(Iterable<? extends T> iterable, String str, String str2, String str3) {
        Intrinsics.checkParameterIsNotNull(iterable, "$this$toLogLn");
        Intrinsics.checkParameterIsNotNull(str, "prefix");
        Intrinsics.checkParameterIsNotNull(str3, "tag");
        if (str2 == null) {
            try {
                Thread currentThread = Thread.currentThread();
                Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
                StackTraceElement stackTraceElement = currentThread.getStackTrace()[4];
                Intrinsics.checkExpressionValueIsNotNull(stackTraceElement, "Thread.currentThread().stackTrace[4]");
                str2 = stackTraceElement.getMethodName();
            } catch (Exception unused) {
            }
        }
        toLog(10 + CollectionsKt.joinToString$default(iterable, "\n", null, null, 0, null, null, 62, null), str, str2, str3);
    }
}
