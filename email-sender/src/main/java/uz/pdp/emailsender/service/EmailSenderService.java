package uz.pdp.emailsender.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import uz.pdp.emailsender.dto.Something;

import java.time.LocalDateTime;

@Service
public class EmailSenderService {


    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void ReceiverMessages(Something something) {
        //............
        System.out.println(LocalDateTime.now() + " - Hi My Name Is " + something);
        //............
    }
}