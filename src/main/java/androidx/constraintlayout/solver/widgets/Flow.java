package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.HashMap;

public class Flow extends VirtualLayout {
    public static final int HORIZONTAL_ALIGN_CENTER = 2;
    public static final int HORIZONTAL_ALIGN_END = 1;
    public static final int HORIZONTAL_ALIGN_START = 0;
    public static final int VERTICAL_ALIGN_BASELINE = 3;
    public static final int VERTICAL_ALIGN_BOTTOM = 1;
    public static final int VERTICAL_ALIGN_CENTER = 2;
    public static final int VERTICAL_ALIGN_TOP = 0;
    public static final int WRAP_ALIGNED = 2;
    public static final int WRAP_CHAIN = 1;
    public static final int WRAP_NONE = 0;
    private ConstraintWidget[] mAlignedBiggestElementsInCols = null;
    private ConstraintWidget[] mAlignedBiggestElementsInRows = null;
    private int[] mAlignedDimensions = null;
    private ArrayList<WidgetsList> mChainList = new ArrayList<>();
    /* access modifiers changed from: private */
    public float mFirstHorizontalBias = 0.5f;
    /* access modifiers changed from: private */
    public int mFirstHorizontalStyle = -1;
    /* access modifiers changed from: private */
    public float mFirstVerticalBias = 0.5f;
    /* access modifiers changed from: private */
    public int mFirstVerticalStyle = -1;
    /* access modifiers changed from: private */
    public int mHorizontalAlign = 2;
    /* access modifiers changed from: private */
    public float mHorizontalBias = 0.5f;
    /* access modifiers changed from: private */
    public int mHorizontalGap = 0;
    /* access modifiers changed from: private */
    public int mHorizontalStyle = -1;
    /* access modifiers changed from: private */
    public float mLastHorizontalBias = 0.5f;
    /* access modifiers changed from: private */
    public int mLastHorizontalStyle = -1;
    /* access modifiers changed from: private */
    public float mLastVerticalBias = 0.5f;
    /* access modifiers changed from: private */
    public int mLastVerticalStyle = -1;
    private int mMaxElementsWrap = -1;
    private int mOrientation = 0;
    /* access modifiers changed from: private */
    public int mVerticalAlign = 2;
    /* access modifiers changed from: private */
    public float mVerticalBias = 0.5f;
    /* access modifiers changed from: private */
    public int mVerticalGap = 0;
    /* access modifiers changed from: private */
    public int mVerticalStyle = -1;
    private int mWrapMode = 0;

    public void copy(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        super.copy(constraintWidget, hashMap);
        Flow flow = (Flow) constraintWidget;
        this.mHorizontalStyle = flow.mHorizontalStyle;
        this.mVerticalStyle = flow.mVerticalStyle;
        this.mFirstHorizontalStyle = flow.mFirstHorizontalStyle;
        this.mFirstVerticalStyle = flow.mFirstVerticalStyle;
        this.mLastHorizontalStyle = flow.mLastHorizontalStyle;
        this.mLastVerticalStyle = flow.mLastVerticalStyle;
        this.mHorizontalBias = flow.mHorizontalBias;
        this.mVerticalBias = flow.mVerticalBias;
        this.mFirstHorizontalBias = flow.mFirstHorizontalBias;
        this.mFirstVerticalBias = flow.mFirstVerticalBias;
        this.mLastHorizontalBias = flow.mLastHorizontalBias;
        this.mLastVerticalBias = flow.mLastVerticalBias;
        this.mHorizontalGap = flow.mHorizontalGap;
        this.mVerticalGap = flow.mVerticalGap;
        this.mHorizontalAlign = flow.mHorizontalAlign;
        this.mVerticalAlign = flow.mVerticalAlign;
        this.mWrapMode = flow.mWrapMode;
        this.mMaxElementsWrap = flow.mMaxElementsWrap;
        this.mOrientation = flow.mOrientation;
    }

    public void setOrientation(int i) {
        this.mOrientation = i;
    }

    public void setFirstHorizontalStyle(int i) {
        this.mFirstHorizontalStyle = i;
    }

    public void setFirstVerticalStyle(int i) {
        this.mFirstVerticalStyle = i;
    }

    public void setLastHorizontalStyle(int i) {
        this.mLastHorizontalStyle = i;
    }

    public void setLastVerticalStyle(int i) {
        this.mLastVerticalStyle = i;
    }

    public void setHorizontalStyle(int i) {
        this.mHorizontalStyle = i;
    }

    public void setVerticalStyle(int i) {
        this.mVerticalStyle = i;
    }

    public void setHorizontalBias(float f) {
        this.mHorizontalBias = f;
    }

    public void setVerticalBias(float f) {
        this.mVerticalBias = f;
    }

    public void setFirstHorizontalBias(float f) {
        this.mFirstHorizontalBias = f;
    }

    public void setFirstVerticalBias(float f) {
        this.mFirstVerticalBias = f;
    }

    public void setLastHorizontalBias(float f) {
        this.mLastHorizontalBias = f;
    }

    public void setLastVerticalBias(float f) {
        this.mLastVerticalBias = f;
    }

    public void setHorizontalAlign(int i) {
        this.mHorizontalAlign = i;
    }

    public void setVerticalAlign(int i) {
        this.mVerticalAlign = i;
    }

    public void setWrapMode(int i) {
        this.mWrapMode = i;
    }

    public void setHorizontalGap(int i) {
        this.mHorizontalGap = i;
    }

    public void setVerticalGap(int i) {
        this.mVerticalGap = i;
    }

    public void setMaxElementsWrap(int i) {
        this.mMaxElementsWrap = i;
    }

    /* access modifiers changed from: private */
    public final int getWidgetWidth(ConstraintWidget constraintWidget) {
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mMatchConstraintDefaultWidth == 0) {
            return 0;
        }
        return constraintWidget.getWidth();
    }

    /* access modifiers changed from: private */
    public final int getWidgetHeight(ConstraintWidget constraintWidget) {
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mMatchConstraintDefaultHeight == 0) {
            return 0;
        }
        return constraintWidget.getHeight();
    }

    public void measure(int i, int i2, int i3, int i4) {
        boolean z = false;
        if (this.mWidgetsCount <= 0 || measureChildren()) {
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int[] iArr = new int[2];
            int i5 = (i2 - paddingLeft) - paddingRight;
            if (this.mOrientation == 1) {
                i5 = (i4 - paddingTop) - paddingBottom;
            }
            if (this.mOrientation == 0) {
                if (this.mHorizontalStyle == -1) {
                    this.mHorizontalStyle = 0;
                }
                if (this.mVerticalStyle == -1) {
                    this.mVerticalStyle = 0;
                }
            } else {
                if (this.mHorizontalStyle == -1) {
                    this.mHorizontalStyle = 0;
                }
                if (this.mVerticalStyle == -1) {
                    this.mVerticalStyle = 0;
                }
            }
            int i6 = this.mWrapMode;
            if (i6 == 0) {
                measureNoWrap(this.mWidgets, this.mOrientation, i5, iArr);
            } else if (i6 == 1) {
                measureChainWrap(this.mWidgets, this.mOrientation, i5, iArr);
            } else if (i6 == 2) {
                measureAligned(this.mWidgets, this.mOrientation, i5, iArr);
            }
            int i7 = iArr[0] + paddingLeft + paddingRight;
            int i8 = iArr[1] + paddingTop + paddingBottom;
            if (i != 1073741824) {
                i2 = i == Integer.MIN_VALUE ? Math.min(i7, i2) : i == 0 ? i7 : 0;
            }
            if (i3 != 1073741824) {
                i4 = i3 == Integer.MIN_VALUE ? Math.min(i8, i4) : i3 == 0 ? i8 : 0;
            }
            setMeasure(i2, i4);
            if (this.mWidgetsCount > 0) {
                z = true;
            }
            needsCallbackFromSolver(z);
            return;
        }
        setMeasure(0, 0);
        needsCallbackFromSolver(false);
    }

    private class WidgetsList {
        /* access modifiers changed from: private */
        public ConstraintWidget biggest = null;
        int biggestDimension = 0;
        private ConstraintAnchor mBottom;
        private int mCount = 0;
        private int mHeight = 0;
        private ConstraintAnchor mLeft;
        private int mOrientation = 0;
        private int mPaddingBottom = 0;
        private int mPaddingLeft = 0;
        private int mPaddingRight = 0;
        private int mPaddingTop = 0;
        private ConstraintAnchor mRight;
        private int mStartIndex = 0;
        private ConstraintAnchor mTop;
        private int mWidth = 0;

        public WidgetsList(int i, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4) {
            this.mOrientation = i;
            this.mLeft = constraintAnchor;
            this.mTop = constraintAnchor2;
            this.mRight = constraintAnchor3;
            this.mBottom = constraintAnchor4;
            this.mPaddingLeft = Flow.this.getPaddingLeft();
            this.mPaddingTop = Flow.this.getPaddingTop();
            this.mPaddingRight = Flow.this.getPaddingRight();
            this.mPaddingBottom = Flow.this.getPaddingBottom();
        }

        public void setup(int i, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i2, int i3, int i4, int i5) {
            this.mOrientation = i;
            this.mLeft = constraintAnchor;
            this.mTop = constraintAnchor2;
            this.mRight = constraintAnchor3;
            this.mBottom = constraintAnchor4;
            this.mPaddingLeft = i2;
            this.mPaddingTop = i3;
            this.mPaddingRight = i4;
            this.mPaddingBottom = i5;
        }

        public void clear() {
            this.biggestDimension = 0;
            this.biggest = null;
            this.mWidth = 0;
            this.mHeight = 0;
            this.mStartIndex = 0;
            this.mCount = 0;
        }

        public void setStartIndex(int i) {
            this.mStartIndex = i;
        }

        public int getWidth() {
            if (this.mOrientation == 0) {
                return this.mWidth - Flow.this.mHorizontalGap;
            }
            return this.mWidth;
        }

        public int getHeight() {
            if (this.mOrientation == 1) {
                return this.mHeight - Flow.this.mVerticalGap;
            }
            return this.mHeight;
        }

        public void add(ConstraintWidget constraintWidget) {
            int i = 0;
            if (this.mOrientation == 0) {
                int access$200 = Flow.this.getWidgetWidth(constraintWidget);
                int access$000 = Flow.this.mHorizontalGap;
                if (constraintWidget.getVisibility() != 8) {
                    i = access$000;
                }
                this.mWidth += access$200 + i;
                int access$300 = Flow.this.getWidgetHeight(constraintWidget);
                if (this.biggest == null || this.biggestDimension < access$300) {
                    this.biggest = constraintWidget;
                    this.biggestDimension = access$300;
                    this.mHeight = access$300;
                }
            } else {
                int access$2002 = Flow.this.getWidgetWidth(constraintWidget);
                int access$3002 = Flow.this.getWidgetHeight(constraintWidget);
                int access$100 = Flow.this.mVerticalGap;
                if (constraintWidget.getVisibility() != 8) {
                    i = access$100;
                }
                this.mHeight += access$3002 + i;
                if (this.biggest == null || this.biggestDimension < access$2002) {
                    this.biggest = constraintWidget;
                    this.biggestDimension = access$2002;
                    this.mWidth = access$2002;
                }
            }
            this.mCount++;
        }

        /* JADX WARNING: Removed duplicated region for block: B:46:0x00b3  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void createConstraints(boolean r17, int r18, boolean r19) {
            /*
                r16 = this;
                r0 = r16
                int r1 = r0.mCount
                r2 = 0
                r3 = r2
            L_0x0006:
                if (r3 >= r1) goto L_0x0017
                androidx.constraintlayout.solver.widgets.Flow r4 = androidx.constraintlayout.solver.widgets.Flow.this
                androidx.constraintlayout.solver.widgets.ConstraintWidget[] r4 = r4.mWidgets
                int r5 = r0.mStartIndex
                int r5 = r5 + r3
                r4 = r4[r5]
                r4.resetAnchors()
                int r3 = r3 + 1
                goto L_0x0006
            L_0x0017:
                if (r1 == 0) goto L_0x0312
                androidx.constraintlayout.solver.widgets.ConstraintWidget r3 = r0.biggest
                if (r3 != 0) goto L_0x001f
                goto L_0x0312
            L_0x001f:
                if (r19 == 0) goto L_0x0025
                if (r18 != 0) goto L_0x0025
                r4 = 1
                goto L_0x0026
            L_0x0025:
                r4 = r2
            L_0x0026:
                r5 = -1
                r6 = r2
                r7 = r5
                r8 = r7
            L_0x002a:
                if (r6 >= r1) goto L_0x0049
                if (r17 == 0) goto L_0x0032
                int r9 = r1 + -1
                int r9 = r9 - r6
                goto L_0x0033
            L_0x0032:
                r9 = r6
            L_0x0033:
                androidx.constraintlayout.solver.widgets.Flow r10 = androidx.constraintlayout.solver.widgets.Flow.this
                androidx.constraintlayout.solver.widgets.ConstraintWidget[] r10 = r10.mWidgets
                int r11 = r0.mStartIndex
                int r11 = r11 + r9
                r9 = r10[r11]
                int r9 = r9.getVisibility()
                if (r9 != 0) goto L_0x0046
                if (r7 != r5) goto L_0x0045
                r7 = r6
            L_0x0045:
                r8 = r6
            L_0x0046:
                int r6 = r6 + 1
                goto L_0x002a
            L_0x0049:
                r6 = 0
                int r9 = r0.mOrientation
                if (r9 != 0) goto L_0x01b0
                androidx.constraintlayout.solver.widgets.ConstraintWidget r9 = r0.biggest
                androidx.constraintlayout.solver.widgets.Flow r10 = androidx.constraintlayout.solver.widgets.Flow.this
                int r10 = r10.mVerticalStyle
                r9.setVerticalChainStyle(r10)
                int r10 = r0.mPaddingTop
                if (r18 <= 0) goto L_0x0064
                androidx.constraintlayout.solver.widgets.Flow r11 = androidx.constraintlayout.solver.widgets.Flow.this
                int r11 = r11.mVerticalGap
                int r10 = r10 + r11
            L_0x0064:
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r9.mTop
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r12 = r0.mTop
                r11.connect(r12, r10)
                if (r19 == 0) goto L_0x0076
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r10 = r9.mBottom
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r0.mBottom
                int r12 = r0.mPaddingBottom
                r10.connect(r11, r12)
            L_0x0076:
                if (r18 <= 0) goto L_0x0083
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r10 = r0.mTop
                androidx.constraintlayout.solver.widgets.ConstraintWidget r10 = r10.mOwner
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r10 = r10.mBottom
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r9.mTop
                r10.connect(r11, r2)
            L_0x0083:
                androidx.constraintlayout.solver.widgets.Flow r10 = androidx.constraintlayout.solver.widgets.Flow.this
                int r10 = r10.mVerticalAlign
                r11 = 3
                if (r10 != r11) goto L_0x00af
                boolean r10 = r9.hasBaseline()
                if (r10 != 0) goto L_0x00af
                r10 = r2
            L_0x0093:
                if (r10 >= r1) goto L_0x00af
                if (r17 == 0) goto L_0x009b
                int r12 = r1 + -1
                int r12 = r12 - r10
                goto L_0x009c
            L_0x009b:
                r12 = r10
            L_0x009c:
                androidx.constraintlayout.solver.widgets.Flow r13 = androidx.constraintlayout.solver.widgets.Flow.this
                androidx.constraintlayout.solver.widgets.ConstraintWidget[] r13 = r13.mWidgets
                int r14 = r0.mStartIndex
                int r14 = r14 + r12
                r12 = r13[r14]
                boolean r13 = r12.hasBaseline()
                if (r13 == 0) goto L_0x00ac
                goto L_0x00b0
            L_0x00ac:
                int r10 = r10 + 1
                goto L_0x0093
            L_0x00af:
                r12 = r9
            L_0x00b0:
                r10 = r2
            L_0x00b1:
                if (r10 >= r1) goto L_0x0312
                if (r17 == 0) goto L_0x00b9
                int r13 = r1 + -1
                int r13 = r13 - r10
                goto L_0x00ba
            L_0x00b9:
                r13 = r10
            L_0x00ba:
                androidx.constraintlayout.solver.widgets.Flow r14 = androidx.constraintlayout.solver.widgets.Flow.this
                androidx.constraintlayout.solver.widgets.ConstraintWidget[] r14 = r14.mWidgets
                int r15 = r0.mStartIndex
                int r15 = r15 + r13
                r14 = r14[r15]
                if (r10 != 0) goto L_0x00ce
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r15 = r14.mLeft
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r0.mLeft
                int r3 = r0.mPaddingLeft
                r14.connect(r15, r11, r3)
            L_0x00ce:
                if (r13 != 0) goto L_0x0111
                androidx.constraintlayout.solver.widgets.Flow r3 = androidx.constraintlayout.solver.widgets.Flow.this
                int r3 = r3.mHorizontalStyle
                androidx.constraintlayout.solver.widgets.Flow r11 = androidx.constraintlayout.solver.widgets.Flow.this
                float r11 = r11.mHorizontalBias
                int r13 = r0.mStartIndex
                if (r13 != 0) goto L_0x00f5
                androidx.constraintlayout.solver.widgets.Flow r13 = androidx.constraintlayout.solver.widgets.Flow.this
                int r13 = r13.mFirstHorizontalStyle
                if (r13 == r5) goto L_0x00f5
                androidx.constraintlayout.solver.widgets.Flow r3 = androidx.constraintlayout.solver.widgets.Flow.this
                int r3 = r3.mFirstHorizontalStyle
                androidx.constraintlayout.solver.widgets.Flow r11 = androidx.constraintlayout.solver.widgets.Flow.this
                float r11 = r11.mFirstHorizontalBias
                goto L_0x010b
            L_0x00f5:
                if (r19 == 0) goto L_0x010b
                androidx.constraintlayout.solver.widgets.Flow r13 = androidx.constraintlayout.solver.widgets.Flow.this
                int r13 = r13.mLastHorizontalStyle
                if (r13 == r5) goto L_0x010b
                androidx.constraintlayout.solver.widgets.Flow r3 = androidx.constraintlayout.solver.widgets.Flow.this
                int r3 = r3.mLastHorizontalStyle
                androidx.constraintlayout.solver.widgets.Flow r11 = androidx.constraintlayout.solver.widgets.Flow.this
                float r11 = r11.mLastHorizontalBias
            L_0x010b:
                r14.setHorizontalChainStyle(r3)
                r14.setHorizontalBiasPercent(r11)
            L_0x0111:
                int r3 = r1 + -1
                if (r10 != r3) goto L_0x011e
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r14.mRight
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r0.mRight
                int r13 = r0.mPaddingRight
                r14.connect(r3, r11, r13)
            L_0x011e:
                if (r6 == 0) goto L_0x0149
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r14.mLeft
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r6.mRight
                androidx.constraintlayout.solver.widgets.Flow r13 = androidx.constraintlayout.solver.widgets.Flow.this
                int r13 = r13.mHorizontalGap
                r3.connect(r11, r13)
                if (r10 != r7) goto L_0x0136
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r14.mLeft
                int r11 = r0.mPaddingLeft
                r3.setGoneMargin(r11)
            L_0x0136:
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r6.mRight
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r14.mLeft
                r3.connect(r11, r2)
                r3 = 1
                int r11 = r8 + 1
                if (r10 != r11) goto L_0x0149
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r6.mRight
                int r6 = r0.mPaddingRight
                r3.setGoneMargin(r6)
            L_0x0149:
                if (r14 == r9) goto L_0x01a9
                androidx.constraintlayout.solver.widgets.Flow r3 = androidx.constraintlayout.solver.widgets.Flow.this
                int r3 = r3.mVerticalAlign
                r6 = 3
                if (r3 != r6) goto L_0x016a
                boolean r3 = r12.hasBaseline()
                if (r3 == 0) goto L_0x016a
                if (r14 == r12) goto L_0x016a
                boolean r3 = r14.hasBaseline()
                if (r3 == 0) goto L_0x016a
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r14.mBaseline
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r12.mBaseline
                r3.connect(r11, r2)
                goto L_0x01aa
            L_0x016a:
                androidx.constraintlayout.solver.widgets.Flow r3 = androidx.constraintlayout.solver.widgets.Flow.this
                int r3 = r3.mVerticalAlign
                if (r3 == 0) goto L_0x01a1
                r11 = 1
                if (r3 == r11) goto L_0x0199
                if (r4 == 0) goto L_0x018a
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r14.mTop
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r0.mTop
                int r13 = r0.mPaddingTop
                r3.connect(r11, r13)
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r14.mBottom
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r0.mBottom
                int r13 = r0.mPaddingBottom
                r3.connect(r11, r13)
                goto L_0x01aa
            L_0x018a:
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r14.mTop
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r9.mTop
                r3.connect(r11, r2)
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r14.mBottom
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r9.mBottom
                r3.connect(r11, r2)
                goto L_0x01aa
            L_0x0199:
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r14.mBottom
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r9.mBottom
                r3.connect(r11, r2)
                goto L_0x01aa
            L_0x01a1:
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r14.mTop
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r9.mTop
                r3.connect(r11, r2)
                goto L_0x01aa
            L_0x01a9:
                r6 = 3
            L_0x01aa:
                int r10 = r10 + 1
                r11 = r6
                r6 = r14
                goto L_0x00b1
            L_0x01b0:
                androidx.constraintlayout.solver.widgets.ConstraintWidget r3 = r0.biggest
                androidx.constraintlayout.solver.widgets.Flow r9 = androidx.constraintlayout.solver.widgets.Flow.this
                int r9 = r9.mVerticalStyle
                r3.setHorizontalChainStyle(r9)
                int r9 = r0.mPaddingLeft
                if (r18 <= 0) goto L_0x01c6
                androidx.constraintlayout.solver.widgets.Flow r10 = androidx.constraintlayout.solver.widgets.Flow.this
                int r10 = r10.mHorizontalGap
                int r9 = r9 + r10
            L_0x01c6:
                if (r17 == 0) goto L_0x01e8
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r10 = r3.mRight
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r0.mRight
                r10.connect(r11, r9)
                if (r19 == 0) goto L_0x01da
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r9 = r3.mLeft
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r10 = r0.mLeft
                int r11 = r0.mPaddingRight
                r9.connect(r10, r11)
            L_0x01da:
                if (r18 <= 0) goto L_0x0207
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r9 = r0.mRight
                androidx.constraintlayout.solver.widgets.ConstraintWidget r9 = r9.mOwner
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r9 = r9.mLeft
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r10 = r3.mRight
                r9.connect(r10, r2)
                goto L_0x0207
            L_0x01e8:
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r10 = r3.mLeft
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r0.mLeft
                r10.connect(r11, r9)
                if (r19 == 0) goto L_0x01fa
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r9 = r3.mRight
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r10 = r0.mRight
                int r11 = r0.mPaddingRight
                r9.connect(r10, r11)
            L_0x01fa:
                if (r18 <= 0) goto L_0x0207
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r9 = r0.mLeft
                androidx.constraintlayout.solver.widgets.ConstraintWidget r9 = r9.mOwner
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r9 = r9.mRight
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r10 = r3.mLeft
                r9.connect(r10, r2)
            L_0x0207:
                r9 = r2
            L_0x0208:
                if (r9 >= r1) goto L_0x0312
                androidx.constraintlayout.solver.widgets.Flow r10 = androidx.constraintlayout.solver.widgets.Flow.this
                androidx.constraintlayout.solver.widgets.ConstraintWidget[] r10 = r10.mWidgets
                int r11 = r0.mStartIndex
                int r11 = r11 + r9
                r10 = r10[r11]
                if (r9 != 0) goto L_0x025f
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r10.mTop
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r12 = r0.mTop
                int r13 = r0.mPaddingTop
                r10.connect(r11, r12, r13)
                androidx.constraintlayout.solver.widgets.Flow r11 = androidx.constraintlayout.solver.widgets.Flow.this
                int r11 = r11.mVerticalStyle
                androidx.constraintlayout.solver.widgets.Flow r12 = androidx.constraintlayout.solver.widgets.Flow.this
                float r12 = r12.mVerticalBias
                int r13 = r0.mStartIndex
                if (r13 != 0) goto L_0x0243
                androidx.constraintlayout.solver.widgets.Flow r13 = androidx.constraintlayout.solver.widgets.Flow.this
                int r13 = r13.mFirstVerticalStyle
                if (r13 == r5) goto L_0x0243
                androidx.constraintlayout.solver.widgets.Flow r11 = androidx.constraintlayout.solver.widgets.Flow.this
                int r11 = r11.mFirstVerticalStyle
                androidx.constraintlayout.solver.widgets.Flow r12 = androidx.constraintlayout.solver.widgets.Flow.this
                float r12 = r12.mFirstVerticalBias
                goto L_0x0259
            L_0x0243:
                if (r19 == 0) goto L_0x0259
                androidx.constraintlayout.solver.widgets.Flow r13 = androidx.constraintlayout.solver.widgets.Flow.this
                int r13 = r13.mLastVerticalStyle
                if (r13 == r5) goto L_0x0259
                androidx.constraintlayout.solver.widgets.Flow r11 = androidx.constraintlayout.solver.widgets.Flow.this
                int r11 = r11.mLastVerticalStyle
                androidx.constraintlayout.solver.widgets.Flow r12 = androidx.constraintlayout.solver.widgets.Flow.this
                float r12 = r12.mLastVerticalBias
            L_0x0259:
                r10.setVerticalChainStyle(r11)
                r10.setVerticalBiasPercent(r12)
            L_0x025f:
                int r11 = r1 + -1
                if (r9 != r11) goto L_0x026c
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r10.mBottom
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r12 = r0.mBottom
                int r13 = r0.mPaddingBottom
                r10.connect(r11, r12, r13)
            L_0x026c:
                if (r6 == 0) goto L_0x0297
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r10.mTop
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r12 = r6.mBottom
                androidx.constraintlayout.solver.widgets.Flow r13 = androidx.constraintlayout.solver.widgets.Flow.this
                int r13 = r13.mVerticalGap
                r11.connect(r12, r13)
                if (r9 != r7) goto L_0x0284
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r10.mTop
                int r12 = r0.mPaddingTop
                r11.setGoneMargin(r12)
            L_0x0284:
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r6.mBottom
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r12 = r10.mTop
                r11.connect(r12, r2)
                r11 = 1
                int r12 = r8 + 1
                if (r9 != r12) goto L_0x0297
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r6.mBottom
                int r11 = r0.mPaddingBottom
                r6.setGoneMargin(r11)
            L_0x0297:
                if (r10 == r3) goto L_0x030c
                r6 = 2
                if (r17 == 0) goto L_0x02c9
                androidx.constraintlayout.solver.widgets.Flow r11 = androidx.constraintlayout.solver.widgets.Flow.this
                int r11 = r11.mHorizontalAlign
                if (r11 == 0) goto L_0x02c1
                r12 = 1
                if (r11 == r12) goto L_0x02b9
                if (r11 == r6) goto L_0x02aa
                goto L_0x030c
            L_0x02aa:
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r10.mLeft
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r3.mLeft
                r6.connect(r11, r2)
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r10.mRight
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r3.mRight
                r6.connect(r11, r2)
                goto L_0x030c
            L_0x02b9:
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r10.mLeft
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r3.mLeft
                r6.connect(r11, r2)
                goto L_0x030c
            L_0x02c1:
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r10.mRight
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r3.mRight
                r6.connect(r11, r2)
                goto L_0x030c
            L_0x02c9:
                androidx.constraintlayout.solver.widgets.Flow r11 = androidx.constraintlayout.solver.widgets.Flow.this
                int r11 = r11.mHorizontalAlign
                if (r11 == 0) goto L_0x0303
                r12 = 1
                if (r11 == r12) goto L_0x02fb
                if (r11 == r6) goto L_0x02d7
                goto L_0x030d
            L_0x02d7:
                if (r4 == 0) goto L_0x02ec
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r10.mLeft
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r0.mLeft
                int r13 = r0.mPaddingLeft
                r6.connect(r11, r13)
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r10.mRight
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r0.mRight
                int r13 = r0.mPaddingRight
                r6.connect(r11, r13)
                goto L_0x030d
            L_0x02ec:
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r10.mLeft
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r3.mLeft
                r6.connect(r11, r2)
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r10.mRight
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r3.mRight
                r6.connect(r11, r2)
                goto L_0x030d
            L_0x02fb:
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r10.mRight
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r3.mRight
                r6.connect(r11, r2)
                goto L_0x030d
            L_0x0303:
                r12 = 1
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r10.mLeft
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r3.mLeft
                r6.connect(r11, r2)
                goto L_0x030d
            L_0x030c:
                r12 = 1
            L_0x030d:
                int r9 = r9 + 1
                r6 = r10
                goto L_0x0208
            L_0x0312:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.Flow.WidgetsList.createConstraints(boolean, int, boolean):void");
        }
    }

    private void measureChainWrap(ConstraintWidget[] constraintWidgetArr, int i, int i2, int[] iArr) {
        ConstraintAnchor constraintAnchor;
        int i3;
        int i4;
        ConstraintAnchor constraintAnchor2;
        int i5;
        ConstraintAnchor constraintAnchor3;
        int i6;
        int i7;
        int i8 = i2;
        int i9 = this.mWidgetsCount;
        if (i9 != 0) {
            this.mChainList.clear();
            WidgetsList widgetsList = new WidgetsList(i, this.mLeft, this.mTop, this.mRight, this.mBottom);
            this.mChainList.add(widgetsList);
            if (i == 0) {
                int i10 = this.mHorizontalGap * 2;
                for (int i11 = 0; i11 < i9; i11++) {
                    ConstraintWidget constraintWidget = constraintWidgetArr[i11];
                    int widgetWidth = getWidgetWidth(constraintWidget);
                    boolean z = (i10 + widgetWidth) + this.mHorizontalGap > i8 && widgetsList.biggest != null;
                    if (!z && i11 > 0 && (i7 = this.mMaxElementsWrap) > 0 && i11 % i7 == 0) {
                        z = true;
                    }
                    if (z) {
                        int i12 = this.mHorizontalGap * 2;
                        WidgetsList widgetsList2 = new WidgetsList(i, this.mLeft, this.mTop, this.mRight, this.mBottom);
                        widgetsList2.setStartIndex(i11);
                        this.mChainList.add(widgetsList2);
                        i10 = i12;
                        widgetsList = widgetsList2;
                    }
                    i10 += widgetWidth + this.mHorizontalGap;
                    widgetsList.add(constraintWidget);
                }
            } else {
                int i13 = this.mVerticalGap * 2;
                for (int i14 = 0; i14 < i9; i14++) {
                    ConstraintWidget constraintWidget2 = constraintWidgetArr[i14];
                    int widgetHeight = getWidgetHeight(constraintWidget2);
                    boolean z2 = (i13 + widgetHeight) + this.mVerticalGap > i8 && widgetsList.biggest != null;
                    if (!z2 && i14 > 0 && (i6 = this.mMaxElementsWrap) > 0 && i14 % i6 == 0) {
                        z2 = true;
                    }
                    if (z2) {
                        int i15 = this.mVerticalGap * 2;
                        WidgetsList widgetsList3 = new WidgetsList(i, this.mLeft, this.mTop, this.mRight, this.mBottom);
                        widgetsList3.setStartIndex(i14);
                        this.mChainList.add(widgetsList3);
                        i13 = i15;
                        widgetsList = widgetsList3;
                    }
                    i13 += widgetHeight;
                    widgetsList.add(constraintWidget2);
                }
            }
            int size = this.mChainList.size();
            ConstraintAnchor constraintAnchor4 = this.mLeft;
            ConstraintAnchor constraintAnchor5 = this.mTop;
            ConstraintAnchor constraintAnchor6 = this.mRight;
            ConstraintAnchor constraintAnchor7 = this.mBottom;
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            ConstraintAnchor constraintAnchor8 = constraintAnchor4;
            ConstraintAnchor constraintAnchor9 = constraintAnchor5;
            int paddingRight = getPaddingRight();
            int paddingBottom = getPaddingBottom();
            while (i18 < size) {
                WidgetsList widgetsList4 = this.mChainList.get(i18);
                if (i == 0) {
                    if (i18 < size - 1) {
                        constraintAnchor3 = this.mChainList.get(i18 + 1).biggest.mTop;
                        i5 = 0;
                    } else {
                        constraintAnchor3 = this.mBottom;
                        i5 = getPaddingBottom();
                    }
                    ConstraintAnchor constraintAnchor10 = constraintAnchor6;
                    ConstraintAnchor constraintAnchor11 = constraintAnchor3;
                    constraintAnchor = widgetsList4.biggest.mBottom;
                    i3 = i18;
                    widgetsList4.setup(i, constraintAnchor8, constraintAnchor9, constraintAnchor6, constraintAnchor3, paddingLeft, paddingTop, paddingRight, i5);
                    int max = Math.max(i17, widgetsList4.getWidth());
                    i16 += widgetsList4.getHeight();
                    if (i3 > 0) {
                        i16 += this.mVerticalGap;
                    }
                    constraintAnchor6 = constraintAnchor10;
                    i17 = max;
                    paddingBottom = i5;
                    paddingTop = 0;
                    constraintAnchor7 = constraintAnchor11;
                } else {
                    int i19 = paddingBottom;
                    ConstraintAnchor constraintAnchor12 = constraintAnchor9;
                    int i20 = i16;
                    int i21 = i17;
                    i3 = i18;
                    if (i3 < size - 1) {
                        constraintAnchor2 = this.mChainList.get(i3 + 1).biggest.mLeft;
                        i4 = 0;
                    } else {
                        constraintAnchor2 = this.mRight;
                        i4 = getPaddingRight();
                    }
                    constraintAnchor8 = widgetsList4.biggest.mRight;
                    widgetsList4.setup(i, constraintAnchor8, constraintAnchor12, constraintAnchor2, constraintAnchor7, paddingLeft, paddingTop, i4, i19);
                    i17 = i21 + widgetsList4.getWidth();
                    int max2 = Math.max(i20, widgetsList4.getHeight());
                    if (i3 > 0) {
                        i17 += this.mHorizontalGap;
                    }
                    i16 = max2;
                    paddingLeft = 0;
                    paddingBottom = i19;
                    constraintAnchor6 = constraintAnchor2;
                    constraintAnchor = constraintAnchor12;
                    paddingRight = i4;
                }
                i18 = i3 + 1;
                constraintAnchor9 = constraintAnchor;
            }
            iArr[0] = i17;
            iArr[1] = i16;
        }
    }

    private void measureNoWrap(ConstraintWidget[] constraintWidgetArr, int i, int i2, int[] iArr) {
        WidgetsList widgetsList;
        int i3 = this.mWidgetsCount;
        if (i3 != 0) {
            if (this.mChainList.size() == 0) {
                widgetsList = new WidgetsList(i, this.mLeft, this.mTop, this.mRight, this.mBottom);
                this.mChainList.add(widgetsList);
            } else {
                WidgetsList widgetsList2 = this.mChainList.get(0);
                widgetsList2.clear();
                widgetsList = widgetsList2;
                widgetsList.setup(i, this.mLeft, this.mTop, this.mRight, this.mBottom, getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
            }
            for (int i4 = 0; i4 < i3; i4++) {
                widgetsList.add(constraintWidgetArr[i4]);
            }
            iArr[0] = widgetsList.getWidth();
            iArr[1] = widgetsList.getHeight();
        }
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:52)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:86)
        */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0129 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0062  */
    private void measureAligned(androidx.constraintlayout.solver.widgets.ConstraintWidget[] r12, int r13, int r14, int[] r15) {
        /*
            r11 = this;
            r0 = 0
            if (r13 != 0) goto L_0x0028
            int r1 = r11.mMaxElementsWrap
            if (r1 > 0) goto L_0x0025
            r1 = r0
            r2 = r1
            r3 = r2
        L_0x000a:
            int r4 = r11.mWidgetsCount
            if (r2 >= r4) goto L_0x0025
            if (r2 <= 0) goto L_0x0013
            int r4 = r11.mHorizontalGap
            int r3 = r3 + r4
        L_0x0013:
            r4 = r12[r2]
            if (r4 != 0) goto L_0x0018
            goto L_0x0022
        L_0x0018:
            int r4 = r11.getWidgetWidth(r4)
            int r3 = r3 + r4
            if (r3 <= r14) goto L_0x0020
            goto L_0x0025
        L_0x0020:
            int r1 = r1 + 1
        L_0x0022:
            int r2 = r2 + 1
            goto L_0x000a
        L_0x0025:
            r2 = r1
            r1 = r0
            goto L_0x004b
        L_0x0028:
            int r1 = r11.mMaxElementsWrap
            if (r1 > 0) goto L_0x004a
            r1 = r0
            r2 = r1
            r3 = r2
        L_0x002f:
            int r4 = r11.mWidgetsCount
            if (r2 >= r4) goto L_0x004a
            if (r2 <= 0) goto L_0x0038
            int r4 = r11.mVerticalGap
            int r3 = r3 + r4
        L_0x0038:
            r4 = r12[r2]
            if (r4 != 0) goto L_0x003d
            goto L_0x0047
        L_0x003d:
            int r4 = r11.getWidgetHeight(r4)
            int r3 = r3 + r4
            if (r3 <= r14) goto L_0x0045
            goto L_0x004a
        L_0x0045:
            int r1 = r1 + 1
        L_0x0047:
            int r2 = r2 + 1
            goto L_0x002f
        L_0x004a:
            r2 = r0
        L_0x004b:
            int[] r3 = r11.mAlignedDimensions
            if (r3 != 0) goto L_0x0054
            r3 = 2
            int[] r3 = new int[r3]
            r11.mAlignedDimensions = r3
        L_0x0054:
            r3 = 1
            if (r1 != 0) goto L_0x0059
            if (r13 == r3) goto L_0x005d
        L_0x0059:
            if (r2 != 0) goto L_0x005f
            if (r13 != 0) goto L_0x005f
        L_0x005d:
            r4 = r3
            goto L_0x0060
        L_0x005f:
            r4 = r0
        L_0x0060:
            if (r4 != 0) goto L_0x0129
            if (r13 != 0) goto L_0x0070
            int r1 = r11.mWidgetsCount
            float r1 = (float) r1
            float r5 = (float) r2
            float r1 = r1 / r5
            double r5 = (double) r1
            double r5 = java.lang.Math.ceil(r5)
            int r1 = (int) r5
            goto L_0x007b
        L_0x0070:
            int r2 = r11.mWidgetsCount
            float r2 = (float) r2
            float r5 = (float) r1
            float r2 = r2 / r5
            double r5 = (double) r2
            double r5 = java.lang.Math.ceil(r5)
            int r2 = (int) r5
        L_0x007b:
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r5 = r11.mAlignedBiggestElementsInCols
            r6 = 0
            if (r5 == 0) goto L_0x0088
            int r7 = r5.length
            if (r7 >= r2) goto L_0x0084
            goto L_0x0088
        L_0x0084:
            java.util.Arrays.fill(r5, r6)
            goto L_0x008c
        L_0x0088:
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r5 = new androidx.constraintlayout.solver.widgets.ConstraintWidget[r2]
            r11.mAlignedBiggestElementsInCols = r5
        L_0x008c:
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r5 = r11.mAlignedBiggestElementsInRows
            if (r5 == 0) goto L_0x0098
            int r7 = r5.length
            if (r7 >= r1) goto L_0x0094
            goto L_0x0098
        L_0x0094:
            java.util.Arrays.fill(r5, r6)
            goto L_0x009c
        L_0x0098:
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r5 = new androidx.constraintlayout.solver.widgets.ConstraintWidget[r1]
            r11.mAlignedBiggestElementsInRows = r5
        L_0x009c:
            r5 = r0
        L_0x009d:
            if (r5 >= r2) goto L_0x00e5
            r6 = r0
        L_0x00a0:
            if (r6 >= r1) goto L_0x00e2
            int r7 = r6 * r2
            int r7 = r7 + r5
            if (r13 != r3) goto L_0x00aa
            int r7 = r5 * r1
            int r7 = r7 + r6
        L_0x00aa:
            int r8 = r12.length
            if (r7 < r8) goto L_0x00ae
            goto L_0x00df
        L_0x00ae:
            r7 = r12[r7]
            if (r7 != 0) goto L_0x00b3
            goto L_0x00df
        L_0x00b3:
            int r8 = r11.getWidgetWidth(r7)
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r9 = r11.mAlignedBiggestElementsInCols
            r10 = r9[r5]
            if (r10 == 0) goto L_0x00c5
            r9 = r9[r5]
            int r9 = r9.getWidth()
            if (r9 >= r8) goto L_0x00c9
        L_0x00c5:
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r8 = r11.mAlignedBiggestElementsInCols
            r8[r5] = r7
        L_0x00c9:
            int r8 = r11.getWidgetHeight(r7)
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r9 = r11.mAlignedBiggestElementsInRows
            r10 = r9[r6]
            if (r10 == 0) goto L_0x00db
            r9 = r9[r6]
            int r9 = r9.getHeight()
            if (r9 >= r8) goto L_0x00df
        L_0x00db:
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r8 = r11.mAlignedBiggestElementsInRows
            r8[r6] = r7
        L_0x00df:
            int r6 = r6 + 1
            goto L_0x00a0
        L_0x00e2:
            int r5 = r5 + 1
            goto L_0x009d
        L_0x00e5:
            r5 = r0
            r6 = r5
        L_0x00e7:
            if (r5 >= r2) goto L_0x00fc
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r7 = r11.mAlignedBiggestElementsInCols
            r7 = r7[r5]
            if (r7 == 0) goto L_0x00f9
            if (r5 <= 0) goto L_0x00f4
            int r8 = r11.mHorizontalGap
            int r6 = r6 + r8
        L_0x00f4:
            int r7 = r11.getWidgetWidth(r7)
            int r6 = r6 + r7
        L_0x00f9:
            int r5 = r5 + 1
            goto L_0x00e7
        L_0x00fc:
            r5 = r0
            r7 = r5
        L_0x00fe:
            if (r5 >= r1) goto L_0x0113
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r8 = r11.mAlignedBiggestElementsInRows
            r8 = r8[r5]
            if (r8 == 0) goto L_0x0110
            if (r5 <= 0) goto L_0x010b
            int r9 = r11.mVerticalGap
            int r7 = r7 + r9
        L_0x010b:
            int r8 = r11.getWidgetHeight(r8)
            int r7 = r7 + r8
        L_0x0110:
            int r5 = r5 + 1
            goto L_0x00fe
        L_0x0113:
            r15[r0] = r6
            r15[r3] = r7
            if (r13 != 0) goto L_0x0121
            if (r6 <= r14) goto L_0x005d
            if (r2 <= r3) goto L_0x005d
            int r2 = r2 + -1
            goto L_0x0060
        L_0x0121:
            if (r7 <= r14) goto L_0x005d
            if (r1 <= r3) goto L_0x005d
            int r1 = r1 + -1
            goto L_0x0060
        L_0x0129:
            int[] r12 = r11.mAlignedDimensions
            r12[r0] = r2
            r12[r3] = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.Flow.measureAligned(androidx.constraintlayout.solver.widgets.ConstraintWidget[], int, int, int[]):void");
    }

    private void createAlignedConstraints(boolean z) {
        ConstraintWidget constraintWidget;
        if (this.mAlignedDimensions != null && this.mAlignedBiggestElementsInCols != null && this.mAlignedBiggestElementsInRows != null) {
            for (int i = 0; i < this.mWidgetsCount; i++) {
                this.mWidgets[i].resetAnchors();
            }
            int[] iArr = this.mAlignedDimensions;
            int i2 = iArr[0];
            int i3 = iArr[1];
            ConstraintWidget constraintWidget2 = null;
            for (int i4 = 0; i4 < i2; i4++) {
                ConstraintWidget constraintWidget3 = this.mAlignedBiggestElementsInCols[z ? (i2 - i4) - 1 : i4];
                if (constraintWidget3 != null) {
                    if (i4 == 0) {
                        constraintWidget3.connect(constraintWidget3.mLeft, this.mLeft, getPaddingLeft());
                        constraintWidget3.setHorizontalChainStyle(this.mHorizontalStyle);
                        constraintWidget3.setHorizontalBiasPercent(this.mHorizontalBias);
                    }
                    if (i4 == i2 - 1) {
                        constraintWidget3.connect(constraintWidget3.mRight, this.mRight, getPaddingRight());
                    }
                    if (i4 > 0) {
                        constraintWidget3.connect(constraintWidget3.mLeft, constraintWidget2.mRight, this.mHorizontalGap);
                        constraintWidget2.connect(constraintWidget2.mRight, constraintWidget3.mLeft, 0);
                    }
                    constraintWidget2 = constraintWidget3;
                }
            }
            for (int i5 = 0; i5 < i3; i5++) {
                ConstraintWidget constraintWidget4 = this.mAlignedBiggestElementsInRows[i5];
                if (constraintWidget4 != null) {
                    if (i5 == 0) {
                        constraintWidget4.connect(constraintWidget4.mTop, this.mTop, getPaddingTop());
                        constraintWidget4.setVerticalChainStyle(this.mVerticalStyle);
                        constraintWidget4.setVerticalBiasPercent(this.mVerticalBias);
                    }
                    if (i5 == i3 - 1) {
                        constraintWidget4.connect(constraintWidget4.mBottom, this.mBottom, getPaddingBottom());
                    }
                    if (i5 > 0) {
                        constraintWidget4.connect(constraintWidget4.mTop, constraintWidget2.mBottom, this.mVerticalGap);
                        constraintWidget2.connect(constraintWidget2.mBottom, constraintWidget4.mTop, 0);
                    }
                    constraintWidget2 = constraintWidget4;
                }
            }
            for (int i6 = 0; i6 < i2; i6++) {
                for (int i7 = 0; i7 < i3; i7++) {
                    int i8 = (i7 * i2) + i6;
                    if (this.mOrientation == 1) {
                        i8 = (i6 * i3) + i7;
                    }
                    if (i8 < this.mWidgets.length && (constraintWidget = this.mWidgets[i8]) != null) {
                        ConstraintWidget constraintWidget5 = this.mAlignedBiggestElementsInCols[i6];
                        ConstraintWidget constraintWidget6 = this.mAlignedBiggestElementsInRows[i7];
                        if (constraintWidget != constraintWidget5) {
                            constraintWidget.connect(constraintWidget.mLeft, constraintWidget5.mLeft, 0);
                            constraintWidget.connect(constraintWidget.mRight, constraintWidget5.mRight, 0);
                        }
                        if (constraintWidget != constraintWidget6) {
                            constraintWidget.connect(constraintWidget.mTop, constraintWidget6.mTop, 0);
                            constraintWidget.connect(constraintWidget.mBottom, constraintWidget6.mBottom, 0);
                        }
                    }
                }
            }
        }
    }

    public void addToSolver(LinearSystem linearSystem) {
        super.addToSolver(linearSystem);
        boolean isRtl = getParent() != null ? ((ConstraintWidgetContainer) getParent()).isRtl() : false;
        int i = this.mWrapMode;
        if (i != 0) {
            if (i == 1) {
                int size = this.mChainList.size();
                int i2 = 0;
                while (i2 < size) {
                    this.mChainList.get(i2).createConstraints(isRtl, i2, i2 == size + -1);
                    i2++;
                }
            } else if (i == 2) {
                createAlignedConstraints(isRtl);
            }
        } else if (this.mChainList.size() > 0) {
            this.mChainList.get(0).createConstraints(isRtl, 0, true);
        }
        needsCallbackFromSolver(false);
    }
}
