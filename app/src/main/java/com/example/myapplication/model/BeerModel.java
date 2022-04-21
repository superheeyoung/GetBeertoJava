package com.example.myapplication.model;

import com.google.gson.annotations.SerializedName;

public class BeerModel {
    @SerializedName("name")
    private String fullName;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
