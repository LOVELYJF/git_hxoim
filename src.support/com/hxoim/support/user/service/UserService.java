package com.hxoim.support.user.service;

import com.github.pagehelper.PageInfo;
import com.hxoim.support.user.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
   /**
    *@ author：三凡
    *@ desc：重置密码
    *@ date：2019/5/27
    **/
   void resetPassword(String userId);

   /**
    *@ author：三凡
    *@ desc：新增or修改 user
    *@ date：2019/5/27
    **/
   void InserOrUpdateSysUser(User user);
   /**
    *@ author：三凡
    *@ desc：根据userId查询  去用户修改页面
    *@ date：2019/5/27
    **/
   User selectByPrimaryKey(String userId);
   /**
    *@ author：三凡
    *@ desc：根据userId 删除 用户
    *@ date：2019/5/27
    **/
   void deleteByPrimaryKey(String userId);
   /**
    *@ author：三凡
    *@ desc：校验orgCode
    *@ date：2019/5/27
    **/
   int selectByUserCode(String userName);
   /**
    *@ author：三凡
    *@ desc：根据userCode 修改状态
    *@ date：2019/5/27
    **/
   void updateUserStateByUserCode(User user);

   /**
    *@ author：三凡
    *@ desc：用户查询列表
    *@ date：2019/5/27
    **/
   PageInfo getSysUserList(Integer pageNum, Integer pageSize, String keyWord, String orgId);

   /**
    * @desc: 通过处室id查询用户
    * @author: lijing
    * @date: 2019/7/24
    */
   List<User> selectUserByUserGroupId(String userGroupId);

   /**
    *@ author：孙登
    *@ desc：查询密码
    *@ date：2019/8/1
    **/
   String selectPassword(String userId);

   /**
    *@ author：孙登
    *@ desc：修改密码
    *@ date：2019/8/1
    **/
   void updatePassword(String userId,String newPassword);

   /**
    * 获取所有的使用中的管理员账号
    *
    * @author sunqian
    * @date 2019/9/3 15:08
    */
    List<User> selectSysUserList();
}
