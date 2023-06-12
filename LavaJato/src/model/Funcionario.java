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
public class Funcionario extends Pessoa{
    
    private String cpf;
    private String cep;
    private Double salario;
    private Double comissoes;
    private String user;
    private String senha;
    private boolean acesso;

    public Funcionario() {
    }

    public Funcionario(String user, String senha) {
        this.user = user;
        this.senha = senha;
    }

    public Funcionario(String cpf, String cep, Double salario, Double comissoes, String user, String senha, boolean tipoDeAcesso, String nome, String telefone, String bairro, String rua, String numero) {
        super(nome, telefone, bairro, rua, numero);
        this.cpf = cpf;
        this.cep = cep;
        this.salario = salario;
        this.comissoes = comissoes;
        this.user = user;
        this.senha = senha;
        this.acesso = tipoDeAcesso;
    }


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Double getComissoes() {
        return comissoes;
    }

    public void setComissoes(Double comissoes) {
        this.comissoes = comissoes;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAcesso() {
        return acesso;
    }

    public void setAcesso(boolean acesso) {
        this.acesso = acesso;
    }

    
}
