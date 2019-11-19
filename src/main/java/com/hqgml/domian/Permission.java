package com.hqgml.domian;

import lombok.Data;

import java.util.List;

/**
 * @data 11/16/2019 11:48 PM
 **/
@Data
public class Permission {
    private String id;
    private String permissionName;
    private String url;
    private List<Role> roles;
}
