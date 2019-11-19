package com.hqgml.dao;

import com.hqgml.domian.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;

@Controller
public interface LogDao {

    @Insert("insert into syslog(visitTime,username,ip,url,executionTime,method) values(#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    public void SetLog(SysLog sysLog);

    @Select("select * from sysLog  where username= #{username}")
    List<SysLog> findAllLog(String username);
}
