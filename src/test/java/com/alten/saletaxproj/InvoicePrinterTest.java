/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alten.saletaxproj;

import com.alten.saletaxproj.model.EProductCategory;
import com.alten.saletaxproj.model.InputItem;
import com.alten.saletaxproj.model.Invoice;
import com.alten.saletaxproj.model.Item;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author work
 */
public class InvoicePrinterTest {
Logger logger = Logger.getLogger(InvoicePrinterTest.class);
    public InvoicePrinterTest() {
    }
    
   
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testGetFields() throws Exception {

        List <String> result = InvoicePrinter.getFields(":amount :name :basicPrice :finalPrice :taxAmount");
        logger.debug("trovati  i seguenti fields: " + result.toString());
        assertEquals(5,result.size());
        assertEquals(result.get(0), "amount");
        
        result = InvoicePrinter.getFields(":amount :name: :basicPrice");
        logger.debug("trovati  i seguenti fields: " + result.toString());
        assertEquals(3,result.size());
        assertEquals(result.get(0), "amount");
        assertEquals(result.get(1), "name");
        
        result = InvoicePrinter.getFields("Sales Taxes: :salesTaxes \n Total: :total");
        logger.debug("trovati  i seguenti fields: " + result.toString());
        assertEquals(2,result.size());
        assertEquals(result.get(0), "salesTaxes");
        assertEquals(result.get(1), "total");
    }
    /**
     * Test of print method, of class InvoicePrinter.
     */
    @Test
    public void testPrint() throws Exception {
        System.out.println("print");
        Item i = new Item(new InputItem(2, "testItem", true, EProductCategory.OTHERS, 12.334));
        i.setFinalPrice(20.445);
        i.setTaxAmount(22.444);
        Invoice invoice = new Invoice();
        invoice.pushItem(i);
        invoice.setTotal(333.444);
        invoice.setSalesTaxes(11.333);
  
        StringWriter sw = new StringWriter();
        InvoicePrinter.setPrintStream(new PrintWriter(sw));
        InvoicePrinter.print(i);
        String result = sw.toString();
        logger.debug("print Item:"+  result + "- result.lenght:"+ result.length());
        assertArrayEquals("2 testItem: 20.44\n".toCharArray(), result.toCharArray());       
    }
    
}
