package com.hxoim.common.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;

public class UserInfoUtil {

    public static UserInfo getUserInfo() {
        String token = DomainObjectUtil.getRequest().getHeader(Constants.TOKEN_KEY);
        UserInfo userInfo = new UserInfo();
        try {
           BeanUtils.copyProperties(userInfo, JWTUtil.parseToken(token));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userInfo;
    }
}
