package com.zx.mes.test.reflect;

import com.alibaba.fastjson.JSON;
import com.sun.xml.internal.bind.v2.TODO;
import com.zx.mes.proxy.dao.IDao;
import com.zx.mes.reflect.Person;
import org.apache.log4j.Logger;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by Administrator on 2017/6/28.
 */
public class Test {

    private static final Logger logger=Logger.getLogger(Test.class);

    //logger.info(JSON.toJSONStringWithDateFormat("","yyyy-MM-dd HH:mm:ss"));

    @org.junit.Test
    public void test(){
        //三种使用
        Class clazz= Person.class;
        Class clazz2=new Person().getClass();
        Class clazz3=null;
        try {
            clazz3=Class.forName("com.zx.mes.reflect.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        logger.info(JSON.toJSONStringWithDateFormat(clazz,"yyyy-MM-dd HH:mm:ss"));
        logger.info(JSON.toJSONStringWithDateFormat(clazz2,"yyyy-MM-dd HH:mm:ss"));
        logger.info(JSON.toJSONStringWithDateFormat(clazz3,"yyyy-MM-dd HH:mm:ss"));
    }

    @org.junit.Test
    public void test2(){
        Class clazz=null;
        try {
            clazz=Class.forName("com.zx.mes.reflect.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            try {
                Person person= (Person) clazz.getConstructor(new Class[]{String.class,String.class,int.class}).newInstance(new  Object[]{"小明","密码",22});
                logger.info(JSON.toJSONStringWithDateFormat(person.toString(),"yyyy-MM-dd HH:mm:ss"));
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

    @org.junit.Test
    public void test3(){
        Class clazz=null;
        try {
            clazz=Class.forName("com.zx.mes.reflect.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Field[] fields=clazz.getFields();
        for (int i=0;i<fields.length;i++){
            logger.info(JSON.toJSONStringWithDateFormat(fields[i],"yyyy-MM-dd HH:mm:ss"));
        }

    }

    //字段
    @org.junit.Test
    public void test4(){
        Class clazz=null;
        try {
            clazz=Class.forName("com.zx.mes.reflect.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Field[] fields=clazz.getDeclaredFields();
        for (int i=0;i<fields.length;i++){
            //logger.info(JSON.toJSONStringWithDateFormat(fields[i],"yyyy-MM-dd HH:mm:ss"));
            //logger.info(JSON.toJSONStringWithDateFormat(fields[i].getName()+" 修饰符: "+ Modifier.toString(fields[i].getModifiers()) +" 变量类型: " +fields[i].getType().getName(),"yyyy-MM-dd HH:mm:ss"));
            logger.info(JSON.toJSONStringWithDateFormat( Modifier.toString(fields[i].getModifiers()) + " " +fields[i].getType().getName()+" " +fields[i].getName()+";","yyyy-MM-dd HH:mm:ss"));
            //fields[i].setAccessible(true);
            //TODO 如logger应如何处理;
        }

    }
    //方法
    @ org.junit.Test
    public void test5(){
        Class clazz=null;
        try {
            clazz=Class.forName("com.zx.mes.reflect.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Method [] methods=clazz.getDeclaredMethods();
        for (int i=0;i<methods.length;i++){
            //logger.info(JSON.toJSONStringWithDateFormat(methods[i],"yyyy-MM-dd HH:mm:ss"));
            //logger.info(JSON.toJSONStringWithDateFormat(methods[i].getName()+" : "+ Modifier.toString(methods[i].getModifiers())+" : "+methods[i].getGenericParameterTypes(),"yyyy-MM-dd HH:mm:ss"));
            logger.info(JSON.toJSONStringWithDateFormat("方法名:"+methods[i].getName(),"yyyy-MM-dd HH:mm:ss"));
            logger.info(JSON.toJSONStringWithDateFormat("修饰符:"+Modifier.toString(methods[i].getModifiers()),"yyyy-MM-dd HH:mm:ss"));
            logger.info(JSON.toJSONStringWithDateFormat("返回类型:"+methods[i].getGenericReturnType(),"yyyy-MM-dd HH:mm:ss"));
            Class[] classes=methods[i].getParameterTypes();
            for (int j=0;j<classes.length;j++){
                logger.info(JSON.toJSONStringWithDateFormat("参数:"+classes[j].getName(),"yyyy-MM-dd HH:mm:ss"));
            }
            logger.info(JSON.toJSONStringWithDateFormat("-------------------------------------------------------------------","yyyy-MM-dd HH:mm:ss"));
        }
    }

    //接口
    @org.junit.Test
    public  void test6(){
        Class clazz=null;
        try {
            clazz=Class.forName("com.zx.mes.reflect.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Class[] classes=clazz.getInterfaces();
        logger.info(JSON.toJSONStringWithDateFormat(classes.length,"yyyy-MM-dd HH:mm:dd"));

        for (int i=0;i<classes.length;i++){
            logger.info(JSON.toJSONStringWithDateFormat(classes[i].getSimpleName(),"yyyy-MM-dd HH:mm:dd"));
        }
    }

    //TODO 构造方法等

}
