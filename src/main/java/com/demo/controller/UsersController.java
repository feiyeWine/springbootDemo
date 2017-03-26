package com.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.demo.dao.UserInfoMapper;
import com.demo.model.UserInfo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by YR on 2016/7/13.
 */

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UserInfoMapper userInfoMapper;

    static Logger logger = Logger.getLogger(UsersController.class);
    /**
     * 查询所有用户信息
     * @param modelAndView
     * @return
     */
    @Secured(value = "USER")
    @RequestMapping(value="/getUsers",method = RequestMethod.GET)
    public ModelAndView getUsers(ModelAndView modelAndView){

        List<UserInfo> users = userInfoMapper.getUsers();

        modelAndView.addObject("users",users);
        modelAndView.setViewName("test");

        return modelAndView;
    }
    /**
     * 修改用户信息
     */
    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    public JSONObject updateUser(UserInfo user){
        JSONObject jsonObject = new JSONObject();
        try{
            userInfoMapper.updateByPrimaryKeySelective(user);
            jsonObject.put("user",user);
        }catch(Exception e){
            logger.error("修改用户信息错误！！！");
            jsonObject.put("user","error");
            e.printStackTrace();
        }
        return jsonObject;
    }
}
