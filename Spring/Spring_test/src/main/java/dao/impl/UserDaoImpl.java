package dao.impl;

import dao.UserDao;
import ssmweb.domain.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public User findByUsernameAndPassword(String username, String password) throws EmptyResultDataAccessException {
        String sql="select * from sys_user where username = ? and password = ? ";
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);

        return user;
    }

    @Override
    public List<User> findAll() {

        String sql="select * from sys_user ";
        List<User> userList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return userList;
    }

    @Override
    public long save(User user) {

        PreparedStatementCreator creator=new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                String sql ="insert into sys_user values(?,?,?,?,?) ";
                PreparedStatement preparedStatement=con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
                preparedStatement.setObject(1,null);
                preparedStatement.setObject(2,user.getUsername());
                preparedStatement.setObject(3,user.getEmail());
                preparedStatement.setObject(4,user.getPassword());
                preparedStatement.setObject(5,user.getPhoneNum());


                return preparedStatement;
            }
        };

        GeneratedKeyHolder keyHolder=new GeneratedKeyHolder();
        jdbcTemplate.update(creator,keyHolder);
        long userId = keyHolder.getKey().longValue();

        return userId;
    }


    @Override
    public void saveByUserId(long userId,Long[] roleIds) {

        String sql="insert into sys_user_role values(?,?) ";
        for (Long roleId : roleIds) {
            jdbcTemplate.update(sql,userId,roleId);
        }


    }

    @Override
    public void delRel(Long userId) {
        String sql="delete from sys_user_role where userId = ? ";
        jdbcTemplate.update(sql,userId);
    }

    @Override
    public void del(Long userId) {
        String sql="delete from sys_user where id = ? ";
        jdbcTemplate.update(sql,userId);
    }
}
