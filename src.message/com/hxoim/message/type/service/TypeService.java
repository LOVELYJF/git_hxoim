package com.hxoim.message.type.service;

import com.hxoim.message.type.entity.Type;
import com.hxoim.message.type.entity.TypeCustom;

import java.util.List;

/**
 * @desc 消息分类service
 * @author  lijing
 * @date  2019/5/27
 */
public interface TypeService {

    /**
     * @desc 新增消息分类
     * @author lijing
     * @date 2019/5/27
     */
    String insertMsgType(Type type);

    /**
     * @desc 更新消息分类
     * @author lijing
     * @date 2019/5/27
     */
    void updateMsgType(Type type);

    /**
     * @desc 消息分类列表
     * @author lijing
     * @param id 消息分类ID
     * @date 2019/5/27
     */
    List<TypeCustom> selectMsgTypeList(String id);

    /**
     * @desc 通过ID查询消息分类
     * @author  lijing
     * @date  2019/5/27
     */
    Type selectMsgTypeByKey(String id);

    /**
     * @desc 删除消息分类
     * @author lijing
     * @date 2019/5/27
     */
    void deleteMsgType(String id);

    /**
     * @desc: 查询所有分类
     * @author: lijing
     * @date: 2019/7/25
     */
    List<Type> selectAllType();
}
