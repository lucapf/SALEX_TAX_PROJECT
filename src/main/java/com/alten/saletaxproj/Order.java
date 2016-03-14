/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alten.saletaxproj;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.OutputStream;

/**
 *
 * @author palancaf
 */
public class Order {
    private BufferedReader inputFile;
    private OutputStream outputFile;

    public BufferedReader getInputFile() {
        return inputFile;
    }

    public void setInputFile(BufferedReader inputFile) {
        this.inputFile = inputFile;
    }

    public OutputStream getOutputFile() {
        return outputFile;
    }

    public void setOutputFile(OutputStream outputFile) {
        this.outputFile = outputFile;
    }
    
    
}
