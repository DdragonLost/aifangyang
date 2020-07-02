package com.aifangyang.study.thread;

import java.util.concurrent.TimeUnit;

public class InterruptDemo {
    private static int i;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            while (!(Thread.currentThread().isInterrupted())){ // 默认是false
                i++;
            }
            System.out.println("i:"+ i );
        });
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt(); // 把is_interrupted设置成true
    }
}