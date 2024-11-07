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
import javax.swing.JOptionPane;

public class ProdutoCRUD {

    private static final String CAMINHO_ARQUIVO = "notas_fiscais.txt";  // Caminho do arquivo de registro
    private String ARQUIVO;

    public ProdutoCRUD(String ARQUIVO) {
        this.ARQUIVO = ARQUIVO;
    }

    public void setARQUIVO(String ARQUIVO) {
        this.ARQUIVO = ARQUIVO;
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
                if (!linha.trim().isEmpty()) {
                    try {
                        produtos.add(Produto.fromString(linha));
                    } catch (IllegalArgumentException e) {
                        System.err.println(e.getMessage());
                    }
                }
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

    public void limpar_arquivo() {

        File arquivo = new File(ARQUIVO);

        // Verifica se o arquivo existe e tenta deletar
        if (arquivo.exists()) {
            if (arquivo.delete()) {
                System.out.println("Arquivo deletado com sucesso.");
            } else {
                System.out.println("Falha ao deletar o arquivo.");
            }
        } else {
            System.out.println("O arquivo não existe.");
        }
    }

    // Método para verificar se a tabela está vazia
    public boolean arquivoVazio() {
        try (BufferedReader br = new BufferedReader(new FileReader(ARQUIVO))) {
            return br.readLine() == null;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao ler o arquivo: " + e.getMessage());
            return true; // Considerar como se estivesse vazio em caso de erro
        }
    }

    // Método para verificar se o arquivo está vazio e impedir operações
    public boolean verificarArquivoVazio() {
        if (arquivoVazio()) {
            JOptionPane.showMessageDialog(null, "O banco de dados está vazio.\nFavor cadastrar algum produto para efetuar alguma movimentação");
            return false; // Indica que a operação não pode ser realizada
        }
        return true; // Indica que a operação pode ser realizada
    }

    public void salvarNotaFiscalEmArquivo(String conteudoNotaFiscal, String nomeArquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true))) {
            writer.write(conteudoNotaFiscal);  // Grava o conteúdo no arquivo
            writer.newLine();
            writer.newLine();
            writer.write("//=============//==============//");
            writer.newLine();
            writer.newLine();
            writer.flush();  // Assegura que o conteúdo seja escrito no arquivo
        } catch (IOException e) {
            System.err.println("Erro ao gravar a nota fiscal no arquivo: " + e.getMessage());
        }
    }

}
