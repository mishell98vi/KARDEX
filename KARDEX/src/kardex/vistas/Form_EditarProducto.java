
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
import javafx.stage.*;
import javafx.scene.image.*;
import kardex.negocio.dao.*;
import kardex.negocio.entidades.*;
import kardex.negocio.impl.*;
import kardex.accesoadatos.*;
public class Form_EditarProducto {
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
    private Producto nProd;
    //combobox
    private ComboBox<Categoria> cbxCategoria;
    private ObservableList<Categoria> items = FXCollections.observableArrayList();
    private ArrayList<Categoria> listadoCategorias;
    //multimedia
    private Image icono;
    private ImageView visorIcono;
    //botones
    private Button btnBuscar;
    private Button btnLimpiar;
    private Button btnModificar;
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
    private VBox pnlFinal;

    public Form_EditarProducto() {
        //imagen y listado de categorias
        icono = new Image("file:src\\kardex\\multimedia\\images\\iconoProducto.png");
        visorIcono = new ImageView(icono);
        visorIcono.setFitHeight(100);
        visorIcono.setFitWidth(100);
        prod = new Label("PRODUCTOS");
        prod.setFont(Font.font("News701 BT", 20));
        cargarCategorias();
        cbxCategoria = new ComboBox<>();
        cbxCategoria.setItems(items);
        cbxCategoria.setValue(items.get(0));
        cbxCategoria.setOnHiding(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                mostrarDescripcionEventHandler(event);
            }
        });
        txtCategoProd = new Label("Categoria: ");
        txtCategoProd.setFont(Font.font("News701 BT", 20));
        pnlListCateg = new HBox(10);
        pnlListCateg.getChildren().addAll(txtCategoProd, cbxCategoria);
        pnlListCateg.setAlignment(Pos.CENTER);
        pnlVisualizar = new VBox(10);
        pnlVisualizar.getChildren().addAll(visorIcono, pnlListCateg);
        pnlVisualizar.setAlignment(Pos.CENTER);
        pnlVisualizar.setPadding(new Insets(5));
        //producto
        //labels
        txtCodprod = new Label("Codigo: ");
        txtCodprod.setFont(Font.font("News701 BT", 20));
        txtNomProd = new Label("Nombre: ");
        txtNomProd.setFont(Font.font("News701 BT", 20));
        txtPrecioProd = new Label("Precio: ");
        txtPrecioProd.setFont(Font.font("News701 BT", 20));
        categDesc = new Label("Descripcion de Categoria: ");
        categDesc.setFont(Font.font("News701 BT", 15));
        Descripcion = new Label("");
        Descripcion.setMaxSize(400, 100);
        Descripcion.setMinSize(400, 100);
        //items
        codProd = new TextField("");
        nomProd = new TextField("");
        precioProd = new TextField("");
        //panel producto
        pnlNombresProducto = new VBox(10);
        pnlNombresProducto.getChildren().addAll(txtCodprod, txtNomProd, txtPrecioProd);
        pnlNombresProducto.setAlignment(Pos.CENTER_LEFT);
        pnlNombresProducto.setPadding(new Insets(5));
        pnlItemsProducto = new VBox(10);
        pnlItemsProducto.getChildren().addAll(codProd, nomProd, precioProd);
        pnlItemsProducto.setAlignment(Pos.CENTER);
        pnlItemsProducto.setPadding(new Insets(5));
        pnlProducto = new HBox(10);
        pnlProducto.getChildren().addAll(pnlNombresProducto, pnlItemsProducto);
        pnlProducto.setPadding(new Insets(5));
        pnlDetProducto = new VBox(10);
        pnlDetProducto.getChildren().addAll(prod, pnlProducto);
        pnlDetProducto.setPadding(new Insets(5));
        pnlDetProducto.setAlignment(Pos.CENTER);
        pnlprodCateg = new HBox(10);
        pnlprodCateg.getChildren().addAll(pnlDetProducto, pnlVisualizar);
        //descripcion categoria
        pnlDescCateg = new VBox(10);
        pnlDescCateg.getChildren().addAll(categDesc, Descripcion);
        pnlDescCateg.setAlignment(Pos.CENTER);
        //Botones
        btnBuscar = new Button("Buscar");
        btnBuscar.setFont(Font.font("News701 BT", 15));
        btnBuscar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                bBuscarEventHandler(event);
            }
        });
        btnLimpiar = new Button("Limpiar");
        btnLimpiar.setFont(Font.font("News701 BT", 15));
        btnLimpiar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                bLimpiarEventHandler(event);
            }
        });
        btnModificar = new Button("Modificar");
        btnModificar.setFont(Font.font("News701 BT", 15));
        btnModificar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                bModificarEventHandler(event);
            }
        });
        pnlBotones = new HBox(25);
        pnlBotones.getChildren().addAll(btnBuscar,btnModificar, btnLimpiar);
        pnlBotones.setAlignment(Pos.CENTER);
        pnlBotones.setPadding(new Insets(10));
        //Panel Principal
        pnlFinal = new VBox(5);
        Image fondoFinal = new Image("file:src\\kardex\\multimedia\\images\\fondo.jpg");
        BackgroundImage fondo = new BackgroundImage(fondoFinal, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        pnlFinal.setBackground(new Background(fondo));
        pnlFinal.setStyle("-fx-padding: 10; -fx-border-color: black ; -fx-border-width: 2px");
        pnlFinal.getChildren().addAll(pnlprodCateg, pnlDescCateg, pnlBotones);
    }
    
    

    public void cargarCategorias() {
        listadoCategorias = new ArrayList<>();
        CategoriaI categDao = new CategoriaImp();
        try {
            listadoCategorias = categDao.obtener();
            for (Categoria categ : listadoCategorias) {
                items.add(categ);
            }
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(this, "ERROR AL CARGAR CURSOS", "ERROR" + e.getMessage(), JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public void bBuscarEventHandler(ActionEvent event){
        ProductoI prodDao=new ProductoImp();
        Categoria nCat=new Categoria();
        CategoriaI categDao=new CategoriaImp();
        try {
            nProd=prodDao.obtener(Integer.parseInt(codProd.getText()));
            nomProd.setText(nProd.getNombre());
            precioProd.setText(String.valueOf(nProd.getPrecio()));
            nCat=categDao.obtener(nProd.getCategoria().getCodigoCategoria());
            Descripcion.setText(nCat.getDescripcion());
            Descripcion.setWrapText(true);
        } catch (Exception e) {
        }
    }
            
    public void bLimpiarEventHandler(ActionEvent event){
        codProd.setText("");
        nomProd.setText("");
        precioProd.setText("");
    }
    
    
    public void mostrarDescripcionEventHandler(Event event){
        Categoria ncat=new Categoria();
        ncat=cbxCategoria.getValue();
        Descripcion.setText(ncat.getDescripcion());
    }

    public void bModificarEventHandler(ActionEvent event){
        ProductoI prodDao=new ProductoImp();
        Categoria ncat=new Categoria();
        CategoriaI catDao=new CategoriaImp();
        try {
            ncat=cbxCategoria.getValue();
            nProd.setNombre(nomProd.getText());
            nProd.setPrecio(Double.parseDouble(precioProd.getText()));
            nProd.setCategoria(ncat);
            if(prodDao.modificar(nProd)>0){
                System.out.println("Modificacion Correcta");
            }
            else{
                System.out.println("Modificacion Fallida");
            }
        } catch (Exception e) {
        }
    }
    
    public VBox getPnlFinal() {
        return pnlFinal;
    }
}
