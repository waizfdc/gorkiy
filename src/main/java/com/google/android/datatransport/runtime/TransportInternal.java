package com.google.android.datatransport.runtime;

import com.google.android.datatransport.TransportScheduleCallback;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
interface TransportInternal {
    void send(SendRequest sendRequest, TransportScheduleCallback transportScheduleCallback);
}
