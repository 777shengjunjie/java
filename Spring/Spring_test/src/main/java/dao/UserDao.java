package dao;

import domain.User;

import java.util.List;

public interface UserDao {
    User findByUsernameAndPassword(String username, String password);

    List<User> findAll();

    long save(User user);

    void saveByUserId(long userId,Long[] roleIds);

    //删除关联表数据
    void delRel(Long userId);
    //删除sys_user
    void del(Long userId);
}
