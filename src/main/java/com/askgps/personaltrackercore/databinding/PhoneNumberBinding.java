package com.askgps.personaltrackercore.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.askgps.personaltrackercore.R;
import com.askgps.personaltrackercore.database.model.PhoneNumber;

public abstract class PhoneNumberBinding extends ViewDataBinding {
    @Bindable
    protected PhoneNumber mPhoneNumber;

    public abstract void setPhoneNumber(PhoneNumber phoneNumber);

    protected PhoneNumberBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public PhoneNumber getPhoneNumber() {
        return this.mPhoneNumber;
    }

    public static PhoneNumberBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PhoneNumberBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PhoneNumberBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.phone_number, viewGroup, z, obj);
    }

    public static PhoneNumberBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PhoneNumberBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PhoneNumberBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.phone_number, null, false, obj);
    }

    public static PhoneNumberBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PhoneNumberBinding bind(View view, Object obj) {
        return (PhoneNumberBinding) bind(obj, view, R.layout.phone_number);
    }
}
