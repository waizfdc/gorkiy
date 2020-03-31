package org.koin.core.scope;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.fitness.FitnessActivities;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.definition.Definitions;
import org.koin.core.definition.Options;
import org.koin.core.error.DefinitionOverrideException;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.qualifier.QualifierKt;
import org.koin.core.qualifier.StringQualifier;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 (2\u00020\u0001:\u0001(B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012 \b\u0002\u0010\u0006\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u0007j\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b`\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u0012\u001a\u00020\u0000J\u0013\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0012\u0010\u0017\u001a\u00020\u00182\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\bJ\u001c\u0010\u001a\u001a\u00020\u00182\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\b2\b\b\u0002\u0010\u001b\u001a\u00020\u0005JS\u0010\u001c\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\b\"\b\b\u0000\u0010\u001d*\u00020\u00012\u0006\u0010\u001e\u001a\u0002H\u001d2\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\u001f\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030!\u0018\u00010 2\b\b\u0002\u0010\"\u001a\u00020\u0005¢\u0006\u0002\u0010#J\r\u0010$\u001a\u00020\u0016H\u0000¢\u0006\u0002\b%J\u000e\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u0000R&\u0010\u0006\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u0007j\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b`\tX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006)"}, d2 = {"Lorg/koin/core/scope/ScopeDefinition;", "", "qualifier", "Lorg/koin/core/qualifier/Qualifier;", "isRoot", "", "_definitions", "Ljava/util/HashSet;", "Lorg/koin/core/definition/BeanDefinition;", "Lkotlin/collections/HashSet;", "(Lorg/koin/core/qualifier/Qualifier;ZLjava/util/HashSet;)V", "definitions", "", "getDefinitions", "()Ljava/util/Set;", "()Z", "getQualifier", "()Lorg/koin/core/qualifier/Qualifier;", "copy", "equals", FitnessActivities.OTHER, "hashCode", "", "remove", "", "beanDefinition", "save", "forceOverride", "saveNewDefinition", ExifInterface.GPS_DIRECTION_TRUE, "instance", "secondaryTypes", "", "Lkotlin/reflect/KClass;", "override", "(Ljava/lang/Object;Lorg/koin/core/qualifier/Qualifier;Ljava/util/List;Z)Lorg/koin/core/definition/BeanDefinition;", "size", "size$koin_core", "unloadDefinitions", "scopeDefinition", "Companion", "koin-core"}, k = 1, mv = {1, 1, 16})
/* compiled from: ScopeDefinition.kt */
public final class ScopeDefinition {
    public static final Companion Companion = new Companion(null);
    public static final String ROOT_SCOPE_ID = "-Root-";
    /* access modifiers changed from: private */
    public static final StringQualifier ROOT_SCOPE_QUALIFIER = QualifierKt._q(ROOT_SCOPE_ID);
    private final HashSet<BeanDefinition<?>> _definitions;
    private final boolean isRoot;
    private final Qualifier qualifier;

    public ScopeDefinition(Qualifier qualifier2, boolean z, HashSet<BeanDefinition<?>> hashSet) {
        Intrinsics.checkParameterIsNotNull(qualifier2, "qualifier");
        Intrinsics.checkParameterIsNotNull(hashSet, "_definitions");
        this.qualifier = qualifier2;
        this.isRoot = z;
        this._definitions = hashSet;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ScopeDefinition(Qualifier qualifier2, boolean z, HashSet hashSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(qualifier2, (i & 2) != 0 ? false : z, (i & 4) != 0 ? new HashSet() : hashSet);
    }

    public final Qualifier getQualifier() {
        return this.qualifier;
    }

    public final boolean isRoot() {
        return this.isRoot;
    }

    public final Set<BeanDefinition<?>> getDefinitions() {
        return this._definitions;
    }

    public static /* synthetic */ void save$default(ScopeDefinition scopeDefinition, BeanDefinition beanDefinition, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        scopeDefinition.save(beanDefinition, z);
    }

    public final void save(BeanDefinition<?> beanDefinition, boolean z) {
        Object obj;
        Intrinsics.checkParameterIsNotNull(beanDefinition, "beanDefinition");
        if (getDefinitions().contains(beanDefinition)) {
            if (beanDefinition.getOptions().getOverride() || z) {
                this._definitions.remove(beanDefinition);
            } else {
                Iterator it = getDefinitions().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (Intrinsics.areEqual((BeanDefinition) obj, beanDefinition)) {
                        break;
                    }
                }
                throw new DefinitionOverrideException("Definition '" + beanDefinition + "' try to override existing definition. Please use override option or check for definition '" + ((BeanDefinition) obj) + '\'');
            }
        }
        this._definitions.add(beanDefinition);
    }

    public final void remove(BeanDefinition<?> beanDefinition) {
        Intrinsics.checkParameterIsNotNull(beanDefinition, "beanDefinition");
        this._definitions.remove(beanDefinition);
    }

    public final int size$koin_core() {
        return getDefinitions().size();
    }

    public static /* synthetic */ BeanDefinition saveNewDefinition$default(ScopeDefinition scopeDefinition, Object obj, Qualifier qualifier2, List list, boolean z, int i, Object obj2) {
        if ((i & 2) != 0) {
            qualifier2 = null;
        }
        if ((i & 4) != 0) {
            list = null;
        }
        if ((i & 8) != 0) {
            z = false;
        }
        return scopeDefinition.saveNewDefinition(obj, qualifier2, list, z);
    }

    public final <T> BeanDefinition<? extends Object> saveNewDefinition(T t, Qualifier qualifier2, List<? extends KClass<?>> list, boolean z) {
        Object obj;
        Intrinsics.checkParameterIsNotNull(t, "instance");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(t.getClass());
        Iterator it = getDefinitions().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((BeanDefinition) obj).is(orCreateKotlinClass, qualifier2, this)) {
                break;
            }
        }
        BeanDefinition beanDefinition = (BeanDefinition) obj;
        if (beanDefinition != null) {
            if (z) {
                remove(beanDefinition);
            } else {
                throw new DefinitionOverrideException("Trying to override existing definition '" + beanDefinition + "' with new definition typed '" + orCreateKotlinClass + '\'');
            }
        }
        Definitions definitions = Definitions.INSTANCE;
        Function2 scopeDefinition$saveNewDefinition$beanDefinition$1 = new ScopeDefinition$saveNewDefinition$beanDefinition$1(t);
        Options options = new Options(false, z);
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        BeanDefinition createSingle$koin_core = definitions.createSingle$koin_core(orCreateKotlinClass, qualifier2, scopeDefinition$saveNewDefinition$beanDefinition$1, this, options, list);
        save(createSingle$koin_core, z);
        return createSingle$koin_core;
    }

    public final void unloadDefinitions(ScopeDefinition scopeDefinition) {
        Intrinsics.checkParameterIsNotNull(scopeDefinition, "scopeDefinition");
        for (BeanDefinition remove : scopeDefinition.getDefinitions()) {
            this._definitions.remove(remove);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), obj != null ? obj.getClass() : null)) {
            return false;
        }
        if (obj != null) {
            ScopeDefinition scopeDefinition = (ScopeDefinition) obj;
            if (!(!Intrinsics.areEqual(this.qualifier, scopeDefinition.qualifier)) && this.isRoot == scopeDefinition.isRoot) {
                return true;
            }
            return false;
        }
        throw new TypeCastException("null cannot be cast to non-null type org.koin.core.scope.ScopeDefinition");
    }

    public int hashCode() {
        return (this.qualifier.hashCode() * 31) + Boolean.valueOf(this.isRoot).hashCode();
    }

    public final ScopeDefinition copy() {
        ScopeDefinition scopeDefinition = new ScopeDefinition(this.qualifier, this.isRoot, new HashSet());
        scopeDefinition._definitions.addAll(getDefinitions());
        return scopeDefinition;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lorg/koin/core/scope/ScopeDefinition$Companion;", "", "()V", "ROOT_SCOPE_ID", "", "ROOT_SCOPE_QUALIFIER", "Lorg/koin/core/qualifier/StringQualifier;", "getROOT_SCOPE_QUALIFIER", "()Lorg/koin/core/qualifier/StringQualifier;", "rootDefinition", "Lorg/koin/core/scope/ScopeDefinition;", "koin-core"}, k = 1, mv = {1, 1, 16})
    /* compiled from: ScopeDefinition.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final StringQualifier getROOT_SCOPE_QUALIFIER() {
            return ScopeDefinition.ROOT_SCOPE_QUALIFIER;
        }

        public final ScopeDefinition rootDefinition() {
            return new ScopeDefinition(getROOT_SCOPE_QUALIFIER(), true, null, 4, null);
        }
    }
}
