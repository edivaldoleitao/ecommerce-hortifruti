
package projeto2va.exceptions;




public class UsuarioInexistenteException extends Exception{

    private Object conta;

    public UsuarioInexistenteException(Object conta) {
        super("usuario nao existe !!");
        this.conta = conta;
    }

    public Object getConta() {
       return  conta;
    }

    public void setConta(Object conta) {
        this.conta = conta;
    }
    
    
    
    
}
