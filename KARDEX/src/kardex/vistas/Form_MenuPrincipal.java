
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
    Menu producto;
    Menu categoria;
    Menu detalle_compra;
    Menu detalle_venta;
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
    //Producto
    MenuItem newProducto;
    MenuItem modProducto;
    MenuItem delProducto;
    MenuItem infProducto;
    MenuItem listProducto;
    //Categoria
    
    MenuItem newCategoria;
    MenuItem modCategoria;
    MenuItem delCategoria;
    MenuItem infCategoria;
    MenuItem listCategoria;
   //Detalle compra
    
    MenuItem newDetalle_compra;
    MenuItem modDetalle_compra;
    MenuItem delDetalle_compra;
    MenuItem infDetalle_compra;
    MenuItem listDetalle_compra;
    //Detalle venta
    MenuItem newDetalle_venta;
    MenuItem modDetalle_venta;
    MenuItem delDetalle_venta;
    MenuItem infDetalle_venta;
    MenuItem listDetalle_venta;
    
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
    private BorderPane escritorio;
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
        producto = new Menu("Producto");
        newProducto = new MenuItem("Nuevo Producto");
        modProducto = new MenuItem("Modificar Producto");
        delProducto = new MenuItem("Eliminar Producto");
        infProducto = new MenuItem("Informacion de un Producto");
        listProducto = new MenuItem("Listado Producto");
        producto.getItems().addAll(newProducto, modProducto, delProducto, new SeparatorMenuItem(), infProducto, listProducto);
        //Menu Inicio
        categoria = new Menu("Categoria");
        newCategoria = new MenuItem("Nueva Categoria");
        newCategoria.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Pane nCategoria=new Pane();
                nCategoria.getChildren().add(nCategoriaEventHandler(event));
                nCategoria.setPadding(new Insets(10));
                escritorio.setCenter(nCategoria);
            }
        });
        modCategoria = new MenuItem("Modificar Categoria");
        delCategoria = new MenuItem("Eliminar Categoria");
        infCategoria = new MenuItem("Informacion de una Categoria");
        listCategoria = new MenuItem("Listado Categoria");
        categoria.getItems().addAll(newCategoria, modCategoria, delCategoria, new SeparatorMenuItem(), infCategoria, listCategoria);
        //Detalle compra
        detalle_compra = new Menu("Detalle Compra");
        newDetalle_compra = new MenuItem("Nuevo Detalle compra");
        modDetalle_compra = new MenuItem("Modificar Detalle compra");
        delDetalle_compra = new MenuItem("Eliminar Detalle compra");
        infDetalle_compra = new MenuItem("Informacion de un Detalle compra");
        listDetalle_compra = new MenuItem("Listado Detalle compra");
        detalle_compra.getItems().addAll(newDetalle_compra, modDetalle_compra, delDetalle_compra, new SeparatorMenuItem(), infDetalle_compra, listDetalle_compra);
        
        //Detalle venta
        detalle_venta = new Menu("Detalle venta");
        newDetalle_venta = new MenuItem("Nuevo Detalle venta");
        modDetalle_venta = new MenuItem("Modificar Detalle venta");
        delDetalle_venta = new MenuItem("Eliminar Detalle venta");
        infDetalle_venta = new MenuItem("Informacion de Detalle venta");
        listDetalle_venta = new MenuItem("Listado Detalle venta");
        detalle_venta.getItems().addAll(newDetalle_venta, modDetalle_venta, delDetalle_venta, new SeparatorMenuItem(), infDetalle_venta, listDetalle_venta);
        
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

        menuPrincipal.getMenus().addAll(inicio, cliente, proveedor,producto,categoria, detalle_compra, detalle_venta, FacturaVenta, facturaCompra, kardex);

        escritorio = new BorderPane();
        escritorio.setTop(menuPrincipal);
        
        Scene scene = new Scene(escritorio, 300, 250);
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
    public Form_SubVentana nCategoriaEventHandler(ActionEvent event){
        BorderPane categNueva=new BorderPane();
        Label titulo=new Label("Nueva Categoria");
        titulo.setFont(Font.font("News701 BT", 25));
        titulo.setTextFill(Color.AQUA);
        Button cerrar=new Button("X");
        cerrar.setFont(Font.font("Arial Black", 20));
        cerrar.setTextFill(Color.AQUA);
        Form_Barra_De_Titulo btitulo=new Form_Barra_De_Titulo(titulo, cerrar);
        categNueva.setTop(btitulo.getBarra());
        Form_Nueva_Categoria categN=new Form_Nueva_Categoria();
        categNueva.setCenter(categN.getPnlFinal());
        Form_SubVentana nCategoria=new Form_SubVentana();
        nCategoria.setRoot(categNueva);
        nCategoria.makeDragable(btitulo.getBarra());
        nCategoria.makeDragable(titulo);
        nCategoria.makeResizable(20);
        nCategoria.makeFocusable();
        nCategoria.setCloseButton(cerrar);
        return nCategoria;
    }
}
