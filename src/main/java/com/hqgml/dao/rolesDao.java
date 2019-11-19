package com.hqgml.dao;

import com.hqgml.domian.Permission;
import com.hqgml.domian.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface rolesDao {
    //根据id获取对应的信息
    @Select("select * from role  where id in (select roleid from users_role where userId= #{userid})")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permissions", column = "id", javaType = java.util.List.class, many = @Many(select = "com.hqgml.dao.PermissionDao.findAllByRoleId")),

    })
    public List<Role> findUsersByUid(String userid);

    //查询所有的用户
    @Select("select * from role ")
    List<Role> findAll();

    //添加一个新的用户
    @Insert("insert into role (roleName,roleDesc) values (#{roleName},#{roleDesc})")
    void addRole(Role role);

    @Select("select * from role where id= #{roleId}")
    Role findByid(String roleId);

    @Select("select *from permission where id not in(select permissionid from role_permission where roleId=#{roleId}) ")
    List<Permission> findOtherPermisson(String roleId);

    @Insert("insert into role_permission(roleid,permissionid)values (#{roleId},#{per}) ")
    void addPermissionToRole(@Param("roleId") String roleId, @Param("per") String per);

}
