
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


public class Form_ListProveedor extends Application {
   
    
    private TableView<Proveedor> tblProveedor;
    private Label titulo;
    private TableColumn<Proveedor, Integer> cmlRuc;
    private TableColumn<Proveedor, String> cmlNombre;
    private TableColumn<Proveedor, String> cmlDireccion;
    private TableColumn<Proveedor, String> cmlTelefono;
    private TableColumn<Proveedor, String> cmlEmail;
    private VBox pntPrincipal;
    
    @Override
    public void start(Stage primaryStage) {
        
        titulo = new Label("LISTADO DE PROVEEDORES");
        titulo.setFont(Font.font("News701 BT", 20));
        tblProveedor = new TableView();
        cmlRuc = new TableColumn<>("Ruc");
        cmlNombre = new TableColumn<>("Nombre");
        cmlDireccion = new TableColumn<>("Direccion");
        cmlDireccion.setMaxWidth(250);
        cmlDireccion.setMinWidth(250);
        cmlTelefono = new TableColumn<>("Telefono");
        cmlEmail = new TableColumn<>("eMail");
        cmlEmail.setMaxWidth(250);
        cmlEmail.setMinWidth(250);
        tblProveedor.getColumns().addAll(cmlRuc, cmlNombre, cmlDireccion,cmlTelefono,cmlEmail);
        cargarProveedor();
        pntPrincipal = new VBox();
        pntPrincipal.getChildren().addAll(titulo, tblProveedor);
        pntPrincipal.setAlignment(Pos.CENTER);
        Scene scene = new Scene(pntPrincipal, 425, 250);

        primaryStage.setTitle("Listado de Proveedores.");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void cargarProveedor() {
        List<Proveedor> listProveedor = new ArrayList<>();
        ProveedorI proDao = new ProveedorImp();

        try {
            listProveedor = proDao.obtener();
            cmlRuc.setCellValueFactory(new PropertyValueFactory<>("ruc"));
            cmlNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
            cmlDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
            cmlTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
            cmlEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
            tblProveedor.getItems().addAll(listProveedor);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            Group ptnError = new Group();
            ptnError.getChildren().add(new Label("Error: " + e.getMessage()));
            Scene error = new Scene(ptnError, 0, 0);
        }
    }
}
