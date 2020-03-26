package com.hxoim.support.module.mapper;

import com.hxoim.common.tree.Tree;
import com.hxoim.common.utils.UserInfo;
import com.hxoim.support.module.entity.Module;

import java.util.List;

public interface ModuleMapper {
    int deleteByPrimaryKey(String id);

    int insert(Module record);

    int insertSelective(Module record);

    Module selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Module record);

    int updateByPrimaryKey(Module record);

    /**
     * @Author sunqian
     * @Description 查询所有模块树
     * @Date 10:40 2019/6/4
     */
    List<Tree> selectModuleTree();

    /**
     * @return java.util.List<com.hxoim.support.module.entity.Module>
     * @Author sunqian
     * @Description 查询当前用户下的所有的模块(根据权限查, 授权还没有做好, 默认查所有的可用的模块)
     * @Date 14:01 2019/6/4
     * @Param [userInfo]
     */
    List<Module> selectModuleList();

    /**
     * @return com.hxoim.support.module.entity.Module
     * @Author sunqian
     * @Description 根据编码查询模块
     * @Date 14:37 2019/6/5
     * @Param [muCode] 模块编码
     */
    Module selectModuleByCode(String muCode);

    /**
     * @Author sunqian
     * @Desc 获取所有的正常使用的模块
     * @Date 2019/6/24 17:19
     * @param orgId
     */
    List<Module> selectOrgGrantModule(String orgId);

    /**
     * 根据用户id获取用户的所有模块
     *
     * @author sunqian
     * @date 2019/7/6 17:17
     */
    List<Module> selectUserGrantModules(String userId);

    List<Module> selectRouterList();
}