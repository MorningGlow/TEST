package com.zx.mes.test;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2017/6/23.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {})
public class Test {
    private static final Logger logger=Logger.getLogger(Test.class);
    @org.junit.Test
    public void test(){
        logger.info(JSON.toJSONStringWithDateFormat("测试","yyyy-MM-dd HH:mm:dd"));
    }
    @org.junit.Test
    public void test2(){

    }
}
