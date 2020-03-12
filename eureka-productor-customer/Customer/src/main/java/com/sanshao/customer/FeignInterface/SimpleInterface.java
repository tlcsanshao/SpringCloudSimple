package com.sanshao.customer.FeignInterface;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "productor",fallback = SimpleHystrix.class)
public interface SimpleInterface {

    //这里会调用到productor中sayHello方法，通过类上方的模块名称+方法中URL+方法中的参数定位
    //实际开发中两边的方法名称最好保持一致。这里只为了演示。
    @GetMapping("/hello")
    public String diaoyong(@RequestParam(value = "name") String name);


}
