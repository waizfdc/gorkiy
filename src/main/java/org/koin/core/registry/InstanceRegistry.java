package org.koin.core.registry;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.koin.core.Koin;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.definition.BeanDefinitionKt;
import org.koin.core.definition.Kind;
import org.koin.core.instance.FactoryInstanceFactory;
import org.koin.core.instance.InstanceContext;
import org.koin.core.instance.InstanceFactory;
import org.koin.core.instance.SingleInstanceFactory;
import org.koin.core.logger.Level;
import org.koin.core.logger.Logger;
import org.koin.core.parameter.DefinitionParameters;
import org.koin.core.scope.Scope;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006JE\u0010\u0015\u001a\u0004\u0018\u0001H\u0016\"\u0004\b\u0000\u0010\u00162\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u00182\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u00182\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bj\u0004\u0018\u0001`\u001dH\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010 \u001a\u00020!H\u0000¢\u0006\u0002\b\"J\u001f\u0010#\u001a\u00020!2\u0010\u0010$\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030&0%H\u0000¢\u0006\u0002\b'J\u0019\u0010(\u001a\u00020!2\n\u0010)\u001a\u0006\u0012\u0002\b\u00030&H\u0000¢\u0006\u0002\b*J\r\u0010+\u001a\u00020!H\u0000¢\u0006\u0002\b,J \u0010-\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u0002\u001a\u00020\u00032\n\u0010)\u001a\u0006\u0012\u0002\b\u00030&H\u0002J\u001e\u0010.\u001a\u00020/2\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bj\u0004\u0018\u0001`\u001dH\u0002J\u0019\u00100\u001a\u00020!2\n\u0010)\u001a\u0006\u0012\u0002\b\u00030&H\u0000¢\u0006\u0002\b1J)\u00102\u001a\b\u0012\u0004\u0012\u0002H403\"\b\b\u0000\u00104*\u00020\u00012\n\u00105\u001a\u0006\u0012\u0002\b\u00030\u0018H\u0000¢\u0006\u0002\b6J9\u00107\u001a\u0004\u0018\u0001H4\"\u0004\b\u0000\u001042\n\u00108\u001a\u00060\tj\u0002`\n2\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bj\u0004\u0018\u0001`\u001dH\u0000¢\u0006\u0004\b9\u0010:J\u001a\u0010;\u001a\u00020!2\n\u0010)\u001a\u0006\u0012\u0002\b\u00030&2\u0006\u0010<\u001a\u00020=J(\u0010>\u001a\u00020!2\n\u0010?\u001a\u00060\tj\u0002`\n2\n\u0010@\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010<\u001a\u00020=H\u0002J \u0010A\u001a\u00020!2\n\u0010?\u001a\u00060\tj\u0002`\n2\n\u0010@\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0002R:\u0010\u0007\u001a.\u0012\b\u0012\u00060\tj\u0002`\n\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\bj\u0016\u0012\b\u0012\u00060\tj\u0002`\n\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b`\fX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R%\u0010\u0011\u001a\u0016\u0012\b\u0012\u00060\tj\u0002`\n\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006B"}, d2 = {"Lorg/koin/core/registry/InstanceRegistry;", "", "_koin", "Lorg/koin/core/Koin;", "_scope", "Lorg/koin/core/scope/Scope;", "(Lorg/koin/core/Koin;Lorg/koin/core/scope/Scope;)V", "_instances", "Ljava/util/HashMap;", "", "Lorg/koin/core/definition/IndexKey;", "Lorg/koin/core/instance/InstanceFactory;", "Lkotlin/collections/HashMap;", "get_koin", "()Lorg/koin/core/Koin;", "get_scope", "()Lorg/koin/core/scope/Scope;", "instances", "", "getInstances", "()Ljava/util/Map;", "bind", ExifInterface.LATITUDE_SOUTH, "primaryType", "Lkotlin/reflect/KClass;", "secondaryType", "parameters", "Lkotlin/Function0;", "Lorg/koin/core/parameter/DefinitionParameters;", "Lorg/koin/core/parameter/ParametersDefinition;", "bind$koin_core", "(Lkotlin/reflect/KClass;Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "close", "", "close$koin_core", "create", "definitions", "", "Lorg/koin/core/definition/BeanDefinition;", "create$koin_core", "createDefinition", "definition", "createDefinition$koin_core", "createEagerInstances", "createEagerInstances$koin_core", "createInstanceFactory", "defaultInstanceContext", "Lorg/koin/core/instance/InstanceContext;", "dropDefinition", "dropDefinition$koin_core", "getAll", "", ExifInterface.GPS_DIRECTION_TRUE, "clazz", "getAll$koin_core", "resolveInstance", "indexKey", "resolveInstance$koin_core", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "saveDefinition", "override", "", "saveInstance", "key", "factory", "saveInstanceIfPossible", "koin-core"}, k = 1, mv = {1, 1, 16})
/* compiled from: InstanceRegistry.kt */
public final class InstanceRegistry {
    private final HashMap<String, InstanceFactory<?>> _instances = new HashMap<>();
    private final Koin _koin;
    private final Scope _scope;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Kind.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[Kind.Single.ordinal()] = 1;
            $EnumSwitchMapping$0[Kind.Factory.ordinal()] = 2;
        }
    }

    public InstanceRegistry(Koin koin, Scope scope) {
        Intrinsics.checkParameterIsNotNull(koin, "_koin");
        Intrinsics.checkParameterIsNotNull(scope, "_scope");
        this._koin = koin;
        this._scope = scope;
    }

    public final Koin get_koin() {
        return this._koin;
    }

    public final Scope get_scope() {
        return this._scope;
    }

    public final Map<String, InstanceFactory<?>> getInstances() {
        return this._instances;
    }

    public final void create$koin_core(Set<? extends BeanDefinition<?>> set) {
        Intrinsics.checkParameterIsNotNull(set, "definitions");
        for (BeanDefinition beanDefinition : set) {
            if (this._koin.get_logger().isAt(Level.DEBUG)) {
                if (this._scope.get_scopeDefinition().isRoot()) {
                    Logger logger = this._koin.get_logger();
                    logger.debug("- " + beanDefinition);
                } else {
                    Logger logger2 = this._koin.get_logger();
                    logger2.debug(this._scope + " -> " + beanDefinition);
                }
            }
            saveDefinition(beanDefinition, false);
        }
    }

    public final void saveDefinition(BeanDefinition<?> beanDefinition, boolean z) {
        Intrinsics.checkParameterIsNotNull(beanDefinition, "definition");
        boolean z2 = beanDefinition.getOptions().getOverride() || z;
        InstanceFactory<?> createInstanceFactory = createInstanceFactory(this._koin, beanDefinition);
        saveInstance(BeanDefinitionKt.indexKey(beanDefinition.getPrimaryType(), beanDefinition.getQualifier()), createInstanceFactory, z2);
        for (KClass kClass : beanDefinition.getSecondaryTypes()) {
            if (z2) {
                saveInstance(BeanDefinitionKt.indexKey(kClass, beanDefinition.getQualifier()), createInstanceFactory, z2);
            } else {
                saveInstanceIfPossible(BeanDefinitionKt.indexKey(kClass, beanDefinition.getQualifier()), createInstanceFactory);
            }
        }
    }

    private final InstanceFactory<?> createInstanceFactory(Koin koin, BeanDefinition<?> beanDefinition) {
        int i = WhenMappings.$EnumSwitchMapping$0[beanDefinition.getKind().ordinal()];
        if (i == 1) {
            return new SingleInstanceFactory<>(koin, beanDefinition);
        }
        if (i == 2) {
            return new FactoryInstanceFactory<>(koin, beanDefinition);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final void saveInstance(String str, InstanceFactory<?> instanceFactory, boolean z) {
        if (!this._instances.containsKey(str) || z) {
            this._instances.put(str, instanceFactory);
            return;
        }
        throw new IllegalStateException(("InstanceRegistry already contains index '" + str + '\'').toString());
    }

    private final void saveInstanceIfPossible(String str, InstanceFactory<?> instanceFactory) {
        if (!this._instances.containsKey(str)) {
            this._instances.put(str, instanceFactory);
        }
    }

    public final <T> T resolveInstance$koin_core(String str, Function0<DefinitionParameters> function0) {
        Intrinsics.checkParameterIsNotNull(str, "indexKey");
        InstanceFactory instanceFactory = this._instances.get(str);
        T t = instanceFactory != null ? instanceFactory.get(defaultInstanceContext(function0)) : null;
        if (!(t instanceof Object)) {
            return null;
        }
        return t;
    }

    private final InstanceContext defaultInstanceContext(Function0<DefinitionParameters> function0) {
        return new InstanceContext(this._koin, this._scope, function0);
    }

    public final void close$koin_core() {
        Collection<InstanceFactory<?>> values = this._instances.values();
        Intrinsics.checkExpressionValueIsNotNull(values, "_instances.values");
        for (InstanceFactory drop : values) {
            drop.drop();
        }
        this._instances.clear();
    }

    public final void createEagerInstances$koin_core() {
        Collection arrayList = new ArrayList();
        for (Object next : getInstances().values()) {
            if (next instanceof SingleInstanceFactory) {
                arrayList.add(next);
            }
        }
        Collection arrayList2 = new ArrayList();
        for (Object next2 : (List) arrayList) {
            if (((SingleInstanceFactory) next2).getBeanDefinition().getOptions().isCreatedAtStart()) {
                arrayList2.add(next2);
            }
        }
        for (SingleInstanceFactory singleInstanceFactory : (List) arrayList2) {
            singleInstanceFactory.get(new InstanceContext(this._koin, this._scope, null, 4, null));
        }
    }

    public final <T> List<T> getAll$koin_core(KClass<?> kClass) {
        Intrinsics.checkParameterIsNotNull(kClass, "clazz");
        Collection arrayList = new ArrayList();
        for (Object next : CollectionsKt.toSet(getInstances().values())) {
            if (((InstanceFactory) next).getBeanDefinition().hasType(kClass)) {
                arrayList.add(next);
            }
        }
        Collection arrayList2 = new ArrayList();
        for (InstanceFactory instanceFactory : (List) arrayList) {
            Object obj = null;
            Object obj2 = instanceFactory.get(defaultInstanceContext(null));
            if (obj2 instanceof Object) {
                obj = obj2;
            }
            if (obj != null) {
                arrayList2.add(obj);
            }
        }
        return (List) arrayList2;
    }

    public final <S> S bind$koin_core(KClass<?> kClass, KClass<?> kClass2, Function0<DefinitionParameters> function0) {
        Object obj;
        Intrinsics.checkParameterIsNotNull(kClass, "primaryType");
        Intrinsics.checkParameterIsNotNull(kClass2, "secondaryType");
        Iterator it = getInstances().values().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((InstanceFactory) obj).getBeanDefinition().canBind(kClass, kClass2)) {
                break;
            }
        }
        InstanceFactory instanceFactory = (InstanceFactory) obj;
        S s = instanceFactory != null ? instanceFactory.get(defaultInstanceContext(function0)) : null;
        if (!(s instanceof Object)) {
            return null;
        }
        return s;
    }

    public final void dropDefinition$koin_core(BeanDefinition<?> beanDefinition) {
        Intrinsics.checkParameterIsNotNull(beanDefinition, "definition");
        Map linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : this._instances.entrySet()) {
            if (Intrinsics.areEqual(((InstanceFactory) entry.getValue()).getBeanDefinition(), beanDefinition)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        Collection arrayList = new ArrayList(linkedHashMap.size());
        for (Map.Entry key : linkedHashMap.entrySet()) {
            arrayList.add((String) key.getKey());
        }
        for (String remove : (List) arrayList) {
            this._instances.remove(remove);
        }
    }

    public final void createDefinition$koin_core(BeanDefinition<?> beanDefinition) {
        Intrinsics.checkParameterIsNotNull(beanDefinition, "definition");
        saveDefinition(beanDefinition, false);
    }
}
