/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.visao.pessoa;

import com.mycompany.dao.DaoCidade;
import com.mycompany.dao.DaoCliente;
import com.mycompany.dao.DaoEndereco;
import com.mycompany.dao.DaoPessoa;
import com.mycompany.ferramentas.Constantes;
import com.mycompany.ferramentas.DadosTemporarios;
import com.mycompany.ferramentas.Formularios;
import com.mycompany.modelo.ModCliente;
import com.mycompany.modelo.ModEndereco;
import com.mycompany.modelo.ModPessoa;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Usuario
 */
public class CadPessoa extends javax.swing.JFrame {

    /**
     * Creates new form CadPessoa
     */
    public CadPessoa() {
        initComponents();
        
        carregarCidades();
        
        if(!existeDadosTemporarios()){
            DaoPessoa daoPessoa = new DaoPessoa();
            DaoEndereco daoEndereco = new DaoEndereco();
            DaoCliente daoCliente = new DaoCliente();
            
            int id = daoPessoa.buscarProximoId(); 
            int idEnd = daoEndereco.buscarProximoId();
            int idCli = daoCliente.buscarProximoId();
            if (id > 0){
                tfId.setText(String.valueOf(id));
                tfIdEndereco.setText(String.valueOf(idEnd));
                tfIdCliente.setText(String.valueOf(idCli));
            }
            
            btnAcao.setText(Constantes.BTN_SALVAR_TEXT);
            btnExcluir.setVisible(false);
        }else{
            btnAcao.setText(Constantes.BTN_ALTERAR_TEXT);
            btnExcluir.setVisible(true);
        }
        
        recuperaIdCidade();
        
        setLocationRelativeTo(null);
        
        tfId.setEnabled(false);
        
        setExtendedState(MAXIMIZED_BOTH);
        
        //tfIdEndereco.setVisible(false);
        //tfIdCidade.setVisible(false);
        //tfIdCliente.setVisible(false);
    
    }
    
    private Boolean existeDadosTemporarios(){        
        if(DadosTemporarios.tempObject instanceof ModPessoa){
            int id = ((ModPessoa) DadosTemporarios.tempObject).getId();
            int idEndereco = ((ModPessoa) DadosTemporarios.tempObject).getIdEndereco();
            String nome = ((ModPessoa) DadosTemporarios.tempObject).getNome();
            String sobrenome = ((ModPessoa) DadosTemporarios.tempObject).getSobrenome();
            String genero = ((ModPessoa) DadosTemporarios.tempObject).getGenero();
            String telefone = ((ModPessoa) DadosTemporarios.tempObject).getTelefone();
            String email = ((ModPessoa) DadosTemporarios.tempObject).getEmail();
            String cpf = ((ModPessoa) DadosTemporarios.tempObject).getCpf();
            String caruqd = ((ModPessoa) DadosTemporarios.tempObject).getCartaocreditoultimosquatrodigit();
            String carnt = ((ModPessoa) DadosTemporarios.tempObject).getCartaocreditonomedotitular();
            String cardaven = ((ModPessoa) DadosTemporarios.tempObject).getCartaocreditodatavencimento();
            
            tfId.setText(String.valueOf(id));
            tfIdEndereco.setText(String.valueOf(idEndereco));
            tfNome.setText(nome);
            tfSobrenome.setText(sobrenome);
            tfTelefone.setText(telefone);
            tfEmail.setText(email);
            tfCpf.setText(cpf);
            tfCarUQD.setText(caruqd);
            tfCarNTITU.setText(carnt);
            tfCarDatVenci.setText(cardaven);
            
            //
            try{
                DaoEndereco daoEndereco = new DaoEndereco();
                ResultSet resultSet = daoEndereco.listarPorId(idEndereco);
                resultSet.next();
                String cidade = resultSet.getString("CIDADE");
                int index = 0;
                for(int i = 0; i < jcbCidade.getItemCount(); i++){
                    if(jcbCidade.getItemAt(i).equals(cidade)){
                        index = i;
                        break;
                    }
                }
                jcbCidade.setSelectedIndex(index);
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
            //
            
            //
            int index = 0;
            for(int i = 0; i < jcbGenero.getItemCount(); i++){
                if(jcbGenero.getItemAt(i).equals(genero)){
                    index = i;
                    break;
                }
            }
            jcbGenero.setSelectedIndex(index);
            //
            
            String rua = ((ModEndereco) DadosTemporarios.tempObject2).getNomeRua();
            String cep = ((ModEndereco) DadosTemporarios.tempObject2).getCep();
            String numRes = ((ModEndereco) DadosTemporarios.tempObject2).getNumeroResidencia();
            
            tfRua.setText(rua);
            tfCep.setText(cep);
            tfNumero.setText(numRes);
            
            int idCliente = ((ModCliente) DadosTemporarios.tempObject3).getId();
            tfIdCliente.setText(String.valueOf(idCliente));
            
            DadosTemporarios.tempObject = null;
            DadosTemporarios.tempObject2 = null;
            DadosTemporarios.tempObject3 = null;
            
            return true;
        }else
            return false;
    }
    
    private void inserir(){
        DaoPessoa daoPessoa = new DaoPessoa();
        DaoEndereco daoEndereco = new DaoEndereco();
        
        if (daoPessoa.inserir(Integer.parseInt(tfId.getText()), Integer.parseInt(tfIdEndereco.getText()), tfNome.getText(), tfSobrenome.getText(), (String) jcbGenero.getSelectedItem(), tfTelefone.getText(), tfEmail.getText(), tfCpf.getText(), tfCarUQD.getText(), tfCarNTITU.getText(), tfCarDatVenci.getText(), tfUsuario.getText(), String.valueOf(pfSenha.getPassword()))){
            JOptionPane.showMessageDialog(null, "Pessoa salva com sucesso!");
            
            //            tfId.setText(String.valueOf(daoPessoa.buscarProximoId()));
//            tfIdEndereco.setText(String.valueOf(daoEndereco.buscarProximoId()));
            tfNome.setText("");
            tfSobrenome.setText("");
            tfTelefone.setText("");
            tfEmail.setText("");
            tfCpf.setText("");
            tfCarUQD.setText("");
            tfCarNTITU.setText("");
            tfCarDatVenci.setText("");
                    
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível salvar a pessoa!");
        }
    }
    
    private void inserirEndereco(){
        DaoEndereco daoEndereco = new DaoEndereco();
        
        if (daoEndereco.inserir(Integer.parseInt(tfIdEndereco.getText()), Integer.parseInt(tfIdCidade.getText()), tfRua.getText(), tfCep.getText(), tfNumero.getText())){
//            JOptionPane.showMessageDialog(null, "Endereço salvo com sucesso!");
            
            tfRua.setText("");
            tfNumero.setText("");
            tfCep.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível salvar o endereço!");
        }
    }
    private void inserirCliente(){
        DaoCliente daoCliente = new DaoCliente();
        
        if (daoCliente.inserir(Integer.parseInt(tfIdCliente.getText()), Integer.parseInt(tfId.getText()))){
//            JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso!");
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível salvar o cliente!");
        }
    }
    
    private void alterar(){
        DaoPessoa daoPessoa = new DaoPessoa();
        
        if (daoPessoa.alterar(Integer.parseInt(tfId.getText()), Integer.parseInt(tfIdEndereco.getText()), tfNome.getText(), tfSobrenome.getText(), (String) jcbGenero.getSelectedItem(), tfTelefone.getText(), tfEmail.getText(), tfCpf.getText(), tfCarUQD.getText(), tfCarNTITU.getText(), tfCarDatVenci.getText(), tfUsuario.getText())){
            JOptionPane.showMessageDialog(null, "Pessoa alterada com sucesso!");
            
            //tfIdEndereco.setText(String.valueOf(daoEndereco.buscarProximoId()));          
            tfNome.setText("");
            tfSobrenome.setText("");
            tfTelefone.setText("");
            tfEmail.setText("");
            tfCpf.setText("");
            tfCarUQD.setText("");
            tfCarNTITU.setText("");
            tfCarDatVenci.setText("");
            tfUsuario.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível alterar a pessoa!");
        }
        
        ((ListPessoa) Formularios.listPessoa).listarTodos();
        
        dispose();
    }

    private void alterarEndereco(){
        DaoEndereco daoEndereco = new DaoEndereco();
        
        if (daoEndereco.alterar(Integer.parseInt(tfIdEndereco.getText()), Integer.parseInt(tfIdCidade.getText()), tfRua.getText(), tfCep.getText(), tfNumero.getText())){
            //JOptionPane.showMessageDialog(null, "Pessoa alterada com sucesso!");
            
            tfRua.setText("");
            tfCep.setText("");
            tfNumero.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível alterar a pessoa!");
        }
    }
    
    private void excluir(){
        DaoPessoa daoPessoa = new DaoPessoa();
        
        if (daoPessoa.excluir(Integer.parseInt(tfId.getText())))
            JOptionPane.showMessageDialog(null, "Pessoa excluída com sucesso!");
        else
            JOptionPane.showMessageDialog(null, "Não foi possível excluir a pessoa!");
        
        ((ListPessoa) Formularios.listPessoa).listarTodos();
        
        dispose();
    }
    
    private void excluirEndereco(){
        
        DaoEndereco daoEndereco = new DaoEndereco();

        if (daoEndereco.excluir(Integer.parseInt(tfIdEndereco.getText()))){

        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível excluir o endereco!");
        }
    }
    
    private void excluirCliente(){
        
        DaoCliente daoCliente = new DaoCliente();

        if (daoCliente.excluir(Integer.parseInt(tfIdCliente.getText()))){

        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível excluir o endereco!");
        }
    }
    
    private void carregarCidades(){
        try{
            DaoCidade daoCidade = new DaoCidade();

            ResultSet resultSet = daoCidade.listarTodos();

            while(resultSet.next())
                jcbCidade.addItem(resultSet.getString("CIDADE"));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    private void recuperaIdCidade(){
        try{
            DaoCidade daoCidade = new DaoCidade();
            ResultSet resultSet = daoCidade.listarPorNome(jcbCidade.getSelectedItem().toString());
            
            resultSet.next();
            tfIdCidade.setText(resultSet.getString("ID"));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    private boolean camposObrigatoriosPreenchidos(JTextField campos[]){
        boolean b = true;
        
        for(int i = 0; i < campos.length; i++){
            if(campos[i].getText().equals("")){
                JOptionPane.showMessageDialog(null, "O campo " + campos[i].getToolTipText() + " é obrigatório!");
                campos[i].requestFocus();
                b = false;
                break;
            }
        }
        
        return b;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfIdEndereco = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfIdCidade = new javax.swing.JTextField();
        tfIdCliente = new javax.swing.JTextField();
        jcbCidade = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfSobrenome = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfUsuario = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tfNumero = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tfCep = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tfEmail = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        tfTelefone = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        tfRua = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        pfSenha = new javax.swing.JPasswordField();
        jLabel14 = new javax.swing.JLabel();
        pfConfirmacaoSenha = new javax.swing.JPasswordField();
        jLabel15 = new javax.swing.JLabel();
        jcbGenero = new javax.swing.JComboBox<>();
        btnAcao = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        tfCpf = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        tfCarUQD = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        tfCarNTITU = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        tfCarDatVenci = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("ID");

        jLabel2.setText("ID_ENDERECO");

        jLabel3.setText("ID_CIDADE");

        jLabel4.setText("ID_CLIENTE");

        jcbCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbCidadeActionPerformed(evt);
            }
        });

        jLabel5.setText("NOME");

        jLabel6.setText("SOBRENOME");

        jLabel7.setText("USUARIO");

        jLabel8.setText("NUM_RESIDENCIA");

        jLabel9.setText("CEP");

        jLabel10.setText("EMAIL");

        jLabel11.setText("TELEFONE");

        jLabel12.setText("RUA");

        jLabel13.setText("SENHA");

        jLabel14.setText("CONFIRME A SENHA");

        jLabel15.setText("GENERO");

        jcbGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Feminino", "Prefiro nao dizer" }));

        btnAcao.setText("Salvar");
        btnAcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcaoActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        jLabel16.setText("CPF");

        jLabel17.setText("Cartao Ultimos Quatro DIGITOS");

        jLabel18.setText("Cartao Nome do Titular");

        jLabel19.setText("Cartao Data Vencimento(formato: 20_12_2022)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfIdEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tfIdCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jcbCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tfIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(tfSobrenome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                .addComponent(tfNome, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(tfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnAcao)
                                .addGap(18, 18, 18)
                                .addComponent(btnExcluir)))
                        .addGap(86, 86, 86)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(tfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(tfCep, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(jcbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(tfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(tfRua, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(pfConfirmacaoSenha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                .addComponent(pfSenha, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel14))
                        .addGap(58, 58, 58)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel18)
                            .addComponent(jLabel17)
                            .addComponent(jLabel16)
                            .addComponent(tfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfCarUQD, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfCarNTITU, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfCarDatVenci, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfIdCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfIdEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8)
                    .addComponent(jLabel11)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9)
                    .addComponent(jLabel12)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfSobrenome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCarUQD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel10)
                    .addComponent(jLabel13)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCarNTITU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pfConfirmacaoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAcao)
                    .addComponent(btnExcluir)
                    .addComponent(tfCarDatVenci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1012, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbCidadeActionPerformed
        recuperaIdCidade();
    }//GEN-LAST:event_jcbCidadeActionPerformed

    private void btnAcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcaoActionPerformed
        String senha = String.valueOf(pfSenha.getPassword());
        String confirmacaoSenha = String.valueOf(pfConfirmacaoSenha.getPassword());
        
        
        if(senha.equals(confirmacaoSenha)){
            DaoPessoa daoPessoa = new DaoPessoa();
            DaoCliente daoCliente = new DaoCliente();
            DaoEndereco daoEndereco = new DaoEndereco();

            if(camposObrigatoriosPreenchidos(new JTextField[]{tfRua, tfCep, tfNumero, tfNome, tfSobrenome, tfTelefone, tfUsuario})){
                if (btnAcao.getText() == Constantes.BTN_SALVAR_TEXT){
                    inserirEndereco();
                    inserir();
                    inserirCliente();

                    tfId.setText(String.valueOf(daoPessoa.buscarProximoId()));
                    tfIdCliente.setText(String.valueOf(daoCliente.buscarProximoId()));
                    tfIdEndereco.setText(String.valueOf(daoEndereco.buscarProximoId()));
                }else if (btnAcao.getText() == Constantes.BTN_ALTERAR_TEXT){            
                    alterarEndereco();
                    alterar();
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, Constantes.CONFIRMACAO_SENHA_DIFERENTE);
        }
    }//GEN-LAST:event_btnAcaoActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int escolha = 
                JOptionPane.showConfirmDialog(
                        null, 
                        "Deseja realmente excluir a pessoa?");
        
        if(escolha == JOptionPane.YES_OPTION){
            excluirCliente();
            excluir();
            excluirEndereco();
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

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
            java.util.logging.Logger.getLogger(CadPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadPessoa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcao;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcbCidade;
    private javax.swing.JComboBox<String> jcbGenero;
    private javax.swing.JPasswordField pfConfirmacaoSenha;
    private javax.swing.JPasswordField pfSenha;
    private javax.swing.JTextField tfCarDatVenci;
    private javax.swing.JTextField tfCarNTITU;
    private javax.swing.JTextField tfCarUQD;
    private javax.swing.JTextField tfCep;
    private javax.swing.JTextField tfCpf;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextField tfIdCidade;
    private javax.swing.JTextField tfIdCliente;
    private javax.swing.JTextField tfIdEndereco;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfNumero;
    private javax.swing.JTextField tfRua;
    private javax.swing.JTextField tfSobrenome;
    private javax.swing.JTextField tfTelefone;
    private javax.swing.JTextField tfUsuario;
    // End of variables declaration//GEN-END:variables
}
