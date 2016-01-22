/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alten.saletaxproj.writer;

import com.alten.saletaxproj.model.EProductCategory;
import com.alten.saletaxproj.model.InputItem;
import com.alten.saletaxproj.model.Invoice;
import com.alten.saletaxproj.model.Item;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author palancaf
 */
public class StreamIInvoiceWriterTest {
    Logger logger =  Logger.getLogger(StreamIInvoiceWriterTest.class);
    public StreamIInvoiceWriterTest() {
    }

    @Test
    public void testWrite() {
    }

    @Test
    public void testGetFields() {
        OutputStream os = new StringOutputStream();
            List<String> fields = new StreamIInvoiceWriter(os).getFields("${asd}....---1234>!${name}QQQQ${example}");
            assertEquals(3,fields.size());
            Iterator<String> i = fields.iterator();
           assertEquals("asd",i.next());
           assertEquals("name",i.next());
           
        }
    @Test 
    public void testInvoicewriter() throws UnsupportedFieldException, IOException{
        Invoice i = new Invoice();
        i.setSalesTaxes(2.99);
        i.setTotal(4.99);
        i.getItems().add(new Item(new InputItem(1,"item1",false,EProductCategory.BOOK,1.99d)));
        i.getItems().add(new Item(new InputItem(2,"item2",false,EProductCategory.BOOK,2.99d)));
        StringOutputStream outputStream = new StringOutputStream();
        new StreamIInvoiceWriter(outputStream).write(i);
        logger.info(outputStream.toString());
        
    }
        
    }
    

