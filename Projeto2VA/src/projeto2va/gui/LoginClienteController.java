
package projeto2va.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
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
    private PasswordField senha;

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
    
    public ContaCliente logarCliente() throws IOException, ElementoNaoExisteException {
        ContaCliente conta = null;
        try {
        ContaCliente c1;
        c1 = Fachada.getInstance().loginCliente(login.getText(), senha.getText());
        Fachada.getInstance().setConta(c1);
        conta = c1;
        alertalogin.setText("");
        alertasenha.setText("");
        if(c1!= null) {
        Hortifruti_App.setStage(ScreenManager.getInstance().getTelaclientescene());
        ScreenManager.getInstance().getTelaclientecontroller().setLabel("Bem-Vindo " + c1.getNome() + "!!");
        Hortifruti_App.setTitle("Tela Cliente");
        }
        }
        catch(ElementoNaoExisteException |  UsuarioInexistenteException | UsuarioBloqueadoException ex) {
            alertalogin.setText(ex.getMessage());
        }
        catch(SenhaIncorretaException ex) {
            alertasenha.setText(ex.getMessage());
            alertalogin.setText("");
        }
        if(conta!= null)
            return conta;
        else 
            throw  new ElementoNaoExisteException(conta);
    }
    
        public void voltarTela() throws IOException {
        try {
             ScreenManager manager = ScreenManager.getInstance();
             login.setText("");
             senha.setText("");
             alertalogin.setText("");
             alertasenha.setText("");
             Hortifruti_App.setStage(manager.getMainScene());
             Hortifruti_App.setTitle("E-commece hortifruti");
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
    }
    
    
}
