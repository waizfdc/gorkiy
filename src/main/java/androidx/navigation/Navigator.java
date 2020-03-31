package androidx.navigation;

import android.os.Bundle;
import androidx.navigation.NavDestination;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class Navigator<D extends NavDestination> {
    private final CopyOnWriteArrayList<OnNavigatorBackPressListener> mOnBackPressListeners = new CopyOnWriteArrayList<>();

    public interface Extras {
    }

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Name {
        String value();
    }

    public interface OnNavigatorBackPressListener {
        void onPopBackStack(Navigator navigator);
    }

    public abstract D createDestination();

    public abstract NavDestination navigate(NavDestination navDestination, Bundle bundle, NavOptions navOptions, Extras extras);

    /* access modifiers changed from: protected */
    public void onBackPressAdded() {
    }

    /* access modifiers changed from: protected */
    public void onBackPressRemoved() {
    }

    public void onRestoreState(Bundle bundle) {
    }

    public Bundle onSaveState() {
        return null;
    }

    public abstract boolean popBackStack();

    public final void addOnNavigatorBackPressListener(OnNavigatorBackPressListener onNavigatorBackPressListener) {
        if (this.mOnBackPressListeners.add(onNavigatorBackPressListener) && this.mOnBackPressListeners.size() == 1) {
            onBackPressAdded();
        }
    }

    public final void removeOnNavigatorBackPressListener(OnNavigatorBackPressListener onNavigatorBackPressListener) {
        if (this.mOnBackPressListeners.remove(onNavigatorBackPressListener) && this.mOnBackPressListeners.isEmpty()) {
            onBackPressRemoved();
        }
    }

    public final void dispatchOnNavigatorBackPress() {
        Iterator<OnNavigatorBackPressListener> it = this.mOnBackPressListeners.iterator();
        while (it.hasNext()) {
            it.next().onPopBackStack(this);
        }
    }
}
