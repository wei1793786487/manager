package com.hqgml.service.impl;

import com.hqgml.dao.LogDao;
import com.hqgml.domian.SysLog;
import com.hqgml.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
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

        return logDao.findAllLog();
    }


}
