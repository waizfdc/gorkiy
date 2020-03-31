package com.google.android.gms.internal.fitness;

import androidx.recyclerview.widget.ItemTouchHelper;
import com.google.android.gms.internal.fitness.zzgg;
import kotlin.text.Typography;
import okhttp3.internal.ws.WebSocketProtocol;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public final class zzf extends zzgg<zzf, zzb> implements zzhq {
    /* access modifiers changed from: private */
    public static final zzf zzf;
    private static volatile zzhy<zzf> zzg;

    /* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
    public enum zza implements zzgj {
        UNKNOWN(0),
        GAMES(1),
        PLUS(2),
        PANORAMA(3),
        WALLET(4),
        PEOPLE(5),
        LOCATION(6),
        APP_STATE(7),
        ADMOB(8),
        ACCOUNT(9),
        CAST(10),
        DRIVE(11),
        ADDRESS(12),
        CAR(13),
        WEAR(14),
        IDENTITY(15),
        AUTH_PROXY(16),
        FITNESS(17),
        REMINDERS(18),
        LIGHT_INDEX(19),
        DEVICE_CONNECTIONS(20),
        APP_DATA_SEARCH(21),
        REPORTING(22),
        GOOGLE_LOCATION_MANAGER(23),
        PLAY_LOG(24),
        DROID_GUARD(25),
        LOCKBOX(26),
        CAST_MIRRORING(27),
        NETWORK_QUALITY(28),
        FEEDBACK(29),
        SEARCH_ADMINISTRATION(30),
        AUTO_BACKUP(31),
        SEARCH_QUERIES(32),
        GLOBAL_SEARCH_ADMIN(33),
        CLOUD_SAVE(34),
        UDC(35),
        SEARCH_CORPORA(36),
        DEVICE_MANAGER(37),
        PSEUDONYMOUS_ID(38),
        COMMON(39),
        CLEARCUT_LOGGER(40),
        USAGE_REPORTING(41),
        KIDS(42),
        DOWNLOAD(43),
        SIGN_IN(44),
        SAFETY_NET(45),
        ADMOB_GSERVICES_VALUE(46),
        CONTEXT_MANAGER(47),
        AUDIO_MODEM(48),
        NEARBY(49),
        LIGHTWEIGHT_NETWORK_QUALITY(50),
        PHENOTYPE(51),
        VOICE_UNLOCK(52),
        NEARBY_CONNECTIONS(54),
        FIT_SENSORS(55),
        FIT_RECORDING(56),
        FIT_HISTORY(57),
        FIT_SESSIONS(58),
        FIT_BLE(59),
        FIT_CONFIG(60),
        FIT_INTERNAL(61),
        NEARBY_MESSAGES(62),
        GOOGLE_HELP(63),
        CHECKIN_CONFIG(64),
        PLACES_GEO_DATA(65),
        IME_UPDATES(66),
        PLACES_PLACE_DETECTION(67),
        AUTH_CREDENTIALS(68),
        NEARBY_BOOTSTRAP(69),
        PLUS_INTERNAL(70),
        MAPS_API(71),
        TRUSTAGENT_TRUSTED_DEVICES(72),
        SEARCH_AUTH(73),
        ACCOUNT_STATUS(74),
        SMARTDEVICE_D2D_SOURCE_DEVICE(75),
        SMARTDEVICE_D2D_TARGET_DEVICE(76),
        APP_INVITE(77),
        SEARCH_NATIVE_API(78),
        WALLET_TAP_AND_PAY(79),
        CHROME_SYNC(80),
        SMARTDEVICE_SETUP_ACCOUNTS_BOOTSTRAP(81),
        GSA(82),
        CAST_REMOTE_DISPLAY(83),
        TRUSTAGENT(84),
        TRUSTAGENT_STATE(85),
        YOUTUBE(86),
        AUTH_SIGN_IN(87),
        VISION(88),
        TRUSTAGENT_BRIDGE(89),
        BACKUP_STATS(90),
        AUTH_GOOGLE_SIGN_IN(91),
        MEASUREMENT(93),
        WEAVE_DEVICE(94),
        AD_MEASUREMENT(95),
        CHROME_SYNC_PREFERENCES(96),
        CHROME_SYNC_PASSWORD(97),
        FREIGHTER(98),
        WEAVE_MANAGEMENT(99),
        WEAVE_COMMAND(100),
        WEAVE_APP_ACCESS(101),
        WEAVE_EVENT(102),
        WEAVE_LOCAL_STATELESS_DEVICE(103),
        AUTH_AUTHZEN_KEY(104),
        SCREEN_CAPTURE(105),
        APP_INVITE_INTERNAL(106),
        AUTH_AUTHZEN_INTERNAL_DATA(107),
        AUTH_PROXIMITY(108),
        ACCOUNT_SETTINGS(109),
        GUNS(110),
        BEACON(111),
        FIREBASE_AUTH(112),
        APP_INDEXING(113),
        WALLET_P2P(114),
        WALLET_P2P_INTERNAL(115),
        GASS(116),
        U2F_API(117),
        U2F_PRIVILEGED_API(118),
        U2F_ZERO_PARTY_API(119),
        WORK_ACCOUNT_API(120),
        INSTANT_APPS(121),
        CAST_FIRST_PARTY(122),
        ADMOB_CACHE(123),
        BOOT_COUNT(124),
        FIT_GOALS(125),
        SMS_RETRIEVER(WebSocketProtocol.PAYLOAD_SHORT),
        MOBILE_DATA_HUB(127),
        AUTH_ACCOUNT_TRANSFER(128),
        CRYPTAUTH_API(129),
        CHECKIN_API(130),
        DYNAMIC_LINKS_API(131),
        FONT_API(132),
        TEST_SUPPORT(133),
        LOCATION_SHARING(134),
        ROMANESCO(135),
        AUTH_MANAGED_EMM_API(136),
        NETWORK_SCORER(137),
        NETWORK_RECOMMENDATION(138),
        BRELLA(139),
        RESTORE_SESSION(140),
        PEER_DOWNLOAD_MANAGER(141),
        AUTH_PROXIMITY_DEVICE_SYNC(142),
        REACHABILITY(143),
        AUTH_PROXIMITY_SECURE_CHANNEL(144),
        PREDICT_ON_DEVICE(145),
        APP_PREVIEW_MESSAGING(146),
        LOCAL_RESTORE(147),
        FIDO2_API(148),
        FIDO2_PRIVILEGED_API(149),
        TELEPHONY_SPAM(150),
        AUTH_UNCERTIFIED_DEVICE(151),
        MOBILE_DATA_DOWNLOAD(152),
        AUTH_ACCOUNT_DATA(153),
        AUDIT(154),
        CONSTELLATION(155),
        GROWTH(156),
        SYSTEM_UPDATE(157),
        MOBILE_DATA_PLAN(158),
        SMARTDEVICE_WIFI_HELPER(159),
        MOBSTORE_FILE(160),
        CAST_API(161),
        CURATOR(162),
        USER_LOCATION(163),
        MOBILE_DATA_HUB_LISTENER(164),
        EXAMPLE(165),
        ADMOB_HTTP_CLIENT(166),
        LANGUAGE_PROFILE(167),
        MDNS(168),
        NEARBY_SETUP(169),
        ANALYTICS(170),
        SUBSCRIPTIONS(171),
        FOLSOM(172),
        SEMANTIC_LOCATION(173),
        VEHICLE(174),
        BACKUP_NOW(175),
        AUTH_EARLY_UPDATE(176),
        AUTOFILL(177),
        MATCHSTICK(178),
        AUTH_CREDENTIALS_INTERNAL(179),
        FIDO2_ZERO_PARTY_API(180),
        G1_RESTORE(181),
        G1_BACKUP(182),
        CODELAB(183),
        DRIVING_MODE(184),
        OSS_LICENSES_SERVICE(185),
        CLEAR_CONTACT_INTERACTIONS_SERVICE(186),
        AUTH_MANAGED_POLICY_SERVICE(187),
        PAY_SECURE_ELEMENT_SERVICE(188),
        RCS(189),
        SMARTDEVICE_POST_SETUP(190),
        CARRIER_AUTH(191),
        SYSTEM_UPDATE_SINGLE_USER(192),
        APPUSAGE(193),
        NEARBY_SHARING(194),
        ADMOB_CONSENT_SERVICE(195),
        CREDENTIAL_MANAGER(196),
        SMS_RETRIEVER_INTERNAL(197),
        PAY(198),
        ASTERISM(199),
        MOBILE_SUBSCRIPTION(ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION),
        GMS_RESTORE(201),
        FACS_CACHE(202),
        ADMOB_SDK_SIGNAL(203),
        PLATFORM_CONFIGURATOR(204),
        RECAPTCHA(205),
        DUOKIT_SERVICE(206),
        SYSTEM_UPDATE_TV_API(207),
        CONTACTS_SYNC_SERVICE(208),
        FEEDBACK_CAR(209),
        SMARTDEVICE_SOURCE_DIRECT_TRANSFER(210),
        SMARTDEVICE_TARGET_DIRECT_TRANSFER(211),
        AUTH_API_IDENTITY_SIGNIN(212),
        IDENTITY_GIS_INTERNAL(213),
        UNRECOGNIZED(-1);
        
        private static final zzgm<zza> zzhm = new zzg();
        private final int value;

        public final int zzc() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("<");
            sb.append(getClass().getName());
            sb.append('@');
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            if (this != UNRECOGNIZED) {
                sb.append(" number=");
                sb.append(zzc());
            }
            sb.append(" name=");
            sb.append(name());
            sb.append((char) Typography.greater);
            return sb.toString();
        }

        private zza(int i) {
            this.value = i;
        }
    }

    private zzf() {
    }

    /* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
    public static final class zzb extends zzgg.zzb<zzf, zzb> implements zzhq {
        private zzb() {
            super(zzf.zzf);
        }

        /* synthetic */ zzb(zze zze) {
            this();
        }
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Type inference failed for: r1v13, types: [com.google.android.gms.internal.fitness.zzgg$zza, com.google.android.gms.internal.fitness.zzhy<com.google.android.gms.internal.fitness.zzf>] */
    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        zzhy<zzf> zzhy;
        switch (zze.zze[i - 1]) {
            case 1:
                return new zzf();
            case 2:
                return new zzb(null);
            case 3:
                return zza(zzf, "\u0000\u0000", (Object[]) null);
            case 4:
                return zzf;
            case 5:
                zzhy<zzf> zzhy2 = zzg;
                zzhy<zzf> zzhy3 = zzhy2;
                if (zzhy2 == null) {
                    synchronized (zzf.class) {
                        zzhy<zzf> zzhy4 = zzg;
                        zzhy = zzhy4;
                        if (zzhy4 == null) {
                            ? zza2 = new zzgg.zza(zzf);
                            zzg = zza2;
                            zzhy = zza2;
                        }
                    }
                    zzhy3 = zzhy;
                }
                return zzhy3;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        zzf zzf2 = new zzf();
        zzf = zzf2;
        zzgg.zza(zzf.class, super);
    }
}
