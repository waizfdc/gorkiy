package com.google.firebase.installations;

/* compiled from: com.google.firebase:firebase-installations@@16.0.0 */
final /* synthetic */ class FirebaseInstallations$$Lambda$3 implements Runnable {
    private final FirebaseInstallations arg$1;

    private FirebaseInstallations$$Lambda$3(FirebaseInstallations firebaseInstallations) {
        this.arg$1 = firebaseInstallations;
    }

    public static Runnable lambdaFactory$(FirebaseInstallations firebaseInstallations) {
        return new FirebaseInstallations$$Lambda$3(firebaseInstallations);
    }

    public void run() {
        this.arg$1.doGetAuthTokenWithoutForceRefresh();
    }
}
