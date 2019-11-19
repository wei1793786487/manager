package com.hqgml.web;

import cn.hutool.core.date.DateUtil;
import com.hqgml.domian.SysLog;
import com.sun.net.httpserver.HttpsServer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @data 11/18/2019 11:35 PM
 **/

//方法名	功能
//        Signature getSignature();	获取封装了署名信息的对象,在该对象中可以获取到目标方法名,所属类的Class等信息
//        Object[] getArgs();	获取传入目标方法的参数对象
//        Object getTarget();	获取被代理的对象
//        Object getThis();	获取代理对象
@Component
@Aspect
public class LogAop {

    private Date startTime;//开始的时间
    private Class clazz;//访问的类
    private Method method;//访问的方法
    private String ip;
    private String username;

    @Autowired
    private HttpServletRequest request;

    //前置通知 获取开始时间 执行的类是哪个 执行的是哪个方法
    @Before("execution(* com.hqgml.web.*.*(..))")
    public void before(JoinPoint jp) throws NoSuchMethodException {
        startTime = new Date();//获取当前时间
        clazz = jp.getTarget().getClass(); //获取访问的类
        String name = jp.getSignature().getName();//获取访问的方法的名字
        Object[] args = jp.getArgs();//获取方法的参数
        if (args == null || args.length == 0) {
            method = clazz.getMethod(name);
        } else {
            Class[] classes = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                classes[i] = args[i].getClass();
            }
            method = clazz.getMethod(name, classes);
        }
    }

    @After("execution(* com.hqgml.web.*.*(..))")
    public void after(JoinPoint jp) {

        long time = new Date().getTime() - startTime.getTime();//获取访问时间
        String url = "";
        //获取url通过反射

        if (clazz != null || method != null || clazz != LogAop.class) {
            RequestMapping clazzAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);//获取类上面0的url
            if (clazzAnnotation != null) {
                String[] classvalue = clazzAnnotation.value();

                RequestMapping methodannotation = method.getAnnotation(RequestMapping.class);//获取方法上面的url
                if (methodannotation != null) {
                    String[] method = methodannotation.value();
                    url = classvalue[0] + method[0];
                }
            }
        }

        //获取ip
        ip = request.getRemoteAddr();

        //获取用户
        SecurityContext context = SecurityContextHolder.getContext();//通过上下文获取当前操作的用户
        User user = (User) context.getAuthentication().getPrincipal();
        username = user.getUsername();

        //封装
        SysLog sysLog = new SysLog();
        sysLog.setIp(ip);
        sysLog.setExecutionTime(time);
        sysLog.setMethod("[类名]" + clazz.getName() + "[方法名]" + method.getName());
        sysLog.setUrl(url);
        sysLog.setUsername(username);
        String format = DateUtil.formatDateTime(startTime);
        sysLog.setVisitTimeStr(format);

    }
}

















