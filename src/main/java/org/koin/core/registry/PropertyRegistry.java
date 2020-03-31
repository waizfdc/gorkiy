package org.koin.core.registry;

import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.ByteArrayInputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.MapsKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.koin.core.Koin;
import org.koin.core.error.NoPropertyFileFoundException;
import org.koin.core.logger.Level;
import org.koin.core.logger.Logger;
import org.koin.ext.StringExtKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\tJ\u001b\u0010\u000e\u001a\u0004\u0018\u0001H\u000f\"\u0004\b\u0000\u0010\u000f2\u0006\u0010\r\u001a\u00020\t¢\u0006\u0002\u0010\u0010J\u0006\u0010\u0011\u001a\u00020\u000bJ\u000e\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\tJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\tH\u0002J\u000e\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0015J\u001a\u0010\u0017\u001a\u00020\u000b2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u0019J)\u0010\u001a\u001a\u00020\u000b\"\b\b\u0000\u0010\u000f*\u00020\u00012\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u001b\u001a\u0002H\u000fH\u0000¢\u0006\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lorg/koin/core/registry/PropertyRegistry;", "", "_koin", "Lorg/koin/core/Koin;", "(Lorg/koin/core/Koin;)V", "get_koin", "()Lorg/koin/core/Koin;", "_values", "", "", "close", "", "deleteProperty", "key", "getProperty", ExifInterface.GPS_DIRECTION_TRUE, "(Ljava/lang/String;)Ljava/lang/Object;", "loadEnvironmentProperties", "loadPropertiesFromFile", "fileName", "readDataFromFile", "Ljava/util/Properties;", FirebaseAnalytics.Param.CONTENT, "saveProperties", "properties", "", "saveProperty", "value", "saveProperty$koin_core", "(Ljava/lang/String;Ljava/lang/Object;)V", "koin-core"}, k = 1, mv = {1, 1, 16})
/* compiled from: PropertyRegistry.kt */
public final class PropertyRegistry {
    private final Koin _koin;
    private final Map<String, Object> _values = new ConcurrentHashMap();

    public PropertyRegistry(Koin koin) {
        Intrinsics.checkParameterIsNotNull(koin, "_koin");
        this._koin = koin;
    }

    public final Koin get_koin() {
        return this._koin;
    }

    public final void saveProperties(Map<String, ? extends Object> map) {
        Intrinsics.checkParameterIsNotNull(map, "properties");
        if (this._koin.get_logger().isAt(Level.DEBUG)) {
            Logger logger = this._koin.get_logger();
            logger.debug("load " + map.size() + " properties");
        }
        this._values.putAll(map);
    }

    public final void saveProperties(Properties properties) {
        Intrinsics.checkParameterIsNotNull(properties, "properties");
        if (this._koin.get_logger().isAt(Level.DEBUG)) {
            Logger logger = this._koin.get_logger();
            logger.debug("load " + properties.size() + " properties");
        }
        Map map = MapsKt.toMap(properties);
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                String str2 = (String) entry.getValue();
                if (StringExtKt.isInt(str2)) {
                    saveProperty$koin_core(str, Integer.valueOf(Integer.parseInt(str2)));
                } else if (StringExtKt.isFloat(str2)) {
                    saveProperty$koin_core(str, Float.valueOf(Float.parseFloat(str2)));
                } else {
                    saveProperty$koin_core(str, StringExtKt.quoted(str2));
                }
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
    }

    public final <T> void saveProperty$koin_core(String str, T t) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        Intrinsics.checkParameterIsNotNull(t, "value");
        this._values.put(str, t);
    }

    public final void deleteProperty(String str) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        this._values.remove(str);
    }

    public final <T> T getProperty(String str) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        T t = this._values.get(str);
        if (!(t instanceof Object)) {
            return null;
        }
        return t;
    }

    public final void loadPropertiesFromFile(String str) {
        String str2;
        Intrinsics.checkParameterIsNotNull(str, "fileName");
        if (this._koin.get_logger().isAt(Level.DEBUG)) {
            Logger logger = this._koin.get_logger();
            logger.debug("load properties from " + str);
        }
        URL resource = Koin.class.getResource(str);
        if (resource != null) {
            str2 = new String(TextStreamsKt.readBytes(resource), Charsets.UTF_8);
        } else {
            str2 = null;
        }
        if (str2 != null) {
            if (this._koin.get_logger().isAt(Level.INFO)) {
                Logger logger2 = this._koin.get_logger();
                logger2.info("loaded properties from file:'" + str + '\'');
            }
            saveProperties(readDataFromFile(str2));
            return;
        }
        throw new NoPropertyFileFoundException("No properties found for file '" + str + '\'');
    }

    private final Properties readDataFromFile(String str) {
        Properties properties = new Properties();
        Charset charset = Charsets.UTF_8;
        if (str != null) {
            byte[] bytes = str.getBytes(charset);
            Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
            properties.load(new ByteArrayInputStream(bytes));
            return properties;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    public final void loadEnvironmentProperties() {
        if (this._koin.get_logger().isAt(Level.DEBUG)) {
            this._koin.get_logger().debug("load properties from environment");
        }
        Properties properties = System.getProperties();
        Intrinsics.checkExpressionValueIsNotNull(properties, "sysProperties");
        saveProperties(properties);
        Map<String, String> map = System.getenv();
        Intrinsics.checkExpressionValueIsNotNull(map, "System.getenv()");
        Properties properties2 = new Properties();
        properties2.putAll(map);
        saveProperties(properties2);
    }

    public final void close() {
        this._values.clear();
    }
}
