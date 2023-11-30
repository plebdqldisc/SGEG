/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.visao.outros.cliente;

import com.mycompany.dao.DaoProduto;
import com.mycompany.ferramentas.BancoDeDadosMySql;
import com.mycompany.ferramentas.DadosTemporarios;
import com.mycompany.ferramentas.Formularios;
import com.mycompany.modelo.ModProduto;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class TelaPesquisa extends javax.swing.JFrame {

    /**
     * Creates new form TelaPesquisa
     */
    public TelaPesquisa() {
        initComponents();
        Formularios.telaPesquisa = this;
        
        setLocationRelativeTo(null);
        
        if (!BancoDeDadosMySql.conectar()){
            JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco de dados. O sistema será finalizado.");
            System.exit(0);
            
        }   
            //jcbTipoFiltro.setVisible(false);
            //tfFiltro.setVisible(false);
        
    }
    public void listarPorNome(String pNome){
        try{
            //Define o model da tabela.
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableProduto.getModel();
            
            tableProduto.setModel(defaultTableModel);

            DaoProduto daoProduto = new DaoProduto();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoProduto.listarPorNome(pNome);
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String marca = resultSet.getString (3);
                String nome =  resultSet.getString(4);
                String descricao =  resultSet.getString(5);
                String preco = resultSet.getString(6);
                
                defaultTableModel.addRow(new Object[]{marca, nome, descricao, preco});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void listarPorCategoria(String pCategoria){
        try{
            //Define o model da tabela.
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableProduto.getModel();
            
            tableProduto.setModel(defaultTableModel);

            DaoProduto daoProduto = new DaoProduto();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoProduto.listarPorCategoria(pCategoria);
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String marca = resultSet.getString (3);
                String nome =  resultSet.getString(4);
                String descricao =  resultSet.getString(5);
                String preco = resultSet.getString(6);
                
                defaultTableModel.addRow(new Object[]{marca, nome, descricao, preco});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void listarPorMarca(String pMarca){
        try{
            //Define o model da tabela.
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableProduto.getModel();
            
            tableProduto.setModel(defaultTableModel);

            DaoProduto daoProduto = new DaoProduto();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoProduto.listarPorMarca(pMarca);
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String marca = resultSet.getString (3);
                String nome =  resultSet.getString(4);
                String descricao =  resultSet.getString(5);
                String preco = resultSet.getString(6);
                
                defaultTableModel.addRow(new Object[]{marca, nome, descricao, preco});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void listarPorDescricao(String pDescricao){
        try{
            //Define o model da tabela.
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableProduto.getModel();
            
            tableProduto.setModel(defaultTableModel);

            DaoProduto daoProduto = new DaoProduto();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoProduto.listarPorDescricao(pDescricao);
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                
                String marca = resultSet.getString (3);
                String nome =  resultSet.getString(4);
                String descricao =  resultSet.getString(5);
                String preco = resultSet.getString(6);
                
                defaultTableModel.addRow(new Object[]{marca, nome, descricao, preco});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void listarPorPrecoMaiorQue(Double pPreco){
        try{
            //Define o model da tabela.
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableProduto.getModel();
            
            tableProduto.setModel(defaultTableModel);

            DaoProduto daoProduto = new DaoProduto();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoProduto.listarPorPrecoMaiorQue(pPreco);
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String marca = resultSet.getString (3);
                String nome =  resultSet.getString(4);
                String descricao =  resultSet.getString(5);
                String preco = resultSet.getString(6);
                
                defaultTableModel.addRow(new Object[]{marca, nome, descricao, preco});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void listarPorPrecoMenorQue(Double pPreco){
        try{
            //Define o model da tabela.
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableProduto.getModel();
            
            tableProduto.setModel(defaultTableModel);

            DaoProduto daoProduto = new DaoProduto();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoProduto.listarPorPrecoMenorQue(pPreco);
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String marca = resultSet.getString (3);
                String nome =  resultSet.getString(4);
                String descricao =  resultSet.getString(5);
                String preco = resultSet.getString(6);
                
                defaultTableModel.addRow(new Object[]{marca, nome, descricao, preco});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void listarPorPrecoIgualA(Double pPreco){
        try{
            //Define o model da tabela.
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableProduto.getModel();
            
            tableProduto.setModel(defaultTableModel);

            DaoProduto daoProduto = new DaoProduto();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoProduto.listarPorPrecoIgualA(pPreco);
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String marca = resultSet.getString (3);
                String nome =  resultSet.getString(4);
                String descricao =  resultSet.getString(5);
                String preco = resultSet.getString(6);
                
                defaultTableModel.addRow(new Object[]{marca, nome, descricao, preco});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jcbTipoFiltro = new javax.swing.JComboBox<>();
        tfFiltro = new javax.swing.JTextField();
        btnAcao = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableProduto = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));

        jPanel2.setBackground(new java.awt.Color(0, 153, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 204, 255));
        jLabel1.setText("LAZER GAMES BEAM");

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 204, 255));
        jLabel2.setText("Pesquise o seu interesse");

        jcbTipoFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PRODUTO", "CATEGORIA", "MARCA", "DESCRICAO", "PRECO MAIOR", "PRECO MENOR", "PRECO IGUAL" }));

        tfFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfFiltroActionPerformed(evt);
            }
        });

        btnAcao.setBackground(new java.awt.Color(102, 102, 255));
        btnAcao.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        btnAcao.setText("Atualizar Produtos");
        btnAcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 373, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnAcao)
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(tfFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jcbTipoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jcbTipoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(btnAcao)
                .addContainerGap())
        );

        tableProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MARCA", "PRODUTO", "DESCRIÇÃO", "PREÇO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProdutoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableProduto);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 943, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 552, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfFiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfFiltroActionPerformed

    private void btnAcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcaoActionPerformed
        switch (jcbTipoFiltro.getSelectedIndex()){
            case 0:
                listarPorNome(tfFiltro.getText());
                break;
            case 1:
                listarPorCategoria(tfFiltro.getText());
                break;
            case 2:
                listarPorMarca(tfFiltro.getText());
                break;
            case 3:
                listarPorDescricao(tfFiltro.getText());
                break;
            case 4:
                listarPorPrecoMaiorQue(Double.parseDouble(tfFiltro.getText()));
                break;
            case 5:
                listarPorPrecoMenorQue(Double.parseDouble(tfFiltro.getText()));
                break;
            case 6:
                listarPorPrecoIgualA(Double.parseDouble(tfFiltro.getText()));
                break;
        }
    }//GEN-LAST:event_btnAcaoActionPerformed

    private void tableProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProdutoMouseClicked
        try{
            if (evt.getClickCount() == 2){
                int selectedRow = tableProduto.getSelectedRow();
                if (selectedRow != -1) {

                    ModProduto modProduto = new ModProduto();
                    DaoProduto daoProduto = new DaoProduto();

                    ResultSet resultSet = daoProduto.listarPorNome(String.valueOf(tableProduto.getValueAt(tableProduto.getSelectedRow(), 0)));

                    resultSet.next();

                    int id  = resultSet.getInt("ID");
                    String categoria = resultSet.getString("CATEGORIA");
                    String marca = resultSet.getString("MARCA");
                    String descricao = resultSet.getString("DESCRICAO");

                    System.out.println(categoria);
                    System.out.println(marca);

                    modProduto.setId(id);
                    modProduto.setIdMarca(Integer.parseInt(String.valueOf(tableProduto.getValueAt(tableProduto.getSelectedRow(), 0))));
                    modProduto.setNome(String.valueOf(tableProduto.getValueAt(tableProduto.getSelectedRow(), 1)));
                    modProduto.setDescricao(String.valueOf(tableProduto.getValueAt(tableProduto.getSelectedRow(), 2)));
                    modProduto.setPreco(Double.parseDouble(String.valueOf(tableProduto.getValueAt(tableProduto.getSelectedRow(), 3))));

                    DadosTemporarios.tempObject = (ModProduto) modProduto;
                    DadosTemporarios.categoriaProdutoVenda = categoria;
                    DadosTemporarios.marcaProdutoVenda = marca;

                    if (Formularios.teladeVenda == null){
                        Formularios.teladeVenda = new TeladeVenda();
                        Formularios.teladeVenda.setVisible(true);
                    }else{
                        int escolha =
                        JOptionPane.showConfirmDialog(
                            null,
                            "Existe uma compra em andamento, deseja cancelá-la?");

                        if(escolha == JOptionPane.YES_OPTION){
                            Formularios.teladeVenda.dispose();
                            Formularios.teladeVenda = null;

                            Formularios.teladeVenda = new TeladeVenda();
                            Formularios.teladeVenda.setVisible(true);
                        }else{
                            Formularios.teladeVenda.setVisible(true);
                        }

                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_tableProdutoMouseClicked

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
            java.util.logging.Logger.getLogger(TelaPesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPesquisa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> jcbTipoFiltro;
    private javax.swing.JTable tableProduto;
    private javax.swing.JTextField tfFiltro;
    // End of variables declaration//GEN-END:variables
}
