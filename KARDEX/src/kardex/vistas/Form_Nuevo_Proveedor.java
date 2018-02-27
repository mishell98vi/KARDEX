
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

public class Form_Nuevo_Proveedor{
    private Label txtRuc;
    private Label txtNombres;
    private Label txtDireccion;
    private Label txtTelefono;
    private Label txtEmail;
    private TextField Ruc;
    private TextField Nombres;
    private TextField Direccion;
    private TextField Telefono;
    private TextField Email;
    private Button btnIngresar;
    private Button btnLimpiar;
    private Button btnCancelar;
    private VBox pnlIcono;
    private Image iconProveedor;
    private ImageView visorIcono;
    private Label pProveedor;
    private VBox pnlTxtField;
    private VBox pnlObProv;
    private HBox pnlProveedor;
    private HBox pnlBotones;
    private VBox pnlFinal;
    public Form_Nuevo_Proveedor() {
        //Icono
        iconProveedor = new Image("file:src\\kardex\\multimedia\\images\\iconoProveedor.jpg");
        visorIcono = new ImageView(iconProveedor);
        visorIcono.setFitWidth(200);
        visorIcono.setFitHeight(150);
        pnlIcono = new VBox(5);
        pProveedor = new Label("\" Proveedor \"");
        pProveedor.setFont(Font.font("News701 BT", 20));
        pnlIcono.getChildren().addAll(visorIcono, pProveedor);
        pnlIcono.setAlignment(Pos.CENTER);
        pnlIcono.setPadding(new Insets(5));
        //Detalles Proveedor
        txtRuc = new Label("Ruc: ");
        txtRuc.setFont(Font.font("News701 BT", 20));
        Ruc = new TextField("");
        txtNombres = new Label("Nombres: ");
        txtNombres.setFont(Font.font("News701 BT", 20));
        Nombres = new TextField("");
        txtDireccion = new Label("Direccion: ");
        txtDireccion.setFont(Font.font("News701 BT", 20));
        Direccion = new TextField("");
        txtTelefono = new Label("Telefono: ");
        txtTelefono.setFont(Font.font("News701 BT", 20));
        Telefono = new TextField("");
        txtEmail = new Label("Email: ");
        txtEmail.setFont(Font.font("News701 BT", 20));
        Email = new TextField("");
        pnlTxtField = new VBox(10);
        pnlObProv = new VBox(10);
        pnlTxtField.getChildren().addAll(txtRuc,txtNombres,txtDireccion,txtTelefono,txtEmail);
        pnlObProv.getChildren().addAll(Ruc,Nombres,Direccion,Telefono,Email);
        pnlTxtField.setAlignment(Pos.CENTER_RIGHT);
        pnlTxtField.setPadding(new Insets(5));
        pnlObProv.setAlignment(Pos.CENTER);
        pnlObProv.setPadding(new Insets(5));
        //panel Proveedor
        pnlProveedor=new HBox(10);
        pnlProveedor.getChildren().addAll(pnlIcono,pnlTxtField,pnlObProv);
        pnlProveedor.setAlignment(Pos.CENTER);
        pnlProveedor.setPadding(new Insets(5));
        //Botones
        btnIngresar=new Button("Ingresar");
        btnIngresar.setFont(Font.font("News701 BT", 15));
        btnIngresar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                bIngEventHandler(event);
            }
        });
        btnLimpiar=new Button("Limpiar");
        btnLimpiar.setFont(Font.font("News701 BT", 15));
        btnLimpiar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                bLimpiarEventHandler(event);
            }
        });
        btnCancelar=new Button("Cancelar");
        btnCancelar.setFont(Font.font("News701 BT", 15));
        btnCancelar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                bCancelarEventHandler(event);
            }
        });
        pnlBotones=new HBox(20);
        pnlBotones.getChildren().addAll(btnIngresar,btnLimpiar,btnCancelar);
        pnlBotones.setAlignment(Pos.CENTER);
        pnlBotones.setPadding(new Insets(10));
        //Panel Principal
        pnlFinal=new VBox(5);
        Image fondoFinal = new Image("file:src\\kardex\\multimedia\\images\\fondo.jpg");
        BackgroundImage fondo = new BackgroundImage(fondoFinal, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        pnlFinal.setBackground(new Background(fondo));
        pnlFinal.setStyle("-fx-padding: 10; -fx-border-color: black ; -fx-border-width: 2px");
        pnlFinal.getChildren().addAll(pnlProveedor,pnlBotones);
        pnlFinal.setPadding(new Insets(10));
    }
    
    
    
    public void bIngEventHandler(ActionEvent event){
        ProveedorI provDao=new ProveedorImp();
        try {
            Proveedor nuevoProveedor=new Proveedor();
            nuevoProveedor.setRuc(Ruc.getText());
            nuevoProveedor.setNombre(Nombres.getText());
            nuevoProveedor.setDireccion(Direccion.getText());
            nuevoProveedor.setTelefono(Telefono.getText());
            nuevoProveedor.setEmail(Email.getText());
            if(provDao.ingresar(nuevoProveedor)>0){
                System.out.println("Ingreso Correcto");
            }
            else{
                System.out.println("Error de Ingreso");
            }
        } catch (Exception e) {
            System.out.println("Error de Ingreso"+e.getMessage());
        }
    }
   public void bLimpiarEventHandler(ActionEvent event){
        Ruc.setText("");
        Nombres.setText("");
        Direccion.setText("");
        Telefono.setText("");
        Email.setText("");
        
    }
    public void bCancelarEventHandler(ActionEvent event){
        System.exit(0);
    }
    public VBox getPnlFinal() {
        return pnlFinal;
    }
}
