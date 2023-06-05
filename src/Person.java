//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.Serializable;
import java.util.Date;

public class Person implements Serializable {
    String name;
    String surName;
    Date dOB;
    Long mobNo;

    public Person(String name, String surName, Date dOB, Long mobNo) {
        this.name = name;
        this.surName = surName;
        this.dOB = dOB;
        this.mobNo = mobNo;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return this.surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public Date getDOB() {
        return this.dOB;
    }

    public void setDOB(Date dOB) {
        this.dOB = dOB;
    }

    public Long getMobNo() {
        return this.mobNo;
    }

    public void setMobNo(Long mobNo) {
        this.mobNo = mobNo;
    }
}
