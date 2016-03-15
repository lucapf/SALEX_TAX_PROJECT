/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alten.saletaxproj.configLoader;

import com.alten.saletaxproj.configloader.ITaxConfiguration;
import com.alten.saletaxproj.model.EProductCategory;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author luca
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/tax-bean.xml"})
public class ITaxConfigurationTest {
    @Autowired
    @Qualifier("basicTaxConfiguration")
    ITaxConfiguration iTaxBasicConfiguration;
     @Autowired
    @Qualifier("importedTaxConfiguration")
    ITaxConfiguration iTaxImportedConfiguration;
    public ITaxConfigurationTest() {
    }

    @org.junit.Test
    public void testLoad() throws Exception {
        assertNotNull(iTaxBasicConfiguration);
        assertEquals(iTaxBasicConfiguration.getTaxValue(EProductCategory.OTHERS, true).longValue(),10l);
        assertEquals(iTaxBasicConfiguration.getTaxPercValue(EProductCategory.OTHERS,false),0.1,0.0);
        
        
         assertNotNull(iTaxImportedConfiguration);
        assertEquals(iTaxImportedConfiguration.getTaxValue(EProductCategory.OTHERS, true).longValue(),5l);
        assertEquals(iTaxImportedConfiguration.getTaxPercValue(EProductCategory.OTHERS,false),0.00,0.0);
        
    }

   
    
}
