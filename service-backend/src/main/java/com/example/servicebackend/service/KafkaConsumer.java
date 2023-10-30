package com.example.servicebackend.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @KafkaListener(topics = "Backend",groupId ="groupId02")
    void listener(String data){
        System.out.println("Listener recevied:"+data);
    }
}
