package com.hqgml.web;

import com.hqgml.domian.Permission;
import com.hqgml.service.PermissionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

/**
 * @data 11/17/2019 10:23 PM
 **/
@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    PermissionServices ps;

    @RequestMapping("/findAll.do")
    @RolesAllowed("ADMIN")
    public ModelAndView findAll() {
        ModelAndView md = new ModelAndView();
        List<Permission> plist = ps.findAll();
        md.addObject("permissionList", plist);
        md.setViewName("permission-list");
        return md;
    }


    @RequestMapping("save.do")
    public String addPer(Permission permission) {

        ps.addPer(permission);
        return "redirect:findAll.do";
    }


}
