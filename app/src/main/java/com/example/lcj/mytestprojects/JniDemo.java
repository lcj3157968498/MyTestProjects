package com.example.lcj.mytestprojects;

/**
 * Created by XCL on 2018/9/11.
 * Description:
 */
public class JniDemo {
    public static native String getJni();
    static {
        System.loadLibrary("MyLibrary");
    }
}
