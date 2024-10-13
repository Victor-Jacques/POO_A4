/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mercado;

import java.util.Random;

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
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.id = id;
        
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

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return id + "," + nome + "," + preco + "," + quantidade;
    }

    public static Produto fromString(String linha) {
        String[] partes = linha.split(",");
        return new Produto(Integer.parseInt(partes[0]), partes[1], Double.parseDouble(partes[2]), Integer.parseInt(partes[3]));
    }
    
    int getId(){
        return id;
    }   
    
    private int genereteRandom(){
        Random random = new Random(); 
        
        return random.nextInt(1000);
    }
}
