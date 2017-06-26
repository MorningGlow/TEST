package com.zx.mes.proxy.dao.impl;

import com.alibaba.fastjson.JSON;
import com.zx.mes.proxy.dao.IDao;
import org.apache.log4j.Logger;

/**
 * Created by Administrator on 2017/6/26.
 */
public class DaoImpl implements IDao {

    private static final Logger logger=Logger.getLogger(DaoImpl.class);

    public void delete(String id) {
        logger.info(JSON.toJSONStringWithDateFormat("删除","yyyy-MM-dd HH:mm:ss"));
    }

    public String find(String id) {
        logger.info(JSON.toJSONStringWithDateFormat("查询","yyyy-MM-dd HH:mm:ss"));
        return "这是有返回值的";
    }
}
