package com.hxoim.support.user.mapper;

import com.hxoim.support.user.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    int deleteByPrimaryKey(String userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectPasswordByUsername(String username);

    int selectByUserCode(String userName);

    void updateUserStateByUserCode(User record);

    List<User> getSysUserList(@Param("userName") String keyWord, @Param("orgId") String orgId);

    /**
     * @desc: 通过处室id查询用户
     * @author: lijing
     * @date: 2019/7/24
     */
    List<User> selectUserByUserGroupId(Map<String, Object> params);

    /**
     * @desc: 查询所有用户
     * @author: lijing
     * @date: 2019/8/10
     */
    List<User> selectAllUser();

    /**
     * @desc: 查询密码
     * @author: 孙登
     * @date: 2019/8/1
     */
    String selectPassword(String userId);

    /**
     * @desc: 修改密码
     * @author: 孙登
     * @date: 2019/8/1
     */
    void updatePassword(@Param("userId") String userId, @Param("password") String password);

    /**
     * 获取所有的使用中的管理员账号
     *
     * @author sunqian
     * @date 2019/9/3 15:08
     */
    List<User> selectSysUserList();
}