package com.askgps.personaltrackercore;

import com.askgps.personaltrackercore.config.ConfigKt;
import com.askgps.personaltrackercore.database.model.EmptyResponse;
import java.security.Security;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.conscrypt.Conscrypt;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u0000 \r2\u00020\u0001:\u0001\rJ6\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\tH'J\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'¨\u0006\u000e"}, d2 = {"Lcom/askgps/personaltrackercore/GaskarApi;", "", "start", "Lretrofit2/Call;", "Lcom/askgps/personaltrackercore/database/model/EmptyResponse;", "imei", "", "idxid", "latitude", "", "longitude", "stop", "", "Factory", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: GaskarApi.kt */
public interface GaskarApi {
    public static final Factory Factory = Factory.$$INSTANCE;

    @GET("/card/rest/workshift/start")
    Call<EmptyResponse> start(@Query("deviceEUI") String str, @Query("idxid") String str2, @Query("latitude") double d, @Query("longitude") double d2);

    @GET("/card/rest/workshift/stop")
    Call<Unit> stop(@Query("deviceEUI") String str);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/askgps/personaltrackercore/GaskarApi$Factory;", "", "()V", "TIMEOUT", "", "httpClient", "Lokhttp3/OkHttpClient;", "logging", "Lokhttp3/logging/HttpLoggingInterceptor;", "getInstance", "Lcom/askgps/personaltrackercore/GaskarApi;", "url", "", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: GaskarApi.kt */
    public static final class Factory {
        static final /* synthetic */ Factory $$INSTANCE = new Factory();
        private static final long TIMEOUT = 10000;
        private static final OkHttpClient httpClient = new OkHttpClient.Builder().readTimeout(10000, TimeUnit.MILLISECONDS).writeTimeout(10000, TimeUnit.MILLISECONDS).addInterceptor(logging).build();
        private static final HttpLoggingInterceptor logging;

        static {
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new GaskarApi$Factory$logging$1());
            httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.BASIC);
            logging = httpLoggingInterceptor;
        }

        private Factory() {
        }

        public final GaskarApi getInstance(String str) {
            Intrinsics.checkParameterIsNotNull(str, "url");
            Security.insertProviderAt(Conscrypt.newProvider(), 1);
            Object create = new Retrofit.Builder().baseUrl(ConfigKt.BUILDER_GASKAR_HOST).addConverterFactory(GsonConverterFactory.create()).client(httpClient).build().create(GaskarApi.class);
            Intrinsics.checkExpressionValueIsNotNull(create, "Retrofit.Builder()\n//   …te(GaskarApi::class.java)");
            return (GaskarApi) create;
        }
    }
}
