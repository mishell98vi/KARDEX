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
import javafx.stage.*;
import javafx.scene.image.*;
import kardex.negocio.dao.*;
import kardex.negocio.entidades.*;
import kardex.negocio.impl.*;
import kardex.accesoadatos.*;

public class Form_BuscarCategoria {

    private Label titulo;
    private Label txtCodigo;
    private Label txtNombre;
    private Label txtDescripcion;
    private TextField codigo;
    private Label nombre;
    private Label descripcion;
    private Image icono;
    private ImageView visor;
    private Categoria categoria;
    private Button btnBuscar;
    private Button btnLimpiar;
    private VBox pnlICat1;
    private VBox pnlICat2;
    private HBox pnlcat;
    private VBox pnlICat;
    private HBox pnlSup;
    private VBox pnlInt;
    private HBox pnlBotones;
    private VBox pnlFinal;

    public Form_BuscarCategoria() {
        //superior
        titulo = new Label("\" Categorias \"");
        titulo.setFont(Font.font("News701 BT", 30));
        txtCodigo = new Label("Codigo: ");
        txtCodigo.setFont(Font.font("News701 BT", 20));
        txtNombre = new Label("Nombre: ");
        txtNombre.setFont(Font.font("News701 BT", 20));
        pnlICat1 = new VBox(10);
        pnlICat1.getChildren().addAll(txtCodigo, txtNombre);
        pnlICat1.setAlignment(Pos.CENTER_RIGHT);
        pnlICat1.setPadding(new Insets(10));
        codigo = new TextField("");
        nombre = new Label("");
        nombre.setMinSize(200, 25);
        nombre.setMaxSize(200, 25);
        nombre.setStyle("-fx-border-color: black ; -fx-border-width: 2px");
        pnlICat2 = new VBox(10);
        pnlICat2.getChildren().addAll(codigo, nombre);
        pnlICat2.setAlignment(Pos.CENTER);
        pnlICat2.setPadding(new Insets(10));
        pnlcat = new HBox(10);
        pnlcat.getChildren().addAll(pnlICat1, pnlICat2);
        pnlcat.setPadding(new Insets(10));
        pnlICat = new VBox(10);
        pnlICat.getChildren().addAll(titulo, pnlcat);
        pnlICat.setAlignment(Pos.CENTER);
        pnlSup = new HBox(10);
        icono = new Image("file:src\\kardex\\multimedia\\images\\iconoCategoria.png");
        visor = new ImageView(icono);
        visor.setFitHeight(75);
        visor.setFitWidth(75);
        pnlSup.getChildren().addAll(pnlICat, visor);
        pnlSup.setAlignment(Pos.CENTER);
        txtDescripcion = new Label("Descripcion: ");
        txtDescripcion.setFont(Font.font("News701 BT", 25));
        descripcion = new Label("");
        descripcion.setMaxSize(350, 100);
        descripcion.setMinSize(350, 100);
        descripcion.setStyle("-fx-border-color: black ; -fx-border-width: 2px");
        pnlInt = new VBox(10);
        pnlInt.getChildren().addAll(txtDescripcion, descripcion);
        pnlInt.setAlignment(Pos.CENTER);
        btnBuscar = new Button("Buscar");
        btnBuscar.setFont(Font.font("News701 BT", 20));
        btnBuscar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                bBuscarEventHandler(event);
            }
        });
        btnLimpiar = new Button("Limpiar");
        btnLimpiar.setFont(Font.font("News701 BT", 20));
        btnLimpiar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                bLimpiarEventHandler(event);
            }
        });

        pnlBotones = new HBox(25);
        pnlBotones.getChildren().addAll(btnBuscar, btnLimpiar);
        pnlBotones.setAlignment(Pos.CENTER);
        pnlFinal = new VBox(10);
        Image fondoFinal = new Image("file:src\\kardex\\multimedia\\images\\FONDOO.jpg");
        BackgroundImage fondo = new BackgroundImage(fondoFinal, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        pnlFinal.setBackground(new Background(fondo));
        pnlFinal.setStyle("-fx-padding: 10; -fx-border-color: black ; -fx-border-width: 2px");
        pnlFinal.getChildren().addAll(pnlSup, pnlInt, pnlBotones);
        pnlFinal.setPadding(new Insets(10));
    }

    public void bBuscarEventHandler(ActionEvent event) {
        CategoriaI categDao = new CategoriaImp();
        Categoria nCategoria = new Categoria();
        try {
            categoria=categDao.obtener(Integer.parseInt(codigo.getText()));
            nombre.setText(categoria.getNombre());
            descripcion.setText(categoria.getDescripcion());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void bLimpiarEventHandler(ActionEvent event) {
        codigo.setText("");
        nombre.setText("");
        descripcion.setText("");

    }

    public Node getPnlFinal() {
        return pnlFinal;
    }
}
