package com.hxoim.common.utils;

import com.alibaba.fastjson.JSONObject;
import com.hxoim.common.exceptions.UserCheckException;
import com.hxoim.support.user.entity.User;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTUtil {

    public static void main(String[] args) throws UserCheckException, UnsupportedEncodingException, InvocationTargetException, IllegalAccessException {
        User user = new User();
        user.setUserName("admin");
        user.setPassword("123");
        user.setId("123123");
        String token = createToken(user);
        System.out.println(token);
        User user1 = parseToken(token);
        System.out.println(user1.getUserName());

    }

    /**
     * 生成token
     *
     * @param user 登录的用户
     * @return 加密的字符串
     */
    public static String createToken(User user) throws UnsupportedEncodingException {
        Base64.Encoder encoder = Base64.getEncoder();
        //设置用户信息
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", user.getId());
        claims.put("userName", user.getUserName());
        claims.put("password", user.getPassword());
        claims.put("name", user.getName());
        claims.put("loginDate", System.currentTimeMillis());
        String token = "HX" + encoder.encodeToString(JSONObject.toJSONString(claims).getBytes("UTF-8"));
        return token;
    }

    /**
     * 解析token
     *
     * @param token 需要解析的token
     * @return 解析后存放用户信息的map
     */
    public static User parseToken(String token) throws UserCheckException, UnsupportedEncodingException, InvocationTargetException, IllegalAccessException {
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decode = decoder.decode(token.substring(2));
        String userJSON = new String(decode, "UTF-8");
        Map map = JSONObject.parseObject(userJSON, Map.class);
        User user = new User();
        BeanUtils.populate(user, map);
        return user;
    }

    /**
     * 校验token
     *
     * @param token 需要校验的token
     * @param user  需要校验的用户
     */
    public static boolean checkToken(String token, User user) throws Exception {
        if (StringUtils.isBlank(token) || user == null) {
            return false;
        }
        User tokenUser = parseToken(token);
        if (!tokenUser.getUserName().equals(user.getUserName()) || !tokenUser.getPassword().equals(user.getPassword())) {
            return false;
        }
        return true;
    }
}
