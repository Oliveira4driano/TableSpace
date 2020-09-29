/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Adriano
 */
public class TablespaceTabelaModelo extends AbstractTableModel {
    private List<Tablespace> tablespaces;
    
    public TablespaceTabelaModelo(List<Tablespace> tablespace) {
        this.tablespaces = tablespace;
    }
    

    @Override
    public int getRowCount() {
        return tablespaces.size();

    }

    @Override
    public int getColumnCount() {
        return 5;
    }
    
    @Override
    public String getColumnName(int coluna){
        switch(coluna){
            case 0:
                return "FILE_ID";                        
            case 1:
                return "NAME";
            case 2:
                return "FILE_NAME";
            case 3:
                return "FILE_SIZE";
            case 4:
                return "ALLOCATED_SIZE";
           
        }
        return null;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Tablespace tab = tablespaces.get(linha);
        switch(coluna){ 
            case 0: 
                return tab.getCodigo();
            case 1:
                return tab.getNome();
            case 2:
                return tab.getFile();
            case 3: 
                return tab.getFileZise();
            case 4: 
                return tab.getAllocatedZise();
         
                
        }
        return null;
        
    }
    
}
