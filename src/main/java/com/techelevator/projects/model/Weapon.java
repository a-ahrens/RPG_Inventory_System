package com.techelevator.projects.model;

import java.util.HashMap;
import java.util.Map;

public class Weapon extends Item {

    private int attack;


    private Map<String, Integer> elementType = new HashMap<>();

    public Weapon(){};

    public Weapon(int id, String name, String itemType, String itemDescription, double itemWeight, int value, int attack) {
        super(id, name, itemType, itemDescription, itemWeight, value);
        this.attack = attack;
    }


    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public Map<String, Integer> getElementType() {
        return elementType;
    }

    public void setElementType(Map<String, Integer> elementType) {
        this.elementType = elementType;
    }

    @Override
    public String toString(){
        String printout =   "Weapon \n" +
                "Name: "    + getName() + "\n" +
                "Type: "    + getItemType() + "\n" +
                "Attack: "  + getAttack() + "\n" +
                "Description: \n"
                + getItemDescription() + "\n" +
                "Weight: "  + getItemWeight() + "\n" +
                "Value: "   + getValue() + "\n" +
                "Elemental Attack: \n";

        for(String element: getElementType().keySet()){
            printout += element + ": " + getElementType().get(element) + " ";
        }

        return printout;
    }

}
