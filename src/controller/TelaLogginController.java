/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import com.jfoenix.controls.JFXButton;
import controller.DAO.Connect;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Cliente;

/**
 * FXML Controller class
 *
 * @author Luciano
 */
public class TelaLogginController implements Initializable {
    static Stage stage = new Stage();
    @FXML
    private AnchorPane pane;

    @FXML
    private JFXButton btnAcessar;

    @FXML
    void cmdAcessar(ActionEvent event) {
        stage.close();
        telaInicial();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
    public void boot(){
        Connect c = new Connect();
        c.Conectar();
        Cliente cli = new Cliente();
      //  cli.allCliente();
        telaLoggin();
//        telaInicial();
    }

    public void telaLoggin() {
        try {
            
            Parent root = FXMLLoader.load(getClass().getResource("/view/telaLoggin.fxml"));
            stage.setOnCloseRequest(event -> System.exit(0));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("BitBank");
            javafx.scene.image.Image icon = new javafx.scene.image.Image(getClass().getResourceAsStream("/image/logo1.png"));
            stage.getIcons().add(icon);
            stage.show();

        } catch (IOException ex) {

        }

    }

    public void telaInicial() {   
        try {
            
            Parent root = FXMLLoader.load(getClass().getResource("/view/telaInicial.fxml"));
            Scene scene = new Scene(root, 1000, 700);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("BitBank");
            javafx.scene.image.Image icon = new javafx.scene.image.Image(getClass().getResourceAsStream("/image/logo1.png"));
            stage.getIcons().add(icon);
            stage.show();

        } catch (IOException ex) {

        }
    }

}
