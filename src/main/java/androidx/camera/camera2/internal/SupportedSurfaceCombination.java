package androidx.camera.camera2.internal;

import android.content.Context;
import android.graphics.Point;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.util.Rational;
import android.util.Size;
import android.view.WindowManager;
import androidx.camera.core.CameraX;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.SurfaceCombination;
import androidx.camera.core.impl.SurfaceConfig;
import androidx.camera.core.impl.SurfaceSizeDefinition;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class SupportedSurfaceCombination {
    private static final int ALIGN16 = 16;
    private static final Rational ASPECT_RATIO_16_9 = new Rational(16, 9);
    private static final Rational ASPECT_RATIO_3_4 = new Rational(3, 4);
    private static final Rational ASPECT_RATIO_4_3 = new Rational(4, 3);
    private static final Rational ASPECT_RATIO_9_16 = new Rational(9, 16);
    private static final Size DEFAULT_SIZE = new Size(640, 480);
    private static final Size MAX_PREVIEW_SIZE = new Size(1920, 1080);
    private static final Size QUALITY_1080P_SIZE = new Size(1920, 1080);
    private static final Size QUALITY_2160P_SIZE = new Size(3840, 2160);
    private static final Size QUALITY_480P_SIZE = new Size(720, 480);
    private static final Size QUALITY_720P_SIZE = new Size(1280, 720);
    private static final Size ZERO_SIZE = new Size(0, 0);
    private CamcorderProfileHelper mCamcorderProfileHelper;
    private String mCameraId;
    private CameraCharacteristics mCharacteristics;
    private int mHardwareLevel = 2;
    private boolean mIsBurstCaptureSupported = false;
    private boolean mIsRawSupported = false;
    private final Map<Integer, Size> mMaxSizeCache = new HashMap();
    private final List<SurfaceCombination> mSurfaceCombinations = new ArrayList();
    private SurfaceSizeDefinition mSurfaceSizeDefinition;

    private void checkCustomization() {
    }

    SupportedSurfaceCombination(Context context, String str, CamcorderProfileHelper camcorderProfileHelper) {
        this.mCameraId = str;
        this.mCamcorderProfileHelper = camcorderProfileHelper;
        init(context);
    }

    private SupportedSurfaceCombination() {
    }

    /* access modifiers changed from: package-private */
    public String getCameraId() {
        return this.mCameraId;
    }

    /* access modifiers changed from: package-private */
    public boolean isRawSupported() {
        return this.mIsRawSupported;
    }

    /* access modifiers changed from: package-private */
    public boolean isBurstCaptureSupported() {
        return this.mIsBurstCaptureSupported;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:3:0x000d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean checkSupported(java.util.List<androidx.camera.core.impl.SurfaceConfig> r4) {
        /*
            r3 = this;
            java.util.List<androidx.camera.core.impl.SurfaceCombination> r0 = r3.mSurfaceCombinations
            java.util.Iterator r0 = r0.iterator()
            r1 = 0
        L_0x0007:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0019
            java.lang.Object r1 = r0.next()
            androidx.camera.core.impl.SurfaceCombination r1 = (androidx.camera.core.impl.SurfaceCombination) r1
            boolean r1 = r1.isSupported(r4)
            if (r1 == 0) goto L_0x0007
        L_0x0019:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.internal.SupportedSurfaceCombination.checkSupported(java.util.List):boolean");
    }

    /* access modifiers changed from: package-private */
    public SurfaceConfig transformSurfaceConfig(int i, Size size) {
        SurfaceConfig.ConfigType configType;
        SurfaceConfig.ConfigSize configSize = SurfaceConfig.ConfigSize.NOT_SUPPORT;
        if (getAllOutputSizesByFormat(i) != null) {
            if (i == 35) {
                configType = SurfaceConfig.ConfigType.YUV;
            } else if (i == 256) {
                configType = SurfaceConfig.ConfigType.JPEG;
            } else if (i == 32) {
                configType = SurfaceConfig.ConfigType.RAW;
            } else {
                configType = SurfaceConfig.ConfigType.PRIV;
            }
            Size fetchMaxSize = fetchMaxSize(i);
            if (size.getWidth() * size.getHeight() <= this.mSurfaceSizeDefinition.getAnalysisSize().getWidth() * this.mSurfaceSizeDefinition.getAnalysisSize().getHeight()) {
                configSize = SurfaceConfig.ConfigSize.ANALYSIS;
            } else if (size.getWidth() * size.getHeight() <= this.mSurfaceSizeDefinition.getPreviewSize().getWidth() * this.mSurfaceSizeDefinition.getPreviewSize().getHeight()) {
                configSize = SurfaceConfig.ConfigSize.PREVIEW;
            } else if (size.getWidth() * size.getHeight() <= this.mSurfaceSizeDefinition.getRecordSize().getWidth() * this.mSurfaceSizeDefinition.getRecordSize().getHeight()) {
                configSize = SurfaceConfig.ConfigSize.RECORD;
            } else if (size.getWidth() * size.getHeight() <= fetchMaxSize.getWidth() * fetchMaxSize.getHeight()) {
                configSize = SurfaceConfig.ConfigSize.MAXIMUM;
            }
            return SurfaceConfig.create(configType, configSize);
        }
        throw new IllegalArgumentException("Can not get supported output size for the format: " + i);
    }

    /* access modifiers changed from: package-private */
    public Map<UseCase, Size> getSuggestedResolutions(List<UseCase> list, List<UseCase> list2) {
        HashMap hashMap = new HashMap();
        List<Integer> useCasesPriorityOrder = getUseCasesPriorityOrder(list2);
        ArrayList arrayList = new ArrayList();
        for (Integer intValue : useCasesPriorityOrder) {
            arrayList.add(getSupportedOutputSizes(list2.get(intValue.intValue())));
        }
        Iterator<List<Size>> it = getAllPossibleSizeArrangements(arrayList).iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            List next = it.next();
            ArrayList arrayList2 = new ArrayList();
            if (list != null) {
                for (UseCase next2 : list) {
                    arrayList2.add(transformSurfaceConfig(next2.getImageFormat(), next2.getAttachedSurfaceResolution(next2.getBoundCamera().getCameraInfoInternal().getCameraId())));
                }
            }
            for (int i = 0; i < next.size(); i++) {
                arrayList2.add(transformSurfaceConfig(list2.get(useCasesPriorityOrder.get(i).intValue()).getImageFormat(), (Size) next.get(i)));
            }
            if (checkSupported(arrayList2)) {
                for (UseCase next3 : list2) {
                    hashMap.put(next3, next.get(useCasesPriorityOrder.indexOf(Integer.valueOf(list2.indexOf(next3)))));
                }
            }
        }
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    public boolean requiresCorrectedAspectRatio() {
        return this.mHardwareLevel == 2 && Build.VERSION.SDK_INT == 21;
    }

    /* access modifiers changed from: package-private */
    public Rational getCorrectedAspectRatio(int i) {
        if (this.mHardwareLevel != 2 || Build.VERSION.SDK_INT != 21) {
            return null;
        }
        Size fetchMaxSize = fetchMaxSize(256);
        return rotateAspectRatioByRotation(new Rational(fetchMaxSize.getWidth(), fetchMaxSize.getHeight()), i);
    }

    /* access modifiers changed from: package-private */
    public SurfaceSizeDefinition getSurfaceSizeDefinition() {
        return this.mSurfaceSizeDefinition;
    }

    private Size fetchMaxSize(int i) {
        Size size = this.mMaxSizeCache.get(Integer.valueOf(i));
        if (size != null) {
            return size;
        }
        Size maxOutputSizeByFormat = getMaxOutputSizeByFormat(i);
        this.mMaxSizeCache.put(Integer.valueOf(i), maxOutputSizeByFormat);
        return maxOutputSizeByFormat;
    }

    private List<Integer> getUseCasesPriorityOrder(List<UseCase> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        for (UseCase useCaseConfig : list) {
            int surfaceOccupancyPriority = useCaseConfig.getUseCaseConfig().getSurfaceOccupancyPriority(0);
            if (!arrayList2.contains(Integer.valueOf(surfaceOccupancyPriority))) {
                arrayList2.add(Integer.valueOf(surfaceOccupancyPriority));
            }
        }
        Collections.sort(arrayList2);
        Collections.reverse(arrayList2);
        for (Integer intValue : arrayList2) {
            int intValue2 = intValue.intValue();
            for (UseCase next : list) {
                if (intValue2 == next.getUseCaseConfig().getSurfaceOccupancyPriority(0)) {
                    arrayList.add(Integer.valueOf(list.indexOf(next)));
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public List<Size> getSupportedOutputSizes(UseCase useCase) {
        Rational rational;
        int imageFormat = useCase.getImageFormat();
        Size[] allOutputSizesByFormat = getAllOutputSizesByFormat(imageFormat, useCase);
        ArrayList<Size> arrayList = new ArrayList<>();
        ImageOutputConfig imageOutputConfig = (ImageOutputConfig) useCase.getUseCaseConfig();
        Size maxResolution = imageOutputConfig.getMaxResolution(getMaxOutputSizeByFormat(imageFormat));
        int targetRotation = imageOutputConfig.getTargetRotation(0);
        Arrays.sort(allOutputSizesByFormat, new CompareSizesByArea(true));
        Size targetResolution = imageOutputConfig.getTargetResolution(ZERO_SIZE);
        if (isRotationNeeded(targetRotation)) {
            targetResolution = new Size(targetResolution.getHeight(), targetResolution.getWidth());
        }
        Size size = DEFAULT_SIZE;
        if (!targetResolution.equals(ZERO_SIZE) && getArea(targetResolution) < getArea(DEFAULT_SIZE)) {
            size = targetResolution;
        }
        for (Size size2 : allOutputSizesByFormat) {
            if (getArea(size2) <= getArea(maxResolution) && getArea(size2) >= getArea(size)) {
                arrayList.add(size2);
            }
        }
        if (!arrayList.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            Rational rational2 = null;
            if (imageOutputConfig.hasTargetAspectRatio()) {
                boolean isRotationNeeded = isRotationNeeded(0);
                int targetAspectRatio = imageOutputConfig.getTargetAspectRatio();
                if (targetAspectRatio != 0) {
                    if (targetAspectRatio == 1) {
                        rational = isRotationNeeded ? ASPECT_RATIO_16_9 : ASPECT_RATIO_9_16;
                    }
                } else if (isRotationNeeded) {
                    rational = ASPECT_RATIO_4_3;
                } else {
                    rational = ASPECT_RATIO_3_4;
                }
                rational2 = rational;
            } else {
                rational2 = rotateAspectRatioByRotation(imageOutputConfig.getTargetAspectRatioCustom(null), targetRotation);
            }
            for (Size size3 : arrayList) {
                if (rational2 == null || hasMatchingAspectRatio(size3, rational2)) {
                    if (!arrayList2.contains(size3)) {
                        arrayList2.add(size3);
                    }
                } else if (!arrayList3.contains(size3)) {
                    arrayList3.add(size3);
                }
            }
            if (rational2 != null) {
                Collections.sort(arrayList3, new CompareSizesByDistanceToTargetRatio(Float.valueOf(rational2.floatValue())));
            }
            if (targetResolution.equals(ZERO_SIZE)) {
                targetResolution = imageOutputConfig.getDefaultResolution(ZERO_SIZE);
            }
            if (!targetResolution.equals(ZERO_SIZE)) {
                removeSupportedSizesByTargetSize(arrayList2, targetResolution);
                removeSupportedSizesByTargetSizeAndAspectRatio(arrayList3, targetResolution);
            }
            ArrayList arrayList4 = new ArrayList();
            arrayList4.addAll(arrayList2);
            arrayList4.addAll(arrayList3);
            return arrayList4;
        }
        throw new IllegalArgumentException("Can not get supported output size under supported maximum for the format: " + imageFormat);
    }

    private Rational rotateAspectRatioByRotation(Rational rational, int i) {
        return (rational == null || !isRotationNeeded(i)) ? rational : new Rational(rational.getDenominator(), rational.getNumerator());
    }

    private boolean isRotationNeeded(int i) {
        int sensorRotationDegrees = CameraX.getCameraInfo(this.mCameraId).getSensorRotationDegrees(i);
        return sensorRotationDegrees == 90 || sensorRotationDegrees == 270;
    }

    static boolean hasMatchingAspectRatio(Size size, Rational rational) {
        if (rational == null) {
            return false;
        }
        if (rational.equals(new Rational(size.getWidth(), size.getHeight()))) {
            return true;
        }
        return isPossibleMod16FromAspectRatio(size, rational);
    }

    private static boolean isPossibleMod16FromAspectRatio(Size size, Rational rational) {
        int width = size.getWidth();
        int height = size.getHeight();
        Rational rational2 = new Rational(rational.getDenominator(), rational.getNumerator());
        int i = width % 16;
        if (i == 0 && height % 16 == 0) {
            if (ratioIntersectsMod16Segment(Math.max(0, height - 16), width, rational) || ratioIntersectsMod16Segment(Math.max(0, width - 16), height, rational2)) {
                return true;
            }
            return false;
        } else if (i == 0) {
            return ratioIntersectsMod16Segment(height, width, rational);
        } else {
            if (height % 16 == 0) {
                return ratioIntersectsMod16Segment(width, height, rational2);
            }
            return false;
        }
    }

    private int getArea(Size size) {
        return size.getWidth() * size.getHeight();
    }

    private static boolean ratioIntersectsMod16Segment(int i, int i2, Rational rational) {
        Preconditions.checkArgument(i2 % 16 == 0);
        double numerator = ((double) (i * rational.getNumerator())) / ((double) rational.getDenominator());
        if (numerator <= ((double) Math.max(0, i2 - 16)) || numerator >= ((double) (i2 + 16))) {
            return false;
        }
        return true;
    }

    private void removeSupportedSizesByTargetSizeAndAspectRatio(List<Size> list, Size size) {
        if (list != null && !list.isEmpty()) {
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            Rational rational = null;
            for (int i = 0; i < list.size(); i++) {
                Size size2 = list.get(i);
                if (size2.getWidth() >= size.getWidth() && size2.getHeight() >= size.getHeight()) {
                    Rational rational2 = new Rational(size2.getWidth(), size2.getHeight());
                    if (rational == null || !hasMatchingAspectRatio(size2, rational)) {
                        rational = rational2;
                    }
                    Size size3 = (Size) hashMap.get(rational);
                    if (size3 != null) {
                        arrayList.add(size3);
                    }
                    hashMap.put(rational, size2);
                }
            }
            list.removeAll(arrayList);
        }
    }

    private void removeSupportedSizesByTargetSize(List<Size> list, Size size) {
        if (list != null && !list.isEmpty()) {
            int i = -1;
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                int i4 = i;
                i = i3;
                if (i >= list.size()) {
                    break;
                }
                Size size2 = list.get(i);
                if (size2.getWidth() < size.getWidth() || size2.getHeight() < size.getHeight()) {
                    break;
                }
                if (i4 >= 0) {
                    arrayList.add(list.get(i4));
                }
                i2 = i + 1;
            }
            list.removeAll(arrayList);
        }
    }

    private List<List<Size>> getAllPossibleSizeArrangements(List<List<Size>> list) {
        int i = 1;
        for (List<Size> size : list) {
            i *= size.size();
        }
        if (i != 0) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < i; i2++) {
                arrayList.add(new ArrayList());
            }
            int size2 = i / list.get(0).size();
            int i3 = i;
            for (int i4 = 0; i4 < list.size(); i4++) {
                List list2 = list.get(i4);
                for (int i5 = 0; i5 < i; i5++) {
                    ((List) arrayList.get(i5)).add(list2.get((i5 % i3) / size2));
                }
                if (i4 < list.size() - 1) {
                    i3 = size2;
                    size2 /= list.get(i4 + 1).size();
                }
            }
            return arrayList;
        }
        throw new IllegalArgumentException("Failed to find supported resolutions.");
    }

    private Size[] getAllOutputSizesByFormat(int i) {
        return getAllOutputSizesByFormat(i, null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: android.util.Size[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.util.Size[] getAllOutputSizesByFormat(int r4, androidx.camera.core.UseCase r5) {
        /*
            r3 = this;
            r0 = 0
            if (r5 == 0) goto L_0x000e
            androidx.camera.core.impl.UseCaseConfig r5 = r5.getUseCaseConfig()
            androidx.camera.core.impl.ImageOutputConfig r5 = (androidx.camera.core.impl.ImageOutputConfig) r5
            java.util.List r5 = r5.getSupportedResolutions(r0)
            goto L_0x000f
        L_0x000e:
            r5 = r0
        L_0x000f:
            if (r5 == 0) goto L_0x0030
            java.util.Iterator r5 = r5.iterator()
        L_0x0015:
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto L_0x0030
            java.lang.Object r1 = r5.next()
            android.util.Pair r1 = (android.util.Pair) r1
            java.lang.Object r2 = r1.first
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            if (r2 != r4) goto L_0x0015
            java.lang.Object r5 = r1.second
            r0 = r5
            android.util.Size[] r0 = (android.util.Size[]) r0
        L_0x0030:
            java.lang.String r5 = "Can not get supported output size for the format: "
            if (r0 != 0) goto L_0x0075
            android.hardware.camera2.CameraCharacteristics r0 = r3.mCharacteristics
            if (r0 == 0) goto L_0x006d
            android.hardware.camera2.CameraCharacteristics$Key r1 = android.hardware.camera2.CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP
            java.lang.Object r0 = r0.get(r1)
            android.hardware.camera2.params.StreamConfigurationMap r0 = (android.hardware.camera2.params.StreamConfigurationMap) r0
            if (r0 == 0) goto L_0x0058
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 23
            if (r1 >= r2) goto L_0x0053
            r1 = 34
            if (r4 != r1) goto L_0x0053
            java.lang.Class<android.graphics.SurfaceTexture> r1 = android.graphics.SurfaceTexture.class
            android.util.Size[] r0 = r0.getOutputSizes(r1)
            goto L_0x0075
        L_0x0053:
            android.util.Size[] r0 = r0.getOutputSizes(r4)
            goto L_0x0075
        L_0x0058:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r5)
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            r0.<init>(r4)
            throw r0
        L_0x006d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "CameraCharacteristics is null."
            r4.<init>(r5)
            throw r4
        L_0x0075:
            if (r0 == 0) goto L_0x0081
            androidx.camera.camera2.internal.SupportedSurfaceCombination$CompareSizesByArea r4 = new androidx.camera.camera2.internal.SupportedSurfaceCombination$CompareSizesByArea
            r5 = 1
            r4.<init>(r5)
            java.util.Arrays.sort(r0, r4)
            return r0
        L_0x0081:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r5)
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            r0.<init>(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.internal.SupportedSurfaceCombination.getAllOutputSizesByFormat(int, androidx.camera.core.UseCase):android.util.Size[]");
    }

    /* access modifiers changed from: package-private */
    public Size getMaxOutputSizeByFormat(int i) {
        return (Size) Collections.max(Arrays.asList(getAllOutputSizesByFormat(i)), new CompareSizesByArea());
    }

    private void init(Context context) {
        CameraManager cameraManager = (CameraManager) context.getSystemService("camera");
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        try {
            generateSupportedCombinationList(cameraManager);
            generateSurfaceSizeDefinition(windowManager);
            checkCustomization();
        } catch (CameraAccessException e) {
            throw new IllegalArgumentException("Generate supported combination list and size definition fail - CameraId:" + this.mCameraId, e);
        }
    }

    /* access modifiers changed from: package-private */
    public List<SurfaceCombination> getLegacySupportedCombinationList() {
        ArrayList arrayList = new ArrayList();
        SurfaceCombination surfaceCombination = new SurfaceCombination();
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.MAXIMUM));
        arrayList.add(surfaceCombination);
        SurfaceCombination surfaceCombination2 = new SurfaceCombination();
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.JPEG, SurfaceConfig.ConfigSize.MAXIMUM));
        arrayList.add(surfaceCombination2);
        SurfaceCombination surfaceCombination3 = new SurfaceCombination();
        surfaceCombination3.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.MAXIMUM));
        arrayList.add(surfaceCombination3);
        SurfaceCombination surfaceCombination4 = new SurfaceCombination();
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW));
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.JPEG, SurfaceConfig.ConfigSize.MAXIMUM));
        arrayList.add(surfaceCombination4);
        SurfaceCombination surfaceCombination5 = new SurfaceCombination();
        surfaceCombination5.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.PREVIEW));
        surfaceCombination5.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.JPEG, SurfaceConfig.ConfigSize.MAXIMUM));
        arrayList.add(surfaceCombination5);
        SurfaceCombination surfaceCombination6 = new SurfaceCombination();
        surfaceCombination6.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW));
        surfaceCombination6.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW));
        arrayList.add(surfaceCombination6);
        SurfaceCombination surfaceCombination7 = new SurfaceCombination();
        surfaceCombination7.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW));
        surfaceCombination7.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.PREVIEW));
        arrayList.add(surfaceCombination7);
        SurfaceCombination surfaceCombination8 = new SurfaceCombination();
        surfaceCombination8.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW));
        surfaceCombination8.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.PREVIEW));
        surfaceCombination8.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.JPEG, SurfaceConfig.ConfigSize.MAXIMUM));
        arrayList.add(surfaceCombination8);
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public List<SurfaceCombination> getLimitedSupportedCombinationList() {
        ArrayList arrayList = new ArrayList();
        SurfaceCombination surfaceCombination = new SurfaceCombination();
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW));
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.RECORD));
        arrayList.add(surfaceCombination);
        SurfaceCombination surfaceCombination2 = new SurfaceCombination();
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW));
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.RECORD));
        arrayList.add(surfaceCombination2);
        SurfaceCombination surfaceCombination3 = new SurfaceCombination();
        surfaceCombination3.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.PREVIEW));
        surfaceCombination3.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.RECORD));
        arrayList.add(surfaceCombination3);
        SurfaceCombination surfaceCombination4 = new SurfaceCombination();
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW));
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.RECORD));
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.JPEG, SurfaceConfig.ConfigSize.RECORD));
        arrayList.add(surfaceCombination4);
        SurfaceCombination surfaceCombination5 = new SurfaceCombination();
        surfaceCombination5.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW));
        surfaceCombination5.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.RECORD));
        surfaceCombination5.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.JPEG, SurfaceConfig.ConfigSize.RECORD));
        arrayList.add(surfaceCombination5);
        SurfaceCombination surfaceCombination6 = new SurfaceCombination();
        surfaceCombination6.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.PREVIEW));
        surfaceCombination6.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.PREVIEW));
        surfaceCombination6.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.JPEG, SurfaceConfig.ConfigSize.MAXIMUM));
        arrayList.add(surfaceCombination6);
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public List<SurfaceCombination> getFullSupportedCombinationList() {
        ArrayList arrayList = new ArrayList();
        SurfaceCombination surfaceCombination = new SurfaceCombination();
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW));
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.MAXIMUM));
        arrayList.add(surfaceCombination);
        SurfaceCombination surfaceCombination2 = new SurfaceCombination();
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW));
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.MAXIMUM));
        arrayList.add(surfaceCombination2);
        SurfaceCombination surfaceCombination3 = new SurfaceCombination();
        surfaceCombination3.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.PREVIEW));
        surfaceCombination3.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.MAXIMUM));
        arrayList.add(surfaceCombination3);
        SurfaceCombination surfaceCombination4 = new SurfaceCombination();
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW));
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW));
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.JPEG, SurfaceConfig.ConfigSize.MAXIMUM));
        arrayList.add(surfaceCombination4);
        SurfaceCombination surfaceCombination5 = new SurfaceCombination();
        surfaceCombination5.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.ANALYSIS));
        surfaceCombination5.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW));
        surfaceCombination5.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.MAXIMUM));
        arrayList.add(surfaceCombination5);
        SurfaceCombination surfaceCombination6 = new SurfaceCombination();
        surfaceCombination6.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.ANALYSIS));
        surfaceCombination6.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.PREVIEW));
        surfaceCombination6.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.MAXIMUM));
        arrayList.add(surfaceCombination6);
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public List<SurfaceCombination> getRAWSupportedCombinationList() {
        ArrayList arrayList = new ArrayList();
        SurfaceCombination surfaceCombination = new SurfaceCombination();
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.RAW, SurfaceConfig.ConfigSize.MAXIMUM));
        arrayList.add(surfaceCombination);
        SurfaceCombination surfaceCombination2 = new SurfaceCombination();
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW));
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.RAW, SurfaceConfig.ConfigSize.MAXIMUM));
        arrayList.add(surfaceCombination2);
        SurfaceCombination surfaceCombination3 = new SurfaceCombination();
        surfaceCombination3.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.PREVIEW));
        surfaceCombination3.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.RAW, SurfaceConfig.ConfigSize.MAXIMUM));
        arrayList.add(surfaceCombination3);
        SurfaceCombination surfaceCombination4 = new SurfaceCombination();
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW));
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW));
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.RAW, SurfaceConfig.ConfigSize.MAXIMUM));
        arrayList.add(surfaceCombination4);
        SurfaceCombination surfaceCombination5 = new SurfaceCombination();
        surfaceCombination5.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW));
        surfaceCombination5.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.PREVIEW));
        surfaceCombination5.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.RAW, SurfaceConfig.ConfigSize.MAXIMUM));
        arrayList.add(surfaceCombination5);
        SurfaceCombination surfaceCombination6 = new SurfaceCombination();
        surfaceCombination6.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.PREVIEW));
        surfaceCombination6.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.PREVIEW));
        surfaceCombination6.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.RAW, SurfaceConfig.ConfigSize.MAXIMUM));
        arrayList.add(surfaceCombination6);
        SurfaceCombination surfaceCombination7 = new SurfaceCombination();
        surfaceCombination7.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW));
        surfaceCombination7.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.JPEG, SurfaceConfig.ConfigSize.MAXIMUM));
        surfaceCombination7.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.RAW, SurfaceConfig.ConfigSize.MAXIMUM));
        arrayList.add(surfaceCombination7);
        SurfaceCombination surfaceCombination8 = new SurfaceCombination();
        surfaceCombination8.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.PREVIEW));
        surfaceCombination8.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.JPEG, SurfaceConfig.ConfigSize.MAXIMUM));
        surfaceCombination8.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.RAW, SurfaceConfig.ConfigSize.MAXIMUM));
        arrayList.add(surfaceCombination8);
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public List<SurfaceCombination> getBurstSupportedCombinationList() {
        ArrayList arrayList = new ArrayList();
        SurfaceCombination surfaceCombination = new SurfaceCombination();
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW));
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.MAXIMUM));
        arrayList.add(surfaceCombination);
        SurfaceCombination surfaceCombination2 = new SurfaceCombination();
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW));
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.MAXIMUM));
        arrayList.add(surfaceCombination2);
        SurfaceCombination surfaceCombination3 = new SurfaceCombination();
        surfaceCombination3.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.PREVIEW));
        surfaceCombination3.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.MAXIMUM));
        arrayList.add(surfaceCombination3);
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public List<SurfaceCombination> getLevel3SupportedCombinationList() {
        ArrayList arrayList = new ArrayList();
        SurfaceCombination surfaceCombination = new SurfaceCombination();
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW));
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.ANALYSIS));
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.MAXIMUM));
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.RAW, SurfaceConfig.ConfigSize.MAXIMUM));
        arrayList.add(surfaceCombination);
        SurfaceCombination surfaceCombination2 = new SurfaceCombination();
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW));
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.ANALYSIS));
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.JPEG, SurfaceConfig.ConfigSize.MAXIMUM));
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.RAW, SurfaceConfig.ConfigSize.MAXIMUM));
        arrayList.add(surfaceCombination2);
        return arrayList;
    }

    private void generateSupportedCombinationList(CameraManager cameraManager) throws CameraAccessException {
        CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(this.mCameraId);
        this.mCharacteristics = cameraCharacteristics;
        Integer num = (Integer) cameraCharacteristics.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        if (num != null) {
            this.mHardwareLevel = num.intValue();
        }
        this.mSurfaceCombinations.addAll(getLegacySupportedCombinationList());
        int i = this.mHardwareLevel;
        if (i == 0 || i == 1 || i == 3) {
            this.mSurfaceCombinations.addAll(getLimitedSupportedCombinationList());
        }
        int i2 = this.mHardwareLevel;
        if (i2 == 1 || i2 == 3) {
            this.mSurfaceCombinations.addAll(getFullSupportedCombinationList());
        }
        int[] iArr = (int[]) this.mCharacteristics.get(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
        if (iArr != null) {
            for (int i3 : iArr) {
                if (i3 == 3) {
                    this.mIsRawSupported = true;
                } else if (i3 == 6) {
                    this.mIsBurstCaptureSupported = true;
                }
            }
        }
        if (this.mIsRawSupported) {
            this.mSurfaceCombinations.addAll(getRAWSupportedCombinationList());
        }
        if (this.mIsBurstCaptureSupported && this.mHardwareLevel == 0) {
            this.mSurfaceCombinations.addAll(getBurstSupportedCombinationList());
        }
        if (this.mHardwareLevel == 3) {
            this.mSurfaceCombinations.addAll(getLevel3SupportedCombinationList());
        }
    }

    private void generateSurfaceSizeDefinition(WindowManager windowManager) {
        this.mSurfaceSizeDefinition = SurfaceSizeDefinition.create(new Size(640, 480), getPreviewSize(windowManager), getRecordSize());
    }

    private Size getPreviewSize(WindowManager windowManager) {
        Size size;
        Point point = new Point();
        windowManager.getDefaultDisplay().getRealSize(point);
        if (point.x > point.y) {
            size = new Size(point.x, point.y);
        } else {
            size = new Size(point.y, point.x);
        }
        return (Size) Collections.min(Arrays.asList(new Size(size.getWidth(), size.getHeight()), MAX_PREVIEW_SIZE), new CompareSizesByArea());
    }

    private Size getRecordSize() {
        Size size = QUALITY_480P_SIZE;
        if (this.mCamcorderProfileHelper.hasProfile(Integer.parseInt(this.mCameraId), 8)) {
            return QUALITY_2160P_SIZE;
        }
        if (this.mCamcorderProfileHelper.hasProfile(Integer.parseInt(this.mCameraId), 6)) {
            return QUALITY_1080P_SIZE;
        }
        if (this.mCamcorderProfileHelper.hasProfile(Integer.parseInt(this.mCameraId), 5)) {
            return QUALITY_720P_SIZE;
        }
        return this.mCamcorderProfileHelper.hasProfile(Integer.parseInt(this.mCameraId), 4) ? QUALITY_480P_SIZE : size;
    }

    static final class CompareSizesByArea implements Comparator<Size> {
        private boolean mReverse = false;

        CompareSizesByArea() {
        }

        CompareSizesByArea(boolean z) {
            this.mReverse = z;
        }

        public int compare(Size size, Size size2) {
            int signum = Long.signum((((long) size.getWidth()) * ((long) size.getHeight())) - (((long) size2.getWidth()) * ((long) size2.getHeight())));
            return this.mReverse ? signum * -1 : signum;
        }
    }

    static final class CompareSizesByDistanceToTargetRatio implements Comparator<Size> {
        private Float mTargetRatio;

        CompareSizesByDistanceToTargetRatio(Float f) {
            this.mTargetRatio = f;
        }

        public int compare(Size size, Size size2) {
            if (SupportedSurfaceCombination.hasMatchingAspectRatio(size, new Rational(size2.getWidth(), size2.getHeight()))) {
                return 0;
            }
            Float valueOf = Float.valueOf((((float) size.getWidth()) * 1.0f) / ((float) size.getHeight()));
            Float valueOf2 = Float.valueOf((((float) size2.getWidth()) * 1.0f) / ((float) size2.getHeight()));
            return (int) Math.signum(Float.valueOf(Math.abs(valueOf.floatValue() - this.mTargetRatio.floatValue())).floatValue() - Float.valueOf(Math.abs(valueOf2.floatValue() - this.mTargetRatio.floatValue())).floatValue());
        }
    }
}
