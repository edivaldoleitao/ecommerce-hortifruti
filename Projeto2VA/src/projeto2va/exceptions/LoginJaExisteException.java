/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto2va.exceptions;


public class LoginJaExisteException extends Exception{
    private static final long serialVersionUID = 4868332235826988555L;
    private Object elemento;
    
    public LoginJaExisteException(Object obj) {
        super("Este Login ja foi cadastrado!");
        this.elemento = obj;        
    }
    
    public Object getElemento() {
        return elemento;
    }

    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }
    
}
