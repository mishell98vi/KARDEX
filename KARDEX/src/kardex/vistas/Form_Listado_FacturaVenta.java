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

public class Form_Listado_FacturaVenta {

    private TableView<Factura_Venta> tblFactura_Venta;
    private Label titulo;
    private TableColumn<Factura_Venta, Integer> cmlcodFactura_Venta;
    private TableColumn<Factura_Venta, String> cmlFecha;
    private TableColumn<Factura_Venta, Cliente> cmlCliente;
    private VBox pnlFinal;

    public Form_Listado_FacturaVenta() {
        titulo = new Label("LISTADO DE FACTURA VENTA");
        titulo.setFont(Font.font("News701 BT", 20));
        tblFactura_Venta = new TableView();
        cmlcodFactura_Venta = new TableColumn<>("Codigo Fac_Vent");
        cmlFecha = new TableColumn<>("Fecha");
        cmlCliente = new TableColumn<>("Cliente");

        tblFactura_Venta.getColumns().addAll(cmlcodFactura_Venta, cmlFecha, cmlCliente);
        cargarFactura_Venta();
        pnlFinal = new VBox();
        Image fondoFinal = new Image("file:src\\kardex\\multimedia\\images\\fondo.jpg");
        BackgroundImage fondo = new BackgroundImage(fondoFinal, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        pnlFinal.setBackground(new Background(fondo));
        pnlFinal.setStyle("-fx-padding: 10; -fx-border-color: orange ; -fx-border-width: 2px");
        pnlFinal.getChildren().addAll(titulo, tblFactura_Venta);
        pnlFinal.setAlignment(Pos.CENTER);
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

    public VBox getPnlFinal() {
        return pnlFinal;
    }
}
