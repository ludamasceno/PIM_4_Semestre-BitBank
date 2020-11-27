/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import model.Cliente;
import model.Moeda;
import model.investimento;

/**
 * FXML Controller class
 *
 * @author Luciano
 */
public class TelaInicialController extends TelaLogginController {

    
    @FXML
    private TableView<Cliente> tbCliente;
    @FXML
    private TableColumn<Cliente, Integer> tbClienteID;
    @FXML
    private TableColumn<Cliente, String> tbClienteNome;
    @FXML
    private AnchorPane pane;
    @FXML
    private JFXButton btnLoad;
    @FXML
    private Label lblCabecalho;
    @FXML
    private TableColumn<Cliente, Integer> tbClienteOrdem;
    private TableColumn<?, ?> tbClienteCompra;

    // TABELA INVESTIMENTOS - INICIO
    @FXML
    private TableView<investimento> Investimento;
    @FXML
    private TableColumn<investimento, Integer> ordemInvestimento;
    @FXML
    private TableColumn<investimento, String> clienteInvestimento;
    @FXML
    private TableColumn<investimento, String> moedaInvestimento;
    @FXML
    private TableColumn<investimento, Integer> quantidadeInvestimento;
    @FXML
    private TableColumn<investimento, String> valorInvestimento;

    // TABELA INVESTIMENTOS - FIM
    // TABELA MOEDA - INICIO
    @FXML
    private TableView<Moeda> tabelaMoedas;
    @FXML
    private TableColumn<Moeda, String> moeda;
    @FXML
    private TableColumn<Moeda, String> valor;

    // TABELA MOEDA - FIM
    @FXML
    private Pane paneView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listaCliente();
        listaInvestimento();
        listaMoeda();
    }

    @FXML
    private void cmdLoad(ActionEvent event) {
        listaCliente();
        listaInvestimento();
        listaMoeda();

     
    }

    private void listaCliente() {
        tbClienteOrdem.setCellValueFactory(new PropertyValueFactory("idCliente"));
        tbClienteNome.setCellValueFactory(new PropertyValueFactory("nomeCliente"));

        tbCliente.setItems(listaTabela());
    }

    private ObservableList<Cliente> listaTabela() {
        Cliente c = new Cliente();
        return FXCollections.observableArrayList(c.allCliente());
    }

    private void listaInvestimento() {
        ordemInvestimento.setCellValueFactory(new PropertyValueFactory<>("ordem"));
        clienteInvestimento.setCellValueFactory(new PropertyValueFactory<>("cliente"));
        moedaInvestimento.setCellValueFactory(new PropertyValueFactory<>("moeda"));
        quantidadeInvestimento.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        valorInvestimento.setCellValueFactory(new PropertyValueFactory<>("valor"));
        Investimento.setItems(listaTabelaInvestimento());

    }

    private ObservableList<investimento> listaTabelaInvestimento() {
        investimento i = new investimento();
        return FXCollections.observableArrayList(i.allInvestimento());
    }

    private void listaMoeda() {
        moeda.setCellValueFactory(new PropertyValueFactory<>("nome"));
        valor.setCellValueFactory(new PropertyValueFactory<>("valor"));
        tabelaMoedas.setItems(listaTabelaMoeda());
    }

    private ObservableList<Moeda> listaTabelaMoeda() {
        Moeda m = new Moeda();
        return FXCollections.observableArrayList(m.allMoeda());
    }

}
