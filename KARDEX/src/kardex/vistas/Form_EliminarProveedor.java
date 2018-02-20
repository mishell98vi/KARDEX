/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

public class Form_EliminarProveedor {

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
    private Button btnEliminar;
    private Button btnBuscar;
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
    private Proveedor prov;

    public Form_EliminarProveedor() {
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
        pnlTxtField.getChildren().addAll(txtRuc, txtNombres, txtDireccion, txtTelefono, txtEmail);
        pnlObProv.getChildren().addAll(Ruc, Nombres, Direccion, Telefono, Email);
        pnlTxtField.setAlignment(Pos.CENTER_RIGHT);
        pnlTxtField.setPadding(new Insets(5));
        pnlObProv.setAlignment(Pos.CENTER);
        pnlObProv.setPadding(new Insets(5));
        //panel Proveedor
        pnlProveedor = new HBox(10);
        pnlProveedor.getChildren().addAll(pnlIcono, pnlTxtField, pnlObProv);
        pnlProveedor.setAlignment(Pos.CENTER);
        pnlProveedor.setPadding(new Insets(5));
        //Botones
        btnEliminar = new Button("Eliminar");
        btnEliminar.setFont(Font.font("News701 BT", 15));
        btnEliminar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                btnElminarEventHandler(event);
            }
        });

        btnBuscar = new Button("Buscar");
        btnBuscar.setFont(Font.font("News701 BT", 20));
        btnBuscar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                bLimpiarEventHandler(event);
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
        btnBuscar = new Button("Buscar");
        btnBuscar.setFont(Font.font("News701 BT", 15));
        btnBuscar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                bBuscarEventHandler(event);
            }
        });
        pnlBotones = new HBox(20);
        pnlBotones.getChildren().addAll(btnEliminar, btnBuscar, btnLimpiar, btnCancelar);
        pnlBotones.setAlignment(Pos.CENTER);
        pnlBotones.setPadding(new Insets(10));
        //Panel Principal
        pnlFinal = new VBox(5);
        Image fondoFinal = new Image("file:src\\kardex\\multimedia\\images\\fondo.jpg");
        BackgroundImage fondo = new BackgroundImage(fondoFinal, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        pnlFinal.setBackground(new Background(fondo));
        pnlFinal.setStyle("-fx-padding: 10; -fx-border-color: orange ; -fx-border-width: 2px");
        pnlFinal.getChildren().addAll(pnlProveedor, pnlBotones);
        pnlFinal.setPadding(new Insets(10));
    }

    public void btnElminarEventHandler(ActionEvent event) {
        ProveedorI provDao = new ProveedorImp();
        try {
            Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
            confirmacion.setTitle("Informacion del sistema");
            confirmacion.setHeaderText(null);
            confirmacion.setContentText("Desea eliminar esta Categoria");
            confirmacion.showAndWait();

            if (confirmacion.getResult() == ButtonType.OK) {
                if (provDao.eliminar(prov) > 0) {
                    confirmacion.setTitle("Informacion del sistema");
                    confirmacion.setHeaderText(null);
                    confirmacion.setContentText("Se ha elimiando correctamente");
                    confirmacion.showAndWait();

                }
            } else {
                confirmacion.setTitle("Informacion del sistema");
                confirmacion.setHeaderText(null);
                confirmacion.setContentText("No se puede eliminar");
                confirmacion.showAndWait();
            }
        } catch (Exception e) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Informacion del sistema");
            alerta.setHeaderText(null);
            alerta.setContentText("No se puede eliminar");
            alerta.showAndWait();
        }

    }

    public void bLimpiarEventHandler(ActionEvent event) {
        Ruc.setText("");
        Nombres.setText("");
        Direccion.setText("");
        Telefono.setText("");
        Email.setText("");

    }

    public void bBuscarEventHandler(ActionEvent event) {
        ProveedorI provDao = new ProveedorImp();
        prov = new Proveedor();
        try {
            prov = provDao.obtener(Ruc.getText());
            Nombres.setText(prov.getNombre());
            Direccion.setText(prov.getDireccion());
            Telefono.setText(prov.getTelefono());
            Email.setText(prov.getEmail());
        } catch (Exception e) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Informacion del sistema");
            alerta.setHeaderText(null);
            alerta.setContentText("No se encontro registros: " + e.getMessage());
            alerta.showAndWait();
        }
    }

    public VBox getPnlFinal() {
        return pnlFinal;
    }
}
