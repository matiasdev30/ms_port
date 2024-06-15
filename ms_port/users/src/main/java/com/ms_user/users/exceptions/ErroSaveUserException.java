package com.ms_user.users.exceptions;

public class ErroSaveUserException extends RuntimeException {
    
    public ErroSaveUserException(String msg){
        super(msg);
    }

    public ErroSaveUserException(){
        super("Erro ao salvar usuario");
    }

}
