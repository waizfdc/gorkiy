package org.conscrypt;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import javax.crypto.NoSuchPaddingException;
import org.conscrypt.OpenSSLCipher;

public abstract class OpenSSLEvpCipherAES extends OpenSSLEvpCipher {
    private static final int AES_BLOCK_SIZE = 16;

    /* access modifiers changed from: package-private */
    public String getBaseCipherName() {
        return "AES";
    }

    /* access modifiers changed from: package-private */
    public int getCipherBlockSize() {
        return 16;
    }

    OpenSSLEvpCipherAES(OpenSSLCipher.Mode mode, OpenSSLCipher.Padding padding) {
        super(mode, padding);
    }

    /* access modifiers changed from: package-private */
    public void checkSupportedMode(OpenSSLCipher.Mode mode) throws NoSuchAlgorithmException {
        int i = AnonymousClass1.$SwitchMap$org$conscrypt$OpenSSLCipher$Mode[mode.ordinal()];
        if (i != 1 && i != 2 && i != 3) {
            throw new NoSuchAlgorithmException("Unsupported mode " + mode.toString());
        }
    }

    /* renamed from: org.conscrypt.OpenSSLEvpCipherAES$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$conscrypt$OpenSSLCipher$Mode;
        static final /* synthetic */ int[] $SwitchMap$org$conscrypt$OpenSSLCipher$Padding;

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0038 */
        static {
            /*
                org.conscrypt.OpenSSLCipher$Padding[] r0 = org.conscrypt.OpenSSLCipher.Padding.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                org.conscrypt.OpenSSLEvpCipherAES.AnonymousClass1.$SwitchMap$org$conscrypt$OpenSSLCipher$Padding = r0
                r1 = 1
                org.conscrypt.OpenSSLCipher$Padding r2 = org.conscrypt.OpenSSLCipher.Padding.NOPADDING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = org.conscrypt.OpenSSLEvpCipherAES.AnonymousClass1.$SwitchMap$org$conscrypt$OpenSSLCipher$Padding     // Catch:{ NoSuchFieldError -> 0x001d }
                org.conscrypt.OpenSSLCipher$Padding r3 = org.conscrypt.OpenSSLCipher.Padding.PKCS5PADDING     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                org.conscrypt.OpenSSLCipher$Mode[] r2 = org.conscrypt.OpenSSLCipher.Mode.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                org.conscrypt.OpenSSLEvpCipherAES.AnonymousClass1.$SwitchMap$org$conscrypt$OpenSSLCipher$Mode = r2
                org.conscrypt.OpenSSLCipher$Mode r3 = org.conscrypt.OpenSSLCipher.Mode.CBC     // Catch:{ NoSuchFieldError -> 0x002e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r1 = org.conscrypt.OpenSSLEvpCipherAES.AnonymousClass1.$SwitchMap$org$conscrypt$OpenSSLCipher$Mode     // Catch:{ NoSuchFieldError -> 0x0038 }
                org.conscrypt.OpenSSLCipher$Mode r2 = org.conscrypt.OpenSSLCipher.Mode.CTR     // Catch:{ NoSuchFieldError -> 0x0038 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0038 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0038 }
            L_0x0038:
                int[] r0 = org.conscrypt.OpenSSLEvpCipherAES.AnonymousClass1.$SwitchMap$org$conscrypt$OpenSSLCipher$Mode     // Catch:{ NoSuchFieldError -> 0x0043 }
                org.conscrypt.OpenSSLCipher$Mode r1 = org.conscrypt.OpenSSLCipher.Mode.ECB     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.conscrypt.OpenSSLEvpCipherAES.AnonymousClass1.<clinit>():void");
        }
    }

    /* access modifiers changed from: package-private */
    public void checkSupportedPadding(OpenSSLCipher.Padding padding) throws NoSuchPaddingException {
        int i = AnonymousClass1.$SwitchMap$org$conscrypt$OpenSSLCipher$Padding[padding.ordinal()];
        if (i != 1 && i != 2) {
            throw new NoSuchPaddingException("Unsupported padding " + padding.toString());
        }
    }

    /* access modifiers changed from: package-private */
    public String getCipherName(int i, OpenSSLCipher.Mode mode) {
        return "aes-" + (i * 8) + "-" + mode.toString().toLowerCase(Locale.US);
    }

    public static class AES extends OpenSSLEvpCipherAES {
        AES(OpenSSLCipher.Mode mode, OpenSSLCipher.Padding padding) {
            super(mode, padding);
        }

        public static class CBC extends AES {
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

        public static class CTR extends AES {
            public CTR() {
                super(OpenSSLCipher.Mode.CTR, OpenSSLCipher.Padding.NOPADDING);
            }
        }

        public static class ECB extends AES {
            ECB(OpenSSLCipher.Padding padding) {
                super(OpenSSLCipher.Mode.ECB, padding);
            }

            public static class NoPadding extends ECB {
                public NoPadding() {
                    super(OpenSSLCipher.Padding.NOPADDING);
                }
            }

            public static class PKCS5Padding extends ECB {
                public PKCS5Padding() {
                    super(OpenSSLCipher.Padding.PKCS5PADDING);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void checkSupportedKeySize(int i) throws InvalidKeyException {
            if (i != 16 && i != 24 && i != 32) {
                throw new InvalidKeyException("Unsupported key size: " + i + " bytes");
            }
        }
    }

    public static class AES_128 extends OpenSSLEvpCipherAES {
        AES_128(OpenSSLCipher.Mode mode, OpenSSLCipher.Padding padding) {
            super(mode, padding);
        }

        public static class CBC extends AES_128 {
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

        public static class CTR extends AES_128 {
            public CTR() {
                super(OpenSSLCipher.Mode.CTR, OpenSSLCipher.Padding.NOPADDING);
            }
        }

        public static class ECB extends AES_128 {
            ECB(OpenSSLCipher.Padding padding) {
                super(OpenSSLCipher.Mode.ECB, padding);
            }

            public static class NoPadding extends ECB {
                public NoPadding() {
                    super(OpenSSLCipher.Padding.NOPADDING);
                }
            }

            public static class PKCS5Padding extends ECB {
                public PKCS5Padding() {
                    super(OpenSSLCipher.Padding.PKCS5PADDING);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void checkSupportedKeySize(int i) throws InvalidKeyException {
            if (i != 16) {
                throw new InvalidKeyException("Unsupported key size: " + i + " bytes");
            }
        }
    }

    public static class AES_256 extends OpenSSLEvpCipherAES {
        AES_256(OpenSSLCipher.Mode mode, OpenSSLCipher.Padding padding) {
            super(mode, padding);
        }

        public static class CBC extends AES_256 {
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

        public static class CTR extends AES_256 {
            public CTR() {
                super(OpenSSLCipher.Mode.CTR, OpenSSLCipher.Padding.NOPADDING);
            }
        }

        public static class ECB extends AES_256 {
            ECB(OpenSSLCipher.Padding padding) {
                super(OpenSSLCipher.Mode.ECB, padding);
            }

            public static class NoPadding extends ECB {
                public NoPadding() {
                    super(OpenSSLCipher.Padding.NOPADDING);
                }
            }

            public static class PKCS5Padding extends ECB {
                public PKCS5Padding() {
                    super(OpenSSLCipher.Padding.PKCS5PADDING);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void checkSupportedKeySize(int i) throws InvalidKeyException {
            if (i != 32) {
                throw new InvalidKeyException("Unsupported key size: " + i + " bytes");
            }
        }
    }
}
