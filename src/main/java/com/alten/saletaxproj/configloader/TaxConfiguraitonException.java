/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alten.saletaxproj.configloader;

/**
 *
 * @author luca
 */
public class TaxConfiguraitonException extends Exception {
    public TaxConfiguraitonException(String message, Exception e){
        super(message,e);
    }
    public TaxConfiguraitonException (String message){
        super(message);
    }
}
