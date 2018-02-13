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

public class Form_Listado_DetalleCompra {

    private TableView<Detalle_Compra> tblDetalle_Compra;
    private Label titulo;
    private TableColumn<Detalle_Compra, Integer> cmlcodDetalle_Compra;
    private TableColumn<Detalle_Compra, Producto> cmlProducto;
    private TableColumn<Detalle_Compra, Factura_Compra> cmlfacturaCompra;
    private TableColumn<Detalle_Compra, Integer> cmlCantidad;
    private TableColumn<Detalle_Compra, Double> cmlprecioTotal;
    private VBox pnlFinal;

    public Form_Listado_DetalleCompra() {
        titulo = new Label("LISTADO DE DETALLE COMPRA");
        titulo.setFont(Font.font("News701 BT", 20));
        tblDetalle_Compra = new TableView();

        cmlcodDetalle_Compra = new TableColumn<>("Codigo Detalle_Compra");
        cmlProducto = new TableColumn<>("Producto");
        cmlfacturaCompra = new TableColumn<>("Codigo Factura_Compra");
        cmlCantidad = new TableColumn<>("Cantidad");
        cmlprecioTotal = new TableColumn<>("Precio_Total");

        tblDetalle_Compra.getColumns().addAll(cmlcodDetalle_Compra, cmlProducto, cmlfacturaCompra, cmlCantidad, cmlprecioTotal);
        cargarDetalle_Compra();
        pnlFinal = new VBox();
        Image fondoFinal = new Image("file:src\\kardex\\multimedia\\images\\fondo.jpg");
        BackgroundImage fondo = new BackgroundImage(fondoFinal, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        pnlFinal.setBackground(new Background(fondo));
        pnlFinal.setStyle("-fx-padding: 10; -fx-border-color: orange ; -fx-border-width: 2px");
        pnlFinal.getChildren().addAll(titulo, tblDetalle_Compra);
        pnlFinal.setAlignment(Pos.CENTER);
    }

    public VBox getPnlFinal() {
        return pnlFinal;
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
