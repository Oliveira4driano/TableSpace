/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Adriano
 */
public class TablespaceCrud {
    private int codigo;
    private String tabela;
    private String file;

    public TablespaceCrud() {
    }

    public TablespaceCrud(int codigo, String tabela, String file) {
        this.codigo = codigo;
        this.tabela = tabela;
        this.file = file;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTabela() {
        return tabela;
    }

    public void setTabela(String tabela) {
        this.tabela = tabela;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
    
}
