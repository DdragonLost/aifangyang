package com.aifangyang.study.thread;

import java.util.concurrent.TimeUnit;

public class ExceptionThreadDemo {
    private static int i;
    // thread.interrupt(); 属于当前线程，不会立即中断 由自身决定 复位
    // wait、sleep、join。。。都属于阻塞方法
    //
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) { // 默认是false
                try {
                    TimeUnit.SECONDS.sleep(2); // 中断一个处于阻塞状态的线程 join/wait/queue.take
                    System.out.println("XXXXXXX");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;  // 只是跳出While循环
                }
            }
            System.out.println("i:>>>>>"+i);
        });
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt(); // 把is_interrupted设置成true
        System.out.println(thread.isInterrupted());
    }
}
