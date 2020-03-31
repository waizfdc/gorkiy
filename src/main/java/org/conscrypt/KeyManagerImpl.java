package org.conscrypt;

import java.net.Socket;
import java.security.KeyStore;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.X509ExtendedKeyManager;

class KeyManagerImpl extends X509ExtendedKeyManager {
    private final HashMap<String, KeyStore.PrivateKeyEntry> hash = new HashMap<>();

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x002e */
    /* JADX WARNING: Removed duplicated region for block: B:4:? A[ExcHandler: KeyStoreException | NoSuchAlgorithmException | UnrecoverableEntryException (unused java.lang.Throwable), SYNTHETIC, Splitter:B:7:0x001c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    KeyManagerImpl(java.security.KeyStore r6, char[] r7) {
        /*
            r5 = this;
            r5.<init>()
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            r5.hash = r0
            java.util.Enumeration r0 = r6.aliases()     // Catch:{ KeyStoreException -> 0x0044 }
        L_0x000e:
            boolean r1 = r0.hasMoreElements()
            if (r1 == 0) goto L_0x0044
            java.lang.Object r1 = r0.nextElement()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Class<java.security.KeyStore$PrivateKeyEntry> r2 = java.security.KeyStore.PrivateKeyEntry.class
            boolean r2 = r6.entryInstanceOf(r1, r2)     // Catch:{ KeyStoreException | NoSuchAlgorithmException | UnrecoverableEntryException -> 0x000e }
            if (r2 == 0) goto L_0x000e
            java.security.KeyStore$PasswordProtection r2 = new java.security.KeyStore$PasswordProtection     // Catch:{ UnsupportedOperationException -> 0x002e, KeyStoreException | NoSuchAlgorithmException | UnrecoverableEntryException -> 0x000e, KeyStoreException | NoSuchAlgorithmException | UnrecoverableEntryException -> 0x000e }
            r2.<init>(r7)     // Catch:{ UnsupportedOperationException -> 0x002e, KeyStoreException | NoSuchAlgorithmException | UnrecoverableEntryException -> 0x000e, KeyStoreException | NoSuchAlgorithmException | UnrecoverableEntryException -> 0x000e }
            java.security.KeyStore$Entry r2 = r6.getEntry(r1, r2)     // Catch:{ UnsupportedOperationException -> 0x002e, KeyStoreException | NoSuchAlgorithmException | UnrecoverableEntryException -> 0x000e, KeyStoreException | NoSuchAlgorithmException | UnrecoverableEntryException -> 0x000e }
            java.security.KeyStore$PrivateKeyEntry r2 = (java.security.KeyStore.PrivateKeyEntry) r2     // Catch:{ UnsupportedOperationException -> 0x002e, KeyStoreException | NoSuchAlgorithmException | UnrecoverableEntryException -> 0x000e, KeyStoreException | NoSuchAlgorithmException | UnrecoverableEntryException -> 0x000e }
            goto L_0x003e
        L_0x002e:
            java.security.Key r2 = r6.getKey(r1, r7)     // Catch:{ KeyStoreException | NoSuchAlgorithmException | UnrecoverableEntryException -> 0x000e }
            java.security.PrivateKey r2 = (java.security.PrivateKey) r2     // Catch:{ KeyStoreException | NoSuchAlgorithmException | UnrecoverableEntryException -> 0x000e }
            java.security.cert.Certificate[] r3 = r6.getCertificateChain(r1)     // Catch:{ KeyStoreException | NoSuchAlgorithmException | UnrecoverableEntryException -> 0x000e }
            java.security.KeyStore$PrivateKeyEntry r4 = new java.security.KeyStore$PrivateKeyEntry     // Catch:{ KeyStoreException | NoSuchAlgorithmException | UnrecoverableEntryException -> 0x000e }
            r4.<init>(r2, r3)     // Catch:{ KeyStoreException | NoSuchAlgorithmException | UnrecoverableEntryException -> 0x000e }
            r2 = r4
        L_0x003e:
            java.util.HashMap<java.lang.String, java.security.KeyStore$PrivateKeyEntry> r3 = r5.hash     // Catch:{ KeyStoreException | NoSuchAlgorithmException | UnrecoverableEntryException -> 0x000e }
            r3.put(r1, r2)     // Catch:{ KeyStoreException | NoSuchAlgorithmException | UnrecoverableEntryException -> 0x000e }
            goto L_0x000e
        L_0x0044:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.conscrypt.KeyManagerImpl.<init>(java.security.KeyStore, char[]):void");
    }

    public String chooseClientAlias(String[] strArr, Principal[] principalArr, Socket socket) {
        String[] chooseAlias = chooseAlias(strArr, principalArr);
        if (chooseAlias == null) {
            return null;
        }
        return chooseAlias[0];
    }

    public String chooseServerAlias(String str, Principal[] principalArr, Socket socket) {
        String[] chooseAlias = chooseAlias(new String[]{str}, principalArr);
        if (chooseAlias == null) {
            return null;
        }
        return chooseAlias[0];
    }

    public X509Certificate[] getCertificateChain(String str) {
        X509Certificate[] x509CertificateArr = null;
        if (str == null) {
            return null;
        }
        if (this.hash.containsKey(str)) {
            Certificate[] certificateChain = this.hash.get(str).getCertificateChain();
            if (certificateChain[0] instanceof X509Certificate) {
                x509CertificateArr = new X509Certificate[certificateChain.length];
                for (int i = 0; i < certificateChain.length; i++) {
                    x509CertificateArr[i] = (X509Certificate) certificateChain[i];
                }
            }
        }
        return x509CertificateArr;
    }

    public String[] getClientAliases(String str, Principal[] principalArr) {
        return chooseAlias(new String[]{str}, principalArr);
    }

    public String[] getServerAliases(String str, Principal[] principalArr) {
        return chooseAlias(new String[]{str}, principalArr);
    }

    public PrivateKey getPrivateKey(String str) {
        if (str != null && this.hash.containsKey(str)) {
            return this.hash.get(str).getPrivateKey();
        }
        return null;
    }

    public String chooseEngineClientAlias(String[] strArr, Principal[] principalArr, SSLEngine sSLEngine) {
        String[] chooseAlias = chooseAlias(strArr, principalArr);
        if (chooseAlias == null) {
            return null;
        }
        return chooseAlias[0];
    }

    public String chooseEngineServerAlias(String str, Principal[] principalArr, SSLEngine sSLEngine) {
        String[] chooseAlias = chooseAlias(new String[]{str}, principalArr);
        if (chooseAlias == null) {
            return null;
        }
        return chooseAlias[0];
    }

    private String[] chooseAlias(String[] strArr, Principal[] principalArr) {
        List list;
        String str;
        String[] strArr2 = strArr;
        Principal[] principalArr2 = principalArr;
        if (strArr2 == null || strArr2.length == 0) {
            return null;
        }
        if (principalArr2 == null) {
            list = null;
        } else {
            list = Arrays.asList(principalArr);
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry next : this.hash.entrySet()) {
            String str2 = (String) next.getKey();
            Certificate[] certificateChain = ((KeyStore.PrivateKeyEntry) next.getValue()).getCertificateChain();
            int i = 0;
            Certificate certificate = certificateChain[0];
            String algorithm = certificate.getPublicKey().getAlgorithm();
            String upperCase = certificate instanceof X509Certificate ? ((X509Certificate) certificate).getSigAlgName().toUpperCase(Locale.US) : null;
            int length = strArr2.length;
            int i2 = 0;
            while (i2 < length) {
                String str3 = strArr2[i2];
                if (str3 != null) {
                    int indexOf = str3.indexOf(95);
                    if (indexOf == -1) {
                        str = null;
                    } else {
                        str = str3.substring(indexOf + 1);
                        str3 = str3.substring(i, indexOf);
                    }
                    if (algorithm.equals(str3) && (str == null || upperCase == null || upperCase.contains(str))) {
                        if (principalArr2 == null || principalArr2.length == 0) {
                            arrayList.add(str2);
                        } else {
                            int length2 = certificateChain.length;
                            for (int i3 = i; i3 < length2; i3++) {
                                Certificate certificate2 = certificateChain[i3];
                                if ((certificate2 instanceof X509Certificate) && list.contains(((X509Certificate) certificate2).getIssuerX500Principal())) {
                                    arrayList.add(str2);
                                }
                            }
                        }
                    }
                }
                i2++;
                i = 0;
            }
        }
        if (!arrayList.isEmpty()) {
            return (String[]) arrayList.toArray(new String[arrayList.size()]);
        }
        return null;
    }
}
