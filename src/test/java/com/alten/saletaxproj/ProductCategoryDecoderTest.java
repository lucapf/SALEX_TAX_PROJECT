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
public class ProductCategoryDecoderTest {
    
    public ProductCategoryDecoderTest() {
    }

    @Test
    public void testMatch() throws Exception {
        String message="1 bottle of chocolate imported";
        ProductCategoryDecoder pcd=new ProductCategoryDecoder();
        assertEquals(pcd.match(message), EProductCategory.FOOD);
        message="1 bottle of pills imported";
        assertEquals(pcd.match(message), EProductCategory.OTHERS);
          message=" headache pills";
        assertEquals(pcd.match(message), EProductCategory.MEDICAL);
          message=" chocolates pills";
        assertEquals(pcd.match(message), EProductCategory.FOOD);
        message=" chocolated pills";
        assertEquals(pcd.match(message), EProductCategory.OTHERS);
        message="great italian pasta pack ";
        assertEquals(pcd.match(message), EProductCategory.FOOD);
    }
    
}
