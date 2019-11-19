package com.hqgml.web;

import com.hqgml.domian.Permission;
import com.hqgml.domian.Role;
import com.hqgml.service.RoleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import sun.security.provider.MD2;

import java.util.List;

/**
 * @data 11/17/2019 9:48 PM
 **/

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    RoleServices rs;

    @RequestMapping("/findAll.do")
    public ModelAndView finfAll() {
        List<Role> roles = rs.findAll();
        ModelAndView md = new ModelAndView();
        md.setViewName("role-list");
        md.addObject("roleList", roles);
        return md;
    }


    @RequestMapping("/save.do")
    public String addRole(Role role) {
        rs.addRole(role);
        return "redirect:findAll.do";
    }

    //根据roleid查询出role
    @RequestMapping("/findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndAllPermission(@RequestParam(value = "id") String RoleId) {
        ModelAndView md = new ModelAndView();
        //根基roleid查询role
        Role role = rs.findById(RoleId);
        //查询所有不属于这个用户的权限
        List<Permission> OtherPermissions = rs.OtherPermission(RoleId);
        md.addObject("role", role);
        md.addObject("permissionList", OtherPermissions);
        md.setViewName("role-permission-add");
        return md;
    }

    @RequestMapping("/addPermissionToRole.do")

    public String AddPermissionToRole(@RequestParam(value = "roleId") String roleId, @RequestParam(value = "ids") String[] perId) {

        rs.addPermissionTorole(roleId,perId);
        return "redirect:findAll.do";
    }


}
