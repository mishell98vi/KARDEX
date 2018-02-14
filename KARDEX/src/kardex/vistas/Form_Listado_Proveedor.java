package kardex.vistas;

import javafx.application.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import java.util.*;
import javafx.scene.text.*;
import javafx.scene.paint.*;
import java.lang.reflect.*;
import java.text.*;
import javafx.beans.*;
import javafx.collections.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.stage.*;
import javafx.scene.image.*;
import kardex.negocio.dao.*;
import kardex.negocio.entidades.*;
import kardex.negocio.impl.*;
import kardex.accesoadatos.*;

public class Form_Listado_Proveedor {

    private TableView<Proveedor> tblProveedor;
    private Label titulo;
    private TableColumn<Proveedor, Integer> cmlRuc;
    private TableColumn<Proveedor, String> cmlNombre;
    private TableColumn<Proveedor, String> cmlDireccion;
    private TableColumn<Proveedor, String> cmlTelefono;
    private TableColumn<Proveedor, String> cmlEmail;
    private VBox pnlFinal;

    public Form_Listado_Proveedor(){

        titulo = new Label("LISTADO DE PROVEEDORES");
        titulo.setFont(Font.font("News701 BT", 20));
        tblProveedor = new TableView();
        cmlRuc = new TableColumn<>("Ruc");
        cmlNombre = new TableColumn<>("Nombre");
        cmlDireccion = new TableColumn<>("Direccion");
        cmlDireccion.setMaxWidth(250);
        cmlDireccion.setMinWidth(250);
        cmlTelefono = new TableColumn<>("Telefono");
        cmlEmail = new TableColumn<>("Email");
        cmlEmail.setMaxWidth(250);
        cmlEmail.setMinWidth(250);
        tblProveedor.getColumns().addAll(cmlRuc, cmlNombre, cmlDireccion, cmlTelefono, cmlEmail);
        cargarProveedor();
        pnlFinal = new VBox();
        Image fondoFinal = new Image("file:src\\kardex\\multimedia\\images\\fondo.jpg");
        BackgroundImage fondo = new BackgroundImage(fondoFinal, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        pnlFinal.setBackground(new Background(fondo));
        pnlFinal.setStyle("-fx-padding: 10; -fx-border-color: orange ; -fx-border-width: 2px");
        pnlFinal.getChildren().addAll(titulo, tblProveedor);
        pnlFinal.setAlignment(Pos.CENTER);
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

    public VBox getPnlFinal() {
        return pnlFinal;
    }
}
