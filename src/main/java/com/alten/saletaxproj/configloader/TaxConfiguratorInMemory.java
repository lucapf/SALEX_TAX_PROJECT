/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alten.saletaxproj.configloader;

import com.alten.saletaxproj.model.EProductCategory;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author luca
 */
public class TaxConfiguratorInMemory  implements ITaxConfiguration{
    private String name;
    private static final Integer ONE_HUNDRED=100;
    private Map<EProductCategory,Integer> hmImported;
    private Map<EProductCategory,Integer> hmNotImported;
    public TaxConfiguratorInMemory(){}
    
   

   
    @Override
    public Integer getTaxValue(EProductCategory ekop,boolean imported){
        Map<EProductCategory,Integer> currentItemSet=imported?hmImported:hmNotImported;
        return currentItemSet.get(ekop)==null
                ?currentItemSet.get(EProductCategory.OTHERS)
                :currentItemSet.get(ekop);
    }
    @Override
    public double getTaxPercValue(EProductCategory ekop, boolean imported){
        return getTaxValue(ekop, imported).doubleValue()/ONE_HUNDRED;
    }

    /**
     * @param hmImported the hmImported to set
     */
    public void setHmImported(Map<EProductCategory,Integer> hmImported) {
        this.hmImported = hmImported;
    }

    /**
     * @param hmNotImported the hmNotImported to set
     */
    public void setHmNotImported(Map<EProductCategory,Integer> hmNotImported) {
        this.hmNotImported = hmNotImported;
    }

    /**
     * @return the name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    
   
    
}
