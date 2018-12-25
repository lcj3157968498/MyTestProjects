//
// Created by lcj on 2018/9/11.
//
#include<jni.h>
#include<stdio.h>
//导入我们创建的头文件
#include "com_example_lcj_mytestprojects_JniDemo.h"


JNIEXPORT jstring JNICALL Java_com_example_lcj_mytestprojects_JniDemo_getJni
  (JNIEnv *env, jclass jclass){

    return (*env)->NewStringUTF(env,"This is my first NDK Application");
  };