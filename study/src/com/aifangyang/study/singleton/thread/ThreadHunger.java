package com.aifangyang.study.singleton.thread;

import com.aifangyang.study.singleton.HungerSingleton;
import com.aifangyang.study.singleton.InnerClassSingleton;
import com.aifangyang.study.singleton.LazySingleton;

public class ThreadHunger extends Thread implements Runnable
{

    @Override
    public void run()
    {
        // 饿汉式单例
        // HungerSingleton instance = HungerSingleton.getInstance();
        // 懒汉式单例
        InnerClassSingleton instance = InnerClassSingleton.getInstance();
        System.out.println(Thread.currentThread().getName()+">>>"+instance);
    }
}
