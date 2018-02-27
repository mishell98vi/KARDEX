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

public class Form_Listado_Categoria{

    private TableView<Categoria> tblCategoria;
    private Label titulo;
    private TableColumn<Categoria, Integer> cmlCodCategoria;
    private TableColumn<Categoria, String> cmlNombreCategoria;
    private TableColumn<Categoria, String> cmlDescrCategoria;
    private VBox pnlFinal;

    
    public Form_Listado_Categoria() {

        titulo = new Label("LISTADO DE CATEGORIAS");
        titulo.setFont(Font.font("News701 BT", 20));
        tblCategoria = new TableView();
        cmlCodCategoria = new TableColumn<>("Codigo");
        cmlNombreCategoria = new TableColumn<>("Nombre");
        cmlDescrCategoria = new TableColumn<>("Descripcion");
        cmlDescrCategoria.setMaxWidth(250);
        cmlDescrCategoria.setMinWidth(250);
        tblCategoria.getColumns().addAll(cmlCodCategoria, cmlNombreCategoria, cmlDescrCategoria);
        cargarCategorias();
        pnlFinal = new VBox();
        Image fondoFinal = new Image("file:src\\kardex\\multimedia\\images\\fondo.jpg");
        BackgroundImage fondo = new BackgroundImage(fondoFinal, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        pnlFinal.setBackground(new Background(fondo));
        pnlFinal.setStyle("-fx-padding: 10; -fx-border-color: black ; -fx-border-width: 2px");
        pnlFinal.getChildren().addAll(titulo, tblCategoria);
        pnlFinal.setAlignment(Pos.CENTER);
    }

    public VBox getPnlFinal() {
        return pnlFinal;
    }

    public void cargarCategorias() {
        List<Categoria> listCategorias = new ArrayList<>();
        CategoriaI categDao = new CategoriaImp();

        try {
            listCategorias = categDao.obtener();
            cmlCodCategoria.setCellValueFactory(new PropertyValueFactory<>("codigoCategoria"));
            cmlNombreCategoria.setCellValueFactory(new PropertyValueFactory<>("nombre"));
            cmlDescrCategoria.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
            tblCategoria.getItems().addAll(listCategorias);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            Group ptnError = new Group();
            ptnError.getChildren().add(new Label("Error: " + e.getMessage()));
            Scene error = new Scene(ptnError, 0, 0);
        }
    }
}
