package com.zx.mes.thread;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;

/**
 * Created by Administrator on 2017/7/15.
 */
public class Example4 implements Runnable{

    private static final Logger logger=Logger.getLogger(Example4.class);

    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i=0;i<50;i++){
            logger.info(JSON.toJSONStringWithDateFormat("执行..."+i,"yyyy-MM-dd HH:mm:ss"));
        }
        logger.info(JSON.toJSONStringWithDateFormat("执行完成...","yyyy-MM-dd HH:mm:ss"));
    }
}
