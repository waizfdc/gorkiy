package androidx.camera.core.impl;

public class LensFacingConverter {
    private LensFacingConverter() {
    }

    public static Integer[] values() {
        return new Integer[]{0, 1};
    }

    public static int valueOf(String str) {
        if (str != null) {
            char c = 65535;
            int hashCode = str.hashCode();
            if (hashCode != 2030823) {
                if (hashCode == 67167753 && str.equals("FRONT")) {
                    c = 0;
                }
            } else if (str.equals("BACK")) {
                c = 1;
            }
            if (c == 0) {
                return 0;
            }
            if (c == 1) {
                return 1;
            }
            throw new IllegalArgumentException("Unknown len facing name " + str);
        }
        throw new NullPointerException("name cannot be null");
    }

    public static String nameOf(int i) {
        if (i == 0) {
            return "FRONT";
        }
        if (i == 1) {
            return "BACK";
        }
        throw new IllegalArgumentException("Unknown lens facing " + i);
    }
}
