
package projeto2va.negocio;

import projeto2va.dados.IRepositorioGenerico;
import projeto2va.dados.RepositorioGenerico;
import java.util.List;
import projeto2va.exceptions.ElementoJaExisteException;
import projeto2va.exceptions.ElementoNaoExisteException;
import projeto2va.exceptions.LoginJaExisteException;
import projeto2va.exceptions.SenhaIncorretaException;
import projeto2va.exceptions.UsuarioInexistenteException;
import projeto2va.negocio.beans.ContaCliente;
import projeto2va.negocio.beans.ContaUsuario;

public class ControladorUsuario {
    
    
    private static ControladorUsuario instance;
    private IRepositorioGenerico<ContaUsuario> repositorioUsuarios;  
    
    private ControladorUsuario() {
        this.repositorioUsuarios = new RepositorioGenerico<>("usuarios.dat");
    }
    
    public static ControladorUsuario getInstance() {
        if(instance == null) {
            instance = new ControladorUsuario();
        }
       return instance;
    }
    
    public void inserirUsuario(ContaUsuario usuario) throws LoginJaExisteException, ElementoJaExisteException {
        if(usuario != null) {
            boolean teste = true;
            List<ContaUsuario> lista = this.repositorioUsuarios.listar();
            
            for(ContaUsuario u : lista) {
                if(u.getLogin().equals(usuario.getLogin()))
                    teste = false;
            }
            if(teste)
                this.repositorioUsuarios.inserir(usuario);
            else 
                throw new LoginJaExisteException(usuario);
        }    
    }
  
    public void removerUsuario(ContaUsuario usuario) throws ElementoNaoExisteException{
        if(usuario != null){
            if(usuario instanceof ContaCliente ) {
                this.repositorioUsuarios.remover(usuario);
            }
        }
    }
    
    //metodo  login
    public ContaCliente LoginCliente(String login,String senha) throws ElementoNaoExisteException, SenhaIncorretaException, UsuarioInexistenteException{
        
        List<ContaUsuario> lista = this.repositorioUsuarios.listar();
        if(login!= null && senha!= null) {
            for(ContaUsuario conta : lista) {
                if(conta.getLogin().equals(login) ) {
                    if( conta.getSenha().equals(senha)) {
                        return (ContaCliente) conta;
                    }
                    else {
                        throw new SenhaIncorretaException(conta);
                    }
                }   
            }
        }
        throw new UsuarioInexistenteException(login);
    }
    
    //metodo client
    public void alterarSenha(ContaUsuario conta ,String senha) {
        if(conta!= null && senha!= null) {
            conta.setSenha(senha);
        }
    } 
    // metodo do admin
    public void bloquearUsuario(ContaCliente conta) {
        List<ContaUsuario> lista = this.repositorioUsuarios.listar();
        if(conta!= null) {
            if(lista.contains(conta))
              conta.setBloqueio(true);
        }
    }
    // metodo do admin
    public void desbloquearUsuario(ContaCliente conta) {
        List<ContaUsuario> lista = this.repositorioUsuarios.listar();
        if(conta!= null) {
            if(lista.contains(conta))
              conta.setBloqueio(false);
        }
    }
    
    public void atualizarUsuario(ContaCliente conta) throws ElementoNaoExisteException{
        this.repositorioUsuarios.atualizar(conta);
    }
////////////////////////////////////////////////////////////////////////////qlklklkllklklklklklk
    public ContaCliente buscarPorId(double id) {
        ContaCliente ContaCliente;
        return  ContaCliente = null;
    }


}
