package cn.bayllech.springbootrabbitmq.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author bei.qi
 * @Description
 * @Date 2017-12-11 10:29
 */
@Component
@RabbitListener(queues = "hello")
public class HelloReceiver {
    
    @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver  : " + hello);
    }
    
}
