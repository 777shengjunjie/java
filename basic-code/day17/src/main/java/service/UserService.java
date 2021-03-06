package service;


import domain.PageBean;
import domain.User;

import java.util.List;
import java.util.Map;

/**
 * 用户管理的业务接口
 */
public interface UserService {

    /**
     * 查询用户方法
     * @return
     */
    public List<User> findAll();

    //登录方法
    public User login(User user);

    //保存对象
    void addUser(User user);

    //删除对象
    void deleteUserByID(String id);

    User findUserByID(String id);

    void updateUser(User user);

    void deleteUsersByID(String[] uids);

    PageBean<User> findUserByPage(String currentPage, String rows, Map<String, String[]> condition);
}
