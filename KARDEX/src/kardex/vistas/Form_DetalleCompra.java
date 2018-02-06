package kardex.vistas;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.util.*;
import javafx.scene.text.*;
import javafx.scene.paint.*;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.MessageFormat;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import kardex.negocio.dao.*;
import kardex.negocio.entidades.*;
import kardex.negocio.impl.*;
import kardex.accesoadatos.*;

public class Form_DetalleCompra extends Application {

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
    private VBox pntPrincipal;

    @Override
    public void start(Stage primaryStage) {
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
        btnCancelar=new Button("Salir");
        btnCancelar.setFont(Font.font("News701 BT", 15));
        pnlBotones=new HBox(25);
        pnlBotones.getChildren().addAll(btnIngresar,btnLimpiar,btnCancelar);
        pnlBotones.setPadding(new Insets(5));
        pnlBotones.setAlignment(Pos.CENTER);
        pntPrincipal=new VBox(5);
        pntPrincipal.getChildren().addAll(pnlcod,pnlProd,pnlcant,pnlfactura,pnlBotones);
        pntPrincipal.setPadding(new Insets(10));
        pntPrincipal.setAlignment(Pos.CENTER);
        
        
        Scene scene = new Scene(pntPrincipal, 440, 400);

        primaryStage.setTitle("Detalle Compra");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
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
}
