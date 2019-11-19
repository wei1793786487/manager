package com.hqgml.dao;

import com.hqgml.domian.Role;
import com.hqgml.domian.UserInfo;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @data 11/17/2019 3:09 PM
 **/
public interface UserDao {

    @Select("select * from users where username=#{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles", column = "id", javaType = java.util.List.class, many = @Many(select = "com.hqgml.dao.rolesDao.findUsersByUid"))


    })
    public UserInfo findUser(String username);

    @Select("select * from users where username=#{username}")
    public UserInfo findUser2(String username);

    /**
     * 查询所有的用户
     *
     * @return
     */
    @Select("select * from users")
    List<UserInfo> findAllUser();

    /**
     * 保存用户
     *
     * @param userInfo
     */
    @Insert("insert into users(email,username,password,phoneNum,status) values(#{email},#{username},#{password},#{phoneNum},#{status})")
    void savaUser(UserInfo userInfo);

    /**
     * 根据id查询用户
     *
     * @return
     */
    @Select("select * from users where id =#{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles", column = "id", javaType = java.util.List.class, many = @Many(select = "com.hqgml.dao.rolesDao.findUsersByUid"))
    })
    UserInfo findById(String id);

    /**
     * 根据id查询不属于他的角色
     *
     * @param id
     * @return
     */
    @Select("select *from  role where id not in (select roleId from users_role where userId = #{userId}) ")
    List<Role> findOtherRole(String id);

    /**
     * '
     * 给用户添加角色
     *
     * @param userId
     * @param roleId
     */
    @Insert("insert into users_role(userId,roleId) values (#{userId},#{roleId}) ")
    void addRoleToUser(@Param("userId") String userId, @Param("roleId") String roleId);
}
