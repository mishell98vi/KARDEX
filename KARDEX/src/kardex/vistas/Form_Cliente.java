package kardex.vistas;
import com.sun.javafx.scene.control.skin.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javafx.application.Application;
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

public class Form_Cliente extends Application {

    private Label txtCedula;
    private Label txtFechaNacim;
    private Label txtNombres;
    private Label txtApellidos;
    private Label txtTelf;
    private Label txtDir;
    private Label txtEmail;

    private TextField cedula;
    private TextField fechanac;
    private TextField nombres;
    private TextField apellidos;
    private TextField telf; 
    private TextField dir;
    private TextField email;

    private Image iconCliente;
    private ImageView visorIcono;
    
    private Button bIngresar;
    private Button bModificar;
    private Button bEliminar;
    private Button bLimpiar;
    private Button bCancelar;

    private GridPane centroCliente;
    private HBox clImagen;
    private GridPane datRest;
    private HBox datsFinales;
    private HBox pnlbotones;
    private VBox pnlPrinc;

    @Override
    public void start(Stage primaryStage) {
        
       iconCliente=new Image("file:src\\kardex\\multimedia\\images\\iconocliente.png");
       visorIcono= new ImageView(iconCliente);
       visorIcono.setFitHeight(100);
       visorIcono.setFitWidth(100);
         //labels
        txtCedula = new Label("Cedula: ");
        txtCedula.setFont(Font.font("News701 BT", 20));
        txtFechaNacim = new Label("Fecha de Nacimiento: ");
        txtFechaNacim.setFont(Font.font("News701 BT", 20));
        txtNombres = new Label("Nombres: ");
        txtNombres.setFont(Font.font("News701 BT", 20));
        txtApellidos = new Label("Apellidos: ");
        txtApellidos.setFont(Font.font("News701 BT", 20));
        txtTelf = new Label("Telefono: ");
        txtTelf.setFont(Font.font("News701 BT", 20));
        txtDir = new Label("Direccion: ");
        txtDir.setFont(Font.font("News701 BT", 20));
        txtEmail = new Label("E-mail: ");
        txtEmail.setFont(Font.font("News701 BT", 20));
        //cajas de texto
        cedula = new TextField("");
        fechanac = new TextField("");
        nombres = new TextField("");
        apellidos = new TextField("");
        telf = new TextField("");
        dir = new TextField("");
        email = new TextField("");
        email.setMinWidth(350);
        email.setMaxWidth(350);
        //BOTONES
        bIngresar = new Button("Aceptar");
        bIngresar.setFont(Font.font("News701 BT", 15));
        bIngresar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                btnIngresarEventHandler(event);
            }
        });
        bLimpiar = new Button("Limpiar");
        bLimpiar.setFont(Font.font("News701 BT", 15));
        bLimpiar.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
               bLimpiarEventHandler(event);
           }
       });
        bCancelar = new Button("Cancelar");
        bCancelar.setFont(Font.font("News701 BT", 15));
        bCancelar.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
               bCancelarEventHandler(event);
           }
       });
        //PANELES
        //Cliente
        centroCliente=new GridPane();
        centroCliente.setVgap(10);
        centroCliente.setHgap(10);
        centroCliente.add(txtCedula, 0, 0);
        centroCliente.add(cedula, 1, 0);
        centroCliente.add(txtFechaNacim, 0, 1);
        centroCliente.add(fechanac, 1, 1);
        centroCliente.add(txtNombres, 0, 2);
        centroCliente.add(nombres, 1, 2);
        centroCliente.add(txtApellidos, 0, 3);
        centroCliente.add(apellidos, 1, 3);
        //CLIENTE E IMAGEN
        clImagen=new HBox(10);
        clImagen.getChildren().addAll(visorIcono, centroCliente);
        clImagen.setAlignment(Pos.CENTER);
        //RESTO CLIENTE
        datRest=new GridPane();
        datRest.add(txtTelf, 0, 0);
        datRest.add(telf, 1, 0);
        datRest.add(txtDir, 2, 0);
        datRest.add(dir, 3, 0);
        //FINAL CLIENTE
        datsFinales=new HBox(10);
        datsFinales.getChildren().addAll(txtEmail, email);
        datsFinales.setAlignment(Pos.CENTER);
        //BOTONES
        pnlbotones=new HBox(25);
        pnlbotones.getChildren().addAll(bIngresar, bLimpiar, bCancelar);
        pnlbotones.setAlignment(Pos.CENTER);
        //PANTALLA PRINCIPAL
        pnlPrinc = new VBox(10);
        pnlPrinc.getChildren().addAll(clImagen, datRest, datsFinales,pnlbotones);
        pnlPrinc.setAlignment(Pos.CENTER);
        pnlPrinc.setPadding(new Insets(15));

        Scene scene = new Scene(pnlPrinc, 545, 280);
        primaryStage.setTitle("Cliente");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    public void btnIngresarEventHandler(ActionEvent event){
        ClienteI clienteDao=new ClienteImp();
        try {
            Cliente nuevoCliente=new Cliente();
            nuevoCliente.setCedula(cedula.getText());
            nuevoCliente.setNombre(nombres.getText());
            nuevoCliente.setApellido(apellidos.getText());
            nuevoCliente.setDireccion(dir.getText());
            nuevoCliente.setTelefono(telf.getText());
            nuevoCliente.setEmail(email.getText());
            DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            try {
                nuevoCliente.setFechaNac(formatoFecha.parse(fechanac.getText()));
            } catch (Exception er) {
                System.out.println("Error al insertar fecha"+er.getMessage());
            }
            if(clienteDao.ingresar(nuevoCliente)>0){
                System.out.println("Ingreso Correcto");
            }
            else{
                System.out.println("Error de Ingreso");
            }
        } catch (Exception e) {
            System.out.println("Error de Ingreso"+e.getMessage());
        }
    }

    public void bCancelarEventHandler(ActionEvent event){
        System.exit(0);
    }
    public void bLimpiarEventHandler(ActionEvent event){
        cedula.setText("");
        nombres.setText("");
        apellidos.setText("");
        dir.setText("");
        telf.setText("");
        email.setText("");
    }
    
}
