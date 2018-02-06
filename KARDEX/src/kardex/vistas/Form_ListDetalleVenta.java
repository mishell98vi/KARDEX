
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

public class Form_ListDetalleVenta extends Application {

    private TableView<Detalle_Venta> tblDetalle_Venta;
    private Label titutlo;
    private TableColumn<Detalle_Venta, Integer> cmlCodDV;
    private TableColumn<Detalle_Venta, Producto> cmlProducto;
    private TableColumn<Detalle_Venta, Factura_Venta> cmlFacV;
    private TableColumn<Detalle_Venta, Integer> cmlCantidad;
    private TableColumn<Detalle_Venta, Double> cmlPrecioT;
    private VBox pntPrincipal;

    @Override
    public void start(Stage primaryStage) {

        titutlo = new Label("LISTADO DETALLE VENTA");
        titutlo.setFont(Font.font("News701 BT", 20));
        tblDetalle_Venta = new TableView();
        cmlCodDV = new TableColumn<>("CODIGO DETALLE VENTA");
        cmlProducto = new TableColumn<>("PRODUCTO");
        cmlFacV = new TableColumn<>("FACTURA VENTA");
        cmlCantidad = new TableColumn<>("CANTIDAD");
        cmlPrecioT = new TableColumn<>("PRECIO TOTAL");

        tblDetalle_Venta.getColumns().addAll(cmlCodDV, cmlProducto, cmlFacV, cmlCantidad, cmlPrecioT);
        cargarDetalle_Venta();
        pntPrincipal = new VBox();
        pntPrincipal.getChildren().addAll(titutlo, tblDetalle_Venta);
        pntPrincipal.setAlignment(Pos.CENTER);

        Scene scene = new Scene(pntPrincipal, 820, 650);

        primaryStage.setTitle("Listado Detalles Ventas");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
    
    public void cargarDetalle_Venta(){
     List<Detalle_Venta> listDV = new ArrayList<>();
     Detalle_VentaI dvDao = new Detalle_VentaImp();
     
     
        try {
            listDV = dvDao.obtener();
            cmlCodDV.setCellValueFactory(new PropertyValueFactory<>("codigoDVenta"));
            cmlProducto.setCellValueFactory(new PropertyValueFactory<>("producto"));
            cmlFacV.setCellValueFactory(new PropertyValueFactory<>("fVenta"));
            cmlCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
            cmlPrecioT.setCellValueFactory(new PropertyValueFactory<>("pTotal"));
            
            tblDetalle_Venta.getItems().addAll(listDV);
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            Group ptnError = new Group();
            ptnError.getChildren().add(new Label("Error: " + e.getMessage()));
            Scene error = new Scene(ptnError, 0, 0);
            
        }
        
    }
}
