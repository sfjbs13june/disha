package com.disha.app;

import com.disha.app.controller.PatientController;
import com.disha.app.model.Appointment;
import com.disha.app.model.Prescription;
import com.disha.app.repository.AppointmentRepository;
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
public class PatientControllerTest {
    @InjectMocks
    PatientController patientController;

    @Mock
    AppointmentRepository appointmentRepository;

    @Mock
    Appointment appointment;

    @BeforeEach
    void setUp() {

        appointmentRepository = Mockito.mock(AppointmentRepository.class);
    }


    @Test
    public void getAppointments() {
        List<Appointment> getMyAppointment = new ArrayList();
        Prescription prescription1 = new Prescription("P100", "A10", "Cyra D", "Anu", "Dr. Firke");
        Appointment appointmentpatient = new Appointment("A10", "Anu", "Dr.Firke", "28/5/2022", prescription1);
        getMyAppointment.add(appointmentpatient);
        when(appointmentRepository.findByPatientName(anyString())).thenReturn(getMyAppointment);
        List<Appointment> result = patientController.getMyAppointment("Anu");
        assertEquals(getMyAppointment.size(), 1);
        assertEquals(getMyAppointment.size(), 1);
        assertEquals(getMyAppointment.get(0).getAppointmentId(), result.get(0).getAppointmentId());
        assertEquals(getMyAppointment.get(0).getDate(), result.get(0).getDate());
        assertEquals(getMyAppointment.get(0).getPatientName(), result.get(0).getPatientName());
        assertEquals(getMyAppointment.get(0).getDoctorName(), result.get(0).getDoctorName());
        assertEquals(getMyAppointment.get(0).getPrescription().getDescription(), result.get(0).getPrescription().getDescription());
    }

    @Test
    public void saveAppointment() {
        Appointment savePatientAppointment=new Appointment();
        savePatientAppointment.setAppointmentId("A10");
        savePatientAppointment.setDate("28/05/2022");
        savePatientAppointment.setDoctorName("Dr. Firke");
        savePatientAppointment.setPatientName("Anu");
        when(appointmentRepository.save(any(Appointment.class))).thenReturn(savePatientAppointment);
        Appointment result = patientController.saveAppointment(appointment);
        assertEquals(savePatientAppointment.getAppointmentId(), result.getAppointmentId());
        assertEquals(savePatientAppointment.getDate(), result.getDate());
        assertEquals(savePatientAppointment.getDoctorName(), result.getDoctorName());
        assertEquals(savePatientAppointment.getPatientName(), result.getPatientName());
    }
}