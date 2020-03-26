package com.hxoim.support.b01.controller;

import com.hxoim.common.tree.Tree;
import com.hxoim.common.utils.Result;
import com.hxoim.support.b01.entity.B01;
import com.hxoim.support.b01.service.OrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: sunqian
 * @desc: 机构管理
 * @date: 2019/5/28 16:36
 */
@RestController
@RequestMapping("/org")
public class OrgController {

    @Autowired
    private OrgService orgService;

    @RequestMapping("/selectOrgTree")
    public Result selectOrgTree() {
        List<Tree> list  = orgService.selectOrgTree();
        return Result.success(list);
    }

    /**
     * @ description: 编辑机构
     * @ create by: 张乾
     * @ createDate: 2019/6/5 14:34
     */
    @RequestMapping("/updateOrg")
    public Result updateOrg(B01 b01){
        orgService.updateOrg(b01);
        return Result.success();
    }

    /**
     * @ description: 添加机构
     * @ create by: 张乾
     * @ createDate: 2019/6/5 14:57
     */
    @RequestMapping("/insertOrg")
    public Result insertOrg(B01 b01){
        orgService.insertOrg(b01);
        return Result.success();
    }

    /**
     *@ description: 机构搜索查询
     *@ create by: 张乾
     *@ createDate: 2019/6/5 15:03
     */
    @RequestMapping("/selectOrg")
    public Result selectOrg(B01 b01){
        List<B01> b01Org=orgService.selectOrg(b01);
        return Result.success(b01Org);
    }

    /**
     * @ description: 删除机构
     * @ create by: 张乾
     * @ createDate: 2019/6/5 15:29
     */
    @RequestMapping("/deleteOrg")
    public Result deleteOrg(String b0111){
        orgService.deleteOrg(b0111);
        return Result.success();
    }

    /**
     * @ description: 机构排序
     * @ create by: 张乾
     * @ createDate: 2019/6/5 16:11
     */
    @RequestMapping("/sortOrg")
    public Result sortOrg(String b0111s){
        orgService.sortOrg(b0111s);
        return Result.success();
    }

    /**
     * @ description: 查询下级机构列表
     * @ create by: 张乾
     * @ createDate: 2019/6/5 16:32
     */
    @RequestMapping("/selectOrgById")
    public Result selectOrgById(B01 b01){
        List<B01> b01List=orgService.selectOrgById(b01);
        return Result.success(b01List);
    }

    /**
     * @ description: 通过标识编码查询机构
     * @ create by: 张乾
     * @ createDate: 2019/6/7 15:44
     */
    @RequestMapping("/selectOrgByB0111")
    public Result selectOrgByB0111(String b0111){
        B01 b01=orgService.selectOrgByB0111(b0111);
        return Result.success(b01);
    }

    /**
     * @desc: 查询所有机构
     * @author: lijing
     * @date: 2019/7/24
     */
    @RequestMapping("/selectOrgAllList")
    public Result selectOrgAllList(){
        List<B01> b01List = orgService.selectOrgAllList();
        return Result.success(b01List);
    }
}
