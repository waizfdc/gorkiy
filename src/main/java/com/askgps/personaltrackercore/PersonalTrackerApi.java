package com.askgps.personaltrackercore;

import com.askgps.personaltrackercore.database.model.AuthResponse;
import com.askgps.personaltrackercore.database.model.CheckDeviceResponse;
import com.askgps.personaltrackercore.database.model.Device;
import com.askgps.personaltrackercore.database.model.Location;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010$\n\u0002\b\u0002\bf\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'J\"\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\nH'J\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\b\b\u0001\u0010\r\u001a\u00020\u000eH'J\u0018\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\b\b\u0001\u0010\r\u001a\u00020\u000eH'J\u001e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\u000e\b\u0001\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H'J(\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u000e\b\u0001\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H'J:\u0010\u0015\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00170\u00160\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u000e\b\u0001\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H'¨\u0006\u0019"}, d2 = {"Lcom/askgps/personaltrackercore/PersonalTrackerApi;", "", "checkDevicestatus", "Lretrofit2/Call;", "Lcom/askgps/personaltrackercore/database/model/CheckDeviceResponse;", "imei", "", "patientIdentification", "", "photo", "Lokhttp3/MultipartBody$Part;", "registerDevice", "Lcom/askgps/personaltrackercore/database/model/AuthResponse;", "data", "Lcom/askgps/personaltrackercore/database/model/Device;", "requestPassword", "sendBuilderLocation", FirebaseAnalytics.Param.LOCATION, "", "Lcom/askgps/personaltrackercore/database/model/Location;", "sendPatientLocation", "sendPatientLocationWithCommand", "", "", "Factory", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: PersonalTrackerApi.kt */
public interface PersonalTrackerApi {
    public static final Factory Factory = Factory.$$INSTANCE;

    @GET("/api/covid/Device/{deviceId}/status")
    Call<CheckDeviceResponse> checkDevicestatus(@Path("deviceId") String str);

    @POST("/api/covid/Device/{deviceId}/photo")
    @Multipart
    Call<Unit> patientIdentification(@Path("deviceId") String str, @Part MultipartBody.Part part);

    @POST("/api/covid/Device/auth")
    Call<AuthResponse> registerDevice(@Body Device device);

    @POST("/api/covid/Device/password")
    Call<Unit> requestPassword(@Body Device device);

    @POST("/personaltracker")
    Call<Unit> sendBuilderLocation(@Body List<Location> list);

    @POST("/api/covid/Device/{deviceId}/message")
    Call<Unit> sendPatientLocation(@Path("deviceId") String str, @Body List<Location> list);

    @POST("/api/covid/Device/{deviceId}/message")
    Call<Map<String, String>[]> sendPatientLocationWithCommand(@Path("deviceId") String str, @Body List<Location> list);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/askgps/personaltrackercore/PersonalTrackerApi$Factory;", "", "()V", "TIMEOUT", "", "instance", "Lcom/askgps/personaltrackercore/PersonalTrackerApi;", "getInstance", "()Lcom/askgps/personaltrackercore/PersonalTrackerApi;", "instance$delegate", "Lkotlin/Lazy;", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: PersonalTrackerApi.kt */
    public static final class Factory {
        static final /* synthetic */ Factory $$INSTANCE;
        static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Factory.class), "instance", "getInstance()Lcom/askgps/personaltrackercore/PersonalTrackerApi;"))};
        private static final long TIMEOUT = 10000;
        private static final Lazy instance$delegate;

        public final PersonalTrackerApi getInstance() {
            Lazy lazy = instance$delegate;
            KProperty kProperty = $$delegatedProperties[0];
            return (PersonalTrackerApi) lazy.getValue();
        }

        static {
            Factory factory = new Factory();
            $$INSTANCE = factory;
            instance$delegate = LazyKt.lazy(new PersonalTrackerApi$Factory$instance$2(factory));
        }

        private Factory() {
        }
    }
}
