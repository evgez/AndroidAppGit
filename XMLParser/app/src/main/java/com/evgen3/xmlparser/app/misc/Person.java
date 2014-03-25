package com.evgen3.xmlparser.app.misc;

import java.util.Date;

/**
 * Created by Серёга on 24.03.2014.
 */

public class Person {
    private String id;
    private String fio;
    private Napravlenie napravlenie1;
    private Napravlenie napravlenie2;
    private Napravlenie napravlenie3;
    private Date        dataOld;
    private Date        dataNew;

    public Date getDataOld() {
        return dataOld;
    }

    public void setDataOld(Date dataOld) {
        this.dataOld = dataOld;
    }

    public Date getDataNew() {
        return dataNew;
    }

    public void setDataNew(Date dataNew) {
        this.dataNew = dataNew;
    }

    public Person(String id, String fio, Napravlenie napravlenie1) {
        this.id = id;
        this.fio = fio;
        this.napravlenie1 = napravlenie1;
    }

    public Person(String id, String fio, Napravlenie napravlenie1, Napravlenie napravlenie2, Napravlenie napravlenie3, Napravlenie napravlenie4) {
        this.id = id;
        this.fio = fio;
        this.napravlenie1 = napravlenie1;
        this.napravlenie2 = napravlenie2;
        this.napravlenie3 = napravlenie3;
        this.napravlenie4 = napravlenie4;
    }

    public Person(String id, String fio, Napravlenie napravlenie1, Napravlenie napravlenie2, Napravlenie napravlenie3) {
        this.id = id;
        this.fio = fio;
        this.napravlenie1 = napravlenie1;
        this.napravlenie2 = napravlenie2;
        this.napravlenie3 = napravlenie3;
    }

    public Person(String id, String fio, Napravlenie napravlenie1, Napravlenie napravlenie2) {
        this.id = id;
        this.fio = fio;
        this.napravlenie1 = napravlenie1;
        this.napravlenie2 = napravlenie2;
    }

    public Person(String id, String fio, Napravlenie napravlenie1, Napravlenie napravlenie2, Napravlenie napravlenie3, Napravlenie napravlenie4, Napravlenie napravlenie5) {
        this.id = id;
        this.fio = fio;
        this.napravlenie1 = napravlenie1;
        this.napravlenie2 = napravlenie2;
        this.napravlenie3 = napravlenie3;
        this.napravlenie4 = napravlenie4;
        this.napravlenie5 = napravlenie5;
    }

    private Napravlenie napravlenie4;

    public Napravlenie getNapravlenie5() {
        return napravlenie5;
    }

    public void setNapravlenie5(Napravlenie napravlenie5) {
        this.napravlenie5 = napravlenie5;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Napravlenie getNapravlenie1() {
        return napravlenie1;
    }

    public void setNapravlenie1(Napravlenie napravlenie1) {
        this.napravlenie1 = napravlenie1;
    }

    public Napravlenie getNapravlenie2() {
        return napravlenie2;
    }

    public void setNapravlenie2(Napravlenie napravlenie2) {
        this.napravlenie2 = napravlenie2;
    }

    public Napravlenie getNapravlenie3() {
        return napravlenie3;
    }

    public void setNapravlenie3(Napravlenie napravlenie3) {
        this.napravlenie3 = napravlenie3;
    }

    public Napravlenie getNapravlenie4() {
        return napravlenie4;
    }

    public void setNapravlenie4(Napravlenie napravlenie4) {
        this.napravlenie4 = napravlenie4;
    }

    private Napravlenie napravlenie5;
}

