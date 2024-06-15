package com.ms_user.users.producer;
// hainkyui luta na lixeira

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.ms_user.users.models.UserModel;
import com.ms_user.users.UsersApplication;
import com.ms_user.users.dtos.EmailDTO;

@Component
public class UserProducer {
    
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value(value="${broker.queue.email.name}")
    private String routingKey;


    @RabbitHandler
    public void publisMessageEmail( UserModel userModel) {
        
        var emailDto = new EmailDTO();
        

        emailDto.setId(userModel.getId());
        emailDto.setEmailTo(userModel.getEmail());
        emailDto.setSubject("Cadastro realizado com sucesso");
        emailDto.setText(userModel.getName() + ", seja bem vindo(a) ! \nAgradecemos o seu cadastro agora todos os recursos da nossa plantaforma!");
        
        UsersApplication.log.info("[ms_users] emailDTO criado");

        rabbitTemplate.convertAndSend("", routingKey, emailDto);

    }
   
}
