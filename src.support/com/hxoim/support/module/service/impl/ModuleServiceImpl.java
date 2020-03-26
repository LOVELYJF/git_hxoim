package com.hxoim.support.module.service.impl;

import com.hxoim.common.exceptions.AlertMessageException;
import com.hxoim.common.exceptions.DataExistException;
import com.hxoim.common.exceptions.ParameterNullException;
import com.hxoim.common.tree.Tree;
import com.hxoim.common.tree.TreeUtil;
import com.hxoim.common.utils.Constants;
import com.hxoim.common.utils.UUIDGenerator;
import com.hxoim.common.utils.UserInfo;
import com.hxoim.common.utils.UserInfoUtil;
import com.hxoim.support.module.entity.Module;
import com.hxoim.support.module.entity.ModuleTree;
import com.hxoim.support.module.mapper.ModuleMapper;
import com.hxoim.support.module.service.ModuleService;
import com.hxoim.support.user.entity.User;
import com.hxoim.support.user.mapper.UserMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Description: 模块管理CRUD
 * @Author: sunqian
 * @CreateDate: 2019/5/17 18:35
 */
@Service
public class ModuleServiceImpl implements ModuleService {

    @Autowired
    private ModuleMapper moduleMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Tree> selectModuleTree(UserInfo userInfo) {
        List<Tree> list = moduleMapper.selectModuleTree();
        return TreeUtil.listToTreeJson(list);
    }

    @Override
    public void insertModule(Module module) {
        if (module == null) {
            throw new ParameterNullException("参数为空");
        }
        if (StringUtils.isBlank(module.getMuName())) {
            throw new ParameterNullException("名称不能为空");
        }
        if (StringUtils.isBlank(module.getMuCode())) {
            throw new ParameterNullException("编码不能为空");
        }
        //校验编码是否存在
        Module valModule = moduleMapper.selectModuleByCode(module.getMuCode());
        if (valModule != null) {
            throw new DataExistException("该编码已经存在");
        }
        module.setId(UUIDGenerator.getPrimaryKey());
        module.setModifyUser(UserInfoUtil.getUserInfo().getId());
        module.setModifyTime(new Date());
        moduleMapper.insertSelective(module);
    }

    @Override
    public List<Module> selectModulesByPid(String pId) {
        if (pId == null) {
            throw new ParameterNullException("参数pId不能为空");
        }
        List<Module> moduleList = moduleMapper.selectModuleList();
        if (moduleList != null && !moduleList.isEmpty()) {
            Iterator<Module> iterator = moduleList.iterator();
            while (iterator.hasNext()) {
                Module next = iterator.next();
                if (!pId.equals(next.getpId())) {
                    iterator.remove();
                }
            }
        }
        return moduleList == null ? new ArrayList<>() : moduleList;
    }

    @Override
    public Module selectModuleById(String id) {
        return moduleMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateModule(Module module) {
        if (module == null) {
            throw new ParameterNullException("参数为空");
        }
        if (StringUtils.isBlank(module.getId())) {
            throw new ParameterNullException("id不能为空");
        }
        moduleMapper.updateByPrimaryKeySelective(module);
    }

    @Override
    public void deleteModuleById(String id) {
        if (id == null) {
            throw new ParameterNullException("参数id不能为空");
        }
        //判断是否有子节点
        List<Module> modules = selectModulesByPid(id);
        if (modules == null || modules.isEmpty()) {
            moduleMapper.deleteByPrimaryKey(id);
        } else {
            throw new AlertMessageException("有子节点，不能删除");
        }
    }

    @Override
    public List<Module> selectCurrGrantModule(String userId) {
        if (userId == null) {
            userId = UserInfoUtil.getUserInfo().getId();
        }
        //获取当前登录用户
        User user = userMapper.selectByPrimaryKey(userId);
        List<Module> currModuleList = null;
        if (Constants.USER_TYPES[0].equals(user.getUserType())) {
            //管理员权限
            currModuleList = moduleMapper.selectOrgGrantModule(user.getOrgId());
        } else {
            //普通用户权限
            currModuleList = moduleMapper.selectUserGrantModules(user.getId());
        }
        return currModuleList == null ? new ArrayList<>() : currModuleList;
    }

    @Override
    public Map<String, Object> selectGrantModuleTree(String userId) {
        Map<String, Object> map = new HashMap<>();
        List<Module> moduleList = selectCurrGrantModule(userId);
        List<Tree> moduleTrees = new ArrayList<>();
        if (moduleList != null && !moduleList.isEmpty()) {
            for (Module module : moduleList) {
                ModuleTree mt = new ModuleTree();
                mt.setId(module.getId());
                mt.setUrl(module.getUrl());
                mt.setLabel(module.getMuName());
                mt.setpId(module.getpId());
                mt.setIcon(module.getMuIcon());
                moduleTrees.add(mt);
            }
        }
        map.put("moduleTree", TreeUtil.listToTreeJson(moduleTrees));
        map.put("moduleList",moduleList);
        return map;
    }

    @Override
    public List<Module> selectRouterList() {
        return moduleMapper.selectRouterList();
    }
}
