#include <jni.h>
#include <string>
using namespace  std;

extern "C" JNIEXPORT jstring JNICALL
Java_com_ceconcatenator3000_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject/* this */,
        jstring palabra1,
        jstring palabra2){
    const char* p1= env->GetStringUTFChars(palabra1, nullptr);
    const char* p2= env->GetStringUTFChars(palabra2, nullptr);

    std::string resultado = std::string(p1) + "" + std::string (p2);

    env->ReleaseStringUTFChars(palabra1, p1);
    env->ReleaseStringUTFChars(palabra2, p2);

    return env->NewStringUTF(resultado.c_str());



}