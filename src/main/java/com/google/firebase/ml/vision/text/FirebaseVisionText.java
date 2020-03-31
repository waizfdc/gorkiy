package com.google.firebase.ml.vision.text;

import android.graphics.Point;
import android.graphics.Rect;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_ml.zzmr;
import com.google.android.gms.vision.text.Text;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public class FirebaseVisionText {
    public static final FirebaseVisionText zzbnv = new FirebaseVisionText("", new ArrayList());
    private final String text;
    private final List<TextBlock> zzbnw;

    public List<TextBlock> getTextBlocks() {
        return Collections.unmodifiableList(this.zzbnw);
    }

    /* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
    public static class Element extends TextBase {
        Element(com.google.android.gms.vision.text.Element element) {
            super(element);
        }

        public Element(String str, Rect rect, List<RecognizedLanguage> list, Float f) {
            super(str, rect, list, f);
        }

        public /* bridge */ /* synthetic */ List getRecognizedLanguages() {
            return super.getRecognizedLanguages();
        }

        public /* bridge */ /* synthetic */ Float getConfidence() {
            return super.getConfidence();
        }

        public /* bridge */ /* synthetic */ String getText() {
            return super.getText();
        }

        public /* bridge */ /* synthetic */ Point[] getCornerPoints() {
            return super.getCornerPoints();
        }

        public /* bridge */ /* synthetic */ Rect getBoundingBox() {
            return super.getBoundingBox();
        }
    }

    public String getText() {
        return this.text;
    }

    public FirebaseVisionText(SparseArray<com.google.android.gms.vision.text.TextBlock> sparseArray) {
        this.zzbnw = new ArrayList();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sparseArray.size(); i++) {
            com.google.android.gms.vision.text.TextBlock textBlock = sparseArray.get(sparseArray.keyAt(i));
            if (textBlock != null) {
                TextBlock textBlock2 = new TextBlock(textBlock);
                this.zzbnw.add(textBlock2);
                if (sb.length() != 0) {
                    sb.append("\n");
                }
                if (textBlock.getValue() != null) {
                    sb.append(textBlock2.getText());
                }
            }
        }
        this.text = sb.toString();
    }

    /* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
    static class TextBase {
        private final Float confidence;
        private final Point[] cornerPoints;
        private final String text;
        private final Rect zzbks;
        private final List<RecognizedLanguage> zzblo;

        TextBase(Text text2) {
            Preconditions.checkNotNull(text2, "Text to construct FirebaseVisionText classes can't be null");
            this.confidence = null;
            this.text = text2.getValue();
            this.zzbks = text2.getBoundingBox();
            this.cornerPoints = text2.getCornerPoints();
            this.zzblo = zzmr.zzji();
        }

        private TextBase(String str, Rect rect, List<RecognizedLanguage> list, Float f) {
            Preconditions.checkNotNull(str, "Text string cannot be null");
            Preconditions.checkNotNull(list, "Text languages cannot be null");
            this.confidence = f;
            this.cornerPoints = null;
            this.text = str;
            this.zzbks = rect;
            this.zzblo = list;
        }

        public Rect getBoundingBox() {
            return this.zzbks;
        }

        public Point[] getCornerPoints() {
            return this.cornerPoints;
        }

        public String getText() {
            String str = this.text;
            return str == null ? "" : str;
        }

        public Float getConfidence() {
            return this.confidence;
        }

        public List<RecognizedLanguage> getRecognizedLanguages() {
            return this.zzblo;
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
    public static class Line extends TextBase {
        private final List<Element> zzbnx;

        Line(com.google.android.gms.vision.text.Line line) {
            super(line);
            this.zzbnx = new ArrayList();
            for (Text text : line.getComponents()) {
                if (text instanceof com.google.android.gms.vision.text.Element) {
                    this.zzbnx.add(new Element((com.google.android.gms.vision.text.Element) text));
                } else {
                    Log.e("FirebaseVisionText", "A subcomponent of line is should be an element!");
                }
            }
        }

        public Line(String str, Rect rect, List<RecognizedLanguage> list, List<Element> list2, Float f) {
            super(str, rect, list, f);
            this.zzbnx = list2;
        }

        public synchronized List<Element> getElements() {
            return this.zzbnx;
        }

        public /* bridge */ /* synthetic */ List getRecognizedLanguages() {
            return super.getRecognizedLanguages();
        }

        public /* bridge */ /* synthetic */ Float getConfidence() {
            return super.getConfidence();
        }

        public /* bridge */ /* synthetic */ String getText() {
            return super.getText();
        }

        public /* bridge */ /* synthetic */ Point[] getCornerPoints() {
            return super.getCornerPoints();
        }

        public /* bridge */ /* synthetic */ Rect getBoundingBox() {
            return super.getBoundingBox();
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
    public static class TextBlock extends TextBase {
        private final List<Line> zzbob;

        TextBlock(com.google.android.gms.vision.text.TextBlock textBlock) {
            super(textBlock);
            this.zzbob = new ArrayList();
            for (Text text : textBlock.getComponents()) {
                if (text instanceof com.google.android.gms.vision.text.Line) {
                    this.zzbob.add(new Line((com.google.android.gms.vision.text.Line) text));
                } else {
                    Log.e("FirebaseVisionText", "A subcomponent of textblock is should be a line!");
                }
            }
        }

        public TextBlock(String str, Rect rect, List<RecognizedLanguage> list, List<Line> list2, Float f) {
            super(str, rect, list, f);
            this.zzbob = list2;
        }

        public synchronized List<Line> getLines() {
            return this.zzbob;
        }

        public /* bridge */ /* synthetic */ List getRecognizedLanguages() {
            return super.getRecognizedLanguages();
        }

        public /* bridge */ /* synthetic */ Float getConfidence() {
            return super.getConfidence();
        }

        public /* bridge */ /* synthetic */ String getText() {
            return super.getText();
        }

        public /* bridge */ /* synthetic */ Point[] getCornerPoints() {
            return super.getCornerPoints();
        }

        public /* bridge */ /* synthetic */ Rect getBoundingBox() {
            return super.getBoundingBox();
        }
    }

    public FirebaseVisionText(String str, List<TextBlock> list) {
        ArrayList arrayList = new ArrayList();
        this.zzbnw = arrayList;
        this.text = str;
        arrayList.addAll(list);
    }
}
