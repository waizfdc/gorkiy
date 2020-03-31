package org.conscrypt;

import java.security.PrivateKey;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.logging.Logger;

final class CryptoUpcalls {
    private static final Logger logger = Logger.getLogger(CryptoUpcalls.class.getName());

    private CryptoUpcalls() {
    }

    private static ArrayList<Provider> getExternalProviders(String str) {
        ArrayList<Provider> arrayList = new ArrayList<>(1);
        for (Provider provider : Security.getProviders(str)) {
            if (!Conscrypt.isConscrypt(provider)) {
                arrayList.add(provider);
            }
        }
        if (arrayList.isEmpty()) {
            logger.warning("Could not find external provider for algorithm: " + str);
        }
        return arrayList;
    }

    static byte[] ecSignDigestWithPrivateKey(PrivateKey privateKey, byte[] bArr) {
        if ("EC".equals(privateKey.getAlgorithm())) {
            return signDigestWithPrivateKey(privateKey, bArr, "NONEwithECDSA");
        }
        throw new RuntimeException("Unexpected key type: " + privateKey.toString());
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Throwable):void}
     arg types: [java.util.logging.Level, java.lang.String, java.lang.Exception]
     candidates:
      ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.Throwable, java.util.function.Supplier<java.lang.String>):void}
      ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Object[]):void}
      ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Object):void}
      ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Throwable):void} */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0010, code lost:
        if (org.conscrypt.Conscrypt.isConscrypt(r1.getProvider()) != false) goto L_0x001e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static byte[] signDigestWithPrivateKey(java.security.PrivateKey r5, byte[] r6, java.lang.String r7) {
        /*
            r0 = 0
            java.security.Signature r1 = java.security.Signature.getInstance(r7)     // Catch:{ NoSuchAlgorithmException -> 0x009c, InvalidKeyException -> 0x0013 }
            r1.initSign(r5)     // Catch:{ NoSuchAlgorithmException -> 0x009c, InvalidKeyException -> 0x0013 }
            java.security.Provider r2 = r1.getProvider()     // Catch:{ NoSuchAlgorithmException -> 0x009c, InvalidKeyException -> 0x0013 }
            boolean r2 = org.conscrypt.Conscrypt.isConscrypt(r2)     // Catch:{ NoSuchAlgorithmException -> 0x009c, InvalidKeyException -> 0x0013 }
            if (r2 == 0) goto L_0x001f
            goto L_0x001e
        L_0x0013:
            r1 = move-exception
            java.util.logging.Logger r2 = org.conscrypt.CryptoUpcalls.logger
            java.lang.String r3 = "Preferred provider doesn't support key:"
            r2.warning(r3)
            r1.printStackTrace()
        L_0x001e:
            r1 = r0
        L_0x001f:
            if (r1 != 0) goto L_0x0071
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Signature."
            r2.append(r3)
            r2.append(r7)
            java.lang.String r2 = r2.toString()
            java.util.ArrayList r2 = getExternalProviders(r2)
            java.util.Iterator r2 = r2.iterator()
            r3 = r0
        L_0x003b:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x0055
            java.lang.Object r1 = r2.next()
            java.security.Provider r1 = (java.security.Provider) r1
            java.security.Signature r1 = java.security.Signature.getInstance(r7, r1)     // Catch:{ InvalidKeyException | NoSuchAlgorithmException -> 0x0053, RuntimeException -> 0x004f }
            r1.initSign(r5)     // Catch:{ InvalidKeyException | NoSuchAlgorithmException -> 0x0053, RuntimeException -> 0x004f }
            goto L_0x0055
        L_0x004f:
            r1 = move-exception
            if (r3 != 0) goto L_0x0053
            r3 = r1
        L_0x0053:
            r1 = r0
            goto L_0x003b
        L_0x0055:
            if (r1 != 0) goto L_0x0071
            if (r3 != 0) goto L_0x0070
            java.util.logging.Logger r5 = org.conscrypt.CryptoUpcalls.logger
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r1 = "Could not find provider for algorithm: "
            r6.append(r1)
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            r5.warning(r6)
            return r0
        L_0x0070:
            throw r3
        L_0x0071:
            r1.update(r6)     // Catch:{ Exception -> 0x0079 }
            byte[] r5 = r1.sign()     // Catch:{ Exception -> 0x0079 }
            return r5
        L_0x0079:
            r6 = move-exception
            java.util.logging.Logger r7 = org.conscrypt.CryptoUpcalls.logger
            java.util.logging.Level r1 = java.util.logging.Level.WARNING
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Exception while signing message with "
            r2.append(r3)
            java.lang.String r5 = r5.getAlgorithm()
            r2.append(r5)
            java.lang.String r5 = " private key:"
            r2.append(r5)
            java.lang.String r5 = r2.toString()
            r7.log(r1, r5, r6)
            return r0
        L_0x009c:
            java.util.logging.Logger r5 = org.conscrypt.CryptoUpcalls.logger
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r1 = "Unsupported signature algorithm: "
            r6.append(r1)
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            r5.warning(r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.conscrypt.CryptoUpcalls.signDigestWithPrivateKey(java.security.PrivateKey, byte[], java.lang.String):byte[]");
    }

    static byte[] rsaSignDigestWithPrivateKey(PrivateKey privateKey, int i, byte[] bArr) {
        return rsaOpWithPrivateKey(privateKey, i, 1, bArr);
    }

    static byte[] rsaDecryptWithPrivateKey(PrivateKey privateKey, int i, byte[] bArr) {
        return rsaOpWithPrivateKey(privateKey, i, 2, bArr);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Throwable):void}
     arg types: [java.util.logging.Level, java.lang.String, java.security.InvalidKeyException]
     candidates:
      ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.Throwable, java.util.function.Supplier<java.lang.String>):void}
      ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Object[]):void}
      ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Object):void}
      ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Throwable):void} */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Throwable):void}
     arg types: [java.util.logging.Level, java.lang.String, java.lang.Exception]
     candidates:
      ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.Throwable, java.util.function.Supplier<java.lang.String>):void}
      ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Object[]):void}
      ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Object):void}
      ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Throwable):void} */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006e, code lost:
        if (org.conscrypt.Conscrypt.isConscrypt(r1.getProvider()) != false) goto L_0x007b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00af  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static byte[] rsaOpWithPrivateKey(java.security.PrivateKey r5, int r6, int r7, byte[] r8) {
        /*
            java.lang.String r0 = "Unsupported cipher algorithm: "
            java.lang.String r1 = r5.getAlgorithm()
            java.lang.String r2 = "RSA"
            boolean r2 = r2.equals(r1)
            r3 = 0
            if (r2 != 0) goto L_0x0026
            java.util.logging.Logger r5 = org.conscrypt.CryptoUpcalls.logger
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Unexpected key type: "
            r6.append(r7)
            r6.append(r1)
            java.lang.String r6 = r6.toString()
            r5.warning(r6)
            return r3
        L_0x0026:
            r1 = 1
            if (r6 == r1) goto L_0x004c
            r1 = 3
            if (r6 == r1) goto L_0x0049
            r1 = 4
            if (r6 == r1) goto L_0x0046
            java.util.logging.Logger r5 = org.conscrypt.CryptoUpcalls.logger
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "Unsupported OpenSSL/BoringSSL padding: "
            r7.append(r8)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            r5.warning(r6)
            return r3
        L_0x0046:
            java.lang.String r6 = "OAEPPadding"
            goto L_0x004e
        L_0x0049:
            java.lang.String r6 = "NoPadding"
            goto L_0x004e
        L_0x004c:
            java.lang.String r6 = "PKCS1Padding"
        L_0x004e:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "RSA/ECB/"
            r1.append(r2)
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            javax.crypto.Cipher r1 = javax.crypto.Cipher.getInstance(r6)     // Catch:{ NoSuchAlgorithmException -> 0x010b, NoSuchPaddingException -> 0x00f6, InvalidKeyException -> 0x0071 }
            r1.init(r7, r5)     // Catch:{ NoSuchAlgorithmException -> 0x010b, NoSuchPaddingException -> 0x00f6, InvalidKeyException -> 0x0071 }
            java.security.Provider r2 = r1.getProvider()     // Catch:{ NoSuchAlgorithmException -> 0x010b, NoSuchPaddingException -> 0x00f6, InvalidKeyException -> 0x0071 }
            boolean r0 = org.conscrypt.Conscrypt.isConscrypt(r2)     // Catch:{ NoSuchAlgorithmException -> 0x010b, NoSuchPaddingException -> 0x00f6, InvalidKeyException -> 0x0071 }
            if (r0 == 0) goto L_0x007c
            goto L_0x007b
        L_0x0071:
            r0 = move-exception
            java.util.logging.Logger r1 = org.conscrypt.CryptoUpcalls.logger
            java.util.logging.Level r2 = java.util.logging.Level.WARNING
            java.lang.String r4 = "Preferred provider doesn't support key:"
            r1.log(r2, r4, r0)
        L_0x007b:
            r1 = r3
        L_0x007c:
            if (r1 != 0) goto L_0x00c6
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "Cipher."
            r0.append(r2)
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            java.util.ArrayList r0 = getExternalProviders(r0)
            java.util.Iterator r0 = r0.iterator()
        L_0x0097:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x00ad
            java.lang.Object r1 = r0.next()
            java.security.Provider r1 = (java.security.Provider) r1
            javax.crypto.Cipher r1 = javax.crypto.Cipher.getInstance(r6, r1)     // Catch:{ InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException -> 0x00ab }
            r1.init(r7, r5)     // Catch:{ InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException -> 0x00ab }
            goto L_0x00ad
        L_0x00ab:
            r1 = r3
            goto L_0x0097
        L_0x00ad:
            if (r1 != 0) goto L_0x00c6
            java.util.logging.Logger r5 = org.conscrypt.CryptoUpcalls.logger
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "Could not find provider for algorithm: "
            r7.append(r8)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            r5.warning(r6)
            return r3
        L_0x00c6:
            byte[] r5 = r1.doFinal(r8)     // Catch:{ Exception -> 0x00cb }
            return r5
        L_0x00cb:
            r7 = move-exception
            java.util.logging.Logger r8 = org.conscrypt.CryptoUpcalls.logger
            java.util.logging.Level r0 = java.util.logging.Level.WARNING
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Exception while decrypting message with "
            r1.append(r2)
            java.lang.String r5 = r5.getAlgorithm()
            r1.append(r5)
            java.lang.String r5 = " private key using "
            r1.append(r5)
            r1.append(r6)
            java.lang.String r5 = ":"
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            r8.log(r0, r5, r7)
            return r3
        L_0x00f6:
            java.util.logging.Logger r5 = org.conscrypt.CryptoUpcalls.logger
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r0)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            r5.warning(r6)
            return r3
        L_0x010b:
            java.util.logging.Logger r5 = org.conscrypt.CryptoUpcalls.logger
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r0)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            r5.warning(r6)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.conscrypt.CryptoUpcalls.rsaOpWithPrivateKey(java.security.PrivateKey, int, int, byte[]):byte[]");
    }
}
