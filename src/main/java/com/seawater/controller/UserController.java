package com.seawater.controller;

import com.seawater.dao.UserDao;
import com.seawater.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by zhouhs on 2016/12/30.
 */
@RestController
@RequestMapping(value = "/user")
@Api(description = "用户")
public class UserController {

    @Resource
    UserDao userDAO;


    @ApiOperation(value = "添加用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name" , value = "name" , paramType = "query" , required = true ),
            @ApiImplicitParam(name = "age" , value = "age" , paramType = "query" , required = true )
    })
    @RequestMapping(value = "/addUser" , method = RequestMethod.POST)
    public String addUser(@RequestParam(value = "name") String name,@RequestParam(value = "age") int age){

        User user = new User();
        user.setName(name);
        user.setAge(age);

        userDAO.save(user);

        return "add user success !";
    }


    @ApiOperation(value = "查找用户")
    @ApiImplicitParam(name = "id" , value = "id" , paramType = "query" , required = true , dataType = "int")
    @RequestMapping(value = "/findById" , method = RequestMethod.POST)
    public String findById(@RequestParam(value = "id") Long id){

        User user = userDAO.findById(id);

        if(user == null){
            return "error";
        }else{
            return "name:" + user.getName() + " , age:" + user.getAge();
        }
    }


    @ApiOperation(value = "查询所有用户")
    @RequestMapping(value = "/findAll" , method = RequestMethod.POST)
    public Iterable findAll(){

        Iterable<User> userList = userDAO.findAll();

        return userList;

    }

    @ApiOperation(value = "删除用户")
    @ApiImplicitParam(name = "id" , value = "id" , paramType = "query" , required = true , dataType = "int")
    @RequestMapping(value = "/deleteById" , method = RequestMethod.POST)
    public String deleteById(@RequestParam(value = "id") Long id){

        userDAO.delete(id);
        return "delete success !";

    }



}
