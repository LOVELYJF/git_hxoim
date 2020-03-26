package com.hxoim.support.b01.service.impl;

import com.hxoim.common.exceptions.DataExistException;
import com.hxoim.common.exceptions.ParameterNullException;
import com.hxoim.common.tree.Tree;
import com.hxoim.common.tree.TreeUtil;
import com.hxoim.common.utils.Constants;
import com.hxoim.common.utils.UUIDGenerator;
import com.hxoim.common.utils.UserInfoUtil;
import com.hxoim.support.b01.entity.OrgGrant;
import com.hxoim.support.b01.mapper.OrgGrantMapper;
import com.hxoim.support.b01.service.OrgGrantService;
import com.hxoim.support.b01.service.OrgService;
import com.hxoim.support.inforesource.entity.DataTable;
import com.hxoim.support.leadertype.service.LeaderTypeService;
import com.hxoim.support.module.entity.Module;
import com.hxoim.support.module.service.ModuleService;
import com.hxoim.support.system.entity.SystemInfo;
import com.hxoim.support.system.mapper.SystemInfoMapper;
import com.hxoim.support.system.service.SystemInfoService;
import com.hxoim.support.user.entity.User;
import com.hxoim.support.user.mapper.UserMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author sunqian
 * @Desc 机构授权
 * @Date 2019/6/24 14:07
 */
@Service
public class OrgGrantServiceImpl implements OrgGrantService {


    @Autowired
    private ModuleService moduleService;
    @Autowired
    private OrgGrantMapper orgGrantMapper;
    @Autowired
    private SystemInfoMapper systemInfoMapper;
    @Autowired
    private LeaderTypeService leaderTypeService;
    @Autowired
    private OrgService orgService;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private SystemInfoService systemInfoService;


    @Override
    public OrgGrant selectGrantModule(String orgId) {
        if (orgId == null) {
            throw new ParameterNullException("机构id为空");
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
        List<String> grantModule = orgGrantMapper.selectGrantModuleId(orgId);
        OrgGrant orgGrant = new OrgGrant();
        orgGrant.setTreeList(TreeUtil.listToTreeJson(treeList));
        orgGrant.setCheckList(grantModule);
        return orgGrant;
    }

    @Override
    public OrgGrant selectGrantSystem(String orgId) {
        if (orgId == null) {
            throw new ParameterNullException("机构id为空");
        }
        //获取所有的系统
        List<SystemInfo> systemInfoList = systemInfoService.selectCurrUserGrantSystemInfo();
        List<Tree> infoList = new ArrayList<>();
        if (systemInfoList != null && !systemInfoList.isEmpty()) {
            for (SystemInfo systemInfo : systemInfoList) {
                Tree tree = new Tree();
                tree.setId(systemInfo.getId());
                tree.setLabel(systemInfo.getSystemName());
                infoList.add(tree);
            }
        }
        List<String> checkList = orgGrantMapper.selectGrantSysInfo(orgId);
        OrgGrant orgGrant = new OrgGrant();
        orgGrant.setTreeList(TreeUtil.listToTreeJson(infoList));
        orgGrant.setCheckList(checkList);
        return orgGrant;
    }

    @Override
    public void insertGrantModule(OrgGrant orgGrant) {
        if (orgGrant == null) {
            throw new ParameterNullException("参数不能为空");
        }
        String orgId = orgGrant.getOrgId();
        if (StringUtils.isBlank(orgId)) {
            throw new ParameterNullException("机构id为空");
        }
        //先删除已授权的模块
        orgGrantMapper.deleteGrantByTabName(orgId, "cf_org_module");
        List<String> checkList = orgGrant.getCheckList();
        if (checkList == null || checkList.isEmpty()) {
            return;
        }
        List<OrgGrant> list = getOrgGrantList(orgId, checkList);
        orgGrantMapper.insertGrantModule(list);
    }

    @Override
    public void insertGrantSystem(OrgGrant orgGrant) {
        if (orgGrant == null) {
            throw new ParameterNullException("参数不能为空");
        }
        String orgId = orgGrant.getOrgId();
        if (StringUtils.isBlank(orgId)) {
            throw new ParameterNullException("角色id为空");
        }
        //先删除已授权的模块
        orgGrantMapper.deleteGrantByTabName(orgId, "cf_org_system");
        List<String> checkList = orgGrant.getCheckList();
        if (checkList == null || checkList.isEmpty()) {
            return;
        }
        List<OrgGrant> list = getOrgGrantList(orgId, checkList);
        orgGrantMapper.insertGrantSystem(list);
    }

    @Override
    public void insertGrantLeaderTypeInfo(OrgGrant orgGrant) {
        if (orgGrant == null) {
            throw new ParameterNullException("参数不能为空");
        }
        String orgId = orgGrant.getOrgId();
        String leaderTypeId = orgGrant.getLeaderTypeId();
        if (StringUtils.isBlank(orgId)) {
            throw new ParameterNullException("机构id为空");
        }
        if (StringUtils.isBlank(leaderTypeId)) {
            throw new ParameterNullException("干部类别id为空");
        }
        //先删除已授权的模块
        orgGrantMapper.deleteGrantByTabName(orgId, "cf_org_leadertype");
        List<String> checkList = orgGrant.getCheckList();
        if (checkList == null || checkList.isEmpty()) {
            return;
        }
        List<OrgGrant> list = getOrgGrantList(orgId, checkList);
        for (OrgGrant grant : list) {
            grant.setLeaderTypeId(leaderTypeId);
        }
        orgGrantMapper.insertGrantLeaderTypeInfo(list);
    }

    @Override
    public void insertGrantOrg(OrgGrant orgGrant) {
        if (orgGrant == null) {
            throw new ParameterNullException("参数不能为空");
        }
        String orgId = orgGrant.getOrgId();
        if (StringUtils.isBlank(orgId)) {
            throw new ParameterNullException("机构id为空");
        }
        //先删除已授权的模块
        orgGrantMapper.deleteGrantByTabName(orgId, "cf_org_sub");
        List<String> checkList = orgGrant.getCheckList();
        if (checkList == null || checkList.isEmpty()) {
            return;
        }
        List<OrgGrant> list = getOrgGrantList(orgId, checkList);
        int batch = 1000;
        int size = list.size();
        for (int i = 0; i <= size / batch; i++) {
            if ((i + 1) * batch < size) {
                orgGrantMapper.insertGrantOrg(list.subList(i * batch, (i + 1) * batch));
            } else {
                orgGrantMapper.insertGrantOrg(list.subList(i * batch, size));
            }
        }
    }


    @Override
    public OrgGrant selectGrantLeaderType(String orgId, String leaderTypeId) {
        if (StringUtils.isBlank(orgId)) {
            throw new ParameterNullException("机构id不能为空");
        }
        User user = userMapper.selectByPrimaryKey(UserInfoUtil.getUserInfo().getId());
        //当前用户所在机构所具有的信息集权限
        List<DataTable> dataTableList = leaderTypeService.selectGrantLeaderTypeInfo(leaderTypeId);
        //所设机构已有的权限
        List<Tree> checkTreeList = orgGrantMapper.selectOrgGrantLeaderType(orgId, leaderTypeId);
        List<String> checkList = new ArrayList<>();
        if (checkTreeList != null && !checkTreeList.isEmpty()) {
            for (Tree tree : checkTreeList) {
                checkList.add(tree.getId());
            }
        }
        OrgGrant orgGrant = new OrgGrant();
        List<Tree> infoList = new ArrayList<>();
        if (dataTableList != null && !dataTableList.isEmpty()) {
            for (DataTable dataTable : dataTableList) {
                Tree tree = new Tree();
                tree.setId(dataTable.getTabCode());
                tree.setLabel(dataTable.getTabName());
                infoList.add(tree);
            }
        }
        orgGrant.setTreeList(TreeUtil.listToTreeJson(infoList));
        orgGrant.setCheckList(checkList);
        return orgGrant;
    }

    @Override
    public List<Tree> selectLeaderType() {
        //查询干部类别
        List<Tree> leaderTypeList = orgGrantMapper.selectLeaderType(Constants.LEADER_TYPE);
        if (leaderTypeList == null || leaderTypeList.isEmpty()) {
            throw new DataExistException("字典中干部类别不存在");
        }
        return leaderTypeList;
    }

    @Override
    public OrgGrant selectGrantOrg(String orgId) {
        if (StringUtils.isBlank(orgId)) {
            throw new ParameterNullException("机构id不能为空");
        }
        List<Tree> list = orgService.selectOrgTree();
        List<String> checkList = orgGrantMapper.selectGrantOrg(orgId);
        OrgGrant orgGrant = new OrgGrant();
        orgGrant.setCheckList(checkList);
        orgGrant.setTreeList(list);
        return orgGrant;
    }

    @Override
    public void copyOrgGrantForOtherOrg(String srcOrgId, List<String> list) {
        if (StringUtils.isBlank(srcOrgId)) {
            throw new ParameterNullException("源机构id不能为空");
        }
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            String tarOrgId = list.get(i);
            if (tarOrgId.equals(srcOrgId)) {
                continue;
            }
            //先删除角色所有的权限
            deleteOrgGrant(tarOrgId);
            //开始拷贝权限
            copyOrgGrant(srcOrgId, tarOrgId);
        }
    }

    private void copyOrgGrant(String srcOrgId, String tarOrgId) {
        //拷贝模块
        orgGrantMapper.copyGrantModule(srcOrgId, tarOrgId);
        //拷贝机构
        orgGrantMapper.copyGrantOrg(srcOrgId, tarOrgId);
        //拷贝干部类别
        orgGrantMapper.copyGrantLeaderType(srcOrgId, tarOrgId);
        //拷贝单点登录系统
        orgGrantMapper.copyGrantSystem(srcOrgId, tarOrgId);
    }

    private void deleteOrgGrant(String roleId) {
        orgGrantMapper.deleteGrantByTabName(roleId, "cf_org_module");
        orgGrantMapper.deleteGrantByTabName(roleId, "cf_org_system");
        orgGrantMapper.deleteGrantByTabName(roleId, "cf_org_sub");
        orgGrantMapper.deleteGrantByTabName(roleId, "cf_org_leadertype");
    }

    /**
     * 转成list集合
     *
     * @author sunqian
     * @date 2019/6/27 9:57
     */
    private List<OrgGrant> getOrgGrantList(String orgId, List<String> checkList) {
        List<OrgGrant> list = new ArrayList<>();
        for (String id : checkList) {
            OrgGrant rg = new OrgGrant();
            rg.setId(UUIDGenerator.getPrimaryKey());
            rg.setCheckId(id);
            rg.setOrgId(orgId);
            list.add(rg);
        }
        return list;
    }
}
