package com.hqgml.service.impl;

import com.hqgml.dao.LogDao;
import com.hqgml.domian.SysLog;
import com.hqgml.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @data 11/19/2019 10:03 AM
 **/
@Service
public class LogServicesImpl implements LogService {
    @Autowired
    private LogDao logDao;
    @Override
    public void setLog(SysLog sysLog) {
        logDao.SetLog(sysLog);
    }

    @Override
    public List<SysLog> findAllLog() {
        SecurityContext context = SecurityContextHolder.getContext();
        User user= (User) context.getAuthentication().getPrincipal();
        String username = user.getUsername();
        return logDao.findAllLog(username);
    }


}
