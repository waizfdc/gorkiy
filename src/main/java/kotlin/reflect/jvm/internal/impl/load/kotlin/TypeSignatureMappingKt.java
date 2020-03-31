package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementKt;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.utils.FunctionsKt;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* compiled from: typeSignatureMapping.kt */
public final class TypeSignatureMappingKt {
    private static final <T> T boxTypeIfNeeded(JvmTypeFactory<T> jvmTypeFactory, T t, boolean z) {
        return z ? jvmTypeFactory.boxType(t) : t;
    }

    public static /* synthetic */ Object mapType$default(KotlinType kotlinType, JvmTypeFactory jvmTypeFactory, TypeMappingMode typeMappingMode, TypeMappingConfiguration typeMappingConfiguration, JvmDescriptorTypeWriter jvmDescriptorTypeWriter, Function3 function3, int i, Object obj) {
        if ((i & 32) != 0) {
            function3 = FunctionsKt.getDO_NOTHING_3();
        }
        return mapType(kotlinType, jvmTypeFactory, typeMappingMode, typeMappingConfiguration, jvmDescriptorTypeWriter, function3);
    }

    /* JADX WARN: Type inference failed for: r13v0, types: [kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration<? extends T>, java.lang.Object, kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> T mapType(kotlin.reflect.jvm.internal.impl.types.KotlinType r10, kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory<T> r11, kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingMode r12, kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration<? extends T> r13, kotlin.reflect.jvm.internal.impl.load.kotlin.JvmDescriptorTypeWriter<T> r14, kotlin.jvm.functions.Function3<? super kotlin.reflect.jvm.internal.impl.types.KotlinType, ? super T, ? super kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingMode, kotlin.Unit> r15) {
        /*
            java.lang.String r0 = "kotlinType"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r10, r0)
            java.lang.String r0 = "factory"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r11, r0)
            java.lang.String r0 = "mode"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r12, r0)
            java.lang.String r0 = "typeMappingConfiguration"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r13, r0)
            java.lang.String r0 = "writeGenericType"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r15, r0)
            kotlin.reflect.jvm.internal.impl.types.KotlinType r1 = r13.preprocessType(r10)
            if (r1 == 0) goto L_0x0029
            r2 = r11
            r3 = r12
            r4 = r13
            r5 = r14
            r6 = r15
            java.lang.Object r10 = mapType(r1, r2, r3, r4, r5, r6)
            return r10
        L_0x0029:
            boolean r0 = kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt.isSuspendFunctionType(r10)
            if (r0 == 0) goto L_0x0044
            boolean r0 = r13.releaseCoroutines()
            kotlin.reflect.jvm.internal.impl.types.SimpleType r10 = kotlin.reflect.jvm.internal.impl.builtins.SuspendFunctionTypesKt.transformSuspendFunctionToRuntimeFunctionType(r10, r0)
            r0 = r10
            kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r0
            r1 = r11
            r2 = r12
            r3 = r13
            r4 = r14
            r5 = r15
            java.lang.Object r10 = mapType(r0, r1, r2, r3, r4, r5)
            return r10
        L_0x0044:
            kotlin.reflect.jvm.internal.impl.types.checker.SimpleClassicTypeSystemContext r0 = kotlin.reflect.jvm.internal.impl.types.checker.SimpleClassicTypeSystemContext.INSTANCE
            kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext r0 = (kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext) r0
            r1 = r10
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r1 = (kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) r1
            java.lang.Object r0 = mapBuiltInType(r0, r1, r11, r12)
            if (r0 == 0) goto L_0x005d
            boolean r13 = r12.getNeedPrimitiveBoxing()
            java.lang.Object r11 = boxTypeIfNeeded(r11, r0, r13)
            r15.invoke(r10, r11, r12)
            return r11
        L_0x005d:
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r0 = r10.getConstructor()
            boolean r2 = r0 instanceof kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor
            if (r2 == 0) goto L_0x007d
            kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor r0 = (kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor) r0
            java.util.Collection r10 = r0.getSupertypes()
            kotlin.reflect.jvm.internal.impl.types.KotlinType r10 = r13.commonSupertype(r10)
            kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.replaceArgumentsWithStarProjections(r10)
            r1 = r11
            r2 = r12
            r3 = r13
            r4 = r14
            r5 = r15
            java.lang.Object r10 = mapType(r0, r1, r2, r3, r4, r5)
            return r10
        L_0x007d:
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r0 = r0.getDeclarationDescriptor()
            if (r0 == 0) goto L_0x01ea
            java.lang.String r2 = "constructor.declarationD…structor of $kotlinType\")"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)
            r2 = r0
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r2 = (kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor) r2
            boolean r2 = kotlin.reflect.jvm.internal.impl.types.ErrorUtils.isError(r2)
            java.lang.String r3 = "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor"
            if (r2 == 0) goto L_0x00ac
            java.lang.String r12 = "error/NonExistentClass"
            java.lang.Object r11 = r11.createObjectType(r12)
            if (r0 == 0) goto L_0x00a6
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r0
            r13.processErrorType(r10, r0)
            if (r14 == 0) goto L_0x00a5
            r14.writeClass(r11)
        L_0x00a5:
            return r11
        L_0x00a6:
            kotlin.TypeCastException r10 = new kotlin.TypeCastException
            r10.<init>(r3)
            throw r10
        L_0x00ac:
            boolean r2 = r0 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
            if (r2 == 0) goto L_0x0132
            boolean r4 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isArray(r10)
            if (r4 == 0) goto L_0x0132
            java.util.List r0 = r10.getArguments()
            int r0 = r0.size()
            r1 = 1
            if (r0 != r1) goto L_0x0128
            java.util.List r10 = r10.getArguments()
            r0 = 0
            java.lang.Object r10 = r10.get(r0)
            kotlin.reflect.jvm.internal.impl.types.TypeProjection r10 = (kotlin.reflect.jvm.internal.impl.types.TypeProjection) r10
            kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = r10.getType()
            java.lang.String r1 = "memberProjection.type"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            kotlin.reflect.jvm.internal.impl.types.Variance r1 = r10.getProjectionKind()
            kotlin.reflect.jvm.internal.impl.types.Variance r2 = kotlin.reflect.jvm.internal.impl.types.Variance.IN_VARIANCE
            if (r1 != r2) goto L_0x00ef
            java.lang.String r10 = "java/lang/Object"
            java.lang.Object r10 = r11.createObjectType(r10)
            if (r14 == 0) goto L_0x010e
            r14.writeArrayType()
            r14.writeClass(r10)
            r14.writeArrayEnd()
            goto L_0x010e
        L_0x00ef:
            if (r14 == 0) goto L_0x00f4
            r14.writeArrayType()
        L_0x00f4:
            kotlin.reflect.jvm.internal.impl.types.Variance r10 = r10.getProjectionKind()
            java.lang.String r1 = "memberProjection.projectionKind"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r10, r1)
            kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingMode r2 = r12.toGenericArgumentMode(r10)
            r1 = r11
            r3 = r13
            r4 = r14
            r5 = r15
            java.lang.Object r10 = mapType(r0, r1, r2, r3, r4, r5)
            if (r14 == 0) goto L_0x010e
            r14.writeArrayEnd()
        L_0x010e:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "["
            r12.append(r13)
            java.lang.String r10 = r11.toString(r10)
            r12.append(r10)
            java.lang.String r10 = r12.toString()
            java.lang.Object r10 = r11.createFromString(r10)
            return r10
        L_0x0128:
            java.lang.UnsupportedOperationException r10 = new java.lang.UnsupportedOperationException
            java.lang.String r11 = "arrays must have one type argument"
            r10.<init>(r11)
            java.lang.Throwable r10 = (java.lang.Throwable) r10
            throw r10
        L_0x0132:
            if (r2 == 0) goto L_0x01ab
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r0
            boolean r2 = r0.isInline()
            if (r2 == 0) goto L_0x015c
            boolean r2 = r12.getNeedInlineClassWrapping()
            if (r2 != 0) goto L_0x015c
            kotlin.reflect.jvm.internal.impl.types.checker.SimpleClassicTypeSystemContext r2 = kotlin.reflect.jvm.internal.impl.types.checker.SimpleClassicTypeSystemContext.INSTANCE
            kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext r2 = (kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext) r2
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r1 = kotlin.reflect.jvm.internal.impl.load.kotlin.InlineClassMappingKt.computeExpandedTypeForInlineClass(r2, r1)
            r4 = r1
            kotlin.reflect.jvm.internal.impl.types.KotlinType r4 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r4
            if (r4 == 0) goto L_0x015c
            kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingMode r6 = r12.wrapInlineClassesMode()
            r5 = r11
            r7 = r13
            r8 = r14
            r9 = r15
            java.lang.Object r10 = mapType(r4, r5, r6, r7, r8, r9)
            return r10
        L_0x015c:
            boolean r14 = r12.isForAnnotationParameter()
            if (r14 == 0) goto L_0x016d
            boolean r14 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isKClass(r0)
            if (r14 == 0) goto L_0x016d
            java.lang.Object r11 = r11.getJavaLangClassType()
            goto L_0x01a7
        L_0x016d:
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r14 = r0.getOriginal()
            java.lang.String r1 = "descriptor.original"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r14, r1)
            java.lang.Object r14 = r13.getPredefinedTypeForClass(r14)
            if (r14 == 0) goto L_0x017e
            r11 = r14
            goto L_0x01a7
        L_0x017e:
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r14 = r0.getKind()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r1 = kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.ENUM_ENTRY
            if (r14 != r1) goto L_0x0196
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r14 = r0.getContainingDeclaration()
            if (r14 == 0) goto L_0x0190
            r0 = r14
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r0
            goto L_0x0196
        L_0x0190:
            kotlin.TypeCastException r10 = new kotlin.TypeCastException
            r10.<init>(r3)
            throw r10
        L_0x0196:
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r14 = r0.getOriginal()
            java.lang.String r0 = "enumClassIfEnumEntry.original"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r14, r0)
            java.lang.String r13 = computeInternalName(r14, r13)
            java.lang.Object r11 = r11.createObjectType(r13)
        L_0x01a7:
            r15.invoke(r10, r11, r12)
            return r11
        L_0x01ab:
            boolean r15 = r0 instanceof kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor
            if (r15 == 0) goto L_0x01d1
            r10 = r0
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r10 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r10
            kotlin.reflect.jvm.internal.impl.types.KotlinType r1 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.getRepresentativeUpperBound(r10)
            kotlin.jvm.functions.Function3 r6 = kotlin.reflect.jvm.internal.impl.utils.FunctionsKt.getDO_NOTHING_3()
            r5 = 0
            r2 = r11
            r3 = r12
            r4 = r13
            java.lang.Object r10 = mapType(r1, r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0203 }
            if (r14 == 0) goto L_0x01d0
            kotlin.reflect.jvm.internal.impl.name.Name r11 = r0.getName()
            java.lang.String r12 = "descriptor.getName()"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r11, r12)
            r14.writeTypeVariable(r11, r10)
        L_0x01d0:
            return r10
        L_0x01d1:
            java.lang.UnsupportedOperationException r11 = new java.lang.UnsupportedOperationException
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "Unknown type "
            r12.append(r13)
            r12.append(r10)
            java.lang.String r10 = r12.toString()
            r11.<init>(r10)
            java.lang.Throwable r11 = (java.lang.Throwable) r11
            throw r11
        L_0x01ea:
            java.lang.UnsupportedOperationException r11 = new java.lang.UnsupportedOperationException
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "no descriptor for type constructor of "
            r12.append(r13)
            r12.append(r10)
            java.lang.String r10 = r12.toString()
            r11.<init>(r10)
            java.lang.Throwable r11 = (java.lang.Throwable) r11
            throw r11
        L_0x0203:
            r10 = move-exception
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.kotlin.TypeSignatureMappingKt.mapType(kotlin.reflect.jvm.internal.impl.types.KotlinType, kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory, kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingMode, kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration, kotlin.reflect.jvm.internal.impl.load.kotlin.JvmDescriptorTypeWriter, kotlin.jvm.functions.Function3):java.lang.Object");
    }

    public static final boolean hasVoidReturnType(CallableDescriptor callableDescriptor) {
        Intrinsics.checkParameterIsNotNull(callableDescriptor, "descriptor");
        if (callableDescriptor instanceof ConstructorDescriptor) {
            return true;
        }
        KotlinType returnType = callableDescriptor.getReturnType();
        if (returnType == null) {
            Intrinsics.throwNpe();
        }
        if (KotlinBuiltIns.isUnit(returnType)) {
            KotlinType returnType2 = callableDescriptor.getReturnType();
            if (returnType2 == null) {
                Intrinsics.throwNpe();
            }
            if (TypeUtils.isNullableType(returnType2) || (callableDescriptor instanceof PropertyGetterDescriptor)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public static final <T> T mapBuiltInType(TypeSystemCommonBackendContext typeSystemCommonBackendContext, KotlinTypeMarker kotlinTypeMarker, JvmTypeFactory<T> jvmTypeFactory, TypeMappingMode typeMappingMode) {
        Intrinsics.checkParameterIsNotNull(typeSystemCommonBackendContext, "$this$mapBuiltInType");
        Intrinsics.checkParameterIsNotNull(kotlinTypeMarker, "type");
        Intrinsics.checkParameterIsNotNull(jvmTypeFactory, "typeFactory");
        Intrinsics.checkParameterIsNotNull(typeMappingMode, "mode");
        TypeConstructorMarker typeConstructor = typeSystemCommonBackendContext.typeConstructor(kotlinTypeMarker);
        if (!typeSystemCommonBackendContext.isClassTypeConstructor(typeConstructor)) {
            return null;
        }
        PrimitiveType primitiveType = typeSystemCommonBackendContext.getPrimitiveType(typeConstructor);
        boolean z = true;
        if (primitiveType != null) {
            JvmPrimitiveType jvmPrimitiveType = JvmPrimitiveType.get(primitiveType);
            Intrinsics.checkExpressionValueIsNotNull(jvmPrimitiveType, "JvmPrimitiveType.get(primitiveType)");
            String desc = jvmPrimitiveType.getDesc();
            Intrinsics.checkExpressionValueIsNotNull(desc, "JvmPrimitiveType.get(primitiveType).desc");
            T createFromString = jvmTypeFactory.createFromString(desc);
            if (!typeSystemCommonBackendContext.isNullableType(kotlinTypeMarker) && !TypeEnhancementKt.hasEnhancedNullability(typeSystemCommonBackendContext, kotlinTypeMarker)) {
                z = false;
            }
            return boxTypeIfNeeded(jvmTypeFactory, createFromString, z);
        }
        PrimitiveType primitiveArrayType = typeSystemCommonBackendContext.getPrimitiveArrayType(typeConstructor);
        if (primitiveArrayType != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            JvmPrimitiveType jvmPrimitiveType2 = JvmPrimitiveType.get(primitiveArrayType);
            Intrinsics.checkExpressionValueIsNotNull(jvmPrimitiveType2, "JvmPrimitiveType.get(arrayElementType)");
            sb.append(jvmPrimitiveType2.getDesc());
            return jvmTypeFactory.createFromString(sb.toString());
        }
        if (typeSystemCommonBackendContext.isUnderKotlinPackage(typeConstructor)) {
            FqNameUnsafe classFqNameUnsafe = typeSystemCommonBackendContext.getClassFqNameUnsafe(typeConstructor);
            ClassId mapKotlinToJava = classFqNameUnsafe != null ? JavaToKotlinClassMap.INSTANCE.mapKotlinToJava(classFqNameUnsafe) : null;
            if (mapKotlinToJava != null) {
                if (!typeMappingMode.getKotlinCollectionsToJavaCollections()) {
                    Iterable mutabilityMappings = JavaToKotlinClassMap.INSTANCE.getMutabilityMappings();
                    if (!(mutabilityMappings instanceof Collection) || !((Collection) mutabilityMappings).isEmpty()) {
                        Iterator it = mutabilityMappings.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (Intrinsics.areEqual(((JavaToKotlinClassMap.PlatformMutabilityMapping) it.next()).getJavaClass(), mapKotlinToJava)) {
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                    z = false;
                    if (z) {
                        return null;
                    }
                }
                JvmClassName byClassId = JvmClassName.byClassId(mapKotlinToJava);
                Intrinsics.checkExpressionValueIsNotNull(byClassId, "JvmClassName.byClassId(classId)");
                String internalName = byClassId.getInternalName();
                Intrinsics.checkExpressionValueIsNotNull(internalName, "JvmClassName.byClassId(classId).internalName");
                return jvmTypeFactory.createObjectType(internalName);
            }
        }
        return null;
    }

    public static /* synthetic */ String computeInternalName$default(ClassDescriptor classDescriptor, TypeMappingConfiguration typeMappingConfiguration, int i, Object obj) {
        if ((i & 2) != 0) {
            typeMappingConfiguration = TypeMappingConfigurationImpl.INSTANCE;
        }
        return computeInternalName(classDescriptor, typeMappingConfiguration);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: kotlin.text.StringsKt__StringsJVMKt.replace$default(java.lang.String, char, char, boolean, int, java.lang.Object):java.lang.String
     arg types: [java.lang.String, int, int, int, int, ?[OBJECT, ARRAY]]
     candidates:
      kotlin.text.StringsKt__StringsJVMKt.replace$default(java.lang.String, java.lang.String, java.lang.String, boolean, int, java.lang.Object):java.lang.String
      kotlin.text.StringsKt__StringsJVMKt.replace$default(java.lang.String, char, char, boolean, int, java.lang.Object):java.lang.String */
    public static final String computeInternalName(ClassDescriptor classDescriptor, TypeMappingConfiguration<?> typeMappingConfiguration) {
        Intrinsics.checkParameterIsNotNull(classDescriptor, "klass");
        Intrinsics.checkParameterIsNotNull(typeMappingConfiguration, "typeMappingConfiguration");
        String predefinedFullInternalNameForClass = typeMappingConfiguration.getPredefinedFullInternalNameForClass(classDescriptor);
        if (predefinedFullInternalNameForClass != null) {
            return predefinedFullInternalNameForClass;
        }
        DeclarationDescriptor containingDeclaration = classDescriptor.getContainingDeclaration();
        Intrinsics.checkExpressionValueIsNotNull(containingDeclaration, "klass.containingDeclaration");
        Name safeIdentifier = SpecialNames.safeIdentifier(classDescriptor.getName());
        Intrinsics.checkExpressionValueIsNotNull(safeIdentifier, "SpecialNames.safeIdentifier(klass.name)");
        String identifier = safeIdentifier.getIdentifier();
        Intrinsics.checkExpressionValueIsNotNull(identifier, "SpecialNames.safeIdentifier(klass.name).identifier");
        if (containingDeclaration instanceof PackageFragmentDescriptor) {
            FqName fqName = ((PackageFragmentDescriptor) containingDeclaration).getFqName();
            if (fqName.isRoot()) {
                return identifier;
            }
            StringBuilder sb = new StringBuilder();
            String asString = fqName.asString();
            Intrinsics.checkExpressionValueIsNotNull(asString, "fqName.asString()");
            sb.append(StringsKt.replace$default(asString, '.', '/', false, 4, (Object) null));
            sb.append('/');
            sb.append(identifier);
            return sb.toString();
        }
        ClassDescriptor classDescriptor2 = (ClassDescriptor) (!(containingDeclaration instanceof ClassDescriptor) ? null : containingDeclaration);
        if (classDescriptor2 != null) {
            String predefinedInternalNameForClass = typeMappingConfiguration.getPredefinedInternalNameForClass(classDescriptor2);
            if (predefinedInternalNameForClass == null) {
                predefinedInternalNameForClass = computeInternalName(classDescriptor2, typeMappingConfiguration);
            }
            return predefinedInternalNameForClass + ((char) Typography.dollar) + identifier;
        }
        throw new IllegalArgumentException("Unexpected container: " + containingDeclaration + " for " + classDescriptor);
    }
}
