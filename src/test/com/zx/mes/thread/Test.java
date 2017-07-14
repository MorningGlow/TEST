package com.zx.mes.thread;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;

/**
 * Created by Administrator on 2017/7/14.
 */
public class Test {
    private static final Logger logger=Logger.getLogger(Test.class);

    @org.junit.Test
    public void test(){
        logger.info(JSON.toJSONStringWithDateFormat("test","yyyy-MM-dd HH:mm:ss"));
    }

    //这种测试环境与在main方法所做测试有所区别，当test测试完成后，有可能线程还没有执行
    //测试继承Thread
    @org.junit.Test
    public void test2(){
        logger.info(JSON.toJSONStringWithDateFormat(Thread.currentThread().getName(),"yyyy-MM-dd HH:mm:ss"));
        Mythread mythread=new Mythread();
        mythread.start();
    }

    //测试继承Runable
    @org.junit.Test
    public void test3(){
        logger.info(JSON.toJSONStringWithDateFormat(Thread.currentThread().getName(),"yyyy-MM-dd HH:mm:ss"));
        Thread t=new Thread(new MythreadWithRunable());
        t.start();
    }

    //中断测试
    @org.junit.Test
    public void test4() throws InterruptedException {
        Example example=new Example();
        Thread thread=new Thread(example);
        thread.start();
        thread.sleep(3000);
        logger.info(JSON.toJSONStringWithDateFormat("中断线程...","yyyy-MM-dd HH:mm:ss"));

        example.stop=true;
        thread.sleep(3000);

        logger.info(JSON.toJSONStringWithDateFormat("结束程序...","yyyy-MM-dd HH:mm:ss"));

  }
    //中断测试2(使用thread.interrupt()中断非阻塞状态线程，比test4简洁)
    @org.junit.Test
    public void test5() throws InterruptedException {
        Example2 example=new Example2();
        Thread thread=new Thread(example);
        thread.start();
        thread.sleep(3000);
        logger.info(JSON.toJSONStringWithDateFormat("中断线程...","yyyy-MM-dd HH:mm:ss"));
        //发出中断请求
        thread.interrupt();
        thread.sleep(3000);

        logger.info(JSON.toJSONStringWithDateFormat("结束程序...","yyyy-MM-dd HH:mm:ss"));

    }
}
