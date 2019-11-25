package projeto2va.gui;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

 
public class MainScreenController {

    @FXML
    private Button tela1;

    @FXML
    private Button tela2;

    @FXML
    private Button tela3;
    
    @FXML
    private Pane mainPane;
    

    
    public void telaCadastro() throws IOException {
       ScreenManager gerenciadoraTelas = ScreenManager.getInstance();
       Hortifruti_App.setStage(gerenciadoraTelas.getCadastroclientescene());
       Hortifruti_App.setTitle("cadastro cliente");
    }
    
    public void telaLoginAdmin() throws IOException {
        ScreenManager gerenciadoraTelas = ScreenManager.getInstance();
        Hortifruti_App.setStage(gerenciadoraTelas.getLoginAdminScene());
        Hortifruti_App.setTitle("Login Administrador");
    }
    
    public void telaLoginCliente() throws IOException {
       ScreenManager gerenciadoraTelas = ScreenManager.getInstance();
       Hortifruti_App.setStage(gerenciadoraTelas.getLoginclientescene());
       Hortifruti_App.setTitle("Login Cliente"); 
    }
    
}

