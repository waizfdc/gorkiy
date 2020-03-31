package io.fabric.sdk.android.services.events;

import java.io.IOException;

public interface EventTransform<T> {
    byte[] toBytes(Object obj) throws IOException;
}
