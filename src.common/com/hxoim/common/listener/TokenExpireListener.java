package com.hxoim.common.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TokenExpireListener implements ServletContextListener {

    /**
     * 创建线程安全Map集合，key为token，value为timer
     */
    private static final Map<String, Object> tokenCacheMap = new ConcurrentHashMap();

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().setAttribute("tokenCacheMap", tokenCacheMap);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

    public static Map<String, Object> getTokenCacheMap() {
        return tokenCacheMap;
    }
}
