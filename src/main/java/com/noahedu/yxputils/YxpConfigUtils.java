package com.noahedu.yxputils;

import android.os.Environment;
import android.util.Log;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.lang.reflect.Field;

public class YxpConfigUtils {
    public static final String TAG = YxpConfigUtils.class.getSimpleName();
    private static final boolean DEBUG_CONFIG = false;


    /**
     * @param cls   变量所在的类
     * @param file  配置所在根目录路径名称
     */
    private static void readConfig(Class<?> cls, String file) {
        File path = new File(Environment.getExternalStorageDirectory(), file);
        path.setReadable(true, true);
        if (path.exists() && !path.isDirectory()) {
            LineNumberReader lnr = null;
            try {
                lnr = new LineNumberReader(new FileReader(path));
                while (true) {
                    String line = lnr.readLine();
                    if (line == null) break;

                    String[] values = line.split("=");
                    if (values != null && values.length == 2) {
                        config(cls, values[0].trim(), values[1].trim());
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (lnr != null) {
                    try {
                        lnr.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * 注意：目前只支持String,int和boolean三种配置参数
     */
    private static void config(Class<?> orgClass, String name, String value) {
        try {
            Field f = orgClass.getDeclaredField(name);
            Class<?> cls = f.getType();
            YxpLogUtils.i(TAG, String.format("SET %s=%s,%s", name, value, cls));

            if (String.class.equals(cls)) {
                f.set(cls, value);
            } else if (int.class.equals(cls)) {
                f.setInt(cls, Integer.valueOf(value).intValue());
            } else {
                f.setBoolean(cls, "true".equalsIgnoreCase(value));
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    private static void printConfig(Class<?> cls) {
        Field[] fields = cls.getDeclaredFields();
        try {
            for (Field f : fields) {
                f.setAccessible(true);
				YxpLogUtils.i(TAG, String.format("%s=%s", f.getName(), f.get(cls)));
            }
		} catch (IllegalAccessException e) {
			e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param cls   变量所在的类
     * @param file  配置所在根目录路径名称
     */
    public static void initConfig(Class<?> cls, String file) {
        YxpConfigUtils.readConfig(cls, file);
        if (DEBUG_CONFIG) {
            YxpConfigUtils.printConfig(cls);
        }
    }
}
