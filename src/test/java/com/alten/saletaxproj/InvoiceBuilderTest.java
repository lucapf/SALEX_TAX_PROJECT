/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alten.saletaxproj;

import com.alten.saletaxproj.model.Invoice;
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
        String item="1 box of pasta spaghetti at 2";
        invoice = builder.update(invoice, item);
        assertNotNull(invoice.getItems());
        assertEquals(invoice.getItems().size(), 1);
        
    }
    
}
