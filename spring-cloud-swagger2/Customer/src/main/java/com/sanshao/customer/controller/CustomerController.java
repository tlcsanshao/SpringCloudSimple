package com.sanshao.customer.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Api(tags = "Customer Stage")
public class CustomerController {

    @ApiOperation("Customer Opertion -- sayHello")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "key your name",dataType = "String",required = true,paramType = "path"),
            @ApiImplicitParam(name = "age", value = "key your age",dataType = "int",required = true,paramType = "path")
    })
    @GetMapping("/sayHello/{name}/{age}")
    public String sayHello(@PathVariable("name") String name, @PathVariable("age") int age) {
        return "Hello Baby, your name is " + name + ",your age is " + age;
    }

    @ApiOperation("Customer Operation -- test")
    @GetMapping("/test")
    public String test(){
        return "test";
    }


//    paramType：表示参数放在哪个地方
//        header-->请求参数的获取：@RequestHeader(代码中接收注解)
//        query-->请求参数的获取：@RequestParam(代码中接收注解)
//        path（用于restful接口）-->请求参数的获取：@PathVariable(代码中接收注解)
//        body-->请求参数的获取：@RequestBody(代码中接收注解)

//    localhost:port/swagger-ui.html 访问
}
