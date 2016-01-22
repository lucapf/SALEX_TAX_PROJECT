/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alten.saletaxproj.writer;

import java.io.IOException;
import java.io.OutputStream;

/**
 *
 * @author palancaf
 */
public class StringOutputStream extends OutputStream {
    StringBuilder sb = new StringBuilder();
    @Override
    public void write(int b) throws IOException {
        sb.append((char) b);
    }
    public String toString() {
        return sb.toString();
    }
}
