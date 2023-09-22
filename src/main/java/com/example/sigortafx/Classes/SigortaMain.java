package com.example.sigortafx.Classes;

import com.example.sigortafx.Abstarcts.Person;
import com.example.sigortafx.Abstarcts.Sigorta;
import com.example.sigortafx.Classes.Customer.Customers;
import com.example.sigortafx.Classes.Manager.Managers;
import com.example.sigortafx.Classes.Sigortas.DaskSigorta;
import com.example.sigortafx.Classes.Sigortas.TrafikSigorta;
import com.example.sigortafx.Exceptions.*;
import com.example.sigortafx.FileData.SigortaDataFile;
import com.example.sigortafx.FileData.UserDataFile;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SigortaMain {
    private static final SigortaMain instance = new SigortaMain();
    private ObservableList<Person> persons;
    private ObservableList<Sigorta> sigortas;
    private Person person;

    public SigortaMain()
    {
        this.persons = FXCollections.observableArrayList();
        this.sigortas = FXCollections.observableArrayList();
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public static SigortaMain getInstance() {
        return instance;
    }

    public ObservableList<Person> getPersons() {
        return persons;
    }

    public ObservableList<Sigorta> getSigortas() {
        return sigortas;
    }


    // Data Methods

    public void writeToUsersToFile()
    {
        UserDataFile.getInstance().writeUserDatasToFile(persons);
    }
    public void readUsersFromFile()
    {
        UserDataFile.getInstance().readUsersFromFile();
    }
    public void writeSigortasToFile()
    {
        SigortaDataFile.getInstance().writeSigortasToData(sigortas);
    }
    public void readSigortasFromFile()
    {
        SigortaDataFile.getInstance().readSigortasFromFile();
    }

    // Data Methods end

    public void sigortaBasvurDask(Customers person, Sigorta sigorta, String address, boolean isDayanikli) throws YouHaveAlreadyRegisterException, SigortaDontFoundException
    {
        if(!getSigortas().contains(sigorta))
        {
            throw new SigortaDontFoundException();
        }
        Optional<Sigorta> sigorta1 = person.getSigortas().stream().filter(e -> e.getName().equals(sigorta.getName())).findFirst();
        if(sigorta1.isPresent())
        {
            throw new YouHaveAlreadyRegisterException();
        }
        person.sigortaBasvur(sigorta);
        person.setAdress(address);
        person.setDayanikli(isDayanikli);

    }
    public void sigortaBasvurTrafik(Customers person, Sigorta sigorta, String plate, boolean isBiggerThan13) throws YouHaveAlreadyRegisterException, SigortaDontFoundException
    {
        if(!getSigortas().contains(sigorta))
        {
            throw new SigortaDontFoundException();
        }
        Optional<Sigorta> sigorta1 = person.getSigortas().stream().filter(e -> e.getName().equals(sigorta.getName())).findFirst();
        if(sigorta1.isPresent())
        {
            throw new YouHaveAlreadyRegisterException();
        }
        person.sigortaBasvur(sigorta);
        person.setPlateNumber(plate);
        person.setBiggerThan13(isBiggerThan13);

    }
    public void addCustomer(String name, String surname, String email, String TC)
    {
        Customers customers = new Customers(name,surname,email,TC);
    }
    public void addManager(String name, String surname, String email, String TC)
    {
        Managers customers = new Managers(name,surname,email,TC);
    }
    public void addSigorta(String name, String content, String tur)
    {
        if(tur.equals("Trafik"))
        {
            Sigorta sigorta = new TrafikSigorta(name,content);
        }else if(tur.equals("DASK"))
        {
            Sigorta sigorta1 = new DaskSigorta(name,content);
        }
    }
    public long yilHesapla(LocalDate date)
    {
        return ChronoUnit.YEARS.between(date, LocalDate.now());
    }
    public void addUser(String name, String surname, String email, String password, String repassword)
            throws AllFieldsCanNotBeNullException, EmailMustBeTypeEmailException, PasswordAndRepasswordMustBeEqualException
    {

        if(name != null && surname != null && email != null && password != null && repassword != null)
        {

            if(isValidEmail(email))
            {

                if(password.equals(repassword))
                {

                    Person person1 = new Customers(name,surname,email,password);

                }else{
                    throw new PasswordAndRepasswordMustBeEqualException();
                }
            }else{
                throw new EmailMustBeTypeEmailException();
            }

        }else{
            throw new AllFieldsCanNotBeNullException();
        }
    }
    public static boolean isValidEmail(String email) {
        // E-posta adresi için bir regex deseni oluşturun
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";

        // Deseni derleyin
        Pattern pattern = Pattern.compile(regex);

        // Deseni e-posta adresine uygulayın
        Matcher matcher = pattern.matcher(email);

        // E-posta adresi regex deseniyle eşleşirse true döndürün, aksi takdirde false döndürün
        return matcher.matches();
    }
}
