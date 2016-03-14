/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alten.saletaxproj;

import com.alten.saletaxproj.model.Invoice;
import com.alten.saletaxproj.model.Item;
import java.io.PrintStream;

/**
 *
 * @author palancaf
 */
class InvoicePrinter {

    
    PrintStream ps = System.out;
    private static final String PATTERN_ITEM =":amount :name: :basicPrice";
    private static final String FOOTER_PATTERN="Sales Taxes: :salesTaxes \n Total: :total";
    private static final String FIELDS_PATTERN="\b:([a-zA.Z])\b.*";
    static void print(Invoice invoice) {
        System.setProperty("decimal.separator", ".");
        for (Item item : invoice.getItems()) {
            print(item, PATTERN_ITEM); 
        }
        print(invoice, FOOTER_PATTERN);
    }
    private static void print(Object o, String pattern) {
        List<String> fields = new ArrayList<>();
    }
}
