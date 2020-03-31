package org.conscrypt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ClientSessionContext extends AbstractSessionContext {
    private SSLClientSessionCache persistentCache;
    private final Map<HostAndPort, List<NativeSslSession>> sessionsByHostAndPort = new HashMap();

    /* access modifiers changed from: package-private */
    public NativeSslSession getSessionFromPersistentCache(byte[] bArr) {
        return null;
    }

    ClientSessionContext() {
        super(10);
    }

    public void setPersistentCache(SSLClientSessionCache sSLClientSessionCache) {
        this.persistentCache = sSLClientSessionCache;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0053, code lost:
        return r8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized org.conscrypt.NativeSslSession getCachedSession(java.lang.String r8, int r9, org.conscrypt.SSLParametersImpl r10) {
        /*
            r7 = this;
            monitor-enter(r7)
            r0 = 0
            if (r8 != 0) goto L_0x0006
            monitor-exit(r7)
            return r0
        L_0x0006:
            org.conscrypt.NativeSslSession r8 = r7.getSession(r8, r9)     // Catch:{ all -> 0x0054 }
            if (r8 != 0) goto L_0x000e
            monitor-exit(r7)
            return r0
        L_0x000e:
            java.lang.String r9 = r8.getProtocol()     // Catch:{ all -> 0x0054 }
            java.lang.String[] r1 = r10.enabledProtocols     // Catch:{ all -> 0x0054 }
            int r2 = r1.length     // Catch:{ all -> 0x0054 }
            r3 = 0
            r4 = r3
        L_0x0017:
            r5 = 1
            if (r4 >= r2) goto L_0x0027
            r6 = r1[r4]     // Catch:{ all -> 0x0054 }
            boolean r6 = r9.equals(r6)     // Catch:{ all -> 0x0054 }
            if (r6 == 0) goto L_0x0024
            r9 = r5
            goto L_0x0028
        L_0x0024:
            int r4 = r4 + 1
            goto L_0x0017
        L_0x0027:
            r9 = r3
        L_0x0028:
            if (r9 != 0) goto L_0x002c
            monitor-exit(r7)
            return r0
        L_0x002c:
            java.lang.String r9 = r8.getCipherSuite()     // Catch:{ all -> 0x0054 }
            java.lang.String[] r10 = r10.getEnabledCipherSuites()     // Catch:{ all -> 0x0054 }
            int r1 = r10.length     // Catch:{ all -> 0x0054 }
            r2 = r3
        L_0x0036:
            if (r2 >= r1) goto L_0x0045
            r4 = r10[r2]     // Catch:{ all -> 0x0054 }
            boolean r4 = r9.equals(r4)     // Catch:{ all -> 0x0054 }
            if (r4 == 0) goto L_0x0042
            r3 = r5
            goto L_0x0045
        L_0x0042:
            int r2 = r2 + 1
            goto L_0x0036
        L_0x0045:
            if (r3 != 0) goto L_0x0049
            monitor-exit(r7)
            return r0
        L_0x0049:
            boolean r9 = r8.isSingleUse()     // Catch:{ all -> 0x0054 }
            if (r9 == 0) goto L_0x0052
            r7.removeSession(r8)     // Catch:{ all -> 0x0054 }
        L_0x0052:
            monitor-exit(r7)
            return r8
        L_0x0054:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.conscrypt.ClientSessionContext.getCachedSession(java.lang.String, int, org.conscrypt.SSLParametersImpl):org.conscrypt.NativeSslSession");
    }

    /* access modifiers changed from: package-private */
    public int size() {
        int i;
        synchronized (this.sessionsByHostAndPort) {
            i = 0;
            for (List<NativeSslSession> size : this.sessionsByHostAndPort.values()) {
                i += size.size();
            }
        }
        return i;
    }

    private NativeSslSession getSession(String str, int i) {
        NativeSslSession nativeSslSession;
        byte[] sessionData;
        NativeSslSession newInstance;
        if (str == null) {
            return null;
        }
        HostAndPort hostAndPort = new HostAndPort(str, i);
        synchronized (this.sessionsByHostAndPort) {
            List list = this.sessionsByHostAndPort.get(hostAndPort);
            nativeSslSession = (list == null || list.size() <= 0) ? null : (NativeSslSession) list.get(0);
        }
        if (nativeSslSession != null && nativeSslSession.isValid()) {
            return nativeSslSession;
        }
        SSLClientSessionCache sSLClientSessionCache = this.persistentCache;
        if (sSLClientSessionCache == null || (sessionData = sSLClientSessionCache.getSessionData(str, i)) == null || (newInstance = NativeSslSession.newInstance(super, sessionData, str, i)) == null || !newInstance.isValid()) {
            return null;
        }
        putSession(hostAndPort, newInstance);
        return newInstance;
    }

    private void putSession(HostAndPort hostAndPort, NativeSslSession nativeSslSession) {
        synchronized (this.sessionsByHostAndPort) {
            List list = this.sessionsByHostAndPort.get(hostAndPort);
            if (list == null) {
                list = new ArrayList();
                this.sessionsByHostAndPort.put(hostAndPort, list);
            }
            if (list.size() > 0 && ((NativeSslSession) list.get(0)).isSingleUse() != nativeSslSession.isSingleUse()) {
                while (!list.isEmpty()) {
                    removeSession((NativeSslSession) list.get(0));
                }
                this.sessionsByHostAndPort.put(hostAndPort, list);
            }
            list.add(nativeSslSession);
        }
    }

    private void removeSession(HostAndPort hostAndPort, NativeSslSession nativeSslSession) {
        synchronized (this.sessionsByHostAndPort) {
            List list = this.sessionsByHostAndPort.get(hostAndPort);
            if (list != null) {
                list.remove(nativeSslSession);
                if (list.isEmpty()) {
                    this.sessionsByHostAndPort.remove(hostAndPort);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void onBeforeAddSession(NativeSslSession nativeSslSession) {
        byte[] bytes;
        String peerHost = nativeSslSession.getPeerHost();
        int peerPort = nativeSslSession.getPeerPort();
        if (peerHost != null) {
            putSession(new HostAndPort(peerHost, peerPort), nativeSslSession);
            if (this.persistentCache != null && !nativeSslSession.isSingleUse() && (bytes = nativeSslSession.toBytes()) != null) {
                this.persistentCache.putSessionData(nativeSslSession.toSSLSession(), bytes);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void onBeforeRemoveSession(NativeSslSession nativeSslSession) {
        String peerHost = nativeSslSession.getPeerHost();
        if (peerHost != null) {
            removeSession(new HostAndPort(peerHost, nativeSslSession.getPeerPort()), nativeSslSession);
        }
    }

    private static final class HostAndPort {
        final String host;
        final int port;

        HostAndPort(String str, int i) {
            this.host = str;
            this.port = i;
        }

        public int hashCode() {
            return (this.host.hashCode() * 31) + this.port;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof HostAndPort)) {
                return false;
            }
            HostAndPort hostAndPort = (HostAndPort) obj;
            if (!this.host.equals(hostAndPort.host) || this.port != hostAndPort.port) {
                return false;
            }
            return true;
        }
    }
}
