package com.google.firebase.installations;

import com.google.firebase.FirebaseException;

/* compiled from: com.google.firebase:firebase-installations@@16.0.0 */
public class FirebaseInstallationsException extends FirebaseException {
    private final Status status;

    /* compiled from: com.google.firebase:firebase-installations@@16.0.0 */
    public enum Status {
        BAD_CONFIG
    }

    public FirebaseInstallationsException(Status status2) {
        this.status = status2;
    }

    public FirebaseInstallationsException(String str, Status status2) {
        super(str);
        this.status = status2;
    }

    public FirebaseInstallationsException(String str, Status status2, Throwable th) {
        super(str, th);
        this.status = status2;
    }

    public Status getStatus() {
        return this.status;
    }
}
