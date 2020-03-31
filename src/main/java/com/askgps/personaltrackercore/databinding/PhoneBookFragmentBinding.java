package com.askgps.personaltrackercore.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatButton;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.askgps.personaltrackercore.R;
import com.askgps.personaltrackercore.ui.phonebook.PhoneBookViewModel;

public abstract class PhoneBookFragmentBinding extends ViewDataBinding {
    @Bindable
    protected PhoneBookViewModel mVm;
    public final AppCompatButton phoneBookBtnAdd;
    public final RecyclerView recyclerView;

    public abstract void setVm(PhoneBookViewModel phoneBookViewModel);

    protected PhoneBookFragmentBinding(Object obj, View view, int i, AppCompatButton appCompatButton, RecyclerView recyclerView2) {
        super(obj, view, i);
        this.phoneBookBtnAdd = appCompatButton;
        this.recyclerView = recyclerView2;
    }

    public PhoneBookViewModel getVm() {
        return this.mVm;
    }

    public static PhoneBookFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PhoneBookFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PhoneBookFragmentBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.phone_book_fragment, viewGroup, z, obj);
    }

    public static PhoneBookFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PhoneBookFragmentBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PhoneBookFragmentBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.phone_book_fragment, null, false, obj);
    }

    public static PhoneBookFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PhoneBookFragmentBinding bind(View view, Object obj) {
        return (PhoneBookFragmentBinding) bind(obj, view, R.layout.phone_book_fragment);
    }
}
