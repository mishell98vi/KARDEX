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
public class Form_EditarCliente {
private Label txtCedula;
    private Label txtFechaNacim;
    private Label txtNombres;
    private Label txtApellidos;
    private Label txtTelf;
    private Label txtDir;
    private Label txtEmail;
private Cliente clienteB;
    private TextField cedula;
    
    private TextField fechanac;
    private TextField nombres;
    private TextField apellidos;
    private TextField telf;
    private TextField dir;
    private TextField email;

    private Image iconCliente;
    private ImageView visorIcono;

    private Button bBuscar;
    private Button bModificar;
    private Button bLimpiar;

    private GridPane centroCliente;
    private HBox clImagen;
    private HBox datRest;
    private HBox datsFinales;
    private HBox pnlbotones;
    private VBox pnlFinal;

    public Form_EditarCliente() {

        iconCliente = new Image("file:src\\kardex\\multimedia\\images\\iconocliente.png");
        visorIcono = new ImageView(iconCliente);
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
 //BOTONES
        bModificar = new Button("Aceptar");
        bModificar.setFont(Font.font("News701 BT", 15));
        bModificar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                btnEditarEventHandler(event);
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
        bBuscar = new Button("Buscar");
        bBuscar.setFont(Font.font("News701 BT", 15));
        //PANELES
        //Cliente
        centroCliente = new GridPane();
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
        clImagen = new HBox(10);
        clImagen.getChildren().addAll(visorIcono, centroCliente);
        clImagen.setAlignment(Pos.CENTER);
        //RESTO CLIENTE
        datRest = new HBox();
        datRest.getChildren().addAll(txtTelf, telf, txtDir, dir);
        datRest.setAlignment(Pos.CENTER);
        //FINAL CLIENTE
        datsFinales = new HBox(10);
        datsFinales.getChildren().addAll(txtEmail, email);
        datsFinales.setAlignment(Pos.CENTER);
        //BOTONES
        pnlbotones = new HBox(25);
        pnlbotones.getChildren().addAll(bBuscar, bModificar, bLimpiar);
        pnlbotones.setAlignment(Pos.CENTER);
        //PANTALLA PRINCIPAL
        pnlFinal = new VBox(10);
        Image fondoFinal = new Image("file:src\\kardex\\multimedia\\images\\fondo.jpg");
        BackgroundImage fondo = new BackgroundImage(fondoFinal, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        pnlFinal.setBackground(new Background(fondo));
        pnlFinal.setStyle("-fx-padding: 10; -fx-border-color: orange ; -fx-border-width: 2px");
        pnlFinal.getChildren().addAll(clImagen, datRest, datsFinales, pnlbotones);
        pnlFinal.setAlignment(Pos.CENTER);
        pnlFinal.setPadding(new Insets(15));
        bBuscar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                buscarClienteEventHandler(event);
            }
        });
    }

    public VBox getPnlFinal() {
        return pnlFinal;
    }

    public void btnEditarEventHandler(ActionEvent event) {
        ClienteI clienteDao = new ClienteImp();
        try {
            DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            clienteB.setNombre(nombres.getText());
            clienteB.setApellido(apellidos.getText());
            clienteB.setTelefono(telf.getText());
            clienteB.setDireccion(dir.getText());
            clienteB.setEmail(email.getText());
            try {
                clienteB.setFechaNac(formatoFecha.parse(fechanac.getText()));
            } catch (Exception er) {
                System.out.println("Error al insertar fecha" + er.getMessage());
            }
            if (clienteDao.modificar(clienteB) > 0) {
                System.out.println("Se modificio correctamente el Cliente");
            }
            else{
                System.out.println("Error de modificacion de Cliente");
            }
        } catch (Exception e) {
            System.out.println("Error de Ingreso" + e.getMessage());
        }
    }

    public void bCancelarEventHandler(ActionEvent event) {
        System.exit(0);
    }

    public void bLimpiarEventHandler(ActionEvent event) {
        cedula.setText("");
        nombres.setText("");
        apellidos.setText("");
        dir.setText("");
        telf.setText("");
        email.setText("");
        fechanac.setText("");
    }

    public void buscarClienteEventHandler(ActionEvent event){
        ClienteI clienteDao=new ClienteImp();
         clienteB=null;
        try {
            clienteB=clienteDao.obtener(cedula.getText());
            fechanac.setText(String.valueOf(clienteB.getFechaNac()));
            nombres.setText(String.valueOf(clienteB.getNombre()));
            apellidos.setText(String.valueOf(clienteB.getApellido()));
            dir.setText(String.valueOf(clienteB.getDireccion()));
            telf.setText(String.valueOf(clienteB.getTelefono()));
            email.setText(String.valueOf(clienteB.getEmail()));
        } catch (Exception e) {
            
        }
    }
    
}


