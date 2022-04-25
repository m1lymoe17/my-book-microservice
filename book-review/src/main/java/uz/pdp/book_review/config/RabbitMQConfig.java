package uz.pdp.book_review.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${spring.rabbitmq.host}")
    String host;

    @Value("${spring.rabbitmq.username}")
    String username;

    @Value("${spring.rabbitmq.password}")
    String password;

    @Value("${spring.rabbitmq.queue}")
    String queue;

    @Value("${spring.rabbitmq.exchange}")
    String exchange;

    @Value("${spring.rabbitmq.routing-key}")
    String routingKey;

    @Bean
    public CachingConnectionFactory factory() {
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory();
        cachingConnectionFactory.setHost(host);
        cachingConnectionFactory.setUsername(username);
        cachingConnectionFactory.setPassword(password);
        return cachingConnectionFactory;
    }

    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public Queue queue(){
        return new Queue(queue,true);
    }

    @Bean
    public Exchange getExchange(){
        return ExchangeBuilder.directExchange(exchange).build();
    }

    @Bean
    public Binding binding(){
        return BindingBuilder.bind(queue()).to(getExchange()).with(routingKey).noargs();
    }
}