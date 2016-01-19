/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alten.saletaxproj.model;

import com.alten.saletaxproj.model.EProductCategory;

/**
 *
 * @author luca
 */
public class InputItem {
    private final int amount;
    private final String name;
    private final boolean imported;
    private final EProductCategory productCategory;
    private double basicPrice; 
    public InputItem(int amount,String name, boolean imported, EProductCategory product, double basicPrice){
        this.amount=amount;
        this.name=name;
        this.imported=imported;
        this.productCategory=product;
        this.basicPrice=basicPrice;
                
    }
    public int getAmount(){
        return amount;
    }
    /**
     * @return the imported
     */
    public boolean isImported() {
        return imported;
    }

    /**
     * @return the productCategory
     */
    public EProductCategory getProductCategory() {
        return productCategory;
    }

    /**
     * @return the basicPrice
     */
    public double getBasicPrice() {
        return basicPrice;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    
}
