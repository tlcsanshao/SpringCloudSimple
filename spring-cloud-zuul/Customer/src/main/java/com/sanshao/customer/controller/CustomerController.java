package com.sanshao.customer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {


    @GetMapping("/test")
    public String testSayHello(){
        return "三少";
    }


}
