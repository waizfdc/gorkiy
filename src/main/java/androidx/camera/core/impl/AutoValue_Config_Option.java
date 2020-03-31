package androidx.camera.core.impl;

import androidx.camera.core.impl.Config;

final class AutoValue_Config_Option<T> extends Config.Option<T> {
    private final String id;
    private final Object token;
    private final Class<T> valueClass;

    AutoValue_Config_Option(String str, Class<T> cls, Object obj) {
        if (str != null) {
            this.id = str;
            if (cls != null) {
                this.valueClass = cls;
                this.token = obj;
                return;
            }
            throw new NullPointerException("Null valueClass");
        }
        throw new NullPointerException("Null id");
    }

    public String getId() {
        return this.id;
    }

    public Class<T> getValueClass() {
        return this.valueClass;
    }

    public Object getToken() {
        return this.token;
    }

    public String toString() {
        return "Option{id=" + this.id + ", valueClass=" + this.valueClass + ", token=" + this.token + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Config.Option)) {
            return false;
        }
        Config.Option option = (Config.Option) obj;
        if (this.id.equals(super.getId()) && this.valueClass.equals(super.getValueClass())) {
            Object obj2 = this.token;
            if (obj2 == null) {
                if (super.getToken() == null) {
                    return true;
                }
            } else if (obj2.equals(super.getToken())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (((this.id.hashCode() ^ 1000003) * 1000003) ^ this.valueClass.hashCode()) * 1000003;
        Object obj = this.token;
        return hashCode ^ (obj == null ? 0 : obj.hashCode());
    }
}
