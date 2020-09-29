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
public class ListaTabela {
    private int codigo;
    private String tabela;

    public ListaTabela() {
    }

    public ListaTabela(int codigo, String tabela) {
        this.codigo = codigo;
        this.tabela = tabela;
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
    
    
}
