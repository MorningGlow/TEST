package com.zx.mes.proxy;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


/**
 * Created by Administrator on 2017/6/26.
 */
public class JKProxy implements InvocationHandler {

    private static final Logger logger=Logger.getLogger(JKProxy.class);

    private Object target;

    public JKProxy(){}

    public JKProxy(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        logger.info(JSON.toJSONStringWithDateFormat("method前:"+method,"yyyy-MM-dd HH:mm:ss"));
        Object result=method.invoke(target,args);
        logger.info(JSON.toJSONStringWithDateFormat(result,"yyyy-MM-dd HH:mm:ss"));

        logger.info(JSON.toJSONStringWithDateFormat("method后:"+method,"yyyy-MM-dd HH:mm:ss"));
        //可获得值 ，就可修改值
        return result;
    }
}
