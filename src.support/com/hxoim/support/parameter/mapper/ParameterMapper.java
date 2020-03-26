package com.hxoim.support.parameter.mapper;

import com.hxoim.support.parameter.entity.Parameter;

import java.util.List;

/**
 * @Description: 参数设置mapper层
 * @Author: 张乾
 * @CreateDate: 2019/5/17$ 15:45$
 */
public interface ParameterMapper {

    /**
     * description:查询排序字段最大值
     * create by: 张乾
     * createDate: 2019/5/27 16:59
     */
    Integer selectMaxOrderIndex();

    int insertParameter(Parameter parameter);

    int sortParameter(String[] array);

    int updateParameter(Parameter parameter);

    int deleteParameter(Parameter parameter);

    /**
     * description:查询参数列表
     * create by: 张乾
     * createDate: 2019/5/27 16:57
     */
    List<Parameter> selectAllParameter();

    /**
     * 方法实现说明   通过code查询参数值
     * @author 孙登
     * @date 2019/5/17 16:54
     */
    String selectPValueByCode(String code);
}
