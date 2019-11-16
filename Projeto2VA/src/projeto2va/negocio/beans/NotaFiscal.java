
package projeto2va.negocio.beans;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;


public class NotaFiscal implements Serializable{
    private String id;
    private ArrayList<Produto> compras;
    private LocalDate dataCompra;
 
    public NotaFiscal(String id) {
        this.id = id;
        this.dataCompra = LocalDate.now();
    }
    
    public ArrayList<Produto> getCompras() {
       return compras;
    }

    public void NotaAdicionaProduto(Produto produto) {
        this.compras.add(produto);
    }
   
    public double getTotalCompras() {
        double total = 0;
        for(Produto p : this.compras) {
            total += p.getPreco();
        }
        return total;
    }
    
    public String toString() {
        String s = "id cliente :" + this.id + "\n";
        s += "data compra: " + this.dataCompra + "\n ";
        for(Produto p : this.compras) {
            s += "nome produto " + p.getNome() + " preco" + p.getPreco() + "\n";
        }
        s +="total compras : " + getTotalCompras();
        return s;
    }
    
    
}
