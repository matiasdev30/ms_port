package com.ms_email.email.consumers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import com.ms_email.email.dtos.EmailRecordDTO;
import com.ms_email.email.serviice.EmailSenderService;

@Component
public class EmailConsumer {

    @Autowired
    private EmailSenderService emailSenderService;

    @RabbitListener(queues = "${broker.queue.email.name}")
    public void listenEmailQueue(@Payload EmailRecordDTO emailRecordDTO) {
        emailSenderService.sendEmail(emailRecordDTO);
    }

}
