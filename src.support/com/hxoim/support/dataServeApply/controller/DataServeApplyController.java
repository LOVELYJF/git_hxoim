package com.hxoim.support.dataServeApply.controller;

import com.alibaba.fastjson.JSONObject;
import com.hxoim.common.utils.Result;
import com.hxoim.support.dataServeApply.entity.DataServeApply;
import com.hxoim.support.dataServeApply.service.DataServeApplyService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 数据服务申请
 */
@RestController
@RequestMapping("/dataServeApply")
public class DataServeApplyController {
    @Autowired
    private DataServeApplyService dataServeApplyService;

    /**
     *  查询服务
     * @return {a:b,c:d,e:f}
     */
    @RequestMapping("/selectDataServeApply")
    public Result selectDataServeApply(String param){
        Map<String,String> map = new HashMap<String,String>();
        if (StringUtils.isNotEmpty(param)){
            JSONObject jsonObject =JSONObject.parseObject(param);
            map.put("applyOrg",jsonObject.getString("applyOrg"));
            map.put("softwareDevName",jsonObject.getString("softwareDevName"));
            map.put("serveUsername",jsonObject.getString("serveUsername"));
            map.put("serveIp",jsonObject.getString("serveIp"));
        }
        List<DataServeApply> dataServeApplyList = dataServeApplyService.selectDataServeApply(map);
        return Result.success(dataServeApplyList);
    }

    /**
     *  查询服务对象
     * @param id
     * @return
     */
    @RequestMapping("/selectDataServeApplyById")
    public Result selectDataServeApplyById(String id){
        DataServeApply dataServeApply =dataServeApplyService.selectById(id);
        return Result.success(dataServeApply);
    }

    /**
     *  添加服务对象
     * @param dataServeApply
     * @return
     */
    @RequestMapping("/insertDataServeApply")
    public Result insertDataServeApply(DataServeApply dataServeApply){
        dataServeApplyService.insertDataServeApply(dataServeApply);
        return Result.success();
    }

    /**
     *  修复服务对象
     * @param dataServeApply
     * @return
     */
    @RequestMapping("/updateDataServeApply")
    public Result updateDataServeApply(DataServeApply dataServeApply){
        dataServeApplyService.updateDataServeApply(dataServeApply);
        return Result.success();
    }

    /**
     * 删除服务
     * @param id
     * @return
     */
    @RequestMapping("/deleteDataServeApplyById")
    public Result deleteDataServeApplyById(String id){
        dataServeApplyService.deleteDataServeApplyById(id);
        return Result.success();
    }

    /**
     * 查询其他服务
     * @param id
     * @return
     */
    @RequestMapping("/selectOtherDataServeApply")
    public Result selectOtherDataServeApply(String id){
        List<DataServeApply> list = dataServeApplyService.selectOtherDataServeApply(id);
        return Result.success(list);
    }

    @RequestMapping("/selectValidateByParams")
    public Result selectValidateByParams(String id,String serveIp,String serveUsername){
        if(StringUtils.isEmpty(serveIp) || StringUtils.isEmpty(serveUsername) ){
            return Result.error("参数异常");
        }
        DataServeApply dataServeApply =dataServeApplyService.selectValidateByParams(serveIp,serveUsername);
        if(dataServeApply !=null && !dataServeApply.getId().equals(id)){
            return Result.error("该服务下的用户名已存在，请重新输入");
        }

        return Result.success();
    }
}
