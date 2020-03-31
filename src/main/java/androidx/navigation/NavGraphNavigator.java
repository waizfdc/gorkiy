package androidx.navigation;

import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import androidx.navigation.Navigator;
import java.util.ArrayDeque;
import java.util.Iterator;

@Navigator.Name(NotificationCompat.CATEGORY_NAVIGATION)
public class NavGraphNavigator extends Navigator<NavGraph> {
    private static final String KEY_BACK_STACK_IDS = "androidx-nav-graph:navigator:backStackIds";
    private ArrayDeque<Integer> mBackStack = new ArrayDeque<>();
    private final NavigatorProvider mNavigatorProvider;

    public NavGraphNavigator(NavigatorProvider navigatorProvider) {
        this.mNavigatorProvider = navigatorProvider;
    }

    public NavGraph createDestination() {
        return new NavGraph(super);
    }

    public NavDestination navigate(NavGraph navGraph, Bundle bundle, NavOptions navOptions, Navigator.Extras extras) {
        int startDestination = navGraph.getStartDestination();
        if (startDestination != 0) {
            NavDestination findNode = navGraph.findNode(startDestination, false);
            if (findNode != null) {
                if (navOptions == null || !navOptions.shouldLaunchSingleTop() || !isAlreadyTop(navGraph)) {
                    this.mBackStack.add(Integer.valueOf(navGraph.getId()));
                }
                return this.mNavigatorProvider.getNavigator(findNode.getNavigatorName()).navigate(findNode, findNode.addInDefaultArgs(bundle), navOptions, extras);
            }
            String startDestDisplayName = navGraph.getStartDestDisplayName();
            throw new IllegalArgumentException("navigation destination " + startDestDisplayName + " is not a direct child of this NavGraph");
        }
        throw new IllegalStateException("no start destination defined via app:startDestination for " + navGraph.getDisplayName());
    }

    private boolean isAlreadyTop(NavGraph navGraph) {
        if (this.mBackStack.isEmpty()) {
            return false;
        }
        int intValue = this.mBackStack.peekLast().intValue();
        while (navGraph.getId() != intValue) {
            NavDestination findNode = navGraph.findNode(navGraph.getStartDestination());
            if (!(findNode instanceof NavGraph)) {
                return false;
            }
            navGraph = (NavGraph) findNode;
        }
        return true;
    }

    public boolean popBackStack() {
        return this.mBackStack.pollLast() != null;
    }

    public Bundle onSaveState() {
        Bundle bundle = new Bundle();
        int[] iArr = new int[this.mBackStack.size()];
        Iterator<Integer> it = this.mBackStack.iterator();
        int i = 0;
        while (it.hasNext()) {
            iArr[i] = it.next().intValue();
            i++;
        }
        bundle.putIntArray(KEY_BACK_STACK_IDS, iArr);
        return bundle;
    }

    public void onRestoreState(Bundle bundle) {
        int[] intArray;
        if (bundle != null && (intArray = bundle.getIntArray(KEY_BACK_STACK_IDS)) != null) {
            this.mBackStack.clear();
            for (int valueOf : intArray) {
                this.mBackStack.add(Integer.valueOf(valueOf));
            }
        }
    }
}
