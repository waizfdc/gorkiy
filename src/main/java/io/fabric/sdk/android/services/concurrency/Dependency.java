package io.fabric.sdk.android.services.concurrency;

import java.util.Collection;

public interface Dependency<T> {
    void addDependency(Object obj);

    boolean areDependenciesMet();

    Collection<T> getDependencies();
}
