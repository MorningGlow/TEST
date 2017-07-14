package com.zx.mes.thread;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;

/**
 * Created by Administrator on 2017/7/14.
 */
public class Example2 implements Runnable {

    private static final Logger logger=Logger.getLogger(Example2.class);

    //
    public void run() {
        //每隔一秒检测是否设置了中断标示
        while (!Thread.currentThread().isInterrupted()){
            logger.info(JSON.toJSONStringWithDateFormat("Thread is running...","yyyy-MM-dd HH:mm:ss"));
            long time=System.currentTimeMillis();

            //使用while循环模拟sleep方法，这里不使用sleep，否则在阻塞时会抛InterruptedException异常而退出循环，这样while检测stop条件就不会执行
            while ((System.currentTimeMillis()-time)<1000){

            }
            logger.info(JSON.toJSONStringWithDateFormat("执行要做的事...","yyyy-MM-dd HH:mm:ss"));
        }
    }
}
