package dao;


import domain.User;

import java.util.List;

/**
 * 用户操作的数据库
 */
public interface UserDao {
    public List<User> findAll();
    public User findUsernameAndPassword(String username ,String password);

    void add(User user);

    void deleteUserByID(int id);

    User findUserByID(int id);

    void updateUser(User user);
}
