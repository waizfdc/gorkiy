package com.google.android.gms.internal.base;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import androidx.recyclerview.widget.ItemTouchHelper;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
public final class zae extends Drawable implements Drawable.Callback {
    private int mAlpha;
    private int mFrom;
    private boolean zand;
    private int zanl;
    private long zanm;
    private int zann;
    private int zano;
    private int zanp;
    private boolean zanq;
    private zah zanr;
    private Drawable zans;
    private Drawable zant;
    private boolean zanu;
    private boolean zanv;
    private boolean zanw;
    private int zanx;

    public zae(Drawable drawable, Drawable drawable2) {
        this(null);
        drawable = drawable == null ? zaf.zany : drawable;
        this.zans = super;
        super.setCallback(this);
        zah zah = this.zanr;
        zah.zaoa = super.getChangingConfigurations() | zah.zaoa;
        drawable2 = drawable2 == null ? zaf.zany : drawable2;
        this.zant = super;
        super.setCallback(this);
        zah zah2 = this.zanr;
        zah2.zaoa = super.getChangingConfigurations() | zah2.zaoa;
    }

    zae(zah zah) {
        this.zanl = 0;
        this.zano = 255;
        this.mAlpha = 0;
        this.zand = true;
        this.zanr = new zah(zah);
    }

    public final void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(super);
        }
    }

    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(super, runnable, j);
        }
    }

    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(super, runnable);
        }
    }

    public final int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.zanr.mChangingConfigurations | this.zanr.zaoa;
    }

    public final void setAlpha(int i) {
        if (this.mAlpha == this.zano) {
            this.mAlpha = i;
        }
        this.zano = i;
        invalidateSelf();
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.zans.setColorFilter(colorFilter);
        this.zant.setColorFilter(colorFilter);
    }

    public final int getIntrinsicWidth() {
        return Math.max(this.zans.getIntrinsicWidth(), this.zant.getIntrinsicWidth());
    }

    public final int getIntrinsicHeight() {
        return Math.max(this.zans.getIntrinsicHeight(), this.zant.getIntrinsicHeight());
    }

    /* access modifiers changed from: protected */
    public final void onBoundsChange(Rect rect) {
        this.zans.setBounds(rect);
        this.zant.setBounds(rect);
    }

    public final Drawable.ConstantState getConstantState() {
        if (!canConstantState()) {
            return null;
        }
        this.zanr.mChangingConfigurations = getChangingConfigurations();
        return this.zanr;
    }

    public final int getOpacity() {
        if (!this.zanw) {
            this.zanx = Drawable.resolveOpacity(this.zans.getOpacity(), this.zant.getOpacity());
            this.zanw = true;
        }
        return this.zanx;
    }

    private final boolean canConstantState() {
        if (!this.zanu) {
            this.zanv = (this.zans.getConstantState() == null || this.zant.getConstantState() == null) ? false : true;
            this.zanu = true;
        }
        return this.zanv;
    }

    public final Drawable mutate() {
        if (!this.zanq && super.mutate() == this) {
            if (canConstantState()) {
                this.zans.mutate();
                this.zant.mutate();
                this.zanq = true;
            } else {
                throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
            }
        }
        return super;
    }

    public final Drawable zacd() {
        return this.zant;
    }

    public final void startTransition(int i) {
        this.mFrom = 0;
        this.zann = this.zano;
        this.mAlpha = 0;
        this.zanp = ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION;
        this.zanl = 1;
        invalidateSelf();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.min(float, float):float}
     arg types: [float, int]
     candidates:
      ClspMth{java.lang.Math.min(double, double):double}
      ClspMth{java.lang.Math.min(long, long):long}
      ClspMth{java.lang.Math.min(int, int):int}
      ClspMth{java.lang.Math.min(float, float):float} */
    public final void draw(Canvas canvas) {
        int i = this.zanl;
        boolean z = false;
        boolean z2 = true;
        if (i != 1) {
            if (i == 2 && this.zanm >= 0) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.zanm)) / ((float) this.zanp);
                if (uptimeMillis < 1.0f) {
                    z2 = false;
                }
                if (z2) {
                    this.zanl = 0;
                }
                this.mAlpha = (int) ((((float) this.zann) * Math.min(uptimeMillis, 1.0f)) + 0.0f);
            }
            z = z2;
        } else {
            this.zanm = SystemClock.uptimeMillis();
            this.zanl = 2;
        }
        int i2 = this.mAlpha;
        boolean z3 = this.zand;
        Drawable drawable = this.zans;
        Drawable drawable2 = this.zant;
        if (z) {
            if (!z3 || i2 == 0) {
                super.draw(canvas);
            }
            int i3 = this.zano;
            if (i2 == i3) {
                super.setAlpha(i3);
                super.draw(canvas);
                return;
            }
            return;
        }
        if (z3) {
            super.setAlpha(this.zano - i2);
        }
        super.draw(canvas);
        if (z3) {
            super.setAlpha(this.zano);
        }
        if (i2 > 0) {
            super.setAlpha(i2);
            super.draw(canvas);
            super.setAlpha(this.zano);
        }
        invalidateSelf();
    }
}
