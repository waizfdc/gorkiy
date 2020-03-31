package org.conscrypt;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import javax.crypto.NoSuchPaddingException;
import org.conscrypt.OpenSSLCipher;

public abstract class OpenSSLEvpCipherDESEDE extends OpenSSLEvpCipher {
    private static final int DES_BLOCK_SIZE = 8;

    /* access modifiers changed from: package-private */
    public String getBaseCipherName() {
        return "DESede";
    }

    /* access modifiers changed from: package-private */
    public int getCipherBlockSize() {
        return 8;
    }

    OpenSSLEvpCipherDESEDE(OpenSSLCipher.Mode mode, OpenSSLCipher.Padding padding) {
        super(mode, padding);
    }

    public static class CBC extends OpenSSLEvpCipherDESEDE {
        CBC(OpenSSLCipher.Padding padding) {
            super(OpenSSLCipher.Mode.CBC, padding);
        }

        public static class NoPadding extends CBC {
            public NoPadding() {
                super(OpenSSLCipher.Padding.NOPADDING);
            }
        }

        public static class PKCS5Padding extends CBC {
            public PKCS5Padding() {
                super(OpenSSLCipher.Padding.PKCS5PADDING);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public String getCipherName(int i, OpenSSLCipher.Mode mode) {
        String str = i == 16 ? "des-ede" : "des-ede3";
        return str + "-" + mode.toString().toLowerCase(Locale.US);
    }

    /* access modifiers changed from: package-private */
    public void checkSupportedKeySize(int i) throws InvalidKeyException {
        if (i != 16 && i != 24) {
            throw new InvalidKeyException("key size must be 128 or 192 bits");
        }
    }

    /* access modifiers changed from: package-private */
    public void checkSupportedMode(OpenSSLCipher.Mode mode) throws NoSuchAlgorithmException {
        if (mode != OpenSSLCipher.Mode.CBC) {
            throw new NoSuchAlgorithmException("Unsupported mode " + mode.toString());
        }
    }

    /* renamed from: org.conscrypt.OpenSSLEvpCipherDESEDE$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$conscrypt$OpenSSLCipher$Padding;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                org.conscrypt.OpenSSLCipher$Padding[] r0 = org.conscrypt.OpenSSLCipher.Padding.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                org.conscrypt.OpenSSLEvpCipherDESEDE.AnonymousClass1.$SwitchMap$org$conscrypt$OpenSSLCipher$Padding = r0
                org.conscrypt.OpenSSLCipher$Padding r1 = org.conscrypt.OpenSSLCipher.Padding.NOPADDING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = org.conscrypt.OpenSSLEvpCipherDESEDE.AnonymousClass1.$SwitchMap$org$conscrypt$OpenSSLCipher$Padding     // Catch:{ NoSuchFieldError -> 0x001d }
                org.conscrypt.OpenSSLCipher$Padding r1 = org.conscrypt.OpenSSLCipher.Padding.PKCS5PADDING     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.conscrypt.OpenSSLEvpCipherDESEDE.AnonymousClass1.<clinit>():void");
        }
    }

    /* access modifiers changed from: package-private */
    public void checkSupportedPadding(OpenSSLCipher.Padding padding) throws NoSuchPaddingException {
        int i = AnonymousClass1.$SwitchMap$org$conscrypt$OpenSSLCipher$Padding[padding.ordinal()];
        if (i != 1 && i != 2) {
            throw new NoSuchPaddingException("Unsupported padding " + padding.toString());
        }
    }
}
