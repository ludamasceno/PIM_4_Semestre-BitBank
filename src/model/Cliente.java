/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.DAO.Connect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Luciano
 */
public class Cliente {

    private int idCliente;
    private String nomeCliente;

    public Cliente() {
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
    
    

    public Cliente(int idCliente, String nomeCliente) {
        this.idCliente = idCliente;
        this.nomeCliente = nomeCliente;
    }
    Connect con = new Connect();

    public List<Cliente> allCliente() {
        ArrayList<Cliente> result = new ArrayList<>();
        con.Conectar();
        try {
            PreparedStatement comandoSQL = con.getConexao().prepareStatement("SELECT idCliente, nomeCliente FROM dbo.cliente");
            ResultSet rs = comandoSQL.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente(
                        rs.getInt(1),
                        rs.getString(2));
                result.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao listar clientes!\nERRO: " + ex.getMessage(), "Lista de clientes", JOptionPane.INFORMATION_MESSAGE);
        } finally {
            //     con.Desconectar();
        }
        return result;
    }
}
