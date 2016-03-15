/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alten.saletaxproj;

import com.alten.saletaxproj.input.parser.ProductCategoryNotConfiguredException;
import com.alten.saletaxproj.model.EProductCategory;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Pattern;
import org.apache.log4j.Logger;

/**
 *
 * @author luca
 */
public class ProductCategoryDecoder {

    private static final Properties PROPERTY = new Properties();
    private static final Logger logger = Logger.getLogger(ProductCategoryDecoder.class.getName());
    private static Map<EProductCategory, Pattern> PATTERN = new HashMap<>();
    private static final String PRODUCT_CONFIGURATION_PROPERTIES_FILE = "/ProductConfiguration.properties";

    public ProductCategoryDecoder() {
        try {
            PROPERTY.load(ProductCategoryDecoder.class.getResourceAsStream(PRODUCT_CONFIGURATION_PROPERTIES_FILE));
            for (Object okey : PROPERTY.keySet()) {
                EProductCategory c = EProductCategory.valueOf((String) okey);
                Pattern p = Pattern.compile(PROPERTY.getProperty(c.name()), Pattern.CASE_INSENSITIVE);
                PATTERN.put(c, p);
            }
        } catch (IOException ioe) {
            logger.error(ioe);
        }
    }

    public EProductCategory match(String product) throws ProductCategoryNotConfiguredException {
        if (PATTERN.isEmpty()) {
            throw new ProductCategoryNotConfiguredException("product category not configured chek " + PRODUCT_CONFIGURATION_PROPERTIES_FILE);
        }
        for (EProductCategory pc : PATTERN.keySet()) {
            if (PATTERN.get(pc).matcher(product).find()) {
                return pc;
            }
        }
        return EProductCategory.OTHERS;
    }
}
