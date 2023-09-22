package com.example.sigortafx.FileData;

import com.example.sigortafx.Abstarcts.Person;
import com.example.sigortafx.Abstarcts.Sigorta;
import com.example.sigortafx.Classes.Customer.Customers;
import com.example.sigortafx.Classes.Manager.Managers;
import com.example.sigortafx.Classes.SigortaMain;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.Iterator;
import java.util.Optional;
import java.util.stream.Stream;

public class UserDataFile {
    private static final UserDataFile instance = new UserDataFile();

    public static UserDataFile getInstance() {
        return instance;
    }

    // Write to file

    public void writeUserDatasToFile(ObservableList<Person> persons)
    {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("Users.txt")))
        {

            Iterator<Person> personIterator = persons.iterator();
            while (personIterator.hasNext())
            {
                Person person = personIterator.next();
                writer.write(person.bilgileriYazdir());
                writer.newLine();
            }

        }catch (Exception e)
        {
            System.out.println("Hata: " + e);
        }
    }

    // Write to file finish

    // Read from File

    public void readUsersFromFile()
    {
        try(BufferedReader reader = new BufferedReader(new FileReader("Users.txt")))
        {

            String Line = "";
            while ((Line = reader.readLine()) != null)
            {
                String []lineSplit = Line.split("\t");
                String name = lineSplit[0];
                String surname = lineSplit[1];
                String email = lineSplit[2];
                String TC = lineSplit[3];
                String plateNumber = lineSplit[4];
                String address = lineSplit[5];
                String phoneNumer = lineSplit[6];
                boolean isDayanikli = Boolean.parseBoolean(lineSplit[7]);
                boolean isBiggerThan13= Boolean.parseBoolean(lineSplit[8]);
                double teklifDask = Double.parseDouble(lineSplit[9]);
                double teklifTrafik = Double.parseDouble(lineSplit[10]);
                boolean isManager = Boolean.parseBoolean(lineSplit[11]);
                if(isManager)
                {
                    Person managers = new Managers(name,surname,email,TC);
                }else{
                    Person customers = new Customers(name,surname,email,TC);
                    customers.setAdress(address);
                    customers.setPlateNumber(plateNumber);
                    customers.setPhoneNumber(phoneNumer);
                    customers.setDayanikli(isDayanikli);
                    customers.setTeklifDask(teklifDask);
                    customers.setTeklifTrafik(teklifTrafik);
                    if(lineSplit.length>12)
                    {
                        for(int i = 12; i<lineSplit.length; i++)
                        {
                            int finalI = i;
                            Optional<Sigorta> sigorta = SigortaMain.getInstance().getSigortas().stream().filter(e->e.getName().equals(lineSplit[finalI])).findFirst();
                            if(sigorta.isPresent())
                            {
                                Sigorta sigorta1 = sigorta.get();
                                customers.getSigortas().add(sigorta1);
                            }
                        }

                    }
                }
            }

        }catch (IOException e)
        {
            System.out.println("Erro : " + e);
        }
    }

    // Read from File finish
}
