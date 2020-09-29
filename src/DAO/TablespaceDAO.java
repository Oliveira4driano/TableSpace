/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexao.ControlaConexao;
import Modelo.ListaTabela;
import Modelo.Tablespace;
import Modelo.TablespaceCrud;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * @author Adriano
 */
public class TablespaceDAO {
    private List<Tablespace> tabs;
    private List<ListaTabela> lists;
    
    public List<Tablespace> listar() throws SQLException{
        String listarTabespace;
        listarTabespace =" SELECT FILE_ID, NAME, FILE_NAME,FILE_SIZE,ALLOCATED_SIZE " +
"			FROM INFORMATION_SCHEMA.INNODB_SYS_TABLESPACES " +
"			INNER JOIN INFORMATION_SCHEMA.files ON SPACE=FILE_ID " +
"            order by FILE_ID, NAME, FILE_NAME,FILE_SIZE,ALLOCATED_SIZE";
        //System.out.println(listarTabespace);
        tabs = new ArrayList<Tablespace>();
        Connection conexao = null;
        PreparedStatement instrucao;        
        try{
            conexao = ControlaConexao.getConnection();
            instrucao = conexao.prepareStatement(listarTabespace);
            ResultSet resultados = instrucao.executeQuery();
              //System.out.println(resultados.getInt("SPACE")+"inicio");         
            while(resultados.next()){
                Tablespace tablespace = new Tablespace();
                tablespace.setCodigo(resultados.getInt("FILE_ID"));
                tablespace.setNome(resultados.getString("NAME"));
                tablespace.setFile(resultados.getString("FILE_NAME"));
                tablespace.setFileZise(resultados.getInt("FILE_SIZE"));  
                tablespace.setAllocatedZise(resultados.getInt("ALLOCATED_SIZE"));
                
                tabs.add(tablespace);
                //System.out.println(resultados.getInt("SPACE")+"fim");  
            } 
        } catch(SQLException e){
            System.err.println(e.getErrorCode()+"Erro"); 
            
        } finally{
             return tabs;
            //ControlaConexao.fecharInstrucao(instrucao);
            //ControlaConexao.fecharConexao(conexao);
        }  
       
    }         
   
    public List<ListaTabela> listarTabela() throws SQLException{
        String listarTabela;
        
        listarTabela = "show tables";
        lists = new ArrayList<ListaTabela>();
        Connection conexao = null;
        PreparedStatement instrucao = null;        
        try{
            conexao = ControlaConexao.getConnection();
            instrucao = conexao.prepareStatement(listarTabela);
            ResultSet resultados = instrucao.executeQuery();
            
            
            while(resultados.next()){
                ListaTabela lstSaida = new ListaTabela();
                lstSaida.setTabela(resultados.getString(1));
                //tabSaida.setNome(resultados.getString("NAME"));
                //tabSaida.setTipo(resultados.getString("FILE_NAME"));
                //tabSaida.setLogfile(resultados.getString("FILE_SIZE"));  
                //tabSaida.setStatus(resultados.getString("ALLOCATED_SIZE"));   */
                lists.add(lstSaida);
                
            } 
        } catch(SQLException e){
            
        } finally{
            ControlaConexao.fecharInstrucao(instrucao);
            ControlaConexao.fecharConexao(conexao);
        }  
        return lists;
    }
    public List<Tablespace> pesquisar(Tablespace tab) throws SQLException{
       // List<Tablespace> tablespaces;
        Tablespace tablespaceSaida;
         
        String listarTablespace = " SELECT FILE_ID, NAME, FILE_NAME,FILE_SIZE,ALLOCATED_SIZE " +
                                        "FROM INFORMATION_SCHEMA.INNODB_SYS_TABLESPACES " +
                                        "INNER JOIN INFORMATION_SCHEMA.files ON SPACE=FILE_ID WHERE NAME LIKE ? " ;
                                        
        
        Connection conexao = null; 
        PreparedStatement instrucao = null;  
        ResultSet resultados = null;
           
        try{
            conexao = ControlaConexao.getConnection();
            instrucao = conexao.prepareStatement(listarTablespace);
            instrucao.setString(1,"%"+tab.getNome()+"%");
            System.out.println(listarTablespace); 
            resultados = instrucao.executeQuery();
            tabs = new ArrayList<Tablespace>();
                        
            while(resultados.next()){
               tablespaceSaida = new Tablespace();
                tablespaceSaida.setCodigo(resultados.getInt("FILE_ID"));
                tablespaceSaida.setNome(resultados.getString("NAME"));
                tablespaceSaida.setFile(resultados.getString("FILE_NAME"));
                tablespaceSaida.setFileZise(resultados.getInt("FILE_SIZE"));  
                tablespaceSaida.setAllocatedZise(resultados.getInt("ALLOCATED_SIZE"));
                tabs.add(tablespaceSaida);
            } 
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Falha na Pesquisa!", JOptionPane.ERROR_MESSAGE);// Criar uma tela aparecendo essa mensagem e mais detalhes
        } finally{
            ControlaConexao.fecharInstrucao(instrucao);
            ControlaConexao.fecharConexao(conexao);
        }  
        return tabs;
    }
    
       
   public void alterar(TablespaceCrud tab) throws SQLException{
        //String alterarTab = "UPDATE CLIENTE SET clienteNome = ?, clienteEndereco = ?, clienteTelefone = ?, clienteCidadeId = ? WHERE clienteId = ?";
        String alterarTab = "ALTER TABLE "+tab.getTabela()+" TABLESPACE "+tab.getFile();
        Connection conexao = null;
        PreparedStatement instrucao = null;   
        
        try{
            conexao = ControlaConexao.getConnection();
            //conexao = ControlaConexao.getConexao
            instrucao = conexao.prepareStatement(alterarTab);
            //instrucao.setString(1, tab.getTabela());
            //instrucao.setString(2, tab.getFile());
            System.out.println(alterarTab);
            instrucao.execute();
        } catch (SQLException e){
            System.out.println(e.getMessage()+"Erro");
        } finally{
            ControlaConexao.fecharInstrucao(instrucao);
            ControlaConexao.fecharConexao(conexao);        
        }
    
    
    }
   
   public void criar(TablespaceCrud tab) throws SQLException{
        //String alterarTab = "UPDATE CLIENTE SET clienteNome = ?, clienteEndereco = ?, clienteTelefone = ?, clienteCidadeId = ? WHERE clienteId = ?";
        //String alterarTab = "ALTER TABLE "+tab.getTabela()+" TABLESPACE "+tab.getFile();
        String criarTab = "CREATE TABLESPACE "+tab.getTabela()+" ADD DATAFILE '"+tab.getTabela()+".ibd' Engine=InnoDB";
        Connection conexao = null;
        PreparedStatement instrucao = null;   
        
        try{
           
            conexao = ControlaConexao.getConnection();            
            instrucao = conexao.prepareStatement(criarTab);
            System.out.println(criarTab);
            instrucao.execute();
        } catch (SQLException e){
            System.out.println(e.getMessage()+"Erro");
        } finally{
            ControlaConexao.fecharInstrucao(instrucao);
            ControlaConexao.fecharConexao(conexao);        
        }
    
    }
   public void deletar(Tablespace tab){
       String deletarTabela = "DROP TABLESPACE"+tab.getNome()+"ENGINE =INNODB";
       Connection conexao = null;
       PreparedStatement instrucao = null;
       try {
           conexao = ControlaConexao.getConnection();
           instrucao = conexao.prepareStatement(deletarTabela);
           instrucao.execute();
       } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e.getMessage(), "deletar!", JOptionPane.ERROR_MESSAGE);// Criar uma tela aparecendo essa mensagem e mais detalhes
       }
       finally{
           ControlaConexao.fecharInstrucao(instrucao);
           ControlaConexao.fecharConexao(conexao);
           
   } 
   }
      
   public void criarDiretorio(TablespaceCrud tab) throws SQLException{
        //String alterarTab = "UPDATE CLIENTE SET clienteNome = ?, clienteEndereco = ?, clienteTelefone = ?, clienteCidadeId = ? WHERE clienteId = ?";
        //String alterarTab = "ALTER TABLE "+tab.getTabela()+" TABLESPACE "+tab.getFile();
        String criarTab = "CREATE TABLESPACE "+tab.getTabela()+" ADD DATAFILE '"+tab.getFile()+"/"+tab.getTabela()+".ibd' Engine=InnoDB";
        Connection conexao = null;
        PreparedStatement instrucao = null;   
        
        try{
            conexao = ControlaConexao.getConnection();
            //conexao = ControlaConexao.getConexao
            instrucao = conexao.prepareStatement(criarTab);
            //instrucao.setString(1, tab.getTabela());
            //instrucao.setString(2, tab.getFile());
            System.out.println(criarTab);
            instrucao.execute();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Falha criar Diretorio!", JOptionPane.ERROR_MESSAGE);// Criar uma tela aparecendo essa mensagem e mais detalhes
        } finally{
            ControlaConexao.fecharInstrucao(instrucao);
            ControlaConexao.fecharConexao(conexao);        
        }
   }
    
}
