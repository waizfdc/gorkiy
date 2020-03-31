package io.fabric.sdk.android.services.persistence;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import java.io.File;

public class FileStoreImpl implements FileStore {
    private final String contentPath;
    private final Context context;
    private final String legacySupport;

    public FileStoreImpl(Kit kit) {
        if (kit.getContext() != null) {
            this.context = kit.getContext();
            this.contentPath = kit.getPath();
            this.legacySupport = "Android/" + this.context.getPackageName();
            return;
        }
        throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
    }

    public File getCacheDir() {
        return prepare(this.context.getCacheDir());
    }

    public File getExternalCacheDir() {
        File file;
        if (!isExternalStorageAvailable()) {
            file = null;
        } else if (Build.VERSION.SDK_INT >= 8) {
            file = this.context.getExternalCacheDir();
        } else {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            file = new File(externalStorageDirectory, this.legacySupport + "/cache/" + this.contentPath);
        }
        return prepare(file);
    }

    public File getFilesDir() {
        return prepare(this.context.getFilesDir());
    }

    public File getExternalFilesDir() {
        File file = null;
        if (isExternalStorageAvailable()) {
            if (Build.VERSION.SDK_INT >= 8) {
                file = this.context.getExternalFilesDir(null);
            } else {
                File externalStorageDirectory = Environment.getExternalStorageDirectory();
                file = new File(externalStorageDirectory, this.legacySupport + "/files/" + this.contentPath);
            }
        }
        return prepare(file);
    }

    /* access modifiers changed from: package-private */
    public File prepare(File file) {
        if (file == null) {
            Fabric.getLogger().d(Fabric.TAG, "Null File");
            return null;
        } else if (file.exists() || file.mkdirs()) {
            return file;
        } else {
            Fabric.getLogger().w(Fabric.TAG, "Couldn't create file");
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isExternalStorageAvailable() {
        if ("mounted".equals(Environment.getExternalStorageState())) {
            return true;
        }
        Fabric.getLogger().w(Fabric.TAG, "External Storage is not mounted and/or writable\nHave you declared android.permission.WRITE_EXTERNAL_STORAGE in the manifest?");
        return false;
    }
}
