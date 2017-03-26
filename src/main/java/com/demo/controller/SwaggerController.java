package com.demo.controller;

import com.demo.dao.UserInfoMapper;
import com.demo.model.UserInfo;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by YR on 2016/7/11.
 */



@RestController
@RequestMapping("/users")
public class SwaggerController {

    /**
     *  http://localhost:8080/swagger/index.html
     */
    @Autowired
    private UserInfoMapper userInfoMapper;

    @ApiOperation(value = "getUser",notes = "requires noting")
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public UserInfo getUser(@PathVariable int id){

        UserInfo user = userInfoMapper.selectByPrimaryKey(id);

        return user;
    }

    @ApiOperation(value = "insertUser",notes = "插入一个新用户")
    @RequestMapping(value = "/insertUser",method = RequestMethod.POST)
    public int insertUser(@RequestBody UserInfo user){
        System.out.println(user.getId()+"..."+user.getName()+"..."+user.getPassword());
        return userInfoMapper.insertSelective(user);
    }

}
