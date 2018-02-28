package kardex.vistas;

import com.sun.javafx.scene.control.skin.LabeledText;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.scene.control.Button;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.text.*;
import kardex.negocio.dao.*;
import kardex.negocio.entidades.*;
import kardex.negocio.impl.*;
import kardex.accesoadatos.*;

public class Form_Nueva_FacturaVenta {

    private Image iFondo;
    private BackgroundImage fondo;
    private Label lblCedula;
    private Label lblNombre;
    private Label lblDireccion;
    private Label lblTelefono;
    private Label lblEmail;
    private TextField cedula;
    private Label nombres;
    private Label direccion;
    private Label telefono;
    private Label email;
    private VBox pntCliente;
    private Button btnBuscar;
    private HBox pntCliente1;
    private HBox pntCliente2;
    private HBox pntCliente3;
    private HBox pntCliente4;
    private ArrayList<Factura_Venta> listaFacturas;
    private Cliente client;
    //DETALLE VENTA
    private Group pntMedio;
    private VBox detaVenta;
    private Label codigo;
    private Label nombre;
    private Label cantidad;
    private Label precioU;
    private Label precioT;
    private Label accion;
    private VBox cod;
    private ObservableList<TextField> lstCodigo = FXCollections.observableArrayList();
    private ArrayList<Integer> listaCodigo = new ArrayList<Integer>();
    private TextField tfCodigo;
    private VBox nom;
    private ComboBox<Producto> cbxProd;
    private ArrayList<Producto> listaProdF;
    private ObservableList<ComboBox<Producto>> cbxProducto = FXCollections.observableArrayList();
    private ObservableList<Producto> listaProductos = FXCollections.observableArrayList();
    private ArrayList<Producto> listProducto;
    private VBox cant;
    private ObservableList<TextField> lstCantidad = FXCollections.observableArrayList();
    private ArrayList<Integer> listaCantidad = new ArrayList<Integer>();
    private TextField tfCantidad;
    private VBox pUnit;
    private ObservableList<TextField> lstPrecioU = FXCollections.observableArrayList();
    private ArrayList<Double> listaPrecioU = new ArrayList<Double>();
    private TextField tfPrecioU;
    private VBox pTot;
    private ObservableList<TextField> lstPrecioT = FXCollections.observableArrayList();
    private ArrayList<Double> listaPrecioT = new ArrayList<Double>();
    private TextField tfprecioT;
    private Button btnFila;
    private HBox pntItems;
    private HBox items;
    private ScrollPane pntDesplazable;
    private VBox vItems;
    /////////////////
    //////////Factura////////////
    private Label tituloFac;
    private Label txtCodFactura;
    private TextField tfCodFactura;
    private Label txtFechaFact;
    private TextField tfFechaFact;
    private HBox pntFactura1;
    private HBox pntFactura2;
    private HBox pntFactura3;
    private VBox pntFact;
    /// Logo ////
    private Image iLogo;
    private ImageView mostrarLogo;
    //////// Cabecera /////////
    private HBox pntCabecera;
    private VBox pntCFinal;
    /////////Pie/////////
    private Label txtTotalAntes;
    private Label TotalAntes;
    private Label txtIva;
    private TextField iva;
    private Label txtTotalFinal;
    private Label totalFinal;
    private HBox pntFin1;
    private HBox pntFin2;
    private HBox pntFin3;
    private HBox pntbotones;
    private Button btnVender;
    private Button btnlimpiar;
    private VBox pntFinal;
    private double totalA;
    private double totalF;
    private double ivaUsado;
    private ArrayList<Detalle_Venta> listaVentas;
    private String tipoTransaccion;
    private BorderPane PnlFinal;
    private ArrayList<Kardex> listadoKardex;

    public Form_Nueva_FacturaVenta() {
        totalA = 0;
        totalF = 0;
        tipoTransaccion = "V";
        //PANEL SUPERIOR CLIENTE
        iFondo = new Image("file:src\\kardex\\multimedia\\images\\fondo.jpg");
        fondo = new BackgroundImage(iFondo, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        lblCedula = new Label("Cedula/Ruc Cliente:   ");
        lblCedula.setFont(Font.font("News701 BT", 15));
        btnBuscar = new Button("Buscar");
        lblNombre = new Label("Nombre: ");
        lblNombre.setFont(Font.font("News701 BT", 15));
        lblDireccion = new Label("Direccion: ");
        lblDireccion.setFont(Font.font("News701 BT", 15));
        lblTelefono = new Label("Telefono: ");
        lblTelefono.setFont(Font.font("News701 BT", 15));
        lblEmail = new Label("Correo: ");
        lblEmail.setFont(Font.font("News701 BT", 15));
        cargarProducto();
        listaProdF = new ArrayList<Producto>();
        //cajas de texto
        cedula = new TextField("0000000000001");
        cedula.setMaxSize(150, 25);
        cedula.setMinSize(150, 25);
        nombres = new Label("");
        nombres.setStyle("-fx-border-color: black; -fx-border-width: 2px");
        nombres.setMaxSize(250, 25);
        nombres.setMinSize(250, 25);
        direccion = new Label("");
        direccion.setStyle("-fx-border-color: black; -fx-border-width: 2px");
        direccion.setMaxSize(225, 25);
        direccion.setMinSize(225, 25);
        telefono = new Label("");
        telefono.setStyle("-fx-border-color: black; -fx-border-width: 2px");
        telefono.setMaxSize(75, 25);
        telefono.setMinSize(75, 25);
        email = new Label("");
        email.setStyle("-fx-border-color: black; -fx-border-width: 2px");
        email.setMaxSize(100, 25);
        email.setMinSize(100, 25);
        pntCliente1 = new HBox(5);
        pntCliente1.getChildren().addAll(lblCedula, cedula, btnBuscar);
        pntCliente1.setAlignment(Pos.CENTER);
        pntCliente2 = new HBox(5);
        pntCliente2.getChildren().addAll(lblNombre, nombres);
        pntCliente2.setAlignment(Pos.CENTER);
        pntCliente3 = new HBox(5);
        pntCliente3.getChildren().addAll(lblDireccion, direccion);
        pntCliente3.setAlignment(Pos.CENTER);
        pntCliente4 = new HBox(5);
        pntCliente4.getChildren().addAll(lblTelefono, telefono, lblEmail, email);
        pntCliente4.setAlignment(Pos.CENTER);
        pntCliente = new VBox(2);
        pntCliente.getChildren().addAll(pntCliente1, pntCliente2, pntCliente3, pntCliente4);
        consumidorFinal();
        ///////////Logo///////////
        iLogo = new Image("file:src\\kardex\\multimedia\\images\\logoFactura.png");
        mostrarLogo = new ImageView(iLogo);
        mostrarLogo.setFitHeight(100);
        mostrarLogo.setFitWidth(400);
        mostrarLogo.setOpacity(25);
        ///////////7////////////
        ///////////////Factura/////////////////
        tituloFac = new Label("Informacion de Facturacion");
        tituloFac.setMaxSize(200, 75);
        tituloFac.setMinSize(200, 75);
        tituloFac.setFont(Font.font("News701 BT", 25));
        tituloFac.setAlignment(Pos.CENTER);
        tituloFac.setWrapText(true);
        txtCodFactura = new Label("Codigo Factura: ");
        tituloFac.setMaxSize(100, 25);
        tituloFac.setMaxSize(100, 25);
        txtCodFactura.setFont(Font.font("News701 BT", 15));
        tfCodFactura = new TextField(String.valueOf(cargarFactura() + 1));
        tfCodFactura.setMaxSize(100, 25);
        tfCodFactura.setMinSize(100, 25);
        txtFechaFact = new Label("Fecha de Emision: ");
        tituloFac.setMaxSize(100, 25);
        tituloFac.setMaxSize(100, 25);
        txtFechaFact.setFont(Font.font("News701 BT", 15));
        tfFechaFact = new TextField("");
        tfFechaFact.setMaxSize(100, 25);
        tfFechaFact.setMinSize(100, 25);
        pntFactura1 = new HBox(5);
        pntFactura1.getChildren().add(tituloFac);
        pntFactura1.setAlignment(Pos.CENTER);
        pntFactura2 = new HBox(5);
        pntFactura2.getChildren().addAll(txtCodFactura, tfCodFactura);
        pntFactura2.setAlignment(Pos.CENTER);
        pntFactura3 = new HBox(5);
        pntFactura3.getChildren().addAll(txtFechaFact, tfFechaFact);
        pntFactura3.setAlignment(Pos.CENTER);
        pntFact = new VBox(2);
        pntFact.getChildren().addAll(pntFactura1, pntFactura2, pntFactura3);
        pntFact.setAlignment(Pos.CENTER);
        //////////////////////
        ////////////CABECERA///////////
        pntCabecera = new HBox(10);
        pntCabecera.getChildren().addAll(pntCliente, pntFact);
        pntCabecera.setAlignment(Pos.CENTER);
        pntCFinal = new VBox(5);
        pntCFinal.getChildren().addAll(mostrarLogo, pntCabecera);
        pntCFinal.setAlignment(Pos.CENTER);
        //barra Items
        detaVenta = new VBox();
        codigo = new Label("Codigo");
        codigo.setMaxSize(100, 30);
        codigo.setMinSize(100, 30);
        codigo.setFont(Font.font("News701 BT"));
        codigo.setStyle("-fx-border-color: black; -fx-border-width: 2px");
        codigo.setAlignment(Pos.CENTER);
        nombre = new Label("Nombre");
        nombre.setMaxSize(325, 30);
        nombre.setMinSize(325, 30);
        nombre.setFont(Font.font("News701 BT"));
        nombre.setStyle("-fx-border-color: black; -fx-border-width: 2px");
        nombre.setAlignment(Pos.CENTER);
        cantidad = new Label("Cantidad");
        cantidad.setMaxSize(75, 30);
        cantidad.setMinSize(75, 30);
        cantidad.setFont(Font.font("News701 BT"));
        cantidad.setStyle("-fx-border-color: black; -fx-border-width: 2px");
        cantidad.setAlignment(Pos.CENTER);
        precioU = new Label("P. Unit");
        precioU.setMaxSize(50, 30);
        precioU.setMinSize(50, 30);
        precioU.setFont(Font.font("News701 BT"));
        precioU.setStyle("-fx-border-color: black; -fx-border-width: 2px");
        precioU.setAlignment(Pos.CENTER);
        precioT = new Label("p. Total");
        precioT.setMaxSize(50, 30);
        precioT.setMinSize(50, 30);
        precioT.setFont(Font.font("News701 BT"));
        precioT.setStyle("-fx-border-color: black; -fx-border-width: 2px");
        precioT.setAlignment(Pos.CENTER);
        accion = new Label("Ins");
        accion.setFont(Font.font("News701 BT"));
        accion.setMaxSize(55, 30);
        accion.setMinSize(55, 30);
        accion.setStyle("-fx-border-color: black; -fx-border-width: 2px");
        accion.setAlignment(Pos.CENTER);
        pntItems = new HBox(2);
        pntItems.setMaxSize(670, 30);
        pntItems.setMinSize(670, 30);
        pntItems.getChildren().addAll(codigo, nombre, cantidad, precioU, precioT, accion);
        pntItems.setAlignment(Pos.CENTER);
        //btnaccion
        btnFila = new Button("...");
        btnFila.setMaxSize(25, 25);
        btnFila.setMinSize(25, 25);
        items = new HBox(1);
        generarFilaVenta();
        items.setStyle("-fx-border-color: white; -fx-border-width: 2px");
        items.setMaxWidth(670);
        items.setMinWidth(670);
        vItems = new VBox();
        vItems.getChildren().add(items);
        pntDesplazable = new ScrollPane(vItems);
        pntDesplazable.setMaxSize(675, 100);
        pntDesplazable.setMinSize(675, 100);
        pntDesplazable.setVmax(5000);
        pntDesplazable.setVmin(0);
        detaVenta.getChildren().addAll(pntItems, pntDesplazable);
        detaVenta.setAlignment(Pos.CENTER);
        detaVenta.setPadding(new Insets(10));
        /////////////////////
        ////////////panel Fina////////////
        txtTotalAntes = new Label("Total Antes: ");
        txtTotalAntes.setFont(Font.font("News701 BT",10));
        TotalAntes = new Label("");
        TotalAntes.setMaxSize(100, 25);
        TotalAntes.setMinSize(100, 25);
        TotalAntes.setFont(Font.font("News701 BT",10));
        TotalAntes.setStyle("-fx-border-color: black; -fx-border-width: 2px");
        txtIva = new Label("IVA: ");
        txtIva.setFont(Font.font("News701 BT",10));
        iva = new TextField("12");
        iva.setMaxSize(100, 25);
        iva.setMinSize(100, 25);
        txtTotalFinal = new Label("Total Final: ");
        txtTotalFinal.setFont(Font.font("News701 BT",10));
        totalFinal = new Label("");
        totalFinal.setMaxSize(100, 25);
        totalFinal.setMinSize(100, 25);
        totalFinal.setFont(Font.font("News701 BT",10));
        totalFinal.setStyle("-fx-border-color: black; -fx-border-width: 2px");
        pntFin1 = new HBox(5);
        pntFin1.getChildren().addAll(txtTotalAntes, TotalAntes);
        pntFin1.setAlignment(Pos.CENTER_RIGHT);
        pntFin2 = new HBox(5);
        pntFin2.getChildren().addAll(txtIva, iva);
        pntFin2.setAlignment(Pos.CENTER_RIGHT);
        pntFin3 = new HBox(5);
        pntFin3.getChildren().addAll(txtTotalFinal, totalFinal);
        pntFin3.setAlignment(Pos.CENTER_RIGHT);
        btnlimpiar = new Button("Limpiar");
        btnlimpiar.setFont(Font.font("News701 BT", 15));
        btnVender = new Button("Vender");
        btnVender.setFont(Font.font("News701 BT", 15));
        pntbotones = new HBox(10);
        pntbotones.getChildren().addAll(btnlimpiar, btnVender);
        pntbotones.setAlignment(Pos.CENTER_RIGHT);
        pntFinal = new VBox();
        pntFinal.getChildren().addAll(pntFin1, pntFin2, pntFin3, pntbotones);
        /////////////////////////////
        PnlFinal = new BorderPane();
        PnlFinal.setTop(pntCFinal);
        PnlFinal.setCenter(detaVenta);
        PnlFinal.setBottom(pntFinal);
        PnlFinal.setPadding(new Insets(5));
        PnlFinal.setBackground(new Background(fondo));
        PnlFinal.setStyle("-fx-padding: 10; -fx-border-color: black; -fx-border-width: 2px");

        btnFila.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                insertarVentaPEventHandler(event);
            }
        });
        btnVender.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                btnVenderEventHandler(event);
            }
        });
        btnlimpiar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                btnLimpiarEventHandler(event);
            }
        });
        btnBuscar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                btnBuscarEventHandler(event);
            }
        });

    }

    public Node getPnlFinal() {
        return PnlFinal;
    }

    public void consumidorFinal() {
        ClienteI clienteDao = new ClienteImp();
        Cliente nCliente = new Cliente();
        try {
            nCliente = clienteDao.obtener(cedula.getText());
            nombres.setText(nCliente.getNombre() + " " + nCliente.getApellido());
            direccion.setText(nCliente.getDireccion());
            telefono.setText(nCliente.getTelefono());
            email.setText(nCliente.getEmail());
        } catch (Exception e) {
        }
    }

    public void calcular(ActionEvent event) {
        double v1 = Double.parseDouble(tfCantidad.getText());
        double v2 = Double.parseDouble(tfPrecioU.getText());
        tfprecioT.setText(String.valueOf(v1 * v2));
    }

    public void btnFilaEventHandler(ActionEvent event) {
        double v1 = Double.parseDouble(tfCantidad.getText());
        double v2 = Double.parseDouble(tfPrecioU.getText());
        tfprecioT.setText(String.valueOf(v1 * v2));
        listaCodigo.add(Integer.parseInt(tfCodigo.getText()));
        listaProdF.add(cbxProd.getValue());
        listaCantidad.add(Integer.parseInt(tfCantidad.getText()));
        listaPrecioU.add(Double.parseDouble(tfPrecioU.getText()));
        listaPrecioT.add(Double.parseDouble(tfprecioT.getText()));
    }

    public void generarFilaVenta() {
        //listado de items
        //codigo
        tfCodigo = new TextField();
        tfCodigo.setMaxSize(100, 25);
        tfCodigo.setMinSize(100, 25);
        tfCodigo.setStyle("-fx-border-color: black; -fx-border-width: 2px");
        tfCodigo.setEditable(false);
        lstCodigo.add(tfCodigo);
        cod = new VBox();
        cod.getChildren().addAll(lstCodigo);
        cod.setAlignment(Pos.BOTTOM_CENTER);
        //nombre
        listaProductos.addAll(listProducto);
        cbxProd = new ComboBox<Producto>(listaProductos);
        cbxProducto.add(cbxProd);
        nom = new VBox();
        nom.getChildren().addAll(cbxProducto);
        nom.setAlignment(Pos.BOTTOM_CENTER);
        //cantidad
        tfCantidad = new TextField();
        tfCantidad.setMaxSize(100, 25);
        tfCantidad.setMinSize(100, 25);
        tfCantidad.setStyle("-fx-border-color: black; -fx-border-width: 2px");
        lstCantidad.add(tfCantidad);
        cant = new VBox();
        cant.getChildren().addAll(lstCantidad);
        cant.setAlignment(Pos.BOTTOM_CENTER);
        //pu
        tfPrecioU = new TextField();
        tfPrecioU.setMaxSize(50, 25);
        tfPrecioU.setMinSize(50, 25);
        tfPrecioU.setStyle("-fx-border-color: black; -fx-border-width: 2px");
        tfPrecioU.setEditable(false);
        lstPrecioU.add(tfPrecioU);
        pUnit = new VBox();
        pUnit.getChildren().addAll(lstPrecioU);
        pUnit.setAlignment(Pos.BOTTOM_CENTER);
        //pt
        tfprecioT = new TextField();
        tfprecioT.setMaxSize(50, 25);
        tfprecioT.setMinSize(50, 25);
        tfprecioT.setStyle("-fx-border-color: black; -fx-border-width: 2px");
        tfprecioT.setEditable(false);
        lstPrecioT.add(tfprecioT);
        pTot = new VBox();
        pTot.getChildren().addAll(lstPrecioT);
        pTot.setAlignment(Pos.BOTTOM_CENTER);
        items = new HBox(1);
        items.setPadding(new Insets(1));
        items.getChildren().addAll(cod, nom, cant, pUnit, pTot, btnFila);
        items.setAlignment(Pos.BOTTOM_LEFT);
        tfCantidad.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                calcular(event);
            }
        });
        cbxProd.setOnHiding(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                llenarProducto(event);
            }
        });
    }

    public void llenarProducto(Event event) {
        try {
            tfCodigo.setText(String.valueOf(cbxProd.getValue().getCodigoProducto()));
            tfPrecioU.setText(String.valueOf(cbxProd.getValue().getPrecio()));
        } catch (Exception e) {
        }
    }

    public void insertarVentaPEventHandler(ActionEvent event) {
        ProductoI prodDao = new ProductoImp();
        Producto produc = null;
        try {
            produc = new Producto();
            if (tfCodigo.getText() != null && tfCantidad.getText() != null && tfPrecioU.getText() != null && tfprecioT.getText() != null) {
                listaCodigo.add(Integer.parseInt(tfCodigo.getText()));
                produc = prodDao.obtener(Integer.parseInt(tfCodigo.getText()));
                listaProdF.add(produc);;
                listaCantidad.add(Integer.parseInt(tfCantidad.getText()));
                listaPrecioU.add(Double.parseDouble(tfPrecioU.getText()));
                listaPrecioT.add(Double.parseDouble(tfprecioT.getText()));
                ivaUsado = Double.parseDouble(iva.getText()) / 100;
                totalA = totalA + Double.parseDouble(tfprecioT.getText());
                TotalAntes.setText(String.valueOf(totalA));
                totalF = totalA + (ivaUsado * totalA);
                totalFinal.setText(String.valueOf(totalF));
                generarFilaVenta();
                vItems.getChildren().add(items);
            } else {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("INFORMACION DEL SISTEMA");
                alerta.setHeaderText(null);
                alerta.setContentText("Error campos Vacios en factura! ");
                alerta.showAndWait();
            }
            vItems.getChildren().add(items);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    private int cargarFactura() {
        int numCateg = 0;
        listaFacturas = new ArrayList<>();
        Factura_VentaI factDao = new Factura_VentaImp();
        try {
            listaFacturas = factDao.obtener();
            numCateg = listaFacturas.size();
        } catch (Exception e) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("INFORMACION DEL SISTEMA");
            alerta.setHeaderText(null);
            alerta.setContentText("Error: " + e.getMessage());
            alerta.showAndWait();
        }
        return numCateg;
    }

    private int cargarDetalleVenta() {
        int numCateg = 0;
        listaVentas = new ArrayList<>();
        Detalle_VentaI ventaDao = new Detalle_VentaImp();
        try {
            listaVentas = ventaDao.obtener();
            numCateg = listaFacturas.size();
        } catch (Exception e) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("INFORMACION DEL SISTEMA");
            alerta.setHeaderText(null);
            alerta.setContentText("Error: " + e.getMessage());
            alerta.showAndWait();
        }
        return numCateg;
    }

    public void btnVenderEventHandler(ActionEvent event) {
        KardexI kardexDao = new KardexImpl();
        Kardex nKardex = null;
        ClienteI clientedorDao = new ClienteImp();
        Cliente nCliente = new Cliente();
        DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        try {
            nCliente = clientedorDao.obtener(cedula.getText());
        } catch (Exception e) {
        }
        Factura_VentaI factDao = new Factura_VentaImp();
        Factura_Venta nFactura = new Factura_Venta();
        ProductoI producDao = new ProductoImp();
        Producto productoTemp = new Producto();
        Detalle_VentaI ventaDao = new Detalle_VentaImp();
        KardexProductoI consultaKDao = new KardexProductoImpl();
        Detalle_Venta nVenta = null;
        try {
            nFactura.setCodFVenta(Integer.parseInt(tfCodFactura.getText()));
            try {
                nFactura.setFecha(formatoFecha.parse(tfFechaFact.getText()));
            } catch (Exception e) {
            }
            nFactura.setCliente(nCliente);
            if (factDao.ingresar(nFactura) > 0) {
                System.out.println("Factura Nueva Creada");
            } else {
                System.out.println("Error de creacion de factura");
            }
            for (int i = 0; i < listaCodigo.size(); i++) {
                productoTemp = producDao.obtener(listaCodigo.get(i));
                nVenta = new Detalle_Venta((cargarDetalleVenta() + 1 + i), productoTemp, nFactura, listaCantidad.get(i), listaPrecioT.get(i));
                if (ventaDao.ingresar(nVenta) > 0) {
                    System.out.println("Ingreso de Detalle V Correcto!");
                } else {
                    System.out.println("Ingreso de Detalle V Fallido!");
                }
                ArrayList<Kardex> kardexBuscado = new ArrayList<>();
                kardexBuscado = consultaKDao.listadoKardexProducto(productoTemp.getCodigoProducto());
                System.out.println("tamaño de kardex por producto: "+kardexBuscado.size());
                Kardex kardexTemp = null;
                if (!kardexBuscado.isEmpty()) {
                    Kardex ktemp = new Kardex();
                    ktemp = kardexBuscado.get(kardexBuscado.size() - 1);
                    System.out.println("Kardex final: " + ktemp.getCodKardex() + ktemp.getProducto().getNombre());
                    kardexTemp = new Kardex();
                    kardexTemp = ktemp;
                    nKardex = new Kardex((ktemp.getCodKardex() + 1), productoTemp, nFactura.getFecha(), tipoTransaccion, kardexTemp.getExistencias()+(listaCantidad.get(i) * (-1)), listaCantidad.get(i)*-1, (-1*listaPrecioT.get(i)));
                } else {
                    kardexTemp = new Kardex(1, productoTemp, nFactura.getFecha(), tipoTransaccion, 0, 0, totalA);
                }
                if (kardexDao.insertar(nKardex) > 0) {
                    System.out.println("Ingreso de Kardex Correcto!");
                } else {
                    System.out.println("Ingreso de Kardex Fallido!");
                }
            }
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("INFORMACION DEL SISTEMA");
            alerta.setHeaderText(null);
            alerta.setContentText("Venta Realizada con Exito!");
            alerta.showAndWait();
        } catch (Exception e) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("INFORMACION DEL SISTEMA");
            alerta.setHeaderText(null);
            alerta.setContentText("Error: " + e.getMessage());
            alerta.showAndWait();
        }
    }

    public void btnLimpiarEventHandler(ActionEvent event) {
        detaVenta = new VBox();
        generarFilaVenta();
        tfCodFactura.setText(String.valueOf(cargarFactura() + 1));
        tfFechaFact.setText("");
        vItems.getChildren().removeAll(items);
        vItems.getChildren().add(items);
        pntDesplazable = new ScrollPane();
        pntDesplazable.setMaxSize(718, 200);
        pntDesplazable.setMinSize(718, 200);
        pntDesplazable.setVmax(5000);
        pntDesplazable.setVmin(0);
        pntDesplazable.setContent(vItems);
        detaVenta.getChildren().addAll(pntItems, pntDesplazable);
        detaVenta.setAlignment(Pos.CENTER);
        detaVenta.setPadding(new Insets(10));
        PnlFinal.setCenter(detaVenta);
    }

    private int cargarKardex() {
        int numCateg = 0;
        listadoKardex = new ArrayList<>();
        KardexI kardexDao = new KardexImpl();
        try {
            listadoKardex = kardexDao.obtener();
            numCateg = listaFacturas.size();
        } catch (Exception e) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("INFORMACION DEL SISTEMA");
            alerta.setHeaderText(null);
            alerta.setContentText("Error: " + e.getMessage());
            alerta.showAndWait();
        }
        return numCateg;
    }

    public void cargarProducto() {
        listProducto = new ArrayList<>();
        ProductoI proDao = new ProductoImp();
        try {
            listProducto = proDao.obtener();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            Group ptnError = new Group();
            ptnError.getChildren().add(new Label("Error: " + e.getMessage()));
            Scene error = new Scene(ptnError, 0, 0);
        }
    }

    public void btnBuscarEventHandler(ActionEvent event) {
        ClienteI clienteDao = new ClienteImp();
        client = new Cliente();
        try {
            client = clienteDao.obtener(cedula.getText());
            nombres.setText(client.getNombre() + " " + client.getApellido());
            direccion.setText(client.getDireccion());
            telefono.setText(client.getTelefono());
            email.setText(client.getEmail());
        } catch (Exception e) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("INFORMACION DEL SISTEMA");
            alerta.setHeaderText(null);
            alerta.setContentText("No se encontro Registros: " + e.getMessage());
            alerta.showAndWait();
        }
    }
}
