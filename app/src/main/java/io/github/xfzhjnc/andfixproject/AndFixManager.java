package io.github.xfzhjnc.andfixproject;

import java.lang.reflect.Method;

public class AndFixManager {

    static {
        System.loadLibrary("native_lib");
    }

    public static native void calculatedArtMethod(Method m1, Method m2);

    public static native void andFixMethod(Method srcMethod, Method dstMethod);

}
