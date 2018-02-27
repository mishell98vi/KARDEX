
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
public class Form_EliminarProducto {
    private TextField codProd;
    private Label nomProd;
    private Label precioProd;
    private Label prod;
    private Label txtCodprod;
    private Label txtNomProd;
    private Label txtPrecioProd;
    private Label txtCategoProd;
    private Label categDesc;
    private Label Descripcion;
    private Label cbxCategoria;
    private Producto nProd;
    private Categoria ncat;
    private Image icono;
    private ImageView visorIcono;
    private Button btnBuscar;
    private Button btnLimpiar;
    private Button btnEliminar;
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

    public Form_EliminarProducto() {
        icono = new Image("file:src\\kardex\\multimedia\\images\\iconoProducto.png");
        visorIcono = new ImageView(icono);
        visorIcono.setFitHeight(100);
        visorIcono.setFitWidth(100);
        prod = new Label("PRODUCTOS");
        prod.setFont(Font.font("News701 BT", 20));
        cbxCategoria = new Label("");
        cbxCategoria.setMaxSize(150, 25);
        cbxCategoria.setMinSize(150, 25);
        cbxCategoria.setStyle("-fx-border-color: black ; -fx-border-width: 2px");
        txtCategoProd = new Label("Categoria: ");
        txtCategoProd.setFont(Font.font("News701 BT", 20));
        pnlListCateg = new HBox(10);
        pnlListCateg.getChildren().addAll(txtCategoProd, cbxCategoria);
        pnlListCateg.setAlignment(Pos.CENTER);
        pnlVisualizar = new VBox(10);
        pnlVisualizar.getChildren().addAll(visorIcono, pnlListCateg);
        pnlVisualizar.setAlignment(Pos.CENTER);
        pnlVisualizar.setPadding(new Insets(5));
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
        Descripcion.setStyle("-fx-border-color: black ; -fx-border-width: 2px");
        codProd = new TextField("");
        codProd.setMaxSize(150, 25);
        codProd.setMinSize(150, 25);
        nomProd = new Label("");
        nomProd.setMaxSize(150, 25);
        nomProd.setMinSize(150, 25);
        nomProd.setStyle("-fx-border-color: black ; -fx-border-width: 2px");
        precioProd = new Label("");
        precioProd.setMaxSize(150, 25);
        precioProd.setMinSize(150, 25);
        precioProd.setStyle("-fx-border-color: black ; -fx-border-width: 2px");
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
        btnBuscar = new Button("Buscar");
        btnBuscar.setFont(Font.font("News701 BT", 15));
        btnBuscar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                bBuscarEventHandler(event);
            }
        });
        pnlprodCateg = new HBox(10);
        pnlprodCateg.getChildren().addAll(pnlDetProducto,btnBuscar, pnlVisualizar);
        pnlprodCateg.setAlignment(Pos.CENTER);
        pnlDescCateg = new VBox(10);
        pnlDescCateg.getChildren().addAll(categDesc, Descripcion);
        pnlDescCateg.setAlignment(Pos.CENTER);
        
        btnLimpiar = new Button("Limpiar");
        btnLimpiar.setFont(Font.font("News701 BT", 15));
        btnLimpiar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                bLimpiarEventHandler(event);
            }
        });
        btnEliminar = new Button("Eliminar");
        btnEliminar.setFont(Font.font("News701 BT", 15));
        btnEliminar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                bEliminarEventHandler(event);
            }
        });
        pnlBotones = new HBox(25);
        pnlBotones.getChildren().addAll(btnLimpiar, btnEliminar);
        pnlBotones.setAlignment(Pos.CENTER);
        pnlBotones.setPadding(new Insets(10));
        pnlFinal = new VBox(5);
        Image fondoFinal = new Image("file:src\\kardex\\multimedia\\images\\fondo.jpg");
        BackgroundImage fondo = new BackgroundImage(fondoFinal, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        pnlFinal.setBackground(new Background(fondo));
        pnlFinal.setStyle("-fx-padding: 10; -fx-border-color: black ; -fx-border-width: 2px");
        pnlFinal.getChildren().addAll(pnlprodCateg, pnlDescCateg, pnlBotones);
    }


    public void bBuscarEventHandler(ActionEvent event) {
        ProductoI prodDao = new ProductoImp();
        nProd = new Producto();
        ncat = new Categoria();
        CategoriaI catDao = new CategoriaImp();
        try {
            nProd=prodDao.obtener(Integer.parseInt(codProd.getText()));
            ncat=catDao.obtener(nProd.getCategoria().getCodigoCategoria());
            nomProd.setText(nProd.getNombre());
            precioProd.setText(String.valueOf(nProd.getPrecio()));
            cbxCategoria.setText(ncat.getNombre());
            Descripcion.setText(ncat.getDescripcion());
            System.out.println("Producto: "+nProd.getCodigoProducto()+"  "+nProd.getCategoria().getNombre()+"  "+nProd.getNombre()+"  "+nProd.getPrecio()+"  ");
        } catch (Exception e) {
        }
    }

    public void bLimpiarEventHandler(ActionEvent event) {
        codProd.setText("");
        nomProd.setText("");
        precioProd.setText("");
        cbxCategoria.setText("");
        Descripcion.setText("");
    }

    public void bEliminarEventHandler(ActionEvent event) {
        ProductoI productoDao=new ProductoImp();
        try {
            if(productoDao.eliminar(nProd)>0){
                System.out.println("Eliminado Correctamente!");
            }
            else
            {
                System.out.println("Error de eliminacion de producto");
            }
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
    }

    public void mostrarDescripcionEventHandler(Event event) {
        ncat = new Categoria();
        Descripcion.setText(ncat.getDescripcion());
    }

    public VBox getPnlFinal() {
        return pnlFinal;
    }
}
