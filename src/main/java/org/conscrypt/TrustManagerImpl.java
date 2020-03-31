package org.conscrypt;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.CertPath;
import java.security.cert.CertPathValidator;
import java.security.cert.CertPathValidatorException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateParsingException;
import java.security.cert.PKIXCertPathChecker;
import java.security.cert.PKIXParameters;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509ExtendedTrustManager;
import org.conscrypt.ct.CTPolicy;
import org.conscrypt.ct.CTVerifier;

public final class TrustManagerImpl extends X509ExtendedTrustManager {
    private static final TrustAnchorComparator TRUST_ANCHOR_COMPARATOR = new TrustAnchorComparator();
    private static ConscryptHostnameVerifier defaultHostnameVerifier;
    private static final Logger logger = Logger.getLogger(TrustManagerImpl.class.getName());
    private final X509Certificate[] acceptedIssuers;
    private final CertBlacklist blacklist;
    private boolean ctEnabledOverride;
    private CTPolicy ctPolicy;
    private CTVerifier ctVerifier;
    private final Exception err;
    private final CertificateFactory factory;
    private ConscryptHostnameVerifier hostnameVerifier;
    private final TrustedCertificateIndex intermediateIndex;
    private CertPinManager pinManager;
    private final KeyStore rootKeyStore;
    private final TrustedCertificateIndex trustedCertificateIndex;
    private final ConscryptCertStore trustedCertificateStore;
    private final CertPathValidator validator;

    public TrustManagerImpl(KeyStore keyStore) {
        this(keyStore, null);
    }

    public TrustManagerImpl(KeyStore keyStore, CertPinManager certPinManager) {
        this(keyStore, certPinManager, null);
    }

    public TrustManagerImpl(KeyStore keyStore, CertPinManager certPinManager, ConscryptCertStore conscryptCertStore) {
        this(keyStore, certPinManager, conscryptCertStore, null);
    }

    public TrustManagerImpl(KeyStore keyStore, CertPinManager certPinManager, ConscryptCertStore conscryptCertStore, CertBlacklist certBlacklist) {
        this(keyStore, certPinManager, conscryptCertStore, certBlacklist, null, null, null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x008b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TrustManagerImpl(java.security.KeyStore r6, org.conscrypt.CertPinManager r7, org.conscrypt.ConscryptCertStore r8, org.conscrypt.CertBlacklist r9, org.conscrypt.ct.CTLogStore r10, org.conscrypt.ct.CTVerifier r11, org.conscrypt.ct.CTPolicy r12) {
        /*
            r5 = this;
            r5.<init>()
            r11 = 0
            java.lang.String r0 = "PKIX"
            java.security.cert.CertPathValidator r0 = java.security.cert.CertPathValidator.getInstance(r0)     // Catch:{ Exception -> 0x0072 }
            java.lang.String r1 = "X509"
            java.security.cert.CertificateFactory r1 = java.security.cert.CertificateFactory.getInstance(r1)     // Catch:{ Exception -> 0x006a }
            java.lang.String r2 = "AndroidCAStore"
            java.lang.String r3 = r6.getType()     // Catch:{ Exception -> 0x0062 }
            boolean r2 = r2.equals(r3)     // Catch:{ Exception -> 0x0062 }
            if (r2 == 0) goto L_0x003d
            boolean r2 = org.conscrypt.Platform.supportsConscryptCertStore()     // Catch:{ Exception -> 0x0062 }
            if (r2 == 0) goto L_0x003d
            if (r8 == 0) goto L_0x0025
            goto L_0x0029
        L_0x0025:
            org.conscrypt.ConscryptCertStore r8 = org.conscrypt.Platform.newDefaultCertStore()     // Catch:{ Exception -> 0x003a }
        L_0x0029:
            org.conscrypt.TrustedCertificateIndex r2 = new org.conscrypt.TrustedCertificateIndex     // Catch:{ Exception -> 0x0032 }
            r2.<init>()     // Catch:{ Exception -> 0x0032 }
            r3 = r2
            r2 = r8
            r8 = r11
            goto L_0x004e
        L_0x0032:
            r2 = move-exception
            r3 = r2
            r2 = r1
            r1 = r0
            r0 = r8
            r8 = r11
            goto L_0x0079
        L_0x003a:
            r2 = move-exception
            r8 = r11
            goto L_0x0065
        L_0x003d:
            java.security.cert.X509Certificate[] r6 = acceptedIssuers(r6)     // Catch:{ Exception -> 0x005a }
            org.conscrypt.TrustedCertificateIndex r2 = new org.conscrypt.TrustedCertificateIndex     // Catch:{ Exception -> 0x0052 }
            java.util.Set r3 = trustAnchors(r6)     // Catch:{ Exception -> 0x0052 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x0052 }
            r3 = r2
            r2 = r8
            r8 = r6
            r6 = r11
        L_0x004e:
            r4 = r3
            r3 = r11
            r11 = r4
            goto L_0x007d
        L_0x0052:
            r2 = move-exception
            r3 = r2
            r2 = r1
            r1 = r0
            r0 = r8
            r8 = r6
            r6 = r11
            goto L_0x0079
        L_0x005a:
            r2 = move-exception
            r6 = r11
            r3 = r2
            r2 = r1
            r1 = r0
            r0 = r8
            r8 = r6
            goto L_0x0079
        L_0x0062:
            r2 = move-exception
            r6 = r11
            r8 = r6
        L_0x0065:
            r3 = r2
            r2 = r1
            r1 = r0
            r0 = r8
            goto L_0x0079
        L_0x006a:
            r2 = move-exception
            r6 = r11
            r8 = r6
            r1 = r0
            r3 = r2
            r0 = r8
            r2 = r0
            goto L_0x0079
        L_0x0072:
            r2 = move-exception
            r6 = r11
            r8 = r6
            r0 = r8
            r1 = r0
            r3 = r2
            r2 = r1
        L_0x0079:
            r4 = r2
            r2 = r0
            r0 = r1
            r1 = r4
        L_0x007d:
            if (r9 != 0) goto L_0x0083
            org.conscrypt.CertBlacklist r9 = org.conscrypt.Platform.newDefaultBlacklist()
        L_0x0083:
            if (r10 != 0) goto L_0x0089
            org.conscrypt.ct.CTLogStore r10 = org.conscrypt.Platform.newDefaultLogStore()
        L_0x0089:
            if (r12 != 0) goto L_0x008f
            org.conscrypt.ct.CTPolicy r12 = org.conscrypt.Platform.newDefaultPolicy(r10)
        L_0x008f:
            r5.pinManager = r7
            r5.rootKeyStore = r6
            r5.trustedCertificateStore = r2
            r5.validator = r0
            r5.factory = r1
            r5.trustedCertificateIndex = r11
            org.conscrypt.TrustedCertificateIndex r6 = new org.conscrypt.TrustedCertificateIndex
            r6.<init>()
            r5.intermediateIndex = r6
            r5.acceptedIssuers = r8
            r5.err = r3
            r5.blacklist = r9
            org.conscrypt.ct.CTVerifier r6 = new org.conscrypt.ct.CTVerifier
            r6.<init>(r10)
            r5.ctVerifier = r6
            r5.ctPolicy = r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.conscrypt.TrustManagerImpl.<init>(java.security.KeyStore, org.conscrypt.CertPinManager, org.conscrypt.ConscryptCertStore, org.conscrypt.CertBlacklist, org.conscrypt.ct.CTLogStore, org.conscrypt.ct.CTVerifier, org.conscrypt.ct.CTPolicy):void");
    }

    private static X509Certificate[] acceptedIssuers(KeyStore keyStore) {
        try {
            ArrayList arrayList = new ArrayList();
            Enumeration<String> aliases = keyStore.aliases();
            while (aliases.hasMoreElements()) {
                X509Certificate x509Certificate = (X509Certificate) keyStore.getCertificate(aliases.nextElement());
                if (x509Certificate != null) {
                    arrayList.add(x509Certificate);
                }
            }
            return (X509Certificate[]) arrayList.toArray(new X509Certificate[arrayList.size()]);
        } catch (KeyStoreException unused) {
            return new X509Certificate[0];
        }
    }

    private static Set<TrustAnchor> trustAnchors(X509Certificate[] x509CertificateArr) {
        HashSet hashSet = new HashSet(x509CertificateArr.length);
        for (X509Certificate trustAnchor : x509CertificateArr) {
            hashSet.add(new TrustAnchor(trustAnchor, null));
        }
        return hashSet;
    }

    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        checkTrusted(x509CertificateArr, str, null, null, true);
    }

    public List<X509Certificate> checkClientTrusted(X509Certificate[] x509CertificateArr, String str, String str2) throws CertificateException {
        return checkTrusted(x509CertificateArr, null, null, str, str2, true);
    }

    private static SSLSession getHandshakeSessionOrThrow(SSLSocket sSLSocket) throws CertificateException {
        SSLSession handshakeSession = sSLSocket.getHandshakeSession();
        if (handshakeSession != null) {
            return handshakeSession;
        }
        throw new CertificateException("Not in handshake; no session available");
    }

    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str, Socket socket) throws CertificateException {
        SSLParameters sSLParameters;
        SSLSession sSLSession;
        if (socket instanceof SSLSocket) {
            SSLSocket sSLSocket = (SSLSocket) socket;
            SSLSession handshakeSessionOrThrow = getHandshakeSessionOrThrow(sSLSocket);
            sSLParameters = sSLSocket.getSSLParameters();
            sSLSession = handshakeSessionOrThrow;
        } else {
            sSLSession = null;
            sSLParameters = null;
        }
        checkTrusted(x509CertificateArr, str, sSLSession, sSLParameters, true);
    }

    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str, SSLEngine sSLEngine) throws CertificateException {
        SSLSession handshakeSession = sSLEngine.getHandshakeSession();
        if (handshakeSession != null) {
            checkTrusted(x509CertificateArr, str, handshakeSession, sSLEngine.getSSLParameters(), true);
            return;
        }
        throw new CertificateException("Not in handshake; no session available");
    }

    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        checkTrusted(x509CertificateArr, str, null, null, false);
    }

    public List<X509Certificate> checkServerTrusted(X509Certificate[] x509CertificateArr, String str, String str2) throws CertificateException {
        return checkTrusted(x509CertificateArr, null, null, str, str2, false);
    }

    public List<X509Certificate> getTrustedChainForServer(X509Certificate[] x509CertificateArr, String str, Socket socket) throws CertificateException {
        SSLParameters sSLParameters;
        SSLSession sSLSession;
        if (socket instanceof SSLSocket) {
            SSLSocket sSLSocket = (SSLSocket) socket;
            SSLSession handshakeSessionOrThrow = getHandshakeSessionOrThrow(sSLSocket);
            sSLParameters = sSLSocket.getSSLParameters();
            sSLSession = handshakeSessionOrThrow;
        } else {
            sSLSession = null;
            sSLParameters = null;
        }
        return checkTrusted(x509CertificateArr, str, sSLSession, sSLParameters, false);
    }

    public List<X509Certificate> getTrustedChainForServer(X509Certificate[] x509CertificateArr, String str, SSLEngine sSLEngine) throws CertificateException {
        SSLSession handshakeSession = sSLEngine.getHandshakeSession();
        if (handshakeSession != null) {
            return checkTrusted(x509CertificateArr, str, handshakeSession, sSLEngine.getSSLParameters(), false);
        }
        throw new CertificateException("Not in handshake; no session available");
    }

    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str, Socket socket) throws CertificateException {
        getTrustedChainForServer(x509CertificateArr, str, socket);
    }

    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str, SSLEngine sSLEngine) throws CertificateException {
        getTrustedChainForServer(x509CertificateArr, str, sSLEngine);
    }

    public List<X509Certificate> checkServerTrusted(X509Certificate[] x509CertificateArr, String str, SSLSession sSLSession) throws CertificateException {
        return checkTrusted(x509CertificateArr, str, sSLSession, null, false);
    }

    public void handleTrustStorageUpdate() {
        X509Certificate[] x509CertificateArr = this.acceptedIssuers;
        if (x509CertificateArr == null) {
            this.trustedCertificateIndex.reset();
        } else {
            this.trustedCertificateIndex.reset(trustAnchors(x509CertificateArr));
        }
    }

    private List<X509Certificate> checkTrusted(X509Certificate[] x509CertificateArr, String str, SSLSession sSLSession, SSLParameters sSLParameters, boolean z) throws CertificateException {
        String str2;
        byte[] bArr;
        byte[] bArr2;
        if (sSLSession != null) {
            str2 = sSLSession.getPeerHost();
            bArr2 = getOcspDataFromSession(sSLSession);
            bArr = getTlsSctDataFromSession(sSLSession);
        } else {
            bArr2 = null;
            bArr = null;
            str2 = null;
        }
        if (sSLSession == null || sSLParameters == null || !"HTTPS".equalsIgnoreCase(sSLParameters.getEndpointIdentificationAlgorithm()) || getHttpsVerifier().verify(str2, sSLSession)) {
            return checkTrusted(x509CertificateArr, bArr2, bArr, str, str2, z);
        }
        throw new CertificateException("No subjectAltNames on the certificate match");
    }

    private byte[] getOcspDataFromSession(SSLSession sSLSession) {
        List<byte[]> list;
        if (sSLSession instanceof ConscryptSession) {
            list = ((ConscryptSession) sSLSession).getStatusResponses();
        } else {
            try {
                Method declaredMethod = sSLSession.getClass().getDeclaredMethod("getStatusResponses", new Class[0]);
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(sSLSession, new Object[0]);
                if (invoke instanceof List) {
                    list = (List) invoke;
                }
            } catch (IllegalAccessException | IllegalArgumentException | NoSuchMethodException | SecurityException unused) {
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
            list = null;
        }
        if (list == null || list.isEmpty()) {
            return null;
        }
        return (byte[]) list.get(0);
    }

    private byte[] getTlsSctDataFromSession(SSLSession sSLSession) {
        if (sSLSession instanceof ConscryptSession) {
            return ((ConscryptSession) sSLSession).getPeerSignedCertificateTimestamp();
        }
        try {
            Method declaredMethod = sSLSession.getClass().getDeclaredMethod("getPeerSignedCertificateTimestamp", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(sSLSession, new Object[0]);
            if (invoke instanceof byte[]) {
                return (byte[]) invoke;
            }
            return null;
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchMethodException | SecurityException unused) {
            return null;
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    private List<X509Certificate> checkTrusted(X509Certificate[] x509CertificateArr, byte[] bArr, byte[] bArr2, String str, String str2, boolean z) throws CertificateException {
        if (x509CertificateArr == null || x509CertificateArr.length == 0 || str == null || str.length() == 0) {
            throw new IllegalArgumentException("null or zero-length parameter");
        } else if (this.err == null) {
            HashSet hashSet = new HashSet();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            X509Certificate x509Certificate = x509CertificateArr[0];
            TrustAnchor findTrustAnchorBySubjectAndPublicKey = findTrustAnchorBySubjectAndPublicKey(x509Certificate);
            if (findTrustAnchorBySubjectAndPublicKey != null) {
                arrayList2.add(findTrustAnchorBySubjectAndPublicKey);
                hashSet.add(findTrustAnchorBySubjectAndPublicKey.getTrustedCert());
            } else {
                arrayList.add(x509Certificate);
            }
            hashSet.add(x509Certificate);
            return checkTrustedRecursive(x509CertificateArr, bArr, bArr2, str2, z, arrayList, arrayList2, hashSet);
        } else {
            throw new CertificateException(this.err);
        }
    }

    private List<X509Certificate> checkTrustedRecursive(X509Certificate[] x509CertificateArr, byte[] bArr, byte[] bArr2, String str, boolean z, ArrayList<X509Certificate> arrayList, ArrayList<TrustAnchor> arrayList2, Set<X509Certificate> set) throws CertificateException {
        X509Certificate x509Certificate;
        X509Certificate[] x509CertificateArr2 = x509CertificateArr;
        ArrayList<X509Certificate> arrayList3 = arrayList;
        ArrayList<TrustAnchor> arrayList4 = arrayList2;
        Set<X509Certificate> set2 = set;
        if (arrayList2.isEmpty()) {
            x509Certificate = arrayList3.get(arrayList.size() - 1);
        } else {
            x509Certificate = arrayList4.get(arrayList2.size() - 1).getTrustedCert();
        }
        X509Certificate x509Certificate2 = x509Certificate;
        checkBlacklist(x509Certificate2);
        if (x509Certificate2.getIssuerDN().equals(x509Certificate2.getSubjectDN())) {
            return verifyChain(arrayList, arrayList2, str, z, bArr, bArr2);
        }
        boolean z2 = false;
        CertificateException e = null;
        for (TrustAnchor next : sortPotentialAnchors(findAllTrustAnchorsByIssuerAndSignature(x509Certificate2))) {
            X509Certificate trustedCert = next.getTrustedCert();
            if (!set2.contains(trustedCert)) {
                set2.add(trustedCert);
                arrayList4.add(next);
                try {
                    return checkTrustedRecursive(x509CertificateArr, bArr, bArr2, str, z, arrayList, arrayList2, set);
                } catch (CertificateException e2) {
                    e = e2;
                    arrayList4.remove(arrayList2.size() - 1);
                    set2.remove(trustedCert);
                    z2 = true;
                }
            }
        }
        if (arrayList2.isEmpty()) {
            for (int i = 1; i < x509CertificateArr2.length; i++) {
                X509Certificate x509Certificate3 = x509CertificateArr2[i];
                if (!set2.contains(x509Certificate3) && x509Certificate2.getIssuerDN().equals(x509Certificate3.getSubjectDN())) {
                    try {
                        x509Certificate3.checkValidity();
                        ChainStrengthAnalyzer.checkCert(x509Certificate3);
                        set2.add(x509Certificate3);
                        arrayList3.add(x509Certificate3);
                        try {
                            return checkTrustedRecursive(x509CertificateArr, bArr, bArr2, str, z, arrayList, arrayList2, set);
                        } catch (CertificateException e3) {
                            e = e3;
                            set2.remove(x509Certificate3);
                            arrayList3.remove(arrayList.size() - 1);
                        }
                    } catch (CertificateException e4) {
                        e = new CertificateException("Unacceptable certificate: " + x509Certificate3.getSubjectX500Principal(), e4);
                    }
                }
            }
            for (TrustAnchor trustedCert2 : sortPotentialAnchors(this.intermediateIndex.findAllByIssuerAndSignature(x509Certificate2))) {
                X509Certificate trustedCert3 = trustedCert2.getTrustedCert();
                if (!set2.contains(trustedCert3)) {
                    set2.add(trustedCert3);
                    arrayList3.add(trustedCert3);
                    try {
                        return checkTrustedRecursive(x509CertificateArr, bArr, bArr2, str, z, arrayList, arrayList2, set);
                    } catch (CertificateException e5) {
                        e = e5;
                        arrayList3.remove(arrayList.size() - 1);
                        set2.remove(trustedCert3);
                    }
                }
            }
            if (e != null) {
                throw e;
            }
            throw new CertificateException(new CertPathValidatorException("Trust anchor for certification path not found.", null, this.factory.generateCertPath(arrayList3), -1));
        } else if (!z2) {
            return verifyChain(arrayList, arrayList2, str, z, bArr, bArr2);
        } else {
            throw e;
        }
    }

    private List<X509Certificate> verifyChain(List<X509Certificate> list, List<TrustAnchor> list2, String str, boolean z, byte[] bArr, byte[] bArr2) throws CertificateException {
        try {
            CertPath generateCertPath = this.factory.generateCertPath(list);
            if (!list2.isEmpty()) {
                ArrayList<X509Certificate> arrayList = new ArrayList<>();
                arrayList.addAll(list);
                for (TrustAnchor trustedCert : list2) {
                    arrayList.add(trustedCert.getTrustedCert());
                }
                if (this.pinManager != null) {
                    this.pinManager.checkChainPinning(str, arrayList);
                }
                for (X509Certificate checkBlacklist : arrayList) {
                    checkBlacklist(checkBlacklist);
                }
                if (!z && (this.ctEnabledOverride || (str != null && Platform.isCTVerificationRequired(str)))) {
                    checkCT(str, arrayList, bArr, bArr2);
                }
                if (list.isEmpty()) {
                    return arrayList;
                }
                ChainStrengthAnalyzer.check(list);
                HashSet hashSet = new HashSet();
                hashSet.add(list2.get(0));
                PKIXParameters pKIXParameters = new PKIXParameters(hashSet);
                pKIXParameters.setRevocationEnabled(false);
                X509Certificate x509Certificate = list.get(0);
                setOcspResponses(pKIXParameters, x509Certificate, bArr);
                pKIXParameters.addCertPathChecker(new ExtendedKeyUsagePKIXCertPathChecker(z, x509Certificate));
                this.validator.validate(generateCertPath, pKIXParameters);
                for (int i = 1; i < list.size(); i++) {
                    this.intermediateIndex.index(list.get(i));
                }
                return arrayList;
            }
            throw new CertificateException(new CertPathValidatorException("Trust anchor for certification path not found.", null, generateCertPath, -1));
        } catch (InvalidAlgorithmParameterException e) {
            throw new CertificateException("Chain validation failed", e);
        } catch (CertPathValidatorException e2) {
            throw new CertificateException("Chain validation failed", e2);
        } catch (CertificateException e3) {
            Logger logger2 = logger;
            logger2.fine("Rejected candidate cert chain due to error: " + e3.getMessage());
            throw e3;
        }
    }

    private void checkBlacklist(X509Certificate x509Certificate) throws CertificateException {
        CertBlacklist certBlacklist = this.blacklist;
        if (certBlacklist != null && certBlacklist.isPublicKeyBlackListed(x509Certificate.getPublicKey())) {
            throw new CertificateException("Certificate blacklisted by public key: " + x509Certificate);
        }
    }

    private void checkCT(String str, List<X509Certificate> list, byte[] bArr, byte[] bArr2) throws CertificateException {
        if (!this.ctPolicy.doesResultConformToPolicy(this.ctVerifier.verifySignedCertificateTimestamps(list, bArr2, bArr), str, (X509Certificate[]) list.toArray(new X509Certificate[list.size()]))) {
            throw new CertificateException("Certificate chain does not conform to required transparency policy.");
        }
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [java.security.cert.PKIXCertPathChecker] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void setOcspResponses(java.security.cert.PKIXParameters r6, java.security.cert.X509Certificate r7, byte[] r8) {
        /*
            r5 = this;
            if (r8 != 0) goto L_0x0003
            return
        L_0x0003:
            r0 = 0
            java.util.ArrayList r1 = new java.util.ArrayList
            java.util.List r2 = r6.getCertPathCheckers()
            r1.<init>(r2)
            java.util.Iterator r2 = r1.iterator()
        L_0x0011:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0024
            java.lang.Object r3 = r2.next()
            java.security.cert.PKIXCertPathChecker r3 = (java.security.cert.PKIXCertPathChecker) r3
            boolean r4 = r3 instanceof java.security.cert.PKIXRevocationChecker
            if (r4 == 0) goto L_0x0011
            r0 = r3
            java.security.cert.PKIXRevocationChecker r0 = (java.security.cert.PKIXRevocationChecker) r0
        L_0x0024:
            if (r0 != 0) goto L_0x003c
            java.security.cert.CertPathValidator r0 = r5.validator     // Catch:{ UnsupportedOperationException -> 0x003b }
            java.security.cert.CertPathChecker r0 = r0.getRevocationChecker()     // Catch:{ UnsupportedOperationException -> 0x003b }
            java.security.cert.PKIXRevocationChecker r0 = (java.security.cert.PKIXRevocationChecker) r0     // Catch:{ UnsupportedOperationException -> 0x003b }
            r1.add(r0)
            java.security.cert.PKIXRevocationChecker$Option r2 = java.security.cert.PKIXRevocationChecker.Option.ONLY_END_ENTITY
            java.util.Set r2 = java.util.Collections.singleton(r2)
            r0.setOptions(r2)
            goto L_0x003c
        L_0x003b:
            return
        L_0x003c:
            java.util.Map r7 = java.util.Collections.singletonMap(r7, r8)
            r0.setOcspResponses(r7)
            r6.setCertPathCheckers(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.conscrypt.TrustManagerImpl.setOcspResponses(java.security.cert.PKIXParameters, java.security.cert.X509Certificate, byte[]):void");
    }

    private static Collection<TrustAnchor> sortPotentialAnchors(Set<TrustAnchor> set) {
        if (set.size() <= 1) {
            return set;
        }
        ArrayList arrayList = new ArrayList(set);
        Collections.sort(arrayList, TRUST_ANCHOR_COMPARATOR);
        return arrayList;
    }

    private static class TrustAnchorComparator implements Comparator<TrustAnchor> {
        private static final CertificatePriorityComparator CERT_COMPARATOR = new CertificatePriorityComparator();

        private TrustAnchorComparator() {
        }

        public int compare(TrustAnchor trustAnchor, TrustAnchor trustAnchor2) {
            return CERT_COMPARATOR.compare(trustAnchor.getTrustedCert(), trustAnchor2.getTrustedCert());
        }
    }

    private static class ExtendedKeyUsagePKIXCertPathChecker extends PKIXCertPathChecker {
        private static final String EKU_OID = "2.5.29.37";
        private static final String EKU_anyExtendedKeyUsage = "2.5.29.37.0";
        private static final String EKU_clientAuth = "1.3.6.1.5.5.7.3.2";
        private static final String EKU_msSGC = "1.3.6.1.4.1.311.10.3.3";
        private static final String EKU_nsSGC = "2.16.840.1.113730.4.1";
        private static final String EKU_serverAuth = "1.3.6.1.5.5.7.3.1";
        private static final Set<String> SUPPORTED_EXTENSIONS = Collections.unmodifiableSet(new HashSet(Arrays.asList(EKU_OID)));
        private final boolean clientAuth;
        private final X509Certificate leaf;

        public void init(boolean z) throws CertPathValidatorException {
        }

        public boolean isForwardCheckingSupported() {
            return true;
        }

        private ExtendedKeyUsagePKIXCertPathChecker(boolean z, X509Certificate x509Certificate) {
            this.clientAuth = z;
            this.leaf = x509Certificate;
        }

        public Set<String> getSupportedExtensions() {
            return SUPPORTED_EXTENSIONS;
        }

        public void check(Certificate certificate, Collection<String> collection) throws CertPathValidatorException {
            X509Certificate x509Certificate = this.leaf;
            if (certificate == x509Certificate) {
                try {
                    List<String> extendedKeyUsage = x509Certificate.getExtendedKeyUsage();
                    if (extendedKeyUsage != null) {
                        boolean z = false;
                        Iterator<String> it = extendedKeyUsage.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            String next = it.next();
                            if (!next.equals(EKU_anyExtendedKeyUsage)) {
                                if (!this.clientAuth) {
                                    if (next.equals(EKU_serverAuth) || next.equals(EKU_nsSGC) || next.equals(EKU_msSGC)) {
                                        break;
                                    }
                                } else if (next.equals(EKU_clientAuth)) {
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        z = true;
                        if (z) {
                            collection.remove(EKU_OID);
                            return;
                        }
                        throw new CertPathValidatorException("End-entity certificate does not have a valid extendedKeyUsage.");
                    }
                } catch (CertificateParsingException e) {
                    throw new CertPathValidatorException(e);
                }
            }
        }
    }

    private Set<TrustAnchor> findAllTrustAnchorsByIssuerAndSignature(X509Certificate x509Certificate) {
        ConscryptCertStore conscryptCertStore;
        Set<TrustAnchor> findAllByIssuerAndSignature = this.trustedCertificateIndex.findAllByIssuerAndSignature(x509Certificate);
        if (findAllByIssuerAndSignature.isEmpty() && (conscryptCertStore = this.trustedCertificateStore) != null) {
            Set<X509Certificate> findAllIssuers = conscryptCertStore.findAllIssuers(x509Certificate);
            if (findAllIssuers.isEmpty()) {
                return findAllByIssuerAndSignature;
            }
            findAllByIssuerAndSignature = new HashSet<>(findAllIssuers.size());
            for (X509Certificate index : findAllIssuers) {
                findAllByIssuerAndSignature.add(this.trustedCertificateIndex.index(index));
            }
        }
        return findAllByIssuerAndSignature;
    }

    private TrustAnchor findTrustAnchorBySubjectAndPublicKey(X509Certificate x509Certificate) {
        X509Certificate trustAnchor;
        TrustAnchor findBySubjectAndPublicKey = this.trustedCertificateIndex.findBySubjectAndPublicKey(x509Certificate);
        if (findBySubjectAndPublicKey != null) {
            return findBySubjectAndPublicKey;
        }
        ConscryptCertStore conscryptCertStore = this.trustedCertificateStore;
        if (conscryptCertStore == null || (trustAnchor = conscryptCertStore.getTrustAnchor(x509Certificate)) == null) {
            return null;
        }
        return new TrustAnchor(trustAnchor, null);
    }

    public X509Certificate[] getAcceptedIssuers() {
        X509Certificate[] x509CertificateArr = this.acceptedIssuers;
        return x509CertificateArr != null ? (X509Certificate[]) x509CertificateArr.clone() : acceptedIssuers(this.rootKeyStore);
    }

    static synchronized void setDefaultHostnameVerifier(ConscryptHostnameVerifier conscryptHostnameVerifier) {
        synchronized (TrustManagerImpl.class) {
            defaultHostnameVerifier = conscryptHostnameVerifier;
        }
    }

    static synchronized ConscryptHostnameVerifier getDefaultHostnameVerifier() {
        ConscryptHostnameVerifier conscryptHostnameVerifier;
        synchronized (TrustManagerImpl.class) {
            conscryptHostnameVerifier = defaultHostnameVerifier;
        }
        return conscryptHostnameVerifier;
    }

    /* access modifiers changed from: package-private */
    public void setHostnameVerifier(ConscryptHostnameVerifier conscryptHostnameVerifier) {
        this.hostnameVerifier = conscryptHostnameVerifier;
    }

    /* access modifiers changed from: package-private */
    public ConscryptHostnameVerifier getHostnameVerifier() {
        return this.hostnameVerifier;
    }

    private enum GlobalHostnameVerifierAdapter implements ConscryptHostnameVerifier {
        INSTANCE;

        public boolean verify(String str, SSLSession sSLSession) {
            return HttpsURLConnection.getDefaultHostnameVerifier().verify(str, sSLSession);
        }
    }

    private ConscryptHostnameVerifier getHttpsVerifier() {
        ConscryptHostnameVerifier conscryptHostnameVerifier = this.hostnameVerifier;
        if (conscryptHostnameVerifier != null) {
            return conscryptHostnameVerifier;
        }
        ConscryptHostnameVerifier defaultHostnameVerifier2 = getDefaultHostnameVerifier();
        if (defaultHostnameVerifier2 != null) {
            return defaultHostnameVerifier2;
        }
        return GlobalHostnameVerifierAdapter.INSTANCE;
    }

    public void setCTEnabledOverride(boolean z) {
        this.ctEnabledOverride = z;
    }

    public void setCTVerifier(CTVerifier cTVerifier) {
        this.ctVerifier = cTVerifier;
    }

    public void setCTPolicy(CTPolicy cTPolicy) {
        this.ctPolicy = cTPolicy;
    }
}
