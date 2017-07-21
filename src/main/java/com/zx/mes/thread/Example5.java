package com.zx.mes.thread;


import org.apache.log4j.Logger;


/**
 * Created by Administrator on 2017/7/19.
 */
//作废
public class Example5 implements Runnable{

    private static final Logger logger=Logger.getLogger(Example5.class);

    private Object object;

    private int number=100;

    public Example5() {
    }

    public Example5(Object object) {
        this.object = object;
    }

    public void run() {

            test();

    }

    void test(){
        while (number>0){
            synchronized (object) {
                number--;
                System.out.println(Thread.currentThread().getName() + ": number: " + number);
            }
        }
    }

    //不知为何使用logger.info()不报错，也不抛异常，所以改为System.out.println("yyyy");
    //public void run() {
    //
    //    synchronized (this){
    //        System.out.println("xxxx");
    //        //logger.info(JSON.toJSONStringWithDateFormat("忆江南","yyyy-MM-dd HH:mm:ss"));
    //        //logger.info(JSON.toJSONStringWithDateFormat("忆江南","yyyy-MM-dd HH:mm:ss"));
    //        System.out.println("yyyy");
    //        //while (number>0){
    //        //    number--;
    //        //    logger.info(JSON.toJSONStringWithDateFormat(Thread.currentThread().getName()+" : i : "+number,
    //        //            "yyyy-MM-dd HH:mm:ss"));
    //        //}
    //        for (int i=0;i<5000;i++){
    //            number--;
    //            //logger.info(JSON.toJSONStringWithDateFormat(Thread.currentThread().getName()+" : i : "+number,
    //            //                    "yyyy-MM-dd HH:mm:ss"));
    //            System.out.println("number: " +number);
    //            try {
    //                Thread.sleep(1000);
    //            } catch (InterruptedException e) {
    //                e.printStackTrace();
    //            }
    //        }
    //
    //    }
    //
    //}
}
