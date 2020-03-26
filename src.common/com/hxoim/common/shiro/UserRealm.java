package com.hxoim.common.shiro;

import com.hxoim.support.user.entity.User;
import com.hxoim.support.user.mapper.UserMapper;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class UserRealm extends AuthorizingRealm {


    private UserMapper userMapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.err.println("调用验证。。。。。。");
        return null;
    }

    /**
     * 登录验证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
            throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();
        //通过username去数据库中获取密码
        User user = userMapper.selectPasswordByUsername(username);
        if (user == null) {
            throw new NullPointerException("该用户不存在");
        } else if (user.getPassword() == null) {
            throw new NullPointerException("该用户密码有问题，联系管理员");
        }
        SimpleAuthenticationInfo userInfo = new SimpleAuthenticationInfo
                (username, user.getPassword(), "userRealm");
        return userInfo;
    }
}
