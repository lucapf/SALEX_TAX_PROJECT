/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alten.saletaxproj.tax.calculator;

import com.alten.saletaxproj.model.InputItem;
import com.alten.saletaxproj.model.Item;
import com.alten.saletaxproj.Tax;
import com.alten.saletaxproj.configloader.ITaxConfiguration;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author luca
 */
public class TaxCalculator implements ITaxCalculator {

    private static final BigDecimal ONE_HUNDRED = new BigDecimal(100);
    private static final BigDecimal TWENTY = new BigDecimal(20);
    @Autowired
    Set<ITaxConfiguration> taxes;

    public void setTaxes(Set<ITaxConfiguration> taxes) {
        this.taxes = taxes;
    }

    @Override
    public Item calculate(InputItem ii) {
        Item i = new Item(ii);
        i.setFinalPrice(ii.getAmount() * ii.getBasicPrice());
        for (ITaxConfiguration configuredTax : taxes) {
            Tax t = getTax(ii, configuredTax);
            i.getTaxes().add(t);
            i.setFinalPrice(i.getFinalPrice() + t.getAmount());
            i.setTaxAmount(i.getTaxAmount() + t.getAmount());
        }
        return i;
    }

    private Tax getTax(InputItem ii, ITaxConfiguration configuredTax) {
        int taxPerc = configuredTax.getTaxValue(ii.getProductCategory(), ii.isImported());

        BigDecimal taxAmount = BigDecimal.valueOf(ii.getAmount() * ii.getBasicPrice() * taxPerc)
                .divide(ONE_HUNDRED, 2, RoundingMode.UP)
                .multiply(TWENTY).setScale(0, RoundingMode.UP)
                .divide(TWENTY, 2, RoundingMode.UP);

        return new Tax(configuredTax.getName(), taxAmount.doubleValue(), taxPerc);
    }

}
