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
public class Moeda {

    String nome;
    String valor = "0.0";

    public Moeda() {
    }

    public Moeda(String nome, String valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    Connect con = new Connect();

    public List<Moeda> allMoeda() {
        ArrayList<Moeda> result = new ArrayList<>();
        con.Conectar();
        String c = "R$ ";
        try {
            PreparedStatement comandoSQL = con.getConexao().prepareStatement("select nome,format(valor, 'c','pt-br') as valor from moeda ");
            ResultSet rs = comandoSQL.executeQuery();
            while (rs.next()) {
                c = "R$ ";
                Moeda m = new Moeda(
                        rs.getString(1),
                        c += rs.getString(2));

                result.add(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao listar moedas!\nERRO: " + ex.getMessage(), "Lista de moedas", JOptionPane.INFORMATION_MESSAGE);
        } finally {
            //     con.Desconectar();
        }
        return result;

    }

}
