
package projeto2va.negocio;
import java.util.ArrayList;
import java.util.List;
import projeto2va.exceptions.*;
import projeto2va.negocio.beans.*;

public class Fachada {
    
    private static ContaCliente conta ;
    private static Fachada instance;
    private ControladorUsuario controladorusuario;
    private ControladorProdutos controladorprodutos;
    private ControladorNotaFiscal controladornotafiscal;
    
    public static Fachada getInstance() {
        if(instance == null) {
            instance = new Fachada();
        }
        return instance;
    }

    private Fachada () {
        this.controladornotafiscal = ControladorNotaFiscal.getInstance();
        this.controladorprodutos = ControladorProdutos.getInstance();
        this.controladorusuario = ControladorUsuario.getInstance();
    }
    
    public  ContaCliente getConta() throws ElementoNaoExisteException {
        if(conta!= null)
            return conta;
        else 
            throw new ElementoNaoExisteException(conta);
    }
    
    public  void setConta(ContaCliente c) {
        if(c!= null)
            conta = c;
    }
    
    public void inserirUsuario(ContaCliente conta) throws LoginJaExisteException, ElementoJaExisteException {
        controladorusuario.inserirUsuario(conta);
    }
    
    public ContaCliente loginCliente(String login, String senha) throws ElementoNaoExisteException, SenhaIncorretaException, UsuarioInexistenteException, UsuarioBloqueadoException {
       return  controladorusuario.LoginCliente(login, senha);
    }
    
    public void alterarSenha(ContaCliente conta,String senha) throws ElementoNaoExisteException {
        controladorusuario.alterarSenha(conta, senha);
    }

    public void bloquearCliente(ContaCliente conta) throws ElementoNaoExisteException {
        controladorusuario.bloquearUsuario(conta);
    }
    
    public void desbloquearCliente(ContaCliente conta) throws ElementoNaoExisteException{
        controladorusuario.desbloquearUsuario(conta);
    }
    
    public ArrayList<ContaCliente> listarClientes() throws ElementoNaoExisteException {
        return controladorusuario.listarClientes();
    }
    
    public void inserirProduto(Produto produto) throws ElementoJaExisteException {
        controladorprodutos.inserirProdutos(produto);
    }
    
    public void removerProduto(Produto produto) throws ElementoNaoExisteException {
        controladorprodutos.removerProdutos(produto);
    }
    
    public void alterarPreco(Produto produto, float preco) throws ElementoNaoExisteException {
        controladorprodutos.alterarPreco(produto, preco);
    }
    
    public Produto buscarProduto(String nome) throws ElementoNaoExisteException {
        return controladorprodutos.buscarProduto(nome);
    }
    
    public ArrayList<Produto> listarPorTipo(String tipo) {
        return controladorprodutos.listarPorTipo(tipo);
    }
    
    public List<Produto> listarProdutos() {
        return controladorprodutos.listarProdutos();
    }
    
    public void inserirNotaFiscal(NotaFiscal nota) {
        controladornotafiscal.inserirNotaFiscal(nota);
    }
    
    public ArrayList<NotaFiscal> listarPorId(long id) throws ElementoNaoExisteException {
        return controladornotafiscal.listarPorId(id);
    }
    
    public ArrayList<Produto> recomendarProdutos(long id) throws ElementoNaoExisteException {
        return controladornotafiscal.recomendarProdutos(id);
    }
    
    public ContaCliente buscarCliente(String login) throws ElementoNaoExisteException {
        return controladorusuario.buscarCliente(login);
    }
}
