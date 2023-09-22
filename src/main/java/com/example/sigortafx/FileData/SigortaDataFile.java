package com.example.sigortafx.FileData;

import com.example.sigortafx.Abstarcts.Sigorta;
import com.example.sigortafx.Classes.Sigortas.DaskSigorta;
import com.example.sigortafx.Classes.Sigortas.TrafikSigorta;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.Iterator;

public class SigortaDataFile {
    private static final SigortaDataFile instance = new SigortaDataFile();

    public static SigortaDataFile getInstance() {
        return instance;
    }

    // Write Data

    public void writeSigortasToData(ObservableList<Sigorta> sigortas)
    {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("Sigorta.txt")))
        {

            Iterator<Sigorta> sigortaIterator = sigortas.iterator();
            while (sigortaIterator.hasNext())
            {
                Sigorta sigorta = sigortaIterator.next();
                writer.write(sigorta.bilgileriYazdir());
                writer.newLine();
            }

        }catch (IOException e)
        {
            System.out.println("Error : " + e);
        }
    }
    public void readSigortasFromFile()
    {
        try(BufferedReader reader = new BufferedReader(new FileReader("Sigorta.txt")))
        {

            String line = "";
            while ((line = reader.readLine()) != null)
            {
                String []lineSplit = line.split("\t");
                String name = lineSplit[0];
                String content = lineSplit[1];
                String tur = lineSplit[2];
                if(tur.equals("DASK"))
                {
                    Sigorta sigorta = new DaskSigorta(name,content);
                }else if(tur.equals("Trafik"))
                {
                    Sigorta sigorta1 = new TrafikSigorta(name,content);
                }
            }

        }catch (IOException e)
        {
            System.out.println("Error : " + e);
        }
    }

    // Write data end
}
