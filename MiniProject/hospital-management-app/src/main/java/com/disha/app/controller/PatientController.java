package com.disha.app.controller;

import com.disha.app.model.Appointment;
import com.disha.app.model.Prescription;
import com.disha.app.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    AppointmentRepository appointmentRepository;

    @RequestMapping(value = "/myappointment", method = RequestMethod.GET)
    public List<Appointment> getMyAppointment(@RequestParam("patientName") String patientName) {
        return appointmentRepository.findByPatientName(patientName);

    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)

    public Appointment saveAppointment(@RequestBody Appointment appointment) {
        appointment = appointmentRepository.save(appointment);
        return appointment;

    }

}