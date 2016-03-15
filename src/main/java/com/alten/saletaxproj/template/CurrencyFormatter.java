/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alten.saletaxproj.template;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;
import org.springframework.util.StringUtils;

/**
 *
 * @author work
 */
public class CurrencyFormatter {
    private static NumberFormat nf =null;
    private static NumberFormat getNumberFormat(){
        if (nf==null){ 
            nf = NumberFormat.getCurrencyInstance(Locale.ENGLISH);
            DecimalFormatSymbols decimalFormatSymbols = ((DecimalFormat)nf).getDecimalFormatSymbols();
            decimalFormatSymbols.setCurrencySymbol("");
            ((DecimalFormat)nf).setDecimalFormatSymbols(decimalFormatSymbols);
        }
        return nf;
    }
   public static String format(double price){
       return getNumberFormat().format(price);
   } 
   public static String format(int quantity){
       return String.valueOf(quantity);
   }
}
