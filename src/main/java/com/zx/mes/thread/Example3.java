package com.zx.mes.thread;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;

/**
 * Created by Administrator on 2017/7/14.
 * http://www.cnblogs.com/onlywujun/p/3565082.html
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
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
