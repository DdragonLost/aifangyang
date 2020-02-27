package com.aifangyang.study.singleton;

import java.io.Serializable;

/**
 * 懒汉式单例
 * 首次调用的时候创建
 */
public class LazySingleton implements Serializable
{
    private volatile static LazySingleton instance=null;
    private LazySingleton()
    {

    }

    // 非线程安全
    /*public static LazySingleton getInstance(){
        if(instance==null){
            instance = new LazySingleton();
        }
        return instance;
    }*/

    // 线程安全 浪费资源
    /*public static synchronized LazySingleton getInstance(){
        if(instance==null){
            instance = new LazySingleton();
        }
        return instance;
    }*/

    // 双重校验
    public static LazySingleton getInstance(){
        if(instance==null){
            synchronized (LazySingleton.class){
                if(instance==null){
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }

    /**
     * 防止序列化和反序列化破坏单例
     * @return
     */
    private Object readResolve() {
        return instance;
    }
}
