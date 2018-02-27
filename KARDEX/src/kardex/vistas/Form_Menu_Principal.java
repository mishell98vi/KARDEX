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
    Menu venta;
    Menu compra;
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
    MenuItem newVenta;
    MenuItem delVenta;
    MenuItem listVenta;
    //facturCompra
    MenuItem newCompra;
    MenuItem delCompra;
    MenuItem listCompra;
    //kardex
    MenuItem kardexMensual;
    MenuItem listakardex;
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
//********************************//
//INICIO
        inicio = new Menu("Inicio");
        inicio.setStyle(STYLESHEET_CASPIAN);
        //LOGIN
        login = new MenuItem("Iniciar Sesion");
        //SALIR
        Salir = new MenuItem("Salir");
        Salir.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mnSalirEventHandler(event);
            }
        });
        
//INICIO
        inicio.getItems().addAll(login, Salir);
//********************************//
//VENTAS
venta = new Menu("Ventas");
        //NUEVA VENTA
        newVenta = new MenuItem("Nueva Venta");
        newVenta.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Pane nFacVenta = new Pane();
                nFacVenta.getChildren().add(nFactVentaEventHandler(event));
                nFacVenta.setPadding(new Insets(10));
                interior.getChildren().add(nFacVenta);
            }
        });
        //LISTA DE VENTAS
//VENTAS
        venta.getItems().addAll(newVenta);
//********************************//
//COMPRAS
compra = new Menu("Compras");
        //NUEVA COMPRA
        newCompra = new MenuItem("Nueva Venta");
        newCompra.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Pane nFacCompra = new Pane();
                nFacCompra.getChildren().add(nFactCompraEventHandler(event));
                nFacCompra.setPadding(new Insets(10));
                interior.getChildren().add(nFacCompra);
            }
        });
        //LISTA DE COMRAS
//COMPRAS
compra.getItems().addAll(newCompra);
//********************************//
//CLIENTE

        cliente = new Menu("Clientes");
        //NUEVO CLIENTE
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
        //EDITAR CLIENTE
        modCliente = new MenuItem("Modificar Cliente");
        modCliente.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Pane mCliente = new Pane();
                mCliente.getChildren().add(mClienteEventHandler(event));
                mCliente.setPadding(new Insets(10));
                interior.getChildren().add(mCliente);
            }
        });
        //ELIMINAR CLIENTE
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
        //INFORMACION DE UN CLIENTE
        infCliente = new MenuItem("Informacion de un Cliente");
        infCliente.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Pane bCliente = new Pane();
                bCliente.getChildren().add(bClienteEventHandler(event));
                bCliente.setPadding(new Insets(10));
                interior.getChildren().add(bCliente);
            }
        });
        //LISTADO DE CLIENTES
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
        
//CLIENTE
        cliente.getItems().addAll(newCliente, modCliente, delCliente, new SeparatorMenuItem(), infCliente, listCliente);
//********************************//        
//PROVEEDOR
        proveedor = new Menu("Proveedores");
        //NUEVO PROVEEDOR
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
        //EDITAR PROVEEDOR
        modProveedor = new MenuItem("Modificar Proveedor");
        modProveedor.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Pane eliProveedores = new Pane();
                eliProveedores.getChildren().add(mProveedorEventHandler(event));
                eliProveedores.setPadding(new Insets(10));
                interior.getChildren().add(eliProveedores);
            }
        });
        //ELIMINAR PROVEEDOR
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
        
        //INFORMACION DE UN PROVEEDOR
        infProveedor = new MenuItem("Informacion de un Proveedor");
        infProveedor.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Pane busProveedores = new Pane();
                busProveedores.getChildren().add(bProveedorEventHandler(event));
                busProveedores.setPadding(new Insets(10));
                interior.getChildren().add(busProveedores);
            }
        });
        //LISTADO DE PROVEEDOR
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
//PROVEEDOR   
        proveedor.getItems().addAll(newProveedor, modProveedor, delProveedor, new SeparatorMenuItem(), infProveedor, listProveedor);
//********************************//        
//PRODUCTO
        producto = new Menu("Producto");
        //NUEVO PRODUCTO
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
        //EDITAR PRODUCTO
        modProducto = new MenuItem("Modificar Producto");
        //ELIMINAR PRODUCTO
        delProducto = new MenuItem("Eliminar Producto");
        delProducto.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Pane eProducto = new Pane();
                eProducto.getChildren().add(eProductoEventHandler(event));
                eProducto.setPadding(new Insets(10));
                interior.getChildren().add(eProducto);
            }
        });
        //INFORMACION DE UN PRODUCTO
        infProducto = new MenuItem("Informacion de un Producto");
        infProducto.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Pane bProducto = new Pane();
                bProducto.getChildren().add(bProductoEventHandler(event));
                bProducto.setPadding(new Insets(10));
                interior.getChildren().add(bProducto);
            }
        });
        
        //LISTADO DE PRODUCTO
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
//PRODUCTO
        producto.getItems().addAll(newProducto, modProducto, delProducto, new SeparatorMenuItem(), infProducto, listProducto);
//********************************//        
//CATEGORIA
        categoria = new Menu("Categoria");
        //NUEVO CATEGORIA
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
        //EDITAR CATEGORIA
        modCategoria = new MenuItem("Modificar Categoria");
        //ELIMINAR CATEGORIA
        delCategoria = new MenuItem("Eliminar Categoria");
        delCategoria.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Pane elimCateg = new Pane();
                elimCateg.getChildren().add(eCategoriaEventHandler(event));
                elimCateg.setPadding(new Insets(10));
                interior.getChildren().add(elimCateg);

            }
        });
        //INFORMACION DE UN CATEGORIA
        infCategoria = new MenuItem("Informacion de una Categoria");
        infCategoria.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Pane buscaCateg = new Pane();
                buscaCateg.getChildren().add(bCategoriaEventHandler(event));
                buscaCateg.setPadding(new Insets(10));
                interior.getChildren().add(buscaCateg);
            }
        });
        
        //LISTADO DE CATEGORIA
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
//CATEGORIA
        categoria.getItems().addAll(newCategoria, modCategoria, delCategoria, new SeparatorMenuItem(), infCategoria, listCategoria);
//********************************//        
//KARDEX
        kardex = new Menu("Kardex");
        //KARDEX MENSUAL
        kardexMensual = new MenuItem("Kardex Mensual");
        //LISTADO DE KARDEX
        listakardex = new MenuItem("Listado de kardex");
//KARDEX
        kardex.getItems().addAll(kardexMensual, listakardex);
//********************************//        
//CONSULTAS
        //LOS 3 PRODUCTOS MAS VENDIDOS
        //LOS 3 PROVEEDORES CON MAS COMPRAS
        //EL MEJOR CLIENTE
        //LOS PRODUCTOS CON SU STOCK
        menuPrincipal.getMenus().addAll(inicio,venta,compra, cliente, proveedor, producto, categoria, kardex);
        escritorio = new BorderPane();
        escritorio.setTop(menuPrincipal);
        escritorio.setCenter(interior);
        Scene scene = new Scene(escritorio, 1280, 720);
        primaryStage.setMaximized(true);
        primaryStage.setMaxHeight(720);
        primaryStage.setMaxWidth(1280);
        primaryStage.setMinHeight(720);
        primaryStage.setMinWidth(1280);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

//INICIO
    //LOGIN
    //SALIR
    private void mnSalirEventHandler(ActionEvent event) {
        System.exit(0);
    }
//VENTAS
    //NUEVA VENTA

    public Form_SubVentana nFactVentaEventHandler(ActionEvent event) {
        BorderPane FactVentaNuevo = new BorderPane();
        Label titulo = new Label("Nuevo Factura Venta");
        titulo.setFont(Font.font("News701 BT", 25));
        titulo.setTextFill(Color.WHITE);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 20));
        cerrar.setTextFill(Color.BLACK);
        Form_Barra_De_Titulo bTitulo = new Form_Barra_De_Titulo(titulo, cerrar);
        FactVentaNuevo.setTop(bTitulo.getBarra());
        Form_Nueva_FacturaVenta FactVentN = new Form_Nueva_FacturaVenta();
        FactVentaNuevo.setCenter(FactVentN.getPnlFinal());
        Form_SubVentana subCliente = new Form_SubVentana();
        subCliente.setRoot(FactVentaNuevo);
        subCliente.makeDragable(bTitulo.getBarra());
        subCliente.makeDragable(titulo);
        subCliente.makeResizable(20);
        subCliente.makeFocusable();
        subCliente.setCloseButton(cerrar);
        return subCliente;
    }

    //ELIMINAR VENTA
    //LISTA DE VENTAS
//COMPRAS
    //NUEVA COMPRA
    public Form_SubVentana nFactCompraEventHandler(ActionEvent event) {
        BorderPane FactVentaNuevo = new BorderPane();
        Label titulo = new Label("Nuevo Factura Venta");
        titulo.setFont(Font.font("News701 BT", 25));
        titulo.setTextFill(Color.WHITE);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 20));
        cerrar.setTextFill(Color.BLACK);
        Form_Barra_De_Titulo bTitulo = new Form_Barra_De_Titulo(titulo, cerrar);
        FactVentaNuevo.setTop(bTitulo.getBarra());
        Form_Nueva_FacturaCompra FactComN = new Form_Nueva_FacturaCompra();
        FactVentaNuevo.setCenter(FactComN.getpntFinal());
        Form_SubVentana subCliente = new Form_SubVentana();
        subCliente.setRoot(FactVentaNuevo);
        subCliente.makeDragable(bTitulo.getBarra());
        subCliente.makeDragable(titulo);
        subCliente.makeResizable(20);
        subCliente.makeFocusable();
        subCliente.setCloseButton(cerrar);
        return subCliente;
    }
    //ELIMIAR COMPRA
    //LISTA DE COMRAS
//CLIENTE
    //NUEVO CLIENTE
    public Form_SubVentana nClienteEventHandler(ActionEvent event) {
        BorderPane clienteNuevo = new BorderPane();
        Label titulo = new Label("Nuevo CLiente");
        titulo.setFont(Font.font("News701 BT", 25));
        titulo.setTextFill(Color.WHITE);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 20));
        cerrar.setTextFill(Color.BLACK);
        Form_Barra_De_Titulo bTitulo = new Form_Barra_De_Titulo(titulo, cerrar);
        clienteNuevo.setTop(bTitulo.getBarra());
        Form_Nuevo_Cliente cliente = new Form_Nuevo_Cliente();
        clienteNuevo.setCenter(cliente.getPnlFinal());
        Form_SubVentana subCliente = new Form_SubVentana();
        subCliente.setRoot(clienteNuevo);
        subCliente.makeDragable(bTitulo.getBarra());
        subCliente.makeDragable(titulo);
        subCliente.makeResizable(20);
        subCliente.makeFocusable();
        subCliente.setCloseButton(cerrar);
        return subCliente;
    }

    //EDITAR CLIENTE
    public Form_SubVentana mClienteEventHandler(ActionEvent event) {
        BorderPane clienteEliminar = new BorderPane();
        Label titulo = new Label("Editar Informacion de un CLiente");
        titulo.setFont(Font.font("News701 BT", 25));
        titulo.setTextFill(Color.WHITE);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 20));
        cerrar.setTextFill(Color.BLACK);
        Form_Barra_De_Titulo bTitulo = new Form_Barra_De_Titulo(titulo, cerrar);
        clienteEliminar.setTop(bTitulo.getBarra());
        Form_EditarCliente cliente = new Form_EditarCliente();
        clienteEliminar.setCenter(cliente.getPnlFinal());
        Form_SubVentana subCliente = new Form_SubVentana();
        subCliente.setRoot(clienteEliminar);
        subCliente.makeDragable(bTitulo.getBarra());
        subCliente.makeDragable(titulo);
        subCliente.makeResizable(20);
        subCliente.makeFocusable();
        subCliente.setCloseButton(cerrar);
        return subCliente;
    }

    //ELIMINAR CLIENTE
    public Form_SubVentana eClienteEventHandler(ActionEvent event) {
        BorderPane clienteEliminar = new BorderPane();
        Label titulo = new Label("Eliminar CLiente");
        titulo.setFont(Font.font("News701 BT", 25));
        titulo.setTextFill(Color.WHITE);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 20));
        cerrar.setTextFill(Color.BLACK);
        Form_Barra_De_Titulo bTitulo = new Form_Barra_De_Titulo(titulo, cerrar);
        clienteEliminar.setTop(bTitulo.getBarra());
        Form_EliminarCliente cliente = new Form_EliminarCliente();
        clienteEliminar.setCenter(cliente.getPnlFinal());
        Form_SubVentana subCliente = new Form_SubVentana();
        subCliente.setRoot(clienteEliminar);
        subCliente.makeDragable(bTitulo.getBarra());
        subCliente.makeDragable(titulo);
        subCliente.makeResizable(20);
        subCliente.makeFocusable();
        subCliente.setCloseButton(cerrar);
        return subCliente;
    }

    //INFORMACION DE UN CLIENTE
    public Form_SubVentana bClienteEventHandler(ActionEvent event) {
        BorderPane clienteBuscar = new BorderPane();
        Label titulo = new Label("Informacion de un CLiente");
        titulo.setFont(Font.font("News701 BT", 25));
        titulo.setTextFill(Color.WHITE);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 20));
        cerrar.setTextFill(Color.BLACK);
        Form_Barra_De_Titulo bTitulo = new Form_Barra_De_Titulo(titulo, cerrar);
        clienteBuscar.setTop(bTitulo.getBarra());
        Form_BuscarCliente cliente = new Form_BuscarCliente();
        clienteBuscar.setCenter(cliente.getPnlFinal());
        Form_SubVentana subCliente = new Form_SubVentana();
        subCliente.setRoot(clienteBuscar);
        subCliente.makeDragable(bTitulo.getBarra());
        subCliente.makeDragable(titulo);
        subCliente.makeResizable(20);
        subCliente.makeFocusable();
        subCliente.setCloseButton(cerrar);
        return subCliente;
    }

    //LISTADO DE CLIENTES
    public Form_SubVentana lstClienteEventHandler(ActionEvent event) {
        BorderPane listClientes = new BorderPane();
        Label titulo = new Label("Listado de CLientes");
        titulo.setFont(Font.font("News701 BT", 25));
        titulo.setTextFill(Color.WHITE);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 20));
        cerrar.setTextFill(Color.BLACK);
        Form_Barra_De_Titulo bTitulo = new Form_Barra_De_Titulo(titulo, cerrar);
        listClientes.setTop(bTitulo.getBarra());
        Form_Listado_Cliente cliente = new Form_Listado_Cliente();
        listClientes.setCenter(cliente.getPnlFinal());
        Form_SubVentana subCliente = new Form_SubVentana();
        subCliente.setRoot(listClientes);
        subCliente.makeDragable(bTitulo.getBarra());
        subCliente.makeDragable(titulo);
        subCliente.makeResizable(20);
        subCliente.makeFocusable();
        subCliente.setCloseButton(cerrar);
        return subCliente;
    }
//PROVEEDOR

    //NUEVO PROVEEDOR
    public Form_SubVentana nProveedorEventHandler(ActionEvent event) {
        BorderPane proveedorNuevo = new BorderPane();
        Label titulo = new Label("Nuevo Proveedor");
        titulo.setFont(Font.font("News701 BT", 25));
        titulo.setTextFill(Color.WHITE);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 20));
        cerrar.setTextFill(Color.BLACK);
        //obejto de barra de titulo
        Form_Barra_De_Titulo bTitulo = new Form_Barra_De_Titulo(titulo, cerrar);
        proveedorNuevo.setTop(bTitulo.getBarra());
        //creo un objeto de tipo nuevo proveedor
        Form_Nuevo_Proveedor proveedor = new Form_Nuevo_Proveedor();
        proveedorNuevo.setCenter(proveedor.getPnlFinal());//agrego en la parte central el nuevo proveedor
        Form_SubVentana subProveedor = new Form_SubVentana();
        subProveedor.setRoot(proveedorNuevo);
        subProveedor.makeDragable(bTitulo.getBarra());
        subProveedor.makeDragable(titulo);
        subProveedor.makeResizable(20);
        subProveedor.makeFocusable();
        subProveedor.setCloseButton(cerrar);
        return subProveedor;
    }

    //EDITAR PROVEEDOR
    public Form_SubVentana mProveedorEventHandler(ActionEvent event) {
        BorderPane eProveedor = new BorderPane();
        Label titulo = new Label("Eliminar un Proveedor");
        titulo.setFont(Font.font("News701 BT", 25));
        titulo.setTextFill(Color.WHITE);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 20));
        cerrar.setTextFill(Color.BLACK);
        Form_Barra_De_Titulo bTitulo = new Form_Barra_De_Titulo(titulo, cerrar);
        eProveedor.setTop(bTitulo.getBarra());
        Form_EditarProveedor proveedor = new Form_EditarProveedor();
        eProveedor.setCenter(proveedor.getPnlFinal());
        Form_SubVentana subProveedor = new Form_SubVentana();
        subProveedor.setRoot(eProveedor);
        subProveedor.makeDragable(bTitulo.getBarra());
        subProveedor.makeDragable(titulo);
        subProveedor.makeResizable(20);
        subProveedor.makeFocusable();
        subProveedor.setCloseButton(cerrar);
        return subProveedor;
    }
    //ELIMINAR PROVEEDOR
    public Form_SubVentana eProveedorEventHandler(ActionEvent event) {
        BorderPane eProveedor = new BorderPane();
        Label titulo = new Label("Eliminar un Proveedor");
        titulo.setFont(Font.font("News701 BT", 25));
        titulo.setTextFill(Color.WHITE);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 20));
        cerrar.setTextFill(Color.BLACK);
        Form_Barra_De_Titulo bTitulo = new Form_Barra_De_Titulo(titulo, cerrar);
        eProveedor.setTop(bTitulo.getBarra());
        Form_EliminarProveedor proveedor = new Form_EliminarProveedor();
        eProveedor.setCenter(proveedor.getPnlFinal());
        Form_SubVentana subProveedor = new Form_SubVentana();
        subProveedor.setRoot(eProveedor);
        subProveedor.makeDragable(bTitulo.getBarra());
        subProveedor.makeDragable(titulo);
        subProveedor.makeResizable(20);
        subProveedor.makeFocusable();
        subProveedor.setCloseButton(cerrar);
        return subProveedor;
    }

    //INFORMACION DE UN PROVEEDOR
    public Form_SubVentana bProveedorEventHandler(ActionEvent event) {
        BorderPane proveedorInfo = new BorderPane();
        Label titulo = new Label("Informacion de Proveedor");
        titulo.setFont(Font.font("News701 BT", 25));
        titulo.setTextFill(Color.WHITE);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 20));
        cerrar.setTextFill(Color.BLACK);
        //obejto de barra de titulo
        Form_Barra_De_Titulo bTitulo = new Form_Barra_De_Titulo(titulo, cerrar);
        proveedorInfo.setTop(bTitulo.getBarra());
        //creo un objeto de tipo nuevo proveedor
        Form_BuscarProveedor proveedor = new Form_BuscarProveedor();
        proveedorInfo.setCenter(proveedor.getPnlFinal());//agrego en la parte central el nuevo proveedor
        Form_SubVentana subProveedor = new Form_SubVentana();
        subProveedor.setRoot(proveedorInfo);
        subProveedor.makeDragable(bTitulo.getBarra());
        subProveedor.makeDragable(titulo);
        subProveedor.makeResizable(20);
        subProveedor.makeFocusable();
        subProveedor.setCloseButton(cerrar);
        return subProveedor;
    }

    //LISTADO DE PROVEEDOR
    public Form_SubVentana lstProveedorEventHandler(ActionEvent event) {
        BorderPane listProveedor = new BorderPane();
        Label titulo = new Label("Listado de Proveedores");
        titulo.setFont(Font.font("News701 BT", 25));
        titulo.setTextFill(Color.WHITE);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 20));
        cerrar.setTextFill(Color.BLACK);
        Form_Barra_De_Titulo bTitulo = new Form_Barra_De_Titulo(titulo, cerrar);
        listProveedor.setTop(bTitulo.getBarra());
        Form_Listado_Proveedor proveedor = new Form_Listado_Proveedor();
        listProveedor.setCenter(proveedor.getPnlFinal());
        Form_SubVentana subProveedor = new Form_SubVentana();
        subProveedor.setRoot(listProveedor);
        subProveedor.makeDragable(bTitulo.getBarra());
        subProveedor.makeDragable(titulo);
        subProveedor.makeResizable(20);
        subProveedor.makeFocusable();
        subProveedor.setCloseButton(cerrar);
        return subProveedor;
    }
//PRODUCTO

    //NUEVO PRODUCTO
    public Form_SubVentana nProductoEventHandler(ActionEvent event) {
        BorderPane producNuevo = new BorderPane();
        Label titulo = new Label("Nuevo Producto");
        titulo.setFont(Font.font("News701 BT", 25));
        titulo.setTextFill(Color.WHITE);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 20));
        cerrar.setTextFill(Color.BLACK);
        Form_Barra_De_Titulo bTitulo = new Form_Barra_De_Titulo(titulo, cerrar);
        producNuevo.setTop(bTitulo.getBarra());
        Form_Nuevo_Producto producto = new Form_Nuevo_Producto();
        producNuevo.setCenter(producto.getPnlFinal());
        Form_SubVentana subProducto = new Form_SubVentana();
        subProducto.setRoot(producNuevo);
        subProducto.makeDragable(bTitulo.getBarra());
        subProducto.makeDragable(titulo);
        subProducto.makeResizable(20);
        subProducto.makeFocusable();
        subProducto.setCloseButton(cerrar);
        return subProducto;
    }

    //EDITAR PRODUCTO
    //ELIMINAR PRODUCTO
    public Form_SubVentana eProductoEventHandler(ActionEvent event) {
        BorderPane producEli = new BorderPane();
        Label titulo = new Label("Eliminar un Producto");
        titulo.setFont(Font.font("News701 BT", 25));
        titulo.setTextFill(Color.WHITE);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 20));
        cerrar.setTextFill(Color.BLACK);
        Form_Barra_De_Titulo bTitulo = new Form_Barra_De_Titulo(titulo, cerrar);
        producEli.setTop(bTitulo.getBarra());
        Form_EliminarProducto producto = new Form_EliminarProducto();
        producEli.setCenter(producto.getPnlFinal());
        Form_SubVentana subProducto = new Form_SubVentana();
        subProducto.setRoot(producEli);
        subProducto.makeDragable(bTitulo.getBarra());
        subProducto.makeDragable(titulo);
        subProducto.makeResizable(20);
        subProducto.makeFocusable();
        subProducto.setCloseButton(cerrar);
        return subProducto;
    }

    //INFORMACION DE UN PRODUCTO
    public Form_SubVentana bProductoEventHandler(ActionEvent event) {
        BorderPane producBuscar = new BorderPane();
        Label titulo = new Label("Informacion de Producto");
        titulo.setFont(Font.font("News701 BT", 25));
        titulo.setTextFill(Color.WHITE);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 20));
        cerrar.setTextFill(Color.BLACK);
        Form_Barra_De_Titulo bTitulo = new Form_Barra_De_Titulo(titulo, cerrar);
        producBuscar.setTop(bTitulo.getBarra());
        Form_BuscarProducto producto = new Form_BuscarProducto();
        producBuscar.setCenter(producto.getPnlFinal());
        Form_SubVentana subProducto = new Form_SubVentana();
        subProducto.setRoot(producBuscar);
        subProducto.makeDragable(bTitulo.getBarra());
        subProducto.makeDragable(titulo);
        subProducto.makeResizable(20);
        subProducto.makeFocusable();
        subProducto.setCloseButton(cerrar);
        return subProducto;
    }

    //LISTADO DE PRODUCTO
    public Form_SubVentana lstProductoEventHandler(ActionEvent event) {
        BorderPane listProd = new BorderPane();
        Label titulo = new Label("Listado de Productos");
        titulo.setFont(Font.font("News701 BT", 25));
        titulo.setTextFill(Color.WHITE);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 20));
        cerrar.setTextFill(Color.BLACK);
        Form_Barra_De_Titulo bTitulo = new Form_Barra_De_Titulo(titulo, cerrar);
        listProd.setTop(bTitulo.getBarra());
        Form_Listado_Producto producto = new Form_Listado_Producto();
        listProd.setCenter(producto.getPnlFinal());
        Form_SubVentana subProducto = new Form_SubVentana();
        subProducto.setRoot(listProd);
        subProducto.makeDragable(bTitulo.getBarra());
        subProducto.makeDragable(titulo);
        subProducto.makeResizable(20);
        subProducto.makeFocusable();
        subProducto.setCloseButton(cerrar);
        return subProducto;
    }
//CATEGORIA

    //NUEVO CATEGORIA
    public Form_SubVentana nCategoriaEventHandler(ActionEvent event) {
        BorderPane categNueva = new BorderPane();
        Label titulo = new Label("Nueva Categoria");
        titulo.setFont(Font.font("News701 BT", 25));
        titulo.setTextFill(Color.WHITE);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 20));
        cerrar.setTextFill(Color.BLACK);
        Form_Barra_De_Titulo bTitulo = new Form_Barra_De_Titulo(titulo, cerrar);
        categNueva.setTop(bTitulo.getBarra());
        Form_Nueva_Categoria categoria = new Form_Nueva_Categoria();
        categNueva.setCenter(categoria.getPnlFinal());
        Form_SubVentana subCategoria = new Form_SubVentana();
        subCategoria.setRoot(categNueva);
        subCategoria.makeDragable(bTitulo.getBarra());
        subCategoria.makeDragable(titulo);
        subCategoria.makeResizable(20);
        subCategoria.makeFocusable();
        subCategoria.setCloseButton(cerrar);
        return subCategoria;
    }

    //EDITAR CATEGORIA
    //ELIMINAR CATEGORIA
    public Form_SubVentana eCategoriaEventHandler(ActionEvent event) {
        BorderPane eCategoria = new BorderPane();
        Label titulo = new Label("Eliminar una Categoria");
        titulo.setFont(Font.font("News701 BT", 25));
        titulo.setTextFill(Color.WHITE);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 20));
        cerrar.setTextFill(Color.BLACK);
        Form_Barra_De_Titulo bTitulo = new Form_Barra_De_Titulo(titulo, cerrar);
        eCategoria.setTop(bTitulo.getBarra());
        Form_EliminarCategoria categoria = new Form_EliminarCategoria();
        eCategoria.setCenter(categoria.getPnlFinal());
        Form_SubVentana subCategoria = new Form_SubVentana();
        subCategoria.setRoot(eCategoria);
        subCategoria.makeDragable(bTitulo.getBarra());
        subCategoria.makeDragable(titulo);
        subCategoria.makeResizable(20);
        subCategoria.makeFocusable();
        subCategoria.setCloseButton(cerrar);
        return subCategoria;
    }

    //INFORMACION DE UN CATEGORIA
    public Form_SubVentana bCategoriaEventHandler(ActionEvent event) {
        BorderPane buscaCategoria = new BorderPane();
        Label titulo = new Label("Informacion de Categoria");
        titulo.setFont(Font.font("News701 BT", 25));
        titulo.setTextFill(Color.WHITE);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 20));
        cerrar.setTextFill(Color.BLACK);
        Form_Barra_De_Titulo bTitulo = new Form_Barra_De_Titulo(titulo, cerrar);
        buscaCategoria.setTop(bTitulo.getBarra());
        Form_BuscarCategoria categoria = new Form_BuscarCategoria();
        buscaCategoria.setCenter(categoria.getPnlFinal());
        Form_SubVentana subCategoria = new Form_SubVentana();
        subCategoria.setRoot(buscaCategoria);
        subCategoria.makeDragable(bTitulo.getBarra());
        subCategoria.makeDragable(titulo);
        subCategoria.makeResizable(20);
        subCategoria.makeFocusable();
        subCategoria.setCloseButton(cerrar);
        return subCategoria;
    }

    //LISTADO DE CATEGORIA
    public Form_SubVentana lstCategoriaEventHandler(ActionEvent event) {
        BorderPane listCateg = new BorderPane();
        Label titulo = new Label("Lista de Categorias");
        titulo.setFont(Font.font("News701 BT", 25));
        titulo.setTextFill(Color.WHITE);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 20));
        cerrar.setTextFill(Color.BLACK);
        Form_Barra_De_Titulo bTitulo = new Form_Barra_De_Titulo(titulo, cerrar);
        listCateg.setTop(bTitulo.getBarra());
        Form_Listado_Categoria categoria = new Form_Listado_Categoria();
        listCateg.setCenter(categoria.getPnlFinal());
        Form_SubVentana subCategoria = new Form_SubVentana();
        subCategoria.setRoot(listCateg);
        subCategoria.makeDragable(bTitulo.getBarra());
        subCategoria.makeDragable(titulo);
        subCategoria.makeResizable(20);
        subCategoria.makeFocusable();
        subCategoria.setCloseButton(cerrar);
        return subCategoria;
    }
//KARDEX

    //KARDEX MENSUAL
    //LISTADO DE KARDEX
//CONSULTAS
    //LOS 3 PRODUCTOS MAS VENDIDOS
    //LOS 3 PROVEEDORES CON MAS COMPRAS
    //EL MEJOR CLIENTE
    //LOS PRODUCTOS CON SU STOCK
}
