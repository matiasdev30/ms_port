package com.ms_user.users.controllers;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms_user.users.UsersApplication;
import com.ms_user.users.dtos.UserModelDTO;
import com.ms_user.users.models.UserModel;
import com.ms_user.users.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

    

    @Autowired
    private UserService userService;
    
    @PostMapping("/create")
    public ResponseEntity<UserModel> createUser(@RequestBody @Valid UserModelDTO userModelDTO){
        var userModel = new UserModel();                
        BeanUtils.copyProperties(userModelDTO, userModel);
        userService.save(userModel);
        UsersApplication.log.info("[ms_users] usuario salvado na base de dados");
        return ResponseEntity.status(HttpStatus.OK).body(userService.save(userModel));
    }

}
