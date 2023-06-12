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
public class Cliente extends Pessoa{
    private String veiculo;
    
    public Cliente(){
    }

    public Cliente(String nome, String veiculo, String telefone, String bairro, String rua, String numero) {
        super(nome, bairro, rua, numero, telefone);
        this.veiculo = veiculo;
    }

    public Cliente(String veiculo, int id, String nome, String bairro, String rua, String numero, String telefone) {
        super(id, nome, bairro, rua, numero, telefone);
        this.veiculo = veiculo;
    }
    
    

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    
    public int getId() {
        return id;
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
