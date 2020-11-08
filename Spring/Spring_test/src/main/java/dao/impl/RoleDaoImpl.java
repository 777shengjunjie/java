package dao.impl;

import dao.RoleDao;
import domain.Role;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class RoleDaoImpl implements RoleDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Role> findAll() {

        String sql="select * from sys_role ";
        List<Role> roleList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Role>(Role.class));
        return roleList;
    }

    @Override
    public void save(Role role) {
        String sql="insert into sys_role values(?,?,?) ";
        jdbcTemplate.update(sql,null,role.getRoleName(),role.getRoleDesc());
    }

    @Override
    public List<Role> findRoleByUserID(Long id) {
        //sys_user_role 别名为ur
        String sql ="select * from sys_user_role ur ,sys_role r where ur.roleId = r.id and ur.userId = ? ";
        List<Role> roles = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Role>(Role.class), id);
        return roles;
    }
}
