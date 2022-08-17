package com.techelevator.projects.view;

import com.techelevator.projects.dao.JdbcWeaponDao;
import com.techelevator.projects.dao.WeaponDao;
import com.techelevator.projects.model.Item;
import com.techelevator.projects.model.Weapon;

import javax.sql.DataSource;

public class Inventory {

    private final double MAXWEIGHTCAPACITY = 100;
    private double totalWeight = 0;
    private final int INVENTORYSLOTS = 10;
    private Item[] inventory = new  Item[INVENTORYSLOTS];

    private WeaponDao weaponDao;

    public Inventory (DataSource dataSource){
        weaponDao = new JdbcWeaponDao(dataSource);
    }





    public void run(){
        System.out.println("This is a test of the weapon retrieval system");
        Weapon weapon = weaponDao.getWeapon(6);
        System.out.println(weapon.toString());
    }



    public double getTotalWeight(){
        return this.totalWeight;
    }

    public Item[] getInventory(){
        return this.inventory;
    }

    public void addItemToInventory(Item item){

        boolean spaceAvailable = false;
        for(int i = 0; i < inventory.length; i++){
            if(inventory[i] == null){
                spaceAvailable = true;
                inventory[i] = item;
                addWeight(item);
                break;
            }
        }

        if(!spaceAvailable){
            System.out.println("Cannot pick up item. No Space Available.");
            System.out.println("Please drop an item to make space in your inventory.");
        }
    }

    public void dropItemFromInventory(int slotNumber){
        System.out.println("You dropped " + inventory[slotNumber] + " from your inventory.");
        subtractWeight(inventory[slotNumber]);
        inventory[slotNumber] = null;
    }

    public void addWeight(Item item){
        totalWeight += item.getItemWeight();
    }

    public void subtractWeight(Item item){
        totalWeight -= item.getItemWeight();
    }




}
