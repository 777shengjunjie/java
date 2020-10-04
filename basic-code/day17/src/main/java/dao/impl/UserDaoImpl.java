package dao.impl;

import dao.UserDao;
import domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtil;

import java.util.List;

public class UserDaoImpl  implements UserDao {

    private JdbcTemplate template=new JdbcTemplate(JDBCUtil.getDs());

    @Override
    public List<User> findAll() {
        //使用Jdbc操作数据库
        String sql="select * from user";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));


        return users;
    }

    @Override
    public User findUsernameAndPassword(String username, String password) {
       try{
           String sql="select * from user where username = ? and password = ?";
           User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
           return user;
       }catch(Exception e){
           e.printStackTrace();
           return null;
       }

    }

    @Override
    public void add(User user) {

        String sql="insert into user value(null,?,?,?,?,?,?,null,null)";
        template.update(sql,user.getName(),user.getGender(),user.getAge(),
                user.getAddress(),user.getQq(),user.getEmail());
    }

    @Override
    public void deleteUserByID(int id) {
        String sql="delete from user where id =?";
        template.update(sql,id);
    }

    @Override
    public User findUserByID(int id) {
        String sql="Select * from user where id = ? ";

        return template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),id);
    }

    @Override
    public void updateUser(User user) {
        String sql="update user set name = ? ,gender = ?, age = ?, address=?, qq=? ,email=? where id=?  ";
        template.update(sql,user.getName(),user.getGender(),user.getAge(),
                user.getAddress(),user.getQq(),user.getEmail(),user.getId());

    }
}
