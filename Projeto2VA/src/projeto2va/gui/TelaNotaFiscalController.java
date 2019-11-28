
package projeto2va.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;


public class TelaNotaFiscalController implements Initializable {

    @FXML
    private TextArea nota;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    public void setNota(String nota) {
        this.nota.setText(nota);
    }
    
    public void voltarTela() throws IOException {
        try {
             ScreenManager manager = ScreenManager.getInstance();
             nota.setText("");
             Hortifruti_App.setStage(manager.getTelaclientescene());
             Hortifruti_App.setTitle("Tela Cliente");
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
    }
}
