package org.conscrypt;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import org.conscrypt.OpenSSLCipher;

public class OpenSSLCipherChaCha20 extends OpenSSLCipher {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int BLOCK_SIZE_BYTES = 64;
    private static final int NONCE_SIZE_BYTES = 12;
    private int blockCounter = 0;
    private int currentBlockConsumedBytes = 0;

    /* access modifiers changed from: package-private */
    public String getBaseCipherName() {
        return "ChaCha20";
    }

    /* access modifiers changed from: package-private */
    public int getCipherBlockSize() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int getOutputSizeForFinal(int i) {
        return i;
    }

    /* access modifiers changed from: package-private */
    public int getOutputSizeForUpdate(int i) {
        return i;
    }

    /* access modifiers changed from: package-private */
    public void engineInitInternal(byte[] bArr, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (algorithmParameterSpec instanceof IvParameterSpec) {
            IvParameterSpec ivParameterSpec = (IvParameterSpec) algorithmParameterSpec;
            if (ivParameterSpec.getIV().length == 12) {
                this.iv = ivParameterSpec.getIV();
                return;
            }
            throw new InvalidAlgorithmParameterException("IV must be 12 bytes long");
        } else if (isEncrypting()) {
            this.iv = new byte[12];
            if (secureRandom != null) {
                secureRandom.nextBytes(this.iv);
            } else {
                NativeCrypto.RAND_bytes(this.iv);
            }
        } else {
            throw new InvalidAlgorithmParameterException("IV must be specified when decrypting");
        }
    }

    /* access modifiers changed from: package-private */
    public int updateInternal(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) throws ShortBufferException {
        int i5;
        int i6;
        int i7;
        int i8 = i;
        int i9 = i2;
        byte[] bArr3 = bArr2;
        int i10 = i3;
        if (i9 <= bArr3.length - i10) {
            int i11 = this.currentBlockConsumedBytes;
            if (i11 > 0) {
                int min = Math.min(64 - i11, i9);
                byte[] bArr4 = new byte[64];
                byte[] bArr5 = new byte[64];
                System.arraycopy(bArr, i8, bArr4, this.currentBlockConsumedBytes, min);
                NativeCrypto.chacha20_encrypt_decrypt(bArr4, 0, bArr5, 0, 64, this.encodedKey, this.iv, this.blockCounter);
                System.arraycopy(bArr5, this.currentBlockConsumedBytes, bArr3, i10, min);
                int i12 = this.currentBlockConsumedBytes + min;
                this.currentBlockConsumedBytes = i12;
                if (i12 < 64) {
                    return min;
                }
                this.currentBlockConsumedBytes = 0;
                this.blockCounter++;
                i5 = i10 + min;
                int i13 = i9 - min;
                i6 = i8 + min;
                i7 = i13;
            } else {
                i6 = i8;
                i7 = i9;
                i5 = i10;
            }
            NativeCrypto.chacha20_encrypt_decrypt(bArr, i6, bArr2, i5, i7, this.encodedKey, this.iv, this.blockCounter);
            this.currentBlockConsumedBytes = i7 % 64;
            this.blockCounter += i7 / 64;
            return i9;
        }
        throw new ShortBufferException("Insufficient output space");
    }

    /* access modifiers changed from: package-private */
    public int doFinalInternal(byte[] bArr, int i, int i2) throws IllegalBlockSizeException, BadPaddingException, ShortBufferException {
        reset();
        return 0;
    }

    private void reset() {
        this.blockCounter = 0;
        this.currentBlockConsumedBytes = 0;
    }

    /* access modifiers changed from: package-private */
    public void checkSupportedKeySize(int i) throws InvalidKeyException {
        if (i != 32) {
            throw new InvalidKeyException("Unsupported key size: " + i + " bytes (must be 32)");
        }
    }

    /* access modifiers changed from: package-private */
    public void checkSupportedMode(OpenSSLCipher.Mode mode) throws NoSuchAlgorithmException {
        if (mode != OpenSSLCipher.Mode.NONE) {
            throw new NoSuchAlgorithmException("Mode must be NONE");
        }
    }

    /* access modifiers changed from: package-private */
    public void checkSupportedPadding(OpenSSLCipher.Padding padding) throws NoSuchPaddingException {
        if (padding != OpenSSLCipher.Padding.NOPADDING) {
            throw new NoSuchPaddingException("Must be NoPadding");
        }
    }
}
