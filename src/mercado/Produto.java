/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mercado;

import java.math.BigDecimal;


/**
 *
 * @author Lucas
 */
public class Produto {
    private String nome;
    private double preco;
    private int quantidade;
    private int id;
    
    public Produto(int id, String nome, double preco, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setId(int id){
        this.id = id;
    }
    
    public int getId(){
        return id;
    }
    
    @Override
    public String toString() {
        return id + ", " + nome + ", " + preco + ", " + quantidade;
    }

    public static Produto fromString(String linha) {
        String[] partes = linha.split(", ");
        
        if (partes.length != 4) {
            throw new IllegalArgumentException("Linha do arquivo mal formatada: " + linha);
        }
        
        int id = Integer.parseInt(partes[0].trim());
        String nome = partes[1].trim();
        double preco = Double.parseDouble(partes[2].trim());
        int quantidade = Integer.parseInt(partes[3].trim());
        return new Produto(id, nome, preco, quantidade);
    }
       
    
    
}
