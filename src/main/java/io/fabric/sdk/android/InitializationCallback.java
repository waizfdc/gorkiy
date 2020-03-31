package io.fabric.sdk.android;

public interface InitializationCallback<T> {
    public static final InitializationCallback EMPTY = new Empty();

    void failure(Exception exc);

    void success(T t);

    public static class Empty implements InitializationCallback<Object> {
        public void failure(Exception exc) {
        }

        public void success(Object obj) {
        }

        private Empty() {
        }
    }
}
