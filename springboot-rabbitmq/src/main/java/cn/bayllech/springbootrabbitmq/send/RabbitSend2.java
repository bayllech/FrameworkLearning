package cn.bayllech.springbootrabbitmq.send;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author bei.qi
 * @Description
 * @Date 2017-12-11 10:26
 */
@Component
public class RabbitSend2 {
    
    @Autowired
    private RabbitTemplate rabbitTemplate;
    
    public void send() {
        String context = "hello " + new Date();
        System.out.println("Sender 2 : " + context);
        this.rabbitTemplate.convertAndSend("spring-boot",context);
    }
    
    public void send(Integer i) {
        String context = "spring boot 发送 queue ******" + i;
        System.out.println("Sender 2 : " + context);
        this.rabbitTemplate.convertAndSend("spring-boot",context);
    }
}
