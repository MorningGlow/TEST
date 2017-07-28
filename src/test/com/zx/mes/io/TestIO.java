package com.zx.mes.io;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;

import org.junit.Test;


import java.io.*;


/**
 * Created by Administrator on 2017/7/27.
 * 测试IO
 *
 * C:/Users\Administrator.PC1138/Desktop
 */
public class TestIO {

    private static final Logger logger=Logger.getLogger(TestIO.class);

    @org.junit.Test
    public void test(){
        logger.info(JSON.toJSONStringWithDateFormat("测试OK","yyyy-MM-dd HH:mm:ss"));
    }

    @org.junit.Test
    public void test2(){
        InputStream in=null;
        OutputStream out=null;
        try {
            in=new FileInputStream(new File("C:\\Users\\Administrator.PC1138\\IdeaProjects\\TEST\\src\\main\\java\\com\\zx\\mes\\proxy\\JKProxy.java"));
            //out=new FileOutputStream(new File("C:/Users/Administrator.PC1138/Desktop/java.txt"),true);//在后面直接加所写的内容
            out=new FileOutputStream(new File("C:/Users/Administrator.PC1138/Desktop/java.txt"),false);
            byte[] buffer=new byte[1024];

            while (in.read(buffer)!=-1) {
                logger.info(JSON.toJSONStringWithDateFormat(new String(buffer),"yyyy-MM-dd HH:mm:ss"));
                //buffer是字节文件，如查不是得转
                //byte[] b="msg".getBytes();
                out.write(buffer);
            }

        } catch (FileNotFoundException e) {
            logger.debug(JSON.toJSONStringWithDateFormat("文件路径找不到:","yyyy-MM-dd HH:mm:ss"));
        } catch (IOException e) {
            logger.debug(JSON.toJSONStringWithDateFormat("读写文件时异常:","yyyy-MM-dd HH:mm:ss"));
        }finally {

            try {
                in.close();
                out.flush();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @org.junit.Test
    public void test3() throws IOException {

        BufferedInputStream bin=new BufferedInputStream(new FileInputStream("C:\\Users\\Administrator.PC1138\\IdeaProjects\\TEST\\src\\main\\java\\com\\zx\\mes\\proxy\\JKProxy.java"));
        BufferedOutputStream bout=new BufferedOutputStream(new FileOutputStream("C:/Users/Administrator.PC1138/Desktop/java.txt"));

        //正常
        //int r;
        //while ((r=bin.read())!=-1) {
        //    logger.info(JSON.toJSONStringWithDateFormat((char)r,"yyyy-MM-dd HH:mm:ss"));
        //    bout.write(r);
        //}

        byte[] b=new byte[1];//128时有问题
        while (bin.read(b)!=-1) {
            logger.info(JSON.toJSONStringWithDateFormat(new String(b),"yyyy-MM-dd HH:mm:ss"));
            bout.write(b);
        }

        bin.close();
        bout.flush();
        bout.close();
    }

    //字符读写
    @Test
    public void test4() throws IOException {

        BufferedReader br=new BufferedReader(new FileReader("C:\\Users\\Administrator" +
                ".PC1138\\IdeaProjects\\TEST\\src\\main\\java\\com\\zx\\mes\\proxy\\JKProxy.java"));
        BufferedWriter bw=new BufferedWriter(new FileWriter("C:/Users/Administrator.PC1138/Desktop/java.txt"));

        String temp;
        while ((temp=br.readLine()) !=null) {
            logger.info(JSON.toJSONStringWithDateFormat(temp,"yyyy-MM-dd HH:mm:ss"));
            bw.write(temp);
        }

        br.close();
        bw.flush();
        bw.close();
    }
}


