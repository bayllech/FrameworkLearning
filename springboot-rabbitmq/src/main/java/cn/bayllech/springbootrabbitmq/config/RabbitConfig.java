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
    
    final static String queueName = "spring-boot";
    
    @Bean
    Queue queue() {
        return new Queue("spring-boot");
    }
    
   /* @Bean
    TopicExchange exchange() {
        return new TopicExchange("spring-boot-exchange");
    }
    
    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(queueName);
    }
    
    @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(queueName);
        container.setMessageListener(listenerAdapter);
        return container;
    }
    
    @Bean
    HelloReceiver receiver() {
        return new HelloReceiver();
    }
    @Bean
    MessageListenerAdapter listenerAdapter(HelloReceiver receiver) {
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }
    
    */
}
