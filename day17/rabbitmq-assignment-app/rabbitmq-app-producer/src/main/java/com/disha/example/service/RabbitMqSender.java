package com.disha.example.service;


import com.disha.example.model.Hospital;
import com.disha.example.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routingkey.name}")
    private String routingkey;

    public void sendHospital(Hospital hospital) {
        rabbitTemplate.convertAndSend(exchange, routingkey, hospital);
        System.out.println("Send msg = " + hospital);
    }

    public void sendPatient(Patient patient) {
        rabbitTemplate.convertAndSend(exchange, routingkey, patient);
        System.out.println("Send msg = " + patient);
    }
}
}
