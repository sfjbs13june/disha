package com.disha.example.controller;


import com.disha.example.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/rabbitmq/")
public class PatientController {
    @Autowired
    RabbitMQSender rabbitMQSender;

    @GetMapping(value = "/hospital/producer")
    public String patientProducer(@RequestParam("patid") String patid, @RequestParam("name") String name, @RequestParam("age") String age, @RequestParam("gender") String gender, @RequestParam("disease") String disease) {

        Patient pat = new Patient();
        pat.setPatId(patid);
        pat.setName(name);
        pat.setAge(age);
        pat.setGender(gender);
        pat.setDisease(disease);

        rabbitMQSender.sendPatient(pat);

        return "Message sent to the RabbitMQ  Successfully";
    }
    @PostMapping(value = "/hospital")
    public String postPatient(@RequestBody Patient patient) {

        rabbitMQSender.sendPatient(patient);

        return "Message sent to the RabbitMQ  Successfully";
    }

}
}
