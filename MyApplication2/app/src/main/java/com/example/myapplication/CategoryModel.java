package com.example.myapplication;

public class CategoryModel {
    String title;
    String description;
    String priceUnit; // Contoh: "Per Jam", "Per Porsi"

    public CategoryModel(String title, String description, String priceUnit) {
        this.title = title;
        this.description = description;
        this.priceUnit = priceUnit;
    }

    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getPriceUnit() { return priceUnit; }
}