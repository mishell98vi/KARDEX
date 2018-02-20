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

public class Form_Menu_Principal extends Application {

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
    private Pane interior;

    @Override
    public void start(Stage primaryStage) {
        interior = new Pane();
        interior.setMaxSize(1270, 710);
        Background fondoImagen = new Background(new BackgroundImage(new Image("file:src\\kardex\\multimedia\\images\\micasa.png"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(500, 500, false, true, true, false)));
        interior.setBackground(fondoImagen);
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
                Pane nCliente = new Pane();
                nCliente.getChildren().add(nClienteEventHandler(event));
                nCliente.setPadding(new Insets(10));
                interior.getChildren().add(nCliente);
            }
        });
        modCliente = new MenuItem("Modificar Cliente");
        delCliente = new MenuItem("Eliminar Cliente");
        delCliente.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Pane eCliente = new Pane();
                eCliente.getChildren().add(eClienteEventHandler(event));
                eCliente.setPadding(new Insets(10));
                interior.getChildren().add(eCliente);
            }
        });
        infCliente = new MenuItem("Informacion de un Cliente");
        listCliente = new MenuItem("Listado de Clientes");
        listCliente.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Pane lstClientes = new Pane();
                lstClientes.getChildren().add(lstClienteEventHandler(event));
                lstClientes.setPadding(new Insets(10));
                interior.getChildren().add(lstClientes);
            }
        });
        cliente.getItems().addAll(newCliente, modCliente, delCliente, new SeparatorMenuItem(), infCliente, listCliente);
        //Menu Factura Venta
        FacturaVenta = new Menu("Factura Ventas");
        newFacVenta = new MenuItem("Nueva Venta");
        newFacVenta.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Pane nFacVenta = new Pane();
                nFacVenta.getChildren().add(nFactVentaEventHandler(event));
                nFacVenta.setPadding(new Insets(10));
                interior.getChildren().add(nFacVenta);
            }
        });
        modFacVenta = new MenuItem("Modificar Venta");
        delFacVenta = new MenuItem("Eliminar Venta");
        infFacVenta = new MenuItem("Informacion de una Venta");
        listFacVenta = new MenuItem("Listado de Venta");
        FacturaVenta.getItems().addAll(newFacVenta, modFacVenta, delFacVenta, new SeparatorMenuItem(), infFacVenta, listFacVenta);
        //Menu Proveedor
        proveedor = new Menu("Proveedores");
        newProveedor = new MenuItem("Nuevo Proveedor");
        newProveedor.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Pane nProveedor = new Pane();
                nProveedor.getChildren().add(nProveedorEventHandler(event));
                nProveedor.setPadding(new Insets(10));
                interior.getChildren().add(nProveedor);
            }
        });
        modProveedor = new MenuItem("Modificar Proveedor");
        delProveedor = new MenuItem("Eliminar Proveedor");
        delProveedor.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Pane eliProveedores = new Pane();
                eliProveedores.getChildren().add(eProveedorEventHandler(event));
                eliProveedores.setPadding(new Insets(10));
                interior.getChildren().add(eliProveedores);
            }
        });
        infProveedor = new MenuItem("Informacion de un Proveedor");
        listProveedor = new MenuItem("Listado Proveedor");
        listProveedor.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Pane lstProveedores = new Pane();
                lstProveedores.getChildren().add(lstProveedorEventHandler(event));
                lstProveedores.setPadding(new Insets(10));
                interior.getChildren().add(lstProveedores);
            }
        });
        proveedor.getItems().addAll(newProveedor, modProveedor, delProveedor, new SeparatorMenuItem(), infProveedor, listProveedor);
        //Menu Producto
        producto = new Menu("Producto");
        newProducto = new MenuItem("Nuevo Producto");
        newProducto.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Pane nProducto = new Pane();
                nProducto.getChildren().add(nProductoEventHandler(event));
                nProducto.setPadding(new Insets(10));
                interior.getChildren().add(nProducto);
            }
        });
        modProducto = new MenuItem("Modificar Producto");
        delProducto = new MenuItem("Eliminar Producto");

        infProducto = new MenuItem("Informacion de un Producto");
        listProducto = new MenuItem("Listado Producto");
        listProducto.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Pane lstProductos = new Pane();
                lstProductos.getChildren().add(lstProductoEventHandler(event));
                lstProductos.setPadding(new Insets(10));
                interior.getChildren().add(lstProductos);
            }
        });
        producto.getItems().addAll(newProducto, modProducto, delProducto, new SeparatorMenuItem(), infProducto, listProducto);
        //Menu Categoria
        categoria = new Menu("Categoria");
        newCategoria = new MenuItem("Nueva Categoria");
        newCategoria.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Pane nCategoria = new Pane();
                nCategoria.getChildren().add(nCategoriaEventHandler(event));
                nCategoria.setPadding(new Insets(10));
                interior.getChildren().add(nCategoria);
            }
        });
        modCategoria = new MenuItem("Modificar Categoria");
        delCategoria = new MenuItem("Eliminar Categoria");
        delCategoria.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Pane elimCateg = new Pane();
                elimCateg.getChildren().add(lstCategoriaEventHandler(event));
                elimCateg.setPadding(new Insets(10));
                interior.getChildren().add(elimCateg);

            }
        });
        infCategoria = new MenuItem("Informacion de una Categoria");
        listCategoria = new MenuItem("Listado Categoria");
        listCategoria.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Pane lstCateg = new Pane();
                lstCateg.getChildren().add(lstCategoriaEventHandler(event));
                lstCateg.setPadding(new Insets(10));
                interior.getChildren().add(lstCateg);
            }
        });
        categoria.getItems().addAll(newCategoria, modCategoria, delCategoria, new SeparatorMenuItem(), infCategoria, listCategoria);

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

        menuPrincipal.getMenus().addAll(inicio, cliente, proveedor, producto, categoria, FacturaVenta, facturaCompra, kardex);

        escritorio = new BorderPane();
        escritorio.setTop(menuPrincipal);
        escritorio.setCenter(interior);
        Scene scene = new Scene(escritorio, 1280, 720);
        primaryStage.setMaximized(true);
        primaryStage.setMaxHeight(960);
        primaryStage.setMaxWidth(1280);
        primaryStage.setMinHeight(960);
        primaryStage.setMinWidth(1280);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void mnSalirEventHandler(ActionEvent event) {
        System.exit(0);
    }

    public Form_SubVentana nProductoEventHandler(ActionEvent event) {
        BorderPane producNuevo = new BorderPane();
        Label titulo = new Label("Nuevo Producto");
        titulo.setFont(Font.font("News701 BT", 25));
        titulo.setTextFill(Color.AQUA);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 20));
        cerrar.setTextFill(Color.AQUA);
        Form_Barra_De_Titulo btitulonProduc = new Form_Barra_De_Titulo(titulo, cerrar);
        producNuevo.setTop(btitulonProduc.getBarra());
        Form_Nuevo_Producto prodN = new Form_Nuevo_Producto();
        producNuevo.setCenter(prodN.getPnlFinal());
        Form_SubVentana nProducto = new Form_SubVentana();
        nProducto.setRoot(producNuevo);
        nProducto.makeDragable(btitulonProduc.getBarra());
        nProducto.makeDragable(titulo);
        nProducto.makeResizable(20);
        nProducto.makeFocusable();
        nProducto.setCloseButton(cerrar);
        return nProducto;
    }

    public Form_SubVentana lstProductoEventHandler(ActionEvent event) {
        BorderPane listProd = new BorderPane();
        Label titulo = new Label("Listado de Productos");
        titulo.setFont(Font.font("News701 BT", 25));
        titulo.setTextFill(Color.AQUA);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 20));
        cerrar.setTextFill(Color.AQUA);
        Form_Barra_De_Titulo btitulonProduc = new Form_Barra_De_Titulo(titulo, cerrar);
        listProd.setTop(btitulonProduc.getBarra());
        Form_Listado_Producto lstProds = new Form_Listado_Producto();
        listProd.setCenter(lstProds.getPnlFinal());
        Form_SubVentana listaProductos = new Form_SubVentana();
        listaProductos.setRoot(listProd);
        listaProductos.makeDragable(btitulonProduc.getBarra());
        listaProductos.makeDragable(titulo);
        listaProductos.makeResizable(20);
        listaProductos.makeFocusable();
        listaProductos.setCloseButton(cerrar);
        return listaProductos;
    }

    public Form_SubVentana nFactVentaEventHandler(ActionEvent event) {
        BorderPane FactVentaNuevo = new BorderPane();
        Label titulo = new Label("Nuevo Factura Venta");
        titulo.setFont(Font.font("News701 BT", 25));
        titulo.setTextFill(Color.AQUA);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 20));
        cerrar.setTextFill(Color.AQUA);
        Form_Barra_De_Titulo btitulonFV = new Form_Barra_De_Titulo(titulo, cerrar);
        FactVentaNuevo.setTop(btitulonFV.getBarra());
        Form_Nueva_FacturaVenta FactVentN = new Form_Nueva_FacturaVenta();
        FactVentaNuevo.setCenter(FactVentN.getPnlFinal());
        Form_SubVentana nFactVenta = new Form_SubVentana();
        nFactVenta.setRoot(FactVentaNuevo);
        nFactVenta.makeDragable(btitulonFV.getBarra());
        nFactVenta.makeDragable(titulo);
        nFactVenta.makeResizable(20);
        nFactVenta.makeFocusable();
        nFactVenta.setCloseButton(cerrar);
        return nFactVenta;
    }

    public Form_SubVentana lstFactVentaEventHandler(ActionEvent event) {
        BorderPane listFacV = new BorderPane();
        Label titulo = new Label("Nuevo Factura Venta");
        titulo.setFont(Font.font("News701 BT", 25));
        titulo.setTextFill(Color.AQUA);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 20));
        cerrar.setTextFill(Color.AQUA);
        Form_Barra_De_Titulo btitulonFV = new Form_Barra_De_Titulo(titulo, cerrar);
        listFacV.setTop(btitulonFV.getBarra());
        Form_Listado_FacturaVenta lstFaV = new Form_Listado_FacturaVenta();
        listFacV.setCenter(lstFaV.getPnlFinal());
        Form_SubVentana FacVList = new Form_SubVentana();
        FacVList.setRoot(listFacV);
        FacVList.makeDragable(btitulonFV.getBarra());
        FacVList.makeDragable(titulo);
        FacVList.makeResizable(20);
        FacVList.makeFocusable();
        FacVList.setCloseButton(cerrar);
        return FacVList;
    }

    public Form_SubVentana nProveedorEventHandler(ActionEvent event) {
        BorderPane proveedorNuevo = new BorderPane();
        Label titulo = new Label("Nuevo Proveedor");
        titulo.setFont(Font.font("News701 BT", 25));
        titulo.setTextFill(Color.BLACK);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 20));
        cerrar.setTextFill(Color.BLACK);
        //obejto de barra de titulo
        Form_Barra_De_Titulo btitulonProve = new Form_Barra_De_Titulo(titulo, cerrar);
        proveedorNuevo.setTop(btitulonProve.getBarra());
        //creo un objeto de tipo nuevo proveedor
        Form_Nuevo_Proveedor proveN = new Form_Nuevo_Proveedor();
        proveedorNuevo.setCenter(proveN.getPnlFinal());//agrego en la parte central el nuevo proveedor

        Form_SubVentana nProveedor = new Form_SubVentana();
        nProveedor.setRoot(proveedorNuevo);
        nProveedor.makeDragable(btitulonProve.getBarra());
        nProveedor.makeDragable(titulo);
        nProveedor.makeResizable(20);
        nProveedor.makeFocusable();
        nProveedor.setCloseButton(cerrar);
        return nProveedor;
    }

    public Form_SubVentana lstProveedorEventHandler(ActionEvent event) {
        BorderPane listProveedor = new BorderPane();
        Label titulo = new Label("Nuevo Proveedor");
        titulo.setFont(Font.font("News701 BT", 25));
        titulo.setTextFill(Color.AQUA);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 20));
        cerrar.setTextFill(Color.AQUA);
        Form_Barra_De_Titulo btitulonProve = new Form_Barra_De_Titulo(titulo, cerrar);
        listProveedor.setTop(btitulonProve.getBarra());
        Form_Listado_Proveedor provList = new Form_Listado_Proveedor();
        listProveedor.setCenter(provList.getPnlFinal());
        Form_SubVentana provL = new Form_SubVentana();
        provL.setRoot(listProveedor);
        provL.makeDragable(btitulonProve.getBarra());
        provL.makeDragable(titulo);
        provL.makeResizable(20);
        provL.makeFocusable();
        provL.setCloseButton(cerrar);
        return provL;
    }

    public Form_SubVentana nClienteEventHandler(ActionEvent event) {
        BorderPane clienteNuevo = new BorderPane();
        Label titulo = new Label("Nueva CLiente");
        titulo.setFont(Font.font("News701 BT", 25));
        titulo.setTextFill(Color.AQUA);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 20));
        cerrar.setTextFill(Color.AQUA);
        Form_Barra_De_Titulo btitulonCliente = new Form_Barra_De_Titulo(titulo, cerrar);
        clienteNuevo.setTop(btitulonCliente.getBarra());
        Form_Nuevo_Cliente clientN = new Form_Nuevo_Cliente();
        clienteNuevo.setCenter(clientN.getPnlFinal());
        Form_SubVentana nCliente = new Form_SubVentana();
        nCliente.setRoot(clienteNuevo);
        nCliente.makeDragable(btitulonCliente.getBarra());
        nCliente.makeDragable(titulo);
        nCliente.makeResizable(20);
        nCliente.makeFocusable();
        nCliente.setCloseButton(cerrar);
        return nCliente;
    }

    public Form_SubVentana eClienteEventHandler(ActionEvent event) {
        BorderPane clienteEliminar = new BorderPane();
        Label titulo = new Label("Eliminar CLiente");
        titulo.setFont(Font.font("News701 BT", 25));
        titulo.setTextFill(Color.AQUA);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 20));
        cerrar.setTextFill(Color.AQUA);
        Form_Barra_De_Titulo btitulonCliente = new Form_Barra_De_Titulo(titulo, cerrar);
        clienteEliminar.setTop(btitulonCliente.getBarra());
        Form_EliminarCliente clienteE = new Form_EliminarCliente();
        clienteEliminar.setCenter(clienteE.getPnlFinal());
        Form_SubVentana eCliente = new Form_SubVentana();
        eCliente.setRoot(clienteEliminar);
        eCliente.makeDragable(btitulonCliente.getBarra());
        eCliente.makeDragable(titulo);
        eCliente.makeResizable(20);
        eCliente.makeFocusable();
        eCliente.setCloseButton(cerrar);
        return eCliente;
    }

    public Form_SubVentana lstClienteEventHandler(ActionEvent event) {
        BorderPane listClientes = new BorderPane();
        Label titulo = new Label("Nueva CLiente");
        titulo.setFont(Font.font("News701 BT", 25));
        titulo.setTextFill(Color.AQUA);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 20));
        cerrar.setTextFill(Color.AQUA);
        Form_Barra_De_Titulo btitulonCliente = new Form_Barra_De_Titulo(titulo, cerrar);
        listClientes.setTop(btitulonCliente.getBarra());
        Form_Listado_Cliente clientesLista = new Form_Listado_Cliente();
        listClientes.setCenter(clientesLista.getPnlFinal());
        Form_SubVentana lstClientes = new Form_SubVentana();
        lstClientes.setRoot(listClientes);
        lstClientes.makeDragable(btitulonCliente.getBarra());
        lstClientes.makeDragable(titulo);
        lstClientes.makeResizable(20);
        lstClientes.makeFocusable();
        lstClientes.setCloseButton(cerrar);
        return lstClientes;
    }

    public Form_SubVentana nCategoriaEventHandler(ActionEvent event) {
        BorderPane categNueva = new BorderPane();
        Label titulo = new Label("Nueva Categoria");
        titulo.setFont(Font.font("News701 BT", 25));
        titulo.setTextFill(Color.AQUA);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 20));
        cerrar.setTextFill(Color.AQUA);
        Form_Barra_De_Titulo btitulonCateg = new Form_Barra_De_Titulo(titulo, cerrar);
        categNueva.setTop(btitulonCateg.getBarra());
        Form_Nueva_Categoria categN = new Form_Nueva_Categoria();
        categNueva.setCenter(categN.getPnlFinal());
        Form_SubVentana nCategoria = new Form_SubVentana();
        nCategoria.setRoot(categNueva);
        nCategoria.makeDragable(btitulonCateg.getBarra());
        nCategoria.makeDragable(titulo);
        nCategoria.makeResizable(20);
        nCategoria.makeFocusable();
        nCategoria.setCloseButton(cerrar);
        return nCategoria;
    }

    public Form_SubVentana lstCategoriaEventHandler(ActionEvent event) {
        BorderPane listCateg = new BorderPane();
        Label titulo = new Label("Nueva Categoria");
        titulo.setFont(Font.font("News701 BT", 25));
        titulo.setTextFill(Color.AQUA);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 20));
        cerrar.setTextFill(Color.AQUA);
        Form_Barra_De_Titulo btitulonCateg = new Form_Barra_De_Titulo(titulo, cerrar);
        listCateg.setTop(btitulonCateg.getBarra());
        Form_Listado_Categoria categLista = new Form_Listado_Categoria();
        listCateg.setCenter(categLista.getPnlFinal());
        Form_SubVentana lstCategorias = new Form_SubVentana();
        lstCategorias.setRoot(listCateg);
        lstCategorias.makeDragable(btitulonCateg.getBarra());
        lstCategorias.makeDragable(titulo);
        lstCategorias.makeResizable(20);
        lstCategorias.makeFocusable();
        lstCategorias.setCloseButton(cerrar);
        return lstCategorias;
    }

    public Form_SubVentana nDetalleCompraEventHandler(ActionEvent event) {
        BorderPane detalleCompraNuevo = new BorderPane();
        Label titulo = new Label("Nueva Detalle Compra");
        titulo.setFont(Font.font("News701 BT", 25));
        titulo.setTextFill(Color.AQUA);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 20));
        cerrar.setTextFill(Color.AQUA);
        Form_Barra_De_Titulo btitulonDC = new Form_Barra_De_Titulo(titulo, cerrar);
        detalleCompraNuevo.setTop(btitulonDC.getBarra());
        Form_Nueva_DetalleCompra detCompraN = new Form_Nueva_DetalleCompra();
        detalleCompraNuevo.setCenter(detCompraN.getPnlFinal());
        Form_SubVentana nDetallCompra = new Form_SubVentana();
        nDetallCompra.setRoot(detalleCompraNuevo);
        nDetallCompra.makeDragable(btitulonDC.getBarra());
        nDetallCompra.makeDragable(titulo);
        nDetallCompra.makeResizable(20);
        nDetallCompra.makeFocusable();
        nDetallCompra.setCloseButton(cerrar);
        return nDetallCompra;
    }

    public Form_SubVentana lstDetalleCompraEventHandler(ActionEvent event) {
        BorderPane listDetCom = new BorderPane();
        Label titulo = new Label("Nueva Detalle Compra");
        titulo.setFont(Font.font("News701 BT", 25));
        titulo.setTextFill(Color.AQUA);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 20));
        cerrar.setTextFill(Color.AQUA);
        Form_Barra_De_Titulo btitulonDC = new Form_Barra_De_Titulo(titulo, cerrar);
        listDetCom.setTop(btitulonDC.getBarra());
        Form_Listado_DetalleCompra DetCompLista = new Form_Listado_DetalleCompra();
        listDetCom.setCenter(DetCompLista.getPnlFinal());
        Form_SubVentana lstDetCompra = new Form_SubVentana();
        lstDetCompra.setRoot(listDetCom);
        lstDetCompra.makeDragable(btitulonDC.getBarra());
        lstDetCompra.makeDragable(titulo);
        lstDetCompra.makeResizable(20);
        lstDetCompra.makeFocusable();
        lstDetCompra.setCloseButton(cerrar);
        return lstDetCompra;
    }

    public Form_SubVentana eCategoriaEventHandler(ActionEvent event) {
        BorderPane eCategoria = new BorderPane();
        Label titulo = new Label("Nueva Detalle Venta");
        titulo.setFont(Font.font("News701 BT", 25));
        titulo.setTextFill(Color.AQUA);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 20));
        cerrar.setTextFill(Color.AQUA);
        Form_Barra_De_Titulo btitulonDV = new Form_Barra_De_Titulo(titulo, cerrar);
        eCategoria.setTop(btitulonDV.getBarra());
        Form_EliminarCategoria categE = new Form_EliminarCategoria();
        eCategoria.setCenter(categE.getPnlFinal());
        Form_SubVentana nDetallVenta = new Form_SubVentana();
        nDetallVenta.setRoot(eCategoria);
        nDetallVenta.makeDragable(btitulonDV.getBarra());
        nDetallVenta.makeDragable(titulo);
        nDetallVenta.makeResizable(20);
        nDetallVenta.makeFocusable();
        nDetallVenta.setCloseButton(cerrar);
        return nDetallVenta;
    }

    public Form_SubVentana eProveedorEventHandler(ActionEvent event) {
        BorderPane eProveedor = new BorderPane();
        Label titulo = new Label("Eliminar Proveedor");
        titulo.setFont(Font.font("News701 BT", 25));
        titulo.setTextFill(Color.AQUA);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 20));
        cerrar.setTextFill(Color.AQUA);
        Form_Barra_De_Titulo btitulonDV = new Form_Barra_De_Titulo(titulo, cerrar);
        eProveedor.setTop(btitulonDV.getBarra());
        Form_EliminarProveedor proE = new Form_EliminarProveedor();
        eProveedor.setCenter(proE.getPnlFinal());
        Form_SubVentana elimProveedor = new Form_SubVentana();
        elimProveedor.setRoot(eProveedor);
        elimProveedor.makeDragable(btitulonDV.getBarra());
        elimProveedor.makeDragable(titulo);
        elimProveedor.makeResizable(20);
        elimProveedor.makeFocusable();
        elimProveedor.setCloseButton(cerrar);
        return elimProveedor;
    }

    public Form_SubVentana lstDetalleVentaEventHandler(ActionEvent event) {
        BorderPane listDetVen = new BorderPane();
        Label titulo = new Label("Nueva Detalle Venta");
        titulo.setFont(Font.font("News701 BT", 25));
        titulo.setTextFill(Color.AQUA);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 20));
        cerrar.setTextFill(Color.AQUA);
        Form_Barra_De_Titulo btitulonDV = new Form_Barra_De_Titulo(titulo, cerrar);
        listDetVen.setTop(btitulonDV.getBarra());
        Form_Listado_DetalleVenta detVenLista = new Form_Listado_DetalleVenta();
        listDetVen.setCenter(detVenLista.getPnlFinal());
        Form_SubVentana lstDetVenta = new Form_SubVentana();
        lstDetVenta.setRoot(listDetVen);
        lstDetVenta.makeDragable(btitulonDV.getBarra());
        lstDetVenta.makeDragable(titulo);
        lstDetVenta.makeResizable(20);
        lstDetVenta.makeFocusable();
        lstDetVenta.setCloseButton(cerrar);
        return lstDetVenta;
    }

}
