package org.conscrypt;

import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import javax.crypto.SecretKey;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509KeyManager;
import javax.net.ssl.X509TrustManager;
import javax.security.auth.x500.X500Principal;

final class SSLParametersImpl implements Cloneable {
    private static final String[] EMPTY_STRING_ARRAY = new String[0];
    private static volatile SSLParametersImpl defaultParameters;
    private static volatile X509KeyManager defaultX509KeyManager;
    private static volatile X509TrustManager defaultX509TrustManager;
    ApplicationProtocolSelectorAdapter applicationProtocolSelector;
    byte[] applicationProtocols = EmptyArray.BYTE;
    boolean channelIdEnabled;
    private final ClientSessionContext clientSessionContext;
    private boolean client_mode = true;
    private boolean ctVerificationEnabled;
    private boolean enable_session_creation = true;
    String[] enabledCipherSuites;
    String[] enabledProtocols;
    private String endpointIdentificationAlgorithm;
    boolean isEnabledProtocolsFiltered;
    private boolean need_client_auth = false;
    byte[] ocspResponse;
    private final PSKKeyManager pskKeyManager;
    byte[] sctExtension;
    private final ServerSessionContext serverSessionContext;
    private boolean useCipherSuitesOrder;
    boolean useSessionTickets;
    private Boolean useSni;
    private boolean want_client_auth = false;
    private final X509KeyManager x509KeyManager;
    private final X509TrustManager x509TrustManager;

    interface AliasChooser {
        String chooseClientAlias(X509KeyManager x509KeyManager, X500Principal[] x500PrincipalArr, String[] strArr);

        String chooseServerAlias(X509KeyManager x509KeyManager, String str);
    }

    interface PSKCallbacks {
        String chooseClientPSKIdentity(PSKKeyManager pSKKeyManager, String str);

        String chooseServerPSKIdentityHint(PSKKeyManager pSKKeyManager);

        SecretKey getPSKKey(PSKKeyManager pSKKeyManager, String str, String str2);
    }

    SSLParametersImpl(KeyManager[] keyManagerArr, TrustManager[] trustManagerArr, SecureRandom secureRandom, ClientSessionContext clientSessionContext2, ServerSessionContext serverSessionContext2, String[] strArr) throws KeyManagementException {
        boolean z = true;
        this.serverSessionContext = serverSessionContext2;
        this.clientSessionContext = clientSessionContext2;
        if (keyManagerArr == null) {
            this.x509KeyManager = getDefaultX509KeyManager();
            this.pskKeyManager = null;
        } else {
            this.x509KeyManager = findFirstX509KeyManager(keyManagerArr);
            this.pskKeyManager = findFirstPSKKeyManager(keyManagerArr);
        }
        if (trustManagerArr == null) {
            this.x509TrustManager = getDefaultX509TrustManager();
        } else {
            this.x509TrustManager = findFirstX509TrustManager(trustManagerArr);
        }
        this.enabledProtocols = (String[]) NativeCrypto.checkEnabledProtocols(strArr == null ? NativeCrypto.DEFAULT_PROTOCOLS : strArr).clone();
        this.enabledCipherSuites = getDefaultCipherSuites((this.x509KeyManager == null && this.x509TrustManager == null) ? false : true, this.pskKeyManager == null ? false : z);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v22, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: byte[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private SSLParametersImpl(org.conscrypt.ClientSessionContext r3, org.conscrypt.ServerSessionContext r4, javax.net.ssl.X509KeyManager r5, org.conscrypt.PSKKeyManager r6, javax.net.ssl.X509TrustManager r7, org.conscrypt.SSLParametersImpl r8) {
        /*
            r2 = this;
            r2.<init>()
            r0 = 1
            r2.client_mode = r0
            r1 = 0
            r2.need_client_auth = r1
            r2.want_client_auth = r1
            r2.enable_session_creation = r0
            byte[] r0 = org.conscrypt.EmptyArray.BYTE
            r2.applicationProtocols = r0
            r2.clientSessionContext = r3
            r2.serverSessionContext = r4
            r2.x509KeyManager = r5
            r2.pskKeyManager = r6
            r2.x509TrustManager = r7
            java.lang.String[] r3 = r8.enabledProtocols
            r4 = 0
            if (r3 != 0) goto L_0x0022
            r3 = r4
            goto L_0x0028
        L_0x0022:
            java.lang.Object r3 = r3.clone()
            java.lang.String[] r3 = (java.lang.String[]) r3
        L_0x0028:
            r2.enabledProtocols = r3
            boolean r3 = r8.isEnabledProtocolsFiltered
            r2.isEnabledProtocolsFiltered = r3
            java.lang.String[] r3 = r8.enabledCipherSuites
            if (r3 != 0) goto L_0x0034
            r3 = r4
            goto L_0x003a
        L_0x0034:
            java.lang.Object r3 = r3.clone()
            java.lang.String[] r3 = (java.lang.String[]) r3
        L_0x003a:
            r2.enabledCipherSuites = r3
            boolean r3 = r8.client_mode
            r2.client_mode = r3
            boolean r3 = r8.need_client_auth
            r2.need_client_auth = r3
            boolean r3 = r8.want_client_auth
            r2.want_client_auth = r3
            boolean r3 = r8.enable_session_creation
            r2.enable_session_creation = r3
            java.lang.String r3 = r8.endpointIdentificationAlgorithm
            r2.endpointIdentificationAlgorithm = r3
            boolean r3 = r8.useCipherSuitesOrder
            r2.useCipherSuitesOrder = r3
            boolean r3 = r8.ctVerificationEnabled
            r2.ctVerificationEnabled = r3
            byte[] r3 = r8.sctExtension
            if (r3 != 0) goto L_0x005e
            r3 = r4
            goto L_0x0064
        L_0x005e:
            java.lang.Object r3 = r3.clone()
            byte[] r3 = (byte[]) r3
        L_0x0064:
            r2.sctExtension = r3
            byte[] r3 = r8.ocspResponse
            if (r3 != 0) goto L_0x006c
            r3 = r4
            goto L_0x0072
        L_0x006c:
            java.lang.Object r3 = r3.clone()
            byte[] r3 = (byte[]) r3
        L_0x0072:
            r2.ocspResponse = r3
            byte[] r3 = r8.applicationProtocols
            if (r3 != 0) goto L_0x0079
            goto L_0x0080
        L_0x0079:
            java.lang.Object r3 = r3.clone()
            r4 = r3
            byte[] r4 = (byte[]) r4
        L_0x0080:
            r2.applicationProtocols = r4
            org.conscrypt.ApplicationProtocolSelectorAdapter r3 = r8.applicationProtocolSelector
            r2.applicationProtocolSelector = r3
            boolean r3 = r8.useSessionTickets
            r2.useSessionTickets = r3
            java.lang.Boolean r3 = r8.useSni
            r2.useSni = r3
            boolean r3 = r8.channelIdEnabled
            r2.channelIdEnabled = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.conscrypt.SSLParametersImpl.<init>(org.conscrypt.ClientSessionContext, org.conscrypt.ServerSessionContext, javax.net.ssl.X509KeyManager, org.conscrypt.PSKKeyManager, javax.net.ssl.X509TrustManager, org.conscrypt.SSLParametersImpl):void");
    }

    static SSLParametersImpl getDefault() throws KeyManagementException {
        SSLParametersImpl sSLParametersImpl = defaultParameters;
        if (sSLParametersImpl == null) {
            sSLParametersImpl = new SSLParametersImpl((KeyManager[]) null, (TrustManager[]) null, (SecureRandom) null, new ClientSessionContext(), new ServerSessionContext(), (String[]) null);
            defaultParameters = sSLParametersImpl;
        }
        return (SSLParametersImpl) sSLParametersImpl.clone();
    }

    /* access modifiers changed from: package-private */
    public AbstractSessionContext getSessionContext() {
        return this.client_mode ? this.clientSessionContext : this.serverSessionContext;
    }

    /* access modifiers changed from: package-private */
    public ClientSessionContext getClientSessionContext() {
        return this.clientSessionContext;
    }

    /* access modifiers changed from: package-private */
    public X509KeyManager getX509KeyManager() {
        return this.x509KeyManager;
    }

    /* access modifiers changed from: package-private */
    public PSKKeyManager getPSKKeyManager() {
        return this.pskKeyManager;
    }

    /* access modifiers changed from: package-private */
    public X509TrustManager getX509TrustManager() {
        return this.x509TrustManager;
    }

    /* access modifiers changed from: package-private */
    public String[] getEnabledCipherSuites() {
        if (!Arrays.asList(this.enabledProtocols).contains("TLSv1.3")) {
            return (String[]) this.enabledCipherSuites.clone();
        }
        return SSLUtils.concat(NativeCrypto.SUPPORTED_TLS_1_3_CIPHER_SUITES, this.enabledCipherSuites);
    }

    /* access modifiers changed from: package-private */
    public void setEnabledCipherSuites(String[] strArr) {
        this.enabledCipherSuites = NativeCrypto.checkEnabledCipherSuites(filterFromCipherSuites(strArr, NativeCrypto.SUPPORTED_TLS_1_3_CIPHER_SUITES_SET));
    }

    /* access modifiers changed from: package-private */
    public String[] getEnabledProtocols() {
        return (String[]) this.enabledProtocols.clone();
    }

    /* access modifiers changed from: package-private */
    public void setEnabledProtocols(String[] strArr) {
        if (strArr != null) {
            String[] filterFromProtocols = filterFromProtocols(strArr, "SSLv3");
            this.isEnabledProtocolsFiltered = strArr.length != filterFromProtocols.length;
            this.enabledProtocols = (String[]) NativeCrypto.checkEnabledProtocols(filterFromProtocols).clone();
            return;
        }
        throw new IllegalArgumentException("protocols == null");
    }

    /* access modifiers changed from: package-private */
    public void setApplicationProtocols(String[] strArr) {
        this.applicationProtocols = SSLUtils.encodeProtocols(strArr);
    }

    /* access modifiers changed from: package-private */
    public String[] getApplicationProtocols() {
        return SSLUtils.decodeProtocols(this.applicationProtocols);
    }

    /* access modifiers changed from: package-private */
    public void setApplicationProtocolSelector(ApplicationProtocolSelectorAdapter applicationProtocolSelectorAdapter) {
        this.applicationProtocolSelector = applicationProtocolSelectorAdapter;
    }

    /* access modifiers changed from: package-private */
    public void setUseClientMode(boolean z) {
        this.client_mode = z;
    }

    /* access modifiers changed from: package-private */
    public boolean getUseClientMode() {
        return this.client_mode;
    }

    /* access modifiers changed from: package-private */
    public void setNeedClientAuth(boolean z) {
        this.need_client_auth = z;
        this.want_client_auth = false;
    }

    /* access modifiers changed from: package-private */
    public boolean getNeedClientAuth() {
        return this.need_client_auth;
    }

    /* access modifiers changed from: package-private */
    public void setWantClientAuth(boolean z) {
        this.want_client_auth = z;
        this.need_client_auth = false;
    }

    /* access modifiers changed from: package-private */
    public boolean getWantClientAuth() {
        return this.want_client_auth;
    }

    /* access modifiers changed from: package-private */
    public void setEnableSessionCreation(boolean z) {
        this.enable_session_creation = z;
    }

    /* access modifiers changed from: package-private */
    public boolean getEnableSessionCreation() {
        return this.enable_session_creation;
    }

    /* access modifiers changed from: package-private */
    public void setUseSessionTickets(boolean z) {
        this.useSessionTickets = z;
    }

    /* access modifiers changed from: package-private */
    public void setUseSni(boolean z) {
        this.useSni = Boolean.valueOf(z);
    }

    /* access modifiers changed from: package-private */
    public boolean getUseSni() {
        Boolean bool = this.useSni;
        return bool != null ? bool.booleanValue() : isSniEnabledByDefault();
    }

    /* access modifiers changed from: package-private */
    public void setCTVerificationEnabled(boolean z) {
        this.ctVerificationEnabled = z;
    }

    /* access modifiers changed from: package-private */
    public void setSCTExtension(byte[] bArr) {
        this.sctExtension = bArr;
    }

    /* access modifiers changed from: package-private */
    public void setOCSPResponse(byte[] bArr) {
        this.ocspResponse = bArr;
    }

    /* access modifiers changed from: package-private */
    public byte[] getOCSPResponse() {
        return this.ocspResponse;
    }

    private static String[] filterFromProtocols(String[] strArr, String str) {
        if (strArr.length == 1 && str.equals(strArr[0])) {
            return EMPTY_STRING_ARRAY;
        }
        ArrayList arrayList = new ArrayList();
        for (String str2 : strArr) {
            if (!str.equals(str2)) {
                arrayList.add(str2);
            }
        }
        return (String[]) arrayList.toArray(EMPTY_STRING_ARRAY);
    }

    private static String[] filterFromCipherSuites(String[] strArr, Set<String> set) {
        if (strArr == null || strArr.length == 0) {
            return strArr;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            if (!set.contains(str)) {
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(EMPTY_STRING_ARRAY);
    }

    private boolean isSniEnabledByDefault() {
        try {
            String property = System.getProperty("jsse.enableSNIExtension", "true");
            if ("true".equalsIgnoreCase(property)) {
                return true;
            }
            if ("false".equalsIgnoreCase(property)) {
                return false;
            }
            throw new RuntimeException("Can only set \"jsse.enableSNIExtension\" to \"true\" or \"false\"");
        } catch (SecurityException unused) {
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    /* access modifiers changed from: package-private */
    public SSLParametersImpl cloneWithTrustManager(X509TrustManager x509TrustManager2) {
        return new SSLParametersImpl(this.clientSessionContext, this.serverSessionContext, this.x509KeyManager, this.pskKeyManager, x509TrustManager2, this);
    }

    private static X509KeyManager getDefaultX509KeyManager() throws KeyManagementException {
        X509KeyManager x509KeyManager2 = defaultX509KeyManager;
        if (x509KeyManager2 != null) {
            return x509KeyManager2;
        }
        X509KeyManager createDefaultX509KeyManager = createDefaultX509KeyManager();
        defaultX509KeyManager = createDefaultX509KeyManager;
        return createDefaultX509KeyManager;
    }

    private static X509KeyManager createDefaultX509KeyManager() throws KeyManagementException {
        try {
            KeyManagerFactory instance = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            instance.init(null, null);
            KeyManager[] keyManagers = instance.getKeyManagers();
            X509KeyManager findFirstX509KeyManager = findFirstX509KeyManager(keyManagers);
            if (findFirstX509KeyManager != null) {
                return findFirstX509KeyManager;
            }
            throw new KeyManagementException("No X509KeyManager among default KeyManagers: " + Arrays.toString(keyManagers));
        } catch (NoSuchAlgorithmException e) {
            throw new KeyManagementException(e);
        } catch (KeyStoreException e2) {
            throw new KeyManagementException(e2);
        } catch (UnrecoverableKeyException e3) {
            throw new KeyManagementException(e3);
        }
    }

    private static X509KeyManager findFirstX509KeyManager(KeyManager[] keyManagerArr) {
        for (KeyManager keyManager : keyManagerArr) {
            if (keyManager instanceof X509KeyManager) {
                return (X509KeyManager) keyManager;
            }
        }
        return null;
    }

    private static PSKKeyManager findFirstPSKKeyManager(KeyManager[] keyManagerArr) {
        int length = keyManagerArr.length;
        int i = 0;
        while (i < length) {
            KeyManager keyManager = keyManagerArr[i];
            if (keyManager instanceof PSKKeyManager) {
                return (PSKKeyManager) keyManager;
            }
            if (keyManager != null) {
                try {
                    return DuckTypedPSKKeyManager.getInstance(keyManager);
                } catch (NoSuchMethodException unused) {
                }
            } else {
                i++;
            }
        }
        return null;
    }

    static X509TrustManager getDefaultX509TrustManager() throws KeyManagementException {
        X509TrustManager x509TrustManager2 = defaultX509TrustManager;
        if (x509TrustManager2 != null) {
            return x509TrustManager2;
        }
        X509TrustManager createDefaultX509TrustManager = createDefaultX509TrustManager();
        defaultX509TrustManager = createDefaultX509TrustManager;
        return createDefaultX509TrustManager;
    }

    private static X509TrustManager createDefaultX509TrustManager() throws KeyManagementException {
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance.init((KeyStore) null);
            TrustManager[] trustManagers = instance.getTrustManagers();
            X509TrustManager findFirstX509TrustManager = findFirstX509TrustManager(trustManagers);
            if (findFirstX509TrustManager != null) {
                return findFirstX509TrustManager;
            }
            throw new KeyManagementException("No X509TrustManager in among default TrustManagers: " + Arrays.toString(trustManagers));
        } catch (NoSuchAlgorithmException e) {
            throw new KeyManagementException(e);
        } catch (KeyStoreException e2) {
            throw new KeyManagementException(e2);
        }
    }

    private static X509TrustManager findFirstX509TrustManager(TrustManager[] trustManagerArr) {
        for (TrustManager trustManager : trustManagerArr) {
            if (trustManager instanceof X509TrustManager) {
                return (X509TrustManager) trustManager;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public String getEndpointIdentificationAlgorithm() {
        return this.endpointIdentificationAlgorithm;
    }

    /* access modifiers changed from: package-private */
    public void setEndpointIdentificationAlgorithm(String str) {
        this.endpointIdentificationAlgorithm = str;
    }

    /* access modifiers changed from: package-private */
    public boolean getUseCipherSuitesOrder() {
        return this.useCipherSuitesOrder;
    }

    /* access modifiers changed from: package-private */
    public void setUseCipherSuitesOrder(boolean z) {
        this.useCipherSuitesOrder = z;
    }

    private static String[] getDefaultCipherSuites(boolean z, boolean z2) {
        if (z) {
            if (z2) {
                return SSLUtils.concat(NativeCrypto.DEFAULT_PSK_CIPHER_SUITES, NativeCrypto.DEFAULT_X509_CIPHER_SUITES, new String[]{"TLS_EMPTY_RENEGOTIATION_INFO_SCSV"});
            }
            return SSLUtils.concat(NativeCrypto.DEFAULT_X509_CIPHER_SUITES, new String[]{"TLS_EMPTY_RENEGOTIATION_INFO_SCSV"});
        } else if (!z2) {
            return new String[]{"TLS_EMPTY_RENEGOTIATION_INFO_SCSV"};
        } else {
            return SSLUtils.concat(NativeCrypto.DEFAULT_PSK_CIPHER_SUITES, new String[]{"TLS_EMPTY_RENEGOTIATION_INFO_SCSV"});
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isCTVerificationEnabled(String str) {
        if (str == null) {
            return false;
        }
        if (this.ctVerificationEnabled) {
            return true;
        }
        return Platform.isCTVerificationRequired(str);
    }
}
