
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
public class Form_ListFacturaVenta extends Application {
    private TableView<Factura_Venta> tblFactura_Venta;
    private Label titulo;
    private TableColumn<Factura_Venta, Integer> cmlcodFactura_Venta;
    private TableColumn<Factura_Venta, String> cmlFecha;
    private TableColumn<Factura_Venta, Cliente> cmlCliente;
    
    private VBox pntPrincipal;
    @Override
    public void start(Stage primaryStage) {
         titulo = new Label("LISTADO DE FACTURA VENTA");
        titulo.setFont(Font.font("News701 BT", 20));
        tblFactura_Venta = new TableView();
        cmlcodFactura_Venta = new TableColumn<>("Codigo Fac_Vent");
        cmlFecha= new TableColumn<>("Fecha");
        cmlCliente = new TableColumn<>("Cliente");
       
        tblFactura_Venta.getColumns().addAll(cmlcodFactura_Venta, cmlFecha, cmlCliente);
        cargarFactura_Venta();
        pntPrincipal = new VBox();
        pntPrincipal.getChildren().addAll(titulo, tblFactura_Venta);
        pntPrincipal.setAlignment(Pos.CENTER);
        Scene scene = new Scene(pntPrincipal, 425, 250);

        primaryStage.setTitle("Listado de Factura Ventas");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void cargarFactura_Venta() {
        List<Factura_Venta> listFV = new ArrayList<>();
        Factura_VentaI fvDao = new Factura_VentaImp();

        try {
            listFV = fvDao.obtener();
            cmlcodFactura_Venta.setCellValueFactory(new PropertyValueFactory<>("codigoFVenta"));
            cmlFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
            cmlCliente.setCellValueFactory(new PropertyValueFactory<>("cliente"));
            
            tblFactura_Venta.getItems().addAll(listFV);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            Group ptnError = new Group();
            ptnError.getChildren().add(new Label("Error: " + e.getMessage()));
            Scene error = new Scene(ptnError, 0, 0);
        }
    }
}
