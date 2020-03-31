package org.conscrypt;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.security.interfaces.ECKey;
import java.security.spec.ECParameterSpec;
import javax.crypto.SecretKey;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSession;
import javax.net.ssl.X509KeyManager;
import javax.net.ssl.X509TrustManager;
import javax.security.auth.x500.X500Principal;
import org.conscrypt.ExternalSession;
import org.conscrypt.NativeCrypto;
import org.conscrypt.NativeRef;
import org.conscrypt.SSLParametersImpl;

class ConscryptFileDescriptorSocket extends OpenSSLSocketImpl implements NativeCrypto.SSLHandshakeCallbacks, SSLParametersImpl.AliasChooser, SSLParametersImpl.PSKCallbacks {
    private static final boolean DBG_STATE = false;
    private final ActiveSession activeSession;
    private OpenSSLKey channelIdPrivateKey;
    private SessionSnapshot closedSession;
    private final SSLSession externalSession = Platform.wrapSSLSession(new ExternalSession(new ExternalSession.Provider() {
        /* class org.conscrypt.ConscryptFileDescriptorSocket.AnonymousClass1 */

        public ConscryptSession provideSession() {
            return ConscryptFileDescriptorSocket.this.provideSession();
        }
    }));
    private final Object guard = Platform.closeGuardGet();
    private int handshakeTimeoutMilliseconds = -1;
    private SSLInputStream is;
    private SSLOutputStream os;
    /* access modifiers changed from: private */
    public final NativeSsl ssl;
    private final SSLParametersImpl sslParameters;
    /* access modifiers changed from: private */
    public int state = 0;
    /* access modifiers changed from: private */
    public int writeTimeoutMilliseconds = 0;

    public final long serverSessionRequested(byte[] bArr) {
        return 0;
    }

    ConscryptFileDescriptorSocket(SSLParametersImpl sSLParametersImpl) throws IOException {
        this.sslParameters = sSLParametersImpl;
        NativeSsl newSsl = newSsl(sSLParametersImpl, this);
        this.ssl = newSsl;
        this.activeSession = new ActiveSession(newSsl, sSLParametersImpl.getSessionContext());
    }

    ConscryptFileDescriptorSocket(String str, int i, SSLParametersImpl sSLParametersImpl) throws IOException {
        super(str, i);
        this.sslParameters = sSLParametersImpl;
        NativeSsl newSsl = newSsl(sSLParametersImpl, this);
        this.ssl = newSsl;
        this.activeSession = new ActiveSession(newSsl, sSLParametersImpl.getSessionContext());
    }

    ConscryptFileDescriptorSocket(InetAddress inetAddress, int i, SSLParametersImpl sSLParametersImpl) throws IOException {
        super(inetAddress, i);
        this.sslParameters = sSLParametersImpl;
        NativeSsl newSsl = newSsl(sSLParametersImpl, this);
        this.ssl = newSsl;
        this.activeSession = new ActiveSession(newSsl, sSLParametersImpl.getSessionContext());
    }

    ConscryptFileDescriptorSocket(String str, int i, InetAddress inetAddress, int i2, SSLParametersImpl sSLParametersImpl) throws IOException {
        super(str, i, inetAddress, i2);
        this.sslParameters = sSLParametersImpl;
        NativeSsl newSsl = newSsl(sSLParametersImpl, this);
        this.ssl = newSsl;
        this.activeSession = new ActiveSession(newSsl, sSLParametersImpl.getSessionContext());
    }

    ConscryptFileDescriptorSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2, SSLParametersImpl sSLParametersImpl) throws IOException {
        super(inetAddress, i, inetAddress2, i2);
        this.sslParameters = sSLParametersImpl;
        NativeSsl newSsl = newSsl(sSLParametersImpl, this);
        this.ssl = newSsl;
        this.activeSession = new ActiveSession(newSsl, sSLParametersImpl.getSessionContext());
    }

    ConscryptFileDescriptorSocket(Socket socket, String str, int i, boolean z, SSLParametersImpl sSLParametersImpl) throws IOException {
        super(socket, str, i, z);
        this.sslParameters = sSLParametersImpl;
        NativeSsl newSsl = newSsl(sSLParametersImpl, this);
        this.ssl = newSsl;
        this.activeSession = new ActiveSession(newSsl, sSLParametersImpl.getSessionContext());
    }

    private static NativeSsl newSsl(SSLParametersImpl sSLParametersImpl, ConscryptFileDescriptorSocket conscryptFileDescriptorSocket) throws SSLException {
        return NativeSsl.newInstance(sSLParametersImpl, conscryptFileDescriptorSocket, conscryptFileDescriptorSocket, conscryptFileDescriptorSocket);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:102:0x00f2, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x00f5, code lost:
        monitor-enter(r9.ssl);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x00f8, code lost:
        if (r9.state == 8) goto L_0x00fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0028, code lost:
        if (getUseClientMode() == false) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x00fd, code lost:
        monitor-enter(r9.ssl);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:?, code lost:
        transitionTo(8);
        r9.ssl.notifyAll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:?, code lost:
        shutdownAndFreeSslNative();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002a, code lost:
        r3 = clientSessionContext().getCachedSession(getHostnameOrIP(), getPort(), r9.sslParameters);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x0119, code lost:
        if (r1.getMessage().contains("unexpected CCS") != false) goto L_0x011b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x011b, code lost:
        org.conscrypt.Platform.logEvent(java.lang.String.format("ssl_unexpected_ccs: host=%s", getHostnameOrIP()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x012c, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003c, code lost:
        if (r3 == null) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x0130, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x0131, code lost:
        r3 = new javax.net.ssl.SSLHandshakeException(r1.getMessage());
        r3.initCause(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x013d, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003e, code lost:
        r3.offerToResume(r9.ssl);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x0141, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0143, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x0151, code lost:
        throw ((javax.net.ssl.SSLHandshakeException) new javax.net.ssl.SSLHandshakeException("Handshake failed").initCause(r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0152, code lost:
        if (1 != 0) goto L_0x0154;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x0156, code lost:
        monitor-enter(r9.ssl);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0043, code lost:
        r3 = getSoTimeout();
        r4 = getSoWriteTimeout();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:?, code lost:
        transitionTo(8);
        r9.ssl.notifyAll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:?, code lost:
        shutdownAndFreeSslNative();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x0167, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004d, code lost:
        if (r9.handshakeTimeoutMilliseconds < 0) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004f, code lost:
        setSoTimeout(r9.handshakeTimeoutMilliseconds);
        setSoWriteTimeout(r9.handshakeTimeoutMilliseconds);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0059, code lost:
        r5 = r9.ssl;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005b, code lost:
        monitor-enter(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:199:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005e, code lost:
        if (r9.state != 8) goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0060, code lost:
        monitor-exit(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0061, code lost:
        r1 = r9.ssl;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0063, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        transitionTo(8);
        r9.ssl.notifyAll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x006c, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        shutdownAndFreeSslNative();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        monitor-exit(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        r9.ssl.doHandshake(org.conscrypt.Platform.getFileDescriptor(r9.socket), getSoTimeout());
        r9.activeSession.onPeerCertificateAvailable(getHostnameOrIP(), getPort());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        r6 = r9.ssl;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0094, code lost:
        monitor-enter(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0097, code lost:
        if (r9.state != 8) goto L_0x00ad;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0099, code lost:
        monitor-exit(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x009a, code lost:
        r1 = r9.ssl;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x009c, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        transitionTo(8);
        r9.ssl.notifyAll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00a5, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        shutdownAndFreeSslNative();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:?, code lost:
        monitor-exit(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00b0, code lost:
        if (r9.handshakeTimeoutMilliseconds < 0) goto L_0x00b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00b2, code lost:
        setSoTimeout(r3);
        setSoWriteTimeout(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00b8, code lost:
        r3 = r9.ssl;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00ba, code lost:
        monitor-enter(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00bd, code lost:
        if (r9.state != 8) goto L_0x00c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x00c0, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x00c3, code lost:
        if (r9.state != 2) goto L_0x00ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x00c5, code lost:
        transitionTo(4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x00ca, code lost:
        transitionTo(5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x00ce, code lost:
        if (r0 != false) goto L_0x00d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x00d0, code lost:
        r9.ssl.notifyAll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x00d5, code lost:
        monitor-exit(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x00d6, code lost:
        if (r0 == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000f, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x00d8, code lost:
        r0 = r9.ssl;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x00da, code lost:
        monitor-enter(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:?, code lost:
        transitionTo(8);
        r9.ssl.notifyAll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x00e3, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:?, code lost:
        shutdownAndFreeSslNative();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        org.conscrypt.Platform.closeGuardOpen(r9.guard, "close");
        r9.ssl.initialize(getHostname(), r9.channelIdPrivateKey);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void startHandshake() throws java.io.IOException {
        /*
            r9 = this;
            r9.checkOpen()
            org.conscrypt.NativeSsl r0 = r9.ssl
            monitor-enter(r0)
            int r1 = r9.state     // Catch:{ all -> 0x016a }
            if (r1 != 0) goto L_0x0168
            r1 = 2
            r9.transitionTo(r1)     // Catch:{ all -> 0x016a }
            monitor-exit(r0)     // Catch:{ all -> 0x016a }
            r0 = 1
            r2 = 8
            java.lang.Object r3 = r9.guard     // Catch:{ SSLProtocolException -> 0x0143 }
            java.lang.String r4 = "close"
            org.conscrypt.Platform.closeGuardOpen(r3, r4)     // Catch:{ SSLProtocolException -> 0x0143 }
            org.conscrypt.NativeSsl r3 = r9.ssl     // Catch:{ SSLProtocolException -> 0x0143 }
            java.lang.String r4 = r9.getHostname()     // Catch:{ SSLProtocolException -> 0x0143 }
            org.conscrypt.OpenSSLKey r5 = r9.channelIdPrivateKey     // Catch:{ SSLProtocolException -> 0x0143 }
            r3.initialize(r4, r5)     // Catch:{ SSLProtocolException -> 0x0143 }
            boolean r3 = r9.getUseClientMode()     // Catch:{ SSLProtocolException -> 0x0143 }
            if (r3 == 0) goto L_0x0043
            org.conscrypt.ClientSessionContext r3 = r9.clientSessionContext()     // Catch:{ SSLProtocolException -> 0x0143 }
            java.lang.String r4 = r9.getHostnameOrIP()     // Catch:{ SSLProtocolException -> 0x0143 }
            int r5 = r9.getPort()     // Catch:{ SSLProtocolException -> 0x0143 }
            org.conscrypt.SSLParametersImpl r6 = r9.sslParameters     // Catch:{ SSLProtocolException -> 0x0143 }
            org.conscrypt.NativeSslSession r3 = r3.getCachedSession(r4, r5, r6)     // Catch:{ SSLProtocolException -> 0x0143 }
            if (r3 == 0) goto L_0x0043
            org.conscrypt.NativeSsl r4 = r9.ssl     // Catch:{ SSLProtocolException -> 0x0143 }
            r3.offerToResume(r4)     // Catch:{ SSLProtocolException -> 0x0143 }
        L_0x0043:
            int r3 = r9.getSoTimeout()     // Catch:{ SSLProtocolException -> 0x0143 }
            int r4 = r9.getSoWriteTimeout()     // Catch:{ SSLProtocolException -> 0x0143 }
            int r5 = r9.handshakeTimeoutMilliseconds     // Catch:{ SSLProtocolException -> 0x0143 }
            if (r5 < 0) goto L_0x0059
            int r5 = r9.handshakeTimeoutMilliseconds     // Catch:{ SSLProtocolException -> 0x0143 }
            r9.setSoTimeout(r5)     // Catch:{ SSLProtocolException -> 0x0143 }
            int r5 = r9.handshakeTimeoutMilliseconds     // Catch:{ SSLProtocolException -> 0x0143 }
            r9.setSoWriteTimeout(r5)     // Catch:{ SSLProtocolException -> 0x0143 }
        L_0x0059:
            org.conscrypt.NativeSsl r5 = r9.ssl     // Catch:{ SSLProtocolException -> 0x0143 }
            monitor-enter(r5)     // Catch:{ SSLProtocolException -> 0x0143 }
            int r6 = r9.state     // Catch:{ all -> 0x013e }
            if (r6 != r2) goto L_0x0074
            monitor-exit(r5)     // Catch:{ all -> 0x013e }
            org.conscrypt.NativeSsl r1 = r9.ssl
            monitor-enter(r1)
            r9.transitionTo(r2)     // Catch:{ all -> 0x0071 }
            org.conscrypt.NativeSsl r0 = r9.ssl     // Catch:{ all -> 0x0071 }
            r0.notifyAll()     // Catch:{ all -> 0x0071 }
            monitor-exit(r1)     // Catch:{ all -> 0x0071 }
            r9.shutdownAndFreeSslNative()     // Catch:{ IOException -> 0x0070 }
        L_0x0070:
            return
        L_0x0071:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0071 }
            throw r0
        L_0x0074:
            monitor-exit(r5)     // Catch:{ all -> 0x013e }
            r5 = 0
            org.conscrypt.NativeSsl r6 = r9.ssl     // Catch:{ CertificateException -> 0x0130, SSLException -> 0x00f2 }
            java.net.Socket r7 = r9.socket     // Catch:{ CertificateException -> 0x0130, SSLException -> 0x00f2 }
            java.io.FileDescriptor r7 = org.conscrypt.Platform.getFileDescriptor(r7)     // Catch:{ CertificateException -> 0x0130, SSLException -> 0x00f2 }
            int r8 = r9.getSoTimeout()     // Catch:{ CertificateException -> 0x0130, SSLException -> 0x00f2 }
            r6.doHandshake(r7, r8)     // Catch:{ CertificateException -> 0x0130, SSLException -> 0x00f2 }
            org.conscrypt.ActiveSession r6 = r9.activeSession     // Catch:{ CertificateException -> 0x0130, SSLException -> 0x00f2 }
            java.lang.String r7 = r9.getHostnameOrIP()     // Catch:{ CertificateException -> 0x0130, SSLException -> 0x00f2 }
            int r8 = r9.getPort()     // Catch:{ CertificateException -> 0x0130, SSLException -> 0x00f2 }
            r6.onPeerCertificateAvailable(r7, r8)     // Catch:{ CertificateException -> 0x0130, SSLException -> 0x00f2 }
            org.conscrypt.NativeSsl r6 = r9.ssl     // Catch:{ SSLProtocolException -> 0x0143 }
            monitor-enter(r6)     // Catch:{ SSLProtocolException -> 0x0143 }
            int r7 = r9.state     // Catch:{ all -> 0x00ef }
            if (r7 != r2) goto L_0x00ad
            monitor-exit(r6)     // Catch:{ all -> 0x00ef }
            org.conscrypt.NativeSsl r1 = r9.ssl
            monitor-enter(r1)
            r9.transitionTo(r2)     // Catch:{ all -> 0x00aa }
            org.conscrypt.NativeSsl r0 = r9.ssl     // Catch:{ all -> 0x00aa }
            r0.notifyAll()     // Catch:{ all -> 0x00aa }
            monitor-exit(r1)     // Catch:{ all -> 0x00aa }
            r9.shutdownAndFreeSslNative()     // Catch:{ IOException -> 0x00a9 }
        L_0x00a9:
            return
        L_0x00aa:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00aa }
            throw r0
        L_0x00ad:
            monitor-exit(r6)     // Catch:{ all -> 0x00ef }
            int r6 = r9.handshakeTimeoutMilliseconds     // Catch:{ SSLProtocolException -> 0x0143 }
            if (r6 < 0) goto L_0x00b8
            r9.setSoTimeout(r3)     // Catch:{ SSLProtocolException -> 0x0143 }
            r9.setSoWriteTimeout(r4)     // Catch:{ SSLProtocolException -> 0x0143 }
        L_0x00b8:
            org.conscrypt.NativeSsl r3 = r9.ssl     // Catch:{ SSLProtocolException -> 0x0143 }
            monitor-enter(r3)     // Catch:{ SSLProtocolException -> 0x0143 }
            int r4 = r9.state     // Catch:{ all -> 0x00ec }
            if (r4 != r2) goto L_0x00c0
            goto L_0x00c1
        L_0x00c0:
            r0 = r5
        L_0x00c1:
            int r4 = r9.state     // Catch:{ all -> 0x00ec }
            if (r4 != r1) goto L_0x00ca
            r1 = 4
            r9.transitionTo(r1)     // Catch:{ all -> 0x00ec }
            goto L_0x00ce
        L_0x00ca:
            r1 = 5
            r9.transitionTo(r1)     // Catch:{ all -> 0x00ec }
        L_0x00ce:
            if (r0 != 0) goto L_0x00d5
            org.conscrypt.NativeSsl r1 = r9.ssl     // Catch:{ all -> 0x00ec }
            r1.notifyAll()     // Catch:{ all -> 0x00ec }
        L_0x00d5:
            monitor-exit(r3)     // Catch:{ all -> 0x00ec }
            if (r0 == 0) goto L_0x00eb
            org.conscrypt.NativeSsl r0 = r9.ssl
            monitor-enter(r0)
            r9.transitionTo(r2)     // Catch:{ all -> 0x00e8 }
            org.conscrypt.NativeSsl r1 = r9.ssl     // Catch:{ all -> 0x00e8 }
            r1.notifyAll()     // Catch:{ all -> 0x00e8 }
            monitor-exit(r0)     // Catch:{ all -> 0x00e8 }
            r9.shutdownAndFreeSslNative()     // Catch:{ IOException -> 0x00eb }
            goto L_0x00eb
        L_0x00e8:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00e8 }
            throw r1
        L_0x00eb:
            return
        L_0x00ec:
            r1 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x00ec }
            throw r1     // Catch:{ SSLProtocolException -> 0x0143 }
        L_0x00ef:
            r1 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x00ef }
            throw r1     // Catch:{ SSLProtocolException -> 0x0143 }
        L_0x00f2:
            r1 = move-exception
            org.conscrypt.NativeSsl r3 = r9.ssl     // Catch:{ SSLProtocolException -> 0x0143 }
            monitor-enter(r3)     // Catch:{ SSLProtocolException -> 0x0143 }
            int r4 = r9.state     // Catch:{ all -> 0x012d }
            if (r4 != r2) goto L_0x010e
            monitor-exit(r3)     // Catch:{ all -> 0x012d }
            org.conscrypt.NativeSsl r1 = r9.ssl
            monitor-enter(r1)
            r9.transitionTo(r2)     // Catch:{ all -> 0x010b }
            org.conscrypt.NativeSsl r0 = r9.ssl     // Catch:{ all -> 0x010b }
            r0.notifyAll()     // Catch:{ all -> 0x010b }
            monitor-exit(r1)     // Catch:{ all -> 0x010b }
            r9.shutdownAndFreeSslNative()     // Catch:{ IOException -> 0x010a }
        L_0x010a:
            return
        L_0x010b:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x010b }
            throw r0
        L_0x010e:
            monitor-exit(r3)     // Catch:{ all -> 0x012d }
            java.lang.String r3 = r1.getMessage()     // Catch:{ SSLProtocolException -> 0x0143 }
            java.lang.String r4 = "unexpected CCS"
            boolean r3 = r3.contains(r4)     // Catch:{ SSLProtocolException -> 0x0143 }
            if (r3 == 0) goto L_0x012c
            java.lang.String r3 = "ssl_unexpected_ccs: host=%s"
            java.lang.Object[] r4 = new java.lang.Object[r0]     // Catch:{ SSLProtocolException -> 0x0143 }
            java.lang.String r6 = r9.getHostnameOrIP()     // Catch:{ SSLProtocolException -> 0x0143 }
            r4[r5] = r6     // Catch:{ SSLProtocolException -> 0x0143 }
            java.lang.String r3 = java.lang.String.format(r3, r4)     // Catch:{ SSLProtocolException -> 0x0143 }
            org.conscrypt.Platform.logEvent(r3)     // Catch:{ SSLProtocolException -> 0x0143 }
        L_0x012c:
            throw r1     // Catch:{ SSLProtocolException -> 0x0143 }
        L_0x012d:
            r1 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x012d }
            throw r1     // Catch:{ SSLProtocolException -> 0x0143 }
        L_0x0130:
            r1 = move-exception
            javax.net.ssl.SSLHandshakeException r3 = new javax.net.ssl.SSLHandshakeException     // Catch:{ SSLProtocolException -> 0x0143 }
            java.lang.String r4 = r1.getMessage()     // Catch:{ SSLProtocolException -> 0x0143 }
            r3.<init>(r4)     // Catch:{ SSLProtocolException -> 0x0143 }
            r3.initCause(r1)     // Catch:{ SSLProtocolException -> 0x0143 }
            throw r3     // Catch:{ SSLProtocolException -> 0x0143 }
        L_0x013e:
            r1 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x013e }
            throw r1     // Catch:{ SSLProtocolException -> 0x0143 }
        L_0x0141:
            r1 = move-exception
            goto L_0x0152
        L_0x0143:
            r1 = move-exception
            javax.net.ssl.SSLHandshakeException r3 = new javax.net.ssl.SSLHandshakeException     // Catch:{ all -> 0x0141 }
            java.lang.String r4 = "Handshake failed"
            r3.<init>(r4)     // Catch:{ all -> 0x0141 }
            java.lang.Throwable r1 = r3.initCause(r1)     // Catch:{ all -> 0x0141 }
            javax.net.ssl.SSLHandshakeException r1 = (javax.net.ssl.SSLHandshakeException) r1     // Catch:{ all -> 0x0141 }
            throw r1     // Catch:{ all -> 0x0141 }
        L_0x0152:
            if (r0 == 0) goto L_0x0167
            org.conscrypt.NativeSsl r0 = r9.ssl
            monitor-enter(r0)
            r9.transitionTo(r2)     // Catch:{ all -> 0x0164 }
            org.conscrypt.NativeSsl r2 = r9.ssl     // Catch:{ all -> 0x0164 }
            r2.notifyAll()     // Catch:{ all -> 0x0164 }
            monitor-exit(r0)     // Catch:{ all -> 0x0164 }
            r9.shutdownAndFreeSslNative()     // Catch:{ IOException -> 0x0167 }
            goto L_0x0167
        L_0x0164:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0164 }
            throw r1
        L_0x0167:
            throw r1
        L_0x0168:
            monitor-exit(r0)     // Catch:{ all -> 0x016a }
            return
        L_0x016a:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x016a }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.conscrypt.ConscryptFileDescriptorSocket.startHandshake():void");
    }

    public final void clientCertificateRequested(byte[] bArr, int[] iArr, byte[][] bArr2) throws CertificateEncodingException, SSLException {
        this.ssl.chooseClientCertificate(bArr, iArr, bArr2);
    }

    public final int clientPSKKeyRequested(String str, byte[] bArr, byte[] bArr2) {
        return this.ssl.clientPSKKeyRequested(str, bArr, bArr2);
    }

    public final int serverPSKKeyRequested(String str, String str2, byte[] bArr) {
        return this.ssl.serverPSKKeyRequested(str, str2, bArr);
    }

    public final void onSSLStateChange(int i, int i2) {
        if (i == 32) {
            synchronized (this.ssl) {
                if (this.state != 8) {
                    transitionTo(5);
                    notifyHandshakeCompletedListeners();
                    synchronized (this.ssl) {
                        this.ssl.notifyAll();
                    }
                }
            }
        }
    }

    public final void onNewSessionEstablished(long j) {
        try {
            NativeCrypto.SSL_SESSION_up_ref(j);
            sessionContext().cacheSession(NativeSslSession.newInstance(new NativeRef.SSL_SESSION(j), this.activeSession));
        } catch (Exception unused) {
        }
    }

    public final void verifyCertificateChain(byte[][] bArr, String str) throws CertificateException {
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    X509Certificate[] decodeX509CertificateChain = SSLUtils.decodeX509CertificateChain(bArr);
                    X509TrustManager x509TrustManager = this.sslParameters.getX509TrustManager();
                    if (x509TrustManager != null) {
                        this.activeSession.onPeerCertificatesReceived(getHostnameOrIP(), getPort(), decodeX509CertificateChain);
                        if (getUseClientMode()) {
                            Platform.checkServerTrusted(x509TrustManager, decodeX509CertificateChain, str, this);
                            return;
                        } else {
                            Platform.checkClientTrusted(x509TrustManager, decodeX509CertificateChain, decodeX509CertificateChain[0].getPublicKey().getAlgorithm(), this);
                            return;
                        }
                    } else {
                        throw new CertificateException("No X.509 TrustManager");
                    }
                }
            } catch (CertificateException e) {
                throw e;
            } catch (Exception e2) {
                throw new CertificateException(e2);
            }
        }
        throw new CertificateException("Peer sent no certificate");
    }

    public final InputStream getInputStream() throws IOException {
        SSLInputStream sSLInputStream;
        checkOpen();
        synchronized (this.ssl) {
            if (this.state != 8) {
                if (this.is == null) {
                    this.is = new SSLInputStream();
                }
                sSLInputStream = this.is;
            } else {
                throw new SocketException("Socket is closed.");
            }
        }
        waitForHandshake();
        return sSLInputStream;
    }

    public final OutputStream getOutputStream() throws IOException {
        SSLOutputStream sSLOutputStream;
        checkOpen();
        synchronized (this.ssl) {
            if (this.state != 8) {
                if (this.os == null) {
                    this.os = new SSLOutputStream();
                }
                sSLOutputStream = this.os;
            } else {
                throw new SocketException("Socket is closed.");
            }
        }
        waitForHandshake();
        return sSLOutputStream;
    }

    private void assertReadableOrWriteableState() {
        int i = this.state;
        if (i != 5 && i != 4) {
            throw new AssertionError("Invalid state: " + this.state);
        }
    }

    private void waitForHandshake() throws IOException {
        startHandshake();
        synchronized (this.ssl) {
            while (this.state != 5 && this.state != 4 && this.state != 8) {
                try {
                    this.ssl.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new IOException("Interrupted waiting for handshake", e);
                }
            }
            if (this.state == 8) {
                throw new SocketException("Socket is closed");
            }
        }
    }

    private class SSLInputStream extends InputStream {
        private final Object readLock = new Object();

        SSLInputStream() {
        }

        public int read() throws IOException {
            byte[] bArr = new byte[1];
            if (read(bArr, 0, 1) != -1) {
                return bArr[0] & 255;
            }
            return -1;
        }

        public int read(byte[] bArr, int i, int i2) throws IOException {
            int read;
            Platform.blockGuardOnNetwork();
            ConscryptFileDescriptorSocket.this.checkOpen();
            ArrayUtils.checkOffsetAndCount(bArr.length, i, i2);
            if (i2 == 0) {
                return 0;
            }
            synchronized (this.readLock) {
                synchronized (ConscryptFileDescriptorSocket.this.ssl) {
                    if (ConscryptFileDescriptorSocket.this.state == 8) {
                        throw new SocketException("socket is closed");
                    }
                }
                read = ConscryptFileDescriptorSocket.this.ssl.read(Platform.getFileDescriptor(ConscryptFileDescriptorSocket.this.socket), bArr, i, i2, ConscryptFileDescriptorSocket.this.getSoTimeout());
                if (read == -1) {
                    synchronized (ConscryptFileDescriptorSocket.this.ssl) {
                        if (ConscryptFileDescriptorSocket.this.state == 8) {
                            throw new SocketException("socket is closed");
                        }
                    }
                }
            }
            return read;
        }

        public int available() {
            return ConscryptFileDescriptorSocket.this.ssl.getPendingReadableBytes();
        }

        /* access modifiers changed from: package-private */
        public void awaitPendingOps() {
            synchronized (this.readLock) {
            }
        }
    }

    private class SSLOutputStream extends OutputStream {
        private final Object writeLock = new Object();

        SSLOutputStream() {
        }

        public void write(int i) throws IOException {
            write(new byte[]{(byte) (i & 255)});
        }

        public void write(byte[] bArr, int i, int i2) throws IOException {
            Platform.blockGuardOnNetwork();
            ConscryptFileDescriptorSocket.this.checkOpen();
            ArrayUtils.checkOffsetAndCount(bArr.length, i, i2);
            if (i2 != 0) {
                synchronized (this.writeLock) {
                    synchronized (ConscryptFileDescriptorSocket.this.ssl) {
                        if (ConscryptFileDescriptorSocket.this.state == 8) {
                            throw new SocketException("socket is closed");
                        }
                    }
                    ConscryptFileDescriptorSocket.this.ssl.write(Platform.getFileDescriptor(ConscryptFileDescriptorSocket.this.socket), bArr, i, i2, ConscryptFileDescriptorSocket.this.writeTimeoutMilliseconds);
                    synchronized (ConscryptFileDescriptorSocket.this.ssl) {
                        if (ConscryptFileDescriptorSocket.this.state == 8) {
                            throw new SocketException("socket is closed");
                        }
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void awaitPendingOps() {
            synchronized (this.writeLock) {
            }
        }
    }

    public final SSLSession getSession() {
        return this.externalSession;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0015, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x002c, code lost:
        if (r4 != false) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0032, code lost:
        return org.conscrypt.SSLNullSession.getNullSession();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0035, code lost:
        return r5.activeSession;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.conscrypt.ConscryptSession provideSession() {
        /*
            r5 = this;
            org.conscrypt.NativeSsl r0 = r5.ssl
            monitor-enter(r0)
            int r1 = r5.state     // Catch:{ all -> 0x0036 }
            r2 = 8
            if (r1 != r2) goto L_0x0016
            org.conscrypt.SessionSnapshot r1 = r5.closedSession     // Catch:{ all -> 0x0036 }
            if (r1 == 0) goto L_0x0010
            org.conscrypt.SessionSnapshot r1 = r5.closedSession     // Catch:{ all -> 0x0036 }
            goto L_0x0014
        L_0x0010:
            org.conscrypt.ConscryptSession r1 = org.conscrypt.SSLNullSession.getNullSession()     // Catch:{ all -> 0x0036 }
        L_0x0014:
            monitor-exit(r0)     // Catch:{ all -> 0x0036 }
            return r1
        L_0x0016:
            r1 = 0
            int r2 = r5.state     // Catch:{ IOException -> 0x002a }
            r3 = 5
            r4 = 1
            if (r2 < r3) goto L_0x001e
            r1 = r4
        L_0x001e:
            if (r1 != 0) goto L_0x002a
            boolean r2 = r5.isConnected()     // Catch:{ IOException -> 0x002a }
            if (r2 == 0) goto L_0x002a
            r5.waitForHandshake()     // Catch:{ IOException -> 0x002a }
            goto L_0x002b
        L_0x002a:
            r4 = r1
        L_0x002b:
            monitor-exit(r0)     // Catch:{ all -> 0x0036 }
            if (r4 != 0) goto L_0x0033
            org.conscrypt.ConscryptSession r0 = org.conscrypt.SSLNullSession.getNullSession()
            return r0
        L_0x0033:
            org.conscrypt.ActiveSession r0 = r5.activeSession
            return r0
        L_0x0036:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0036 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.conscrypt.ConscryptFileDescriptorSocket.provideSession():org.conscrypt.ConscryptSession");
    }

    /* access modifiers changed from: private */
    public ConscryptSession provideHandshakeSession() {
        ConscryptSession conscryptSession;
        synchronized (this.ssl) {
            if (this.state < 2 || this.state >= 5) {
                conscryptSession = SSLNullSession.getNullSession();
            } else {
                conscryptSession = this.activeSession;
            }
        }
        return conscryptSession;
    }

    /* access modifiers changed from: package-private */
    public final SSLSession getActiveSession() {
        return this.activeSession;
    }

    public final SSLSession getHandshakeSession() {
        synchronized (this.ssl) {
            if (this.state < 2 || this.state >= 5) {
                return null;
            }
            SSLSession wrapSSLSession = Platform.wrapSSLSession(new ExternalSession(new ExternalSession.Provider() {
                /* class org.conscrypt.ConscryptFileDescriptorSocket.AnonymousClass2 */

                public ConscryptSession provideSession() {
                    return ConscryptFileDescriptorSocket.this.provideHandshakeSession();
                }
            }));
            return wrapSSLSession;
        }
    }

    public final boolean getEnableSessionCreation() {
        return this.sslParameters.getEnableSessionCreation();
    }

    public final void setEnableSessionCreation(boolean z) {
        this.sslParameters.setEnableSessionCreation(z);
    }

    public final String[] getSupportedCipherSuites() {
        return NativeCrypto.getSupportedCipherSuites();
    }

    public final String[] getEnabledCipherSuites() {
        return this.sslParameters.getEnabledCipherSuites();
    }

    public final void setEnabledCipherSuites(String[] strArr) {
        this.sslParameters.setEnabledCipherSuites(strArr);
    }

    public final String[] getSupportedProtocols() {
        return NativeCrypto.getSupportedProtocols();
    }

    public final String[] getEnabledProtocols() {
        return this.sslParameters.getEnabledProtocols();
    }

    public final void setEnabledProtocols(String[] strArr) {
        this.sslParameters.setEnabledProtocols(strArr);
    }

    public final void setUseSessionTickets(boolean z) {
        this.sslParameters.setUseSessionTickets(z);
    }

    public final void setHostname(String str) {
        this.sslParameters.setUseSni(str != null);
        super.setHostname(str);
    }

    public final void setChannelIdEnabled(boolean z) {
        if (!getUseClientMode()) {
            synchronized (this.ssl) {
                if (this.state != 0) {
                    throw new IllegalStateException("Could not enable/disable Channel ID after the initial handshake has begun.");
                }
            }
            this.sslParameters.channelIdEnabled = z;
            return;
        }
        throw new IllegalStateException("Client mode");
    }

    public final byte[] getChannelId() throws SSLException {
        if (!getUseClientMode()) {
            synchronized (this.ssl) {
                if (this.state != 5) {
                    throw new IllegalStateException("Channel ID is only available after handshake completes");
                }
            }
            return this.ssl.getTlsChannelId();
        }
        throw new IllegalStateException("Client mode");
    }

    public final void setChannelIdPrivateKey(PrivateKey privateKey) {
        if (getUseClientMode()) {
            synchronized (this.ssl) {
                if (this.state != 0) {
                    throw new IllegalStateException("Could not change Channel ID private key after the initial handshake has begun.");
                }
            }
            ECParameterSpec eCParameterSpec = null;
            if (privateKey == null) {
                this.sslParameters.channelIdEnabled = false;
                this.channelIdPrivateKey = null;
                return;
            }
            this.sslParameters.channelIdEnabled = true;
            try {
                if (privateKey instanceof ECKey) {
                    eCParameterSpec = ((ECKey) privateKey).getParams();
                }
                if (eCParameterSpec == null) {
                    eCParameterSpec = OpenSSLECGroupContext.getCurveByName("prime256v1").getECParameterSpec();
                }
                this.channelIdPrivateKey = OpenSSLKey.fromECPrivateKeyForTLSStackOnly(privateKey, eCParameterSpec);
            } catch (InvalidKeyException unused) {
            }
        } else {
            throw new IllegalStateException("Server mode");
        }
    }

    /* access modifiers changed from: package-private */
    public byte[] getTlsUnique() {
        return this.ssl.getTlsUnique();
    }

    /* access modifiers changed from: package-private */
    public byte[] exportKeyingMaterial(String str, byte[] bArr, int i) throws SSLException {
        synchronized (this.ssl) {
            if (this.state >= 3) {
                if (this.state != 8) {
                    return this.ssl.exportKeyingMaterial(str, bArr, i);
                }
            }
            return null;
        }
    }

    public final boolean getUseClientMode() {
        return this.sslParameters.getUseClientMode();
    }

    public final void setUseClientMode(boolean z) {
        synchronized (this.ssl) {
            if (this.state != 0) {
                throw new IllegalArgumentException("Could not change the mode after the initial handshake has begun.");
            }
        }
        this.sslParameters.setUseClientMode(z);
    }

    public final boolean getWantClientAuth() {
        return this.sslParameters.getWantClientAuth();
    }

    public final boolean getNeedClientAuth() {
        return this.sslParameters.getNeedClientAuth();
    }

    public final void setNeedClientAuth(boolean z) {
        this.sslParameters.setNeedClientAuth(z);
    }

    public final void setWantClientAuth(boolean z) {
        this.sslParameters.setWantClientAuth(z);
    }

    public final void setSoWriteTimeout(int i) throws SocketException {
        this.writeTimeoutMilliseconds = i;
        Platform.setSocketWriteTimeout(this, (long) i);
    }

    public final int getSoWriteTimeout() throws SocketException {
        return this.writeTimeoutMilliseconds;
    }

    public final void setHandshakeTimeout(int i) throws SocketException {
        this.handshakeTimeoutMilliseconds = i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003e, code lost:
        if (r1 != null) goto L_0x0042;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0040, code lost:
        if (r2 == null) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0042, code lost:
        r3.ssl.interrupt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0047, code lost:
        if (r1 == null) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0049, code lost:
        r1.awaitPendingOps();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x004c, code lost:
        if (r2 == null) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x004e, code lost:
        r2.awaitPendingOps();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0051, code lost:
        shutdownAndFreeSslNative();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0054, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void close() throws java.io.IOException {
        /*
            r3 = this;
            org.conscrypt.NativeSsl r0 = r3.ssl
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            monitor-enter(r0)
            int r1 = r3.state     // Catch:{ all -> 0x0055 }
            r2 = 8
            if (r1 != r2) goto L_0x000e
            monitor-exit(r0)     // Catch:{ all -> 0x0055 }
            return
        L_0x000e:
            int r1 = r3.state     // Catch:{ all -> 0x0055 }
            r3.transitionTo(r2)     // Catch:{ all -> 0x0055 }
            if (r1 != 0) goto L_0x0022
            r3.free()     // Catch:{ all -> 0x0055 }
            r3.closeUnderlyingSocket()     // Catch:{ all -> 0x0055 }
            org.conscrypt.NativeSsl r1 = r3.ssl     // Catch:{ all -> 0x0055 }
            r1.notifyAll()     // Catch:{ all -> 0x0055 }
            monitor-exit(r0)     // Catch:{ all -> 0x0055 }
            return
        L_0x0022:
            r2 = 5
            if (r1 == r2) goto L_0x0034
            r2 = 4
            if (r1 == r2) goto L_0x0034
            org.conscrypt.NativeSsl r1 = r3.ssl     // Catch:{ all -> 0x0055 }
            r1.interrupt()     // Catch:{ all -> 0x0055 }
            org.conscrypt.NativeSsl r1 = r3.ssl     // Catch:{ all -> 0x0055 }
            r1.notifyAll()     // Catch:{ all -> 0x0055 }
            monitor-exit(r0)     // Catch:{ all -> 0x0055 }
            return
        L_0x0034:
            org.conscrypt.NativeSsl r1 = r3.ssl     // Catch:{ all -> 0x0055 }
            r1.notifyAll()     // Catch:{ all -> 0x0055 }
            org.conscrypt.ConscryptFileDescriptorSocket$SSLInputStream r1 = r3.is     // Catch:{ all -> 0x0055 }
            org.conscrypt.ConscryptFileDescriptorSocket$SSLOutputStream r2 = r3.os     // Catch:{ all -> 0x0055 }
            monitor-exit(r0)     // Catch:{ all -> 0x0055 }
            if (r1 != 0) goto L_0x0042
            if (r2 == 0) goto L_0x0047
        L_0x0042:
            org.conscrypt.NativeSsl r0 = r3.ssl
            r0.interrupt()
        L_0x0047:
            if (r1 == 0) goto L_0x004c
            r1.awaitPendingOps()
        L_0x004c:
            if (r2 == 0) goto L_0x0051
            r2.awaitPendingOps()
        L_0x0051:
            r3.shutdownAndFreeSslNative()
            return
        L_0x0055:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0055 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.conscrypt.ConscryptFileDescriptorSocket.close():void");
    }

    private void shutdownAndFreeSslNative() throws IOException {
        try {
            Platform.blockGuardOnNetwork();
            this.ssl.shutdown(Platform.getFileDescriptor(this.socket));
        } catch (IOException unused) {
        } catch (Throwable th) {
            free();
            closeUnderlyingSocket();
            throw th;
        }
        free();
        closeUnderlyingSocket();
    }

    private void closeUnderlyingSocket() throws IOException {
        super.close();
    }

    private void free() {
        if (!this.ssl.isClosed()) {
            this.ssl.close();
            Platform.closeGuardClose(this.guard);
        }
    }

    /* access modifiers changed from: protected */
    public final void finalize() throws Throwable {
        try {
            if (this.guard != null) {
                Platform.closeGuardWarnIfOpen(this.guard);
            }
            if (this.ssl != null) {
                synchronized (this.ssl) {
                    transitionTo(8);
                }
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
            throw th;
        }
    }

    public final void setApplicationProtocolSelector(ApplicationProtocolSelector applicationProtocolSelector) {
        setApplicationProtocolSelector(applicationProtocolSelector == null ? null : new ApplicationProtocolSelectorAdapter(this, applicationProtocolSelector));
    }

    /* access modifiers changed from: package-private */
    public final void setApplicationProtocolSelector(ApplicationProtocolSelectorAdapter applicationProtocolSelectorAdapter) {
        this.sslParameters.setApplicationProtocolSelector(applicationProtocolSelectorAdapter);
    }

    /* access modifiers changed from: package-private */
    public final void setApplicationProtocols(String[] strArr) {
        this.sslParameters.setApplicationProtocols(strArr);
    }

    /* access modifiers changed from: package-private */
    public final String[] getApplicationProtocols() {
        return this.sslParameters.getApplicationProtocols();
    }

    public final String getApplicationProtocol() {
        return SSLUtils.toProtocolString(this.ssl.getApplicationProtocol());
    }

    public final String getHandshakeApplicationProtocol() {
        String applicationProtocol;
        synchronized (this.ssl) {
            applicationProtocol = (this.state < 2 || this.state >= 5) ? null : getApplicationProtocol();
        }
        return applicationProtocol;
    }

    public final SSLParameters getSSLParameters() {
        SSLParameters sSLParameters = super.getSSLParameters();
        Platform.getSSLParameters(sSLParameters, this.sslParameters, this);
        return sSLParameters;
    }

    public final void setSSLParameters(SSLParameters sSLParameters) {
        super.setSSLParameters(sSLParameters);
        Platform.setSSLParameters(sSLParameters, this.sslParameters, this);
    }

    public final String chooseServerAlias(X509KeyManager x509KeyManager, String str) {
        return x509KeyManager.chooseServerAlias(str, null, this);
    }

    public final String chooseClientAlias(X509KeyManager x509KeyManager, X500Principal[] x500PrincipalArr, String[] strArr) {
        return x509KeyManager.chooseClientAlias(strArr, x500PrincipalArr, this);
    }

    public final String chooseServerPSKIdentityHint(PSKKeyManager pSKKeyManager) {
        return pSKKeyManager.chooseServerKeyIdentityHint(this);
    }

    public final String chooseClientPSKIdentity(PSKKeyManager pSKKeyManager, String str) {
        return pSKKeyManager.chooseClientKeyIdentity(str, this);
    }

    public final SecretKey getPSKKey(PSKKeyManager pSKKeyManager, String str, String str2) {
        return pSKKeyManager.getKey(str, str2, this);
    }

    private ClientSessionContext clientSessionContext() {
        return this.sslParameters.getClientSessionContext();
    }

    private AbstractSessionContext sessionContext() {
        return this.sslParameters.getSessionContext();
    }

    private void transitionTo(int i) {
        int i2;
        if (i == 8 && !this.ssl.isClosed() && (i2 = this.state) >= 2 && i2 < 8) {
            this.closedSession = new SessionSnapshot(this.activeSession);
        }
        this.state = i;
    }
}
