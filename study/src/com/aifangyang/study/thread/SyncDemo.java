package com.aifangyang.study.thread;

public class SyncDemo {
    // synchronized 1、修饰实例方法；2、修饰静态方法；3、修饰代码块
    // 锁控制的范围是由对象的生命周期决定的
    // 参照数据库的表锁和行锁的区别
    // 对象锁和类锁，是否跨线程

    public synchronized void demo01(){
    }

    public void demo02(){
        // TODO
        synchronized (this){
            // 只需要保护线程安全的变量
        }
        // TODO
    }

    public void demo04(){
        // TODO
        synchronized (SyncDemo.class){
            // 只需要保护线程安全的变量
        }
        // TODO
    }

    public synchronized static void demo03(){

    }

    public static void main(String[] args) {
        SyncDemo syncDemo01 = new SyncDemo();
        SyncDemo syncDemo02 = new SyncDemo();
        new Thread(()->syncDemo01.demo01()).start();
        new Thread(()->syncDemo02.demo01()).start();

    }
}
