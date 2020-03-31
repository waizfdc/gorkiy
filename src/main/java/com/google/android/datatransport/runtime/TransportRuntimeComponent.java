package com.google.android.datatransport.runtime;

import android.content.Context;
import com.google.android.datatransport.runtime.backends.BackendRegistryModule;
import com.google.android.datatransport.runtime.scheduling.SchedulingConfigModule;
import com.google.android.datatransport.runtime.scheduling.SchedulingModule;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule;
import com.google.android.datatransport.runtime.time.TimeModule;
import dagger.BindsInstance;
import dagger.Component;
import java.io.Closeable;
import java.io.IOException;
import javax.inject.Singleton;

@Singleton
@Component(modules = {BackendRegistryModule.class, EventStoreModule.class, ExecutionModule.class, SchedulingModule.class, SchedulingConfigModule.class, TimeModule.class})
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
abstract class TransportRuntimeComponent implements Closeable {

    @Component.Builder
    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
    interface Builder {
        TransportRuntimeComponent build();

        @BindsInstance
        Builder setApplicationContext(Context context);
    }

    /* access modifiers changed from: package-private */
    public abstract EventStore getEventStore();

    /* access modifiers changed from: package-private */
    public abstract TransportRuntime getTransportRuntime();

    TransportRuntimeComponent() {
    }

    public void close() throws IOException {
        getEventStore().close();
    }
}
