package com.zx.mes.thread;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;

/**
 * Created by Administrator on 2017/7/14.
 *
 */
public class Example3 implements Runnable{

    private static final Logger logger=Logger.getLogger(Example3.class);

    public void run() {

        while (!Thread.currentThread().isInterrupted()){
            logger.info(JSON.toJSONStringWithDateFormat("Thread running...","yyyy-MM-dd HH:mm:ss"));

            try {
                //如果线程阻塞，将不会去检查中断信号量变量，所 以thread.interrupt()
                // 会使阻塞线程从阻塞的地方抛出异常，让阻塞线程从阻塞状态逃离出来，并
                //进入异常块进行 相应的处理
                Thread.sleep(1000);//线程阻塞，如果线程收到中断操作信号将抛出异常
            } catch (InterruptedException e) {
                logger.info(JSON.toJSONStringWithDateFormat("线程中断","yyyy-MM-dd HH:mm:ss"));
                //如果线程在调用Object.wait()方法，或者join(),sleep()方法
                //过程中，则其中断状将被清除
                //
                 logger.info(JSON.toJSONStringWithDateFormat("此时线程的中断状态: "+Thread.currentThread().isInterrupted(),
                         "yyyy-MM-dd" +
                         " " +
                         "HH:mm:ss"));
                 //如若要中断线程，则需要重新设置中断位，如果不需要，则不用再调用
                 //需要中断调以下方法
                Thread.currentThread().interrupt();
            }
            logger.info(JSON.toJSONStringWithDateFormat("要执行的事...","yyyy-MM-dd HH:mm:ss"));
        }
    }
}
