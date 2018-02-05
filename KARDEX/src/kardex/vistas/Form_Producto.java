
package kardex.vistas;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.util.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.scene.paint.*;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.MessageFormat;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import kardex.negocio.dao.CategoriaI;
import kardex.negocio.entidades.Categoria;
import kardex.negocio.impl.CategoriaImp;

public class Form_Producto  extends Application {
    //Objetos
    private TextField codProd;
    private TextField nomProd;
    private TextField precioProd;
    //Labels
    private Label prod;
    private Label txtCodprod;
    private Label txtNomProd;
    private Label txtPrecioProd;
    private Label txtCategoProd;
    private Label categDesc;
    private Label Descripcion;
    //combobox
    private ComboBox<Categoria> cbxCategoria;
    private ObservableList<Categoria> items = FXCollections.observableArrayList();
    private ArrayList<Categoria> listadoCategorias;
    //multimedia
    private Image icono;
    private ImageView visorIcono;
    //botones
    private Button btnIngresar;
    private Button btnLimpiar;
    private Button btnCancelar;
    //paneles
    private VBox pnlVisualizar;
    private HBox pnlListCateg;
    private VBox pnlItemsProducto;
    private VBox pnlNombresProducto;
    private HBox pnlProducto;
    private VBox pnlDetProducto;
    private HBox pnlprodCateg;
    private VBox pnlDescCateg;
    private HBox pnlBotones;
    private VBox pntPrincipal;

    @Override
    public void start(Stage primaryStage) {
        //imagen y listado de categorias
        icono=new Image("file:src\\kardex\\multimedia\\images\\iconoProducto.png");
        visorIcono=new ImageView(icono);
        visorIcono.setFitHeight(100);
        visorIcono.setFitWidth(100);
        prod=new Label("PRODUCTOS");
        prod.setFont(Font.font("News701 BT", 20));
        cargarCategorias();
        cbxCategoria=new ComboBox<Categoria>(items);
        cbxCategoria.setValue(items.get(0));
        cbxCategoria.setVisible(true);
        txtCategoProd=new Label("Categoria: ");
        txtCategoProd.setFont(Font.font("News701 BT", 20));
        pnlListCateg=new HBox(10);
        pnlListCateg.getChildren().addAll(txtCategoProd,cbxCategoria);
        pnlListCateg.setAlignment(Pos.CENTER);
        pnlVisualizar=new VBox(10);
        pnlVisualizar.getChildren().addAll(visorIcono,pnlListCateg);
        pnlVisualizar.setAlignment(Pos.CENTER);
        pnlVisualizar.setPadding(new Insets(5));
        //producto
            //labels
        txtCodprod=new Label("Codigo: ");
        txtCodprod.setFont(Font.font("News701 BT", 20));
        txtNomProd=new Label("Nombre: ");
        txtNomProd.setFont(Font.font("News701 BT", 20));
        txtPrecioProd=new Label("Precio: ");
        txtPrecioProd.setFont(Font.font("News701 BT", 20));
        categDesc=new Label("Descripcion de Categoria; ");
        categDesc.setFont(Font.font("News701 BT", 15));
        Descripcion=new Label("");
        Descripcion.setMaxSize(400, 100);
        Descripcion.setMinSize(400, 100);
            //items
        codProd=new TextField("");
        nomProd=new TextField("");
        precioProd=new TextField("");
            //panel producto
        pnlNombresProducto=new VBox(10);
        pnlNombresProducto.getChildren().addAll(txtCodprod,txtNomProd,txtPrecioProd);
        pnlNombresProducto.setAlignment(Pos.CENTER_LEFT);
        pnlNombresProducto.setPadding(new Insets(5));
        pnlItemsProducto=new VBox(10);
        pnlItemsProducto.getChildren().addAll(codProd,nomProd,precioProd);
        pnlItemsProducto.setAlignment(Pos.CENTER);
        pnlItemsProducto.setPadding(new Insets(5));
        pnlProducto=new HBox(10);
        pnlProducto.getChildren().addAll(pnlNombresProducto,pnlItemsProducto);
        pnlProducto.setPadding(new Insets(5));
        pnlDetProducto=new VBox(10);
        pnlDetProducto.getChildren().addAll(prod, pnlProducto);
        pnlDetProducto.setPadding(new Insets(5));
        pnlDetProducto.setAlignment(Pos.CENTER);
        pnlprodCateg=new HBox(10);
        pnlprodCateg.getChildren().addAll(pnlDetProducto,pnlVisualizar);
        //descripcion categoria
        pnlDescCateg=new VBox(10);
        pnlDescCateg.getChildren().addAll(categDesc,Descripcion);
        pnlDescCateg.setAlignment(Pos.CENTER);
        //Botones
        btnIngresar=new Button("Ingresar");
        btnIngresar.setFont(Font.font("News701 BT", 15));
        btnLimpiar=new Button("Limpiar");
        btnLimpiar.setFont(Font.font("News701 BT", 15));
        btnCancelar=new Button("Cancelar");
        btnCancelar.setFont(Font.font("News701 BT", 15));
        pnlBotones=new HBox(25);
        pnlBotones.getChildren().addAll(btnIngresar,btnLimpiar,btnCancelar);
        pnlBotones.setAlignment(Pos.CENTER);
        pnlBotones.setPadding(new Insets(10));
        //Panel Principal
        pntPrincipal=new VBox(5);
        pntPrincipal.getChildren().addAll(pnlprodCateg,pnlDescCateg,pnlBotones);
        Scene scene = new Scene(pntPrincipal, 500, 360);
        primaryStage.setTitle("Producto");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void cargarCategorias() {
        listadoCategorias = new ArrayList<>();
        CategoriaI categDao = new CategoriaImp();
        try {
            listadoCategorias=categDao.obtener();
            for(Categoria categ:listadoCategorias){
                items.add(categ);
            }
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(this, "ERROR AL CARGAR CURSOS", "ERROR" + e.getMessage(), JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
}
