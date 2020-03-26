package com.hxoim.message.type.service.impl;

import com.hxoim.common.exceptions.ParameterNullException;
import com.hxoim.common.utils.Constants;
import com.hxoim.common.utils.UUIDGenerator;
import com.hxoim.message.type.entity.Type;
import com.hxoim.message.type.entity.TypeCustom;
import com.hxoim.message.type.mapper.TypeMapper;
import com.hxoim.message.type.service.TypeService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @desc 消息分类Service实现类
 * @author  lijing
 * @date  2019/5/27
 */
@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeMapper typeMapper;

    /**
     * @desc 新增消息分类
     * @author  lijing
     * @param type 消息分类
     * @date  2019/5/27
     */
    @Override
    public String insertMsgType(Type type){
        if (StringUtils.isEmpty(type.getName())){
            throw new ParameterNullException("类型名称不能为空");
        }

        type.setId(UUIDGenerator.getPrimaryKey());
        //父级ID
        if (StringUtils.isEmpty(type.getParId())){
            type.setIsRoot(Constants.IS_ROOT);
        }else{
            type.setIsRoot(Constants.Not_ROOT);
        }
        type.setCreateTime(new Date());

        int insert = typeMapper.insertSelective(type);

        if (insert != 1){
            throw new ParameterNullException("插入失败");
        }
        return type.getId();
    }

    /**
     * @desc 修改消息分类
     * @author  lijing
     * @param type 消息分类
     * @date  2019/5/27
     */
    @Override
    public void updateMsgType(Type type){
        if (StringUtils.isEmpty(type.getName())){
            throw new ParameterNullException("类型名称不能为空");
        }

        int insert = typeMapper.updateByPrimaryKeySelective(type);

        if (insert != 1){
            throw new ParameterNullException("修改失败");
        }
    }

    /**
     * @desc 查询消息分类列表
     * @author  lijing
     * @date  2019/5/27
     */
    @Override
    public List<TypeCustom> selectMsgTypeList(String id){
        return typeMapper.getTypeLists(id);
    }

    /**
     * @desc 通过id查询消息分类列表
     * @author  lijing
     * @param id 消息分类id
     * @date  2019/5/27
     */
    @Override
    public Type selectMsgTypeByKey(@Param(value="id") String id){
        if (StringUtils.isEmpty(id)){
            throw new ParameterNullException("消息ID不能为空");
        }

        Type type = typeMapper.selectByPrimaryKey(id);

        if (ObjectUtils.isEmpty(type)){
            throw new ParameterNullException("信息传入错误");
        }
        return type;
    }

    /**
     * @desc 删除消息分类
     * @author  lijing
     * @param id
     * @date  2019/5/27
     */
    @Override
    public void deleteMsgType(String id){
        if (StringUtils.isEmpty(id)){
            throw new ParameterNullException("消息ID不能为空");
        }
        //分类列表
        List<TypeCustom> typeCustomsLists = typeMapper.getTypeLists(id);
        if (typeCustomsLists != null && typeCustomsLists.size() > 0){
            throw new ParameterNullException("存在子节点不能删除");
        }
        //删除当前节点
        if (typeMapper.deleteByPrimaryKey(id) < 1){
            throw new ParameterNullException("删除失败");
        }
    }

    @Override
    public List<Type> selectAllType() {
        return typeMapper.selectAllType();
    }
}
