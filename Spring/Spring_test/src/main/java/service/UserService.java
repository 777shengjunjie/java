package service;

import domain.User;

import java.util.List;

public interface UserService {
    List<User> list();

    /**
     * 展示添加用户
     * @param user
     */
    void save(User user,Long[] roleIds);

    void del(Long userId);

    User login(String username, String password);
}
