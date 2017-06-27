package com.zx.mes.test.xml;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.*;
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
            String strValue=element.attributeValue("display-name");
            //获取属性
            Attribute attr=element.attribute("display-name");
            //指定获取名称 **所有** 子标签  //如果无指定，那么就是所有子标签
            Iterator<Element> elements=element.elementIterator("welcome-file-list");
            while (elements.hasNext()){
                logger.info(JSON.toJSONStringWithDateFormat(elements.next().getText(),"yyyy-MM-dd HH:mm:ss"));//根节点
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }


    public void test3() throws DocumentException, IOException {
        //只是样例，不做测试
        //1、读取文件
        Document doc = new SAXReader().read(new File("xxx.xml"));
         //2、修改文件

         //3、写出文件
         FileOutputStream out = new FileOutputStream("f:/xxx.xml");//指定文件输出的位置
         //指定写出的格式
         OutputFormat format = OutputFormat.createCompactFormat(); //紧凑的格式.去除空格换行.
         //OutputFormat format = OutputFormat.createPrettyPrint(); //格式好的格式.有空格和换行.
         format.setEncoding("utf-8");//2.指定生成的xml文档的编码
         XMLWriter writer = new XMLWriter(out,format);//创建写出对象
         writer.write(doc);//写出对象
         writer.close();//关闭流

    }
}
