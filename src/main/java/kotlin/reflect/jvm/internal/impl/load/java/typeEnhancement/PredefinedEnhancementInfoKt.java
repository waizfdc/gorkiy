package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.Map;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;

/* compiled from: predefinedEnhancementInfo.kt */
public final class PredefinedEnhancementInfoKt {
    /* access modifiers changed from: private */
    public static final JavaTypeQualifiers NOT_NULLABLE = new JavaTypeQualifiers(NullabilityQualifier.NOT_NULL, null, true, false, 8, null);
    /* access modifiers changed from: private */
    public static final JavaTypeQualifiers NOT_PLATFORM = new JavaTypeQualifiers(NullabilityQualifier.NOT_NULL, null, false, false, 8, null);
    /* access modifiers changed from: private */
    public static final JavaTypeQualifiers NULLABLE = new JavaTypeQualifiers(NullabilityQualifier.NULLABLE, null, false, false, 8, null);
    private static final Map<String, PredefinedFunctionEnhancementInfo> PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE;

    static {
        SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
        String javaLang = signatureBuildingComponents.javaLang("Object");
        String javaFunction = signatureBuildingComponents.javaFunction("Predicate");
        String javaFunction2 = signatureBuildingComponents.javaFunction("Function");
        String javaFunction3 = signatureBuildingComponents.javaFunction("Consumer");
        String javaFunction4 = signatureBuildingComponents.javaFunction("BiFunction");
        String javaFunction5 = signatureBuildingComponents.javaFunction("BiConsumer");
        String javaFunction6 = signatureBuildingComponents.javaFunction("UnaryOperator");
        String javaUtil = signatureBuildingComponents.javaUtil("stream/Stream");
        String javaUtil2 = signatureBuildingComponents.javaUtil("Optional");
        SignatureEnhancementBuilder signatureEnhancementBuilder = new SignatureEnhancementBuilder();
        String str = javaFunction3;
        String str2 = javaFunction;
        String str3 = javaUtil;
        String str4 = javaFunction;
        SignatureEnhancementBuilder.ClassEnhancementBuilder classEnhancementBuilder = new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, signatureBuildingComponents.javaUtil("Iterator"));
        String str5 = javaFunction6;
        String str6 = javaFunction6;
        SignatureEnhancementBuilder signatureEnhancementBuilder2 = signatureEnhancementBuilder;
        String str7 = javaFunction5;
        String str8 = javaUtil2;
        String str9 = javaFunction4;
        String str10 = javaFunction2;
        String str11 = str8;
        classEnhancementBuilder.function("forEachRemaining", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$1(signatureBuildingComponents, str, str2, str3, str5, str7, javaLang, str9, str10, str11));
        SignatureBuildingComponents signatureBuildingComponents2 = signatureBuildingComponents;
        String str12 = str4;
        String str13 = str6;
        String str14 = javaFunction5;
        String str15 = javaLang;
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder2, signatureBuildingComponents.javaLang("Iterable")).function("spliterator", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$2(signatureBuildingComponents2, str, str12, str3, str13, str7, str15, str9, str10, str11));
        SignatureEnhancementBuilder.ClassEnhancementBuilder classEnhancementBuilder2 = new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder2, signatureBuildingComponents.javaUtil("Collection"));
        String str16 = str14;
        classEnhancementBuilder2.function("removeIf", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$3(signatureBuildingComponents2, str, str12, str3, str13, str16, str15, str9, str10, str11));
        classEnhancementBuilder2.function("stream", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$4(signatureBuildingComponents2, str, str12, str3, str13, str16, str15, str9, str10, str11));
        classEnhancementBuilder2.function("parallelStream", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$5(signatureBuildingComponents2, str, str12, str3, str13, str16, str15, str9, str10, str11));
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder2, signatureBuildingComponents.javaUtil("List")).function("replaceAll", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$6(signatureBuildingComponents2, str, str12, str3, str13, str16, str15, str9, str10, str11));
        SignatureEnhancementBuilder.ClassEnhancementBuilder classEnhancementBuilder3 = new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder2, signatureBuildingComponents.javaUtil("Map"));
        SignatureEnhancementBuilder signatureEnhancementBuilder3 = signatureEnhancementBuilder2;
        String str17 = javaLang;
        classEnhancementBuilder3.function("forEach", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$7(signatureBuildingComponents2, str, str12, str3, str13, str16, str17, str9, str10, str11));
        classEnhancementBuilder3.function("putIfAbsent", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$8(signatureBuildingComponents2, str, str12, str3, str13, str16, str17, str9, str10, str11));
        classEnhancementBuilder3.function("replace", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$9(signatureBuildingComponents2, str, str12, str3, str13, str16, str17, str9, str10, str11));
        String str18 = javaLang;
        classEnhancementBuilder3.function("replace", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$10(signatureBuildingComponents2, str, str12, str3, str13, str16, str18, str9, str10, str11));
        classEnhancementBuilder3.function("replaceAll", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$11(signatureBuildingComponents2, str, str12, str3, str13, str16, str18, str9, str10, str11));
        classEnhancementBuilder3.function("compute", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$12(signatureBuildingComponents2, str, str12, str3, str13, str16, str18, str9, str10, str11));
        classEnhancementBuilder3.function("computeIfAbsent", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$13(signatureBuildingComponents2, str, str12, str3, str13, str16, str18, str9, str10, str11));
        classEnhancementBuilder3.function("computeIfPresent", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$14(signatureBuildingComponents2, str, str12, str3, str13, str16, str18, str9, str10, str11));
        classEnhancementBuilder3.function("merge", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$15(signatureBuildingComponents2, str, str12, str3, str13, str16, str18, str9, str10, str11));
        String str19 = str8;
        SignatureEnhancementBuilder signatureEnhancementBuilder4 = signatureEnhancementBuilder3;
        SignatureEnhancementBuilder.ClassEnhancementBuilder classEnhancementBuilder4 = new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder4, str19);
        String str20 = str19;
        classEnhancementBuilder4.function("empty", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$16(signatureBuildingComponents2, str, str12, str3, str13, str16, str18, str9, str10, str20));
        classEnhancementBuilder4.function("of", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$17(signatureBuildingComponents, str, str12, str3, str13, str16, str18, str9, str10, str20));
        classEnhancementBuilder4.function("ofNullable", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$18(signatureBuildingComponents, str, str12, str3, str13, str16, str18, str9, str10, str20));
        SignatureBuildingComponents signatureBuildingComponents3 = signatureBuildingComponents;
        classEnhancementBuilder4.function("get", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$19(signatureBuildingComponents3, str, str12, str3, str13, str16, str18, str9, str10, str20));
        classEnhancementBuilder4.function("ifPresent", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$20(signatureBuildingComponents3, str, str12, str3, str13, str16, javaLang, str9, str10, str20));
        SignatureBuildingComponents signatureBuildingComponents4 = signatureBuildingComponents;
        String str21 = javaFunction3;
        String str22 = "get";
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder4, signatureBuildingComponents.javaLang("ref/Reference")).function(str22, new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$21(signatureBuildingComponents4, str, str12, str3, str13, str16, javaLang, str9, str10, str20));
        String str23 = str4;
        String str24 = str21;
        String str25 = str23;
        String str26 = str22;
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder4, str23).function("test", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$22(signatureBuildingComponents4, str24, str25, str3, str13, str16, javaLang, str9, str10, str20));
        String str27 = str23;
        String str28 = str14;
        SignatureBuildingComponents signatureBuildingComponents5 = signatureBuildingComponents;
        String str29 = javaLang;
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder4, signatureBuildingComponents.javaFunction("BiPredicate")).function("test", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$23(signatureBuildingComponents4, str24, str25, str3, str13, str28, str29, str9, str10, str20));
        String str30 = str21;
        SignatureBuildingComponents signatureBuildingComponents6 = signatureBuildingComponents5;
        String str31 = str30;
        String str32 = str27;
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder4, str30).function("accept", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$24(signatureBuildingComponents6, str31, str32, str3, str13, str28, str29, str9, str10, str20));
        String str33 = str14;
        String str34 = javaLang;
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder4, str33).function("accept", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$25(signatureBuildingComponents6, str31, str32, str3, str13, str33, str34, str9, str10, str20));
        String str35 = str33;
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder4, javaFunction2).function("apply", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$26(signatureBuildingComponents6, str31, str32, str3, str13, str35, str34, str9, str10, str20));
        String str36 = str30;
        String str37 = javaLang;
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder4, javaFunction4).function("apply", new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$27(signatureBuildingComponents6, str31, str32, str3, str13, str35, str37, str9, str10, str20));
        SignatureBuildingComponents signatureBuildingComponents7 = signatureBuildingComponents5;
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder4, signatureBuildingComponents7.javaFunction("Supplier")).function(str26, new PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$28(signatureBuildingComponents7, str36, str32, str3, str13, str35, str37, str9, str10, str20));
        PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE = signatureEnhancementBuilder4.build();
    }

    public static final Map<String, PredefinedFunctionEnhancementInfo> getPREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE() {
        return PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE;
    }
}
