/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mercado;

import java.math.BigDecimal;
import java.util.Random;

/**
 *
 * @author Lucas
 */
public class Produto {
    private String nome;
    private BigDecimal preco;
    private int quantidade;
    private int id;

    public Produto(int id, String nome, BigDecimal preco, int quantidade) {
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

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
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
        return id + ";" + nome + ";" + preco + ";" + quantidade;
    }

    public static Produto fromString(String linha) {
    // Usar vírgula como delimitador
    String[] partes = linha.split(";"); 
    // Verifica se todas as partes estão presentes
    if (partes.length < 4) {
        throw new IllegalArgumentException("Linha inválida: " + linha);
    }
    
    // Tente converter os valores e trate exceções
    try {
        int id = Integer.parseInt(partes[0]);
        String nome = partes[1];
        BigDecimal valor = new BigDecimal(partes[2]);
        int quantidade = Integer.parseInt(partes[3]);
        
        return new Produto(id, nome, valor, quantidade);
    } catch (NumberFormatException e) {
        throw new IllegalArgumentException("Erro ao converter valores da linha: " + linha, e);
    }
}

    
    int getId(){
        return id;
    }   
    
    private int genereteRandom(){
        Random random = new Random(); 
        
        return random.nextInt(1000);
    }
}
