package com.hqgml.service.impl;

import com.hqgml.dao.UserDao;
import com.hqgml.domian.Role;
import com.hqgml.domian.UserInfo;
import com.hqgml.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @data 11/17/2019 3:00 PM
 **/
@SuppressWarnings("all")
@Service("userServices")
public class UserServicesImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * 查询所有的用户
     *
     * @return
     */
    @Override
    public List<UserInfo> findAll() {
        return userDao.findAllUser();
    }

    /**
     * 保存用户
     *
     * @param userInfo
     */
    @Override
    public void saveUser(UserInfo userInfo) {
        //使用security进行加密
        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
        userDao.savaUser(userInfo);
    }

    @Override
    public UserInfo findById(String id) {
        return userDao.findById(id);
    }

    @Override
    public List<Role> findOtherRole(String id) {
        return userDao.findOtherRole(id);
    }

    @Override
    public void addRoleToUser(String userId, String[] roleIds) {
        for (String roleId : roleIds) {

            userDao.addRoleToUser(userId, roleId);
        }
    }

    /**
     * 用户登录
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserInfo userInfo = null;
        try {
            userInfo = userDao.findUser(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //security 框架提供的认证
        User user = new User(userInfo.getUsername(), userInfo.getPassword(), userInfo.getStatus() == 0 ? false : true, true, true, true, getAuthority(userInfo.getRoles()));
        return user;
    }

    //返回一个集合 集合里面装的是角色的描述
    private List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {

        List<SimpleGrantedAuthority> authorityList = new ArrayList<SimpleGrantedAuthority>();

        for (Role role : roles) {
            authorityList.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }
        return authorityList;
    }


}
