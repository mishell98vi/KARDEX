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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.Event;
import javafx.event.EventDispatchChain;
import javafx.event.EventDispatcher;
import javafx.event.EventType;
import javafx.scene.Node;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import kardex.negocio.entidades.*;
import kardex.negocio.dao.*;
import kardex.negocio.impl.*;
import kardex.accesoadatos.*;

public class Form_KardexMensual {

    private Label lblProducto;
    private Label lblFechaI;
    private Label lblAnio;
    private Label lblMes;
    private Label lblFecha;
    private Label lblDetalle;
    private Label lblEntrada;
    private Label lblECantidad;
    private Label lblEValorUnitario;
    private Label lblEValorTotal;
    private Label lblSalida;
    private Label lblSCantidad;
    private Label lblSValorUnitario;
    private Label lblSValorTotal;
    private Label lblExistencia;
    private Label lblExCantidad;
    private Label lblExValorunitario;
    private Label lblExValorTotal;
    private ComboBox<Producto> cmbProducto;
    private ObservableList<Producto> itemsP = FXCollections.observableArrayList();
    private ArrayList<Producto> listaProducto;
    private ComboBox<String> cmbAnio;
    private ObservableList<String> itemsA = FXCollections.observableArrayList();
    private ArrayList<String> listaAnios;
    private ComboBox<String> cmbMes;
    private ObservableList<String> itemsM = FXCollections.observableArrayList();
    private ArrayList<String> listaMes;
    private Button btnCalcular;
    private TableView<Kardex> tblKardex;
    private TableColumn<Kardex, String> cmlFecha;
    private TableColumn<Kardex, String> cmlDetalle;
    private TableColumn<Kardex, Integer> cmlSCant;
    private TableColumn<Kardex, Double> cmlSVU;
    private TableColumn<Kardex, Double> cmlSVT;
    private TableColumn<Kardex, Integer> cmlECant;
    private TableColumn<Kardex, Double> cmlEVU;
    private TableColumn<Kardex, Double> cmlEVT;
    private TableColumn<Kardex, Integer> cmlExCant;
    private TableColumn<Kardex, Double> cmlExVU;
    private TableColumn<Kardex, Double> cmlExVT;
    private ArrayList<Kardex> listaKardexMensual;
    private VBox pntCabProd;
    private HBox pntFecha1;
    private HBox pntFecha2;
    private VBox pntCabFecha;
    private HBox pntCabecera;
    private HBox pntEPropiedades;
    private HBox pntSPropiedades;
    private HBox pntExPropiedades;
    private VBox pntEntrada;
    private VBox pntSalida;
    private VBox pntExistencia;
    private HBox pntCabKardex;
    private VBox pntKardex;
    private ScrollPane pntKardexInt;
    private VBox pntIntKardex;
    private BorderPane pntPrincipal;

    public Form_KardexMensual() {
        cargarProducto();
        itemsA.addAll("2016", "2017", "2018", "2019", "2020");
        itemsM.addAll("Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre");
        lblProducto = new Label("Producto: ");
        lblProducto.setFont(Font.font("News701 BT", 15));
        lblProducto.setAlignment(Pos.CENTER);
        lblFechaI = new Label("Fecha:");
        lblFechaI.setFont(Font.font("News701 BT", 15));
        lblFechaI.setAlignment(Pos.CENTER);
        lblAnio = new Label("Año");
        lblAnio.setFont(Font.font("News701 BT", 15));
        lblAnio.setAlignment(Pos.CENTER);
        lblAnio.setMaxSize(50, 50);
        lblAnio.setMinSize(50, 50);
        lblMes = new Label("Mes");
        lblMes.setFont(Font.font("News701 BT", 15));
        lblMes.setAlignment(Pos.CENTER);
        lblMes.setMaxSize(50, 50);
        lblMes.setMinSize(50, 50);
        cmbProducto = new ComboBox<Producto>(itemsP);
        cmbAnio = new ComboBox<>(itemsA);
        cmbMes = new ComboBox<>(itemsM);
        btnCalcular = new Button("Calcular kardex");
        pntCabProd = new VBox(5);
        pntCabProd.getChildren().addAll(lblProducto, cmbProducto, btnCalcular);
        pntCabProd.setAlignment(Pos.CENTER);
        pntFecha1 = new HBox(5);
        pntFecha1.getChildren().addAll(lblAnio, lblMes);
        pntFecha1.setAlignment(Pos.CENTER);
        pntFecha2 = new HBox(5);
        pntFecha2.getChildren().addAll(cmbAnio, cmbMes);
        pntFecha2.setAlignment(Pos.CENTER);
        pntCabFecha = new VBox(2);
        pntCabFecha.getChildren().addAll(lblFechaI, pntFecha1, pntFecha2);
        pntCabFecha.setAlignment(Pos.CENTER);
        pntCabecera = new HBox(10);
        pntCabecera.getChildren().addAll(pntCabProd, pntCabFecha);
        pntCabecera.setAlignment(Pos.CENTER);
        pntCabecera.setPadding(new Insets(10));
        ///////////////////////////////////////
        lblFecha = new Label("Fecha");
        lblFecha.setFont(Font.font("News701 BT", 15));
        lblFecha.setMaxSize(100, 55);
        lblFecha.setMinSize(100, 55);
        lblFecha.setAlignment(Pos.CENTER);
        lblFecha.setStyle("-fx-border-color: black; -fx-border-width: 2px");
        lblDetalle = new Label("Detalle");
        lblDetalle.setFont(Font.font("News701 BT", 15));
        lblDetalle.setMaxSize(250, 55);
        lblDetalle.setMinSize(250, 55);
        lblDetalle.setAlignment(Pos.CENTER);
        lblDetalle.setStyle("-fx-border-color: black; -fx-border-width: 2px");
        lblEntrada = new Label("Entrada");
        lblEntrada.setFont(Font.font("News701 BT", 15));
        lblEntrada.setAlignment(Pos.CENTER);
        lblECantidad = new Label("Cant");
        lblECantidad.setFont(Font.font("News701 BT", 15));
        lblECantidad.setAlignment(Pos.CENTER);
        lblECantidad.setStyle("-fx-border-color: black; -fx-border-width: 2px");
        lblEValorUnitario = new Label("V Unit");
        lblEValorUnitario.setFont(Font.font("News701 BT", 15));
        lblEValorUnitario.setAlignment(Pos.CENTER);
        lblEValorUnitario.setStyle("-fx-border-color: black; -fx-border-width: 2px");
        lblEValorTotal = new Label("V Tot");
        lblEValorTotal.setFont(Font.font("News701 BT", 15));
        lblEValorTotal.setAlignment(Pos.CENTER);
        lblEValorTotal.setStyle("-fx-border-color: black; -fx-border-width: 2px");
        lblSalida = new Label("Salida");
        lblSalida.setFont(Font.font("News701 BT", 15));
        lblSalida.setAlignment(Pos.CENTER);
        lblSCantidad = new Label("Cant");
        lblSCantidad.setFont(Font.font("News701 BT", 15));
        lblSCantidad.setAlignment(Pos.CENTER);
        lblSCantidad.setStyle("-fx-border-color: black; -fx-border-width: 2px");
        lblSValorUnitario = new Label("V Unit");
        lblSValorUnitario.setFont(Font.font("News701 BT", 15));
        lblSValorUnitario.setAlignment(Pos.CENTER);
        lblSValorUnitario.setStyle("-fx-border-color: black; -fx-border-width: 2px");
        lblSValorTotal = new Label("V Tot");
        lblSValorTotal.setFont(Font.font("News701 BT", 15));
        lblSValorTotal.setAlignment(Pos.CENTER);
        lblSValorTotal.setStyle("-fx-border-color: black; -fx-border-width: 2px");
        lblExistencia = new Label("Existencias");
        lblExistencia.setFont(Font.font("News701 BT", 15));
        lblExistencia.setAlignment(Pos.CENTER);
        lblExCantidad = new Label("Cant");
        lblExCantidad.setFont(Font.font("News701 BT", 15));
        lblExCantidad.setAlignment(Pos.CENTER);
        lblExCantidad.setStyle("-fx-border-color: black; -fx-border-width: 2px");
        lblExValorunitario = new Label("V Unit");
        lblExValorunitario.setFont(Font.font("News701 BT", 15));
        lblExValorunitario.setAlignment(Pos.CENTER);
        lblExValorunitario.setStyle("-fx-border-color: black; -fx-border-width: 2px");
        lblExValorTotal = new Label("V Tot");
        lblExValorTotal.setFont(Font.font("News701 BT", 15));
        lblExValorTotal.setAlignment(Pos.CENTER);
        lblExValorTotal.setStyle("-fx-border-color: black; -fx-border-width: 2px");
        pntEPropiedades = new HBox(2);
        pntEPropiedades.getChildren().addAll(lblECantidad, lblEValorUnitario, lblEValorTotal);
        pntEPropiedades.setAlignment(Pos.TOP_CENTER);
        pntSPropiedades = new HBox(2);
        pntSPropiedades.getChildren().addAll(lblSCantidad, lblSValorUnitario, lblSValorTotal);
        pntSPropiedades.setAlignment(Pos.TOP_CENTER);
        pntExPropiedades = new HBox(2);
        pntExPropiedades.getChildren().addAll(lblExCantidad, lblExValorunitario, lblExValorTotal);
        pntExPropiedades.setAlignment(Pos.TOP_CENTER);
        pntEntrada = new VBox(5);
        pntEntrada.getChildren().addAll(lblEntrada, pntEPropiedades);
        pntEntrada.setStyle("-fx-border-color: black; -fx-border-width: 2px");
        pntEntrada.setAlignment(Pos.TOP_CENTER);
        pntEntrada.setMaxSize(150, 55);
        pntEntrada.setMinSize(150, 55);
        pntSalida = new VBox(5);
        pntSalida.getChildren().addAll(lblSalida, pntSPropiedades);
        pntSalida.setStyle("-fx-border-color: black; -fx-border-width: 2px");
        pntSalida.setAlignment(Pos.TOP_CENTER);
        pntSalida.setMaxSize(150, 55);
        pntSalida.setMinSize(150, 55);
        pntExistencia = new VBox(5);
        pntExistencia.getChildren().addAll(lblExistencia, pntExPropiedades);
        pntExistencia.setStyle("-fx-border-color: black; -fx-border-width: 2px");
        pntExistencia.setAlignment(Pos.TOP_CENTER);
        pntExistencia.setMaxSize(150, 55);
        pntExistencia.setMinSize(150, 55);
        pntCabKardex = new HBox(5);
        pntCabKardex.getChildren().addAll(lblFecha, lblDetalle, pntSalida, pntEntrada, pntExistencia);
        pntCabKardex.setAlignment(Pos.TOP_CENTER);
        //////////////////////////
        tblKardex = new TableView();
        cmlFecha = new TableColumn<>("Fecha");
        cmlFecha.setMaxWidth(100);
        cmlFecha.setMinWidth(100);
        cmlDetalle = new TableColumn<>("Detalle");
        cmlDetalle.setMaxWidth(250);
        cmlDetalle.setMinWidth(250);
        cmlSCant = new TableColumn<>("S Cant");
        cmlSCant.setMaxWidth(50);
        cmlSCant.setMinWidth(50);
        cmlSVU = new TableColumn<>("S VU");
        cmlSVU.setMaxWidth(50);
        cmlSVU.setMinWidth(50);
        cmlSVT = new TableColumn<>("S VT");
        cmlSVT.setMaxWidth(50);
        cmlSVT.setMinWidth(50);
        cmlECant = new TableColumn<>("E Cant");
        cmlECant.setMaxWidth(50);
        cmlECant.setMinWidth(50);
        cmlEVU = new TableColumn<>("E VU");
        cmlEVU.setMaxWidth(50);
        cmlEVU.setMinWidth(50);
        cmlEVT = new TableColumn<>("E VT");
        cmlEVT.setMaxWidth(50);
        cmlEVT.setMinWidth(50);
        cmlExCant = new TableColumn<>("Ex Cant");
        cmlExCant.setMaxWidth(50);
        cmlExCant.setMinWidth(50);
        cmlExVU = new TableColumn<>("Ex VU");
        cmlExVU.setMaxWidth(50);
        cmlExVU.setMinWidth(50);
        cmlExVT = new TableColumn<>("Ex VT");
        cmlExVT.setMaxWidth(50);
        cmlExVT.setMinWidth(50);
        tblKardex.getColumns().addAll(cmlFecha, cmlDetalle, cmlSCant, cmlSVU, cmlSVT, cmlECant, cmlEVU, cmlEVT, cmlExCant, cmlExVU, cmlExVT);
        pntIntKardex = new VBox();
        pntIntKardex.getChildren().add(tblKardex);
///////////////////////////////
        pntKardexInt = new ScrollPane(pntIntKardex);
        pntKardexInt.setMaxSize(820, 200);
        pntKardexInt.setHmin(0);
        pntKardexInt.setHmax(0);
        pntKardex = new VBox();
        pntKardex.getChildren().addAll(pntCabKardex, pntKardexInt);
        pntKardex.setAlignment(Pos.CENTER);
        pntPrincipal = new BorderPane();
        pntPrincipal.setTop(pntCabecera);
        pntPrincipal.setCenter(pntKardex);
        pntPrincipal.setPadding(new Insets(5));
        Scene scene = new Scene(pntPrincipal, 950, 520);
        btnCalcular.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                bCalcularEventHandler(event);
            }
        });
    }

    public Node getPntPrincipal() {
        return pntPrincipal;
    }

    public void cargarProducto() {
        listaProducto = new ArrayList<>();
        ProductoI productoDao = new ProductoImp();
        try {
            listaProducto = productoDao.obtener();
            for (Producto producto : listaProducto) {
                itemsP.add(producto);
            }
        } catch (Exception e) {

        }
    }

    public void bCalcularEventHandler(ActionEvent event) {
        kardexMensualI kardexMDao = new Kardex_MensualImpl();
        ObservableList<String> listFechas = FXCollections.observableArrayList();
        ObservableList<String> listDetalle = FXCollections.observableArrayList();
        ObservableList<String> listEC = FXCollections.observableArrayList();
        ObservableList<String> listEPU = FXCollections.observableArrayList();
        ObservableList<String> listEPT = FXCollections.observableArrayList();
        ObservableList<String> listSC = FXCollections.observableArrayList();
        ObservableList<String> listSPU = FXCollections.observableArrayList();
        ObservableList<String> listSPT = FXCollections.observableArrayList();
        ObservableList<String> listEXC = FXCollections.observableArrayList();
        ObservableList<String> listEXPU = FXCollections.observableArrayList();
        ObservableList<String> listEXPT = FXCollections.observableArrayList();
        listaKardexMensual = new ArrayList<>();
        try {
            listaKardexMensual = kardexMDao.listadoKardexFecha(cmbProducto.getSelectionModel().getSelectedIndex() + 1, String.valueOf(cmbMes.getSelectionModel().getSelectedIndex() + 1), cmbAnio.getValue());
            for (Kardex k : listaKardexMensual) {
                System.out.println(k.getCodKardex() + "  " + k.getTipoTransaccion() + "  " + k.getProducto().getNombre());
                if (k.getTipoTransaccion().equals("C")) {
                    listFechas.add(String.valueOf(k.getFechaEmision()));
                    listDetalle.add("Compra (" + k.getProducto().getNombre() + ")");
                    listEC.add(String.valueOf(k.getCantEditable()));
                    listEPT.add(String.valueOf(k.getValorTotal()));
                    listEPU.add(String.valueOf(k.getValorTotal() / k.getCantEditable()));
                    listSC.add("");
                    listSPU.add("");
                    listSPT.add("");
                    listEXC.add(String.valueOf(k.getExistencias()));
                    listEXPT.add(String.valueOf(k.getValorTotal()));
                    listEXPU.add(String.valueOf(k.getValorTotal() / k.getExistencias()));
                } else {
                    listFechas.add(String.valueOf(k.getFechaEmision()));
                    listDetalle.add("Compra (" + k.getProducto().getNombre() + ")");
                    listSC.add(String.valueOf(k.getCantEditable()));
                    listSPT.add(String.valueOf(k.getValorTotal()));
                    listSPU.add(String.valueOf(k.getValorTotal() / k.getCantEditable()));
                    listEC.add("");
                    listEPU.add("");
                    listEPT.add("");
                    listEXC.add(String.valueOf(k.getExistencias()));
                    listEXPT.add(String.valueOf(k.getValorTotal()));
                    listEXPU.add(String.valueOf(k.getValorTotal() / k.getExistencias()));
                }
                cmlFecha.getStyleClass().addAll(listFechas);
                cmlFecha.setVisible(true);
                cmlDetalle.getStyleClass().addAll(listDetalle);
                cmlDetalle.setVisible(true);
                cmlECant.getStyleClass().addAll(listEC);
                cmlECant.setVisible(true);
                cmlEVU.getStyleClass().addAll(listEPU);
                cmlEVU.setVisible(true);
                cmlEVT.getStyleClass().addAll(listEPT);
                cmlEVT.setVisible(true);
                cmlSCant.getStyleClass().addAll(listSC);
                cmlSCant.setVisible(true);
                cmlSVU.getStyleClass().addAll(listSPU);
                cmlSVU.setVisible(true);
                cmlSVT.getStyleClass().addAll(listSPT);
                cmlSVT.setVisible(true);
                cmlExCant.getStyleClass().addAll(listEXC);
                cmlExCant.setVisible(true);
                cmlExVU.getStyleClass().addAll(listEXPU);
                cmlExVU.setVisible(true);
                cmlExVT.getStyleClass().addAll(listEXPT);
                cmlExVT.setVisible(true);
                tblKardex.getItems().addAll(listaKardexMensual);
                tblKardex.setVisible(true);
            }
        } catch (Exception e) {
        }
    }
}
