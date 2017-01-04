package com.seawater.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhouhs on 2016/12/29.
 */
@RestController
@RequestMapping("/sea")
@Api(description = "sea")
public class HelloWorldController{

    @RequestMapping(value = "/{name}",method = RequestMethod.GET)
    public String Hello(@PathVariable("name") String name){
        return "Hello  , "+ name;
    }



}
