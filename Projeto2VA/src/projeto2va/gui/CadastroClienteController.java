
package projeto2va.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import projeto2va.exceptions.ElementoJaExisteException;
import projeto2va.exceptions.LoginJaExisteException;
import projeto2va.negocio.ControladorUsuario;
import projeto2va.negocio.beans.ContaCliente;
import projeto2va.negocio.beans.ContaUsuario;


public class CadastroClienteController implements Initializable {
    
    private ControladorUsuario controlador = ControladorUsuario.getInstance();
    
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        alertaLogin.setText("");
        confirmacaoCadastro.setText("");
    } 
    
    public void cadastrarButton() {
        try {
            ContaUsuario u = new ContaCliente(nome.getText(), senha.getText(), Login.getText());
            controlador.inserirUsuario(u);
            confirmacaoCadastro.setText("Cadastro realizado!!");
            alertaLogin.setText("");
        }
        catch(ElementoJaExisteException |  LoginJaExisteException ex) {
            alertaLogin.setText(ex.getMessage());
            confirmacaoCadastro.setText("");
        }
    }
    
}
