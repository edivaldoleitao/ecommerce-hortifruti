
package projeto2va.negocio;
import java.util.ArrayList;
import projeto2va.dados.*;
import java.util.List;
import projeto2va.exceptions.*;
import projeto2va.negocio.beans.*;

public class ControladorProdutos {
    private static ControladorProdutos instance;
    private IRepositorioGenerico<Produto> repositorioProdutos;
    
    
    public ControladorProdutos() {
        this.repositorioProdutos = new RepositorioGenerico<>("Produtos.dat");
    }
   
    public static ControladorProdutos getInstance() {
        if(instance == null) {
            instance = new ControladorProdutos();
        }
        return instance;
    }
    
    public void inserirProdutos(Produto produto) throws ElementoJaExisteException{
        if(produto!= null) {
            List<Produto> lista = this.repositorioProdutos.listar();
            boolean existe = false;
            for(Produto p : lista) {
                if(p.getNome().equals(produto.getNome()))
                    existe = true;
            }
            if(!existe)
                this.repositorioProdutos.inserir(produto);
            else 
                throw new ElementoJaExisteException(produto);
        }
    }
    
    public void removerProdutos(Produto produto) throws ElementoNaoExisteException{
        if(produto!= null){
            Produto p = null; 
            for(Produto p1 : this.repositorioProdutos.listar()) {
                if(p1.getNome().equals(produto.getNome()) && p1.getPreco() == produto.getPreco())
                    p = p1;
            }
            this.repositorioProdutos.remover(p);
        }
    }
  
    
    public void alterarPreco(Produto produto, float preco) throws ElementoNaoExisteException {
        if(produto!= null) {
            produto.setPreco(preco);
            this.repositorioProdutos.atualizar(produto);
        }
    }
    
    public Produto buscarProduto(String nome) throws ElementoNaoExisteException{
        List<Produto> lista = this.repositorioProdutos.listar();
        if(nome!= null) {
            for(Produto p : lista) {
                if(p.getNome().equals(nome)) 
                    return p;  
            }
           throw new ElementoNaoExisteException(nome); 
        }
        throw new ElementoNaoExisteException(nome);     
    }
    
    public ArrayList<Produto> listarPorTipo(String tipo) {
        ArrayList<Produto> lista = new ArrayList<>();
        if(tipo!= null) {
            for(Produto p : this.repositorioProdutos.listar()) {
                if(p.getTipo().equals(tipo))
                    lista.add(p);
            }
        }
        return lista;
    }
    
    public List<Produto> listarProdutos() {
        return this.repositorioProdutos.listar();
    }
    
    
}
