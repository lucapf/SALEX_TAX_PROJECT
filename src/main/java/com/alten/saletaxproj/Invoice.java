/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alten.saletaxproj;

import java.util.Set;

/**
 *
 * @author luca
 */
public class Invoice {
    private Set<Item> items;
    private double salesTaxes;
    private double total;

    /**
     * @return the items
     */
    public Set<Item> getItems() {
        return items;
    }

    /**
     * @param items the items to set
     */
    public void setItems(Set<Item> items) {
        this.items = items;
    }

    /**
     * @return the salesTaxes
     */
    public double getSalesTaxes() {
        return salesTaxes;
    }

    /**
     * @param salesTaxes the salesTaxes to set
     */
    public void setSalesTaxes(double salesTaxes) {
        this.salesTaxes = salesTaxes;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }
    
}
