package com.example.pitchproject.bean;

public class Company {
    private int id;
    private int idLocation;
    private String name;
    private String image;
    private String phoneNumber;
    private String email;
    private String address;
    private int idUser;

    public Company() {
    }

    public Company(int id, int idLocation, String name, String image, String phoneNumber, String email, String address, int idUser) {
        this.id = id;
        this.idLocation = idLocation;
        this.name = name;
        this.image = image;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.idUser = idUser;
    }

    public Company(int idLocation, String name, String image, String phoneNumber, String email, String address, int idUser) {
        this.idLocation = idLocation;
        this.name = name;
        this.image = image;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.idUser = idUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(int idLocation) {
        this.idLocation = idLocation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}
