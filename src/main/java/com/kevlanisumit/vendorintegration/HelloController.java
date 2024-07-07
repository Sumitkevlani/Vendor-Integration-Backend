package com.kevlanisumit.vendorintegration;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String sayHello(){
        return "Hello World";
    }
    
    
}
