package org.conscrypt;

import java.io.IOException;
import java.security.AlgorithmParametersSpi;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;

public final class GCMParameters extends AlgorithmParametersSpi {
    private static final int DEFAULT_TLEN = 96;
    private byte[] iv;
    private int tLen;

    /* access modifiers changed from: protected */
    public String engineToString() {
        return "Conscrypt GCM AlgorithmParameters";
    }

    public GCMParameters() {
    }

    GCMParameters(int i, byte[] bArr) {
        this.tLen = i;
        this.iv = bArr;
    }

    /* access modifiers changed from: package-private */
    public int getTLen() {
        return this.tLen;
    }

    /* access modifiers changed from: package-private */
    public byte[] getIV() {
        return this.iv;
    }

    /* access modifiers changed from: protected */
    public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
        GCMParameters fromGCMParameterSpec = Platform.fromGCMParameterSpec(algorithmParameterSpec);
        if (fromGCMParameterSpec != null) {
            this.tLen = fromGCMParameterSpec.tLen;
            this.iv = fromGCMParameterSpec.iv;
            return;
        }
        throw new InvalidParameterSpecException("Only GCMParameterSpec is supported");
    }

    /* access modifiers changed from: protected */
    public void engineInit(byte[] bArr) throws IOException {
        long j;
        long j2 = 0;
        try {
            j = NativeCrypto.asn1_read_init(bArr);
            try {
                j2 = NativeCrypto.asn1_read_sequence(j);
                byte[] asn1_read_octetstring = NativeCrypto.asn1_read_octetstring(j2);
                int i = 96;
                if (!NativeCrypto.asn1_read_is_empty(j2)) {
                    i = ((int) NativeCrypto.asn1_read_uint64(j2)) * 8;
                }
                if (!NativeCrypto.asn1_read_is_empty(j2) || !NativeCrypto.asn1_read_is_empty(j)) {
                    throw new IOException("Error reading ASN.1 encoding");
                }
                this.iv = asn1_read_octetstring;
                this.tLen = i;
                NativeCrypto.asn1_read_free(j2);
                NativeCrypto.asn1_read_free(j);
            } catch (Throwable th) {
                th = th;
                NativeCrypto.asn1_read_free(j2);
                NativeCrypto.asn1_read_free(j);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            j = 0;
            NativeCrypto.asn1_read_free(j2);
            NativeCrypto.asn1_read_free(j);
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public void engineInit(byte[] bArr, String str) throws IOException {
        if (str == null || str.equals("ASN.1")) {
            engineInit(bArr);
            return;
        }
        throw new IOException("Unsupported format: " + str);
    }

    /* access modifiers changed from: protected */
    public <T extends AlgorithmParameterSpec> T engineGetParameterSpec(Class<T> cls) throws InvalidParameterSpecException {
        if (cls != null && cls.getName().equals("javax.crypto.spec.GCMParameterSpec")) {
            return (AlgorithmParameterSpec) cls.cast(Platform.toGCMParameterSpec(this.tLen, this.iv));
        }
        throw new InvalidParameterSpecException("Unsupported class: " + cls);
    }

    /* access modifiers changed from: protected */
    public byte[] engineGetEncoded() throws IOException {
        long j;
        long j2;
        long j3 = 0;
        try {
            j = NativeCrypto.asn1_write_init();
            try {
                long asn1_write_sequence = NativeCrypto.asn1_write_sequence(j);
                NativeCrypto.asn1_write_octetstring(asn1_write_sequence, this.iv);
                if (this.tLen != 96) {
                    NativeCrypto.asn1_write_uint64(asn1_write_sequence, (long) (this.tLen / 8));
                }
                byte[] asn1_write_finish = NativeCrypto.asn1_write_finish(j);
                NativeCrypto.asn1_write_free(asn1_write_sequence);
                NativeCrypto.asn1_write_free(j);
                return asn1_write_finish;
            } catch (IOException e) {
                e = e;
                j3 = j;
                j2 = 0;
                try {
                    NativeCrypto.asn1_write_cleanup(j3);
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    long j4 = j3;
                    j3 = j2;
                    j = j4;
                    NativeCrypto.asn1_write_free(j3);
                    NativeCrypto.asn1_write_free(j);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                NativeCrypto.asn1_write_free(j3);
                NativeCrypto.asn1_write_free(j);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            j2 = 0;
            NativeCrypto.asn1_write_cleanup(j3);
            throw e;
        } catch (Throwable th3) {
            th = th3;
            j = 0;
            NativeCrypto.asn1_write_free(j3);
            NativeCrypto.asn1_write_free(j);
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public byte[] engineGetEncoded(String str) throws IOException {
        if (str == null || str.equals("ASN.1")) {
            return engineGetEncoded();
        }
        throw new IOException("Unsupported format: " + str);
    }
}
