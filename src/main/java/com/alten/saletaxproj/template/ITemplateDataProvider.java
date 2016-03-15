/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alten.saletaxproj.template;

import java.util.Map;

/**
 *
 * @author work
 */
public abstract class ITemplateDataProvider<T> {
    private T t;
    public ITemplateDataProvider(T t){
        this.t=t;
    }
    public T getType(){
        return t;
    }
    public abstract Map<String,String> getBookmarks();
}
