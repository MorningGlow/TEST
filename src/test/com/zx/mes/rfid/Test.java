package com.zx.mes.rfid;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;

/**
 * Created by Administrator on 2017/7/7.
 * http://www.cnblogs.com/lanxuezaipiao/p/3635556.html
 * https://team.oschina.net/
 */

public class Test {

    private static final Logger logger=Logger.getLogger(Test.class);

    @org.junit.Test
    public void test(){
        logger.info(JSON.toJSONStringWithDateFormat("test","yyyy-MM-dd HH:mm:ss"));
    }

    @org.junit.Test
    public void test2(){

        try {
            logger.info(JSON.toJSONStringWithDateFormat(System.getProperty("java.library.path"),"yyyy-MM-dd HH:mm:ss"));
            //logger.info(JSON.toJSONStringWithDateFormat(Rfid.CLibrary.instance.,"yyyy-MM-dd HH:mm:ss"));

            Rfid.CLibrary.instance.ConnectAndLogin("10.30..",23,"alien","password");
        }catch (Exception e){
            logger.info(JSON.toJSONStringWithDateFormat("异常","yyyy-MM-dd HH:mm:ss"));
        }


        logger.info(JSON.toJSONStringWithDateFormat("已连接上","yyyy-MM-dd HH:mm:ss"));

    }
}
