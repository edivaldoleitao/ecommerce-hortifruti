
package projeto2va.gui;


import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Hortifruti_App extends Application   {
    private static Stage stagePrimary;
    
    @Override
    public void start(Stage stage) throws IOException {
        stagePrimary = stage;
        stage.setScene(ScreenManager.getInstance().getMainScene());
        stage.setTitle("E-commece hortifruti");
        ScreenManager.getInstance().setStage(stage);
        stage.show();
    }

    public static void setStage(Scene tela) throws IOException{
        stagePrimary.setScene(tela);
    }
        
    public static void setTitle(String title) {
        stagePrimary.setTitle(title);
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
        
}
