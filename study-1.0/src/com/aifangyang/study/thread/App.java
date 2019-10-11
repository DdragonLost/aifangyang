package com.aifangyang.study.thread;

public class App{
    static IReuqestProccessor reuqestProccessor;
    /*
     * 线程可以合理应用多核CPU资源，提高程序吞吐量
     * 1、Thread类本质是实现Runnable接口
     * 2、Callable/Future带返回值的线程
     * 3、线程池（ThreadPool）管理线程
     */


    /* 实际应用
     * 线程池
     * new Thread()
     * 文件跑批 收益文件、对账 付款信息核对
     * BIO模型优化
     * socket socket = socket.accept() link阻塞
     * socket.inputstream(); read阻塞
     * socket.outputstream(); write阻塞
     * new Thread(new handler(socket)).start() 解决r/w阻塞问题
     */

    /*
     * 所有和阻塞相关的方法，都会跑出一个异常
     * InterruptedException
     * 工作中 使用了异步消息队列去解决了
     */

    /*
     * 线程状态一共六种
     * NEW--->> RUNNABLE BLOCKED（出现锁抢占的时候才会出现） WAITING TIMED_WAITING--->>TERMINATED
     * yield让出当前线程占用的时间片
     * bolcked 执行synchronize修饰的代码块，t1和t2都去调用 t1获得了锁，则t2返回blocked
     * waiting （sleep\wait\join\LockSupport.park) 通过notify、notifyAll、LockSupport.unpark返回执行状态
     * time_waiting是带时间的等待，指的是超出指定时间则会放弃等待
     */
    public void setUp(){
        SaveProcessor saveProcessor = new SaveProcessor();
        saveProcessor.start();
        PrintProcessor printProcessor = new PrintProcessor(saveProcessor);
        printProcessor.start();
        reuqestProccessor = new PreProcessor(printProcessor);
        ((PreProcessor) reuqestProccessor).start();
    }

    public static void main(String[] args) {
        App app = new App();
        app.setUp();
        Request request = new Request();
        request.setName("Request");
        reuqestProccessor.processor(request);
    }
}
