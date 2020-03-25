package com.melake.realestateapp;

public class ModelClass {

    private String firstName,lastName,gender,email;

    private String mobile;
    public ModelClass(String fn, String e, String m){

    }

    public ModelClass(String firstName, String lastName, String gender, String email, String mobile) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.mobile = mobile;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }
}
