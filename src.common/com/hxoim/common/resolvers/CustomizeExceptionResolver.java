package com.hxoim.common.resolvers;

import com.alibaba.fastjson.JSONObject;
import com.hxoim.common.utils.Result;
import com.hxoim.support.errorLog.entity.CfErrorlogWithBLOBs;
import com.hxoim.support.errorLog.service.CfErrorlogService;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomizeExceptionResolver implements HandlerExceptionResolver {

    private static Logger logger = LogManager.getLogger(CustomizeExceptionResolver.class);
    @Autowired
    private CfErrorlogService errorlogService;

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        httpServletResponse.setContentType("text/html;charset=UTF-8");
        try {
            httpServletResponse.getWriter().write(JSONObject.toJSONString(Result.error(e.getMessage())));
            logger.error(e.getMessage());

            CfErrorlogWithBLOBs log=new CfErrorlogWithBLOBs();
            log.setErrorInfo(e.getMessage());
            log.setErrorTrace(StringUtils.join(e.getStackTrace(),','));
            errorlogService.insertSelective(log);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
