package com.askgps.personaltrackercore.databinding;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.askgps.personaltrackercore.R;

public abstract class QrDialogFragmentBinding extends ViewDataBinding {
    @Bindable
    protected Bitmap mQr;
    public final AppCompatImageView qrDialogImgQr;

    public abstract void setQr(Bitmap bitmap);

    protected QrDialogFragmentBinding(Object obj, View view, int i, AppCompatImageView appCompatImageView) {
        super(obj, view, i);
        this.qrDialogImgQr = appCompatImageView;
    }

    public Bitmap getQr() {
        return this.mQr;
    }

    public static QrDialogFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static QrDialogFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (QrDialogFragmentBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.qr_dialog_fragment, viewGroup, z, obj);
    }

    public static QrDialogFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static QrDialogFragmentBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (QrDialogFragmentBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.qr_dialog_fragment, null, false, obj);
    }

    public static QrDialogFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static QrDialogFragmentBinding bind(View view, Object obj) {
        return (QrDialogFragmentBinding) bind(obj, view, R.layout.qr_dialog_fragment);
    }
}
