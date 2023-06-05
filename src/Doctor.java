//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Date;

class Doctor extends Person {
    private String licenceNumber;
    private String specialisation;

    public Doctor(String name, String surName, Date dOB, Long mobNo, String licenceNumber, String specialisation) {
        super(name, surName, dOB, mobNo);
        this.licenceNumber = licenceNumber;
        this.specialisation = specialisation;
    }

    public String getLicenceNumber() {
        return this.licenceNumber;
    }

    public void setLicenceNumber(String medicalLicenceNumber) {
        this.licenceNumber = medicalLicenceNumber;
    }

    public String getSpecialisation() {
        return this.specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }
}
