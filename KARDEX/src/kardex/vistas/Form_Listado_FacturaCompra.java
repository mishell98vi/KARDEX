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

public class Form_Listado_FacturaCompra {

    private TableView<Factura_Compra> tblFactura_Compra;
    private Label titulo;
    private TableColumn<Factura_Compra, Integer> cmlcodFactura_Compra;
    private TableColumn<Factura_Compra, String> cmlFecha;
    private TableColumn<Factura_Compra, Proveedor> cmlProveedor;
    private VBox pnlFinal;

    public Form_Listado_FacturaCompra() {
        titulo = new Label("LISTADO DE FACTURA COMPRA");
        titulo.setFont(Font.font("News701 BT", 20));
        tblFactura_Compra = new TableView();
        cmlcodFactura_Compra = new TableColumn<>("Codigo Fac_Com");
        cmlFecha = new TableColumn<>("Fecha");
        cmlProveedor = new TableColumn<>("Proveedor");
        tblFactura_Compra.getColumns().addAll(cmlcodFactura_Compra, cmlFecha, cmlProveedor);
        cargarFactura_Compra();
        pnlFinal = new VBox();
        Image fondoFinal = new Image("file:src\\kardex\\multimedia\\images\\fondo.jpg");
        BackgroundImage fondo = new BackgroundImage(fondoFinal, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        pnlFinal.setBackground(new Background(fondo));
        pnlFinal.setStyle("-fx-padding: 10; -fx-border-color: orange ; -fx-border-width: 2px");
        pnlFinal.getChildren().addAll(titulo, tblFactura_Compra);
        pnlFinal.setAlignment(Pos.CENTER);
    }

    public VBox getPnlFinal() {
        return pnlFinal;
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
