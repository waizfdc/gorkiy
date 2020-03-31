package com.redmadrobot.inputmask;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.redmadrobot.inputmask.helper.AffinityCalculationStrategy;
import com.redmadrobot.inputmask.helper.Mask;
import com.redmadrobot.inputmask.helper.RTLMask;
import com.redmadrobot.inputmask.model.CaretString;
import com.redmadrobot.inputmask.model.Notation;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 e2\u00020\u00012\u00020\u0002:\u0002efB\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB+\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\fB3\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u000fB%\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0012\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0013B/\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0012\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u0014B9\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0012\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u0015BA\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0012\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u0016BI\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0012\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u0019Bu\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0012\u0012\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0012\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u000e\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u000e¢\u0006\u0002\u0010\u001eJ\u0006\u0010E\u001a\u00020/J\u0006\u0010F\u001a\u00020/J\u0012\u0010G\u001a\u00020H2\b\u0010I\u001a\u0004\u0018\u00010JH\u0016J*\u0010K\u001a\u00020H2\b\u0010L\u001a\u0004\u0018\u00010M2\u0006\u0010N\u001a\u00020/2\u0006\u0010O\u001a\u00020/2\u0006\u0010P\u001a\u00020/H\u0016J\u0018\u0010Q\u001a\u00020/2\u0006\u0010R\u001a\u00020<2\u0006\u0010S\u001a\u00020TH\u0002J\u001e\u0010U\u001a\u00020<2\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0012H\u0002J\u001a\u0010V\u001a\u00020H2\b\u0010W\u001a\u0004\u0018\u00010X2\u0006\u0010Y\u001a\u00020\u000eH\u0016J(\u0010Z\u001a\u00020H2\u0006\u0010S\u001a\u00020M2\u0006\u0010[\u001a\u00020/2\u0006\u0010\\\u001a\u00020/2\u0006\u0010O\u001a\u00020/H\u0016J\u0010\u0010]\u001a\u00020<2\u0006\u0010S\u001a\u00020TH\u0002J\u0006\u0010^\u001a\u00020\u0004J)\u0010_\u001a\u00020`2\u0006\u0010S\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0002\u0010aJ#\u0010_\u001a\u0004\u0018\u00010`2\u0006\u0010S\u001a\u00020\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0002\u0010bJ\u0006\u0010c\u001a\u00020/J\u0006\u0010d\u001a\u00020/R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010\u001c\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010)\"\u0004\b-\u0010+R\u000e\u0010.\u001a\u00020/X\u000e¢\u0006\u0002\n\u0000R \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010 \"\u0004\b1\u0010\"R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u000602X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001a\u0010\u0010\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u0014\u0010;\u001a\u00020<8BX\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>R\u001a\u0010\u001d\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010)\"\u0004\b@\u0010+R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010D¨\u0006g"}, d2 = {"Lcom/redmadrobot/inputmask/MaskedTextChangedListener;", "Landroid/text/TextWatcher;", "Landroid/view/View$OnFocusChangeListener;", "format", "", "field", "Landroid/widget/EditText;", "(Ljava/lang/String;Landroid/widget/EditText;)V", "valueListener", "Lcom/redmadrobot/inputmask/MaskedTextChangedListener$ValueListener;", "(Ljava/lang/String;Landroid/widget/EditText;Lcom/redmadrobot/inputmask/MaskedTextChangedListener$ValueListener;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "(Ljava/lang/String;Landroid/widget/EditText;Landroid/text/TextWatcher;Lcom/redmadrobot/inputmask/MaskedTextChangedListener$ValueListener;)V", "autocomplete", "", "(Ljava/lang/String;ZLandroid/widget/EditText;Landroid/text/TextWatcher;Lcom/redmadrobot/inputmask/MaskedTextChangedListener$ValueListener;)V", "primaryFormat", "affineFormats", "", "(Ljava/lang/String;Ljava/util/List;Landroid/widget/EditText;)V", "(Ljava/lang/String;Ljava/util/List;Landroid/widget/EditText;Lcom/redmadrobot/inputmask/MaskedTextChangedListener$ValueListener;)V", "(Ljava/lang/String;Ljava/util/List;Landroid/widget/EditText;Landroid/text/TextWatcher;Lcom/redmadrobot/inputmask/MaskedTextChangedListener$ValueListener;)V", "(Ljava/lang/String;Ljava/util/List;ZLandroid/widget/EditText;Landroid/text/TextWatcher;Lcom/redmadrobot/inputmask/MaskedTextChangedListener$ValueListener;)V", "affinityCalculationStrategy", "Lcom/redmadrobot/inputmask/helper/AffinityCalculationStrategy;", "(Ljava/lang/String;Ljava/util/List;Lcom/redmadrobot/inputmask/helper/AffinityCalculationStrategy;ZLandroid/widget/EditText;Landroid/text/TextWatcher;Lcom/redmadrobot/inputmask/MaskedTextChangedListener$ValueListener;)V", "customNotations", "Lcom/redmadrobot/inputmask/model/Notation;", "autoskip", "rightToLeft", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/redmadrobot/inputmask/helper/AffinityCalculationStrategy;ZZLandroid/widget/EditText;Landroid/text/TextWatcher;Lcom/redmadrobot/inputmask/MaskedTextChangedListener$ValueListener;Z)V", "getAffineFormats", "()Ljava/util/List;", "setAffineFormats", "(Ljava/util/List;)V", "getAffinityCalculationStrategy", "()Lcom/redmadrobot/inputmask/helper/AffinityCalculationStrategy;", "setAffinityCalculationStrategy", "(Lcom/redmadrobot/inputmask/helper/AffinityCalculationStrategy;)V", "afterText", "getAutocomplete", "()Z", "setAutocomplete", "(Z)V", "getAutoskip", "setAutoskip", "caretPosition", "", "getCustomNotations", "setCustomNotations", "Ljava/lang/ref/WeakReference;", "getListener", "()Landroid/text/TextWatcher;", "setListener", "(Landroid/text/TextWatcher;)V", "getPrimaryFormat", "()Ljava/lang/String;", "setPrimaryFormat", "(Ljava/lang/String;)V", "primaryMask", "Lcom/redmadrobot/inputmask/helper/Mask;", "getPrimaryMask", "()Lcom/redmadrobot/inputmask/helper/Mask;", "getRightToLeft", "setRightToLeft", "getValueListener", "()Lcom/redmadrobot/inputmask/MaskedTextChangedListener$ValueListener;", "setValueListener", "(Lcom/redmadrobot/inputmask/MaskedTextChangedListener$ValueListener;)V", "acceptableTextLength", "acceptableValueLength", "afterTextChanged", "", "edit", "Landroid/text/Editable;", "beforeTextChanged", "s", "", "start", "count", "after", "calculateAffinity", "mask", "text", "Lcom/redmadrobot/inputmask/model/CaretString;", "maskGetOrCreate", "onFocusChange", "view", "Landroid/view/View;", "hasFocus", "onTextChanged", "cursorPosition", "before", "pickMask", "placeholder", "setText", "Lcom/redmadrobot/inputmask/helper/Mask$Result;", "(Ljava/lang/String;Landroid/widget/EditText;Ljava/lang/Boolean;)Lcom/redmadrobot/inputmask/helper/Mask$Result;", "(Ljava/lang/String;Ljava/lang/Boolean;)Lcom/redmadrobot/inputmask/helper/Mask$Result;", "totalTextLength", "totalValueLength", "Companion", "ValueListener", "input-mask-android_release"}, k = 1, mv = {1, 1, 13})
/* compiled from: MaskedTextChangedListener.kt */
public class MaskedTextChangedListener implements TextWatcher, View.OnFocusChangeListener {
    public static final Companion Companion = new Companion(null);
    private List<String> affineFormats;
    private AffinityCalculationStrategy affinityCalculationStrategy;
    private String afterText;
    private boolean autocomplete;
    private boolean autoskip;
    private int caretPosition;
    private List<Notation> customNotations;
    private final WeakReference<EditText> field;
    private TextWatcher listener;
    private String primaryFormat;
    private boolean rightToLeft;
    private ValueListener valueListener;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&¨\u0006\t"}, d2 = {"Lcom/redmadrobot/inputmask/MaskedTextChangedListener$ValueListener;", "", "onTextChanged", "", "maskFilled", "", "extractedValue", "", "formattedValue", "input-mask-android_release"}, k = 1, mv = {1, 1, 13})
    /* compiled from: MaskedTextChangedListener.kt */
    public interface ValueListener {
        void onTextChanged(boolean z, String str, String str2);
    }

    public MaskedTextChangedListener(String str, List<String> list, List<Notation> list2, AffinityCalculationStrategy affinityCalculationStrategy2, boolean z, boolean z2, EditText editText, TextWatcher textWatcher, ValueListener valueListener2, boolean z3) {
        Intrinsics.checkParameterIsNotNull(str, "primaryFormat");
        Intrinsics.checkParameterIsNotNull(list, "affineFormats");
        Intrinsics.checkParameterIsNotNull(list2, "customNotations");
        Intrinsics.checkParameterIsNotNull(affinityCalculationStrategy2, "affinityCalculationStrategy");
        Intrinsics.checkParameterIsNotNull(editText, "field");
        this.primaryFormat = str;
        this.affineFormats = list;
        this.customNotations = list2;
        this.affinityCalculationStrategy = affinityCalculationStrategy2;
        this.autocomplete = z;
        this.autoskip = z2;
        this.listener = textWatcher;
        this.valueListener = valueListener2;
        this.rightToLeft = z3;
        this.afterText = "";
        this.field = new WeakReference<>(editText);
    }

    public final String getPrimaryFormat() {
        return this.primaryFormat;
    }

    public final void setPrimaryFormat(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.primaryFormat = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ MaskedTextChangedListener(java.lang.String r14, java.util.List r15, java.util.List r16, com.redmadrobot.inputmask.helper.AffinityCalculationStrategy r17, boolean r18, boolean r19, android.widget.EditText r20, android.text.TextWatcher r21, com.redmadrobot.inputmask.MaskedTextChangedListener.ValueListener r22, boolean r23, int r24, kotlin.jvm.internal.DefaultConstructorMarker r25) {
        /*
            r13 = this;
            r0 = r24
            r1 = r0 & 2
            if (r1 == 0) goto L_0x000c
            java.util.List r1 = kotlin.collections.CollectionsKt.emptyList()
            r4 = r1
            goto L_0x000d
        L_0x000c:
            r4 = r15
        L_0x000d:
            r1 = r0 & 4
            if (r1 == 0) goto L_0x0017
            java.util.List r1 = kotlin.collections.CollectionsKt.emptyList()
            r5 = r1
            goto L_0x0019
        L_0x0017:
            r5 = r16
        L_0x0019:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x0021
            com.redmadrobot.inputmask.helper.AffinityCalculationStrategy r1 = com.redmadrobot.inputmask.helper.AffinityCalculationStrategy.WHOLE_STRING
            r6 = r1
            goto L_0x0023
        L_0x0021:
            r6 = r17
        L_0x0023:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x002a
            r1 = 1
            r7 = r1
            goto L_0x002c
        L_0x002a:
            r7 = r18
        L_0x002c:
            r1 = r0 & 32
            r2 = 0
            if (r1 == 0) goto L_0x0033
            r8 = r2
            goto L_0x0035
        L_0x0033:
            r8 = r19
        L_0x0035:
            r1 = r0 & 128(0x80, float:1.794E-43)
            r3 = 0
            if (r1 == 0) goto L_0x003f
            r1 = r3
            android.text.TextWatcher r1 = (android.text.TextWatcher) r1
            r10 = r1
            goto L_0x0041
        L_0x003f:
            r10 = r21
        L_0x0041:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x004a
            r1 = r3
            com.redmadrobot.inputmask.MaskedTextChangedListener$ValueListener r1 = (com.redmadrobot.inputmask.MaskedTextChangedListener.ValueListener) r1
            r11 = r1
            goto L_0x004c
        L_0x004a:
            r11 = r22
        L_0x004c:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x0052
            r12 = r2
            goto L_0x0054
        L_0x0052:
            r12 = r23
        L_0x0054:
            r2 = r13
            r3 = r14
            r9 = r20
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.redmadrobot.inputmask.MaskedTextChangedListener.<init>(java.lang.String, java.util.List, java.util.List, com.redmadrobot.inputmask.helper.AffinityCalculationStrategy, boolean, boolean, android.widget.EditText, android.text.TextWatcher, com.redmadrobot.inputmask.MaskedTextChangedListener$ValueListener, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final List<String> getAffineFormats() {
        return this.affineFormats;
    }

    public final void setAffineFormats(List<String> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.affineFormats = list;
    }

    public final List<Notation> getCustomNotations() {
        return this.customNotations;
    }

    public final void setCustomNotations(List<Notation> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.customNotations = list;
    }

    public final AffinityCalculationStrategy getAffinityCalculationStrategy() {
        return this.affinityCalculationStrategy;
    }

    public final void setAffinityCalculationStrategy(AffinityCalculationStrategy affinityCalculationStrategy2) {
        Intrinsics.checkParameterIsNotNull(affinityCalculationStrategy2, "<set-?>");
        this.affinityCalculationStrategy = affinityCalculationStrategy2;
    }

    public final boolean getAutocomplete() {
        return this.autocomplete;
    }

    public final void setAutocomplete(boolean z) {
        this.autocomplete = z;
    }

    public final boolean getAutoskip() {
        return this.autoskip;
    }

    public final void setAutoskip(boolean z) {
        this.autoskip = z;
    }

    public final TextWatcher getListener() {
        return this.listener;
    }

    public final void setListener(TextWatcher textWatcher) {
        this.listener = textWatcher;
    }

    public final ValueListener getValueListener() {
        return this.valueListener;
    }

    public final void setValueListener(ValueListener valueListener2) {
        this.valueListener = valueListener2;
    }

    public final boolean getRightToLeft() {
        return this.rightToLeft;
    }

    public final void setRightToLeft(boolean z) {
        this.rightToLeft = z;
    }

    private final Mask getPrimaryMask() {
        return maskGetOrCreate(this.primaryFormat, this.customNotations);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MaskedTextChangedListener(String str, EditText editText) {
        this(str, editText, (ValueListener) null);
        Intrinsics.checkParameterIsNotNull(str, "format");
        Intrinsics.checkParameterIsNotNull(editText, "field");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MaskedTextChangedListener(String str, EditText editText, ValueListener valueListener2) {
        this(str, editText, (TextWatcher) null, valueListener2);
        Intrinsics.checkParameterIsNotNull(str, "format");
        Intrinsics.checkParameterIsNotNull(editText, "field");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.redmadrobot.inputmask.MaskedTextChangedListener.<init>(java.lang.String, boolean, android.widget.EditText, android.text.TextWatcher, com.redmadrobot.inputmask.MaskedTextChangedListener$ValueListener):void
     arg types: [java.lang.String, int, android.widget.EditText, android.text.TextWatcher, com.redmadrobot.inputmask.MaskedTextChangedListener$ValueListener]
     candidates:
      com.redmadrobot.inputmask.MaskedTextChangedListener.<init>(java.lang.String, java.util.List<java.lang.String>, android.widget.EditText, android.text.TextWatcher, com.redmadrobot.inputmask.MaskedTextChangedListener$ValueListener):void
      com.redmadrobot.inputmask.MaskedTextChangedListener.<init>(java.lang.String, boolean, android.widget.EditText, android.text.TextWatcher, com.redmadrobot.inputmask.MaskedTextChangedListener$ValueListener):void */
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MaskedTextChangedListener(String str, EditText editText, TextWatcher textWatcher, ValueListener valueListener2) {
        this(str, true, editText, textWatcher, valueListener2);
        Intrinsics.checkParameterIsNotNull(str, "format");
        Intrinsics.checkParameterIsNotNull(editText, "field");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MaskedTextChangedListener(java.lang.String r15, boolean r16, android.widget.EditText r17, android.text.TextWatcher r18, com.redmadrobot.inputmask.MaskedTextChangedListener.ValueListener r19) {
        /*
            r14 = this;
            java.lang.String r0 = "format"
            r2 = r15
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r15, r0)
            java.lang.String r0 = "field"
            r8 = r17
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r8, r0)
            java.util.List r3 = kotlin.collections.CollectionsKt.emptyList()
            java.util.List r4 = kotlin.collections.CollectionsKt.emptyList()
            com.redmadrobot.inputmask.helper.AffinityCalculationStrategy r5 = com.redmadrobot.inputmask.helper.AffinityCalculationStrategy.WHOLE_STRING
            r7 = 0
            r11 = 0
            r12 = 512(0x200, float:7.175E-43)
            r13 = 0
            r1 = r14
            r6 = r16
            r9 = r18
            r10 = r19
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.redmadrobot.inputmask.MaskedTextChangedListener.<init>(java.lang.String, boolean, android.widget.EditText, android.text.TextWatcher, com.redmadrobot.inputmask.MaskedTextChangedListener$ValueListener):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MaskedTextChangedListener(String str, List<String> list, EditText editText) {
        this(str, list, editText, (ValueListener) null);
        Intrinsics.checkParameterIsNotNull(str, "primaryFormat");
        Intrinsics.checkParameterIsNotNull(list, "affineFormats");
        Intrinsics.checkParameterIsNotNull(editText, "field");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MaskedTextChangedListener(String str, List<String> list, EditText editText, ValueListener valueListener2) {
        this(str, list, editText, (TextWatcher) null, valueListener2);
        Intrinsics.checkParameterIsNotNull(str, "primaryFormat");
        Intrinsics.checkParameterIsNotNull(list, "affineFormats");
        Intrinsics.checkParameterIsNotNull(editText, "field");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MaskedTextChangedListener(String str, List<String> list, EditText editText, TextWatcher textWatcher, ValueListener valueListener2) {
        this(str, list, true, editText, textWatcher, valueListener2);
        Intrinsics.checkParameterIsNotNull(str, "primaryFormat");
        Intrinsics.checkParameterIsNotNull(list, "affineFormats");
        Intrinsics.checkParameterIsNotNull(editText, "field");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MaskedTextChangedListener(String str, List<String> list, boolean z, EditText editText, TextWatcher textWatcher, ValueListener valueListener2) {
        this(str, list, AffinityCalculationStrategy.WHOLE_STRING, z, editText, textWatcher, valueListener2);
        Intrinsics.checkParameterIsNotNull(str, "primaryFormat");
        Intrinsics.checkParameterIsNotNull(list, "affineFormats");
        Intrinsics.checkParameterIsNotNull(editText, "field");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MaskedTextChangedListener(java.lang.String r15, java.util.List<java.lang.String> r16, com.redmadrobot.inputmask.helper.AffinityCalculationStrategy r17, boolean r18, android.widget.EditText r19, android.text.TextWatcher r20, com.redmadrobot.inputmask.MaskedTextChangedListener.ValueListener r21) {
        /*
            r14 = this;
            java.lang.String r0 = "primaryFormat"
            r2 = r15
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r15, r0)
            java.lang.String r0 = "affineFormats"
            r3 = r16
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r0)
            java.lang.String r0 = "affinityCalculationStrategy"
            r5 = r17
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r5, r0)
            java.lang.String r0 = "field"
            r8 = r19
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r8, r0)
            java.util.List r4 = kotlin.collections.CollectionsKt.emptyList()
            r7 = 0
            r11 = 0
            r12 = 512(0x200, float:7.175E-43)
            r13 = 0
            r1 = r14
            r6 = r18
            r9 = r20
            r10 = r21
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.redmadrobot.inputmask.MaskedTextChangedListener.<init>(java.lang.String, java.util.List, com.redmadrobot.inputmask.helper.AffinityCalculationStrategy, boolean, android.widget.EditText, android.text.TextWatcher, com.redmadrobot.inputmask.MaskedTextChangedListener$ValueListener):void");
    }

    public static /* synthetic */ Mask.Result setText$default(MaskedTextChangedListener maskedTextChangedListener, String str, Boolean bool, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                bool = null;
            }
            return maskedTextChangedListener.setText(str, bool);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setText");
    }

    public Mask.Result setText(String str, Boolean bool) {
        Intrinsics.checkParameterIsNotNull(str, "text");
        EditText editText = this.field.get();
        if (editText == null) {
            return null;
        }
        Intrinsics.checkExpressionValueIsNotNull(editText, "it");
        Mask.Result text = setText(str, editText, bool);
        this.afterText = text.getFormattedText().getString();
        this.caretPosition = text.getFormattedText().getCaretPosition();
        ValueListener valueListener2 = this.valueListener;
        if (valueListener2 != null) {
            valueListener2.onTextChanged(text.getComplete(), text.getExtractedValue(), this.afterText);
        }
        return text;
    }

    public static /* synthetic */ Mask.Result setText$default(MaskedTextChangedListener maskedTextChangedListener, String str, EditText editText, Boolean bool, int i, Object obj) {
        if (obj == null) {
            if ((i & 4) != 0) {
                bool = null;
            }
            return maskedTextChangedListener.setText(str, editText, bool);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setText");
    }

    public Mask.Result setText(String str, EditText editText, Boolean bool) {
        Intrinsics.checkParameterIsNotNull(str, "text");
        Intrinsics.checkParameterIsNotNull(editText, "field");
        CaretString caretString = new CaretString(str, str.length(), new CaretString.CaretGravity.FORWARD(bool != null ? bool.booleanValue() : this.autocomplete));
        Mask.Result apply = pickMask(caretString).apply(caretString);
        editText.setText(apply.getFormattedText().getString());
        editText.setSelection(apply.getFormattedText().getCaretPosition());
        return apply;
    }

    public final String placeholder() {
        return getPrimaryMask().placeholder();
    }

    public final int acceptableTextLength() {
        return getPrimaryMask().acceptableTextLength();
    }

    public final int totalTextLength() {
        return getPrimaryMask().totalTextLength();
    }

    public final int acceptableValueLength() {
        return getPrimaryMask().acceptableValueLength();
    }

    public final int totalValueLength() {
        return getPrimaryMask().totalValueLength();
    }

    public void afterTextChanged(Editable editable) {
        EditText editText = this.field.get();
        if (editText != null) {
            editText.removeTextChangedListener(this);
        }
        if (editable != null) {
            editable.replace(0, editable.length(), this.afterText);
        }
        EditText editText2 = this.field.get();
        if (editText2 != null) {
            editText2.setSelection(this.caretPosition);
        }
        EditText editText3 = this.field.get();
        if (editText3 != null) {
            editText3.addTextChangedListener(this);
        }
        TextWatcher textWatcher = this.listener;
        if (textWatcher != null) {
            textWatcher.afterTextChanged(editable);
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        TextWatcher textWatcher = this.listener;
        if (textWatcher != null) {
            textWatcher.beforeTextChanged(charSequence, i, i2, i3);
        }
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(charSequence, "text");
        boolean z = false;
        boolean z2 = i2 > 0 && i3 == 0;
        boolean z3 = z2 ? false : this.autocomplete;
        if (z2) {
            z = this.autoskip;
        }
        CaretString.CaretGravity backward = z2 ? new CaretString.CaretGravity.BACKWARD(z) : new CaretString.CaretGravity.FORWARD(z3);
        if (!z2) {
            i += i3;
        }
        CaretString caretString = new CaretString(charSequence.toString(), i, backward);
        Mask.Result apply = pickMask(caretString).apply(caretString);
        this.afterText = apply.getFormattedText().getString();
        this.caretPosition = apply.getFormattedText().getCaretPosition();
        ValueListener valueListener2 = this.valueListener;
        if (valueListener2 != null) {
            valueListener2.onTextChanged(apply.getComplete(), apply.getExtractedValue(), this.afterText);
        }
    }

    public void onFocusChange(View view, boolean z) {
        String str;
        if (this.autocomplete && z) {
            EditText editText = this.field.get();
            Editable editable = null;
            Editable text = editText != null ? editText.getText() : null;
            if (text == null) {
                Intrinsics.throwNpe();
            }
            if (text.length() == 0) {
                str = "";
            } else {
                EditText editText2 = this.field.get();
                if (editText2 != null) {
                    editable = editText2.getText();
                }
                str = String.valueOf(editable);
            }
            CaretString caretString = new CaretString(str, str.length(), new CaretString.CaretGravity.FORWARD(this.autocomplete));
            Mask.Result apply = pickMask(caretString).apply(caretString);
            this.afterText = apply.getFormattedText().getString();
            this.caretPosition = apply.getFormattedText().getCaretPosition();
            EditText editText3 = this.field.get();
            if (editText3 != null) {
                editText3.setText(this.afterText);
            }
            EditText editText4 = this.field.get();
            if (editText4 != null) {
                editText4.setSelection(apply.getFormattedText().getCaretPosition());
            }
            ValueListener valueListener2 = this.valueListener;
            if (valueListener2 != null) {
                valueListener2.onTextChanged(apply.getComplete(), apply.getExtractedValue(), this.afterText);
            }
        }
    }

    private final Mask pickMask(CaretString caretString) {
        if (this.affineFormats.isEmpty()) {
            return getPrimaryMask();
        }
        int calculateAffinity = calculateAffinity(getPrimaryMask(), caretString);
        List arrayList = new ArrayList();
        for (String maskGetOrCreate : this.affineFormats) {
            Mask maskGetOrCreate2 = maskGetOrCreate(maskGetOrCreate, this.customNotations);
            arrayList.add(new MaskedTextChangedListener$pickMask$MaskAffinity(maskGetOrCreate2, calculateAffinity(maskGetOrCreate2, caretString)));
        }
        if (arrayList.size() > 1) {
            CollectionsKt.sortWith(arrayList, new MaskedTextChangedListener$pickMask$$inlined$sortByDescending$1());
        }
        int i = -1;
        int i2 = 0;
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (calculateAffinity >= ((MaskedTextChangedListener$pickMask$MaskAffinity) it.next()).getAffinity()) {
                i = i2;
                break;
            } else {
                i2++;
            }
        }
        if (i >= 0) {
            arrayList.add(i, new MaskedTextChangedListener$pickMask$MaskAffinity(getPrimaryMask(), calculateAffinity));
        } else {
            arrayList.add(new MaskedTextChangedListener$pickMask$MaskAffinity(getPrimaryMask(), calculateAffinity));
        }
        return ((MaskedTextChangedListener$pickMask$MaskAffinity) CollectionsKt.first(arrayList)).getMask();
    }

    private final Mask maskGetOrCreate(String str, List<Notation> list) {
        if (this.rightToLeft) {
            return RTLMask.Factory.getOrCreate(str, list);
        }
        return Mask.Factory.getOrCreate(str, list);
    }

    private final int calculateAffinity(Mask mask, CaretString caretString) {
        return this.affinityCalculationStrategy.calculateAffinityOfMask(mask, caretString);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nJ<\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nJl\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\f2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¨\u0006\u0016"}, d2 = {"Lcom/redmadrobot/inputmask/MaskedTextChangedListener$Companion;", "", "()V", "installOn", "Lcom/redmadrobot/inputmask/MaskedTextChangedListener;", "editText", "Landroid/widget/EditText;", "primaryFormat", "", "valueListener", "Lcom/redmadrobot/inputmask/MaskedTextChangedListener$ValueListener;", "affineFormats", "", "affinityCalculationStrategy", "Lcom/redmadrobot/inputmask/helper/AffinityCalculationStrategy;", "customNotations", "Lcom/redmadrobot/inputmask/model/Notation;", "autocomplete", "", "autoskip", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroid/text/TextWatcher;", "input-mask-android_release"}, k = 1, mv = {1, 1, 13})
    /* compiled from: MaskedTextChangedListener.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ MaskedTextChangedListener installOn$default(Companion companion, EditText editText, String str, ValueListener valueListener, int i, Object obj) {
            if ((i & 4) != 0) {
                valueListener = null;
            }
            return companion.installOn(editText, str, valueListener);
        }

        public final MaskedTextChangedListener installOn(EditText editText, String str, ValueListener valueListener) {
            Intrinsics.checkParameterIsNotNull(editText, "editText");
            Intrinsics.checkParameterIsNotNull(str, "primaryFormat");
            return installOn(editText, str, CollectionsKt.emptyList(), AffinityCalculationStrategy.WHOLE_STRING, valueListener);
        }

        public static /* synthetic */ MaskedTextChangedListener installOn$default(Companion companion, EditText editText, String str, List list, AffinityCalculationStrategy affinityCalculationStrategy, ValueListener valueListener, int i, Object obj) {
            if ((i & 4) != 0) {
                list = CollectionsKt.emptyList();
            }
            List list2 = list;
            if ((i & 8) != 0) {
                affinityCalculationStrategy = AffinityCalculationStrategy.WHOLE_STRING;
            }
            AffinityCalculationStrategy affinityCalculationStrategy2 = affinityCalculationStrategy;
            if ((i & 16) != 0) {
                valueListener = null;
            }
            return companion.installOn(editText, str, list2, affinityCalculationStrategy2, valueListener);
        }

        public final MaskedTextChangedListener installOn(EditText editText, String str, List<String> list, AffinityCalculationStrategy affinityCalculationStrategy, ValueListener valueListener) {
            Intrinsics.checkParameterIsNotNull(editText, "editText");
            Intrinsics.checkParameterIsNotNull(str, "primaryFormat");
            Intrinsics.checkParameterIsNotNull(list, "affineFormats");
            Intrinsics.checkParameterIsNotNull(affinityCalculationStrategy, "affinityCalculationStrategy");
            return installOn(editText, str, list, CollectionsKt.emptyList(), affinityCalculationStrategy, true, false, null, valueListener);
        }

        public static /* synthetic */ MaskedTextChangedListener installOn$default(Companion companion, EditText editText, String str, List list, List list2, AffinityCalculationStrategy affinityCalculationStrategy, boolean z, boolean z2, TextWatcher textWatcher, ValueListener valueListener, int i, Object obj) {
            int i2 = i;
            return companion.installOn(editText, str, (i2 & 4) != 0 ? CollectionsKt.emptyList() : list, (i2 & 8) != 0 ? CollectionsKt.emptyList() : list2, (i2 & 16) != 0 ? AffinityCalculationStrategy.WHOLE_STRING : affinityCalculationStrategy, (i2 & 32) != 0 ? true : z, (i2 & 64) != 0 ? false : z2, (i2 & 128) != 0 ? null : textWatcher, (i2 & 256) != 0 ? null : valueListener);
        }

        public final MaskedTextChangedListener installOn(EditText editText, String str, List<String> list, List<Notation> list2, AffinityCalculationStrategy affinityCalculationStrategy, boolean z, boolean z2, TextWatcher textWatcher, ValueListener valueListener) {
            EditText editText2 = editText;
            Intrinsics.checkParameterIsNotNull(editText2, "editText");
            String str2 = str;
            Intrinsics.checkParameterIsNotNull(str2, "primaryFormat");
            List<String> list3 = list;
            Intrinsics.checkParameterIsNotNull(list3, "affineFormats");
            List<Notation> list4 = list2;
            Intrinsics.checkParameterIsNotNull(list4, "customNotations");
            AffinityCalculationStrategy affinityCalculationStrategy2 = affinityCalculationStrategy;
            Intrinsics.checkParameterIsNotNull(affinityCalculationStrategy2, "affinityCalculationStrategy");
            MaskedTextChangedListener maskedTextChangedListener = new MaskedTextChangedListener(str2, list3, list4, affinityCalculationStrategy2, z, z2, editText, textWatcher, valueListener, false, 512, null);
            editText2.addTextChangedListener(maskedTextChangedListener);
            editText2.setOnFocusChangeListener(maskedTextChangedListener);
            return maskedTextChangedListener;
        }
    }
}
