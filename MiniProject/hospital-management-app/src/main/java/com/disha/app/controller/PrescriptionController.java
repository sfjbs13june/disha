package com.disha.app.controller;

import com.disha.app.model.Prescription;
import com.disha.app.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/prescription")
public class PrescriptionController {
    @Autowired
    PrescriptionRepository prescriptionRepository;
    @RequestMapping(value = "/viewprescription",method = RequestMethod.GET)
    public List<Prescription> getAllPrescription(@RequestParam("patientName") String patientName) {
        return prescriptionRepository.findByAllPatientName(patientName);
    }
        @RequestMapping(value = "/saveprescription",method = RequestMethod.POST)
        public Prescription savePrescription(@RequestBody Prescription prescription){
            prescription = prescriptionRepository.save(prescription);
            return prescription;
    }


}
