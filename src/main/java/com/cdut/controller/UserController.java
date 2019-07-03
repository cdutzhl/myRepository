package com.cdut.controller;

import com.cdut.model.User;
import com.cdut.service.IUserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private IUserService userService;
    @ApiOperation(value = "获取所有的用户信息",notes = "查询所有的用户信息")
    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public List<User> getAllUser(){
        logger.debug("查询所有的用户信息：");
        return userService.getAll();
    }
    @ApiOperation(value = "根据id查询用户",notes = "根据id查询用户")
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public User getUserById(int id){
        int t = 1/0;
       return userService.getUserById(id);
    }


}
