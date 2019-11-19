package com.hqgml.dao;

import com.hqgml.domian.Permission;
import com.hqgml.service.PermissionServices;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PermissionDao {

    @Select("select * from permission where id in (select permissionid from role_permission where roleId= #{id})")
    public List<Permission> findAllByRoleId(String id);

    @Select("select * from permission")
    List<Permission> findAll();

    @Insert("insert into permission(permissionName,url) values(#{permissionName},#{url})")
    void addPer(Permission permission);
}
