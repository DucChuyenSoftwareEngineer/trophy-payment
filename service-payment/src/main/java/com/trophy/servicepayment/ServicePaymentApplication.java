package com.trophy.servicepayment;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class ServicePaymentApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServicePaymentApplication.class, args);
        System.out.println("Service Payment");
    }

//    @Bean
//    CommandLineRunner commandLineRunner(KafkaTemplate<String,String> kafkaTemplate){
//        return args -> {
//            for (int i=0; i<10000;i++){
//                kafkaTemplate.send("Backend","data customer and history");
//            }
//
//        };
//    }

}
