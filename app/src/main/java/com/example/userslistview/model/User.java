package com.example.userslistview.model;

import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.Expose;


//User Data Model
public class User {

    @SerializedName("id")
    @Expose
    public String id;

    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("email")
    @Expose
    public String email;

    @SerializedName("phone")
    @Expose
    public String phone;

    public User() {
    }

    public User(String id, String name, String phone, String email) {
        this.id = id;
        this.name=name;
        this.phone=phone;
        this.email=email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}