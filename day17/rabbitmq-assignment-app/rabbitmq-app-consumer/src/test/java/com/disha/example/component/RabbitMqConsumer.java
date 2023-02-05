package com.disha.example.component;

import com.disha.example.model.Patient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;



    @Component
    public class RabbitMQConsumer {

        @Bean
        public Jackson2JsonMessageConverter converter() {
            return new Jackson2JsonMessageConverter();
        }

        @RabbitListener(queues = "${rabbitmq.queue.name}")
        public void recievedHospitalMessage(Hospital hospital) {
            System.out.println("Recieved Message From RabbitMQ: " + hospital);
        }

        @RabbitListener(queues = "${rabbitmq.queue.name}")
        public void recievedPatientMessage(Patient patient) {
            System.out.println("Recieved Message From RabbitMQ: " + patient);
        }

    }
