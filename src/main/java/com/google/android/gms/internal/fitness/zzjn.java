package com.google.android.gms.internal.fitness;

import com.google.android.gms.fitness.FitnessActivities;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public final class zzjn {
    private static final String[] zzabk;

    public static int zzp(String str) {
        int i = 0;
        while (true) {
            String[] strArr = zzabk;
            if (i >= strArr.length) {
                return 4;
            }
            if (strArr[i].equals(str)) {
                return i;
            }
            i++;
        }
    }

    public static String getName(int i) {
        String str;
        if (i >= 0) {
            String[] strArr = zzabk;
            if (i < strArr.length && (str = strArr[i]) != null) {
                return str;
            }
            return "unknown";
        }
        return "unknown";
    }

    public static String getMimeType(String str) {
        String valueOf = String.valueOf(str);
        return valueOf.length() != 0 ? FitnessActivities.MIME_TYPE_PREFIX.concat(valueOf) : new String(FitnessActivities.MIME_TYPE_PREFIX);
    }

    static {
        String[] strArr = new String[123];
        zzabk = strArr;
        strArr[9] = FitnessActivities.AEROBICS;
        strArr[119] = FitnessActivities.ARCHERY;
        strArr[10] = FitnessActivities.BADMINTON;
        strArr[11] = FitnessActivities.BASEBALL;
        strArr[12] = FitnessActivities.BASKETBALL;
        strArr[13] = FitnessActivities.BIATHLON;
        strArr[1] = FitnessActivities.BIKING;
        strArr[14] = FitnessActivities.BIKING_HAND;
        strArr[15] = FitnessActivities.BIKING_MOUNTAIN;
        strArr[16] = FitnessActivities.BIKING_ROAD;
        strArr[17] = FitnessActivities.BIKING_SPINNING;
        strArr[18] = FitnessActivities.BIKING_STATIONARY;
        strArr[19] = FitnessActivities.BIKING_UTILITY;
        strArr[20] = FitnessActivities.BOXING;
        strArr[21] = FitnessActivities.CALISTHENICS;
        strArr[22] = FitnessActivities.CIRCUIT_TRAINING;
        strArr[23] = FitnessActivities.CRICKET;
        strArr[113] = FitnessActivities.CROSSFIT;
        strArr[106] = FitnessActivities.CURLING;
        strArr[24] = FitnessActivities.DANCING;
        strArr[102] = FitnessActivities.DIVING;
        strArr[117] = FitnessActivities.ELEVATOR;
        strArr[25] = FitnessActivities.ELLIPTICAL;
        strArr[103] = FitnessActivities.ERGOMETER;
        strArr[118] = FitnessActivities.ESCALATOR;
        strArr[6] = "exiting_vehicle";
        strArr[26] = FitnessActivities.FENCING;
        strArr[121] = "flossing";
        strArr[27] = FitnessActivities.FOOTBALL_AMERICAN;
        strArr[28] = FitnessActivities.FOOTBALL_AUSTRALIAN;
        strArr[29] = FitnessActivities.FOOTBALL_SOCCER;
        strArr[30] = FitnessActivities.FRISBEE_DISC;
        strArr[31] = FitnessActivities.GARDENING;
        strArr[32] = FitnessActivities.GOLF;
        strArr[122] = "guided_breathing";
        strArr[33] = FitnessActivities.GYMNASTICS;
        strArr[34] = FitnessActivities.HANDBALL;
        strArr[114] = FitnessActivities.HIGH_INTENSITY_INTERVAL_TRAINING;
        strArr[35] = FitnessActivities.HIKING;
        strArr[36] = FitnessActivities.HOCKEY;
        strArr[37] = FitnessActivities.HORSEBACK_RIDING;
        strArr[38] = FitnessActivities.HOUSEWORK;
        strArr[104] = FitnessActivities.ICE_SKATING;
        strArr[0] = FitnessActivities.IN_VEHICLE;
        strArr[115] = FitnessActivities.INTERVAL_TRAINING;
        strArr[39] = FitnessActivities.JUMP_ROPE;
        strArr[40] = FitnessActivities.KAYAKING;
        strArr[41] = FitnessActivities.KETTLEBELL_TRAINING;
        strArr[107] = FitnessActivities.KICK_SCOOTER;
        strArr[42] = FitnessActivities.KICKBOXING;
        strArr[43] = FitnessActivities.KITESURFING;
        strArr[44] = FitnessActivities.MARTIAL_ARTS;
        strArr[45] = FitnessActivities.MEDITATION;
        strArr[46] = FitnessActivities.MIXED_MARTIAL_ARTS;
        strArr[2] = FitnessActivities.ON_FOOT;
        strArr[108] = FitnessActivities.OTHER;
        strArr[47] = FitnessActivities.P90X;
        strArr[48] = FitnessActivities.PARAGLIDING;
        strArr[49] = FitnessActivities.PILATES;
        strArr[50] = FitnessActivities.POLO;
        strArr[51] = FitnessActivities.RACQUETBALL;
        strArr[52] = FitnessActivities.ROCK_CLIMBING;
        strArr[53] = FitnessActivities.ROWING;
        strArr[54] = FitnessActivities.ROWING_MACHINE;
        strArr[55] = FitnessActivities.RUGBY;
        strArr[8] = FitnessActivities.RUNNING;
        strArr[56] = FitnessActivities.RUNNING_JOGGING;
        strArr[57] = FitnessActivities.RUNNING_SAND;
        strArr[58] = FitnessActivities.RUNNING_TREADMILL;
        strArr[59] = FitnessActivities.SAILING;
        strArr[60] = FitnessActivities.SCUBA_DIVING;
        strArr[61] = FitnessActivities.SKATEBOARDING;
        strArr[62] = FitnessActivities.SKATING;
        strArr[63] = FitnessActivities.SKATING_CROSS;
        strArr[105] = FitnessActivities.SKATING_INDOOR;
        strArr[64] = FitnessActivities.SKATING_INLINE;
        strArr[65] = FitnessActivities.SKIING;
        strArr[66] = FitnessActivities.SKIING_BACK_COUNTRY;
        strArr[67] = FitnessActivities.SKIING_CROSS_COUNTRY;
        strArr[68] = FitnessActivities.SKIING_DOWNHILL;
        strArr[69] = FitnessActivities.SKIING_KITE;
        strArr[70] = FitnessActivities.SKIING_ROLLER;
        strArr[71] = FitnessActivities.SLEDDING;
        strArr[72] = FitnessActivities.SLEEP;
        strArr[109] = FitnessActivities.SLEEP_LIGHT;
        strArr[110] = FitnessActivities.SLEEP_DEEP;
        strArr[111] = FitnessActivities.SLEEP_REM;
        strArr[112] = FitnessActivities.SLEEP_AWAKE;
        strArr[73] = FitnessActivities.SNOWBOARDING;
        strArr[74] = FitnessActivities.SNOWMOBILE;
        strArr[75] = FitnessActivities.SNOWSHOEING;
        strArr[120] = FitnessActivities.SOFTBALL;
        strArr[76] = FitnessActivities.SQUASH;
        strArr[77] = FitnessActivities.STAIR_CLIMBING;
        strArr[78] = FitnessActivities.STAIR_CLIMBING_MACHINE;
        strArr[79] = FitnessActivities.STANDUP_PADDLEBOARDING;
        strArr[3] = FitnessActivities.STILL;
        strArr[80] = FitnessActivities.STRENGTH_TRAINING;
        strArr[81] = FitnessActivities.SURFING;
        strArr[82] = FitnessActivities.SWIMMING;
        strArr[83] = FitnessActivities.SWIMMING_POOL;
        strArr[84] = FitnessActivities.SWIMMING_OPEN_WATER;
        strArr[85] = FitnessActivities.TABLE_TENNIS;
        strArr[86] = FitnessActivities.TEAM_SPORTS;
        strArr[87] = FitnessActivities.TENNIS;
        strArr[5] = FitnessActivities.TILTING;
        strArr[88] = FitnessActivities.TREADMILL;
        strArr[4] = "unknown";
        strArr[89] = FitnessActivities.VOLLEYBALL;
        strArr[90] = FitnessActivities.VOLLEYBALL_BEACH;
        strArr[91] = FitnessActivities.VOLLEYBALL_INDOOR;
        strArr[92] = FitnessActivities.WAKEBOARDING;
        strArr[7] = FitnessActivities.WALKING;
        strArr[93] = FitnessActivities.WALKING_FITNESS;
        strArr[94] = FitnessActivities.WALKING_NORDIC;
        strArr[95] = FitnessActivities.WALKING_TREADMILL;
        strArr[116] = FitnessActivities.WALKING_STROLLER;
        strArr[96] = FitnessActivities.WATER_POLO;
        strArr[97] = FitnessActivities.WEIGHTLIFTING;
        strArr[98] = FitnessActivities.WHEELCHAIR;
        strArr[99] = FitnessActivities.WINDSURFING;
        strArr[100] = FitnessActivities.YOGA;
        strArr[101] = FitnessActivities.ZUMBA;
    }
}
