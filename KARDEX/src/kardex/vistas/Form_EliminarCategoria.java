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

public class Form_EliminarCategoria {
    
    
    private Label titulo;
    private Label txtCodigo;
    private Label txtNombre;
    private Label txtDescripcion;
    private TextField codigo;
    private TextField nombre;
    private TextField descripcion;
    private Image icono;
    private ImageView visor;
    private Button btnEliminar;
    private Button btnLimpiar;
    private Button btnBuscar;
    private VBox pnlICat1;
    private VBox pnlICat2;
    private HBox pnlcat;
    private VBox pnlICat;
    private HBox pnlSup;
    private VBox pnlInt;
    private HBox pnlBotones;
    private VBox pnlFinal;

    
  
    private Categoria categ;        
    public Form_EliminarCategoria() {
        //superior
        titulo = new Label("\" Categorias \"");
        titulo.setFont(Font.font("News701 BT", 30));
        txtCodigo = new Label("Codigo: ");
        txtCodigo.setFont(Font.font("News701 BT", 20));
        txtNombre = new Label("Nombre: ");
        txtNombre.setFont(Font.font("News701 BT", 20));
        pnlICat1 = new VBox(10);
        pnlICat1.getChildren().addAll(txtCodigo, txtNombre);
        pnlICat1.setAlignment(Pos.CENTER_RIGHT);
        pnlICat1.setPadding(new Insets(10));
        codigo = new TextField("");
        nombre = new TextField("");
        pnlICat2 = new VBox(10);
        pnlICat2.getChildren().addAll(codigo, nombre);
        pnlICat2.setAlignment(Pos.CENTER);
        pnlICat2.setPadding(new Insets(10));
        pnlcat = new HBox(10);
        pnlcat.getChildren().addAll(pnlICat1, pnlICat2);
        pnlcat.setPadding(new Insets(10));
        pnlICat = new VBox(10);
        pnlICat.getChildren().addAll(titulo, pnlcat);
        pnlICat.setAlignment(Pos.CENTER);
        pnlSup = new HBox(10);
        icono = new Image("file:src\\kardex\\multimedia\\images\\iconoCategoria.png");
        visor = new ImageView(icono);
        visor.setFitHeight(75);
        visor.setFitWidth(75);
        pnlSup.getChildren().addAll(pnlICat, visor);
        pnlSup.setAlignment(Pos.CENTER);
        txtDescripcion = new Label("Descripcion: ");
        txtDescripcion.setFont(Font.font("News701 BT", 25));
        descripcion = new TextField("");
        descripcion.setMaxSize(350, 100);
        descripcion.setMinSize(350, 100);
        pnlInt = new VBox(10);
        pnlInt.getChildren().addAll(txtDescripcion, descripcion);
        pnlInt.setAlignment(Pos.CENTER);
        
           
        btnEliminar = new Button("Eliminar");
        btnEliminar.setFont(Font.font("News701 BT", 20));
        btnEliminar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                bEliminarEventHandler(event);
            }
        });
        
        
        btnBuscar = new Button("Buscar");
        btnBuscar.setFont(Font.font("News701 BT", 20));
        btnBuscar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                bBuscarEventHandler(event);
            }
        });
        
        btnLimpiar = new Button("Limpiar");
        btnLimpiar.setFont(Font.font("News701 BT", 20));
        btnLimpiar.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
               bLimpiarEventHandler(event);
           }
       });
        
        pnlBotones = new HBox(25);
        pnlBotones.getChildren().addAll(btnEliminar,btnBuscar, btnLimpiar);
        pnlBotones.setAlignment(Pos.CENTER);
        pnlFinal = new VBox(10);
        Image fondoFinal=new Image("file:src\\kardex\\multimedia\\images\\FONDOO.jpg");
        BackgroundImage fondo=new BackgroundImage(fondoFinal, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        pnlFinal.setBackground(new Background(fondo));
        pnlFinal.setStyle("-fx-padding: 10; -fx-border-color: orange ; -fx-border-width: 2px");
        pnlFinal.getChildren().addAll(pnlSup, pnlInt, pnlBotones);
        pnlFinal.setPadding(new Insets(10));
    }

    public void bEliminarEventHandler(ActionEvent event) {
        CategoriaI categDao = new CategoriaImp();
       
        try {
            Alert confirmacion= new Alert(Alert.AlertType.CONFIRMATION);
            confirmacion.setTitle("Informacion del sistema");
            confirmacion.setHeaderText(null);
            confirmacion.setContentText("Desea eliminar esta Categoria");
            confirmacion.showAndWait();
            
            if (confirmacion.getResult()== ButtonType.OK ) {
                if(categDao.eliminar(categ)> 0) {
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
    
    public void bBuscarEventHandler(ActionEvent event){
        CategoriaI categDao = new CategoriaImp();
        categ = new Categoria();
        try{
            categ=categDao.obtener(Integer.parseInt(codigo.getText()));
            nombre.setText(categ.getNombre());
            descripcion.setText(categ.getDescripcion());
        } catch(Exception e){
            Alert alerta= new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Informacion del sistema");
            alerta.setHeaderText(null);
            alerta.setContentText("No se encontro registros: "+ e.getMessage());
            alerta.showAndWait();
        }
    }
    public void bLimpiarEventHandler(ActionEvent event){
        codigo.setText("");
        nombre.setText("");
        descripcion.setText("");
        
    }
    
    
 

    public VBox getPnlFinal() {
        return pnlFinal;
    }


}
