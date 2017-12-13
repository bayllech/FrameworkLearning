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
public class RabbitSend {
    
    @Autowired
    private RabbitTemplate rabbitTemplate;
    
    public void send() {
        String context = "hello " + new Date();
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("spring-boot",context);
    }
    
    public void send(Integer i) {
        String context = "spring boot 发送 queue ******" + i;
        System.out.println("Sender 1 : " + context);
        this.rabbitTemplate.convertAndSend("spring-boot",context);
    }
    
    //exchange 发送队列
    public void send1() {
        String context = "hi, 这是 message 1";
        System.out.println("Sender 1 : " + context);
        this.rabbitTemplate.convertAndSend("exchange", "topic.message", context);
    }
    
    public void send2() {
        String context = "hi, 这是 messages 2";
        System.out.println("Sender 2 : " + context);
        this.rabbitTemplate.convertAndSend("exchange", "topic.messages", context);
    }
    
    public void sendFanout() {
        String context = "hi, fanout msg ";
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("fanoutExchange","无论什么都会被忽略", context);
    }
    
}
