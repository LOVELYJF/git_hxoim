package com.hxoim.support.leadertype.controller;

import com.hxoim.common.utils.Result;
import com.hxoim.support.inforesource.entity.DataTable;
import com.hxoim.support.leadertype.service.LeaderTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 干部类别管理
 * 
 * @author sunqian
 * @date 2019/8/21 15:06
 */
@RestController
@RequestMapping("/leaderType")
public class LeaderTypeController {

    @Autowired
    private LeaderTypeService leaderTypeService;

    /**
     * 当前用户权限内的信息集,根据leaderTypeId
     * 
     * @author sunqian
     * @date 2019/8/21 16:13
     */
    @RequestMapping("/selectGrantLeaderTypeInfo")
    public Result selectGrantLeaderTypeInfo(String leaderTypeId){
        List<DataTable> dataTableList = leaderTypeService.selectGrantLeaderTypeInfo(leaderTypeId);
        return Result.success(dataTableList);
    }


}
