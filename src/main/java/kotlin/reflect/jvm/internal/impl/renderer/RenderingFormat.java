package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
/* compiled from: DescriptorRenderer.kt */
public abstract class RenderingFormat extends Enum<RenderingFormat> {
    private static final /* synthetic */ RenderingFormat[] $VALUES;
    public static final RenderingFormat HTML;
    public static final RenderingFormat PLAIN;

    static {
        PLAIN plain = new PLAIN("PLAIN", 0);
        PLAIN = plain;
        HTML html = new HTML("HTML", 1);
        HTML = html;
        $VALUES = new RenderingFormat[]{plain, html};
    }

    public static RenderingFormat valueOf(String str) {
        return (RenderingFormat) Enum.valueOf(RenderingFormat.class, str);
    }

    public static RenderingFormat[] values() {
        return (RenderingFormat[]) $VALUES.clone();
    }

    public abstract String escape(String str);

    /* compiled from: DescriptorRenderer.kt */
    static final class PLAIN extends RenderingFormat {
        public String escape(String str) {
            Intrinsics.checkParameterIsNotNull(str, "string");
            return str;
        }

        PLAIN(String str, int i) {
            super(str, i, null);
        }
    }

    private RenderingFormat(String str, int i) {
    }

    public /* synthetic */ RenderingFormat(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i);
    }

    /* compiled from: DescriptorRenderer.kt */
    static final class HTML extends RenderingFormat {
        HTML(String str, int i) {
            super(str, i, null);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: kotlin.text.StringsKt__StringsJVMKt.replace$default(java.lang.String, java.lang.String, java.lang.String, boolean, int, java.lang.Object):java.lang.String
         arg types: [java.lang.String, java.lang.String, java.lang.String, int, int, ?[OBJECT, ARRAY]]
         candidates:
          kotlin.text.StringsKt__StringsJVMKt.replace$default(java.lang.String, char, char, boolean, int, java.lang.Object):java.lang.String
          kotlin.text.StringsKt__StringsJVMKt.replace$default(java.lang.String, java.lang.String, java.lang.String, boolean, int, java.lang.Object):java.lang.String */
        public String escape(String str) {
            Intrinsics.checkParameterIsNotNull(str, "string");
            return StringsKt.replace$default(StringsKt.replace$default(str, "<", "&lt;", false, 4, (Object) null), ">", "&gt;", false, 4, (Object) null);
        }
    }
}
