/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alten.saletaxproj.configLoader;

import com.alten.saletaxproj.model.EProductCategory;

/**
 *
 * @author luca
 */
public interface ITaxConfiguration {
    final String TAX_DEFAULT_NAME="DEFAULT";
    public void load() throws TaxConfiguraitonException;
    public Integer getTaxValue(EProductCategory ekop, boolean imported);
    public double getTaxPercValue(EProductCategory ekop, boolean imported);
    public String getName();
   
}
