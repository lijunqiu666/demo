package edu.whut.dao;

import edu.whut.bean.User;

import java.util.List;

public interface UserDao {
    /**
     * 插入用户
     *
     * @param user 用户
     */
    void save(User user);

    /**
     * 删除用户
     *
     * @param username 用户名
     */
    void deleteUser(String username);


    void update(User user);

    List<User> findAll();

    User findById(int id);
}
