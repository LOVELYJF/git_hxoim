package com.hxoim.support.parameter.service.impl;

import com.hxoim.common.exceptions.ParameterNullException;
import com.hxoim.common.utils.*;
import com.hxoim.support.parameter.entity.Parameter;
import com.hxoim.support.parameter.mapper.ParameterMapper;
import com.hxoim.support.parameter.service.ParameterService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Description: 参数设置ServiceImpl层
 * @Author: 张乾
 * @CreateDate: 2019/5/17$ 15:47$
 */
@Service
public class ParameterServiceImpl implements ParameterService {

    @Autowired
    private ParameterMapper parameterMapper;

    /**
     * 方法实现说明    添加参数
     * @author 张乾
     * @date 2019/5/17 15:53
     */
    @Override
    public void insertParameter(Parameter parameter) {
        if (parameter == null) {
            throw new ParameterNullException("添加参数不能为空");
        }
        parameter.setPmId(UUIDGenerator.getPrimaryKey());
        Integer orderIndex = parameterMapper.selectMaxOrderIndex();
        if (orderIndex == null) {
            orderIndex = Integer.valueOf(1);
        } else {
            orderIndex += 1;
        }
        parameter.setOrderno(orderIndex);
        parameterMapper.insertParameter(parameter);
    }

    /**
     * 方法实现说明   排序
     * @author 张乾
     * @date 2019/5/17 16:23
     */
    @Override
    public void sortParameter(String ids) {
        if(StringUtils.isBlank(ids)){
            throw new ParameterNullException("排序参数不能为空");
        }
        String[] idArray = ids.split(",");
        parameterMapper.sortParameter(idArray);
    }

    /**
     * 方法实现说明   修改参数
     * @author 张乾
     * @date 2019/5/17 16:40
     */
    @Override
    public void updateParameter(Parameter parameter) {
        if (parameter == null) {
            throw new ParameterNullException("修改参数不能为空");
        }
        parameter.setModifyTime(new Date());
        parameter.setModifyUser(UserInfoUtil.getUserInfo().getId());
        parameterMapper.updateParameter(parameter);
    }

    /**
     * 方法实现说明   删除参数
     * @author 张乾
     * @date 2019/5/17 16:45
     */
    @Override
    public void deleteParameter(Parameter parameter) {
        if (parameter == null) {
            throw new ParameterNullException("删除参数不能为空");
        }
        parameterMapper.deleteParameter(parameter);
    }

    /**
     * 方法实现说明   查询参数列表
     * @author 张乾
     * @date 2019/5/17 16:54
     */
    @Override
    public List<Parameter> selectAllParameter() {
        return parameterMapper.selectAllParameter();
    }

    /**
     * 方法实现说明   通过code查询参数值
     * @author 孙登
     * @date 2019/5/17 16:54
     */
    @Override
    public String selectPValueByCode(String code){
        if (StringUtils.isEmpty(code)) {
            throw new ParameterNullException("参数不能为空");
        }
        String pValue = parameterMapper.selectPValueByCode(code);
        return pValue;
    }
}