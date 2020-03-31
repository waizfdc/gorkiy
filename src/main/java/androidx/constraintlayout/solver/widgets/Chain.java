package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;

class Chain {
    private static final boolean DEBUG = false;

    Chain() {
    }

    static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int i) {
        ChainHead[] chainHeadArr;
        int i2;
        int i3;
        if (i == 0) {
            int i4 = constraintWidgetContainer.mHorizontalChainsSize;
            chainHeadArr = constraintWidgetContainer.mHorizontalChainsArray;
            i2 = i4;
            i3 = 0;
        } else {
            i3 = 2;
            i2 = constraintWidgetContainer.mVerticalChainsSize;
            chainHeadArr = constraintWidgetContainer.mVerticalChainsArray;
        }
        for (int i5 = 0; i5 < i2; i5++) {
            ChainHead chainHead = chainHeadArr[i5];
            chainHead.define();
            applyChainConstraints(constraintWidgetContainer, linearSystem, i, i3, chainHead);
        }
    }

    /* JADX WARN: Type inference failed for: r4v11, types: [androidx.constraintlayout.solver.SolverVariable] */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0035, code lost:
        if (r2.mHorizontalChainStyle == 2) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0048, code lost:
        if (r2.mVerticalChainStyle == 2) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x004c, code lost:
        r5 = false;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:216:0x03eb  */
    /* JADX WARNING: Removed duplicated region for block: B:319:0x03ec A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void applyChainConstraints(androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r37, androidx.constraintlayout.solver.LinearSystem r38, int r39, int r40, androidx.constraintlayout.solver.widgets.ChainHead r41) {
        /*
            r0 = r37
            r9 = r38
            r1 = r41
            androidx.constraintlayout.solver.widgets.ConstraintWidget r10 = r1.mFirst
            androidx.constraintlayout.solver.widgets.ConstraintWidget r11 = r1.mLast
            androidx.constraintlayout.solver.widgets.ConstraintWidget r12 = r1.mFirstVisibleWidget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r13 = r1.mLastVisibleWidget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r1.mHead
            float r3 = r1.mTotalWeight
            androidx.constraintlayout.solver.widgets.ConstraintWidget r4 = r1.mFirstMatchConstraintWidget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r4 = r1.mLastMatchConstraintWidget
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r4 = r0.mListDimensionBehaviors
            r4 = r4[r39]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            r7 = 1
            if (r4 != r5) goto L_0x0021
            r4 = r7
            goto L_0x0022
        L_0x0021:
            r4 = 0
        L_0x0022:
            r5 = 2
            if (r39 != 0) goto L_0x0038
            int r8 = r2.mHorizontalChainStyle
            if (r8 != 0) goto L_0x002b
            r8 = r7
            goto L_0x002c
        L_0x002b:
            r8 = 0
        L_0x002c:
            int r14 = r2.mHorizontalChainStyle
            if (r14 != r7) goto L_0x0032
            r14 = r7
            goto L_0x0033
        L_0x0032:
            r14 = 0
        L_0x0033:
            int r15 = r2.mHorizontalChainStyle
            if (r15 != r5) goto L_0x004c
            goto L_0x004a
        L_0x0038:
            int r8 = r2.mVerticalChainStyle
            if (r8 != 0) goto L_0x003e
            r8 = r7
            goto L_0x003f
        L_0x003e:
            r8 = 0
        L_0x003f:
            int r14 = r2.mVerticalChainStyle
            if (r14 != r7) goto L_0x0045
            r14 = r7
            goto L_0x0046
        L_0x0045:
            r14 = 0
        L_0x0046:
            int r15 = r2.mVerticalChainStyle
            if (r15 != r5) goto L_0x004c
        L_0x004a:
            r5 = r7
            goto L_0x004d
        L_0x004c:
            r5 = 0
        L_0x004d:
            r7 = r10
            r15 = r14
            r14 = r8
            r8 = 0
        L_0x0051:
            r21 = 0
            if (r8 != 0) goto L_0x014d
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r6 = r7.mListAnchors
            r6 = r6[r40]
            if (r4 != 0) goto L_0x0061
            if (r5 == 0) goto L_0x005e
            goto L_0x0061
        L_0x005e:
            r23 = 4
            goto L_0x0063
        L_0x0061:
            r23 = 1
        L_0x0063:
            int r24 = r6.getMargin()
            r25 = r3
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r3 = r7.mListDimensionBehaviors
            r3 = r3[r39]
            r26 = r8
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r8 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r3 != r8) goto L_0x007b
            int[] r3 = r7.mResolvedMatchConstraintDefault
            r3 = r3[r39]
            if (r3 != 0) goto L_0x007b
            r3 = 1
            goto L_0x007c
        L_0x007b:
            r3 = 0
        L_0x007c:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r6.mTarget
            if (r8 == 0) goto L_0x008a
            if (r7 == r10) goto L_0x008a
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r6.mTarget
            int r8 = r8.getMargin()
            int r24 = r24 + r8
        L_0x008a:
            r8 = r24
            if (r5 == 0) goto L_0x0097
            if (r7 == r10) goto L_0x0097
            if (r7 == r12) goto L_0x0097
            r23 = r15
            r22 = 6
            goto L_0x00a4
        L_0x0097:
            if (r14 == 0) goto L_0x00a0
            if (r4 == 0) goto L_0x00a0
            r23 = r15
            r22 = 4
            goto L_0x00a4
        L_0x00a0:
            r22 = r23
            r23 = r15
        L_0x00a4:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r15 = r6.mTarget
            if (r15 == 0) goto L_0x00df
            if (r7 != r12) goto L_0x00b9
            androidx.constraintlayout.solver.SolverVariable r15 = r6.mSolverVariable
            r24 = r14
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r14 = r6.mTarget
            androidx.constraintlayout.solver.SolverVariable r14 = r14.mSolverVariable
            r27 = r2
            r2 = 5
            r9.addGreaterThan(r15, r14, r8, r2)
            goto L_0x00c7
        L_0x00b9:
            r27 = r2
            r24 = r14
            androidx.constraintlayout.solver.SolverVariable r2 = r6.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r14 = r6.mTarget
            androidx.constraintlayout.solver.SolverVariable r14 = r14.mSolverVariable
            r15 = 6
            r9.addGreaterThan(r2, r14, r8, r15)
        L_0x00c7:
            if (r3 == 0) goto L_0x00d3
            if (r5 != 0) goto L_0x00d3
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r6.mTarget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r2.mOwner
            if (r2 != r0) goto L_0x00d3
            r2 = 5
            goto L_0x00d5
        L_0x00d3:
            r2 = r22
        L_0x00d5:
            androidx.constraintlayout.solver.SolverVariable r3 = r6.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r6.mTarget
            androidx.constraintlayout.solver.SolverVariable r6 = r6.mSolverVariable
            r9.addEquality(r3, r6, r8, r2)
            goto L_0x00e3
        L_0x00df:
            r27 = r2
            r24 = r14
        L_0x00e3:
            if (r4 == 0) goto L_0x011a
            int r2 = r7.getVisibility()
            r3 = 8
            if (r2 == r3) goto L_0x0109
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r2 = r7.mListDimensionBehaviors
            r2 = r2[r39]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r2 != r3) goto L_0x0109
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r7.mListAnchors
            int r3 = r40 + 1
            r2 = r2[r3]
            androidx.constraintlayout.solver.SolverVariable r2 = r2.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r7.mListAnchors
            r3 = r3[r40]
            androidx.constraintlayout.solver.SolverVariable r3 = r3.mSolverVariable
            r6 = 5
            r8 = 0
            r9.addGreaterThan(r2, r3, r8, r6)
            goto L_0x010a
        L_0x0109:
            r8 = 0
        L_0x010a:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r7.mListAnchors
            r2 = r2[r40]
            androidx.constraintlayout.solver.SolverVariable r2 = r2.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r0.mListAnchors
            r3 = r3[r40]
            androidx.constraintlayout.solver.SolverVariable r3 = r3.mSolverVariable
            r6 = 6
            r9.addGreaterThan(r2, r3, r8, r6)
        L_0x011a:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r7.mListAnchors
            int r3 = r40 + 1
            r2 = r2[r3]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r2.mTarget
            if (r2 == 0) goto L_0x013b
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r2.mOwner
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r2.mListAnchors
            r3 = r3[r40]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            if (r3 == 0) goto L_0x013b
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r2.mListAnchors
            r3 = r3[r40]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r3 = r3.mOwner
            if (r3 == r7) goto L_0x0139
            goto L_0x013b
        L_0x0139:
            r21 = r2
        L_0x013b:
            if (r21 == 0) goto L_0x0142
            r7 = r21
            r8 = r26
            goto L_0x0143
        L_0x0142:
            r8 = 1
        L_0x0143:
            r15 = r23
            r14 = r24
            r3 = r25
            r2 = r27
            goto L_0x0051
        L_0x014d:
            r27 = r2
            r25 = r3
            r24 = r14
            r23 = r15
            if (r13 == 0) goto L_0x01ba
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r11.mListAnchors
            int r3 = r40 + 1
            r2 = r2[r3]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r2.mTarget
            if (r2 == 0) goto L_0x01ba
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r13.mListAnchors
            r2 = r2[r3]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r6 = r13.mListDimensionBehaviors
            r6 = r6[r39]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r7 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r6 != r7) goto L_0x0175
            int[] r6 = r13.mResolvedMatchConstraintDefault
            r6 = r6[r39]
            if (r6 != 0) goto L_0x0175
            r6 = 1
            goto L_0x0176
        L_0x0175:
            r6 = 0
        L_0x0176:
            if (r6 == 0) goto L_0x0190
            if (r5 != 0) goto L_0x0190
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r2.mTarget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r6 = r6.mOwner
            if (r6 != r0) goto L_0x0190
            androidx.constraintlayout.solver.SolverVariable r6 = r2.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r7 = r2.mTarget
            androidx.constraintlayout.solver.SolverVariable r7 = r7.mSolverVariable
            int r8 = r2.getMargin()
            int r8 = -r8
            r14 = 5
            r9.addEquality(r6, r7, r8, r14)
            goto L_0x01a7
        L_0x0190:
            if (r5 == 0) goto L_0x01a7
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r2.mTarget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r6 = r6.mOwner
            if (r6 != r0) goto L_0x01a7
            androidx.constraintlayout.solver.SolverVariable r6 = r2.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r7 = r2.mTarget
            androidx.constraintlayout.solver.SolverVariable r7 = r7.mSolverVariable
            int r8 = r2.getMargin()
            int r8 = -r8
            r14 = 4
            r9.addEquality(r6, r7, r8, r14)
        L_0x01a7:
            androidx.constraintlayout.solver.SolverVariable r6 = r2.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r7 = r11.mListAnchors
            r3 = r7[r3]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            androidx.constraintlayout.solver.SolverVariable r3 = r3.mSolverVariable
            int r2 = r2.getMargin()
            int r2 = -r2
            r7 = 5
            r9.addLowerThan(r6, r3, r2, r7)
        L_0x01ba:
            if (r4 == 0) goto L_0x01d6
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r0.mListAnchors
            int r2 = r40 + 1
            r0 = r0[r2]
            androidx.constraintlayout.solver.SolverVariable r0 = r0.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r11.mListAnchors
            r3 = r3[r2]
            androidx.constraintlayout.solver.SolverVariable r3 = r3.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r4 = r11.mListAnchors
            r2 = r4[r2]
            int r2 = r2.getMargin()
            r4 = 6
            r9.addGreaterThan(r0, r3, r2, r4)
        L_0x01d6:
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.ConstraintWidget> r0 = r1.mWeightedMatchConstraintsWidgets
            if (r0 == 0) goto L_0x028c
            int r2 = r0.size()
            r3 = 1
            if (r2 <= r3) goto L_0x028c
            boolean r4 = r1.mHasUndefinedWeights
            if (r4 == 0) goto L_0x01ed
            boolean r4 = r1.mHasComplexMatchWeights
            if (r4 != 0) goto L_0x01ed
            int r4 = r1.mWidgetsMatchCount
            float r4 = (float) r4
            goto L_0x01ef
        L_0x01ed:
            r4 = r25
        L_0x01ef:
            r6 = 0
            r29 = r6
            r7 = r21
            r8 = 0
        L_0x01f5:
            if (r8 >= r2) goto L_0x028c
            java.lang.Object r14 = r0.get(r8)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r14 = (androidx.constraintlayout.solver.widgets.ConstraintWidget) r14
            float[] r15 = r14.mWeight
            r15 = r15[r39]
            int r16 = (r15 > r6 ? 1 : (r15 == r6 ? 0 : -1))
            if (r16 >= 0) goto L_0x0222
            boolean r15 = r1.mHasComplexMatchWeights
            if (r15 == 0) goto L_0x021e
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r15 = r14.mListAnchors
            int r16 = r40 + 1
            r15 = r15[r16]
            androidx.constraintlayout.solver.SolverVariable r15 = r15.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r14 = r14.mListAnchors
            r14 = r14[r40]
            androidx.constraintlayout.solver.SolverVariable r14 = r14.mSolverVariable
            r3 = 0
            r6 = 4
            r9.addEquality(r15, r14, r3, r6)
            r6 = 6
            goto L_0x023b
        L_0x021e:
            r6 = 4
            r15 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0223
        L_0x0222:
            r6 = 4
        L_0x0223:
            r3 = 0
            int r19 = (r15 > r3 ? 1 : (r15 == r3 ? 0 : -1))
            if (r19 != 0) goto L_0x0240
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r15 = r14.mListAnchors
            int r19 = r40 + 1
            r15 = r15[r19]
            androidx.constraintlayout.solver.SolverVariable r15 = r15.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r14 = r14.mListAnchors
            r14 = r14[r40]
            androidx.constraintlayout.solver.SolverVariable r14 = r14.mSolverVariable
            r3 = 0
            r6 = 6
            r9.addEquality(r15, r14, r3, r6)
        L_0x023b:
            r25 = r0
            r19 = r2
            goto L_0x0282
        L_0x0240:
            r3 = 0
            r6 = 6
            if (r7 == 0) goto L_0x027b
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r7.mListAnchors
            r3 = r3[r40]
            androidx.constraintlayout.solver.SolverVariable r3 = r3.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r7 = r7.mListAnchors
            int r19 = r40 + 1
            r7 = r7[r19]
            androidx.constraintlayout.solver.SolverVariable r7 = r7.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r6 = r14.mListAnchors
            r6 = r6[r40]
            androidx.constraintlayout.solver.SolverVariable r6 = r6.mSolverVariable
            r25 = r0
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r14.mListAnchors
            r0 = r0[r19]
            androidx.constraintlayout.solver.SolverVariable r0 = r0.mSolverVariable
            r19 = r2
            androidx.constraintlayout.solver.ArrayRow r2 = r38.createRow()
            r28 = r2
            r30 = r4
            r31 = r15
            r32 = r3
            r33 = r7
            r34 = r6
            r35 = r0
            r28.createRowEqualMatchDimensions(r29, r30, r31, r32, r33, r34, r35)
            r9.addConstraint(r2)
            goto L_0x027f
        L_0x027b:
            r25 = r0
            r19 = r2
        L_0x027f:
            r7 = r14
            r29 = r15
        L_0x0282:
            int r8 = r8 + 1
            r2 = r19
            r0 = r25
            r3 = 1
            r6 = 0
            goto L_0x01f5
        L_0x028c:
            if (r12 == 0) goto L_0x02f6
            if (r12 == r13) goto L_0x0292
            if (r5 == 0) goto L_0x02f6
        L_0x0292:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r10.mListAnchors
            r0 = r0[r40]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r11.mListAnchors
            int r2 = r40 + 1
            r1 = r1[r2]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r10.mListAnchors
            r3 = r3[r40]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            if (r3 == 0) goto L_0x02ad
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r10.mListAnchors
            r3 = r3[r40]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            androidx.constraintlayout.solver.SolverVariable r3 = r3.mSolverVariable
            goto L_0x02af
        L_0x02ad:
            r3 = r21
        L_0x02af:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r4 = r11.mListAnchors
            r4 = r4[r2]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r4.mTarget
            if (r4 == 0) goto L_0x02c1
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r4 = r11.mListAnchors
            r4 = r4[r2]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r4.mTarget
            androidx.constraintlayout.solver.SolverVariable r4 = r4.mSolverVariable
            r5 = r4
            goto L_0x02c3
        L_0x02c1:
            r5 = r21
        L_0x02c3:
            if (r12 != r13) goto L_0x02cd
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r12.mListAnchors
            r0 = r0[r40]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r12.mListAnchors
            r1 = r1[r2]
        L_0x02cd:
            if (r3 == 0) goto L_0x051f
            if (r5 == 0) goto L_0x051f
            if (r39 != 0) goto L_0x02d8
            r2 = r27
            float r2 = r2.mHorizontalBiasPercent
            goto L_0x02dc
        L_0x02d8:
            r2 = r27
            float r2 = r2.mVerticalBiasPercent
        L_0x02dc:
            r4 = r2
            int r6 = r0.getMargin()
            int r7 = r1.getMargin()
            androidx.constraintlayout.solver.SolverVariable r2 = r0.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r8 = r1.mSolverVariable
            r10 = 5
            r0 = r38
            r1 = r2
            r2 = r3
            r3 = r6
            r6 = r8
            r8 = r10
            r0.addCentering(r1, r2, r3, r4, r5, r6, r7, r8)
            goto L_0x051f
        L_0x02f6:
            if (r24 == 0) goto L_0x03f0
            if (r12 == 0) goto L_0x03f0
            int r0 = r1.mWidgetsMatchCount
            if (r0 <= 0) goto L_0x0307
            int r0 = r1.mWidgetsCount
            int r1 = r1.mWidgetsMatchCount
            if (r0 != r1) goto L_0x0307
            r16 = 1
            goto L_0x0309
        L_0x0307:
            r16 = 0
        L_0x0309:
            r14 = r12
            r15 = r14
        L_0x030b:
            if (r14 == 0) goto L_0x051f
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r0 = r14.mNextChainWidget
            r0 = r0[r39]
            r8 = r0
        L_0x0312:
            if (r8 == 0) goto L_0x0321
            int r0 = r8.getVisibility()
            r6 = 8
            if (r0 != r6) goto L_0x0323
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r0 = r8.mNextChainWidget
            r8 = r0[r39]
            goto L_0x0312
        L_0x0321:
            r6 = 8
        L_0x0323:
            if (r8 != 0) goto L_0x032e
            if (r14 != r13) goto L_0x0328
            goto L_0x032e
        L_0x0328:
            r17 = r8
            r18 = 6
            goto L_0x03e3
        L_0x032e:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r14.mListAnchors
            r0 = r0[r40]
            androidx.constraintlayout.solver.SolverVariable r1 = r0.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r0.mTarget
            if (r2 == 0) goto L_0x033d
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r0.mTarget
            androidx.constraintlayout.solver.SolverVariable r2 = r2.mSolverVariable
            goto L_0x033f
        L_0x033d:
            r2 = r21
        L_0x033f:
            if (r15 == r14) goto L_0x034a
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r15.mListAnchors
            int r3 = r40 + 1
            r2 = r2[r3]
            androidx.constraintlayout.solver.SolverVariable r2 = r2.mSolverVariable
            goto L_0x0361
        L_0x034a:
            if (r14 != r12) goto L_0x0361
            if (r15 != r14) goto L_0x0361
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r10.mListAnchors
            r2 = r2[r40]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r2.mTarget
            if (r2 == 0) goto L_0x035f
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r10.mListAnchors
            r2 = r2[r40]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r2.mTarget
            androidx.constraintlayout.solver.SolverVariable r2 = r2.mSolverVariable
            goto L_0x0361
        L_0x035f:
            r2 = r21
        L_0x0361:
            int r0 = r0.getMargin()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r14.mListAnchors
            int r4 = r40 + 1
            r3 = r3[r4]
            int r3 = r3.getMargin()
            if (r8 == 0) goto L_0x0383
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r5 = r8.mListAnchors
            r5 = r5[r40]
            androidx.constraintlayout.solver.SolverVariable r7 = r5.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r6 = r14.mListAnchors
            r6 = r6[r4]
            androidx.constraintlayout.solver.SolverVariable r6 = r6.mSolverVariable
            r36 = r7
            r7 = r6
            r6 = r36
            goto L_0x0396
        L_0x0383:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r5 = r11.mListAnchors
            r5 = r5[r4]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r5.mTarget
            if (r5 == 0) goto L_0x038e
            androidx.constraintlayout.solver.SolverVariable r6 = r5.mSolverVariable
            goto L_0x0390
        L_0x038e:
            r6 = r21
        L_0x0390:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r7 = r14.mListAnchors
            r7 = r7[r4]
            androidx.constraintlayout.solver.SolverVariable r7 = r7.mSolverVariable
        L_0x0396:
            if (r5 == 0) goto L_0x039d
            int r5 = r5.getMargin()
            int r3 = r3 + r5
        L_0x039d:
            if (r15 == 0) goto L_0x03a8
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r5 = r15.mListAnchors
            r5 = r5[r4]
            int r5 = r5.getMargin()
            int r0 = r0 + r5
        L_0x03a8:
            if (r1 == 0) goto L_0x0328
            if (r2 == 0) goto L_0x0328
            if (r6 == 0) goto L_0x0328
            if (r7 == 0) goto L_0x0328
            if (r14 != r12) goto L_0x03ba
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r12.mListAnchors
            r0 = r0[r40]
            int r0 = r0.getMargin()
        L_0x03ba:
            r5 = r0
            if (r14 != r13) goto L_0x03c8
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r13.mListAnchors
            r0 = r0[r4]
            int r0 = r0.getMargin()
            r17 = r0
            goto L_0x03ca
        L_0x03c8:
            r17 = r3
        L_0x03ca:
            if (r16 == 0) goto L_0x03cf
            r19 = 6
            goto L_0x03d1
        L_0x03cf:
            r19 = 4
        L_0x03d1:
            r4 = 1056964608(0x3f000000, float:0.5)
            r0 = r38
            r3 = r5
            r5 = r6
            r18 = 6
            r6 = r7
            r7 = r17
            r17 = r8
            r8 = r19
            r0.addCentering(r1, r2, r3, r4, r5, r6, r7, r8)
        L_0x03e3:
            int r0 = r14.getVisibility()
            r8 = 8
            if (r0 == r8) goto L_0x03ec
            r15 = r14
        L_0x03ec:
            r14 = r17
            goto L_0x030b
        L_0x03f0:
            r8 = 8
            r18 = 6
            if (r23 == 0) goto L_0x051f
            if (r12 == 0) goto L_0x051f
            int r0 = r1.mWidgetsMatchCount
            if (r0 <= 0) goto L_0x0405
            int r0 = r1.mWidgetsCount
            int r1 = r1.mWidgetsMatchCount
            if (r0 != r1) goto L_0x0405
            r16 = 1
            goto L_0x0407
        L_0x0405:
            r16 = 0
        L_0x0407:
            r14 = r12
            r15 = r14
        L_0x0409:
            if (r14 == 0) goto L_0x04c1
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r0 = r14.mNextChainWidget
            r0 = r0[r39]
        L_0x040f:
            if (r0 == 0) goto L_0x041c
            int r1 = r0.getVisibility()
            if (r1 != r8) goto L_0x041c
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r0 = r0.mNextChainWidget
            r0 = r0[r39]
            goto L_0x040f
        L_0x041c:
            if (r14 == r12) goto L_0x04b0
            if (r14 == r13) goto L_0x04b0
            if (r0 == 0) goto L_0x04b0
            if (r0 != r13) goto L_0x0427
            r7 = r21
            goto L_0x0428
        L_0x0427:
            r7 = r0
        L_0x0428:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r14.mListAnchors
            r0 = r0[r40]
            androidx.constraintlayout.solver.SolverVariable r1 = r0.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r0.mTarget
            if (r2 == 0) goto L_0x0436
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r0.mTarget
            androidx.constraintlayout.solver.SolverVariable r2 = r2.mSolverVariable
        L_0x0436:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r15.mListAnchors
            int r3 = r40 + 1
            r2 = r2[r3]
            androidx.constraintlayout.solver.SolverVariable r2 = r2.mSolverVariable
            int r0 = r0.getMargin()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r4 = r14.mListAnchors
            r4 = r4[r3]
            int r4 = r4.getMargin()
            if (r7 == 0) goto L_0x045e
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r5 = r7.mListAnchors
            r5 = r5[r40]
            androidx.constraintlayout.solver.SolverVariable r6 = r5.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r5.mTarget
            if (r8 == 0) goto L_0x045b
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r5.mTarget
            androidx.constraintlayout.solver.SolverVariable r8 = r8.mSolverVariable
            goto L_0x046f
        L_0x045b:
            r8 = r21
            goto L_0x046f
        L_0x045e:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r5 = r13.mListAnchors
            r5 = r5[r40]
            if (r5 == 0) goto L_0x0467
            androidx.constraintlayout.solver.SolverVariable r6 = r5.mSolverVariable
            goto L_0x0469
        L_0x0467:
            r6 = r21
        L_0x0469:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r8 = r14.mListAnchors
            r8 = r8[r3]
            androidx.constraintlayout.solver.SolverVariable r8 = r8.mSolverVariable
        L_0x046f:
            if (r5 == 0) goto L_0x0476
            int r5 = r5.getMargin()
            int r4 = r4 + r5
        L_0x0476:
            r17 = r4
            if (r15 == 0) goto L_0x0483
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r4 = r15.mListAnchors
            r3 = r4[r3]
            int r3 = r3.getMargin()
            int r0 = r0 + r3
        L_0x0483:
            r3 = r0
            if (r16 == 0) goto L_0x0489
            r19 = r18
            goto L_0x048b
        L_0x0489:
            r19 = 4
        L_0x048b:
            if (r1 == 0) goto L_0x04a7
            if (r2 == 0) goto L_0x04a7
            if (r6 == 0) goto L_0x04a7
            if (r8 == 0) goto L_0x04a7
            r4 = 1056964608(0x3f000000, float:0.5)
            r0 = r38
            r5 = r6
            r6 = r8
            r20 = r7
            r7 = r17
            r17 = r15
            r15 = 8
            r8 = r19
            r0.addCentering(r1, r2, r3, r4, r5, r6, r7, r8)
            goto L_0x04ad
        L_0x04a7:
            r20 = r7
            r17 = r15
            r15 = 8
        L_0x04ad:
            r0 = r20
            goto L_0x04b3
        L_0x04b0:
            r17 = r15
            r15 = r8
        L_0x04b3:
            int r1 = r14.getVisibility()
            if (r1 == r15) goto L_0x04ba
            goto L_0x04bc
        L_0x04ba:
            r14 = r17
        L_0x04bc:
            r8 = r15
            r15 = r14
            r14 = r0
            goto L_0x0409
        L_0x04c1:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r12.mListAnchors
            r0 = r0[r40]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r10.mListAnchors
            r1 = r1[r40]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r1.mTarget
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r13.mListAnchors
            int r3 = r40 + 1
            r10 = r2[r3]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r11.mListAnchors
            r2 = r2[r3]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r14 = r2.mTarget
            if (r1 == 0) goto L_0x050e
            if (r12 == r13) goto L_0x04e8
            androidx.constraintlayout.solver.SolverVariable r2 = r0.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r1 = r1.mSolverVariable
            int r0 = r0.getMargin()
            r15 = 4
            r9.addEquality(r2, r1, r0, r15)
            goto L_0x050f
        L_0x04e8:
            r15 = 4
            if (r14 == 0) goto L_0x050f
            androidx.constraintlayout.solver.SolverVariable r2 = r0.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r3 = r1.mSolverVariable
            int r4 = r0.getMargin()
            r5 = 1056964608(0x3f000000, float:0.5)
            androidx.constraintlayout.solver.SolverVariable r6 = r10.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r7 = r14.mSolverVariable
            int r8 = r10.getMargin()
            r16 = 4
            r0 = r38
            r1 = r2
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r16
            r0.addCentering(r1, r2, r3, r4, r5, r6, r7, r8)
            goto L_0x050f
        L_0x050e:
            r15 = 4
        L_0x050f:
            if (r14 == 0) goto L_0x051f
            if (r12 == r13) goto L_0x051f
            androidx.constraintlayout.solver.SolverVariable r0 = r10.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r1 = r14.mSolverVariable
            int r2 = r10.getMargin()
            int r2 = -r2
            r9.addEquality(r0, r1, r2, r15)
        L_0x051f:
            if (r24 != 0) goto L_0x0523
            if (r23 == 0) goto L_0x0588
        L_0x0523:
            if (r12 == 0) goto L_0x0588
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r12.mListAnchors
            r0 = r0[r40]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r13.mListAnchors
            int r2 = r40 + 1
            r1 = r1[r2]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r0.mTarget
            if (r3 == 0) goto L_0x0538
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r0.mTarget
            androidx.constraintlayout.solver.SolverVariable r3 = r3.mSolverVariable
            goto L_0x053a
        L_0x0538:
            r3 = r21
        L_0x053a:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r1.mTarget
            if (r4 == 0) goto L_0x0543
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r1.mTarget
            androidx.constraintlayout.solver.SolverVariable r4 = r4.mSolverVariable
            goto L_0x0545
        L_0x0543:
            r4 = r21
        L_0x0545:
            if (r11 == r13) goto L_0x0558
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r4 = r11.mListAnchors
            r4 = r4[r2]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r4.mTarget
            if (r5 == 0) goto L_0x0555
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r4.mTarget
            androidx.constraintlayout.solver.SolverVariable r4 = r4.mSolverVariable
            r21 = r4
        L_0x0555:
            r5 = r21
            goto L_0x0559
        L_0x0558:
            r5 = r4
        L_0x0559:
            if (r12 != r13) goto L_0x0563
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r12.mListAnchors
            r0 = r0[r40]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r12.mListAnchors
            r1 = r1[r2]
        L_0x0563:
            if (r3 == 0) goto L_0x0588
            if (r5 == 0) goto L_0x0588
            r4 = 1056964608(0x3f000000, float:0.5)
            int r6 = r0.getMargin()
            if (r13 != 0) goto L_0x0570
            goto L_0x0571
        L_0x0570:
            r11 = r13
        L_0x0571:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r7 = r11.mListAnchors
            r2 = r7[r2]
            int r7 = r2.getMargin()
            androidx.constraintlayout.solver.SolverVariable r2 = r0.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r8 = r1.mSolverVariable
            r10 = 5
            r0 = r38
            r1 = r2
            r2 = r3
            r3 = r6
            r6 = r8
            r8 = r10
            r0.addCentering(r1, r2, r3, r4, r5, r6, r7, r8)
        L_0x0588:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.Chain.applyChainConstraints(androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer, androidx.constraintlayout.solver.LinearSystem, int, int, androidx.constraintlayout.solver.widgets.ChainHead):void");
    }
}
