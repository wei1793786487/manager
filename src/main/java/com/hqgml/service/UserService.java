package com.hqgml.service;

import com.hqgml.domian.Role;
import com.hqgml.domian.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<UserInfo> findAll();

    void saveUser(UserInfo userInfo);

    UserInfo findById(String id);

    List<Role> findOtherRole(String id);

    void addRoleToUser(String userId, String[] roleIds);
}
