package com.google.firebase.encoders.config;

import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.config.EncoderConfig;

/* compiled from: com.google.firebase:firebase-encoders-json@@16.0.0 */
public interface EncoderConfig<T extends EncoderConfig<T>> {
    <U> T registerEncoder(Class cls, ObjectEncoder objectEncoder);

    <U> T registerEncoder(Class cls, ValueEncoder valueEncoder);
}
