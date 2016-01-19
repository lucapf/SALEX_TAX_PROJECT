/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alten.saletaxproj;

import com.alten.saletaxproj.model.EProductCategory;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author luca
 */
public class ShoppingBasketItemLineParser {
    private static final Pattern p  = Pattern.compile("([0-9]*)\\b([a-zA-Z\\ ]*)\\b([0-9\\.]*)\\b");
    private static final String IMPORTED="IMPORTED";
    private static final ProductCategoryDecoder PRODUCT_CATEGORY_DECODER= new ProductCategoryDecoder();
    private ShoppingBasketItemLineParser(){}
    public static InputItem parse(String line)throws ProductCategoryNotConfiguredException{
        Matcher m  = p.matcher(line);
        InputItem inputItem = null;
        if (m.find()){
            inputItem = new InputItem(Integer.parseInt(m.group(1)), m.group(2),
                    isImported(m.group(2)), getCategory(m.group(2)), 
                    Double.parseDouble(m.group(3)));
        }
        return inputItem;
 
    }
    static boolean isImported(final String  line){
       return line.toUpperCase().contains(IMPORTED);
   }
    static EProductCategory getCategory(final String name)throws ProductCategoryNotConfiguredException{
       return PRODUCT_CATEGORY_DECODER.match(name);
   }
}
