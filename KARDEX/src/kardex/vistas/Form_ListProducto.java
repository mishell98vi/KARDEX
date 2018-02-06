
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

public class Form_ListProducto extends Application {

    private TableView<Producto> tblProducto;
    private Label titulo;
    private TableColumn<Producto, Integer> cmlCodProducto;
    private TableColumn<Producto, Categoria> cmlcodCategoria;
    private TableColumn<Producto, String> cmlNombre;
    private TableColumn<Producto, Double> cmprecio;
    private VBox pntPrincipal;

    @Override

    public void start(Stage primaryStage) {

        titulo = new Label("LISTADO DE PRODUCTOS");
        titulo.setFont(Font.font("News701 BT", 20));
        tblProducto = new TableView();
        cmlCodProducto = new TableColumn<>("Codigo Producto");
        cmlcodCategoria = new TableColumn<>("Categoria");
        cmlNombre = new TableColumn<>("Nombre");
        cmprecio = new TableColumn<>("Precio");
        tblProducto.getColumns().addAll(cmlCodProducto, cmlcodCategoria, cmlNombre, cmprecio);
        cargarProducto();
        pntPrincipal = new VBox();
        pntPrincipal.getChildren().addAll(titulo, tblProducto);
        pntPrincipal.setAlignment(Pos.CENTER);
        Scene scene = new Scene(pntPrincipal, 425, 250);

        primaryStage.setTitle("Listado de Producto.");
        primaryStage.setScene(scene);
        primaryStage.show();
        

    }
    public static void main(String[] args) {
        launch(args);
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
