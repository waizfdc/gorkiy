package com.askgps.personaltrackercore.binding;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007\u001a\u001c\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0007\u001a\u0018\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007¨\u0006\u0010"}, d2 = {"loadImage", "", "iv", "Landroid/widget/ImageView;", "bitmap", "Landroid/graphics/Bitmap;", "setAdapter", "rv", "Landroidx/recyclerview/widget/RecyclerView;", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "setLastChar", "tv", "Landroid/widget/TextView;", "item", "", "personaltrackercore_release"}, k = 2, mv = {1, 1, 16})
/* compiled from: BindingHelper.kt */
public final class BindingHelperKt {
    @BindingAdapter({"bind:imageBitmap"})
    public static final void loadImage(ImageView imageView, Bitmap bitmap) {
        Intrinsics.checkParameterIsNotNull(imageView, "iv");
        Intrinsics.checkParameterIsNotNull(bitmap, "bitmap");
        imageView.setImageBitmap(bitmap);
    }

    @BindingAdapter({"adapter"})
    public static final void setAdapter(RecyclerView recyclerView, RecyclerView.Adapter<?> adapter) {
        Intrinsics.checkParameterIsNotNull(recyclerView, "rv");
        Intrinsics.checkParameterIsNotNull(adapter, "adapter");
        recyclerView.setAdapter(adapter);
    }

    @BindingAdapter({"last_char"})
    public static final void setLastChar(TextView textView, String str) {
        Intrinsics.checkParameterIsNotNull(textView, "tv");
        Intrinsics.checkParameterIsNotNull(str, "item");
        textView.setText(String.valueOf(str.charAt(0)));
    }
}
