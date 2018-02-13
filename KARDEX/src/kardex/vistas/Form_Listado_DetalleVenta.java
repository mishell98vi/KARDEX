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

public class Form_Listado_DetalleVenta {

    private TableView<Detalle_Venta> tblDetalle_Venta;
    private Label titutlo;
    private TableColumn<Detalle_Venta, Integer> cmlCodDV;
    private TableColumn<Detalle_Venta, Producto> cmlProducto;
    private TableColumn<Detalle_Venta, Factura_Venta> cmlFacV;
    private TableColumn<Detalle_Venta, Integer> cmlCantidad;
    private TableColumn<Detalle_Venta, Double> cmlPrecioT;
    private VBox pnlFinal;

    public Form_Listado_DetalleVenta() {

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
        pnlFinal = new VBox();
        Image fondoFinal = new Image("file:src\\kardex\\multimedia\\images\\fondo.jpg");
        BackgroundImage fondo = new BackgroundImage(fondoFinal, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        pnlFinal.setBackground(new Background(fondo));
        pnlFinal.setStyle("-fx-padding: 10; -fx-border-color: orange ; -fx-border-width: 2px");
        pnlFinal.getChildren().addAll(titutlo, tblDetalle_Venta);
        pnlFinal.setAlignment(Pos.CENTER);

    }

    public VBox getPnlFinal() {
        return pnlFinal;
    }

    public void cargarDetalle_Venta() {
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
