package cn.bayllech.springbootrabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
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
    
    
    final static String message = "topic.message";
    final static String messages = "topic.messages";
    
    @Bean
    public Queue queueMessage() {
        return new Queue(RabbitConfig.message);
    }
    
    @Bean
    public Queue queueMessages() {
        return new Queue(RabbitConfig.messages);
    }
    
    @Bean
    TopicExchange exchange() {
        return new TopicExchange("exchange");
    }
    
    @Bean
    Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
    }
    
    @Bean
    Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
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
