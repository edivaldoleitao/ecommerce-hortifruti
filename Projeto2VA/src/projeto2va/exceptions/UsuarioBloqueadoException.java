/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto2va.exceptions;

public class UsuarioBloqueadoException extends Exception{
    private static final long serialVersionUID = -8886022758377417333L;
    private Object elemento;

    public UsuarioBloqueadoException(Object elemento) {
        super("Cliente bloqueado!!");
        this.elemento = elemento;
    }

    public Object getElemento() {
        return elemento;
    }

    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }    
}
