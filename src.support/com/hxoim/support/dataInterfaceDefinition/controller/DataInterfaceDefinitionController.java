package com.hxoim.support.dataInterfaceDefinition.controller;

import com.hxoim.common.tree.Tree;
import com.hxoim.common.utils.Result;
import com.hxoim.support.dataInterfaceDefinition.entity.DataInterfaceDefinition;
import com.hxoim.support.dataInterfaceDefinition.service.DataInterfaceDefinitionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 数据接口定义
 */
@RestController
@RequestMapping("/dataInterface")
public class DataInterfaceDefinitionController {

    @Autowired
    private DataInterfaceDefinitionService dataInterfaceDefinitionService;

//    private
    /**
     *  查询元数据接口
     * @param infoResourceId
     * @return
     */
    @RequestMapping("/selectByInfoResourceId")
    public Result selectByInfoResourceId(String infoResourceId){
        List<DataInterfaceDefinition> dataInterfaceDefinitionList = dataInterfaceDefinitionService.selectByInfoResourceId(infoResourceId);
        return Result.success(dataInterfaceDefinitionList);
    }

    /**
     * 添加数据接口
     * @param dataInterfaceDefinition
     * @return
     */
    @RequestMapping("/insertDataInterfaceDefinition")
    public Result insertDataInterfaceDefinition(DataInterfaceDefinition dataInterfaceDefinition){
//        元数据描述需解析sql
//        dataInterfaceDefinition.setDataDesc(transformDataDesc(dataInterfaceDefinition.getDataSql()));
        dataInterfaceDefinitionService.insertDataInterfaceDefinition(dataInterfaceDefinition);
        return Result.success();
    }

    /**
     * 修改数据接口
     * @param dataInterfaceDefinition
     * @return
     */
    @RequestMapping("/updateDataInterfaceDefinition")
    public Result updateDataInterfaceDefinition(DataInterfaceDefinition dataInterfaceDefinition){
//        元数据描述需解析sql
//        dataInterfaceDefinition.setDataDesc(transformDataDesc(dataInterfaceDefinition.getDataSql()));
        dataInterfaceDefinitionService.updateDataInterfaceDefinition(dataInterfaceDefinition);
        return Result.success();
    }

    /**
     *  删除数据接口
     * @param id
     * @return
     */
    @RequestMapping("/deleteDataInterfaceDefinitionById")
    public Result deleteDataInterfaceDefinitionById(String id){
        dataInterfaceDefinitionService.deleteDataInterfaceDefinition(id);
        return Result.success();
    }

    /**
     * 查询数据接口对象
     * @param id
     * @return
     */
    @RequestMapping("/selectDataInterfaceDefinitionById")
    public Result selectDataInterfaceDefinitionById(String id){
        DataInterfaceDefinition dataInterfaceDefinition =dataInterfaceDefinitionService.selectDataInterfaceDefinitionByKey(id);
        return Result.success(dataInterfaceDefinition);
    }

    /**
     * 修改启用/停用状态
     * @param id
     * @param status
     * @return
     */
    @RequestMapping("/updateDataInterfaceDefinitionStatus")
    public Result updateDataInterfaceDefinitionStatus(String id,String status){
        if(StringUtils.isEmpty(id) || StringUtils.isEmpty(status)){
            return Result.error("参数异常");
        }
        boolean flag = dataInterfaceDefinitionService.updateEnableOrdisableStatus(id,status);
        if(flag == false){
            return Result.error("启用或停用异常");
        }
        return Result.success();
    }

    /** @RequestParam(value = "resourceIds[]",required = false)
     * 查询未分配的服务接口
     * @param infoResourceIds
     * @return
     */
    @RequestMapping(value = "/selectUndistributedInterface")
    public Result selectUndistributedInterface(String infoResourceIds[],String serveId){
        if(infoResourceIds.length <1 || StringUtils.isEmpty(serveId)){
            return Result.error("参数异常，请传入参数");
        }
        List<DataInterfaceDefinition> list = dataInterfaceDefinitionService.selectUndistributedInterface(infoResourceIds,serveId);
        return Result.success(list);
    }

    /**
     * 转换元数据描述
     * @param params
     * @return
     */
    @RequestMapping("/transformDataDesc")
    public Result transformDataDesc(@RequestParam String params[]){
        if(params.length<1){
            return Result.error("参数异常");
        }
        String strXml =dataInterfaceDefinitionService.selectTransformDataDesc(params);
        return Result.success(strXml);
    }

    /**
     * 查询所有数据接口
     * @return
     */
    @RequestMapping("/selectDataInterface")
    public Result selectDataInterface(){
        List<DataInterfaceDefinition> list = dataInterfaceDefinitionService.selectDataInterface();
        return Result.success(list);
    }

    /**
     * 查询资源信息及表 的树形结构
     * @return
     */
    @RequestMapping("/selectResourceTree")
    public Result selectResourceTree(){
        List<Tree> list = dataInterfaceDefinitionService.selectResourceTree();
        return Result.success(list);
    }
}
