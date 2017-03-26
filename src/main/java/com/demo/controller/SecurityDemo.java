package com.demo.controller;

import com.demo.dao.UserInfoMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by YR on 2016/7/15.
 */
@RestController
@RequestMapping("/users")
public class SecurityDemo {

    static final Logger log = Logger.getLogger(SecurityDemo.class);

    @Autowired
    private UserInfoMapper userInfoMapper;

    @RequestMapping("/login")
    public ModelAndView login(ModelAndView modelAndView){
        log.info("login >>>>>>>>>");
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping("/home")
    public ModelAndView home(ModelAndView modelAndView){
        log.info("home >>>>>>>>>");
        modelAndView.setViewName("home");
        return modelAndView;
    }
}
