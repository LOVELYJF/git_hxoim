package com.hxoim.support.b01.service.impl;

import com.hxoim.common.exceptions.ParameterNullException;
import com.hxoim.common.tree.Tree;
import com.hxoim.common.tree.TreeUtil;
import com.hxoim.common.utils.*;
import com.hxoim.support.b01.entity.B01;
import com.hxoim.support.b01.mapper.B01Mapper;
import com.hxoim.support.b01.service.OrgService;
import com.hxoim.support.user.entity.User;
import com.hxoim.support.user.mapper.UserMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author: sunqian
 * @desc: 机构管理实现类
 * @date: 2019/5/28 17:34
 */
@Service
public class OrgServiceImpl implements OrgService {

    @Autowired
    private B01Mapper b01Mapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Tree> selectOrgTree() {
        User user = userMapper.selectByPrimaryKey(UserInfoUtil.getUserInfo().getId());
        //判断用户类型根据类型不同用不同的方式查询
        List<Tree> treeList = null;
        if (Constants.USER_TYPES[0].equals(user.getUserType())) {
            //管理员直接查询所属机构所拥有的的机构权限
            treeList = b01Mapper.selectOrgGrantTree(user.getOrgId());
        } else {
            //普通用户所拥有的权限
            treeList = b01Mapper.selectUserGrantTree(user.getId());
        }
        treeList = TreeUtil.listToTreeJson(treeList);
        return treeList;
    }

    /**
     * @ description: 修改机构
     * @ create by: 张乾
     * @ createDate: 2019/6/5 14:36
     */
    @Override
    public void updateOrg(B01 b01) {
        CheckInput(b01);
        b01.setModifyUser(UserInfoUtil.getUserInfo().getId());
        b01.setModifyTime(UtilDateTime.toDateTimeString(new Date()));
        b01Mapper.updateOrg(b01);
    }

    /**
     * @ description: 添加机构
     * @ create by: 张乾
     * @ createDate: 2019/6/5 14:58
     */
    @Override
    public void insertOrg(B01 b01) {
        CheckInput(b01);
        b01.setB0111(b01Mapper.getNextOrgCode(b01.getB0121()));
        b01Mapper.insertOrg(b01);
    }

    /**
     * @description:判断机构参数是否合法
     * @author:杨波
     * @date:2019-07-27 * @param b01
     * @return:void
     **/
    private void CheckInput(B01 b01) {
        if (b01 == null) {
            throw new ParameterNullException("机构不能为空");
        }
        if (StringUilt.stringIsNullOrEmpty(b01.getB0101())) {
            throw new ParameterNullException("机构名称不能为空");
        }
        if (StringUilt.stringIsNullOrEmpty(b01.getB0114())) {
            throw new ParameterNullException("机构编码不能为空");
        }

        int count = b01Mapper.doubleOrgCode(b01);
        if (count > 0) {
            throw new ParameterNullException("机构编码重复");
        }
        count = b01Mapper.doubleOrgName(b01);
        if (count > 0) {
            throw new ParameterNullException("机构名称重复");
        }
    }

    /**
     * @ description: 机构简称查询
     * @ create by: 张乾
     * @ createDate: 2019/6/5 15:08
     */
    @Override
    public List<B01> selectOrg(B01 b01) {
        if (b01 == null) {
            throw new ParameterNullException("机构不能为空");
        }
        List<B01> b01Org = b01Mapper.selectOrg(b01);
        return b01Org;
    }

    /**
     * @ description: 删除机构
     * @ create by: 张乾
     * @ createDate: 2019/6/5 15:31
     */
    @Override
    @Transactional
    public void deleteOrg(String b0111) {
        if (StringUtils.isBlank(b0111)) {
            throw new ParameterNullException("机构代码不能为空");
        }
        int count = b01Mapper.selectOrgByPid(b0111);
        if (count > 0) {
            throw new ParameterNullException("该机构有下级机构，无法删除！");
        }
        b01Mapper.deleteOrg(b0111);
    }

    /**
     * @ description: 机构排序
     * @ create by: 张乾
     * @ createDate: 2019/6/5 16:13
     */
    @Override
    public void sortOrg(String b0111s) {
        if (StringUtils.isBlank(b0111s)) {
            throw new ParameterNullException("排序机构不能为空");
        }
        String[] b01s = b0111s.split(",");
        b01Mapper.sortOrg(b01s);
    }

    /**
     * @ description: 查询下级机构列表
     * @ create by: 张乾
     * @ createDate: 2019/6/5 16:35
     */
    @Override
    public List<B01> selectOrgById(B01 b01) {
        if (b01 == null) {
            throw new ParameterNullException("机构不能为空");
        }
        List<B01> b01List = b01Mapper.selectOrgById(b01);
        return b01List;
    }

    /**
     * @ description: 通过标识编码查询机构
     * @ create by: 张乾
     * @ createDate: 2019/6/7 15:50
     */
    @Override
    public B01 selectOrgByB0111(String b0111) {
        if (StringUtils.isBlank(b0111)) {
            throw new ParameterNullException("机构代码不能为空");
        }
        return b01Mapper.selectOrgByB0111(b0111);
    }

    @Override
    public List<B01> selectOrgAllList() {
        return b01Mapper.selectOrgAllList();
    }
}
