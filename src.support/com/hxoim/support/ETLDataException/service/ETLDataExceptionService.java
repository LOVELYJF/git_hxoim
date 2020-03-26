package com.hxoim.support.ETLDataException.service;
/*
 * @description:
 * @author 杨波
 * @date:2019-07-17
 */

public interface ETLDataExceptionService {
    /**
    * @description:定时搜索数据转换日志表，将新的数据异常推送给负责处室，根据信息资源目录设置的管理处室来发送消息
    * @author:杨波
    * @date:2019-07-17
    *  * @param null
    * @return:
    **/
    void CollectExceptionSendToManager() throws IllegalAccessException, ClassNotFoundException, InstantiationException;
}
