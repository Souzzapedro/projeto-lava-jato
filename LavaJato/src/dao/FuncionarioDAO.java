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
import javax.swing.JOptionPane;
import model.Funcionario;

/**
 *
 * @author pedro
 */
public class FuncionarioDAO {
    private Conexao conexao;
    private Connection conn;
    
    //Vou criar o construtor da classe. O construtor é executado
    //automaticamente sempre que um novo objeto é criado.
    
    public FuncionarioDAO(){
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    public void inserir(Funcionario funcionario) {
        String sql = "INSERT INTO funcionario(nome, bairro, rua, numero, telefone, cpf, cep, salario, comissoes, user, senha, acesso) VALUES "
                + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getBairro());
            stmt.setString(3, funcionario.getRua());
            stmt.setString(4, funcionario.getNumero());
            stmt.setString(5, funcionario.getTelefone());
            stmt.setString(6, funcionario.getCpf());
            stmt.setString(7, funcionario.getCep());
            stmt.setDouble(8, funcionario.getSalario());
            stmt.setDouble(9, funcionario.getComissoes());
            stmt.setString(10, funcionario.getUser());
            stmt.setString(11, funcionario.getSenha());
            stmt.setBoolean(12, funcionario.isAcesso());
            stmt.execute();
        } catch (SQLException e) {
            System.out.println("Erro ao inserir funcionario: " + e.getMessage());
        }
    }
    
     public void remover(int id){
        String sql = "DELETE FROM funcionario WHERE id = ?";
        
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
        } catch (Exception e) {
            System.out.println("Erro ao excluir funcionario: " + e.getMessage());
        }
    }
    
    public Funcionario autenticacao(String user, String senha){
        String sql = "SELECT * FROM funcionario WHERE user=? and senha=?";
    
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, senha);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
               Funcionario funcionario = new Funcionario();
               funcionario.setId(rs.getInt("id"));
               funcionario.setNome(rs.getString("nome"));
               funcionario.setBairro(rs.getString("bairro"));
               funcionario.setRua(rs.getString("rua"));
               funcionario.setNumero(rs.getString("numero"));
               funcionario.setTelefone(rs.getString("telefone"));
               funcionario.setCpf(rs.getString("cpf"));
               funcionario.setCep(rs.getString("cep"));
               funcionario.setSalario(rs.getDouble("salario"));
               funcionario.setComissoes(rs.getDouble("comissoes"));
               funcionario.setUser(rs.getString("user"));
               funcionario.setSenha(rs.getString("senha"));
               funcionario.setAcesso(rs.getBoolean("acesso"));
               return funcionario;
            }
            return null;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "FuncionarioDAO: " + e);
            return null;
        }
    }
    
    public List<Funcionario> getFuncionarios(String pesquisa){
        String sql = "SELECT * FROM funcionario WHERE nome LIKE ?";
        
        try {           
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, "%" + pesquisa + "%");
            ResultSet rs = ps.executeQuery();
            List<Funcionario> listaFuncionarios = new ArrayList<>();
            
            while(rs.next()){
                Funcionario funcionario = new Funcionario();
                
                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setBairro(rs.getString("bairro"));
                funcionario.setRua(rs.getString("rua"));
                funcionario.setNumero(rs.getString("numero"));
                funcionario.setTelefone(rs.getString("telefone"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setCep(rs.getString("cep"));
                funcionario.setSalario(rs.getDouble("salario"));       
                funcionario.setComissoes(rs.getDouble("comissoes"));       
                funcionario.setAcesso(rs.getBoolean("acesso"));
                
                listaFuncionarios.add(funcionario);
            }          
            return listaFuncionarios;
        } catch (Exception e) {
            System.out.println("Erro ao retornar lista de todos dos funcionario do banco (por pesquisa de string) \"getfuncionarios\" : " + e.getMessage());
            return null;
        } 
    }
    
    public Funcionario getFuncionario(int id){
        String sql = "SELECT * FROM funcionario WHERE id=?";
        
        try {
            
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Funcionario funcionario = new Funcionario();
            
            while(rs.next()){
   
                funcionario.setId(rs.getInt("id"));
                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setBairro(rs.getString("bairro"));
                funcionario.setRua(rs.getString("rua"));
                funcionario.setNumero(rs.getString("numero"));
                funcionario.setTelefone(rs.getString("telefone"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setCep(rs.getString("cep"));
                funcionario.setSalario(rs.getDouble("salario"));       
                funcionario.setComissoes(rs.getDouble("comissoes"));       
                funcionario.setAcesso(rs.getBoolean("acesso"));
                
            }          
            return funcionario;
        } catch (Exception e) {
            System.out.println("Erro ao retornar pesquisa de funcionario por id do banco \"getfuncionario\" : " + e.getMessage());
            return null;
        } 
    }
    
    public void editar(Funcionario funcionario){
        String sql = "UPDATE funcionario SET nome=?, bairro=?, rua=?, numero=?, telefone=?, cpf=?, cep=?, salario=?, comissoes=? WHERE id = ?";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getBairro());
            stmt.setString(3, funcionario.getRua());
            stmt.setString(4, funcionario.getNumero());
            stmt.setString(5, funcionario.getTelefone());
            stmt.setString(6, funcionario.getCpf());
            stmt.setString(7, funcionario.getCep());
            stmt.setDouble(8, funcionario.getSalario());
            stmt.setDouble(9, funcionario.getComissoes());
            stmt.setInt(10, funcionario.getId());
            stmt.execute();
        } catch (SQLException e) {
            System.out.println("Erro ao editar funcionario: " + e.getMessage());
        }
        
    }
    
        public Funcionario retornaFuncionarioNome(String nome) {
        String sql = "SELECT * FROM funcionario WHERE nome = ?";

        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setUser(rs.getString("user"));
                return funcionario;
            }
            return null;
        } catch (Exception e) {
            System.err.println("Erro ao retornar pesquisa de todos od funcionarios pelo nome " + e.getMessage());
            return null;
        }
    }
}
