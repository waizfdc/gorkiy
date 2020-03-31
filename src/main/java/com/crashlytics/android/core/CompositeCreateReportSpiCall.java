package com.crashlytics.android.core;

class CompositeCreateReportSpiCall implements CreateReportSpiCall {
    private final DefaultCreateReportSpiCall javaReportSpiCall;
    private final NativeCreateReportSpiCall nativeReportSpiCall;

    public CompositeCreateReportSpiCall(DefaultCreateReportSpiCall defaultCreateReportSpiCall, NativeCreateReportSpiCall nativeCreateReportSpiCall) {
        this.javaReportSpiCall = defaultCreateReportSpiCall;
        this.nativeReportSpiCall = nativeCreateReportSpiCall;
    }

    /* renamed from: com.crashlytics.android.core.CompositeCreateReportSpiCall$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$crashlytics$android$core$Report$Type;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.crashlytics.android.core.Report$Type[] r0 = com.crashlytics.android.core.Report.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.crashlytics.android.core.CompositeCreateReportSpiCall.AnonymousClass1.$SwitchMap$com$crashlytics$android$core$Report$Type = r0
                com.crashlytics.android.core.Report$Type r1 = com.crashlytics.android.core.Report.Type.JAVA     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = com.crashlytics.android.core.CompositeCreateReportSpiCall.AnonymousClass1.$SwitchMap$com$crashlytics$android$core$Report$Type     // Catch:{ NoSuchFieldError -> 0x001d }
                com.crashlytics.android.core.Report$Type r1 = com.crashlytics.android.core.Report.Type.NATIVE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.crashlytics.android.core.CompositeCreateReportSpiCall.AnonymousClass1.<clinit>():void");
        }
    }

    public boolean invoke(CreateReportRequest createReportRequest) {
        int i = AnonymousClass1.$SwitchMap$com$crashlytics$android$core$Report$Type[createReportRequest.report.getType().ordinal()];
        if (i == 1) {
            this.javaReportSpiCall.invoke(createReportRequest);
            return true;
        } else if (i != 2) {
            return false;
        } else {
            this.nativeReportSpiCall.invoke(createReportRequest);
            return true;
        }
    }
}
