/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alten.saletaxproj;

import com.alten.saletaxproj.configLoader.ITaxConfiguration;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author luca
 */
public class TaxCalculator {
    @Autowired
    Set<ITaxConfiguration> taxes;
    public void setTaxes(Set<ITaxConfiguration> taxes){
        this.taxes=taxes;
    }
    public Item calculate(InputItem ii){
        Item  i = new Item(ii);
        i.setFinalPrice(ii.getBasicPrice());
        for(ITaxConfiguration configuredTax : taxes){
            Tax t = getTax(ii,configuredTax);
            i.getTaxes().add(t);
            i.setFinalPrice(i.getFinalPrice()+t.getAmount());
            i.setTaxAmount(i.getTaxAmount()+t.getAmount());
        }
      return i;  
    }

    private Tax getTax(InputItem ii, ITaxConfiguration configuredTax) {
        int taxPerc=configuredTax.getTaxValue(ii.getProductKind(), ii.isImported());
        double taxAmount = Math.round(ii.getAmount()*ii.getBasicPrice()*taxPerc)/100d;
        return new Tax(configuredTax.getName(),taxAmount,taxPerc);
    }
    
}
