/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alten.saletaxproj;

import com.alten.saletaxproj.model.Invoice;
import java.io.BufferedReader;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author luca
 */
public class InputToinvoice {
    Logger logger = Logger.getLogger(InputToinvoice.class);
    public Invoice exec(BufferedReader inputOrder)throws InvoiceBuilderException{
        ApplicationContext ac = new ClassPathXmlApplicationContext("/beans.xml");
        InvoiceBuilder ib=(InvoiceBuilder)ac.getBean("invoiceBuilder");        
        Invoice invoice = ib.create();
        String orderLine;
        try{
          
        while ( (orderLine = inputOrder.readLine())!= null){
            logger.debug("processing: " + orderLine);
            invoice = ib.update(invoice, orderLine);
        }
        logger.debug("number of items processed: " + invoice.getItemSize());
        }catch (IOException ioe){
            throw  new InvoiceBuilderException(ioe);
        }
       return invoice;
    }
    
//    protected String[] splitItems(String inputOrder){
//        return inputOrder==null?null:inputOrder.split("\n");
//    }
}
