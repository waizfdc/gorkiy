package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassesTracker;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaPropertyInitializerEvaluator;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.components.SamConversionResolver;
import kotlin.reflect.jvm.internal.impl.load.java.components.SignaturePropagator;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaPackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ModuleClassResolver;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElementFactory;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.BinaryClassAnnotationAndConstantLoaderImpl;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializationComponentsForJava;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JavaClassDataFinder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.PackagePartProvider;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ContractDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.utils.Jsr305State;

/* compiled from: RuntimeModuleData.kt */
public final class RuntimeModuleDataKt {
    public static /* synthetic */ LazyJavaPackageFragmentProvider makeLazyJavaPackageFragmentFromClassLoaderProvider$default(ClassLoader classLoader, ModuleDescriptor moduleDescriptor, StorageManager storageManager, NotFoundClasses notFoundClasses, KotlinClassFinder kotlinClassFinder, DeserializedDescriptorResolver deserializedDescriptorResolver, ModuleClassResolver moduleClassResolver, PackagePartProvider packagePartProvider, int i, Object obj) {
        return makeLazyJavaPackageFragmentFromClassLoaderProvider(classLoader, moduleDescriptor, storageManager, notFoundClasses, kotlinClassFinder, deserializedDescriptorResolver, moduleClassResolver, (i & 128) != 0 ? PackagePartProvider.Empty.INSTANCE : packagePartProvider);
    }

    public static final LazyJavaPackageFragmentProvider makeLazyJavaPackageFragmentFromClassLoaderProvider(ClassLoader classLoader, ModuleDescriptor moduleDescriptor, StorageManager storageManager, NotFoundClasses notFoundClasses, KotlinClassFinder kotlinClassFinder, DeserializedDescriptorResolver deserializedDescriptorResolver, ModuleClassResolver moduleClassResolver, PackagePartProvider packagePartProvider) {
        ClassLoader classLoader2 = classLoader;
        ModuleDescriptor moduleDescriptor2 = moduleDescriptor;
        StorageManager storageManager2 = storageManager;
        NotFoundClasses notFoundClasses2 = notFoundClasses;
        Intrinsics.checkParameterIsNotNull(classLoader2, "classLoader");
        Intrinsics.checkParameterIsNotNull(moduleDescriptor2, "module");
        Intrinsics.checkParameterIsNotNull(storageManager2, "storageManager");
        Intrinsics.checkParameterIsNotNull(notFoundClasses2, "notFoundClasses");
        Intrinsics.checkParameterIsNotNull(kotlinClassFinder, "reflectKotlinClassFinder");
        Intrinsics.checkParameterIsNotNull(deserializedDescriptorResolver, "deserializedDescriptorResolver");
        Intrinsics.checkParameterIsNotNull(moduleClassResolver, "singleModuleClassResolver");
        Intrinsics.checkParameterIsNotNull(packagePartProvider, "packagePartProvider");
        AnnotationTypeQualifierResolver annotationTypeQualifierResolver = r11;
        AnnotationTypeQualifierResolver annotationTypeQualifierResolver2 = new AnnotationTypeQualifierResolver(storageManager2, Jsr305State.DISABLED);
        SignaturePropagator signaturePropagator = SignaturePropagator.DO_NOTHING;
        SignaturePropagator signaturePropagator2 = signaturePropagator;
        Intrinsics.checkExpressionValueIsNotNull(signaturePropagator, "SignaturePropagator.DO_NOTHING");
        ErrorReporter errorReporter = RuntimeErrorReporter.INSTANCE;
        JavaResolverCache javaResolverCache = JavaResolverCache.EMPTY;
        JavaResolverCache javaResolverCache2 = javaResolverCache;
        Intrinsics.checkExpressionValueIsNotNull(javaResolverCache, "JavaResolverCache.EMPTY");
        JavaPropertyInitializerEvaluator javaPropertyInitializerEvaluator = JavaPropertyInitializerEvaluator.DoNothing.INSTANCE;
        JavaResolverComponents javaResolverComponents = r1;
        SamConversionResolver samConversionResolver = SamConversionResolver.Empty.INSTANCE;
        AnnotationTypeQualifierResolver annotationTypeQualifierResolver3 = annotationTypeQualifierResolver2;
        JavaSourceElementFactory javaSourceElementFactory = RuntimeSourceElementFactory.INSTANCE;
        NotFoundClasses notFoundClasses3 = notFoundClasses2;
        SupertypeLoopChecker supertypeLoopChecker = SupertypeLoopChecker.EMPTY.INSTANCE;
        JavaClassFinder reflectJavaClassFinder = new ReflectJavaClassFinder(classLoader2);
        ModuleDescriptor moduleDescriptor3 = moduleDescriptor2;
        LookupTracker lookupTracker = LookupTracker.DO_NOTHING.INSTANCE;
        ReflectionTypes reflectionTypes = r0;
        ReflectionTypes reflectionTypes2 = new ReflectionTypes(moduleDescriptor3, notFoundClasses3);
        SignatureEnhancement signatureEnhancement = r0;
        SignatureEnhancement signatureEnhancement2 = new SignatureEnhancement(annotationTypeQualifierResolver3, Jsr305State.DISABLED);
        JavaClassFinder javaClassFinder = reflectJavaClassFinder;
        StorageManager storageManager3 = storageManager;
        JavaResolverComponents javaResolverComponents2 = new JavaResolverComponents(storageManager3, javaClassFinder, kotlinClassFinder, deserializedDescriptorResolver, signaturePropagator2, errorReporter, javaResolverCache2, javaPropertyInitializerEvaluator, samConversionResolver, javaSourceElementFactory, moduleClassResolver, packagePartProvider, supertypeLoopChecker, lookupTracker, moduleDescriptor, reflectionTypes, annotationTypeQualifierResolver, signatureEnhancement, JavaClassesTracker.Default.INSTANCE, JavaResolverSettings.Default.INSTANCE, NewKotlinTypeChecker.Companion.getDefault());
        return new LazyJavaPackageFragmentProvider(javaResolverComponents);
    }

    public static final DeserializationComponentsForJava makeDeserializationComponentsForJava(ModuleDescriptor moduleDescriptor, StorageManager storageManager, NotFoundClasses notFoundClasses, LazyJavaPackageFragmentProvider lazyJavaPackageFragmentProvider, KotlinClassFinder kotlinClassFinder, DeserializedDescriptorResolver deserializedDescriptorResolver) {
        StorageManager storageManager2 = storageManager;
        KotlinClassFinder kotlinClassFinder2 = kotlinClassFinder;
        DeserializedDescriptorResolver deserializedDescriptorResolver2 = deserializedDescriptorResolver;
        Intrinsics.checkParameterIsNotNull(moduleDescriptor, "module");
        Intrinsics.checkParameterIsNotNull(storageManager, "storageManager");
        Intrinsics.checkParameterIsNotNull(notFoundClasses, "notFoundClasses");
        LazyJavaPackageFragmentProvider lazyJavaPackageFragmentProvider2 = lazyJavaPackageFragmentProvider;
        Intrinsics.checkParameterIsNotNull(lazyJavaPackageFragmentProvider2, "lazyJavaPackageFragmentProvider");
        Intrinsics.checkParameterIsNotNull(kotlinClassFinder2, "reflectKotlinClassFinder");
        Intrinsics.checkParameterIsNotNull(deserializedDescriptorResolver2, "deserializedDescriptorResolver");
        JavaClassDataFinder javaClassDataFinder = new JavaClassDataFinder(kotlinClassFinder2, deserializedDescriptorResolver2);
        BinaryClassAnnotationAndConstantLoaderImpl binaryClassAnnotationAndConstantLoaderImpl = new BinaryClassAnnotationAndConstantLoaderImpl(moduleDescriptor, notFoundClasses, storageManager, kotlinClassFinder2);
        return new DeserializationComponentsForJava(storageManager2, moduleDescriptor, DeserializationConfiguration.Default.INSTANCE, javaClassDataFinder, binaryClassAnnotationAndConstantLoaderImpl, lazyJavaPackageFragmentProvider2, notFoundClasses, RuntimeErrorReporter.INSTANCE, LookupTracker.DO_NOTHING.INSTANCE, ContractDeserializer.Companion.getDEFAULT(), NewKotlinTypeChecker.Companion.getDefault());
    }
}
