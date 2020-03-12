package com.aifangyang.study.thread;

public class AtomicDemo {
    private static int count = 0;

    // 线程安全
    // 加锁 最早是数据库的相关知识
    // 互斥锁 访问共享资源的时候，
    // 谁先获取之后，其他的无法获取锁，
    // 对应Java中的 synchronized 重量级锁
    // 对锁优化的目的是 既要保证安全，也要报纸效率 两者存在冲突，从中找到中间点
    // synchronized 1、修饰实例方法；2、修饰静态方法；3、修饰代码块
    // 锁控制的范围是由对象的生命周期决定的
    public static void incr(){
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
    }

    public static void main(String[] args) throws InterruptedException {
        for(int i=0;i<1000;i++){
            new Thread(()->AtomicDemo.incr()).start();
        }
        Thread.sleep(5000);
        System.out.println(count);
    }
}
