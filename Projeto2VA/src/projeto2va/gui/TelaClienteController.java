
package projeto2va.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import projeto2va.exceptions.ElementoNaoExisteException;
import projeto2va.negocio.Fachada;
import projeto2va.negocio.beans.*;
import projeto2va.negocio.beans.NotaFiscal;


public class TelaClienteController implements Initializable {

    @FXML
    private TextField pesquisarhortalica;

    @FXML
    private TextField quantidade;

    @FXML
    private Label alertacompra;
    
    @FXML
    private Label labelc;
    
    @FXML
    private TextArea itenscomprados;
    
    @FXML
    private ComboBox combobox;
    
    @FXML
    private Label totalcompras;
    
    @FXML
    private TextArea produtospec;
    
    private Fachada fachada = Fachada.getInstance();
    private ArrayList<Produto> lista  = new ArrayList<>();
    private ArrayList<Produto> listacarrinho2 =  new ArrayList<>();
    private String s = "";
    private List<Produto> produtoslista;
    private float total ;
    
    @Override   
    public void initialize(URL url, ResourceBundle rb) {
     alertacompra.setText("");
     totalcompras.setText("");
     produtoslista = fachada.listarProdutos();
     for(Produto p : produtoslista) {
         combobox.getItems().add(p.getNome());
        }
    }    
    // i
    public void adicionaProdutos() throws ElementoNaoExisteException {
        try{
            Produto produto = fachada.buscarProduto(pesquisarhortalica.getText());
            total = 0;
            int qtd = Integer.parseInt(quantidade.getText());
            
            if(qtd > 0 ) {
                for(int i = 0; i < qtd; i++) {
                    
                    lista.add(produto);
                }
                for(int i = 0; i < lista.size(); i++) {
                    if(!listacarrinho2.contains(lista.get(i)))
                        listacarrinho2.add(lista.get(i));
                }
                for(Produto p : lista) {
                    s += p.getNome() + "\n" ; 
                    total += p.getPreco();
                }
                itenscomprados.setText(s);
                totalcompras.setText(total + "Reais");
                s = "";
                alertacompra.setText("Produto adicionado!!");
            }
            else 
                alertacompra.setText("quantidade invalida!!");
        }
        catch(ElementoNaoExisteException e) {
            alertacompra.setText("Este produto nao existe!");
        }   
    }
    
    public void removerProdutos() throws ElementoNaoExisteException {
        try{
            Produto produto = fachada.buscarProduto(pesquisarhortalica.getText());
            
            int qtd = Integer.parseInt(quantidade.getText());
            
            if(qtd > 0 ) {
                for(int i = 0; i < qtd; i++) {
                    if(total > 0)
                    total = total - produto.getPreco();
                    lista.remove(produto);
                }
                for(Produto p : lista) {
                    s += p.getNome() + "\n" ; 
                    
                }
                itenscomprados.setText(s);
                totalcompras.setText(total + "Reais");
                s = "";
                alertacompra.setText("Produto removido!!");
            }
            else 
                alertacompra.setText("quantidade invalida!!");
        }
        catch(ElementoNaoExisteException e) {
            alertacompra.setText("Este produto nao existe!");
        }   
    }    

    public void confirmarCompras() throws ElementoNaoExisteException, IOException {
        NotaFiscal nota = new NotaFiscal(fachada.getConta().getId());
       if(!lista.isEmpty()) {
        for(Produto p : this.lista) {
            nota.NotaAdicionaProduto(p);
        }
        fachada.inserirNotaFiscal(nota);
        Hortifruti_App.setStage(ScreenManager.getInstance().getTelanotascene());
        ScreenManager.getInstance().getTelanotacontroller().setNota(nota.toString());
        Hortifruti_App.setTitle("Nota Fiscal");
       }
       else 
           alertacompra.setText("nao existem itens no carrinho!");
        
    }
    
    public void adicionacombobox() throws ElementoNaoExisteException {
       pesquisarhortalica.setText(combobox.getValue().toString());
       quantidade.setText("1");
       produtospec.setText(fachada.buscarProduto(combobox.getValue().toString()).toString());
    }
    
    public void setLabel(String nome) {
        this.labelc.setText(nome);
    }

        public void voltarTela() throws IOException {
        try {
             ScreenManager manager = ScreenManager.getInstance();
             labelc.setText("");
             alertacompra.setText("");
             Hortifruti_App.setStage(manager.getLoginclientescene());
             Hortifruti_App.setTitle("Login Cliente");
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
    }

}
