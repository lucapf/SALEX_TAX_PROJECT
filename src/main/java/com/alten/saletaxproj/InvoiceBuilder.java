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
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author luca
 */
public class InvoiceBuilder {    
    @Autowired
    private TaxCalculator tc;
    
    @Autowired
    private IInputParser basketItemLineParser;
    
    public Invoice create(){
        return new Invoice();
    }
    public Invoice update (Invoice invoice, String input)throws InvoiceBuilderException{
        try{
        Item i = tc.calculate(basketItemLineParser.parse(input));
        invoice.setTotal(invoice.getTotal()+i.getFinalPrice());
        invoice.setSalesTaxes(invoice.getSalesTaxes()+i.getTaxAmount());
        invoice.getItems().add(i);
        }catch (Exception ex){
            throw  new InvoiceBuilderException(ex);
        }
        return invoice;
    }
    
    
}
