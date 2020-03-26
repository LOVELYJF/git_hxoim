package com.hxoim.support.parameter.controller;

import com.hxoim.common.exceptions.ParameterNullException;
import com.hxoim.common.utils.Constants;
import com.hxoim.common.utils.Result;
import com.hxoim.support.parameter.entity.Parameter;
import com.hxoim.support.parameter.service.ParameterService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description: 参数设置Controller层
 * @Author: 张乾
 * @CreateDate: 2019/5/17$ 15:28$
 */
@RestController
@RequestMapping("/parameter")
public class ParameterController {

    @Autowired
    private ParameterService parameterService;

    /**
     * 方法实现说明   添加参数
     * @author 张乾
     * @date 2019/5/17 15:51
     */
    @RequestMapping("/insertParameter")
    public Result insertParameter(Parameter parameter) {
        parameterService.insertParameter(parameter);
        return Result.success();
    }

    /**
     * 方法实现说明    参数排序
     * @author 张乾
     * @date 2019/5/17 16:12
     */
    @RequestMapping("/sortParameter")
    public Result sortParameter(String ids) {
        parameterService.sortParameter(ids);
        return Result.success();
    }

    /**
     * 方法实现说明   修改参数
     * @author 张乾
     * @date 2019/5/17 16:36
     */
    @RequestMapping("/updateParameter")
    public Result updateParameter(@RequestBody Parameter parameter) {
        parameterService.updateParameter(parameter);
        return Result.success();
    }

    /**
     * 方法实现说明   删除参数
     * @author 张乾
     * @date 2019/5/17 16:44
     */
    @RequestMapping("/deleteParameter")
    public Result deleteParameter(Parameter parameter) {
        parameterService.deleteParameter(parameter);
        return Result.success();
    }

    /**
     * 方法实现说明   查询参数列表
     * @author 张乾
     * @date 2019/5/17 16:51
     */
    @RequestMapping("/selectAllParameter")
    public Result selectAllParameter() {
        List<Parameter> parameterList=parameterService.selectAllParameter();
        return Result.success(parameterList);
    }
    /**
     * 方法实现说明   通过code查询参数值
     * @author 杨波
     * @date 2019/9/2 14:48
     */
    @RequestMapping("/selectByCode")
    public String selectPValueByCode(String code){
        if (StringUtils.isEmpty(code)) {
            throw new ParameterNullException("参数不能为空");
        }
        String pValue = parameterService.selectPValueByCode(code);
        return pValue;
    }
}
