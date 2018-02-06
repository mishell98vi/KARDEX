
package kardex.vistas;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.util.*;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.control.cell.PropertyValueFactory;
import kardex.negocio.dao.*;
import kardex.negocio.entidades.*;
import kardex.negocio.impl.*;
import kardex.accesoadatos.*;

public class Form_ListCliente extends Application {
    private TableView<Cliente> tblCliente;
    private Label titulo;
    private TableColumn<Cliente, Integer> cmlCedula;
    private TableColumn<Cliente, String> cmlNombre;
    private TableColumn<Cliente, String> cmlApellido;
    private TableColumn<Cliente, String> cmlDireccion;
    private TableColumn<Cliente, String> cmlTelefono;
    private TableColumn<Cliente, String> cmleMail;
    private TableColumn<Cliente, String> cmlFechaNac;
    private VBox pntPrincipal;
    @Override
    public void start(Stage primaryStage) {
         titulo = new Label("LISTADO DE CLIENTES");
        titulo.setFont(Font.font("News701 BT", 20));
        tblCliente = new TableView();
        cmlCedula = new TableColumn<>("Codigo");
        cmlNombre= new TableColumn<>("Nombres");
        cmlApellido = new TableColumn<>("Apellidos");
        cmlDireccion = new TableColumn<>("Direccion");
        cmlDireccion.setMaxWidth(150);
        cmlDireccion.setMinWidth(150);
        cmlTelefono = new TableColumn<>("Telefono");
        cmleMail = new TableColumn<>("Email");
        cmleMail.setMaxWidth(150);
        cmleMail.setMinWidth(150);
        cmlFechaNac = new TableColumn<>("Fecha_Nacimiento");
        tblCliente.getColumns().addAll(cmlCedula, cmlNombre, cmlApellido,cmlDireccion,cmlTelefono,cmleMail,cmlFechaNac);
        cargarClientes();
        pntPrincipal = new VBox();
        pntPrincipal.getChildren().addAll(titulo, tblCliente);
        pntPrincipal.setAlignment(Pos.CENTER);
        Scene scene = new Scene(pntPrincipal, 425, 250);

        primaryStage.setTitle("Listado de Clientes");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void cargarClientes() {
        List<Cliente> listCliente = new ArrayList<>();
        ClienteI clientDao = new ClienteImp();

        try {
            listCliente = clientDao.obtener();
            cmlCedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
            cmlNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
            cmlApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
            cmlDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
            cmlTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
            cmleMail.setCellValueFactory(new PropertyValueFactory<>("email"));
            cmlFechaNac.setCellValueFactory(new PropertyValueFactory<>("fechaNac"));
            tblCliente.getItems().addAll(listCliente);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            Group ptnError = new Group();
            ptnError.getChildren().add(new Label("Error: " + e.getMessage()));
            Scene error = new Scene(ptnError, 0, 0);
        }
    }
}
