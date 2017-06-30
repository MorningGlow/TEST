package com.zx.mes.reflect;

import com.alibaba.fastjson.JSON;
import com.zx.mes.proxy.dao.IDao;
import org.apache.log4j.Logger;

/**
 * Created by Administrator on 2017/6/28.
 */
public class Person implements IDao {

    private static final Logger logger=Logger.getLogger(Person.class);

    private String name;
    private String password;
    private int age;

    public String  ren;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person() {}

    public Person(String name, String password, int age) {
        this.name = name;
        this.password = password;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }

    private void test(){
        logger.info(JSON.toJSONStringWithDateFormat("test","yyyy-MM-dd HH:mm:ss"));
    }

    public void say(){
        logger.info(JSON.toJSONStringWithDateFormat("say","yyyy-MM-dd HH:mm:ss"));
    }

    public void delete(String id) {

    }

    public String find(String id) {
        return null;
    }
}
