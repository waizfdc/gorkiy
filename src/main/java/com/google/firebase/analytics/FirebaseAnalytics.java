package com.google.firebase.analytics;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.internal.measurement.zzv;
import com.google.android.gms.internal.measurement.zzx;
import com.google.android.gms.measurement.internal.zzgo;
import com.google.android.gms.measurement.internal.zzio;
import com.google.android.gms.measurement.internal.zzw;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.iid.FirebaseInstanceId;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-measurement-api@@17.2.3 */
public final class FirebaseAnalytics {
    private static volatile FirebaseAnalytics zza;
    /* access modifiers changed from: private */
    public final zzgo zzb;
    /* access modifiers changed from: private */
    public final zzx zzc;
    /* access modifiers changed from: private */
    public final boolean zzd;
    private String zze;
    private long zzf;
    private final Object zzg;
    private ExecutorService zzh;

    /* compiled from: com.google.android.gms:play-services-measurement-api@@17.2.3 */
    public static class Event {
        public static final String ADD_PAYMENT_INFO = "add_payment_info";
        public static final String ADD_TO_CART = "add_to_cart";
        public static final String ADD_TO_WISHLIST = "add_to_wishlist";
        public static final String APP_OPEN = "app_open";
        public static final String BEGIN_CHECKOUT = "begin_checkout";
        public static final String CAMPAIGN_DETAILS = "campaign_details";
        public static final String CHECKOUT_PROGRESS = "checkout_progress";
        public static final String EARN_VIRTUAL_CURRENCY = "earn_virtual_currency";
        public static final String ECOMMERCE_PURCHASE = "ecommerce_purchase";
        public static final String GENERATE_LEAD = "generate_lead";
        public static final String JOIN_GROUP = "join_group";
        public static final String LEVEL_END = "level_end";
        public static final String LEVEL_START = "level_start";
        public static final String LEVEL_UP = "level_up";
        public static final String LOGIN = "login";
        public static final String POST_SCORE = "post_score";
        public static final String PRESENT_OFFER = "present_offer";
        public static final String PURCHASE_REFUND = "purchase_refund";
        public static final String REMOVE_FROM_CART = "remove_from_cart";
        public static final String SEARCH = "search";
        public static final String SELECT_CONTENT = "select_content";
        public static final String SET_CHECKOUT_OPTION = "set_checkout_option";
        public static final String SHARE = "share";
        public static final String SIGN_UP = "sign_up";
        public static final String SPEND_VIRTUAL_CURRENCY = "spend_virtual_currency";
        public static final String TUTORIAL_BEGIN = "tutorial_begin";
        public static final String TUTORIAL_COMPLETE = "tutorial_complete";
        public static final String UNLOCK_ACHIEVEMENT = "unlock_achievement";
        public static final String VIEW_ITEM = "view_item";
        public static final String VIEW_ITEM_LIST = "view_item_list";
        public static final String VIEW_SEARCH_RESULTS = "view_search_results";

        protected Event() {
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-api@@17.2.3 */
    public static class Param {
        public static final String ACHIEVEMENT_ID = "achievement_id";
        public static final String ACLID = "aclid";
        public static final String AFFILIATION = "affiliation";
        public static final String CAMPAIGN = "campaign";
        public static final String CHARACTER = "character";
        public static final String CHECKOUT_OPTION = "checkout_option";
        public static final String CHECKOUT_STEP = "checkout_step";
        public static final String CONTENT = "content";
        public static final String CONTENT_TYPE = "content_type";
        public static final String COUPON = "coupon";
        public static final String CP1 = "cp1";
        public static final String CREATIVE_NAME = "creative_name";
        public static final String CREATIVE_SLOT = "creative_slot";
        public static final String CURRENCY = "currency";
        public static final String DESTINATION = "destination";
        public static final String END_DATE = "end_date";
        public static final String EXTEND_SESSION = "extend_session";
        public static final String FLIGHT_NUMBER = "flight_number";
        public static final String GROUP_ID = "group_id";
        public static final String INDEX = "index";
        public static final String ITEM_BRAND = "item_brand";
        public static final String ITEM_CATEGORY = "item_category";
        public static final String ITEM_ID = "item_id";
        public static final String ITEM_LIST = "item_list";
        public static final String ITEM_LOCATION_ID = "item_location_id";
        public static final String ITEM_NAME = "item_name";
        public static final String ITEM_VARIANT = "item_variant";
        public static final String LEVEL = "level";
        public static final String LEVEL_NAME = "level_name";
        public static final String LOCATION = "location";
        public static final String MEDIUM = "medium";
        public static final String METHOD = "method";
        public static final String NUMBER_OF_NIGHTS = "number_of_nights";
        public static final String NUMBER_OF_PASSENGERS = "number_of_passengers";
        public static final String NUMBER_OF_ROOMS = "number_of_rooms";
        public static final String ORIGIN = "origin";
        public static final String PRICE = "price";
        public static final String QUANTITY = "quantity";
        public static final String SCORE = "score";
        public static final String SEARCH_TERM = "search_term";
        public static final String SHIPPING = "shipping";
        @Deprecated
        public static final String SIGN_UP_METHOD = "sign_up_method";
        public static final String SOURCE = "source";
        public static final String START_DATE = "start_date";
        public static final String SUCCESS = "success";
        public static final String TAX = "tax";
        public static final String TERM = "term";
        public static final String TRANSACTION_ID = "transaction_id";
        public static final String TRAVEL_CLASS = "travel_class";
        public static final String VALUE = "value";
        public static final String VIRTUAL_CURRENCY_NAME = "virtual_currency_name";

        protected Param() {
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-api@@17.2.3 */
    public static class UserProperty {
        public static final String ALLOW_AD_PERSONALIZATION_SIGNALS = "allow_personalized_ads";
        public static final String SIGN_UP_METHOD = "sign_up_method";

        protected UserProperty() {
        }
    }

    public static FirebaseAnalytics getInstance(Context context) {
        if (zza == null) {
            synchronized (FirebaseAnalytics.class) {
                if (zza == null) {
                    if (zzx.zzb(context)) {
                        zza = new FirebaseAnalytics(zzx.zza(context));
                    } else {
                        zza = new FirebaseAnalytics(zzgo.zza(context, (zzv) null));
                    }
                }
            }
        }
        return zza;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.measurement.internal.zzhp.zza(java.lang.String, java.lang.String, android.os.Bundle, boolean):void
     arg types: [java.lang.String, java.lang.String, android.os.Bundle, int]
     candidates:
      com.google.android.gms.measurement.internal.zzhp.zza(java.lang.String, java.lang.String, long, java.lang.Object):void
      com.google.android.gms.measurement.internal.zzhp.zza(java.lang.String, java.lang.String, java.lang.String, boolean):java.util.Map<java.lang.String, java.lang.Object>
      com.google.android.gms.measurement.internal.zzhp.zza(java.lang.String, java.lang.String, long, android.os.Bundle):void
      com.google.android.gms.measurement.internal.zzhp.zza(java.lang.String, java.lang.String, java.lang.Object, long):void
      com.google.android.gms.measurement.internal.zzhp.zza(java.lang.String, java.lang.String, java.lang.Object, boolean):void
      com.google.android.gms.measurement.internal.zzhp.zza(java.lang.String, java.lang.String, java.lang.String, android.os.Bundle):void
      com.google.android.gms.measurement.internal.zzhp.zza(java.lang.String, java.lang.String, android.os.Bundle, boolean):void */
    public final void logEvent(String str, Bundle bundle) {
        if (this.zzd) {
            this.zzc.zza(str, bundle);
        } else {
            this.zzb.zzh().zza(SettingsJsonConstants.APP_KEY, str, bundle, true);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.measurement.internal.zzhp.zza(java.lang.String, java.lang.String, java.lang.Object, boolean):void
     arg types: [java.lang.String, java.lang.String, java.lang.String, int]
     candidates:
      com.google.android.gms.measurement.internal.zzhp.zza(java.lang.String, java.lang.String, long, java.lang.Object):void
      com.google.android.gms.measurement.internal.zzhp.zza(java.lang.String, java.lang.String, java.lang.String, boolean):java.util.Map<java.lang.String, java.lang.Object>
      com.google.android.gms.measurement.internal.zzhp.zza(java.lang.String, java.lang.String, long, android.os.Bundle):void
      com.google.android.gms.measurement.internal.zzhp.zza(java.lang.String, java.lang.String, android.os.Bundle, boolean):void
      com.google.android.gms.measurement.internal.zzhp.zza(java.lang.String, java.lang.String, java.lang.Object, long):void
      com.google.android.gms.measurement.internal.zzhp.zza(java.lang.String, java.lang.String, java.lang.String, android.os.Bundle):void
      com.google.android.gms.measurement.internal.zzhp.zza(java.lang.String, java.lang.String, java.lang.Object, boolean):void */
    public final void setUserProperty(String str, String str2) {
        if (this.zzd) {
            this.zzc.zza(str, str2);
        } else {
            this.zzb.zzh().zza(SettingsJsonConstants.APP_KEY, str, (Object) str2, false);
        }
    }

    public final void setCurrentScreen(Activity activity, String str, String str2) {
        if (this.zzd) {
            this.zzc.zza(activity, str, str2);
        } else if (!zzw.zza()) {
            this.zzb.zzr().zzi().zza("setCurrentScreen must be called from the main thread");
        } else {
            this.zzb.zzv().zza(activity, str, str2);
        }
    }

    public final void setAnalyticsCollectionEnabled(boolean z) {
        if (this.zzd) {
            this.zzc.zza(z);
        } else {
            this.zzb.zzh().zza(z);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.measurement.internal.zzhp.zza(java.lang.String, java.lang.String, java.lang.Object, boolean):void
     arg types: [java.lang.String, java.lang.String, java.lang.String, int]
     candidates:
      com.google.android.gms.measurement.internal.zzhp.zza(java.lang.String, java.lang.String, long, java.lang.Object):void
      com.google.android.gms.measurement.internal.zzhp.zza(java.lang.String, java.lang.String, java.lang.String, boolean):java.util.Map<java.lang.String, java.lang.Object>
      com.google.android.gms.measurement.internal.zzhp.zza(java.lang.String, java.lang.String, long, android.os.Bundle):void
      com.google.android.gms.measurement.internal.zzhp.zza(java.lang.String, java.lang.String, android.os.Bundle, boolean):void
      com.google.android.gms.measurement.internal.zzhp.zza(java.lang.String, java.lang.String, java.lang.Object, long):void
      com.google.android.gms.measurement.internal.zzhp.zza(java.lang.String, java.lang.String, java.lang.String, android.os.Bundle):void
      com.google.android.gms.measurement.internal.zzhp.zza(java.lang.String, java.lang.String, java.lang.Object, boolean):void */
    public final void setUserId(String str) {
        if (this.zzd) {
            this.zzc.zza(str);
        } else {
            this.zzb.zzh().zza(SettingsJsonConstants.APP_KEY, "_id", (Object) str, true);
        }
    }

    @Deprecated
    public final void setMinimumSessionDuration(long j) {
        if (this.zzd) {
            this.zzc.zza(j);
        } else {
            this.zzb.zzh().zza(j);
        }
    }

    public final void setSessionTimeoutDuration(long j) {
        if (this.zzd) {
            this.zzc.zzb(j);
        } else {
            this.zzb.zzh().zzb(j);
        }
    }

    private final ExecutorService zza() {
        ExecutorService executorService;
        synchronized (FirebaseAnalytics.class) {
            if (this.zzh == null) {
                this.zzh = new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new ArrayBlockingQueue(100));
            }
            executorService = this.zzh;
        }
        return executorService;
    }

    public final Task<String> getAppInstanceId() {
        try {
            String zzb2 = zzb();
            if (zzb2 != null) {
                return Tasks.forResult(zzb2);
            }
            return Tasks.call(zza(), new zzb(this));
        } catch (Exception e) {
            if (this.zzd) {
                this.zzc.zza(5, "Failed to schedule task for getAppInstanceId", (Object) null, (Object) null, (Object) null);
            } else {
                this.zzb.zzr().zzi().zza("Failed to schedule task for getAppInstanceId");
            }
            return Tasks.forException(e);
        }
    }

    private FirebaseAnalytics(zzgo zzgo) {
        Preconditions.checkNotNull(zzgo);
        this.zzb = zzgo;
        this.zzc = null;
        this.zzd = false;
        this.zzg = new Object();
    }

    private FirebaseAnalytics(zzx zzx) {
        Preconditions.checkNotNull(zzx);
        this.zzb = null;
        this.zzc = zzx;
        this.zzd = true;
        this.zzg = new Object();
    }

    public final void resetAnalyticsData() {
        zza((String) null);
        if (this.zzd) {
            this.zzc.zzb();
        } else {
            this.zzb.zzh().zzd(this.zzb.zzm().currentTimeMillis());
        }
    }

    public final String getFirebaseInstanceId() {
        return FirebaseInstanceId.getInstance().getId();
    }

    /* access modifiers changed from: private */
    public final void zza(String str) {
        synchronized (this.zzg) {
            this.zze = str;
            if (this.zzd) {
                this.zzf = DefaultClock.getInstance().elapsedRealtime();
            } else {
                this.zzf = this.zzb.zzm().elapsedRealtime();
            }
        }
    }

    /* access modifiers changed from: private */
    public final String zzb() {
        long j;
        synchronized (this.zzg) {
            if (this.zzd) {
                j = DefaultClock.getInstance().elapsedRealtime();
            } else {
                j = this.zzb.zzm().elapsedRealtime();
            }
            if (Math.abs(j - this.zzf) >= 1000) {
                return null;
            }
            String str = this.zze;
            return str;
        }
    }

    public static zzio getScionFrontendApiImplementation(Context context, Bundle bundle) {
        zzx zza2;
        if (zzx.zzb(context) && (zza2 = zzx.zza(context, (String) null, (String) null, (String) null, bundle)) != null) {
            return new zza(zza2);
        }
        return null;
    }
}
