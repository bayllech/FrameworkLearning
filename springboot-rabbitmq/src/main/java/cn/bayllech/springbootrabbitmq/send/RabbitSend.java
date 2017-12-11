package cn.bayllech.springbootrabbitmq.send;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @Author bei.qi
 * @Description
 * @Date 2017-12-11 10:26
 */
public class RabbitSend {
    
    @Autowired
    private RabbitTemplate rabbitTemplate;
    
    public void send() {
        String context = "hello " + new Date();
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("hello",context);
    }
}
