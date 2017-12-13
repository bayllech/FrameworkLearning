package cn.bayllech.springbootrabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author bei.qi
 * @Description 消息广播模式配置
 * @Date 2017-12-13 9:56
 */
@Configuration
public class FanoutRabbitConfig {
    
    @Bean
    public Queue AMessage() {
        return new Queue("fanout.A");
    }
    
    @Bean
    public Queue BMessage() {
        return new Queue("fanout.B");
    }
    
    @Bean
    public Queue CMessage() {
        return new Queue("fanout.C");
    }
    
    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanoutExchange");
    }
    
    @Bean
    Binding bindingExchangeA(Queue AMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(AMessage).to(fanoutExchange);
    }
    
    @Bean
    Binding bindingExchangeB(Queue BMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(BMessage).to(fanoutExchange);
    }
    
    @Bean
    Binding bindingExchangeC(Queue CMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(CMessage).to(fanoutExchange);
    }

}
