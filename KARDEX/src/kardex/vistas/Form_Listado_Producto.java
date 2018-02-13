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

public class Form_Listado_Producto {

    private TableView<Producto> tblProducto;
    private Label titulo;
    private TableColumn<Producto, Integer> cmlCodProducto;
    private TableColumn<Producto, Categoria> cmlcodCategoria;
    private TableColumn<Producto, String> cmlNombre;
    private TableColumn<Producto, Double> cmprecio;
    private VBox pnlFinal;

    public Form_Listado_Producto() {

        titulo = new Label("LISTADO DE PRODUCTOS");
        titulo.setFont(Font.font("News701 BT", 20));
        tblProducto = new TableView();
        cmlCodProducto = new TableColumn<>("Codigo Producto");
        cmlcodCategoria = new TableColumn<>("Categoria");
        cmlNombre = new TableColumn<>("Nombre");
        cmprecio = new TableColumn<>("Precio");
        tblProducto.getColumns().addAll(cmlCodProducto, cmlcodCategoria, cmlNombre, cmprecio);
        cargarProducto();
        pnlFinal = new VBox();
        Image fondoFinal = new Image("file:src\\kardex\\multimedia\\images\\fondo.jpg");
        BackgroundImage fondo = new BackgroundImage(fondoFinal, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        pnlFinal.setBackground(new Background(fondo));
        pnlFinal.setStyle("-fx-padding: 10; -fx-border-color: orange ; -fx-border-width: 2px");
        pnlFinal.getChildren().addAll(titulo, tblProducto);
        pnlFinal.setAlignment(Pos.CENTER);
    }

    public VBox getPnlFinal() {
        return pnlFinal;
    }

    public void cargarProducto() {
        List<Producto> listProducto = new ArrayList<>();
        ProductoI proDao = new ProductoImp();

        try {
            listProducto = proDao.obtener();
            cmlCodProducto.setCellValueFactory(new PropertyValueFactory<>("codigoProducto"));
            cmlcodCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
            cmlNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
            cmprecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
            tblProducto.getItems().addAll(listProducto);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            Group ptnError = new Group();
            ptnError.getChildren().add(new Label("Error: " + e.getMessage()));
            Scene error = new Scene(ptnError, 0, 0);
        }
    }
}
