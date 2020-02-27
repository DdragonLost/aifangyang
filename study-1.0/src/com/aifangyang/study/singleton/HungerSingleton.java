package com.aifangyang.study.singleton;

/**
 * 饿汉式单例
 * 类初始化的时候创建实例
 * 不管是否调用，都创建实例，会有资源浪费
 */
public class HungerSingleton {
    private static final HungerSingleton instance = new HungerSingleton();
    private HungerSingleton(){
    }

    public static HungerSingleton getInstance(){
        return instance;
    }
}
