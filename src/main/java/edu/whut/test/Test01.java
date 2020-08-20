package edu.whut.test;

import edu.whut.bean.User;
import edu.whut.dao.UserDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * demo
 * 2020/8/11 11:28
 *
 * @author 李俊秋
 **/

public class Test01 {
    public static void main(String[] args) {
        // 加载MyBatis的配置文件
        InputStream inputStream = Test01.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        /*        8.11*/
//        String statement = "edu.whut.dao.UserDao.save";
//        String statement = "edu.whut.dao.UserDao.deleteUser";
//        User user = new User(6, "张三", "123", 12);
//        sqlSession.insert(statement, user);
//        String username="小王";
//        sqlSession.delete(statement,username);
        /*8.12*/
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = new User(9, "zhaowu", "123", 34);
        userDao.save(user);
        List<User> users = userDao.findAll();
        User user1 = userDao.findById(1);
        System.out.println(users);
        System.out.println(user1);

//测验
        sqlSession.commit();
    }

}
