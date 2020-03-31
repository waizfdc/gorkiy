package com.askgps.personaltrackercore.repository;

import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.askgps.personaltrackercore.BaseMainActivity;
import com.askgps.personaltrackercore.GaskarApi;
import com.askgps.personaltrackercore.HelperKt;
import com.askgps.personaltrackercore.IdentixOneApi;
import com.askgps.personaltrackercore.LogKt;
import com.askgps.personaltrackercore.PersonalTrackerApi;
import com.askgps.personaltrackercore.database.DatabaseHelper;
import com.askgps.personaltrackercore.database.model.AuthResponse;
import com.askgps.personaltrackercore.database.model.CheckDeviceResponse;
import com.askgps.personaltrackercore.database.model.Device;
import com.askgps.personaltrackercore.database.model.EmptyResponse;
import com.askgps.personaltrackercore.database.model.IdentixOneResponse;
import com.askgps.personaltrackercore.database.model.IndoorNavigation;
import com.askgps.personaltrackercore.database.model.Location;
import com.askgps.personaltrackercore.database.model.PhoneNumber;
import com.askgps.personaltrackercore.database.model.Settings;
import com.askgps.personaltrackercore.database.model.StepSensor;
import com.askgps.personaltrackercore.location.GoogleApiHelper;
import com.askgps.personaltrackercore.utils.AvatarUtils;
import com.askgps.personaltrackercore.utils.NotificationHandler;
import com.askgps.personaltrackerround.MainActivity;
import com.hadilq.liveevent.LiveEvent;
import io.reactivex.subjects.PublishSubject;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import org.koin.core.Koin;
import org.koin.core.KoinComponent;
import org.koin.core.parameter.DefinitionParameters;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.qualifier.QualifierKt;
import org.koin.core.scope.Scope;
import retrofit2.Response;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0012\n\u0002\b\u0010\b\u0016\u0018\u0000 \u00012\u00020\u0001:\u0002\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020KH\u0007J\u0006\u0010]\u001a\u00020[J\u0010\u0010^\u001a\u00020[2\u0006\u0010\\\u001a\u00020KH\u0007J\u0010\u0010_\u001a\u00020[2\u0006\u0010<\u001a\u00020:H\u0007J\u000e\u0010`\u001a\u00020[2\u0006\u0010a\u001a\u00020\tJ0\u0010b\u001a\b\u0012\u0004\u0012\u00020c0J2\f\u0010d\u001a\b\u0012\u0004\u0012\u00020e0J2\b\b\u0002\u0010f\u001a\u00020g2\b\u0010h\u001a\u0004\u0018\u00010iH\u0002J\b\u0010j\u001a\u00020\tH\u0007J\u0010\u0010k\u001a\u00020[2\u0006\u0010l\u001a\u00020\tH\u0003J\u0006\u0010m\u001a\u00020[J\u0006\u0010n\u001a\u00020[J\u001a\u0010o\u001a\u00020[2\u0006\u0010p\u001a\u00020\t2\b\u0010h\u001a\u0004\u0018\u00010iH\u0016J\u000e\u0010q\u001a\u00020[2\u0006\u0010a\u001a\u00020\tJ\u0006\u0010r\u001a\u00020[J\u0010\u0010s\u001a\u00020\t2\u0006\u0010t\u001a\u00020:H\u0007J&\u0010u\u001a\u00020[2\u0006\u0010f\u001a\u00020g2\b\u0010h\u001a\u0004\u0018\u00010i2\f\u0010v\u001a\b\u0012\u0004\u0012\u00020[0wJ\b\u0010x\u001a\u00020\tH\u0007J\u0006\u0010y\u001a\u00020[J6\u0010z\u001a\u00020[2\f\u0010d\u001a\b\u0012\u0004\u0012\u00020e0J2\b\b\u0002\u0010f\u001a\u00020g2\b\u0010h\u001a\u0004\u0018\u00010i2\f\u0010v\u001a\b\u0012\u0004\u0012\u00020[0wJ\u0012\u0010{\u001a\u0004\u0018\u00010:2\u0006\u0010|\u001a\u00020:H\u0007J\u0016\u0010}\u001a\u00020\t2\f\u0010~\u001a\b\u0012\u0004\u0012\u00020c0JH\u0003J6\u0010\u001a\u00020[2\f\u0010d\u001a\b\u0012\u0004\u0012\u00020e0J2\b\b\u0002\u0010f\u001a\u00020g2\b\u0010h\u001a\u0004\u0018\u00010i2\f\u0010v\u001a\b\u0012\u0004\u0012\u00020[0wJ\"\u0010\u0001\u001a\u00020[2\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020c0JH@ø\u0001\u0000¢\u0006\u0003\u0010\u0001J\u001c\u0010\u0001\u001a\u00020\t2\u0007\u0010\u0001\u001a\u00020:2\b\u0010\u0001\u001a\u00030\u0001H\u0002J'\u0010\u0001\u001a\u00020[2\u0006\u0010<\u001a\u00020:2\u0007\u0010\u0001\u001a\u00020\t2\u000b\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010eH\u0002J\u0012\u0010\u0001\u001a\u00020[2\u0007\u0010\u0001\u001a\u00020:H\u0007J\u0011\u0010\u0001\u001a\u00020\t2\u0006\u0010|\u001a\u00020:H\u0007J\t\u0010\u0001\u001a\u00020[H\u0003J%\u0010\u0001\u001a\u00020\t2\u0006\u0010<\u001a\u00020:2\u0007\u0010\u0001\u001a\u00020:2\t\u0010\u0001\u001a\u0004\u0018\u00010eH\u0007J9\u0010\u0001\u001a\u00020[2\t\u0010\u0001\u001a\u0004\u0018\u00010:2\t\u0010\u0001\u001a\u0004\u0018\u0001012\t\u0010\u0001\u001a\u0004\u0018\u0001012\t\u0010\u0001\u001a\u0004\u0018\u000101¢\u0006\u0003\u0010\u0001R\u001f\u0010\u0007\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001d\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001f\"\u0004\b.\u0010!R\u0017\u0010/\u001a\b\u0012\u0004\u0012\u00020100¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u001b\u00104\u001a\u0002058BX\u0002¢\u0006\f\n\u0004\b8\u0010\u001c\u001a\u0004\b6\u00107R\u0017\u00109\u001a\b\u0012\u0004\u0012\u00020:0\u0014¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\u0016R\u0017\u0010<\u001a\b\u0012\u0004\u0012\u00020:00¢\u0006\b\n\u0000\u001a\u0004\b=\u00103R$\u0010?\u001a\u00020\t2\u0006\u0010>\u001a\u00020\t@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u001f\"\u0004\b@\u0010!R\u000e\u0010A\u001a\u00020BX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010C\u001a\u00020D8BX\u0002¢\u0006\f\n\u0004\bG\u0010\u001c\u001a\u0004\bE\u0010FR\u001d\u0010H\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020K0J0I¢\u0006\b\n\u0000\u001a\u0004\bL\u0010MR\u0017\u0010N\u001a\b\u0012\u0004\u0012\u00020O0I¢\u0006\b\n\u0000\u001a\u0004\bP\u0010MR\u0017\u0010Q\u001a\b\u0012\u0004\u0012\u00020\t00¢\u0006\b\n\u0000\u001a\u0004\bR\u00103R\u0017\u0010S\u001a\b\u0012\u0004\u0012\u00020\t00¢\u0006\b\n\u0000\u001a\u0004\bT\u00103R\u0017\u0010U\u001a\b\u0012\u0004\u0012\u00020\t0\u0014¢\u0006\b\n\u0000\u001a\u0004\bV\u0010\u0016R\u001a\u0010W\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010\u001f\"\u0004\bY\u0010!\u0002\u0004\n\u0002\b\u0019¨\u0006\u0001"}, d2 = {"Lcom/askgps/personaltrackercore/repository/Repository;", "Lorg/koin/core/KoinComponent;", "context", "Landroid/content/Context;", "databaseHelper", "Lcom/askgps/personaltrackercore/database/DatabaseHelper;", "(Landroid/content/Context;Lcom/askgps/personaltrackercore/database/DatabaseHelper;)V", NotificationCompat.CATEGORY_ALARM, "Lio/reactivex/subjects/PublishSubject;", "", "kotlin.jvm.PlatformType", "getAlarm", "()Lio/reactivex/subjects/PublishSubject;", "attemptCountLeft", "", "getAttemptCountLeft", "()I", "setAttemptCountLeft", "(I)V", "authCode", "Lcom/hadilq/liveevent/LiveEvent;", "getAuthCode", "()Lcom/hadilq/liveevent/LiveEvent;", "avatarUtils", "Lcom/askgps/personaltrackercore/utils/AvatarUtils;", "getAvatarUtils", "()Lcom/askgps/personaltrackercore/utils/AvatarUtils;", "avatarUtils$delegate", "Lkotlin/Lazy;", "checkEnabled", "getCheckEnabled", "()Z", "setCheckEnabled", "(Z)V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getDatabaseHelper", "()Lcom/askgps/personaltrackercore/database/DatabaseHelper;", "deviceData", "Lcom/askgps/personaltrackercore/database/model/Device;", "getDeviceData", "()Lcom/askgps/personaltrackercore/database/model/Device;", "setDeviceData", "(Lcom/askgps/personaltrackercore/database/model/Device;)V", "disableCmd", "getDisableCmd", "setDisableCmd", "fallTime", "Landroidx/lifecycle/MutableLiveData;", "", "getFallTime", "()Landroidx/lifecycle/MutableLiveData;", "googleApiHelper", "Lcom/askgps/personaltrackercore/location/GoogleApiHelper;", "getGoogleApiHelper", "()Lcom/askgps/personaltrackercore/location/GoogleApiHelper;", "googleApiHelper$delegate", "idxId", "", "getIdxId", "imei", "getImei", "value", "isMove", "setMove", "job", "Lkotlinx/coroutines/CompletableJob;", "notif", "Lcom/askgps/personaltrackercore/utils/NotificationHandler;", "getNotif", "()Lcom/askgps/personaltrackercore/utils/NotificationHandler;", "notif$delegate", "phoneNumbers", "Landroidx/lifecycle/LiveData;", "", "Lcom/askgps/personaltrackercore/database/model/PhoneNumber;", "getPhoneNumbers", "()Landroidx/lifecycle/LiveData;", "settings", "Lcom/askgps/personaltrackercore/database/model/Settings;", "getSettings", "showLoader", "getShowLoader", "showNetworkError", "getShowNetworkError", "successfulIdentification", "getSuccessfulIdentification", "wifiEnabled", "getWifiEnabled", "setWifiEnabled", "addPhoneNumber", "", "phoneNumber", "checkPatient", "deletePhoneNumber", "endWork", "endWorkByPower", "power", "getItems", "Lcom/askgps/personaltrackercore/database/model/Location;", "locations", "Landroid/location/Location;", "battery", "", "indoorNavigation", "Lcom/askgps/personaltrackercore/database/model/IndoorNavigation;", "getUserStatus", "identificationSuccess", "state", "onDisableCmd", "processingFallMessage", "processingLeaveHandMessage", "isLeaveHand", "processingPowerManagerMessage", "processingSosMessage", "registerUser", "photoPath", "requestLocation", "callback", "Lkotlin/Function0;", "requestPassword", "resetAttemptLeft", "saveLocationAsync", "searchUserInIdentix", "path", "sendLocation", "items", "sendLocationAsync", "sendLocationWithDb", "newItems", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendPhoto", "fileName", "bitmapData", "", "sendWorkIsStart", "isStart", "lastLocation", "startIdentificationAsync", "id", "startIdentificationOnNavigationAsync", "startWork", "idxid", "updateSettings", "address", "locationInterval", "sendTelemetryInterval", "removalFromHandInterval", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", "Companion", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: Repository.kt */
public class Repository implements KoinComponent {
    static final /* synthetic */ KProperty[] $$delegatedProperties;
    public static final Companion Companion = new Companion(null);
    public static final int MAX_ATTEMPT_COUNT = 3;
    private final PublishSubject<Boolean> alarm;
    private volatile int attemptCountLeft;
    private final LiveEvent<Integer> authCode;
    private final Lazy avatarUtils$delegate;
    private volatile boolean checkEnabled;
    private final Context context;
    /* access modifiers changed from: private */
    public final CoroutineScope coroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(this.job));
    private final DatabaseHelper databaseHelper;
    private Device deviceData;
    private volatile boolean disableCmd;
    private final MutableLiveData<Long> fallTime = new MutableLiveData<>();
    private final Lazy googleApiHelper$delegate;
    private final LiveEvent<String> idxId = new LiveEvent<>();
    private final MutableLiveData<String> imei;
    private boolean isMove = true;
    private final CompletableJob job = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null);
    private final Lazy notif$delegate;
    private final LiveData<List<PhoneNumber>> phoneNumbers;
    private final LiveData<Settings> settings;
    private final MutableLiveData<Boolean> showLoader;
    private final MutableLiveData<Boolean> showNetworkError;
    private final LiveEvent<Boolean> successfulIdentification;
    private volatile boolean wifiEnabled;

    static {
        Class<Repository> cls = Repository.class;
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "notif", "getNotif()Lcom/askgps/personaltrackercore/utils/NotificationHandler;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "avatarUtils", "getAvatarUtils()Lcom/askgps/personaltrackercore/utils/AvatarUtils;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "googleApiHelper", "getGoogleApiHelper()Lcom/askgps/personaltrackercore/location/GoogleApiHelper;"))};
    }

    private final AvatarUtils getAvatarUtils() {
        Lazy lazy = this.avatarUtils$delegate;
        KProperty kProperty = $$delegatedProperties[1];
        return (AvatarUtils) lazy.getValue();
    }

    private final GoogleApiHelper getGoogleApiHelper() {
        Lazy lazy = this.googleApiHelper$delegate;
        KProperty kProperty = $$delegatedProperties[2];
        return (GoogleApiHelper) lazy.getValue();
    }

    private final NotificationHandler getNotif() {
        Lazy lazy = this.notif$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (NotificationHandler) lazy.getValue();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: kotlinx.coroutines.SupervisorKt.SupervisorJob$default(kotlinx.coroutines.Job, int, java.lang.Object):kotlinx.coroutines.CompletableJob
     arg types: [?[OBJECT, ARRAY], int, ?[OBJECT, ARRAY]]
     candidates:
      kotlinx.coroutines.SupervisorKt.SupervisorJob$default(kotlinx.coroutines.Job, int, java.lang.Object):kotlinx.coroutines.Job
      kotlinx.coroutines.SupervisorKt.SupervisorJob$default(kotlinx.coroutines.Job, int, java.lang.Object):kotlinx.coroutines.CompletableJob */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: kotlin.LazyKt__LazyJVMKt.lazy(kotlin.LazyThreadSafetyMode, kotlin.jvm.functions.Function0):kotlin.Lazy<T>
     arg types: [kotlin.LazyThreadSafetyMode, com.askgps.personaltrackercore.repository.Repository$$special$$inlined$inject$1]
     candidates:
      kotlin.LazyKt__LazyJVMKt.lazy(java.lang.Object, kotlin.jvm.functions.Function0):kotlin.Lazy<T>
      kotlin.LazyKt__LazyJVMKt.lazy(kotlin.LazyThreadSafetyMode, kotlin.jvm.functions.Function0):kotlin.Lazy<T> */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: kotlin.LazyKt__LazyJVMKt.lazy(kotlin.LazyThreadSafetyMode, kotlin.jvm.functions.Function0):kotlin.Lazy<T>
     arg types: [kotlin.LazyThreadSafetyMode, com.askgps.personaltrackercore.repository.Repository$$special$$inlined$inject$2]
     candidates:
      kotlin.LazyKt__LazyJVMKt.lazy(java.lang.Object, kotlin.jvm.functions.Function0):kotlin.Lazy<T>
      kotlin.LazyKt__LazyJVMKt.lazy(kotlin.LazyThreadSafetyMode, kotlin.jvm.functions.Function0):kotlin.Lazy<T> */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: kotlin.LazyKt__LazyJVMKt.lazy(kotlin.LazyThreadSafetyMode, kotlin.jvm.functions.Function0):kotlin.Lazy<T>
     arg types: [kotlin.LazyThreadSafetyMode, com.askgps.personaltrackercore.repository.Repository$$special$$inlined$inject$3]
     candidates:
      kotlin.LazyKt__LazyJVMKt.lazy(java.lang.Object, kotlin.jvm.functions.Function0):kotlin.Lazy<T>
      kotlin.LazyKt__LazyJVMKt.lazy(kotlin.LazyThreadSafetyMode, kotlin.jvm.functions.Function0):kotlin.Lazy<T> */
    public Repository(Context context2, DatabaseHelper databaseHelper2) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        Intrinsics.checkParameterIsNotNull(databaseHelper2, "databaseHelper");
        this.context = context2;
        this.databaseHelper = databaseHelper2;
        Qualifier qualifier = null;
        Function0 function0 = null;
        this.notif$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Repository$$special$$inlined$inject$1(this, qualifier, function0));
        this.avatarUtils$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Repository$$special$$inlined$inject$2(this, qualifier, function0));
        this.imei = new MutableLiveData<>(getKoin().get_scopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(String.class), QualifierKt.named("imei"), function0));
        this.successfulIdentification = new LiveEvent<>();
        this.authCode = new LiveEvent<>();
        this.settings = this.databaseHelper.settingsDao().getSettings();
        PublishSubject<Boolean> create = PublishSubject.create();
        Intrinsics.checkExpressionValueIsNotNull(create, "PublishSubject.create<Boolean>()");
        this.alarm = create;
        this.attemptCountLeft = 3;
        this.showLoader = new MutableLiveData<>(false);
        this.showNetworkError = new MutableLiveData<>(false);
        this.googleApiHelper$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Repository$$special$$inlined$inject$3(this, qualifier, function0));
        this.phoneNumbers = this.databaseHelper.phoneBookDao().getNumbers();
        this.deviceData = new Device("", "", "", "", "", "", "", "");
        BuildersKt.runBlocking(Dispatchers.getIO(), new AnonymousClass1(this, null));
    }

    /* access modifiers changed from: protected */
    public final DatabaseHelper getDatabaseHelper() {
        return this.databaseHelper;
    }

    public Koin getKoin() {
        return KoinComponent.DefaultImpls.getKoin(this);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/askgps/personaltrackercore/repository/Repository$Companion;", "", "()V", "MAX_ATTEMPT_COUNT", "", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: Repository.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final boolean getWifiEnabled() {
        return this.wifiEnabled;
    }

    public final void setWifiEnabled(boolean z) {
        this.wifiEnabled = z;
    }

    public final boolean getCheckEnabled() {
        return this.checkEnabled;
    }

    public final void setCheckEnabled(boolean z) {
        this.checkEnabled = z;
    }

    public final boolean getDisableCmd() {
        return this.disableCmd;
    }

    public final void setDisableCmd(boolean z) {
        this.disableCmd = z;
    }

    public final boolean isMove() {
        return this.isMove;
    }

    public final void setMove(boolean z) {
        this.isMove = z;
    }

    public final LiveEvent<String> getIdxId() {
        return this.idxId;
    }

    public final MutableLiveData<Long> getFallTime() {
        return this.fallTime;
    }

    public final MutableLiveData<String> getImei() {
        return this.imei;
    }

    public final LiveEvent<Boolean> getSuccessfulIdentification() {
        return this.successfulIdentification;
    }

    public final LiveEvent<Integer> getAuthCode() {
        return this.authCode;
    }

    public final LiveData<Settings> getSettings() {
        return this.settings;
    }

    public final PublishSubject<Boolean> getAlarm() {
        return this.alarm;
    }

    public final int getAttemptCountLeft() {
        return this.attemptCountLeft;
    }

    public final void setAttemptCountLeft(int i) {
        this.attemptCountLeft = i;
    }

    public final MutableLiveData<Boolean> getShowLoader() {
        return this.showLoader;
    }

    public final MutableLiveData<Boolean> getShowNetworkError() {
        return this.showNetworkError;
    }

    public final LiveData<List<PhoneNumber>> getPhoneNumbers() {
        return this.phoneNumbers;
    }

    public final Device getDeviceData() {
        return this.deviceData;
    }

    public final void setDeviceData(Device device) {
        Intrinsics.checkParameterIsNotNull(device, "<set-?>");
        this.deviceData = device;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 16})
    @DebugMetadata(c = "com.askgps.personaltrackercore.repository.Repository$1", f = "Repository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.askgps.personaltrackercore.repository.Repository$1  reason: invalid class name */
    /* compiled from: Repository.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        private CoroutineScope p$;
        final /* synthetic */ Repository this$0;

        {
            this.this$0 = r1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics.checkParameterIsNotNull(continuation, "completion");
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, continuation);
            r0.p$ = (CoroutineScope) obj;
            return r0;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.this$0.getDatabaseHelper().settingsDao().createSettings(new Settings(false, null, 0, 0, 0, 0, 63, null));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* access modifiers changed from: private */
    public final void identificationSuccess(boolean z) {
        this.successfulIdentification.postValue(Boolean.valueOf(z));
        this.showLoader.postValue(false);
    }

    private final void startWork() {
        Settings value = this.settings.getValue();
        if (value == null || !value.getWorkIsStart()) {
            this.databaseHelper.settingsDao().setWorkIsStart(true);
        }
    }

    public final boolean startIdentificationOnNavigationAsync(String str) {
        Intrinsics.checkParameterIsNotNull(str, "path");
        try {
            boolean sendPhoto = sendPhoto(str, getAvatarUtils().uploadBitmap(str));
            if (sendPhoto) {
                startWork();
                resetAttemptLeft();
            } else {
                this.attemptCountLeft--;
            }
            identificationSuccess(sendPhoto);
            return sendPhoto;
        } catch (Exception e) {
            LogKt.toFile$default(e, "error identification", null, null, 6, null);
            this.showNetworkError.postValue(true);
            this.attemptCountLeft--;
            return false;
        }
    }

    public final void resetAttemptLeft() {
        this.attemptCountLeft = 3;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00b7 A[Catch:{ Exception -> 0x010f }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00d3 A[Catch:{ Exception -> 0x010f }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x01a5  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x01c2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean sendLocation(java.util.List<com.askgps.personaltrackercore.database.model.Location> r18) {
        /*
            r17 = this;
            r1 = r17
            r2 = r18
            java.lang.Class<com.askgps.personaltrackercore.repository.Repository> r8 = com.askgps.personaltrackercore.repository.Repository.class
            java.lang.String r3 = "imei.value!!"
            java.lang.String r4 = "Ошибка отправки координат: "
            r9 = 0
            r5 = r9
            retrofit2.Response r5 = (retrofit2.Response) r5
            com.askgps.personaltrackercore.BaseMainActivity$Companion r0 = com.askgps.personaltrackercore.BaseMainActivity.Companion     // Catch:{ Exception -> 0x00ab }
            com.askgps.personaltrackercore.config.CustomerCategory r0 = r0.getCustomer()     // Catch:{ Exception -> 0x00ab }
            com.askgps.personaltrackercore.config.CustomerCategory r6 = com.askgps.personaltrackercore.config.CustomerCategory.BUILDER_WATCH     // Catch:{ Exception -> 0x00ab }
            if (r0 != r6) goto L_0x002a
            com.askgps.personaltrackercore.PersonalTrackerApi$Factory r0 = com.askgps.personaltrackercore.PersonalTrackerApi.Factory     // Catch:{ Exception -> 0x00ab }
            com.askgps.personaltrackercore.PersonalTrackerApi r0 = r0.getInstance()     // Catch:{ Exception -> 0x00ab }
            retrofit2.Call r0 = r0.sendBuilderLocation(r2)     // Catch:{ Exception -> 0x00ab }
            retrofit2.Response r0 = r0.execute()     // Catch:{ Exception -> 0x00ab }
            r6 = r5
            r5 = r0
            goto L_0x012b
        L_0x002a:
            com.askgps.personaltrackercore.PersonalTrackerApi$Factory r0 = com.askgps.personaltrackercore.PersonalTrackerApi.Factory     // Catch:{ Exception -> 0x00ab }
            com.askgps.personaltrackercore.PersonalTrackerApi r0 = r0.getInstance()     // Catch:{ Exception -> 0x00ab }
            androidx.lifecycle.MutableLiveData<java.lang.String> r6 = r1.imei     // Catch:{ Exception -> 0x00ab }
            java.lang.Object r6 = r6.getValue()     // Catch:{ Exception -> 0x00ab }
            if (r6 != 0) goto L_0x003b
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ Exception -> 0x00ab }
        L_0x003b:
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r3)     // Catch:{ Exception -> 0x00ab }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x00ab }
            retrofit2.Call r0 = r0.sendPatientLocationWithCommand(r6, r2)     // Catch:{ Exception -> 0x00ab }
            retrofit2.Response r6 = r0.execute()     // Catch:{ Exception -> 0x00ab }
            java.lang.String r0 = "resultWithCommand"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r0)     // Catch:{ Exception -> 0x00a9 }
            boolean r0 = r6.isSuccessful()     // Catch:{ Exception -> 0x00a9 }
            if (r0 == 0) goto L_0x0055
            r0 = r6
            goto L_0x0056
        L_0x0055:
            r0 = r9
        L_0x0056:
            if (r0 == 0) goto L_0x012b
            java.lang.Object r0 = r0.body()     // Catch:{ Exception -> 0x00a9 }
            java.util.Map[] r0 = (java.util.Map[]) r0     // Catch:{ Exception -> 0x00a9 }
            if (r0 == 0) goto L_0x012b
            java.util.Iterator r0 = kotlin.jvm.internal.ArrayIteratorKt.iterator(r0)     // Catch:{ Exception -> 0x00a9 }
            if (r0 == 0) goto L_0x012b
        L_0x0066:
            boolean r7 = r0.hasNext()     // Catch:{ Exception -> 0x00a9 }
            if (r7 == 0) goto L_0x012b
            java.lang.Object r7 = r0.next()     // Catch:{ Exception -> 0x00a9 }
            java.util.Map r7 = (java.util.Map) r7     // Catch:{ Exception -> 0x00a9 }
            java.lang.String r10 = "wifi"
            boolean r10 = r7.containsValue(r10)     // Catch:{ Exception -> 0x00a9 }
            r1.wifiEnabled = r10     // Catch:{ Exception -> 0x00a9 }
            java.lang.String r10 = "check"
            boolean r10 = r7.containsValue(r10)     // Catch:{ Exception -> 0x00a9 }
            r1.checkEnabled = r10     // Catch:{ Exception -> 0x00a9 }
            java.lang.String r10 = "disable"
            boolean r10 = r7.containsValue(r10)     // Catch:{ Exception -> 0x00a9 }
            r1.disableCmd = r10     // Catch:{ Exception -> 0x00a9 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a9 }
            r10.<init>()     // Catch:{ Exception -> 0x00a9 }
            java.lang.String r11 = "Ответ содержит команду: "
            r10.append(r11)     // Catch:{ Exception -> 0x00a9 }
            java.util.Collection r7 = r7.values()     // Catch:{ Exception -> 0x00a9 }
            r10.append(r7)     // Catch:{ Exception -> 0x00a9 }
            java.lang.String r11 = r10.toString()     // Catch:{ Exception -> 0x00a9 }
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 7
            r16 = 0
            com.askgps.personaltrackercore.LogKt.toFile$default(r11, r12, r13, r14, r15, r16)     // Catch:{ Exception -> 0x00a9 }
            goto L_0x0066
        L_0x00a9:
            r0 = move-exception
            goto L_0x00ad
        L_0x00ab:
            r0 = move-exception
            r6 = r5
        L_0x00ad:
            com.askgps.personaltrackercore.BaseMainActivity$Companion r7 = com.askgps.personaltrackercore.BaseMainActivity.Companion     // Catch:{ Exception -> 0x010f }
            com.askgps.personaltrackercore.config.CustomerCategory r7 = r7.getCustomer()     // Catch:{ Exception -> 0x010f }
            com.askgps.personaltrackercore.config.CustomerCategory r10 = com.askgps.personaltrackercore.config.CustomerCategory.BUILDER_WATCH     // Catch:{ Exception -> 0x010f }
            if (r7 != r10) goto L_0x00d3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x010f }
            r3.<init>()     // Catch:{ Exception -> 0x010f }
            r3.append(r4)     // Catch:{ Exception -> 0x010f }
            java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x010f }
            r3.append(r0)     // Catch:{ Exception -> 0x010f }
            java.lang.String r10 = r3.toString()     // Catch:{ Exception -> 0x010f }
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 7
            r15 = 0
            com.askgps.personaltrackercore.LogKt.toFile$default(r10, r11, r12, r13, r14, r15)     // Catch:{ Exception -> 0x010f }
            goto L_0x012b
        L_0x00d3:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x010f }
            r7.<init>()     // Catch:{ Exception -> 0x010f }
            java.lang.String r10 = "Ответ не содержит команд, повторная отправка: "
            r7.append(r10)     // Catch:{ Exception -> 0x010f }
            java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x010f }
            r7.append(r0)     // Catch:{ Exception -> 0x010f }
            java.lang.String r10 = r7.toString()     // Catch:{ Exception -> 0x010f }
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 7
            r15 = 0
            com.askgps.personaltrackercore.LogKt.toFile$default(r10, r11, r12, r13, r14, r15)     // Catch:{ Exception -> 0x010f }
            com.askgps.personaltrackercore.PersonalTrackerApi$Factory r0 = com.askgps.personaltrackercore.PersonalTrackerApi.Factory     // Catch:{ Exception -> 0x010f }
            com.askgps.personaltrackercore.PersonalTrackerApi r0 = r0.getInstance()     // Catch:{ Exception -> 0x010f }
            androidx.lifecycle.MutableLiveData<java.lang.String> r7 = r1.imei     // Catch:{ Exception -> 0x010f }
            java.lang.Object r7 = r7.getValue()     // Catch:{ Exception -> 0x010f }
            if (r7 != 0) goto L_0x0101
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ Exception -> 0x010f }
        L_0x0101:
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r7, r3)     // Catch:{ Exception -> 0x010f }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ Exception -> 0x010f }
            retrofit2.Call r0 = r0.sendPatientLocation(r7, r2)     // Catch:{ Exception -> 0x010f }
            retrofit2.Response r5 = r0.execute()     // Catch:{ Exception -> 0x010f }
            goto L_0x012b
        L_0x010f:
            r0 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r4)
            java.lang.String r0 = r0.getMessage()
            r3.append(r0)
            java.lang.String r10 = r3.toString()
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 7
            r15 = 0
            com.askgps.personaltrackercore.LogKt.toFile$default(r10, r11, r12, r13, r14, r15)
        L_0x012b:
            r0 = 1
            if (r5 == 0) goto L_0x0134
            boolean r3 = r5.isSuccessful()
            if (r3 == r0) goto L_0x013c
        L_0x0134:
            if (r6 == 0) goto L_0x013e
            boolean r3 = r6.isSuccessful()
            if (r3 != r0) goto L_0x013e
        L_0x013c:
            r10 = r0
            goto L_0x0140
        L_0x013e:
            r3 = 0
            r10 = r3
        L_0x0140:
            if (r5 == 0) goto L_0x0148
            boolean r3 = r5.isSuccessful()
            if (r3 == r0) goto L_0x0150
        L_0x0148:
            if (r6 == 0) goto L_0x017d
            boolean r3 = r6.isSuccessful()
            if (r3 != r0) goto L_0x017d
        L_0x0150:
            com.askgps.personaltrackercore.database.DatabaseHelper r3 = r1.databaseHelper
            com.askgps.personaltrackercore.database.LocationDao r3 = r3.locationDao()
            r3.removeLocation(r2)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Sent "
            r3.append(r4)
            int r4 = r18.size()
            r3.append(r4)
            java.lang.String r4 = " items"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r4 = 0
            r5 = 0
            r6 = 6
            r7 = 0
            r2 = r18
            com.askgps.personaltrackercore.LogKt.toFile$default(r2, r3, r4, r5, r6, r7)
            goto L_0x0186
        L_0x017d:
            com.askgps.personaltrackercore.database.DatabaseHelper r3 = r1.databaseHelper
            com.askgps.personaltrackercore.database.LocationDao r3 = r3.locationDao()
            r3.insertLocations(r2)
        L_0x0186:
            r2 = r9
            org.koin.core.qualifier.Qualifier r2 = (org.koin.core.qualifier.Qualifier) r2
            kotlin.jvm.functions.Function0 r9 = (kotlin.jvm.functions.Function0) r9
            org.koin.core.Koin r3 = r17.getKoin()
            org.koin.core.registry.ScopeRegistry r3 = r3.get_scopeRegistry()
            org.koin.core.scope.Scope r3 = r3.getRootScope()
            kotlin.reflect.KClass r4 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r8)
            java.lang.Object r3 = r3.get(r4, r2, r9)
            com.askgps.personaltrackercore.repository.Repository r3 = (com.askgps.personaltrackercore.repository.Repository) r3
            boolean r3 = r3.checkEnabled
            if (r3 != r0) goto L_0x01a8
            r17.checkPatient()
        L_0x01a8:
            org.koin.core.Koin r3 = r17.getKoin()
            org.koin.core.registry.ScopeRegistry r3 = r3.get_scopeRegistry()
            org.koin.core.scope.Scope r3 = r3.getRootScope()
            kotlin.reflect.KClass r4 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r8)
            java.lang.Object r2 = r3.get(r4, r2, r9)
            com.askgps.personaltrackercore.repository.Repository r2 = (com.askgps.personaltrackercore.repository.Repository) r2
            boolean r2 = r2.disableCmd
            if (r2 != r0) goto L_0x01c5
            r17.onDisableCmd()
        L_0x01c5:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.askgps.personaltrackercore.repository.Repository.sendLocation(java.util.List):boolean");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
    public final void checkPatient() {
        Scope rootScope = getKoin().get_scopeRegistry().getRootScope();
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Class.class);
        Intent intent = new Intent(this.context, (Class) rootScope.get(orCreateKotlinClass, QualifierKt.named("MainActivityClass"), (Function0<DefinitionParameters>) null));
        intent.putExtra(MainActivity.INTENT_KEY_START_IDENTIFICATION, true);
        intent.putExtra(MainActivity.INTENT_KEY_INFO_DIALOG, true);
        intent.putExtra("INTENT_KEY_INFO_DIALOG", true);
        intent.setFlags(872415232);
        this.context.startActivity(intent);
        this.checkEnabled = false;
    }

    public final void onDisableCmd() {
        Settings value = this.settings.getValue();
        if (value == null || value.getWorkIsStart()) {
            this.databaseHelper.settingsDao().setWorkIsStart(false);
            String value2 = this.imei.getValue();
            if (value2 == null) {
                Intrinsics.throwNpe();
            }
            Intrinsics.checkExpressionValueIsNotNull(value2, "imei.value!!");
            sendWorkIsStart$default(this, value2, false, null, 4, null);
            ((Repository) getKoin().get_scopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(Repository.class), (Qualifier) null, (Function0<DefinitionParameters>) null)).disableCmd = false;
        }
    }

    public final void processingPowerManagerMessage(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("Send location: power ");
        sb.append(z ? DebugKt.DEBUG_PROPERTY_VALUE_ON : DebugKt.DEBUG_PROPERTY_VALUE_OFF);
        LogKt.toFile$default(sb.toString(), null, null, null, 7, null);
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, Dispatchers.getIO(), null, new Repository$processingPowerManagerMessage$1(this, z, null), 2, null);
        endWorkByPower(z);
    }

    public final void endWorkByPower(boolean z) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, Dispatchers.getIO(), null, new Repository$endWorkByPower$1(this, z, null), 2, null);
    }

    public void processingLeaveHandMessage(boolean z, IndoorNavigation indoorNavigation) {
        boolean z2 = z;
        StringBuilder sb = new StringBuilder();
        sb.append("Send location: isLeaveHand ");
        sb.append(z2 ? DebugKt.DEBUG_PROPERTY_VALUE_ON : DebugKt.DEBUG_PROPERTY_VALUE_OFF);
        LogKt.toFile$default(sb.toString(), null, null, null, 7, null);
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, Dispatchers.getIO(), null, new Repository$processingLeaveHandMessage$1(this, z2, indoorNavigation, null), 2, null);
        this.alarm.onNext(Boolean.valueOf(z));
    }

    public final void processingSosMessage() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, Dispatchers.getIO(), null, new Repository$processingSosMessage$1(this, null), 2, null);
    }

    public final void processingFallMessage() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, Dispatchers.getIO(), null, new Repository$processingFallMessage$1(this, null), 2, null);
    }

    public final void updateSettings(String str, Long l, Long l2, Long l3) {
        this.databaseHelper.settingsDao().updateSettings(str, l, l2, l3);
    }

    public final void addPhoneNumber(PhoneNumber phoneNumber) {
        Intrinsics.checkParameterIsNotNull(phoneNumber, "phoneNumber");
        this.databaseHelper.phoneBookDao().addNumber(phoneNumber);
    }

    public final void deletePhoneNumber(PhoneNumber phoneNumber) {
        Intrinsics.checkParameterIsNotNull(phoneNumber, "phoneNumber");
        this.databaseHelper.phoneBookDao().deleteNumber(phoneNumber);
    }

    public final Object sendLocationWithDb(List<Location> list, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new Repository$sendLocationWithDb$2(this, list, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public static /* synthetic */ void saveLocationAsync$default(Repository repository, List list, byte b, IndoorNavigation indoorNavigation, Function0 function0, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                b = -1;
            }
            repository.saveLocationAsync(list, b, indoorNavigation, function0);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: saveLocationAsync");
    }

    public final void saveLocationAsync(List<? extends android.location.Location> list, byte b, IndoorNavigation indoorNavigation, Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(list, "locations");
        Intrinsics.checkParameterIsNotNull(function0, "callback");
        LogKt.toFile$default(Integer.valueOf(list.size()), "Save location items", null, null, 6, null);
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, Dispatchers.getIO(), null, new Repository$saveLocationAsync$1(this, list, b, indoorNavigation, null), 2, null);
        function0.invoke();
    }

    public static /* synthetic */ void sendLocationAsync$default(Repository repository, List list, byte b, IndoorNavigation indoorNavigation, Function0 function0, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                b = -1;
            }
            repository.sendLocationAsync(list, b, indoorNavigation, function0);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendLocationAsync");
    }

    public final void sendLocationAsync(List<? extends android.location.Location> list, byte b, IndoorNavigation indoorNavigation, Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(list, "locations");
        Intrinsics.checkParameterIsNotNull(function0, "callback");
        LogKt.toFile$default(Integer.valueOf(list.size()), "Save location items", null, null, 6, null);
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, Dispatchers.getIO(), null, new Repository$sendLocationAsync$1(this, list, b, indoorNavigation, null), 2, null);
        function0.invoke();
    }

    static /* synthetic */ List getItems$default(Repository repository, List list, byte b, IndoorNavigation indoorNavigation, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                b = -1;
            }
            return repository.getItems(list, b, indoorNavigation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getItems");
    }

    /* access modifiers changed from: private */
    public final List<Location> getItems(List<? extends android.location.Location> list, byte b, IndoorNavigation indoorNavigation) {
        Repository repository = this;
        Iterable<android.location.Location> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (android.location.Location location : iterable) {
            String value = repository.imei.getValue();
            if (value == null) {
                Intrinsics.throwNpe();
            }
            Intrinsics.checkExpressionValueIsNotNull(value, "imei.value!!");
            String str = value;
            long currentTimeMillis = System.currentTimeMillis();
            Long valueOf = Long.valueOf(location.getTime());
            Double valueOf2 = Double.valueOf(location.getLatitude());
            Double valueOf3 = Double.valueOf(location.getLongitude());
            Float valueOf4 = Float.valueOf((float) location.getAltitude());
            Integer valueOf5 = Integer.valueOf((int) location.getAccuracy());
            Short valueOf6 = Short.valueOf((short) ((int) location.getBearing()));
            Float valueOf7 = Float.valueOf(location.getSpeed());
            String provider = location.getProvider();
            StepSensor stepInfo = repository.databaseHelper.stepSensorDao().getStepInfo();
            Location location2 = r4;
            Location location3 = new Location(str, currentTimeMillis, valueOf, valueOf2, valueOf3, valueOf4, valueOf5, valueOf6, valueOf7, provider, Integer.valueOf(stepInfo != null ? stepInfo.getStepCount() : -1), null, Byte.valueOf(b), null, null, null, null, null, null, indoorNavigation, 518144, null);
            arrayList.add(location2);
            repository = this;
        }
        return (List) arrayList;
    }

    public final void requestLocation(byte b, IndoorNavigation indoorNavigation, Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "callback");
        getGoogleApiHelper().requestLastLocation(new Repository$requestLocation$1(this, b, indoorNavigation, function0));
    }

    public final String searchUserInIdentix(String str) {
        IdentixOneResponse identixOneResponse;
        Intrinsics.checkParameterIsNotNull(str, "path");
        File file = new File(str);
        try {
            Response execute = IdentixOneApi.DefaultImpls.searchUser$default(IdentixOneApi.Factory.getInstance(), MultipartBody.Part.Companion.createFormData("photo", file.getName(), RequestBody.Companion.create(file, MediaType.Companion.parse("multipart/form-data"))), false, false, 6, null).execute();
            HelperKt.deletePictureFile(str);
            LogKt.toFile$default(execute, "response", null, null, 6, null);
            LogKt.toFile$default(execute.body(), "body", null, null, 6, null);
            Intrinsics.checkExpressionValueIsNotNull(execute, "it");
            if (!execute.isSuccessful()) {
                execute = null;
            }
            if (execute == null || (identixOneResponse = (IdentixOneResponse) execute.body()) == null) {
                return null;
            }
            return identixOneResponse.getIdxId();
        } catch (Exception e) {
            LogKt.toFile$default(e, "Error search user", null, null, 6, null);
            return null;
        }
    }

    public final void startIdentificationAsync(String str) {
        Intrinsics.checkParameterIsNotNull(str, "id");
        this.showLoader.postValue(true);
        getGoogleApiHelper().requestLastLocation(new Repository$startIdentificationAsync$1(this, str));
    }

    public final boolean startWork(String str, String str2, android.location.Location location) {
        Intrinsics.checkParameterIsNotNull(str, "imei");
        Intrinsics.checkParameterIsNotNull(str2, "idxid");
        Settings value = this.settings.getValue();
        if (value != null) {
            try {
                GaskarApi instance = GaskarApi.Factory.getInstance(value.getGaskarAddress());
                double d = 0.0d;
                double latitude = location != null ? location.getLatitude() : 0.0d;
                if (location != null) {
                    d = location.getLongitude();
                }
                Response<EmptyResponse> execute = instance.start(str, str2, latitude, d).execute();
                Intrinsics.checkExpressionValueIsNotNull(execute, "response");
                return execute.isSuccessful();
            } catch (Exception e) {
                LogKt.toFile$default(e, "error start work", null, null, 6, null);
                return false;
            }
        } else {
            throw new NullPointerException("Settings not defined");
        }
    }

    public final void endWork(String str) {
        Intrinsics.checkParameterIsNotNull(str, "imei");
        Settings value = this.settings.getValue();
        if (value != null) {
            try {
                Response<Unit> execute = GaskarApi.Factory.getInstance(value.getGaskarAddress()).stop(str).execute();
                Intrinsics.checkExpressionValueIsNotNull(execute, "response");
                if (execute.isSuccessful() && value.getWorkIsStart()) {
                    Job unused = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new Repository$endWork$$inlined$let$lambda$1(null, this, str), 3, null);
                }
            } catch (Exception e) {
                LogKt.toFile$default(e, "error stop work", null, null, 6, null);
            }
        } else {
            throw new NullPointerException("Settings not defined");
        }
    }

    static /* synthetic */ void sendWorkIsStart$default(Repository repository, String str, boolean z, android.location.Location location, int i, Object obj) {
        if (obj == null) {
            if ((i & 4) != 0) {
                location = null;
            }
            repository.sendWorkIsStart(str, z, location);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendWorkIsStart");
    }

    private final void sendWorkIsStart(String str, boolean z, android.location.Location location) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, Dispatchers.getIO(), null, new Repository$sendWorkIsStart$1(this, str, location, z, null), 2, null);
    }

    public final boolean requestPassword() {
        Response<Unit> execute = PersonalTrackerApi.Factory.getInstance().requestPassword(this.deviceData).execute();
        Intrinsics.checkExpressionValueIsNotNull(execute, "result");
        if (execute.isSuccessful()) {
            return true;
        }
        this.attemptCountLeft--;
        return false;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: kotlin.text.StringsKt__StringsKt.contains$default(java.lang.CharSequence, java.lang.CharSequence, boolean, int, java.lang.Object):boolean
     arg types: [java.lang.String, java.lang.String, int, int, ?[OBJECT, ARRAY]]
     candidates:
      kotlin.text.StringsKt__StringsKt.contains$default(java.lang.CharSequence, char, boolean, int, java.lang.Object):boolean
      kotlin.text.StringsKt__StringsKt.contains$default(java.lang.CharSequence, java.lang.CharSequence, boolean, int, java.lang.Object):boolean */
    public final boolean getUserStatus() {
        PersonalTrackerApi instance = PersonalTrackerApi.Factory.getInstance();
        String value = this.imei.getValue();
        if (value == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(value, "imei.value!!");
        Response<CheckDeviceResponse> execute = instance.checkDevicestatus(value).execute();
        StringBuilder sb = new StringBuilder();
        sb.append("User status: ");
        sb.append(execute.body());
        sb.append(", ");
        sb.append(execute.message());
        sb.append(". Server response: ");
        Intrinsics.checkExpressionValueIsNotNull(execute, "devStatusResponse");
        sb.append(execute.isSuccessful());
        LogKt.toFile$default(sb.toString(), null, null, null, 7, null);
        if (!execute.isSuccessful()) {
            return false;
        }
        CheckDeviceResponse body = execute.body();
        BaseMainActivity.Companion companion = BaseMainActivity.Companion;
        if (body == null) {
            Intrinsics.throwNpe();
        }
        companion.setNewUser(StringsKt.contains$default((CharSequence) body.getStatus(), (CharSequence) "disabled", false, 2, (Object) null));
        return BaseMainActivity.Companion.isNewUser();
    }

    public final boolean registerUser(String str) {
        Intrinsics.checkParameterIsNotNull(str, "photoPath");
        boolean z = true;
        if (BaseMainActivity.Companion.isNewUser()) {
            Response<AuthResponse> execute = PersonalTrackerApi.Factory.getInstance().registerDevice(this.deviceData).execute();
            StringBuilder sb = new StringBuilder();
            sb.append("User name registration: ");
            sb.append(execute.body());
            sb.append(",  ");
            sb.append(execute.message());
            sb.append(". Server response: ");
            Intrinsics.checkExpressionValueIsNotNull(execute, "regDevResp");
            sb.append(execute.isSuccessful());
            LogKt.toFile$default(sb.toString(), null, null, null, 7, null);
            AuthResponse body = execute.body();
            LogKt.toLog$default(body, "regDevBody= " + body, (String) null, (String) null, 6, (Object) null);
            if (execute.isSuccessful()) {
                if (body == null) {
                    Intrinsics.throwNpe();
                }
                int code = body.getCode();
                if (code == 1000 || code == 1001) {
                    this.authCode.postValue(Integer.valueOf(body.getCode()));
                }
            }
            z = false;
        }
        if (z) {
            return sendPhoto(str, getAvatarUtils().uploadBitmap(str));
        }
        return false;
    }

    private final boolean sendPhoto(String str, byte[] bArr) {
        File convertBitmapToFile = getAvatarUtils().convertBitmapToFile(str, bArr);
        MultipartBody.Part createFormData = MultipartBody.Part.Companion.createFormData("photo", convertBitmapToFile.getName(), RequestBody.Companion.create(convertBitmapToFile, MediaType.Companion.parse("multipart/form-data")));
        try {
            PersonalTrackerApi instance = PersonalTrackerApi.Factory.getInstance();
            String value = this.imei.getValue();
            if (value == null) {
                Intrinsics.throwNpe();
            }
            Intrinsics.checkExpressionValueIsNotNull(value, "imei.value!!");
            Response<Unit> execute = instance.patientIdentification(value, createFormData).execute();
            StringBuilder sb = new StringBuilder();
            sb.append("User photo registration: ");
            sb.append(execute.body());
            sb.append(' ');
            sb.append(execute.message());
            sb.append(". Server response: ");
            Intrinsics.checkExpressionValueIsNotNull(execute, "result");
            sb.append(execute.isSuccessful());
            LogKt.toFile$default(sb.toString(), null, null, null, 7, null);
            if (execute.isSuccessful()) {
                startWork();
                resetAttemptLeft();
            } else {
                this.attemptCountLeft--;
            }
            identificationSuccess(execute.isSuccessful());
            return execute.isSuccessful();
        } catch (Exception e) {
            LogKt.toFile$default(e, "error identification", null, null, 6, null);
            this.showNetworkError.postValue(true);
            this.attemptCountLeft--;
            return false;
        }
    }
}
