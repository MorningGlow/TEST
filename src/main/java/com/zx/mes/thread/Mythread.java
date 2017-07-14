package com.zx.mes.thread;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;

/**
 * Created by Administrator on 2017/7/14.
 */
public class Mythread extends Thread{

    private static final Logger logger=Logger.getLogger(Mythread.class);

    @Override
    public void run() {
        for (int i=0;i<50;i++){
            logger.info(JSON.toJSONStringWithDateFormat(Thread.currentThread().getName()+" : " + i,"yyyy-MM-dd " +
                    "HH:mm:ss"));
        }
    }
}
