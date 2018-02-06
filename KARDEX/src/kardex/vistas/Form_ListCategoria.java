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

public class Form_ListCategoria extends Application {

    private TableView<Categoria> tblCategoria;
    private Label titulo;
    private TableColumn<Categoria, Integer> cmlCodCategoria;
    private TableColumn<Categoria, String> cmlNombreCategoria;
    private TableColumn<Categoria, String> cmlDescrCategoria;
    private VBox pntPrincipal;

    @Override
    public void start(Stage primaryStage) {

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
        pntPrincipal = new VBox();
        pntPrincipal.getChildren().addAll(titulo, tblCategoria);
        pntPrincipal.setAlignment(Pos.CENTER);
        Scene scene = new Scene(pntPrincipal, 425, 250);

        primaryStage.setTitle("Listado de Categorias");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
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
