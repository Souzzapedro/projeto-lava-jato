/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Dispesa;

/**
 *
 * @author pedro
 */
public class DispesaDAO {

    private Conexao conexao;
    private Connection conn;

    public DispesaDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }

    public void incluir(Dispesa dispesa) {
        String sql = "INSERT INTO dispesa(titulo, preco) VALUES "
                + "(?, ?)";

        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, dispesa.getTitulo());
            ps.setDouble(2, dispesa.getPreco());
            ps.execute();
        } catch (SQLException ex) {
            System.err.println("Erro ao inserir dispesa: " + ex.getMessage());
        }
    }

    public void remover(int id) {
        String sql = "DELETE FROM dispesa WHERE id = ?";

        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException ex) {
            System.err.println("Erro ao remover dispesa: " + ex.getMessage());
        }
    }

    public void editar(Dispesa dispesa) {
        String sql = "UPDATE dispesa SET titulo=?, preco=? WHERE id = ?";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, dispesa.getTitulo());
            stmt.setDouble(2, dispesa.getPreco());
            stmt.setInt(3, dispesa.getId());
            stmt.execute();
        } catch (SQLException e) {
            System.out.println("Erro ao editar dispesa: " + e.getMessage());
        }

    }
    
    public List<Dispesa> getDispesas(String pesquisa) {
        String sql = "SELECT * FROM  dispesa WHERE titulo LIKE ?";

        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, ("%" + pesquisa + "%"));
            List<Dispesa> dispesas = new ArrayList<>();
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Dispesa dispesa = new Dispesa();
                dispesa.setId(rs.getInt("id"));
                dispesa.setTitulo(rs.getString("titulo"));
                dispesa.setPreco(rs.getDouble("preco"));

                dispesas.add(dispesa);
            }

            return dispesas;
        } catch (SQLException ex) {
            System.err.println("Erro no getDispesas: " + ex.getMessage());
            return null;
        }
    }

    public Dispesa getDispesa(int id) {
        String sql = "SELECT * FROM dispesa WHERE id = ?";

        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Dispesa dispesa = new Dispesa();

            while (rs.next()) {
                dispesa.setId(id);
                dispesa.setTitulo(rs.getString("titulo"));
                dispesa.setPreco(rs.getDouble("preco"));
            }
            return dispesa;
        } catch (SQLException ex) {
            System.err.println("Erro ao remover dispesa: " + ex.getMessage());
            return null;
        }
    }
    
}
