package com.hxoim.support.b01.controller;

import com.hxoim.common.tree.Tree;
import com.hxoim.common.utils.RequestList;
import com.hxoim.common.utils.Result;
import com.hxoim.support.b01.entity.OrgGrant;
import com.hxoim.support.b01.service.OrgGrantService;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author sunqian
 * @Desc 机构授权
 * @Date 2019/6/24 11:06
 */
@RestController
@RequestMapping("/orgGrant")
public class OrgGrantController {

    @Resource
    private OrgGrantService orgGrantService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setAutoGrowCollectionLimit(Integer.MAX_VALUE);
    }

    /**
     * 获取模块授权树
     *
     * @author sunqian
     * @date 2019/6/24 16:47
     */
    @RequestMapping("/selectGrantModule")
    public Result selectGrantModule(String orgId) {
        OrgGrant orgGrant = orgGrantService.selectGrantModule(orgId);
        return Result.success(orgGrant);
    }

    /**
     * 获取单点登录系统
     *
     * @author sunqian
     * @date 2019/6/25 16:45
     */
    @RequestMapping("/selectGrantSystem")
    public Result selectGrantSystem(String orgId) {
        OrgGrant orgGrant = orgGrantService.selectGrantSystem(orgId);
        return Result.success(orgGrant);
    }

    /**
     * 获取干部类别
     *
     * @author sunqian
     * @date 2019/6/28 9:47
     */
    @RequestMapping("/selectLeaderType")
    public Result selectLeaderType() {
        List<Tree> list = orgGrantService.selectLeaderType();
        return Result.success(list);
    }

    /**
     * 获取干部类别信息权限
     *
     * @author sunqian
     * @date 2019/6/27 10:52
     */
    @RequestMapping("/selectGrantLeaderType")
    public Result selectGrantLeaderType(String orgId, String leaderTypeId) {
        OrgGrant orgGrant = orgGrantService.selectGrantLeaderType(orgId, leaderTypeId);
        return Result.success(orgGrant);
    }

    /**
     * 获取机构权限
     *
     * @author sunqian
     * @date 2019/6/28 13:54
     */
    @RequestMapping("/selectGrantOrg")
    public Result selectGrantOrg(String orgId) {
        OrgGrant orgGrant = orgGrantService.selectGrantOrg(orgId);
        return Result.success(orgGrant);
    }

    /**
     * 保存选中的模块
     *
     * @author sunqian
     * @date 2019/6/25 9:31
     */
    @RequestMapping("/insertGrantModule")
    public Result insertGrantModule(OrgGrant orgGrant) {
        orgGrantService.insertGrantModule(orgGrant);
        return Result.success();
    }

    /**
     * 保存选中的机构
     *
     * @author sunqian
     * @date 2019/6/25 9:31
     */
    @RequestMapping("/insertGrantOrg")
    public Result insertGrantOrg(OrgGrant orgGrant) {
        orgGrantService.insertGrantOrg(orgGrant);
        return Result.success();
    }

    /**
     * 保存选中的干部类别信息集
     *
     * @author sunqian
     * @date 2019/6/25 9:31
     */
    @RequestMapping("/insertGrantLeaderType")
    public Result insertGrantLeaderType(OrgGrant orgGrant) {
        orgGrantService.insertGrantLeaderTypeInfo(orgGrant);
        return Result.success();
    }

    /**
     * 保存选中的单点登录系统
     *
     * @author sunqian
     * @date 2019/6/25 9:31
     */
    @RequestMapping("/insertGrantSystem")
    public Result insertGrantSystem(OrgGrant orgGrant) {
        orgGrantService.insertGrantSystem(orgGrant);
        return Result.success();
    }

    /**
     * 拷贝角色权限
     *
     * @author sunqian
     * @date 2019/6/28 16:07
     */
    @RequestMapping("/copyOrgGrantForOtherOrg")
    public Result copyOrgGrantForOtherOrg(String orgId, RequestList<String> requestList) {
        orgGrantService.copyOrgGrantForOtherOrg(orgId, requestList.getList(String.class));
        return Result.success();
    }
}
