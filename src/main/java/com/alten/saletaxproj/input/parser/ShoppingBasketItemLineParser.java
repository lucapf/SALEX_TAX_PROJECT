/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alten.saletaxproj.input.parser;

import com.alten.saletaxproj.model.InputItem;
import com.alten.saletaxproj.ProductCategoryDecoder;
import com.alten.saletaxproj.model.EProductCategory;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author luca
 */
public class ShoppingBasketItemLineParser implements IInputParser {

    private String linePattern;
    private Pattern p = null;
    private String IMPORTED;
    private ProductCategoryDecoder PRODUCT_CATEGORY_DECODER = new ProductCategoryDecoder();

    private ShoppingBasketItemLineParser() {
    }

    @Override
    public InputItem parse(String line) throws ProductCategoryNotConfiguredException {

        Matcher m = getPattern().matcher(line);
        InputItem inputItem = null;
        if (m.find()) {
            inputItem = new InputItem(Integer.parseInt(m.group(1)), m.group(2),
                    isImported(m.group(2)), getCategory(m.group(2)),
                    Double.parseDouble(m.group(3)));
        }
        return inputItem;

    }

    boolean isImported(final String line) {
        return line.toUpperCase().contains(IMPORTED);
    }

    EProductCategory getCategory(final String name) throws ProductCategoryNotConfiguredException {
        return PRODUCT_CATEGORY_DECODER.match(name);
    }

    public void setLinePattern(String linePattern) {
        this.linePattern = linePattern;
    }

    public void setIMPORTED(String IMPORTED) {
        this.IMPORTED = IMPORTED;
    }

    public void setPRODUCT_CATEGORY_DECODER(ProductCategoryDecoder PRODUCT_CATEGORY_DECODER) {
        this.PRODUCT_CATEGORY_DECODER = PRODUCT_CATEGORY_DECODER;
    }

    private Pattern getPattern() {
        if (p == null) {
            p = Pattern.compile(linePattern);
        }
        return p;
    }

}
