package com.aifangyang.study.singleton;

/**
 * 内部类实现单例
 * 利用了Java的特性，代码更优雅
 * 反射会破坏单例
 */
public class InnerClassSingleton {

    private InnerClassSingleton(){
    }
    public static InnerClassSingleton getInstance(){
        return InnerClssHolder.instance;
    }
    private static class InnerClssHolder{
        private static final InnerClassSingleton instance = new InnerClassSingleton();

    }
}
