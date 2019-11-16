
package projeto2va.negocio.beans;



public class ContaCliente extends ContaUsuario{
    

    
    private boolean bloqueio;
    
    public ContaCliente(String Nome, String senha, String login) {
        super(Nome, senha, login);
        this.bloqueio = false;
    }


    public boolean equals(ContaCliente c) {
        boolean b = false;
        if(c.getNome().equals(this.getNome()) && c.getId() == this.getId())
            b =true;
        return b;
    }

    public boolean getStatusBloqueio() {
        return this.bloqueio;
    }
    
    public void setBloqueio(boolean bloqueio) {
        this.bloqueio = bloqueio;
    }
}
