package com.money.moneytracker;

/**
 * Created by user on 04.11.2017.
 */

public class item {
    private String name;
    private int price;
    public item(String name, int price){
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price){
        this.price = price;
    }
}
