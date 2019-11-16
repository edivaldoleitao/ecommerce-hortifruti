/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto2va.negocio.beans;

import java.io.Serializable;


public enum contaAdmin implements Serializable{
    LOGIN("admin"),
    SENHA("123");
    
    private String s;

    contaAdmin(String s) {
        this.s = s;
    }
    
    public String getString() {
        return this.s;
    }
}
