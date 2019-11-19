package com.hqgml.domian;


import lombok.Data;

import java.util.List;

/**
 * @data 11/16/2019 11:43 PM
 **/
@Data
public class Role {
    private String id;
    private String roleName;
    private String roleDesc;
    private List<Permission> permissions;
    private List<UserInfo> users;

}
