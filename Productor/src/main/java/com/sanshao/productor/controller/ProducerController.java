package com.sanshao.productor.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    @Value("${server.port}")
    private int port;
    
    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "name") String name){
        String s = port+" productor say hello to " + name;
        return s;
    }
    
}
