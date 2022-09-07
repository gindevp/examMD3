package com.codegym.exammd3.model;

import java.time.LocalDate;

public class Student {
    private int id;
    private String name;
    private LocalDate dateOfBirth;
    private String address;
    private String phone;
    private String email;

    private String classroom_id;

    public Student() {
    }

    public Student(int id, String classroom_id) {
        this.id = id;
        this.classroom_id = classroom_id;
    }

    public Student(int id, String name, String dateOfBirth, String address, String phone, String email, String classroom_id) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = LocalDate.parse(dateOfBirth);
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.classroom_id = classroom_id;
    }

    public Student(String name, String dateOfBirth, String address, String phone, String email, String classroom_id) {
        this.name = name;
        this.dateOfBirth = LocalDate.parse(dateOfBirth);
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.classroom_id = classroom_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return String.valueOf(dateOfBirth);
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = LocalDate.parse(dateOfBirth);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClassroom_id() {
        return classroom_id;
    }

    public void setClassroom_id(String classroom_id) {
        this.classroom_id = classroom_id;
    }
}
