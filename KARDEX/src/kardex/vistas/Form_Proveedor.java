/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kardex.vistas;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.util.*;
import javafx.scene.text.*;
import javafx.scene.paint.*;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.MessageFormat;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import kardex.negocio.dao.*;
import kardex.negocio.entidades.*;
import kardex.negocio.impl.*;

public class Form_Proveedor extends Application {
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
    private HBox pntPrincipal;
    private VBox pnlIcono;
    private Image iconProveedor;
    private ImageView visorIcono;
    private Label pProveedor;
    private VBox pnlTxtField;
    private VBox pnlObProv;
    private HBox pnlProveedor;
    private HBox pnlBotones;
    private VBox panelPrincipal;
    @Override
    public void start(Stage primaryStage) {
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
        btnCancelar=new Button("Cancelar");
        btnCancelar.setFont(Font.font("News701 BT", 15));
        pnlBotones=new HBox(20);
        pnlBotones.getChildren().addAll(btnIngresar,btnLimpiar,btnCancelar);
        pnlBotones.setAlignment(Pos.CENTER);
        pnlBotones.setPadding(new Insets(10));
        //Panel Principal
        panelPrincipal=new VBox();
        panelPrincipal.getChildren().addAll(pnlProveedor,pnlBotones);
        panelPrincipal.setPadding(new Insets(10));
        
        Scene scene = new Scene(panelPrincipal, 540, 270);

        primaryStage.setTitle("Proveedor");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
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
}
