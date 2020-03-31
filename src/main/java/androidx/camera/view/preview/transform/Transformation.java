package androidx.camera.view.preview.transform;

final class Transformation {
    private final float mOriginX;
    private final float mOriginY;
    private final float mRotation;
    private final float mScaleX;
    private final float mScaleY;

    Transformation(float f, float f2, float f3, float f4, float f5) {
        this.mScaleX = f;
        this.mScaleY = f2;
        this.mOriginX = f3;
        this.mOriginY = f4;
        this.mRotation = f5;
    }

    /* access modifiers changed from: package-private */
    public float getScaleX() {
        return this.mScaleX;
    }

    /* access modifiers changed from: package-private */
    public float getScaleY() {
        return this.mScaleY;
    }

    /* access modifiers changed from: package-private */
    public float getOriginX() {
        return this.mOriginX;
    }

    /* access modifiers changed from: package-private */
    public float getOriginY() {
        return this.mOriginY;
    }

    /* access modifiers changed from: package-private */
    public float getRotation() {
        return this.mRotation;
    }
}
