package Tabla;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class TablaController implements Initializable
{
    @FXML
    Button btnAceptar = new Button();
    @FXML
    Button btnCancelar = new Button();
    @FXML
    Text titulo = new Text();
    @FXML
    TableView<String> tblResultados = new TableView<>();

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        btnAceptar.setOnAction((e)-> cargar());
        btnCancelar.setOnAction((e)->confirmExit());
        titulo.setFont(Font.font(20));
        TableColumn id = new TableColumn("ID");
        TableColumn a = new TableColumn("A");
        TableColumn b = new TableColumn("B");
        TableColumn xr = new TableColumn("XR");
        TableColumn error = new TableColumn("Error");
        TableColumn fa = new TableColumn("F(a)");
        TableColumn fb = new TableColumn("F(b)");
        TableColumn fxr = new TableColumn("F(xr)");
        tblResultados.getColumns().addAll(id,a,b,fa,fb,xr,fxr,error);
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
            Parent principal = FXMLLoader.load(getClass().getResource("/main/main.fxml"));
            Scene scene = new Scene(principal);
            main.Main.getPrimaryStage().setScene(scene);
        }catch (Exception e){
            System.out.println("ERROR");
        }
    }
}
