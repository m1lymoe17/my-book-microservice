package uz.pdp.consumer_service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ConsumerService {


    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void ReceiverMessages(String name) {
        //............
        System.out.println(LocalDateTime.now() + " - Hi my name is " + name);
        //............
    }
}
