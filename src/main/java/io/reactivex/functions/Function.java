package io.reactivex.functions;

public interface Function<T, R> {
    R apply(Object obj) throws Exception;
}
