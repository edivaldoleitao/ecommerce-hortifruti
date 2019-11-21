
package projeto2va;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import projeto2va.exceptions.*;
import projeto2va.negocio.*;
import projeto2va.negocio.beans.ContaCliente;
import projeto2va.negocio.beans.Produto;

public class Projeto2VA {
    
    
    public static void main(String[] args) {
      /* 
        ControladorUsuario controlador = ControladorUsuario.getInstance();
       ContaCliente conta = null;
       try {
        //controlador.inserirUsuario(new ContaCliente("asa", "x1","mando"));
        conta = controlador.LoginCliente("mando", "x1");
           System.out.println(conta.getStatusBloqueio());
       }
       catch(ElementoNaoExisteException | SenhaIncorretaException | UsuarioBloqueadoException | UsuarioInexistenteException ex){
           System.out.println(ex.getMessage());
       }*/
   
      
       ControladorProdutos controlador = ControladorProdutos.getInstance();
       try {
       Produto p = new Produto("laranja", 2.0f, "fruta");
       Produto p1;
       ///controlador.removerProdutos(p);
          // List<Produto> lista = controlador.listarProdutos();
          // for(Produto p1 : lista) {
            //   System.out.println(p1.toString());
           //}
           p1 = controlador.buscarProduto("laranj");
           System.out.println(p1.toString());
       }
       catch(ElementoNaoExisteException ex) {

           System.out.println("produto cadastrado");
        }
        
    }  
    
      
    }
