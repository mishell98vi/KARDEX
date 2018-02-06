
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

public class Form_ListFacturaCompra extends Application {
    private TableView<Factura_Compra> tblFactura_Compra;
    private Label titulo;
    private TableColumn<Factura_Compra, Integer> cmlcodFactura_Compra;
    private TableColumn<Factura_Compra, String> cmlFecha;
    private TableColumn<Factura_Compra, Proveedor> cmlProveedor;
    
    private VBox pntPrincipal;
    @Override
    public void start(Stage primaryStage) {
         titulo = new Label("LISTADO DE FACTURA COMPRA");
        titulo.setFont(Font.font("News701 BT", 20));
        tblFactura_Compra = new TableView();
        cmlcodFactura_Compra = new TableColumn<>("Codigo Fac_Com");
        cmlFecha= new TableColumn<>("Fecha");
        cmlProveedor = new TableColumn<>("Proveedor");
       
        tblFactura_Compra.getColumns().addAll(cmlcodFactura_Compra, cmlFecha, cmlProveedor);
        cargarFactura_Compra();
        pntPrincipal = new VBox();
        pntPrincipal.getChildren().addAll(titulo, tblFactura_Compra);
        pntPrincipal.setAlignment(Pos.CENTER);
        Scene scene = new Scene(pntPrincipal, 425, 250);

        primaryStage.setTitle("Listado de Factura Compra");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void cargarFactura_Compra() {
        List<Factura_Compra> listFV = new ArrayList<>();
        Factura_CompraI fvDao = new Factura_CompraImp();

        try {
            listFV = fvDao.obtener();
            cmlcodFactura_Compra.setCellValueFactory(new PropertyValueFactory<>("codFCompra"));
            cmlFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
            cmlProveedor.setCellValueFactory(new PropertyValueFactory<>("proveedor"));
            
            tblFactura_Compra.getItems().addAll(listFV);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            Group ptnError = new Group();
            ptnError.getChildren().add(new Label("Error: " + e.getMessage()));
            Scene error = new Scene(ptnError, 0, 0);
        }
    }
}
