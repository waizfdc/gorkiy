package com.google.android.gms.common.images;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.util.Log;
import android.widget.ImageView;
import androidx.collection.LruCache;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Constants;
import com.google.android.gms.internal.base.zaj;
import com.google.android.gms.internal.base.zan;
import com.google.android.gms.internal.base.zao;
import com.google.android.gms.internal.base.zar;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
public final class ImageManager {
    /* access modifiers changed from: private */
    public static final Object zamj = new Object();
    /* access modifiers changed from: private */
    public static HashSet<Uri> zamk = new HashSet<>();
    private static ImageManager zaml;
    /* access modifiers changed from: private */
    public final Context mContext;
    /* access modifiers changed from: private */
    public final Handler mHandler = new zar(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public final ExecutorService zamm = zan.zact().zaa(4, zao.zasg);
    /* access modifiers changed from: private */
    public final zaa zamn = null;
    /* access modifiers changed from: private */
    public final zaj zamo = new zaj();
    /* access modifiers changed from: private */
    public final Map<zab, ImageReceiver> zamp = new HashMap();
    /* access modifiers changed from: private */
    public final Map<Uri, ImageReceiver> zamq = new HashMap();
    /* access modifiers changed from: private */
    public final Map<Uri, Long> zamr = new HashMap();

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    public interface OnImageLoadedListener {
        void onImageLoaded(Uri uri, Drawable drawable, boolean z);
    }

    public static ImageManager create(Context context) {
        if (zaml == null) {
            zaml = new ImageManager(context, false);
        }
        return zaml;
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    private static final class zaa extends LruCache<zaa, Bitmap> {
        /* access modifiers changed from: protected */
        public final /* synthetic */ int sizeOf(Object obj, Object obj2) {
            Bitmap bitmap = (Bitmap) obj2;
            return bitmap.getHeight() * bitmap.getRowBytes();
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ void entryRemoved(boolean z, Object obj, Object obj2, Object obj3) {
            super.entryRemoved(z, (zaa) obj, (Bitmap) obj2, (Bitmap) obj3);
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    private final class zab implements Runnable {
        private final zab zamw;

        public zab(zab zab) {
            this.zamw = zab;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.android.gms.common.images.zab.zaa(android.content.Context, com.google.android.gms.internal.base.zaj, boolean):void
         arg types: [android.content.Context, com.google.android.gms.internal.base.zaj, int]
         candidates:
          com.google.android.gms.common.images.zab.zaa(android.content.Context, android.graphics.Bitmap, boolean):void
          com.google.android.gms.common.images.zab.zaa(android.content.Context, com.google.android.gms.internal.base.zaj, boolean):void */
        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.android.gms.common.images.zab.zaa(android.content.Context, android.graphics.Bitmap, boolean):void
         arg types: [android.content.Context, android.graphics.Bitmap, int]
         candidates:
          com.google.android.gms.common.images.zab.zaa(android.content.Context, com.google.android.gms.internal.base.zaj, boolean):void
          com.google.android.gms.common.images.zab.zaa(android.content.Context, android.graphics.Bitmap, boolean):void */
        public final void run() {
            Asserts.checkMainThread("LoadImageRunnable must be executed on the main thread");
            ImageReceiver imageReceiver = (ImageReceiver) ImageManager.this.zamp.get(this.zamw);
            if (imageReceiver != null) {
                ImageManager.this.zamp.remove(this.zamw);
                imageReceiver.zac(this.zamw);
            }
            zaa zaa = this.zamw.zamz;
            if (zaa.uri == null) {
                this.zamw.zaa(ImageManager.this.mContext, ImageManager.this.zamo, true);
                return;
            }
            Bitmap zaa2 = ImageManager.this.zaa(zaa);
            if (zaa2 != null) {
                this.zamw.zaa(ImageManager.this.mContext, zaa2, true);
                return;
            }
            Long l = (Long) ImageManager.this.zamr.get(zaa.uri);
            if (l != null) {
                if (SystemClock.elapsedRealtime() - l.longValue() < 3600000) {
                    this.zamw.zaa(ImageManager.this.mContext, ImageManager.this.zamo, true);
                    return;
                }
                ImageManager.this.zamr.remove(zaa.uri);
            }
            this.zamw.zaa(ImageManager.this.mContext, ImageManager.this.zamo);
            ImageReceiver imageReceiver2 = (ImageReceiver) ImageManager.this.zamq.get(zaa.uri);
            if (imageReceiver2 == null) {
                imageReceiver2 = new ImageReceiver(zaa.uri);
                ImageManager.this.zamq.put(zaa.uri, imageReceiver2);
            }
            imageReceiver2.zab(this.zamw);
            if (!(this.zamw instanceof zac)) {
                ImageManager.this.zamp.put(this.zamw, imageReceiver2);
            }
            synchronized (ImageManager.zamj) {
                if (!ImageManager.zamk.contains(zaa.uri)) {
                    ImageManager.zamk.add(zaa.uri);
                    imageReceiver2.zacc();
                }
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    private final class zac implements Runnable {
        private final Uri zamt;
        private final ParcelFileDescriptor zamx;

        public zac(Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
            this.zamt = uri;
            this.zamx = parcelFileDescriptor;
        }

        public final void run() {
            Asserts.checkNotMainThread("LoadBitmapFromDiskRunnable can't be executed in the main thread");
            ParcelFileDescriptor parcelFileDescriptor = this.zamx;
            boolean z = false;
            Bitmap bitmap = null;
            if (parcelFileDescriptor != null) {
                try {
                    bitmap = BitmapFactory.decodeFileDescriptor(parcelFileDescriptor.getFileDescriptor());
                } catch (OutOfMemoryError e) {
                    String valueOf = String.valueOf(this.zamt);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 34);
                    sb.append("OOM while loading bitmap for uri: ");
                    sb.append(valueOf);
                    Log.e("ImageManager", sb.toString(), e);
                    z = true;
                }
                try {
                    this.zamx.close();
                } catch (IOException e2) {
                    Log.e("ImageManager", "closed failed", e2);
                }
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            ImageManager.this.mHandler.post(new zad(this.zamt, bitmap, z, countDownLatch));
            try {
                countDownLatch.await();
            } catch (InterruptedException unused) {
                String valueOf2 = String.valueOf(this.zamt);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 32);
                sb2.append("Latch interrupted while posting ");
                sb2.append(valueOf2);
                Log.w("ImageManager", sb2.toString());
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    private final class ImageReceiver extends ResultReceiver {
        private final Uri zamt;
        /* access modifiers changed from: private */
        public final ArrayList<zab> zamu = new ArrayList<>();

        ImageReceiver(Uri uri) {
            super(new zar(Looper.getMainLooper()));
            this.zamt = uri;
        }

        public final void zab(zab zab) {
            Asserts.checkMainThread("ImageReceiver.addImageRequest() must be called in the main thread");
            this.zamu.add(zab);
        }

        public final void zac(zab zab) {
            Asserts.checkMainThread("ImageReceiver.removeImageRequest() must be called in the main thread");
            this.zamu.remove(zab);
        }

        public final void zacc() {
            Intent intent = new Intent(Constants.ACTION_LOAD_IMAGE);
            intent.putExtra(Constants.EXTRA_URI, this.zamt);
            intent.putExtra(Constants.EXTRA_RESULT_RECEIVER, this);
            intent.putExtra(Constants.EXTRA_PRIORITY, 3);
            ImageManager.this.mContext.sendBroadcast(intent);
        }

        public final void onReceiveResult(int i, Bundle bundle) {
            ImageManager.this.zamm.execute(new zac(this.zamt, (ParcelFileDescriptor) bundle.getParcelable("com.google.android.gms.extra.fileDescriptor")));
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    private final class zad implements Runnable {
        private final Bitmap mBitmap;
        private final CountDownLatch zads;
        private final Uri zamt;
        private boolean zamy;

        public zad(Uri uri, Bitmap bitmap, boolean z, CountDownLatch countDownLatch) {
            this.zamt = uri;
            this.mBitmap = bitmap;
            this.zamy = z;
            this.zads = countDownLatch;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.android.gms.common.images.zab.zaa(android.content.Context, android.graphics.Bitmap, boolean):void
         arg types: [android.content.Context, android.graphics.Bitmap, int]
         candidates:
          com.google.android.gms.common.images.zab.zaa(android.content.Context, com.google.android.gms.internal.base.zaj, boolean):void
          com.google.android.gms.common.images.zab.zaa(android.content.Context, android.graphics.Bitmap, boolean):void */
        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.android.gms.common.images.zab.zaa(android.content.Context, com.google.android.gms.internal.base.zaj, boolean):void
         arg types: [android.content.Context, com.google.android.gms.internal.base.zaj, int]
         candidates:
          com.google.android.gms.common.images.zab.zaa(android.content.Context, android.graphics.Bitmap, boolean):void
          com.google.android.gms.common.images.zab.zaa(android.content.Context, com.google.android.gms.internal.base.zaj, boolean):void */
        public final void run() {
            Asserts.checkMainThread("OnBitmapLoadedRunnable must be executed in the main thread");
            boolean z = this.mBitmap != null;
            if (ImageManager.this.zamn != null) {
                if (this.zamy) {
                    ImageManager.this.zamn.evictAll();
                    System.gc();
                    this.zamy = false;
                    ImageManager.this.mHandler.post(this);
                    return;
                } else if (z) {
                    ImageManager.this.zamn.put(new zaa(this.zamt), this.mBitmap);
                }
            }
            ImageReceiver imageReceiver = (ImageReceiver) ImageManager.this.zamq.remove(this.zamt);
            if (imageReceiver != null) {
                ArrayList zaa = imageReceiver.zamu;
                int size = zaa.size();
                for (int i = 0; i < size; i++) {
                    zab zab = (zab) zaa.get(i);
                    if (z) {
                        zab.zaa(ImageManager.this.mContext, this.mBitmap, false);
                    } else {
                        ImageManager.this.zamr.put(this.zamt, Long.valueOf(SystemClock.elapsedRealtime()));
                        zab.zaa(ImageManager.this.mContext, ImageManager.this.zamo, false);
                    }
                    if (!(zab instanceof zac)) {
                        ImageManager.this.zamp.remove(zab);
                    }
                }
            }
            this.zads.countDown();
            synchronized (ImageManager.zamj) {
                ImageManager.zamk.remove(this.zamt);
            }
        }
    }

    private ImageManager(Context context, boolean z) {
        this.mContext = context.getApplicationContext();
    }

    public final void loadImage(ImageView imageView, Uri uri) {
        zaa(new zad(imageView, uri));
    }

    public final void loadImage(ImageView imageView, int i) {
        zaa(new zad(imageView, i));
    }

    public final void loadImage(ImageView imageView, Uri uri, int i) {
        zad zad2 = new zad(imageView, uri);
        zad2.zanb = i;
        zaa(zad2);
    }

    public final void loadImage(OnImageLoadedListener onImageLoadedListener, Uri uri) {
        zaa(new zac(onImageLoadedListener, uri));
    }

    public final void loadImage(OnImageLoadedListener onImageLoadedListener, Uri uri, int i) {
        zac zac2 = new zac(onImageLoadedListener, uri);
        zac2.zanb = i;
        zaa(zac2);
    }

    private final void zaa(zab zab2) {
        Asserts.checkMainThread("ImageManager.loadImage() must be called in the main thread");
        new zab(zab2).run();
    }

    /* access modifiers changed from: private */
    public final Bitmap zaa(zaa zaa2) {
        zaa zaa3 = this.zamn;
        if (zaa3 == null) {
            return null;
        }
        return (Bitmap) zaa3.get(zaa2);
    }
}
