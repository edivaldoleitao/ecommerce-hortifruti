
package projeto2va.negocio.beans;

import java.io.Serializable;
import java.util.Random;

public abstract class ContaUsuario implements Serializable {

    private String Nome;
    private String senha; 
    private String login;
    private long id;

    public ContaUsuario(String Nome,  String senha, String login) {
        this.login = login;
        this.Nome = Nome;
        this.senha = senha;
        Random rand = new Random();
        this.id = rand.nextLong();
    }
    
    public ContaUsuario(){
        
    }

    public String getNome() {
        return Nome;
    }

  
    public String getSenha() {
        return senha;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public long getId() {
        return id;
    }
    
    public boolean equals(ContaUsuario u){
        boolean b = false;
        if(u.getNome().equals(this.Nome) || u.getId() == this.id)
           b = true;
        return b;
    }
    
    
}
