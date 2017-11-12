package com.money.moneytracker;

/**
 * Created by user on 04.11.2017.
 */

public class item {

    public static final String TYPE_UNKNOWN = "unknown";
    public static final String TYPE_EXPENSE = "expense";
    public static final String TYPE_INCOME = "income";


    public int id;
    public int price;
    public String name;
    public String type;

    public item(String name, int price, String type){
        this.name = name;
        this.price = price;
        this.type= type;
    }


}
