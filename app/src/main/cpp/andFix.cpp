#include <jni.h>
#include "art_7_0.h"

size_t art_method_length = 0;

extern "C" JNIEXPORT void JNICALL
Java_io_github_xfzhjnc_andfixproject_AndFixManager_andFixMethod(JNIEnv* env,
        jclass clazz, jobject src_method, jobject dst_method) {

    jmethodID meth = env->FromReflectedMethod(src_method);
    jmethodID target = env->FromReflectedMethod(dst_method);
    memcpy(target, meth, art_method_length);

}

extern "C" JNIEXPORT void JNICALL
Java_io_github_xfzhjnc_andfixproject_AndFixManager_calculatedArtMethod(JNIEnv *env,
        jclass clazz, jobject m1, jobject m2) {

    size_t method1Ptr =  (size_t)env->FromReflectedMethod(m1);
    size_t method2Ptr =  (size_t)env->FromReflectedMethod(m2);
    art_method_length = method2Ptr - method1Ptr;

}