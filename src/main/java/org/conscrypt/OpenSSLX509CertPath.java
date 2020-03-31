package org.conscrypt;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.security.cert.CertPath;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.conscrypt.OpenSSLX509CertificateFactory;

final class OpenSSLX509CertPath extends CertPath {
    private static final List<String> ALL_ENCODINGS = Collections.unmodifiableList(Arrays.asList(Encoding.PKI_PATH.apiName, Encoding.PKCS7.apiName));
    private static final Encoding DEFAULT_ENCODING = Encoding.PKI_PATH;
    private static final byte[] PKCS7_MARKER = {45, 45, 45, 45, 45, 66, 69, 71, 73, 78, 32, 80, 75, 67, 83, 55};
    private static final int PUSHBACK_SIZE = 64;
    private static final long serialVersionUID = -3249106005255170761L;
    private final List<? extends X509Certificate> mCertificates;

    private enum Encoding {
        PKI_PATH("PkiPath"),
        PKCS7("PKCS7");
        
        /* access modifiers changed from: private */
        public final String apiName;

        private Encoding(String str) {
            this.apiName = str;
        }

        static Encoding findByApiName(String str) throws CertificateEncodingException {
            for (Encoding encoding : values()) {
                if (encoding.apiName.equals(str)) {
                    return encoding;
                }
            }
            return null;
        }
    }

    static Iterator<String> getEncodingsIterator() {
        return ALL_ENCODINGS.iterator();
    }

    OpenSSLX509CertPath(List<? extends X509Certificate> list) {
        super("X.509");
        this.mCertificates = list;
    }

    public List<? extends Certificate> getCertificates() {
        return Collections.unmodifiableList(this.mCertificates);
    }

    private byte[] getEncoded(Encoding encoding) throws CertificateEncodingException {
        int size = this.mCertificates.size();
        OpenSSLX509Certificate[] openSSLX509CertificateArr = new OpenSSLX509Certificate[size];
        long[] jArr = new long[size];
        int i = 0;
        for (int i2 = size - 1; i2 >= 0; i2--) {
            X509Certificate x509Certificate = (X509Certificate) this.mCertificates.get(i);
            if (x509Certificate instanceof OpenSSLX509Certificate) {
                openSSLX509CertificateArr[i2] = (OpenSSLX509Certificate) x509Certificate;
            } else {
                openSSLX509CertificateArr[i2] = OpenSSLX509Certificate.fromX509Der(x509Certificate.getEncoded());
            }
            jArr[i2] = openSSLX509CertificateArr[i2].getContext();
            i++;
        }
        int i3 = AnonymousClass1.$SwitchMap$org$conscrypt$OpenSSLX509CertPath$Encoding[encoding.ordinal()];
        if (i3 == 1) {
            return NativeCrypto.ASN1_seq_pack_X509(jArr);
        }
        if (i3 == 2) {
            return NativeCrypto.i2d_PKCS7(jArr);
        }
        throw new CertificateEncodingException("Unknown encoding");
    }

    /* renamed from: org.conscrypt.OpenSSLX509CertPath$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$conscrypt$OpenSSLX509CertPath$Encoding;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                org.conscrypt.OpenSSLX509CertPath$Encoding[] r0 = org.conscrypt.OpenSSLX509CertPath.Encoding.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                org.conscrypt.OpenSSLX509CertPath.AnonymousClass1.$SwitchMap$org$conscrypt$OpenSSLX509CertPath$Encoding = r0
                org.conscrypt.OpenSSLX509CertPath$Encoding r1 = org.conscrypt.OpenSSLX509CertPath.Encoding.PKI_PATH     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = org.conscrypt.OpenSSLX509CertPath.AnonymousClass1.$SwitchMap$org$conscrypt$OpenSSLX509CertPath$Encoding     // Catch:{ NoSuchFieldError -> 0x001d }
                org.conscrypt.OpenSSLX509CertPath$Encoding r1 = org.conscrypt.OpenSSLX509CertPath.Encoding.PKCS7     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.conscrypt.OpenSSLX509CertPath.AnonymousClass1.<clinit>():void");
        }
    }

    public byte[] getEncoded() throws CertificateEncodingException {
        return getEncoded(DEFAULT_ENCODING);
    }

    public byte[] getEncoded(String str) throws CertificateEncodingException {
        Encoding findByApiName = Encoding.findByApiName(str);
        if (findByApiName != null) {
            return getEncoded(findByApiName);
        }
        throw new CertificateEncodingException("Invalid encoding: " + str);
    }

    public Iterator<String> getEncodings() {
        return getEncodingsIterator();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:22|(2:24|25)|26|27|28) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x005d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.security.cert.CertPath fromPkiPathEncoding(java.io.InputStream r7) throws java.security.cert.CertificateException {
        /*
            org.conscrypt.OpenSSLBIOInputStream r0 = new org.conscrypt.OpenSSLBIOInputStream
            r1 = 1
            r0.<init>(r7, r1)
            boolean r2 = r7.markSupported()
            if (r2 == 0) goto L_0x0011
            r3 = 64
            r7.mark(r3)
        L_0x0011:
            long r3 = r0.getBioContext()     // Catch:{ Exception -> 0x0057 }
            long[] r7 = org.conscrypt.NativeCrypto.ASN1_seq_unpack_X509_bio(r3)     // Catch:{ Exception -> 0x0057 }
            r0.release()
            if (r7 != 0) goto L_0x0028
            org.conscrypt.OpenSSLX509CertPath r7 = new org.conscrypt.OpenSSLX509CertPath
            java.util.List r0 = java.util.Collections.emptyList()
            r7.<init>(r0)
            return r7
        L_0x0028:
            java.util.ArrayList r0 = new java.util.ArrayList
            int r2 = r7.length
            r0.<init>(r2)
            int r2 = r7.length
            int r2 = r2 - r1
        L_0x0030:
            if (r2 < 0) goto L_0x004f
            r3 = r7[r2]
            r5 = 0
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x003b
            goto L_0x0045
        L_0x003b:
            org.conscrypt.OpenSSLX509Certificate r1 = new org.conscrypt.OpenSSLX509Certificate     // Catch:{ ParsingException -> 0x0048 }
            r3 = r7[r2]     // Catch:{ ParsingException -> 0x0048 }
            r1.<init>(r3)     // Catch:{ ParsingException -> 0x0048 }
            r0.add(r1)     // Catch:{ ParsingException -> 0x0048 }
        L_0x0045:
            int r2 = r2 + -1
            goto L_0x0030
        L_0x0048:
            r7 = move-exception
            java.security.cert.CertificateParsingException r0 = new java.security.cert.CertificateParsingException
            r0.<init>(r7)
            throw r0
        L_0x004f:
            org.conscrypt.OpenSSLX509CertPath r7 = new org.conscrypt.OpenSSLX509CertPath
            r7.<init>(r0)
            return r7
        L_0x0055:
            r7 = move-exception
            goto L_0x0063
        L_0x0057:
            r1 = move-exception
            if (r2 == 0) goto L_0x005d
            r7.reset()     // Catch:{ IOException -> 0x005d }
        L_0x005d:
            java.security.cert.CertificateException r7 = new java.security.cert.CertificateException     // Catch:{ all -> 0x0055 }
            r7.<init>(r1)     // Catch:{ all -> 0x0055 }
            throw r7     // Catch:{ all -> 0x0055 }
        L_0x0063:
            r0.release()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.conscrypt.OpenSSLX509CertPath.fromPkiPathEncoding(java.io.InputStream):java.security.cert.CertPath");
    }

    private static CertPath fromPkcs7Encoding(InputStream inputStream) throws CertificateException {
        if (inputStream != null) {
            try {
                if (inputStream.available() != 0) {
                    boolean markSupported = inputStream.markSupported();
                    if (markSupported) {
                        inputStream.mark(64);
                    }
                    PushbackInputStream pushbackInputStream = new PushbackInputStream(inputStream, 64);
                    try {
                        byte[] bArr = new byte[PKCS7_MARKER.length];
                        int read = pushbackInputStream.read(bArr);
                        if (read >= 0) {
                            pushbackInputStream.unread(bArr, 0, read);
                            if (read != PKCS7_MARKER.length || !Arrays.equals(PKCS7_MARKER, bArr)) {
                                return new OpenSSLX509CertPath(OpenSSLX509Certificate.fromPkcs7DerInputStream(pushbackInputStream));
                            }
                            return new OpenSSLX509CertPath(OpenSSLX509Certificate.fromPkcs7PemInputStream(pushbackInputStream));
                        }
                        throw new OpenSSLX509CertificateFactory.ParsingException("inStream is empty");
                    } catch (Exception e) {
                        if (markSupported) {
                            try {
                                inputStream.reset();
                            } catch (IOException unused) {
                            }
                        }
                        throw new CertificateException(e);
                    }
                }
            } catch (IOException e2) {
                throw new CertificateException("Problem reading input stream", e2);
            }
        }
        return new OpenSSLX509CertPath(Collections.emptyList());
    }

    private static CertPath fromEncoding(InputStream inputStream, Encoding encoding) throws CertificateException {
        int i = AnonymousClass1.$SwitchMap$org$conscrypt$OpenSSLX509CertPath$Encoding[encoding.ordinal()];
        if (i == 1) {
            return fromPkiPathEncoding(inputStream);
        }
        if (i == 2) {
            return fromPkcs7Encoding(inputStream);
        }
        throw new CertificateEncodingException("Unknown encoding");
    }

    static CertPath fromEncoding(InputStream inputStream, String str) throws CertificateException {
        if (inputStream != null) {
            Encoding findByApiName = Encoding.findByApiName(str);
            if (findByApiName != null) {
                return fromEncoding(inputStream, findByApiName);
            }
            throw new CertificateException("Invalid encoding: " + str);
        }
        throw new CertificateException("inStream == null");
    }

    static CertPath fromEncoding(InputStream inputStream) throws CertificateException {
        if (inputStream != null) {
            return fromEncoding(inputStream, DEFAULT_ENCODING);
        }
        throw new CertificateException("inStream == null");
    }
}
