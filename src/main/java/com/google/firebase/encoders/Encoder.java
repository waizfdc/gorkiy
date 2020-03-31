package com.google.firebase.encoders;

import java.io.IOException;

/* compiled from: com.google.firebase:firebase-encoders-json@@16.0.0 */
interface Encoder<TValue, TContext> {
    void encode(Object obj, Object obj2) throws EncodingException, IOException;
}
