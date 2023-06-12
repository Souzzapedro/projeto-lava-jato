/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Agendamento;
import model.Selecionados;

/**
 *
 * @author pedro
 */
public class AgendamentoDAO {

    private Conexao conexao;
    private Connection conn;

    public AgendamentoDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }

    public void inserir(Agendamento agendamento) {
        String sql = "INSERT INTO agenda(cliente, veiculo, telefone, bairro, rua, numero, data, hora, preco, pagamento, funcionarioresponsavel,"
                + " lavagem, cera, polimento, restauracaoplasticos, restauracaofarois, lavagembancos, aromatizante) VALUES "
                + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, agendamento.getCliente());
            stmt.setString(2, agendamento.getVeiculo());
            stmt.setString(3, agendamento.getContato());
            stmt.setString(4, agendamento.getBairro());
            stmt.setString(5, agendamento.getRua());
            stmt.setString(6, agendamento.getNumero());
            Date sqlDate = Date.valueOf(agendamento.getData());
            stmt.setDate(7, sqlDate);
            Time sqlTime = Time.valueOf(agendamento.getHora());
            stmt.setTime(8, sqlTime);
            stmt.setDouble(9, agendamento.getPreco());
            stmt.setBoolean(10, agendamento.isPagamento());
            stmt.setInt(11, agendamento.getIdFuncionarioResponsavel());
            stmt.setBoolean(12, agendamento.getServicosSelecionados().isLavagem());
            stmt.setBoolean(13, agendamento.getServicosSelecionados().isCera());
            stmt.setBoolean(14, agendamento.getServicosSelecionados().isPolimento());
            stmt.setBoolean(15, agendamento.getServicosSelecionados().isRestauracaoPlasticos());
            stmt.setBoolean(16, agendamento.getServicosSelecionados().isRestauracaoFarois());
            stmt.setBoolean(17, agendamento.getServicosSelecionados().isLavagemBancos());
            stmt.setBoolean(18, agendamento.getServicosSelecionados().isAromatizante());
            stmt.execute();
        } catch (SQLException e) {
            System.out.println("Erro ao inserir agendamento: " + e.getMessage());
        }
    }

    public void remover(int id) {
        String sql = "DELETE FROM agenda WHERE id = ?";

        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
        } catch (Exception e) {
            System.out.println("Erro ao excluir agendamento: " + e.getMessage());
        }
    }

    public void editar(Agendamento agendamento) {
        String sql = "UPDATE agenda SET cliente=?, veiculo=?, telefone=?, bairro=?, rua=?, numero=?, data=?, hora=?, preco=?, pagamento=?, funcionarioresponsavel=?, "
                + "lavagem=?, cera=?, polimento=?, restauracaoplasticos=?, restauracaofarois=?, lavagembancos=?, aromatizante=? WHERE id = ?";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, agendamento.getCliente());
            stmt.setString(2, agendamento.getVeiculo());
            stmt.setString(3, agendamento.getContato());
            stmt.setString(4, agendamento.getBairro());
            stmt.setString(5, agendamento.getRua());
            stmt.setString(6, agendamento.getNumero());
            Date sqlDate = Date.valueOf(agendamento.getData());
            stmt.setDate(7, sqlDate);
            Time sqlTime = Time.valueOf(agendamento.getHora());
            stmt.setTime(8, sqlTime);
            stmt.setDouble(9, agendamento.getPreco());
            stmt.setBoolean(10, agendamento.isPagamento());
            stmt.setInt(11, agendamento.getIdFuncionarioResponsavel());
            stmt.setBoolean(12, agendamento.getServicosSelecionados().isLavagem());
            stmt.setBoolean(13, agendamento.getServicosSelecionados().isCera());
            stmt.setBoolean(14, agendamento.getServicosSelecionados().isPolimento());
            stmt.setBoolean(15, agendamento.getServicosSelecionados().isRestauracaoPlasticos());
            stmt.setBoolean(16, agendamento.getServicosSelecionados().isRestauracaoFarois());
            stmt.setBoolean(17, agendamento.getServicosSelecionados().isLavagemBancos());
            stmt.setBoolean(18, agendamento.getServicosSelecionados().isAromatizante());
            stmt.setInt(19, agendamento.getId());
            stmt.execute();
        } catch (SQLException e) {
            System.out.println("Erro ao editar agendamento: " + e.getMessage());
        }

    }

    public List<Agendamento> getAgendamentos(String pesquisa) {
        String sql = "SELECT * FROM agenda WHERE cliente LIKE ?";

        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, "%" + pesquisa + "%");
            ResultSet rs = ps.executeQuery();
            List<Agendamento> listaAgendamentos = new ArrayList<>();

            while (rs.next()) {
                Agendamento agendamento = new Agendamento();

                agendamento.setId(rs.getInt("id"));
                agendamento.setCliente(rs.getString("cliente"));
                agendamento.setVeiculo(rs.getString("veiculo"));
                agendamento.setContato(rs.getString("telefone"));
                agendamento.setBairro(rs.getString("bairro"));
                agendamento.setRua(rs.getString("rua"));
                agendamento.setNumero(rs.getString("numero"));
                agendamento.setData(rs.getDate("data").toLocalDate());
                agendamento.setHora(rs.getTime("hora").toLocalTime());
                agendamento.setPreco(rs.getDouble("preco"));
                agendamento.setPagamento(rs.getBoolean("pagamento"));
                agendamento.setIdFuncionarioResponsavel(rs.getInt("funcionarioresponsavel"));

                Selecionados servicosSelecionados = new Selecionados();
                servicosSelecionados.setLavagem(rs.getBoolean("lavagem"));
                servicosSelecionados.setCera(rs.getBoolean("cera"));
                servicosSelecionados.setPolimento(rs.getBoolean("polimento"));
                servicosSelecionados.setRestauracaoPlasticos(rs.getBoolean("restauracaoplasticos"));
                servicosSelecionados.setRestauracaoFarois(rs.getBoolean("restauracaofarois"));
                servicosSelecionados.setLavagemBancos(rs.getBoolean("lavagembancos"));
                servicosSelecionados.setAromatizante(rs.getBoolean("aromatizante"));

                agendamento.setServicosSelecionados(servicosSelecionados);

                listaAgendamentos.add(agendamento);
            }
            return listaAgendamentos;
        } catch (Exception e) {
            System.out.println("Erro ao retornar lista de todos dos agendamento do banco (por pesquisa de string) \"getAgendamentos\" : " + e.getMessage());
            return null;
        }
    }

    public Agendamento getAgendamento(int id) {
        String sql = "SELECT * FROM agenda WHERE id=?";

        try {

            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Agendamento agendamento = new Agendamento();

            while (rs.next()) {

                agendamento.setId(rs.getInt("id"));
                agendamento.setCliente(rs.getString("cliente"));
                agendamento.setVeiculo(rs.getString("veiculo"));
                agendamento.setContato(rs.getString("telefone"));
                agendamento.setBairro(rs.getString("bairro"));
                agendamento.setRua(rs.getString("rua"));
                agendamento.setNumero(rs.getString("numero"));
                agendamento.setData(rs.getDate("data").toLocalDate());
                agendamento.setHora(rs.getTime("hora").toLocalTime());
                agendamento.setPreco(rs.getDouble("preco"));
                agendamento.setPagamento(rs.getBoolean("pagamento"));
                agendamento.setIdFuncionarioResponsavel(rs.getInt("funcionarioresponsavel"));

                Selecionados servicosSelecionados = new Selecionados();
                servicosSelecionados.setLavagem(rs.getBoolean("lavagem"));
                servicosSelecionados.setCera(rs.getBoolean("cera"));
                servicosSelecionados.setPolimento(rs.getBoolean("polimento"));
                servicosSelecionados.setRestauracaoPlasticos(rs.getBoolean("restauracaoplasticos"));
                servicosSelecionados.setRestauracaoFarois(rs.getBoolean("restauracaofarois"));
                servicosSelecionados.setLavagemBancos(rs.getBoolean("lavagembancos"));
                servicosSelecionados.setAromatizante(rs.getBoolean("aromatizante"));

                agendamento.setServicosSelecionados(servicosSelecionados);

            }
            return agendamento;
        } catch (Exception e) {
            System.out.println("Erro ao retornar pesquisa de agendamento por id do banco \"getAgendamento\" : " + e.getMessage());
            return null;
        }
    }


    public List<Agendamento> getAgendamentosPosFuncionario(int idFuncionario) {
        String sql = "SELECT * FROM agenda WHERE funcionarioresponsavel = ?";

        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, idFuncionario);
            ResultSet rs = ps.executeQuery();
            List<Agendamento> listaAgendamentos = new ArrayList<>();

            while (rs.next()) {
                Agendamento agendamento = new Agendamento();

                agendamento.setId(rs.getInt("id"));
                agendamento.setCliente(rs.getString("cliente"));
                agendamento.setVeiculo(rs.getString("veiculo"));
                agendamento.setContato(rs.getString("telefone"));
                agendamento.setBairro(rs.getString("bairro"));
                agendamento.setRua(rs.getString("rua"));
                agendamento.setNumero(rs.getString("numero"));
                agendamento.setData(rs.getDate("data").toLocalDate());
                agendamento.setHora(rs.getTime("hora").toLocalTime());
                agendamento.setPreco(rs.getDouble("preco"));
                agendamento.setPagamento(rs.getBoolean("pagamento"));
                agendamento.setIdFuncionarioResponsavel(rs.getInt("funcionarioresponsavel"));

                Selecionados servicosSelecionados = new Selecionados();
                servicosSelecionados.setLavagem(rs.getBoolean("lavagem"));
                servicosSelecionados.setCera(rs.getBoolean("cera"));
                servicosSelecionados.setPolimento(rs.getBoolean("polimento"));
                servicosSelecionados.setRestauracaoPlasticos(rs.getBoolean("restauracaoplasticos"));
                servicosSelecionados.setRestauracaoFarois(rs.getBoolean("restauracaofarois"));
                servicosSelecionados.setLavagemBancos(rs.getBoolean("lavagembancos"));
                servicosSelecionados.setAromatizante(rs.getBoolean("aromatizante"));

                agendamento.setServicosSelecionados(servicosSelecionados);

                listaAgendamentos.add(agendamento);
            }
            return listaAgendamentos;
        } catch (Exception e) {
            System.out.println("Erro ao retornar lista de todos dos agendamento do banco (por pesquisa de string) \"getAgendamentos\" : " + e.getMessage());
            return null;
        }
    }

    public List<Agendamento> getAgendamentosPorData(String pesquisa, String crescenteOuDecrescente, String periodo) {
        String sql = "SELECT * FROM agenda WHERE" + periodo + " cliente LIKE? ORDER BY data " + crescenteOuDecrescente;

        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, "%" + pesquisa + "%");
            ResultSet rs = ps.executeQuery();
            List<Agendamento> listaAgendamentos = new ArrayList<>();

            while (rs.next()) {
                Agendamento agendamento = new Agendamento();

                agendamento.setId(rs.getInt("id"));
                agendamento.setCliente(rs.getString("cliente"));
                agendamento.setVeiculo(rs.getString("veiculo"));
                agendamento.setContato(rs.getString("telefone"));
                agendamento.setBairro(rs.getString("bairro"));
                agendamento.setRua(rs.getString("rua"));
                agendamento.setNumero(rs.getString("numero"));
                agendamento.setData(rs.getDate("data").toLocalDate());
                agendamento.setHora(rs.getTime("hora").toLocalTime());
                agendamento.setPreco(rs.getDouble("preco"));
                agendamento.setPagamento(rs.getBoolean("pagamento"));
                agendamento.setIdFuncionarioResponsavel(rs.getInt("funcionarioresponsavel"));

                Selecionados servicosSelecionados = new Selecionados();
                servicosSelecionados.setLavagem(rs.getBoolean("lavagem"));
                servicosSelecionados.setCera(rs.getBoolean("cera"));
                servicosSelecionados.setPolimento(rs.getBoolean("polimento"));
                servicosSelecionados.setRestauracaoPlasticos(rs.getBoolean("restauracaoplasticos"));
                servicosSelecionados.setRestauracaoFarois(rs.getBoolean("restauracaofarois"));
                servicosSelecionados.setLavagemBancos(rs.getBoolean("lavagembancos"));
                servicosSelecionados.setAromatizante(rs.getBoolean("aromatizante"));

                agendamento.setServicosSelecionados(servicosSelecionados);

                listaAgendamentos.add(agendamento);
            }
            return listaAgendamentos;
        } catch (Exception e) {
            System.out.println("Erro no getAgendamentosPorData: " + e.getMessage());
            return null;
        }
    }

    public List<Agendamento> getAgendamentoPorId(String pesquisa, String crescenteOuDecrescente, String periodo) {
        String sql = "SELECT * FROM agenda WHERE" + periodo + " cliente LIKE ? ORDER BY id " + crescenteOuDecrescente;

        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, "%" + pesquisa + "%");
            ResultSet rs = ps.executeQuery();
            List<Agendamento> listaAgendamentos = new ArrayList<>();

            while (rs.next()) {
                Agendamento agendamento = new Agendamento();

                agendamento.setId(rs.getInt("id"));
                agendamento.setCliente(rs.getString("cliente"));
                agendamento.setVeiculo(rs.getString("veiculo"));
                agendamento.setContato(rs.getString("telefone"));
                agendamento.setBairro(rs.getString("bairro"));
                agendamento.setRua(rs.getString("rua"));
                agendamento.setNumero(rs.getString("numero"));
                agendamento.setData(rs.getDate("data").toLocalDate());
                agendamento.setHora(rs.getTime("hora").toLocalTime());
                agendamento.setPreco(rs.getDouble("preco"));
                agendamento.setPagamento(rs.getBoolean("pagamento"));
                agendamento.setIdFuncionarioResponsavel(rs.getInt("funcionarioresponsavel"));

                Selecionados servicosSelecionados = new Selecionados();
                servicosSelecionados.setLavagem(rs.getBoolean("lavagem"));
                servicosSelecionados.setCera(rs.getBoolean("cera"));
                servicosSelecionados.setPolimento(rs.getBoolean("polimento"));
                servicosSelecionados.setRestauracaoPlasticos(rs.getBoolean("restauracaoplasticos"));
                servicosSelecionados.setRestauracaoFarois(rs.getBoolean("restauracaofarois"));
                servicosSelecionados.setLavagemBancos(rs.getBoolean("lavagembancos"));
                servicosSelecionados.setAromatizante(rs.getBoolean("aromatizante"));

                agendamento.setServicosSelecionados(servicosSelecionados);

                listaAgendamentos.add(agendamento);
            }
            return listaAgendamentos;
        } catch (Exception e) {
            System.out.println("Erro no getAgendamentosPorData: " + e.getMessage());
            return null;
        }
    }

    public List<Agendamento> getAgendamentoPorOrdemAlfabetica(String pesquisa, String periodo) {
        String sql = "SELECT * FROM agenda WHERE" + periodo + " cliente LIKE ? ORDER BY cliente";

        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, "%" + pesquisa + "%");
            ResultSet rs = ps.executeQuery();
            List<Agendamento> listaAgendamentos = new ArrayList<>();

            while (rs.next()) {
                Agendamento agendamento = new Agendamento();

                agendamento.setId(rs.getInt("id"));
                agendamento.setCliente(rs.getString("cliente"));
                agendamento.setVeiculo(rs.getString("veiculo"));
                agendamento.setContato(rs.getString("telefone"));
                agendamento.setBairro(rs.getString("bairro"));
                agendamento.setRua(rs.getString("rua"));
                agendamento.setNumero(rs.getString("numero"));
                agendamento.setData(rs.getDate("data").toLocalDate());
                agendamento.setHora(rs.getTime("hora").toLocalTime());
                agendamento.setPreco(rs.getDouble("preco"));
                agendamento.setPagamento(rs.getBoolean("pagamento"));
                agendamento.setIdFuncionarioResponsavel(rs.getInt("funcionarioresponsavel"));

                Selecionados servicosSelecionados = new Selecionados();
                servicosSelecionados.setLavagem(rs.getBoolean("lavagem"));
                servicosSelecionados.setCera(rs.getBoolean("cera"));
                servicosSelecionados.setPolimento(rs.getBoolean("polimento"));
                servicosSelecionados.setRestauracaoPlasticos(rs.getBoolean("restauracaoplasticos"));
                servicosSelecionados.setRestauracaoFarois(rs.getBoolean("restauracaofarois"));
                servicosSelecionados.setLavagemBancos(rs.getBoolean("lavagembancos"));
                servicosSelecionados.setAromatizante(rs.getBoolean("aromatizante"));

                agendamento.setServicosSelecionados(servicosSelecionados);

                listaAgendamentos.add(agendamento);
            }
            return listaAgendamentos;
        } catch (Exception e) {
            System.out.println("Erro no getAgendamentosPorData: " + e.getMessage());
            return null;
        }
    }

    public double calcularComissaoFuncionario(int id, LocalDate dataInicial, LocalDate dataFinal) {
        String sql = "SELECT (preco) FROM agenda WHERE funcionarioresponsavel = ? AND data BETWEEN ? AND ?";

        try {
            System.out.println("entrou");
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            Date sqlDateInicial = Date.valueOf(dataInicial);
            ps.setDate(2, sqlDateInicial);
            Date sqlDateFinal = Date.valueOf(dataFinal);
            ps.setDate(3, sqlDateFinal);
            ResultSet rs = ps.executeQuery();
            double comissao = 0.0;

            while (rs.next()) {
                comissao += rs.getDouble("preco");
            }
            comissao *= 0.5; // porcentagem de comissao.
            return comissao;
        } catch (Exception e) {
            System.out.println("Erro ao retornar comissao do funcionário com data: " + e.getMessage());
            return 0.0;
        }
    }
    
    public double calcularComissaoFuncionario(int id) {
        String sql = "SELECT (preco) FROM agenda WHERE funcionarioresponsavel = ?";

        try {

            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            double comissao = 0.0;

            while (rs.next()) {
                comissao += rs.getDouble("preco");
            }
            comissao *= 0.5; // porcentagem de comissao.
            return comissao;
        } catch (Exception e) {
            System.out.println("Erro ao retornar comissao do funcionário: " + e.getMessage());
            return 0.0;
        }
    }

    public double somarLucroBruto() {
         String sql = "SELECT * FROM agenda WHERE pagamento = true";
         
         try {

            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            double soma = 0.0;

            while (rs.next()) {
                soma += rs.getDouble("preco");
            }
            return soma;
        } catch (Exception e) {
            System.out.println("Erro ao retornar soma do lucro bruto: " + e.getMessage());
            return 0.0;
        }
    }

    public List<Agendamento> getServicosPagos() {
        String sql = "SELECT * FROM agenda WHERE pagamento = true";
         
         try {

            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Agendamento> agendamentos = new ArrayList<>();

            while (rs.next()) {
                Agendamento agendamento = new Agendamento();

                agendamento.setId(rs.getInt("id"));
                agendamento.setCliente(rs.getString("cliente"));
                agendamento.setVeiculo(rs.getString("veiculo"));
                agendamento.setContato(rs.getString("telefone"));
                agendamento.setBairro(rs.getString("bairro"));
                agendamento.setRua(rs.getString("rua"));
                agendamento.setNumero(rs.getString("numero"));
                agendamento.setData(rs.getDate("data").toLocalDate());
                agendamento.setHora(rs.getTime("hora").toLocalTime());
                agendamento.setPreco(rs.getDouble("preco"));
                agendamento.setPagamento(rs.getBoolean("pagamento"));
                agendamento.setIdFuncionarioResponsavel(rs.getInt("funcionarioresponsavel"));

                Selecionados servicosSelecionados = new Selecionados();
                servicosSelecionados.setLavagem(rs.getBoolean("lavagem"));
                servicosSelecionados.setCera(rs.getBoolean("cera"));
                servicosSelecionados.setPolimento(rs.getBoolean("polimento"));
                servicosSelecionados.setRestauracaoPlasticos(rs.getBoolean("restauracaoplasticos"));
                servicosSelecionados.setRestauracaoFarois(rs.getBoolean("restauracaofarois"));
                servicosSelecionados.setLavagemBancos(rs.getBoolean("lavagembancos"));
                servicosSelecionados.setAromatizante(rs.getBoolean("aromatizante"));

                agendamento.setServicosSelecionados(servicosSelecionados);

                agendamentos.add(agendamento);
            }
            return agendamentos;
        } catch (Exception e) {
            System.out.println("Erro ao retornar soma do lucro bruto: " + e.getMessage());
            return null;
        }
    }
}
