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
    private static final String ARQUIVO = "arq.txt";

    public static void verificarOuCriarArquivo() {
        File arquivo = new File(ARQUIVO);

        // Verifica se o arquivo já existe
        if (!arquivo.exists()) {
            try {
                if (arquivo.createNewFile()) {
                    System.out.println("Arquivo criado com sucesso: " + ARQUIVO);
                } else {
                    System.out.println("Falha ao criar o arquivo.");
                }
            } catch (IOException e) {
                System.out.println("Ocorreu um erro ao criar o arquivo.");
                e.printStackTrace();
            }
        } else {
            System.out.println("Arquivo já existe: " + ARQUIVO);
        }
    }

    
    public void adicionarProduto(Produto produto) {
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO, true))) {
            
            writer.write(produto.toString());
            writer.newLine();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Produto> lerProdutos() {
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

    public void atualizarProduto(int id, Produto novoProduto) {
        List<Produto> produtos = lerProdutos();
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO))) {
            
            for (Produto produto : produtos) {
                
                if (produto.getId() == id) {
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

    public void excluirProduto(int id) {
        List<Produto> produtos = lerProdutos();
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO))) {
            
            for (Produto produto : produtos) {
                
                if (!(produto.getId() == id)) {
                    writer.write(produto.toString());
                    writer.newLine();
                }
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void exibirProdutos() {
        List<Produto> produtos = lerProdutos();
        
        for (Produto produto : produtos) {
            System.out.println("Nome: " + produto.getNome() + ", Preço: " + produto.getPreco() + ", Quantidade: " + produto.getQuantidade());
        }
    }

    public void main(String[] args) {
        // Adicionar um produto
        //Produto produto1 = new Produto("Celular", 1200, 10);
        //adicionarProduto(produto1);

        // Exibir todos os produtos
        exibirProdutos();

        // Atualizar um produto
        //Produto produtoAtualizado = new Produto("Celular", 1100, 8);
        //atualizarProduto(produto1.getId(), produtoAtualizado);

        //Excluir um produto
        //excluirProduto(produto1.getId());

        // Exibir novamente
        exibirProdutos();
    }
}
