package com.askgps.personaltrackercore.ui;

import android.view.View;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 16})
/* compiled from: QrDialog.kt */
final class QrDialog$onViewCreated$2 implements View.OnClickListener {
    final /* synthetic */ QrDialog this$0;

    QrDialog$onViewCreated$2(QrDialog qrDialog) {
        this.this$0 = qrDialog;
    }

    public final void onClick(View view) {
        this.this$0.dismiss();
    }
}
