package com.sejo;

import com.sejo.dao.BeverageDao;
import com.sejo.entities.Beverage;

import java.util.List;
import java.util.Stack;

public class App {
    public static void main(String[] args) {

        BeverageDao beverageDao = new BeverageDao();

        //Creating dummy data to store in database
        Beverage coffeeTea = new Beverage("Coffee/Tea",20,25,50);
        Beverage juice = new Beverage("Juice",20,25,50);
        Beverage soda = new Beverage("Soda",20,25,50);

        List<Beverage> beverageList = List.of(coffeeTea,juice,soda);
        Stack<Beverage> beverageStack = new Stack<>();

        beverageStack.push(coffeeTea);
        beverageStack.push(juice);
        beverageStack.push(soda);

        //Using hibernate dao to save beverages in database
        beverageDao.saveListOfBeverages(beverageList);
        beverageDao.saveStackOfBeverages(beverageStack);

        //Using hibernate dao to retrieve beverages as a list
        List< Beverage > beveragesAsList = beverageDao.getBeveragesAsList();
        Stack< Beverage > beveragesAsStack = beverageDao.getBeveragesAsStack();
        Beverage[] beveragesAsArray = beverageDao.getBeveragesAsArray();


        //Performing some action with the list of beverages
        beveragesAsList.forEach(b ->
                System.out.println(b.toString())
        );

        beveragesAsStack.forEach(b ->
                System.out.println(b.toString())
        );

        for (Beverage b : beveragesAsArray) {
            System.out.println(b.toString());
        }
    }

}
