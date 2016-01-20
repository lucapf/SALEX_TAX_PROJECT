/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alten.saletaxproj.model;

import com.alten.saletaxproj.Tax;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author luca
 */
public class Item extends InputItem{
 
  private Set<Tax> taxes;
  private double taxAmount;
  private double finalPrice;
  public Item(InputItem inputItem){
      super(inputItem.getAmount(),inputItem.getName(),inputItem.isImported(),inputItem.getProductCategory(),inputItem.getBasicPrice());
      this.taxes=new HashSet<Tax> ();
      taxAmount=0;
      finalPrice=0;
  }

    /**
     * @return the taxes
     */
    public Set<Tax> getTaxes() {
        return taxes;
    }

    /**
     * @param taxes the taxes to set
     */
    public void setTaxes(Set<Tax> taxes) {
        this.taxes = taxes;
    }

    /**
     * @return the taxAmount
     */
    public double getTaxAmount() {
        return taxAmount;
    }

    /**
     * @param taxAmount the taxAmount to set
     */
    public void setTaxAmount(double taxAmount) {
        this.taxAmount = taxAmount;
    }

    /**
     * @return the finalPrice
     */
    public double getFinalPrice() {
        return finalPrice;
    }

    /**
     * @param finalPrice the finalPrice to set
     */
    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }
  
}
