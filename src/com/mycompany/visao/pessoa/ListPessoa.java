/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.visao.pessoa;

import com.mycompany.dao.DaoCidade;
import com.mycompany.dao.DaoCliente;
import com.mycompany.dao.DaoEndereco;
import com.mycompany.dao.DaoPessoa;
import com.mycompany.ferramentas.DadosTemporarios;
import com.mycompany.ferramentas.Formularios;
import com.mycompany.modelo.ModCliente;
import com.mycompany.modelo.ModEndereco;
import com.mycompany.modelo.ModPessoa;
import com.mycompany.visao.endereco.CadEndereco;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class ListPessoa extends javax.swing.JFrame {

    /**
     * Creates new form ListPessoa
     */
    public ListPessoa() {
        initComponents();
    
        setLocationRelativeTo(null);
        
        listarTodos();;
    }

    public void listarTodos(){
        try{
            //Pega o model da tabela definido no design
            DefaultTableModel defaultTableModel = (DefaultTableModel) tablePessoa.getModel();
            
            tablePessoa.setModel(defaultTableModel);

            DaoPessoa daoPessoa = new DaoPessoa();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoPessoa.listarTodos();
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String cidade = resultSet.getString(2);
                String rua = resultSet.getString(3);
                String cep = resultSet.getString(4);
                String numRes = resultSet.getString(5);
                String nome = resultSet.getString(6);
                String sobrenome = resultSet.getString(7);
                String genero = resultSet.getString(8);
                String telefone = resultSet.getString(9);
                String email = resultSet.getString(10);
                String cpf = resultSet.getString(11);
                String caruqd = resultSet.getString(12);
                String carnt = resultSet.getString(13);
                String cardaven = resultSet.getString(14);
                String usuario = resultSet.getString(15);
                String senha = resultSet.getString(16);
                
                defaultTableModel.addRow(new Object[]{id, cidade, rua, cep, numRes, nome, sobrenome, genero, telefone, email, cpf, caruqd, carnt, cardaven, usuario, senha});
                }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void listarPorId(){
        try{
            //Pega o model da tabela definido no design
            DefaultTableModel defaultTableModel = (DefaultTableModel) tablePessoa.getModel();
            
            tablePessoa.setModel(defaultTableModel);

            DaoPessoa daoPessoa = new DaoPessoa();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoPessoa.listarPorId(Integer.parseInt(tfFiltro.getText()));
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String cidade = resultSet.getString(2);
                String rua = resultSet.getString(3);
                String cep = resultSet.getString(4);
                String numRes = resultSet.getString(5);
                String nome = resultSet.getString(6);
                String sobrenome = resultSet.getString(7);
                String genero = resultSet.getString(8);
                String telefone = resultSet.getString(9);
                String email = resultSet.getString(10);
                String cpf = resultSet.getString(11);
                String caruqd = resultSet.getString(12);
                String carnt = resultSet.getString(13);
                String cardaven = resultSet.getString(14);
                String usuario = resultSet.getString(15);
                String senha = resultSet.getString(16);
                
                defaultTableModel.addRow(new Object[]{id, cidade, rua, cep, numRes, nome, sobrenome, genero, telefone, email, cpf, caruqd, carnt, cardaven, usuario, senha});
                }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void listarPorRua(){
        try{
            //Pega o model da tabela definido no design
            DefaultTableModel defaultTableModel = (DefaultTableModel) tablePessoa.getModel();
            
            tablePessoa.setModel(defaultTableModel);

            DaoPessoa daoPessoa = new DaoPessoa();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoPessoa.listarPorRua(tfFiltro.getText());
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String cidade = resultSet.getString(2);
                String rua = resultSet.getString(3);
                String cep = resultSet.getString(4);
                String numRes = resultSet.getString(5);
                String nome = resultSet.getString(6);
                String sobrenome = resultSet.getString(7);
                String genero = resultSet.getString(8);
                String telefone = resultSet.getString(9);
                String email = resultSet.getString(10);
                String cpf = resultSet.getString(11);
                String caruqd = resultSet.getString(12);
                String carnt = resultSet.getString(13);
                String cardaven = resultSet.getString(14);
                String usuario = resultSet.getString(15);
                String senha = resultSet.getString(16);
                
                defaultTableModel.addRow(new Object[]{id, cidade, rua, cep, numRes, nome, sobrenome, genero, telefone, email, cpf, caruqd, carnt, cardaven, usuario, senha});
                }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void listarCep(){
        try{
            //Pega o model da tabela definido no design
            DefaultTableModel defaultTableModel = (DefaultTableModel) tablePessoa.getModel();
            
            tablePessoa.setModel(defaultTableModel);

            DaoPessoa daoPessoa = new DaoPessoa();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoPessoa.listarPorCep(tfFiltro.getText());
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String cidade = resultSet.getString(2);
                String rua = resultSet.getString(3);
                String cep = resultSet.getString(4);
                String numRes = resultSet.getString(5);
                String nome = resultSet.getString(6);
                String sobrenome = resultSet.getString(7);
                String genero = resultSet.getString(8);
                String telefone = resultSet.getString(9);
                String email = resultSet.getString(10);
                String cpf = resultSet.getString(11);
                String caruqd = resultSet.getString(12);
                String carnt = resultSet.getString(13);
                String cardaven = resultSet.getString(14);
                String usuario = resultSet.getString(15);
                String senha = resultSet.getString(16);
                
                defaultTableModel.addRow(new Object[]{id, cidade, rua, cep, numRes, nome, sobrenome, genero, telefone, email, cpf, caruqd, carnt, cardaven, usuario, senha}); 
                }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void listarPorNumeroResidencia(){
        try{
            //Pega o model da tabela definido no design
            DefaultTableModel defaultTableModel = (DefaultTableModel) tablePessoa.getModel();
            
            tablePessoa.setModel(defaultTableModel);

            DaoPessoa daoPessoa = new DaoPessoa();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoPessoa.listarPorNumeroResidencia(tfFiltro.getText());
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String cidade = resultSet.getString(2);
                String rua = resultSet.getString(3);
                String cep = resultSet.getString(4);
                String numRes = resultSet.getString(5);
                String nome = resultSet.getString(6);
                String sobrenome = resultSet.getString(7);
                String genero = resultSet.getString(8);
                String telefone = resultSet.getString(9);
                String email = resultSet.getString(10);
                String cpf = resultSet.getString(11);
                String caruqd = resultSet.getString(12);
                String carnt = resultSet.getString(13);
                String cardaven = resultSet.getString(14);
                String usuario = resultSet.getString(15);
                String senha = resultSet.getString(16);
    
                defaultTableModel.addRow(new Object[]{id, cidade, rua, cep, numRes, nome, sobrenome, genero, telefone, email, cpf, caruqd, carnt, cardaven, usuario, senha});
                }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void listarPorNome(){
        try{
            //Pega o model da tabela definido no design
            DefaultTableModel defaultTableModel = (DefaultTableModel) tablePessoa.getModel();
            
            tablePessoa.setModel(defaultTableModel);

            DaoPessoa daoPessoa = new DaoPessoa();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoPessoa.listarPorNome(tfFiltro.getText());
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String cidade = resultSet.getString(2);
                String rua = resultSet.getString(3);
                String cep = resultSet.getString(4);
                String numRes = resultSet.getString(5);
                String nome = resultSet.getString(6);
                String sobrenome = resultSet.getString(7);
                String genero = resultSet.getString(8);
                String telefone = resultSet.getString(9);
                String email = resultSet.getString(10);
                String cpf = resultSet.getString(11);
                String caruqd = resultSet.getString(12);
                String carnt = resultSet.getString(13);
                String cardaven = resultSet.getString(14);
                String usuario = resultSet.getString(15);
                String senha = resultSet.getString(16);
                
                defaultTableModel.addRow(new Object[]{id, cidade, rua, cep, numRes, nome, sobrenome, genero, telefone, email, cpf, caruqd, carnt, cardaven, usuario, senha});
                }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void listarPorSobrenome(){
        try{
            //Pega o model da tabela definido no design
            DefaultTableModel defaultTableModel = (DefaultTableModel) tablePessoa.getModel();
            
            tablePessoa.setModel(defaultTableModel);

            DaoPessoa daoPessoa = new DaoPessoa();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoPessoa.listarPorSobrenome(tfFiltro.getText());
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String cidade = resultSet.getString(2);
                String rua = resultSet.getString(3);
                String cep = resultSet.getString(4);
                String numRes = resultSet.getString(5);
                String nome = resultSet.getString(6);
                String sobrenome = resultSet.getString(7);
                String genero = resultSet.getString(8);
                String telefone = resultSet.getString(9);
                String email = resultSet.getString(10);
                String cpf = resultSet.getString(11);
                String caruqd = resultSet.getString(12);
                String carnt = resultSet.getString(13);
                String cardaven = resultSet.getString(14);
                String usuario = resultSet.getString(15);
                String senha = resultSet.getString(16);
                
                defaultTableModel.addRow(new Object[]{id, cidade, rua, cep, numRes, nome, sobrenome, genero, telefone, email, cpf, caruqd, carnt, cardaven, usuario, senha});
                }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void listarPorGenero(){
        try{
            //Pega o model da tabela definido no design
            DefaultTableModel defaultTableModel = (DefaultTableModel) tablePessoa.getModel();
            
            tablePessoa.setModel(defaultTableModel);

            DaoPessoa daoPessoa = new DaoPessoa();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoPessoa.listarPorGenero(tfFiltro.getText());
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String cidade = resultSet.getString(2);
                String rua = resultSet.getString(3);
                String cep = resultSet.getString(4);
                String numRes = resultSet.getString(5);
                String nome = resultSet.getString(6);
                String sobrenome = resultSet.getString(7);
                String genero = resultSet.getString(8);
                String telefone = resultSet.getString(9);
                String email = resultSet.getString(10);
                String cpf = resultSet.getString(11);
                String caruqd = resultSet.getString(12);
                String carnt = resultSet.getString(13);
                String cardaven = resultSet.getString(14);
                String usuario = resultSet.getString(15);
                String senha = resultSet.getString(16);
                
                defaultTableModel.addRow(new Object[]{id, cidade, rua, cep, numRes, nome, sobrenome, genero, telefone, email, cpf, caruqd, carnt, cardaven, usuario, senha});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void listarPorTelefone(){
        try{
            //Pega o model da tabela definido no design
            DefaultTableModel defaultTableModel = (DefaultTableModel) tablePessoa.getModel();
            
            tablePessoa.setModel(defaultTableModel);

            DaoPessoa daoPessoa = new DaoPessoa();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoPessoa.listarPorTelefone(tfFiltro.getText());
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String cidade = resultSet.getString(2);
                String rua = resultSet.getString(3);
                String cep = resultSet.getString(4);
                String numRes = resultSet.getString(5);
                String nome = resultSet.getString(6);
                String sobrenome = resultSet.getString(7);
                String genero = resultSet.getString(8);
                String telefone = resultSet.getString(9);
                String email = resultSet.getString(10);
                String cpf = resultSet.getString(11);
                String caruqd = resultSet.getString(12);
                String carnt = resultSet.getString(13);
                String cardaven = resultSet.getString(14);
                String usuario = resultSet.getString(15);
                String senha = resultSet.getString(16);
                
                
                defaultTableModel.addRow(new Object[]{id, cidade, rua, cep, numRes, nome, sobrenome, genero, telefone, email, cpf, caruqd, carnt, cardaven, usuario, senha});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void listarPorEmail(){
        try{
            //Pega o model da tabela definido no design
            DefaultTableModel defaultTableModel = (DefaultTableModel) tablePessoa.getModel();
            
            tablePessoa.setModel(defaultTableModel);

            DaoPessoa daoPessoa = new DaoPessoa();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoPessoa.listarPorEmail(tfFiltro.getText());
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String cidade = resultSet.getString(2);
                String rua = resultSet.getString(3);
                String cep = resultSet.getString(4);
                String numRes = resultSet.getString(5);
                String nome = resultSet.getString(6);
                String sobrenome = resultSet.getString(7);
                String genero = resultSet.getString(8);
                String telefone = resultSet.getString(9);
                String email = resultSet.getString(10);
                String cpf = resultSet.getString(11);
                String caruqd = resultSet.getString(12);
                String carnt = resultSet.getString(13);
                String cardaven = resultSet.getString(14);
                String usuario = resultSet.getString(15);
                String senha = resultSet.getString(16);
                
                defaultTableModel.addRow(new Object[]{id, cidade, rua, cep, numRes, nome, sobrenome, genero, telefone, email, cpf, caruqd, carnt, cardaven, usuario, senha});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void listarPorUsuario(){
        try{
            //Pega o model da tabela definido no design
            DefaultTableModel defaultTableModel = (DefaultTableModel) tablePessoa.getModel();
            
            tablePessoa.setModel(defaultTableModel);

            DaoPessoa daoPessoa = new DaoPessoa();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoPessoa.listarPorUsuario(tfFiltro.getText(), false);
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String cidade = resultSet.getString(2);
                String rua = resultSet.getString(3);
                String cep = resultSet.getString(4);
                String numRes = resultSet.getString(5);
                String nome = resultSet.getString(6);
                String sobrenome = resultSet.getString(7);
                String genero = resultSet.getString(8);
                String telefone = resultSet.getString(9);
                String email = resultSet.getString(10);
                String cpf = resultSet.getString(11);
                String caruqd = resultSet.getString(12);
                String carnt = resultSet.getString(13);
                String cardaven = resultSet.getString(14);
                String usuario = resultSet.getString(15);
                String senha = resultSet.getString(16);
                
                defaultTableModel.addRow(new Object[]{id, cidade, rua, cep, numRes, nome, sobrenome, genero, telefone, email, cpf, caruqd, carnt, cardaven, usuario, senha});
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
        jcbTipoFiltro = new javax.swing.JComboBox<>();
        tfFiltro = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePessoa = new javax.swing.JTable();
        jcbBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jcbTipoFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODOS", "ID", "RUA", "CEP", "NUMRESID", "NOME", "SOBRENOM", "GENERO", "TELEFONE", "EMAIL", "USUARIO" }));

        tablePessoa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CIDADE", "RUA", "CEP", "NUMRESIDENCIA", "NOME", "SOBRENOME", "GENERO", "TELEFONE", "EMAIL", "CPF", "CARUQD", "CARNT", "CARDAVEN", "USUARIO", "SENHA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablePessoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePessoaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablePessoa);

        jcbBuscar.setText("Buscar");
        jcbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 988, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jcbTipoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tfFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 765, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jcbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbTipoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jcbBuscar)
                .addGap(8, 8, 8))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablePessoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePessoaMouseClicked
        try{
            if (evt.getClickCount() == 2){
                //Pega os dados da pessoa
                ModPessoa modPessoa = new ModPessoa();

                modPessoa.setId(Integer.parseInt(String.valueOf(tablePessoa.getValueAt(tablePessoa.getSelectedRow(), 0))));
//                modPessoa.setIdEndereco(Integer.parseInt(String.valueOf(tablePessoa.getValueAt(tablePessoa.getSelectedRow(), 1))));
                modPessoa.setNome(String.valueOf(tablePessoa.getValueAt(tablePessoa.getSelectedRow(), 5)));
                modPessoa.setSobrenome(String.valueOf(tablePessoa.getValueAt(tablePessoa.getSelectedRow(), 6)));
                modPessoa.setGenero(String.valueOf(tablePessoa.getValueAt(tablePessoa.getSelectedRow(), 7)));
                modPessoa.setTelefone(String.valueOf(tablePessoa.getValueAt(tablePessoa.getSelectedRow(), 8)));
                modPessoa.setEmail(String.valueOf(tablePessoa.getValueAt(tablePessoa.getSelectedRow(), 9)));
                modPessoa.setCpf(String.valueOf(tablePessoa.getValueAt(tablePessoa.getSelectedRow(), 10)));
                modPessoa.setCartaocreditoultimosquatrodigit(String.valueOf(tablePessoa.getValueAt(tablePessoa.getSelectedRow(), 11)));
                modPessoa.setcartaocreditonomedotitular(String.valueOf(tablePessoa.getValueAt(tablePessoa.getSelectedRow(), 12)));
                modPessoa.setcartaocreditodatavencimento(String.valueOf(tablePessoa.getValueAt(tablePessoa.getSelectedRow(), 13)));
                modPessoa.setUsuario(String.valueOf(tablePessoa.getValueAt(tablePessoa.getSelectedRow(), 14)));
                modPessoa.setSenha(String.valueOf(tablePessoa.getValueAt(tablePessoa.getSelectedRow(), 15)));
                
                //
                DaoPessoa daoPessoa = new DaoPessoa();
                ResultSet resultSet = daoPessoa.listarPorId(Integer.parseInt(tablePessoa.getValueAt(tablePessoa.getSelectedRow(), 0).toString()));

                int idEndereco = -1;
                while(resultSet.next())
                    idEndereco = resultSet.getInt("ID_ENDERECO");

                modPessoa.setIdEndereco(idEndereco);
                //
                
                //Pega os dados do endereço
                ModEndereco modEndereco = new ModEndereco();
                
                modEndereco.setNomeRua(String.valueOf(tablePessoa.getValueAt(tablePessoa.getSelectedRow(), 2)));
                modEndereco.setCep(String.valueOf(tablePessoa.getValueAt(tablePessoa.getSelectedRow(), 3)));
                modEndereco.setNumeroResidencia(String.valueOf(tablePessoa.getValueAt(tablePessoa.getSelectedRow(), 4)));
                //
                
                //
                DaoCliente daoCliente = new DaoCliente();
                resultSet = daoCliente.listarPorIdPessoa(Integer.parseInt(String.valueOf(tablePessoa.getValueAt(tablePessoa.getSelectedRow(), 0))));

                ModCliente modCliente = new ModCliente();
                
                int idCliente = -1;
                while(resultSet.next())
                    idCliente = resultSet.getInt("ID");
                
                modCliente.setId(idCliente);
                //
                
                DadosTemporarios.tempObject = (ModPessoa) modPessoa;
                DadosTemporarios.tempObject2 = (ModEndereco) modEndereco;
                DadosTemporarios.tempObject3 = (ModCliente) modCliente;
                
                CadPessoa cadPessoa = new CadPessoa();
                cadPessoa.setVisible(true);
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_tablePessoaMouseClicked

    private void jcbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbBuscarActionPerformed
        switch (jcbTipoFiltro.getSelectedIndex()){
            case 0:
                listarTodos();
                break;
            case 1:
                listarPorId();
                break;
            case 2:
                listarPorRua();
                break;
            case 3:
                listarCep();
                break;
            case 4:
                listarPorNumeroResidencia();
                break;
            case 5:
                listarPorNome();
                break;
            case 6:
                listarPorSobrenome();
                break;
            case 7:
                listarPorGenero();
                break;
            case 8:
                listarPorTelefone();
                break;
            case 9:
                listarPorEmail();
                break;
            case 10:
                listarPorUsuario();
                break;
        }
    }//GEN-LAST:event_jcbBuscarActionPerformed

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
            java.util.logging.Logger.getLogger(ListPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListPessoa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jcbBuscar;
    private javax.swing.JComboBox<String> jcbTipoFiltro;
    private javax.swing.JTable tablePessoa;
    private javax.swing.JTextField tfFiltro;
    // End of variables declaration//GEN-END:variables
}
