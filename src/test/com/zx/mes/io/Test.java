package com.zx.mes.io;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/26.
 * 对文件File  遍历文件的方法getDirectories
 * IO流进行测试
 */
public class Test {
    private static final Logger logger=Logger.getLogger(Test.class);

    @org.junit.Test
    public void test(){
        logger.info(JSON.toJSONStringWithDateFormat("测试OK","yyyy-MM-dd HH:mm:ss"));
    }

    //当然还有其它的一些构造函数及方法(如获取文件的详细信息，修改文件的状态，操作路径等等)
    @org.junit.Test
    public void test2(){
        File file=new File("C:\\Users\\Administrator.PC1138\\IdeaProjects\\TEST");
        logger.info(JSON.toJSONStringWithDateFormat("目录或者文件名:"+file.getName(),"yyyy-MM-dd HH:mm:ss"));

    }

    //遍历某个文件下所有的文件
    //遍历有问题
    @org.junit.Test
    public void test3() throws InterruptedException {
        //C:\\Users\\Administrator.PC1138\\IdeaProjects\\TEST\\src
        //File file=new File("C:\\Users\\Administrator.PC1138\\IdeaProjects\\TEST");
        File file=new File("C:\\Users\\Administrator.PC1138\\IdeaProjects\\TEST\\src");

      //  //判断当前文件是文件夹还是文件
      //  if(file.isDirectory()){
      //      String[] files=file.list();
      //      logger.info(JSON.toJSONStringWithDateFormat(files,"yyyy-MM-dd HH:mm:ss"));
      //      for (int i=0;i<files.length;i++){
      //
      //      }
      //  }else{
      //      logger.info(JSON.toJSONStringWithDateFormat(file.getName(),"yyyy-MM-dd HH:mm:ss"));
      //}

        getFiles(file);

        Thread.sleep(3000);
    }

    @org.junit.Test
    public void test4(){
        File file=new File("C:\\Users\\Administrator.PC1138\\IdeaProjects\\TEST\\src\\main");

          //判断当前文件是文件夹还是文件

          if(file.isDirectory()){
              String[] files=file.list();
              logger.info(JSON.toJSONStringWithDateFormat(file.isDirectory(),"yyyy-MM-dd HH:mm:ss"));
              for (int i=0;i<files.length;i++){
                  logger.info(JSON.toJSONStringWithDateFormat(new File(files[i]).getAbsolutePath(),"yyyy-MM-dd HH:mm:ss"));
              }
          }else{
              logger.info(JSON.toJSONStringWithDateFormat(file.getName(),"yyyy-MM-dd HH:mm:ss"));
        }
    }

    //有问题
    @org.junit.Test
    public void test5(){
        File file=new File("C:\\Users\\Administrator.PC1138\\IdeaProjects\\TEST\\java");

        //判断当前文件是文件夹还是文件(包是false)
        logger.info(JSON.toJSONStringWithDateFormat(file.isDirectory(),"yyyy-MM-dd HH:mm:ss"));
        if(file.isDirectory()){
            String[] files=file.list();

            for (int i=0;i<files.length;i++){
                logger.info(JSON.toJSONStringWithDateFormat(new File(files[i]).getAbsolutePath(),"yyyy-MM-dd HH:mm:ss"));
            }
        }else{
            logger.info(JSON.toJSONStringWithDateFormat(file.getName(),"yyyy-MM-dd HH:mm:ss"));
        }
    }

    //对遍历文件进行优化(解决找不到java包里面文件)
    @org.junit.Test
    public void test6(){
        File file=new File("C:\\Users\\Administrator.PC1138\\IdeaProjects\\TEST");
        getDirectories(file);
    }

    public List<String> getDirectories(File file){
        List<String> list=null;

        File[] flist=file.listFiles();
        if (flist==null || flist.length==0) {
            return list;
        }else{
            list=new ArrayList<String>();
        }

        for (int i=0;i<flist.length;i++) {
            if (flist[i].isDirectory()) {
                //所有的文件夹
                logger.info(JSON.toJSONStringWithDateFormat(flist[i].getAbsolutePath(),"yyyy-MM-dd HH:mm:ss"));
                list.add(flist[i].getAbsolutePath());
                getDirectories(flist[i]);
            }else {
                //所有的文件
                logger.info(JSON.toJSONStringWithDateFormat(flist[i].getAbsolutePath(),"yyyy-MM-dd HH:mm:ss"));
                list.add(flist[i].getAbsolutePath());
            }
        }

        return list;
    }

    public List<String> getFiles(File file){

        List<String> fileStr=new ArrayList<String>();

        String[] files=file.list();
        logger.info(JSON.toJSONStringWithDateFormat(files,"yyyy-MM-dd HH:mm:ss"));
        for (int i=0;i<files.length;i++){
            File file2=new File(files[i]);
            if (file2.isDirectory()){

                if (file2.getName().equalsIgnoreCase("src")){
                    System.out.println("");
                }
                //System.out.println(file2.getName());
                getFiles(file2);
                logger.info(JSON.toJSONStringWithDateFormat(file2.getAbsolutePath(),"yyyy-MM-dd HH:mm:ss"));
                fileStr.add(file2.getAbsolutePath());
            }else{
                //logger.info(JSON.toJSONStringWithDateFormat(file2.getName(),"yyyy-MM-dd HH:mm:ss"));
                logger.info(JSON.toJSONStringWithDateFormat(file2.getAbsolutePath(),"yyyy-MM-dd HH:mm:ss"));
                fileStr.add(file2.getAbsolutePath());
            }

        }
        return fileStr;
    }

}
