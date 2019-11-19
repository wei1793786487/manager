package com.hqgml.service.impl;

import com.hqgml.dao.PermissionDao;
import com.hqgml.domian.Permission;
import com.hqgml.service.PermissionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @data 11/17/2019 10:24 PM
 **/
@Service
public class PermissionServicesImpl implements PermissionServices {


    @Autowired
    private PermissionDao pd;


    @Override
    public List<Permission> findAll() {
       return pd.findAll();
    }

    @Override
    public void addPer(Permission permission) {
        pd.addPer(permission);
    }
}
