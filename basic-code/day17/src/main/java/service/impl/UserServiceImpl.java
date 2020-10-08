package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.PageBean;
import domain.User;
import service.UserService;

import java.util.List;
import java.util.Map;

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

    @Override
    public PageBean<User> findUserByPage(String strCurrentPage, String strRows, Map<String, String[]> condition) {

        PageBean<User> pb=new PageBean<>();
        int currentPage=Integer.parseInt(strCurrentPage);
        int rows=Integer.parseInt(strRows);

        if (currentPage<=0){
            currentPage=1;
        }



        int totalCount=dao.findTotalCount(condition);
        pb.setTotalCount(totalCount);

        int totalPage= (int) Math.ceil((double)totalCount/(double)rows);
        pb.setTotalPage(totalPage);

        if (currentPage>totalPage){
            currentPage=totalPage;
        }

        int start=(currentPage-1)*rows;
        List<User> list=dao.findByPage(start,rows,condition);
        pb.setList(list);

        pb.setCurrentPage(currentPage);
        pb.setRows(rows);

        return pb;
    }
}
