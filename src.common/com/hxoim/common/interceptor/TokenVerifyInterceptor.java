package com.hxoim.common.interceptor;

import com.hxoim.common.exceptions.UserCheckException;
import com.hxoim.common.listener.TokenExpireListener;
import com.hxoim.common.timer.PassTask;
import com.hxoim.common.utils.Constants;
import com.hxoim.support.parameter.service.ParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

public class TokenVerifyInterceptor implements HandlerInterceptor {

    @Autowired
    private ParameterService parameterService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Map tokenCacheMap = TokenExpireListener.getTokenCacheMap();
        //获取token
        String token = request.getHeader(Constants.TOKEN_KEY);
        if (token == null) {
            throw new UserCheckException("令牌（token）不存在");
        }
        Object token1 = tokenCacheMap.get("token");
        if (token1 == null) {
            PassTask.setPassTaskForCacheMap(token, Constants.DEFAULT_PASS_MINS);
        }
        //检验token是否过期
        boolean flag = tokenCacheMap.containsKey(token);
        if (!flag) {
            throw new UserCheckException("令牌过期");
        } else {
            String mins = parameterService.selectPValueByCode("expireTimes");
            PassTask.setPassTaskForCacheMap(token, mins);
        }
        return true;
    }
}
