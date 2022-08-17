package com.techelevator.projects.view;

import org.apache.commons.dbcp2.BasicDataSource;

public class InventoryCLI {

    public static void main(String[] args) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/RPGInventory");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");


        Inventory myInventory = new Inventory(dataSource);
        myInventory.run();
    }
}
