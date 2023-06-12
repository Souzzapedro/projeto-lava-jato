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
import model.Cliente;

/**
 *
 * @author pedro
 */
public class ClienteDAO {

    private Conexao conexao;
    private Connection conn;

    public ClienteDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }

    public void inserir(Cliente cliente) {
        String sql = "INSERT INTO cliente(nome, bairro, rua, numero, telefone, veiculo) VALUES "
                + "(?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getBairro());
            stmt.setString(3, cliente.getRua());
            stmt.setString(4, cliente.getNumero());
            stmt.setString(5, cliente.getTelefone());
            stmt.setString(6, cliente.getVeiculo());
            stmt.execute();
        } catch (Exception e) {
            System.err.println("Erro ao inserir cliente: " + e.getMessage());
        }
    }

    public List<Cliente> retornaTodos() {
        String sql = "SELECT * FROM cliente";
        List<Cliente> clientes = new ArrayList<Cliente>();

        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setVeiculo(rs.getString("veiculo"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setRua(rs.getString("rua"));
                cliente.setNumero(rs.getString("numero"));

                clientes.add(cliente);
            }
        } catch (Exception e) {
            System.err.println("Ero ao retornar todos os clientes do banco " + e);
        }

        return clientes;
    }

    public List<Cliente> retornaPesquisaNome(String nome) {
        String sql = "SELECT * FROM cliente WHERE nome LIKE ?";

        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, "%" + nome + "%");
            ResultSet rs = ps.executeQuery();
            List<Cliente> clientes = new ArrayList<>();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setVeiculo(rs.getString("veiculo"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setRua(rs.getString("rua"));
                cliente.setNumero(rs.getString("numero"));

                clientes.add(cliente);
            }
            return clientes;
        } catch (Exception e) {
            System.err.println("Erro ao retornar pesquisa de todos od clientes pelo nome " + e);
            return null;
        }
    }

    public Cliente retornaClienteNome(String nome) {
        String sql = "SELECT * FROM cliente WHERE nome = ?";

        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setVeiculo(rs.getString("veiculo"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setRua(rs.getString("rua"));
                cliente.setNumero(rs.getString("numero"));
                return cliente;
            }
            return null;
        } catch (Exception e) {
            System.err.println("Erro ao retornar pesquisa de todos od clientes pelo nome " + e.getMessage());
            return null;
        }
    }

    public Cliente retornaPeloId(int id) {
        String sql = "SELECT * FROM cliente WHERE id=?";

        try {

            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Cliente cliente = new Cliente();

            while (rs.next()) {

                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setVeiculo(rs.getString("veiculo"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setRua(rs.getString("rua"));
                cliente.setNumero(rs.getString("numero"));

            }

            return cliente;
        } catch (Exception e) {
            System.err.println("Erro ao retornar cliente por id: " + e.getMessage());
            return null;
        }
    }

    public void remover(int id) {
        String sql = "DELETE FROM cliente WHERE id = ?";

        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException ex) {
            System.err.println("Erro ao remover cliente por id: " + ex.getMessage());
        }

    }

    public void editar(Cliente cliente) {
        String sql = "UPDATE cliente SET nome=?, bairro=?, rua=?, numero=?, telefone=?, veiculo=? WHERE id = ?";

        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getBairro());
            stmt.setString(3, cliente.getRua());
            stmt.setString(4, cliente.getNumero());
            stmt.setString(5, cliente.getTelefone());
            stmt.setString(6, cliente.getVeiculo());
            stmt.setInt(7, cliente.getId());
            stmt.execute();
        } catch (SQLException e) {
            System.out.println("Erro ao editar cliente: " + e.getMessage());
        }
    }
}
