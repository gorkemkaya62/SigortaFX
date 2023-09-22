package com.example.sigortafx.Abstarcts;

import com.example.sigortafx.Classes.Renkler;
import com.example.sigortafx.Classes.SigortaMain;

public abstract class Sigorta {
    private String name;
    private String content;
    private String tur;

    public Sigorta(String name, String content, String tur)
    {
        this.name = name;
        this.content = content;
        this.tur = tur;
        SigortaMain.getInstance().getSigortas().add(this);
    }

    public String getTur() {
        return tur;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public abstract double teklifYap(boolean isDayanikli ,double deger);
    public abstract String bilgileriYazdir();
    @Override
    public String toString()
    {
        String line = "Ürün Adı: " + getName() + "\n" + "Açıklama:" +getContent();
        return line;
    }


    public String writeInfos() {
        return getName() + "\t" + getContent() + "\t" + getTur();
    }
}
