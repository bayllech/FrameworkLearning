package cn.bayllech.springcloudserviceribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Author bei.qi
 * @Description
 * @Date 2017-11-29 15:04
 */
@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate;
    
    public String hello(String name) {
        return restTemplate.getForObject("http://SERVICE-HI/hi?name=" + name, String.class);
    
    }
}
