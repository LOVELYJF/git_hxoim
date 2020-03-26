package com.hxoim.common.utils;
/*
 * @description:
 * @author 杨波
 * @date:2019-06-11
 */

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Description: 生成mybatis的session对象
 **/
public class MybatisUtils {
    private static String resource = "config/mybatis-config-dao.xml";
    private static SqlSessionFactory sqlSessionFactory = null;
    private static SqlSession session = null;


    private static void init() {
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
//            创建工厂
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//            创建session对象
            session = sqlSessionFactory.openSession(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSession() {
        if (session == null) {
            init();
        }
        return session;
    }

    public static void close() {
        if (session != null) {
            session.close();
            session = null;
        }
    }

    public static <T> T getMapper(Class<T> tClass) {
        if (session == null) {
            init();
        }
        return session.getMapper(tClass);
    }

    public static void commit() {
        if (session != null) {
            session.commit();
        }
    }
}
