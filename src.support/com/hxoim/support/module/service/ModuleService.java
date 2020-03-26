package com.hxoim.support.module.service;

import com.hxoim.common.tree.Tree;
import com.hxoim.common.utils.UserInfo;
import com.hxoim.support.module.entity.Module;

import java.util.List;
import java.util.Map;

/**
 * @author: sunqian
 * @desc: 模块管理service
 * @date: 2019/6/3 10:44
 */
public interface ModuleService {
    /**
     * @author: sunqian
     * @desc: 根据当前登录用户获取机构树
     * @date: 2019/6/3 10:43
     */
    List<Tree> selectModuleTree(UserInfo userInfo);

    /**
     * @Author sunqian
     * @Description 新增模块
     * @Date 10:35 2019/6/4
     * @Param [module] 数据
     */
    void insertModule(Module module);

    /**
     * @return java.util.List<com.hxoim.support.module.entity.Module>
     * @Author sunqian
     * @Description 根据父id查询所有的子模块
     * @Date 13:51 2019/6/4
     * @Param [pId]
     */
    List<Module> selectModulesByPid(String pId);

    /**
     * @return com.hxoim.support.module.entity.Module
     * @Author sunqian
     * @Description 根据模块id查询模块信息
     * @Date 15:25 2019/6/4
     * @Param [id] 模块id
     */
    Module selectModuleById(String id);

    /**
     * @return void
     * @Author sunqian
     * @Description 更新模块
     * @Date 17:00 2019/6/4
     * @Param [module]
     */
    void updateModule(Module module);

    /**
     * @return void
     * @Author sunqian
     * @Description 根据模块删除id
     * @Date 16:50 2019/6/5
     * @Param [id]
     */
    void deleteModuleById(String id);

    /**
     * @Author sunqian
     * @Desc 查询所有的可以使用的
     * @Date 2019/6/24 16:51
     * @param userId
     */
    List<Module> selectCurrGrantModule(String userId);

    /**
     * 获取用户下的模块权限
     * 
     * @author sunqian
     * @date 2019/7/8 10:48
     * @param userId
     */
    Map<String, Object> selectGrantModuleTree(String userId);

    List<Module> selectRouterList();
}
