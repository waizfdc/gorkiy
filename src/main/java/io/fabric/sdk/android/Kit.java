package io.fabric.sdk.android;

import android.content.Context;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.concurrency.DependsOn;
import io.fabric.sdk.android.services.concurrency.Task;
import java.io.File;
import java.util.Collection;

public abstract class Kit<Result> implements Comparable<Kit> {
    Context context;
    final DependsOn dependsOnAnnotation = ((DependsOn) getClass().getAnnotation(DependsOn.class));
    Fabric fabric;
    IdManager idManager;
    InitializationCallback<Result> initializationCallback;
    InitializationTask<Result> initializationTask = new InitializationTask<>(this);

    /* access modifiers changed from: protected */
    public abstract Result doInBackground();

    public abstract String getIdentifier();

    public abstract String getVersion();

    /* access modifiers changed from: protected */
    public void onCancelled(Result result) {
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(Result result) {
    }

    /* access modifiers changed from: protected */
    public boolean onPreExecute() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public void injectParameters(Context context2, Fabric fabric2, InitializationCallback<Result> initializationCallback2, IdManager idManager2) {
        this.fabric = fabric2;
        this.context = new FabricContext(context2, getIdentifier(), getPath());
        this.initializationCallback = initializationCallback2;
        this.idManager = idManager2;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: io.fabric.sdk.android.services.concurrency.PriorityAsyncTask.executeOnExecutor(java.util.concurrent.ExecutorService, java.lang.Object[]):void
     arg types: [java.util.concurrent.ExecutorService, java.lang.Void[]]
     candidates:
      io.fabric.sdk.android.services.concurrency.AsyncTask.executeOnExecutor(java.util.concurrent.Executor, java.lang.Object[]):io.fabric.sdk.android.services.concurrency.AsyncTask<Params, Progress, Result>
      io.fabric.sdk.android.services.concurrency.PriorityAsyncTask.executeOnExecutor(java.util.concurrent.ExecutorService, java.lang.Object[]):void */
    /* access modifiers changed from: package-private */
    public final void initialize() {
        this.initializationTask.executeOnExecutor(this.fabric.getExecutorService(), (Object[]) new Void[]{null});
    }

    /* access modifiers changed from: protected */
    public IdManager getIdManager() {
        return this.idManager;
    }

    public Context getContext() {
        return this.context;
    }

    public Fabric getFabric() {
        return this.fabric;
    }

    public String getPath() {
        return ".Fabric" + File.separator + getIdentifier();
    }

    public int compareTo(Kit kit) {
        if (containsAnnotatedDependency(kit)) {
            return 1;
        }
        if (kit.containsAnnotatedDependency(this)) {
            return -1;
        }
        if (hasAnnotatedDependency() && !kit.hasAnnotatedDependency()) {
            return 1;
        }
        if (hasAnnotatedDependency() || !kit.hasAnnotatedDependency()) {
            return 0;
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public boolean containsAnnotatedDependency(Kit kit) {
        if (hasAnnotatedDependency()) {
            for (Class<?> isAssignableFrom : this.dependsOnAnnotation.value()) {
                if (isAssignableFrom.isAssignableFrom(kit.getClass())) {
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean hasAnnotatedDependency() {
        return this.dependsOnAnnotation != null;
    }

    /* access modifiers changed from: protected */
    public Collection<Task> getDependencies() {
        return this.initializationTask.getDependencies();
    }
}
