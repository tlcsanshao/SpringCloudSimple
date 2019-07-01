package com.sanshao.customer.controller;

import com.sanshao.customer.FeignInterface.SimpleInterface;
import com.sanshao.customer.config.JdbcConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.quartz.QuartzProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    JdbcConfigBean jdbcConfigBean;

    @Autowired
    SimpleInterface simpleInterface;

    @GetMapping("/test")
    public String testSayHello(){
        return simpleInterface.diaoyong("三少");
    }

    @GetMapping("/config")
    public String testGetConfig(){
        System.out.println("get config");
        return jdbcConfigBean.toString();
    }



}
