package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.runtime.SendRequest;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
final class AutoValue_SendRequest extends SendRequest {
    private final Encoding encoding;
    private final Event<?> event;
    private final Transformer<?, byte[]> transformer;
    private final TransportContext transportContext;
    private final String transportName;

    private AutoValue_SendRequest(TransportContext transportContext2, String str, Event<?> event2, Transformer<?, byte[]> transformer2, Encoding encoding2) {
        this.transportContext = transportContext2;
        this.transportName = str;
        this.event = event2;
        this.transformer = transformer2;
        this.encoding = encoding2;
    }

    public TransportContext getTransportContext() {
        return this.transportContext;
    }

    public String getTransportName() {
        return this.transportName;
    }

    /* access modifiers changed from: package-private */
    public Event<?> getEvent() {
        return this.event;
    }

    /* access modifiers changed from: package-private */
    public Transformer<?, byte[]> getTransformer() {
        return this.transformer;
    }

    public Encoding getEncoding() {
        return this.encoding;
    }

    public String toString() {
        return "SendRequest{transportContext=" + this.transportContext + ", transportName=" + this.transportName + ", event=" + this.event + ", transformer=" + this.transformer + ", encoding=" + this.encoding + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SendRequest)) {
            return false;
        }
        SendRequest sendRequest = (SendRequest) obj;
        if (!this.transportContext.equals(super.getTransportContext()) || !this.transportName.equals(super.getTransportName()) || !this.event.equals(super.getEvent()) || !this.transformer.equals(super.getTransformer()) || !this.encoding.equals(super.getEncoding())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((((((((this.transportContext.hashCode() ^ 1000003) * 1000003) ^ this.transportName.hashCode()) * 1000003) ^ this.event.hashCode()) * 1000003) ^ this.transformer.hashCode()) * 1000003) ^ this.encoding.hashCode();
    }

    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
    static final class Builder extends SendRequest.Builder {
        private Encoding encoding;
        private Event<?> event;
        private Transformer<?, byte[]> transformer;
        private TransportContext transportContext;
        private String transportName;

        Builder() {
        }

        public SendRequest.Builder setTransportContext(TransportContext transportContext2) {
            if (transportContext2 != null) {
                this.transportContext = transportContext2;
                return super;
            }
            throw new NullPointerException("Null transportContext");
        }

        public SendRequest.Builder setTransportName(String str) {
            if (str != null) {
                this.transportName = str;
                return super;
            }
            throw new NullPointerException("Null transportName");
        }

        /* access modifiers changed from: package-private */
        public SendRequest.Builder setEvent(Event<?> event2) {
            if (event2 != null) {
                this.event = event2;
                return super;
            }
            throw new NullPointerException("Null event");
        }

        /* access modifiers changed from: package-private */
        public SendRequest.Builder setTransformer(Transformer<?, byte[]> transformer2) {
            if (transformer2 != null) {
                this.transformer = transformer2;
                return super;
            }
            throw new NullPointerException("Null transformer");
        }

        /* access modifiers changed from: package-private */
        public SendRequest.Builder setEncoding(Encoding encoding2) {
            if (encoding2 != null) {
                this.encoding = encoding2;
                return super;
            }
            throw new NullPointerException("Null encoding");
        }

        public SendRequest build() {
            String str = "";
            if (this.transportContext == null) {
                str = str + " transportContext";
            }
            if (this.transportName == null) {
                str = str + " transportName";
            }
            if (this.event == null) {
                str = str + " event";
            }
            if (this.transformer == null) {
                str = str + " transformer";
            }
            if (this.encoding == null) {
                str = str + " encoding";
            }
            if (str.isEmpty()) {
                return new AutoValue_SendRequest(this.transportContext, this.transportName, this.event, this.transformer, this.encoding);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
