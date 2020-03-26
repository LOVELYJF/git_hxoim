package com.hxoim.support.role.service.impl;

import com.hxoim.common.exceptions.DataExistException;
import com.hxoim.common.exceptions.ParameterNullException;
import com.hxoim.common.tree.Tree;
import com.hxoim.common.tree.TreeUtil;
import com.hxoim.common.utils.Constants;
import com.hxoim.common.utils.UUIDGenerator;
import com.hxoim.common.utils.UserInfo;
import com.hxoim.common.utils.UserInfoUtil;
import com.hxoim.support.b01.service.OrgService;
import com.hxoim.support.inforesource.entity.DataTable;
import com.hxoim.support.leadertype.service.LeaderTypeService;
import com.hxoim.support.module.entity.Module;
import com.hxoim.support.module.service.ModuleService;
import com.hxoim.support.role.entity.RoleGrant;
import com.hxoim.support.role.mapper.RoleGrantMapper;
import com.hxoim.support.role.service.RoleGrantService;
import com.hxoim.support.system.entity.SystemInfo;
import com.hxoim.support.system.service.SystemInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Author sunqian
 * @Desc 角色授权
 * @Date 2019/6/24 16:41
 */
@Service
public class RoleGrantServiceImpl implements RoleGrantService {

    @Autowired
    private ModuleService moduleService;
    @Autowired
    private RoleGrantMapper roleGrantMapper;
    @Autowired
    private OrgService orgService;
    @Autowired
    private LeaderTypeService leaderTypeService;
    @Autowired
    private SystemInfoService systemInfoService;

    //获取模块授权树
    @Override
    public RoleGrant selectGrantModule(String roleId) {
        if (roleId == null) {
            throw new ParameterNullException("角色id为空");
        }
        //所有的使用的模块
        List<Module> currUserModuleList = moduleService.selectCurrGrantModule(UserInfoUtil.getUserInfo().getId());
        List<Tree> treeList = new ArrayList<>();
        if (currUserModuleList != null && !currUserModuleList.isEmpty()) {
            for (Module module : currUserModuleList) {
                Tree tree = new Tree();
                tree.setId(module.getId());
                tree.setLabel(module.getMuName());
                tree.setpId(module.getpId());
                treeList.add(tree);
            }
        }
        //所有的已授权的模块
        List<String> grantModule = roleGrantMapper.selectGrantModuleId(roleId);
        RoleGrant roleGrant = new RoleGrant();
        roleGrant.setTreeList(TreeUtil.listToTreeJson(treeList));
        roleGrant.setCheckList(grantModule);
        return roleGrant;
    }

    //获取单点登录系统
    @Override
    public RoleGrant selectGrantSystem(String roleId) {
        if (roleId == null) {
            throw new ParameterNullException("角色id为空");
        }
        //获取所有的系统
        List<SystemInfo> list = systemInfoService.selectCurrUserGrantSystemInfo();
        List<Tree> sysInfoList = new ArrayList<>();
        if (list != null && !list.isEmpty()) {
            for (SystemInfo systemInfo : list) {
                Tree tree = new Tree();
                tree.setId(systemInfo.getId());
                tree.setLabel(systemInfo.getSystemName());
                sysInfoList.add(tree);
            }
        }
        List<String> checkList = roleGrantMapper.selectGrantSysInfo(roleId);
        RoleGrant roleGrant = new RoleGrant();
        roleGrant.setTreeList(TreeUtil.listToTreeJson(sysInfoList));
        roleGrant.setCheckList(checkList);
        return roleGrant;
    }

    //保存模块授权
    @Override
    public void insertGrantModule(RoleGrant roleGrant) {
        if (roleGrant == null) {
            throw new ParameterNullException("参数不能为空");
        }
        String roleId = roleGrant.getRoleId();
        if (StringUtils.isBlank(roleId)) {
            throw new ParameterNullException("角色id为空");
        }
        //先删除已授权的模块
        roleGrantMapper.deleteGrantByTabName(roleId, "cf_role_module");
        List<String> checkList = roleGrant.getCheckList();
        if (checkList == null || checkList.isEmpty()) {
            return;
        }
        List<RoleGrant> list = getRoleGrantList(roleId, checkList);
        roleGrantMapper.insertGrantModule(list);
    }

    //保存系统授权
    @Override
    public void insertGrantSystem(RoleGrant roleGrant) {
        if (roleGrant == null) {
            throw new ParameterNullException("参数不能为空");
        }
        String roleId = roleGrant.getRoleId();
        if (StringUtils.isBlank(roleId)) {
            throw new ParameterNullException("角色id为空");
        }
        //先删除已授权的模块
        roleGrantMapper.deleteGrantByTabName(roleId, "cf_role_system");
        List<String> checkList = roleGrant.getCheckList();
        if (checkList == null || checkList.isEmpty()) {
            return;
        }
        List<RoleGrant> list = getRoleGrantList(roleId, checkList);
        roleGrantMapper.insertGrantSystem(list);
    }

    //保存干部类别权限
    @Override
    public void insertGrantLeaderTypeInfo(RoleGrant roleGrant) {
        if (roleGrant == null) {
            throw new ParameterNullException("参数不能为空");
        }
        String roleId = roleGrant.getRoleId();
        String leaderTypeId = roleGrant.getLeaderTypeId();
        if (StringUtils.isBlank(roleId)) {
            throw new ParameterNullException("角色id为空");
        }
        if (StringUtils.isBlank(leaderTypeId)) {
            throw new ParameterNullException("干部类别id为空");
        }
        //先删除已授权的模块
        roleGrantMapper.deleteGrantByTabName(roleId, "cf_role_leader_info");
        List<String> checkList = roleGrant.getCheckList();
        if (checkList == null || checkList.isEmpty()) {
            return;
        }
        List<RoleGrant> list = getRoleGrantList(roleId, checkList);
        for (RoleGrant grant : list) {
            grant.setLeaderTypeId(leaderTypeId);
        }
        roleGrantMapper.insertGrantLeaderTypeInfo(list);
    }

    //保存机构权限
    @Override
    public void insertGrantOrg(RoleGrant roleGrant) {
        if (roleGrant == null) {
            throw new ParameterNullException("参数不能为空");
        }
        String roleId = roleGrant.getRoleId();
        if (StringUtils.isBlank(roleId)) {
            throw new ParameterNullException("角色id为空");
        }
        //先删除已授权的模块
        roleGrantMapper.deleteGrantByTabName(roleId, "cf_roleb01");
        List<String> checkList = roleGrant.getCheckList();
        if (checkList == null || checkList.isEmpty()) {
            return;
        }
        List<RoleGrant> list = getRoleGrantList(roleId, checkList);
        int batch = 1000;
        int size = list.size();
        for (int i = 0; i <= size / batch; i++) {
            if ((i + 1) * batch < size) {
                roleGrantMapper.insertGrantOrg(list.subList(i * batch, (i + 1) * batch));
            } else {
                roleGrantMapper.insertGrantOrg(list.subList(i * batch, size));
            }
        }
    }

    //保存信息集权限
    @Override
    public void insertGrantLeaderInfo(RoleGrant roleGrant) {
        if (roleGrant == null) {
            throw new ParameterNullException("参数不能为空");
        }
        String roleId = roleGrant.getRoleId();
        if (StringUtils.isBlank(roleId)) {
            throw new ParameterNullException("角色id为空");
        }

        //先删除已授权的模块
        roleGrantMapper.deleteGrantByTabName(roleId, "cf_role_datainfo");
        List<Map<String, String>> infoList = roleGrant.getInfoList();
        if (infoList == null || infoList.isEmpty()) {
            return;
        }
        List list = new ArrayList();
        for (Map<String, String> map : infoList) {
            RoleGrant r = new RoleGrant();
            r.setId(UUIDGenerator.getPrimaryKey());
            r.setRoleId(roleId);
            r.setDatatableId(map.get("datatable_id"));
            r.setChecked(map.get("checked").equals("true") ? "1" : "0");
            r.setReadwrite(map.get("readwrite"));

            list.add(r);
        }
        roleGrantMapper.insertGrantLeaderInfo(list);
    }

    //保存信息项权限
    @Override
    public void insertGrantInfo(RoleGrant roleGrant) {
        if (roleGrant == null) {
            throw new ParameterNullException("参数不能为空");
        }
        String roleId = roleGrant.getRoleId();
        if (StringUtils.isBlank(roleId)) {
            throw new ParameterNullException("角色id为空");
        }
        //先删除已授权的模块
        roleGrantMapper.deleteGrantByTabName(roleId, "cf_role_datacolinfo");
        List<Map<String, String>> infoList = roleGrant.getInfoList();
        if (infoList == null || infoList.isEmpty()) {
            return;
        }
        List list = new ArrayList();
        for (Map<String, String> map : infoList) {
            RoleGrant r = new RoleGrant();
            r.setId(UUIDGenerator.getPrimaryKey());
            r.setRoleId(roleId);
            r.setDatacolId(map.get("datacol_id"));
            r.setReadwrite(map.get("readwrite"));
            list.add(r);
        }
        roleGrantMapper.insertGrantInfo(list);
    }

    //获得干部类别信息权限
    @Override
    public RoleGrant selectGrantLeaderType(String roleId, String leaderTypeId) {
        if (StringUtils.isBlank(roleId)) {
            throw new ParameterNullException("角色id不能为空");
        }
        //当前用户具有的信息集权限
        List<DataTable> currDataTableList = leaderTypeService.selectGrantLeaderTypeInfo(leaderTypeId);
        List<Tree> infoList = new ArrayList<>();
        if (currDataTableList != null && !currDataTableList.isEmpty()) {
            for (DataTable dataTable : currDataTableList) {
                Tree tree = new Tree();
                tree.setId(dataTable.getTabCode());
                tree.setLabel(dataTable.getTabName());
                infoList.add(tree);
            }
        }
        //当前角色已分配的信息集
        List<String> checkList = roleGrantMapper.selectGrantLeaderTypeInfo(roleId, leaderTypeId);
        RoleGrant roleGrant = new RoleGrant();
        roleGrant.setTreeList(TreeUtil.listToTreeJson(infoList));
        roleGrant.setCheckList(checkList);
        return roleGrant;
    }

    //获取干部类别
    @Override
    public List<Tree> selectLeaderType() {
        //查询干部类别
        List<Tree> leaderTypeList = roleGrantMapper.selectLeaderType(Constants.LEADER_TYPE);
        if (leaderTypeList == null || leaderTypeList.isEmpty()) {
            throw new DataExistException("字典中干部类别不存在");
        }
        return leaderTypeList;
    }

    //获取机构授权
    @Override
    public RoleGrant selectGrantOrg(String roleId) {
        if (StringUtils.isBlank(roleId)) {
            throw new ParameterNullException("角色id不能为空");
        }
        List<Tree> list = orgService.selectOrgTree();
        List<String> checkList = roleGrantMapper.selectGrantOrg(roleId);
        RoleGrant roleGrant = new RoleGrant();
        roleGrant.setCheckList(checkList);
        roleGrant.setTreeList(list);
        return roleGrant;
    }

    //拷贝角色权限
    @Override
    public void copyRoleGrantForOtherRole(String srcRoleId, List<String> list) {
        if (StringUtils.isBlank(srcRoleId)) {
            throw new ParameterNullException("源角色id不能为空");
        }
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            String tarRoleId = list.get(i);
            if (tarRoleId.equals(srcRoleId)) {
                continue;
            }
            //先删除角色所有的权限
            deleteRoleGrant(tarRoleId);
            //开始拷贝权限
            copyRoleGrant(srcRoleId, tarRoleId);
        }
    }

    //获取人员信息集权限
    @Override
    public List<Map<String, Object>> selectGrantdataInfo(String id) {
        if (StringUtils.isBlank(id)) {
            throw new ParameterNullException("角色id不能为空");
        }
        UserInfo userInfo = UserInfoUtil.getUserInfo();
        String orgId = userInfo.getOrgId();
        if (StringUtils.isEmpty(orgId)) {
            throw new ParameterNullException("用户所属机构为空");
        }
        List<Map<String, Object>> list = roleGrantMapper.selectGrantdataInfo(id, orgId);
        return list;
    }

    //获取侧边列表
    @Override
    public List<Map<String, Object>> selectGrantListInfo() {
        UserInfo userInfo = UserInfoUtil.getUserInfo();
        String orgId = userInfo.getOrgId();
        if (StringUtils.isEmpty(orgId)) {
            throw new ParameterNullException("用户所属机构为空");
        }
        return roleGrantMapper.selectGrantListInfo(orgId);
    }

    //获取信息项
    @Override
    public List<Map<String, Object>> selectGrantInfo(String id, String tablecode) {
        if (StringUtils.isBlank(id)) {
            throw new ParameterNullException("角色id不能为空");
        }
        List<Map<String, Object>> list = roleGrantMapper.selectGrantInfo(id, tablecode);
        return list;
    }

    private void copyRoleGrant(String srcRoleId, String tarRoleId) {
        //拷贝模块
        roleGrantMapper.copyGrantModule(srcRoleId, tarRoleId);
        //拷贝机构
        roleGrantMapper.copyGrantOrg(srcRoleId, tarRoleId);
        //拷贝干部类别
        roleGrantMapper.copyGrantLeaderType(srcRoleId, tarRoleId);
        //拷贝单点登录系统
        roleGrantMapper.copyGrantSystem(srcRoleId, tarRoleId);
    }

    private void deleteRoleGrant(String roleId) {
        roleGrantMapper.deleteGrantByTabName(roleId, "cf_role_module");
        roleGrantMapper.deleteGrantByTabName(roleId, "cf_roleb01");
        roleGrantMapper.deleteGrantByTabName(roleId, "cf_role_system");
        roleGrantMapper.deleteGrantByTabName(roleId, "cf_role_leader_info");
        roleGrantMapper.deleteGrantByTabName(roleId, "cf_role_datainfo");
        roleGrantMapper.deleteGrantByTabName(roleId, "cf_role_datacolinfo");
    }

    /**
     * 转成list集合
     *
     * @author sunqian
     * @date 2019/6/27 9:57
     */
    private List<RoleGrant> getRoleGrantList(String roleId, List<String> checkList) {
        List<RoleGrant> list = new ArrayList<>();
        for (String id : checkList) {
            RoleGrant rg = new RoleGrant();
            rg.setId(UUIDGenerator.getPrimaryKey());
            rg.setCheckId(id);
            rg.setRoleId(roleId);
            rg.setModifyTime(new Date());
            rg.setModifyUser(UserInfoUtil.getUserInfo().getId());
            list.add(rg);
        }
        return list;
    }
}
