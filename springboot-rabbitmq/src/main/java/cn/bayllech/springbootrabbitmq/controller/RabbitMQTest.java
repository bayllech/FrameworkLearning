package cn.bayllech.springbootrabbitmq.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Author bei.qi
 * @Description
 * @Date 2017-12-11 15:44
 */
@RestController
public class RabbitMQTest {
    
    @Autowired
    RabbitTemplate rabbitTemplate;
    
    @RequestMapping("/rabbit")
    public void test(){
        String context = "hello " + new Date();
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("spring-boot",context);
    }
    
}
