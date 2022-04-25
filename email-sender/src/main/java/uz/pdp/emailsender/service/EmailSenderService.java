package uz.pdp.emailsender.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.clients.user.User;
import uz.pdp.clients.user.UserClient;
import uz.pdp.emailsender.dto.BookReview;

import java.time.LocalDateTime;

@Service
public class EmailSenderService {

//    @Autowired
//    JavaMailSender mailSender;

//    @Autowired
//    UserClient userClient;

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void ReceiverMessages(BookReview bookReview) {
        //............
        System.out.println(LocalDateTime.now() + " - Hi My Name Is " + bookReview.getUserId());
        //............
    }
}