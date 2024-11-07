/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mercado;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.util.Date;


/**
 *
 * @author victo
 */
public class Metodos {

    private JFRead readFile;

    public Metodos(JFRead readFile) {
        this.readFile = readFile;
    }

    public final void mostrar(JTable tabela) {
        ProdutoCRUD crud = new ProdutoCRUD("arq.txt");
        List<Produto> listP = crud.lerProdutos();

        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();

        modelo.setRowCount(0);

        for (Produto produto : listP) {
            Object[] linha = {
                produto.getId(),
                produto.getNome(),
                produto.getPreco(),
                produto.getQuantidade()
            };

            modelo.addRow(linha);
        }
    }

    public void listar(JTable table, ProdutoCRUD crudtemp) {
        List<Produto> listP = crudtemp.lerProdutos();
        String[] colunas = {"ID", "Nome", "Preço", "Quantidade"};
        DefaultTableModel modelo = new DefaultTableModel(colunas, 0);
        table.setModel(modelo);

        for (Produto produto : listP) {
            Object[] linha = {
                produto.getId(),
                produto.getNome(),
                produto.getPreco(),
                produto.getQuantidade()
            };
            modelo.addRow(linha);
        }
    }

    public void addToArq(JComboBox<String> JCProduto, Object quantidadeInput, JTextField TFSubTotal, JLabel JLValorTotal, JTable table, ProdutoCRUD crud, ProdutoCRUD crudtemp) {
        List<Produto> listP = crud.lerProdutos();

        for (Produto p : listP) {
            if (JCProduto.getSelectedItem().equals(p.getNome())) {
                int quantidade;
                if (quantidadeInput instanceof JComboBox) {
                    quantidade = Integer.parseInt(((JComboBox<?>) quantidadeInput).getSelectedItem().toString());
                } else if (quantidadeInput instanceof JTextField) {
                    quantidade = Integer.parseInt(((JTextField) quantidadeInput).getText());
                } else {
                    throw new IllegalArgumentException("Tipo de entrada para quantidade inválido.");
                }

                p.setQuantidade(quantidade);
                crudtemp.adicionarProduto(p);

                // Calcula o subtotal e atualiza no TFSubTotal
                BigDecimal subtotal = p.getPreco().multiply(new BigDecimal(quantidade));
                TFSubTotal.setText(subtotal.toString().replace(".", ","));

                // Atualiza o total
                addTotal(TFSubTotal, JLValorTotal);

                // Atualiza a tabela
                listar(table, crudtemp);
            }
        }
    }

    public void addTotal(JTextField TFSubTotal, JLabel JLValorTotal) {
        try {
            String subTotalText = TFSubTotal.getText().replace(".", "").replace(",", ".").trim();
            if (!subTotalText.isEmpty() && isNumeric(subTotalText)) {
                BigDecimal valorTotal = new BigDecimal(subTotalText);

                String valorTotalText = JLValorTotal.getText().replace(".", "").replace(",", ".").trim();
                BigDecimal valorFinal = BigDecimal.ZERO;

                if (!valorTotalText.isEmpty() && isNumeric(valorTotalText)) {
                    valorFinal = new BigDecimal(valorTotalText);
                }

                valorFinal = valorFinal.add(valorTotal);
                JLValorTotal.setText(valorFinal.setScale(2, RoundingMode.HALF_UP).toString().replace(".", ","));
            } else {
                System.err.println("Valor subtotal inválido: " + subTotalText);
            }
        } catch (NumberFormatException e) {
            System.err.println("Erro de formatação de número: " + e.getMessage());
            JLValorTotal.setText("0,00");
        }
    }

    public void calcularSubtotal(JTextField TFValorUni, Object quantidadeSource, JTextField TFSubTotal) {

        try {
            // Obtém o valor unitário como BigDecimal
            String valorStr = TFValorUni.getText().replace(".", "").replace(",", ".");
            BigDecimal valorUnitario = new BigDecimal(valorStr);

            // Define a quantidade dependendo do tipo de entrada
            int quantidade = 0;
            if (quantidadeSource instanceof JTextField) {
                quantidade = Integer.parseInt(((JTextField) quantidadeSource).getText());
            } else if (quantidadeSource instanceof JComboBox) {
                quantidade = Integer.parseInt(((JComboBox<?>) quantidadeSource).getSelectedItem().toString());
            }

            // Calcula e define o subtotal
            BigDecimal subtotal = valorUnitario.multiply(new BigDecimal(quantidade));
            TFSubTotal.setText(subtotal.setScale(2, RoundingMode.HALF_UP).toString().replace(".", ","));
        } catch (NumberFormatException e) {

            System.err.println("Erro ao calcular subtotal: " + e.getMessage());

            TFSubTotal.setText("0,00");
        }

    }

    public void selecionarProduto(
            List<Produto> listP,
            JComboBox<String> JCProduto,
            JTextField TFValorUni,
            JTextField TFQtd, // Para a tela de Compra
            JComboBox<String> JCQtd, // Para a tela de Venda
            JTextField TFSubTotal
    ) {
        // Verifica se há um produto selecionado
        String produtoSelecionado = (String) JCProduto.getSelectedItem();

        if (produtoSelecionado != null) {
            for (Produto p : listP) {
                if (produtoSelecionado.equals(p.getNome())) {
                    // Formata o preço do produto e define no campo de valor unitário
                    DecimalFormat df = new DecimalFormat("#,##0.00");
                    TFValorUni.setText(df.format(p.getPreco()));

                    // Para a tela de Compra com JTextField de quantidade
                    if (TFQtd != null) {
                        TFQtd.setText("1"); // Inicia com 1
                    }

                    // Para a tela de Venda com JComboBox de quantidade
                    if (JCQtd != null) {
                        // Limpa o JComboBox antes de adicionar os itens
                        JCQtd.removeAllItems();
                        for (int i = 1; i <= p.getQuantidade(); i++) {
                            JCQtd.addItem(String.valueOf(i)); // Adiciona opções de 1 até a quantidade disponível
                        }
                        // Seleciona o primeiro item (1) no JComboBox
                        if (JCQtd.getItemCount() > 0) {
                            JCQtd.setSelectedIndex(0); // Seleciona 1
                        }
                    }
                    break; // Encerra o loop após encontrar o produto
                }
            }
        }
    }

    public void processarTransacao(boolean isCompra) {
        ProdutoCRUD crudTransacao = new ProdutoCRUD("arqTemp.txt");
        ProdutoCRUD crudEstoque = new ProdutoCRUD("arq.txt");

        List<Produto> listTransacao = crudTransacao.lerProdutos();
        List<Produto> listEstoque = crudEstoque.lerProdutos();

        // Converte listEstoque em um Map para acesso rápido
        Map<Integer, Produto> estoqueMap = new HashMap<>();
        for (Produto produtoEstoque : listEstoque) {
            estoqueMap.put(produtoEstoque.getId(), produtoEstoque);
        }

        for (Produto produtoTransacao : listTransacao) {
            Produto produtoEstoque = estoqueMap.get(produtoTransacao.getId());

            if (produtoEstoque != null) {
                if (isCompra) {
                    produtoEstoque.setQuantidade(produtoEstoque.getQuantidade() + produtoTransacao.getQuantidade());
                } else {
                    int novaQuantidade = produtoEstoque.getQuantidade() - produtoTransacao.getQuantidade();
                    if (novaQuantidade < 0) {
                        JOptionPane.showMessageDialog(null, "Estoque insuficiente para o produto: " + produtoEstoque.getNome(), "Erro", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    produtoEstoque.setQuantidade(novaQuantidade);
                }
                // Atualiza o produto no arquivo de estoque
                crudEstoque.atualizarProduto(produtoEstoque.getId(), produtoEstoque);
            }
        }

        // Limpa o arquivo temporário
        crudTransacao.limpar_arquivo();

        // Exibe a nota fiscal com base na transação
        if (isCompra) {
            gerarNotaFiscal(listTransacao, true);
        } else {
            gerarNotaFiscal(listTransacao, false);
        }

        mostrar(readFile.JFReadTable);
    }

    public void gerarNotaFiscal(List<Produto> produtos, boolean isCompra) {
        StringBuilder notaFiscal = new StringBuilder();
        Date dataHora = new Date();
        String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHora);
        String hora = new SimpleDateFormat("    HH:mm:ss").format(dataHora);

        String tipoNota = isCompra ? "Compra" : "Venda";
        notaFiscal.append("Nota Fiscal de ").append(tipoNota).append("\n").append(data).append(hora);
        notaFiscal.append("\n---------------------------\n");

        BigDecimal valorTotal = BigDecimal.ZERO;

        for (Produto produto : produtos) {
            notaFiscal.append("Produto: ").append(produto.getNome()).append("\n");
            notaFiscal.append("Quantidade: ").append(produto.getQuantidade()).append("\n");
            notaFiscal.append("Preço Unitário: ").append(produto.getPreco()).append("\n");
            notaFiscal.append("---------------------------\n");

            valorTotal = valorTotal.add(produto.getPreco().multiply(BigDecimal.valueOf(produto.getQuantidade())));
        }

        notaFiscal.append("Valor Total: ").append(valorTotal).append("\n");

        String nomeArquivo = "nota_fiscal.txt";
        ProdutoCRUD pr = new ProdutoCRUD(nomeArquivo);

        // Chama o método para salvar a nota fiscal em um arquivo
        pr.salvarNotaFiscalEmArquivo(notaFiscal.toString(), nomeArquivo);
        
        JOptionPane.showMessageDialog(null, notaFiscal.toString(), "Nota Fiscal de " + tipoNota, JOptionPane.INFORMATION_MESSAGE);

    }


public boolean isNumeric(String str) {
        try {
            new BigDecimal(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
