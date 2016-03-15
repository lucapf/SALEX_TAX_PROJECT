/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alten.saletaxproj.template;

import com.alten.saletaxproj.model.Invoice;
import com.alten.saletaxproj.model.Item;
import java.util.Map;

/**
 *
 * @author work
 */
public class TemplateDataProviderFactory {
    public static ITemplateDataProvider getProvider(Item t){
     return  new InvoiceItemTemplateDataProvider(t);
    }
    public static ITemplateDataProvider getProvider(Invoice i){
        return new InvoiceDataProvider(i);
    }
}
