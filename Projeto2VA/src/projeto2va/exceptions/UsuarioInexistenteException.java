
package projeto2va.exceptions;

import projeto2va.negocio.beans.ContaUsuario;


public class UsuarioInexistenteException extends Exception{

    private Object conta;

    public UsuarioInexistenteException(Object conta) {
        super("usuaario nao existe no repositorio");
        this.conta = conta;
    }

    public Object getConta() {
       return  conta;
    }

    public void setConta(Object conta) {
        this.conta = conta;
    }
    
    
    
    
}
