package Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;


import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class GraficaController implements Initializable
{
    WebEngine webEngine;
    @FXML
    WebView wbGeogebra = new WebView();
    @FXML
    Button btnAceptar = new Button();
    @FXML
    Button btnCancelar = new Button();
    @FXML
    TextField tfA = new TextField();
    @FXML
    TextField tfB = new TextField();
    @FXML
    TextField tferror = new TextField();
    @FXML
    Text titulo = new Text();
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        titulo.setFont(Font.font(20));
        webEngine = wbGeogebra.getEngine();
        webEngine.load("https://www.geogebra.org/classic");
        btnAceptar.setOnAction((e)-> cargar());
        btnCancelar.setOnAction((e)-> confirmExit());
    }
    private void hideStage(){
        ((Node)btnAceptar).getScene().getWindow().hide();
    }
    private void confirmExit()
    {
        Alert msg = new Alert(Alert.AlertType.CONFIRMATION);
        msg.setTitle("Exit");
        msg.setContentText("Do you want to go out?");
        Optional<ButtonType> salir = msg.showAndWait();
        if (salir.get() == ButtonType.OK) {
            System.exit(0);
        }
    }
    private void cargar(){
        try {
            Parent principal = FXMLLoader.load(getClass().getResource("/FXML/tabla.fxml"));
            Scene scene = new Scene(principal);
            main.Main.getPrimaryStage().setScene(scene);
        }catch (Exception e){
            System.out.println("ERROR");
        }
    }
}