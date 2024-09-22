package com.algoriant.sms.model;

public class Student {
    private String name,email;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(int phoneno) {
        this.phoneno = phoneno;
    }

    private int phoneno;

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setEmail(String email) {
        this.email=email;
    }
    public String getEmail() {
        return email;
    }
    public  String toString() {
        return id+" "+name+" "+email+" "+phoneno;
    }
}
