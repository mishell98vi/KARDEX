/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kardex.vistas;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.util.*;

import javafx.scene.text.*;
import javafx.scene.paint.*;
import java.lang.reflect.Field;

import java.text.DateFormat;
import java.text.MessageFormat;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import kardex.negocio.dao.CategoriaI;
import kardex.negocio.entidades.Categoria;
import kardex.negocio.impl.CategoriaImp;

public class Form_Producto  extends Application {
    
    private Text txtCodigo;
    private Text txtCategoria;

    private Text txtNombre;
    private Text txtPrecio;

    private TextArea codigo;
    private TextArea nombre;
    private TextArea precio;
    private TextArea descrCategoria;

    private ComboBox<Categoria> cbxCategoria;
    private ObservableList<Categoria> obsCateg;
    private ArrayList<Categoria> listCategories;

    private Button btnAceptar;
    private Button btnModificar;
    private Button btnEliminar;
    private Button btnLimpiar;
    private Button btnCancelar;

    private VBox pnlProducto;
    private VBox pnlCategoria;
    private GridPane pnlCentral;
    private GridPane pnlBotones;
    private GridPane pnlPrincipal;

    @Override
    public void start(Stage primaryStage) {
        txtCodigo = new Text("Codigo");
        txtCodigo.setFont(javafx.scene.text.Font.font("Arial Black", 20));
        codigo = new TextArea("");
        txtNombre = new Text("Nombre");
        txtNombre.setFont(javafx.scene.text.Font.font("Arial Black", 20));
        nombre = new TextArea("");
        txtPrecio = new Text("Precio");
        txtPrecio.setFont(javafx.scene.text.Font.font("Arial Black", 20));
        precio = new TextArea("");

        txtCategoria = new Text("Categoria");
        txtCategoria.setFont(javafx.scene.text.Font.font("Arial Black", 20));
        
        cargarCategorias();
        cbxCategoria = new ComboBox<Categoria>();
        cbxCategoria.getItems();
        descrCategoria = new TextArea("");
        
        btnAceptar = new Button("Aceptar");
        btnAceptar.setFont(Font.font("Arial Black", 20));
        btnModificar = new Button("Modificar");
        btnModificar.setFont(Font.font("Arial Black", 20));
        btnEliminar = new Button("Eliminar");
        btnEliminar.setFont(Font.font("Arial Black", 20));
        btnLimpiar = new Button("Limpiar");
        btnLimpiar.setFont(Font.font("Arial Black", 20));
        btnCancelar = new Button("Cancelar");
        btnCancelar.setFont(Font.font("Arial Black", 20));

        pnlProducto = new VBox(20);
        pnlProducto.getChildren().add(txtCodigo);
        pnlProducto.getChildren().add(codigo);
        pnlProducto.getChildren().add(txtNombre);
        pnlProducto.getChildren().add(nombre);
        pnlProducto.getChildren().add(txtPrecio);
        pnlProducto.getChildren().add(precio);

        pnlCategoria = new VBox(20);
        pnlCategoria.getChildren().add(txtCategoria);
        pnlCategoria.getChildren().add(cbxCategoria);
        pnlCategoria.getChildren().add(descrCategoria);

        pnlCentral = new GridPane();
        pnlCentral.setVgap(10);
        pnlCentral.setHgap(10);
        pnlCentral.add(pnlProducto, 0, 0);
        pnlCentral.add(pnlCategoria, 1, 0);

        pnlBotones = new GridPane();
        pnlBotones.setVgap(10);
        pnlBotones.setHgap(10);
        pnlBotones.add(btnAceptar, 0, 0);
        pnlBotones.add(btnLimpiar, 1, 0);
        pnlBotones.add(btnCancelar, 2, 0);
        pnlBotones.setAlignment(Pos.CENTER);

        pnlPrincipal = new GridPane();
        pnlPrincipal.setVgap(10);
        pnlPrincipal.setHgap(10);
        pnlPrincipal.add(pnlCentral, 0, 0);
        pnlPrincipal.add(pnlBotones, 0, 1);
        pnlPrincipal.setPadding(new Insets(25));

        Scene scene = new Scene(pnlPrincipal, 600, 400);
        primaryStage.setTitle("Producto");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void cargarCategorias() {
        listCategories = new ArrayList<>();
        CategoriaI categDao = new CategoriaImp();
        try {
            listCategories=categDao.obtener();
            obsCateg.addAll(listCategories);
//            cbxCategoria.setItems(value);
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(this, "ERROR AL CARGAR CURSOS", "ERROR" + e.getMessage(), JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
}
