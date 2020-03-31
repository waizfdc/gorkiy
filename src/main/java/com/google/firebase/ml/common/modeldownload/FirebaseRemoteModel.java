package com.google.firebase.ml.common.modeldownload;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import java.util.EnumMap;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public class FirebaseRemoteModel {
    private static final Map<BaseModel, String> zzbgd = new EnumMap(BaseModel.class);
    private static final Map<BaseModel, String> zzbge;
    private final String zzbdo;
    private String zzbfn;
    private final BaseModel zzbgc;

    protected FirebaseRemoteModel(String str, BaseModel baseModel) {
        Preconditions.checkArgument(TextUtils.isEmpty(str) != (baseModel != null) ? false : true, "One of cloud model name and base model cannot be empty");
        this.zzbdo = str;
        this.zzbgc = baseModel;
    }

    public String getModelNameForBackend() {
        String str = this.zzbdo;
        if (str != null) {
            return str;
        }
        return zzbge.get(this.zzbgc);
    }

    public String getUniqueModelNameForPersist() {
        String str = this.zzbdo;
        if (str != null) {
            return str;
        }
        String valueOf = String.valueOf(zzbge.get(this.zzbgc));
        return valueOf.length() != 0 ? "COM.GOOGLE.BASE_".concat(valueOf) : new String("COM.GOOGLE.BASE_");
    }

    public boolean isBaseModel() {
        return this.zzbgc != null;
    }

    public String getModelName() {
        return this.zzbdo;
    }

    public boolean baseModelHashMatches(String str) {
        BaseModel baseModel = this.zzbgc;
        if (baseModel == null) {
            return false;
        }
        return str.equals(zzbgd.get(baseModel));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FirebaseRemoteModel)) {
            return false;
        }
        FirebaseRemoteModel firebaseRemoteModel = (FirebaseRemoteModel) obj;
        return Objects.equal(this.zzbdo, firebaseRemoteModel.zzbdo) && Objects.equal(this.zzbgc, firebaseRemoteModel.zzbgc);
    }

    public int hashCode() {
        return Objects.hashCode(this.zzbdo, this.zzbgc);
    }

    public void setModelHash(String str) {
        this.zzbfn = str;
    }

    public String getModelHash() {
        return this.zzbfn;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.Map.put(java.lang.Object, java.lang.Object):V}
     arg types: [com.google.firebase.ml.common.modeldownload.BaseModel, java.lang.String]
     candidates:
      ClspMth{java.util.EnumMap.put(java.lang.Enum, java.lang.Object):V}
      ClspMth{java.util.Map.put(java.lang.Object, java.lang.Object):V} */
    static {
        EnumMap enumMap = new EnumMap(BaseModel.class);
        zzbge = enumMap;
        enumMap.put((Object) BaseModel.FACE_DETECTION, (Object) "face_detector_model_m41");
        zzbge.put(BaseModel.SMART_REPLY, "smart_reply_model_m41");
        zzbge.put(BaseModel.TRANSLATE, "translate_model_m41");
        zzbgd.put(BaseModel.FACE_DETECTION, "modelHash");
        zzbgd.put(BaseModel.SMART_REPLY, "smart_reply_model_hash");
        zzbgd.put(BaseModel.TRANSLATE, "modelHash");
    }
}
