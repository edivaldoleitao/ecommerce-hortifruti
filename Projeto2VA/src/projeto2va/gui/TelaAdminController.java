package projeto2va.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.fxml.Initializable;
import projeto2va.exceptions.ElementoJaExisteException;
import projeto2va.negocio.Fachada;
import projeto2va.negocio.beans.Produto;

public class TelaAdminController implements Initializable{

    @FXML
    private Text text1;

    @FXML
    private Button logout;

    @FXML
    private Text text3;

    @FXML
    private TextField nomeProdutoInserir;
    
    @FXML
    private TextField precoProdutoInserir;   
    
    @FXML
    private TextField tipoProdutoInserir;
            
    @FXML
    private Button buttonRemoveC;

    @FXML
    private Label AlertaInserir;

    @FXML
    private Label Alertapreco;    
    
    @FXML
    private Label AlertaRemover;
    
    @FXML
    private Text text4;

    @FXML
    private TextField nomeProduto;

    @FXML
    private Button buttonRemoveP;

    @FXML
    private Text text5;

    @FXML
    private TextField nomePreco;

    @FXML
    private TextField valorPreco;

    @FXML
    private Button buttonAlteraPreco;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AlertaInserir.setText("");
        AlertaRemover.setText("");
        Alertapreco.setText("");
    }

    public void inserirProduto() {
        try {
            float preco = Float.parseFloat(precoProdutoInserir.getText());
            Produto produto = new Produto(nomeProdutoInserir.getText(),preco,tipoProdutoInserir.getText());
           if(preco > 0) {
            Fachada.getInstance().inserirProduto(produto);
           AlertaInserir.setText("produto cadastrado!!");
           }
           else 
               AlertaInserir.setText("preco invalido!!");
        }
        catch(ElementoJaExisteException ex) {
           AlertaInserir.setText("Produto ja existe!!");
        }
        
    }
    

}
