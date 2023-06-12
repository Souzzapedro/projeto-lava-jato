/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Pedro
 */
public abstract class Pessoa {
    protected int id;
    protected String nome;
    protected String bairro;
    protected String rua;
    protected String numero;
    protected String telefone;

    public Pessoa(String nome, String telefone, String bairro, String rua, String numero) {
        this.nome = nome;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.telefone = telefone;
    }

    public Pessoa(int id, String nome, String bairro, String rua, String numero, String telefone) {
        this.id = id;
        this.nome = nome;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.telefone = telefone;
    }
  
    
    

    public Pessoa() {
    }

    
       
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
       
}
