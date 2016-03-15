/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alten.saletaxproj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.apache.log4j.Logger;

/**
 *
 * @author palancaf
 */
public class Main {

    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(final String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            InvoicePrinter.print(new InputToinvoice().exec(br));

        } catch (InvoiceBuilderException ibe) {
            logger.error("Error in order parsing! see detail plx ", ibe);
        }catch (InvoicePrinterException ipe){
            logger.error("Error in printing order! see detail plx ", ipe);
        }
    }
}
