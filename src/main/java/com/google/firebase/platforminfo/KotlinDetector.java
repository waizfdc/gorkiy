package com.google.firebase.platforminfo;

import kotlin.KotlinVersion;

/* compiled from: com.google.firebase:firebase-common@@19.3.0 */
public final class KotlinDetector {
    private KotlinDetector() {
    }

    public static String detectVersion() {
        try {
            return KotlinVersion.CURRENT.toString();
        } catch (NoClassDefFoundError unused) {
            return null;
        }
    }
}
