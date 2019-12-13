package com.f19.rosette_768425_ft;

import androidx.annotation.NonNull;

public class Person {
    private String name;
    private String email;
    private Long phone;

    public Person(String name, String email, Long phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
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

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    @NonNull
    @Override
    public String toString() {
        String details = "Name\t\t\t: " + this.name +
                "\nPhone\t\t\t: " + String.valueOf(this.phone) +
                "\nEmail Ad\t\t\t: " + this.email;
        return details;
    }

}