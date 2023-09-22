package com.example.sigortafx.Classes.Manager;

import com.example.sigortafx.Abstarcts.Person;
import com.example.sigortafx.Abstarcts.Sigorta;

public class Managers extends Person {
    public Managers(String name, String surname, String email, String TC) {
        super(name, surname, email, TC, true);
    }

    @Override
    public void sigortaBasvur(Sigorta sigorta) {

    }

    @Override
    public String bilgileriYazdir() {
        return getName() + "\t" + getSurname() + "\t" + getEmail() + "\t" + getTC() + "\t" + isManager() ;
    }
}
