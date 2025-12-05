package com.example.myapplication;

public class UserModel {
    String name;
    String date;   // Sesuai XML tvDate
    String role;   // Sesuai XML tvRole
    String status; // Sesuai XML tvStatus

    public UserModel(String name, String date, String role, String status) {
        this.name = name;
        this.date = date;
        this.role = role;
        this.status = status;
    }

    public String getName() { return name; }
    public String getDate() { return date; }
    public String getRole() { return role; }
    public String getStatus() { return status; }
}