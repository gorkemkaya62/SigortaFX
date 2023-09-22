package com.example.sigortafx.Classes.Sigortas;

import com.example.sigortafx.Abstarcts.Sigorta;

public class TrafikSigorta extends Sigorta {
    public TrafikSigorta(String name, String content) {
        super(name, content, "Trafik");
    }

    @Override
    public double teklifYap(boolean isBiggerThan13 ,double deger) {
        if(isBiggerThan13)
        {
            return (deger)/100;
        }else{
            return (deger)/50;
        }
    }

    @Override
    public String bilgileriYazdir() {
        return getName() + "\t" + getContent() + "\t" + getTur();
    }
}
