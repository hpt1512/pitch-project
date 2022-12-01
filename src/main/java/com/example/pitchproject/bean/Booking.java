package com.example.pitchproject.bean;

import java.util.Date;

public class Booking {
    private int id;
    private int idPitch;
    private int idUser;
    private Date date;
    private int price;
    private String description;
    private int idVoucher;
    private int status;

    public Booking() {
    }

    public Booking(int id, int id_pitch, int id_user, Date date, int price, String description, int idVoucher, int status) {
        this.id = id;
        this.idPitch = id_pitch;
        this.idUser = id_user;
        this.date = date;
        this.price = price;
        this.description = description;
        this.idVoucher = idVoucher;
        this.status = status;
    }

    public Booking(int id_pitch, int id_user, Date date, int price, String description, int idVoucher) {
        this.idPitch = id_pitch;
        this.idUser = id_user;
        this.date = date;
        this.price = price;
        this.description = description;
        this.idVoucher = idVoucher;
    }
    public Booking(int id_pitch, int id_user, Date date, int price, String description) {
        this.idPitch = id_pitch;
        this.idUser = id_user;
        this.date = date;
        this.price = price;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPitch() {
        return idPitch;
    }

    public void setIdPitch(int idPitch) {
        this.idPitch = idPitch;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdVoucher() {
        return idVoucher;
    }

    public void setIdVoucher(int idVoucher) {
        this.idVoucher = idVoucher;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
