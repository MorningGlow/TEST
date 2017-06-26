package com.zx.mes.proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.apache.log4j.Logger;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/6/26.
 */
public class CGProxy implements MethodInterceptor {

    private static final Logger logger=Logger.getLogger(CGProxy.class);



    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        return null;
    }
}
