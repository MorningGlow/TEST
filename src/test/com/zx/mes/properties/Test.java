package com.zx.mes.properties;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.Properties;

/**
 * Created by Administrator on 2017/6/26.
 */
public class Test {

    private static final Logger logger=Logger.getLogger(Test.class);

    @org.junit.Test
    public void test(){
        Properties prop=new Properties();
        InputStream in=Test.class.getClassLoader().getResourceAsStream("test.properties");
        try {
            prop.load(in);
            logger.info(JSON.toJSONStringWithDateFormat(prop.get("name"),"yyyy-MM-dd HH:mm:ss"));
            logger.info(JSON.toJSONStringWithDateFormat(prop.get("password"),"yyyy-MM-dd HH:mm:ss"));
            logger.info(JSON.toJSONStringWithDateFormat(prop.get("test"),"yyyy-MM-dd HH:mm:ss"));
            logger.info(JSON.toJSONStringWithDateFormat(prop.get("日月"),"yyyy-MM-dd HH:mm:ss"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void test2(){
        String path="C:\\Users\\Administrator.PC1138\\IdeaProjects\\TEST\\src\\main\\resources\\test.properties";
        try {
            InputStream in=new BufferedInputStream(new FileInputStream(path));
            Properties prop=new Properties();

            prop.load(in);
            logger.info(JSON.toJSONStringWithDateFormat(prop.get("test"),"yyyy-MM-dd HH:mm:ss"));
            logger.info(JSON.toJSONStringWithDateFormat(prop.get("name"),"yyyy-MM-dd HH:mm:ss"));
            logger.info(JSON.toJSONStringWithDateFormat(prop.get("password"),"yyyy-MM-dd HH:mm:ss"));
            logger.info(JSON.toJSONStringWithDateFormat(prop.get("日月"),"yyyy-MM-dd HH:mm:ss"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
