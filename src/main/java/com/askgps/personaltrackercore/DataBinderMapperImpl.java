package com.askgps.personaltrackercore;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.askgps.personaltrackercore.databinding.PhoneBookFragmentBindingImpl;
import com.askgps.personaltrackercore.databinding.PhoneNumberBindingImpl;
import com.askgps.personaltrackercore.databinding.QrDialogFragmentBindingImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
    private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP;
    private static final int LAYOUT_PHONEBOOKFRAGMENT = 1;
    private static final int LAYOUT_PHONENUMBER = 2;
    private static final int LAYOUT_QRDIALOGFRAGMENT = 3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(3);
        INTERNAL_LAYOUT_ID_LOOKUP = sparseIntArray;
        sparseIntArray.put(R.layout.phone_book_fragment, 1);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.phone_number, 2);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.qr_dialog_fragment, 3);
    }

    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i) {
        int i2 = INTERNAL_LAYOUT_ID_LOOKUP.get(i);
        if (i2 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag == null) {
            throw new RuntimeException("view must have a tag");
        } else if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    return null;
                }
                if ("layout/qr_dialog_fragment_0".equals(tag)) {
                    return new QrDialogFragmentBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for qr_dialog_fragment is invalid. Received: " + tag);
            } else if ("layout/phone_number_0".equals(tag)) {
                return new PhoneNumberBindingImpl(dataBindingComponent, view);
            } else {
                throw new IllegalArgumentException("The tag for phone_number is invalid. Received: " + tag);
            }
        } else if ("layout/phone_book_fragment_0".equals(tag)) {
            return new PhoneBookFragmentBindingImpl(dataBindingComponent, view);
        } else {
            throw new IllegalArgumentException("The tag for phone_book_fragment is invalid. Received: " + tag);
        }
    }

    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View[] viewArr, int i) {
        if (viewArr == null || viewArr.length == 0 || INTERNAL_LAYOUT_ID_LOOKUP.get(i) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = InnerLayoutIdLookup.sKeys.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    public String convertBrIdToString(int i) {
        return InnerBrLookup.sKeys.get(i);
    }

    public List<DataBinderMapper> collectDependencies() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        return arrayList;
    }

    private static class InnerBrLookup {
        static final SparseArray<String> sKeys;

        private InnerBrLookup() {
        }

        static {
            SparseArray<String> sparseArray = new SparseArray<>(4);
            sKeys = sparseArray;
            sparseArray.put(0, "_all");
            sKeys.put(1, "phoneNumber");
            sKeys.put(2, "qr");
            sKeys.put(3, "vm");
        }
    }

    private static class InnerLayoutIdLookup {
        static final HashMap<String, Integer> sKeys;

        private InnerLayoutIdLookup() {
        }

        static {
            HashMap<String, Integer> hashMap = new HashMap<>(3);
            sKeys = hashMap;
            hashMap.put("layout/phone_book_fragment_0", Integer.valueOf(R.layout.phone_book_fragment));
            sKeys.put("layout/phone_number_0", Integer.valueOf(R.layout.phone_number));
            sKeys.put("layout/qr_dialog_fragment_0", Integer.valueOf(R.layout.qr_dialog_fragment));
        }
    }
}
