
package projeto2va.negocio;
import projeto2va.dados.*;
import projeto2va.negocio.beans.NotaFiscal;
import java.time.*;
import java.util.ArrayList;
import projeto2va.exceptions.*;
import projeto2va.negocio.beans.Produto;

public class ControladorNotaFiscal {
    private static ControladorNotaFiscal instance;
    private IRepositorioGenerico<NotaFiscal> repositorioNotaFiscal;
    
    public ControladorNotaFiscal() {
        this.repositorioNotaFiscal = new RepositorioGenerico<>("NotaFical.dat");
    }
    
    public static ControladorNotaFiscal getInstance() {
        if(instance == null) {
            instance = new ControladorNotaFiscal();      
        }
        return instance;
    }
    
    public void inserirNotaFiscal(NotaFiscal nota) {
        this.repositorioNotaFiscal.inserirR(nota);
    }
    
    public ArrayList<NotaFiscal> listarPorId(String id) throws ElementoNaoExisteException{
        if(id!= null) {
            ArrayList<NotaFiscal> lista = new ArrayList<>();
            for(NotaFiscal nota : this.repositorioNotaFiscal.listar()) {
                if(nota.getIdCliente().equals(id))
                    lista.add(nota);
            }
            if(lista == null)
                throw new ElementoNaoExisteException(id);
            else 
               return lista;
        }
        throw new ElementoNaoExisteException(id);
    }
 
    public ArrayList<Produto> recomendarProdutos(String id) throws ElementoNaoExisteException {
        ArrayList<NotaFiscal> lista = this.listarPorId(id);
        ArrayList<Produto>listaP  = new ArrayList<>();
        if(lista!= null && !lista.isEmpty()) {
            NotaFiscal nota = lista.get(lista.size() - 1);
            for(Produto p : nota.getCompras()) {
                if(!listaP.contains(p))
                    listaP.add(p);
            }
            return listaP;
        }
        throw new ElementoNaoExisteException(id);
    }
    
    
}
