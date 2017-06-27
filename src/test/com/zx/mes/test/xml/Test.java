package com.zx.mes.test.xml;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.util.Iterator;

/**
 * Created by Administrator on 2017/6/27.
 */
public class Test {

    private static final Logger logger=Logger.getLogger(Test.class);

    @org.junit.Test
    public void test(){
        //创建一个xml解析器对象
        SAXReader reader=new SAXReader();
        try {
            //读取xml文档，返回Document对象
            Document doc=reader.read(Test.class.getClassLoader().getResourceAsStream("test.xml"));
            //获取当前标签节点下的所有子节点
            Iterator<Node> nodes=doc.nodeIterator();
            //logger.info(JSON.toJSONStringWithDateFormat(nodes,"yyyy-MM-dd HH:mm:ss"));
            while (nodes.hasNext()){
                Node node=nodes.next();
                logger.info(JSON.toJSONStringWithDateFormat(node,"yyyy-MM-dd HH:mm:ss"));
                logger.info(JSON.toJSONStringWithDateFormat(node.getName(),"yyyy-MM-dd HH:mm:ss"));//根节点

            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void test2(){
        //创建一个xml解析器对象
        SAXReader reader=new SAXReader();
        try {
            //读取xml文档，返回Document对象
            Document doc=reader.read(Test.class.getClassLoader().getResourceAsStream("test.xml"));
            //获得xml文档的根标签(一般创建doc对象后先调用此方得到根节标签)
            Element element=doc.getRootElement();
            logger.info(JSON.toJSONStringWithDateFormat(element.getName(),"yyyy-MM-dd HH:mm:ss"));//根节点
            logger.info(JSON.toJSONStringWithDateFormat(element.getText(),"yyyy-MM-dd HH:mm:ss"));//根节点
            //指定获取名称 **第一个** 子标签
            Element element2=element.element("display-name");
            logger.info(JSON.toJSONStringWithDateFormat(element2.getText(),"yyyy-MM-dd HH:mm:ss"));//根节点
            //获取属性值

            //获取属性

            //指定获取名称 **所有** 子标签  //如果无指定，那么就是所有子标签
            Iterator<Element> elements=element.elementIterator("welcome-file-list");
            while (elements.hasNext()){
                logger.info(JSON.toJSONStringWithDateFormat(elements.next().getText(),"yyyy-MM-dd HH:mm:ss"));//根节点
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
