/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mercado;

import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lucas
 */
public class JFCompra extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public JFCompra() {
        initComponents();
        comboBox();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TFSubTotal = new javax.swing.JTextField();
        TFValorUni = new javax.swing.JTextField();
        JBAddList = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        JBVender = new javax.swing.JButton();
        JCProduto = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        JLValorTotal = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        TFQtd = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TFSubTotal.setEditable(false);

        JBAddList.setText("Adicionar a lista");
        JBAddList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBAddListActionPerformed(evt);
            }
        });

        jLabel1.setText("Compra ");

        jLabel2.setText("Produto");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Quantidade", "Valor total"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        JBVender.setText("Vender");
        JBVender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBVenderActionPerformed(evt);
            }
        });

        JCProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCProdutoActionPerformed(evt);
            }
        });

        jLabel3.setText("Quantidade");

        jLabel4.setText("Valor Unitario");

        JLValorTotal.setText("0, 00");

        jLabel6.setText("Valor Total: R$");

        jLabel7.setText("Sub Total");

        TFQtd.setText("1");
        TFQtd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFQtdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 656, Short.MAX_VALUE)
                .addComponent(JBVender, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(513, 513, 513)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JLValorTotal))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(534, 534, 534)
                        .addComponent(JBAddList))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JCProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(49, 49, 49)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(TFQtd, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(TFValorUni))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(TFSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(106, 106, 106))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JCProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TFQtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(TFSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(TFValorUni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(40, 40, 40)
                .addComponent(JBAddList)
                .addGap(51, 51, 51)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLValorTotal)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JBVender, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBAddListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBAddListActionPerformed
        // TODO add your handling code here:
        addToArq();
    }//GEN-LAST:event_JBAddListActionPerformed

    private void JBVenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBVenderActionPerformed
        // TODO add your handling code here:
        vender();
    }//GEN-LAST:event_JBVenderActionPerformed

    private void JCProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCProdutoActionPerformed
        // TODO add your handling code here:
        selecionado();
    }//GEN-LAST:event_JCProdutoActionPerformed

    private void TFQtdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFQtdActionPerformed
        // TODO add your handling code here:
        setValorTotal();
    }//GEN-LAST:event_TFQtdActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFCompra().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBAddList;
    private javax.swing.JButton JBVender;
    private javax.swing.JComboBox<String> JCProduto;
    private javax.swing.JLabel JLValorTotal;
    private javax.swing.JTextField TFQtd;
    private javax.swing.JTextField TFSubTotal;
    private javax.swing.JTextField TFValorUni;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    public void comboBox(){
        
        ProdutoCRUD crud = new ProdutoCRUD("arq.txt");
        List<Produto> listP = crud.lerProdutos();
        
        
        for(Produto p : listP){
            JCProduto.addItem(p.getNome());
        }
        
    }
    
    private void selecionado() {
        ProdutoCRUD crud = new ProdutoCRUD("arq.txt");
        List<Produto> listP = crud.lerProdutos();
        
        for(Produto p : listP){
            if(JCProduto.getSelectedItem().equals(p.getNome())){
                TFValorUni.setText(Double.toString(p.getPreco()));
            }
        }    
        
        setValorTotal();
    }

    private void setValorTotal() {
        double valor = Double.parseDouble(TFValorUni.getText());
        int qtd = Integer.parseInt(TFQtd.getText());
        double total = qtd * valor;
        
        TFSubTotal.setText(Double.toString(total)); 
    }

    private void addToArq() {
        ProdutoCRUD crud = new ProdutoCRUD("arq.txt");
        ProdutoCRUD crudtemp = new ProdutoCRUD("arqTemp.txt");
        List<Produto> listP = crud.lerProdutos();
        
        
        for(Produto p : listP){
            if(JCProduto.getSelectedItem().equals(p.getNome())){
                p.setQuantidade(Integer.parseInt(TFQtd.getText()));
                crudtemp.adicionarProduto(p);
                
            }
        }
        
        listar(crudtemp);
    }

    private void listar(ProdutoCRUD crudtemp) {
        List<Produto> listP = crudtemp.lerProdutos();
        
        String[] colunas = {"ID", "Nome", "Preço", "Quantidade"};
        DefaultTableModel modelo = new DefaultTableModel(colunas, 0);
        

        
        jTable1.setModel(modelo);
        
        
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

    private void vender() {
        ProdutoCRUD crudVenda = new ProdutoCRUD("arqTemp.txt");
        ProdutoCRUD crudEstoque = new ProdutoCRUD("arq.txt");
        
        List<Produto> listV = crudVenda.lerProdutos();
        List<Produto> listE = crudEstoque.lerProdutos();
        
        for(Produto vendido : listV){
            for(Produto estoque : listE){
                if(vendido.getId() == estoque.getId()){
                    estoque.setQuantidade(estoque.getQuantidade() - vendido.getQuantidade());
                    crudEstoque.atualizarProduto(estoque.getId(), estoque);
                }
            }
        }
        
        //crudVenda.limpar_arquivo();
        //JFVenda.this.dispose();

    }
}
