/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alten.saletaxproj;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author palancaf
 */
public class MainTest {
    
    public MainTest() {
    }
    @Test
    public void testSplit(){
        String inputStr = "1 box of chocolate at 1.99\n"
                + "2 bottles of cocacola at 2";
        
        String [] aString = new Main().splitItems(inputStr);
        assertNotNull(aString);
        assertEquals(2,aString.length);
        assertEquals("1 box of chocolate at 1.99", aString[0]);
    }
    
}
