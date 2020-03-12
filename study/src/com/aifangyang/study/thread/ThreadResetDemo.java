package com.aifangyang.study.thread;

import java.util.concurrent.TimeUnit;

public class ThreadResetDemo {
    // 1、Thread.interrupted
    // 2、InterruptedExceprion

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true) { // 默认是false
                if(Thread.currentThread().isInterrupted()){
                    System.out.println("before:"+ Thread.currentThread().isInterrupted());
                    Thread.interrupted();
                    System.out.println("after:"+ Thread.currentThread().isInterrupted());
                }
            }
        });
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt(); // 把is_interrupted设置成true
    }
}
