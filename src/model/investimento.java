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
public class investimento {

    private int ordem;
    private String cliente;
    private String moeda;
    private int quantidade;
    private String valor;

    public investimento() {
    }

    public investimento(int ordem, String cliente, String moeda, int quantidade, String valor) {
        this.ordem = ordem;
        this.cliente = cliente;
        this.moeda = moeda;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public investimento(int ordem, String cliente, String moeda, int quantidade) {
        this.ordem = ordem;
        this.cliente = cliente;
        this.moeda = moeda;
        this.quantidade = quantidade;
    }

    public int getOrdem() {
        return ordem;
    }

    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getMoeda() {
        return moeda;
    }

    public void setMoeda(String moeda) {
        this.moeda = moeda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    Connect con = new Connect();

    public List<investimento> allInvestimento() {
        int j = 0;
        ArrayList<investimento> result = new ArrayList<>();
        con.Conectar();
        String c = "R$ ";
        try {
            PreparedStatement comandoSQL = con.getConexao().prepareStatement("select idCompra, NomeCliente, nome, quantidade, format (valor*quantidade, 'c','pt-br') as valor from compra \n"
                    + "inner join cliente \n"
                    + "on compra.idCliente = cliente.idCliente\n"
                    + "inner join moeda\n"
                    + "on compra.idMoeda = moeda.idMoeda");
            ResultSet rs = comandoSQL.executeQuery();
            while (rs.next()) {
                investimento i = new investimento(
                        
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5));
                result.add(i);
                j++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao listar investimentos!\nERRO: " + ex.getMessage(), "Lista de investimentos", JOptionPane.INFORMATION_MESSAGE);
        } finally {
            //     con.Desconectar();
        }
        return result;
    }

}
