package com.disha.app;

import com.disha.app.controller.DoctorController;
import com.disha.app.model.Appointment;
import com.disha.app.model.Prescription;
import com.disha.app.repository.AppointmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer1;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DoctorControllerTest {

    @InjectMocks
    DoctorController doctorController;


    @Mock
    AppointmentRepository appointmentRepository;

    @Mock
    Appointment appointment;

    @BeforeEach
    void setUp() {
        appointmentRepository = Mockito.mock(AppointmentRepository.class);
        appointment = Mockito.mock(Appointment.class);
    }



    @Test
    public void getAppointmentsTest(){
        List<Appointment> getAppointment = new ArrayList();
        Appointment appointment1 = new Appointment();

        Prescription prescription1 = new Prescription("P10","A10","Cyra D","Rani","dr Firke");
        appointment1.setAppointmentId("A10");
        appointment1.setDate("10/09/2022");
        appointment1.setPatientName("Rani");
        appointment1.setDoctorName("Dr. Firke");
        appointment1.setPrescription(prescription1);
        getAppointment.add(appointment1);

        when(appointmentRepository.findBydoctorName(anyString())).thenReturn(getAppointment);
        List<Appointment> result = doctorController.getAppointments("Dr. Firke");
       // List<Appointment> result = doctorController.getAppointments("Dr. Firke");
        assertEquals(getAppointment.size(), 1);
        assertEquals(getAppointment.get(0).getAppointmentId(),result.get(0).getAppointmentId());
        assertEquals(getAppointment.get(0).getDate(),result.get(0).getDate());
        assertEquals(getAppointment.get(0).getPatientName(),result.get(0).getPatientName());
        assertEquals(getAppointment.get(0).getDoctorName(),result.get(0).getDoctorName());
        assertEquals(getAppointment.get(0).getPrescription().getDescription(),result.get(0).getPrescription().getDescription());

    }

    @Test
    public void saveAppointment(){
        Appointment saveAppointment=new Appointment();
        saveAppointment.setAppointmentId("A20");
        saveAppointment.setDate("11/09/2022");
        saveAppointment.setDoctorName("Dr. Firke");
        saveAppointment.setPatientName("Kavya");
        when(appointmentRepository.save(any(Appointment.class))).thenReturn(saveAppointment);
        Appointment result = doctorController.saveAppointment(appointment);
        assertEquals(saveAppointment.getAppointmentId(), result.getAppointmentId());
        assertEquals(saveAppointment.getDate(), result.getDate());
        assertEquals(saveAppointment.getDoctorName(), result.getDoctorName());
        assertEquals(saveAppointment.getPrescription(), result.getPatientName());
    }


}
