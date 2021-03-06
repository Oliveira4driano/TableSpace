/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tela;

import DAO.TablespaceDAO;
import Modelo.ListaTabela;
import Modelo.Tablespace;
import Modelo.TablespaceCrud;
import Modelo.TablespaceTabelaModelo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Adriano
 */
public class TableSpaceTela extends javax.swing.JFrame {
    private Tablespace tab = new Tablespace();
    private TablespaceCrud crud = new TablespaceCrud();
    private List<Tablespace> tabs = new ArrayList<Tablespace>(); //tabela 
    private TableSpaceTela tabSelecionado;
    private TablespaceDAO tablespaceDAO;
    private List<ListaTabela> listas = new ArrayList<ListaTabela>();
    
    
    
    public TableSpaceTela() throws SQLException, Exception {
        //tab.setNome("");       
        initComponents();
        setLocationRelativeTo(null);
        listar();
        preencherLista();
        
       
    }  
    
    private void preencherTabela(){
        tabela.setModel(new TablespaceTabelaModelo(tabs));   // table model    
    }   
     public void preencherFiltro(){
         tab.setNome(campoNome.getText());
    }     
      
    public void preencherLista(){  // preenche a lista de tabelas
        tablespaceDAO = new TablespaceDAO();
        listas = new ArrayList<ListaTabela>();
        try {
           listas = tablespaceDAO.listarTabela();
            listas.forEach((e) -> {
                jComboBoxTabela.addItem(e.getTabela());
            });            
        } catch (SQLException ex) {
            Logger.getLogger(TableSpaceTela.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
     private void listar() throws SQLException{
        listarBD();
        preencherTabela();
        
        
    } 
     
    private void listarBD()throws SQLException{
         TablespaceDAO dao= new TablespaceDAO();  
         
        try{
           tabs= dao.listar();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this,"Ocorreu um erro de banco de dados: "+e.getMessage());
        }       
    }   
    
    
      public void pesquisar(){ //pesquisa com o parametro nome
        preencherFiltro();
        pesquisarBD();
        preencherTabela();
    }  
    
    private void pesquisarBD(){
         TablespaceDAO dao= new TablespaceDAO();  
         
        try{
           tabs= dao.pesquisar(tab);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this,"Ocorreu um erro de banco de dados: "+e.getMessage());
        }       
    }  
    
  
    private void criarDados(){
         crud.setTabela(campoTabelaCriar.getText());                 
    }
    private void criarBD() throws Exception{
        TablespaceDAO dao= new TablespaceDAO();
        try {         
            dao.criar(crud);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, listas);
            JOptionPane.showMessageDialog(this,"Ocorreu um erro de banco de dados: "+e.getMessage());
        }
        
    } 
    private void criar() throws Exception{
        criarDados();
        criarBD();
        limpaCampos();
        preencherTabela();
        
    }
    
    
     
    private void criarDirDados(){
         crud.setTabela(campoTabelaS.getText());  
         crud.setFile(campoLocal.getText());
    }
    private void criarDirBD() throws Exception{
        TablespaceDAO dao= new TablespaceDAO();
        dao.criarDiretorio(crud);
        
        
        
    } 
    private void criarDir() throws Exception{
        criarDirDados();
        criarDirBD();
        limpaCampos();
       
        
    }
    
      private void preencherDados(){
         crud.setTabela(campoTabela.getText());
         crud.setFile(campoTablespace.getText());
                       
    }
    
    private void alterarBD() throws Exception{
        TablespaceDAO dao= new TablespaceDAO();
        dao.alterar(crud);
        
    }
    private void alterar() throws Exception{
        preencherDados();
        alterarBD();
        limpaCampos();
        preencherTabela();
        
    }
    private void limpaCampos(){
        campoTabela.setText("");
        campoTablespace.setText("");
        campoTabelaCriar.setText("");
        campoLocal.setText("");
        campoTabelaS.setText("");
    }
    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        campoTabelaCriar = new javax.swing.JTextField();
        botaoCriar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jPanelListar = new javax.swing.JPanel();
        campoNome = new javax.swing.JTextField();
        botaoPesquisar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        campoNomeTablespace3 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        campoNomeTablespace4 = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        campoNomeTablespace5 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        campoTablespace = new javax.swing.JTextField();
        campoTabela = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        botaoAlterar = new javax.swing.JButton();
        jComboBoxTabela = new javax.swing.JComboBox<>();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        campoNomeTablespace7 = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        campoNomeTablespace8 = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        campoNomeTablespace9 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        campoLocal = new javax.swing.JTextField();
        campoTabelaS = new javax.swing.JTextField();
        botaoCriarDiretorio = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("TABLESPACE");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 180, 40));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Criando um tablespace geral no diretório de dados MySQL", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setText("Tabela");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));
        jPanel2.add(campoTabelaCriar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 120, -1));

        botaoCriar.setText("Criar");
        botaoCriar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoCriarMouseClicked(evt);
            }
        });
        botaoCriar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCriarActionPerformed(evt);
            }
        });
        jPanel2.add(botaoCriar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, -1, 20));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, -160, -1, 110));

        jLabel8.setText("C:\\ProgramData\\MySQL\\MySQL Server 5.7\\Data");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 670, 80));

        jPanelListar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Listar TableSpace ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        jPanelListar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanelListar.add(campoNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 250, -1));

        botaoPesquisar.setText("Pesquisar");
        botaoPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoPesquisarActionPerformed(evt);
            }
        });
        jPanelListar.add(botaoPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, -1, -1));

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Título 5"
            }
        ));
        jScrollPane2.setViewportView(tabela);

        jPanelListar.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 620, 130));

        getContentPane().add(jPanelListar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 670, 200));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "\nAdicionar tabelas ao tablespace", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Criando um tablespace geral em um diretório fora do diretório de dados MySQL", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        campoNomeTablespace3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoNomeTablespace3.setText("create tablespace <<ts2>> ADD DATAFILE '<<C://TesteBanco/ts2.ibd>>'  Engine=InnoDB;");
        campoNomeTablespace3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNomeTablespace3ActionPerformed(evt);
            }
        });
        jPanel5.add(campoNomeTablespace3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 610, 50));

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 670, 90));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Criando um tablespace geral em um diretório fora do diretório de dados MySQL", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        campoNomeTablespace4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoNomeTablespace4.setText("create tablespace <<ts2>> ADD DATAFILE '<<C://TesteBanco/ts2.ibd>>'  Engine=InnoDB;");
        campoNomeTablespace4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNomeTablespace4ActionPerformed(evt);
            }
        });
        jPanel6.add(campoNomeTablespace4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 610, 50));

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Criando um tablespace geral em um diretório fora do diretório de dados MySQL", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        campoNomeTablespace5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoNomeTablespace5.setText("create tablespace <<ts2>> ADD DATAFILE '<<C://TesteBanco/ts2.ibd>>'  Engine=InnoDB;");
        campoNomeTablespace5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNomeTablespace5ActionPerformed(evt);
            }
        });
        jPanel7.add(campoNomeTablespace5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 610, 50));

        jPanel6.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 670, 90));

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 670, 90));

        jLabel1.setText("Tabela");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel2.setText("TableSpace");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, -1, -1));
        jPanel4.add(campoTablespace, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 120, -1));
        jPanel4.add(campoTabela, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 120, -1));

        jLabel9.setText("Tabelas do BD");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, -1, 20));

        botaoAlterar.setText("Alterar");
        botaoAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAlterarActionPerformed(evt);
            }
        });
        jPanel4.add(botaoAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, -1, -1));

        jPanel4.add(jComboBoxTabela, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, 100, -1));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, 670, 70));

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Criando um tablespace geral em um diretório fora do diretório de dados MySQL", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Criando um tablespace geral em um diretório fora do diretório de dados MySQL", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        campoNomeTablespace7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoNomeTablespace7.setText("create tablespace <<ts2>> ADD DATAFILE '<<C://TesteBanco/ts2.ibd>>'  Engine=InnoDB;");
        campoNomeTablespace7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNomeTablespace7ActionPerformed(evt);
            }
        });
        jPanel9.add(campoNomeTablespace7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 610, 50));

        jPanel8.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 670, 90));

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Criando um tablespace geral em um diretório fora do diretório de dados MySQL", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        campoNomeTablespace8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoNomeTablespace8.setText("create tablespace <<ts2>> ADD DATAFILE '<<C://TesteBanco/ts2.ibd>>'  Engine=InnoDB;");
        campoNomeTablespace8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNomeTablespace8ActionPerformed(evt);
            }
        });
        jPanel10.add(campoNomeTablespace8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 610, 50));

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Criando um tablespace geral em um diretório fora do diretório de dados MySQL", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        campoNomeTablespace9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoNomeTablespace9.setText("create tablespace <<ts2>> ADD DATAFILE '<<C://TesteBanco/ts2.ibd>>'  Engine=InnoDB;");
        campoNomeTablespace9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNomeTablespace9ActionPerformed(evt);
            }
        });
        jPanel11.add(campoNomeTablespace9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 610, 50));

        jPanel10.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 670, 90));

        jPanel8.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 670, 90));

        jLabel5.setText("Tabela");
        jPanel8.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel6.setText("Local Tablespace");
        jPanel8.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, -1, -1));
        jPanel8.add(campoLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 120, -1));
        jPanel8.add(campoTabelaS, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 120, -1));

        botaoCriarDiretorio.setText("Criar Diretorio");
        botaoCriarDiretorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCriarDiretorioActionPerformed(evt);
            }
        });
        jPanel8.add(botaoCriarDiretorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, -1, 20));

        jLabel7.setText("Obs: A barra utilizada para separar o caminho e: /");
        jPanel8.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, -1, -1));

        getContentPane().add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 670, 100));

        jLabel10.setText("V.2 comando executado no MySql 5.7.20");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, -1, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoPesquisarActionPerformed
        pesquisar();
    }//GEN-LAST:event_botaoPesquisarActionPerformed

    private void campoNomeTablespace3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNomeTablespace3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNomeTablespace3ActionPerformed

    private void campoNomeTablespace4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNomeTablespace4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNomeTablespace4ActionPerformed

    private void campoNomeTablespace5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNomeTablespace5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNomeTablespace5ActionPerformed

    private void campoNomeTablespace7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNomeTablespace7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNomeTablespace7ActionPerformed

    private void campoNomeTablespace8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNomeTablespace8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNomeTablespace8ActionPerformed

    private void campoNomeTablespace9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNomeTablespace9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNomeTablespace9ActionPerformed

    private void botaoAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAlterarActionPerformed
        try {
            alterar();
        } catch (Exception ex) {
            Logger.getLogger(TableSpaceTela.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botaoAlterarActionPerformed

    private void botaoCriarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCriarActionPerformed
        try {
            criar();
            preencherTabela();
        } catch (Exception ex) {
            Logger.getLogger(TableSpaceTela.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botaoCriarActionPerformed

    private void botaoCriarDiretorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCriarDiretorioActionPerformed
        try {
            criarDir();
            preencherTabela();
        } catch (Exception ex) {
            Logger.getLogger(TableSpaceTela.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botaoCriarDiretorioActionPerformed

    private void botaoCriarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoCriarMouseClicked
        preencherTabela();
    }//GEN-LAST:event_botaoCriarMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TableSpaceTela().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(TableSpaceTela.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAlterar;
    private javax.swing.JButton botaoCriar;
    private javax.swing.JButton botaoCriarDiretorio;
    private javax.swing.JButton botaoPesquisar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField campoLocal;
    private javax.swing.JTextField campoNome;
    private javax.swing.JTextField campoNomeTablespace3;
    private javax.swing.JTextField campoNomeTablespace4;
    private javax.swing.JTextField campoNomeTablespace5;
    private javax.swing.JTextField campoNomeTablespace7;
    private javax.swing.JTextField campoNomeTablespace8;
    private javax.swing.JTextField campoNomeTablespace9;
    private javax.swing.JTextField campoTabela;
    private javax.swing.JTextField campoTabelaCriar;
    private javax.swing.JTextField campoTabelaS;
    private javax.swing.JTextField campoTablespace;
    private javax.swing.JComboBox<String> jComboBoxTabela;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanelListar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
