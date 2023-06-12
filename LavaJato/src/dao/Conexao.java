/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author pedro
 */
public class Conexao {
    public Connection getConexao(){
        
        try {
            //tentar estabelecer conexão
            Connection conn;
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/lava_jato?serverTimezone=UTC", //Linha de conexão
                    "root", //Usuario do mysql
                    "" //Senha do mysql
            );
            return conn;
        } catch (Exception e) {
            //se deu erro na hora de conectar
            System.out.println("Erro ao conectar " + e.getMessage());
            return null;
        }
    }
 
}
