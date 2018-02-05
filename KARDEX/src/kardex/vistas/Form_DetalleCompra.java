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
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import kardex.negocio.dao.*;
import kardex.negocio.entidades.*;
import kardex.negocio.impl.*;

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
    private ComboBox<Factura_Compra> lstFactura;
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
        txtProd=new Label("Producto: ");
        txtPrecio=new Label("Precio: ");
        precio=new Label("");
        txtCant=new Label("Cantidad: ");
        txtFactComp=new Label("Factura: ");
        txtTotal=new Label("Total: ");
        total=new Label("");
        cod=new TextField("");
        cant=new TextField("");
        lstProd=new ComboBox<>();
        lstFactura=new ComboBox<>();
        pnlcod=new HBox(5);
        pnlcod.getChildren().addAll(txtcod, cod);
        pnlcod.setPadding(new Insets(5));
        pnlcod.setAlignment(Pos.CENTER);
        pnlProd=new HBox(5);
        pnlProd.getChildren().addAll(txtProd, lstProd, txtPrecio, precio);
        pnlProd.setPadding(new Insets(5));
        pnlProd.setAlignment(Pos.CENTER);
        pnlcant=new HBox(5);
        pnlcant.getChildren().addAll(txtCant,cant,txtTotal,total);
        pnlcant.setPadding(new Insets(5));
        pnlcant.setAlignment(Pos.CENTER);
        pnlfactura=new VBox(5);
        pnlfactura.getChildren().addAll(txtFactComp, lstFactura);
        pnlfactura.setPadding(new Insets(5));
        pnlfactura.setAlignment(Pos.CENTER);
        btnIngresar=new Button("Ingresar");
        btnLimpiar=new Button("Limpiar");
        btnCancelar=new Button("Cancelar");
        pnlBotones=new HBox(25);
        pnlBotones.getChildren().addAll(btnIngresar,btnLimpiar,btnCancelar);
        pnlBotones.setPadding(new Insets(5));
        pnlBotones.setAlignment(Pos.CENTER);
        pntPrincipal=new VBox(5);
        pntPrincipal.getChildren().addAll(pnlcod,pnlProd,pnlcant,pnlfactura,pnlBotones);
        pntPrincipal.setPadding(new Insets(10));
        pntPrincipal.setAlignment(Pos.CENTER);
        
        
        Scene scene = new Scene(pntPrincipal, 300, 250);

        primaryStage.setTitle("Detalle Compra");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
