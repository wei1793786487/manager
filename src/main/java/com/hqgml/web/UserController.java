package com.hqgml.web;

import com.hqgml.domian.Role;
import com.hqgml.domian.UserInfo;
import com.hqgml.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @data 11/17/2019 4:53 PM
 **/
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService us;

    //查找所有
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() {
        ModelAndView md = new ModelAndView();
        List<UserInfo> usAll = us.findAll();
        md.addObject("userList", usAll);
        md.setViewName("user-list");
        return md;
    }

    //保存
    @RequestMapping("/save.do")
    public String savaUser(UserInfo userInfo) {
        us.saveUser(userInfo);
        return "redirect:findAll.do";
    }


    //查找单个用户
    @RequestMapping("findById.do")
    public ModelAndView findById(String id) {
        ModelAndView md = new ModelAndView();
        UserInfo userInfo = us.findById(id);
        md.setViewName("user-show");
        md.addObject("user", userInfo);
        return md;
    }

    //查询用户以及用户可以添加的角色
    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id") String id) {
        ModelAndView md = new ModelAndView();
        //1.根基用户id查询用户
        UserInfo user = us.findById(id);
        //2. 根据用于id查询可以添加的角色
        List<Role> otherroleList = us.findOtherRole(id);
        md.addObject("user", user);
        md.addObject("roleList", otherroleList);
        md.setViewName("user-role-add");
        return md;
    }

    @RequestMapping("addRoleToUser.do")
    public String addRoleToUser(@RequestParam(name = "userId") String userId, @RequestParam(name = "ids") String[] roleIds) {

        us.addRoleToUser(userId, roleIds);
        return "redirect:findAll.do";
    }

}
