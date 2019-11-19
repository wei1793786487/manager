package com.hqgml.domian;

import lombok.Data;

import java.util.Date;

/**
 * @data 11/18/2019 10:36 PM
 **/
@Data
public class SysLog {
    private String id;
    private Date visitTime;
    private String visitTimeStr;
    private String username;
    private String ip;
    private String url;
    private Long executionTime;
    private String method;
}
