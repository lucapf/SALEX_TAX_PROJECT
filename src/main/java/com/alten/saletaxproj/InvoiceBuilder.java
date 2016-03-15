/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alten.saletaxproj;

import com.alten.saletaxproj.model.Item;
import com.alten.saletaxproj.model.Invoice;
import com.alten.saletaxproj.tax.calculator.TaxCalculator;
import com.alten.saletaxproj.input.parser.IInputParser;
import com.alten.saletaxproj.input.parser.ShoppingBasketItemLineParser;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author luca
 */
public class InvoiceBuilder {   
    Logger logger = Logger.getLogger(InvoiceBuilder.class);
    @Autowired(required = true)   
    private TaxCalculator tc;
    
    @Autowired(required = true)
    private IInputParser inputParser;
    
    public Invoice create(){
        return new Invoice();
    }
    public Invoice update (Invoice invoice, String input)throws InvoiceBuilderException{
        try{
         logger.debug("aggiornamento invoice; inputString:"+ input 
                 + " parser inizializzato?" +(inputParser!= null)
                 + " taxCalculator inizializzato? " + (tc!= null));
        Item i = tc.calculate(inputParser.parse(input));
        invoice.setTotal(invoice.getTotal()+i.getFinalPrice());
        invoice.setSalesTaxes(invoice.getSalesTaxes()+i.getTaxAmount());
        invoice.pushItem(i);
        }catch (Exception ex){
            throw  new InvoiceBuilderException(ex);
        }
        return invoice;
    }
    
    
}
