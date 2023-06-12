/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author pedro
 */
public class Agendamento {
    private int id;
    private String cliente;
    private String veiculo;
    private String contato;
    private String bairro;
    private String rua;
    private String numero;
    private LocalDate data;
    private LocalTime hora;
    private double preco;
    private boolean pagamento;
    private int idFuncionarioResponsavel;
    private Selecionados servicosSelecionados;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    } 
    
    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
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

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
   
    public boolean isPagamento() {
        return pagamento;
    }

    public void setPagamento(boolean pagamento) {
        this.pagamento = pagamento;
    }

    public int getIdFuncionarioResponsavel() {
        return idFuncionarioResponsavel;
    }

    public void setIdFuncionarioResponsavel(int idFuncionarioResponsavel) {
        this.idFuncionarioResponsavel = idFuncionarioResponsavel;
    }

    public Selecionados getServicosSelecionados() {
        return servicosSelecionados;
    }

    public void setServicosSelecionados(Selecionados servicosSelecionados) {
        this.servicosSelecionados = servicosSelecionados;
    }
  
    
}
