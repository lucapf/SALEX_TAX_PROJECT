/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alten.saletaxproj.template;

import com.alten.saletaxproj.model.Invoice;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author work
 */
public class InvoiceDataProvider extends ITemplateDataProvider<Invoice>{

    public InvoiceDataProvider(Invoice t) {
        super(t);
    }

    @Override
    public Map<String, String> getBookmarks() {
        Map<String,String> m = new HashMap<>();
        m.put("salesTaxes", CurrencyFormatter.format(getType().getSalesTaxes()));
        m.put("total", CurrencyFormatter.format(getType().getTotal()));
        return m;
    }
    
}
