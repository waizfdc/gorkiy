package org.conscrypt;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.security.PrivateKey;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSession;
import javax.net.ssl.X509ExtendedTrustManager;
import javax.net.ssl.X509TrustManager;

class ConscryptEngineSocket extends OpenSSLSocketImpl {
    private static final ByteBuffer EMPTY_BUFFER = ByteBuffer.allocate(0);
    /* access modifiers changed from: private */
    public BufferAllocator bufferAllocator = ConscryptEngine.getDefaultBufferAllocator();
    /* access modifiers changed from: private */
    public final ConscryptEngine engine;
    /* access modifiers changed from: private */
    public final Object handshakeLock = new Object();
    private SSLInputStream in;
    private SSLOutputStream out;
    /* access modifiers changed from: private */
    public int state = 0;
    /* access modifiers changed from: private */
    public final Object stateLock = new Object();

    ConscryptEngineSocket(SSLParametersImpl sSLParametersImpl) throws IOException {
        this.engine = newEngine(sSLParametersImpl, this);
    }

    ConscryptEngineSocket(String str, int i, SSLParametersImpl sSLParametersImpl) throws IOException {
        super(str, i);
        this.engine = newEngine(sSLParametersImpl, this);
    }

    ConscryptEngineSocket(InetAddress inetAddress, int i, SSLParametersImpl sSLParametersImpl) throws IOException {
        super(inetAddress, i);
        this.engine = newEngine(sSLParametersImpl, this);
    }

    ConscryptEngineSocket(String str, int i, InetAddress inetAddress, int i2, SSLParametersImpl sSLParametersImpl) throws IOException {
        super(str, i, inetAddress, i2);
        this.engine = newEngine(sSLParametersImpl, this);
    }

    ConscryptEngineSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2, SSLParametersImpl sSLParametersImpl) throws IOException {
        super(inetAddress, i, inetAddress2, i2);
        this.engine = newEngine(sSLParametersImpl, this);
    }

    ConscryptEngineSocket(Socket socket, String str, int i, boolean z, SSLParametersImpl sSLParametersImpl) throws IOException {
        super(socket, str, i, z);
        this.engine = newEngine(sSLParametersImpl, this);
    }

    private static ConscryptEngine newEngine(SSLParametersImpl sSLParametersImpl, ConscryptEngineSocket conscryptEngineSocket) {
        ConscryptEngine conscryptEngine = new ConscryptEngine(Platform.supportsX509ExtendedTrustManager() ? sSLParametersImpl.cloneWithTrustManager(getDelegatingTrustManager(sSLParametersImpl.getX509TrustManager(), conscryptEngineSocket)) : sSLParametersImpl, conscryptEngineSocket.peerInfoProvider());
        conscryptEngine.setHandshakeListener(new HandshakeListener() {
            /* class org.conscrypt.ConscryptEngineSocket.AnonymousClass1 */

            public void onHandshakeFinished() {
                ConscryptEngineSocket.this.onHandshakeFinished();
            }
        });
        conscryptEngine.setUseClientMode(sSLParametersImpl.getUseClientMode());
        return conscryptEngine;
    }

    private static X509TrustManager getDelegatingTrustManager(X509TrustManager x509TrustManager, final ConscryptEngineSocket conscryptEngineSocket) {
        if (!(x509TrustManager instanceof X509ExtendedTrustManager)) {
            return x509TrustManager;
        }
        final X509ExtendedTrustManager x509ExtendedTrustManager = (X509ExtendedTrustManager) x509TrustManager;
        return new X509ExtendedTrustManager() {
            /* class org.conscrypt.ConscryptEngineSocket.AnonymousClass2 */

            public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str, Socket socket) throws CertificateException {
                throw new AssertionError("Should not be called");
            }

            public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str, Socket socket) throws CertificateException {
                throw new AssertionError("Should not be called");
            }

            public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str, SSLEngine sSLEngine) throws CertificateException {
                x509ExtendedTrustManager.checkClientTrusted(x509CertificateArr, str, conscryptEngineSocket);
            }

            public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str, SSLEngine sSLEngine) throws CertificateException {
                x509ExtendedTrustManager.checkServerTrusted(x509CertificateArr, str, conscryptEngineSocket);
            }

            public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
                x509ExtendedTrustManager.checkClientTrusted(x509CertificateArr, str);
            }

            public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
                x509ExtendedTrustManager.checkServerTrusted(x509CertificateArr, str);
            }

            public X509Certificate[] getAcceptedIssuers() {
                return x509ExtendedTrustManager.getAcceptedIssuers();
            }
        };
    }

    public final SSLParameters getSSLParameters() {
        return this.engine.getSSLParameters();
    }

    public final void setSSLParameters(SSLParameters sSLParameters) {
        this.engine.setSSLParameters(sSLParameters);
    }

    public final void startHandshake() throws IOException {
        checkOpen();
        try {
            synchronized (this.handshakeLock) {
                synchronized (this.stateLock) {
                    if (this.state == 0) {
                        this.state = 2;
                        this.engine.beginHandshake();
                        this.in = new SSLInputStream();
                        this.out = new SSLOutputStream();
                        doHandshake();
                    }
                }
            }
        } catch (SSLException e) {
            close();
            throw e;
        } catch (IOException e2) {
            close();
            throw e2;
        } catch (Exception e3) {
            close();
            throw SSLUtils.toSSLHandshakeException(e3);
        }
    }

    /* access modifiers changed from: private */
    public void doHandshake() throws IOException {
        boolean z = false;
        while (!z) {
            try {
                int i = AnonymousClass3.$SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[this.engine.getHandshakeStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        this.out.writeInternal(EMPTY_BUFFER);
                        this.out.flushInternal();
                    } else if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                throw new IllegalStateException("Unknown handshake status: " + this.engine.getHandshakeStatus());
                            }
                        }
                        z = true;
                    } else {
                        throw new IllegalStateException("Engine tasks are unsupported");
                    }
                } else if (this.in.processDataFromSocket(EmptyArray.BYTE, 0, 0) < 0) {
                    throw SSLUtils.toSSLHandshakeException(new EOFException());
                }
            } catch (SSLException e) {
                drainOutgoingQueue();
                close();
                throw e;
            } catch (IOException e2) {
                close();
                throw e2;
            } catch (Exception e3) {
                close();
                throw SSLUtils.toSSLHandshakeException(e3);
            }
        }
    }

    public final InputStream getInputStream() throws IOException {
        checkOpen();
        waitForHandshake();
        return this.in;
    }

    public final OutputStream getOutputStream() throws IOException {
        checkOpen();
        waitForHandshake();
        return this.out;
    }

    public final SSLSession getHandshakeSession() {
        return this.engine.handshakeSession();
    }

    public final SSLSession getSession() {
        if (isConnected()) {
            try {
                waitForHandshake();
            } catch (IOException unused) {
            }
        }
        return this.engine.getSession();
    }

    /* access modifiers changed from: package-private */
    public final SSLSession getActiveSession() {
        return this.engine.getSession();
    }

    public final boolean getEnableSessionCreation() {
        return this.engine.getEnableSessionCreation();
    }

    public final void setEnableSessionCreation(boolean z) {
        this.engine.setEnableSessionCreation(z);
    }

    public final String[] getSupportedCipherSuites() {
        return this.engine.getSupportedCipherSuites();
    }

    public final String[] getEnabledCipherSuites() {
        return this.engine.getEnabledCipherSuites();
    }

    public final void setEnabledCipherSuites(String[] strArr) {
        this.engine.setEnabledCipherSuites(strArr);
    }

    public final String[] getSupportedProtocols() {
        return this.engine.getSupportedProtocols();
    }

    public final String[] getEnabledProtocols() {
        return this.engine.getEnabledProtocols();
    }

    public final void setEnabledProtocols(String[] strArr) {
        this.engine.setEnabledProtocols(strArr);
    }

    public final void setHostname(String str) {
        this.engine.setHostname(str);
        super.setHostname(str);
    }

    public final void setUseSessionTickets(boolean z) {
        this.engine.setUseSessionTickets(z);
    }

    public final void setChannelIdEnabled(boolean z) {
        this.engine.setChannelIdEnabled(z);
    }

    public final byte[] getChannelId() throws SSLException {
        return this.engine.getChannelId();
    }

    public final void setChannelIdPrivateKey(PrivateKey privateKey) {
        this.engine.setChannelIdPrivateKey(privateKey);
    }

    /* access modifiers changed from: package-private */
    public byte[] getTlsUnique() {
        return this.engine.getTlsUnique();
    }

    /* access modifiers changed from: package-private */
    public byte[] exportKeyingMaterial(String str, byte[] bArr, int i) throws SSLException {
        return this.engine.exportKeyingMaterial(str, bArr, i);
    }

    public final boolean getUseClientMode() {
        return this.engine.getUseClientMode();
    }

    public final void setUseClientMode(boolean z) {
        this.engine.setUseClientMode(z);
    }

    public final boolean getWantClientAuth() {
        return this.engine.getWantClientAuth();
    }

    public final boolean getNeedClientAuth() {
        return this.engine.getNeedClientAuth();
    }

    public final void setNeedClientAuth(boolean z) {
        this.engine.setNeedClientAuth(z);
    }

    public final void setWantClientAuth(boolean z) {
        this.engine.setWantClientAuth(z);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        super.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002c, code lost:
        r3.engine.closeInbound();
        r3.engine.closeOutbound();
        r1 = r3.in;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0038, code lost:
        if (r1 != null) goto L_0x003a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003a, code lost:
        r1.release();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003d, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void close() throws java.io.IOException {
        /*
            r3 = this;
            java.lang.Object r0 = r3.stateLock
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            monitor-enter(r0)
            int r1 = r3.state     // Catch:{ all -> 0x003e }
            r2 = 8
            if (r1 != r2) goto L_0x000e
            monitor-exit(r0)     // Catch:{ all -> 0x003e }
            return
        L_0x000e:
            r3.state = r2     // Catch:{ all -> 0x003e }
            java.lang.Object r1 = r3.stateLock     // Catch:{ all -> 0x003e }
            r1.notifyAll()     // Catch:{ all -> 0x003e }
            monitor-exit(r0)     // Catch:{ all -> 0x003e }
            super.close()     // Catch:{ all -> 0x002b }
            org.conscrypt.ConscryptEngine r0 = r3.engine
            r0.closeInbound()
            org.conscrypt.ConscryptEngine r0 = r3.engine
            r0.closeOutbound()
            org.conscrypt.ConscryptEngineSocket$SSLInputStream r0 = r3.in
            if (r0 == 0) goto L_0x002a
            r0.release()
        L_0x002a:
            return
        L_0x002b:
            r0 = move-exception
            org.conscrypt.ConscryptEngine r1 = r3.engine
            r1.closeInbound()
            org.conscrypt.ConscryptEngine r1 = r3.engine
            r1.closeOutbound()
            org.conscrypt.ConscryptEngineSocket$SSLInputStream r1 = r3.in
            if (r1 == 0) goto L_0x003d
            r1.release()
        L_0x003d:
            throw r0
        L_0x003e:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003e }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.conscrypt.ConscryptEngineSocket.close():void");
    }

    /* access modifiers changed from: package-private */
    public final void setApplicationProtocols(String[] strArr) {
        this.engine.setApplicationProtocols(strArr);
    }

    /* access modifiers changed from: package-private */
    public final String[] getApplicationProtocols() {
        return this.engine.getApplicationProtocols();
    }

    public final String getApplicationProtocol() {
        return this.engine.getApplicationProtocol();
    }

    public final String getHandshakeApplicationProtocol() {
        return this.engine.getHandshakeApplicationProtocol();
    }

    public final void setApplicationProtocolSelector(ApplicationProtocolSelector applicationProtocolSelector) {
        setApplicationProtocolSelector(applicationProtocolSelector == null ? null : new ApplicationProtocolSelectorAdapter(this, applicationProtocolSelector));
    }

    /* access modifiers changed from: package-private */
    public final void setApplicationProtocolSelector(ApplicationProtocolSelectorAdapter applicationProtocolSelectorAdapter) {
        this.engine.setApplicationProtocolSelector(applicationProtocolSelectorAdapter);
    }

    /* access modifiers changed from: package-private */
    public void setBufferAllocator(BufferAllocator bufferAllocator2) {
        this.engine.setBufferAllocator(bufferAllocator2);
        this.bufferAllocator = bufferAllocator2;
    }

    /* access modifiers changed from: private */
    public void onHandshakeFinished() {
        boolean z;
        synchronized (this.stateLock) {
            if (this.state != 8) {
                if (this.state == 2) {
                    this.state = 4;
                } else if (this.state == 3) {
                    this.state = 5;
                }
                this.stateLock.notifyAll();
                z = true;
            } else {
                z = false;
            }
        }
        if (z) {
            notifyHandshakeCompletedListeners();
        }
    }

    private void waitForHandshake() throws IOException {
        startHandshake();
        synchronized (this.stateLock) {
            while (this.state != 5 && this.state != 4 && this.state != 8) {
                try {
                    this.stateLock.wait();
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

    private void drainOutgoingQueue() {
        while (this.engine.pendingOutboundEncryptedBytes() > 0) {
            try {
                this.out.writeInternal(EMPTY_BUFFER);
                this.out.flushInternal();
            } catch (IOException unused) {
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    public OutputStream getUnderlyingOutputStream() throws IOException {
        return super.getOutputStream();
    }

    /* access modifiers changed from: private */
    public InputStream getUnderlyingInputStream() throws IOException {
        return super.getInputStream();
    }

    private final class SSLOutputStream extends OutputStream {
        private OutputStream socketOutputStream;
        private final ByteBuffer target;
        private final int targetArrayOffset;
        private final Object writeLock = new Object();

        SSLOutputStream() {
            ByteBuffer allocate = ByteBuffer.allocate(ConscryptEngineSocket.this.engine.getSession().getPacketBufferSize());
            this.target = allocate;
            this.targetArrayOffset = allocate.arrayOffset();
        }

        public void close() throws IOException {
            ConscryptEngineSocket.this.close();
        }

        public void write(int i) throws IOException {
            ConscryptEngineSocket.this.startHandshake();
            synchronized (this.writeLock) {
                write(new byte[]{(byte) i});
            }
        }

        public void write(byte[] bArr) throws IOException {
            ConscryptEngineSocket.this.startHandshake();
            synchronized (this.writeLock) {
                writeInternal(ByteBuffer.wrap(bArr));
            }
        }

        public void write(byte[] bArr, int i, int i2) throws IOException {
            ConscryptEngineSocket.this.startHandshake();
            synchronized (this.writeLock) {
                writeInternal(ByteBuffer.wrap(bArr, i, i2));
            }
        }

        /* access modifiers changed from: private */
        public void writeInternal(ByteBuffer byteBuffer) throws IOException {
            Platform.blockGuardOnNetwork();
            ConscryptEngineSocket.this.checkOpen();
            init();
            int remaining = byteBuffer.remaining();
            do {
                this.target.clear();
                SSLEngineResult wrap = ConscryptEngineSocket.this.engine.wrap(byteBuffer, this.target);
                if (wrap.getStatus() != SSLEngineResult.Status.OK) {
                    throw new SSLException("Unexpected engine result " + wrap.getStatus());
                } else if (this.target.position() == wrap.bytesProduced()) {
                    remaining -= wrap.bytesConsumed();
                    if (remaining == byteBuffer.remaining()) {
                        this.target.flip();
                        writeToSocket();
                    } else {
                        throw new SSLException("Engine did not read the correct number of bytes");
                    }
                } else {
                    throw new SSLException("Engine bytesProduced " + wrap.bytesProduced() + " does not match bytes written " + this.target.position());
                }
            } while (remaining > 0);
        }

        public void flush() throws IOException {
            ConscryptEngineSocket.this.startHandshake();
            synchronized (this.writeLock) {
                flushInternal();
            }
        }

        /* access modifiers changed from: private */
        public void flushInternal() throws IOException {
            ConscryptEngineSocket.this.checkOpen();
            init();
            this.socketOutputStream.flush();
        }

        private void init() throws IOException {
            if (this.socketOutputStream == null) {
                this.socketOutputStream = ConscryptEngineSocket.this.getUnderlyingOutputStream();
            }
        }

        private void writeToSocket() throws IOException {
            this.socketOutputStream.write(this.target.array(), this.targetArrayOffset, this.target.limit());
        }
    }

    private final class SSLInputStream extends InputStream {
        private final AllocatedBuffer allocatedBuffer;
        private final ByteBuffer fromEngine;
        private final ByteBuffer fromSocket;
        private final int fromSocketArrayOffset;
        private final Object readLock = new Object();
        private final byte[] singleByte = new byte[1];
        private InputStream socketInputStream;

        SSLInputStream() {
            if (ConscryptEngineSocket.this.bufferAllocator != null) {
                AllocatedBuffer allocateDirectBuffer = ConscryptEngineSocket.this.bufferAllocator.allocateDirectBuffer(ConscryptEngineSocket.this.engine.getSession().getApplicationBufferSize());
                this.allocatedBuffer = allocateDirectBuffer;
                this.fromEngine = allocateDirectBuffer.nioBuffer();
            } else {
                this.allocatedBuffer = null;
                this.fromEngine = ByteBuffer.allocateDirect(ConscryptEngineSocket.this.engine.getSession().getApplicationBufferSize());
            }
            this.fromEngine.flip();
            ByteBuffer allocate = ByteBuffer.allocate(ConscryptEngineSocket.this.engine.getSession().getPacketBufferSize());
            this.fromSocket = allocate;
            this.fromSocketArrayOffset = allocate.arrayOffset();
        }

        public void close() throws IOException {
            ConscryptEngineSocket.this.close();
        }

        /* access modifiers changed from: package-private */
        public void release() {
            synchronized (this.readLock) {
                if (this.allocatedBuffer != null) {
                    this.allocatedBuffer.release();
                }
            }
        }

        public int read() throws IOException {
            ConscryptEngineSocket.this.startHandshake();
            synchronized (this.readLock) {
                int read = read(this.singleByte, 0, 1);
                if (read == -1) {
                    return -1;
                }
                if (read == 1) {
                    byte b = this.singleByte[0];
                    return b;
                }
                throw new SSLException("read incorrect number of bytes " + read);
            }
        }

        public int read(byte[] bArr) throws IOException {
            int read;
            ConscryptEngineSocket.this.startHandshake();
            synchronized (this.readLock) {
                read = read(bArr, 0, bArr.length);
            }
            return read;
        }

        public int read(byte[] bArr, int i, int i2) throws IOException {
            int readUntilDataAvailable;
            ConscryptEngineSocket.this.startHandshake();
            synchronized (this.readLock) {
                readUntilDataAvailable = readUntilDataAvailable(bArr, i, i2);
            }
            return readUntilDataAvailable;
        }

        public int available() throws IOException {
            int remaining;
            ConscryptEngineSocket.this.startHandshake();
            synchronized (this.readLock) {
                init();
                remaining = this.fromEngine.remaining();
            }
            return remaining;
        }

        private boolean isHandshaking(SSLEngineResult.HandshakeStatus handshakeStatus) {
            int i = AnonymousClass3.$SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[handshakeStatus.ordinal()];
            return i == 1 || i == 2 || i == 3;
        }

        private int readUntilDataAvailable(byte[] bArr, int i, int i2) throws IOException {
            int processDataFromSocket;
            do {
                processDataFromSocket = processDataFromSocket(bArr, i, i2);
            } while (processDataFromSocket == 0);
            return processDataFromSocket;
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x00a0, code lost:
            if (r1.bytesProduced() == 0) goto L_0x00a4;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int processDataFromSocket(byte[] r7, int r8, int r9) throws java.io.IOException {
            /*
                r6 = this;
                org.conscrypt.Platform.blockGuardOnNetwork()
                org.conscrypt.ConscryptEngineSocket r0 = org.conscrypt.ConscryptEngineSocket.this
                r0.checkOpen()
                r6.init()
            L_0x000b:
                java.nio.ByteBuffer r0 = r6.fromEngine
                int r0 = r0.remaining()
                if (r0 <= 0) goto L_0x0023
                java.nio.ByteBuffer r0 = r6.fromEngine
                int r0 = r0.remaining()
                int r9 = java.lang.Math.min(r0, r9)
                java.nio.ByteBuffer r0 = r6.fromEngine
                r0.get(r7, r8, r9)
                return r9
            L_0x0023:
                java.nio.ByteBuffer r0 = r6.fromSocket
                r0.flip()
                java.nio.ByteBuffer r0 = r6.fromEngine
                r0.clear()
                org.conscrypt.ConscryptEngineSocket r0 = org.conscrypt.ConscryptEngineSocket.this
                org.conscrypt.ConscryptEngine r0 = r0.engine
                javax.net.ssl.SSLEngineResult$HandshakeStatus r0 = r0.getHandshakeStatus()
                boolean r0 = r6.isHandshaking(r0)
                org.conscrypt.ConscryptEngineSocket r1 = org.conscrypt.ConscryptEngineSocket.this
                org.conscrypt.ConscryptEngine r1 = r1.engine
                java.nio.ByteBuffer r2 = r6.fromSocket
                java.nio.ByteBuffer r3 = r6.fromEngine
                javax.net.ssl.SSLEngineResult r1 = r1.unwrap(r2, r3)
                java.nio.ByteBuffer r2 = r6.fromSocket
                r2.compact()
                java.nio.ByteBuffer r2 = r6.fromEngine
                r2.flip()
                int[] r2 = org.conscrypt.ConscryptEngineSocket.AnonymousClass3.$SwitchMap$javax$net$ssl$SSLEngineResult$Status
                javax.net.ssl.SSLEngineResult$Status r3 = r1.getStatus()
                int r3 = r3.ordinal()
                r2 = r2[r3]
                r3 = 1
                r4 = -1
                r5 = 0
                if (r2 == r3) goto L_0x009c
                r3 = 2
                if (r2 == r3) goto L_0x0086
                r7 = 3
                if (r2 != r7) goto L_0x006b
                return r4
            L_0x006b:
                javax.net.ssl.SSLException r7 = new javax.net.ssl.SSLException
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                r8.<init>()
                java.lang.String r9 = "Unexpected engine result "
                r8.append(r9)
                javax.net.ssl.SSLEngineResult$Status r9 = r1.getStatus()
                r8.append(r9)
                java.lang.String r8 = r8.toString()
                r7.<init>(r8)
                throw r7
            L_0x0086:
                if (r0 != 0) goto L_0x00a3
                javax.net.ssl.SSLEngineResult$HandshakeStatus r0 = r1.getHandshakeStatus()
                boolean r0 = r6.isHandshaking(r0)
                if (r0 == 0) goto L_0x00a3
                boolean r0 = r6.isHandshakeFinished()
                if (r0 == 0) goto L_0x00a3
                r6.renegotiate()
                return r5
            L_0x009c:
                int r0 = r1.bytesProduced()
                if (r0 != 0) goto L_0x00a3
                goto L_0x00a4
            L_0x00a3:
                r3 = r5
            L_0x00a4:
                if (r3 != 0) goto L_0x00ad
                int r0 = r1.bytesProduced()
                if (r0 != 0) goto L_0x00ad
                return r5
            L_0x00ad:
                if (r3 == 0) goto L_0x000b
                int r0 = r6.readFromSocket()
                if (r0 != r4) goto L_0x000b
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: org.conscrypt.ConscryptEngineSocket.SSLInputStream.processDataFromSocket(byte[], int, int):int");
        }

        private boolean isHandshakeFinished() {
            boolean z;
            synchronized (ConscryptEngineSocket.this.stateLock) {
                z = ConscryptEngineSocket.this.state >= 4;
            }
            return z;
        }

        private void renegotiate() throws IOException {
            synchronized (ConscryptEngineSocket.this.handshakeLock) {
                ConscryptEngineSocket.this.doHandshake();
            }
        }

        private void init() throws IOException {
            if (this.socketInputStream == null) {
                this.socketInputStream = ConscryptEngineSocket.this.getUnderlyingInputStream();
            }
        }

        private int readFromSocket() throws IOException {
            try {
                int position = this.fromSocket.position();
                int read = this.socketInputStream.read(this.fromSocket.array(), this.fromSocketArrayOffset + position, this.fromSocket.limit() - position);
                if (read > 0) {
                    this.fromSocket.position(position + read);
                }
                return read;
            } catch (EOFException unused) {
                return -1;
            }
        }
    }

    /* renamed from: org.conscrypt.ConscryptEngineSocket$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus;
        static final /* synthetic */ int[] $SwitchMap$javax$net$ssl$SSLEngineResult$Status;

        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|(3:21|22|24)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|(3:21|22|24)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(20:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|21|22|24) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0058 */
        static {
            /*
                javax.net.ssl.SSLEngineResult$Status[] r0 = javax.net.ssl.SSLEngineResult.Status.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                org.conscrypt.ConscryptEngineSocket.AnonymousClass3.$SwitchMap$javax$net$ssl$SSLEngineResult$Status = r0
                r1 = 1
                javax.net.ssl.SSLEngineResult$Status r2 = javax.net.ssl.SSLEngineResult.Status.BUFFER_UNDERFLOW     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = org.conscrypt.ConscryptEngineSocket.AnonymousClass3.$SwitchMap$javax$net$ssl$SSLEngineResult$Status     // Catch:{ NoSuchFieldError -> 0x001d }
                javax.net.ssl.SSLEngineResult$Status r3 = javax.net.ssl.SSLEngineResult.Status.OK     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = org.conscrypt.ConscryptEngineSocket.AnonymousClass3.$SwitchMap$javax$net$ssl$SSLEngineResult$Status     // Catch:{ NoSuchFieldError -> 0x0028 }
                javax.net.ssl.SSLEngineResult$Status r4 = javax.net.ssl.SSLEngineResult.Status.CLOSED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                javax.net.ssl.SSLEngineResult$HandshakeStatus[] r3 = javax.net.ssl.SSLEngineResult.HandshakeStatus.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                org.conscrypt.ConscryptEngineSocket.AnonymousClass3.$SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus = r3
                javax.net.ssl.SSLEngineResult$HandshakeStatus r4 = javax.net.ssl.SSLEngineResult.HandshakeStatus.NEED_UNWRAP     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r1 = org.conscrypt.ConscryptEngineSocket.AnonymousClass3.$SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus     // Catch:{ NoSuchFieldError -> 0x0043 }
                javax.net.ssl.SSLEngineResult$HandshakeStatus r3 = javax.net.ssl.SSLEngineResult.HandshakeStatus.NEED_WRAP     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r0 = org.conscrypt.ConscryptEngineSocket.AnonymousClass3.$SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus     // Catch:{ NoSuchFieldError -> 0x004d }
                javax.net.ssl.SSLEngineResult$HandshakeStatus r1 = javax.net.ssl.SSLEngineResult.HandshakeStatus.NEED_TASK     // Catch:{ NoSuchFieldError -> 0x004d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                int[] r0 = org.conscrypt.ConscryptEngineSocket.AnonymousClass3.$SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus     // Catch:{ NoSuchFieldError -> 0x0058 }
                javax.net.ssl.SSLEngineResult$HandshakeStatus r1 = javax.net.ssl.SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                int[] r0 = org.conscrypt.ConscryptEngineSocket.AnonymousClass3.$SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus     // Catch:{ NoSuchFieldError -> 0x0063 }
                javax.net.ssl.SSLEngineResult$HandshakeStatus r1 = javax.net.ssl.SSLEngineResult.HandshakeStatus.FINISHED     // Catch:{ NoSuchFieldError -> 0x0063 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0063 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0063 }
            L_0x0063:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.conscrypt.ConscryptEngineSocket.AnonymousClass3.<clinit>():void");
        }
    }
}
