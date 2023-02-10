package com.disha.app;

import com.disha.app.controller.PatientController;
import com.disha.app.controller.PrescriptionController;
import com.disha.app.model.Appointment;
import com.disha.app.model.Prescription;
import com.disha.app.repository.AppointmentRepository;
import com.disha.app.repository.PrescriptionRepository;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PrescriptionControllerTest {
    @InjectMocks
    PrescriptionController prescriptionController;
    ;

    @Mock
    PrescriptionRepository prescriptionRepository;

    @Mock
    Prescription prescription;

    @BeforeEach
    void setUp() {
        prescription = Mockito.mock(Prescription.class);
        prescriptionRepository = Mockito.mock(PrescriptionRepository.class);
    }

    @Test
    public void getAllPrescriptions() {
        List<Prescription> viewprescription = new ArrayList();
        Prescription prescription2 = new Prescription("P108", "A41", "Cofsils", "Radha", "Dr. Firke");
        viewprescription.add(prescription2);
        when(prescriptionRepository.findByAllPatientName(anyString())).thenReturn(viewprescription);
        List<Prescription> result = prescriptionController.getAllPrescription("Radha");
        assertEquals(viewprescription.size(), 1);
        assertEquals(viewprescription.get(0).getPrescriptionId(), result.get(0).getPrescriptionId());
        assertEquals(viewprescription.get(0).getAppointmentId(), result.get(0).getAppointmentId());
        assertEquals(viewprescription.get(0).getDescription(), result.get(0).getDescription());
        assertEquals(viewprescription.get(0).getPatientName(), result.get(0).getPatientName());
        assertEquals(viewprescription.get(0).getDoctorName(), result.get(0).getDoctorName());

    }

    @Test
    public void savePrescription() {
        Prescription saveprescription = new Prescription();
        saveprescription.setAppointmentId("A41");
        saveprescription.setPrescriptionId("P108");
        saveprescription.setDescription("This medicine is for cough");
        saveprescription.setDoctorName("Dr.Firke");
        saveprescription.setPatientName("Radha");
        when(prescriptionRepository.save(any(Prescription.class))).thenReturn(saveprescription);
        Prescription result = prescriptionController.savePrescription(prescription);
        assertEquals(saveprescription.getPrescriptionId(), result.getPrescriptionId());
        assertEquals(saveprescription.getAppointmentId(), result.getAppointmentId());
        assertEquals(saveprescription.getDescription(), result.getDescription());
        assertEquals(saveprescription.getDoctorName(), result.getDoctorName());
        assertEquals(saveprescription.getPatientName(), result.getPatientName());


    }
}