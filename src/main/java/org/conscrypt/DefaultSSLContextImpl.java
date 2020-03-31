package org.conscrypt;

import java.security.KeyManagementException;
import java.security.SecureRandom;
import javax.net.ssl.KeyManager;
import javax.net.ssl.TrustManager;

public final class DefaultSSLContextImpl extends OpenSSLContextImpl {
    private static KeyManager[] KEY_MANAGERS;
    private static TrustManager[] TRUST_MANAGERS;

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x004d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public javax.net.ssl.KeyManager[] getKeyManagers() throws java.security.GeneralSecurityException, java.io.IOException {
        /*
            r6 = this;
            javax.net.ssl.KeyManager[] r0 = org.conscrypt.DefaultSSLContextImpl.KEY_MANAGERS
            if (r0 == 0) goto L_0x0005
            return r0
        L_0x0005:
            java.lang.String r0 = "javax.net.ssl.keyStore"
            java.lang.String r0 = java.lang.System.getProperty(r0)
            r1 = 0
            if (r0 != 0) goto L_0x000f
            return r1
        L_0x000f:
            java.lang.String r2 = "javax.net.ssl.keyStorePassword"
            java.lang.String r2 = java.lang.System.getProperty(r2)
            if (r2 != 0) goto L_0x0019
            r2 = r1
            goto L_0x001d
        L_0x0019:
            char[] r2 = r2.toCharArray()
        L_0x001d:
            java.lang.String r3 = java.security.KeyStore.getDefaultType()
            java.security.KeyStore r3 = java.security.KeyStore.getInstance(r3)
            java.io.BufferedInputStream r4 = new java.io.BufferedInputStream     // Catch:{ all -> 0x004a }
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ all -> 0x004a }
            r5.<init>(r0)     // Catch:{ all -> 0x004a }
            r4.<init>(r5)     // Catch:{ all -> 0x004a }
            r3.load(r4, r2)     // Catch:{ all -> 0x0047 }
            r4.close()
            java.lang.String r0 = javax.net.ssl.KeyManagerFactory.getDefaultAlgorithm()
            javax.net.ssl.KeyManagerFactory r0 = javax.net.ssl.KeyManagerFactory.getInstance(r0)
            r0.init(r3, r2)
            javax.net.ssl.KeyManager[] r0 = r0.getKeyManagers()
            org.conscrypt.DefaultSSLContextImpl.KEY_MANAGERS = r0
            return r0
        L_0x0047:
            r0 = move-exception
            r1 = r4
            goto L_0x004b
        L_0x004a:
            r0 = move-exception
        L_0x004b:
            if (r1 == 0) goto L_0x0050
            r1.close()
        L_0x0050:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.conscrypt.DefaultSSLContextImpl.getKeyManagers():javax.net.ssl.KeyManager[]");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x004d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public javax.net.ssl.TrustManager[] getTrustManagers() throws java.security.GeneralSecurityException, java.io.IOException {
        /*
            r6 = this;
            javax.net.ssl.TrustManager[] r0 = org.conscrypt.DefaultSSLContextImpl.TRUST_MANAGERS
            if (r0 == 0) goto L_0x0005
            return r0
        L_0x0005:
            java.lang.String r0 = "javax.net.ssl.trustStore"
            java.lang.String r0 = java.lang.System.getProperty(r0)
            r1 = 0
            if (r0 != 0) goto L_0x000f
            return r1
        L_0x000f:
            java.lang.String r2 = "javax.net.ssl.trustStorePassword"
            java.lang.String r2 = java.lang.System.getProperty(r2)
            if (r2 != 0) goto L_0x0019
            r2 = r1
            goto L_0x001d
        L_0x0019:
            char[] r2 = r2.toCharArray()
        L_0x001d:
            java.lang.String r3 = java.security.KeyStore.getDefaultType()
            java.security.KeyStore r3 = java.security.KeyStore.getInstance(r3)
            java.io.BufferedInputStream r4 = new java.io.BufferedInputStream     // Catch:{ all -> 0x004a }
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ all -> 0x004a }
            r5.<init>(r0)     // Catch:{ all -> 0x004a }
            r4.<init>(r5)     // Catch:{ all -> 0x004a }
            r3.load(r4, r2)     // Catch:{ all -> 0x0047 }
            r4.close()
            java.lang.String r0 = javax.net.ssl.TrustManagerFactory.getDefaultAlgorithm()
            javax.net.ssl.TrustManagerFactory r0 = javax.net.ssl.TrustManagerFactory.getInstance(r0)
            r0.init(r3)
            javax.net.ssl.TrustManager[] r0 = r0.getTrustManagers()
            org.conscrypt.DefaultSSLContextImpl.TRUST_MANAGERS = r0
            return r0
        L_0x0047:
            r0 = move-exception
            r1 = r4
            goto L_0x004b
        L_0x004a:
            r0 = move-exception
        L_0x004b:
            if (r1 == 0) goto L_0x0050
            r1.close()
        L_0x0050:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.conscrypt.DefaultSSLContextImpl.getTrustManagers():javax.net.ssl.TrustManager[]");
    }

    public void engineInit(KeyManager[] keyManagerArr, TrustManager[] trustManagerArr, SecureRandom secureRandom) throws KeyManagementException {
        throw new KeyManagementException("Do not init() the default SSLContext ");
    }
}
