package com.ms_user.users.exceptions;

public class ArgumentValidationException extends RuntimeException{
    
    public ArgumentValidationException(String msg){
        super(msg);
    }

    public ArgumentValidationException(){
        super("Erro de validação de argumentos");
    }

}
