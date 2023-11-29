/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.visao.outros.cliente;

import com.mycompany.dao.DaoPedido;
import com.mycompany.ferramentas.DadosTemporarios;
import com.mycompany.ferramentas.Formularios;
import com.mycompany.modelo.ModPais;
import com.mycompany.modelo.ModProduto;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
/**
 *
 * @author arthur.7923
 */
public class TeladeVenda extends javax.swing.JFrame {

    /**
     * Creates new form TeladeVenda
     */
    public TeladeVenda() {
        initComponents();
        
        setLocationRelativeTo(null);
        
        existeDadosTemporarios();
        
        labelQuantidadeCompra.setText("1");
        
        taDescricao.setEnabled(false);
        
        calculaTotalCompra(Double.parseDouble(labelPreco.getText()), Integer.parseInt(labelQuantidadeCompra.getText()));
        
        tfIdPedido.setVisible(false);
        tfIdProduto.setVisible(false);
        tfIdCliente.setVisible(false);
    }

    private Boolean existeDadosTemporarios(){        
        if(DadosTemporarios.tempObject instanceof ModProduto){
            int id = ((ModProduto) DadosTemporarios.tempObject).getId();
            String nome = ((ModProduto) DadosTemporarios.tempObject).getNome();
            Double preco = ((ModProduto) DadosTemporarios.tempObject).getPreco();
            String descricao = ((ModProduto) DadosTemporarios.tempObject).getDescricao();
            String categoria = DadosTemporarios.categoriaProdutoVenda;
            String marca = DadosTemporarios.marcaProdutoVenda;
            int idCliente = DadosTemporarios.idUsuarioLogado;
            
            int proximoIdPedido = new DaoPedido().buscarProximoId();
            
            tfIdPedido.setText(String.valueOf(proximoIdPedido));
            tfIdCliente.setText(String.valueOf(idCliente));
            tfIdProduto.setText(String.valueOf(id));
            
            labelProduto.setText(nome);
            labelPreco.setText(String.valueOf(preco));
            labelCategoriaProduto.setText(categoria);
            labelMarcaProduto.setText(marca);
            taDescricao.setText(descricao);
            
            DadosTemporarios.tempObject = null;
            DadosTemporarios.categoriaProdutoVenda = null;
            DadosTemporarios.marcaProdutoVenda = null;
            
            return true;
        }else
            return false;
    }
    
    private void calculaTotalCompra(Double preco, int quantidade){
        Double total = preco * quantidade;
        
        labelTotalCompra.setText(String.valueOf(total));
    }
    
    private void adicionaUnidade() {
    String quantidadeAtualText = labelQuantidadeAtual.getText().trim();
    int qtdeAtual = Integer.parseInt(quantidadeAtualText);
    
    qtdeAtual++;
    
    labelQuantidadeAtual.setText(String.valueOf(qtdeAtual));
    labelQuantidadeCompra.setText(String.valueOf(qtdeAtual));
    }
    
    private void diminuirUnidade() {
        int qtdeAtual = Integer.parseInt(labelQuantidadeAtual.getText());
        
        if(qtdeAtual > 1){
            qtdeAtual--;

            labelQuantidadeAtual.setText(String.valueOf(qtdeAtual));
            labelQuantidadeCompra.setText(String.valueOf(qtdeAtual));
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        labelProduto = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        labelCategoriaProduto = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        labelMarcaProduto = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        labelPreco = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        labelTotalCompra = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        labelQuantidadeCompra = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        btnComprar = new javax.swing.JButton();
        tfIdCliente = new javax.swing.JTextField();
        tfIdProduto = new javax.swing.JTextField();
        tfIdPedido = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        labelQuantidadeAtual = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taDescricao = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel1.setText("Produto");

        labelProduto.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        labelProduto.setText("nomeProduto");

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel3.setText("Categoria");

        labelCategoriaProduto.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        labelCategoriaProduto.setText("categoriaProduto");

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel5.setText("Marca");

        labelMarcaProduto.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        labelMarcaProduto.setText("marcaProduto");

        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel7.setText("Preço");

        labelPreco.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        labelPreco.setText("precoProduto");

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel9.setText("Descrição");

        jLabel10.setFont(new java.awt.Font("Segoe UI Black", 0, 36)); // NOI18N
        jLabel10.setText("Total da Compra");

        labelTotalCompra.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        labelTotalCompra.setText("totalCompra");

        jLabel12.setFont(new java.awt.Font("Segoe UI Black", 0, 36)); // NOI18N
        jLabel12.setText("Quantidade");

        labelQuantidadeCompra.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        labelQuantidadeCompra.setText("quantidadeCompra");

        btnComprar.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        btnComprar.setText("Comprar");
        btnComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprarActionPerformed(evt);
            }
        });

        tfIdPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIdPedidoActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jButton2.setText("-");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jButton4.setText("+");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        labelQuantidadeAtual.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        labelQuantidadeAtual.setText("1");

        taDescricao.setColumns(20);
        taDescricao.setRows(5);
        jScrollPane1.setViewportView(taDescricao);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnComprar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(labelProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelCategoriaProduto, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelPreco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelMarcaProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel9)
                            .addComponent(labelTotalCompra))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelQuantidadeCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(tfIdPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfIdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(labelQuantidadeAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(labelProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(labelCategoriaProduto)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(labelMarcaProduto)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(labelPreco)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfIdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfIdPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton4)
                                .addComponent(jButton2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(labelQuantidadeAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelTotalCompra)
                    .addComponent(labelQuantidadeCompra))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnComprar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprarActionPerformed

        try{
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            String dataPedido = dtf.format(now);
            
            
            DaoPedido daoPedido = new DaoPedido();
            
            int id = Integer.parseInt(tfIdPedido.getText());
            int idCliente = Integer.parseInt(tfIdCliente.getText());
            int idProduto = Integer.parseInt(tfIdProduto.getText());
            dataPedido = now.toString();
            int quantidade = Integer.parseInt(labelQuantidadeCompra.getText());
            
            daoPedido.inserir(id, idCliente, idProduto, dataPedido, quantidade);
            
            System.out.println("Data e Hora Atuais: " + dataPedido);
            
            JOptionPane.showMessageDialog(null, "Obrigado, " + DadosTemporarios.usuarioLogado + ", pela sua compra, seu produto chegará em breve pelo email!");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Houve um problema ao tentar salvar o pedido!");
        }
    }//GEN-LAST:event_btnComprarActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        adicionaUnidade();
        calculaTotalCompra(Double.parseDouble(labelPreco.getText()), Integer.parseInt(labelQuantidadeCompra.getText()));
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        diminuirUnidade();
        calculaTotalCompra(Double.parseDouble(labelPreco.getText()), Integer.parseInt(labelQuantidadeCompra.getText()));
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        Formularios.teladeVenda = null;
    }//GEN-LAST:event_formWindowClosed

    private void tfIdPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIdPedidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfIdPedidoActionPerformed

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
            java.util.logging.Logger.getLogger(TeladeVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TeladeVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TeladeVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TeladeVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TeladeVenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComprar;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel labelCategoriaProduto;
    private javax.swing.JLabel labelMarcaProduto;
    private javax.swing.JLabel labelPreco;
    private javax.swing.JLabel labelProduto;
    private javax.swing.JLabel labelQuantidadeAtual;
    private javax.swing.JLabel labelQuantidadeCompra;
    private javax.swing.JLabel labelTotalCompra;
    private javax.swing.JTextArea taDescricao;
    private javax.swing.JTextField tfIdCliente;
    private javax.swing.JTextField tfIdPedido;
    private javax.swing.JTextField tfIdProduto;
    // End of variables declaration//GEN-END:variables
}
