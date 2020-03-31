package org.conscrypt;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class FileClientSessionCache {
    public static final int MAX_SIZE = 12;
    static final Map<File, Impl> caches = new HashMap();
    /* access modifiers changed from: private */
    public static final Logger logger = Logger.getLogger(FileClientSessionCache.class.getName());

    private FileClientSessionCache() {
    }

    static class Impl implements SSLClientSessionCache {
        Map<String, File> accessOrder = newAccessOrder();
        final File directory;
        String[] initialFiles;
        int size;

        Impl(File file) throws IOException {
            boolean exists = file.exists();
            if (!exists || file.isDirectory()) {
                if (exists) {
                    String[] list = file.list();
                    this.initialFiles = list;
                    if (list != null) {
                        Arrays.sort(list);
                        this.size = this.initialFiles.length;
                    } else {
                        throw new IOException(file + " exists but cannot list contents.");
                    }
                } else if (file.mkdirs()) {
                    this.size = 0;
                } else {
                    throw new IOException("Creation of " + file + " directory failed.");
                }
                this.directory = file;
                return;
            }
            throw new IOException(file + " exists but is not a directory.");
        }

        private static Map<String, File> newAccessOrder() {
            return new LinkedHashMap(12, 0.75f, true);
        }

        private static String fileName(String str, int i) {
            if (str != null) {
                return str + "." + i;
            }
            throw new NullPointerException("host == null");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0054, code lost:
            r6 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x0055, code lost:
            logReadError(r5, r0, r6);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x0059, code lost:
            return null;
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x0053 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized byte[] getSessionData(java.lang.String r5, int r6) {
            /*
                r4 = this;
                monitor-enter(r4)
                java.lang.String r6 = fileName(r5, r6)     // Catch:{ all -> 0x005a }
                java.util.Map<java.lang.String, java.io.File> r0 = r4.accessOrder     // Catch:{ all -> 0x005a }
                java.lang.Object r0 = r0.get(r6)     // Catch:{ all -> 0x005a }
                java.io.File r0 = (java.io.File) r0     // Catch:{ all -> 0x005a }
                r1 = 0
                if (r0 != 0) goto L_0x002c
                java.lang.String[] r0 = r4.initialFiles     // Catch:{ all -> 0x005a }
                if (r0 != 0) goto L_0x0016
                monitor-exit(r4)
                return r1
            L_0x0016:
                java.lang.String[] r0 = r4.initialFiles     // Catch:{ all -> 0x005a }
                int r0 = java.util.Arrays.binarySearch(r0, r6)     // Catch:{ all -> 0x005a }
                if (r0 >= 0) goto L_0x0020
                monitor-exit(r4)
                return r1
            L_0x0020:
                java.io.File r0 = new java.io.File     // Catch:{ all -> 0x005a }
                java.io.File r2 = r4.directory     // Catch:{ all -> 0x005a }
                r0.<init>(r2, r6)     // Catch:{ all -> 0x005a }
                java.util.Map<java.lang.String, java.io.File> r2 = r4.accessOrder     // Catch:{ all -> 0x005a }
                r2.put(r6, r0)     // Catch:{ all -> 0x005a }
            L_0x002c:
                java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0054 }
                r6.<init>(r0)     // Catch:{ FileNotFoundException -> 0x0054 }
                long r2 = r0.length()     // Catch:{ IOException -> 0x0047 }
                int r2 = (int) r2     // Catch:{ IOException -> 0x0047 }
                byte[] r2 = new byte[r2]     // Catch:{ IOException -> 0x0047 }
                java.io.DataInputStream r3 = new java.io.DataInputStream     // Catch:{ IOException -> 0x0047 }
                r3.<init>(r6)     // Catch:{ IOException -> 0x0047 }
                r3.readFully(r2)     // Catch:{ IOException -> 0x0047 }
                r6.close()     // Catch:{ Exception -> 0x0043 }
            L_0x0043:
                monitor-exit(r4)
                return r2
            L_0x0045:
                r5 = move-exception
                goto L_0x0050
            L_0x0047:
                r2 = move-exception
                logReadError(r5, r0, r2)     // Catch:{ all -> 0x0045 }
                r6.close()     // Catch:{ Exception -> 0x004e }
            L_0x004e:
                monitor-exit(r4)
                return r1
            L_0x0050:
                r6.close()     // Catch:{ Exception -> 0x0053 }
            L_0x0053:
                throw r5     // Catch:{ all -> 0x005a }
            L_0x0054:
                r6 = move-exception
                logReadError(r5, r0, r6)     // Catch:{ all -> 0x005a }
                monitor-exit(r4)
                return r1
            L_0x005a:
                r5 = move-exception
                monitor-exit(r4)
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: org.conscrypt.FileClientSessionCache.Impl.getSessionData(java.lang.String, int):byte[]");
        }

        static void logReadError(String str, File file, Throwable th) {
            Logger access$000 = FileClientSessionCache.logger;
            Level level = Level.WARNING;
            access$000.log(level, "FileClientSessionCache: Error reading session data for " + str + " from " + file + ".", th);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0036, code lost:
            r5 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0040, code lost:
            delete(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0043, code lost:
            throw r5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0044, code lost:
            r5 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x004e, code lost:
            r5 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
            delete(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x005a, code lost:
            throw r5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
            r3.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
            delete(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x0062, code lost:
            r5 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x0064, code lost:
            r6 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
            logWriteError(r0, r1, r6);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
            throw r5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x006a, code lost:
            delete(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x006d, code lost:
            throw r5;
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [B:18:0x0039, B:26:0x0047, B:32:0x0051, B:45:0x0065] */
        /* JADX WARNING: Unknown top exception splitter block from list: {B:20:0x003c=Splitter:B:20:0x003c, B:41:0x005e=Splitter:B:41:0x005e} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized void putSessionData(javax.net.ssl.SSLSession r5, byte[] r6) {
            /*
                r4 = this;
                monitor-enter(r4)
                java.lang.String r0 = r5.getPeerHost()     // Catch:{ all -> 0x007c }
                if (r6 == 0) goto L_0x0074
                int r5 = r5.getPeerPort()     // Catch:{ all -> 0x007c }
                java.lang.String r5 = fileName(r0, r5)     // Catch:{ all -> 0x007c }
                java.io.File r1 = new java.io.File     // Catch:{ all -> 0x007c }
                java.io.File r2 = r4.directory     // Catch:{ all -> 0x007c }
                r1.<init>(r2, r5)     // Catch:{ all -> 0x007c }
                boolean r2 = r1.exists()     // Catch:{ all -> 0x007c }
                java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x006e }
                r3.<init>(r1)     // Catch:{ FileNotFoundException -> 0x006e }
                if (r2 != 0) goto L_0x002a
                int r2 = r4.size     // Catch:{ all -> 0x007c }
                int r2 = r2 + 1
                r4.size = r2     // Catch:{ all -> 0x007c }
                r4.makeRoom()     // Catch:{ all -> 0x007c }
            L_0x002a:
                r3.write(r6)     // Catch:{ IOException -> 0x0046 }
                r3.close()     // Catch:{ IOException -> 0x0038 }
                java.util.Map<java.lang.String, java.io.File> r6 = r4.accessOrder     // Catch:{ all -> 0x007c }
                r6.put(r5, r1)     // Catch:{ all -> 0x007c }
                goto L_0x0055
            L_0x0036:
                r5 = move-exception
                goto L_0x0040
            L_0x0038:
                r5 = move-exception
                logWriteError(r0, r1, r5)     // Catch:{ all -> 0x0036 }
            L_0x003c:
                r4.delete(r1)     // Catch:{ all -> 0x007c }
                goto L_0x0055
            L_0x0040:
                r4.delete(r1)     // Catch:{ all -> 0x007c }
                throw r5     // Catch:{ all -> 0x007c }
            L_0x0044:
                r5 = move-exception
                goto L_0x005b
            L_0x0046:
                r5 = move-exception
                logWriteError(r0, r1, r5)     // Catch:{ all -> 0x0044 }
                r3.close()     // Catch:{ IOException -> 0x0050 }
                goto L_0x003c
            L_0x004e:
                r5 = move-exception
                goto L_0x0057
            L_0x0050:
                r5 = move-exception
                logWriteError(r0, r1, r5)     // Catch:{ all -> 0x004e }
                goto L_0x003c
            L_0x0055:
                monitor-exit(r4)
                return
            L_0x0057:
                r4.delete(r1)     // Catch:{ all -> 0x007c }
                throw r5     // Catch:{ all -> 0x007c }
            L_0x005b:
                r3.close()     // Catch:{ IOException -> 0x0064 }
            L_0x005e:
                r4.delete(r1)     // Catch:{ all -> 0x007c }
                goto L_0x0069
            L_0x0062:
                r5 = move-exception
                goto L_0x006a
            L_0x0064:
                r6 = move-exception
                logWriteError(r0, r1, r6)     // Catch:{ all -> 0x0062 }
                goto L_0x005e
            L_0x0069:
                throw r5     // Catch:{ all -> 0x007c }
            L_0x006a:
                r4.delete(r1)     // Catch:{ all -> 0x007c }
                throw r5     // Catch:{ all -> 0x007c }
            L_0x006e:
                r5 = move-exception
                logWriteError(r0, r1, r5)     // Catch:{ all -> 0x007c }
                monitor-exit(r4)
                return
            L_0x0074:
                java.lang.NullPointerException r5 = new java.lang.NullPointerException     // Catch:{ all -> 0x007c }
                java.lang.String r6 = "sessionData == null"
                r5.<init>(r6)     // Catch:{ all -> 0x007c }
                throw r5     // Catch:{ all -> 0x007c }
            L_0x007c:
                r5 = move-exception
                monitor-exit(r4)
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: org.conscrypt.FileClientSessionCache.Impl.putSessionData(javax.net.ssl.SSLSession, byte[]):void");
        }

        private void makeRoom() {
            if (this.size > 12) {
                indexFiles();
                int i = this.size - 12;
                Iterator<File> it = this.accessOrder.values().iterator();
                do {
                    delete(it.next());
                    it.remove();
                    i--;
                } while (i > 0);
            }
        }

        private void indexFiles() {
            String[] strArr = this.initialFiles;
            if (strArr != null) {
                this.initialFiles = null;
                TreeSet<CacheFile> treeSet = new TreeSet<>();
                for (String str : strArr) {
                    if (!this.accessOrder.containsKey(str)) {
                        treeSet.add(new CacheFile(this.directory, str));
                    }
                }
                if (!treeSet.isEmpty()) {
                    Map<String, File> newAccessOrder = newAccessOrder();
                    for (CacheFile cacheFile : treeSet) {
                        newAccessOrder.put(cacheFile.name, cacheFile);
                    }
                    newAccessOrder.putAll(this.accessOrder);
                    this.accessOrder = newAccessOrder;
                }
            }
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Throwable):void}
         arg types: [java.util.logging.Level, java.lang.String, java.io.IOException]
         candidates:
          ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.Throwable, java.util.function.Supplier<java.lang.String>):void}
          ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Object[]):void}
          ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Object):void}
          ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Throwable):void} */
        private void delete(File file) {
            if (!file.delete()) {
                IOException iOException = new IOException("FileClientSessionCache: Failed to delete " + file + ".");
                FileClientSessionCache.logger.log(Level.WARNING, iOException.getMessage(), (Throwable) iOException);
            }
            this.size--;
        }

        static void logWriteError(String str, File file, Throwable th) {
            Logger access$000 = FileClientSessionCache.logger;
            Level level = Level.WARNING;
            access$000.log(level, "FileClientSessionCache: Error writing session data for " + str + " to " + file + ".", th);
        }
    }

    public static synchronized SSLClientSessionCache usingDirectory(File file) throws IOException {
        Impl impl;
        synchronized (FileClientSessionCache.class) {
            impl = caches.get(file);
            if (impl == null) {
                impl = new Impl(file);
                caches.put(file, impl);
            }
        }
        return impl;
    }

    static synchronized void reset() {
        synchronized (FileClientSessionCache.class) {
            caches.clear();
        }
    }

    static class CacheFile extends File {
        long lastModified = -1;
        final String name;

        CacheFile(File file, String str) {
            super(super, str);
            this.name = str;
        }

        public long lastModified() {
            long j = this.lastModified;
            if (j != -1) {
                return j;
            }
            long lastModified2 = super.lastModified();
            this.lastModified = lastModified2;
            return lastModified2;
        }

        public int compareTo(File file) {
            int i = ((lastModified() - super.lastModified()) > 0 ? 1 : ((lastModified() - super.lastModified()) == 0 ? 0 : -1));
            if (i == 0) {
                return super.compareTo(super);
            }
            return i < 0 ? -1 : 1;
        }
    }
}
