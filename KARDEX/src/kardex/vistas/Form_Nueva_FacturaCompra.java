
package kardex.vistas;

import com.sun.javafx.scene.control.skin.LabeledText;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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

public class Form_Nueva_FacturaCompra extends Application {

    private Text txtCodigo;
    private Text txtFecha;
    private TextArea codigo;
    private TextArea fecha;
    private Button logo;
    
    
    private Text txtCliente;
    private Text txtCedula;
    private Text txtNombre;
    private Text txtApellido;
    private Text txtDireccion;
    private Text txtTelefono;
    
    private TextArea cedula;
    private TextArea nombre;
     private TextArea apellido;
    private TextArea direccion;
    private TextArea telefono;
    
    private GridPane panelFventa;
    private GridPane panelCliente;
    private HBox panelCedula;
    private VBox panelInfoCliente;
    private VBox panelLogoFactura;
    private HBox panelClienteFactura;
    private VBox pntPrincipal;
    
    @Override
    public void start(Stage primaryStage) {

        //labels
        txtCodigo = new Text("Codigo: ");
        txtFecha = new Text("Fecha de emision: ");
        logo= new Button("LOGO EMPRESARIAL");
        logo.setFont(Font.font("Arial Black",25));
        txtCliente = new Text("Cliente");
        txtCedula = new Text("Cedula: ");
        txtNombre = new Text("Nombre: ");
        txtApellido = new Text("Apellido: ");
        txtDireccion = new Text("Direccion: ");
        txtTelefono = new Text("Telefono: ");
        
        
         //cajas de texto
        codigo = new TextArea("");
        fecha = new TextArea("");
        
        cedula = new TextArea("");
        nombre = new TextArea("");
        apellido = new TextArea("");
        direccion = new TextArea("");
        telefono = new TextArea("");
        
        panelFventa = new GridPane();
        panelFventa.add(txtCodigo, 0, 0);
        panelFventa.add(txtFecha, 0, 1);
        panelFventa.add(codigo, 1, 0);
        panelFventa.add(fecha, 1, 1);
        
       
        panelCliente = new GridPane();
        panelCliente.add(txtNombre, 0, 0);
        panelCliente.add(txtApellido, 2, 0);
        panelCliente.add(txtDireccion, 0, 1);
        panelCliente.add(txtTelefono, 2, 1);
        panelCliente.add(nombre, 1, 0);
        panelCliente.add(apellido, 3, 0);
        panelCliente.add(direccion, 1, 1);
        panelCliente.add(telefono, 3, 1);
        
        panelCedula = new HBox(4);
        panelCedula.getChildren().addAll(txtCedula, cedula);
        
        panelInfoCliente= new VBox(8);
        panelInfoCliente.getChildren().addAll(txtCliente, panelCedula, panelCliente);
        
        panelLogoFactura= new VBox(12);
        panelLogoFactura.getChildren().addAll(logo, panelFventa);
        
        panelClienteFactura= new HBox(20);
        panelClienteFactura.getChildren().addAll(panelInfoCliente,panelLogoFactura);
//        panelClienteFactura.add(panelInfoCliente, 0, 0);
//        panelClienteFactura.add(panelLogoFactura, 1, 0);
        

        pntPrincipal=new VBox(20);
        pntPrincipal.getChildren().addAll(panelClienteFactura,new Button("detalles"),new Button("opciones"),new Button("botones"));
        Scene scene = new Scene(pntPrincipal, 320*2, 480);

        primaryStage.setTitle("Factura Venta");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
}
