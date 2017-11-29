package cn.bayllech.springcloudserviceribbon.controller;

import cn.bayllech.springcloudserviceribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author bei.qi
 * @Description
 * @Date 2017-11-29 15:07
 */
@RestController
public class HelloController {
    @Autowired
    HelloService helloService;
    
    @RequestMapping("/hello")
    public String hello(String name) {
        return helloService.hello(name);
    }
}
