package com.aifangyang.study.thread;

import java.util.concurrent.TimeUnit;

public class ThreadStatusDemo {
    /*
     * 1、下载hotspot源码
     * 2、start0的方法
     * 3、底层基于OS创建线程并启动线程
     * 4、线程终止的方法
     */

    public static void main(String[] args) {
        new Thread(()->{
            while (true){
                try {
                    TimeUnit.SECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"Time_Waiting_Thread").start();
        new Thread(()->{
            while (true){
                synchronized (ThreadStatusDemo.class){
                    try {
                        ThreadStatusDemo.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"Waiting_Thread").start();

        // BLOCKED

        new Thread(new BlockedDemo(),"Blocked01_Thread").start();
        new Thread(new BlockedDemo(),"Blocked02_Thread").start();
    }

    static class BlockedDemo extends Thread {
        @Override
        public void run() {
            synchronized (BlockedDemo.class){
                while(true){
                    try {
                        TimeUnit.SECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
