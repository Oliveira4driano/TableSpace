/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.math.BigInteger;

/**
 *
 * @author Adriano
 */
public class Tablespace {
    private int codigo;
    private String nome;
    private String file;
    private Integer fileZise;
    private Integer allocatedZise;

    public Tablespace() {
    }

    public Tablespace(int codigo, String nome, String file, Integer fileZise, Integer allocatedZise) {
        this.codigo = codigo;
        this.nome = nome;
        this.file = file;
        this.fileZise = fileZise;
        this.allocatedZise = allocatedZise;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public Integer getFileZise() {
        return fileZise;
    }

    public void setFileZise(Integer fileZise) {
        this.fileZise = fileZise;
    }

    public Integer getAllocatedZise() {
        return allocatedZise;
    }

    public void setAllocatedZise(Integer allocatedZise) {
        this.allocatedZise = allocatedZise;
    }

   
   
    
}
