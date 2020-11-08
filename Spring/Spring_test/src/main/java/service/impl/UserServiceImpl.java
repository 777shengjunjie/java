package service.impl;

import dao.RoleDao;
import dao.UserDao;
import domain.Role;
import domain.User;
import org.springframework.dao.EmptyResultDataAccessException;
import service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao;
    private RoleDao roleDao;

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> list() {

        List<User> userList = userDao.findAll();
        for (User user : userList) {
            Long id = user.getId();
            List<Role> roles = roleDao.findRoleByUserID(id);
            user.setRoles(roles);
        }
        return userList;
    }

    @Override
    public void save(User user, Long[] roleIds) {

        //1.存储sys_user
        long userId = userDao.save(user);
        //2.存储sys_user_role
        userDao.saveByUserId(userId, roleIds);

    }

    @Override
    public void del(Long userId) {
        //当存在连接表，需要先删除关系表
        //1.先删除sys_user_role
        userDao.delRel(userId);
        //2.再删除sys_user
        userDao.del(userId);

    }

    @Override
    public User login(String username, String password) {

        try {
            User user = userDao.findByUsernameAndPassword(username, password);
            return user;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }


}
