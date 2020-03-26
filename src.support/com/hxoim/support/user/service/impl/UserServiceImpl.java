package com.hxoim.support.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hxoim.common.exceptions.ParameterNullException;
import com.hxoim.common.utils.Constants;
import com.hxoim.common.utils.StringUilt;
import com.hxoim.common.utils.UUIDGenerator;
import com.hxoim.support.user.entity.User;
import com.hxoim.support.user.mapper.UserMapper;
import com.hxoim.support.user.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 重置密码
     */
    @Override
    public void resetPassword(String userId) {
        if (StringUtils.isEmpty(userId)) {
            throw new ParameterNullException("参数为空");
        }
        User user = userMapper.selectByPrimaryKey(userId);
        if (user == null) {
            throw new ParameterNullException("当前用户不存在");
        }
        user.setPassword(UUIDGenerator.encryptPwd(Constants.USER_PWD));
        userMapper.updateByPrimaryKeySelective(user);
    }

    /**
     * 修改or添加
     */
    @Override
    public void InserOrUpdateSysUser(User user) {
        if (user == null) {
                throw new NullPointerException("用户不能为空");
            }
        user.setPassword(UUIDGenerator.encryptPwd(Constants.USER_PWD));
        if (StringUilt.isStrOrnull(user.getId())) {
            userMapper.updateByPrimaryKeySelective(user);
        } else {
            user.setId(UUIDGenerator.getPrimaryKey());
            userMapper.insertSelective(user);
        }
    }

    @Override
    public User selectByPrimaryKey(String userId) {
        if (StringUtils.isEmpty(userId)) {
            throw new ParameterNullException("参数为空");
        }
        User user = userMapper.selectByPrimaryKey(userId);
        if (user == null) {
            throw new NullPointerException("用户不存在");
        }
        return user;
    }

    @Override
    public void deleteByPrimaryKey(String userId) {
        if (StringUtils.isEmpty(userId)){
            throw new ParameterNullException("参数为空");
        }
        userMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public int selectByUserCode(String userName) {
        if (StringUtils.isEmpty(userName)){
            throw new ParameterNullException("登录名不能为空");
        }
        int num = userMapper.selectByUserCode(userName);
        if (num <= 0){
            throw new ParameterNullException("登录名不存在");
        }
        return num;
    }

    @Override
    public void updateUserStateByUserCode(User user) {
        String userCode = user != null ? user.getUserName() : "";
        String userState = user != null ? user.getUserState() : "";
        if (user == null || StringUtils.isEmpty(userCode) || StringUtils.isEmpty(userState)) {
            throw new ParameterNullException("登录名或登录状态不能为空");
        }
        userMapper.updateUserStateByUserCode(user);
    }

    @Override
    public PageInfo getSysUserList(Integer pageNum, Integer pageSize, String keyWord, String orgId) {
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        PageHelper.startPage(pageNum, pageSize);   //设置传入页码，以及每页的大小
        List<User> users = userMapper.getSysUserList(keyWord, orgId);
        PageInfo info = new PageInfo(users);
        return info;
    }

    @Override
    public List<User> selectUserByUserGroupId(String userGroupId) {
        if (StringUtils.isEmpty(userGroupId)){
            throw new ParameterNullException("处室id不能为空");
        }
        Map<String, Object> param = new HashMap<>();
        param.put("userGroupId", userGroupId);
        return userMapper.selectUserByUserGroupId(param);
    }

    //查询密码
    @Override
    public String selectPassword(String userId) {
        return userMapper.selectPassword(userId);
    }

    //修改密码
    @Override
    public void updatePassword(String userId, String newPassword) {
        if (StringUilt.stringIsNullOrEmpty(userId)) {
            throw new ParameterNullException("ID为空");
        }
        if (StringUilt.stringIsNullOrEmpty(newPassword)) {
            throw new ParameterNullException("新密码为空");
        }
        String selectPassword = userMapper.selectPassword(userId);
        String password = UUIDGenerator.encryptPwd(newPassword);

        if (selectPassword.equals(password)){
            throw new ParameterNullException("不能和原密码相同！");
        }
        userMapper.updatePassword(userId,password);
    }

    @Override
    public List<User> selectSysUserList() {
        return userMapper.selectSysUserList();
    }
}