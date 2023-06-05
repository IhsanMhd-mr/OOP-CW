//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Date;

public class Consultation {
    private Date date;
    private String timeSlot;
    private double cost;
    private String notes;
    private Patient patient;
    private String doctor;

    public Consultation(Date date, String timeSlot, double cost, String notes, String doctor, Patient patient) {
        this.date = date;
        this.timeSlot = timeSlot;
        this.cost = cost;
        this.notes = notes;
        this.patient = patient;
        this.doctor = doctor;
    }

    public String getDoctor() {
        return this.doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTimeSlot() {
        return this.timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public double getCost() {
        return this.cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Patient getPatient() {
        return this.patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
