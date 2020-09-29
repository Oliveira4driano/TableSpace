package Tela;


import Conexao.ControlaConexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;
/**
 *
 * @author Aluno
 */
public class LogTela extends javax.swing.JFrame{
    
    public static void main(String[] args){
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                new LogTela().setVisible(true);
                
                
            }
        });       
    }

    public LogTela(){
        initComponents();
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setSize(400, 550);
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botaoLogar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtHost = new javax.swing.JTextField();
        txtBanco = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtPorta = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login TableSpace");
        setSize(new java.awt.Dimension(800, 450));
        getContentPane().setLayout(null);

        botaoLogar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        botaoLogar.setText("ENTRAR");
        botaoLogar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoLogarMouseClicked(evt);
            }
        });
        botaoLogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoLogarActionPerformed(evt);
            }
        });
        getContentPane().add(botaoLogar);
        botaoLogar.setBounds(80, 440, 200, 47);

        jLabel3.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("TABLESPACE");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(50, 20, 270, 70);
        getContentPane().add(txtUsuario);
        txtUsuario.setBounds(80, 330, 200, 30);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setText("USUÁRIO");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(80, 300, 100, 22);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setText("SENHA");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(80, 370, 70, 20);

        txtHost.setText("localhost");
        getContentPane().add(txtHost);
        txtHost.setBounds(80, 130, 200, 30);
        getContentPane().add(txtBanco);
        txtBanco.setBounds(80, 260, 200, 30);

        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setText("HOST");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(80, 110, 100, 22);

        jLabel7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel7.setText("BANCO");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(80, 230, 70, 20);

        txtPorta.setText("3306");
        getContentPane().add(txtPorta);
        txtPorta.setBounds(80, 190, 200, 30);

        jLabel8.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel8.setText("PORTA");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(80, 170, 70, 20);

        txtSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSenhaActionPerformed(evt);
            }
        });
        getContentPane().add(txtSenha);
        txtSenha.setBounds(80, 400, 200, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoLogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoLogarActionPerformed
        
       // Connection conexao;
        try {
            try{ 
                 ControlaConexao.CONEXAO_HOST = txtHost.getText();
                 ControlaConexao.CONEXAO_PORTA = txtPorta.getText();
                 ControlaConexao.CONEXAO_BANCO = txtBanco.getText();
                 ControlaConexao.CONEXAO_USER = txtUsuario.getText();
                 ControlaConexao.CONEXAO_PASSWORD = txtSenha.getText();
                 
                 
                Connection conexao;
               // String host="jdbc:mysql://localhost:3306/cep_rural";
                String host="jdbc:mysql://"+txtHost.getText()+":"+txtPorta.getText()+"/"+txtBanco.getText();
                conexao = DriverManager.getConnection(host ,txtUsuario.getText() ,txtSenha.getText());
                conexao.close(); 

                 
                
                 setVisible(false);
                 new TableSpaceTela().setVisible(true);
                 
                  
            }catch(SQLException ex){
                 JOptionPane.showMessageDialog(null, ex.getMessage(), "Falha na conexao", JOptionPane.ERROR_MESSAGE);
                     
            }
            finally{
                
         
            }
        } 
        catch (Exception ex) {
            Logger.getLogger(LogTela.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botaoLogarActionPerformed

    private void botaoLogarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoLogarMouseClicked
        // TODO add your handling code here: 
    }//GEN-LAST:event_botaoLogarMouseClicked

    private void txtSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSenhaActionPerformed
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoLogar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField txtBanco;
    private javax.swing.JTextField txtHost;
    private javax.swing.JTextField txtPorta;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
} 
