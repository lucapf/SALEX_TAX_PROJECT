/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alten.saletaxproj.writer;

import com.alten.saletaxproj.model.Item;

/**
 *
 * @author palancaf
 */
public class UnsupportedFieldException extends Exception {

    public UnsupportedFieldException(String field, String item, String i) {
        super ("fieldName: " + field + " item: " + item + " values:" + i);
    }
    
}