/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alten.saletaxproj;

import com.alten.saletaxproj.model.EProductCategory;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author luca
 */
public class ShoppingBasketItemLineParserTest {
    
    public ShoppingBasketItemLineParserTest() {
    }

    @Test
    public void testParse() throws Exception {
        String strInput="1 bottle of imported chocolate at 8.90";
        InputItem ii = ShoppingBasketItemLineParser.parse(strInput);
        assertNotNull(ii);
        assertEquals(ii.getAmount(), 1);
        assertEquals(ii.getBasicPrice(),8.90d,0.0d);
        assertEquals(ii.getProductKind(),EProductCategory.FOOD);
        
        strInput="1 packet ok spaghetti pasta 8.90";
        ii = ShoppingBasketItemLineParser.parse(strInput);
        assertNotNull(ii);
        assertEquals(ii.getAmount(), 1);
        assertEquals(ii.getBasicPrice(),8.90d,0.0d);
        assertEquals(ii.getProductKind(),EProductCategory.FOOD);
        
        
         strInput="1 table 8.90";
        ii = ShoppingBasketItemLineParser.parse(strInput);
        assertNotNull(ii);
        assertEquals(ii.getAmount(), 1);
        assertEquals(ii.getBasicPrice(),8.90d,0.0d);
        assertEquals(ii.getProductKind(),EProductCategory.OTHERS);
        
        
    }
    
}
