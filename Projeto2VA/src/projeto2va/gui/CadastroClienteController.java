
package projeto2va.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import projeto2va.exceptions.ElementoJaExisteException;
import projeto2va.exceptions.LoginJaExisteException;
import projeto2va.negocio.Fachada;
import projeto2va.negocio.beans.ContaCliente;



public class CadastroClienteController implements Initializable {
    
    private Fachada fachada = Fachada.getInstance();
    
    @FXML
    private Label label;

    @FXML
    private Label alertaLogin;

    @FXML
    private TextField Login;

    @FXML
    private Text text1;

    @FXML
    private TextField nome;

    @FXML
    private Text text2;

    @FXML
    private TextField senha;

    @FXML
    private Button botaoconfirma;

    @FXML
    private Label confirmacaoCadastro;

    @FXML 
    private Button voltarTela;
    
    @FXML 
    private Pane cadastroPane;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        alertaLogin.setText("");
        confirmacaoCadastro.setText("");
    } 
    
    public void cadastrarButton() {
        try {
            ContaCliente u = new ContaCliente(nome.getText(), senha.getText(), Login.getText());
            fachada.inserirUsuario(u);
            confirmacaoCadastro.setText("Cadastro realizado!!");
            alertaLogin.setText("");
        }
        catch(ElementoJaExisteException |  LoginJaExisteException ex) {
            alertaLogin.setText(ex.getMessage());
            confirmacaoCadastro.setText("");
        }
    }
    
    public void voltarTela() throws IOException{
        try {
        ScreenManager manager = ScreenManager.getInstance();
        nome.setText("");
        senha.setText("");
        Login.setText("");
        alertaLogin.setText("");
        Hortifruti_App.setStage(manager.getMainScene());
        Hortifruti_App.setTitle("E-commece hortifruti");
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
    } 
            
}
