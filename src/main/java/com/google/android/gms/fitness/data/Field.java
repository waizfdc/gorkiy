package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public final class Field extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Field> CREATOR = new zzq();
    public static final Field FIELD_ACCURACY = zze("accuracy");
    public static final Field FIELD_ACTIVITY = zzc("activity");
    @Deprecated
    public static final Field FIELD_ACTIVITY_CONFIDENCE = zzg("activity_confidence");
    public static final Field FIELD_ALTITUDE = zzf("altitude");
    public static final Field FIELD_AVERAGE = zze("average");
    public static final Field FIELD_BPM = zze("bpm");
    public static final Field FIELD_CALORIES = zze(NUTRIENT_CALORIES);
    public static final Field FIELD_CIRCUMFERENCE = zze("circumference");
    public static final Field FIELD_CONFIDENCE = zze("confidence");
    public static final Field FIELD_DISTANCE = zze("distance");
    public static final Field FIELD_DURATION = zzc("duration");
    public static final Field FIELD_EXERCISE = new Field("exercise", 3);
    public static final Field FIELD_FOOD_ITEM = new Field("food_item", 3, true);
    public static final Field FIELD_HEIGHT = zze(SettingsJsonConstants.ICON_HEIGHT_KEY);
    public static final Field FIELD_HIGH_LATITUDE = zze("high_latitude");
    public static final Field FIELD_HIGH_LONGITUDE = zze("high_longitude");
    public static final Field FIELD_INTENSITY = zze("intensity");
    public static final Field FIELD_LATITUDE = zze("latitude");
    public static final Field FIELD_LONGITUDE = zze("longitude");
    public static final Field FIELD_LOW_LATITUDE = zze("low_latitude");
    public static final Field FIELD_LOW_LONGITUDE = zze("low_longitude");
    public static final Field FIELD_MAX = zze("max");
    public static final Field FIELD_MEAL_TYPE = zzd("meal_type");
    public static final Field FIELD_MIN = zze("min");
    public static final Field FIELD_NUM_SEGMENTS = zzc("num_segments");
    public static final Field FIELD_NUTRIENTS = zzg("nutrients");
    public static final Field FIELD_OCCURRENCES = zzc("occurrences");
    public static final Field FIELD_PERCENTAGE = zze("percentage");
    public static final Field FIELD_REPETITIONS = zzd("repetitions");
    public static final Field FIELD_RESISTANCE = zzf("resistance");
    public static final Field FIELD_RESISTANCE_TYPE = zzd("resistance_type");
    public static final Field FIELD_REVOLUTIONS = zzc("revolutions");
    public static final Field FIELD_RPM = zze("rpm");
    public static final Field FIELD_SPEED = zze("speed");
    public static final Field FIELD_STEPS = zzc("steps");
    public static final Field FIELD_STEP_LENGTH = zze("step_length");
    public static final Field FIELD_VOLUME = zze("volume");
    public static final Field FIELD_WATTS = zze("watts");
    public static final Field FIELD_WEIGHT = zze("weight");
    public static final int FORMAT_FLOAT = 2;
    public static final int FORMAT_INT32 = 1;
    public static final int FORMAT_MAP = 4;
    public static final int FORMAT_STRING = 3;
    public static final int MEAL_TYPE_BREAKFAST = 1;
    public static final int MEAL_TYPE_DINNER = 3;
    public static final int MEAL_TYPE_LUNCH = 2;
    public static final int MEAL_TYPE_SNACK = 4;
    public static final int MEAL_TYPE_UNKNOWN = 0;
    public static final String NUTRIENT_CALCIUM = "calcium";
    public static final String NUTRIENT_CALORIES = "calories";
    public static final String NUTRIENT_CHOLESTEROL = "cholesterol";
    public static final String NUTRIENT_DIETARY_FIBER = "dietary_fiber";
    public static final String NUTRIENT_IRON = "iron";
    public static final String NUTRIENT_MONOUNSATURATED_FAT = "fat.monounsaturated";
    public static final String NUTRIENT_POLYUNSATURATED_FAT = "fat.polyunsaturated";
    public static final String NUTRIENT_POTASSIUM = "potassium";
    public static final String NUTRIENT_PROTEIN = "protein";
    public static final String NUTRIENT_SATURATED_FAT = "fat.saturated";
    public static final String NUTRIENT_SODIUM = "sodium";
    public static final String NUTRIENT_SUGAR = "sugar";
    public static final String NUTRIENT_TOTAL_CARBS = "carbs.total";
    public static final String NUTRIENT_TOTAL_FAT = "fat.total";
    public static final String NUTRIENT_TRANS_FAT = "fat.trans";
    public static final String NUTRIENT_UNSATURATED_FAT = "fat.unsaturated";
    public static final String NUTRIENT_VITAMIN_A = "vitamin_a";
    public static final String NUTRIENT_VITAMIN_C = "vitamin_c";
    public static final int RESISTANCE_TYPE_BARBELL = 1;
    public static final int RESISTANCE_TYPE_BODY = 6;
    public static final int RESISTANCE_TYPE_CABLE = 2;
    public static final int RESISTANCE_TYPE_DUMBBELL = 3;
    public static final int RESISTANCE_TYPE_KETTLEBELL = 4;
    public static final int RESISTANCE_TYPE_MACHINE = 5;
    public static final int RESISTANCE_TYPE_UNKNOWN = 0;
    public static final Field zzkh = zzd("duration");
    public static final Field zzki = zzg("activity_duration.ascending");
    public static final Field zzkj = zzg("activity_duration.descending");
    public static final Field zzkk = zzh("google.android.fitness.GoalV2");
    public static final Field zzkl = zzh("symptom");
    public static final Field zzkm = zzh("google.android.fitness.StrideModel");
    public static final Field zzkn = zzh("google.android.fitness.Device");
    public static final Field zzko = zze("elevation.change");
    public static final Field zzkp = zzg("elevation.gain");
    public static final Field zzkq = zzg("elevation.loss");
    public static final Field zzkr = zze("floors");
    public static final Field zzks = zzg("floor.gain");
    public static final Field zzkt = zzg("floor.loss");
    public static final Field zzku = zzc("sensor_type");
    private static final Field zzkv = zzc("sensor_types");
    public static final Field zzkw = new Field("timestamps", 5);
    private static final Field zzkx = zzc("sample_period");
    private static final Field zzky = zzc("num_samples");
    private static final Field zzkz = zzc("num_dimensions");
    public static final Field zzla = new Field("sensor_values", 6);
    public static final Field zzlb = zze("probability");
    private final int format;
    private final String name;
    private final Boolean zzlc;

    /* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
    public static class zza {
        public static final Field zzld = Field.zze("x");
        public static final Field zzle = Field.zze("y");
        public static final Field zzlf = Field.zze("z");
        public static final Field zzlg = Field.zzi("debug_session");
        public static final Field zzlh = Field.zzi("google.android.fitness.SessionV2");
        public static final Field zzli = Field.zzh("google.android.fitness.DataPointSession");
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static Field zza(String str, int i) {
        char c;
        switch (str.hashCode()) {
            case -2131707655:
                if (str.equals("accuracy")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -2083865430:
                if (str.equals("debug_session")) {
                    c = '_';
                    break;
                }
                c = 65535;
                break;
            case -2006370880:
                if (str.equals("body_temperature_measurement_location")) {
                    c = 20;
                    break;
                }
                c = 65535;
                break;
            case -1992012396:
                if (str.equals("duration")) {
                    c = ' ';
                    break;
                }
                c = 65535;
                break;
            case -1859447186:
                if (str.equals("blood_glucose_level")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case -1743016407:
                if (str.equals("symptom")) {
                    c = 'K';
                    break;
                }
                c = 65535;
                break;
            case -1655966961:
                if (str.equals("activity")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -1595712862:
                if (str.equals("cervical_dilation")) {
                    c = 23;
                    break;
                }
                c = 65535;
                break;
            case -1579612127:
                if (str.equals("floor.gain")) {
                    c = '%';
                    break;
                }
                c = 65535;
                break;
            case -1579449403:
                if (str.equals("floor.loss")) {
                    c = Typography.amp;
                    break;
                }
                c = 65535;
                break;
            case -1569430471:
                if (str.equals("num_segments")) {
                    c = '7';
                    break;
                }
                c = 65535;
                break;
            case -1531570079:
                if (str.equals("elevation.change")) {
                    c = '!';
                    break;
                }
                c = 65535;
                break;
            case -1440707631:
                if (str.equals("oxygen_saturation")) {
                    c = ';';
                    break;
                }
                c = 65535;
                break;
            case -1439978388:
                if (str.equals("latitude")) {
                    c = '-';
                    break;
                }
                c = 65535;
                break;
            case -1352492506:
                if (str.equals("num_dimensions")) {
                    c = '5';
                    break;
                }
                c = 65535;
                break;
            case -1290561483:
                if (str.equals("probability")) {
                    c = 'a';
                    break;
                }
                c = 65535;
                break;
            case -1271636505:
                if (str.equals("floors")) {
                    c = '\'';
                    break;
                }
                c = 65535;
                break;
            case -1248595573:
                if (str.equals("supplemental_oxygen_flow_rate_average")) {
                    c = 'H';
                    break;
                }
                c = 65535;
                break;
            case -1221029593:
                if (str.equals(SettingsJsonConstants.ICON_HEIGHT_KEY)) {
                    c = ')';
                    break;
                }
                c = 65535;
                break;
            case -1220952307:
                if (str.equals("blood_pressure_measurement_location")) {
                    c = 13;
                    break;
                }
                c = 65535;
                break;
            case -1129337776:
                if (str.equals("num_samples")) {
                    c = '6';
                    break;
                }
                c = 65535;
                break;
            case -1110756780:
                if (str.equals("food_item")) {
                    c = '(';
                    break;
                }
                c = 65535;
                break;
            case -921832806:
                if (str.equals("percentage")) {
                    c = 'L';
                    break;
                }
                c = 65535;
                break;
            case -918978307:
                if (str.equals("cervical_position")) {
                    c = 27;
                    break;
                }
                c = 65535;
                break;
            case -810883302:
                if (str.equals("volume")) {
                    c = 'Y';
                    break;
                }
                c = 65535;
                break;
            case -803244749:
                if (str.equals("blood_pressure_systolic")) {
                    c = 14;
                    break;
                }
                c = 65535;
                break;
            case -791592328:
                if (str.equals("weight")) {
                    c = '[';
                    break;
                }
                c = 65535;
                break;
            case -631448035:
                if (str.equals("average")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case -626344110:
                if (str.equals("high_longitude")) {
                    c = ',';
                    break;
                }
                c = 65535;
                break;
            case -619868540:
                if (str.equals("low_longitude")) {
                    c = '0';
                    break;
                }
                c = 65535;
                break;
            case -511934137:
                if (str.equals("sensor_values")) {
                    c = 'F';
                    break;
                }
                c = 65535;
                break;
            case -494782871:
                if (str.equals("high_latitude")) {
                    c = '+';
                    break;
                }
                c = 65535;
                break;
            case -452643911:
                if (str.equals("step_length")) {
                    c = 'T';
                    break;
                }
                c = 65535;
                break;
            case -437053898:
                if (str.equals("meal_type")) {
                    c = '2';
                    break;
                }
                c = 65535;
                break;
            case -277306353:
                if (str.equals("circumference")) {
                    c = 28;
                    break;
                }
                c = 65535;
                break;
            case -266093204:
                if (str.equals("nutrients")) {
                    c = '8';
                    break;
                }
                c = 65535;
                break;
            case -228366862:
                if (str.equals("oxygen_saturation_measurement_method")) {
                    c = Typography.greater;
                    break;
                }
                c = 65535;
                break;
            case -168965370:
                if (str.equals(NUTRIENT_CALORIES)) {
                    c = 22;
                    break;
                }
                c = 65535;
                break;
            case -126538880:
                if (str.equals("resistance_type")) {
                    c = 'O';
                    break;
                }
                c = 65535;
                break;
            case -28590302:
                if (str.equals("ovulation_test_result")) {
                    c = ':';
                    break;
                }
                c = 65535;
                break;
            case 120:
                if (str.equals("x")) {
                    c = '\\';
                    break;
                }
                c = 65535;
                break;
            case 121:
                if (str.equals("y")) {
                    c = ']';
                    break;
                }
                c = 65535;
                break;
            case 122:
                if (str.equals("z")) {
                    c = '^';
                    break;
                }
                c = 65535;
                break;
            case 97759:
                if (str.equals("bpm")) {
                    c = 21;
                    break;
                }
                c = 65535;
                break;
            case 107876:
                if (str.equals("max")) {
                    c = '1';
                    break;
                }
                c = 65535;
                break;
            case 108114:
                if (str.equals("min")) {
                    c = '4';
                    break;
                }
                c = 65535;
                break;
            case 113135:
                if (str.equals("rpm")) {
                    c = 'Q';
                    break;
                }
                c = 65535;
                break;
            case 66639641:
                if (str.equals("temporal_relation_to_sleep")) {
                    c = 'X';
                    break;
                }
                c = 65535;
                break;
            case 109641799:
                if (str.equals("speed")) {
                    c = 'R';
                    break;
                }
                c = 65535;
                break;
            case 109761319:
                if (str.equals("steps")) {
                    c = 'S';
                    break;
                }
                c = 65535;
                break;
            case 112903913:
                if (str.equals("watts")) {
                    c = 'Z';
                    break;
                }
                c = 65535;
                break;
            case 120904628:
                if (str.equals("sensor_types")) {
                    c = 'E';
                    break;
                }
                c = 65535;
                break;
            case 137365935:
                if (str.equals("longitude")) {
                    c = '.';
                    break;
                }
                c = 65535;
                break;
            case 198162679:
                if (str.equals("low_latitude")) {
                    c = '/';
                    break;
                }
                c = 65535;
                break;
            case 220648413:
                if (str.equals("blood_pressure_diastolic_average")) {
                    c = 10;
                    break;
                }
                c = 65535;
                break;
            case 248891292:
                if (str.equals("blood_glucose_specimen_source")) {
                    c = 8;
                    break;
                }
                c = 65535;
                break;
            case 286612066:
                if (str.equals("activity_duration.descending")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 288459765:
                if (str.equals("distance")) {
                    c = 31;
                    break;
                }
                c = 65535;
                break;
            case 306600408:
                if (str.equals("google.android.fitness.SessionV2")) {
                    c = '`';
                    break;
                }
                c = 65535;
                break;
            case 320627489:
                if (str.equals("cervical_mucus_texture")) {
                    c = 26;
                    break;
                }
                c = 65535;
                break;
            case 419669488:
                if (str.equals("google.android.fitness.Device")) {
                    c = 30;
                    break;
                }
                c = 65535;
                break;
            case 455965230:
                if (str.equals("activity_duration.ascending")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 475560024:
                if (str.equals("blood_pressure_systolic_max")) {
                    c = 16;
                    break;
                }
                c = 65535;
                break;
            case 475560262:
                if (str.equals("blood_pressure_systolic_min")) {
                    c = 17;
                    break;
                }
                c = 65535;
                break;
            case 499324979:
                if (str.equals("intensity")) {
                    c = '*';
                    break;
                }
                c = 65535;
                break;
            case 514168969:
                if (str.equals("google.android.fitness.GoalV2")) {
                    c = 'U';
                    break;
                }
                c = 65535;
                break;
            case 581888402:
                if (str.equals("cervical_mucus_amount")) {
                    c = 25;
                    break;
                }
                c = 65535;
                break;
            case 623947695:
                if (str.equals("oxygen_saturation_average")) {
                    c = Typography.less;
                    break;
                }
                c = 65535;
                break;
            case 738210934:
                if (str.equals("google.android.fitness.StrideModel")) {
                    c = 'V';
                    break;
                }
                c = 65535;
                break;
            case 784486594:
                if (str.equals("occurrences")) {
                    c = '9';
                    break;
                }
                c = 65535;
                break;
            case 811264586:
                if (str.equals("revolutions")) {
                    c = 'P';
                    break;
                }
                c = 65535;
                break;
            case 815736413:
                if (str.equals("oxygen_saturation_system")) {
                    c = '@';
                    break;
                }
                c = 65535;
                break;
            case 829251210:
                if (str.equals("confidence")) {
                    c = 29;
                    break;
                }
                c = 65535;
                break;
            case 833248065:
                if (str.equals("temporal_relation_to_meal")) {
                    c = 'W';
                    break;
                }
                c = 65535;
                break;
            case 883161687:
                if (str.equals("body_temperature")) {
                    c = 19;
                    break;
                }
                c = 65535;
                break;
            case 984367650:
                if (str.equals("repetitions")) {
                    c = 'M';
                    break;
                }
                c = 65535;
                break;
            case 998412730:
                if (str.equals("activity_confidence")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 1136011766:
                if (str.equals("sample_period")) {
                    c = 'C';
                    break;
                }
                c = 65535;
                break;
            case 1276952063:
                if (str.equals("blood_pressure_diastolic")) {
                    c = 9;
                    break;
                }
                c = 65535;
                break;
            case 1284575222:
                if (str.equals("oxygen_saturation_max")) {
                    c = '=';
                    break;
                }
                c = 65535;
                break;
            case 1284575460:
                if (str.equals("oxygen_saturation_min")) {
                    c = '?';
                    break;
                }
                c = 65535;
                break;
            case 1403812644:
                if (str.equals("blood_pressure_diastolic_max")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case 1403812882:
                if (str.equals("blood_pressure_diastolic_min")) {
                    c = 12;
                    break;
                }
                c = 65535;
                break;
            case 1527920799:
                if (str.equals("sensor_type")) {
                    c = 'D';
                    break;
                }
                c = 65535;
                break;
            case 1708915229:
                if (str.equals("timestamps")) {
                    c = 'B';
                    break;
                }
                c = 65535;
                break;
            case 1857734768:
                if (str.equals("elevation.gain")) {
                    c = Typography.quote;
                    break;
                }
                c = 65535;
                break;
            case 1857897492:
                if (str.equals("elevation.loss")) {
                    c = '#';
                    break;
                }
                c = 65535;
                break;
            case 1863800889:
                if (str.equals("resistance")) {
                    c = 'N';
                    break;
                }
                c = 65535;
                break;
            case 1880897007:
                if (str.equals("oxygen_therapy_administration_mode")) {
                    c = 'A';
                    break;
                }
                c = 65535;
                break;
            case 1892583496:
                if (str.equals("menstrual_flow")) {
                    c = '3';
                    break;
                }
                c = 65535;
                break;
            case 1958191058:
                if (str.equals("supplemental_oxygen_flow_rate_max")) {
                    c = 'I';
                    break;
                }
                c = 65535;
                break;
            case 1958191296:
                if (str.equals("supplemental_oxygen_flow_rate_min")) {
                    c = 'J';
                    break;
                }
                c = 65535;
                break;
            case 1983072038:
                if (str.equals("body_position")) {
                    c = 18;
                    break;
                }
                c = 65535;
                break;
            case 2020153105:
                if (str.equals("blood_pressure_systolic_average")) {
                    c = 15;
                    break;
                }
                c = 65535;
                break;
            case 2036550306:
                if (str.equals("altitude")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 2056323544:
                if (str.equals("exercise")) {
                    c = Typography.dollar;
                    break;
                }
                c = 65535;
                break;
            case 2072582505:
                if (str.equals("cervical_firmness")) {
                    c = 24;
                    break;
                }
                c = 65535;
                break;
            case 2078370221:
                if (str.equals("supplemental_oxygen_flow_rate")) {
                    c = 'G';
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                return FIELD_ACCURACY;
            case 1:
                return FIELD_ACTIVITY;
            case 2:
                return FIELD_ACTIVITY_CONFIDENCE;
            case 3:
                return zzki;
            case 4:
                return zzkj;
            case 5:
                return FIELD_ALTITUDE;
            case 6:
                return FIELD_AVERAGE;
            case 7:
                return HealthFields.FIELD_BLOOD_GLUCOSE_LEVEL;
            case 8:
                return HealthFields.FIELD_BLOOD_GLUCOSE_SPECIMEN_SOURCE;
            case 9:
                return HealthFields.FIELD_BLOOD_PRESSURE_DIASTOLIC;
            case 10:
                return HealthFields.FIELD_BLOOD_PRESSURE_DIASTOLIC_AVERAGE;
            case 11:
                return HealthFields.FIELD_BLOOD_PRESSURE_DIASTOLIC_MAX;
            case 12:
                return HealthFields.FIELD_BLOOD_PRESSURE_DIASTOLIC_MIN;
            case 13:
                return HealthFields.FIELD_BLOOD_PRESSURE_MEASUREMENT_LOCATION;
            case 14:
                return HealthFields.FIELD_BLOOD_PRESSURE_SYSTOLIC;
            case 15:
                return HealthFields.FIELD_BLOOD_PRESSURE_SYSTOLIC_AVERAGE;
            case 16:
                return HealthFields.FIELD_BLOOD_PRESSURE_SYSTOLIC_MAX;
            case 17:
                return HealthFields.FIELD_BLOOD_PRESSURE_SYSTOLIC_MIN;
            case 18:
                return HealthFields.FIELD_BODY_POSITION;
            case 19:
                return HealthFields.FIELD_BODY_TEMPERATURE;
            case 20:
                return HealthFields.FIELD_BODY_TEMPERATURE_MEASUREMENT_LOCATION;
            case 21:
                return FIELD_BPM;
            case 22:
                return FIELD_CALORIES;
            case 23:
                return HealthFields.FIELD_CERVICAL_DILATION;
            case 24:
                return HealthFields.FIELD_CERVICAL_FIRMNESS;
            case 25:
                return HealthFields.FIELD_CERVICAL_MUCUS_AMOUNT;
            case 26:
                return HealthFields.FIELD_CERVICAL_MUCUS_TEXTURE;
            case 27:
                return HealthFields.FIELD_CERVICAL_POSITION;
            case 28:
                return FIELD_CIRCUMFERENCE;
            case 29:
                return FIELD_CONFIDENCE;
            case 30:
                return zzkn;
            case 31:
                return FIELD_DISTANCE;
            case ' ':
                return FIELD_DURATION;
            case '!':
                return zzko;
            case '\"':
                return zzkp;
            case '#':
                return zzkq;
            case '$':
                return FIELD_EXERCISE;
            case '%':
                return zzks;
            case '&':
                return zzkt;
            case '\'':
                return zzkr;
            case '(':
                return FIELD_FOOD_ITEM;
            case ')':
                return FIELD_HEIGHT;
            case '*':
                return FIELD_INTENSITY;
            case '+':
                return FIELD_HIGH_LATITUDE;
            case ',':
                return FIELD_HIGH_LONGITUDE;
            case '-':
                return FIELD_LATITUDE;
            case '.':
                return FIELD_LONGITUDE;
            case '/':
                return FIELD_LOW_LATITUDE;
            case '0':
                return FIELD_LOW_LONGITUDE;
            case '1':
                return FIELD_MAX;
            case '2':
                return FIELD_MEAL_TYPE;
            case '3':
                return HealthFields.FIELD_MENSTRUAL_FLOW;
            case '4':
                return FIELD_MIN;
            case '5':
                return zzkz;
            case '6':
                return zzky;
            case '7':
                return FIELD_NUM_SEGMENTS;
            case '8':
                return FIELD_NUTRIENTS;
            case '9':
                return FIELD_OCCURRENCES;
            case ':':
                return HealthFields.FIELD_OVULATION_TEST_RESULT;
            case ';':
                return HealthFields.FIELD_OXYGEN_SATURATION;
            case '<':
                return HealthFields.FIELD_OXYGEN_SATURATION_AVERAGE;
            case '=':
                return HealthFields.FIELD_OXYGEN_SATURATION_MAX;
            case '>':
                return HealthFields.FIELD_OXYGEN_SATURATION_MEASUREMENT_METHOD;
            case '?':
                return HealthFields.FIELD_OXYGEN_SATURATION_MIN;
            case '@':
                return HealthFields.FIELD_OXYGEN_SATURATION_SYSTEM;
            case 'A':
                return HealthFields.FIELD_OXYGEN_THERAPY_ADMINISTRATION_MODE;
            case 'B':
                return zzkw;
            case 'C':
                return zzkx;
            case 'D':
                return zzku;
            case 'E':
                return zzkv;
            case 'F':
                return zzla;
            case 'G':
                return HealthFields.FIELD_SUPPLEMENTAL_OXYGEN_FLOW_RATE;
            case 'H':
                return HealthFields.FIELD_SUPPLEMENTAL_OXYGEN_FLOW_RATE_AVERAGE;
            case 'I':
                return HealthFields.FIELD_SUPPLEMENTAL_OXYGEN_FLOW_RATE_MAX;
            case 'J':
                return HealthFields.FIELD_SUPPLEMENTAL_OXYGEN_FLOW_RATE_MIN;
            case 'K':
                return zzkl;
            case 'L':
                return FIELD_PERCENTAGE;
            case 'M':
                return FIELD_REPETITIONS;
            case 'N':
                return FIELD_RESISTANCE;
            case 'O':
                return FIELD_RESISTANCE_TYPE;
            case 'P':
                return FIELD_REVOLUTIONS;
            case 'Q':
                return FIELD_RPM;
            case 'R':
                return FIELD_SPEED;
            case 'S':
                return FIELD_STEPS;
            case 'T':
                return FIELD_STEP_LENGTH;
            case 'U':
                return zzkk;
            case 'V':
                return zzkm;
            case 'W':
                return HealthFields.FIELD_TEMPORAL_RELATION_TO_MEAL;
            case 'X':
                return HealthFields.FIELD_TEMPORAL_RELATION_TO_SLEEP;
            case 'Y':
                return FIELD_VOLUME;
            case 'Z':
                return FIELD_WATTS;
            case '[':
                return FIELD_WEIGHT;
            case '\\':
                return zza.zzld;
            case ']':
                return zza.zzle;
            case '^':
                return zza.zzlf;
            case '_':
                return zza.zzlg;
            case '`':
                return zza.zzlh;
            case 'a':
                return zzlb;
            default:
                return new Field(str, i, null);
        }
    }

    private static Field zzc(String str) {
        return new Field(str, 1);
    }

    public static Field zzd(String str) {
        return new Field(str, 1, true);
    }

    public static Field zze(String str) {
        return new Field(str, 2);
    }

    private static Field zzf(String str) {
        return new Field(str, 2, true);
    }

    private static Field zzg(String str) {
        return new Field(str, 4);
    }

    public static Field zzh(String str) {
        return new Field(str, 7);
    }

    public static Field zzi(String str) {
        return new Field(str, 7, true);
    }

    private Field(String str, int i) {
        this(str, i, null);
    }

    Field(String str, int i, Boolean bool) {
        this.name = (String) Preconditions.checkNotNull(str);
        this.format = i;
        this.zzlc = bool;
    }

    public final String getName() {
        return this.name;
    }

    public final int getFormat() {
        return this.format;
    }

    public final Boolean isOptional() {
        return this.zzlc;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Field)) {
            return false;
        }
        Field field = (Field) obj;
        return this.name.equals(field.name) && this.format == field.format;
    }

    public final int hashCode() {
        return this.name.hashCode();
    }

    public final String toString() {
        Object[] objArr = new Object[2];
        objArr[0] = this.name;
        objArr[1] = this.format == 1 ? "i" : "f";
        return String.format("%s(%s)", objArr);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getName(), false);
        SafeParcelWriter.writeInt(parcel, 2, getFormat());
        SafeParcelWriter.writeBooleanObject(parcel, 3, isOptional(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
