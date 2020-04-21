//package com.rogear.library.dao;
//
//import org.apache.ibatis.io.Resources;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.ibatis.session.SqlSessionFactoryBuilder;
//import org.junit.Test;
//
//import java.io.IOException;
//import java.io.InputStream;
//
//
//public class UserMapperTest {
//
//    @Test
//    public void insert() {
//    }
//
//    @Test
//    public void selectByPrimaryKey() throws IOException {
//
//        String resource = "mybatis-config.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory =
//                new SqlSessionFactoryBuilder().build(inputStream);
//
//        try (SqlSession session = sqlSessionFactory.openSession()) {
////            Blog blog = session.selectOne(
////                    "org.mybatis.example.BlogMapper.selectBlog", 101);
//            User user = session.selectOne("com.rogear.library.dao.UserMapper.selectByPrimaryKey",1);
//            System.out.println(user.toString());
//        }
//    }
//}
