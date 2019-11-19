package com.hqgml.service;

import com.hqgml.domian.Permission;

import java.util.List;

/**
 * @data 11/17/2019 10:24 PM
 **/
public interface PermissionServices {
    List<Permission> findAll();

    void addPer(Permission permission);
}
