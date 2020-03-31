package com.askgps.personaltrackercore;

import com.askgps.personaltrackercore.database.model.IdentixOneResponse;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u0000 \n2\u00020\u0001:\u0001\nJ,\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\b2\b\b\u0003\u0010\t\u001a\u00020\bH'¨\u0006\u000b"}, d2 = {"Lcom/askgps/personaltrackercore/IdentixOneApi;", "", "searchUser", "Lretrofit2/Call;", "Lcom/askgps/personaltrackercore/database/model/IdentixOneResponse;", "photo", "Lokhttp3/MultipartBody$Part;", "asm", "", "liveness", "Factory", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: IdentixOneApi.kt */
public interface IdentixOneApi {
    public static final Factory Factory = Factory.$$INSTANCE;
    public static final String HOST = "api.identix.one";
    public static final String TOKEN = "a2879be8028a654f81c5a94b7a2472e943efb927a14ede776a5f5d039717bffdffad94e14c1e68e0248be4bda355d2b747e156e508ac5fc8dadec5b600ce7bdc";
    public static final String URL = "https://api.identix.one";

    @Multipart
    @POST("/v1/persons/search/")
    @Headers({"Authorization: Token a2879be8028a654f81c5a94b7a2472e943efb927a14ede776a5f5d039717bffdffad94e14c1e68e0248be4bda355d2b747e156e508ac5fc8dadec5b600ce7bdc"})
    Call<IdentixOneResponse> searchUser(@Part MultipartBody.Part part, @Part("asm") boolean z, @Part("liveness") boolean z2);

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* compiled from: IdentixOneApi.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ Call searchUser$default(IdentixOneApi identixOneApi, MultipartBody.Part part, boolean z, boolean z2, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = false;
                }
                if ((i & 4) != 0) {
                    z2 = false;
                }
                return identixOneApi.searchUser(part, z, z2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: searchUser");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8FX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/askgps/personaltrackercore/IdentixOneApi$Factory;", "", "()V", "HOST", "", "TIMEOUT", "", "TOKEN", "URL", "instance", "Lcom/askgps/personaltrackercore/IdentixOneApi;", "getInstance", "()Lcom/askgps/personaltrackercore/IdentixOneApi;", "instance$delegate", "Lkotlin/Lazy;", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: IdentixOneApi.kt */
    public static final class Factory {
        static final /* synthetic */ Factory $$INSTANCE;
        static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Factory.class), "instance", "getInstance()Lcom/askgps/personaltrackercore/IdentixOneApi;"))};
        public static final String HOST = "api.identix.one";
        private static final long TIMEOUT = 10000;
        public static final String TOKEN = "a2879be8028a654f81c5a94b7a2472e943efb927a14ede776a5f5d039717bffdffad94e14c1e68e0248be4bda355d2b747e156e508ac5fc8dadec5b600ce7bdc";
        public static final String URL = "https://api.identix.one";
        private static final Lazy instance$delegate;

        public final IdentixOneApi getInstance() {
            Lazy lazy = instance$delegate;
            KProperty kProperty = $$delegatedProperties[0];
            return (IdentixOneApi) lazy.getValue();
        }

        static {
            Factory factory = new Factory();
            $$INSTANCE = factory;
            instance$delegate = LazyKt.lazy(new IdentixOneApi$Factory$instance$2(factory));
        }

        private Factory() {
        }
    }
}
