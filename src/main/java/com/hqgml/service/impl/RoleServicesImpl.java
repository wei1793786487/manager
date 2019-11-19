package com.hqgml.service.impl;

import com.hqgml.dao.rolesDao;
import com.hqgml.domian.Permission;
import com.hqgml.domian.Role;
import com.hqgml.service.RoleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @data 11/17/2019 9:50 PM
 **/
@Service
public class RoleServicesImpl implements RoleServices {
    @Autowired
    rolesDao rolesDao;

    @Override
    public List<Role> findAll() {
        return rolesDao.findAll();
    }

    @Override
    public void addRole(Role role) {
        rolesDao.addRole(role);
    }

    @Override
    public Role findById(String roleId) {
        return rolesDao.findByid(roleId);

    }

    @Override
    public List<Permission> OtherPermission(String roleId) {

        return rolesDao.findOtherPermisson(roleId);
    }

    @Override
    public void addPermissionTorole(String roleId, String[] perId) {
        for (String Per : perId) {
            rolesDao.addPermissionToRole(roleId,Per);
        }
    }
}
