package com.ms_user.users.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms_user.users.UsersApplication;
import com.ms_user.users.exceptions.ArgumentValidationException;
import com.ms_user.users.exceptions.ErroSaveUserException;
import com.ms_user.users.models.UserModel;
import com.ms_user.users.producer.UserProducer;
import com.ms_user.users.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserProducer userProducer;

    @Transactional
    public UserModel save(UserModel userModel) {


        if (userModel.getName() == null || userModel.getEmail() == null) {
            UsersApplication.log.error("[ms_users] erro ao salvar usuarios, campo nulo");
            throw new ErroSaveUserException();
        }
    
        userProducer.publisMessageEmail(userModel);
        UsersApplication.log.info("[ms_users] mensagem publicada na fila [rabbitmq]");

        return userRepository.save(userModel);
    }

}
