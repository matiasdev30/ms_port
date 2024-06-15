package com.ms_email.email.exceptions;

import org.springframework.mail.MailException;

public class ErroSendEmailException extends MailException {

    public ErroSendEmailException(String msg) {
        super(msg);
    }
    
}
