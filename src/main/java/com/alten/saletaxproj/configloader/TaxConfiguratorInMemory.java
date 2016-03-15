/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alten.saletaxproj.configLoader;

import com.alten.saletaxproj.model.EProductCategory;
import java.util.HashMap;

/**
 *
 * @author luca
 */
public class TaxConfiguratorInMemory  implements ITaxConfiguration{
    private String name;
    private final Integer ONE_THOUSAND=100;
    private HashMap<EProductCategory,Integer> hmImported;
    private HashMap<EProductCategory,Integer> hmNotImported;
    public TaxConfiguratorInMemory(){}
    
    @Override
    public void load() throws TaxConfiguraitonException {
    }

   
    @Override
    public Integer getTaxValue(EProductCategory ekop,boolean imported){
        HashMap<EProductCategory,Integer> currentItemSet=imported?hmImported:hmNotImported;
        return currentItemSet.get(ekop)==null
                ?currentItemSet.get(EProductCategory.OTHERS)
                :currentItemSet.get(ekop);
    }
    @Override
    public double getTaxPercValue(EProductCategory ekop, boolean imported){
        return getTaxValue(ekop, imported).doubleValue()/ONE_THOUSAND;
    }

    /**
     * @param hmImported the hmImported to set
     */
    public void setHmImported(HashMap<EProductCategory,Integer> hmImported) {
        this.hmImported = hmImported;
    }

    /**
     * @param hmNotImported the hmNotImported to set
     */
    public void setHmNotImported(HashMap<EProductCategory,Integer> hmNotImported) {
        this.hmNotImported = hmNotImported;
    }

    /**
     * @return the name
     */
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
