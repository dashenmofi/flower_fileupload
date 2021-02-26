package com.mofei.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class DBUtil {

    private   static SqlSessionFactory factory;

    private  static ThreadLocal<SqlSession>  tl=new ThreadLocal<>();

    static {
        InputStream inputStream = null;
        try {
            //[1]解析myBatis.xml文件
            inputStream = Resources.getResourceAsStream("mybatis.xml");
            //[2]获得sqlsession工厂
            factory=new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //获得sqlsession对象
    public  static SqlSession   getSqlSession(){

        //获得ThreadLoacl中的sqlsession对象
        SqlSession sqlSession = tl.get();

        if(sqlSession==null){

            sqlSession = factory.openSession(true);

            //把创建好的对象放到ThreadLoacl
            tl.set(sqlSession);
        }

        return  tl.get();
    }


    //关闭sqlsession

    public  static    void closeAll(){

        SqlSession sqlSession = tl.get();

        if(sqlSession!=null){

            sqlSession.close();

        }
        tl.set(null);
    }

}
