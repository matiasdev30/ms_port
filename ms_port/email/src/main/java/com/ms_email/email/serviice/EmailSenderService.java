package com.ms_email.email.serviice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ms_email.email.EmailApplication;
import com.ms_email.email.dtos.EmailRecordDTO;

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;

    @Transactional
    public void sendEmail(EmailRecordDTO emailRecordDTO) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setFrom(sender);
        mailMessage.setTo(emailRecordDTO.emailTo());
        mailMessage.setText(emailRecordDTO.text());
        mailMessage.setSubject(emailRecordDTO.subject());

        try {
            javaMailSender.send(mailMessage);
            EmailApplication.log.info("[ms_email] email enviado com sucesso");
        } catch (MailException e) {
            EmailApplication.log.error("[ms_email] erro ao enviar email " + e.toString());
        }

    }

}
