
package projeto2va.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    
    private Fachada fachada = Fachada.getInstance();
    private ArrayList<Produto> lista  = new ArrayList<>();
    private ArrayList<Produto> listacarrinho2 =  new ArrayList<>();
    private String s = "";
    
    @Override   
    public void initialize(URL url, ResourceBundle rb) {
     alertacompra.setText("");  
    }    
    
    public void adicionaProdutos() throws ElementoNaoExisteException {
        try{
            Produto produto = fachada.buscarProduto(pesquisarhortalica.getText());
            int qtd = Integer.parseInt(quantidade.getText());
            if(qtd > 0 ) {
                for(int i = 0; i < qtd; i++) {
                    lista.add(produto);
                }
                for(int i = 0; i < lista.size(); i++) {
                    if(!listacarrinho2.contains(lista.get(i)))
                        listacarrinho2.add(lista.get(i));
                }
                for(Produto p : listacarrinho2) {
                    s += p.getNome() + "\n";            
                }
                itenscomprados.setText(s);
                s = "";
            }
            else 
                alertacompra.setText("quantidade invalida!!");
        }
        catch(ElementoNaoExisteException e) {
            alertacompra.setText("Este produto nao existe!");
        }   
    }

    public void confirmarCompras() throws ElementoNaoExisteException {
        NotaFiscal nota = new NotaFiscal(fachada.getConta().getId());
        for(Produto p : this.lista) {
            nota.NotaAdicionaProduto(p);
        }
        fachada.inserirNotaFiscal(nota);
        itenscomprados.setText(nota.toString());
    }
    
    
    
    
    
    
    public void setLabel(String nome) {
        this.labelc.setText(nome);
    }
}
