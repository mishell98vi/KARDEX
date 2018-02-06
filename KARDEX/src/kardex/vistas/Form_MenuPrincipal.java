
package kardex.vistas;

import com.sun.javafx.geom.Area;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.text.*;
import javafx.scene.effect.*;
import javafx.scene.paint.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.*;
import java.util.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.Event;
import javafx.event.EventDispatchChain;
import javafx.event.EventDispatcher;
import javafx.scene.Node;
import javafx.scene.text.Text;


public class Form_MenuPrincipal extends Application {
    Image fondo;
    ImageView visorFondo;

    MenuBar menuPrincipal;
    Menu inicio;
    Menu cliente;
    Menu proveedor;
    Menu FacturaVenta;
    Menu facturaCompra;
    Menu kardex;
    //inicio
    MenuItem login;
    MenuItem Salir;
    //cliente
    MenuItem newCliente;
    MenuItem modCliente;
    MenuItem delCliente;
    MenuItem infCliente;
    MenuItem listCliente;
    //proveedor
    MenuItem newProveedor;
    MenuItem modProveedor;
    MenuItem delProveedor;
    MenuItem infProveedor;
    MenuItem listProveedor;
    //FacturaVenta
    MenuItem newFacVenta;
    MenuItem modFacVenta;
    MenuItem delFacVenta;
    MenuItem infFacVenta;
    MenuItem listFacVenta;
    //facturCompra
    MenuItem newFacCompra;
    MenuItem modFacCompra;
    MenuItem delFacCompra;
    MenuItem infFacCompra;
    MenuItem listFacCompra;
    //kardex
    MenuItem kardexMensual;
    MenuItem kardexAnual;
    private VBox pntPrincipal;
    @Override
    public void start(Stage primaryStage) {
        fondo = new Image("file:src\\unachkardex\\multimedia\\error.jpg", 1280, 720, true, true);
        visorFondo = new ImageView(fondo);
        visorFondo.setPreserveRatio(true);

        menuPrincipal = new MenuBar();
        //Menu Inicio
        inicio = new Menu("Inicio");
        inicio.setStyle(STYLESHEET_CASPIAN);
        login = new MenuItem("Iniciar Sesion");
        Salir = new MenuItem("Salir");
        Salir.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mnSalirEventHandler(event);
            }
        });
        inicio.getItems().addAll(login, Salir);
        //Menu Inicio
        cliente = new Menu("Clientes");
        newCliente = new MenuItem("Nuevo Cliente");
        newCliente.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                nClienteEventHandler(event);
            }
        });
        modCliente = new MenuItem("Modificar Cliente");
        delCliente = new MenuItem("Eliminar Cliente");
        infCliente = new MenuItem("Informacion de un Cliente");
        listCliente = new MenuItem("Listado de Clientes");
        cliente.getItems().addAll(newCliente, modCliente, delCliente, new SeparatorMenuItem(), infCliente, listCliente);
        //Menu Inicio
        FacturaVenta = new Menu("Factura Ventas");
        newFacVenta = new MenuItem("Nueva Venta");
        modFacVenta = new MenuItem("Modificar Venta");
        delFacVenta = new MenuItem("Eliminar Venta");
        infFacVenta = new MenuItem("Informacion de una Venta");
        listFacVenta = new MenuItem("Listado de Venta");
        FacturaVenta.getItems().addAll(newFacVenta, modFacVenta, delFacVenta, new SeparatorMenuItem(), infFacVenta, listFacVenta);
        //Menu Inicio
        proveedor = new Menu("Proveedores");
        newProveedor = new MenuItem("Nuevo Proveedor");
        modProveedor = new MenuItem("Modificar Proveedor");
        delProveedor = new MenuItem("Eliminar Proveedor");
        infProveedor = new MenuItem("Informacion de un Proveedor");
        listProveedor = new MenuItem("Listado Proveedor");
        proveedor.getItems().addAll(newProveedor, modProveedor, delProveedor, new SeparatorMenuItem(), infProveedor, listProveedor);
        //Menu Inicio
        facturaCompra = new Menu("Factura Compras");
        newFacCompra = new MenuItem("Nuevas Compas");
        modFacCompra = new MenuItem("Modificar Compra");
        delFacCompra = new MenuItem("Eliminar Compra");
        infFacCompra = new MenuItem("Informacion de una Compra");
        listFacCompra = new MenuItem("Listado de Compras");
        facturaCompra.getItems().addAll(newFacCompra, modFacCompra, delFacCompra, new SeparatorMenuItem(), infFacCompra, listFacCompra);
        //Menu Inicio
        kardex = new Menu("Kardex");
        kardexMensual = new MenuItem("Kardex Mensual");
        kardexAnual = new MenuItem("Kardex Anual");
        kardex.getItems().addAll(kardexMensual, kardexAnual);

        menuPrincipal.getMenus().addAll(inicio, cliente, proveedor, FacturaVenta, facturaCompra, kardex);

        pntPrincipal = new VBox(10);
        pntPrincipal.getChildren().add(menuPrincipal);
        
        Scene scene = new Scene(pntPrincipal, 300, 250);
        primaryStage.setMaximized(true);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    public void mnSalirEventHandler(ActionEvent event){
        System.exit(0);
    }
    public void nClienteEventHandler(ActionEvent event){
//        pntPrincipal.getChildren().add(nCliente);
    }
}
