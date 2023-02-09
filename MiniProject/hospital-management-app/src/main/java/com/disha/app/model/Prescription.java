package com.disha.app.model;

public class Prescription {
    String appointmentId;
    String description;
    String patientName;
    String doctorName;

    public Prescription() {
    }

    public Prescription(String prescriptionId, String appointmentId, String description, String patientName, String doctorName) {
        this.prescriptionId = prescriptionId;
        this.appointmentId = appointmentId;
        this.description = description;
        this.patientName = patientName;
        this.doctorName = doctorName;
    }

    public String getPrescriptionId() {
        return prescriptionId;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public String getDescription() {
        return description;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    String prescriptionId;

    public void setPrescriptionId(String prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }


}
