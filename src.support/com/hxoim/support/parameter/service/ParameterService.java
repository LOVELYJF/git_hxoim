package com.hxoim.support.parameter.service;

import com.hxoim.common.utils.Result;
import com.hxoim.support.parameter.entity.Parameter;

import java.util.List;

/**
 * @Description: 参数设置Service层
 * @Author: 张乾
 * @CreateDate: 2019/5/17$ 15:47$
 * @UpdateUser: 张乾
 * @UpdateDate: 2019/5/17$ 15:47$
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public interface ParameterService {

    void insertParameter(Parameter parameter);

    void sortParameter(String ids);

    void updateParameter(Parameter parameter);

    void deleteParameter(Parameter parameter);

    /**
     * description:查询参数列表
     * create by: 张乾
     * createDate: 2019/5/27 16:57
     */
    List<Parameter> selectAllParameter();

    String selectPValueByCode(String expireTimes);
}
