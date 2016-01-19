/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alten.saletaxproj;

import com.alten.saletaxproj.model.Invoice;
import java.util.Set;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author luca
 */
public class Main {
    public Invoice exec(String inputOrder){
        ApplicationContext ac = new ClassPathXmlApplicationContext("/beans.xml");
        InvoiceBuilder ib=(InvoiceBuilder)ac.getBean("invoiceBuilder");        
        
        for (String orderLine : splitItems(inputOrder)){
            
        }
        
       return null;
    }
    
    protected String[] splitItems(String inputOrder){
        return inputOrder==null?null:inputOrder.split("\n");
    }
}
