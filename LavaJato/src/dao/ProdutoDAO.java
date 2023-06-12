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
import model.Produto;

/**
 *
 * @author pedro
 */
public class ProdutoDAO {

    private Conexao conexao;
    private Connection conn;

    public ProdutoDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }

    public void incluir(Produto produto) {
        String sql = "INSERT INTO produto(nome, preco, quantidade, min, max, mediagasto) VALUES "
                + "(?, ?, ?, ?, ?, ?)";

        try {
            System.out.println("entrou");
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, produto.getNome());
            ps.setDouble(2, produto.getPrecoUnidade());
            ps.setDouble(3, produto.getQuantidade());
            ps.setDouble(4, produto.getMin());
            ps.setDouble(5, produto.getMax());
            ps.setDouble(6, produto.getMediaGasto());
            ps.execute();
        } catch (SQLException ex) {
            System.err.println("Erro ao inserir produto: " + ex.getMessage());
        }
    }

    public void remover(int id) {
        String sql = "DELETE FROM produto WHERE id = ?";

        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException ex) {
            System.err.println("Erro ao remover produto: " + ex.getMessage());
        }
    }

    public void editar(Produto produto) {
        String sql = "UPDATE produto SET nome=?, preco=?, quantidade=?, min=?, max=?, mediagasto=? WHERE id = ?";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPrecoUnidade());
            stmt.setDouble(3, produto.getQuantidade());
            stmt.setDouble(4, produto.getMin());
            stmt.setDouble(5, produto.getMax());
            stmt.setDouble(6, produto.getMediaGasto());
            stmt.setInt(7, produto.getId());
            stmt.execute();
        } catch (SQLException e) {
            System.out.println("Erro ao editar produto: " + e.getMessage());
        }

    }

    public void subtrairProduto(int id, double novaQuantidade){
        String sql = "UPDATE produto SET quantidade=? WHERE id = ?";
        
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setDouble(1, novaQuantidade);
            stmt.setInt(2, id);
            stmt.execute();
        } catch (SQLException e) {
            System.out.println("Erro ao subtrair produto: " + e.getMessage());
        }
    }
    
    public List<Produto> getProdutos(String pesquisa) {
        String sql = "SELECT * FROM  produto WHERE nome LIKE ?";

        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, ("%" + pesquisa + "%"));
            List<Produto> produtos = new ArrayList<>();
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setPrecoUnidade(rs.getDouble("preco"));
                produto.setQuantidade(rs.getDouble("quantidade"));
                produto.setMin(rs.getDouble("min"));
                produto.setMax(rs.getDouble("max"));
                produto.setMediaGasto(rs.getDouble("mediagasto"));

                produtos.add(produto);
            }

            return produtos;
        } catch (SQLException ex) {
            System.err.println("Erro no getProdutos: " + ex.getMessage());
            return null;
        }
    }

    public Produto getProduto(int id) {
        String sql = "SELECT * FROM produto WHERE id = ?";

        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Produto produto = new Produto();

            while (rs.next()) {
                produto.setId(id);
                produto.setNome(rs.getString("nome"));
                produto.setPrecoUnidade(rs.getDouble("preco"));
                produto.setQuantidade(rs.getDouble("quantidade"));
                produto.setMin(rs.getDouble("min"));
                produto.setMax(rs.getDouble("max"));
                produto.setMediaGasto(rs.getDouble("mediagasto"));
            }
            return produto;
        } catch (SQLException ex) {
            System.err.println("Erro ao remover produto: " + ex.getMessage());
            return null;
        }
    }
    
}
