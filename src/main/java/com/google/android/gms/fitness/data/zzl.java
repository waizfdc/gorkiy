package com.google.android.gms.fitness.data;

import com.google.android.gms.fitness.data.DataType;
import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public final class zzl {
    private static final DataType[] zzjy = {DataType.zzjq, DataType.TYPE_WORKOUT_EXERCISE, DataType.TYPE_MOVE_MINUTES, DataType.TYPE_ACTIVITY_SAMPLES, DataType.TYPE_ACTIVITY_SEGMENT, DataType.AGGREGATE_ACTIVITY_SUMMARY, HealthDataTypes.TYPE_BASAL_BODY_TEMPERATURE, HealthDataTypes.AGGREGATE_BASAL_BODY_TEMPERATURE_SUMMARY, HealthDataTypes.TYPE_BLOOD_GLUCOSE, HealthDataTypes.AGGREGATE_BLOOD_GLUCOSE_SUMMARY, HealthDataTypes.TYPE_BLOOD_PRESSURE, HealthDataTypes.AGGREGATE_BLOOD_PRESSURE_SUMMARY, DataType.TYPE_BODY_FAT_PERCENTAGE, DataType.AGGREGATE_BODY_FAT_PERCENTAGE_SUMMARY, HealthDataTypes.TYPE_BODY_TEMPERATURE, HealthDataTypes.AGGREGATE_BODY_TEMPERATURE_SUMMARY, DataType.TYPE_BASAL_METABOLIC_RATE, DataType.AGGREGATE_BASAL_METABOLIC_RATE_SUMMARY, DataType.TYPE_CALORIES_EXPENDED, HealthDataTypes.TYPE_CERVICAL_MUCUS, HealthDataTypes.TYPE_CERVICAL_POSITION, DataType.TYPE_CYCLING_PEDALING_CADENCE, DataType.TYPE_CYCLING_PEDALING_CUMULATIVE, DataType.TYPE_CYCLING_WHEEL_REVOLUTION, DataType.TYPE_CYCLING_WHEEL_RPM, DataType.TYPE_DISTANCE_CUMULATIVE, DataType.TYPE_DISTANCE_DELTA, DataType.zzjp, DataType.zzju, DataType.zzjm, DataType.zzjn, DataType.TYPE_HEART_POINTS, DataType.AGGREGATE_HEART_POINTS, DataType.TYPE_HEART_RATE_BPM, DataType.AGGREGATE_HEART_RATE_SUMMARY, DataType.TYPE_HEIGHT, DataType.AGGREGATE_HEIGHT_SUMMARY, DataType.AGGREGATE_LOCATION_BOUNDING_BOX, DataType.TYPE_LOCATION_SAMPLE, DataType.TYPE_LOCATION_TRACK, HealthDataTypes.TYPE_MENSTRUATION, DataType.TYPE_NUTRITION, DataType.TYPE_HYDRATION, DataType.AGGREGATE_NUTRITION_SUMMARY, HealthDataTypes.TYPE_OVULATION_TEST, HealthDataTypes.TYPE_OXYGEN_SATURATION, HealthDataTypes.AGGREGATE_OXYGEN_SATURATION_SUMMARY, DataType.TYPE_POWER_SAMPLE, DataType.AGGREGATE_POWER_SUMMARY, DataType.zzjr, DataType.TYPE_SPEED, DataType.AGGREGATE_SPEED_SUMMARY, DataType.TYPE_STEP_COUNT_CADENCE, DataType.zzjo, DataType.TYPE_STEP_COUNT_CUMULATIVE, DataType.TYPE_STEP_COUNT_DELTA, HealthDataTypes.TYPE_VAGINAL_SPOTTING, DataType.TYPE_WEIGHT, DataType.AGGREGATE_WEIGHT_SUMMARY, DataType.zzjs, DataType.zzjt};
    private static final DataType[] zzjz = {HealthDataTypes.TYPE_BASAL_BODY_TEMPERATURE, HealthDataTypes.AGGREGATE_BASAL_BODY_TEMPERATURE_SUMMARY, HealthDataTypes.TYPE_BLOOD_GLUCOSE, HealthDataTypes.AGGREGATE_BLOOD_GLUCOSE_SUMMARY, HealthDataTypes.TYPE_BLOOD_PRESSURE, HealthDataTypes.AGGREGATE_BLOOD_PRESSURE_SUMMARY, HealthDataTypes.TYPE_BODY_TEMPERATURE, HealthDataTypes.AGGREGATE_BODY_TEMPERATURE_SUMMARY, HealthDataTypes.TYPE_CERVICAL_MUCUS, HealthDataTypes.TYPE_CERVICAL_POSITION, HealthDataTypes.TYPE_MENSTRUATION, HealthDataTypes.TYPE_OVULATION_TEST, HealthDataTypes.TYPE_OXYGEN_SATURATION, HealthDataTypes.AGGREGATE_OXYGEN_SATURATION_SUMMARY, HealthDataTypes.TYPE_VAGINAL_SPOTTING};

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static DataType zzb(String str) {
        char c;
        switch (str.hashCode()) {
            case -2060095039:
                if (str.equals("com.google.cycling.wheel_revolution.rpm")) {
                    c = 24;
                    break;
                }
                c = 65535;
                break;
            case -2023954015:
                if (str.equals("com.google.location.bounding_box")) {
                    c = '%';
                    break;
                }
                c = 65535;
                break;
            case -2001464928:
                if (str.equals("com.google.internal.symptom")) {
                    c = 30;
                    break;
                }
                c = 65535;
                break;
            case -1999891138:
                if (str.equals("com.google.heart_minutes")) {
                    c = 31;
                    break;
                }
                c = 65535;
                break;
            case -1939429191:
                if (str.equals("com.google.blood_glucose.summary")) {
                    c = 10;
                    break;
                }
                c = 65535;
                break;
            case -1783842905:
                if (str.equals("com.google.accelerometer")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1757812901:
                if (str.equals("com.google.location.sample")) {
                    c = Typography.amp;
                    break;
                }
                c = 65535;
                break;
            case -1659958877:
                if (str.equals("com.google.menstruation")) {
                    c = '(';
                    break;
                }
                c = 65535;
                break;
            case -1487055015:
                if (str.equals("com.google.body.temperature.basal.summary")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case -1466904157:
                if (str.equals("com.google.floor_change.summary")) {
                    c = 28;
                    break;
                }
                c = 65535;
                break;
            case -1465729060:
                if (str.equals("com.google.internal.primary_device")) {
                    c = Typography.greater;
                    break;
                }
                c = 65535;
                break;
            case -1431431801:
                if (str.equals("com.google.height.summary")) {
                    c = Typography.dollar;
                    break;
                }
                c = 65535;
                break;
            case -1248818137:
                if (str.equals("com.google.distance.delta")) {
                    c = 26;
                    break;
                }
                c = 65535;
                break;
            case -1196687875:
                if (str.equals("com.google.internal.session.v2")) {
                    c = '3';
                    break;
                }
                c = 65535;
                break;
            case -1196687874:
                if (str.equals("com.google.internal.session.v3")) {
                    c = '4';
                    break;
                }
                c = 65535;
                break;
            case -1103712522:
                if (str.equals("com.google.heart_minutes.summary")) {
                    c = ' ';
                    break;
                }
                c = 65535;
                break;
            case -1102520626:
                if (str.equals("com.google.step_count.delta")) {
                    c = '8';
                    break;
                }
                c = 65535;
                break;
            case -1091068721:
                if (str.equals("com.google.height")) {
                    c = '#';
                    break;
                }
                c = 65535;
                break;
            case -922976890:
                if (str.equals("com.google.cycling.pedaling.cumulative")) {
                    c = 22;
                    break;
                }
                c = 65535;
                break;
            case -900592674:
                if (str.equals("com.google.cycling.pedaling.cadence")) {
                    c = 21;
                    break;
                }
                c = 65535;
                break;
            case -886569606:
                if (str.equals("com.google.location.track")) {
                    c = '\'';
                    break;
                }
                c = 65535;
                break;
            case -777285735:
                if (str.equals("com.google.heart_rate.summary")) {
                    c = Typography.quote;
                    break;
                }
                c = 65535;
                break;
            case -700668164:
                if (str.equals("com.google.internal.goal")) {
                    c = 29;
                    break;
                }
                c = 65535;
                break;
            case -661631456:
                if (str.equals("com.google.weight")) {
                    c = ';';
                    break;
                }
                c = 65535;
                break;
            case -424876584:
                if (str.equals("com.google.weight.summary")) {
                    c = Typography.less;
                    break;
                }
                c = 65535;
                break;
            case -362418992:
                if (str.equals("com.google.body.temperature")) {
                    c = 14;
                    break;
                }
                c = 65535;
                break;
            case -217611775:
                if (str.equals("com.google.blood_glucose")) {
                    c = 9;
                    break;
                }
                c = 65535;
                break;
            case -185830635:
                if (str.equals("com.google.power.summary")) {
                    c = '0';
                    break;
                }
                c = 65535;
                break;
            case -177293656:
                if (str.equals("com.google.nutrition.summary")) {
                    c = '+';
                    break;
                }
                c = 65535;
                break;
            case -164586193:
                if (str.equals("com.google.activity.exercise")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -98150574:
                if (str.equals("com.google.heart_rate.bpm")) {
                    c = '!';
                    break;
                }
                c = 65535;
                break;
            case -56824761:
                if (str.equals("com.google.calories.bmr")) {
                    c = 16;
                    break;
                }
                c = 65535;
                break;
            case 53773386:
                if (str.equals("com.google.blood_pressure.summary")) {
                    c = 12;
                    break;
                }
                c = 65535;
                break;
            case 269180370:
                if (str.equals("com.google.activity.samples")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 295793957:
                if (str.equals("com.google.sensor.events")) {
                    c = '1';
                    break;
                }
                c = 65535;
                break;
            case 296250623:
                if (str.equals("com.google.calories.bmr.summary")) {
                    c = 17;
                    break;
                }
                c = 65535;
                break;
            case 324760871:
                if (str.equals("com.google.step_count.cadence")) {
                    c = '6';
                    break;
                }
                c = 65535;
                break;
            case 378060028:
                if (str.equals("com.google.activity.segment")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 529727579:
                if (str.equals("com.google.power.sample")) {
                    c = '/';
                    break;
                }
                c = 65535;
                break;
            case 657433501:
                if (str.equals("com.google.step_count.cumulative")) {
                    c = '7';
                    break;
                }
                c = 65535;
                break;
            case 682891187:
                if (str.equals("com.google.body.fat.percentage")) {
                    c = 8;
                    break;
                }
                c = 65535;
                break;
            case 841663855:
                if (str.equals("com.google.activity.summary")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 877955159:
                if (str.equals("com.google.speed.summary")) {
                    c = '5';
                    break;
                }
                c = 65535;
                break;
            case 899666941:
                if (str.equals("com.google.calories.expended")) {
                    c = 18;
                    break;
                }
                c = 65535;
                break;
            case 936279698:
                if (str.equals("com.google.blood_pressure")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case 946706510:
                if (str.equals("com.google.hydration")) {
                    c = '*';
                    break;
                }
                c = 65535;
                break;
            case 946938859:
                if (str.equals("com.google.stride_model")) {
                    c = '9';
                    break;
                }
                c = 65535;
                break;
            case 1029221057:
                if (str.equals("com.google.device_on_body")) {
                    c = '=';
                    break;
                }
                c = 65535;
                break;
            case 1098265835:
                if (str.equals("com.google.floor_change")) {
                    c = 27;
                    break;
                }
                c = 65535;
                break;
            case 1111714923:
                if (str.equals("com.google.body.fat.percentage.summary")) {
                    c = 13;
                    break;
                }
                c = 65535;
                break;
            case 1214093899:
                if (str.equals("com.google.vaginal_spotting")) {
                    c = ':';
                    break;
                }
                c = 65535;
                break;
            case 1404118825:
                if (str.equals("com.google.oxygen_saturation")) {
                    c = '-';
                    break;
                }
                c = 65535;
                break;
            case 1439932546:
                if (str.equals("com.google.ovulation_test")) {
                    c = ',';
                    break;
                }
                c = 65535;
                break;
            case 1483133089:
                if (str.equals("com.google.body.temperature.basal")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 1524007137:
                if (str.equals("com.google.cycling.wheel_revolution.cumulative")) {
                    c = 23;
                    break;
                }
                c = 65535;
                break;
            case 1532018766:
                if (str.equals("com.google.active_minutes")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 1633152752:
                if (str.equals("com.google.nutrition")) {
                    c = ')';
                    break;
                }
                c = 65535;
                break;
            case 1921738212:
                if (str.equals("com.google.distance.cumulative")) {
                    c = 25;
                    break;
                }
                c = 65535;
                break;
            case 1925848149:
                if (str.equals("com.google.cervical_position")) {
                    c = 20;
                    break;
                }
                c = 65535;
                break;
            case 1975902189:
                if (str.equals("com.google.cervical_mucus")) {
                    c = 19;
                    break;
                }
                c = 65535;
                break;
            case 2051843553:
                if (str.equals("com.google.oxygen_saturation.summary")) {
                    c = '.';
                    break;
                }
                c = 65535;
                break;
            case 2053496735:
                if (str.equals("com.google.speed")) {
                    c = '2';
                    break;
                }
                c = 65535;
                break;
            case 2131809416:
                if (str.equals("com.google.body.temperature.summary")) {
                    c = 15;
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
                return DataType.zzjq;
            case 1:
                return DataType.TYPE_MOVE_MINUTES;
            case 2:
                return DataType.TYPE_WORKOUT_EXERCISE;
            case 3:
                return DataType.TYPE_ACTIVITY_SAMPLES;
            case 4:
                return DataType.TYPE_ACTIVITY_SEGMENT;
            case 5:
                return DataType.AGGREGATE_ACTIVITY_SUMMARY;
            case 6:
                return HealthDataTypes.TYPE_BASAL_BODY_TEMPERATURE;
            case 7:
                return HealthDataTypes.AGGREGATE_BASAL_BODY_TEMPERATURE_SUMMARY;
            case 8:
                return DataType.TYPE_BODY_FAT_PERCENTAGE;
            case 9:
                return HealthDataTypes.TYPE_BLOOD_GLUCOSE;
            case 10:
                return HealthDataTypes.AGGREGATE_BLOOD_GLUCOSE_SUMMARY;
            case 11:
                return HealthDataTypes.TYPE_BLOOD_PRESSURE;
            case 12:
                return HealthDataTypes.AGGREGATE_BLOOD_PRESSURE_SUMMARY;
            case 13:
                return DataType.AGGREGATE_BODY_FAT_PERCENTAGE_SUMMARY;
            case 14:
                return HealthDataTypes.TYPE_BODY_TEMPERATURE;
            case 15:
                return HealthDataTypes.AGGREGATE_BODY_TEMPERATURE_SUMMARY;
            case 16:
                return DataType.TYPE_BASAL_METABOLIC_RATE;
            case 17:
                return DataType.AGGREGATE_BASAL_METABOLIC_RATE_SUMMARY;
            case 18:
                return DataType.TYPE_CALORIES_EXPENDED;
            case 19:
                return HealthDataTypes.TYPE_CERVICAL_MUCUS;
            case 20:
                return HealthDataTypes.TYPE_CERVICAL_POSITION;
            case 21:
                return DataType.TYPE_CYCLING_PEDALING_CADENCE;
            case 22:
                return DataType.TYPE_CYCLING_PEDALING_CUMULATIVE;
            case 23:
                return DataType.TYPE_CYCLING_WHEEL_REVOLUTION;
            case 24:
                return DataType.TYPE_CYCLING_WHEEL_RPM;
            case 25:
                return DataType.TYPE_DISTANCE_CUMULATIVE;
            case 26:
                return DataType.TYPE_DISTANCE_DELTA;
            case 27:
                return DataType.zzjp;
            case 28:
                return DataType.zzju;
            case 29:
                return DataType.zzjm;
            case 30:
                return DataType.zzjn;
            case 31:
                return DataType.TYPE_HEART_POINTS;
            case ' ':
                return DataType.AGGREGATE_HEART_POINTS;
            case '!':
                return DataType.TYPE_HEART_RATE_BPM;
            case '\"':
                return DataType.AGGREGATE_HEART_RATE_SUMMARY;
            case '#':
                return DataType.TYPE_HEIGHT;
            case '$':
                return DataType.AGGREGATE_HEIGHT_SUMMARY;
            case '%':
                return DataType.AGGREGATE_LOCATION_BOUNDING_BOX;
            case '&':
                return DataType.TYPE_LOCATION_SAMPLE;
            case '\'':
                return DataType.TYPE_LOCATION_TRACK;
            case '(':
                return HealthDataTypes.TYPE_MENSTRUATION;
            case ')':
                return DataType.TYPE_NUTRITION;
            case '*':
                return DataType.TYPE_HYDRATION;
            case '+':
                return DataType.AGGREGATE_NUTRITION_SUMMARY;
            case ',':
                return HealthDataTypes.TYPE_OVULATION_TEST;
            case '-':
                return HealthDataTypes.TYPE_OXYGEN_SATURATION;
            case '.':
                return HealthDataTypes.AGGREGATE_OXYGEN_SATURATION_SUMMARY;
            case '/':
                return DataType.TYPE_POWER_SAMPLE;
            case '0':
                return DataType.AGGREGATE_POWER_SUMMARY;
            case '1':
                return DataType.zzjr;
            case '2':
                return DataType.TYPE_SPEED;
            case '3':
                return DataType.zza.zzjk;
            case '4':
                return DataType.zza.zzjl;
            case '5':
                return DataType.AGGREGATE_SPEED_SUMMARY;
            case '6':
                return DataType.TYPE_STEP_COUNT_CADENCE;
            case '7':
                return DataType.TYPE_STEP_COUNT_CUMULATIVE;
            case '8':
                return DataType.TYPE_STEP_COUNT_DELTA;
            case '9':
                return DataType.zzjo;
            case ':':
                return HealthDataTypes.TYPE_VAGINAL_SPOTTING;
            case ';':
                return DataType.TYPE_WEIGHT;
            case '<':
                return DataType.AGGREGATE_WEIGHT_SUMMARY;
            case '=':
                return DataType.zzjs;
            case '>':
                return DataType.zzjt;
            default:
                return null;
        }
    }
}
