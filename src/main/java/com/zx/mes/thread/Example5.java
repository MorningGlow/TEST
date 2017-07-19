package com.zx.mes.thread;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;

import javax.swing.*;

/**
 * Created by Administrator on 2017/7/19.
 */
public class Example5 implements Runnable{

    private static final Logger logger=Logger.getLogger(Example5.class);

    private Object object;

    private int number=20;

    public Example5() {
    }

    public Example5(Object object) {
        this.object = object;
    }

    public void run() {

        synchronized (this){
            logger.info(JSON.toJSONStringWithDateFormat("忆江南","yyyy-MM-dd HH:mm:ss"));
            //while (number>0){
            //    number--;
            //    logger.info(JSON.toJSONStringWithDateFormat(Thread.currentThread().getName()+" : i : "+number,
            //            "yyyy-MM-dd HH:mm:ss"));
            //}
            for (int i=0;i<5000;i++){
                number--;
                logger.info(JSON.toJSONStringWithDateFormat(Thread.currentThread().getName()+" : i : "+number,
                                    "yyyy-MM-dd HH:mm:ss"));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}
