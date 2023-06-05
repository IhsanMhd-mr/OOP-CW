//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Date;

class Patient extends Person {
    String patientId;

    public Patient(String name, String surName, Date dOB, Long mobNo, String patientId) {
        super(name, surName, dOB, mobNo);
        this.patientId = patientId;
    }

    public String getPatientId() {
        return this.patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }
}
