package androidx.camera.camera2.internal;

import androidx.camera.core.ImageCapture;
import androidx.camera.core.UseCase;
import androidx.camera.core.VideoCapture;
import java.util.List;

final class UseCaseSurfaceOccupancyManager {
    private UseCaseSurfaceOccupancyManager() {
    }

    static void checkUseCaseLimitNotExceeded(List<UseCase> list, List<UseCase> list2) {
        int i;
        if (list2 == null || list2.isEmpty()) {
            throw new IllegalArgumentException("No new use cases to be bound.");
        }
        int i2 = 0;
        if (list != null) {
            i = 0;
            for (UseCase next : list) {
                if (next instanceof ImageCapture) {
                    i2++;
                } else if (next instanceof VideoCapture) {
                    i++;
                }
            }
        } else {
            i = 0;
        }
        for (UseCase next2 : list2) {
            if (next2 instanceof ImageCapture) {
                i2++;
            } else if (next2 instanceof VideoCapture) {
                i++;
            }
        }
        if (i2 > 1) {
            throw new IllegalArgumentException("Exceeded max simultaneously bound image capture use cases.");
        } else if (i > 1) {
            throw new IllegalArgumentException("Exceeded max simultaneously bound video capture use cases.");
        }
    }
}
