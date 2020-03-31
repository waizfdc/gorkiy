package com.google.firebase.ml.vision.document;

import android.graphics.Rect;
import com.google.android.gms.internal.firebase_ml.zzki;
import com.google.android.gms.internal.firebase_ml.zzkl;
import com.google.android.gms.internal.firebase_ml.zzkx;
import com.google.android.gms.internal.firebase_ml.zzla;
import com.google.android.gms.internal.firebase_ml.zzld;
import com.google.android.gms.internal.firebase_ml.zzlf;
import com.google.android.gms.internal.firebase_ml.zzlg;
import com.google.android.gms.internal.firebase_ml.zzlj;
import com.google.android.gms.internal.firebase_ml.zzmn;
import com.google.android.gms.internal.firebase_ml.zzmr;
import com.google.android.gms.internal.firebase_ml.zzqy;
import com.google.android.gms.internal.firebase_ml.zzsd;
import com.google.firebase.ml.vision.text.RecognizedLanguage;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public class FirebaseVisionDocumentText {
    private static final FirebaseVisionDocumentText zzbln = new FirebaseVisionDocumentText("", new ArrayList());
    private final List<Block> blocks;
    private final String text;

    /* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
    public static class Block extends DocumentTextBase {
        private final List<Paragraph> paragraphs;

        public List<Paragraph> getParagraphs() {
            return this.paragraphs;
        }

        private Block(List<RecognizedLanguage> list, RecognizedBreak recognizedBreak, Rect rect, List<Paragraph> list2, String str, Float f) {
            super(list, recognizedBreak, rect, str, f);
            this.paragraphs = list2;
        }

        /* access modifiers changed from: private */
        public static Block zza(zzki zzki, float f) {
            ArrayList arrayList = new ArrayList();
            StringBuilder sb = new StringBuilder();
            List<RecognizedLanguage> zze = zzsd.zze(zzki.zzil());
            if (zzki.getParagraphs() != null) {
                for (zzla next : zzki.getParagraphs()) {
                    if (next != null) {
                        Paragraph zzb = Paragraph.zza(next, f);
                        if (sb.length() != 0) {
                            sb.append("\n");
                        }
                        sb.append(super.getText());
                        arrayList.add(zzb);
                    }
                }
            }
            return new Block(zze, new RecognizedBreak(), zzqy.zza(zzki.zzik(), f), arrayList, sb.toString(), zzki.getConfidence());
        }

        public /* bridge */ /* synthetic */ Float getConfidence() {
            return super.getConfidence();
        }

        public /* bridge */ /* synthetic */ RecognizedBreak getRecognizedBreak() {
            return super.getRecognizedBreak();
        }

        public /* bridge */ /* synthetic */ List getRecognizedLanguages() {
            return super.getRecognizedLanguages();
        }

        public /* bridge */ /* synthetic */ Rect getBoundingBox() {
            return super.getBoundingBox();
        }

        public /* bridge */ /* synthetic */ String getText() {
            return super.getText();
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
    public static class Paragraph extends DocumentTextBase {
        private final List<Word> words;

        public List<Word> getWords() {
            return this.words;
        }

        private Paragraph(List<RecognizedLanguage> list, RecognizedBreak recognizedBreak, Rect rect, List<Word> list2, String str, Float f) {
            super(list, recognizedBreak, rect, str, f);
            this.words = list2;
        }

        /* access modifiers changed from: private */
        public static Paragraph zza(zzla zzla, float f) {
            ArrayList arrayList = new ArrayList();
            StringBuilder sb = new StringBuilder();
            List<RecognizedLanguage> zze = zzsd.zze(zzla.zzil());
            if (zzla.getWords() != null) {
                for (zzlj next : zzla.getWords()) {
                    if (next != null) {
                        Word zzb = Word.zza(next, f);
                        sb.append(super.getText());
                        sb.append(FirebaseVisionDocumentText.zza(super.getRecognizedBreak()));
                        arrayList.add(zzb);
                    }
                }
            }
            return new Paragraph(zze, new RecognizedBreak(), zzqy.zza(zzla.zzik(), f), arrayList, sb.toString(), zzla.getConfidence());
        }

        public /* bridge */ /* synthetic */ Float getConfidence() {
            return super.getConfidence();
        }

        public /* bridge */ /* synthetic */ RecognizedBreak getRecognizedBreak() {
            return super.getRecognizedBreak();
        }

        public /* bridge */ /* synthetic */ List getRecognizedLanguages() {
            return super.getRecognizedLanguages();
        }

        public /* bridge */ /* synthetic */ Rect getBoundingBox() {
            return super.getBoundingBox();
        }

        public /* bridge */ /* synthetic */ String getText() {
            return super.getText();
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
    public static class RecognizedBreak {
        public static final int EOL_SURE_SPACE = 3;
        public static final int HYPHEN = 4;
        public static final int LINE_BREAK = 5;
        public static final int SPACE = 1;
        public static final int SURE_SPACE = 2;
        public static final int UNKNOWN = 0;
        private final int type;
        private final boolean zzblq;

        @Retention(RetentionPolicy.CLASS)
        /* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
        public @interface BreakType {
        }

        public int getDetectedBreakType() {
            return this.type;
        }

        public boolean getIsPrefix() {
            return this.zzblq;
        }

        private RecognizedBreak(int i, boolean z) {
            this.type = i;
            this.zzblq = z;
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x0079  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static com.google.firebase.ml.vision.document.FirebaseVisionDocumentText.RecognizedBreak zzc(com.google.android.gms.internal.firebase_ml.zzlf r8) {
            /*
                if (r8 == 0) goto L_0x008b
                com.google.android.gms.internal.firebase_ml.zzkm r0 = r8.zzis()
                if (r0 != 0) goto L_0x000a
                goto L_0x008b
            L_0x000a:
                com.google.android.gms.internal.firebase_ml.zzkm r0 = r8.zzis()
                java.lang.String r0 = r0.getType()
                r1 = 4
                r2 = 3
                r3 = 2
                r4 = 1
                r5 = 0
                if (r0 == 0) goto L_0x006e
                com.google.android.gms.internal.firebase_ml.zzkm r0 = r8.zzis()
                java.lang.String r0 = r0.getType()
                r6 = -1
                int r7 = r0.hashCode()
                switch(r7) {
                    case -1651884996: goto L_0x0052;
                    case -1571028039: goto L_0x0048;
                    case 79100134: goto L_0x003e;
                    case 1541383380: goto L_0x0034;
                    case 2145946930: goto L_0x002a;
                    default: goto L_0x0029;
                }
            L_0x0029:
                goto L_0x005b
            L_0x002a:
                java.lang.String r7 = "HYPHEN"
                boolean r0 = r0.equals(r7)
                if (r0 == 0) goto L_0x005b
                r6 = r2
                goto L_0x005b
            L_0x0034:
                java.lang.String r7 = "LINE_BREAK"
                boolean r0 = r0.equals(r7)
                if (r0 == 0) goto L_0x005b
                r6 = r1
                goto L_0x005b
            L_0x003e:
                java.lang.String r7 = "SPACE"
                boolean r0 = r0.equals(r7)
                if (r0 == 0) goto L_0x005b
                r6 = r5
                goto L_0x005b
            L_0x0048:
                java.lang.String r7 = "EOL_SURE_SPACE"
                boolean r0 = r0.equals(r7)
                if (r0 == 0) goto L_0x005b
                r6 = r3
                goto L_0x005b
            L_0x0052:
                java.lang.String r7 = "SURE_SPACE"
                boolean r0 = r0.equals(r7)
                if (r0 == 0) goto L_0x005b
                r6 = r4
            L_0x005b:
                if (r6 == 0) goto L_0x006c
                if (r6 == r4) goto L_0x006a
                if (r6 == r3) goto L_0x0068
                if (r6 == r2) goto L_0x006f
                if (r6 == r1) goto L_0x0066
                goto L_0x006e
            L_0x0066:
                r1 = 5
                goto L_0x006f
            L_0x0068:
                r1 = r2
                goto L_0x006f
            L_0x006a:
                r1 = r3
                goto L_0x006f
            L_0x006c:
                r1 = r4
                goto L_0x006f
            L_0x006e:
                r1 = r5
            L_0x006f:
                com.google.android.gms.internal.firebase_ml.zzkm r0 = r8.zzis()
                java.lang.Boolean r0 = r0.zzim()
                if (r0 == 0) goto L_0x0085
                com.google.android.gms.internal.firebase_ml.zzkm r8 = r8.zzis()
                java.lang.Boolean r8 = r8.zzim()
                boolean r5 = r8.booleanValue()
            L_0x0085:
                com.google.firebase.ml.vision.document.FirebaseVisionDocumentText$RecognizedBreak r8 = new com.google.firebase.ml.vision.document.FirebaseVisionDocumentText$RecognizedBreak
                r8.<init>(r1, r5)
                return r8
            L_0x008b:
                r8 = 0
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.ml.vision.document.FirebaseVisionDocumentText.RecognizedBreak.zzc(com.google.android.gms.internal.firebase_ml.zzlf):com.google.firebase.ml.vision.document.FirebaseVisionDocumentText$RecognizedBreak");
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
    public static class Word extends DocumentTextBase {
        private final List<Symbol> symbols;

        public List<Symbol> getSymbols() {
            return this.symbols;
        }

        private Word(List<RecognizedLanguage> list, RecognizedBreak recognizedBreak, Rect rect, List<Symbol> list2, String str, Float f) {
            super(list, recognizedBreak, rect, str, f);
            this.symbols = list2;
        }

        /* access modifiers changed from: private */
        public static Word zza(zzlj zzlj, float f) {
            ArrayList arrayList = new ArrayList();
            StringBuilder sb = new StringBuilder();
            List<RecognizedLanguage> zze = zzsd.zze(zzlj.zzil());
            RecognizedBreak recognizedBreak = null;
            if (zzlj.getSymbols() != null) {
                for (zzld next : zzlj.getSymbols()) {
                    if (next != null) {
                        Symbol zzb = Symbol.zza(next, f);
                        RecognizedBreak recognizedBreak2 = super.getRecognizedBreak();
                        sb.append(super.getText());
                        arrayList.add(Symbol.zza(next, f));
                        recognizedBreak = recognizedBreak2;
                    }
                }
            }
            return new Word(zze, recognizedBreak, zzqy.zza(zzlj.zzik(), f), arrayList, sb.toString(), zzlj.getConfidence());
        }

        public /* bridge */ /* synthetic */ Float getConfidence() {
            return super.getConfidence();
        }

        public /* bridge */ /* synthetic */ RecognizedBreak getRecognizedBreak() {
            return super.getRecognizedBreak();
        }

        public /* bridge */ /* synthetic */ List getRecognizedLanguages() {
            return super.getRecognizedLanguages();
        }

        public /* bridge */ /* synthetic */ Rect getBoundingBox() {
            return super.getBoundingBox();
        }

        public /* bridge */ /* synthetic */ String getText() {
            return super.getText();
        }
    }

    public List<Block> getBlocks() {
        return this.blocks;
    }

    /* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
    public static class Symbol extends DocumentTextBase {
        private Symbol(List<RecognizedLanguage> list, RecognizedBreak recognizedBreak, Rect rect, String str, Float f) {
            super(list, recognizedBreak, rect, str, f);
        }

        /* access modifiers changed from: private */
        public static Symbol zza(zzld zzld, float f) {
            return new Symbol(FirebaseVisionDocumentText.zza(zzld.zzil()), RecognizedBreak.zzc(zzld.zzil()), zzqy.zza(zzld.zzik(), f), zzqy.zzcc(zzld.getText()), zzld.getConfidence());
        }

        public /* bridge */ /* synthetic */ Float getConfidence() {
            return super.getConfidence();
        }

        public /* bridge */ /* synthetic */ RecognizedBreak getRecognizedBreak() {
            return super.getRecognizedBreak();
        }

        public /* bridge */ /* synthetic */ List getRecognizedLanguages() {
            return super.getRecognizedLanguages();
        }

        public /* bridge */ /* synthetic */ Rect getBoundingBox() {
            return super.getBoundingBox();
        }

        public /* bridge */ /* synthetic */ String getText() {
            return super.getText();
        }
    }

    public String getText() {
        return zzmn.zzba(this.text);
    }

    private FirebaseVisionDocumentText(String str, List<Block> list) {
        this.text = str;
        this.blocks = list;
    }

    /* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
    static class DocumentTextBase {
        private final Float confidence;
        private final String text;
        private final Rect zzbks;
        private final List<RecognizedLanguage> zzblo;
        private final RecognizedBreak zzblp;

        DocumentTextBase(List<RecognizedLanguage> list, RecognizedBreak recognizedBreak, Rect rect, String str, Float f) {
            this.text = str;
            this.zzblo = list;
            this.zzblp = recognizedBreak;
            this.zzbks = rect;
            this.confidence = f;
        }

        public String getText() {
            return this.text;
        }

        public Rect getBoundingBox() {
            return this.zzbks;
        }

        public List<RecognizedLanguage> getRecognizedLanguages() {
            return this.zzblo;
        }

        public RecognizedBreak getRecognizedBreak() {
            return this.zzblp;
        }

        public Float getConfidence() {
            return this.confidence;
        }
    }

    static FirebaseVisionDocumentText zza(zzlg zzlg, float f) {
        if (zzlg == null) {
            return zzbln;
        }
        String zzcc = zzqy.zzcc(zzlg.getText());
        ArrayList arrayList = new ArrayList();
        if (zzlg.getPages() != null) {
            for (zzkx next : zzlg.getPages()) {
                if (next != null) {
                    for (zzki next2 : next.getBlocks()) {
                        if (next2 != null) {
                            arrayList.add(Block.zza(next2, f));
                        }
                    }
                }
            }
        }
        return new FirebaseVisionDocumentText(zzcc, arrayList);
    }

    /* access modifiers changed from: private */
    public static List<RecognizedLanguage> zza(zzlf zzlf) {
        if (zzlf == null) {
            return zzmr.zzji();
        }
        ArrayList arrayList = new ArrayList();
        if (zzlf.zzit() != null) {
            for (zzkl zza : zzlf.zzit()) {
                RecognizedLanguage zza2 = RecognizedLanguage.zza(zza);
                if (zza2 != null) {
                    arrayList.add(zza2);
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public static String zza(RecognizedBreak recognizedBreak) {
        if (recognizedBreak == null) {
            return "";
        }
        int detectedBreakType = recognizedBreak.getDetectedBreakType();
        if (detectedBreakType == 1 || detectedBreakType == 2) {
            return " ";
        }
        if (detectedBreakType != 3) {
            if (detectedBreakType == 4) {
                return "-\n";
            }
            if (detectedBreakType != 5) {
                return "";
            }
        }
        return "\n";
    }
}
