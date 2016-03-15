/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alten.saletaxproj;

/**
 *
 * @author work
 */
public class InvoicePrinterException extends Exception {
    public InvoicePrinterException(String message, Exception e){
        super(message,e);
    }
    public InvoicePrinterException (String message){
        super(message);
    }
}
