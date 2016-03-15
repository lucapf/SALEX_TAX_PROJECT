/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alten.saletaxproj;

/**
 *
 * @author palancaf
 */
public class InvoiceBuilderException extends Exception {

    public InvoiceBuilderException(Exception e) {
        super(e);
    }

    public InvoiceBuilderException(String message) {
        super(message);
    }

    public InvoiceBuilderException(String message, Exception e) {
        super(message, e);
    }

}
