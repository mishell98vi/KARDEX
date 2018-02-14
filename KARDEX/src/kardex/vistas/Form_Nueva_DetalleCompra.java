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

public class Form_Nueva_DetalleCompra{

    private Label txtcod;
    private Label txtProd;
    private Label txtPrecio;
    private Label precio;
    private Label txtCant;
    private Label txtFactComp;
    private Label txtTotal;
    private Label total;
    private TextField cod;
    private TextField cant;
    private ComboBox<Producto> lstProd;
    private ObservableList<Producto> itemProd=FXCollections.observableArrayList();
    private ArrayList<Producto> listProd;
    private ComboBox<Factura_Compra> lstFactura;
    private ObservableList<Factura_Compra> itemfc=FXCollections.observableArrayList();
    private ArrayList<Factura_Compra> listfc;
    
    private Image icono;
    private ImageView visor;
    private Button btnIngresar;
    private Button btnLimpiar;
    private Button btnCancelar;
    private HBox pnlcod;
    private HBox pnlProd;
    private HBox pnlprecio;
    private HBox pnlcant;
    private VBox pnlfactura;
    private HBox pnlBotones;
    private VBox pnlSup;
    private VBox pnlFinal;

    public Form_Nueva_DetalleCompra() {
        txtcod=new Label("Codigo: ");
        txtcod.setFont(Font.font("News701 BT", 20));
        txtProd=new Label("Producto: ");
        txtProd.setFont(Font.font("News701 BT", 20));
        txtPrecio=new Label("Precio: ");
        txtPrecio.setFont(Font.font("News701 BT", 20));
        precio=new Label("          ");
        precio.setFont(Font.font("News701 BT", 20));
        txtCant=new Label("Cantidad: ");
        txtCant.setFont(Font.font("News701 BT", 20));
        txtFactComp=new Label("Factura: ");
        txtFactComp.setFont(Font.font("News701 BT", 20));
        txtTotal=new Label("Total: ");
        txtTotal.setFont(Font.font("News701 BT", 20));
        total=new Label("           ");
        total.setFont(Font.font("News701 BT", 20));
        cod=new TextField("");
        cant=new TextField("");
        lstProd=new ComboBox<>();
        lstFactura=new ComboBox<>();
        cargarProductos();
        cargarFacturaCompra();
        lstFactura.setItems(itemfc);
        lstProd.setItems(itemProd);
        pnlcod=new HBox(5);
        pnlcod.getChildren().addAll(txtcod, cod);
        pnlcod.setPadding(new Insets(5));
        pnlcod.setAlignment(Pos.CENTER_LEFT);
        pnlProd=new HBox(5);
        pnlProd.getChildren().addAll(txtProd, lstProd, txtPrecio, precio);
        pnlProd.setPadding(new Insets(5));
        pnlProd.setAlignment(Pos.CENTER_LEFT);
        pnlcant=new HBox(5);
        pnlcant.getChildren().addAll(txtCant,cant,txtTotal,total);
        pnlcant.setPadding(new Insets(5));
        pnlcant.setAlignment(Pos.CENTER_LEFT);
        pnlfactura=new VBox(5);
        pnlfactura.getChildren().addAll(txtFactComp, lstFactura);
        pnlfactura.setPadding(new Insets(5));
        pnlfactura.setAlignment(Pos.CENTER);
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
               bLimpiarEventHandler(event);
           }
       });
        btnCancelar=new Button("Salir");
        btnCancelar.setFont(Font.font("News701 BT", 15));
        btnCancelar.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
               bCancelarEventHandler(event);
           }
       });
        pnlBotones=new HBox(25);
        pnlBotones.getChildren().addAll(btnIngresar,btnLimpiar,btnCancelar);
        pnlBotones.setPadding(new Insets(5));
        pnlBotones.setAlignment(Pos.CENTER);
        pnlFinal=new VBox(5);
        Image fondoFinal = new Image("file:src\\kardex\\multimedia\\images\\fondo.jpg");
        BackgroundImage fondo = new BackgroundImage(fondoFinal, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        pnlFinal.setBackground(new Background(fondo));
        pnlFinal.setStyle("-fx-padding: 10; -fx-border-color: orange ; -fx-border-width: 2px");
        pnlFinal.getChildren().addAll(pnlcod,pnlProd,pnlcant,pnlfactura,pnlBotones);
        pnlFinal.setPadding(new Insets(10));
        pnlFinal.setAlignment(Pos.CENTER);
    }
    
    public void bIngresarEventHandler(ActionEvent event) {
        Detalle_CompraI detaDao = new Detalle_CompraImp();
        Detalle_Compra nDetalleCompra = new Detalle_Compra();
        try {
            nDetalleCompra.setCodigoDcompra(Integer.parseInt(cod.getText()));
            nDetalleCompra.setCantidad(Integer.parseInt(cant.getText()));
            nDetalleCompra.setpTotal(Double.parseDouble(total.getText()));
            nDetalleCompra.setProducto(lstProd.getSelectionModel().getSelectedItem());
            nDetalleCompra.setfCompra(lstFactura.getSelectionModel().getSelectedItem());
            if (detaDao.ingresar(nDetalleCompra) > 0) {
                System.out.println("Ingreso correcto");
            } else {
                System.out.println("Ingreso Incorrecto");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
     public void bLimpiarEventHandler(ActionEvent event){
        cod.setText("");
        cant.setText("");
        total.setText("");
//        lstProd.setItems("");
//        lstFactura.setItems("");
           }
     public void bCancelarEventHandler(ActionEvent event){
        System.exit(0);
    }
    public void cargarProductos(){
        ProductoI proDao=new ProductoImp();
        listProd=new ArrayList<>();
        try {
            listProd=proDao.obtener();
            for(Producto produc:listProd){
                itemProd.add(produc);
            }
        } catch (Exception e) {
        }
    }
    public void cargarFacturaCompra(){
        Factura_CompraI fcDao=new Factura_CompraImp();
        listfc=new ArrayList<>();
        try {
            listfc=fcDao.obtener();
            for(Factura_Compra fcompra:listfc){
                itemfc.add(fcompra);
            }
        } catch (Exception e) {
        }
    }

    public VBox getPnlFinal() {
        return pnlFinal;
    }
}