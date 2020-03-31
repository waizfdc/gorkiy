package com.google.android.gms.internal.firebase_ml;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public final class zzsj implements Closeable, Flushable {
    private static final String[] zzbov = new String[128];
    private static final String[] zzbow;
    private final Writer out;
    private String separator;
    private boolean zzboj;
    private int[] zzbor = new int[32];
    private int zzbos = 0;
    private String zzbox;
    private String zzboy;
    private boolean zzboz;

    public zzsj(Writer writer) {
        zzbz(6);
        this.separator = ":";
        this.zzboz = true;
        this.out = writer;
    }

    public final void setIndent(String str) {
        if (str.length() == 0) {
            this.zzbox = null;
            this.separator = ":";
            return;
        }
        this.zzbox = str;
        this.separator = ": ";
    }

    public final void setLenient(boolean z) {
        this.zzboj = true;
    }

    public final zzsj zzqr() throws IOException {
        zzqv();
        return zza(1, "[");
    }

    public final zzsj zzqs() throws IOException {
        return zzc(1, 2, "]");
    }

    public final zzsj zzqt() throws IOException {
        zzqv();
        return zza(3, "{");
    }

    public final zzsj zzqu() throws IOException {
        return zzc(3, 5, "}");
    }

    private final zzsj zza(int i, String str) throws IOException {
        zzqy();
        zzbz(i);
        this.out.write(str);
        return this;
    }

    private final zzsj zzc(int i, int i2, String str) throws IOException {
        int peek = peek();
        if (peek != i2 && peek != i) {
            throw new IllegalStateException("Nesting problem.");
        } else if (this.zzboy == null) {
            this.zzbos--;
            if (peek == i2) {
                zzqx();
            }
            this.out.write(str);
            return this;
        } else {
            throw new IllegalStateException("Dangling name: " + this.zzboy);
        }
    }

    private final void zzbz(int i) {
        int i2 = this.zzbos;
        int[] iArr = this.zzbor;
        if (i2 == iArr.length) {
            int[] iArr2 = new int[(i2 << 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.zzbor = iArr2;
        }
        int[] iArr3 = this.zzbor;
        int i3 = this.zzbos;
        this.zzbos = i3 + 1;
        iArr3[i3] = i;
    }

    private final int peek() {
        int i = this.zzbos;
        if (i != 0) {
            return this.zzbor[i - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private final void zzcb(int i) {
        this.zzbor[this.zzbos - 1] = i;
    }

    public final zzsj zzce(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        } else if (this.zzboy != null) {
            throw new IllegalStateException();
        } else if (this.zzbos != 0) {
            this.zzboy = str;
            return this;
        } else {
            throw new IllegalStateException("JsonWriter is closed.");
        }
    }

    private final void zzqv() throws IOException {
        if (this.zzboy != null) {
            int peek = peek();
            if (peek == 5) {
                this.out.write(44);
            } else if (peek != 3) {
                throw new IllegalStateException("Nesting problem.");
            }
            zzqx();
            zzcb(4);
            zzcg(this.zzboy);
            this.zzboy = null;
        }
    }

    public final zzsj zzcf(String str) throws IOException {
        if (str == null) {
            return zzqw();
        }
        zzqv();
        zzqy();
        zzcg(str);
        return this;
    }

    public final zzsj zzqw() throws IOException {
        if (this.zzboy != null) {
            if (this.zzboz) {
                zzqv();
            } else {
                this.zzboy = null;
                return this;
            }
        }
        zzqy();
        this.out.write("null");
        return this;
    }

    public final zzsj zzaw(boolean z) throws IOException {
        zzqv();
        zzqy();
        this.out.write(z ? "true" : "false");
        return this;
    }

    public final zzsj zzb(double d) throws IOException {
        zzqv();
        if (this.zzboj || (!Double.isNaN(d) && !Double.isInfinite(d))) {
            zzqy();
            this.out.append((CharSequence) Double.toString(d));
            return this;
        }
        throw new IllegalArgumentException("Numeric values must be finite, but was " + d);
    }

    public final zzsj zzu(long j) throws IOException {
        zzqv();
        zzqy();
        this.out.write(Long.toString(j));
        return this;
    }

    public final zzsj zza(Number number) throws IOException {
        if (number == null) {
            return zzqw();
        }
        zzqv();
        String obj = number.toString();
        if (this.zzboj || (!obj.equals("-Infinity") && !obj.equals("Infinity") && !obj.equals("NaN"))) {
            zzqy();
            this.out.append((CharSequence) obj);
            return this;
        }
        throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
    }

    public final void flush() throws IOException {
        if (this.zzbos != 0) {
            this.out.flush();
            return;
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public final void close() throws IOException {
        this.out.close();
        int i = this.zzbos;
        if (i > 1 || (i == 1 && this.zzbor[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.zzbos = 0;
    }

    private final void zzcg(String str) throws IOException {
        String str2;
        String[] strArr = zzbov;
        this.out.write("\"");
        int length = str.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt < 128) {
                str2 = strArr[charAt];
                if (str2 == null) {
                }
            } else if (charAt == 8232) {
                str2 = "\\u2028";
            } else if (charAt == 8233) {
                str2 = "\\u2029";
            }
            if (i < i2) {
                this.out.write(str, i, i2 - i);
            }
            this.out.write(str2);
            i = i2 + 1;
        }
        if (i < length) {
            this.out.write(str, i, length - i);
        }
        this.out.write("\"");
    }

    private final void zzqx() throws IOException {
        if (this.zzbox != null) {
            this.out.write("\n");
            int i = this.zzbos;
            for (int i2 = 1; i2 < i; i2++) {
                this.out.write(this.zzbox);
            }
        }
    }

    private final void zzqy() throws IOException {
        int peek = peek();
        if (peek == 1) {
            zzcb(2);
            zzqx();
        } else if (peek == 2) {
            this.out.append(',');
            zzqx();
        } else if (peek != 4) {
            if (peek != 6) {
                if (peek != 7) {
                    throw new IllegalStateException("Nesting problem.");
                } else if (!this.zzboj) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
            zzcb(7);
        } else {
            this.out.append((CharSequence) this.separator);
            zzcb(5);
        }
    }

    static {
        for (int i = 0; i <= 31; i++) {
            zzbov[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        String[] strArr = zzbov;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        zzbow = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }
}
