
package projeto2va.negocio.beans;

import java.io.Serializable;



public class Produto implements Serializable {

    private String nome;
    private float preco;
    String tipo;
  
    
    public Produto(String nome, float preco, String tipo) {
        this.nome = nome;
        this.preco = preco;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
    
    public String getTipo() {
        return this.tipo;
    }
    
}
