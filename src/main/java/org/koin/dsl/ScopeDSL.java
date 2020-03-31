package org.koin.dsl;

import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.definition.Definitions;
import org.koin.core.definition.Kind;
import org.koin.core.definition.Options;
import org.koin.core.parameter.DefinitionParameters;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;
import org.koin.core.scope.ScopeDefinition;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JX\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\t0\b\"\u0006\b\u0000\u0010\t\u0018\u00012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2)\b\b\u0010\u000e\u001a#\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u0002H\t0\u000fj\b\u0012\u0004\u0012\u0002H\t`\u0012¢\u0006\u0002\b\u0013H\bJX\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\t0\b\"\u0006\b\u0000\u0010\t\u0018\u00012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2)\b\b\u0010\u000e\u001a#\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u0002H\t0\u000fj\b\u0012\u0004\u0012\u0002H\t`\u0012¢\u0006\u0002\b\u0013H\bJX\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\t0\b\"\u0006\b\u0000\u0010\t\u0018\u00012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2)\b\b\u0010\u000e\u001a#\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u0002H\t0\u000fj\b\u0012\u0004\u0012\u0002H\t`\u0012¢\u0006\u0002\b\u0013H\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, d2 = {"Lorg/koin/dsl/ScopeDSL;", "", "scopeDefinition", "Lorg/koin/core/scope/ScopeDefinition;", "(Lorg/koin/core/scope/ScopeDefinition;)V", "getScopeDefinition", "()Lorg/koin/core/scope/ScopeDefinition;", "factory", "Lorg/koin/core/definition/BeanDefinition;", ExifInterface.GPS_DIRECTION_TRUE, "qualifier", "Lorg/koin/core/qualifier/Qualifier;", "override", "", "definition", "Lkotlin/Function2;", "Lorg/koin/core/scope/Scope;", "Lorg/koin/core/parameter/DefinitionParameters;", "Lorg/koin/core/definition/Definition;", "Lkotlin/ExtensionFunctionType;", "scoped", "single", "koin-core"}, k = 1, mv = {1, 1, 16})
/* compiled from: ScopeDSL.kt */
public final class ScopeDSL {
    private final ScopeDefinition scopeDefinition;

    public ScopeDSL(ScopeDefinition scopeDefinition2) {
        Intrinsics.checkParameterIsNotNull(scopeDefinition2, "scopeDefinition");
        this.scopeDefinition = scopeDefinition2;
    }

    public final ScopeDefinition getScopeDefinition() {
        return this.scopeDefinition;
    }

    public static /* synthetic */ BeanDefinition single$default(ScopeDSL scopeDSL, Qualifier qualifier, boolean z, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
        }
        int i2 = i & 2;
        Intrinsics.checkParameterIsNotNull(function2, "definition");
        throw new IllegalStateException("Scoped definition is deprecated and has been replaced with Single scope definitions".toString());
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Can't use Single in a scope. Use Scoped instead")
    public final /* synthetic */ <T> BeanDefinition<T> single(Qualifier qualifier, boolean z, Function2<? super Scope, ? super DefinitionParameters, ? extends T> function2) {
        Intrinsics.checkParameterIsNotNull(function2, "definition");
        throw new IllegalStateException("Scoped definition is deprecated and has been replaced with Single scope definitions".toString());
    }

    public static /* synthetic */ BeanDefinition scoped$default(ScopeDSL scopeDSL, Qualifier qualifier, boolean z, Function2 function2, int i, Object obj) {
        Qualifier qualifier2 = (i & 1) != 0 ? null : qualifier;
        boolean z2 = (i & 2) != 0 ? false : z;
        Function2 function22 = function2;
        Intrinsics.checkParameterIsNotNull(function22, "definition");
        Definitions definitions = Definitions.INSTANCE;
        ScopeDefinition scopeDefinition2 = scopeDSL.getScopeDefinition();
        Options options = new Options(false, z2);
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        BeanDefinition beanDefinition = r2;
        BeanDefinition beanDefinition2 = new BeanDefinition(scopeDefinition2, Reflection.getOrCreateKotlinClass(Object.class), qualifier2, function22, Kind.Single, emptyList, options, null, null, 384, null);
        ScopeDefinition.save$default(scopeDefinition2, beanDefinition, false, 2, null);
        return beanDefinition;
    }

    public final /* synthetic */ <T> BeanDefinition<T> scoped(Qualifier qualifier, boolean z, Function2<? super Scope, ? super DefinitionParameters, ? extends T> function2) {
        Function2<? super Scope, ? super DefinitionParameters, ? extends T> function22 = function2;
        Intrinsics.checkParameterIsNotNull(function22, "definition");
        Definitions definitions = Definitions.INSTANCE;
        ScopeDefinition scopeDefinition2 = getScopeDefinition();
        Options options = new Options(false, z);
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        BeanDefinition beanDefinition = new BeanDefinition(scopeDefinition2, Reflection.getOrCreateKotlinClass(Object.class), qualifier, function22, Kind.Single, emptyList, options, null, null, 384, null);
        ScopeDefinition.save$default(scopeDefinition2, beanDefinition, false, 2, null);
        return beanDefinition;
    }

    public static /* synthetic */ BeanDefinition factory$default(ScopeDSL scopeDSL, Qualifier qualifier, boolean z, Function2 function2, int i, Object obj) {
        Qualifier qualifier2 = (i & 1) != 0 ? null : qualifier;
        boolean z2 = (i & 2) != 0 ? false : z;
        Function2 function22 = function2;
        Intrinsics.checkParameterIsNotNull(function22, "definition");
        Definitions definitions = Definitions.INSTANCE;
        ScopeDefinition scopeDefinition2 = scopeDSL.getScopeDefinition();
        Options options = new Options(false, z2);
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        BeanDefinition beanDefinition = r2;
        BeanDefinition beanDefinition2 = new BeanDefinition(scopeDefinition2, Reflection.getOrCreateKotlinClass(Object.class), qualifier2, function22, Kind.Factory, emptyList, options, null, null, 384, null);
        ScopeDefinition.save$default(scopeDefinition2, beanDefinition, false, 2, null);
        return beanDefinition;
    }

    public final /* synthetic */ <T> BeanDefinition<T> factory(Qualifier qualifier, boolean z, Function2<? super Scope, ? super DefinitionParameters, ? extends T> function2) {
        Function2<? super Scope, ? super DefinitionParameters, ? extends T> function22 = function2;
        Intrinsics.checkParameterIsNotNull(function22, "definition");
        Definitions definitions = Definitions.INSTANCE;
        ScopeDefinition scopeDefinition2 = getScopeDefinition();
        Options options = new Options(false, z);
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        BeanDefinition beanDefinition = new BeanDefinition(scopeDefinition2, Reflection.getOrCreateKotlinClass(Object.class), qualifier, function22, Kind.Factory, emptyList, options, null, null, 384, null);
        ScopeDefinition.save$default(scopeDefinition2, beanDefinition, false, 2, null);
        return beanDefinition;
    }
}
