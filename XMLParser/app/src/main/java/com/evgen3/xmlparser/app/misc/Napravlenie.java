package com.evgen3.xmlparser.app.misc;

/**
 * Created by Серёга on 02.03.14.
 */
public class Napravlenie {
    private String naimenovanie,department,speciality,privilege,docstate;

    public Napravlenie(String naimenovanie, String department, String speciality, String privilege, String docstate, int license, int budget, int rating, int place, int originplace) {
        this.naimenovanie = naimenovanie;
        this.department = department;
        this.speciality = speciality;
        this.privilege = privilege;
        this.docstate = docstate;
        this.license = license;
        this.budget = budget;
        this.rating = rating;
        this.place = place;
        this.originplace = originplace;
    }

    public String getNaimenovanie() {
        return naimenovanie;
    }

    public void setNaimenovanie(String naimenovanie) {
        this.naimenovanie = naimenovanie;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

    public String getDocstate() {
        return docstate;
    }

    public void setDocstate(String docstate) {
        this.docstate = docstate;
    }

    public int getLicense() {
        return license;
    }

    public void setLicense(int license) {
        this.license = license;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public int getOriginplace() {
        return originplace;
    }

    public void setOriginplace(int originplace) {
        this.originplace = originplace;
    }

    private int    license,budget,rating,place,originplace;
}
