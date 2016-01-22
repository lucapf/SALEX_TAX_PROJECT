/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alten.saletaxproj.writer;

import com.alten.saletaxproj.model.Invoice;
import com.alten.saletaxproj.model.Item;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.log4j.Logger;

/**
 *
 * @author palancaf
 */
public class StreamIInvoiceWriter {

    private static final String OUTPUT_ITEM_TEMPLATE = "${amount} ${name}: ${price}\n";
    private static final String OUTPUT_INVOICE_SUMMARY_TEMPLATE = "Sales Taxes: ${salesTaxes} \n Total: ${total}";
    private static final String FIELD_REGEX = "\\$\\{([a-zA-Z0-9]*)\\}";
    private final OutputStream os;
    private final Logger logger = Logger.getLogger(StreamIInvoiceWriter.class);

    public StreamIInvoiceWriter(OutputStream os) {
        this.os = os;
    }

    public void write(Invoice invoice)throws UnsupportedFieldException, IOException{
        for (Item i : invoice.getItems()) {
            writeItem(i);
        }
        writeInvoice(invoice);

    }

    public List<String> getFields(String template) {
        Pattern p = Pattern.compile(FIELD_REGEX);
        List<String> fields = new ArrayList<>();
        Matcher match = p.matcher(template);
        while (match.find()) {
            fields.add(match.group(1));
        }
        logger.info(fields.toString());
        return fields;
    }

    private void writeItem(Item i) throws UnsupportedFieldException, IOException{
        String itemLine = OUTPUT_ITEM_TEMPLATE;
        for (String field : getFields(OUTPUT_ITEM_TEMPLATE)) {
            itemLine = itemLine.replaceAll("\\$\\{" + field + "\\}", getItemValue(field, i));
        }
       os.write(itemLine.getBytes());

    }

    private void writeInvoice(Invoice invoice) throws IOException, UnsupportedFieldException {
        String itemLine = OUTPUT_INVOICE_SUMMARY_TEMPLATE;
        for (String field:getFields(OUTPUT_INVOICE_SUMMARY_TEMPLATE)){
            itemLine = itemLine.replaceAll("\\$\\{" + field + "\\}", getInvoceValue(field, invoice));
        }
        os.write(itemLine.getBytes());
    }

    private String getItemValue(String field, Item i) throws UnsupportedFieldException {
        switch (field) {
            case "amount":
                return String.valueOf(i.getAmount());
            case "name":
                return i.getName();
            case "price":
                return String.valueOf(i.getBasicPrice());
            default:
                throw new UnsupportedFieldException(field, "item", i.toString());
        }
    }

    private String getInvoceValue(String field, Invoice invoice) throws UnsupportedFieldException{
        switch(field){
            case "salesTaxes": return String.valueOf(invoice.getSalesTaxes());
            case "total":return String.valueOf(invoice.getTotal());
            default: throw new UnsupportedFieldException(field, "invoice", invoice.toString());
        }
    }
}
