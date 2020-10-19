package cn.itcast.travel.service.Impl;

import cn.itcast.travel.dao.Impl.UserDaoImpl;
import cn.itcast.travel.dao.UserDao;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.util.MailUtils;
import cn.itcast.travel.util.UuidUtil;

public class UserServiceImpl implements UserService {

    private UserDao userDao=new UserDaoImpl();

    /**
     * 注册
     * @param user
     * @return
     */
    @Override
    public boolean regist(User user) {

        User u = userDao.findByUsername(user.getUsername());
        if (u!=null){
            return false;
        }

        user.setCode(UuidUtil.getUuid());
        user.setStatus("N");

        userDao.save(user);

        //String content="<a href='http://localhost:8080/travel/user/active?code="+user.getCode()+"'>点击激活【黑马旅游网】</a>";
        String content="<a href='http://34.92.81.190:8080/travel/user/active?code="+user.getCode()+"'>点击激活【黑马旅游网】</a>";

        MailUtils.sendMail(user.getEmail(),content,"激活邮件");


        return true;


    }

    @Override
    public boolean active(String code) {

        User user=userDao.findByCode(code);
        if (user!=null){
            userDao.updateStatus(user);
            return true;
        }else {

        return false;

        }
    }

    @Override
    public User login(User user) {

        return userDao.findByUsernameAndPassword(user.getUsername(),user.getPassword());
    }


}
