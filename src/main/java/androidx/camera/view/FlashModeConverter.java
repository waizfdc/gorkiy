package androidx.camera.view;

final class FlashModeConverter {
    private FlashModeConverter() {
    }

    public static int valueOf(String str) {
        if (str != null) {
            char c = 65535;
            int hashCode = str.hashCode();
            if (hashCode != 2527) {
                if (hashCode != 78159) {
                    if (hashCode == 2020783 && str.equals("AUTO")) {
                        c = 0;
                    }
                } else if (str.equals("OFF")) {
                    c = 2;
                }
            } else if (str.equals("ON")) {
                c = 1;
            }
            if (c == 0) {
                return 0;
            }
            if (c == 1) {
                return 1;
            }
            if (c == 2) {
                return 2;
            }
            throw new IllegalArgumentException("Unknown flash mode name " + str);
        }
        throw new NullPointerException("name cannot be null");
    }

    public static String nameOf(int i) {
        if (i == 0) {
            return "AUTO";
        }
        if (i == 1) {
            return "ON";
        }
        if (i == 2) {
            return "OFF";
        }
        throw new IllegalArgumentException("Unknown flash mode " + i);
    }
}
