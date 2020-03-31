package org.koin.core.scope;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.fitness.FitnessActivities;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.koin.core.Koin;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.definition.BeanDefinitionKt;
import org.koin.core.error.ClosedScopeException;
import org.koin.core.error.MissingPropertyException;
import org.koin.core.error.NoBeanDefFoundException;
import org.koin.core.logger.Level;
import org.koin.core.logger.Logger;
import org.koin.core.parameter.DefinitionParameters;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.registry.InstanceRegistry;
import org.koin.ext.KClassExtKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0010\u0001\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B-\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\nJ?\u0010#\u001a\u0002H$\"\u0004\b\u0000\u0010$2\n\u0010%\u001a\u0006\u0012\u0002\b\u00030&2\n\u0010'\u001a\u0006\u0012\u0002\b\u00030&2\u0014\u0010(\u001a\u0010\u0012\u0004\u0012\u00020*\u0018\u00010)j\u0004\u0018\u0001`+¢\u0006\u0002\u0010,J6\u0010#\u001a\u0002H$\"\u0006\b\u0000\u0010$\u0018\u0001\"\u0006\b\u0001\u0010-\u0018\u00012\u0016\b\n\u0010(\u001a\u0010\u0012\u0004\u0012\u00020*\u0018\u00010)j\u0004\u0018\u0001`+H\b¢\u0006\u0002\u0010.J\r\u0010/\u001a\u000200H\u0000¢\u0006\u0002\b1J\u0006\u00102\u001a\u000200J\r\u00103\u001a\u00060\u0003j\u0002`\u0004HÆ\u0003J\t\u00104\u001a\u00020\u0006HÆ\u0003J\t\u00105\u001a\u00020\bHÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0001HÆ\u0003J7\u00107\u001a\u00020\u00002\f\b\u0002\u0010\u0002\u001a\u00060\u0003j\u0002`\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\u001b\u00108\u001a\u0002002\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u00000:H\u0000¢\u0006\u0002\b;J\r\u0010<\u001a\u000200H\u0000¢\u0006\u0002\b=JI\u0010>\u001a\u000200\"\b\b\u0000\u0010?*\u00020\u00012\u0006\u0010@\u001a\u0002H?2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010B2\u0014\b\u0002\u0010C\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030&\u0018\u00010:2\b\b\u0002\u0010D\u001a\u00020\u0010¢\u0006\u0002\u0010EJ\u000e\u0010F\u001a\u0002002\u0006\u0010G\u001a\u00020\u0006J\u0013\u0010H\u001a\u00020\u00102\b\u0010I\u001a\u0004\u0018\u00010\u0001HÖ\u0003JA\u0010J\u001a\u0004\u0018\u0001H?\"\u0004\b\u0000\u0010?2\n\u0010K\u001a\u0006\u0012\u0002\b\u00030&2\b\u0010A\u001a\u0004\u0018\u00010B2\u0014\u0010(\u001a\u0010\u0012\u0004\u0012\u00020*\u0018\u00010)j\u0004\u0018\u0001`+H\u0002¢\u0006\u0002\u0010LJC\u0010M\u001a\u0002H?\"\u0004\b\u0000\u0010?2\n\u0010K\u001a\u0006\u0012\u0002\b\u00030N2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010B2\u0016\b\u0002\u0010(\u001a\u0010\u0012\u0004\u0012\u00020*\u0018\u00010)j\u0004\u0018\u0001`+H\u0007¢\u0006\u0002\u0010OJA\u0010M\u001a\u0002H?\"\u0004\b\u0000\u0010?2\n\u0010K\u001a\u0006\u0012\u0002\b\u00030&2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010B2\u0016\b\u0002\u0010(\u001a\u0010\u0012\u0004\u0012\u00020*\u0018\u00010)j\u0004\u0018\u0001`+¢\u0006\u0002\u0010LJ:\u0010M\u001a\u0002H?\"\u0006\b\u0000\u0010?\u0018\u00012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010B2\u0016\b\n\u0010(\u001a\u0010\u0012\u0004\u0012\u00020*\u0018\u00010)j\u0004\u0018\u0001`+H\b¢\u0006\u0002\u0010PJ\u001b\u0010Q\u001a\b\u0012\u0004\u0012\u0002H?0:\"\n\b\u0000\u0010?\u0018\u0001*\u00020\u0001H\bJ\"\u0010Q\u001a\b\u0012\u0004\u0012\u0002H?0:\"\b\b\u0000\u0010?*\u00020\u00012\n\u0010K\u001a\u0006\u0012\u0002\b\u00030&J!\u0010R\u001a\u0004\u0018\u0001H?\"\u0004\b\u0000\u0010?2\n\u0010K\u001a\u0006\u0012\u0002\b\u00030&H\u0002¢\u0006\u0002\u0010SJ\u0006\u0010T\u001a\u00020\bJE\u0010U\u001a\u0004\u0018\u0001H?\"\u0004\b\u0000\u0010?2\n\u0010K\u001a\u0006\u0012\u0002\b\u00030&2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010B2\u0016\b\u0002\u0010(\u001a\u0010\u0012\u0004\u0012\u00020*\u0018\u00010)j\u0004\u0018\u0001`+H\u0007¢\u0006\u0002\u0010LJ<\u0010U\u001a\u0004\u0018\u0001H?\"\u0006\b\u0000\u0010?\u0018\u00012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010B2\u0016\b\n\u0010(\u001a\u0010\u0012\u0004\u0012\u00020*\u0018\u00010)j\u0004\u0018\u0001`+H\b¢\u0006\u0002\u0010PJ\u0019\u0010V\u001a\u0002H?\"\u0004\b\u0000\u0010?2\u0006\u0010W\u001a\u00020\u0003¢\u0006\u0002\u0010XJ!\u0010V\u001a\u0002H?\"\u0004\b\u0000\u0010?2\u0006\u0010W\u001a\u00020\u00032\u0006\u0010Y\u001a\u0002H?¢\u0006\u0002\u0010ZJ\u001b\u0010[\u001a\u0004\u0018\u0001H?\"\u0004\b\u0000\u0010?2\u0006\u0010W\u001a\u00020\u0003¢\u0006\u0002\u0010XJ\u0012\u0010\\\u001a\u00020\u00002\n\u0010]\u001a\u00060\u0003j\u0002`\u0004J\u001a\u0010^\u001a\u0002H?\"\n\b\u0000\u0010?\u0018\u0001*\u00020\u0001H\b¢\u0006\u0002\u0010\u001dJ\t\u0010_\u001a\u00020`HÖ\u0001J;\u0010a\u001a\b\u0012\u0004\u0012\u0002H?0b\"\u0006\b\u0000\u0010?\u0018\u00012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010B2\u0016\b\n\u0010(\u001a\u0010\u0012\u0004\u0012\u00020*\u0018\u00010)j\u0004\u0018\u0001`+H\bJ=\u0010c\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H?0b\"\u0006\b\u0000\u0010?\u0018\u00012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010B2\u0016\b\n\u0010(\u001a\u0010\u0012\u0004\u0012\u00020*\u0018\u00010)j\u0004\u0018\u0001`+H\bJ\u001f\u0010d\u001a\u0002002\u0012\u0010e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000f\"\u00020\u0000¢\u0006\u0002\u0010gJ\u000e\u0010h\u001a\u0002002\u0006\u0010G\u001a\u00020\u0006J\u000e\u0010i\u001a\u0002002\u0006\u0010j\u001a\u00020\rJ?\u0010k\u001a\u0002H?\"\u0004\b\u0000\u0010?2\b\u0010A\u001a\u0004\u0018\u00010B2\n\u0010K\u001a\u0006\u0012\u0002\b\u00030&2\u0014\u0010(\u001a\u0010\u0012\u0004\u0012\u00020*\u0018\u00010)j\u0004\u0018\u0001`+H\u0002¢\u0006\u0002\u0010lJ\u001e\u0010m\u001a\u00020n2\b\u0010A\u001a\u0004\u0018\u00010B2\n\u0010K\u001a\u0006\u0012\u0002\b\u00030&H\u0002J\b\u0010o\u001a\u00020\u0003H\u0016J\u001f\u0010p\u001a\u0002002\u0012\u0010e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000f\"\u00020\u0000¢\u0006\u0002\u0010gR\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R!\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00000\fj\b\u0012\u0004\u0012\u00020\u0000`\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0015\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u0006q"}, d2 = {"Lorg/koin/core/scope/Scope;", "", "id", "", "Lorg/koin/core/scope/ScopeID;", "_scopeDefinition", "Lorg/koin/core/scope/ScopeDefinition;", "_koin", "Lorg/koin/core/Koin;", "_source", "(Ljava/lang/String;Lorg/koin/core/scope/ScopeDefinition;Lorg/koin/core/Koin;Ljava/lang/Object;)V", "_callbacks", "Ljava/util/ArrayList;", "Lorg/koin/core/scope/ScopeCallback;", "Lkotlin/collections/ArrayList;", "_closed", "", "_instanceRegistry", "Lorg/koin/core/registry/InstanceRegistry;", "get_instanceRegistry", "()Lorg/koin/core/registry/InstanceRegistry;", "get_koin", "()Lorg/koin/core/Koin;", "_linkedScope", "get_linkedScope", "()Ljava/util/ArrayList;", "get_scopeDefinition", "()Lorg/koin/core/scope/ScopeDefinition;", "get_source", "()Ljava/lang/Object;", "closed", "getClosed", "()Z", "getId", "()Ljava/lang/String;", "bind", ExifInterface.LATITUDE_SOUTH, "primaryType", "Lkotlin/reflect/KClass;", "secondaryType", "parameters", "Lkotlin/Function0;", "Lorg/koin/core/parameter/DefinitionParameters;", "Lorg/koin/core/parameter/ParametersDefinition;", "(Lkotlin/reflect/KClass;Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "P", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "clear", "", "clear$koin_core", "close", "component1", "component2", "component3", "component4", "copy", "create", "links", "", "create$koin_core", "createEagerInstances", "createEagerInstances$koin_core", "declare", ExifInterface.GPS_DIRECTION_TRUE, "instance", "qualifier", "Lorg/koin/core/qualifier/Qualifier;", "secondaryTypes", "override", "(Ljava/lang/Object;Lorg/koin/core/qualifier/Qualifier;Ljava/util/List;Z)V", "dropInstances", "scopeDefinition", "equals", FitnessActivities.OTHER, "findInOtherScope", "clazz", "(Lkotlin/reflect/KClass;Lorg/koin/core/qualifier/Qualifier;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "get", "Ljava/lang/Class;", "(Ljava/lang/Class;Lorg/koin/core/qualifier/Qualifier;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "(Lorg/koin/core/qualifier/Qualifier;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "getAll", "getFromSource", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "getKoin", "getOrNull", "getProperty", "key", "(Ljava/lang/String;)Ljava/lang/Object;", "defaultValue", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "getPropertyOrNull", "getScope", "scopeID", "getSource", "hashCode", "", "inject", "Lkotlin/Lazy;", "injectOrNull", "linkTo", "scopes", "", "([Lorg/koin/core/scope/Scope;)V", "loadDefinitions", "registerCallback", "callback", "resolveInstance", "(Lorg/koin/core/qualifier/Qualifier;Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "throwDefinitionNotFound", "", "toString", "unlink", "koin-core"}, k = 1, mv = {1, 1, 16})
/* compiled from: Scope.kt */
public final class Scope {
    private final ArrayList<ScopeCallback> _callbacks;
    private boolean _closed;
    private final InstanceRegistry _instanceRegistry;
    private final Koin _koin;
    private final ArrayList<Scope> _linkedScope;
    private final ScopeDefinition _scopeDefinition;
    private final Object _source;
    private final String id;

    public static /* synthetic */ Scope copy$default(Scope scope, String str, ScopeDefinition scopeDefinition, Koin koin, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            str = scope.id;
        }
        if ((i & 2) != 0) {
            scopeDefinition = scope._scopeDefinition;
        }
        if ((i & 4) != 0) {
            koin = scope._koin;
        }
        if ((i & 8) != 0) {
            obj = scope._source;
        }
        return scope.copy(str, scopeDefinition, koin, obj);
    }

    public final String component1() {
        return this.id;
    }

    public final ScopeDefinition component2() {
        return this._scopeDefinition;
    }

    public final Koin component3() {
        return this._koin;
    }

    public final Object component4() {
        return this._source;
    }

    public final Scope copy(String str, ScopeDefinition scopeDefinition, Koin koin, Object obj) {
        Intrinsics.checkParameterIsNotNull(str, "id");
        Intrinsics.checkParameterIsNotNull(scopeDefinition, "_scopeDefinition");
        Intrinsics.checkParameterIsNotNull(koin, "_koin");
        return new Scope(str, scopeDefinition, koin, obj);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Scope)) {
            return false;
        }
        Scope scope = (Scope) obj;
        return Intrinsics.areEqual(this.id, scope.id) && Intrinsics.areEqual(this._scopeDefinition, scope._scopeDefinition) && Intrinsics.areEqual(this._koin, scope._koin) && Intrinsics.areEqual(this._source, scope._source);
    }

    public final /* synthetic */ <T> T get() {
        return get$default(this, null, null, 3, null);
    }

    public final <T> T get(Class<?> cls) {
        return get$default(this, cls, (Qualifier) null, (Function0) null, 6, (Object) null);
    }

    public final <T> T get(Class<?> cls, Qualifier qualifier) {
        return get$default(this, cls, qualifier, (Function0) null, 4, (Object) null);
    }

    public final /* synthetic */ <T> T get(Qualifier qualifier) {
        return get$default(this, qualifier, null, 2, null);
    }

    public final /* synthetic */ <T> T getOrNull() {
        return getOrNull$default(this, null, null, 3, null);
    }

    public final <T> T getOrNull(KClass<?> kClass) {
        return getOrNull$default(this, kClass, null, null, 6, null);
    }

    public final <T> T getOrNull(KClass<?> kClass, Qualifier qualifier) {
        return getOrNull$default(this, kClass, qualifier, null, 4, null);
    }

    public final /* synthetic */ <T> T getOrNull(Qualifier qualifier) {
        return getOrNull$default(this, qualifier, null, 2, null);
    }

    public int hashCode() {
        String str = this.id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        ScopeDefinition scopeDefinition = this._scopeDefinition;
        int hashCode2 = (hashCode + (scopeDefinition != null ? scopeDefinition.hashCode() : 0)) * 31;
        Koin koin = this._koin;
        int hashCode3 = (hashCode2 + (koin != null ? koin.hashCode() : 0)) * 31;
        Object obj = this._source;
        if (obj != null) {
            i = obj.hashCode();
        }
        return hashCode3 + i;
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

    public Scope(String str, ScopeDefinition scopeDefinition, Koin koin, Object obj) {
        Intrinsics.checkParameterIsNotNull(str, "id");
        Intrinsics.checkParameterIsNotNull(scopeDefinition, "_scopeDefinition");
        Intrinsics.checkParameterIsNotNull(koin, "_koin");
        this.id = str;
        this._scopeDefinition = scopeDefinition;
        this._koin = koin;
        this._source = obj;
        this._linkedScope = new ArrayList<>();
        this._instanceRegistry = new InstanceRegistry(this._koin, this);
        this._callbacks = new ArrayList<>();
    }

    public final String getId() {
        return this.id;
    }

    public final ScopeDefinition get_scopeDefinition() {
        return this._scopeDefinition;
    }

    public final Koin get_koin() {
        return this._koin;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Scope(String str, ScopeDefinition scopeDefinition, Koin koin, Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, scopeDefinition, koin, (i & 8) != 0 ? null : obj);
    }

    public final Object get_source() {
        return this._source;
    }

    public final ArrayList<Scope> get_linkedScope() {
        return this._linkedScope;
    }

    public final InstanceRegistry get_instanceRegistry() {
        return this._instanceRegistry;
    }

    public final boolean getClosed() {
        return this._closed;
    }

    public final void create$koin_core(List<Scope> list) {
        Intrinsics.checkParameterIsNotNull(list, "links");
        this._instanceRegistry.create$koin_core(this._scopeDefinition.getDefinitions());
        this._linkedScope.addAll(list);
    }

    public final /* synthetic */ <T> T getSource() {
        T t = get_source();
        Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);
        T t2 = (Object) t;
        if (t2 != null) {
            return t2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't use Scope source for ");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        sb.append(KClassExtKt.getFullName(Reflection.getOrCreateKotlinClass(Object.class)));
        sb.append(" - source is:");
        sb.append(get_source());
        throw new IllegalStateException(sb.toString().toString());
    }

    public final void linkTo(Scope... scopeArr) {
        Intrinsics.checkParameterIsNotNull(scopeArr, "scopes");
        if (!this._scopeDefinition.isRoot()) {
            CollectionsKt.addAll(this._linkedScope, scopeArr);
            return;
        }
        throw new IllegalStateException("Can't add scope link to a root scope".toString());
    }

    public final void unlink(Scope... scopeArr) {
        Intrinsics.checkParameterIsNotNull(scopeArr, "scopes");
        if (!this._scopeDefinition.isRoot()) {
            CollectionsKt.removeAll(this._linkedScope, scopeArr);
            return;
        }
        throw new IllegalStateException("Can't remove scope link to a root scope".toString());
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: kotlin.LazyKt__LazyJVMKt.lazy(kotlin.LazyThreadSafetyMode, kotlin.jvm.functions.Function0):kotlin.Lazy<T>
     arg types: [kotlin.LazyThreadSafetyMode, org.koin.core.scope.Scope$inject$1]
     candidates:
      kotlin.LazyKt__LazyJVMKt.lazy(java.lang.Object, kotlin.jvm.functions.Function0):kotlin.Lazy<T>
      kotlin.LazyKt__LazyJVMKt.lazy(kotlin.LazyThreadSafetyMode, kotlin.jvm.functions.Function0):kotlin.Lazy<T> */
    public static /* synthetic */ Lazy inject$default(Scope scope, Qualifier qualifier, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            qualifier = null;
        }
        if ((i & 2) != 0) {
            function0 = null;
        }
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        Intrinsics.needClassReification();
        return LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Scope$inject$1(scope, qualifier, function0));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: kotlin.LazyKt__LazyJVMKt.lazy(kotlin.LazyThreadSafetyMode, kotlin.jvm.functions.Function0):kotlin.Lazy<T>
     arg types: [kotlin.LazyThreadSafetyMode, org.koin.core.scope.Scope$inject$1]
     candidates:
      kotlin.LazyKt__LazyJVMKt.lazy(java.lang.Object, kotlin.jvm.functions.Function0):kotlin.Lazy<T>
      kotlin.LazyKt__LazyJVMKt.lazy(kotlin.LazyThreadSafetyMode, kotlin.jvm.functions.Function0):kotlin.Lazy<T> */
    public final /* synthetic */ <T> Lazy<T> inject(Qualifier qualifier, Function0<DefinitionParameters> function0) {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        Intrinsics.needClassReification();
        return LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Scope$inject$1(this, qualifier, function0));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: kotlin.LazyKt__LazyJVMKt.lazy(kotlin.LazyThreadSafetyMode, kotlin.jvm.functions.Function0):kotlin.Lazy<T>
     arg types: [kotlin.LazyThreadSafetyMode, org.koin.core.scope.Scope$injectOrNull$1]
     candidates:
      kotlin.LazyKt__LazyJVMKt.lazy(java.lang.Object, kotlin.jvm.functions.Function0):kotlin.Lazy<T>
      kotlin.LazyKt__LazyJVMKt.lazy(kotlin.LazyThreadSafetyMode, kotlin.jvm.functions.Function0):kotlin.Lazy<T> */
    public static /* synthetic */ Lazy injectOrNull$default(Scope scope, Qualifier qualifier, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            qualifier = null;
        }
        if ((i & 2) != 0) {
            function0 = null;
        }
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        Intrinsics.needClassReification();
        return LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Scope$injectOrNull$1(scope, qualifier, function0));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: kotlin.LazyKt__LazyJVMKt.lazy(kotlin.LazyThreadSafetyMode, kotlin.jvm.functions.Function0):kotlin.Lazy<T>
     arg types: [kotlin.LazyThreadSafetyMode, org.koin.core.scope.Scope$injectOrNull$1]
     candidates:
      kotlin.LazyKt__LazyJVMKt.lazy(java.lang.Object, kotlin.jvm.functions.Function0):kotlin.Lazy<T>
      kotlin.LazyKt__LazyJVMKt.lazy(kotlin.LazyThreadSafetyMode, kotlin.jvm.functions.Function0):kotlin.Lazy<T> */
    public final /* synthetic */ <T> Lazy<T> injectOrNull(Qualifier qualifier, Function0<DefinitionParameters> function0) {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        Intrinsics.needClassReification();
        return LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Scope$injectOrNull$1(this, qualifier, function0));
    }

    public static /* synthetic */ Object get$default(Scope scope, Qualifier qualifier, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            qualifier = null;
        }
        if ((i & 2) != 0) {
            function0 = null;
        }
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return scope.get(Reflection.getOrCreateKotlinClass(Object.class), qualifier, function0);
    }

    public final /* synthetic */ <T> T get(Qualifier qualifier, Function0<DefinitionParameters> function0) {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return get(Reflection.getOrCreateKotlinClass(Object.class), qualifier, function0);
    }

    public static /* synthetic */ Object getOrNull$default(Scope scope, Qualifier qualifier, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            qualifier = null;
        }
        if ((i & 2) != 0) {
            function0 = null;
        }
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return scope.getOrNull(Reflection.getOrCreateKotlinClass(Object.class), qualifier, function0);
    }

    public final /* synthetic */ <T> T getOrNull(Qualifier qualifier, Function0<DefinitionParameters> function0) {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return getOrNull(Reflection.getOrCreateKotlinClass(Object.class), qualifier, function0);
    }

    public static /* synthetic */ Object getOrNull$default(Scope scope, KClass kClass, Qualifier qualifier, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            qualifier = null;
        }
        if ((i & 4) != 0) {
            function0 = null;
        }
        return scope.getOrNull(kClass, qualifier, function0);
    }

    public final <T> T getOrNull(KClass<?> kClass, Qualifier qualifier, Function0<DefinitionParameters> function0) {
        Intrinsics.checkParameterIsNotNull(kClass, "clazz");
        try {
            return get(kClass, qualifier, function0);
        } catch (Exception unused) {
            Logger logger = this._koin.get_logger();
            logger.error("Can't get instance for " + KClassExtKt.getFullName(kClass));
            return null;
        }
    }

    public static /* synthetic */ Object get$default(Scope scope, KClass kClass, Qualifier qualifier, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            qualifier = null;
        }
        if ((i & 4) != 0) {
            function0 = null;
        }
        return scope.get(kClass, qualifier, function0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x002b, code lost:
        if (r1 != null) goto L_0x0030;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T> T get(kotlin.reflect.KClass<?> r6, org.koin.core.qualifier.Qualifier r7, kotlin.jvm.functions.Function0<org.koin.core.parameter.DefinitionParameters> r8) {
        /*
            r5 = this;
            java.lang.String r0 = "clazz"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r6, r0)
            org.koin.core.Koin r0 = r5._koin
            org.koin.core.logger.Logger r0 = r0.get_logger()
            org.koin.core.logger.Level r1 = org.koin.core.logger.Level.DEBUG
            boolean r0 = r0.isAt(r1)
            if (r0 == 0) goto L_0x0099
            r0 = 39
            if (r7 == 0) goto L_0x002e
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = " with qualifier '"
            r1.append(r2)
            r1.append(r7)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            if (r1 == 0) goto L_0x002e
            goto L_0x0030
        L_0x002e:
            java.lang.String r1 = ""
        L_0x0030:
            org.koin.core.Koin r2 = r5._koin
            org.koin.core.logger.Logger r2 = r2.get_logger()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "+- '"
            r3.append(r4)
            java.lang.String r4 = org.koin.ext.KClassExtKt.getFullName(r6)
            r3.append(r4)
            r3.append(r0)
            r3.append(r1)
            java.lang.String r0 = r3.toString()
            r2.debug(r0)
            org.koin.core.scope.Scope$get$1 r0 = new org.koin.core.scope.Scope$get$1
            r0.<init>(r5, r7, r6, r8)
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            kotlin.Pair r7 = org.koin.core.time.MeasureKt.measureDurationForResult(r0)
            java.lang.Object r8 = r7.component1()
            java.lang.Object r7 = r7.component2()
            java.lang.Number r7 = (java.lang.Number) r7
            double r0 = r7.doubleValue()
            org.koin.core.Koin r7 = r5._koin
            org.koin.core.logger.Logger r7 = r7.get_logger()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "|- '"
            r2.append(r3)
            java.lang.String r6 = org.koin.ext.KClassExtKt.getFullName(r6)
            r2.append(r6)
            java.lang.String r6 = "' in "
            r2.append(r6)
            r2.append(r0)
            java.lang.String r6 = " ms"
            r2.append(r6)
            java.lang.String r6 = r2.toString()
            r7.debug(r6)
            return r8
        L_0x0099:
            java.lang.Object r6 = r5.resolveInstance(r7, r6, r8)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.koin.core.scope.Scope.get(kotlin.reflect.KClass, org.koin.core.qualifier.Qualifier, kotlin.jvm.functions.Function0):java.lang.Object");
    }

    public static /* synthetic */ Object get$default(Scope scope, Class cls, Qualifier qualifier, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            qualifier = null;
        }
        if ((i & 4) != 0) {
            function0 = null;
        }
        return scope.get(cls, qualifier, function0);
    }

    public final <T> T get(Class<?> cls, Qualifier qualifier, Function0<DefinitionParameters> function0) {
        Intrinsics.checkParameterIsNotNull(cls, "clazz");
        return get(JvmClassMappingKt.getKotlinClass(cls), qualifier, function0);
    }

    /* access modifiers changed from: private */
    public final <T> T resolveInstance(Qualifier qualifier, KClass<?> kClass, Function0<DefinitionParameters> function0) {
        if (!this._closed) {
            T resolveInstance$koin_core = this._instanceRegistry.resolveInstance$koin_core(BeanDefinitionKt.indexKey(kClass, qualifier), function0);
            if (resolveInstance$koin_core == null) {
                resolveInstance$koin_core = findInOtherScope(kClass, qualifier, function0);
            }
            if (resolveInstance$koin_core == null) {
                resolveInstance$koin_core = getFromSource(kClass);
            }
            if (resolveInstance$koin_core != null) {
                return resolveInstance$koin_core;
            }
            throwDefinitionNotFound(qualifier, kClass);
            throw null;
        }
        throw new ClosedScopeException("Scope '" + this.id + "' is closed");
    }

    private final <T> T getFromSource(KClass<?> kClass) {
        if (!kClass.isInstance(this._source)) {
            return null;
        }
        T t = this._source;
        if (!(t instanceof Object)) {
            return null;
        }
        return t;
    }

    private final <T> T findInOtherScope(KClass<?> kClass, Qualifier qualifier, Function0<DefinitionParameters> function0) {
        Object obj;
        boolean z;
        Iterator it = this._linkedScope.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((Scope) obj).getOrNull(kClass, qualifier, function0) != null) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        Scope scope = (Scope) obj;
        if (scope != null) {
            return scope.get(kClass, qualifier, function0);
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0018, code lost:
        if (r5 != null) goto L_0x001d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Void throwDefinitionNotFound(org.koin.core.qualifier.Qualifier r5, kotlin.reflect.KClass<?> r6) {
        /*
            r4 = this;
            r0 = 39
            if (r5 == 0) goto L_0x001b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = " & qualifier:'"
            r1.append(r2)
            r1.append(r5)
            r1.append(r0)
            java.lang.String r5 = r1.toString()
            if (r5 == 0) goto L_0x001b
            goto L_0x001d
        L_0x001b:
            java.lang.String r5 = ""
        L_0x001d:
            org.koin.core.error.NoBeanDefFoundException r1 = new org.koin.core.error.NoBeanDefFoundException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "No definition found for class:'"
            r2.append(r3)
            java.lang.String r6 = org.koin.ext.KClassExtKt.getFullName(r6)
            r2.append(r6)
            r2.append(r0)
            r2.append(r5)
            java.lang.String r5 = ". Check your definitions!"
            r2.append(r5)
            java.lang.String r5 = r2.toString()
            r1.<init>(r5)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.koin.core.scope.Scope.throwDefinitionNotFound(org.koin.core.qualifier.Qualifier, kotlin.reflect.KClass):java.lang.Void");
    }

    public final void createEagerInstances$koin_core() {
        if (this._scopeDefinition.isRoot()) {
            this._instanceRegistry.createEagerInstances$koin_core();
        }
    }

    public static /* synthetic */ void declare$default(Scope scope, Object obj, Qualifier qualifier, List list, boolean z, int i, Object obj2) {
        if ((i & 2) != 0) {
            qualifier = null;
        }
        if ((i & 4) != 0) {
            list = null;
        }
        if ((i & 8) != 0) {
            z = false;
        }
        scope.declare(obj, qualifier, list, z);
    }

    public final <T> void declare(T t, Qualifier qualifier, List<? extends KClass<?>> list, boolean z) {
        Intrinsics.checkParameterIsNotNull(t, "instance");
        synchronized (this) {
            this._instanceRegistry.saveDefinition(this._scopeDefinition.saveNewDefinition(t, qualifier, list, z), true);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final Koin getKoin() {
        return this._koin;
    }

    public final Scope getScope(String str) {
        Intrinsics.checkParameterIsNotNull(str, "scopeID");
        return getKoin().getScope(str);
    }

    public final void registerCallback(ScopeCallback scopeCallback) {
        Intrinsics.checkParameterIsNotNull(scopeCallback, "callback");
        this._callbacks.add(scopeCallback);
    }

    public final /* synthetic */ <T> List<T> getAll() {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return getAll(Reflection.getOrCreateKotlinClass(Object.class));
    }

    public final <T> List<T> getAll(KClass<?> kClass) {
        Intrinsics.checkParameterIsNotNull(kClass, "clazz");
        return this._instanceRegistry.getAll$koin_core(kClass);
    }

    public static /* synthetic */ Object bind$default(Scope scope, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        Intrinsics.reifiedOperationMarker(4, ExifInterface.LATITUDE_SOUTH);
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(4, "P");
        return scope.bind(Reflection.getOrCreateKotlinClass(Object.class), orCreateKotlinClass, function0);
    }

    public final /* synthetic */ <S, P> S bind(Function0<DefinitionParameters> function0) {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.LATITUDE_SOUTH);
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(4, "P");
        return bind(Reflection.getOrCreateKotlinClass(Object.class), orCreateKotlinClass, function0);
    }

    public final <S> S bind(KClass<?> kClass, KClass<?> kClass2, Function0<DefinitionParameters> function0) {
        Intrinsics.checkParameterIsNotNull(kClass, "primaryType");
        Intrinsics.checkParameterIsNotNull(kClass2, "secondaryType");
        S bind$koin_core = this._instanceRegistry.bind$koin_core(kClass, kClass2, function0);
        if (bind$koin_core != null) {
            return bind$koin_core;
        }
        throw new NoBeanDefFoundException("No definition found to bind class:'" + KClassExtKt.getFullName(kClass) + "' & secondary type:'" + KClassExtKt.getFullName(kClass2) + "'. Check your definitions!");
    }

    public final <T> T getProperty(String str, T t) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        return this._koin.getProperty(str, t);
    }

    public final <T> T getPropertyOrNull(String str) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        return this._koin.getProperty(str);
    }

    public final <T> T getProperty(String str) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        T property = this._koin.getProperty(str);
        if (property != null) {
            return property;
        }
        throw new MissingPropertyException("Property '" + str + "' not found");
    }

    public final void close() {
        synchronized (this) {
            clear$koin_core();
            this._koin.get_scopeRegistry().deleteScope(this);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void clear$koin_core() {
        synchronized (this) {
            this._closed = true;
            if (this._koin.get_logger().isAt(Level.DEBUG)) {
                Logger logger = this._koin.get_logger();
                logger.info("closing scope:'" + this.id + '\'');
            }
            for (ScopeCallback onScopeClose : this._callbacks) {
                onScopeClose.onScopeClose(this);
            }
            this._callbacks.clear();
            this._instanceRegistry.close$koin_core();
            Unit unit = Unit.INSTANCE;
        }
    }

    public String toString() {
        return "['" + this.id + "']";
    }

    public final void dropInstances(ScopeDefinition scopeDefinition) {
        Intrinsics.checkParameterIsNotNull(scopeDefinition, "scopeDefinition");
        for (BeanDefinition dropDefinition$koin_core : scopeDefinition.getDefinitions()) {
            this._instanceRegistry.dropDefinition$koin_core(dropDefinition$koin_core);
        }
    }

    public final void loadDefinitions(ScopeDefinition scopeDefinition) {
        Intrinsics.checkParameterIsNotNull(scopeDefinition, "scopeDefinition");
        for (BeanDefinition createDefinition$koin_core : scopeDefinition.getDefinitions()) {
            this._instanceRegistry.createDefinition$koin_core(createDefinition$koin_core);
        }
    }
}
