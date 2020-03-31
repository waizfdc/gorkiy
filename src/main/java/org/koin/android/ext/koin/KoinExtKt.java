package org.koin.android.ext.koin;

import android.app.Application;
import android.content.Context;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.koin.android.logger.AndroidLogger;
import org.koin.core.KoinApplication;
import org.koin.core.logger.Level;
import org.koin.dsl.ModuleKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0000\u001a\u00020\u0002\u001a\u0014\u0010\u0003\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u001a\u0014\u0010\u0006\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"androidContext", "Lorg/koin/core/KoinApplication;", "Landroid/content/Context;", "androidFileProperties", "koinPropertyFile", "", "androidLogger", FirebaseAnalytics.Param.LEVEL, "Lorg/koin/core/logger/Level;", "koin-android_release"}, k = 2, mv = {1, 1, 16})
/* compiled from: KoinExt.kt */
public final class KoinExtKt {
    public static /* synthetic */ KoinApplication androidLogger$default(KoinApplication koinApplication, Level level, int i, Object obj) {
        if ((i & 1) != 0) {
            level = Level.INFO;
        }
        return androidLogger(koinApplication, level);
    }

    public static final KoinApplication androidLogger(KoinApplication koinApplication, Level level) {
        Intrinsics.checkParameterIsNotNull(koinApplication, "$this$androidLogger");
        Intrinsics.checkParameterIsNotNull(level, FirebaseAnalytics.Param.LEVEL);
        koinApplication.getKoin().set_logger(new AndroidLogger(level));
        return koinApplication;
    }

    public static final KoinApplication androidContext(KoinApplication koinApplication, Context context) {
        Intrinsics.checkParameterIsNotNull(koinApplication, "$this$androidContext");
        Intrinsics.checkParameterIsNotNull(context, "androidContext");
        if (koinApplication.getKoin().get_logger().isAt(Level.INFO)) {
            koinApplication.getKoin().get_logger().info("[init] declare Android Context");
        }
        if (context instanceof Application) {
            koinApplication.getKoin().loadModules(CollectionsKt.listOf(ModuleKt.module$default(false, false, new KoinExtKt$androidContext$1(context), 3, null)));
        }
        koinApplication.getKoin().loadModules(CollectionsKt.listOf(ModuleKt.module$default(false, false, new KoinExtKt$androidContext$2(context), 3, null)));
        return koinApplication;
    }

    public static /* synthetic */ KoinApplication androidFileProperties$default(KoinApplication koinApplication, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "koin.properties";
        }
        return androidFileProperties(koinApplication, str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00a3, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r7, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00a7, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final org.koin.core.KoinApplication androidFileProperties(org.koin.core.KoinApplication r6, java.lang.String r7) {
        /*
            java.lang.String r0 = "$this$androidFileProperties"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r6, r0)
            java.lang.String r0 = "koinPropertyFile"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r7, r0)
            org.koin.core.Koin r0 = r6.getKoin()
            r0.createRootScope()
            java.util.Properties r0 = new java.util.Properties
            r0.<init>()
            org.koin.core.Koin r1 = r6.getKoin()
            r2 = 0
            r3 = r2
            org.koin.core.qualifier.Qualifier r3 = (org.koin.core.qualifier.Qualifier) r3
            r4 = r2
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            org.koin.core.registry.ScopeRegistry r1 = r1.get_scopeRegistry()
            org.koin.core.scope.Scope r1 = r1.getRootScope()
            java.lang.Class<android.content.Context> r5 = android.content.Context.class
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r5)
            java.lang.Object r1 = r1.get(r5, r3, r4)
            android.content.Context r1 = (android.content.Context) r1
            android.content.res.AssetManager r3 = r1.getAssets()     // Catch:{ Exception -> 0x00e4 }
            if (r3 == 0) goto L_0x0048
            java.lang.String r4 = ""
            java.lang.String[] r3 = r3.list(r4)     // Catch:{ Exception -> 0x00e4 }
            if (r3 == 0) goto L_0x0048
            boolean r3 = kotlin.collections.ArraysKt.contains(r3, r7)     // Catch:{ Exception -> 0x00e4 }
            goto L_0x0049
        L_0x0048:
            r3 = 0
        L_0x0049:
            if (r3 == 0) goto L_0x00c6
            android.content.res.AssetManager r1 = r1.getAssets()     // Catch:{ Exception -> 0x00a8 }
            java.io.InputStream r7 = r1.open(r7)     // Catch:{ Exception -> 0x00a8 }
            java.io.Closeable r7 = (java.io.Closeable) r7     // Catch:{ Exception -> 0x00a8 }
            java.lang.Throwable r2 = (java.lang.Throwable) r2     // Catch:{ Exception -> 0x00a8 }
            r1 = r7
            java.io.InputStream r1 = (java.io.InputStream) r1     // Catch:{ all -> 0x00a1 }
            r0.load(r1)     // Catch:{ all -> 0x00a1 }
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00a1 }
            kotlin.io.CloseableKt.closeFinally(r7, r2)     // Catch:{ Exception -> 0x00a8 }
            org.koin.core.Koin r7 = r6.getKoin()     // Catch:{ Exception -> 0x00a8 }
            org.koin.core.registry.PropertyRegistry r7 = r7.get_propertyRegistry()     // Catch:{ Exception -> 0x00a8 }
            r7.saveProperties(r0)     // Catch:{ Exception -> 0x00a8 }
            kotlin.Unit r7 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x00a8 }
            org.koin.core.Koin r0 = r6.getKoin()     // Catch:{ Exception -> 0x00a8 }
            org.koin.core.logger.Logger r0 = r0.get_logger()     // Catch:{ Exception -> 0x00a8 }
            org.koin.core.logger.Level r1 = org.koin.core.logger.Level.INFO     // Catch:{ Exception -> 0x00a8 }
            boolean r0 = r0.isAt(r1)     // Catch:{ Exception -> 0x00a8 }
            if (r0 == 0) goto L_0x0101
            org.koin.core.Koin r0 = r6.getKoin()     // Catch:{ Exception -> 0x00a8 }
            org.koin.core.logger.Logger r0 = r0.get_logger()     // Catch:{ Exception -> 0x00a8 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a8 }
            r1.<init>()     // Catch:{ Exception -> 0x00a8 }
            java.lang.String r2 = "[Android-Properties] loaded "
            r1.append(r2)     // Catch:{ Exception -> 0x00a8 }
            r1.append(r7)     // Catch:{ Exception -> 0x00a8 }
            java.lang.String r7 = " properties from assets/koin.properties"
            r1.append(r7)     // Catch:{ Exception -> 0x00a8 }
            java.lang.String r7 = r1.toString()     // Catch:{ Exception -> 0x00a8 }
            r0.info(r7)     // Catch:{ Exception -> 0x00a8 }
            goto L_0x0101
        L_0x00a1:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x00a3 }
        L_0x00a3:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r7, r0)     // Catch:{ Exception -> 0x00a8 }
            throw r1     // Catch:{ Exception -> 0x00a8 }
        L_0x00a8:
            r7 = move-exception
            org.koin.core.Koin r0 = r6.getKoin()     // Catch:{ Exception -> 0x00e4 }
            org.koin.core.logger.Logger r0 = r0.get_logger()     // Catch:{ Exception -> 0x00e4 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00e4 }
            r1.<init>()     // Catch:{ Exception -> 0x00e4 }
            java.lang.String r2 = "[Android-Properties] error for binding properties : "
            r1.append(r2)     // Catch:{ Exception -> 0x00e4 }
            r1.append(r7)     // Catch:{ Exception -> 0x00e4 }
            java.lang.String r7 = r1.toString()     // Catch:{ Exception -> 0x00e4 }
            r0.error(r7)     // Catch:{ Exception -> 0x00e4 }
            goto L_0x0101
        L_0x00c6:
            org.koin.core.Koin r7 = r6.getKoin()     // Catch:{ Exception -> 0x00e4 }
            org.koin.core.logger.Logger r7 = r7.get_logger()     // Catch:{ Exception -> 0x00e4 }
            org.koin.core.logger.Level r0 = org.koin.core.logger.Level.INFO     // Catch:{ Exception -> 0x00e4 }
            boolean r7 = r7.isAt(r0)     // Catch:{ Exception -> 0x00e4 }
            if (r7 == 0) goto L_0x0101
            org.koin.core.Koin r7 = r6.getKoin()     // Catch:{ Exception -> 0x00e4 }
            org.koin.core.logger.Logger r7 = r7.get_logger()     // Catch:{ Exception -> 0x00e4 }
            java.lang.String r0 = "[Android-Properties] no assets/koin.properties file to load"
            r7.info(r0)     // Catch:{ Exception -> 0x00e4 }
            goto L_0x0101
        L_0x00e4:
            r7 = move-exception
            org.koin.core.Koin r0 = r6.getKoin()
            org.koin.core.logger.Logger r0 = r0.get_logger()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "[Android-Properties] error while loading properties from assets/koin.properties : "
            r1.append(r2)
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            r0.error(r7)
        L_0x0101:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.koin.android.ext.koin.KoinExtKt.androidFileProperties(org.koin.core.KoinApplication, java.lang.String):org.koin.core.KoinApplication");
    }
}
