/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alten.saletaxproj;

import com.alten.saletaxproj.model.EProductCategory;
import com.alten.saletaxproj.model.Invoice;
import com.alten.saletaxproj.model.Item;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author palancaf
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/beans.xml"})
public class InvoiceBuilderTest {
    @Autowired            
    InvoiceBuilder builder;
    public InvoiceBuilderTest() {
    }

   

    @Test
    public void testUpdate() throws Exception {
        Invoice invoice = builder.create();
        assertNotNull(invoice);
        
        invoice = builder.update(invoice, "1 box of pasta spaghetti imported at 2");
        assertNotNull(invoice.getItems());
        assertEquals(invoice.getItems().size(), 1);
        Item i = invoice.getItems().iterator().next();
        assertEquals(EProductCategory.FOOD,i.getProductCategory());
        assertEquals(2.1d,i.getFinalPrice(),0.0);
        assertEquals(2.1d,invoice.getTotal(),0.0);
        assertEquals(0.1d,invoice.getSalesTaxes(),0.0);
        
        invoice = builder.update(invoice, "2 box of pasta spaghetti at 2");
        assertEquals(invoice.getItems().size(), 2);
        assertEquals(6.1d,invoice.getTotal(),0.0);
        assertEquals(0.1d,invoice.getSalesTaxes(),0.0);
    }
    
}
