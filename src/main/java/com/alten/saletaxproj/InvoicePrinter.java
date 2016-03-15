/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alten.saletaxproj;

import com.alten.saletaxproj.model.Invoice;
import com.alten.saletaxproj.model.Item;
import com.alten.saletaxproj.template.ITemplateDataProvider;
import com.alten.saletaxproj.template.TemplateDataProviderFactory;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.log4j.Logger;

/**
 *
 * @author palancaf
 */
class InvoicePrinter {

    private static final Logger LOGGER = Logger.getLogger(InvoicePrinter.class);

    private static PrintWriter ps = new PrintWriter(new OutputStreamWriter(System.out));

    //:amount :name :basicPrice :finalPrice :taxAmount
    private static final String PATTERN_ITEM = ":amount :name: :finalPrice\n";
    private static final String FOOTER_PATTERN = "Sales Taxes: :salesTaxes \nTotal: :total";
    private static final String FIELDS_PATTERN = ":(\\w+)";

    private InvoicePrinter() {
    }

    static void print(Invoice invoice) throws InvoicePrinterException {
        Item item;
        while ((item = invoice.getItem()) != null) {
            print(item);
        }
        print(TemplateDataProviderFactory.getProvider(invoice), FOOTER_PATTERN);
        ps.flush();
        ps.close();
    }

    static void print(Item item) throws InvoicePrinterException {
        LOGGER.debug("stampo item: " + item.toString());
        print(TemplateDataProviderFactory.getProvider(item), PATTERN_ITEM);
    }

    private static void print(ITemplateDataProvider templateDataProvider, String pattern) throws InvoicePrinterException {
        if (templateDataProvider == null) {
            throw new InvoicePrinterException("impossibile determinare il provider per l'ogetto");
        }
        String outputItem = pattern;
        Map<String, String> bookmarks = templateDataProvider.getBookmarks();
        LOGGER.debug("bookmarks : " + bookmarks.toString());
        for (String field : getFields(pattern)) {
            outputItem = outputItem.replace(":" + field, bookmarks.get(field));

        }
        ps.print(outputItem);

    }

    static List<String> getFields(final String pattern) {
        List<String> fields = new ArrayList<>();
        Pattern p = Pattern.compile(FIELDS_PATTERN);
        Matcher m = p.matcher(pattern);
        while (m.find()) {
            fields.add(m.group(1));
        }
        return fields;
    }

    public static void setPrintStream(PrintWriter ps1) {
        ps = ps1;
    }
}
