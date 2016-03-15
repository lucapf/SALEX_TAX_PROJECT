/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alten.saletaxproj.template;

import com.alten.saletaxproj.model.Item;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author work
 */
public class InvoiceItemTemplateDataProvider extends ITemplateDataProvider<Item>{

    public InvoiceItemTemplateDataProvider(Item t) {
        super(t);
    }

    @Override
    public Map<String, String> getBookmarks() {
      Map<String,String> m = new HashMap<>();
      m.put("amount", CurrencyFormatter.format(getType().getAmount()));
      m.put("name", getType().getName());
      m.put("basicPrice", CurrencyFormatter.format(getType().getBasicPrice()));
      m.put("finalPrice", CurrencyFormatter.format(getType().getFinalPrice()));
      m.put("taxAmount", CurrencyFormatter.format(getType().getTaxAmount()));
      return m;
    }
    
}
