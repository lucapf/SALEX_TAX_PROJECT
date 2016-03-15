/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alten.saletaxproj;

import com.alten.saletaxproj.model.InputItem;
import com.alten.saletaxproj.input.parser.ShoppingBasketItemLineParser;
import com.alten.saletaxproj.model.EProductCategory;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author luca
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/beans.xml"})
public class ShoppingBasketItemLineParserTest {
    @Autowired
    ShoppingBasketItemLineParser sbilp;
    public ShoppingBasketItemLineParserTest() {
    }

    @Test
    public void testParse() throws Exception {
        String strInput="1 bottle of imported chocolate at 8.90";
        InputItem ii = sbilp.parse(strInput);
        assertNotNull(ii);
        assertEquals(ii.getAmount(), 1);
        assertEquals(ii.getBasicPrice(),8.90d,0.0d);
        assertEquals(ii.getProductCategory(),EProductCategory.FOOD);
        
        strInput="1 packet ok spaghetti pasta at 8.90";
        ii = sbilp.parse(strInput);
        assertNotNull(ii);
        assertEquals(ii.getAmount(), 1);
        assertEquals(ii.getBasicPrice(),8.90d,0.0d);
        assertEquals(ii.getProductCategory(),EProductCategory.FOOD);
        
        
         strInput="1 table at 8.90";
        ii = sbilp.parse(strInput);
        assertNotNull(ii);
        assertEquals(ii.getAmount(), 1);
        assertEquals(ii.getBasicPrice(),8.90d,0.0d);
        assertEquals(ii.getProductCategory(),EProductCategory.OTHERS);
        
        
    }
    
}
