package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.User;
import service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao dao=new UserDaoImpl();

    @Override
    public List<User> findAll() {
        //调用dao
        return dao.findAll();
    }

    @Override
    public User login(User user) {
        return dao.findUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public void addUser(User user) {
        dao.add(user);
    }

    @Override
    public void deleteUserByID(String id) {
        dao.deleteUserByID(Integer.parseInt(id));
    }

    @Override
    public User findUserByID(String id) {
        return dao.findUserByID(Integer.parseInt(id));
    }

    @Override
    public void updateUser(User user) {
        dao.updateUser(user);
    }

    @Override
    public void deleteUsersByID(String[] uids) {
        if (uids!=null&&uids.length>0){
            for (String uid : uids) {
                dao.deleteUserByID(Integer.parseInt(uid));
            }
        }

    }
}
