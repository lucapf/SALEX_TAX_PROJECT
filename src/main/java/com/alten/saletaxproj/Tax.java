/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alten.saletaxproj;

/**
 *
 * @author luca
 */
public class Tax {
    private final String name;
    private final double amount;
    private final double perc;
    public Tax(String name, double amount, double perc){
        this.name=name;
        this.amount=amount;
        this.perc=perc;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

   

    /**
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
   
    /**
     * @return the perc
     */
    public double getPerc() {
        return perc;
    }

   
}
