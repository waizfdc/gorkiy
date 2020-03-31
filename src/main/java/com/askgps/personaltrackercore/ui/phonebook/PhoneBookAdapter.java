package com.askgps.personaltrackercore.ui.phonebook;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.askgps.personaltrackercore.database.model.PhoneNumber;
import com.askgps.personaltrackercore.databinding.PhoneNumberBinding;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B-\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\u0010\bJ\b\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\fH\u0016J\u0014\u0010\u0014\u001a\u00020\u00062\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/askgps/personaltrackercore/ui/phonebook/PhoneBookAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/askgps/personaltrackercore/ui/phonebook/PhoneBookViewHolder;", "clickListener", "Lkotlin/Function1;", "Lcom/askgps/personaltrackercore/database/model/PhoneNumber;", "", "longClickListener", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "items", "", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "submitList", "newList", "", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: PhoneBookAdapter.kt */
public final class PhoneBookAdapter extends RecyclerView.Adapter<PhoneBookViewHolder> {
    private final Function1<PhoneNumber, Unit> clickListener;
    private final List<PhoneNumber> items = new ArrayList();
    private final Function1<PhoneNumber, Unit> longClickListener;

    /* JADX WARN: Type inference failed for: r2v0, types: [kotlin.jvm.functions.Function1<com.askgps.personaltrackercore.database.model.PhoneNumber, kotlin.Unit>, java.lang.Object, kotlin.jvm.functions.Function1<? super com.askgps.personaltrackercore.database.model.PhoneNumber, kotlin.Unit>] */
    /* JADX WARN: Type inference failed for: r3v0, types: [kotlin.jvm.functions.Function1<com.askgps.personaltrackercore.database.model.PhoneNumber, kotlin.Unit>, java.lang.Object, kotlin.jvm.functions.Function1<? super com.askgps.personaltrackercore.database.model.PhoneNumber, kotlin.Unit>] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public PhoneBookAdapter(kotlin.jvm.functions.Function1<? super com.askgps.personaltrackercore.database.model.PhoneNumber, kotlin.Unit> r2, kotlin.jvm.functions.Function1<? super com.askgps.personaltrackercore.database.model.PhoneNumber, kotlin.Unit> r3) {
        /*
            r1 = this;
            java.lang.String r0 = "clickListener"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r2, r0)
            java.lang.String r0 = "longClickListener"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r0)
            r1.<init>()
            r1.clickListener = r2
            r1.longClickListener = r3
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.List r2 = (java.util.List) r2
            r1.items = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.askgps.personaltrackercore.ui.phonebook.PhoneBookAdapter.<init>(kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1):void");
    }

    public PhoneBookViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        PhoneNumberBinding inflate = PhoneNumberBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "PhoneNumberBinding.infla….context), parent, false)");
        return new PhoneBookViewHolder(inflate);
    }

    public int getItemCount() {
        return this.items.size();
    }

    public void onBindViewHolder(PhoneBookViewHolder phoneBookViewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(phoneBookViewHolder, "holder");
        phoneBookViewHolder.bind(this.items.get(i));
        phoneBookViewHolder.setOnClickListener(this.clickListener);
        phoneBookViewHolder.setOnLongClickListener(this.longClickListener);
    }

    public final void submitList(List<PhoneNumber> list) {
        Intrinsics.checkParameterIsNotNull(list, "newList");
        this.items.clear();
        this.items.addAll(list);
        notifyDataSetChanged();
    }
}
