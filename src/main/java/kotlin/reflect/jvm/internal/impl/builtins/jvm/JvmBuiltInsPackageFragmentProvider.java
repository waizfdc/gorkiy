package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.io.InputStream;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AbstractDeserializedPackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragment;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInsPackageFragmentImpl;

/* compiled from: JvmBuiltInsPackageFragmentProvider.kt */
public final class JvmBuiltInsPackageFragmentProvider extends AbstractDeserializedPackageFragmentProvider {
    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public JvmBuiltInsPackageFragmentProvider(kotlin.reflect.jvm.internal.impl.storage.StorageManager r27, kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder r28, kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor r29, kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses r30, kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider r31, kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter r32, kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration r33, kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker r34) {
        /*
            r26 = this;
            r0 = r26
            r2 = r27
            r1 = r28
            r3 = r29
            r4 = r30
            r8 = r27
            r9 = r29
            r19 = r30
            r21 = r31
            r22 = r32
            r10 = r33
            r24 = r34
            java.lang.String r5 = "storageManager"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r2, r5)
            java.lang.String r5 = "finder"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r1, r5)
            java.lang.String r5 = "moduleDescriptor"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r5)
            java.lang.String r5 = "notFoundClasses"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r4, r5)
            java.lang.String r5 = "additionalClassPartsProvider"
            r6 = r31
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r6, r5)
            java.lang.String r5 = "platformDependentDeclarationFilter"
            r6 = r32
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r6, r5)
            java.lang.String r5 = "deserializationConfiguration"
            r6 = r33
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r6, r5)
            java.lang.String r5 = "kotlinTypeChecker"
            r6 = r34
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r6, r5)
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.KotlinMetadataFinder r1 = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.KotlinMetadataFinder) r1
            r0.<init>(r2, r1, r3)
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents r6 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents
            r7 = r6
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedClassDataFinder r1 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedClassDataFinder
            r5 = r0
            kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider r5 = (kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider) r5
            r13 = r5
            r1.<init>(r5)
            r11 = r1
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder r11 = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder) r11
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoaderImpl r1 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoaderImpl
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInSerializerProtocol r5 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInSerializerProtocol.INSTANCE
            kotlin.reflect.jvm.internal.impl.serialization.SerializerExtensionProtocol r5 = (kotlin.reflect.jvm.internal.impl.serialization.SerializerExtensionProtocol) r5
            r1.<init>(r3, r4, r5)
            r12 = r1
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader r12 = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader) r12
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.LocalClassifierTypeSettings$Default r1 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.LocalClassifierTypeSettings.Default.INSTANCE
            r14 = r1
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.LocalClassifierTypeSettings r14 = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.LocalClassifierTypeSettings) r14
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter r1 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter.DO_NOTHING
            r15 = r1
            java.lang.String r4 = "ErrorReporter.DO_NOTHING"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r4)
            kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker$DO_NOTHING r1 = kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker.DO_NOTHING.INSTANCE
            r16 = r1
            kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker r16 = (kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker) r16
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.FlexibleTypeDeserializer$ThrowException r1 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.FlexibleTypeDeserializer.ThrowException.INSTANCE
            r17 = r1
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.FlexibleTypeDeserializer r17 = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.FlexibleTypeDeserializer) r17
            r1 = 2
            kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory[] r5 = new kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory[r1]
            kotlin.reflect.jvm.internal.impl.builtins.functions.BuiltInFictitiousFunctionClassFactory r1 = new kotlin.reflect.jvm.internal.impl.builtins.functions.BuiltInFictitiousFunctionClassFactory
            r1.<init>(r2, r3)
            kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory r1 = (kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory) r1
            r4 = 0
            r5[r4] = r1
            kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInClassDescriptorFactory r18 = new kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInClassDescriptorFactory
            r4 = 0
            r20 = 4
            r23 = 0
            r1 = r18
            r25 = r5
            r5 = r20
            r0 = r6
            r6 = r23
            r1.<init>(r2, r3, r4, r5, r6)
            kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory r18 = (kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory) r18
            r1 = 1
            r25[r1] = r18
            java.util.List r1 = kotlin.collections.CollectionsKt.listOf(r25)
            r18 = r1
            java.lang.Iterable r18 = (java.lang.Iterable) r18
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.ContractDeserializer$Companion r1 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.ContractDeserializer.Companion
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.ContractDeserializer r20 = r1.getDEFAULT()
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInSerializerProtocol r1 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInSerializerProtocol.INSTANCE
            kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r23 = r1.getExtensionRegistry()
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            r1 = r0
            r0 = r26
            r0.setComponents(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsPackageFragmentProvider.<init>(kotlin.reflect.jvm.internal.impl.storage.StorageManager, kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder, kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses, kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider, kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter, kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration, kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker):void");
    }

    /* access modifiers changed from: protected */
    public DeserializedPackageFragment findPackage(FqName fqName) {
        BuiltInsPackageFragmentImpl builtInsPackageFragmentImpl;
        Intrinsics.checkParameterIsNotNull(fqName, "fqName");
        InputStream findBuiltInsData = getFinder().findBuiltInsData(fqName);
        if (findBuiltInsData != null) {
            builtInsPackageFragmentImpl = BuiltInsPackageFragmentImpl.Companion.create(fqName, getStorageManager(), getModuleDescriptor(), findBuiltInsData, false);
        } else {
            builtInsPackageFragmentImpl = null;
        }
        return builtInsPackageFragmentImpl;
    }
}
