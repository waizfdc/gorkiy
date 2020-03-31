package com.askgps.personaltrackercore.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.askgps.personaltrackercore.BR;
import com.askgps.personaltrackercore.binding.BindingHelperKt;
import com.askgps.personaltrackercore.database.model.PhoneNumber;
import com.google.android.material.textview.MaterialTextView;

public class PhoneNumberBindingImpl extends PhoneNumberBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    private final MaterialTextView mboundView1;
    private final MaterialTextView mboundView2;
    private final MaterialTextView mboundView3;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public PhoneNumberBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 4, sIncludes, sViewsWithIds));
    }

    private PhoneNumberBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.mDirtyFlags = -1;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        MaterialTextView materialTextView = (MaterialTextView) objArr[1];
        this.mboundView1 = materialTextView;
        materialTextView.setTag(null);
        MaterialTextView materialTextView2 = (MaterialTextView) objArr[2];
        this.mboundView2 = materialTextView2;
        materialTextView2.setTag(null);
        MaterialTextView materialTextView3 = (MaterialTextView) objArr[3];
        this.mboundView3 = materialTextView3;
        materialTextView3.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (BR.phoneNumber != i) {
            return false;
        }
        setPhoneNumber((PhoneNumber) obj);
        return true;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.mPhoneNumber = phoneNumber;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.phoneNumber);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        String str;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        PhoneNumber phoneNumber = this.mPhoneNumber;
        int i = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        String str2 = null;
        if (i == 0 || phoneNumber == null) {
            str = null;
        } else {
            str2 = phoneNumber.getName();
            str = phoneNumber.getNumber();
        }
        if (i != 0) {
            BindingHelperKt.setLastChar(this.mboundView1, str2);
            TextViewBindingAdapter.setText(this.mboundView2, str2);
            TextViewBindingAdapter.setText(this.mboundView3, str);
        }
    }
}
