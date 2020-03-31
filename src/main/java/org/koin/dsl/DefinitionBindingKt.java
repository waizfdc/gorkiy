package org.koin.dsl;

import androidx.exifinterface.media.ExifInterface;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.definition.Callbacks;
import org.koin.core.scope.ScopeDefinition;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001d\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u0006\u0012\u0002\b\u00030\u0001H\b\u001a+\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0004\u001a,\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0001*\u0006\u0012\u0002\b\u00030\u00012\u0010\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0007H\u0004¢\u0006\u0002\u0010\b\u001a?\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u001e\u0010\t\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u0001H\u0002\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u0002H\u0002`\fH\u0004¨\u0006\r"}, d2 = {"bind", "Lorg/koin/core/definition/BeanDefinition;", ExifInterface.GPS_DIRECTION_TRUE, "clazz", "Lkotlin/reflect/KClass;", "binds", "classes", "", "(Lorg/koin/core/definition/BeanDefinition;[Lkotlin/reflect/KClass;)Lorg/koin/core/definition/BeanDefinition;", "onClose", "Lkotlin/Function1;", "", "Lorg/koin/core/definition/OnCloseCallback;", "koin-core"}, k = 2, mv = {1, 1, 16})
/* compiled from: DefinitionBinding.kt */
public final class DefinitionBindingKt {
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: kotlin.collections.CollectionsKt___CollectionsKt.plus(java.util.Collection, java.lang.Object):java.util.List<T>
     arg types: [java.util.List<kotlin.reflect.KClass<?>>, kotlin.reflect.KClass<?>]
     candidates:
      kotlin.collections.CollectionsKt___CollectionsKt.plus(java.lang.Iterable, java.lang.Iterable):java.util.List<T>
      kotlin.collections.CollectionsKt___CollectionsKt.plus(java.lang.Iterable, java.lang.Object):java.util.List<T>
      kotlin.collections.CollectionsKt___CollectionsKt.plus(java.lang.Iterable, kotlin.sequences.Sequence):java.util.List<T>
      kotlin.collections.CollectionsKt___CollectionsKt.plus(java.lang.Iterable, java.lang.Object[]):java.util.List<T>
      kotlin.collections.CollectionsKt___CollectionsKt.plus(java.util.Collection, java.lang.Iterable):java.util.List<T>
      kotlin.collections.CollectionsKt___CollectionsKt.plus(java.util.Collection, kotlin.sequences.Sequence):java.util.List<T>
      kotlin.collections.CollectionsKt___CollectionsKt.plus(java.util.Collection, java.lang.Object[]):java.util.List<T>
      kotlin.collections.CollectionsKt___CollectionsKt.plus(java.util.Collection, java.lang.Object):java.util.List<T> */
    public static final <T> BeanDefinition<T> bind(BeanDefinition<T> beanDefinition, KClass<?> kClass) {
        Intrinsics.checkParameterIsNotNull(beanDefinition, "$this$bind");
        Intrinsics.checkParameterIsNotNull(kClass, "clazz");
        BeanDefinition<T> copy$default = BeanDefinition.copy$default(beanDefinition, null, null, null, null, null, CollectionsKt.plus((Collection) beanDefinition.getSecondaryTypes(), (Object) kClass), null, null, null, 479, null);
        beanDefinition.getScopeDefinition().remove(beanDefinition);
        ScopeDefinition.save$default(beanDefinition.getScopeDefinition(), copy$default, false, 2, null);
        return copy$default;
    }

    public static final /* synthetic */ <T> BeanDefinition<?> bind(BeanDefinition<?> beanDefinition) {
        Intrinsics.checkParameterIsNotNull(beanDefinition, "$this$bind");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return bind(beanDefinition, Reflection.getOrCreateKotlinClass(Object.class));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: kotlin.collections.CollectionsKt___CollectionsKt.plus(java.util.Collection, java.lang.Object[]):java.util.List<T>
     arg types: [java.util.List<kotlin.reflect.KClass<?>>, kotlin.reflect.KClass<?>[]]
     candidates:
      kotlin.collections.CollectionsKt___CollectionsKt.plus(java.lang.Iterable, java.lang.Iterable):java.util.List<T>
      kotlin.collections.CollectionsKt___CollectionsKt.plus(java.lang.Iterable, java.lang.Object):java.util.List<T>
      kotlin.collections.CollectionsKt___CollectionsKt.plus(java.lang.Iterable, kotlin.sequences.Sequence):java.util.List<T>
      kotlin.collections.CollectionsKt___CollectionsKt.plus(java.lang.Iterable, java.lang.Object[]):java.util.List<T>
      kotlin.collections.CollectionsKt___CollectionsKt.plus(java.util.Collection, java.lang.Iterable):java.util.List<T>
      kotlin.collections.CollectionsKt___CollectionsKt.plus(java.util.Collection, java.lang.Object):java.util.List<T>
      kotlin.collections.CollectionsKt___CollectionsKt.plus(java.util.Collection, kotlin.sequences.Sequence):java.util.List<T>
      kotlin.collections.CollectionsKt___CollectionsKt.plus(java.util.Collection, java.lang.Object[]):java.util.List<T> */
    public static final BeanDefinition<?> binds(BeanDefinition<?> beanDefinition, KClass<?>[] kClassArr) {
        Intrinsics.checkParameterIsNotNull(beanDefinition, "$this$binds");
        Intrinsics.checkParameterIsNotNull(kClassArr, "classes");
        BeanDefinition<?> copy$default = BeanDefinition.copy$default(beanDefinition, null, null, null, null, null, CollectionsKt.plus((Collection) beanDefinition.getSecondaryTypes(), (Object[]) kClassArr), null, null, null, 479, null);
        beanDefinition.getScopeDefinition().remove(beanDefinition);
        ScopeDefinition.save$default(beanDefinition.getScopeDefinition(), copy$default, false, 2, null);
        return copy$default;
    }

    public static final <T> BeanDefinition<T> onClose(BeanDefinition<T> beanDefinition, Function1<? super T, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(beanDefinition, "$this$onClose");
        Intrinsics.checkParameterIsNotNull(function1, "onClose");
        BeanDefinition<T> copy$default = BeanDefinition.copy$default(beanDefinition, null, null, null, null, null, null, null, null, new Callbacks(function1), 255, null);
        beanDefinition.getScopeDefinition().remove(beanDefinition);
        ScopeDefinition.save$default(beanDefinition.getScopeDefinition(), copy$default, false, 2, null);
        return copy$default;
    }
}
