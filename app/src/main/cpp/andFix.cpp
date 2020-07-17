#include <jni.h>
#include "art_7_0.h"

extern "C" JNIEXPORT void JNICALL
Java_io_github_xfzhjnc_andfixproject_AndFixManager_andFixMethod(JNIEnv* env,
        jclass clazz, jobject src_method, jobject dst_method) {

    art::mirror::ArtMethod* meth = (art::mirror::ArtMethod*) env->FromReflectedMethod(src_method);
    art::mirror::ArtMethod* target = (art::mirror::ArtMethod*) env->FromReflectedMethod(dst_method);

    target->declaring_class_ = meth->declaring_class_;
    target->access_flags_ = meth->access_flags_;
    target->dex_code_item_offset_ = meth->dex_code_item_offset_;
    target->dex_method_index_ = meth->dex_method_index_;
    target->method_index_ = meth->method_index_;
    target->hotness_count_ = meth->hotness_count_;
    target->ptr_sized_fields_.dex_cache_resolved_types_ = meth->ptr_sized_fields_.dex_cache_resolved_types_;
    target->ptr_sized_fields_.dex_cache_resolved_methods_ = meth->ptr_sized_fields_.dex_cache_resolved_methods_;
    target->ptr_sized_fields_.entry_point_from_jni_ = meth->ptr_sized_fields_.entry_point_from_jni_;
    target->ptr_sized_fields_.entry_point_from_quick_compiled_code_ = meth->ptr_sized_fields_.entry_point_from_quick_compiled_code_;
}

