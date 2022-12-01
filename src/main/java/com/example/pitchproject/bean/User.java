package com.example.pitchproject.bean;

public class User {
    private int id;
    private String username;
    private String password;
    private int idRole;
    private String fullName;
    private String image;
    private String phoneNumber;
    private String email;
    private String address;
    private int point;

    public User() {
    }

    public User(int id, String username, String password, int idRole, String fullName, String image, String phoneNumber, String email, String address, int point) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.idRole = idRole;
        this.fullName = fullName;
        this.image = image;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.point = point;
    }

    public User(String username, String password, int idRole, String fullName, String image, String phoneNumber, String email, String address) {
        this.username = username;
        this.password = password;
        this.idRole = idRole;
        this.fullName = fullName;
        this.image = image;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
