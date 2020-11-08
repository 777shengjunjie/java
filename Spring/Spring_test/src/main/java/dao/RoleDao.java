package dao;


import domain.Role;

import java.util.List;

public interface RoleDao {

    //查询所有角色
    List<Role> findAll();
    //添加角色
    void save(Role role);
    //根据UserID查询角色
    List<Role> findRoleByUserID(Long id);
}
