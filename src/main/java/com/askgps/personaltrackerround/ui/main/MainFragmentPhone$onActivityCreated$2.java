package com.askgps.personaltrackerround.ui.main;

import android.view.View;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 16})
/* compiled from: MainFragmentPhone.kt */
final class MainFragmentPhone$onActivityCreated$2 implements View.OnClickListener {
    final /* synthetic */ MainFragmentPhone this$0;

    MainFragmentPhone$onActivityCreated$2(MainFragmentPhone mainFragmentPhone) {
        this.this$0 = mainFragmentPhone;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: kotlin.collections.CollectionsKt___CollectionsKt.plus(java.util.Collection, java.lang.Object):java.util.List<T>
     arg types: [java.util.List, com.askgps.personaltrackercore.database.model.PhoneNumber]
     candidates:
      kotlin.collections.CollectionsKt___CollectionsKt.plus(java.lang.Iterable, java.lang.Iterable):java.util.List<T>
      kotlin.collections.CollectionsKt___CollectionsKt.plus(java.lang.Iterable, java.lang.Object):java.util.List<T>
      kotlin.collections.CollectionsKt___CollectionsKt.plus(java.lang.Iterable, kotlin.sequences.Sequence):java.util.List<T>
      kotlin.collections.CollectionsKt___CollectionsKt.plus(java.lang.Iterable, java.lang.Object[]):java.util.List<T>
      kotlin.collections.CollectionsKt___CollectionsKt.plus(java.util.Collection, java.lang.Iterable):java.util.List<T>
      kotlin.collections.CollectionsKt___CollectionsKt.plus(java.util.Collection, kotlin.sequences.Sequence):java.util.List<T>
      kotlin.collections.CollectionsKt___CollectionsKt.plus(java.util.Collection, java.lang.Object[]):java.util.List<T>
      kotlin.collections.CollectionsKt___CollectionsKt.plus(java.util.Collection, java.lang.Object):java.util.List<T> */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0021, code lost:
        if (r5 != null) goto L_0x002c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onClick(android.view.View r5) {
        /*
            r4 = this;
            com.askgps.personaltrackerround.ui.main.MainFragmentPhone r5 = r4.this$0
            com.askgps.personaltrackercore.ui.main.MainViewModel r5 = com.askgps.personaltrackerround.ui.main.MainFragmentPhone.access$getViewModel$p(r5)
            androidx.lifecycle.LiveData r5 = r5.getPhoneNumbers()
            java.lang.Object r5 = r5.getValue()
            java.util.List r5 = (java.util.List) r5
            if (r5 == 0) goto L_0x0024
            java.lang.String r0 = "it"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r5, r0)
            java.util.Collection r5 = (java.util.Collection) r5
            com.askgps.personaltrackercore.database.model.PhoneNumber r0 = com.askgps.personaltrackerround.ui.main.MainFragmentPhone.DEF_PHONE
            java.util.List r5 = kotlin.collections.CollectionsKt.plus(r5, r0)
            if (r5 == 0) goto L_0x0024
            goto L_0x002c
        L_0x0024:
            com.askgps.personaltrackercore.database.model.PhoneNumber r5 = com.askgps.personaltrackerround.ui.main.MainFragmentPhone.DEF_PHONE
            java.util.List r5 = kotlin.collections.CollectionsKt.listOf(r5)
        L_0x002c:
            androidx.appcompat.app.AlertDialog$Builder r0 = new androidx.appcompat.app.AlertDialog$Builder
            com.askgps.personaltrackerround.ui.main.MainFragmentPhone r1 = r4.this$0
            android.content.Context r1 = r1.getContext()
            if (r1 != 0) goto L_0x0039
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0039:
            r2 = 2131689713(0x7f0f00f1, float:1.900845E38)
            r0.<init>(r1, r2)
            r1 = 2131624084(0x7f0e0094, float:1.8875338E38)
            androidx.appcompat.app.AlertDialog$Builder r0 = r0.setTitle(r1)
            r1 = r5
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 10
            int r3 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r1, r3)
            r2.<init>(r3)
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r1 = r1.iterator()
        L_0x005a:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x006e
            java.lang.Object r3 = r1.next()
            com.askgps.personaltrackercore.database.model.PhoneNumber r3 = (com.askgps.personaltrackercore.database.model.PhoneNumber) r3
            java.lang.String r3 = r3.toListItem()
            r2.add(r3)
            goto L_0x005a
        L_0x006e:
            java.util.List r2 = (java.util.List) r2
            java.util.Collection r2 = (java.util.Collection) r2
            r1 = 0
            java.lang.String[] r1 = new java.lang.String[r1]
            java.lang.Object[] r1 = r2.toArray(r1)
            if (r1 == 0) goto L_0x0090
            java.lang.CharSequence[] r1 = (java.lang.CharSequence[]) r1
            com.askgps.personaltrackerround.ui.main.MainFragmentPhone$onActivityCreated$2$2 r2 = new com.askgps.personaltrackerround.ui.main.MainFragmentPhone$onActivityCreated$2$2
            r2.<init>(r4, r5)
            android.content.DialogInterface$OnClickListener r2 = (android.content.DialogInterface.OnClickListener) r2
            androidx.appcompat.app.AlertDialog$Builder r5 = r0.setItems(r1, r2)
            androidx.appcompat.app.AlertDialog r5 = r5.create()
            r5.show()
            return
        L_0x0090:
            kotlin.TypeCastException r5 = new kotlin.TypeCastException
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.Array<T>"
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.askgps.personaltrackerround.ui.main.MainFragmentPhone$onActivityCreated$2.onClick(android.view.View):void");
    }
}
