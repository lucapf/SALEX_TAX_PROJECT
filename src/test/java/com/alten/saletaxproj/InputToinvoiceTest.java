/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alten.saletaxproj;

import com.alten.saletaxproj.model.Invoice;
import java.io.BufferedReader;
import java.io.StringReader;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author palancaf
 */
public class InputToinvoiceTest {
    
    public InputToinvoiceTest() {
    }

    @Test
    public void testExec() throws Exception {
        StringReader sr = new StringReader("1 chocolate bar at 12.49");
        BufferedReader br = new BufferedReader(sr);
        Invoice i = new InputToinvoice().exec(br);
        assertEquals(1, i.getItemSize());
    }

   
    
}
