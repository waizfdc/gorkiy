package androidx.customview.view;

import android.os.Parcel;
import android.os.Parcelable;

public abstract class AbsSavedState implements Parcelable {
    public static final Parcelable.Creator<AbsSavedState> CREATOR = new Parcelable.ClassLoaderCreator<AbsSavedState>() {
        /* class androidx.customview.view.AbsSavedState.AnonymousClass2 */

        public AbsSavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) == null) {
                return AbsSavedState.EMPTY_STATE;
            }
            throw new IllegalStateException("superState must be null");
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: androidx.customview.view.AbsSavedState.2.createFromParcel(android.os.Parcel, java.lang.ClassLoader):androidx.customview.view.AbsSavedState
         arg types: [android.os.Parcel, ?[OBJECT, ARRAY]]
         candidates:
          androidx.customview.view.AbsSavedState.2.createFromParcel(android.os.Parcel, java.lang.ClassLoader):java.lang.Object
          ClspMth{android.os.Parcelable.ClassLoaderCreator.createFromParcel(android.os.Parcel, java.lang.ClassLoader):T}
          androidx.customview.view.AbsSavedState.2.createFromParcel(android.os.Parcel, java.lang.ClassLoader):androidx.customview.view.AbsSavedState */
        public AbsSavedState createFromParcel(Parcel parcel) {
            return createFromParcel(parcel, (ClassLoader) null);
        }

        public AbsSavedState[] newArray(int i) {
            return new AbsSavedState[i];
        }
    };
    public static final AbsSavedState EMPTY_STATE = new AbsSavedState() {
        /* class androidx.customview.view.AbsSavedState.AnonymousClass1 */
    };
    private final Parcelable mSuperState;

    public int describeContents() {
        return 0;
    }

    private AbsSavedState() {
        this.mSuperState = null;
    }

    protected AbsSavedState(Parcelable parcelable) {
        if (parcelable != null) {
            this.mSuperState = parcelable == EMPTY_STATE ? null : parcelable;
            return;
        }
        throw new IllegalArgumentException("superState must not be null");
    }

    protected AbsSavedState(Parcel parcel) {
        this(parcel, null);
    }

    protected AbsSavedState(Parcel parcel, ClassLoader classLoader) {
        Parcelable readParcelable = parcel.readParcelable(classLoader);
        this.mSuperState = readParcelable == null ? EMPTY_STATE : readParcelable;
    }

    public final Parcelable getSuperState() {
        return this.mSuperState;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mSuperState, i);
    }
}
