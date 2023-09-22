package com.example.sigortafx.Classes.Sigortas;

import com.example.sigortafx.Abstarcts.Sigorta;

public class DaskSigorta extends Sigorta {

    public DaskSigorta(String name, String content) {
        super(name, content, "DASK");
    }

    @Override
    public double teklifYap(boolean isDayanikli ,double deger) {
        if(isDayanikli)
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
