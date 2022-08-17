package com.techelevator.projects.model;


public class Item {

    private int itemId;
    private String name;
    private String itemType;
    private String itemDescription;
    private double itemWeight;
    private int value;

    public Item(){};

    public Item(int itemId, String name, String itemType, String itemDescription, double itemWeight, int value) {
        this.itemId = itemId;
        this.name = name;
        this.itemType = itemType;
        this.itemDescription = itemDescription;
        this.itemWeight = itemWeight;
        this.value = value;
    }


    public int getItemId() {
        return itemId;
    }

    public void setItemId(int id) {
        this.itemId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public double getItemWeight() {
        return itemWeight;
    }

    public void setItemWeight(double itemWeight) {
        this.itemWeight = itemWeight;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

