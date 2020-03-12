package com.sanshao.customer.FeignInterface;

import org.springframework.stereotype.Component;

@Component
public class SimpleHystrix implements SimpleInterface{
    @Override
    public String diaoyong(String name) {
        return "Productor can not supply service";
    }
}
