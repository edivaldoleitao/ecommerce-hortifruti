
package projeto2va.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import projeto2va.exceptions.ElementoNaoExisteException;
import projeto2va.negocio.Fachada;
import projeto2va.negocio.beans.ContaCliente;
import projeto2va.negocio.beans.NotaFiscal;

public class TelaClienteController implements Initializable {

    @FXML
    private TextField pesquisarhortalica;

    @FXML
    private TextField quantidade;

    @FXML
    private Label alertacompra;
    @Override
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        alertacompra.setText("");
    }    
    
    public void comprarProdutos() throws ElementoNaoExisteException {
        ContaCliente c = Fachada.getConta();
        NotaFiscal notaFiscal = new NotaFiscal(c.getId());
        nota
    }
}
