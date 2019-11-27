
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
import projeto2va.negocio.beans.contaAdmin;

public class LoginAdmController implements Initializable {

    
    @FXML
    private Label alertaLogin;
    
    @FXML
    private Label alertaSenha;

    @FXML
    private TextField login;

    @FXML
    private PasswordField senha;

    @FXML
    private Button botaoconfirma;

    @FXML
    private Button botaoVoltar;
    
    @FXML
    private Text tex1;

    @FXML
    private Text text2;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        alertaLogin.setText("");
        alertaSenha.setText("");
    }    
    
    public void LoginAdmin() throws IOException {
        
        if(login.getText().equals(contaAdmin.LOGIN.getString())) {
            if(senha.getText().equals(contaAdmin.SENHA.getString())) {
                Hortifruti_App.setStage(ScreenManager.getInstance().getTelaadminscene());
                Hortifruti_App.setTitle("tela Administrador");
            }
            else{
                alertaSenha.setText("senha incorreta!!");
                alertaLogin.setText("");
            }
        }
        else{
            alertaLogin.setText("Login incorreto!!");
            alertaSenha.setText("");
        }
    }
    
    public void voltarTela() throws IOException {
        try {
             ScreenManager manager = ScreenManager.getInstance();
             login.setText("");
             senha.setText("");
             alertaLogin.setText("");
             alertaSenha.setText("");
             Hortifruti_App.setStage(manager.getMainScene());
             Hortifruti_App.setTitle("E-commece hortifruti");
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
    }

}
