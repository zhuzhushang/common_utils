package com.noahedu.yxputils;



import android.content.Intent;
import android.net.Uri;


import java.io.File;
import java.io.InputStream;

/**
 * Author: shaoqw
 * Date: 2020/9/10 15:54
 * Description: utils 桥接类
 */
public class YxpUtilsBridge {

    /**
     * @param s
     * @return YxpStringUtils
     */
    static boolean isSpace(final String s) {
        return YxpStringUtils.isSpace(s);
    }

    /**
     * @param bytes
     * @return YxpConvertUtils
     */
    static String bytes2HexString(final byte[] bytes) {
        return YxpConvertUtils.bytes2HexString(bytes);
    }

    static boolean writeFileFromIS(final String filePath, final InputStream is) {
        return YxpFileIOUtils.writeFileFromIS(filePath, is);
    }

    static String byte2FitMemorySize(final long byteSize) {
        return YxpConvertUtils.byte2FitMemorySize(byteSize);
    }

    ///////////////////////////////////////////////////////////////////////////
    // YxpFileUtils
    ///////////////////////////////////////////////////////////////////////////
    static boolean isFileExists(final File file) {
        return YxpFileUtils.isFileExists(file);
    }

    static File getFileByPath(final String filePath) {
        return YxpFileUtils.getFileByPath(filePath);
    }

    static boolean deleteAllInDir(final File dir) {
        return YxpFileUtils.deleteAllInDir(dir);
    }

    static boolean createOrExistsFile(final File file) {
        return YxpFileUtils.createOrExistsFile(file);
    }

    static boolean createOrExistsDir(final File file) {
        return YxpFileUtils.createOrExistsDir(file);
    }

    static boolean createFileByDeleteOldFile(final File file) {
        return YxpFileUtils.createFileByDeleteOldFile(file);
    }

    ///////////////////////////////////////////////////////////////////////////
    // IntentUtils
    ///////////////////////////////////////////////////////////////////////////
    static boolean isIntentAvailable(final Intent intent) {
        return YxpIntentUtils.isIntentAvailable(intent);
    }

    static Intent getLaunchAppIntent(final String pkgName) {
        return YxpIntentUtils.getLaunchAppIntent(pkgName);
    }

    static Intent getInstallAppIntent(final File file) {
        return YxpIntentUtils.getInstallAppIntent(file);
    }

    static Intent getInstallAppIntent(final Uri uri) {
        return YxpIntentUtils.getInstallAppIntent(uri);
    }

    static Intent getUninstallAppIntent(final String pkgName) {
        return YxpIntentUtils.getUninstallAppIntent(pkgName);
    }

    ///////////////////////////////////////////////////////////////////////////
    // ActivityUtils
    ///////////////////////////////////////////////////////////////////////////

    static String getLauncherActivity() {
        return YxpActivityUtils.getLauncherActivity();
    }

    static String getLauncherActivity(final String pkg) {
        return YxpActivityUtils.getLauncherActivity(pkg);
    }

    ///////////////////////////////////////////////////////////////////////////
    // ProcessUtils
    ///////////////////////////////////////////////////////////////////////////
    static boolean isMainProcess() {
        return YxpProcessUtils.isMainProcess();
    }

    static String getForegroundProcessName() {
        return YxpProcessUtils.getForegroundProcessName();
    }

    static String getCurrentProcessName() {
        return YxpProcessUtils.getCurrentProcessName();
    }

    ///////////////////////////////////////////////////////////////////////////
    // ShellUtils
    ///////////////////////////////////////////////////////////////////////////
    static YxpShellUtils.CommandResult execCmd(final String command, final boolean isRooted) {
        return YxpShellUtils.execCmd(command, isRooted);
    }



    ///////////////////////////////////////////////////////////////////////////
    // ThreadUtils
    ///////////////////////////////////////////////////////////////////////////
    static <T> YxpUtils.Task<T> doAsync(final YxpUtils.Task<T> task) {
        YxpThreadUtils.getCachedPool().execute(task);
        return task;
    }

    static void runOnUiThread(final Runnable runnable) {
        YxpThreadUtils.runOnUiThread(runnable);
    }

    static void runOnUiThreadDelayed(final Runnable runnable, long delayMillis) {
        YxpThreadUtils.runOnUiThreadDelayed(runnable, delayMillis);
    }


    static Intent getLaunchAppDetailsSettingsIntent(final String pkgName, final boolean isNewTask) {
        return YxpIntentUtils.getLaunchAppDetailsSettingsIntent(pkgName, isNewTask);
    }


    ///////////////////////////////////////////////////////////////////////////
    // EncryptUtils
    ///////////////////////////////////////////////////////////////////////////
    static byte[] hashTemplate(final byte[] data, final String algorithm) {
        return YxpEncryptUtils.hashTemplate(data, algorithm);
    }
}
