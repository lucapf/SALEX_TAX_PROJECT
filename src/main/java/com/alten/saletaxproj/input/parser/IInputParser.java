/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alten.saletaxproj.input.parser;

import com.alten.saletaxproj.model.InputItem;

/**
 *
 * @author palancaf
 */
public interface IInputParser {

    InputItem parse(String line) throws ProductCategoryNotConfiguredException;
    
}
