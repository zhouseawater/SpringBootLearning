package com.seawater;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zhouhs on 2016/12/29.
 */
@EnableAutoConfiguration
@ComponentScan
@Configuration
public class Application {

    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
    }

}
