package com.example.pitchproject.bean;

import java.sql.Time;

public class Pitch {
    private int id;
    private int idCompany;
    private String name;
    private int peopleMax;
    private Time time;
    private int price;
    private int status;

    public Pitch(int id, int idCompany, String name, int peopleMax, Time time, int price, int status) {
        this.id = id;
        this.idCompany = idCompany;
        this.name = name;
        this.peopleMax = peopleMax;
        this.time = time;
        this.price = price;
        this.status = status;
    }

    public Pitch(int idCompany, String name, int peopleMax, Time time, int price) {
        this.idCompany = idCompany;
        this.name = name;
        this.peopleMax = peopleMax;
        this.time = time;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(int idCompany) {
        this.idCompany = idCompany;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPeopleMax() {
        return peopleMax;
    }

    public void setPeopleMax(int peopleMax) {
        this.peopleMax = peopleMax;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
