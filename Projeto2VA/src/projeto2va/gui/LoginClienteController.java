
package projeto2va.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import projeto2va.exceptions.ElementoNaoExisteException;
import projeto2va.exceptions.SenhaIncorretaException;
import projeto2va.exceptions.UsuarioBloqueadoException;
import projeto2va.exceptions.UsuarioInexistenteException;
import projeto2va.negocio.Fachada;
import projeto2va.negocio.beans.ContaCliente;


public class LoginClienteController implements Initializable {

    @FXML
    private Label label;

    @FXML
    private TextField login;

    @FXML
    private TextField senha;

    @FXML
    private Button botaoconfirma;
    
    @FXML
    private Label alertalogin; 
    
    @FXML
    private Text text1;

    @FXML
    private Text text2;
    
    @FXML
    private Label alertasenha;    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        alertalogin.setText("");
        alertasenha.setText("");
        // TODO
    }    
    
    public void logarCliente() throws IOException {
        try {
        ContaCliente c;
        c = Fachada.getInstance().loginCliente(login.getText(), senha.getText());
        Fachada.setConta(c);
        alertalogin.setText("");
        alertasenha.setText("");
        Hortifruti_App.setStage(ScreenManager.getInstance().getTelaclientescene());
        Hortifruti_App.setTitle("Tela Cliente");
        }
        catch(ElementoNaoExisteException |  UsuarioInexistenteException | UsuarioBloqueadoException ex) {
            alertalogin.setText(ex.getMessage());
        }
        catch(SenhaIncorretaException ex) {
            alertasenha.setText(ex.getMessage());
            alertalogin.setText("");
        }
    }
    
    
}
