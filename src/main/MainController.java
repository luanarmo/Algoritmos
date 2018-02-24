package main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import java.net.URL;
import javafx.scene.Parent;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.Optional;
import java.util.ResourceBundle;
public class MainController implements Initializable
{
    @FXML
    ComboBox<String> cmbfuncion = new ComboBox<>();
    @FXML
    Button btnAceptar = new Button();
    @FXML
    Button btnCancelar = new Button();
    @FXML
    Text titulo = new Text();
    ObservableList<String> lista = FXCollections.observableArrayList();
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        titulo.setFont(Font.font(20));
        lista.addAll("Bisección","Regla Falsa");
        cmbfuncion.setItems(lista);
        btnAceptar.setOnAction((e) -> elegirFuncion(cmbfuncion.getSelectionModel().getSelectedItem()));
        btnCancelar.setOnAction((e)-> confirmExit());
    }
    private void elegirFuncion(String funcion)
    {
        if(!cmbfuncion.getSelectionModel().isEmpty()) {
            if (funcion.equals("Bisección")) {
                try {
                    Parent principal = FXMLLoader.load(getClass().getResource("/Grafica/grafica.fxml"));
                    Scene scene = new Scene(principal);
                    main.Main.getPrimaryStage().setScene(scene);
                    System.out.println(funcion);
                } catch (Exception e) {
                    System.out.println("ERROR");
                }
            } else {

            }
        }else{
            showMessage("ERROR","Elija un metodo");
        }
    }
    private void showMessage(String title, String msg)
    {
        Alert message=new Alert(Alert.AlertType.INFORMATION);
        message.setTitle(title);
        message.setContentText(msg);
        message.showAndWait();
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
    private void hideStage(){
        ((Node)btnAceptar).getScene().getWindow().hide();
    }
}