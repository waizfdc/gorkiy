package com.askgps.personaltrackercore;

import androidx.work.WorkRequest;
import com.askgps.personaltrackercore.IdentixOneApi;
import java.security.Security;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.conscrypt.Conscrypt;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/askgps/personaltrackercore/IdentixOneApi;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: IdentixOneApi.kt */
final class IdentixOneApi$Factory$instance$2 extends Lambda implements Function0<IdentixOneApi> {
    final /* synthetic */ IdentixOneApi.Factory this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IdentixOneApi$Factory$instance$2(IdentixOneApi.Factory factory) {
        super(0);
        this.this$0 = factory;
    }

    public final IdentixOneApi invoke() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new IdentixOneApi$Factory$instance$2$logging$1());
        httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.HEADERS);
        Security.insertProviderAt(Conscrypt.newProvider(), 1);
        return (IdentixOneApi) new Retrofit.Builder().baseUrl("https://api.identix.one").addConverterFactory(GsonConverterFactory.create()).client(new OkHttpClient.Builder().readTimeout(WorkRequest.MIN_BACKOFF_MILLIS, TimeUnit.MILLISECONDS).writeTimeout(WorkRequest.MIN_BACKOFF_MILLIS, TimeUnit.MILLISECONDS).addInterceptor(httpLoggingInterceptor).build()).build().create(IdentixOneApi.class);
    }
}
