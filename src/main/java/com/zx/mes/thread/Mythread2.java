package com.zx.mes.thread;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;

/**
 * Created by Administrator on 2017/7/21.
 */
public class Mythread2 {

    private static final Logger logger=Logger.getLogger(Mythread2.class);

    private int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void test(){
        synchronized (this){
            while (number>0){
                number=number-1;
                //logger.info(JSON.toJSONStringWithDateFormat(Thread.currentThread().getName()+" : number: "+number,
                //        "yyyy-MM-dd HH:mm:ss"));
                System.out.println(Thread.currentThread().getName()+" : number: "+number);

            }
        }

    }

    public void test2(){
        synchronized (this){
            while (number>0){
                number--;
                //logger.info(JSON.toJSONStringWithDateFormat(Thread.currentThread().getName()+" : number: "+number,
                //        "yyyy-MM-dd HH:mm:ss"));
                System.out.println(Thread.currentThread().getName()+" : number: "+number);
                //try {
                //    Thread.sleep(500);
                //} catch (InterruptedException e) {
                //    System.out.println("中断异常");
                //}
            }
        }
    }
}
