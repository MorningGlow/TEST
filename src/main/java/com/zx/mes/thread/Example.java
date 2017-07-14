package com.zx.mes.thread;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;

/**
 * Created by Administrator on 2017/7/14.
 */
public class Example implements Runnable {

    private static final Logger logger=Logger.getLogger(MythreadWithRunable.class);

    //线程中断信号量
    volatile boolean stop=false;

    public void run() {

        //第隔一秒检测一下中断信号量(使用中断信号量中断非阻塞状态的线程)
        //中断线程最好的，最受推荐的方式是，使用共享变量（shared variable）发出信号，告诉线程必须停止正在运行的任务。
        // 线程必须周期性的核查这一变量，然后有秩序地中止任务
        while (!stop){
            logger.info(JSON.toJSONStringWithDateFormat("Thread is running...","yyyy-MM-dd HH:mm:ss"));
            long time=System.currentTimeMillis();

            //使用while循环模拟sleep方法，这里不使用sleep，否则在阻塞时会抛InterruptedException异常而退出循环，这样while检测stop条件就不会执行
            while ((System.currentTimeMillis()-time)<1000){

            }
            logger.info(JSON.toJSONStringWithDateFormat("执行要做的事...","yyyy-MM-dd HH:mm:ss"));
        }
    }
}
