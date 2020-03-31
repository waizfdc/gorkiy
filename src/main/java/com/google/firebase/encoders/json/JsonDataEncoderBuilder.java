package com.google.firebase.encoders.json;

import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.ValueEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* compiled from: com.google.firebase:firebase-encoders-json@@16.0.0 */
public final class JsonDataEncoderBuilder implements EncoderConfig<JsonDataEncoderBuilder> {
    private static final ValueEncoder<Boolean> BOOLEAN_ENCODER = JsonDataEncoderBuilder$$Lambda$4.lambdaFactory$();
    private static final ValueEncoder<String> STRING_ENCODER = JsonDataEncoderBuilder$$Lambda$1.lambdaFactory$();
    private static final TimestampEncoder TIMESTAMP_ENCODER = new TimestampEncoder();
    /* access modifiers changed from: private */
    public final Map<Class<?>, ObjectEncoder<?>> objectEncoders = new HashMap();
    /* access modifiers changed from: private */
    public final Map<Class<?>, ValueEncoder<?>> valueEncoders = new HashMap();

    /* compiled from: com.google.firebase:firebase-encoders-json@@16.0.0 */
    private static final class TimestampEncoder implements ValueEncoder<Date> {
        private static final DateFormat rfc339;

        private TimestampEncoder() {
        }

        static {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
            rfc339 = simpleDateFormat;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        }

        public void encode(Date date, ValueEncoderContext valueEncoderContext) throws EncodingException, IOException {
            valueEncoderContext.add(rfc339.format(date));
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.firebase.encoders.json.JsonDataEncoderBuilder.registerEncoder(java.lang.Class, com.google.firebase.encoders.ValueEncoder):com.google.firebase.encoders.json.JsonDataEncoderBuilder
     arg types: [java.lang.Class, com.google.firebase.encoders.ValueEncoder<java.lang.String>]
     candidates:
      com.google.firebase.encoders.json.JsonDataEncoderBuilder.registerEncoder(java.lang.Class, com.google.firebase.encoders.ObjectEncoder):com.google.firebase.encoders.config.EncoderConfig
      com.google.firebase.encoders.json.JsonDataEncoderBuilder.registerEncoder(java.lang.Class, com.google.firebase.encoders.ValueEncoder):com.google.firebase.encoders.config.EncoderConfig
      com.google.firebase.encoders.json.JsonDataEncoderBuilder.registerEncoder(java.lang.Class, com.google.firebase.encoders.ObjectEncoder):com.google.firebase.encoders.json.JsonDataEncoderBuilder
      com.google.firebase.encoders.config.EncoderConfig.registerEncoder(java.lang.Class, com.google.firebase.encoders.ObjectEncoder):T
      com.google.firebase.encoders.config.EncoderConfig.registerEncoder(java.lang.Class, com.google.firebase.encoders.ValueEncoder):T
      com.google.firebase.encoders.json.JsonDataEncoderBuilder.registerEncoder(java.lang.Class, com.google.firebase.encoders.ValueEncoder):com.google.firebase.encoders.json.JsonDataEncoderBuilder */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.firebase.encoders.json.JsonDataEncoderBuilder.registerEncoder(java.lang.Class, com.google.firebase.encoders.ValueEncoder):com.google.firebase.encoders.json.JsonDataEncoderBuilder
     arg types: [java.lang.Class, com.google.firebase.encoders.ValueEncoder<java.lang.Boolean>]
     candidates:
      com.google.firebase.encoders.json.JsonDataEncoderBuilder.registerEncoder(java.lang.Class, com.google.firebase.encoders.ObjectEncoder):com.google.firebase.encoders.config.EncoderConfig
      com.google.firebase.encoders.json.JsonDataEncoderBuilder.registerEncoder(java.lang.Class, com.google.firebase.encoders.ValueEncoder):com.google.firebase.encoders.config.EncoderConfig
      com.google.firebase.encoders.json.JsonDataEncoderBuilder.registerEncoder(java.lang.Class, com.google.firebase.encoders.ObjectEncoder):com.google.firebase.encoders.json.JsonDataEncoderBuilder
      com.google.firebase.encoders.config.EncoderConfig.registerEncoder(java.lang.Class, com.google.firebase.encoders.ObjectEncoder):T
      com.google.firebase.encoders.config.EncoderConfig.registerEncoder(java.lang.Class, com.google.firebase.encoders.ValueEncoder):T
      com.google.firebase.encoders.json.JsonDataEncoderBuilder.registerEncoder(java.lang.Class, com.google.firebase.encoders.ValueEncoder):com.google.firebase.encoders.json.JsonDataEncoderBuilder */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.firebase.encoders.json.JsonDataEncoderBuilder.registerEncoder(java.lang.Class, com.google.firebase.encoders.ValueEncoder):com.google.firebase.encoders.json.JsonDataEncoderBuilder
     arg types: [java.lang.Class, com.google.firebase.encoders.json.JsonDataEncoderBuilder$TimestampEncoder]
     candidates:
      com.google.firebase.encoders.json.JsonDataEncoderBuilder.registerEncoder(java.lang.Class, com.google.firebase.encoders.ObjectEncoder):com.google.firebase.encoders.config.EncoderConfig
      com.google.firebase.encoders.json.JsonDataEncoderBuilder.registerEncoder(java.lang.Class, com.google.firebase.encoders.ValueEncoder):com.google.firebase.encoders.config.EncoderConfig
      com.google.firebase.encoders.json.JsonDataEncoderBuilder.registerEncoder(java.lang.Class, com.google.firebase.encoders.ObjectEncoder):com.google.firebase.encoders.json.JsonDataEncoderBuilder
      com.google.firebase.encoders.config.EncoderConfig.registerEncoder(java.lang.Class, com.google.firebase.encoders.ObjectEncoder):T
      com.google.firebase.encoders.config.EncoderConfig.registerEncoder(java.lang.Class, com.google.firebase.encoders.ValueEncoder):T
      com.google.firebase.encoders.json.JsonDataEncoderBuilder.registerEncoder(java.lang.Class, com.google.firebase.encoders.ValueEncoder):com.google.firebase.encoders.json.JsonDataEncoderBuilder */
    public JsonDataEncoderBuilder() {
        registerEncoder(String.class, (ValueEncoder) STRING_ENCODER);
        registerEncoder(Boolean.class, (ValueEncoder) BOOLEAN_ENCODER);
        registerEncoder(Date.class, (ValueEncoder) TIMESTAMP_ENCODER);
    }

    public <T> JsonDataEncoderBuilder registerEncoder(Class cls, ObjectEncoder objectEncoder) {
        if (!this.objectEncoders.containsKey(cls)) {
            this.objectEncoders.put(cls, objectEncoder);
            return this;
        }
        throw new IllegalArgumentException("Encoder already registered for " + cls.getName());
    }

    public <T> JsonDataEncoderBuilder registerEncoder(Class cls, ValueEncoder valueEncoder) {
        if (!this.valueEncoders.containsKey(cls)) {
            this.valueEncoders.put(cls, valueEncoder);
            return this;
        }
        throw new IllegalArgumentException("Encoder already registered for " + cls.getName());
    }

    public JsonDataEncoderBuilder configureWith(Configurator configurator) {
        configurator.configure(this);
        return this;
    }

    public DataEncoder build() {
        return new DataEncoder() {
            /* class com.google.firebase.encoders.json.JsonDataEncoderBuilder.AnonymousClass1 */

            public void encode(Object obj, Writer writer) throws IOException, EncodingException {
                JsonValueObjectEncoderContext jsonValueObjectEncoderContext = new JsonValueObjectEncoderContext(writer, JsonDataEncoderBuilder.this.objectEncoders, JsonDataEncoderBuilder.this.valueEncoders);
                jsonValueObjectEncoderContext.add(obj);
                jsonValueObjectEncoderContext.close();
            }

            public String encode(Object obj) throws EncodingException {
                StringWriter stringWriter = new StringWriter();
                try {
                    encode(obj, stringWriter);
                } catch (IOException unused) {
                }
                return stringWriter.toString();
            }
        };
    }
}
