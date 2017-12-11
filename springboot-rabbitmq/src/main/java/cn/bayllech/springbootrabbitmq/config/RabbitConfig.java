package cn.bayllech.springbootrabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author bei.qi
 * @Description
 * @Date 2017-12-11 10:18
 */
@Configuration
public class RabbitConfig {
    
    @Bean
    public Queue Queue() {
        return new Queue("hello");
    }
    
}
