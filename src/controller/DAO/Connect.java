/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.DAO;

import java.beans.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Luciano
 */
public class Connect {

    public Statement stm;
    public ResultSet rs;
    private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private String caminho = "jdbc:sqlserver://localhost:1433;databaseName=banco";
    private String usuario = "bitbank";
    private String senha = "";
    public Connection conexao;
    java.sql.Statement comando;

    public Connection getConexao() {
        return conexao;
    }

    public void setConexao(Connection conexao) {
        this.conexao = conexao;
    }

    public java.sql.Statement getComando() {
        return comando;
    }

    public void setComando(java.sql.Statement comando) {
        this.comando = comando;
    }
    
    
    

    public void Conectar() {
        try {
            System.setProperty("jdbc.Drivers", driver);
            conexao = DriverManager.getConnection(caminho, usuario, senha);
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro de conexão!\nERRO: " + ex.getMessage(), "Banco de Dados", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void Desconectar() {
        try {
            conexao.close();
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro de desconexão!\nERRO: " + ex.getMessage(), "Banco de Dados", JOptionPane.INFORMATION_MESSAGE);
            
        }
    }
}
