package org.conscrypt;

import com.google.android.gms.stats.CodePackage;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import org.conscrypt.OpenSSLCipher;

public abstract class OpenSSLAeadCipherAES extends OpenSSLAeadCipher {
    private static final int AES_BLOCK_SIZE = 16;

    /* access modifiers changed from: package-private */
    public String getBaseCipherName() {
        return "AES";
    }

    /* access modifiers changed from: package-private */
    public int getCipherBlockSize() {
        return 16;
    }

    OpenSSLAeadCipherAES(OpenSSLCipher.Mode mode) {
        super(mode);
    }

    /* access modifiers changed from: package-private */
    public void checkSupportedKeySize(int i) throws InvalidKeyException {
        if (i != 16 && i != 32) {
            throw new InvalidKeyException("Unsupported key size: " + i + " bytes (must be 16 or 32)");
        }
    }

    /* access modifiers changed from: protected */
    public AlgorithmParameterSpec getParameterSpec(AlgorithmParameters algorithmParameters) throws InvalidAlgorithmParameterException {
        if (algorithmParameters == null) {
            return null;
        }
        AlgorithmParameterSpec fromGCMParameters = Platform.fromGCMParameters(algorithmParameters);
        if (fromGCMParameters != null) {
            return fromGCMParameters;
        }
        return super.getParameterSpec(algorithmParameters);
    }

    /* access modifiers changed from: protected */
    public AlgorithmParameters engineGetParameters() {
        if (this.iv == null) {
            return null;
        }
        AlgorithmParameterSpec gCMParameterSpec = Platform.toGCMParameterSpec(this.tagLengthInBytes * 8, this.iv);
        if (gCMParameterSpec == null) {
            return super.engineGetParameters();
        }
        try {
            AlgorithmParameters instance = AlgorithmParameters.getInstance(CodePackage.GCM);
            instance.init(gCMParameterSpec);
            return instance;
        } catch (NoSuchAlgorithmException e) {
            throw ((Error) new AssertionError("GCM not supported").initCause(e));
        } catch (InvalidParameterSpecException unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public int getOutputSizeForFinal(int i) {
        if (isEncrypting()) {
            return this.bufCount + i + this.tagLengthInBytes;
        }
        return Math.max(0, (this.bufCount + i) - this.tagLengthInBytes);
    }

    public static class GCM extends OpenSSLAeadCipherAES {
        public GCM() {
            super(OpenSSLCipher.Mode.GCM);
        }

        /* access modifiers changed from: package-private */
        public void checkSupportedMode(OpenSSLCipher.Mode mode) throws NoSuchAlgorithmException {
            if (mode != OpenSSLCipher.Mode.GCM) {
                throw new NoSuchAlgorithmException("Mode must be GCM");
            }
        }

        /* access modifiers changed from: package-private */
        public long getEVP_AEAD(int i) throws InvalidKeyException {
            if (i == 16) {
                return NativeCrypto.EVP_aead_aes_128_gcm();
            }
            if (i == 32) {
                return NativeCrypto.EVP_aead_aes_256_gcm();
            }
            throw new RuntimeException("Unexpected key length: " + i);
        }

        public static class AES_128 extends GCM {
            /* access modifiers changed from: package-private */
            public void checkSupportedKeySize(int i) throws InvalidKeyException {
                if (i != 16) {
                    throw new InvalidKeyException("Unsupported key size: " + i + " bytes (must be 16)");
                }
            }
        }

        public static class AES_256 extends GCM {
            /* access modifiers changed from: package-private */
            public void checkSupportedKeySize(int i) throws InvalidKeyException {
                if (i != 32) {
                    throw new InvalidKeyException("Unsupported key size: " + i + " bytes (must be 32)");
                }
            }
        }
    }

    public static class GCM_SIV extends OpenSSLAeadCipherAES {
        /* access modifiers changed from: package-private */
        public boolean allowsNonceReuse() {
            return true;
        }

        public GCM_SIV() {
            super(OpenSSLCipher.Mode.GCM_SIV);
        }

        /* access modifiers changed from: package-private */
        public void checkSupportedMode(OpenSSLCipher.Mode mode) throws NoSuchAlgorithmException {
            if (mode != OpenSSLCipher.Mode.GCM_SIV) {
                throw new NoSuchAlgorithmException("Mode must be GCM-SIV");
            }
        }

        /* access modifiers changed from: package-private */
        public void checkSupportedTagLength(int i) throws InvalidAlgorithmParameterException {
            if (i != 128) {
                throw new InvalidAlgorithmParameterException("Tag length must be 128 bits");
            }
        }

        /* access modifiers changed from: package-private */
        public long getEVP_AEAD(int i) throws InvalidKeyException {
            if (i == 16) {
                return NativeCrypto.EVP_aead_aes_128_gcm_siv();
            }
            if (i == 32) {
                return NativeCrypto.EVP_aead_aes_256_gcm_siv();
            }
            throw new RuntimeException("Unexpected key length: " + i);
        }

        public static class AES_128 extends GCM_SIV {
            /* access modifiers changed from: package-private */
            public void checkSupportedKeySize(int i) throws InvalidKeyException {
                if (i != 16) {
                    throw new InvalidKeyException("Unsupported key size: " + i + " bytes (must be 16)");
                }
            }
        }

        public static class AES_256 extends GCM_SIV {
            /* access modifiers changed from: package-private */
            public void checkSupportedKeySize(int i) throws InvalidKeyException {
                if (i != 32) {
                    throw new InvalidKeyException("Unsupported key size: " + i + " bytes (must be 32)");
                }
            }
        }
    }
}
