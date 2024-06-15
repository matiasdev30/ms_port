package com.ms_email.email.config;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ms_email.email.EmailApplication;


@Configuration
public class RabbitMQconfig {
    
    @Value("${broker.queue.email.name}")
    private String queue;

    @Bean
    public Queue queue(){
        return new Queue(queue, true);
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory, Jackson2JsonMessageConverter converter) {
        EmailApplication.log.info("[ms_email] convertendo objecto para fila");
        final var rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter);
        return rabbitTemplate;
    }

    @Bean
    public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
        var objectMapper = new ObjectMapper();
        return new Jackson2JsonMessageConverter(objectMapper);
    }



}
