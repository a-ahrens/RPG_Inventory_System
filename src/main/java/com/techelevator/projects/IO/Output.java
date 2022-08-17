package com.techelevator.projects.IO;

import com.techelevator.projects.model.Item;

public class Output {

    //You are walking down the road and found an item
    public void itemDiscovery(Item item){
        System.out.println("You found " + item.getName());
        System.out.println("ITEM IMAGE");
        System.out.println("Would you like to pick up this item? Y/N");
    }

    public void itemPickup(Item item){
        System.out.println("You picked up " + item.getName());
    }

    public void overWeightMessage(){
        System.out.println("You are carrying too much weight. You cannot continue to travel");
        System.out.println("Please select an item to drop: ");
    }
}
