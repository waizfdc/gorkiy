package com.google.firebase.events;

/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
public interface EventHandler<T> {
    void handle(Event<T> event);
}
