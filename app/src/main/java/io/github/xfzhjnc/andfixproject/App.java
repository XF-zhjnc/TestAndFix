package io.github.xfzhjnc.andfixproject;

import android.app.Application;
import android.content.Context;

import java.lang.reflect.Method;

import dalvik.system.DexClassLoader;
import io.github.xfzhjnc.andfixproject.test.WrongMethodClass;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        startAndFix(this);
    }

    private static String fixDexPath = "file:///android_asset/right.dex";

    public static void startAndFix(Context context) {
        try {
            Class<?> clazz = loadRightMethodClass(context);
            Method srcMethod = clazz.getMethod("getRightInteger", int.class, int.class);
            Method dstMethod = WrongMethodClass.class.getMethod("getWrongInteger", int.class, int.class);

            AndFixManager.andFixMethod(srcMethod, dstMethod);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

    //从assets目录中加载dex文件中的正确方法的类
    private static Class<?> loadRightMethodClass(Context context) {
        DexClassLoader rightClassLoader = new DexClassLoader(fixDexPath, context.getDir("dex", Context.MODE_PRIVATE).getAbsolutePath(), null, context.getClassLoader());
        Class<?> clazz = null;
        try {
            clazz = rightClassLoader.loadClass("io.github.xfzhjnc.andfixproject.test.RightMethodClass");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return clazz;
    }

}
