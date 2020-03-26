package com.hxoim.support.role.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hxoim.common.exceptions.AlertMessageException;
import com.hxoim.common.exceptions.ParameterNullException;
import com.hxoim.common.tree.Tree;
import com.hxoim.common.utils.Constants;
import com.hxoim.common.utils.UUIDGenerator;
import com.hxoim.common.utils.UserInfoUtil;
import com.hxoim.support.b01.entity.OrgGrant;
import com.hxoim.support.b01.mapper.OrgGrantMapper;
import com.hxoim.support.inforesource.entity.DataTable;
import com.hxoim.support.inforesource.mapper.DataTableMapper;
import com.hxoim.support.role.entity.Role;
import com.hxoim.support.role.mapper.RoleMapper;
import com.hxoim.support.role.service.RoleService;
import com.hxoim.support.sysdict.entity.SysDictItem;
import com.hxoim.support.sysdict.mapper.SysDictItemMapper;
import com.hxoim.support.user.entity.User;
import com.hxoim.support.user.mapper.UserMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private OrgGrantMapper orgGrantMapper;
    @Autowired
    private SysDictItemMapper sysDictItemMapper;
    @Autowired
    private DataTableMapper dataTableMapper;

    @Override
    public void selectByUserCode(String roleCode) {
        roleMapper.selectByRoleCode(roleCode);
    }

    @Override
    public void insertRole(Role role) {
        if (role == null) {
            throw new ParameterNullException("角色不能为空");
        }
        role.setId(UUIDGenerator.getPrimaryKey());
        role.setOrderIndex(roleMapper.findMaxOrderno());
        role.setModifyTime(new Date());
        role.setModifyUser(UserInfoUtil.getUserInfo().getId());
        roleMapper.insertSelective(role);
    }

    @Override
    public void changeRoleState(Role role) {
        String roleState = role != null ? role.getRoleState() : "";
        String roleCode = role != null ? role.getRoleCode() : "";
        if (StringUtils.isEmpty(roleState) || StringUtils.isEmpty(roleCode)) {
            throw new ParameterNullException("角色编码或角色状态不能为空");
        }
        roleMapper.changeRoleState(role);
    }

    @Override
    public Role selectByPrimaryKey(String roleId) {
        if (StringUtils.isEmpty(roleId)) {
            throw new ParameterNullException("角色Id不能为空");
        }
        Role role = roleMapper.selectByPrimaryKey(roleId);
        if (role == null) {
            throw new ParameterNullException("角色不存在");
        }
        return role;
    }

    @Override
    public void updateRole(Role role) {
        if (role == null) {
            throw new ParameterNullException("角色不能为空");
        }
        roleMapper.updateByPrimaryKeySelective(role);
    }

    @Override
    public void deleteRole(String roleId) {
        if (StringUtils.isEmpty(roleId)) {
            throw new ParameterNullException("角色Id不能为空");
        }
        roleMapper.deleteByPrimaryKey(roleId);
    }

    @Override
    public PageInfo getroleLists(Integer pageNum, Integer pageSize, String roleName, String orgId) {
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        PageHelper.startPage(pageNum, pageSize);   //设置传入页码，以及每页的大小
        List<Role> list = roleMapper.selectRoleList(roleName, orgId);
        PageInfo info = new PageInfo(list);
        return info;
    }

    @Override
    public void initRole(String loginName) {
        //初始化所有权限相关表
        User user = userMapper.selectPasswordByUsername(loginName);
        if (user == null) {
            throw new ParameterNullException("用户不存在");
        }
        if (!Constants.USER_TYPES[0].equals(user.getUserType())) {
            throw new AlertMessageException("只能初始化管理员用户");
        }
        //初始化模块权限
        initModule(user.getOrgId());
        //初始化机构权限
        initOrg(user.getOrgId());
        //初始化干部类别信息集
        initLeaderTypeInfo(user.getOrgId());
    }

    /**
     * 初始化干部类别信息集权限
     *
     * @author sunqian
     * @date 2019/8/27 13:52
     */
    private void initLeaderTypeInfo(String orgId) {
        //清空干部类别权限
        roleMapper.executeCUDSql("delete from cf_org_leaderType where b0111='" + orgId + "'");
        //获取所有的干部类别
        List<SysDictItem> leaderTypeList = sysDictItemMapper.selectSysdictItemListByDictCode(Constants.LEADER_TYPE);
        //获取所有的信息集
        List<DataTable> dataTableList = dataTableMapper.selectDataTableByResourceCode(Constants.PERSON_INFO);
        if (leaderTypeList == null || leaderTypeList.isEmpty()) {
            return;
        }
        if (dataTableList == null || dataTableList.isEmpty()) {
            return;
        }
        List<OrgGrant> grantList = new ArrayList<>();
        for (int i = 0; i < leaderTypeList.size(); i++) {
            SysDictItem sysDictItem = leaderTypeList.get(i);
            for (int j = 0; j < dataTableList.size(); j++) {
                DataTable dataTable = dataTableList.get(j);
                OrgGrant orgGrant = new OrgGrant();
                orgGrant.setId(UUIDGenerator.getPrimaryKey());
                orgGrant.setOrgId(orgId);
                orgGrant.setCheckId(dataTable.getTabCode());
                orgGrant.setLeaderTypeId(sysDictItem.getId());
                grantList.add(orgGrant);
            }
        }
        orgGrantMapper.insertGrantLeaderTypeInfo(grantList);
    }

    /**
     * 初始化机构权限
     *
     * @author sunqian
     * @date 2019/8/26 17:56
     */
    private void initOrg(String orgId) {
        //先清空机构权限
        roleMapper.executeCUDSql("delete from cf_org_sub where b0111='" + orgId + "'");
        List<Map<String, Object>> list = roleMapper.executeSelectSql("select B0111 from b01");
        List<OrgGrant> grantList = new ArrayList<>();
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> map = list.get(i);
            OrgGrant orgGrant = new OrgGrant();
            orgGrant.setId(UUIDGenerator.getPrimaryKey());
            orgGrant.setOrgId(orgId);
            orgGrant.setCheckId((String) map.get("B0111"));
            grantList.add(orgGrant);
        }
        int batch = 100;
        int size = grantList.size();
        for (int i = 0; i < size / batch; i++) {
            int max = (i + 1) * batch;
            if (max < size) {
                orgGrantMapper.insertGrantOrg(grantList.subList(i * batch, max));
            } else {
                orgGrantMapper.insertGrantOrg(grantList.subList(i * batch, size));
            }
        }
    }

    /**
     * 初始化模块权限
     *
     * @author sunqian
     * @date 2019/8/26 17:56
     */
    private void initModule(String orgId) {
        roleMapper.executeCUDSql("delete from cf_org_module where b0111='" + orgId + "'");
        List<Map<String, Object>> list = roleMapper.executeSelectSql("select ID from cf_module where mu_type!='3' and mu_state='1'");
        List<OrgGrant> grantList = new ArrayList<>();

        for (Map<String, Object> map : list) {
            OrgGrant orgGrant = new OrgGrant();
            orgGrant.setOrgId(orgId);
            orgGrant.setCheckId((String) map.get("ID"));
            orgGrant.setId(UUIDGenerator.getPrimaryKey());
            grantList.add(orgGrant);
        }
        orgGrantMapper.insertGrantModule(grantList);
    }

    //批量新增
    //处理日期
    public String getDateByString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String newDate = "";
        try {
            newDate = sdf.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newDate;
    }
}
