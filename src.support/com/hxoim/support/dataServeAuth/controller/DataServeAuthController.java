package com.hxoim.support.dataServeAuth.controller;

import com.hxoim.common.utils.Result;
import com.hxoim.support.dataServeAuth.entity.DataServeAuth;
import com.hxoim.support.dataServeAuth.entity.DataServeAuthVO;
import com.hxoim.support.dataServeAuth.service.DataServeAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 数据服务权限
 */
@RestController
@RequestMapping("/dataServeAuth")
public class DataServeAuthController {

    @Autowired
    private DataServeAuthService dataServeAuthService;

    /**
     * 数据服务分配权限
     * @param dataServeAuth
     * @return
     */
    @RequestMapping("/insetDataServeAuth")
    public Result insetDataServeAuth(DataServeAuth dataServeAuth){
        dataServeAuthService.insertDataServeAuth(dataServeAuth);
        return Result.success();
    }

    /**
     * 数据服务权限取消
     * @param id
     * @return
     */
    @RequestMapping("/deleteDataServeAuthById")
    public Result deleteDataServeAuthById(String id){
        dataServeAuthService.deleteById(id);
        return Result.success();
    }

    /**
     * 查询服务在信息资源节点下有哪些接口权限
     * @param serveId
     * @return
     */
    @RequestMapping("/selectByServeIdAndInfoResourceId")
    public Result selectByServeIdAndInfoResourceId(String serveId){
        List<DataServeAuthVO> dataServeAuthVOList = dataServeAuthService.selectByServeIdAndInfoResourceId(serveId);
        return Result.success(dataServeAuthVOList);
    }

    /**
     * 查询接口有哪些服务使用
     * @param interfaceDefinitionId
     * @return
     */
    @RequestMapping("/selectByDataInterfaceDefinitionId")
    public Result selectByDataInterfaceDefinitionId(String interfaceDefinitionId){
        List<DataServeAuth> dataServeAuthList = dataServeAuthService.selectByDataInterfaceDefinitionId(interfaceDefinitionId);
        return Result.success(dataServeAuthList);
    }

    /**
     * 拷贝给其他服务
     * @return
     */
    @RequestMapping("/insertBatchDataServeAuth")
    public Result insertBatchDataServeAuth(@RequestParam String params){
        dataServeAuthService.insertBatchDataServeAuth(params);
        return Result.success();
    }

}
