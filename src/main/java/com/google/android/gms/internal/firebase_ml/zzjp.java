package com.google.android.gms.internal.firebase_ml;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public @interface zzjp {
    String value() default "##default";
}
