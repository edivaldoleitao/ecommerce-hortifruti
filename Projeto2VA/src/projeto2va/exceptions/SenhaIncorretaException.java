
package projeto2va.exceptions;


public class SenhaIncorretaException extends Exception{
    private static final long serialVersionUID = -7096022758377417333L;
    private Object elemento;

    public SenhaIncorretaException(Object elemento) {
        super("A senha esta incorreta");
        this.elemento = elemento;
    }

    public Object getElemento() {
        return elemento;
    }

    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }
    
    
    
}
