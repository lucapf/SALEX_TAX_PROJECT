/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alten.saletaxproj.tax.calculator;

import com.alten.saletaxproj.model.InputItem;
import com.alten.saletaxproj.model.Item;

/**
 *
 * @author palancaf
 */
public interface ITaxCalculator {

    public Item calculate(InputItem ii);
    
}
