package org.koin.core;

import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.koin.core.error.ScopeNotCreatedException;
import org.koin.core.logger.EmptyLogger;
import org.koin.core.logger.Level;
import org.koin.core.logger.Logger;
import org.koin.core.module.Module;
import org.koin.core.parameter.DefinitionParameters;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.qualifier.TypeQualifier;
import org.koin.core.registry.PropertyRegistry;
import org.koin.core.registry.ScopeRegistry;
import org.koin.core.scope.Scope;
import org.koin.ext.InstanceScopeExtKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JA\u0010\u0017\u001a\u0002H\u0018\"\u0004\b\u0000\u0010\u00182\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u001a2\n\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u001a2\u0016\b\u0002\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dj\u0004\u0018\u0001`\u001f¢\u0006\u0002\u0010 J6\u0010\u0017\u001a\u0002H\u0018\"\u0006\b\u0000\u0010\u0018\u0018\u0001\"\u0006\b\u0001\u0010!\u0018\u00012\u0016\b\n\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dj\u0004\u0018\u0001`\u001fH\b¢\u0006\u0002\u0010\"J\u0006\u0010#\u001a\u00020$J\r\u0010%\u001a\u00020$H\u0000¢\u0006\u0002\b&J\r\u0010'\u001a\u00020$H\u0000¢\u0006\u0002\b(J\u0006\u0010)\u001a\u00020$J\u0011\u0010*\u001a\u00020+\"\u0006\b\u0000\u0010,\u0018\u0001H\bJ)\u0010*\u001a\u00020+\"\u0006\b\u0000\u0010,\u0018\u00012\n\u0010-\u001a\u00060.j\u0002`/2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0001H\bJ&\u0010*\u001a\u00020+2\n\u0010-\u001a\u00060.j\u0002`/2\u0006\u00101\u001a\u0002022\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0001JL\u00103\u001a\u00020$\"\n\b\u0000\u0010,\u0018\u0001*\u00020\u00012\u0006\u00104\u001a\u0002H,2\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\u0012\b\u0002\u00105\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001a062\b\b\u0002\u00107\u001a\u000208H\b¢\u0006\u0002\u00109J\u000e\u0010:\u001a\u00020$2\u0006\u0010;\u001a\u00020.J\u0012\u0010<\u001a\u00020$2\n\u0010-\u001a\u00060.j\u0002`/JA\u0010=\u001a\u0002H,\"\u0004\b\u0000\u0010,2\n\u0010>\u001a\u0006\u0012\u0002\b\u00030\u001a2\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\u0016\b\u0002\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dj\u0004\u0018\u0001`\u001f¢\u0006\u0002\u0010?J:\u0010=\u001a\u0002H,\"\u0006\b\u0000\u0010,\u0018\u00012\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\u0016\b\n\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dj\u0004\u0018\u0001`\u001fH\b¢\u0006\u0002\u0010@J\u001b\u0010A\u001a\b\u0012\u0004\u0012\u0002H,06\"\n\b\u0000\u0010,\u0018\u0001*\u00020\u0001H\bJ\u001d\u0010B\u001a\u00020+\"\u0006\b\u0000\u0010,\u0018\u00012\n\u0010-\u001a\u00060.j\u0002`/H\bJ\u001a\u0010B\u001a\u00020+2\n\u0010-\u001a\u00060.j\u0002`/2\u0006\u00101\u001a\u000202JC\u0010C\u001a\u0004\u0018\u0001H,\"\u0004\b\u0000\u0010,2\n\u0010>\u001a\u0006\u0012\u0002\b\u00030\u001a2\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\u0016\b\u0002\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dj\u0004\u0018\u0001`\u001f¢\u0006\u0002\u0010?J<\u0010C\u001a\u0004\u0018\u0001H,\"\u0006\b\u0000\u0010,\u0018\u00012\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\u0016\b\n\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dj\u0004\u0018\u0001`\u001fH\b¢\u0006\u0002\u0010@J\u001b\u0010D\u001a\u0004\u0018\u0001H,\"\u0004\b\u0000\u0010,2\u0006\u0010;\u001a\u00020.¢\u0006\u0002\u0010EJ!\u0010D\u001a\u0002H,\"\u0004\b\u0000\u0010,2\u0006\u0010;\u001a\u00020.2\u0006\u0010F\u001a\u0002H,¢\u0006\u0002\u0010GJ\u0012\u0010H\u001a\u00020+2\n\u0010-\u001a\u00060.j\u0002`/J\u0014\u0010I\u001a\u0004\u0018\u00010+2\n\u0010-\u001a\u00060.j\u0002`/J;\u0010J\u001a\b\u0012\u0004\u0012\u0002H,0K\"\u0006\b\u0000\u0010,\u0018\u00012\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\u0016\b\n\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dj\u0004\u0018\u0001`\u001fH\bJ=\u0010L\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H,0K\"\u0006\b\u0000\u0010,\u0018\u00012\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\u0016\b\n\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dj\u0004\u0018\u0001`\u001fH\bJ\u0014\u0010M\u001a\u00020$2\f\u0010N\u001a\b\u0012\u0004\u0012\u00020\u000b06J%\u0010O\u001a\u00020$\"\b\b\u0000\u0010,*\u00020\u00012\u0006\u0010;\u001a\u00020.2\u0006\u0010P\u001a\u0002H,¢\u0006\u0002\u0010QJ\u0014\u0010R\u001a\u0002082\f\u0010N\u001a\b\u0012\u0004\u0012\u00020\u000b06R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR!\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006S"}, d2 = {"Lorg/koin/core/Koin;", "", "()V", "_logger", "Lorg/koin/core/logger/Logger;", "get_logger", "()Lorg/koin/core/logger/Logger;", "set_logger", "(Lorg/koin/core/logger/Logger;)V", "_modules", "Ljava/util/HashSet;", "Lorg/koin/core/module/Module;", "Lkotlin/collections/HashSet;", "get_modules", "()Ljava/util/HashSet;", "_propertyRegistry", "Lorg/koin/core/registry/PropertyRegistry;", "get_propertyRegistry", "()Lorg/koin/core/registry/PropertyRegistry;", "_scopeRegistry", "Lorg/koin/core/registry/ScopeRegistry;", "get_scopeRegistry", "()Lorg/koin/core/registry/ScopeRegistry;", "bind", ExifInterface.LATITUDE_SOUTH, "primaryType", "Lkotlin/reflect/KClass;", "secondaryType", "parameters", "Lkotlin/Function0;", "Lorg/koin/core/parameter/DefinitionParameters;", "Lorg/koin/core/parameter/ParametersDefinition;", "(Lkotlin/reflect/KClass;Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "P", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "close", "", "createContextIfNeeded", "createContextIfNeeded$koin_core", "createEagerInstances", "createEagerInstances$koin_core", "createRootScope", "createScope", "Lorg/koin/core/scope/Scope;", ExifInterface.GPS_DIRECTION_TRUE, "scopeId", "", "Lorg/koin/core/scope/ScopeID;", FirebaseAnalytics.Param.SOURCE, "qualifier", "Lorg/koin/core/qualifier/Qualifier;", "declare", "instance", "secondaryTypes", "", "override", "", "(Ljava/lang/Object;Lorg/koin/core/qualifier/Qualifier;Ljava/util/List;Z)V", "deleteProperty", "key", "deleteScope", "get", "clazz", "(Lkotlin/reflect/KClass;Lorg/koin/core/qualifier/Qualifier;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "(Lorg/koin/core/qualifier/Qualifier;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "getAll", "getOrCreateScope", "getOrNull", "getProperty", "(Ljava/lang/String;)Ljava/lang/Object;", "defaultValue", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "getScope", "getScopeOrNull", "inject", "Lkotlin/Lazy;", "injectOrNull", "loadModules", "modules", "setProperty", "value", "(Ljava/lang/String;Ljava/lang/Object;)V", "unloadModules", "koin-core"}, k = 1, mv = {1, 1, 16})
/* compiled from: Koin.kt */
public final class Koin {
    private Logger _logger = new EmptyLogger();
    private final HashSet<Module> _modules = new HashSet<>();
    private final PropertyRegistry _propertyRegistry = new PropertyRegistry(this);
    private final ScopeRegistry _scopeRegistry = new ScopeRegistry(this);

    public final /* synthetic */ <T> T get() {
        return get$default(this, null, null, 3, null);
    }

    public final /* synthetic */ <T> T get(Qualifier qualifier) {
        return get$default(this, qualifier, null, 2, null);
    }

    public final /* synthetic */ <T> T getOrNull() {
        return getOrNull$default(this, null, null, 3, null);
    }

    public final /* synthetic */ <T> T getOrNull(Qualifier qualifier) {
        return getOrNull$default(this, qualifier, null, 2, null);
    }

    public final /* synthetic */ <T> Lazy<T> inject() {
        return inject$default(this, null, null, 3, null);
    }

    public final /* synthetic */ <T> Lazy<T> inject(Qualifier qualifier) {
        return inject$default(this, qualifier, null, 2, null);
    }

    public final /* synthetic */ <T> Lazy<T> injectOrNull() {
        return injectOrNull$default(this, null, null, 3, null);
    }

    public final /* synthetic */ <T> Lazy<T> injectOrNull(Qualifier qualifier) {
        return injectOrNull$default(this, qualifier, null, 2, null);
    }

    public final ScopeRegistry get_scopeRegistry() {
        return this._scopeRegistry;
    }

    public final PropertyRegistry get_propertyRegistry() {
        return this._propertyRegistry;
    }

    public final Logger get_logger() {
        return this._logger;
    }

    public final void set_logger(Logger logger) {
        Intrinsics.checkParameterIsNotNull(logger, "<set-?>");
        this._logger = logger;
    }

    public final HashSet<Module> get_modules() {
        return this._modules;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: kotlin.LazyKt__LazyJVMKt.lazy(kotlin.LazyThreadSafetyMode, kotlin.jvm.functions.Function0):kotlin.Lazy<T>
     arg types: [kotlin.LazyThreadSafetyMode, org.koin.core.Koin$inject$$inlined$inject$2]
     candidates:
      kotlin.LazyKt__LazyJVMKt.lazy(java.lang.Object, kotlin.jvm.functions.Function0):kotlin.Lazy<T>
      kotlin.LazyKt__LazyJVMKt.lazy(kotlin.LazyThreadSafetyMode, kotlin.jvm.functions.Function0):kotlin.Lazy<T> */
    public static /* synthetic */ Lazy inject$default(Koin koin, Qualifier qualifier, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            qualifier = null;
        }
        if ((i & 2) != 0) {
            function0 = null;
        }
        Scope rootScope = koin.get_scopeRegistry().getRootScope();
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        Intrinsics.needClassReification();
        return LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Koin$inject$$inlined$inject$2(rootScope, qualifier, function0));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: kotlin.LazyKt__LazyJVMKt.lazy(kotlin.LazyThreadSafetyMode, kotlin.jvm.functions.Function0):kotlin.Lazy<T>
     arg types: [kotlin.LazyThreadSafetyMode, org.koin.core.Koin$inject$$inlined$inject$1]
     candidates:
      kotlin.LazyKt__LazyJVMKt.lazy(java.lang.Object, kotlin.jvm.functions.Function0):kotlin.Lazy<T>
      kotlin.LazyKt__LazyJVMKt.lazy(kotlin.LazyThreadSafetyMode, kotlin.jvm.functions.Function0):kotlin.Lazy<T> */
    public final /* synthetic */ <T> Lazy<T> inject(Qualifier qualifier, Function0<DefinitionParameters> function0) {
        Scope rootScope = get_scopeRegistry().getRootScope();
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        Intrinsics.needClassReification();
        return LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Koin$inject$$inlined$inject$1(rootScope, qualifier, function0));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: kotlin.LazyKt__LazyJVMKt.lazy(kotlin.LazyThreadSafetyMode, kotlin.jvm.functions.Function0):kotlin.Lazy<T>
     arg types: [kotlin.LazyThreadSafetyMode, org.koin.core.Koin$injectOrNull$$inlined$injectOrNull$2]
     candidates:
      kotlin.LazyKt__LazyJVMKt.lazy(java.lang.Object, kotlin.jvm.functions.Function0):kotlin.Lazy<T>
      kotlin.LazyKt__LazyJVMKt.lazy(kotlin.LazyThreadSafetyMode, kotlin.jvm.functions.Function0):kotlin.Lazy<T> */
    public static /* synthetic */ Lazy injectOrNull$default(Koin koin, Qualifier qualifier, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            qualifier = null;
        }
        if ((i & 2) != 0) {
            function0 = null;
        }
        Scope rootScope = koin.get_scopeRegistry().getRootScope();
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        Intrinsics.needClassReification();
        return LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Koin$injectOrNull$$inlined$injectOrNull$2(rootScope, qualifier, function0));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: kotlin.LazyKt__LazyJVMKt.lazy(kotlin.LazyThreadSafetyMode, kotlin.jvm.functions.Function0):kotlin.Lazy<T>
     arg types: [kotlin.LazyThreadSafetyMode, org.koin.core.Koin$injectOrNull$$inlined$injectOrNull$1]
     candidates:
      kotlin.LazyKt__LazyJVMKt.lazy(java.lang.Object, kotlin.jvm.functions.Function0):kotlin.Lazy<T>
      kotlin.LazyKt__LazyJVMKt.lazy(kotlin.LazyThreadSafetyMode, kotlin.jvm.functions.Function0):kotlin.Lazy<T> */
    public final /* synthetic */ <T> Lazy<T> injectOrNull(Qualifier qualifier, Function0<DefinitionParameters> function0) {
        Scope rootScope = get_scopeRegistry().getRootScope();
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        Intrinsics.needClassReification();
        return LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Koin$injectOrNull$$inlined$injectOrNull$1(rootScope, qualifier, function0));
    }

    public static /* synthetic */ Object get$default(Koin koin, Qualifier qualifier, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            qualifier = null;
        }
        if ((i & 2) != 0) {
            function0 = null;
        }
        Scope rootScope = koin.get_scopeRegistry().getRootScope();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return rootScope.get(Reflection.getOrCreateKotlinClass(Object.class), qualifier, function0);
    }

    public final /* synthetic */ <T> T get(Qualifier qualifier, Function0<DefinitionParameters> function0) {
        Scope rootScope = get_scopeRegistry().getRootScope();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return rootScope.get(Reflection.getOrCreateKotlinClass(Object.class), qualifier, function0);
    }

    public static /* synthetic */ Object getOrNull$default(Koin koin, Qualifier qualifier, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            qualifier = null;
        }
        if ((i & 2) != 0) {
            function0 = null;
        }
        Scope rootScope = koin.get_scopeRegistry().getRootScope();
        Intrinsics.reifiedOperationMarker(4, "T?");
        return rootScope.getOrNull(Reflection.getOrCreateKotlinClass(Object.class), qualifier, function0);
    }

    public final /* synthetic */ <T> T getOrNull(Qualifier qualifier, Function0<DefinitionParameters> function0) {
        Scope rootScope = get_scopeRegistry().getRootScope();
        Intrinsics.reifiedOperationMarker(4, "T?");
        return rootScope.getOrNull(Reflection.getOrCreateKotlinClass(Object.class), qualifier, function0);
    }

    public static /* synthetic */ Object get$default(Koin koin, KClass kClass, Qualifier qualifier, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            qualifier = null;
        }
        if ((i & 4) != 0) {
            function0 = null;
        }
        return koin.get(kClass, qualifier, function0);
    }

    public final <T> T get(KClass<?> kClass, Qualifier qualifier, Function0<DefinitionParameters> function0) {
        Intrinsics.checkParameterIsNotNull(kClass, "clazz");
        return this._scopeRegistry.getRootScope().get(kClass, qualifier, function0);
    }

    public static /* synthetic */ Object getOrNull$default(Koin koin, KClass kClass, Qualifier qualifier, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            qualifier = null;
        }
        if ((i & 4) != 0) {
            function0 = null;
        }
        return koin.getOrNull(kClass, qualifier, function0);
    }

    public final <T> T getOrNull(KClass<?> kClass, Qualifier qualifier, Function0<DefinitionParameters> function0) {
        Intrinsics.checkParameterIsNotNull(kClass, "clazz");
        return this._scopeRegistry.getRootScope().getOrNull(kClass, qualifier, function0);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: kotlin.collections.CollectionsKt___CollectionsKt.plus(java.util.Collection, java.lang.Iterable):java.util.List<T>
     arg types: [java.util.List, java.util.List]
     candidates:
      kotlin.collections.CollectionsKt___CollectionsKt.plus(java.lang.Iterable, java.lang.Iterable):java.util.List<T>
      kotlin.collections.CollectionsKt___CollectionsKt.plus(java.lang.Iterable, java.lang.Object):java.util.List<T>
      kotlin.collections.CollectionsKt___CollectionsKt.plus(java.lang.Iterable, kotlin.sequences.Sequence):java.util.List<T>
      kotlin.collections.CollectionsKt___CollectionsKt.plus(java.lang.Iterable, java.lang.Object[]):java.util.List<T>
      kotlin.collections.CollectionsKt___CollectionsKt.plus(java.util.Collection, java.lang.Object):java.util.List<T>
      kotlin.collections.CollectionsKt___CollectionsKt.plus(java.util.Collection, kotlin.sequences.Sequence):java.util.List<T>
      kotlin.collections.CollectionsKt___CollectionsKt.plus(java.util.Collection, java.lang.Object[]):java.util.List<T>
      kotlin.collections.CollectionsKt___CollectionsKt.plus(java.util.Collection, java.lang.Iterable):java.util.List<T> */
    public static /* synthetic */ void declare$default(Koin koin, Object obj, Qualifier qualifier, List list, boolean z, int i, Object obj2) {
        if ((i & 2) != 0) {
            qualifier = null;
        }
        if ((i & 4) != 0) {
            list = CollectionsKt.emptyList();
        }
        if ((i & 8) != 0) {
            z = false;
        }
        Intrinsics.checkParameterIsNotNull(obj, "instance");
        Intrinsics.checkParameterIsNotNull(list, "secondaryTypes");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        koin.get_scopeRegistry().getRootScope().declare(obj, qualifier, CollectionsKt.plus((Collection) CollectionsKt.listOf(Reflection.getOrCreateKotlinClass(Object.class)), (Iterable) list), z);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: kotlin.collections.CollectionsKt___CollectionsKt.plus(java.util.Collection, java.lang.Iterable):java.util.List<T>
     arg types: [java.util.List, java.util.List<? extends kotlin.reflect.KClass<?>>]
     candidates:
      kotlin.collections.CollectionsKt___CollectionsKt.plus(java.lang.Iterable, java.lang.Iterable):java.util.List<T>
      kotlin.collections.CollectionsKt___CollectionsKt.plus(java.lang.Iterable, java.lang.Object):java.util.List<T>
      kotlin.collections.CollectionsKt___CollectionsKt.plus(java.lang.Iterable, kotlin.sequences.Sequence):java.util.List<T>
      kotlin.collections.CollectionsKt___CollectionsKt.plus(java.lang.Iterable, java.lang.Object[]):java.util.List<T>
      kotlin.collections.CollectionsKt___CollectionsKt.plus(java.util.Collection, java.lang.Object):java.util.List<T>
      kotlin.collections.CollectionsKt___CollectionsKt.plus(java.util.Collection, kotlin.sequences.Sequence):java.util.List<T>
      kotlin.collections.CollectionsKt___CollectionsKt.plus(java.util.Collection, java.lang.Object[]):java.util.List<T>
      kotlin.collections.CollectionsKt___CollectionsKt.plus(java.util.Collection, java.lang.Iterable):java.util.List<T> */
    public final /* synthetic */ <T> void declare(T t, Qualifier qualifier, List<? extends KClass<?>> list, boolean z) {
        Intrinsics.checkParameterIsNotNull(t, "instance");
        Intrinsics.checkParameterIsNotNull(list, "secondaryTypes");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        get_scopeRegistry().getRootScope().declare(t, qualifier, CollectionsKt.plus((Collection) CollectionsKt.listOf(Reflection.getOrCreateKotlinClass(Object.class)), (Iterable) list), z);
    }

    public final /* synthetic */ <T> List<T> getAll() {
        Scope rootScope = get_scopeRegistry().getRootScope();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return rootScope.getAll(Reflection.getOrCreateKotlinClass(Object.class));
    }

    public static /* synthetic */ Object bind$default(Koin koin, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        Scope rootScope = koin.get_scopeRegistry().getRootScope();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.LATITUDE_SOUTH);
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(4, "P");
        return rootScope.bind(Reflection.getOrCreateKotlinClass(Object.class), orCreateKotlinClass, function0);
    }

    public final /* synthetic */ <S, P> S bind(Function0<DefinitionParameters> function0) {
        Scope rootScope = get_scopeRegistry().getRootScope();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.LATITUDE_SOUTH);
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(4, "P");
        return rootScope.bind(Reflection.getOrCreateKotlinClass(Object.class), orCreateKotlinClass, function0);
    }

    public static /* synthetic */ Object bind$default(Koin koin, KClass kClass, KClass kClass2, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            function0 = null;
        }
        return koin.bind(kClass, kClass2, function0);
    }

    public final <S> S bind(KClass<?> kClass, KClass<?> kClass2, Function0<DefinitionParameters> function0) {
        Intrinsics.checkParameterIsNotNull(kClass, "primaryType");
        Intrinsics.checkParameterIsNotNull(kClass2, "secondaryType");
        return this._scopeRegistry.getRootScope().bind(kClass, kClass2, function0);
    }

    public final void createEagerInstances$koin_core() {
        createContextIfNeeded$koin_core();
        this._scopeRegistry.getRootScope().createEagerInstances$koin_core();
    }

    public final void createContextIfNeeded$koin_core() {
        if (this._scopeRegistry.get_rootScope() == null) {
            this._scopeRegistry.createRootScope$koin_core();
        }
    }

    public static /* synthetic */ Scope createScope$default(Koin koin, String str, Qualifier qualifier, Object obj, int i, Object obj2) {
        if ((i & 4) != 0) {
            obj = null;
        }
        return koin.createScope(str, qualifier, obj);
    }

    public final Scope createScope(String str, Qualifier qualifier, Object obj) {
        Intrinsics.checkParameterIsNotNull(str, "scopeId");
        Intrinsics.checkParameterIsNotNull(qualifier, "qualifier");
        if (this._logger.isAt(Level.DEBUG)) {
            Logger logger = this._logger;
            logger.debug("!- create scope - id:'" + str + "' q:" + qualifier);
        }
        return this._scopeRegistry.createScope(str, qualifier, obj);
    }

    public static /* synthetic */ Scope createScope$default(Koin koin, String str, Object obj, int i, Object obj2) {
        if ((i & 2) != 0) {
            obj = null;
        }
        Intrinsics.checkParameterIsNotNull(str, "scopeId");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        TypeQualifier typeQualifier = new TypeQualifier(Reflection.getOrCreateKotlinClass(Object.class));
        if (koin.get_logger().isAt(Level.DEBUG)) {
            Logger logger = koin.get_logger();
            logger.debug("!- create scope - id:'" + str + "' q:" + typeQualifier);
        }
        return koin.get_scopeRegistry().createScope(str, typeQualifier, obj);
    }

    public final /* synthetic */ <T> Scope createScope(String str, Object obj) {
        Intrinsics.checkParameterIsNotNull(str, "scopeId");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        TypeQualifier typeQualifier = new TypeQualifier(Reflection.getOrCreateKotlinClass(Object.class));
        if (get_logger().isAt(Level.DEBUG)) {
            Logger logger = get_logger();
            logger.debug("!- create scope - id:'" + str + "' q:" + typeQualifier);
        }
        return get_scopeRegistry().createScope(str, typeQualifier, obj);
    }

    public final /* synthetic */ <T> Scope createScope() {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        String scopeId = InstanceScopeExtKt.getScopeId(orCreateKotlinClass);
        TypeQualifier typeQualifier = new TypeQualifier(orCreateKotlinClass);
        if (get_logger().isAt(Level.DEBUG)) {
            Logger logger = get_logger();
            logger.debug("!- create scope - id:'" + scopeId + "' q:" + typeQualifier);
        }
        return get_scopeRegistry().createScope(scopeId, typeQualifier, (Object) null);
    }

    public final Scope getOrCreateScope(String str, Qualifier qualifier) {
        Intrinsics.checkParameterIsNotNull(str, "scopeId");
        Intrinsics.checkParameterIsNotNull(qualifier, "qualifier");
        Scope scopeOrNull = this._scopeRegistry.getScopeOrNull(str);
        return scopeOrNull != null ? scopeOrNull : createScope$default(this, str, qualifier, null, 4, null);
    }

    public final /* synthetic */ <T> Scope getOrCreateScope(String str) {
        Intrinsics.checkParameterIsNotNull(str, "scopeId");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        TypeQualifier typeQualifier = new TypeQualifier(Reflection.getOrCreateKotlinClass(Object.class));
        Scope scopeOrNull = get_scopeRegistry().getScopeOrNull(str);
        if (scopeOrNull != null) {
            return scopeOrNull;
        }
        return createScope$default(this, str, typeQualifier, null, 4, null);
    }

    public final Scope getScope(String str) {
        Intrinsics.checkParameterIsNotNull(str, "scopeId");
        Scope scopeOrNull = this._scopeRegistry.getScopeOrNull(str);
        if (scopeOrNull != null) {
            return scopeOrNull;
        }
        throw new ScopeNotCreatedException("No scope found for id '" + str + '\'');
    }

    public final Scope getScopeOrNull(String str) {
        Intrinsics.checkParameterIsNotNull(str, "scopeId");
        return this._scopeRegistry.getScopeOrNull(str);
    }

    public final void deleteScope(String str) {
        Intrinsics.checkParameterIsNotNull(str, "scopeId");
        this._scopeRegistry.deleteScope(str);
    }

    public final <T> T getProperty(String str, T t) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        T property = this._propertyRegistry.getProperty(str);
        return property != null ? property : t;
    }

    public final <T> T getProperty(String str) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        return this._propertyRegistry.getProperty(str);
    }

    public final <T> void setProperty(String str, T t) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        Intrinsics.checkParameterIsNotNull(t, "value");
        this._propertyRegistry.saveProperty$koin_core(str, t);
    }

    public final void deleteProperty(String str) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        this._propertyRegistry.deleteProperty(str);
    }

    public final void close() {
        synchronized (this) {
            for (Module loaded$koin_core : this._modules) {
                loaded$koin_core.setLoaded$koin_core(false);
            }
            this._modules.clear();
            this._scopeRegistry.close$koin_core();
            this._propertyRegistry.close();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void loadModules(List<Module> list) {
        Intrinsics.checkParameterIsNotNull(list, "modules");
        synchronized (this) {
            this._modules.addAll(list);
            this._scopeRegistry.loadModules$koin_core(list);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final boolean unloadModules(List<Module> list) {
        boolean removeAll;
        Intrinsics.checkParameterIsNotNull(list, "modules");
        synchronized (this) {
            this._scopeRegistry.unloadModules(list);
            removeAll = this._modules.removeAll(list);
        }
        return removeAll;
    }

    public final void createRootScope() {
        this._scopeRegistry.createRootScope$koin_core();
    }
}
