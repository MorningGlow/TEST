package com.zx.mes.rfid;


import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.win32.StdCallLibrary;


/**
 * Created by Administrator on 2017/7/7.
 */
public class Rfid {
    //继承Library，用于加载库文件
    public interface CLibrary extends Library{


        CLibrary instance= (CLibrary) Native.loadLibrary("AlienRFID2",CLibrary.class);
        //此方法为链接库中的方法
        String ConnectAndLogin(String ipaddress,int iport,String username,String password);

        boolean Login(String username,String password);
    }
}
