package com.example.sigortafx.Abstarcts;

import com.example.sigortafx.Classes.SigortaMain;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.UUID;

public abstract class Person {
    private UUID ID;
    private String name;
    private String surname;
    private String email;
    private String TC;
    private boolean isManager;
    private ObservableList<Sigorta> sigortas;
    private String phoneNumber;
    private boolean isDayanikli;
    private boolean isBiggerThan13;
    private String adress;
    private String plateNumber;
    private double teklifDask;
    private double teklifTrafik;
    public Person(String name, String surname, String email, String TC, boolean isManager)
    {
        this.ID = UUID.randomUUID();
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.TC = TC;
        this.isManager = isManager;
        this.sigortas = FXCollections.observableArrayList();
        SigortaMain.getInstance().getPersons().add(this);
    }

    public double getTeklifDask() {
        return teklifDask;
    }

    public void setTeklifDask(double teklifDask) {
        this.teklifDask = teklifDask;
    }

    public double getTeklifTrafik() {
        return teklifTrafik;
    }

    public void setTeklifTrafik(double teklifTrafik) {
        this.teklifTrafik = teklifTrafik;
    }

    public void setSigortas(ObservableList<Sigorta> sigortas) {
        this.sigortas = sigortas;
    }

    public boolean isBiggerThan13() {
        return isBiggerThan13;
    }

    public void setBiggerThan13(boolean biggerThan13) {
        isBiggerThan13 = biggerThan13;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isDayanikli() {
        return isDayanikli;
    }

    public void setDayanikli(boolean dayanikli) {
        isDayanikli = dayanikli;
    }

    public ObservableList<Sigorta> getSigortas() {
        return sigortas;
    }

    public boolean isManager() {
        return isManager;
    }

    public void setManager(boolean manager) {
        isManager = manager;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTC() {
        return TC;
    }

    public void setTC(String TC) {
        this.TC = TC;
    }
    public abstract void sigortaBasvur(Sigorta sigorta);

    public abstract String bilgileriYazdir();

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", TC='" + TC + '\'' +
                ", isManager=" + isManager +
                '}';
    }
}
