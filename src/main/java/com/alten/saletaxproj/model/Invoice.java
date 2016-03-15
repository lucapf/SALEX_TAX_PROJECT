/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alten.saletaxproj.model;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author luca
 */
public class Invoice {

    private Deque<Item> items = new ArrayDeque<Item>();
    private double salesTaxes = 0.0d;
    private double total = 0.0d;

    /**
     * @return the items
     */
    public Item getItem() {
        return items.pollLast();
    }

    public int getItemSize() {
        return items.size();
    }

    /**
     * @param items the items to set
     */
    public void pushItem(Item item) {
        this.items.push(item);
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
