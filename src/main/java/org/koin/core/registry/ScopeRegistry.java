package org.koin.core.registry;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.Koin;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.error.NoScopeDefFoundException;
import org.koin.core.error.ScopeAlreadyCreatedException;
import org.koin.core.logger.Logger;
import org.koin.core.module.Module;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;
import org.koin.core.scope.ScopeDefinition;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010 \u001a\u00020!H\u0002J\r\u0010\"\u001a\u00020!H\u0000¢\u0006\u0002\b#J\r\u0010$\u001a\u00020!H\u0000¢\u0006\u0002\b%J\r\u0010&\u001a\u00020!H\u0000¢\u0006\u0002\b'J&\u0010(\u001a\u00020\u00062\n\u0010)\u001a\u00060\u0013j\u0002`\u00172\u0006\u0010*\u001a\u00020+2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0001J&\u0010(\u001a\u00020\u00062\n\u0010)\u001a\u00060\u0013j\u0002`\u00172\u0006\u0010-\u001a\u00020\f2\b\u0010,\u001a\u0004\u0018\u00010\u0001H\u0002J\u0010\u0010.\u001a\u00020!2\u0006\u0010/\u001a\u00020\fH\u0002J\u0010\u00100\u001a\u00020!2\u0006\u0010-\u001a\u00020\fH\u0002J\u0010\u00101\u001a\u00020!2\u0006\u0010-\u001a\u00020\fH\u0002J\u0016\u00102\u001a\u00020!2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\f04H\u0002J\u000e\u00105\u001a\u00020!2\u0006\u00106\u001a\u00020\u0006J\u0012\u00105\u001a\u00020!2\n\u0010)\u001a\u00060\u0013j\u0002`\u0017J\u0014\u00107\u001a\u0004\u0018\u00010\u00062\n\u0010)\u001a\u00060\u0013j\u0002`\u0017J\u0010\u00108\u001a\u00020!2\u0006\u00109\u001a\u00020:H\u0002J\u001b\u0010;\u001a\u00020!2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020:0=H\u0000¢\u0006\u0002\b>J\u0010\u0010?\u001a\u00020!2\u0006\u0010/\u001a\u00020\fH\u0002J\u0006\u0010@\u001a\u00020AJ\u0010\u0010B\u001a\u00020!2\u0006\u0010-\u001a\u00020\fH\u0002J\u0010\u0010C\u001a\u00020!2\u0006\u0010-\u001a\u00020\fH\u0002J\u0014\u0010D\u001a\u00020!2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020:0=J\u000e\u0010D\u001a\u00020!2\u0006\u00109\u001a\u00020:R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R2\u0010\u0011\u001a&\u0012\b\u0012\u00060\u0013j\u0002`\u0014\u0012\u0004\u0012\u00020\f0\u0012j\u0012\u0012\b\u0012\u00060\u0013j\u0002`\u0014\u0012\u0004\u0012\u00020\f`\u0015X\u0004¢\u0006\u0002\n\u0000R2\u0010\u0016\u001a&\u0012\b\u0012\u00060\u0013j\u0002`\u0017\u0012\u0004\u0012\u00020\u00060\u0012j\u0012\u0012\b\u0012\u00060\u0013j\u0002`\u0017\u0012\u0004\u0012\u00020\u0006`\u0015X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0018\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\bR!\u0010\u001a\u001a\u0012\u0012\b\u0012\u00060\u0013j\u0002`\u0014\u0012\u0004\u0012\u00020\f0\u001b8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR!\u0010\u001e\u001a\u0012\u0012\b\u0012\u00060\u0013j\u0002`\u0017\u0012\u0004\u0012\u00020\u00060\u001b8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001d¨\u0006E"}, d2 = {"Lorg/koin/core/registry/ScopeRegistry;", "", "_koin", "Lorg/koin/core/Koin;", "(Lorg/koin/core/Koin;)V", "_rootScope", "Lorg/koin/core/scope/Scope;", "get_rootScope", "()Lorg/koin/core/scope/Scope;", "set_rootScope", "(Lorg/koin/core/scope/Scope;)V", "_rootScopeDefinition", "Lorg/koin/core/scope/ScopeDefinition;", "get_rootScopeDefinition", "()Lorg/koin/core/scope/ScopeDefinition;", "set_rootScopeDefinition", "(Lorg/koin/core/scope/ScopeDefinition;)V", "_scopeDefinitions", "Ljava/util/HashMap;", "", "Lorg/koin/core/qualifier/QualifierValue;", "Lkotlin/collections/HashMap;", "_scopes", "Lorg/koin/core/scope/ScopeID;", "rootScope", "getRootScope", "scopeDefinitions", "", "getScopeDefinitions", "()Ljava/util/Map;", "scopes", "getScopes", "clearScopes", "", "close", "close$koin_core", "createRootScope", "createRootScope$koin_core", "createRootScopeDefinition", "createRootScopeDefinition$koin_core", "createScope", "scopeId", "qualifier", "Lorg/koin/core/qualifier/Qualifier;", FirebaseAnalytics.Param.SOURCE, "scopeDefinition", "declareDefinitions", "definition", "declareInstances", "declareScope", "declareScopes", "list", "", "deleteScope", "scope", "getScopeOrNull", "loadModule", "module", "Lorg/koin/core/module/Module;", "loadModules", "modules", "", "loadModules$koin_core", "mergeDefinitions", "size", "", "unloadDefinitions", "unloadInstances", "unloadModules", "koin-core"}, k = 1, mv = {1, 1, 16})
/* compiled from: ScopeRegistry.kt */
public final class ScopeRegistry {
    private final Koin _koin;
    private Scope _rootScope;
    private ScopeDefinition _rootScopeDefinition;
    private final HashMap<String, ScopeDefinition> _scopeDefinitions = new HashMap<>();
    private final HashMap<String, Scope> _scopes = new HashMap<>();

    public ScopeRegistry(Koin koin) {
        Intrinsics.checkParameterIsNotNull(koin, "_koin");
        this._koin = koin;
    }

    public final Map<String, ScopeDefinition> getScopeDefinitions() {
        return this._scopeDefinitions;
    }

    public final Map<String, Scope> getScopes() {
        return this._scopes;
    }

    public final ScopeDefinition get_rootScopeDefinition() {
        return this._rootScopeDefinition;
    }

    public final void set_rootScopeDefinition(ScopeDefinition scopeDefinition) {
        this._rootScopeDefinition = scopeDefinition;
    }

    public final Scope get_rootScope() {
        return this._rootScope;
    }

    public final void set_rootScope(Scope scope) {
        this._rootScope = scope;
    }

    public final Scope getRootScope() {
        Scope scope = this._rootScope;
        if (scope != null) {
            return scope;
        }
        throw new IllegalStateException("No root scoped initialized".toString());
    }

    public final int size() {
        Iterable<ScopeDefinition> values = getScopeDefinitions().values();
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(values, 10));
        for (ScopeDefinition size$koin_core : values) {
            arrayList.add(Integer.valueOf(size$koin_core.size$koin_core()));
        }
        return CollectionsKt.sumOfInt((List) arrayList);
    }

    private final void loadModule(Module module) {
        declareScope(module.getRootScope());
        declareScopes(module.getOtherScopes());
    }

    private final void declareScopes(List<ScopeDefinition> list) {
        for (ScopeDefinition declareScope : list) {
            declareScope(declareScope);
        }
    }

    private final void declareScope(ScopeDefinition scopeDefinition) {
        declareDefinitions(scopeDefinition);
        declareInstances(scopeDefinition);
    }

    private final void declareInstances(ScopeDefinition scopeDefinition) {
        Collection<Scope> values = this._scopes.values();
        Intrinsics.checkExpressionValueIsNotNull(values, "_scopes.values");
        Collection arrayList = new ArrayList();
        for (Object next : values) {
            if (Intrinsics.areEqual(((Scope) next).get_scopeDefinition(), scopeDefinition)) {
                arrayList.add(next);
            }
        }
        for (Scope loadDefinitions : (List) arrayList) {
            loadDefinitions.loadDefinitions(scopeDefinition);
        }
    }

    private final void declareDefinitions(ScopeDefinition scopeDefinition) {
        if (getScopeDefinitions().containsKey(scopeDefinition.getQualifier().getValue())) {
            mergeDefinitions(scopeDefinition);
        } else {
            this._scopeDefinitions.put(scopeDefinition.getQualifier().getValue(), scopeDefinition.copy());
        }
    }

    private final void mergeDefinitions(ScopeDefinition scopeDefinition) {
        ScopeDefinition scopeDefinition2 = getScopeDefinitions().get(scopeDefinition.getQualifier().getValue());
        if (scopeDefinition2 != null) {
            for (BeanDefinition save$default : scopeDefinition.getDefinitions()) {
                ScopeDefinition.save$default(scopeDefinition2, save$default, false, 2, null);
            }
            return;
        }
        throw new IllegalStateException(("Scope definition '" + scopeDefinition + "' not found in " + this._scopeDefinitions).toString());
    }

    public final void createRootScopeDefinition$koin_core() {
        ScopeDefinition rootDefinition = ScopeDefinition.Companion.rootDefinition();
        this._scopeDefinitions.put(ScopeDefinition.Companion.getROOT_SCOPE_QUALIFIER().getValue(), rootDefinition);
        this._rootScopeDefinition = rootDefinition;
    }

    public final void createRootScope$koin_core() {
        if (this._rootScope == null) {
            this._rootScope = createScope(ScopeDefinition.ROOT_SCOPE_ID, ScopeDefinition.Companion.getROOT_SCOPE_QUALIFIER(), (Object) null);
        }
    }

    public final Scope getScopeOrNull(String str) {
        Intrinsics.checkParameterIsNotNull(str, "scopeId");
        return getScopes().get(str);
    }

    public static /* synthetic */ Scope createScope$default(ScopeRegistry scopeRegistry, String str, Qualifier qualifier, Object obj, int i, Object obj2) {
        if ((i & 4) != 0) {
            obj = null;
        }
        return scopeRegistry.createScope(str, qualifier, obj);
    }

    public final Scope createScope(String str, Qualifier qualifier, Object obj) {
        Intrinsics.checkParameterIsNotNull(str, "scopeId");
        Intrinsics.checkParameterIsNotNull(qualifier, "qualifier");
        if (!getScopes().containsKey(str)) {
            ScopeDefinition scopeDefinition = getScopeDefinitions().get(qualifier.getValue());
            if (scopeDefinition != null) {
                Scope createScope = createScope(str, scopeDefinition, obj);
                this._scopes.put(str, createScope);
                return createScope;
            }
            throw new NoScopeDefFoundException("No Scope Definition found for qualifer '" + qualifier.getValue() + '\'');
        }
        throw new ScopeAlreadyCreatedException("Scope with id '" + str + "' is already created");
    }

    private final Scope createScope(String str, ScopeDefinition scopeDefinition, Object obj) {
        List list;
        Scope scope = new Scope(str, scopeDefinition, this._koin, obj);
        Scope scope2 = this._rootScope;
        if (scope2 == null || (list = CollectionsKt.listOf(scope2)) == null) {
            list = CollectionsKt.emptyList();
        }
        scope.create$koin_core(list);
        return scope;
    }

    public final void deleteScope(String str) {
        Intrinsics.checkParameterIsNotNull(str, "scopeId");
        this._scopes.remove(str);
    }

    public final void deleteScope(Scope scope) {
        Intrinsics.checkParameterIsNotNull(scope, "scope");
        this._scopes.remove(scope.getId());
    }

    public final void close$koin_core() {
        clearScopes();
        this._scopes.clear();
        this._scopeDefinitions.clear();
        this._rootScopeDefinition = null;
        this._rootScope = null;
    }

    private final void clearScopes() {
        Collection<Scope> values = this._scopes.values();
        Intrinsics.checkExpressionValueIsNotNull(values, "_scopes.values");
        for (Scope clear$koin_core : values) {
            clear$koin_core.clear$koin_core();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: kotlin.collections.CollectionsKt___CollectionsKt.plus(java.util.Collection, java.lang.Object):java.util.List<T>
     arg types: [java.util.ArrayList<org.koin.core.scope.ScopeDefinition>, org.koin.core.scope.ScopeDefinition]
     candidates:
      kotlin.collections.CollectionsKt___CollectionsKt.plus(java.lang.Iterable, java.lang.Iterable):java.util.List<T>
      kotlin.collections.CollectionsKt___CollectionsKt.plus(java.lang.Iterable, java.lang.Object):java.util.List<T>
      kotlin.collections.CollectionsKt___CollectionsKt.plus(java.lang.Iterable, kotlin.sequences.Sequence):java.util.List<T>
      kotlin.collections.CollectionsKt___CollectionsKt.plus(java.lang.Iterable, java.lang.Object[]):java.util.List<T>
      kotlin.collections.CollectionsKt___CollectionsKt.plus(java.util.Collection, java.lang.Iterable):java.util.List<T>
      kotlin.collections.CollectionsKt___CollectionsKt.plus(java.util.Collection, kotlin.sequences.Sequence):java.util.List<T>
      kotlin.collections.CollectionsKt___CollectionsKt.plus(java.util.Collection, java.lang.Object[]):java.util.List<T>
      kotlin.collections.CollectionsKt___CollectionsKt.plus(java.util.Collection, java.lang.Object):java.util.List<T> */
    public final void unloadModules(Module module) {
        Intrinsics.checkParameterIsNotNull(module, "module");
        for (ScopeDefinition unloadDefinitions : CollectionsKt.plus((Collection) module.getOtherScopes(), (Object) module.getRootScope())) {
            unloadDefinitions(unloadDefinitions);
        }
        module.setLoaded$koin_core(false);
    }

    private final void unloadDefinitions(ScopeDefinition scopeDefinition) {
        Object obj;
        unloadInstances(scopeDefinition);
        Collection<ScopeDefinition> values = this._scopeDefinitions.values();
        Intrinsics.checkExpressionValueIsNotNull(values, "_scopeDefinitions.values");
        Iterator it = values.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual((ScopeDefinition) obj, scopeDefinition)) {
                break;
            }
        }
        ScopeDefinition scopeDefinition2 = (ScopeDefinition) obj;
        if (scopeDefinition2 != null) {
            scopeDefinition2.unloadDefinitions(scopeDefinition);
        }
    }

    private final void unloadInstances(ScopeDefinition scopeDefinition) {
        Collection<Scope> values = this._scopes.values();
        Intrinsics.checkExpressionValueIsNotNull(values, "_scopes.values");
        Collection arrayList = new ArrayList();
        for (Object next : values) {
            if (Intrinsics.areEqual(((Scope) next).get_scopeDefinition(), scopeDefinition)) {
                arrayList.add(next);
            }
        }
        for (Scope dropInstances : (List) arrayList) {
            dropInstances.dropInstances(scopeDefinition);
        }
    }

    public final void loadModules$koin_core(Iterable<Module> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "modules");
        for (Module next : iterable) {
            if (!next.isLoaded()) {
                loadModule(next);
                next.setLoaded$koin_core(true);
            } else {
                Logger logger = this._koin.get_logger();
                logger.error("module '" + next + "' already loaded!");
            }
        }
    }

    public final void unloadModules(Iterable<Module> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "modules");
        for (Module unloadModules : iterable) {
            unloadModules(unloadModules);
        }
    }
}
