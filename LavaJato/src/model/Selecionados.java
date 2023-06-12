/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author pedro
 */
public class Selecionados {
    boolean lavagem;
    boolean cera;
    boolean polimento;
    boolean restauracaoPlasticos;
    boolean restauracaoFarois;
    boolean lavagemBancos;
    boolean aromatizante;

    public Selecionados() {
    }

    public Selecionados(boolean lavagem, boolean cera, boolean polimento, boolean restauracaoPlasticos, boolean restauracaoFarois, boolean lavagemBancos, boolean aromatizante) {
        this.lavagem = lavagem;
        this.cera = cera;
        this.polimento = polimento;
        this.restauracaoPlasticos = restauracaoPlasticos;
        this.restauracaoFarois = restauracaoFarois;
        this.lavagemBancos = lavagemBancos;
        this.aromatizante = aromatizante;
    }

    public boolean isLavagem() {
        return lavagem;
    }

    public void setLavagem(boolean lavagem) {
        this.lavagem = lavagem;
    }

    public boolean isCera() {
        return cera;
    }

    public void setCera(boolean cera) {
        this.cera = cera;
    }

    public boolean isPolimento() {
        return polimento;
    }

    public void setPolimento(boolean polimento) {
        this.polimento = polimento;
    }

    public boolean isRestauracaoPlasticos() {
        return restauracaoPlasticos;
    }

    public void setRestauracaoPlasticos(boolean restauracaoPlasticos) {
        this.restauracaoPlasticos = restauracaoPlasticos;
    }

    public boolean isRestauracaoFarois() {
        return restauracaoFarois;
    }

    public void setRestauracaoFarois(boolean restauracaoFarois) {
        this.restauracaoFarois = restauracaoFarois;
    }

    public boolean isLavagemBancos() {
        return lavagemBancos;
    }

    public void setLavagemBancos(boolean lavagemBancos) {
        this.lavagemBancos = lavagemBancos;
    }

    public boolean isAromatizante() {
        return aromatizante;
    }

    public void setAromatizante(boolean aromatizante) {
        this.aromatizante = aromatizante;
    }
    
   
}
