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
public class Form_Proveedor extends  Application {
    private Text txtRuc;
    private Text txtNombres;
    private Text txtDireccion;
    private Text txtTelefono;
    
    private Text txtEmail;
    
    private TextArea Ruc;
    private TextArea Nombres;
    private TextArea Direccion;
    private TextArea Telefono;
    private TextArea Email;
     
    private Button btnAceptar;
    private Button btnLimpiar;
    private Button btnCancelar;
    private Button btnModificar;
    private Button btnEliminar;
    
    private GridPane panelProveedor;
    private HBox panelBotones;
    private VBox panelPrincipal;
            
    
    @Override
    public void start(Stage primaryStage) {
        
        txtRuc = new Text("Ruc: ");
        txtRuc.setFont(javafx.scene.text.Font.font("Arial",20));
        Ruc =new TextArea(""); 
        txtNombres = new Text("Nombres: ");
        txtNombres.setFont(javafx.scene.text.Font.font("Arial",20));
        Nombres=new TextArea("");
        txtDireccion = new Text("Direccion: ");
        txtDireccion.setFont(javafx.scene.text.Font.font("Arial",20));
        Direccion=new TextArea("");
        txtTelefono = new Text("Telefono: ");
        txtTelefono.setFont(javafx.scene.text.Font.font("Arial",20));
        Telefono=new TextArea("");
        txtEmail = new Text("Email: ");
        
        txtEmail.setFont(javafx.scene.text.Font.font("Arial",20));
        Email=new TextArea("");
        
        btnAceptar=new Button("Aceptar");
        btnAceptar.setFont(javafx.scene.text.Font.font("Times New Roman",15));
        btnLimpiar=new Button("Limpiar");
        btnLimpiar.setFont(javafx.scene.text.Font.font("Times New Roman",15));
        btnCancelar=new Button("Cancelar");
        btnCancelar.setFont(javafx.scene.text.Font.font("Times New Roman",15));
        
        btnModificar=new Button("Modificar");
        btnModificar.setFont(javafx.scene.text.Font.font("Times New Roman",15));
        btnEliminar=new Button("Eliminar");
        btnEliminar.setFont(javafx.scene.text.Font.font("Times New Roman",15));

        panelProveedor = new GridPane();
        panelProveedor.add(txtRuc, 0, 0);
        panelProveedor.add(Ruc,1,0);
        
        panelProveedor.add(txtNombres, 0, 1);
        panelProveedor.add(Nombres,1,1);
        panelProveedor.add(txtDireccion, 0, 2);
        panelProveedor.add(Direccion,1,2);
        panelProveedor.add(txtTelefono, 0, 3);
        panelProveedor.add(Telefono,1,3);
        panelProveedor.add(txtEmail, 0, 4);
        panelProveedor.add(Email,1,4);
        
        
        panelBotones =new HBox(20);
        panelBotones.getChildren().add(btnAceptar);
        panelBotones.getChildren().add(btnLimpiar);
        panelBotones.getChildren().add(btnCancelar);
        panelBotones.setAlignment(Pos.CENTER);
    
        panelPrincipal=new VBox();
        panelPrincipal.getChildren().add(panelProveedor);
        panelPrincipal.getChildren().add(panelBotones);
        
        
        Scene scene = new Scene(panelPrincipal, 300, 250);
        
        primaryStage.setTitle("Proveedor");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
