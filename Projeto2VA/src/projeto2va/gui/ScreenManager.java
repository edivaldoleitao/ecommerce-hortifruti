


package projeto2va.gui;
import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

@SuppressWarnings("all")

public class ScreenManager {

    private static  ScreenManager instance;
    private Stage stage;
    
    private Scene mainScene;
    private MainScreenController mainscreencontroller;
    
    private Scene cadastroclientescene;
    private CadastroClienteController cadastroclientecontroller;
    
    private LoginAdmController loginadmincontroller;
    private Scene loginadminscene;
    
    private TelaAdminController telaadmincontroller;
    private Scene telaadminscene;

    private LoginClienteController loginclientecontroller;
    private Scene loginclientescene;
    
    private TelaClienteController telaclientecontroller;
    private Scene telaclientescene;
    
    
    
    private ScreenManager()  {
       this.initialize();
   } 
   
   public static ScreenManager getInstance()  {
       if(instance == null) {
           instance = new ScreenManager();
       }
       return instance;
   }
   
   private void initialize()  {
       try {
           FXMLLoader fxmlloader = new FXMLLoader();
           AnchorPane mainPane = fxmlloader.load(getClass().getResource("MainScreen.fxml").openStream());
           this.mainScene = new Scene(mainPane);
           this.mainscreencontroller = (MainScreenController) fxmlloader.getController();
           
           fxmlloader = new FXMLLoader();
           AnchorPane cadastroPane = fxmlloader.load(getClass().getResource("CadastroCliente.fxml").openStream());
           this.cadastroclientescene = new Scene(cadastroPane);
           this.cadastroclientecontroller = (CadastroClienteController) fxmlloader.getController();
           
           fxmlloader = new FXMLLoader();
           AnchorPane loginadminPane = fxmlloader.load(getClass().getResource("LoginAdm.fxml").openStream());
           this.loginadminscene = new Scene(loginadminPane);
           this.loginadmincontroller = (LoginAdmController) fxmlloader.getController();
           
           fxmlloader = new FXMLLoader();
           AnchorPane telaadminPane = fxmlloader.load(getClass().getResource("TelaAdmin.fxml").openStream());
           this.telaadminscene = new Scene(telaadminPane);
           this.telaadmincontroller = (TelaAdminController) fxmlloader.getController();
           
           fxmlloader = new FXMLLoader();
           AnchorPane LoginclientePane = fxmlloader.load(getClass().getResource("LoginCliente.fxml").openStream());
           this.loginclientescene = new Scene(LoginclientePane);
           this.loginclientecontroller = (LoginClienteController) fxmlloader.getController();     
     
           fxmlloader = new FXMLLoader();
           AnchorPane telaclientePane = fxmlloader.load(getClass().getResource("TelaCliente.fxml").openStream());
           this.telaclientescene = new Scene(telaclientePane);
           this.telaclientecontroller = (TelaClienteController) fxmlloader.getController();   
       
       }
       catch(IOException ex) {
           ex.printStackTrace();
       }
  
   }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Scene getMainScene() {
        return mainScene;
    }

    public MainScreenController getMainscreencontroller() {
        return mainscreencontroller;
    }

    public Scene getCadastroclientescene() {
        return cadastroclientescene;
    }

    public CadastroClienteController getCadastroclientecontroller() {
        return cadastroclientecontroller;
    }
   
    public Scene getLoginAdminScene() {
        return loginadminscene;
    }
   
    public LoginAdmController getLoginAdmController() {
        return loginadmincontroller;
    }

    public Scene getTelaadminscene() {
        return telaadminscene;
    }


    public TelaAdminController getTelaadmincontroller() {
        return telaadmincontroller;
    }

    public LoginClienteController getLoginclientecontroller() {
        return loginclientecontroller;
    }

    public Scene getLoginclientescene() {
        return loginclientescene;
    }

    public TelaClienteController getTelaclientecontroller() {
        return telaclientecontroller;
    }

    public Scene getTelaclientescene() {
        return telaclientescene;
    }



    
    
   
}
