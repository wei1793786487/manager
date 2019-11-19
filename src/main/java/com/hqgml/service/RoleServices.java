package com.hqgml.service;

import com.hqgml.domian.Permission;
import com.hqgml.domian.Role;

import java.util.List;

public interface RoleServices {


    List<Role> findAll();

    void addRole(Role role);

    Role findById(String roleId);

    List<Permission> OtherPermission(String roleId);

    void addPermissionTorole(String roleId, String[] perId);
}
