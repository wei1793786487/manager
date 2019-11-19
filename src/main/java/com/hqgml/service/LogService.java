package com.hqgml.service;

import com.hqgml.domian.SysLog;

import java.util.List;

public interface LogService {

    public void  setLog(SysLog sysLog);

    List<SysLog> findAllLog();

}
