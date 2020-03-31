package androidx.navigation;

import android.os.Bundle;

final class NavBackStackEntry {
    private final Bundle mArgs;
    private final NavDestination mDestination;

    NavBackStackEntry(NavDestination navDestination, Bundle bundle) {
        this.mDestination = navDestination;
        this.mArgs = bundle;
    }

    public NavDestination getDestination() {
        return this.mDestination;
    }

    public Bundle getArguments() {
        return this.mArgs;
    }
}
