package com.hqgml.web;

import com.hqgml.domian.SysLog;
import com.hqgml.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @data 11/19/2019 10:19 AM
 **/
@Controller
@RequestMapping("/sysLog")
public class LogController {
    @Autowired
    private LogService logService;


    public ModelAndView findAllLog() {

        ModelAndView md = new ModelAndView();

        List<SysLog> logs = logService.findAllLog();
        md.addObject("sysLogs", logs);
        md.setViewName("syslog-list.jsp");
        return md;

    }

}
