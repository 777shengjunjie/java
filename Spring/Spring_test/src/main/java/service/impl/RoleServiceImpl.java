package service.impl;

import dao.RoleDao;
import domain.Role;
import service.RoleService;

import java.util.List;

public class RoleServiceImpl implements RoleService {

    private RoleDao roleDao;

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<Role> list() {
        List<Role> roleList= roleDao.findAll();

        return roleList;
    }
}
