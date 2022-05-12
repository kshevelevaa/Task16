package com.example.demo.Model;

import jdk.jfr.DataAmount;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table
@Data
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String firstName;
    private String lastName;
    private int position;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "doctor", fetch = FetchType.LAZY)
    private final List<Patient> patientSet = new ArrayList<>();

    public Doctor() {
    }

    public Doctor(String firstName, String lastName, int position) {
        this.position = position;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public List<Patient> getPatientSet() {
        return patientSet;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position=" + position +
                "}\n";
    }
}
