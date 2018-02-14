
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

public class Form_Nueva_DetalleVenta{
    private Image icono;
    private ImageView visor;
    private Label titulo;
    private Label txtCod;
    private Label txtProd;
    private Label txtPrecio;
    private Label precio;
    private Label txtCant;
    private Label txtFactVenta;
    private Label txtTotal;
    private TextField cod;
    private TextField cant;
    private Label total;
    private ComboBox<Producto> lstProd;
    private ComboBox<Factura_Venta> lstFactura;
    private Button btnIngresar;
    private Button btnLimpiar;
    private Button btnCancelar;
    
    private HBox pnlTitulo;
    private HBox pnlCod;
    private HBox pnlProdPrecio;
    private HBox pnlCantTotal;
    private VBox pnlFactVenta;
    private HBox pnlBotones;
    private VBox pnlFinal;
    
    public Form_Nueva_DetalleVenta(){
        icono=new Image("file:src\\kardex\\multimedia\\images\\iconoProveedor.jpg");
        visor=new ImageView(icono);
        visor.setFitHeight(100);
        visor.setFitWidth(150);
        titulo=new Label("Detalle Venta");
        titulo.setFont(Font.font("News701 BT", 20));
        pnlTitulo=new HBox(5);
        pnlTitulo.getChildren().addAll(visor, titulo);
        pnlTitulo.setAlignment(Pos.CENTER);
        pnlTitulo.setPadding(new Insets(5));
        txtCod=new Label("Codigo: ");
        txtCod.setFont(Font.font("News701 BT", 20));
        cod=new TextField("");
        pnlCod=new HBox(5);
        pnlCod.getChildren().addAll(txtCod,cod);
        pnlCod.setAlignment(Pos.CENTER);
        pnlCod.setPadding(new Insets(5));
        txtProd=new Label("Producto: ");
        txtProd.setFont(Font.font("News701 BT", 20));
        lstProd=new ComboBox<>();
        txtPrecio=new Label("Precio: ");
        txtPrecio.setFont(Font.font("News701 BT", 20));
        precio=new Label("        ");
        pnlProdPrecio=new HBox(5);
        pnlProdPrecio.getChildren().addAll(txtProd,lstProd,txtPrecio,precio);
        pnlProdPrecio.setAlignment(Pos.CENTER);
        pnlProdPrecio.setPadding(new Insets(5));
        txtCant=new Label("cantidad: ");
        txtCant.setFont(Font.font("News701 BT", 20));
        cant=new TextField("");
        txtTotal=new Label("Total: ");
        txtTotal.setFont(Font.font("News701 BT", 20));
        total=new Label("         ");
        pnlCantTotal=new HBox(5);
        pnlCantTotal.getChildren().addAll(txtCant,cant,txtTotal,total);
        pnlCantTotal.setAlignment(Pos.CENTER);
        pnlCantTotal.setPadding(new Insets(5));
        txtFactVenta=new Label("Factura venta: ");
        txtFactVenta.setFont(Font.font("News701 BT", 20));
        lstFactura=new ComboBox<>();
        pnlFactVenta=new VBox(5);
        pnlFactVenta.getChildren().addAll(txtFactVenta,lstFactura);
        pnlFactVenta.setAlignment(Pos.CENTER);
        pnlFactVenta.setPadding(new Insets(5));
        btnIngresar=new Button("Ingresar");
        btnIngresar.setFont(Font.font("News701 BT", 15));
        btnIngresar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                bIngresarEventHandler(event);
            }
        });
        
        btnLimpiar=new Button("Limpiar");
        btnLimpiar.setFont(Font.font("News701 BT", 15));
        btnLimpiar.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
               btnLimpiarEventHandler(event);
           }
       });
        btnCancelar=new Button("Salir");
        btnCancelar.setFont(Font.font("News701 BT", 15));
         btnCancelar.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
               btnCancelarEventHandler(event);
           }
       });
        pnlBotones=new HBox(25);
        pnlBotones.getChildren().addAll(btnIngresar,btnLimpiar,btnCancelar);
        pnlBotones.setAlignment(Pos.CENTER);
        pnlBotones.setPadding(new Insets(5));
        pnlFinal=new VBox(10);
        pnlFinal.getChildren().addAll(pnlTitulo,pnlCod, pnlProdPrecio, pnlCantTotal, pnlFactVenta, pnlBotones);
        pnlFinal.setPadding(new Insets(10));
        Image fondoFinal = new Image("file:src\\kardex\\multimedia\\images\\fondo.jpg");
        BackgroundImage fondo = new BackgroundImage(fondoFinal, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        pnlFinal.setBackground(new Background(fondo));
        pnlFinal.setStyle("-fx-padding: 10; -fx-border-color: orange ; -fx-border-width: 2px");
        Scene scene = new Scene(pnlFinal, 460, 400);
    }
    
    public void bIngresarEventHandler(ActionEvent event) {
        Detalle_VentaI detvDao = new Detalle_VentaImp();
        Detalle_Venta nDetalleVenta = new Detalle_Venta();
        try {
            nDetalleVenta.setCodigoDVenta(Integer.parseInt(cod.getText()));
            nDetalleVenta.setCantidad(Integer.parseInt(cant.getText()));
            nDetalleVenta.setpTotal(Double.parseDouble(total.getText()));
            nDetalleVenta.setProducto(lstProd.getSelectionModel().getSelectedItem());
            nDetalleVenta.setfVenta(lstFactura.getSelectionModel().getSelectedItem());
            if (detvDao.ingresar(nDetalleVenta) > 0) {
                System.out.println("Ingreso correcto");
            } else {
                System.out.println("Ingreso Incorrecto");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
     public void btnLimpiarEventHandler(ActionEvent event){
        cod.setText("");
        cant.setText("");
        total.setText("");

           }
     public void btnCancelarEventHandler(ActionEvent event){
        System.exit(0);
    }

    public VBox getPnlFinal() {
        return pnlFinal;
    }
}