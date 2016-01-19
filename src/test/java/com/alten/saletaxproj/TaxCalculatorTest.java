/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alten.saletaxproj;

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
@ContextConfiguration("/beans.xml")
public class TaxCalculatorTest {
    @Autowired
    TaxCalculator tc;
    public TaxCalculatorTest() {
    }

    @Test
    public void testCalculate() {
        InputItem ii = new InputItem(2,"book",true,EProductCategory.BOOK,12.49d);
        Item i  = tc.calculate(ii);
        assertNotNull(i);
        assertEquals(i.getTaxAmount(),2*12.49*5/100,0.009);
    }
    
}
