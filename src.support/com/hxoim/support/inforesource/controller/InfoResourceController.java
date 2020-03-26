package com.hxoim.support.inforesource.controller;

import com.hxoim.common.tree.Tree;
import com.hxoim.common.utils.Result;
import com.hxoim.support.inforesource.entity.InfoResource;
import com.hxoim.support.inforesource.service.InfoResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description: 信息资源管理
 * @Author: 张乾
 * @CreateDate: 2019/5/23$ 19:12$
 */
@RestController
@RequestMapping("/infoResource")
public class InfoResourceController {

    @Autowired
    private InfoResourceService infoResourceService;

    /**
     * 查询资源信息
     */
    @RequestMapping("/selectInfoResourceById")
    public Result selectInfoResourceById(InfoResource infoResource){
        InfoResource info=infoResourceService.selectInfoResourceById(infoResource);
        return Result.success(info);
    }

    /**
     *   添加信息资源
     */
    @RequestMapping("/insertInfoResource")
    public Result insertInfoResource(InfoResource infoResource){
        infoResourceService.insertInfoResource(infoResource);
        return Result.success();
    }
    /**
    * 方法实现说明   修改信息资源
    * @author      张乾
    * @date        2019/5/23 20:21
    */
    @RequestMapping("/updateInfoResource")
    public Result updateInfoResource(InfoResource infoResource){
        infoResourceService.updateInfoResource(infoResource);
        return Result.success();
    }
    /**
    * 方法实现说明   删除信息资源
    * @author      张乾
    * @date        2019/5/23 20:43
    */
    @RequestMapping("/deleteInfoResource")
    public Result deleteInfoResource(InfoResource infoResource){
        infoResourceService.deleteInfoResource(infoResource);
        return Result.success();
    }

    /**
     * description:排序
     * create by: 张乾
     * createDate: 2019/5/28 13:58
     */
    @RequestMapping("/sortOrderIndex")
    public Result sortOrderIndex(@RequestParam(value = "resourceIds[]",required = false) String[] resourceIds){
        infoResourceService.sortOrderIndex(resourceIds);
        return Result.success();
    }

    /**
     * description:点击节点查询其下面的所有表
     * create by: 张乾
     * createDate: 2019/5/28 19:42
     */
    @RequestMapping("/selectTableByPid")
    public Result selectTableByPid(InfoResource infoResource){
        List<InfoResource> infoResourceList=infoResourceService.selectTableByPid(infoResource);
        return Result.success(infoResourceList);
    }

    /**
     * @ description: 查询信息资源树
     * @ create by: 张乾
     * @ createDate: 2019/6/4 14:04
     */
    @RequestMapping("/selectInfoResourceTree")
    public Result selectInfoResourceTree(){
        List<Tree> list=infoResourceService.selectInfoResourceTree();
        return Result.success(list);
    }

    /**
     * @ description: 验证资源编码是否重复
     * @ create by: 张乾
     * @ createDate: 2019/6/7 13:01
     */
    @RequestMapping("/selectResourceCode")
    public Result selectResourceCode(InfoResource infoResource){
        infoResourceService.selectResourceCode(infoResource);
        return Result.success();
    }

    /**
     * @ description: 查询所有分类
     * @ create by: 张乾
     * @ createDate: 2019/6/11 14:59
     */
    @RequestMapping("/selectResourceType")
    public Result selectResourceType(){
        List<InfoResource> list=infoResourceService.selectResourceType();
        return Result.success(list);
    }

    /**
     * 查询资源信息类型为系统列表
     * @return
     */
    @RequestMapping("/selectInfoResourceByType")
    public Result selectInfoResourceByType(){
        //资源信息类型 1:系统 2:人员 3:公文 4:知识库
        String resourceType="1";
        List<InfoResource> list = infoResourceService.selectInfoResourceByType(resourceType);
        return Result.success();
    }
}
