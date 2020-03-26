package com.hxoim.support.usergroup.service.impl;

import com.hxoim.common.Reflector.ReflectHelpper;
import com.hxoim.common.exceptions.ParameterNullException;
import com.hxoim.common.utils.StringUilt;
import com.hxoim.common.utils.UUIDGenerator;
import com.hxoim.support.system.entity.SystemInfo;
import com.hxoim.support.system.mapper.SystemInfoMapper;
import com.hxoim.support.usergroup.entity.SystemUserGroup;
import com.hxoim.support.usergroup.mapper.SystemUserGroupMapper;
import com.hxoim.support.usergroup.mapper.UserGroupMapper;
import com.hxoim.support.usergroup.service.SystemUserGroupService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：张乾
 * @description：系统用户组（处室）service实现类
 * @createDate ： 2019/5/30 10:35
 */
@Service
public class SystemUserGroupServiceImpl implements SystemUserGroupService {

    @Autowired
    private SystemUserGroupMapper systemUserGroupMapper;

    //注入业务系统
    @Autowired
    private SystemInfoMapper systemInfoMapper;

    //注入管理处室
    @Autowired
    private UserGroupMapper userGroupMapper;

    /**
     * @ description:设置业务系统管理处室
     * @ create by: 张乾
     * @ createDate: 2019/5/30 13:52
     */
    @Override
    @Transactional
    public void insertSystemUserGroup(SystemUserGroup systemUserGroup) {
        if (systemUserGroup == null) {
            throw new ParameterNullException("业务系统不能为空");
        }
        //删除该业务系统已有管理处室
        systemUserGroupMapper.deleteSystemUserGroup(systemUserGroup);
        if (systemUserGroup.getUgids() != null && systemUserGroup.getUgids().length > 0) {
            //该业务系统重新设置管理处室
            for (String ugId : systemUserGroup.getUgids()) {
                systemUserGroup.setId(UUIDGenerator.getPrimaryKey());
                systemUserGroup.setUgId(ugId);
                ReflectHelpper.setModifyFields(systemUserGroup);
                systemUserGroupMapper.insertSystemUserGroup(systemUserGroup);
            }
        }
    }

    /**
     * @ description: 查询每个业务系统所拥有的管理处室
     * @ create by: 张乾
     * @ createDate: 2019/5/30 14:21
     */
    @Override
    public List<SystemUserGroup> selectSystemUserGroup() {
        List<SystemUserGroup> systemUserGroupList = systemUserGroupMapper.selectSystemUserGroup();
        SystemInfo systemInfo = null;
        String systemPName = "";
        List<SystemUserGroup> sugList = new ArrayList<SystemUserGroup>();
        for (SystemUserGroup systemUserGroup : systemUserGroupList) {
            SystemUserGroup sug = new SystemUserGroup();
            String ugName = "";
            //通过业务系统id查询名称
            systemInfo = systemInfoMapper.selectSystemNamePid(systemUserGroup.getSyId());
            //查询上级业务系统名称
            systemPName = systemInfoMapper.selectSystemNameByPid(systemInfo.getpId());
            sug.setSyId(systemUserGroup.getSyId());
            if (StringUtils.isNotBlank(systemPName)) {
                sug.setSyName(systemPName + systemInfo.getSystemName());
            } else {
                sug.setSyName(systemInfo.getSystemName());
            }
            if (StringUtils.isNotBlank(systemUserGroup.getOrgIds())) {
                //查询管理处室名称
                ugName = userGroupMapper.selectUserGroupNameByUgId(systemUserGroup.getOrgIds());
                sug.setUgNames(ugName);
            }
            sugList.add(sug);
        }
        return sugList;
    }

    /**
     * @ description: 删除该系统的管理处室
     * @ create by: 张乾
     * @ createDate: 2019/5/30 16:56
     */
    @Override
    public void deleteSystemUserGroup(SystemUserGroup systemUserGroup) {
        if (systemUserGroup == null|| StringUilt.stringIsNullOrEmpty(systemUserGroup.getSyId())) {
            throw new ParameterNullException("业务系统不能为空");
        }
        systemUserGroupMapper.deleteSystemUserGroup(systemUserGroup);
    }
    /**
     * @description:根据ID删除系统设置的管理处室
     * @author:杨波
     * @date:2019-07-21
     *  * @param SystemUserGroup systemUserGroup
     * @return:
     **/
    public void deleteSystemUserGroupById(SystemUserGroup systemUserGroup) {
        if (systemUserGroup == null|| StringUilt.stringIsNullOrEmpty(systemUserGroup.getId())) {
            throw new ParameterNullException("业务系统不能为空");
        }
        systemUserGroupMapper.deleteSystemUserGroupById(systemUserGroup);
    }

    /**
     * @ description:  查询该业务系统拥有的管理处室
     * @ create by: 张乾
     * @ createDate: 2019/5/30 19:05
     */
    @Override
    public List<SystemUserGroup> selectUserGroupBySyId(SystemUserGroup systemUserGroup) {
        if (systemUserGroup == null) {
            throw new ParameterNullException("业务系统不能为空");
        }
        return systemUserGroupMapper.selectUserGroupBySyId(systemUserGroup);
    }
}
