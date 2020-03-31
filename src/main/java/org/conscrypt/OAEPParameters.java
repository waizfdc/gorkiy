package org.conscrypt;

import io.fabric.sdk.android.services.common.CommonUtils;
import java.io.IOException;
import java.security.AlgorithmParametersSpi;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.MGF1ParameterSpec;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;

public class OAEPParameters extends AlgorithmParametersSpi {
    private static final String MGF1_OID = "1.2.840.113549.1.1.8";
    private static final Map<String, String> NAME_TO_OID = new HashMap();
    private static final Map<String, String> OID_TO_NAME = new HashMap();
    private static final String PSPECIFIED_OID = "1.2.840.113549.1.1.9";
    private OAEPParameterSpec spec = OAEPParameterSpec.DEFAULT;

    /* access modifiers changed from: protected */
    public String engineToString() {
        return "Conscrypt OAEP AlgorithmParameters";
    }

    static {
        OID_TO_NAME.put("1.3.14.3.2.26", CommonUtils.SHA1_INSTANCE);
        OID_TO_NAME.put("2.16.840.1.101.3.4.2.4", "SHA-224");
        OID_TO_NAME.put("2.16.840.1.101.3.4.2.1", CommonUtils.SHA256_INSTANCE);
        OID_TO_NAME.put("2.16.840.1.101.3.4.2.2", "SHA-384");
        OID_TO_NAME.put("2.16.840.1.101.3.4.2.3", "SHA-512");
        for (Map.Entry next : OID_TO_NAME.entrySet()) {
            NAME_TO_OID.put(next.getValue(), next.getKey());
        }
    }

    /* access modifiers changed from: protected */
    public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
        if (algorithmParameterSpec instanceof OAEPParameterSpec) {
            this.spec = (OAEPParameterSpec) algorithmParameterSpec;
            return;
        }
        throw new InvalidParameterSpecException("Only OAEPParameterSpec is supported");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:26:0x0057=Splitter:B:26:0x0057, B:36:0x007f=Splitter:B:36:0x007f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void engineInit(byte[] r13) throws java.io.IOException {
        /*
            r12 = this;
            r0 = 0
            long r2 = org.conscrypt.NativeCrypto.asn1_read_init(r13)     // Catch:{ all -> 0x008a }
            long r4 = org.conscrypt.NativeCrypto.asn1_read_sequence(r2)     // Catch:{ all -> 0x0088 }
            javax.crypto.spec.PSource$PSpecified r13 = javax.crypto.spec.PSource.PSpecified.DEFAULT     // Catch:{ all -> 0x0085 }
            java.lang.String r6 = readHash(r4)     // Catch:{ all -> 0x0085 }
            java.lang.String r7 = readMgfHash(r4)     // Catch:{ all -> 0x0085 }
            r8 = 2
            boolean r8 = org.conscrypt.NativeCrypto.asn1_read_next_tag_is(r4, r8)     // Catch:{ all -> 0x0085 }
            java.lang.String r9 = "Error reading ASN.1 encoding"
            if (r8 == 0) goto L_0x005e
            long r10 = org.conscrypt.NativeCrypto.asn1_read_tagged(r4)     // Catch:{ all -> 0x0055 }
            long r0 = org.conscrypt.NativeCrypto.asn1_read_sequence(r10)     // Catch:{ all -> 0x0053 }
            java.lang.String r13 = org.conscrypt.NativeCrypto.asn1_read_oid(r0)     // Catch:{ all -> 0x0053 }
            java.lang.String r8 = "1.2.840.113549.1.1.9"
            boolean r13 = r13.equals(r8)     // Catch:{ all -> 0x0053 }
            if (r13 == 0) goto L_0x004d
            javax.crypto.spec.PSource$PSpecified r13 = new javax.crypto.spec.PSource$PSpecified     // Catch:{ all -> 0x0053 }
            byte[] r8 = org.conscrypt.NativeCrypto.asn1_read_octetstring(r0)     // Catch:{ all -> 0x0053 }
            r13.<init>(r8)     // Catch:{ all -> 0x0053 }
            boolean r8 = org.conscrypt.NativeCrypto.asn1_read_is_empty(r0)     // Catch:{ all -> 0x0053 }
            if (r8 == 0) goto L_0x0047
            org.conscrypt.NativeCrypto.asn1_read_free(r0)     // Catch:{ all -> 0x0085 }
            org.conscrypt.NativeCrypto.asn1_read_free(r10)     // Catch:{ all -> 0x0085 }
            goto L_0x005e
        L_0x0047:
            java.io.IOException r13 = new java.io.IOException     // Catch:{ all -> 0x0053 }
            r13.<init>(r9)     // Catch:{ all -> 0x0053 }
            throw r13     // Catch:{ all -> 0x0053 }
        L_0x004d:
            java.io.IOException r13 = new java.io.IOException     // Catch:{ all -> 0x0053 }
            r13.<init>(r9)     // Catch:{ all -> 0x0053 }
            throw r13     // Catch:{ all -> 0x0053 }
        L_0x0053:
            r13 = move-exception
            goto L_0x0057
        L_0x0055:
            r13 = move-exception
            r10 = r0
        L_0x0057:
            org.conscrypt.NativeCrypto.asn1_read_free(r0)     // Catch:{ all -> 0x0085 }
            org.conscrypt.NativeCrypto.asn1_read_free(r10)     // Catch:{ all -> 0x0085 }
            throw r13     // Catch:{ all -> 0x0085 }
        L_0x005e:
            boolean r0 = org.conscrypt.NativeCrypto.asn1_read_is_empty(r4)     // Catch:{ all -> 0x0085 }
            if (r0 == 0) goto L_0x007f
            boolean r0 = org.conscrypt.NativeCrypto.asn1_read_is_empty(r2)     // Catch:{ all -> 0x0085 }
            if (r0 == 0) goto L_0x007f
            javax.crypto.spec.OAEPParameterSpec r0 = new javax.crypto.spec.OAEPParameterSpec     // Catch:{ all -> 0x0085 }
            java.lang.String r1 = "MGF1"
            java.security.spec.MGF1ParameterSpec r8 = new java.security.spec.MGF1ParameterSpec     // Catch:{ all -> 0x0085 }
            r8.<init>(r7)     // Catch:{ all -> 0x0085 }
            r0.<init>(r6, r1, r8, r13)     // Catch:{ all -> 0x0085 }
            r12.spec = r0     // Catch:{ all -> 0x0085 }
            org.conscrypt.NativeCrypto.asn1_read_free(r4)
            org.conscrypt.NativeCrypto.asn1_read_free(r2)
            return
        L_0x007f:
            java.io.IOException r13 = new java.io.IOException     // Catch:{ all -> 0x0085 }
            r13.<init>(r9)     // Catch:{ all -> 0x0085 }
            throw r13     // Catch:{ all -> 0x0085 }
        L_0x0085:
            r13 = move-exception
            r0 = r4
            goto L_0x008c
        L_0x0088:
            r13 = move-exception
            goto L_0x008c
        L_0x008a:
            r13 = move-exception
            r2 = r0
        L_0x008c:
            org.conscrypt.NativeCrypto.asn1_read_free(r0)
            org.conscrypt.NativeCrypto.asn1_read_free(r2)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: org.conscrypt.OAEPParameters.engineInit(byte[]):void");
    }

    /* access modifiers changed from: protected */
    public void engineInit(byte[] bArr, String str) throws IOException {
        if (str == null || str.equals("ASN.1")) {
            engineInit(bArr);
            return;
        }
        throw new IOException("Unsupported format: " + str);
    }

    static String readHash(long j) throws IOException {
        if (!NativeCrypto.asn1_read_next_tag_is(j, 0)) {
            return CommonUtils.SHA1_INSTANCE;
        }
        long j2 = 0;
        try {
            j2 = NativeCrypto.asn1_read_tagged(j);
            return getHashName(j2);
        } finally {
            NativeCrypto.asn1_read_free(j2);
        }
    }

    static String readMgfHash(long j) throws IOException {
        long j2;
        if (!NativeCrypto.asn1_read_next_tag_is(j, 1)) {
            return CommonUtils.SHA1_INSTANCE;
        }
        long j3 = 0;
        try {
            j2 = NativeCrypto.asn1_read_tagged(j);
            try {
                j3 = NativeCrypto.asn1_read_sequence(j2);
                if (NativeCrypto.asn1_read_oid(j3).equals(MGF1_OID)) {
                    String hashName = getHashName(j3);
                    if (NativeCrypto.asn1_read_is_empty(j3)) {
                        NativeCrypto.asn1_read_free(j3);
                        NativeCrypto.asn1_read_free(j2);
                        return hashName;
                    }
                    throw new IOException("Error reading ASN.1 encoding");
                }
                throw new IOException("Error reading ASN.1 encoding");
            } catch (Throwable th) {
                th = th;
                NativeCrypto.asn1_read_free(j3);
                NativeCrypto.asn1_read_free(j2);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            j2 = 0;
            NativeCrypto.asn1_read_free(j3);
            NativeCrypto.asn1_read_free(j2);
            throw th;
        }
    }

    private static String getHashName(long j) throws IOException {
        long j2;
        try {
            j2 = NativeCrypto.asn1_read_sequence(j);
            try {
                String asn1_read_oid = NativeCrypto.asn1_read_oid(j2);
                if (!NativeCrypto.asn1_read_is_empty(j2)) {
                    NativeCrypto.asn1_read_null(j2);
                }
                if (!NativeCrypto.asn1_read_is_empty(j2) || !OID_TO_NAME.containsKey(asn1_read_oid)) {
                    throw new IOException("Error reading ASN.1 encoding");
                }
                String str = OID_TO_NAME.get(asn1_read_oid);
                NativeCrypto.asn1_read_free(j2);
                return str;
            } catch (Throwable th) {
                th = th;
                NativeCrypto.asn1_read_free(j2);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            j2 = 0;
            NativeCrypto.asn1_read_free(j2);
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public <T extends AlgorithmParameterSpec> T engineGetParameterSpec(Class<T> cls) throws InvalidParameterSpecException {
        if (cls != null && cls == OAEPParameterSpec.class) {
            return this.spec;
        }
        throw new InvalidParameterSpecException("Unsupported class: " + cls);
    }

    /* access modifiers changed from: protected */
    public byte[] engineGetEncoded() throws IOException {
        long j;
        long j2;
        IOException e;
        long j3;
        long j4 = 0;
        try {
            j2 = NativeCrypto.asn1_write_init();
            try {
                j = NativeCrypto.asn1_write_sequence(j2);
            } catch (IOException e2) {
                e = e2;
                j = 0;
                try {
                    NativeCrypto.asn1_write_cleanup(j2);
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    NativeCrypto.asn1_write_free(j);
                    NativeCrypto.asn1_write_free(j2);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                j = 0;
                NativeCrypto.asn1_write_free(j);
                NativeCrypto.asn1_write_free(j2);
                throw th;
            }
            try {
                writeHashAndMgfHash(j, this.spec.getDigestAlgorithm(), (MGF1ParameterSpec) this.spec.getMGFParameters());
                PSource.PSpecified pSpecified = (PSource.PSpecified) this.spec.getPSource();
                if (pSpecified.getValue().length != 0) {
                    try {
                        j3 = NativeCrypto.asn1_write_tag(j, 2);
                        try {
                            j4 = writeAlgorithmIdentifier(j3, PSPECIFIED_OID);
                            NativeCrypto.asn1_write_octetstring(j4, pSpecified.getValue());
                            NativeCrypto.asn1_write_flush(j);
                            NativeCrypto.asn1_write_free(j4);
                            NativeCrypto.asn1_write_free(j3);
                        } catch (Throwable th3) {
                            th = th3;
                            NativeCrypto.asn1_write_flush(j);
                            NativeCrypto.asn1_write_free(j4);
                            NativeCrypto.asn1_write_free(j3);
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        j3 = 0;
                        NativeCrypto.asn1_write_flush(j);
                        NativeCrypto.asn1_write_free(j4);
                        NativeCrypto.asn1_write_free(j3);
                        throw th;
                    }
                }
                byte[] asn1_write_finish = NativeCrypto.asn1_write_finish(j2);
                NativeCrypto.asn1_write_free(j);
                NativeCrypto.asn1_write_free(j2);
                return asn1_write_finish;
            } catch (IOException e3) {
                e = e3;
                NativeCrypto.asn1_write_cleanup(j2);
                throw e;
            }
        } catch (IOException e4) {
            j = 0;
            e = e4;
            j2 = 0;
            NativeCrypto.asn1_write_cleanup(j2);
            throw e;
        } catch (Throwable th5) {
            j = 0;
            th = th5;
            j2 = 0;
            NativeCrypto.asn1_write_free(j);
            NativeCrypto.asn1_write_free(j2);
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

    static void writeHashAndMgfHash(long j, String str, MGF1ParameterSpec mGF1ParameterSpec) throws IOException {
        long j2;
        long j3;
        long j4;
        long writeAlgorithmIdentifier;
        long j5 = 0;
        if (!str.equals(CommonUtils.SHA1_INSTANCE)) {
            try {
                j4 = NativeCrypto.asn1_write_tag(j, 0);
                try {
                    writeAlgorithmIdentifier = writeAlgorithmIdentifier(j4, NAME_TO_OID.get(str));
                } catch (Throwable th) {
                    th = th;
                    NativeCrypto.asn1_write_flush(j);
                    NativeCrypto.asn1_write_free(j5);
                    NativeCrypto.asn1_write_free(j4);
                    throw th;
                }
                try {
                    NativeCrypto.asn1_write_null(writeAlgorithmIdentifier);
                    NativeCrypto.asn1_write_flush(j);
                    NativeCrypto.asn1_write_free(writeAlgorithmIdentifier);
                    NativeCrypto.asn1_write_free(j4);
                } catch (Throwable th2) {
                    th = th2;
                    j5 = writeAlgorithmIdentifier;
                    NativeCrypto.asn1_write_flush(j);
                    NativeCrypto.asn1_write_free(j5);
                    NativeCrypto.asn1_write_free(j4);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                j4 = 0;
                NativeCrypto.asn1_write_flush(j);
                NativeCrypto.asn1_write_free(j5);
                NativeCrypto.asn1_write_free(j4);
                throw th;
            }
        }
        if (!mGF1ParameterSpec.getDigestAlgorithm().equals(CommonUtils.SHA1_INSTANCE)) {
            try {
                j3 = NativeCrypto.asn1_write_tag(j, 1);
                try {
                    j2 = writeAlgorithmIdentifier(j3, MGF1_OID);
                    try {
                        j5 = writeAlgorithmIdentifier(j2, NAME_TO_OID.get(mGF1ParameterSpec.getDigestAlgorithm()));
                        NativeCrypto.asn1_write_null(j5);
                        NativeCrypto.asn1_write_flush(j);
                        NativeCrypto.asn1_write_free(j5);
                        NativeCrypto.asn1_write_free(j2);
                        NativeCrypto.asn1_write_free(j3);
                    } catch (Throwable th4) {
                        th = th4;
                        NativeCrypto.asn1_write_flush(j);
                        NativeCrypto.asn1_write_free(j5);
                        NativeCrypto.asn1_write_free(j2);
                        NativeCrypto.asn1_write_free(j3);
                        throw th;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    j2 = 0;
                    NativeCrypto.asn1_write_flush(j);
                    NativeCrypto.asn1_write_free(j5);
                    NativeCrypto.asn1_write_free(j2);
                    NativeCrypto.asn1_write_free(j3);
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
                j3 = 0;
                j2 = 0;
                NativeCrypto.asn1_write_flush(j);
                NativeCrypto.asn1_write_free(j5);
                NativeCrypto.asn1_write_free(j2);
                NativeCrypto.asn1_write_free(j3);
                throw th;
            }
        }
    }

    private static long writeAlgorithmIdentifier(long j, String str) throws IOException {
        long j2;
        try {
            j2 = NativeCrypto.asn1_write_sequence(j);
            try {
                NativeCrypto.asn1_write_oid(j2, str);
                return j2;
            } catch (IOException e) {
                e = e;
                NativeCrypto.asn1_write_free(j2);
                throw e;
            }
        } catch (IOException e2) {
            e = e2;
            j2 = 0;
            NativeCrypto.asn1_write_free(j2);
            throw e;
        }
    }
}
