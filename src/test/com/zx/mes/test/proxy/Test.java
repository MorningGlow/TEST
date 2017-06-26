package com.zx.mes.test.proxy;

import com.alibaba.fastjson.JSON;
import com.zx.mes.proxy.CGProxy;
import com.zx.mes.proxy.JKProxy;
import com.zx.mes.proxy.dao.IDao;
import com.zx.mes.proxy.dao.impl.DaoImpl;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.apache.log4j.Logger;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Administrator on 2017/6/26.
 */
public class Test {
    private static final Logger logger=Logger.getLogger(com.zx.mes.test.Test.class);
    @org.junit.Test
    public void test(){
        IDao dao= (IDao) Proxy.newProxyInstance(DaoImpl.class.getClassLoader(),new Class[]{IDao.class},new JKProxy(new DaoImpl()));
        dao.delete("这是专业测试30年");

        dao.find("这是调用查询的方法");

    }

    @org.junit.Test
    public void test2(){
        IDao dao=(IDao) Proxy.newProxyInstance(DaoImpl.class.getClassLoader(), new Class[]{IDao.class}, new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object result=method.invoke(new DaoImpl(),args);
                return null;
            }
        });
        dao.find("xxxx");
    }

    @org.junit.Test
    public void test3(){
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(DaoImpl.class);
        enhancer.setCallback(new CGProxy());

        DaoImpl dao= (DaoImpl) enhancer.create();

        dao.find("xx");

    }


    @org.junit.Test
    public void test4(){
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(DaoImpl.class);
        enhancer.setCallback(new MethodInterceptor() {
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                logger.info(JSON.toJSONStringWithDateFormat("方法执行前","yyyy-MM-dd HH:mm:ss"));
                Object result=methodProxy.invokeSuper(o,objects);
                logger.info(JSON.toJSONStringWithDateFormat("方法执行后,方法返回值:"+result,"yyyy-MM-dd HH:mm:ss"));
                return null;
            }
        });

        DaoImpl dao=(DaoImpl) enhancer.create();
        dao.find(" xx");
    }
}
