package com.aifangyang.study;

import java.util.concurrent.LinkedBlockingQueue;

public class PreProcessor extends Thread implements IReuqestProccessor{
    // 阻塞队列
    LinkedBlockingQueue<Request> requests = new LinkedBlockingQueue<>();

    private IReuqestProccessor nextPorcessor;

    private volatile boolean isFinish = false;

    public PreProcessor(){

    }

    public PreProcessor(IReuqestProccessor nextPorcessor){
        this.nextPorcessor = nextPorcessor;
    }

    public void shutDown(){
        isFinish = true;
    }

    @Override
    public void run() {
        while(!isFinish){
            try {
                Request take = requests.take();// 阻塞式获取数据
                // 真正处理逻辑
                System.out.println("preProcessor : "+ take);
                // 交给责任链的下个节点
                nextPorcessor.processor(take);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void processor(Request request) {
        // TODO 根据实际需求进行处理
        // 验证请求参数
        requests.add(request);
    }
}
