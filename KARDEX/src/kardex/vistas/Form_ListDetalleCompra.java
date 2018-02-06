
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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.control.cell.PropertyValueFactory;
import kardex.negocio.dao.*;
import kardex.negocio.entidades.*;
import kardex.negocio.impl.*;
import kardex.accesoadatos.*;

public class Form_ListDetalleCompra extends Application {
    private TableView<Detalle_Compra> tblDetalle_Compra;
    private Label titulo;
    private TableColumn<Detalle_Compra, Integer> cmlcodDetalle_Compra;
    private TableColumn<Detalle_Compra, Producto> cmlProducto;
    private TableColumn<Detalle_Compra, Factura_Compra> cmlfacturaCompra;
    private TableColumn<Detalle_Compra, Integer> cmlCantidad;
    private TableColumn<Detalle_Compra, Double> cmlprecioTotal;
    private VBox pntPrincipal;
    
    @Override
    public void start(Stage primaryStage) {
        titulo = new Label("LISTADO DE DETALLE COMPRA");
        titulo.setFont(Font.font("News701 BT", 20));
        tblDetalle_Compra = new TableView();
        
        cmlcodDetalle_Compra = new TableColumn<>("Codigo Detalle_Compra");
        cmlProducto= new TableColumn<>("Producto");
        cmlfacturaCompra = new TableColumn<>("Codigo Factura_Compra");
        cmlCantidad = new TableColumn<>("Cantidad");
        cmlprecioTotal = new TableColumn<>("Precio_Total");
       
        tblDetalle_Compra.getColumns().addAll(cmlcodDetalle_Compra, cmlProducto, cmlfacturaCompra,cmlCantidad,cmlprecioTotal);
        cargarDetalle_Compra();
        pntPrincipal = new VBox();
        pntPrincipal.getChildren().addAll(titulo, tblDetalle_Compra);
        pntPrincipal.setAlignment(Pos.CENTER);
        Scene scene = new Scene(pntPrincipal, 425, 250);

        primaryStage.setTitle("Listado de Detalle Compra");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void cargarDetalle_Compra() {
        List<Detalle_Compra> listDC = new ArrayList<>();
        Detalle_CompraI dcDao = new Detalle_CompraImp();

        try {
            listDC = dcDao.obtener();
           
            cmlcodDetalle_Compra.setCellValueFactory(new PropertyValueFactory<>("codigoDcompra"));
            cmlProducto.setCellValueFactory(new PropertyValueFactory<>("producto"));
            cmlfacturaCompra.setCellValueFactory(new PropertyValueFactory<>("fCompra"));
            cmlCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
            cmlprecioTotal.setCellValueFactory(new PropertyValueFactory<>("pTotal"));
            
            tblDetalle_Compra.getItems().addAll(listDC);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            Group ptnError = new Group();
            ptnError.getChildren().add(new Label("Error: " + e.getMessage()));
            Scene error = new Scene(ptnError, 0, 0);
        }
    }
}
