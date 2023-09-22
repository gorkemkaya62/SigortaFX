package com.example.sigortafx.Classes.Customer;

import com.example.sigortafx.Abstarcts.Person;
import com.example.sigortafx.Abstarcts.Sigorta;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Customers extends Person {


    public Customers(String name, String surname, String email, String TC) {
        super(name, surname, email, TC, false);
    }

    // Methods
    @Override
    public void sigortaBasvur(Sigorta sigorta)
    {
        getSigortas().add(sigorta);
    }

    public String arrayListToString()
    {
        String line = "";
        int i = 0;
        for (Sigorta now : getSigortas())
        {
            line += "\t" + now.getName();
            i++;
        }
        return line;
    }
    @Override
    public String bilgileriYazdir() {
        return getName() + "\t" + getSurname() + "\t" + getEmail() + "\t" + getTC() + "\t" + getPlateNumber() + "\t" + getAdress() + "\t" + getPhoneNumber() + "\t" + isDayanikli() + "\t" + isBiggerThan13() + "\t" + getTeklifDask() + "\t" + getTeklifTrafik() + "\t" + isManager() +  arrayListToString();
    }

    // Methods finish
}
