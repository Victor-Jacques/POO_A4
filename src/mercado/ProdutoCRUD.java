/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mercado;

/**
 *
 * @author Lucas
 */

import java.io.*;
import java.util.*;

public class ProdutoCRUD {
    private static final String ARQUIVO = "C:\\Users\\Lucas\\Documents\\programacao\\pasta_txt\\arq.txt";

    public static void adicionarProduto(Produto produto) {
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO, true))) {
            
            writer.write(produto.toString());
            writer.newLine();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Produto> lerProdutos() {
        List<Produto> produtos = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO))) {
            String linha;
            
            while ((linha = reader.readLine()) != null) {
                produtos.add(Produto.fromString(linha));
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        return produtos;
    }

    public static void atualizarProduto(String nome, Produto novoProduto) {
        List<Produto> produtos = lerProdutos();
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO))) {
            
            for (Produto produto : produtos) {
                
                if (produto.getNome().equalsIgnoreCase(nome)) {
                    writer.write(novoProduto.toString());
                } else {
                    writer.write(produto.toString());
                }
                
                writer.newLine();
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void excluirProduto(String nome) {
        List<Produto> produtos = lerProdutos();
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO))) {
            
            for (Produto produto : produtos) {
                
                if (!produto.getNome().equalsIgnoreCase(nome)) {
                    writer.write(produto.toString());
                    writer.newLine();
                }
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void exibirProdutos() {
        List<Produto> produtos = lerProdutos();
        
        for (Produto produto : produtos) {
            System.out.println("Nome: " + produto.getNome() + ", Preço: " + produto.getPreco() + ", Quantidade: " + produto.getQuantidade());
        }
    }

    public static void main(String[] args) {
        // Adicionar um produto
        Produto produto1 = new Produto("Celular", 1200.00, 10);
        adicionarProduto(produto1);

        // Exibir todos os produtos
        exibirProdutos();

        // Atualizar um produto
        Produto produtoAtualizado = new Produto("Celular", 1100.00, 8);
        atualizarProduto("Celular", produtoAtualizado);

        // Excluir um produto
        excluirProduto("Celular");

        // Exibir novamente
        exibirProdutos();
    }
}
