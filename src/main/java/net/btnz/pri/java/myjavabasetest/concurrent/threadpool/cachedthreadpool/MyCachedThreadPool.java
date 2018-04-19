package net.btnz.pri.java.myjavabasetest.concurrent.threadpool.cachedthreadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhangsongwei on 2016/12/21.
 */
public class MyCachedThreadPool {
    public static void main(String[] args){
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for(int i = 0; i < 10; i++){
            final int index = i;
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            cachedThreadPool.execute(new Runnable(){
                @Override
                public void run(){
                    System.out.println(index + " " + Thread.currentThread().getId());
                }
            });
        }
        cachedThreadPool.shutdown();
    }
}
