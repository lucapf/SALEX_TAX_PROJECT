/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alten.saletaxproj.writer;

import com.alten.saletaxproj.model.Invoice;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author palancaf
 */
public class StreamIInvoiceWriter {
    private static final String OUTPUT_ITEM_TEMPLATE="${amount} ${name}: ${price}";
    private static final String OUTPUT_INVOICE_SUMMARY_TEMPLATE="Sales Taxes: ${salesTaxes} \n Total: ${total}";
    private static final String FIELD_REGEX="$\\{(.*)\\}";
    private final OutputStream os ;
    
    public StreamIInvoiceWriter(OutputStream os){
        this.os=os;
    }
    public void write(Invoice invoice){
        
    }
    public List<String> getFields(String template){
        Pattern p = Pattern.compile(FIELD_REGEX);
        List<String> fields = new ArrayList<>();
        Matcher match = p.matcher(template);
        while (match.find()){
            fields.add(match.group(1));
        }
        return 
    }
}
