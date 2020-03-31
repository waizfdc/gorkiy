package com.askgps.personaltrackercore;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import androidx.core.app.NotificationCompat;
import androidx.core.os.BundleKt;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J;\u0010\u001a\u001a\u00020\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002¢\u0006\u0002\u0010 J9\u0010!\u001a\u00020\u00172\b\u0010\"\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\u0002\u0010 R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u000b*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/askgps/personaltrackercore/Logger;", "", "()V", "FILE_NAME", "", "METHOD_NAME", "PREFIX", "THREAD_ID", "TO_FILE", "", "date", "kotlin.jvm.PlatformType", "file", "Ljava/io/File;", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "handler$delegate", "Lkotlin/Lazy;", "handlerThread", "Landroid/os/HandlerThread;", "initFile", "", "context", "Landroid/content/Context;", "toFile", NotificationCompat.CATEGORY_MESSAGE, Logger.PREFIX, Logger.METHOD_NAME, Logger.THREAD_ID, "", "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "writeToFile", "obj", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: Log.kt */
public final class Logger {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Logger.class), "handler", "getHandler()Landroid/os/Handler;"))};
    private static final String FILE_NAME = ("tracker_" + date + ".txt");
    public static final Logger INSTANCE = new Logger();
    private static final String METHOD_NAME = "methodName";
    private static final String PREFIX = "prefix";
    private static final String THREAD_ID = "threadId";
    private static final int TO_FILE = 0;
    private static final String date = new SimpleDateFormat("ddMMyy").format(new Date(System.currentTimeMillis()));
    private static File file;
    private static final Lazy handler$delegate = LazyKt.lazy(Logger$handler$2.INSTANCE);
    /* access modifiers changed from: private */
    public static final HandlerThread handlerThread;

    private final Handler getHandler() {
        Lazy lazy = handler$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (Handler) lazy.getValue();
    }

    static {
        HandlerThread handlerThread2 = new HandlerThread("logger");
        handlerThread2.setDaemon(true);
        handlerThread2.start();
        handlerThread = handlerThread2;
    }

    private Logger() {
    }

    public final void initFile(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        File file2 = new File(context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS), "Log");
        file2.mkdir();
        File file3 = new File(file2, FILE_NAME);
        file = file3;
        if (file3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("file");
        }
        if (!(!file3.exists())) {
            file3 = null;
        }
        if (file3 != null) {
            file3.createNewFile();
        }
    }

    public static /* synthetic */ void writeToFile$default(Logger logger, Object obj, String str, String str2, Long l, int i, Object obj2) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        if ((i & 8) != 0) {
            l = null;
        }
        logger.writeToFile(obj, str, str2, l);
    }

    public final void writeToFile(Object obj, String str, String str2, Long l) {
        Handler handler = getHandler();
        Message message = new Message();
        message.what = 0;
        message.obj = obj;
        Pair[] pairArr = new Pair[3];
        if (str == null) {
            str = "";
        }
        pairArr[0] = TuplesKt.to(PREFIX, str);
        if (str2 == null) {
            str2 = "";
        }
        pairArr[1] = TuplesKt.to(METHOD_NAME, str2);
        pairArr[2] = TuplesKt.to(THREAD_ID, l);
        message.setData(BundleKt.bundleOf(pairArr));
        handler.sendMessage(message);
    }

    static /* synthetic */ void toFile$default(Logger logger, Object obj, String str, String str2, Long l, int i, Object obj2) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        if ((i & 8) != 0) {
            l = null;
        }
        logger.toFile(obj, str, str2, l);
    }

    /* access modifiers changed from: private */
    public final void toFile(Object obj, String str, String str2, Long l) {
        try {
            File file2 = file;
            if (file2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("file");
            }
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyy HH:mm:ss");
            Calendar instance = Calendar.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(instance, "Calendar.getInstance()");
            sb.append(simpleDateFormat.format(instance.getTime()));
            sb.append("] [");
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            Object[] objArr = new Object[1];
            if (l == null) {
                Thread currentThread = Thread.currentThread();
                Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
                l = Long.valueOf(currentThread.getId());
            }
            objArr[0] = l;
            String format = String.format("%5d", Arrays.copyOf(objArr, 1));
            Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
            sb.append(format);
            sb.append(']');
            sb.append('[');
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String format2 = String.format("%-15s", Arrays.copyOf(new Object[]{str2}, 1));
            Intrinsics.checkExpressionValueIsNotNull(format2, "java.lang.String.format(format, *args)");
            sb.append(format2);
            sb.append("] ");
            sb.append(str);
            sb.append(": ");
            sb.append(obj);
            sb.append(" \n");
            FilesKt.appendText$default(file2, sb.toString(), null, 2, null);
        } catch (Exception unused) {
        }
    }
}
